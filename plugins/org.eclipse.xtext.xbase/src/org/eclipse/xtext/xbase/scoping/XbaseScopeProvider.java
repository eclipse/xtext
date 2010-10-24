/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.typing.ITypeProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.newapi.CompositeScope;
import org.eclipse.xtext.xbase.scoping.newapi.DelegatingScope;
import org.eclipse.xtext.xbase.scoping.newapi.INewScope;
import org.eclipse.xtext.xbase.scoping.newapi.ISelector;
import org.eclipse.xtext.xbase.scoping.newapi.MapBasedScope;
import org.eclipse.xtext.xbase.scoping.newapi.NewToOldAdapter;
import org.eclipse.xtext.xbase.scoping.newapi.Selectors;
import org.eclipse.xtext.xbase.scoping.newapi.SingletonScope;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseScopeProvider extends XtypeScopeProvider {

	public static final QualifiedName THIS = QualifiedName.create("this");
	public static final QualifiedName EQUALS = QualifiedName.create("=");

	@Inject
	private OperatorMapping operatorMapping;

	@Inject
	private ITypeProvider<JvmTypeReference> typeResolver;

	@Inject
	private CallableFeaturePredicate featurePredicate;

	@Inject
	private TypeArgumentContext.Provider provider;
	
	@Inject
	private IJvmTypeConformanceComputer conformanceChecker;

	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (isFeatureCallScope(reference)) {
			BestMatchingJvmFeatureScope featureScope = new BestMatchingJvmFeatureScope(conformanceChecker, context, reference, createFeatureCallScope(context, reference));
			return new NewToOldAdapter(featureScope, getSelector(context, reference));
		}
		return super.getScope(context, reference);
	}

	protected boolean isFeatureCallScope(EReference reference) {
		return reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
	}

	protected INewScope createFeatureCallScope(EObject context, EReference reference) {
		if (context instanceof XAssignment) {
			return createAssignmentFeatureScope((XAssignment) context);
		}
		if (context instanceof XMemberFeatureCall || context instanceof XBinaryOperation) {
			final XAbstractFeatureCall call = (XAbstractFeatureCall) context;
			if (call.getArguments().isEmpty())
				return INewScope.NULL_SCOPE;
			XExpression target = call.getArguments().get(0);
			JvmTypeReference jvmTypeReference = typeResolver.getType(target, null);
			if (jvmTypeReference != null) {
				return createFeatureScopeForTypeRef(jvmTypeReference, INewScope.NULL_SCOPE, publicOnly);
			}
		}
		if (context instanceof XAbstractFeatureCall) {

			DelegatingScope implicitThis = new DelegatingScope();
			INewScope localVariableScope = createLocalVarScope(context, reference, implicitThis);
			IEObjectDescription thisVariable = localVariableScope.getSingleElement(Selectors.byName(THIS));

			if (thisVariable != null) {
				EObject thisVal = thisVariable.getEObjectOrProxy();
				JvmTypeReference type = typeResolver.getType(thisVal, null);
				if (type != null) {
					implicitThis.setDelegate(createFeatureScopeForTypeRef(type, INewScope.NULL_SCOPE, publicOnly));
				}
			}
			return localVariableScope;
		}
		return INewScope.NULL_SCOPE;
	}

	protected ISelector getSelector(final EObject context, final EReference reference) {
		return new ISelector() {
			public boolean apply(IEObjectDescription input) {
				TypeArgumentContext ctx = null;
				if (input instanceof JvmFeatureDescription) {
					ctx = ((JvmFeatureDescription) input).getContext();
				}
				return featurePredicate.accept(input.getEObjectOrProxy(), context, reference, ctx);
			}
		};
	}
	
	protected Predicate<JvmMember> publicOnly = new Predicate<JvmMember>() {

		public boolean apply(JvmMember input) {
			return input.getVisibility() == JvmVisibility.PUBLIC;
		}
	}; 

	protected INewScope createAssignmentFeatureScope(XAssignment context) {
		XExpression assignable = context.getAssignable();
		JvmTypeReference jvmTypeReference = typeResolver.getType(assignable, null);
		INewScope parent = INewScope.NULL_SCOPE;
		if (jvmTypeReference != null) {
			parent = createFeatureScopeForTypeRef(jvmTypeReference, parent, publicOnly);
		}
		if (assignable instanceof XFeatureCall) {
			XFeatureCall featureCall = (XFeatureCall) assignable;
			if (featureCall.getFeature() instanceof XVariableDeclaration)
				return new SingletonScope(EObjectDescription.create(EQUALS, featureCall.getFeature()), parent);
			if (featureCall.getFeature() instanceof JvmFormalParameter)
				return new SingletonScope(EObjectDescription.create(EQUALS, featureCall.getFeature()), parent);
			if (featureCall.getFeature() instanceof JvmField) {
				if (!((JvmField) featureCall.getFeature()).isFinal())
					return new SingletonScope(EObjectDescription.create(EQUALS, featureCall.getFeature()), parent);
			}
		}
		if (assignable instanceof XMemberFeatureCall) {
			XMemberFeatureCall featureCall = (XMemberFeatureCall) assignable;
			if (featureCall.getFeature() instanceof JvmField) {
				if (!((JvmField) featureCall.getFeature()).isFinal())
					return new SingletonScope(EObjectDescription.create(EQUALS, featureCall.getFeature()), parent);
			}
		}
		return parent;

	}

	protected INewScope createLocalVarScope(EObject context, EReference reference, INewScope parentScope) {
		if (context == null)
			return parentScope;
		if (context.eContainer() != null)
			parentScope = createLocalVarScope(context.eContainer(), reference, parentScope);
		if (context.eContainer() instanceof XBlockExpression) {
			XBlockExpression block = (XBlockExpression) context.eContainer();
			parentScope = createLocalVarScopeForBlock(block, block.getExpressions().indexOf(context), parentScope);
		}
		if (context.eContainer() instanceof XForLoopExpression) {
			XForLoopExpression loop = (XForLoopExpression) context.eContainer();

			parentScope = new SingletonScope(createEObjectDescription(loop.getDeclaredParam()), parentScope);
		}
		if (context.eContainer() instanceof XCatchClause) {
			XCatchClause catchClause = (XCatchClause) context.eContainer();
			parentScope = new SingletonScope(createEObjectDescription(catchClause.getDeclaredParam()), parentScope);

		}
		if (context instanceof XClosure) {
			parentScope = createLocalVarScopeForClosure((XClosure) context, parentScope);
		}
		return parentScope;
	}

	protected INewScope createLocalVarScopeForCatchClause(XCatchClause catchClause, int indexOfContextExpressionInBlock,
			INewScope parentScope) {
		return new SingletonScope(createEObjectDescription(catchClause.getDeclaredParam()), parentScope);
	}
	protected INewScope createLocalVarScopeForBlock(XBlockExpression block, int indexOfContextExpressionInBlock,
			INewScope parentScope) {
		Map<QualifiedName, IEObjectDescription> vars = Maps.newHashMap();
		
		for (int i = 0; i < indexOfContextExpressionInBlock; i++) {
			XExpression expression = block.getExpressions().get(i);
			if (expression instanceof XVariableDeclaration) {
				XVariableDeclaration varDecl = (XVariableDeclaration) expression;
				IEObjectDescription desc = createEObjectDescription(varDecl);
				vars.put(desc.getName(), desc);
				
			}
		}
		if (vars.isEmpty())
			return parentScope;
		return new MapBasedScope(vars, parentScope);
	}

	protected INewScope createLocalVarScopeForClosure(XClosure closure, INewScope parentScope) {
		EList<JvmFormalParameter> params = closure.getFormalParameters();
		Map<QualifiedName, IEObjectDescription> descriptions = Maps.newHashMap();
		for (JvmFormalParameter p : params) {
			IEObjectDescription desc = createEObjectDescription(p);
			descriptions.put(desc.getName(), desc);

		}
		return new MapBasedScope(descriptions, parentScope);
	}

	protected INewScope createFeatureScopeForTypeRef(JvmTypeReference type, INewScope parent, Predicate<JvmMember> isAccept) {
		if (type.getType() instanceof JvmDeclaredType) {
			TypeArgumentContext context = provider.get(type);
			return createFeatureScopeForTypeRef(type,
					parent, isAccept,
					context);
		}
		//TODO handle JvmTypeParameter
//		if (type.getType() instanceof JvmTypeParameter) {
//			TypeArgumentContext context = provider.get(type);
//			
//			return createFeatureScopeForTypeRefs(((JvmTypeParameter) type.getType()).getSuperTypes(), parent, context);
//		}
		return parent;
	}

	protected INewScope createFeatureScopeForTypeRefs(EList<JvmTypeReference> superTypes, INewScope parent, Predicate<JvmMember> isAccept,
			TypeArgumentContext context) {
		if (superTypes.isEmpty())
			return parent;
		if (superTypes.size()==1)
			return createFeatureScopeForTypeRef(superTypes.get(0), parent, isAccept, context);
		List<INewScope> scopes = newArrayList();
		boolean firstIteration = true;
		for (JvmTypeReference typeRef : superTypes) {
			scopes.add(createFeatureScopeForTypeRef(typeRef, firstIteration ? parent : INewScope.NULL_SCOPE, isAccept, context));
			firstIteration = false;
		}
		return new CompositeScope(scopes);
	}

	protected INewScope createFeatureScopeForTypeRef(JvmTypeReference jvmTypeRef, INewScope parent, Predicate<JvmMember> isAccept,
			TypeArgumentContext context) {
		if (jvmTypeRef.getType() instanceof JvmDeclaredType) {
			EList<JvmTypeReference> superTypes2 = ((JvmDeclaredType) jvmTypeRef.getType()).getSuperTypes();
			parent = createFeatureScopeForTypeRefs(superTypes2, parent, isAccept, context);
			JvmDeclaredType declType = (JvmDeclaredType) jvmTypeRef.getType();
			INewScope scopeForMethods = createScopeForMethods(declType, parent, isAccept, context);
			return createScopeForField(declType,scopeForMethods,isAccept,context);
		}
		return INewScope.NULL_SCOPE;
	}

	protected INewScope createScopeForField(JvmDeclaredType declType, INewScope parent,
			Predicate<JvmMember> isAccept, final TypeArgumentContext context) {
		Iterable<JvmField> operations = filter(filter(declType.getMembers(),JvmField.class),isAccept);
		if (!operations.iterator().hasNext())
			return parent;
		Iterable<IEObjectDescription> descriptions = transform(operations,
				new Function<JvmField, IEObjectDescription>() {
					public IEObjectDescription apply(JvmField from) {
						return createEObjectDescription(from, context, from.getSimpleName());
					}
				});
		return new JvmFeatureDescriptionContainingScope(descriptions, parent);
	}

	protected INewScope createScopeForMethods(JvmDeclaredType declType, INewScope parent, Predicate<JvmMember> isAccept,
			final TypeArgumentContext context) {
		final JvmFeatureShadowingIndexObjectProvider stringProvider = new JvmFeatureShadowingIndexObjectProvider(
				context);
		Iterable<JvmOperation> operations = filter(filter(declType.getMembers(),JvmOperation.class),isAccept);
		if (!operations.iterator().hasNext())
			return parent;
		Iterable<IEObjectDescription> descriptions = transform(operations,
				new Function<JvmOperation, IEObjectDescription>() {
					public IEObjectDescription apply(JvmOperation from) {
						return createEObjectDescription(from, context,stringProvider.apply(from));
					}
				});
		return new JvmFeatureDescriptionContainingScope(concat(descriptions, getOperatorSugar(operations, context)), parent);
	}

	protected Iterable<? extends IEObjectDescription> getOperatorSugar(Iterable<JvmOperation> operations, final TypeArgumentContext context) {
		final JvmFeatureShadowingIndexObjectProvider stringProvider = new JvmFeatureShadowingIndexObjectProvider(
				context);
		return Iterables.filter(
				Iterables.transform(operations, new Function<JvmOperation, IEObjectDescription>() {
					public IEObjectDescription apply(JvmOperation operation) {
						QualifiedName operator = operatorMapping.getOperator(QualifiedName.create(operation.getSimpleName()));
						if (operator != null) {
							return createEObjectDescription(operator, operation, context, operator+stringProvider.apply(operation));
						}
						if (operation.getParameters().isEmpty()) {
							return createEObjectDescription(operation, context, operation.getSimpleName());
						}
						return null;
					}
				}), Predicates.notNull());
	}

	protected IEObjectDescription createEObjectDescription(JvmFormalParameter p) {
		return EObjectDescription.create(QualifiedName.create(p.getName()), p);
	}

	protected IEObjectDescription createEObjectDescription(JvmFeature jvmFeature, TypeArgumentContext ctx, String shadowingString) {
		return createEObjectDescription(QualifiedName.create(jvmFeature.getSimpleName()),jvmFeature,ctx,shadowingString);
	}
	protected IEObjectDescription createEObjectDescription(QualifiedName name, JvmFeature jvmFeature, TypeArgumentContext ctx, String shadowingString) {
		return new JvmFeatureDescription(name,jvmFeature,ctx,shadowingString);
	}

	protected IEObjectDescription createEObjectDescription(XVariableDeclaration varDecl) {
		return EObjectDescription.create(QualifiedName.create(varDecl.getName()), varDecl);
	}
}
