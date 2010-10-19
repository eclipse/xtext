/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.scoping.impl.SingletonScope;
import org.eclipse.xtext.typing.ITypeProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseScopeProvider extends XtypeScopeProvider {

	public static final String THIS = "this";

	@Inject
	private OperatorMapping operatorMapping;

	@Inject
	private ITypeProvider<JvmTypeReference> typeResolver;

	@Inject
	private CallableFeaturePredicate featurePredicate;

	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (isFeatureCallScope(reference)) {
			return createFeatureCallScope(context, reference);
		}
		return super.getScope(context, reference);
	}

	protected boolean isFeatureCallScope(EReference reference) {
		return reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
	}

	protected IScope createFeatureCallScope(EObject context, EReference reference) {
		if (context instanceof XAssignment) {
			return createAssignmentFeatureScope((XAssignment)context);
		}
		if (context instanceof XMemberFeatureCall || context instanceof XBinaryOperation) {
			final XAbstractFeatureCall call = (XAbstractFeatureCall) context;
			XExpression target = call.getArguments().get(0);
			JvmTypeReference jvmTypeReference = typeResolver.getType(target, null);
			if (jvmTypeReference != null) {
				IScope parent = createFeatureScopeForTypeRef(jvmTypeReference,
						createCallableFeaturePredicate(call, null), IScope.NULLSCOPE);
				return parent;
			}
		}
		if (context instanceof XAbstractFeatureCall) {
			final XAbstractFeatureCall call = (XAbstractFeatureCall) context;
			
			Predicate<EObject> featurePredicate = createCallableFeaturePredicate(call, null);
			IScope parentScope = createLocalVarScope(context.eContainer(), reference, featurePredicate);
			Map<String, IEObjectDescription> implicitThisScope = Maps.newHashMap();
			IScope localVariableScope = createLocalVarScope(context, reference, featurePredicate, new MapBasedScope(
					parentScope, implicitThisScope));
			IEObjectDescription thisVariable = localVariableScope.getContentByName(THIS);

			if (thisVariable != null) {
				EObject thisVal = thisVariable.getEObjectOrProxy();
				JvmTypeReference type = typeResolver.getType(thisVal, null);
				if (type != null) {
					IScope allFeatures = createFeatureScopeForTypeRef(type, createCallableFeaturePredicate(call, type),
							IScope.NULLSCOPE);
					implicitThisScope.putAll(Scopes.scopeToMap(allFeatures));
				}
			}
			return localVariableScope;
		}
		return IScope.NULLSCOPE;
	}

	protected IScope createAssignmentFeatureScope(XAssignment context) {
		XExpression assignable = context.getAssignable();
		JvmTypeReference jvmTypeReference = typeResolver.getType(assignable, null);
		IScope parent = IScope.NULLSCOPE;
		if (jvmTypeReference != null) {
			parent = createFeatureScopeForTypeRef(jvmTypeReference,
					createCallableFeaturePredicate(context, null), IScope.NULLSCOPE);
		}
		if (assignable instanceof XFeatureCall) {
			XFeatureCall featureCall = (XFeatureCall) assignable;
			if (featureCall.getFeature() instanceof XVariableDeclaration)
				return new SingletonScope(EObjectDescription.create("=", featureCall.getFeature()), parent);
			if (featureCall.getFeature() instanceof JvmFormalParameter)
				return new SingletonScope(EObjectDescription.create("=", featureCall.getFeature()), parent);
		}
		return parent;
		
	}

	protected Predicate<EObject> createCallableFeaturePredicate(final XAbstractFeatureCall call,
			final JvmTypeReference thisVar) {
		return new Predicate<EObject>() {
			public boolean apply(EObject input) {
				return featurePredicate.accept(input, call, thisVar);
			}
		};
	}

	protected IScope createLocalVarScope(EObject context, EReference reference, Predicate<EObject> featurePredicate) {
		if (context.eContainer()==null)
			return createLocalVarScope(context, reference, featurePredicate, IScope.NULLSCOPE);
		return createLocalVarScope(context, reference, featurePredicate, createLocalVarScope(context.eContainer(), reference, featurePredicate));
	}
		
	protected IScope createLocalVarScope(EObject context, EReference reference, Predicate<EObject> featurePredicate,
				IScope parentScope) {
		if (context == null)
			return parentScope;
		if (context.eContainer() instanceof XBlockExpression) {
			XBlockExpression block = (XBlockExpression) context.eContainer();
			parentScope = createLocalVarScopeForBlock(block, block.getExpressions().indexOf(context), featurePredicate,
					parentScope);
		}
		if (context.eContainer() instanceof XForLoopExpression) {
			XForLoopExpression loop = (XForLoopExpression) context.eContainer();
			parentScope = new SingletonScope(EObjectDescription.create(loop.getDeclaredParam().getName(), loop.getDeclaredParam()), parentScope);
		}
		if (context instanceof XClosure) {
			parentScope = createLocalVarScopeForClosure((XClosure) context, featurePredicate, parentScope);
		}
		return parentScope;
	}

	protected IScope createLocalVarScopeForBlock(XBlockExpression block, int indexOfContextExpressionInBlock,
			Predicate<EObject> featurePredicate, IScope parentScope) {
		Map<String, IEObjectDescription> vars = Maps.newHashMap();
		for (int i = 0; i < indexOfContextExpressionInBlock; i++) {
			XExpression expression = block.getExpressions().get(i);
			if (expression instanceof XVariableDeclaration) {
				XVariableDeclaration varDecl = (XVariableDeclaration) expression;
				if (featurePredicate.apply(varDecl)) {
					EObjectDescription desc = createEObjectDescription(varDecl);
					vars.put(desc.getName(), desc);
				}
			}
		}
		if (vars.isEmpty())
			return parentScope;
		return new MapBasedScope(parentScope, vars);
	}

	protected IScope createLocalVarScopeForClosure(XClosure closure, Predicate<EObject> featurePredicate,
			IScope parentScope) {
		EList<JvmFormalParameter> params = closure.getFormalParameters();
		Map<String, IEObjectDescription> descriptions = Maps.newHashMap();
		for (JvmFormalParameter p : params) {
			if (featurePredicate.apply(p)) {
				EObjectDescription desc = createEObjectDescription(p);
				descriptions.put(desc.getName(), desc);
			}
		}
		return new MapBasedScope(parentScope, descriptions);
	}

	protected IScope createFeatureScopeForTypeRef(JvmTypeReference jvmTypeRef, Predicate<EObject> featurePredicate,
			IScope parent) {
		if (jvmTypeRef.getType() instanceof JvmDeclaredType) {
			JvmDeclaredType declType = (JvmDeclaredType) jvmTypeRef.getType();
			//TODO don't use scopes to shadow overridden methods, but use a 
			// to be written service, which does something like 
			EList<JvmTypeReference> types = declType.getSuperTypes();
			for (JvmTypeReference jvmTypeReference : types) {
				parent = createFeatureScopeForTypeRef(jvmTypeReference, featurePredicate, parent);
			}
		}
		HashMap<String, IEObjectDescription> map = createFeatureMap(jvmTypeRef, featurePredicate);
		return new MapBasedScope(parent, map);
	}

	protected HashMap<String, IEObjectDescription> createFeatureMap(JvmTypeReference jvmTypeRef,
			Predicate<EObject> featurePredicate) {
		HashMap<String, IEObjectDescription> map = Maps.newHashMap();
		if (jvmTypeRef.getType() instanceof JvmGenericType) {
			JvmGenericType genType = (JvmGenericType) jvmTypeRef.getType();
			List<JvmFeature> features = EcoreUtil2.typeSelect(genType.getMembers(), JvmFeature.class);
			for (JvmFeature jvmFeature : features) {
				if (featurePredicate.apply(jvmFeature)) {
					IEObjectDescription desc = createEObjectDescription(jvmFeature);
					map.put(desc.getName(), desc);
					String operator = operatorMapping.getOperator(desc.getName());
					if (operator != null) {
						AliasedEObjectDescription description = new AliasedEObjectDescription(operator, desc);
						map.put(description.getName(), description);
					}
				}
			}
		}
		return map;
	}

	protected EObjectDescription createEObjectDescription(JvmFormalParameter p) {
		return new EObjectDescription(p.getName(), p, Collections.<String, String> emptyMap());
	}

	protected IEObjectDescription createEObjectDescription(JvmFeature jvmFeature) {
		return new EObjectDescription(jvmFeature.getSimpleName(), jvmFeature, null);
	}

	protected EObjectDescription createEObjectDescription(XVariableDeclaration varDecl) {
		return new EObjectDescription(varDecl.getName(), varDecl, Collections.<String, String> emptyMap());
	}
}
