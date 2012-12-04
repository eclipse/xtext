/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.typesystem;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtend.core.jvmmodel.DispatchUtil;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.InferredTypeIndicator;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputer;
import org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.OperationBodyComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.StackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.AbstractReentrantTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * The customized reentrant type resolver is responsible for proper typing
 * of dispatch methods' return type and parameter types as well as adding
 * extension fields to the scope. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class DispatchAndExtensionAwareReentrantTypeResolver extends LogicalContainerAwareReentrantTypeResolver {

	public class DispatchReturnTypeReferenceProvider extends AbstractReentrantTypeReferenceProvider {
		private final JvmOperation operation;
		private final ResolvedTypes resolvedTypes;
		private final IFeatureScopeSession session;

		public DispatchReturnTypeReferenceProvider(JvmOperation operation, ResolvedTypes resolvedTypes, IFeatureScopeSession session) {
			this.operation = operation;
			this.resolvedTypes = resolvedTypes;
			this.session = session;
		}

		@Override
		@Nullable
		protected JvmTypeReference doGetTypeReference(XComputedTypeReferenceImplCustom context) {
			LightweightTypeReference expectedType = getReturnTypeOfOverriddenOperation(operation, resolvedTypes, session);
			if (expectedType != null) {
				return expectedType.toJavaCompliantTypeReference();
			}
			
			List<JvmOperation> cases = dispatchUtil.getDispatchCases(operation);
			List<LightweightTypeReference> types = Lists.newArrayListWithCapacity(cases.size());
			for(JvmOperation operation: cases) {
				LightweightTypeReference caseType = resolvedTypes.getActualType(operation);
				types.add(caseType);
			}
			TypeConformanceComputer conformanceComputer = getServices().getTypeConformanceComputer();
			LightweightTypeReference result = conformanceComputer.getCommonSuperType(types);
			if (result == null)
				return null;
			return result.toJavaCompliantTypeReference();
		}
	}
	
	public class DispatchParameterTypeReferenceProvider extends AbstractReentrantTypeReferenceProvider {
		private final JvmOperation operation;
		private final ResolvedTypes resolvedTypes;
		private final int idx;

		public DispatchParameterTypeReferenceProvider(JvmOperation operation, int idx, ResolvedTypes resolvedTypes) {
			this.idx = idx;
			this.operation = operation;
			this.resolvedTypes = resolvedTypes;
		}

		@Override
		@Nullable
		protected JvmTypeReference doGetTypeReference(XComputedTypeReferenceImplCustom context) {
			// TODO type parameters on dispatch operations
			List<JvmOperation> cases = dispatchUtil.getDispatchCases(operation);
			TypeConformanceComputer conformanceComputer = getServices().getTypeConformanceComputer();
			List<LightweightTypeReference> parameterTypes = Lists.newArrayListWithCapacity(cases.size());
			for(JvmOperation caseOperation: cases) {
				JvmFormalParameter parameter = caseOperation.getParameters().get(idx);
				LightweightTypeReference parameterType = resolvedTypes.getActualType(parameter);
				parameterTypes.add(parameterType);
			}
			LightweightTypeReference parameterType = conformanceComputer.getCommonSuperType(parameterTypes);
			if (parameterType == null) {
				throw new IllegalStateException("TODO: handle broken models properly");
			}
			return parameterType.toJavaCompliantTypeReference();
		}
	}
	
	@Inject
	private DispatchUtil dispatchUtil;
	
	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private XbaseFactory xbaseFactory;
	
	@Override
	protected void _computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession,
			JvmOperation operation) {
		if (dispatchUtil.isDispatcherFunction(operation)) {
			// TODO an inherited declared type should influence the expectation of the cases
			
			// no associated expression, we just resolve it to the common super type of all associated cases
			// see #createTypeProvider and #_doPrepare
			computeAnnotationTypes(resolvedTypes, featureScopeSession, operation);
		} else if (dispatchUtil.isDispatchFunction(operation) && InferredTypeIndicator.isInferred(operation.getReturnType())) {
			JvmOperation dispatcher = dispatchUtil.getDispatcherOperation(operation);
			LightweightTypeReference declaredDispatcherType = null;
			if (dispatcher != null) {
				declaredDispatcherType = getReturnTypeOfOverriddenOperation(dispatcher, resolvedTypes, featureScopeSession);
			}
			List<JvmOperation> dispatchCases = dispatchUtil.getDispatchCases(dispatcher);
			List<LightweightTypeReference> dispatchCaseResults = Lists.newArrayListWithCapacity(dispatchCases.size());
			boolean hasInferredCase = false;
			for(JvmOperation dispatchCase: dispatchCases) {
				OperationBodyComputationState state = new DispatchOperationBodyComputationState(resolvedTypes, featureScopeSession, dispatchCase, dispatcher, this);
				ITypeComputationResult dispatchCaseResult = state.computeTypes();
				if (InferredTypeIndicator.isInferred(dispatchCase.getReturnType())) {
					if (declaredDispatcherType == null) {
						dispatchCaseResults.add(dispatchCaseResult.getReturnType());
					}
					hasInferredCase = true;
				} else {
					dispatchCaseResults.add(resolvedTypes.getActualType(dispatchCase));
				}
				computeAnnotationTypes(resolvedTypes, featureScopeSession, operation);
			}
			if (hasInferredCase) {
				LightweightTypeReference commonDispatchType = declaredDispatcherType != null ? declaredDispatcherType : getServices().getTypeConformanceComputer().getCommonSuperType(dispatchCaseResults);
				if (commonDispatchType != null) {
					for(JvmOperation dispatchCase: dispatchCases) {
						JvmTypeReference returnType = dispatchCase.getReturnType();
						if (InferredTypeIndicator.isInferred(returnType)) {
							InferredTypeIndicator.resolveTo(returnType, commonDispatchType.toJavaCompliantTypeReference());
						}
					}
				}
			}
		} else {
			super._computeTypes(resolvedTypes, featureScopeSession, operation);
		}
	}
	
	@Override
	protected void computeMemberTypes(StackedResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession,
			JvmDeclaredType type) {
		IFeatureScopeSession childSession = addExtensionsToMemberSession(resolvedTypes, featureScopeSession, type);
		super.computeMemberTypes(resolvedTypes, childSession, type);
	}
	
	@Override
	protected void prepareMembers(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmDeclaredType type) {
		IFeatureScopeSession childSession = addExtensionsToMemberSession(resolvedTypes, featureScopeSession, type);
		super.prepareMembers(resolvedTypes, childSession, type);
	}

	protected IFeatureScopeSession addExtensionsToMemberSession(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession, JvmDeclaredType type) {
		Iterable<JvmField> fields = type.getDeclaredFields();
		IEObjectDescription thisDescription = featureScopeSession.getLocalElement(IFeatureNames.THIS);
		if (thisDescription == null) {
			throw new IllegalStateException("Cannot find feature 'THIS'");
		}
		JvmIdentifiableElement thisFeature = (JvmIdentifiableElement) thisDescription.getEObjectOrProxy();
		Map<XExpression, LightweightTypeReference> extensionProviders = null;
		for(JvmField field: fields) {
			if (isExtensionField(field)) {
				if (extensionProviders == null)
					extensionProviders = Maps.newHashMapWithExpectedSize(3);
				XMemberFeatureCall extensionProvider = createExtensionProvider(thisFeature, field);
				LightweightTypeReference fieldType = resolvedTypes.getActualType(field);
				extensionProviders.put(extensionProvider, fieldType);
			}
		}
		IFeatureScopeSession childSession = featureScopeSession;
		if (extensionProviders != null) {
			childSession = featureScopeSession.addToExtensionScope(extensionProviders);
		}
		XFeatureCall thisAccess = xbaseFactory.createXFeatureCall();
		thisAccess.setFeature(thisFeature);
		LightweightTypeReference thisType = resolvedTypes.getActualType(thisFeature);
		childSession = childSession.addToExtensionScope(Collections.<XExpression, LightweightTypeReference>singletonMap(thisAccess, thisType));
		return childSession;
	}

	protected XMemberFeatureCall createExtensionProvider(JvmIdentifiableElement thisFeature, JvmField field) {
		XMemberFeatureCall extensionProvider = xbaseFactory.createXMemberFeatureCall();
		extensionProvider.setFeature(field);
		XFeatureCall thisAccess = xbaseFactory.createXFeatureCall();
		thisAccess.setFeature(thisFeature);
		extensionProvider.setMemberCallTarget(thisAccess);
		return extensionProvider;
	}
	
	protected boolean isExtensionField(JvmField field) {
		XtendField xtendField = associations.getXtendField(field);
		return xtendField != null && xtendField.isExtension();
	}
	
	@Override
	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession,
			JvmOperation operation) {
		if (dispatchUtil.isDispatcherFunction(operation)) {
			List<JvmFormalParameter> parameters = operation.getParameters();
			for(int i = 0; i < parameters.size(); i++) {
				JvmFormalParameter parameter = parameters.get(i);
				JvmTypeReference parameterType = parameter.getParameterType();
				if (InferredTypeIndicator.isInferred(parameterType)) {
					XComputedTypeReference casted = (XComputedTypeReference) parameterType;
					XComputedTypeReference computedParameterType = getServices().getXtypeFactory().createXComputedTypeReference();
					computedParameterType.setTypeProvider(new DispatchParameterTypeReferenceProvider(operation, i, resolvedTypes));
					casted.setEquivalent(computedParameterType);
				} else if (parameterType == null) {
					XComputedTypeReference computedParameterType = getServices().getXtypeFactory().createXComputedTypeReference();
					computedParameterType.setTypeProvider(new DispatchParameterTypeReferenceProvider(operation, i, resolvedTypes));
					parameter.setParameterType(computedParameterType);
				}
			}
		}
		super._doPrepare(resolvedTypes, featureScopeSession, operation);
	}
	
	@Override
	protected AbstractReentrantTypeReferenceProvider createTypeProvider(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmMember member,
			boolean returnType) {
		if (member instanceof JvmOperation) {
			JvmOperation operation = (JvmOperation) member;
			if (dispatchUtil.isDispatcherFunction(operation)) {
				return new DispatchReturnTypeReferenceProvider(operation, resolvedTypes, featureScopeSession);
			}
		}
		return super.createTypeProvider(resolvedTypes, featureScopeSession, member, returnType);
	}

	protected DispatchUtil getDispatchUtil() {
		return dispatchUtil;
	}
	
}
