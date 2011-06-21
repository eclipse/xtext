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

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.DefaultJvmFeatureDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.IJvmFeatureDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.IValidatedEObjectDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureScope;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureScopeProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.LocalVarDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.StaticMethodsFeatureForTypeProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.XAssignmentDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.XAssignmentSugarDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.XFeatureCallSugarDescriptionProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseScopeProvider extends XtypeScopeProvider {

	private final static Logger log = Logger.getLogger(XbaseScopeProvider.class);

	public static final QualifiedName THIS = QualifiedName.create("this");

	@Inject
	protected JvmFeatureScopeProvider jvmFeatureScopeProvider;

	@Inject
	private Provider<DefaultJvmFeatureDescriptionProvider> defaultFeatureDescProvider;

	@Inject
	private Provider<XFeatureCallSugarDescriptionProvider> sugarFeatureDescProvider;

	@Inject
	private Provider<StaticMethodsFeatureForTypeProvider> implicitStaticFeatures;

	@Inject
	private Provider<XAssignmentDescriptionProvider> assignmentFeatureDescProvider;

	@Inject
	private Provider<XAssignmentSugarDescriptionProvider> assignmentSugarFeatureDescProvider;

	@Inject
	private ITypeProvider typeProvider;

	@Inject
	private IdentifiableSimpleNameProvider featureNameProvider;
	
	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;
	
	@Inject
	private TypeReferences typeReferences;

	public void setFeatureNameProvider(IdentifiableSimpleNameProvider featureNameProvider) {
		this.featureNameProvider = featureNameProvider;
	}

	public void setTypeProvider(ITypeProvider typeProvider) {
		this.typeProvider = typeProvider;
	}

	protected ITypeProvider getTypeProvider() {
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
		if (log.isDebugEnabled()) {
			log.debug("enter getScope(" + context + ", " + reference.getEContainingClass().getName() + "#" + reference.getName() + ")");
		}
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
			return super.getScope(context, reference);
		} catch (RuntimeException e) {
			log.error("error during scoping", e);
			throw e;
		} finally {
			if (log.isDebugEnabled()) {
				log.debug("leave getScope(" + context + ", " + reference.getEContainingClass().getName() + "#" + reference.getName() + ")");
			}
		}
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
								TypeArgumentContext typeArgumentContext = typeArgumentContextProvider.getReceiverContext(null);
								final JvmConstructor constructor = (JvmConstructor) from.getEObjectOrProxy();
								return new JvmFeatureDescription(from.getQualifiedName(), constructor, typeArgumentContext,
										constructor.getIdentifier(), true, null, 0);
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
				Iterable<IEObjectDescription> elements = getElements(object);
				return (isEmpty(elements)) ? null : elements.iterator().next();
			}

			public IEObjectDescription getSingleElement(QualifiedName name) {
				throw new UnsupportedOperationException();
			}

		};
	}

	protected boolean isConstructorCallScope(EReference reference) {
		return reference.getEReferenceType() == TypesPackage.Literals.JVM_CONSTRUCTOR;
	}

	public boolean isFeatureCallScope(EReference reference) {
		return reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
	}

	/**
	 * creates the feature scope for {@link XAbstractFeatureCall}, including the local variables in case it is a feature
	 * call without receiver (XFeatureCall).
	 */
	protected IScope createFeatureCallScope(final XAbstractFeatureCall call, EReference reference) {
		if (call instanceof XFeatureCall
				|| ((call instanceof XAssignment) && ((XAssignment) call).getAssignable() == null)) {
			IScope result = createSimpleFeatureCallScope(call, reference, call.eResource(), false, -1);
			return result;
		}
		final XExpression syntacticalReceiver = getSyntacticalReceiver(call);
		IScope result = createFeatureCallScopeForReceiver(call, syntacticalReceiver, reference);
		return result;
	}

	/**
	 * This method serves as an entry point for the content assist scoping for simple feature calls.
	 * @param context the context e.g. a for loop expression, a block or a catch clause
	 * @param reference the reference who's value shall be scoped. Not necessarily a feature of the context.
	 * @param includeCurrentBlock <code>false</code> in the context of scoping but content assist will not have the
	 *   actual value holder of the reference at hand so it passes its container to this method and expects the 
	 *   declared variables to be exposed in the scope.
	 * @param idx the index in an expression list of a block. Otherwise to be ignored.
	 */
	public IScope createSimpleFeatureCallScope(final EObject context, EReference reference, Resource resource, boolean includeCurrentBlock, int idx) {
		if (context instanceof XFeatureCall) {
			XFeatureCall featureCall = (XFeatureCall) context;
			if (featureCall.getDeclaringType() != null) {
				JvmParameterizedTypeReference typeReference = typeReferences.createTypeRef(featureCall.getDeclaringType());
				JvmFeatureScope result = createFeatureScopeForTypeRef(typeReference, context, getContextType(context), null, IScope.NULLSCOPE);
				return result;
			}
		}
		DelegatingScope implicitThis = new DelegatingScope(IScope.NULLSCOPE);
		IScope staticScope = createStaticScope(context, resource, implicitThis);
		LocalVariableScopeContext scopeContext = createLocalVariableScopeContext(context, reference, includeCurrentBlock, idx);
		IScope localVariableScope = createLocalVarScope(staticScope, scopeContext);
		IScope featureScopeForThis = createImplicitFeatureCallScope(context, localVariableScope);
		if (featureScopeForThis != null)
			implicitThis.setDelegate(featureScopeForThis);
		return localVariableScope;
	}

	protected LocalVariableScopeContext createLocalVariableScopeContext(final EObject context, EReference reference,
			boolean includeCurrentBlock, int idx) {
		return new LocalVariableScopeContext(context, reference, includeCurrentBlock, idx, false);
	}

	protected IScope createStaticScope(EObject context, Resource resource, IScope parent) {
		JvmDeclaredType contextType = getContextType(context);
		List<IJvmFeatureDescriptionProvider> descriptionProviders = getStaticFeatureDescriptionProviders(resource, contextType);
		return jvmFeatureScopeProvider.createFeatureScopeForTypeRef(parent, null, descriptionProviders);
	}

	/**
	 * This method serves as an entry point for the content assist scoping for features.
	 * @param context the context provides access to the resource set. If it is an assignment, it 
	 *   will be used to restrict scoping.
	 * @param receiver the receiver of the feature call.
	 */
	public IScope createFeatureCallScopeForReceiver(final XExpression context, final XExpression receiver, EReference reference) {
		if (!isFeatureCallScope(reference))
			return IScope.NULLSCOPE;
		if (receiver == null || receiver.eIsProxy())
			return IScope.NULLSCOPE;
		JvmTypeReference receiverType = typeProvider.getType(receiver,true);
		if (receiverType != null) {
			return createFeatureScopeForTypeRef(receiverType, context, getContextType(context), null, IScope.NULLSCOPE);
		}
		return IScope.NULLSCOPE;
	}
	

	protected XExpression getSyntacticalReceiver(final XAbstractFeatureCall call) {
		if (call instanceof XMemberFeatureCall) {
			return ((XMemberFeatureCall) call).getMemberCallTarget();
		}
		if (call instanceof XBinaryOperation) {
			return ((XBinaryOperation) call).getLeftOperand();
		}
		if (call instanceof XUnaryOperation) {
			return ((XUnaryOperation) call).getOperand();
		}
		if (call instanceof XAssignment) {
			return ((XAssignment) call).getAssignable();
		}
		return null;
	}

	/**
	 * override to add any other implicit feature calls.
	 */
	protected IScope createImplicitFeatureCallScope(final EObject call, IScope localVariableScope) {
		JvmFeatureScope featureScopeForThis = null;
		IEObjectDescription thisVariable = localVariableScope.getSingleElement(THIS);
		if (thisVariable != null) {
			EObject implicitReceiver = thisVariable.getEObjectOrProxy();
			JvmTypeReference implicitReceiverType = typeProvider.getTypeForIdentifiable((JvmIdentifiableElement) implicitReceiver);
			if (implicitReceiverType != null && implicitReceiver instanceof JvmIdentifiableElement) {
				XFeatureCall receiver = XbaseFactory.eINSTANCE.createXFeatureCall();
				receiver.setFeature((JvmIdentifiableElement) implicitReceiver);
				featureScopeForThis = createFeatureScopeForTypeRef(
						implicitReceiverType, 
						call, 
						getContextType(call),
						receiver,
						IScope.NULLSCOPE);
			}
		}
		return featureScopeForThis;
	}
	
	protected JvmDeclaredType getContextType(EObject call) {
		if (call == null)
			return null;
		return EcoreUtil2.getContainerOfType(call, JvmDeclaredType.class);
	}
	
	protected IScope createLocalVarScope(IScope parentScope, LocalVariableScopeContext scopeContext) {
		if (scopeContext == null || scopeContext.context == null)
			return parentScope;
		if (scopeContext.canSpawnForContainer())
			parentScope = createLocalVarScope(parentScope, scopeContext.spawnForContainer());
		EObject context = scopeContext.context;
		if (context.eContainer() instanceof XBlockExpression) {
			XBlockExpression block = (XBlockExpression) context.eContainer();
			parentScope = createLocalVarScopeForBlock(block, block.getExpressions().indexOf(context), scopeContext.referredFromClosure, parentScope);
		}
		if (context.eContainer() instanceof XForLoopExpression && context.eContainingFeature() == XbasePackage.Literals.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION) {
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
			parentScope = createLocalVarScopeForTypeGuardedCase((XCasePart) context, parentScope);
		}
		if (context instanceof XSwitchExpression) {
			parentScope = createLocalVarScopeForSwitchExpression((XSwitchExpression) context, parentScope);
		}
		if (scopeContext.includeCurrentBlock) {
			if (context instanceof XBlockExpression) {
				XBlockExpression block = (XBlockExpression) context;
				if (!block.getExpressions().isEmpty()) {
					parentScope = createLocalVarScopeForBlock(block, scopeContext.idx, scopeContext.referredFromClosure, parentScope);
				}
			}
			if (context instanceof XForLoopExpression) {
				parentScope = createLocalScopeForParameter(((XForLoopExpression) context).getDeclaredParam(), parentScope);
			}
			if (context instanceof XCatchClause) {
				parentScope = createLocalScopeForParameter(((XCatchClause) context).getDeclaredParam(), parentScope);
			}
		}
		return parentScope;
	}

	protected IScope createLocalVarScopeForSwitchExpression(XSwitchExpression context, IScope parentScope) {
		if (context.getLocalVarName() != null) {
			return new JvmFeatureScope(parentScope,	"XSwitchExpression",
					new LocalVarDescription(QualifiedName.create(context.getLocalVarName()), context));
		}
		return parentScope;
	}

	protected IScope createLocalVarScopeForTypeGuardedCase(XCasePart context, IScope parentScope) {
		JvmTypeReference guard = context.getTypeGuard();
		if (guard == null) {
			return parentScope;
		}
		String varName = featureNameProvider.getSimpleName(context);
		if (varName == null) {
			return parentScope;
		}
		return new JvmFeatureScope(parentScope, "XCasePart", new LocalVarDescription(QualifiedName.create(varName), context));
	}

	protected IScope createLocalVarScopeForCatchClause(XCatchClause catchClause, int indexOfContextExpressionInBlock,
			IScope parentScope) {
		return createLocalScopeForParameter(catchClause.getDeclaredParam(), parentScope);
	}

	protected IScope createLocalVarScopeForBlock(
			XBlockExpression block, int indexOfContextExpressionInBlock,
			boolean referredFromClosure, IScope parentScope) {
		List<IValidatedEObjectDescription> descriptions = Lists.newArrayList();
		for (int i = 0; i < indexOfContextExpressionInBlock; i++) {
			XExpression expression = block.getExpressions().get(i);
			if (expression instanceof XVariableDeclaration) {
				XVariableDeclaration varDecl = (XVariableDeclaration) expression;
				if (varDecl.getName() != null) {
					IValidatedEObjectDescription desc = createLocalVarDescription(varDecl);
					if (referredFromClosure && varDecl.isWriteable())
						desc.setIssueCode(IssueCodes.INVALID_MUTABLE_VARIABLE_ACCESS);
					descriptions.add(desc);
				}
			}
		}
		return new JvmFeatureScope(parentScope, "XBlockExpression", descriptions);
	}

	protected IScope createLocalVarScopeForClosure(XClosure closure, IScope parentScope) {
		List<IValidatedEObjectDescription> descriptions = Lists.newArrayList();
		EList<JvmFormalParameter> params = closure.getFormalParameters();
		for (JvmFormalParameter p : params) {
			if (p.getName() != null) {
				IValidatedEObjectDescription desc = createLocalVarDescription(p);
				descriptions.add(desc);
			}
		}
		return new JvmFeatureScope(parentScope, "XClosure", descriptions);
	}

	protected JvmFeatureScope createFeatureScopeForTypeRef(JvmTypeReference receiverType, EObject expression,
			JvmDeclaredType currentContext, XExpression implicitReceiver, IScope parent) {
		if (expression instanceof XAssignment) {
			List<IJvmFeatureDescriptionProvider> providers = getFeatureDescriptionProvidersForAssignment(receiverType, (XAssignment) expression, 
					currentContext, implicitReceiver);
			return jvmFeatureScopeProvider.createFeatureScopeForTypeRef(parent, receiverType, providers);
		} else {
			List<IJvmFeatureDescriptionProvider> providers = getFeatureDescriptionProviders(receiverType, expression,
					currentContext, implicitReceiver);
			return jvmFeatureScopeProvider.createFeatureScopeForTypeRef(parent, receiverType, providers);
		}
	}
	
	protected List<IJvmFeatureDescriptionProvider> getStaticFeatureDescriptionProviders(Resource context, JvmDeclaredType contextType) {
		final StaticMethodsFeatureForTypeProvider staticProvider = newImplicitStaticFeaturesProvider();
		staticProvider.setContext(context);

		final DefaultJvmFeatureDescriptionProvider provider1 = newDefaultFeatureDescProvider();
		final XFeatureCallSugarDescriptionProvider provider2 = newSugarDescriptionProvider();
		
		provider1.setContextType(contextType);
		provider1.setFeaturesForTypeProvider(staticProvider);
		provider2.setContextType(contextType);
		provider2.setFeaturesForTypeProvider(staticProvider);
		
		return Lists.<IJvmFeatureDescriptionProvider>newArrayList(provider1, provider2);
	}

	protected List<IJvmFeatureDescriptionProvider> getFeatureDescriptionProviders(JvmTypeReference type,
			EObject expression, JvmDeclaredType currentContext, XExpression implicitReceiver) {
		final DefaultJvmFeatureDescriptionProvider provider1 = newDefaultFeatureDescProvider();
		final XFeatureCallSugarDescriptionProvider provider2 = newSugarDescriptionProvider();
		
		final StaticMethodsFeatureForTypeProvider staticExtensionsProvider = newImplicitStaticFeaturesProvider();
		staticExtensionsProvider.setContext(expression.eResource());
		staticExtensionsProvider.setExtensionProvider(true);
		
		final DefaultJvmFeatureDescriptionProvider provider3 = newDefaultFeatureDescProvider();
		provider3.setFeaturesForTypeProvider(staticExtensionsProvider);
		
		final XFeatureCallSugarDescriptionProvider provider4 = newSugarDescriptionProvider();
		provider4.setFeaturesForTypeProvider(staticExtensionsProvider);
		
		provider1.setContextType(currentContext);
		provider1.setImplicitReceiver(implicitReceiver);
		provider2.setContextType(currentContext);
		provider2.setImplicitReceiver(implicitReceiver);
		provider3.setContextType(currentContext);
		provider3.setImplicitReceiver(implicitReceiver);
		provider4.setContextType(currentContext);
		provider4.setImplicitReceiver(implicitReceiver);
		
		List<IJvmFeatureDescriptionProvider> result = Lists.<IJvmFeatureDescriptionProvider> newArrayList(
				provider1, provider2, provider3, provider4);
		return result;
	}

	protected StaticMethodsFeatureForTypeProvider newImplicitStaticFeaturesProvider() {
		return implicitStaticFeatures.get();
	}

	protected List<IJvmFeatureDescriptionProvider> getFeatureDescriptionProvidersForAssignment(
			JvmTypeReference type, XAssignment expression, JvmDeclaredType currentContext, XExpression implicitReceiver) {
		XAssignmentDescriptionProvider provider1 = assignmentFeatureDescProvider.get();
		XAssignmentSugarDescriptionProvider provider2 = assignmentSugarFeatureDescProvider.get();
		provider1.setContextType(currentContext);
		provider1.setImplicitReceiver(implicitReceiver);
		provider2.setContextType(currentContext);
		provider2.setImplicitReceiver(implicitReceiver);
		List<IJvmFeatureDescriptionProvider> result = Lists.<IJvmFeatureDescriptionProvider>newArrayList(provider1, provider2);
		return result;
	}

	protected IScope createLocalScopeForParameter(JvmFormalParameter p, IScope parentScope) {
		return (p.getName() != null) ? new JvmFeatureScope(parentScope, "JvmFormalParameter", createLocalVarDescription(p)) : parentScope;
	}

	protected IValidatedEObjectDescription createLocalVarDescription(JvmFormalParameter p) {
		return new LocalVarDescription(QualifiedName.create(p.getName()), p);
	}

	protected IValidatedEObjectDescription createLocalVarDescription(XVariableDeclaration varDecl) {
		return new LocalVarDescription(QualifiedName.create(varDecl.getName()), varDecl);
	}
	
	protected DefaultJvmFeatureDescriptionProvider newDefaultFeatureDescProvider() {
		return defaultFeatureDescProvider.get();
	}
	
	protected XFeatureCallSugarDescriptionProvider newSugarDescriptionProvider() {
		return sugarFeatureDescProvider.get();
	}
	
}
