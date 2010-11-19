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
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.scoping.impl.SingletonScope;
import org.eclipse.xtext.typing.ITypeProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Strings;
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

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseScopeProvider extends XtypeScopeProvider {

	public static final QualifiedName THIS = QualifiedName.create("this");
	public static final QualifiedName ASSIGN = QualifiedName.create("=");
	public static final QualifiedName ADD = QualifiedName.create("+=");

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
			return new BestMatchingJvmFeatureScope(conformanceChecker, context,
					reference, createFeatureCallScope(context, reference),getSelector(context, reference));
		}
		return super.getScope(context, reference);
	}

	protected boolean isFeatureCallScope(EReference reference) {
		return reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
	}

	protected IScope createFeatureCallScope(EObject context, EReference reference) {
		if (context instanceof XAssignment) {
			return createAssignmentFeatureScope((XAssignment) context);
		}
		if (context instanceof XMemberFeatureCall || context instanceof XBinaryOperation) {
			final XAbstractFeatureCall call = (XAbstractFeatureCall) context;
			if (call.getArguments().isEmpty())
				return IScope.NULLSCOPE;
			XExpression target = call.getArguments().get(0);
			if (target != null) {
				JvmTypeReference jvmTypeReference = typeResolver.getType(target, null);
				if (jvmTypeReference != null) {
					return createFeatureScopeForTypeRef(jvmTypeReference, IScope.NULLSCOPE, publicOnly);
				}
			}
		}
		DelegatingScope implicitThis = new DelegatingScope();
		IScope localVariableScope = createLocalVarScope(context, reference, implicitThis);
		IEObjectDescription thisVariable = localVariableScope.getSingleElement(new ISelector.SelectByName(THIS));

		if (thisVariable != null) {
			EObject thisVal = thisVariable.getEObjectOrProxy();
			JvmTypeReference type = typeResolver.getType(thisVal, null);
			if (type != null) {
				implicitThis.setDelegate(createFeatureScopeForTypeRef(type, IScope.NULLSCOPE, publicOnly));
			}
		}
		return localVariableScope;
	}

	protected ISelector getSelector(final EObject context, final EReference reference) {
		return new ISelector() {
			public Iterable<IEObjectDescription> applySelector(Iterable<IEObjectDescription> elements) {
				return filter(elements, new Predicate<IEObjectDescription>() {
					public boolean apply(IEObjectDescription input) {
						TypeArgumentContext ctx = null;
						if (input instanceof JvmFeatureDescription) {
							ctx = ((JvmFeatureDescription) input).getContext();
						}
						return featurePredicate.accept(input.getEObjectOrProxy(), context, reference, ctx);
					}
				});
			}
		};
	}

	protected Predicate<JvmMember> publicOnly = new Predicate<JvmMember>() {

		public boolean apply(JvmMember input) {
			return input.getVisibility() == JvmVisibility.PUBLIC;
		}
	};

	protected IScope createAssignmentFeatureScope(XAssignment context) {
		XExpression assignable = context.getAssignable();
		List<IEObjectDescription> descriptions = Lists.newArrayList();
		IScope parent = IScope.NULLSCOPE;
		if (assignable instanceof XAbstractFeatureCall) {
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) assignable;
			if (featureCall.getFeature() instanceof XVariableDeclaration) {
				descriptions.add(EObjectDescription.create(getAssignmentOperator(context), featureCall.getFeature()));
			}
			if (featureCall.getFeature() instanceof JvmField) {
				if (!((JvmField) featureCall.getFeature()).isFinal())
					descriptions.add(EObjectDescription.create(getAssignmentOperator(context),
							featureCall.getFeature()));
			}
			if (featureCall.getFeature() instanceof JvmOperation) {
				JvmOperation operation = (JvmOperation) featureCall.getFeature();
				final String propertyName = getPropertyName(operation);
				if (propertyName != null) {
					EObject typedElement = null;
					if (featureCall instanceof XFeatureCall) {
						typedElement = getWhatsBoundToThis(featureCall);
					} else {
						typedElement = featureCall.getArguments().get(0);
					}
					JvmTypeReference typeReference = typeResolver.getType(typedElement, null);
					IScope scope = createFeatureScopeForTypeRef(typeReference, IScope.NULLSCOPE, new Predicate<JvmMember>() {

						public boolean apply(JvmMember input) {
							if (input instanceof JvmOperation) {
								JvmOperation op = (JvmOperation) input;
								if (op.getParameters().size()!=1)
									return false;
								return (getSetterMethodName(propertyName)).equals(op.getSimpleName());
							}
							return false;
						}
					});
					Iterable<IEObjectDescription> allDescriptions = scope.getElements(ISelector.SELECT_ALL);
					for(IEObjectDescription description: allDescriptions) {
						JvmFeatureDescription featureDescription = (JvmFeatureDescription) description;
						descriptions.add(createJvmFeatureDescription(
								getAssignmentOperator(context), 
								featureDescription.getJvmFeature(), 
								featureDescription.getContext(), 
								getAssignmentOperator(context).toString()));
					}
				}
				// methods with one param may be written as setFoo = 'firstParam'
//				if (operation.getParameters().size() == 1) {
//					return new SingletonScope(EObjectDescription.create(getAssignmentOperator(),
//							featureCall.getFeature()), parent);
//				}
			}
		}
		JvmTypeReference typeReference = typeResolver.getType(assignable, null);
		if (typeReference!=null) {
			return new SimpleScope(createFeatureScopeForTypeRef(typeReference, parent, new Predicate<JvmMember>() {
				public boolean apply(JvmMember input) {
					return true;
				}
			}),descriptions);
		}
		return new SimpleScope(parent,descriptions);

	}

	protected EObject getWhatsBoundToThis(XAbstractFeatureCall featureCall) {
		EObject typedElement;
		IScope localVarScope = createLocalVarScope(featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, IScope.NULLSCOPE);
		IEObjectDescription element = localVarScope.getSingleElement(new ISelector.SelectByName(THIS));
		typedElement = element.getEObjectOrProxy();
		return typedElement;
	}

	protected QualifiedName getAssignmentOperator(XAssignment assignment) {
		return ASSIGN;
	}

	protected IScope createLocalVarScope(EObject context, EReference reference, IScope parentScope) {
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

	protected IScope createLocalVarScopeForCatchClause(XCatchClause catchClause,
			int indexOfContextExpressionInBlock, IScope parentScope) {
		return new SingletonScope(createEObjectDescription(catchClause.getDeclaredParam()), parentScope);
	}

	protected IScope createLocalVarScopeForBlock(XBlockExpression block, int indexOfContextExpressionInBlock,
			IScope parentScope) {
		Map<QualifiedName, IEObjectDescription> vars = Maps.newHashMap();

		for (int i = 0; i < indexOfContextExpressionInBlock; i++) {
			XExpression expression = block.getExpressions().get(i);
			if (expression instanceof XVariableDeclaration) {
				XVariableDeclaration varDecl = (XVariableDeclaration) expression;
				IEObjectDescription desc = createEObjectDescription(varDecl);
				vars.put(desc.getName().toLowerCase(), desc);
			}
		}
		if (vars.isEmpty())
			return parentScope;
		return new MapBasedScope(parentScope, vars);
	}

	protected IScope createLocalVarScopeForClosure(XClosure closure, IScope parentScope) {
		EList<JvmFormalParameter> params = closure.getFormalParameters();
		Map<QualifiedName, IEObjectDescription> descriptions = Maps.newHashMap();
		for (JvmFormalParameter p : params) {
			IEObjectDescription desc = createEObjectDescription(p);
			descriptions.put(desc.getName().toLowerCase(), desc);
		}
		return new MapBasedScope(parentScope, descriptions);
	}

	protected IScope createFeatureScopeForTypeRef(JvmTypeReference type, IScope parent,
			Predicate<JvmMember> isAccept) {
		if (type.getType() instanceof JvmDeclaredType) {
			TypeArgumentContext context = provider.get(type);
			return createFeatureScopeForTypeRef(type, parent, isAccept, context);
		}
		//TODO handle JvmTypeParameter
		//		if (type.getType() instanceof JvmTypeParameter) {
		//			TypeArgumentContext context = provider.get(type);
		//			
		//			return createFeatureScopeForTypeRefs(((JvmTypeParameter) type.getType()).getSuperTypes(), parent, context);
		//		}
		return parent;
	}

	protected IScope createFeatureScopeForTypeRefs(List<JvmTypeReference> superTypes, IScope parent,
			Predicate<JvmMember> isAccept, TypeArgumentContext context) {
		if (superTypes.isEmpty())
			return parent;
		if (superTypes.size() == 1)
			return createFeatureScopeForTypeRef(superTypes.get(0), parent, isAccept, context);
		List<IScope> scopes = newArrayList();
		boolean firstIteration = true;
		for (JvmTypeReference typeRef : superTypes) {
			scopes.add(createFeatureScopeForTypeRef(typeRef, firstIteration ? parent : IScope.NULLSCOPE, isAccept,
					context));
		}
		// TODO smarter way to linearize the type hierarchy.
		return new CompositeScope(scopes);
	}

	protected IScope createFeatureScopeForTypeRef(JvmTypeReference jvmTypeRef, IScope parent,
			Predicate<JvmMember> isAccept, TypeArgumentContext context) {
		if (jvmTypeRef.getType() instanceof JvmDeclaredType) {
			EList<JvmTypeReference> superTypes2 = ((JvmDeclaredType) jvmTypeRef.getType()).getSuperTypes();
			parent = createFeatureScopeForTypeRefs(newArrayList(superTypes2), parent, isAccept, context);
			JvmDeclaredType declType = (JvmDeclaredType) jvmTypeRef.getType();
			IScope scopeForMethods = createScopeForMethods(declType, parent, isAccept, context);
			return createScopeForField(declType, scopeForMethods, isAccept, context);
		}
		return IScope.NULLSCOPE;
	}

	protected IScope createScopeForField(JvmDeclaredType declType, IScope parent, final Predicate<JvmMember> isAccept,
			final TypeArgumentContext context) {
		Iterable<JvmField> operations = filter(filter(declType.getMembers(), JvmField.class), new Predicate<JvmMember>(){
			public boolean apply(JvmMember input) {
				return isAccept.apply(input) && !((JvmField)input).isStatic();
			}
		});
		if (!operations.iterator().hasNext())
			return parent;
		Iterable<IEObjectDescription> descriptions = transform(operations,
				new Function<JvmField, IEObjectDescription>() {
					public IEObjectDescription apply(JvmField from) {
						return createJvmFeatureDescription(from, context, from.getSimpleName());
					}
				});
		return new SimpleScope(parent, descriptions);
	}

	protected IScope createScopeForMethods(JvmDeclaredType declType, IScope parent,
			final Predicate<JvmMember> isAccept, final TypeArgumentContext context) {
		final JvmFeatureShadowingIndexObjectProvider stringProvider = new JvmFeatureShadowingIndexObjectProvider(
				context);
		Iterable<JvmOperation> operations = filter(filter(declType.getMembers(), JvmOperation.class), new Predicate<JvmMember>(){
			public boolean apply(JvmMember input) {
				return isAccept.apply(input) && !((JvmOperation)input).isStatic();
			}
		});
		if (!operations.iterator().hasNext())
			return parent;
		Iterable<IEObjectDescription> descriptions = transform(operations,
				new Function<JvmOperation, IEObjectDescription>() {
					public IEObjectDescription apply(JvmOperation from) {
						return createJvmFeatureDescription(from, context, stringProvider.apply(from));
					}
				});
		final IScope sugarScope = getSugarScope(descriptions, declType, parent,
				context);
		return new SimpleScope(sugarScope, descriptions);
	}

	protected IScope getSugarScope(Iterable<IEObjectDescription> operations, JvmDeclaredType declType,
			IScope parent, final TypeArgumentContext context) {
		List<IEObjectDescription> operationsAsList = Lists.newArrayList(operations);
		if (operationsAsList.isEmpty())
			return parent;

		final List<IEObjectDescription> sugar = Lists.newArrayList();
		IAcceptor<JvmFeatureDescription> acceptor = new IAcceptor<JvmFeatureDescription>() {
			public void accept(JvmFeatureDescription t) {
				sugar.add(t);
			}
		};
		for (IEObjectDescription jvmFeatureDescription : operationsAsList) {
			addSugaredDescriptions(jvmFeatureDescription, context, acceptor);
		}

		return sugar.isEmpty() ? parent : new SimpleScope(parent, sugar);
	}

	protected IEObjectDescription createEObjectDescription(JvmFormalParameter p) {
		return EObjectDescription.create(QualifiedName.create(p.getName()), p);
	}

	protected JvmFeatureDescription createJvmFeatureDescription(JvmFeature jvmFeature, TypeArgumentContext ctx,
			String shadowingString) {
		return createJvmFeatureDescription(QualifiedName.create(jvmFeature.getSimpleName()), jvmFeature, ctx,
				shadowingString);
	}

	protected JvmFeatureDescription createJvmFeatureDescription(QualifiedName name, JvmFeature jvmFeature,
			TypeArgumentContext ctx, String shadowingString) {
		return new JvmFeatureDescription(name, jvmFeature, ctx, shadowingString);
	}

	protected IEObjectDescription createEObjectDescription(XVariableDeclaration varDecl) {
		return EObjectDescription.create(QualifiedName.create(varDecl.getName()), varDecl);
	}

	protected void addSugaredDescriptions(IEObjectDescription description, final TypeArgumentContext context,
			IAcceptor<JvmFeatureDescription> acceptor) {
		if (description instanceof JvmFeatureDescription) {
			JvmFeature feature = ((JvmFeatureDescription) description).getJvmFeature();
			if (feature instanceof JvmOperation) {
				JvmOperation op = (JvmOperation) feature;
				if (op.getParameters().size() <= 1) {
					QualifiedName operator = operatorMapping.getOperator(QualifiedName.create(op.getSimpleName()));
					if (operator != null) {
						acceptor.accept(createJvmFeatureDescription(operator, op, context,
								operator + description.getKey().toString()));
					}
				}
				if (op.getParameters().isEmpty()) {
					acceptor.accept(createJvmFeatureDescription(op, context, op.getSimpleName()));
					String propertyName = getPropertyName(op);
					if (propertyName != null) {
						acceptor.accept(createJvmFeatureDescription(QualifiedName.create(propertyName), op, context,
								propertyName));
					}
				}
			}
		}
	}

	protected String getPropertyName(JvmOperation op) {
		String opName = op.getSimpleName();
		if (opName.startsWith("get") && opName.length() > 3 && Character.isUpperCase(opName.charAt(3))) {
			return Strings.toFirstLower(opName.substring(3));
		}
		return null;
	}

	protected String getSetterMethodName(final String propertyName) {
		return "set"+Strings.toFirstUpper(propertyName);
	}

}
