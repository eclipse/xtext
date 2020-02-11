/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.AnnotationLookup;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.controlflow.ConstantConditionsInterpreter;
import org.eclipse.xtext.xbase.controlflow.EvaluationContext;
import org.eclipse.xtext.xbase.controlflow.IConstantEvaluationResult;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.InferredTypeIndicator;
import org.eclipse.xtext.xbase.typesystem.LocalVariableCapturer;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.AbstractReentrantTypeReferenceProvider;
import org.eclipse.xtext.xbase.typesystem.util.LocalTypeSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.Maps2;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class LogicalContainerAwareReentrantTypeResolver extends DefaultReentrantTypeResolver {

	protected static class LocalVariableCapturerImpl extends LocalVariableCapturer {

		private JvmDeclaredType localClass;
		private LogicalContainerAwareReentrantTypeResolver typeResolver;
		private Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext;
		private ResolvedTypes resolvedTypes;
		private IFeatureScopeSession capturedState;

		protected LocalVariableCapturerImpl(
				JvmTypeReference equivalent,
				JvmDeclaredType localClass,
				LogicalContainerAwareReentrantTypeResolver typeResolver,
				ResolvedTypes resolvedTypes,
				Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext) {
			super(equivalent);
			this.localClass = localClass;
			this.typeResolver = typeResolver;
			this.resolvedTypes = resolvedTypes;
			this.resolvedTypesByContext = resolvedTypesByContext;
		}
		
		@Override
		protected void awaitCapturing() {
			super.awaitCapturing();
		}

		@Override
		protected void capture(ITypeComputationState state) {
			this.capturedState = ((AbstractTypeComputationState) state).getFeatureScopeSession();
			IFeatureScopeSession nestedSession = typeResolver.addThisAndSuper(capturedState, state.getReferenceOwner(), localClass, getEquivalent(), true);
			
			ResolvedTypes capturedResolvedTypes = captureResolvedTypes(state);
			typeResolver.doPrepare(capturedResolvedTypes, nestedSession, localClass, resolvedTypesByContext);
		}

		protected ResolvedTypes captureResolvedTypes(ITypeComputationState state) {
			ResolvedTypes capturedResolvedTypes = ((AbstractTypeComputationState) state).getResolvedTypes();
			return new CapturedLocalElementsAwareStackedResolvedTypes(capturedResolvedTypes, resolvedTypes);
		}
		
		protected static IFeatureScopeSession findCapturedState(JvmDeclaredType type) {
			LocalVariableCapturerImpl capturer = findLocalClassSupertype(type);
			if (capturer != null) {
				if (capturer.capturedState == null) {
					throw new IllegalStateException("Not yet captured");
				}
				return capturer.capturedState;
			}
			return null;
		}
		
	}
	
	protected static abstract class AbstractDemandTypeReferenceProvider extends AbstractReentrantTypeReferenceProvider {

		/*
		 * Allows invocation from within the context of the class
		 */
		@Override
		protected void markComputing() {
			super.markComputing();
		}
		
		@Override
		protected void unmarkComputing() {
			super.unmarkComputing();
		}
		
	}
	
	public class DemandTypeReferenceProvider extends AbstractDemandTypeReferenceProvider {
		private final JvmMember member;
		private final ResolvedTypes resolvedTypes;
		private final boolean returnType;
		private final IFeatureScopeSession session;
		private final XExpression expression;
		private final Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext;

		public DemandTypeReferenceProvider(
				JvmMember member, 
				XExpression expression, 
				Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext,
				ResolvedTypes resolvedTypes, 
				IFeatureScopeSession session, 
				boolean returnType) {
			this.member = member;
			this.expression = expression;
			this.resolvedTypesByContext = resolvedTypesByContext;
			this.resolvedTypes = resolvedTypes;
			this.session = session;
			this.returnType = returnType;
		}

		@Override
		/* @Nullable */
		protected JvmTypeReference doGetTypeReference(XComputedTypeReferenceImplCustom context) {
			try {
				if (isHandled(expression)) {
					return doGetTypeReferenceWithCurrentTypeResolver();
				}
				return doGetTypReferenceWithAnotherTypeReference();
			} finally {
				context.unsetTypeProviderWithoutNotification();
			}
		}

		protected JvmTypeReference doGetTypReferenceWithAnotherTypeReference() {
			IResolvedTypes resolveTypes = typeResolver.resolveTypes(expression);
			LightweightTypeReference actualType = returnType ? resolveTypes.getReturnType(expression) : resolveTypes.getActualType(expression);
			if (actualType == null) {
				actualType = returnType ? resolvedTypes.getExpectedReturnType(expression) : resolvedTypes.getExpectedType(expression);
			}
			if (actualType == null)
				return null;
			return toJavaCompliantTypeReference(convertLocalType(actualType), session);
		}

		protected JvmTypeReference doGetTypeReferenceWithCurrentTypeResolver() {
			LightweightTypeReference actualType = returnType ? resolvedTypes.getReturnType(expression) : resolvedTypes.getActualType(expression);
			if (actualType == null) {
				computeTypes(resolvedTypesByContext, resolvedTypes, session, member);
				actualType = returnType ? resolvedTypes.getExpectedReturnType(expression) : resolvedTypes.getExpectedType(expression);
				if (actualType == null)
					actualType = returnType ? resolvedTypes.getReturnType(expression) : resolvedTypes.getActualType(expression);
			}
			if (actualType == null)
				return null;
			return toJavaCompliantTypeReference(convertLocalType(actualType), session);
		}

		protected LightweightTypeReference convertLocalType(LightweightTypeReference reference) {
			if (member instanceof JvmFeature) {
				List<JvmGenericType> localClasses = ((JvmFeature) member).getLocalClasses();
				if (localClasses.isEmpty()) {
					return reference;
				}
				LocalTypeSubstitutor substitutor = new LocalTypeSubstitutor(reference.getOwner(), member);
				LightweightTypeReference result = substitutor.withoutLocalTypes(reference);
				return result;
			} else {
				return reference;
			}
		}
		
		@Override
		protected JvmTypeReference handleReentrantInvocation(XComputedTypeReferenceImplCustom context) {
			EObject sourceElement = getSourceElement(member);
			EStructuralFeature feature = sourceElement.eClass().getEStructuralFeature("name");
			resolvedTypes.addDiagnostic(new EObjectDiagnosticImpl(
					Severity.WARNING, 
					IssueCodes.TOO_LITTLE_TYPE_INFORMATION, 
					"Cannot infer type from recursive usage. Type 'Object' is used.",
					sourceElement, 
					feature, 
					-1, 
					null));
			AnyTypeReference result = resolvedTypes.getReferenceOwner().newAnyTypeReference();
			return toJavaCompliantTypeReference(result, session);
		}
		
	}
	
	public static class AnyTypeReferenceProvider extends AbstractReentrantTypeReferenceProvider {
		private final JvmMember member;
		private final ResolvedTypes resolvedTypes;
		private final LogicalContainerAwareReentrantTypeResolver typeResolver;

		public AnyTypeReferenceProvider(JvmMember member, ResolvedTypes resolvedTypes, LogicalContainerAwareReentrantTypeResolver typeResolver) {
			this.member = member;
			this.resolvedTypes = resolvedTypes;
			this.typeResolver = typeResolver;
		}

		@Override
		/* @Nullable */
		protected JvmTypeReference doGetTypeReference(XComputedTypeReferenceImplCustom context) {
			try {
				resolvedTypes.addDiagnostic(new EObjectDiagnosticImpl(
						Severity.ERROR, 
						IssueCodes.TOO_LITTLE_TYPE_INFORMATION, 
						"Cannot infer type",
						typeResolver.getSourceElement(member), 
						null, 
						-1, 
						null));
				return TypesFactory.eINSTANCE.createJvmAnyTypeReference();
			} finally {
				context.unsetTypeProviderWithoutNotification();
			}
		}
	}

	@Inject
	private ILogicalContainerProvider logicalContainerProvider;
	
	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	private OverrideHelper overrideHelper;
	
	@Inject
	private AnnotationLookup annotationLookup;
	
	@Inject
	private IBatchTypeResolver typeResolver;
	
	@Inject
	private ConstantConditionsInterpreter constantConditionsInterpreter;
	
	protected Set<EObject> rootedInstances;
	
	protected JvmType getRootJvmType() {
		EObject result = getRoot();
		if (result instanceof JvmType)
			return (JvmType) result;
		throw new IllegalStateException();
	}
	
	@Override
	protected void clear() {
		rootedInstances.clear();
		super.clear();
	}
	
	@Override
	protected void setAllRootedExpressions(final Set<EObject> allRootedExpressions) {
		super.setAllRootedExpressions(allRootedExpressions);
		rootedInstances = new HashSet<EObject>() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean add(EObject e) {
				if (!allRootedExpressions.add(e)) {
					throw new IllegalStateException("Cannot root object twice: " + e);
				}
				return super.add(e);
			}
		};
	}
	
	@Override
	protected boolean isHandled(JvmIdentifiableElement identifiableElement) {
		// if the identifiable is a formal parameter, use the nearest logical container since
		// it may be the parameter of a lambda or for loop
		JvmIdentifiableElement container = logicalContainerProvider.getNearestLogicalContainer(identifiableElement);
		if (container != null) {
			return super.isHandled(container);
		}
		return super.isHandled(identifiableElement);
	}
	
	@Override
	protected boolean isHandled(XExpression expression) {
		// short cut - shaves off around 20% of all calls
		if (rootedInstances.contains(expression)) {
			return true;
		}
		JvmIdentifiableElement logicalContainer = logicalContainerProvider.getNearestLogicalContainer(expression);
		if (logicalContainer == null)
			return false;
		XExpression associatedExpression = logicalContainerProvider.getAssociatedExpression(logicalContainer);
		if (associatedExpression != null && EcoreUtil.isAncestor(associatedExpression, expression) && rootedInstances.contains(associatedExpression)) {
			return true;
		}
		// special treatment for annotations
		EObject root = expression;
		EObject container = root.eContainer();
		while(isPartOfExpressionTree(container)) {
			root = container;
			container = root.eContainer();
		}
		if (rootedInstances.contains(root)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true if the container can be nested within the expression tree. First and foremost that's
	 * true if the container itself is an expression. Other possible types are {@link XCasePart},
	 * {@link XCatchClause} or {@link XAnnotationElementValuePair}. Clients may override.
	 */
	protected boolean isPartOfExpressionTree(EObject container) {
		if (container instanceof XExpression) {
			return true;
		}
		EClass type = container.eClass();
		return type == XbasePackage.Literals.XCASE_PART || type == XbasePackage.Literals.XCATCH_CLAUSE || type == XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR;
	}
	
	@Override
	protected boolean isHandled(EObject context) {
		if (context instanceof XExpression) {
			return isHandled((XExpression)context);
		}
		if (context instanceof JvmIdentifiableElement) {
			return isHandled((JvmIdentifiableElement)context);
		}
		if (isPartOfExpressionTree(context)) {
			return isHandled((XExpression) context.eContainer());
		}
		JvmIdentifiableElement logicalContainer = logicalContainerProvider.getNearestLogicalContainer(context);
		if (logicalContainer == null)
			return false;
		return isHandled(logicalContainer);
	}
	
	/**
	 * Assign computed type references to the identifiable structural elements in the processed type.
	 * @return the stacked resolved types that shall be used in the computation.
	 */
	protected Map<JvmIdentifiableElement, ResolvedTypes> prepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession) {
		Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext = Maps.newHashMapWithExpectedSize(3); 
		JvmType root = getRootJvmType();
		rootedInstances.add(root);
		recordExpressions(root);
		doPrepare(resolvedTypes, featureScopeSession, root, resolvedTypesByContext);
		return resolvedTypesByContext;
	}
	
	protected void recordExpressions(JvmIdentifiableElement element) {
		XExpression expression = getLogicalContainerProvider().getAssociatedExpression(element);
		if (expression != null) {
			rootedInstances.add(expression);
		}
		if (element instanceof JvmDeclaredType) {
			_recordExpressions((JvmDeclaredType) element);
		} else if (element instanceof JvmExecutable) {
			_recordExpressions((JvmExecutable) element);
		} else if (element instanceof JvmFeature) {
			_recordExpressions((JvmFeature) element);
		}
	}

	protected void _recordExpressions(JvmFeature feature) {
		List<JvmGenericType> localClasses = feature.getLocalClasses();
		for(int i = 0, size = localClasses.size(); i < size; i++) {
			recordExpressions(localClasses.get(i));
		}
		recordAnnotationExpressions(feature);
	}

	protected void _recordExpressions(JvmExecutable executable) {
		List<JvmGenericType> localClasses = executable.getLocalClasses();
		for(int i = 0, size = localClasses.size(); i < size; i++) {
			recordExpressions(localClasses.get(i));
		}
		recordAnnotationExpressions(executable);
	}

	protected void _recordExpressions(JvmDeclaredType type) {
		List<JvmMember> members = type.getMembers();
		for(int i = 0, size = members.size(); i < size; i++) {
			recordExpressions(members.get(i));
		}
		recordAnnotationExpressions(type);
	}

	protected void doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmIdentifiableElement element, Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext) {
		XExpression expression = getLogicalContainerProvider().getAssociatedExpression(element);
		if (expression != null) {
			if (!rootedInstances.contains(expression)) {
				throw new IllegalStateException("Expression not yet recorded: " + expression);
			}
		}
		if (element instanceof JvmDeclaredType) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmDeclaredType) element, resolvedTypesByContext);
		} else if (element instanceof JvmConstructor) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmConstructor) element, resolvedTypesByContext);
		} else if (element instanceof JvmField) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmField) element, resolvedTypesByContext);
		} else if (element instanceof JvmOperation) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmOperation) element, resolvedTypesByContext);
		}
	}
	
	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmDeclaredType type, Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByType) {
		IFeatureScopeSession childSession = addThisAndSuper(featureScopeSession, resolvedTypes.getReferenceOwner(), type);
		prepareMembers(resolvedTypes, childSession, type, resolvedTypesByType);
	}

	protected void prepareMembers(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmDeclaredType type, Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByType) {
		IFeatureScopeSession childSession = addExtensionsToMemberSession(resolvedTypes, featureScopeSession, type);
		
		StackedResolvedTypes childResolvedTypes = declareTypeParameters(resolvedTypes, type, resolvedTypesByType);
		
		JvmTypeReference superType = getExtendedClass(type);
		ITypeReferenceOwner referenceOwner = childResolvedTypes.getReferenceOwner();
		if (superType != null) {
			LightweightTypeReference lightweightSuperType = referenceOwner.toLightweightTypeReference(superType);
			childResolvedTypes.reassignTypeWithoutMerge(superType.getType(), lightweightSuperType);
			/* 
			 * We use reassignType to make sure that the following works:
			 *
			 * StringList extends AbstractList<String> {
			 *   NestedIntList extends AbstractList<Integer> {
			 *   }
			 *   SubType extends StringList {}
			 * }
			 */
		}
		LightweightTypeReference lightweightThisType = referenceOwner.toLightweightTypeReference(type);
		childResolvedTypes.reassignTypeWithoutMerge(type, lightweightThisType);
		
		List<JvmMember> members = type.getMembers();
		int size = members.size();
		for(int i = 0; i < size; i++) {
			doPrepare(childResolvedTypes, childSession, members.get(i), resolvedTypesByType);
		}
	}

	protected StackedResolvedTypes declareTypeParameters(ResolvedTypes resolvedTypes, JvmIdentifiableElement declarator,
			Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext) {
		StackedResolvedTypes childResolvedTypes = resolvedTypes.pushTypes();
		if (declarator instanceof JvmTypeParameterDeclarator) {
			JvmTypeParameterDeclarator casted = (JvmTypeParameterDeclarator) declarator;
			if (isStatic(declarator) && !(declarator instanceof JvmConstructor)) {
				childResolvedTypes.replaceDeclaredTypeParameters(casted.getTypeParameters());
			} else {
				childResolvedTypes.addDeclaredTypeParameters(casted.getTypeParameters());
			}
		}
		resolvedTypesByContext.put(declarator, childResolvedTypes);
		return childResolvedTypes;
	}
	
	protected boolean isStatic(JvmIdentifiableElement declarator) {
		if (declarator instanceof JvmFeature) {
			return ((JvmFeature) declarator).isStatic();
		}
		if (declarator instanceof JvmDeclaredType) {
			return ((JvmDeclaredType) declarator).isStatic();
		}
		return false;
	}

	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmField field, Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext) {
		StackedResolvedTypes childResolvedTypes = declareTypeParameters(resolvedTypes, field, resolvedTypesByContext);
		
		JvmTypeReference knownType = field.getType();
		if (InferredTypeIndicator.isInferred(knownType)) {
			XComputedTypeReference casted = (XComputedTypeReference) knownType;
			JvmTypeReference reference = createComputedTypeReference(resolvedTypesByContext, childResolvedTypes, featureScopeSession, field, (InferredTypeIndicator) casted.getTypeProvider(), false);
			casted.setEquivalent(reference);
		} else if (knownType != null) {
			LightweightTypeReference lightweightReference = childResolvedTypes.getReferenceOwner().toLightweightTypeReference(knownType);
			childResolvedTypes.setType(field, lightweightReference);
		} else {
			JvmTypeReference reference = createComputedTypeReference(resolvedTypesByContext, childResolvedTypes, featureScopeSession, field, null, false);
			field.setType(reference);
		}
	}
	
	/* @Nullable */
	protected AbstractDemandTypeReferenceProvider getComputedTypeReference(JvmTypeReference knownType) {
		if (InferredTypeIndicator.isInferred(knownType)) {
			XComputedTypeReference casted = (XComputedTypeReference) knownType;
			JvmTypeReference equivalent = casted.getEquivalent();
			if (equivalent instanceof XComputedTypeReference) {
				IJvmTypeReferenceProvider typeProvider = ((XComputedTypeReference) equivalent).getTypeProvider();
				if (typeProvider instanceof AbstractDemandTypeReferenceProvider) {
					return (AbstractDemandTypeReferenceProvider) typeProvider;
				}
			}
		}
		return null;
	}
	
	protected void markComputing(JvmTypeReference knownType) {
		AbstractDemandTypeReferenceProvider demandTypeReferenceProvider = getComputedTypeReference(knownType);
		if (demandTypeReferenceProvider != null) {
			demandTypeReferenceProvider.markComputing();
		}
	}
	
	protected void unmarkComputing(JvmTypeReference knownType) {
		AbstractDemandTypeReferenceProvider demandTypeReferenceProvider = getComputedTypeReference(knownType);
		if (demandTypeReferenceProvider != null) {
			demandTypeReferenceProvider.unmarkComputing();
		}
	}
	
	@SuppressWarnings("unused")
	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmConstructor constructor, Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext) {
		StackedResolvedTypes childResolvedTypes = declareTypeParameters(resolvedTypes, constructor, resolvedTypesByContext);
		
		JvmDeclaredType producedType = constructor.getDeclaringType();
		LightweightTypeReference lightweightReference = childResolvedTypes.getReferenceOwner().toLightweightTypeReference(producedType);
		childResolvedTypes.setType(constructor, lightweightReference);
	}
	
	protected void recordAnnotationExpressions(JvmExecutable executable) {
		List<JvmFormalParameter> parameters = executable.getParameters();
		for(JvmFormalParameter parameter: parameters) {
			recordAnnotationExpressions(parameter);
		}
		recordAnnotationExpressions((JvmAnnotationTarget) executable);
	}
	
	protected void recordAnnotationExpressions(JvmAnnotationTarget annotable) {
		List<JvmAnnotationReference> annotations = annotable.getAnnotations();
		recordAnnotationExpressions(annotations);
	}

	protected void recordAnnotationExpressions(List<JvmAnnotationReference> annotations) {
		for(JvmAnnotationReference annotation: annotations) {
			EObject sourceElement = getSourceElement(annotation);
			if (sourceElement != annotation) {
				rootedInstances.add(sourceElement);
			} else {
				for(JvmAnnotationValue value: annotation.getExplicitValues()) {
					if (value instanceof JvmCustomAnnotationValue) {
						JvmCustomAnnotationValue custom = (JvmCustomAnnotationValue) value;
						for(Object object: custom.getValues()) {
							if (object instanceof XExpression) {
								rootedInstances.add(sourceElement);
							}
						}
					} else if (value instanceof JvmAnnotationAnnotationValue) {
						recordAnnotationExpressions(((JvmAnnotationAnnotationValue) value).getValues());
					}
				}
			}
		}
	}

	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmOperation operation, Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext) {
		StackedResolvedTypes childResolvedTypes = declareTypeParameters(resolvedTypes, operation, resolvedTypesByContext);
		
		JvmTypeReference knownType = operation.getReturnType();
		if (InferredTypeIndicator.isInferred(knownType)) {
			XComputedTypeReference casted = (XComputedTypeReference) knownType;
			JvmTypeReference reference = createComputedTypeReference(
					resolvedTypesByContext, childResolvedTypes, featureScopeSession, operation, (InferredTypeIndicator) casted.getTypeProvider(), true);
			casted.setEquivalent(reference);
		} else if (knownType != null) {
			LightweightTypeReference lightweightReference = childResolvedTypes.getReferenceOwner().toLightweightTypeReference(knownType);
			childResolvedTypes.setType(operation, lightweightReference);
		} else {
			JvmTypeReference reference = createComputedTypeReference(resolvedTypesByContext, childResolvedTypes, featureScopeSession, operation, null, true);
			operation.setReturnType(reference);
		}
	}
	
	protected JvmTypeReference createComputedTypeReference(
			Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext,
			ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			JvmMember member,
			/* @Nullable */ InferredTypeIndicator indicator,
			boolean returnType) {
		XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
		if (indicator == null || indicator.getExpression() == null)
			result.setTypeProvider(createTypeProvider(resolvedTypesByContext, resolvedTypes, featureScopeSession, member, returnType));
		else
			result.setTypeProvider(createTypeProvider(resolvedTypesByContext, resolvedTypes, featureScopeSession, member, indicator.getExpression(), returnType));
		// TODO do we need a lightweight computed type reference?
//		resolvedTypes.setType(member, result);
		return result;
	}
	
	protected AbstractReentrantTypeReferenceProvider createTypeProvider(Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmMember member, boolean returnType) {
		XExpression expression = logicalContainerProvider.getAssociatedExpression(member);
		return createTypeProvider(resolvedTypesByContext, resolvedTypes, featureScopeSession, member, expression, returnType);
	}
	
	protected AbstractReentrantTypeReferenceProvider createTypeProvider(
			Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmMember member, 
			/* @Nullable */ XExpression expression, boolean returnType) {
		if (expression != null) {
			markToBeInferred(resolvedTypes, expression);
			return new DemandTypeReferenceProvider(member, expression, resolvedTypesByContext, resolvedTypes, featureScopeSession, returnType);
		}
		return new AnyTypeReferenceProvider(member, resolvedTypes, this); 
	}

	protected void markToBeInferred(ResolvedTypes resolvedTypes, XExpression expression) {
		resolvedTypes.markToBeInferred(expression);
	}
	
	/**
	 * Returns the expression that will be used to infer the given type from. If the type is 
	 * already resolved, the result will be null. If no expression can be determined, null is
	 * also returned.
	 */
	protected XExpression getInferredFrom(JvmTypeReference typeReference) {
		if (InferredTypeIndicator.isInferred(typeReference)) {
			XComputedTypeReference computed = (XComputedTypeReference) typeReference;
			if (computed.getEquivalent() instanceof XComputedTypeReference) {
				XComputedTypeReference inferred = (XComputedTypeReference) computed.getEquivalent();
				IJvmTypeReferenceProvider typeProvider = inferred.getTypeProvider();
				if (typeProvider instanceof DemandTypeReferenceProvider) {
					return ((DemandTypeReferenceProvider) typeProvider).expression;
				}
			}
		}
		return null;
	}
	
	@Override
	protected void computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession session) {
		EObject root = getRoot();
		if (root instanceof JvmType) {
			Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes = prepare(resolvedTypes, session);
			computeTypes(preparedResolvedTypes, resolvedTypes, session, root);
		} else {
			super.computeTypes(resolvedTypes, session);
		}
	}
	
	protected void computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, EObject element) {
		if (element instanceof JvmDeclaredType) {
			_computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, (JvmDeclaredType) element);
		} else if (element instanceof JvmConstructor) {
			_computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, (JvmConstructor) element);
		} else if (element instanceof JvmField) {
			_computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, (JvmField) element);
		} else if (element instanceof JvmOperation) {
			_computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, (JvmOperation) element);
		} else {
			computeTypes(resolvedTypes, featureScopeSession, element);
		}
	}
	
	@Override
	protected void computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, EObject element) {
		if (element instanceof JvmConstructor) {
			throw new IllegalStateException();
		} else if (element instanceof JvmField) {
			throw new IllegalStateException();
		} else if (element instanceof JvmOperation) {
			throw new IllegalStateException();
		} else if (element instanceof JvmDeclaredType) {
			throw new IllegalStateException();
		} else {
			super.computeTypes(resolvedTypes, featureScopeSession, element);
		}
	}

	@SuppressWarnings("unused")
	protected void _computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, final JvmField field) {
		ResolvedTypes childResolvedTypes = preparedResolvedTypes.get(field);
		if (childResolvedTypes == null) {
			if (preparedResolvedTypes.containsKey(field))
				return;
			throw new IllegalStateException("No resolved type found. Field was: " + field.getIdentifier());
		} else {
			preparedResolvedTypes.put(field, null);
		}
		final FieldTypeComputationState state = new FieldTypeComputationState(childResolvedTypes, field.isStatic() ? featureScopeSession : featureScopeSession.toInstanceContext(), field);
		markComputing(field.getType());
		try {
			state.computeTypes();
		} finally {
			unmarkComputing(field.getType());
		}
		computeAnnotationTypes(childResolvedTypes, featureScopeSession, field);
		computeLocalTypes(preparedResolvedTypes, childResolvedTypes, featureScopeSession, field);
		if (field.isStatic() && field.isFinal() && !field.isSetConstant()) {
			final XExpression expression = state.getRootExpression();
			childResolvedTypes.addDeferredLogic(new IAcceptor<IResolvedTypes>() {

				@Override
				public void accept(IResolvedTypes resolvedTypes) {
					EvaluationContext context = constantConditionsInterpreter.newEvaluationContext();
					context.addResolvedTypes(field.eResource(), resolvedTypes);
					IConstantEvaluationResult<Object> result = expression != null ? constantConditionsInterpreter.evaluate(expression, context) : null;
					if (result != null && result.isCompileTimeConstant()) {
						field.setConstantValue(result.getValue().orNull());
						field.setConstant(true);
					} else {
						field.setConstant(false);
					}
				}
			});
		}
		mergeChildTypes(childResolvedTypes);
	}
	
	@SuppressWarnings("unused")
	protected void _computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmConstructor constructor) {
		ResolvedTypes childResolvedTypes = preparedResolvedTypes.get(constructor);
		if (childResolvedTypes == null) {
			if (preparedResolvedTypes.containsKey(constructor))
				return;
			throw new IllegalStateException("No resolved type found. Constructor was: " + constructor.getIdentifier());
		} else {
			preparedResolvedTypes.put(constructor, null);
		}
		ConstructorBodyComputationState state = new ConstructorBodyComputationState(childResolvedTypes, featureScopeSession.toInstanceContext().toConstructorContext(), constructor);
		addExtensionProviders(state, constructor.getParameters());
		state.computeTypes();
		computeAnnotationTypes(childResolvedTypes, featureScopeSession, constructor);
		computeLocalTypes(preparedResolvedTypes, childResolvedTypes, featureScopeSession, constructor);
		mergeChildTypes(childResolvedTypes);
	}

	protected void computeLocalTypes(
			Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes,
			ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			JvmFeature feature) {
		for(JvmGenericType localClass: feature.getLocalClasses()) {
			computeTypes(preparedResolvedTypes, resolvedTypes, featureScopeSession, localClass);
		}
	}
	
	protected void addExtensionProviders(ITypeComputationState state, List<JvmFormalParameter> parameters) {
		List<JvmFormalParameter> extensionProviders = null;
		for(JvmFormalParameter parameter: parameters) {
			if (isExtensionProvider(parameter)) {
				if (extensionProviders == null)
					extensionProviders = Lists.newLinkedList();
				extensionProviders.add(parameter);
			}
		}
		if (extensionProviders != null)
			state.addExtensionsToCurrentScope(extensionProviders);
	}
	
	@SuppressWarnings("unused")
	protected void _computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmOperation operation) {
		ResolvedTypes childResolvedTypes = preparedResolvedTypes.get(operation);
		if (childResolvedTypes == null) {
			if (preparedResolvedTypes.containsKey(operation))
				return;
			throw new IllegalStateException("No resolved type found. Operation was: " + operation.getIdentifier());
		} else {
			preparedResolvedTypes.put(operation, null);
		}
		OperationBodyComputationState state = new OperationBodyComputationState(childResolvedTypes, operation.isStatic() ? featureScopeSession : featureScopeSession.toInstanceContext(), operation);
		addExtensionProviders(state, operation.getParameters());
		markComputing(operation.getReturnType());
		try {
			state.computeTypes();
		} finally {
			unmarkComputing(operation.getReturnType());
		}
		computeAnnotationTypes(childResolvedTypes, featureScopeSession, operation);
		computeLocalTypes(preparedResolvedTypes, childResolvedTypes, featureScopeSession, operation);
		mergeChildTypes(childResolvedTypes);
	}

	protected void computeAnnotationTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession sessions, JvmExecutable operation) {
		computeAnnotationTypes(resolvedTypes, sessions, (JvmAnnotationTarget) operation);
		for(JvmFormalParameter parameter: operation.getParameters()) {
			computeAnnotationTypes(resolvedTypes, sessions, parameter);
		}
	}

	protected void mergeChildTypes(ResolvedTypes childResolvedTypes) {
		if (childResolvedTypes instanceof StackedResolvedTypes)
			((StackedResolvedTypes) childResolvedTypes).mergeIntoParent();
	}
	
	protected void computeAnnotationTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmAnnotationTarget annotable) {
		List<JvmAnnotationReference> annotations = annotable.getAnnotations();
		computeAnnotationTypes(resolvedTypes, featureScopeSession, annotations);
	}

	protected void computeAnnotationTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, List<JvmAnnotationReference> annotations) {
		for(JvmAnnotationReference annotation: annotations) {
			EObject sourceElement = getSourceElement(annotation);
			if (sourceElement != annotation) {
				computeTypes(resolvedTypes, featureScopeSession, sourceElement);
			} else {
				for(JvmAnnotationValue value: annotation.getExplicitValues()) {
					if (value instanceof JvmCustomAnnotationValue) {
						JvmCustomAnnotationValue custom = (JvmCustomAnnotationValue) value;
						for(Object object: custom.getValues()) {
							if (object instanceof XExpression) {
								AnnotationValueTypeComputationState state = new AnnotationValueTypeComputationState(resolvedTypes, featureScopeSession, value, (XExpression) object);
								state.computeTypes();
							}
						}
					} else if (value instanceof JvmAnnotationAnnotationValue) {
						computeAnnotationTypes(resolvedTypes, featureScopeSession, ((JvmAnnotationAnnotationValue) value).getValues());
					}
				}
			}
		}
	}
	
	@SuppressWarnings("unused")
	protected void _computeTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmDeclaredType type) {
		ResolvedTypes childResolvedTypes = preparedResolvedTypes.get(type);
		if (childResolvedTypes == null)
			throw new IllegalStateException("No resolved type found. Type was: " + type.getIdentifier());
		IFeatureScopeSession capturedState = LocalVariableCapturerImpl.findCapturedState(type);
		if (capturedState != null) {
			featureScopeSession = capturedState;
		}
		IFeatureScopeSession childSession = addThisAndSuper(featureScopeSession, childResolvedTypes.getReferenceOwner(), type);
		computeMemberTypes(preparedResolvedTypes, childResolvedTypes, childSession, type);
		computeAnnotationTypes(childResolvedTypes, featureScopeSession, type);
		
		mergeChildTypes(childResolvedTypes);
	}

	protected void computeMemberTypes(Map<JvmIdentifiableElement, ResolvedTypes> preparedResolvedTypes, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession,
			JvmDeclaredType type) {
		IFeatureScopeSession childSession = addExtensionsToMemberSession(resolvedTypes, featureScopeSession, type);
		List<JvmMember> members = type.getMembers();
		for(int i = 0; i < members.size(); i++) {
			computeTypes(preparedResolvedTypes, resolvedTypes, childSession, members.get(i));
		}
	}
	
	protected IFeatureScopeSession addThisAndSuper(IFeatureScopeSession session, ITypeReferenceOwner owner, JvmDeclaredType type) {
		JvmTypeReference superType = getExtendedClass(type);
		return addThisAndSuper(session, owner, type, superType, true);
	}

	protected IFeatureScopeSession addThisAndSuper(
			IFeatureScopeSession session,
			ITypeReferenceOwner owner,
			JvmDeclaredType thisType,
			/* @Nullable */ JvmTypeReference superType,
			boolean addNestedTypes) {
		IFeatureScopeSession childSession = session;
		if (thisType.eContainer() != null) {
			if (thisType.isStatic()) {
				childSession = childSession.dropLocalElements();
			} else {
				childSession = childSession.captureLocalElements();
			}
		}
		if (superType != null && superType.getType() != null) {
			ImmutableMap.Builder<QualifiedName, JvmIdentifiableElement> builder = ImmutableMap.builder();
			builder.put(IFeatureNames.THIS, thisType);
			builder.put(IFeatureNames.SUPER, superType.getType());
			childSession = childSession.addLocalElements(builder.build(), owner);
		} else {
			childSession = childSession.addLocalElement(IFeatureNames.THIS, thisType, owner);
		}
		childSession = addThisTypeToStaticScope(childSession, thisType);
		if (addNestedTypes)
			childSession = childSession.addNestedTypesToScope(thisType);
		return childSession;
	}

	protected IFeatureScopeSession addThisTypeToStaticScope(IFeatureScopeSession session, JvmDeclaredType type) {
		return session.addTypesToStaticScope(Collections.singletonList(type), Collections.<JvmDeclaredType>emptyList());
	}
	
	/* @Nullable */
	public JvmTypeReference getExtendedClass(JvmDeclaredType type) {
		for(JvmTypeReference candidate: type.getSuperTypes()) {
			JvmType candidateType = candidate.getType();
			if (candidateType instanceof JvmGenericType && !((JvmGenericType) candidateType).isInterface())
				return candidate;
		}
		return null;
	}
	
	protected IFeatureScopeSession addExtensionsToMemberSession(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession, JvmDeclaredType type) {
		IEObjectDescription thisDescription = featureScopeSession.getLocalElement(IFeatureNames.THIS);
		if (thisDescription == null) {
			throw new IllegalStateException("Cannot find feature 'THIS'");
		}
		JvmIdentifiableElement thisFeature = (JvmIdentifiableElement) thisDescription.getEObjectOrProxy();
		IFeatureScopeSession childSession = addExtensionFieldsToMemberSession(
				resolvedTypes, featureScopeSession, type, thisFeature, Sets.<String>newHashSetWithExpectedSize(8), Sets.<JvmType>newHashSetWithExpectedSize(4));
		XFeatureCall thisAccess = getXbaseFactory().createXFeatureCall();
		thisAccess.setFeature(thisFeature);
		LightweightTypeReference thisType = resolvedTypes.getActualType(thisFeature);
		childSession = childSession.addToExtensionScope(Collections.<XExpression, LightweightTypeReference>singletonMap(thisAccess, thisType));
		return childSession;
	}
	
	protected IFeatureScopeSession addExtensionFieldsToMemberSession(
				ResolvedTypes resolvedTypes, 
				IFeatureScopeSession featureScopeSession, 
				JvmDeclaredType type, 
				JvmIdentifiableElement thisFeature,
				Set<String> seenNames,
				Set<JvmType> seenTypes) {
		if (seenTypes.add(type)) {
			Iterable<JvmField> fields = type.getDeclaredFields();
			// collect local fields first, to populate the set of names
			Map<XExpression, LightweightTypeReference> extensionProviders = null;
			for(JvmField field: fields) {
				if (featureScopeSession.isVisible(field) && seenNames.add(field.getSimpleName()) && isExtensionProvider(field)) {
					if (extensionProviders == null) {
						extensionProviders = Maps2.newLinkedHashMapWithExpectedSize(3);
					}
					XAbstractFeatureCall extensionProvider = createExtensionProvider(thisFeature, field);
					LightweightTypeReference fieldType = resolvedTypes.getActualType(field);
					extensionProviders.put(extensionProvider, fieldType);
				}
			}
			// traverse the type hierarchy to create the feature scope sessions
			JvmTypeReference superType = getExtendedClass(type);
			IFeatureScopeSession result = featureScopeSession;
			if (superType != null) {
				result = addExtensionFieldsToMemberSession(resolvedTypes, featureScopeSession, (JvmDeclaredType) superType.getType(), thisFeature, seenNames, seenTypes);
			}
			if (extensionProviders != null) {
				result = result.addToExtensionScope(extensionProviders);
			}
			return result;
		}
		return featureScopeSession;
	}
	
	protected XAbstractFeatureCall createExtensionProvider(JvmIdentifiableElement thisFeature, JvmField field) {
		if (field.isStatic()) {
			XFeatureCall extensionProvider = getXbaseFactory().createXFeatureCall();
			extensionProvider.setFeature(field);
			return extensionProvider;
		} else {
			XMemberFeatureCall extensionProvider = getXbaseFactory().createXMemberFeatureCall();
			extensionProvider.setFeature(field);
			XFeatureCall thisAccess = getXbaseFactory().createXFeatureCall();
			thisAccess.setFeature(thisFeature);
			extensionProvider.setMemberCallTarget(thisAccess);
			return extensionProvider;
		}
	}
	
	protected boolean isExtensionProvider(JvmAnnotationTarget annotatedElement) {
		// coding style to simplify debugging
		if (annotationLookup.findAnnotation(annotatedElement, Extension.class) != null) {
			return true;
		}
		return false;
	}
	
	protected AnnotationLookup getAnnotationLookup() {
		return annotationLookup;
	}

	protected ILogicalContainerProvider getLogicalContainerProvider() {
		return logicalContainerProvider;
	}
	
	protected IBatchTypeResolver getTypeResolver() {
		return typeResolver;
	}
	
	/**
	 * Returns <code>null</code> if the given operation declares it's own return type or if it does not override
	 * another operation.
	 */
	/* @Nullable */
	@SuppressWarnings("unused")
	protected LightweightTypeReference getReturnTypeOfOverriddenOperation(JvmOperation operation, ResolvedTypes resolvedTypes, IFeatureScopeSession session) {
		if (operation.getVisibility() == JvmVisibility.PRIVATE)
			return null;
		if (InferredTypeIndicator.isInferred(operation.getReturnType())) {
			LightweightTypeReference declaringType = resolvedTypes.getActualType(operation.getDeclaringType());
			if (declaringType == null) {
				throw new IllegalStateException("Cannot determine declaring type of operation: " + operation);
			}
			LightweightTypeReference result = overrideHelper.getReturnTypeOfOverriddenOperation(operation, declaringType);
			return result;
		}
		return null;
	}
	
	protected OverrideHelper getOverrideHelper() {
		return overrideHelper;
	}

	@Override
	protected EObject getSourceElement(EObject element) {
		EObject result = associations.getPrimarySourceElement(element);
		if (result != null)
			return result;
		return element;
	}
	
	protected Set<EObject> getInferredElements(EObject element) {
		return associations.getJvmElements(element);
	}
	
	protected JvmTypeReference toJavaCompliantTypeReference(LightweightTypeReference result, IFeatureScopeSession session) {
		return result.toJavaCompliantTypeReference(session);
	}
	
	protected void requestCapturedLocalVariables(JvmTypeReference toBeWrapped, JvmDeclaredType type, ResolvedTypes resolvedTypes, Map<JvmIdentifiableElement, ResolvedTypes> resolvedTypesByContext, IAcceptor<JvmTypeReference> result) {
		LocalVariableCapturerImpl capturer = new LocalVariableCapturerImpl(toBeWrapped, type, this, resolvedTypes, resolvedTypesByContext);
		XComputedTypeReference ref = getServices().getXtypeFactory().createXComputedTypeReference();
		ref.setTypeProvider(capturer);
		result.accept(ref);
		capturer.awaitCapturing();
	}
}
