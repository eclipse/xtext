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
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.typing.ITypeProvider;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
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

	protected class DelegatingScope implements IScope {
		private IScope scope = IScope.NULLSCOPE;

		public void setScope(IScope scope) {
			this.scope = scope;
		}

		public IScope getOuterScope() {
			return scope.getOuterScope();
		}

		public Iterable<IEObjectDescription> getContents() {
			return scope.getContents();
		}

		public Iterable<IEObjectDescription> getAllContents() {
			return scope.getAllContents();
		}

		public IEObjectDescription getContentByName(String name) {
			return scope.getContentByName(name);
		}

		public IEObjectDescription getContentByEObject(EObject object) {
			return scope.getContentByEObject(object);
		}

		public Iterable<IEObjectDescription> getAllContentsByEObject(EObject object) {
			return scope.getAllContentsByEObject(object);
		}
	}

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
		if (context instanceof XMemberFeatureCall || context instanceof XBinaryOperation) {
			final XAbstractFeatureCall call = (XAbstractFeatureCall) context;
			XExpression target = call.getArguments().get(0);
			JvmTypeReference jvmTypeReference = typeResolver.getType(target, null, null);
			if (jvmTypeReference != null) {
				IScope parent = createFeatureScopeForTypeRef(jvmTypeReference,
						createCallableFeaturePredicate(call, null), IScope.NULLSCOPE);
				return parent;
			}
		}
		if (context instanceof XAbstractFeatureCall) {
			final XAbstractFeatureCall call = (XAbstractFeatureCall) context;
			DelegatingScope delegatingScope = new DelegatingScope();
			IScope localVariableScope = createLocalVarScope(context, reference,
					createCallableFeaturePredicate(call, null), delegatingScope);
			IEObjectDescription thisVariable = localVariableScope.getContentByName(THIS);
			if (thisVariable != null) {
				EObject thisVal = thisVariable.getEObjectOrProxy();
				JvmTypeReference type = typeResolver.getType(thisVal, null, ValidationMessageAcceptor.NULL);
				if (type != null) {
					IScope allFeatures = createFeatureScopeForTypeRef(type, createCallableFeaturePredicate(call, type),
							IScope.NULLSCOPE);
					delegatingScope.setScope(allFeatures);
				}
			}
			return localVariableScope;
		}
		return IScope.NULLSCOPE;
	}

	protected Predicate<EObject> createCallableFeaturePredicate(final XAbstractFeatureCall call,
			final JvmTypeReference thisVar) {
		return new Predicate<EObject>() {
			public boolean apply(EObject input) {
				return featurePredicate.accept(input, call, thisVar);
			}
		};
	}

	protected IScope createLocalVarScope(EObject context, EReference reference, Predicate<EObject> featurePredicate,
			IScope parentScope) {
		if (context == null)
			return parentScope;
		parentScope = createLocalVarScope(context.eContainer(), reference, featurePredicate, parentScope);
		if (context.eContainer() instanceof XBlockExpression) {
			XBlockExpression block = (XBlockExpression) context.eContainer();
			parentScope = createLocalVarScopeForBlock(block, block.getExpressions().indexOf(context), featurePredicate,
					parentScope);
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
