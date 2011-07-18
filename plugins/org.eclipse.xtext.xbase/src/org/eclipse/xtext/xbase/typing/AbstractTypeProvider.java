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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XExpression;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractTypeProvider implements ITypeProvider {

	private static final Logger logger = Logger.getLogger(AbstractTypeProvider.class);
	
	@Inject 
	private XbaseTypeConformanceComputer typeConformanceComputer;
	
	@Inject 
	private TypeReferences typeReferences;
	
	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;
	
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
	protected static final class ImmutableLinkedItem {
		
		protected final EObject object;
		protected final ImmutableLinkedItem prev;
		protected final int hashCode;
		protected final int size;
		
		public ImmutableLinkedItem(EObject object, ImmutableLinkedItem immutableStack) {
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
			ImmutableLinkedItem other = (ImmutableLinkedItem) obj;
			return other.object == object && other.size == size && (other.prev == prev || prev != null && prev.equals(other.prev));
		}
		
		@Override
		public int hashCode() {
			return hashCode;
		}

	}
	
	private OnChangeEvictingCache typeReferenceAwareCache = new OnChangeEvictingCache() {
		
		@Override
		public <T> T get(Object key, Resource resource, Provider<T> provider) {
			if(resource == null) {
				return provider.get();
			}
			CacheAdapter adapter = getOrCreate(resource);
			T element = adapter.<T>get(key);
			if (element==null) {
				element = provider.get();
				boolean rawType = (Boolean) ((Triple<?, ?, ?>) key).getThird();
				if (element==null || (element instanceof JvmTypeReference && !isResolved((JvmTypeReference) element, null, rawType))) {
					if (logger.isDebugEnabled()) {
						logger.debug(getDebugIndentation(rawType) + "cache skip: " + element);
					}
					return element;
				}
				if (logger.isDebugEnabled()) {
					logger.debug(getDebugIndentation(rawType) + "cache: " + element);
				}
				adapter.set(key, element);
			}
			return element;
		}
	};
	
	// TODO improve / extract to a utility method if other clients are doing similar things
	protected boolean isResolved(JvmTypeReference reference, JvmTypeParameterDeclarator declarator, boolean rawType) {
		if (reference == null)
			return false;
		if (reference.getType() instanceof JvmTypeParameter) {
			if (isDeclaratorOf(declarator, (JvmTypeParameter) reference.getType()))
				return true;
			return false;
		}
		if (reference instanceof JvmParameterizedTypeReference) {
			if (rawType)
				return true;
			JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) reference;
			for(JvmTypeReference argument: parameterized.getArguments()) {
				if (!isResolved(argument, declarator, rawType))
					return false;
			}
		}
		if (reference instanceof JvmWildcardTypeReference) {
			for(JvmTypeConstraint constraint: ((JvmWildcardTypeReference) reference).getConstraints()) {
				if (!isResolved(constraint.getTypeReference(), declarator, rawType))
					return false;
			}
		}
		return true;
	}
	
	protected JvmTypeParameterDeclarator getNearestTypeParameterDeclarator(EObject obj) {
		return EcoreUtil2.getContainerOfType(obj, JvmTypeParameterDeclarator.class);
	}
	
	protected boolean isDeclaratorOf(JvmTypeParameterDeclarator declarator, JvmTypeParameter param) {
		return param.getDeclarator() == declarator;
	}
	
	private final PolymorphicDispatcher<JvmTypeReference> typeDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_type", 2, 2, this);

	protected JvmTypeReference _type(XExpression expression, boolean rawType) {
		throw new IllegalArgumentException("Type computation is not implemented for " + expression);
	}

	protected CyclicHandlingSupport<XExpression> getType = new CyclicHandlingSupport<XExpression>() {

		@Override
		protected JvmTypeReference doComputation(XExpression t, boolean rawType) {
			return typeDispatcher.invoke(t, rawType);
		}

		@Override
		protected JvmTypeReference doHandleCyclicCall(XExpression t, boolean rawType) {
			return handleCyclicGetType(t, rawType);
		}
	};

	protected String getDebugIndentation(boolean rawType) {
		int size = getType.getOngoingComputationsSize(rawType) + getExpectedType.getOngoingComputationsSize(rawType) + getTypeForIdentifiable.getOngoingComputationsSize(rawType);
		char[] chars = new char[size];
		Arrays.fill(chars, ' ');
		return String.valueOf(chars);
	}
	
	protected <T extends EObject> JvmTypeReference doGetType(String key, T object, boolean rawType, CyclicHandlingSupport<T> typeComputer) {
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
		return getType(expression, false);
	}
	
	public JvmTypeReference getType(final XExpression expression, boolean rawType) {
		return doGetType("getType", expression, rawType, getType);
	}

	protected JvmTypeReference handleCyclicGetType(final XExpression expression, boolean rawType) {
		return null;
	}

	private final PolymorphicDispatcher<JvmTypeReference> expectedTypeDispatcher = PolymorphicDispatcher
			.createForSingleTarget("_expectedType", 4, 4, this);

	protected JvmTypeReference _expectedType(EObject container, EReference reference, int index, boolean rawType) {
		return null;
	}

	protected CyclicHandlingSupport<XExpression> getExpectedType = new CyclicHandlingSupport<XExpression>() {

		@Override
		protected JvmTypeReference doComputation(XExpression t, boolean rawType) {
			Triple<EObject, EReference, Integer> triple = getContainingInfo(t);
			if (triple == null)
				return null;
			return expectedTypeDispatcher.invoke(triple.getFirst(), triple.getSecond(), triple.getThird(), rawType);
		}

		@Override
		protected JvmTypeReference doHandleCyclicCall(XExpression t, boolean rawType) {
			return handleCycleGetExpectedType(t, rawType);
		}
	};
	
	public JvmTypeReference getExpectedType(final XExpression expression) {
		return getExpectedType(expression, false);
	}
	
	public JvmTypeReference getExpectedType(final XExpression expression, boolean rawType) {
		return doGetType("getExpectedType", expression, rawType, getExpectedType);
	}

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

	private final PolymorphicDispatcher<JvmTypeReference> typeForIdentifiableDispatcher = PolymorphicDispatcher
			.createForSingleTarget("_typeForIdentifiable", 2, 2, this);

	protected JvmTypeReference _typeForIdentifiable(JvmIdentifiableElement identifiable, boolean rawType) {
		throw new IllegalArgumentException("Type computation is not implemented for " + identifiable);
	}

	protected CyclicHandlingSupport<JvmIdentifiableElement> getTypeForIdentifiable = new CyclicHandlingSupport<JvmIdentifiableElement>() {

		@Override
		protected JvmTypeReference doComputation(JvmIdentifiableElement t, boolean rawType) {
			return typeForIdentifiableDispatcher.invoke(t, rawType);
		}

		@Override
		protected JvmTypeReference doHandleCyclicCall(JvmIdentifiableElement t, boolean rawType) {
			return handleCycleGetTypeForIdentifiable(t, rawType);
		}
	};

	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement) {
		return getTypeForIdentifiable(identifiableElement, false);
	}
	
	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement, boolean rawType) {
		return doGetType("getTypeForIdentifiable", identifiableElement, rawType, getTypeForIdentifiable);
	}

	protected JvmTypeReference handleCycleGetTypeForIdentifiable(JvmIdentifiableElement identifiableElement, boolean rawType) {
		return null;
	}
	
	public static class EarlyExitAcceptor {
		protected List<JvmTypeReference> returns = newArrayList();
		protected List<JvmTypeReference> thrown = newArrayList();
		
		public List<JvmTypeReference> getReturns() {
			return returns;
		}
		
		public List<JvmTypeReference> getThrown() {
			return thrown;
		}

		public void appendThrown(Iterable<JvmTypeReference> exceptions) {
			thrown.addAll(newArrayList(exceptions));
		}
		
	}
	
	private PolymorphicDispatcher<Void> earlyExits = PolymorphicDispatcher.createForSingleTarget("_earlyExits", 2, 2, this);
	
	public JvmTypeReference getCommonReturnType(XExpression expression, boolean assumeImplicitReturnExpression) {
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
	
	protected void internalCollectEarlyExits(EObject expr, EarlyExitAcceptor acceptor) {
		earlyExits.invoke(expr, acceptor);
	}
	
	protected void _earlyExits(Void expr, EarlyExitAcceptor a) {
	}
	
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

	protected static class ComputationData<T extends EObject> {
		protected final Set<T> computations = Sets.newHashSet();
		protected ImmutableLinkedItem queryState = null;
		protected Resource resource;
		protected boolean resourceLeftOrCyclic;
		
		protected boolean add(T t) {
			boolean result = computations.add(t);
			if (result) {
				if (queryState == null) {
					resource = t.eResource();
				}
				queryState = new ImmutableLinkedItem(t, queryState);
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
	
	abstract class CyclicHandlingSupport<T extends EObject> {

		private final ThreadLocal<ComputationData<T>> ongoingComputations = new ThreadLocal<ComputationData<T>>() {
			@Override
			protected ComputationData<T> initialValue() {
				return new ComputationData<T>();
			}
		};
		private final ThreadLocal<ComputationData<T>> ongoingRawTypeComputations = new ThreadLocal<ComputationData<T>>() {
			@Override
			protected ComputationData<T> initialValue() {
				return new ComputationData<T>();
			}
		};

		protected ComputationData<T> getTypeComputations(boolean rawType) {
			ThreadLocal<ComputationData<T>> computations = rawType ? ongoingRawTypeComputations : ongoingComputations;
			ComputationData<T> result = computations.get();
			return result;
		}

		public JvmTypeReference getType(final T t, final boolean rawType) {
			if (t == null)
				return null;
			if (t.eIsProxy())
				return null;
			ComputationData<T> computationData = getTypeComputations(rawType);
			if (computationData.add(t)) {
				try {
					if (computationData.resource == t.eResource() && !computationData.resourceLeftOrCyclic) {
						Triple<CyclicHandlingSupport<T>, ImmutableLinkedItem, Boolean> cacheKey = Tuples.create(this, computationData.queryState, rawType);
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
	}

}
