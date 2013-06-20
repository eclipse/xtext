/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.resource.LinkingAssumptions;
import org.eclipse.xtext.xbase.resource.LinkingAssumptions.Tracker;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public abstract class AbstractTypeProvider implements ITypeProvider {

	private static final Logger logger = Logger.getLogger(AbstractTypeProvider.class);
	
	@Inject 
	private XbaseTypeConformanceComputer typeConformanceComputer;
	
	@Inject 
	private TypeReferences typeReferences;
	
	@Inject
	private XbaseTypeArgumentContextProvider typeArgumentContextProvider;
	
	@Inject
	private ILogicalContainerProvider logicalContainerProvider;
	
	@Inject
	private LinkingAssumptions linkingAssumptions;
	
	/*
	 * Don't use #typeReferenceAwareCache since it makes assumptions on the
	 * cache key and expected return type
	 */
	@Inject
	private IResourceScopeCache resourceScopeCache;
	
	{
		checkIsSingelton();
	}
	
	protected void checkIsSingelton() {
		Singleton singleton = getClass().getAnnotation(Singleton.class);
		if (singleton==null) {
			throw new IllegalStateException("The class "+getClass().getSimpleName()+" must be annotated with @Singleton annotation.");
		}
	}
	
	// this class is final because of the assumptions that are made in
	// equals and hashcode
	protected static final class ImmutableLinkedItem<T> {
		
		protected final T object;
		protected final ImmutableLinkedItem<T> prev;
		protected final int hashCode;
		protected final int size;
		
		public ImmutableLinkedItem(T object, ImmutableLinkedItem<T> immutableStack) {
			this.object = object;
			prev = immutableStack;
			size = immutableStack == null ? 1 : immutableStack.size + 1;
			if (prev != null) {
				hashCode = 31 * size * prev.hashCode() + object.hashCode();
			} else {
				hashCode = object.hashCode();
			}
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (obj == this)
				return true;
			if (obj.hashCode() != hashCode() || obj.getClass() != ImmutableLinkedItem.class)
				return false;
			ImmutableLinkedItem<?> other = (ImmutableLinkedItem<?>) obj;
			return other.object.equals(object) && other.size == size && (other.prev == prev || prev != null && prev.equals(other.prev));
		}
		
		@Override
		public int hashCode() {
			return hashCode;
		}

	}
	
	private OnChangeEvictingCache typeReferenceAwareCache = new OnChangeEvictingCache() {
		
		@Override
		public <T> T get(Object key, Resource resource, Provider<T> provider) {
			if(resource == null || resource instanceof TypeResource) {
				return provider.get();
			}
			CacheAdapter adapter = getOrCreate(resource);
			T element = adapter.<T>get(key);
			// we could have unloaded cached values that were contained in another resource
			// thus #resource was never notified about the change
			boolean validEntry = element != null;
			if (validEntry && element instanceof EObject) {
				validEntry = !((EObject) element).eIsProxy();
			}
			if (!validEntry) {
				cacheMiss(adapter);
				Tracker tracker = linkingAssumptions.trackAssumptions(resource);
				element = provider.get();
				tracker.stopTracking();
				@SuppressWarnings("unchecked")
				Triple<CyclicHandlingSupport<T>, ImmutableLinkedItem<T>, Boolean> castedKey = (Triple<CyclicHandlingSupport<T>, ImmutableLinkedItem<T>, Boolean>) key;
				CyclicHandlingSupport<T> cyclicHandlingSupport = castedKey.getFirst();
				ImmutableLinkedItem<T> linkedItem = castedKey.getSecond();
				boolean rawType = castedKey.getThird();
				if (!tracker.isIndependentOfAssumptions() || !(linkedItem.object instanceof EObject) ||
						!isResolved((JvmTypeReference) element, getNearestTypeParameterDeclarator(cyclicHandlingSupport.getPrimaryEObject(linkedItem.object)), rawType)) {
					if (logger.isDebugEnabled()) {
						logger.debug(getDebugIndentation(rawType) + "cache skip: " + element);
					}
					return element;
				}
				if (logger.isDebugEnabled()) {
					logger.debug(getDebugIndentation(rawType) + "cache: " + element);
				}
				adapter.set(key, element);
			} else {
				cacheHit(adapter);
			}
			return element;
		}
		
	};
	
	// TODO improve / extract to a utility method if other clients are doing similar things
	protected boolean isResolved(JvmTypeReference reference, JvmTypeParameterDeclarator declarator, boolean rawType) {
		return isResolved(reference, declarator, rawType, true, Sets.<JvmTypeReference>newHashSet());
	}
	
	protected boolean isResolved(JvmTypeReference reference, JvmTypeParameterDeclarator declarator, boolean rawType, boolean allowAnyType, Set<JvmTypeReference> visited) {
		if (reference == null || reference instanceof JvmParameterizedTypeReference && reference.getType() == null || !visited.add(reference))
			return false;
		if (reference instanceof JvmCompoundTypeReference) {
			for(JvmTypeReference component: ((JvmCompoundTypeReference) reference).getReferences()) {
				if (!isResolved(component, declarator, rawType, allowAnyType, visited))
					return false;
			}
			return true;
		}
		if (reference.getType() instanceof JvmTypeParameter) {
			if (isDeclaratorOf(declarator, (JvmTypeParameter) reference.getType()))
				return true;
			for(JvmTypeConstraint constraint: ((JvmTypeParameter) reference.getType()).getConstraints()) {
				if (!isResolved(constraint.getTypeReference(), declarator, rawType, false, visited))
					return false;
			}
			return false;
		}
		if (reference instanceof JvmParameterizedTypeReference) {
			if (rawType)
				return true;
			JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) reference;
			JvmType type = parameterized.getType();
			if (type instanceof JvmTypeParameterDeclarator) {
				if (parameterized.getArguments().size() != ((JvmTypeParameterDeclarator) type).getTypeParameters().size()) {
					return false;
				}
			}
			for(JvmTypeReference argument: parameterized.getArguments()) {
				if (!isResolved(argument, declarator, rawType, false, visited))
					return false;
			}
		}
		if (reference instanceof JvmWildcardTypeReference) {
			for(JvmTypeConstraint constraint: ((JvmWildcardTypeReference) reference).getConstraints()) {
				if (!isResolved(constraint.getTypeReference(), declarator, rawType, false, visited))
					return false;
				if (constraint instanceof JvmLowerBound) {
					if (typeReferences.is(constraint.getTypeReference(), Object.class))
						return false;
				}
			}
		}
		if (reference instanceof JvmDelegateTypeReference) {
			return isResolved(((JvmDelegateTypeReference) reference).getDelegate(), declarator, rawType, allowAnyType, visited);
		}
		if (reference instanceof JvmSpecializedTypeReference) {
			return isResolved(((JvmSpecializedTypeReference) reference).getEquivalent(), declarator, rawType, allowAnyType, visited);
		}
		if (reference instanceof JvmAnyTypeReference) {
			return allowAnyType;
		}
		if (reference instanceof JvmGenericArrayTypeReference) {
			return isResolved(((JvmGenericArrayTypeReference) reference).getComponentType(), declarator, rawType, allowAnyType, visited);
		}
		return true;
	}
	
	protected JvmTypeParameterDeclarator getNearestTypeParameterDeclarator(EObject obj) {
		if (obj == null)
			return null;
		if (obj instanceof JvmTypeParameterDeclarator) {
			return (JvmTypeParameterDeclarator) obj;
		}
		return getNearestTypeParameterDeclarator(getLogicalOrRealContainer(obj));
	}
	
	protected EObject getLogicalOrRealContainer(EObject obj) {
		if (obj.eResource() != null) {
			JvmIdentifiableElement container = logicalContainerProvider.getLogicalContainer(obj);
			if (container != null)
				return container;
		}
		return obj.eContainer();
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T getLogicalOrRealContainer(EObject obj, Class<T> type) {
		EObject container = getLogicalOrRealContainer(obj);
		while (container != null && !type.isInstance(container)) {
			container = getLogicalOrRealContainer(container);
		}
		return (T) container;
	}
	
	protected boolean isDeclaratorOf(JvmTypeParameterDeclarator declarator, JvmTypeParameter param) {
		return param.getDeclarator() == declarator;
	}
	
	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(XExpression expression, JvmTypeReference rawExpectation, boolean rawType) {
		throw new IllegalArgumentException("Type computation is not implemented for " + expression);
	}

	protected CyclicHandlingSupport<Pair<XExpression, JvmTypeReference>> getType = new CyclicHandlingSupport<Pair<XExpression, JvmTypeReference>>() {

		@Override
		protected JvmTypeReference doComputation(Pair<XExpression, JvmTypeReference> t, boolean rawType) {
			return type(t.getFirst(), t.getSecond(), rawType);
		}
		
		@Override
		protected EObject getPrimaryEObject(Pair<XExpression, JvmTypeReference> pair) {
			return pair.getFirst();
		}
		
		@Override
		protected JvmTypeReference doHandleCyclicCall(Pair<XExpression, JvmTypeReference> t, boolean rawType) {
			return handleCyclicGetType(t.getFirst(), t.getSecond(), rawType);
		}
	};
	
	protected JvmIdentifiableElement getFeature(XAbstractFeatureCall expr, boolean resolve) {
		return linkingAssumptions.getFeature(expr, resolve);
	}
	
	protected JvmIdentifiableElement getFeature(XAbstractFeatureCall expr) {
		return getFeature(expr, true);
	}
	
	protected JvmConstructor getConstructor(XConstructorCall expr, boolean resolve) {
		return linkingAssumptions.getConstructor(expr, resolve);
	}
	
	protected JvmConstructor getConstructor(XConstructorCall expr) {
		return getConstructor(expr, true);
	}
	
	protected JvmTypeReference type(XExpression expression, JvmTypeReference rawExpectation, boolean rawType) {
		return _type(expression, rawExpectation, rawType);
	}

	protected String getDebugIndentation(boolean rawType) {
		int size = getType.getOngoingComputationsSize(rawType) + getExpectedType.getOngoingComputationsSize(rawType) + getTypeForIdentifiable.getOngoingComputationsSize(rawType);
		char[] chars = new char[size];
		Arrays.fill(chars, ' ');
		return String.valueOf(chars);
	}
	
	protected <T> JvmTypeReference doGetType(String key, T object, boolean rawType, CyclicHandlingSupport<T> typeComputer) {
		String debugIndentation = null;
		if (logger.isDebugEnabled()) {
			debugIndentation = getDebugIndentation(rawType);
			if (debugIndentation.length() == 0) {
				StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
				for(StackTraceElement element: stackTrace) {
					if (!element.isNativeMethod() && !AbstractTypeProvider.class.getName().equals(element.getClassName())) {
						logger.debug(debugIndentation + key + "(" + (rawType ? "raw" : "parameterized") + ") : " + element);
						break;
					}
				}
			}
			logger.debug(debugIndentation + key + ": " + object);
		}
		JvmTypeReference result = typeComputer.getType(object, rawType);
		if (logger.isDebugEnabled()) {
			logger.debug(debugIndentation + "result: " + result + " " + key + "(" + (rawType ? "raw" : "parameterized") + ") : " + object);
		}
		return result;
	}
	
	public JvmTypeReference getType(final XExpression expression) {
		return getType(expression, null, false);
	}
	
	public JvmTypeReference getType(final XExpression expression, boolean rawType) {
		return getType(expression, null, rawType);
	}
	
	public JvmTypeReference getType(final XExpression expression, JvmTypeReference rawExpectation, boolean rawType) {
		return doGetType("getType", Tuples.create(expression, rawExpectation), rawType, getType);
	}

	/**
	 * Allows to handle cyclic type resolution.
	 * @param expression the expression that was asked reentrant for its type.
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference handleCyclicGetType(final XExpression expression, JvmTypeReference rawExpectation, boolean rawType) {
		return null;
	}

	/**
	 * @param container the container that owns the expression that may have a type expectation. 
	 * @param reference the reference that can be used to obtain the expression with a type expectation.
	 * @param index the index if {@code reference} is a {@link EStructuralFeature#isMany() multi value} feature.
	 * @param rawType <code>true</code> if we are only interested in the type parameter.
	 */
	protected JvmTypeReference _expectedType(EObject container, EReference reference, int index, boolean rawType) {
		return null;
	}

	protected CyclicHandlingSupport<XExpression> getExpectedType = new CyclicHandlingSupport<XExpression>() {

		@Override
		protected JvmTypeReference doComputation(XExpression t, boolean rawType) {
			Triple<EObject, EReference, Integer> triple = getContainingInfo(t);
			if (triple == null)
				return null;
			return expectedType(triple.getFirst(), triple.getSecond(), triple.getThird(), rawType);
		}

		@Override
		protected JvmTypeReference doHandleCyclicCall(XExpression t, boolean rawType) {
			return handleCycleGetExpectedType(t, rawType);
		}

		@Override
		protected EObject getPrimaryEObject(XExpression expression) {
			return expression;
		}
	};
	
	protected JvmTypeReference expectedType(EObject container, EReference reference, int index, boolean rawType) {
		return _expectedType(container, reference, index, rawType);
	}
	
	public JvmTypeReference getExpectedType(final XExpression expression) {
		return getExpectedType(expression, false);
	}
	
	public JvmTypeReference getExpectedType(final XExpression expression, boolean rawType) {
		return doGetType("getExpectedType", expression, rawType, getExpectedType);
	}

	/**
	 * Allows to handle cyclic resolution of expected types.
	 * @param expression the expression that was asked reentrant for its expected type.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference handleCycleGetExpectedType(XExpression expression, boolean rawType) {
		return null;
	}

	protected Triple<EObject, EReference, Integer> getContainingInfo(XExpression obj) {
		if (obj == null)
			return null;
		if (obj.eIsProxy())
			return null;
		EReference containmentReference = obj.eContainmentFeature();
		if (containmentReference == null)
			return null;
		EObject container = obj.eContainer();
		int index = (containmentReference.isMany()) ? ((List<?>) container.eGet(containmentReference)).indexOf(obj)
				: -1;
		Triple<EObject, EReference, Integer> triple = Tuples.create(container, containmentReference, index);
		return triple;
	}

	/**
	 * @param rawType <code>true</code> if we are only interested in the type parameter.
	 */
	protected JvmTypeReference _typeForIdentifiable(JvmIdentifiableElement identifiable, boolean rawType) {
		throw new IllegalArgumentException("Type computation is not implemented for " + identifiable);
	}

	protected CyclicHandlingSupport<JvmIdentifiableElement> getTypeForIdentifiable = new CyclicHandlingSupport<JvmIdentifiableElement>() {
		@Override
		protected JvmTypeReference doComputation(JvmIdentifiableElement t, boolean rawType) {
			return typeForIdentifiable(t, rawType);
		}

		@Override
		protected JvmTypeReference doHandleCyclicCall(JvmIdentifiableElement t, boolean rawType) {
			return handleCycleGetTypeForIdentifiable(t, rawType);
		}

		@Override
		protected EObject getPrimaryEObject(JvmIdentifiableElement identifiable) {
			return identifiable;
		}
	};

	protected JvmTypeReference typeForIdentifiable(JvmIdentifiableElement identifiable, boolean rawType) {
		return _typeForIdentifiable(identifiable, rawType);
	}
	
	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement) {
		return getTypeForIdentifiable(identifiableElement, false);
	}
	
	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement, boolean rawType) {
		return doGetType("getTypeForIdentifiable", identifiableElement, rawType, getTypeForIdentifiable);
	}

	/**
	 * Allows to handle cyclic resolution of types.
	 * @param identifiableElement the element that was asked reentrant for its type.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference handleCycleGetTypeForIdentifiable(JvmIdentifiableElement identifiableElement, boolean rawType) {
		return null;
	}
	
	public static class EarlyExitAcceptor {
		protected List<JvmTypeReference> returns = newArrayListWithCapacity(2);
		protected List<JvmTypeReference> thrown = newArrayListWithCapacity(2);
		
		public List<JvmTypeReference> getReturns() {
			return returns;
		}
		
		public List<JvmTypeReference> getThrown() {
			return thrown;
		}

		public void appendThrown(Iterable<JvmTypeReference> exceptions) {
			Iterables.addAll(thrown, exceptions);
		}
	}
	
	private PolymorphicDispatcher<Void> earlyExits = PolymorphicDispatcher.createForSingleTarget("_earlyExits", 2, 2, this);
	
	public JvmTypeReference getCommonReturnType(XExpression expression, boolean assumeImplicitReturnExpression) {
		// TODO use JvmUnknownTypeReference instead of adding plain Void.TYPE
		EarlyExitAcceptor acceptor = new EarlyExitAcceptor();
		internalCollectEarlyExits(expression, acceptor);
		final List<JvmTypeReference> returns = acceptor.returns;
		if (assumeImplicitReturnExpression) {
			JvmTypeReference implicitReturnType = getType(expression);
			if (implicitReturnType != null && !typeReferences.is(implicitReturnType, Void.TYPE))
				acceptor.returns.add(implicitReturnType);
		}
		if (returns.isEmpty()) {
			if (expression != null)
				return typeReferences.getTypeForName(Void.TYPE, expression);
			return null;
		}
		JvmTypeReference superType = typeConformanceComputer.getCommonSuperType(returns);
		return superType;
	}
	
	public Iterable<JvmTypeReference> getThrownExceptionTypes(XExpression expression) {
		EarlyExitAcceptor acceptor = new EarlyExitAcceptor();
		internalCollectEarlyExits(expression, acceptor);
		Map<JvmType, JvmTypeReference> result = newHashMap();
		for (JvmTypeReference thrownType : acceptor.thrown) {
			result.put(thrownType.getType(), thrownType);
		}
		return result.values();
	}
	
	protected void internalCollectEarlyExits(final EObject expr, EarlyExitAcceptor acceptor) {
		if (expr == null || expr.eResource() == null)
			return;
		EarlyExitAcceptor child = resourceScopeCache.get(Tuples.create("internalCollectEarlyExits", expr),
				expr.eResource(), new Provider<EarlyExitAcceptor>() {
					public EarlyExitAcceptor get() {
						EarlyExitAcceptor result = new EarlyExitAcceptor();
						earlyExits.invoke(expr, result);
						return result;
					}
				});
		acceptor.returns.addAll(child.returns);
		acceptor.thrown.addAll(child.thrown);
	}
	
	/**
	 * Computes early exits of {@code null}.
	 * @param expr always {@code null}. 
	 * @param a the collector of the early exit result.
	 */
	protected void _earlyExits(Void expr, EarlyExitAcceptor a) {
	}
	
	/**
	 * Computes early exits of type references.
	 * @param ref the type reference. 
	 * @param a the collector of the early exit result.
	 */
	protected void _earlyExits(JvmTypeReference ref, EarlyExitAcceptor a) {
	}
	
	protected void _earlyExits(EObject expr, EarlyExitAcceptor acceptor) {
		EList<EObject> list = expr.eContents();
		for (EObject eObject : list) {
			internalCollectEarlyExits(eObject, acceptor);
		}
	}
	
	protected XbaseTypeConformanceComputer getTypeConformanceComputer() {
		return typeConformanceComputer;
	}
	
	protected TypeReferences getTypeReferences() {
		return typeReferences;
	}
	
	protected TypeArgumentContextProvider getTypeArgumentContextProvider() {
		return typeArgumentContextProvider;
	}
	
	protected ILogicalContainerProvider getLogicalContainerProvider() {
		return logicalContainerProvider;
	}

	abstract class CyclicHandlingSupport<T> {

		protected class ComputationData {
			protected final Set<T> computations = Sets.newHashSet();
			protected ImmutableLinkedItem<T> queryState = null;
			protected Resource resource;
			protected boolean resourceLeftOrCyclic;
			
			protected boolean add(T t) {
				boolean result = computations.add(t);
				if (result) {
					if (queryState == null) {
						resource = getPrimaryEObject(t).eResource();
					}
					queryState = new ImmutableLinkedItem<T>(t, queryState);
				}
				return result;
			}
			
			protected void remove(T t) {
				computations.remove(t);
				queryState = queryState.prev;
				if (queryState == null)
					resource = null;
			}

			protected int size() {
				return computations.size();
			}
		}
		
		protected abstract EObject getPrimaryEObject(T t);
		
		private final ThreadLocal<ComputationData> ongoingComputations = new ThreadLocal<ComputationData>() {
			@Override
			protected ComputationData initialValue() {
				return createComputationData();
			}
		};
		private final ThreadLocal<ComputationData> ongoingRawTypeComputations = new ThreadLocal<ComputationData>() {
			@Override
			protected ComputationData initialValue() {
				return createComputationData();
			}
		};
		
		protected ComputationData getTypeComputations(boolean rawType) {
			ThreadLocal<ComputationData> computations = rawType ? ongoingRawTypeComputations : ongoingComputations;
			ComputationData result = computations.get();
			return result;
		}

		public JvmTypeReference getType(final T t, final boolean rawType) {
			if (t == null)
				return null;
			EObject eObject = getPrimaryEObject(t);
			if (eObject == null || eObject.eIsProxy())
				return null;
			ComputationData computationData = getTypeComputations(rawType);
			if (computationData.add(t)) {
				try {
					if (computationData.resource == eObject.eResource() && !computationData.resourceLeftOrCyclic) {
						Triple<CyclicHandlingSupport<T>, ImmutableLinkedItem<T>, Boolean> cacheKey = Tuples.create(this, computationData.queryState, rawType);
						final boolean[] hit = new boolean[] { true };
						JvmTypeReference result = typeReferenceAwareCache.get(cacheKey, computationData.resource, new Provider<JvmTypeReference>(){
							public JvmTypeReference get() {
								hit[0] = false;
								JvmTypeReference result = doComputation(t, rawType);
								return result;
							}
						});
						if (logger.isDebugEnabled()) {
							logger.debug(getDebugIndentation(rawType) + "cache hit: " + hit[0] + " for: " + t);
						}
						return result;
					} else {
						if (computationData.resourceLeftOrCyclic)
							return doComputation(t, rawType);
						try {
							computationData.resourceLeftOrCyclic = true;
							return doComputation(t, rawType);
						} finally {
							computationData.resourceLeftOrCyclic = false;
						}
					}
					
				} finally {
					computationData.remove(t);
				}
			} else {
				if (computationData.resourceLeftOrCyclic)
					return doHandleCyclicCall(t, rawType);
				try {
					computationData.resourceLeftOrCyclic = true;
					return doHandleCyclicCall(t, rawType);
				} finally {
					computationData.resourceLeftOrCyclic = false;
				}
			}
		}
		
		protected int getOngoingComputationsSize(boolean rawType) {
			return getTypeComputations(rawType).size();
		}

		protected abstract JvmTypeReference doComputation(T t, boolean rawType);

		protected abstract JvmTypeReference doHandleCyclicCall(T t, boolean rawType);

		protected ComputationData createComputationData() {
			return new ComputationData();
		}
	}

}
