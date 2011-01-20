/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import static com.google.common.collect.Iterables.*;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.scoping.impl.SingletonScope;
import org.eclipse.xtext.typing.ITypeProvider;
import org.eclipse.xtext.typing.TypeResolutionException;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.featurecalls.DefaultJvmFeatureDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureScope;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureScopeProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.StaticMethodsFeatureForTypeProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.XAssignmentDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.XAssignmentSugarDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.XFeatureCallSugarDescriptionProvider;
import org.eclipse.xtext.xbase.typing.IXbaseTypeProvider;

import com.google.common.base.Function;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.internal.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseScopeProvider extends XtypeScopeProvider {

	public static final QualifiedName THIS = QualifiedName.create("this");
	public static final QualifiedName ASSIGN = QualifiedName.create("=");
	public static final QualifiedName ADD = QualifiedName.create("+=");

	@Inject
	private JvmFeatureScopeProvider jvmFeatureScopeProvider;

	@Inject
	private Provider<DefaultJvmFeatureDescriptionProvider> defaultFeatureDescProvider;

	@Inject
	private Provider<XFeatureCallSugarDescriptionProvider> sugarFeatureDescProvider;
	
	@Inject
	private Provider<StaticMethodsFeatureForTypeProvider> staticMethodsFeaturesForTypeProvider;
	
	@Inject
	private Provider<XAssignmentDescriptionProvider> assignmentFeatureDescProvider;

	@Inject
	private Provider<XAssignmentSugarDescriptionProvider> assignmentSugarFeatureDescProvider;

	@Inject
	private IXbaseTypeProvider typeProvider;

	public void setTypeProvider(IXbaseTypeProvider typeProvider) {
		this.typeProvider = typeProvider;
	}

	protected ITypeProvider<JvmTypeReference> getTypeProvider() {
		return typeProvider;
	}

	public void setSugarFeatureDescProvider(Provider<XFeatureCallSugarDescriptionProvider> sugarFeatureDescProvider) {
		this.sugarFeatureDescProvider = sugarFeatureDescProvider;
	}

	public void setDefaultFeatureDescProvider(Provider<DefaultJvmFeatureDescriptionProvider> defaultFeatureDescProvider) {
		this.defaultFeatureDescProvider = defaultFeatureDescProvider;
	}

	@Override
	public IScope getScope(EObject context, EReference reference) {
		try {
			if (isFeatureCallScope(reference)) {
				if (!(context instanceof XAbstractFeatureCall)) {
					return IScope.NULLSCOPE;
				}
				return createFeatureCallScope((XAbstractFeatureCall) context, reference);
			}
			if (isConstructorCallScope(reference)) {
				return createConstructorCallScope(context, reference);
			}
		} catch (TypeResolutionException exception) {
			return IScope.NULLSCOPE;
		}
		return super.getScope(context, reference);
	}

	protected IScope createConstructorCallScope(EObject context, EReference reference) {
		final IScope scope = super.getScope(context, reference);
		return new IScope() {

			public Iterable<IEObjectDescription> getAllElements() {
				Iterable<IEObjectDescription> original = scope.getAllElements();
				return createFeatureDescriptions(original);
			}

			protected Iterable<IEObjectDescription> createFeatureDescriptions(Iterable<IEObjectDescription> original) {
				Iterable<IEObjectDescription> result = transform(original,
						new Function<IEObjectDescription, IEObjectDescription>() {
							public IEObjectDescription apply(IEObjectDescription from) {
								final JvmConstructor constructor = (JvmConstructor) from.getEObjectOrProxy();
								return new JvmFeatureDescription(from.getQualifiedName(), constructor, null,
										constructor.getCanonicalName(), true, null, false);
							}
						});
				return result;
			}

			public Iterable<IEObjectDescription> getElements(EObject object) {
				Iterable<IEObjectDescription> original = scope.getElements(object);
				return createFeatureDescriptions(original);
			}

			public Iterable<IEObjectDescription> getElements(QualifiedName name) {
				Iterable<IEObjectDescription> original = scope.getElements(name);
				return createFeatureDescriptions(original);
			}

			public IEObjectDescription getSingleElement(EObject object) {
				throw new UnsupportedOperationException();
			}

			public IEObjectDescription getSingleElement(QualifiedName name) {
				throw new UnsupportedOperationException();
			}

		};
	}

	protected boolean isConstructorCallScope(EReference reference) {
		return reference.getEReferenceType() == TypesPackage.Literals.JVM_CONSTRUCTOR;
	}

	protected boolean isFeatureCallScope(EReference reference) {
		return reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
	}

	/**
	 * creates the feature scope for {@link XAbstractFeatureCall}, including the local variables in case it is a feature
	 * call without receiver (XFeatureCall).
	 */
	protected IScope createFeatureCallScope(final XAbstractFeatureCall call, EReference reference) {
		if (call instanceof XFeatureCall
				|| ((call instanceof XAssignment) && ((XAssignment) call).getAssignable() == null)) {
			DelegatingScope implicitThis = new DelegatingScope();
			IScope localVariableScope = createLocalVarScope(call, reference, implicitThis);
			IScope featureScopeForThis = createImplicitFeatureCallScope(call, localVariableScope);
			if (featureScopeForThis != null)
				implicitThis.setDelegate(featureScopeForThis);
			return localVariableScope;
		}
		if (call.getArguments().isEmpty())
			return IScope.NULLSCOPE;
		XExpression target = call.getArguments().get(0);
		if (target != null && !target.eIsProxy()) {
			JvmTypeReference jvmTypeReference = typeProvider.getType(target);
			if (jvmTypeReference != null) {
				return createFeatureScopeForTypeRef(jvmTypeReference, call, getContextType(call), null);
			}
		}
		return IScope.NULLSCOPE;
	}

	/**
	 * override to add any other implicit feature calls.
	 */
	protected IScope createImplicitFeatureCallScope(final XAbstractFeatureCall call, IScope localVariableScope) {
		JvmFeatureScope featureScopeForThis = null;
		IEObjectDescription thisVariable = localVariableScope.getSingleElement(THIS);
		if (thisVariable != null) {
			EObject thisVal = thisVariable.getEObjectOrProxy();
			JvmTypeReference type = typeProvider.getType(thisVal);
			if (type != null) {
				featureScopeForThis = createFeatureScopeForTypeRef(type, call, getContextType(call),(JvmIdentifiableElement) thisVariable.getEObjectOrProxy());
			}
		}
		return featureScopeForThis;
	}

	protected JvmDeclaredType getContextType(XAbstractFeatureCall call) {
		return EcoreUtil2.getContainerOfType(call, JvmDeclaredType.class);
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
			parentScope = createLocalScopeForParameter(loop.getDeclaredParam(), parentScope);
		}
		if (context.eContainer() instanceof XCatchClause) {
			XCatchClause catchClause = (XCatchClause) context.eContainer();
			parentScope = createLocalScopeForParameter(catchClause.getDeclaredParam(), parentScope);
		}
		if (context instanceof XClosure) {
			parentScope = createLocalVarScopeForClosure((XClosure) context, parentScope);
		}
		if (context instanceof XCasePart) {
			parentScope = createLocalVarScopeForTypeGuardedCase((XCasePart)context, parentScope);
		}
		if (context instanceof XSwitchExpression) {
			parentScope = createLocalVarScopeForSwitchExpression((XSwitchExpression)context, parentScope);
		}
		return parentScope;
	}

	protected IScope createLocalVarScopeForSwitchExpression(XSwitchExpression context, IScope parentScope) {
		if (context.getLocalVarName()!=null) {
			return new SingletonScope(EObjectDescription.create(QualifiedName.create(context.getLocalVarName()), context), parentScope);
		}
		return parentScope;
	}

	protected IScope createLocalVarScopeForTypeGuardedCase(XCasePart context, IScope parentScope) {
		JvmTypeReference guard = context.getTypeGuard();
		if (guard==null) {
			return parentScope;
		}
		XSwitchExpression switchExpr = (XSwitchExpression) context.eContainer();
		String varName = switchExpr.getLocalVarName();
		if (varName==null) {
			if (switchExpr.getSwitch() instanceof XFeatureCall) {
				varName = ((XFeatureCall)switchExpr.getSwitch()).getFeatureName();
			}
		}
		if (varName==null) {
			return parentScope;
		}
		return new SingletonScope(EObjectDescription.create(QualifiedName.create(varName), context), parentScope);
	}

	protected IScope createLocalVarScopeForCatchClause(XCatchClause catchClause, int indexOfContextExpressionInBlock,
			IScope parentScope) {
		return createLocalScopeForParameter(catchClause.getDeclaredParam(), parentScope);
	}

	protected IScope createLocalVarScopeForBlock(XBlockExpression block, int indexOfContextExpressionInBlock,
			IScope parentScope) {
		List<IEObjectDescription> descriptions = Lists.newArrayList();
		for (int i = 0; i < indexOfContextExpressionInBlock; i++) {
			XExpression expression = block.getExpressions().get(i);
			if (expression instanceof XVariableDeclaration) {
				XVariableDeclaration varDecl = (XVariableDeclaration) expression;
				if (varDecl.getName() != null) {
					IEObjectDescription desc = createEObjectDescription(varDecl);
					descriptions.add(desc);
				}
			}
		}
		return MapBasedScope.createScope(parentScope, descriptions);
	}

	protected IScope createLocalVarScopeForClosure(XClosure closure, IScope parentScope) {
		List<IEObjectDescription> descriptions = Lists.newArrayList();
		EList<JvmFormalParameter> params = closure.getFormalParameters();
		for (JvmFormalParameter p : params) {
			if (p.getName() != null) {
				IEObjectDescription desc = createEObjectDescription(p);
				descriptions.add(desc);
			}
		}
		return MapBasedScope.createScope(parentScope, descriptions);
	}

	protected JvmFeatureScope createFeatureScopeForTypeRef(JvmTypeReference type, XAbstractFeatureCall call,
			JvmDeclaredType currentContext, JvmIdentifiableElement implicitReceiver) {
		if (call instanceof XAssignment) {
			XAssignmentDescriptionProvider provider1 = assignmentFeatureDescProvider.get();
			XAssignmentSugarDescriptionProvider provider2 = assignmentSugarFeatureDescProvider.get();
			provider1.setContextType(currentContext);
			provider1.setImplicitReceiver(implicitReceiver);
			provider2.setContextType(currentContext);
			provider2.setImplicitReceiver(implicitReceiver);
			return jvmFeatureScopeProvider.createFeatureScopeForTypeRef(type, provider1, provider2);
		} else {
			final DefaultJvmFeatureDescriptionProvider provider1 = defaultFeatureDescProvider.get();
			final XFeatureCallSugarDescriptionProvider provider2 = sugarFeatureDescProvider.get();
			final DefaultJvmFeatureDescriptionProvider provider3 = defaultFeatureDescProvider.get();
			provider3.setFeaturesForTypeProvider(staticMethodsFeaturesForTypeProvider.get());
			final XFeatureCallSugarDescriptionProvider provider4 = sugarFeatureDescProvider.get();
			provider4.setFeaturesForTypeProvider(staticMethodsFeaturesForTypeProvider.get());
			provider1.setContextType(currentContext);
			provider1.setImplicitReceiver(implicitReceiver);
			provider2.setContextType(currentContext);
			provider2.setImplicitReceiver(implicitReceiver);
			provider3.setContextType(currentContext);
			provider3.setImplicitReceiver(implicitReceiver);
			provider4.setContextType(currentContext);
			provider4.setImplicitReceiver(implicitReceiver);
			return jvmFeatureScopeProvider.createFeatureScopeForTypeRef(type, provider1, provider2, provider3, provider4);
		}
	}

	protected IScope createLocalScopeForParameter(JvmFormalParameter p, IScope parentScope) {
		return (p.getName() != null) ? new SingletonScope(createEObjectDescription(p), parentScope) : parentScope;
	}

	protected IEObjectDescription createEObjectDescription(JvmFormalParameter p) {
		return EObjectDescription.create(QualifiedName.create(p.getName()), p);
	}

	protected IEObjectDescription createEObjectDescription(XVariableDeclaration varDecl) {
		return EObjectDescription.create(QualifiedName.create(varDecl.getName()), varDecl);
	}

}
