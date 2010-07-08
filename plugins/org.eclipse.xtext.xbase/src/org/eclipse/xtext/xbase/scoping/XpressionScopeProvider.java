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
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.xbase.XFunction;
import org.eclipse.xtext.xbase.typing.ExpressionsTypeResolver;
import org.eclipse.xtext.xbase.typing.OperatorMapping;
import org.eclipse.xtext.xpression.XBlockExpression;
import org.eclipse.xtext.xpression.XClosure;
import org.eclipse.xtext.xpression.XExpression;
import org.eclipse.xtext.xpression.XFeatureCall;
import org.eclipse.xtext.xpression.XMemberFeatureCall;
import org.eclipse.xtext.xpression.XVariableDeclaration;
import org.eclipse.xtext.xpression.XpressionPackage;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XpressionScopeProvider extends XtypeScopeProvider {

	@Inject
	private OperatorMapping operatorMapping;

	@Inject
	private ExpressionsTypeResolver typeResolver;

	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (isFeatureScope(reference)) {
			return getFeatureScope(context, reference);
		}
		return super.getScope(context, reference);
	}

	protected boolean isFeatureScope(EReference reference) {
		return reference == XpressionPackage.Literals.XFEATURE_CALL__FEATURE;
	}

	protected IScope getFeatureScope(EObject context, EReference reference) {
		if (context instanceof XMemberFeatureCall) {
			final XMemberFeatureCall call = (XMemberFeatureCall) context;
			XExpression target = call.getParams().get(0);
			JvmTypeReference jvmTypeReference = typeResolver.doSwitch(target, null);
			IScope parent = getAllFeatures(jvmTypeReference.getType(), IScope.NULLSCOPE, createCallableFeaturePredicate(call));
			return parent;
		}
		if (context instanceof XFeatureCall) {
			final XFeatureCall call = (XFeatureCall) context;
			return getLocalVariableScope(context, reference, createCallableFeaturePredicate(call));
		}
		return IScope.NULLSCOPE;
	}

	protected Predicate<EObject> createCallableFeaturePredicate(final XFeatureCall call) {
		return new Predicate<EObject>() {
			public boolean apply(EObject input) {
				if (input instanceof JvmField && call.getParams().size() > 1)
					return false;
				if (input instanceof XFunction) {
					if (call.getParams().size() != ((JvmOperation) input).getParameters().size())
						return false;
				} else if (input instanceof JvmOperation) {
					if (call.getParams().size() - 1 != ((JvmOperation) input).getParameters().size())
						return false;
				}
				return true;
			}
		};
	}

	protected IScope getLocalVariableScope(EObject context, EReference reference, Predicate<EObject> featurePredicate) {
		if (context == null)
			return IScope.NULLSCOPE;
		IScope parentScope = getLocalVariableScope(context.eContainer(), reference, featurePredicate);
		if (context.eContainer() instanceof XBlockExpression) {
			XBlockExpression block = (XBlockExpression) context.eContainer();
			parentScope = localVarScopeForBlock(parentScope, block, block.getExpressions().indexOf(context),
					featurePredicate);
		}
		if (context instanceof XClosure) {
			parentScope = localVarScopeForClosure(parentScope, (XClosure) context, featurePredicate);
		}
		return parentScope;
	}

	protected IScope localVarScopeForBlock(IScope parentScope, XBlockExpression block,
			int indexOfContextExpressionInBlock, Predicate<EObject> featurePredicate) {
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

	protected EObjectDescription createEObjectDescription(XVariableDeclaration varDecl) {
		return new EObjectDescription(varDecl.getName(), varDecl, Collections.<String, String> emptyMap());
	}

	protected IScope localVarScopeForClosure(IScope parentScope, XClosure closure, Predicate<EObject> featurePredicate) {
		EList<JvmFormalParameter> params = closure.getParams();
		Map<String, IEObjectDescription> descriptions = Maps.newHashMap();
		for (JvmFormalParameter p : params) {
			if (featurePredicate.apply(p)) {
				EObjectDescription desc = createEObjectDescription(p);
				descriptions.put(desc.getName(), desc);
			}
		}
		return new MapBasedScope(parentScope, descriptions);
	}

	protected EObjectDescription createEObjectDescription(JvmFormalParameter p) {
		return new EObjectDescription(p.getName(), p, Collections.<String, String> emptyMap());
	}

	protected IScope getAllFeatures(JvmType type, IScope parent, Predicate<EObject> featurePredicate) {
		if (type instanceof JvmDeclaredType) {
			JvmDeclaredType declType = (JvmDeclaredType) type;
			EList<JvmTypeReference> types = declType.getSuperTypes();
			for (JvmTypeReference jvmTypeReference : types) {
				parent = getAllFeatures(jvmTypeReference.getType(), parent, featurePredicate);
			}
		}
		HashMap<String, IEObjectDescription> map = createFeatureMap(type, featurePredicate);
		return new MapBasedScope(parent, map);
	}

	protected HashMap<String, IEObjectDescription> createFeatureMap(JvmType jvmType, Predicate<EObject> featurePredicate) {
		HashMap<String, IEObjectDescription> map = Maps.newHashMap();
		if (jvmType instanceof JvmGenericType) {
			JvmGenericType genType = (JvmGenericType) jvmType;
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

	protected IEObjectDescription createEObjectDescription(JvmFeature jvmFeature) {
		return new EObjectDescription(jvmFeature.getSimpleName(), jvmFeature, null);
	}
}
