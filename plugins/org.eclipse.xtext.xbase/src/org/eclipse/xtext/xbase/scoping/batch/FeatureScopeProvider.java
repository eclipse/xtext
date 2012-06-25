/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.featurecalls.DefaultJvmFeatureDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.IFeaturesForTypeProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.IJvmFeatureDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.scoping.featurecalls.StaticImplicitMethodsFeatureForTypeProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.XAssignmentDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.XAssignmentSugarDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.XFeatureCallSugarDescriptionProvider;
import org.eclipse.xtext.xbase.typesystem.references.LightweightResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureScopeProvider implements FeatureNames {

	@Inject
	private Provider<DefaultJvmFeatureDescriptionProvider> defaultFeatureDescProvider;
	
	@Inject
	private Provider<XFeatureCallSugarDescriptionProvider> sugarFeatureDescProvider;

	@Inject
	private Provider<StaticImplicitMethodsFeatureForTypeProvider> implicitStaticFeatures;
	
	@Inject
	private Provider<XAssignmentDescriptionProvider> assignmentFeatureDescProvider;

	@Inject
	private Provider<XAssignmentSugarDescriptionProvider> assignmentSugarFeatureDescProvider;

	@Inject
	private OperatorMapping operatorMapping;
	
	protected static final int DEFAULT_MEMBER_CALL_PRIORITY = 0;
	protected static final int DEFAULT_IT_PRIORITY = 10;
	protected static final int DEFAULT_THIS_PRIORITY = 20;
	protected static final int DEFAULT_IMPLICIT_STATIC_FEATURE_PRIORITY = 60;

	protected static final int DEFAULT_SUGAR_PRIORITY_OFFSET = 100;
	protected static final int DEFAULT_STATIC_EXTENSION_PRIORITY_OFFSET = 230;
	
	/**
	 * creates the feature scope for {@link XAbstractFeatureCall}, including the local variables in case it is a feature
	 * call without receiver (XFeatureCall).
	 * @param session the currently available session data
	 */
	public IScope createFeatureCallScope(EObject context, EReference reference, IFeatureScopeSession session, LightweightResolvedTypes resolvedTypes) {
		if (!(context instanceof XAbstractFeatureCall)) {
			return IScope.NULLSCOPE;
		}
		XAbstractFeatureCall call = (XAbstractFeatureCall) context;
		final XExpression syntacticalReceiver = getSyntacticalReceiver(call);
		if (syntacticalReceiver == null) { // featureCall instanceof XFeatureCall || ((featureCall instanceof XAssignment) && ((XAssignment) featureCall).getAssignable() == null);
			IScope result = createSimpleFeatureCallScope(call, reference, session, resolvedTypes);
			return result;
		}
		IScope result = createFeatureCallScopeForReceiver(call, syntacticalReceiver, reference, session, resolvedTypes);
		return result;
	}

	public boolean isFeatureCallScope(EReference reference) {
		return reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
	}
	
	/**
	 * This method serves as an entry point for the content assist scoping for simple feature calls.
	 * @param context the context e.g. a for loop expression, a block or a catch clause
	 * @param reference the reference who's value shall be scoped. Not necessarily a feature of the context.
	 */
	public IScope createSimpleFeatureCallScope(EObject context, EReference reference, IFeatureScopeSession session, LightweightResolvedTypes resolvedTypes) {
		if (context instanceof XFeatureCall) {
			XFeatureCall featureCall = (XFeatureCall) context;
			if (featureCall.getDeclaringType() != null) {
				TypeBucket receiverBucket = new TypeBucket(-1, Collections.<JvmType>singletonList(featureCall.getDeclaringType()));
				return new ReceiverFeatureScope(IScope.NULLSCOPE, session, null, null, asAbstractFeatureCall(context), receiverBucket, operatorMapping);
			}
		}
		
//		DelegatingScope implicitFeaturesAndStatics = new DelegatingScope(IScope.NULLSCOPE);
//		LocalVariableScopeContext scopeContext = createLocalVariableScopeContext(context, reference, includeCurrentBlock, idx);
		IScope staticImports = createStaticFeaturesScope(context, IScope.NULLSCOPE, session);
		IScope staticExtensions = createStaticExtensionsScope(null, null, context, staticImports, session);
		IScope implicitReceivers = createImplicitFeatureCallScope(context, staticExtensions, session, resolvedTypes);
		IScope localVariables = new LocalVariableScope(implicitReceivers, session, asAbstractFeatureCall(context));
//		IScope scopeForImplicitFeatures = createImplicitFeatureCallScope(context, resource, IScope.NULLSCOPE, localVariableScope);
//		implicitFeaturesAndStatics.setDelegate(scopeForImplicitFeatures);
		return localVariables;
	}

	protected XAbstractFeatureCall asAbstractFeatureCall(EObject context) {
		return context instanceof XAbstractFeatureCall ? (XAbstractFeatureCall) context : null;
	}

//	/**
//	 * This method serves as an entry point for the content assist scoping for simple feature calls.
//	 * @param context the context e.g. a for loop expression, a block or a catch clause
//	 * @param reference the reference who's value shall be scoped. Not necessarily a feature of the context.
//	 * @param includeCurrentBlock <code>false</code> in the context of scoping but content assist will not have the
//	 *   actual value holder of the reference at hand so it passes its container to this method and expects the 
//	 *   declared variables to be exposed in the scope.
//	 * @param idx the index in an expression list of a block. Otherwise to be ignored.
//	 */
//	public IScope createSimpleFeatureCallScope(EObject context, EReference reference, Resource resource, boolean includeCurrentBlock, int idx) {
//		if (context instanceof XFeatureCall) {
//			XFeatureCall featureCall = (XFeatureCall) context;
//			if (featureCall.getDeclaringType() != null) {
//				JvmTypeReference typeReference = typeReferences.createTypeRef(featureCall.getDeclaringType());
//				JvmFeatureScopeAcceptor featureScopeDescriptions = new JvmFeatureScopeAcceptor();
//				IAcceptor<IJvmFeatureDescriptionProvider> curried = featureScopeDescriptions.curry(typeReference, featureCall);
//				addFeatureDescriptionProviders(getContextType(featureCall), null, null, null, getDefaultPriority(), true, curried);
//				IScope result = featureScopeDescriptions.createScope(IScope.NULLSCOPE);
//				return result;
//			}
//		}
//		DelegatingScope implicitFeaturesAndStatics = new DelegatingScope(IScope.NULLSCOPE);
//		LocalVariableScopeContext scopeContext = createLocalVariableScopeContext(context, reference, includeCurrentBlock, idx);
//		IScope localVariableScope = createLocalVarScope(implicitFeaturesAndStatics, scopeContext);
//		IScope scopeForImplicitFeatures = createImplicitFeatureCallScope(context, resource, IScope.NULLSCOPE, localVariableScope);
//		implicitFeaturesAndStatics.setDelegate(scopeForImplicitFeatures);
//		return localVariableScope;
//	}
	
	protected IScope createFeatureScopeForTypeRef(
			XExpression receiver,
			LightweightTypeReference featureDeclarator, 
			EObject featureCall,
			IFeatureScopeSession session,
			IScope parent) {
		// TODO ReceiverFeatureScopes for synonyms
		List<JvmType> rawTypes = featureDeclarator.getRawTypes();
		TypeBucket typeBucket = new TypeBucket(-1, rawTypes);
		IScope result = new ReceiverFeatureScope(parent, session, receiver, featureDeclarator, asAbstractFeatureCall(featureCall), typeBucket, operatorMapping);
		return result;
	}

//	protected LocalVariableScopeContext createLocalVariableScopeContext(final EObject context, EReference reference,
//			boolean includeCurrentBlock, int idx) {
//		return new LocalVariableScopeContext(context, reference, includeCurrentBlock, idx, false, logicalContainerProvider);
//	}

	/**
	 * This method serves as an entry point for the content assist scoping for features.
	 * @param featureCall the context provides access to the resource set. If it is an assignment, it 
	 *   will be used to restrict scoping.
	 * @param receiver the receiver of the feature call.
	 * @param resolvedTypes TODO
	 * @param session TODO
	 */
	public IScope createFeatureCallScopeForReceiver(final XExpression featureCall, final XExpression receiver, EReference reference, IFeatureScopeSession session, LightweightResolvedTypes resolvedTypes) {
		if (!isFeatureCallScope(reference))
			return IScope.NULLSCOPE;
		if (receiver == null || receiver.eIsProxy())
			return IScope.NULLSCOPE;
		LightweightTypeReference receiverType = resolvedTypes.internalGetActualType(receiver);
		if (receiverType != null) {
			IScope result = createStaticExtensionsScope(receiver, receiverType, featureCall, IScope.NULLSCOPE, session);
			return createFeatureScopeForTypeRef(receiver, receiverType, featureCall, session, result);
		} else {
			return IScope.NULLSCOPE;
		}
	}

	protected StaticExtensionImportsScope createStaticExtensionsScope(XExpression receiver, LightweightTypeReference receiverType, EObject featureCall, IScope parent, IFeatureScopeSession session) {
		return new StaticExtensionImportsScope(parent, session, receiver, receiverType, asAbstractFeatureCall(featureCall), operatorMapping);
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

	protected IScope createStaticFeaturesScope(EObject featureCall, IScope parent, IFeatureScopeSession session) {
		return new StaticImportsScope(parent, session, asAbstractFeatureCall(featureCall));
	}
	
	protected IScope createImplicitFeatureCallScope(EObject featureCall, IScope parent, IFeatureScopeSession session, LightweightResolvedTypes resolvedTypes) {
		IScope result = parent;
		result = createImplicitFeatureCallScope(THIS, featureCall, session, resolvedTypes, result);
		result = createImplicitFeatureCallScope(IT, featureCall, session, resolvedTypes, result);
		return result;
	}

	protected IScope createImplicitFeatureCallScope(QualifiedName implicitName, EObject featureCall,
			IFeatureScopeSession session, LightweightResolvedTypes resolvedTypes, IScope parent) {
		IEObjectDescription thisDescription = session.getLocalElement(implicitName);
		if (thisDescription != null) {
			JvmIdentifiableElement thisElement = (JvmIdentifiableElement) thisDescription.getEObjectOrProxy();
			LightweightTypeReference type = resolvedTypes.internalGetActualType(thisElement);
			// TODO create feature call to this and add it as receiver
			return createFeatureScopeForTypeRef(null, type, featureCall, session, parent);
		}
		return parent;
	}
	
//	protected void addFeatureCallScopes(EObject featureCall, IScope localVariableScope,
//			IJvmFeatureScopeAcceptor featureScopeDescriptions) {
//		addFeatureCallScopes(featureCall, localVariableScope, THIS, getThisPriority(), featureScopeDescriptions);
//		addFeatureCallScopes(featureCall, localVariableScope, IT, getItPriority(), featureScopeDescriptions);
//		
//		JvmIdentifiableElement logicalContainer = logicalContainerProvider.getNearestLogicalContainer(featureCall);
//		if (logicalContainer instanceof JvmConstructor) {
//			JvmConstructor constructor = (JvmConstructor) logicalContainer;
//			JvmDeclaredType contextType = constructor.getDeclaringType();
//			JvmTypeReference receiverType = typeReferences.createTypeRef(contextType);
//			IAcceptor<IJvmFeatureDescriptionProvider> acceptor = featureScopeDescriptions.curry(receiverType, featureCall);
//			DefaultConstructorDescriptionProvider defaultProvider = newDefaultConstructorDescriptionProvider();
//			XConstructorProvider featureProvider = newConstructorProvider();
//			defaultProvider.setContextType(contextType);
//			defaultProvider.setPriority(getDefaultPriority());
//			defaultProvider.setFeaturesForTypeProvider(featureProvider);
//			acceptor.accept(defaultProvider);			
//		}
//	}

//	protected void addFeatureCallScopes(
//			EObject expression, 
//			IScope localVariableScope,
//			QualifiedName variableName,
//			int priority,
//			IJvmFeatureScopeAcceptor featureScopeDescriptions) {
//		IEObjectDescription implicitVariable = localVariableScope.getSingleElement(variableName);
//		if (implicitVariable != null) {
//			EObject implicitReceiver = implicitVariable.getEObjectOrProxy();
//			if (implicitReceiver instanceof JvmIdentifiableElement) {
//				JvmTypeReference receiverType = typeProvider.getTypeForIdentifiable((JvmIdentifiableElement) implicitReceiver);
//				receiverType = unkownToObject(receiverType, expression);
//				if (receiverType != null) {
//					XFeatureCall receiver = XbaseFactory.eINSTANCE.createXFeatureCall();
//					receiver.setFeature((JvmIdentifiableElement) implicitReceiver);
//					addFeatureScopes(receiverType, expression, getContextType(expression), receiver, null, priority, featureScopeDescriptions);
//				}
//			}
//		}
//	}
	
//	protected JvmTypeReference unkownToObject(JvmTypeReference receiverType, EObject context) {
//		if (receiverType instanceof JvmUnknownTypeReference) {
//			return typeReferences.getTypeForName(Object.class, context);
//		}
//		return receiverType;
//	}

//	protected JvmDeclaredType getContextType(EObject obj) {
//		if (obj == null)
//			return null;
//		if (obj instanceof JvmDeclaredType) {
//			return (JvmDeclaredType) obj;
//		}
//		if (obj instanceof XExpression) {
//			JvmIdentifiableElement element = logicalContainerProvider.getLogicalContainer(obj);
//			if (element != null) {
//				if (element instanceof JvmDeclaredType) {
//					return (JvmDeclaredType) element;
//				} else if (element instanceof JvmMember) {
//					return ((JvmMember) element).getDeclaringType();
//				}
//			}
//		}
//		return getContextType(obj.eContainer());
//	}
	
//	protected IScope createLocalVarScope(IScope parentScope, LocalVariableScopeContext scopeContext) {
//		if (scopeContext == null || scopeContext.getContext() == null)
//			return parentScope;
//		EObject context = scopeContext.getContext();
//		if (context instanceof JvmOperation) {
//			JvmOperation jvmOperation = (JvmOperation) context;
//			if (jvmOperation.getDeclaringType() != null) {
//				JvmDeclaredType declaredType = jvmOperation.getDeclaringType();
//				if (!jvmOperation.isStatic()) {
//					parentScope = createLocalVarScopeForJvmDeclaredType(declaredType, parentScope);
//				}
//			}
//			return createLocalVarScopeForJvmOperation((JvmOperation)context, parentScope);
//		}
//		if (context instanceof JvmConstructor) {
//			JvmConstructor constructor = (JvmConstructor) context;
//			if (constructor.getDeclaringType() != null) {
//				JvmDeclaredType declaredType = constructor.getDeclaringType();
//				parentScope = createLocalVarScopeForJvmDeclaredType(declaredType, parentScope);
//			}
//			return createLocalVarScopeForJvmConstructor((JvmConstructor)context, parentScope);
//		}
//		if (context instanceof JvmField) {
//			JvmField field = (JvmField) context;
//			if (field.getDeclaringType() != null) {
//				JvmDeclaredType declaredType = field.getDeclaringType();
//				if (!field.isStatic()) {
//					parentScope = createLocalVarScopeForJvmDeclaredType(declaredType, parentScope);
//				}
//			}
//			return parentScope;
//		}
//		if(context instanceof JvmDeclaredType) {
//			return createLocalVarScopeForJvmDeclaredType((JvmDeclaredType) context, parentScope);
//		}
//		if (scopeContext.canSpawnForContainer())
//			parentScope = createLocalVarScope(parentScope, scopeContext.spawnForContainer());
//		if (context.eContainer() instanceof XBlockExpression) {
//			XBlockExpression block = (XBlockExpression) context.eContainer();
//			parentScope = createLocalVarScopeForBlock(block, block.getExpressions().indexOf(context), scopeContext.isReferredFromClosure(), parentScope);
//		}
//		if (context.eContainer() instanceof XForLoopExpression && context.eContainingFeature() == XbasePackage.Literals.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION) {
//			XForLoopExpression loop = (XForLoopExpression) context.eContainer();
//			parentScope = createLocalScopeForParameter(loop.getDeclaredParam(), parentScope);
//		}
//		if (context.eContainer() instanceof XCatchClause) {
//			XCatchClause catchClause = (XCatchClause) context.eContainer();
//			parentScope = createLocalScopeForParameter(catchClause.getDeclaredParam(), parentScope);
//		}
//		if (context instanceof XClosure) {
//			parentScope = createLocalVarScopeForClosure((XClosure) context, parentScope);
//		}
//		if (context instanceof XCasePart) {
//			parentScope = createLocalVarScopeForTypeGuardedCase((XCasePart) context, parentScope);
//		}
//		if (context instanceof XSwitchExpression) {
//			parentScope = createLocalVarScopeForSwitchExpression((XSwitchExpression) context, parentScope);
//		}
//		if (scopeContext.isIncludeCurrentBlock()) {
//			if (context instanceof XBlockExpression) {
//				XBlockExpression block = (XBlockExpression) context;
//				if (!block.getExpressions().isEmpty()) {
//					parentScope = createLocalVarScopeForBlock(block, scopeContext.getIndex(), scopeContext.isReferredFromClosure(), parentScope);
//				}
//			}
//			if (context instanceof XForLoopExpression) {
//				parentScope = createLocalScopeForParameter(((XForLoopExpression) context).getDeclaredParam(), parentScope);
//			}
//			if (context instanceof XCatchClause) {
//				parentScope = createLocalScopeForParameter(((XCatchClause) context).getDeclaredParam(), parentScope);
//			}
//		}
//		return parentScope;
//	}

//	protected IScope createLocalVarScopeForJvmOperation(JvmOperation context, IScope parentScope) {
//		List<JvmFormalParameter> parameters = context.getParameters();
//		if (parameters.isEmpty())
//			return parentScope;
//		List<LocalVarDescription> descriptions = newArrayList();
//		for (JvmFormalParameter p : parameters) {
//			if (p.getName() != null)
//				descriptions.add(new LocalVarDescription(QualifiedName.create(p.getName()), p));
//		}
//		return new JvmFeatureScope(parentScope, "operation "+context.getSimpleName(), descriptions);
//	}
//	
//	protected IScope createLocalVarScopeForJvmConstructor(JvmConstructor context, IScope parentScope) {
//		List<JvmFormalParameter> parameters = context.getParameters();
//		if (parameters.isEmpty())
//			return parentScope;
//		List<LocalVarDescription> descriptions = newArrayList();
//		for (JvmFormalParameter p : parameters) {
//			if (p.getName() != null)
//				descriptions.add(new LocalVarDescription(QualifiedName.create(p.getName()), p));
//		}
//		return new JvmFeatureScope(parentScope, "constructor "+context.getSimpleName(), descriptions);
//	}

//	protected IScope createLocalVarScopeForJvmDeclaredType(JvmDeclaredType type, IScope parentScope) {
//		Iterator<JvmTypeReference> classes = filter(type.getSuperTypes(), new Predicate<JvmTypeReference>() {
//			public boolean apply(JvmTypeReference input) {
//				if (input.getType() instanceof JvmGenericType) {
//					return !((JvmGenericType)input.getType()).isInterface();
//				}
//				return false;
//			}
//		}).iterator();
//		JvmGenericType superType = null;
//		if (classes.hasNext()) {
//			superType = (JvmGenericType) classes.next().getType();
//		}
//		if (superType == null) {
//			return new JvmFeatureScope(parentScope, "this", new LocalVarDescription(THIS, type));
//		} else {
//			return new JvmFeatureScope(parentScope, "this & super", newArrayList(
//					new LocalVarDescription(THIS, type), 
//					new LocalVarDescription(SUPER, superType)));
//		}
//	}

//	protected boolean adaptsToJvmElement(EObject context) {
//		if (context instanceof XExpression) {
//			return logicalContainerProvider.getLogicalContainer(context) != null;
//		}
//		return false;
//	}

//	protected IScope createLocalVarScopeForSwitchExpression(XSwitchExpression context, IScope parentScope) {
//		if (context.getLocalVarName() != null) {
//			return new JvmFeatureScope(parentScope,	"XSwitchExpression",
//					new LocalVarDescription(QualifiedName.create(context.getLocalVarName()), context));
//		}
//		return parentScope;
//	}

//	/**
//	 * Allows to hook into the case guards to introduce new local variables with a specialized type.
//	 * Implemented as no-op by default.
//	 * @param context the case part.
//	 * @param parentScope the parent scope.
//	 */
//	protected IScope createLocalVarScopeForTypeGuardedCase(XCasePart context, IScope parentScope) {
//		return parentScope;
//	}
//
//	/**
//	 * Allows to hook into the local variable definition for catch clauses.
//	 * @param catchClause the catch clause.
//	 * @param indexOfContextExpressionInBlock the index of the context expression in its surrounding block.
//	 * @param parentScope the parent scope.
//	 */
//	protected IScope createLocalVarScopeForCatchClause(XCatchClause catchClause, int indexOfContextExpressionInBlock,
//			IScope parentScope) {
//		return createLocalScopeForParameter(catchClause.getDeclaredParam(), parentScope);
//	}

//	protected IScope createLocalVarScopeForBlock(
//			XBlockExpression block, int indexOfContextExpressionInBlock,
//			boolean referredFromClosure, IScope parentScope) {
//		List<IValidatedEObjectDescription> descriptions = Lists.newArrayList();
//		for (int i = 0; i < indexOfContextExpressionInBlock; i++) {
//			XExpression expression = block.getExpressions().get(i);
//			if (expression instanceof XVariableDeclaration) {
//				XVariableDeclaration varDecl = (XVariableDeclaration) expression;
//				if (varDecl.getName() != null) {
//					IValidatedEObjectDescription desc = createLocalVarDescription(varDecl);
//					if (referredFromClosure && varDecl.isWriteable())
//						desc.setIssueCode(IssueCodes.INVALID_MUTABLE_VARIABLE_ACCESS);
//					descriptions.add(desc);
//				}
//			}
//		}
//		if (descriptions.isEmpty())
//			return parentScope;
//		return new JvmFeatureScope(parentScope, "XBlockExpression", descriptions);
//	}

//	protected IScope createLocalVarScopeForClosure(XClosure closure, IScope parentScope) {
//		List<IValidatedEObjectDescription> descriptions = Lists.newArrayList();
//		EList<JvmFormalParameter> params = closure.getFormalParameters();
//		for (JvmFormalParameter p : params) {
//			if (p.getName() != null) {
//				IValidatedEObjectDescription desc = createLocalVarDescription(p);
//				descriptions.add(desc);
//			}
//		}
//		return new JvmFeatureScope(parentScope, "XClosure", descriptions);
//	}

//	public interface IJvmFeatureScopeAcceptor {
//		void acceptScope(
//				JvmTypeReference featureDeclarator, 
//				Function<JvmFeatureDescription,ITypeArgumentContext> contextFactory, 
//				IJvmFeatureDescriptionProvider provider);
//		
//		IAcceptor<IJvmFeatureDescriptionProvider> curry(
//				JvmTypeReference featureDeclarator,
//				EObject expression);
//	}
	
//	protected abstract class AbstractJvmFeatureScopeAcceptor implements IJvmFeatureScopeAcceptor {
//
//		public IAcceptor<IJvmFeatureDescriptionProvider> curry(
//				JvmTypeReference featureDeclarator,
//				EObject expression) {
//			return new SimpleAcceptor(this, featureDeclarator, expression);
//		}
//	}
	
//	protected class SimpleAcceptor implements IAcceptor<IJvmFeatureDescriptionProvider> {
//		private final Function<JvmFeatureDescription, ITypeArgumentContext> contextFactory;
//		private final IJvmFeatureScopeAcceptor parent;
//		private final JvmTypeReference receiverType;
//		private final EObject expression;
//
//		protected SimpleAcceptor(
//				IJvmFeatureScopeAcceptor parent,
//				JvmTypeReference receiverType, 
//				EObject expression) {
//			this.parent = parent;
//			this.receiverType = receiverType;
//			this.expression = expression;
//			this.contextFactory = new GenericTypeArgumentContextFactory(receiverType, expression);
//		}
//
//		public void accept(IJvmFeatureDescriptionProvider provider) {
//			parent.acceptScope(receiverType, contextFactory, provider);
//		}
//		
//		public IJvmFeatureScopeAcceptor getParent() {
//			return parent;
//		}
//		
//		public EObject getExpression() {
//			return expression;
//		}
//		
//		public JvmTypeReference getReceiverType() {
//			return receiverType;
//		}
//		
//	}
	
//	protected class JvmFeatureScopeAcceptor extends AbstractJvmFeatureScopeAcceptor {
//		
//		private final List<IJvmFeatureScopeProvider.FeatureScopeDescription> descriptions;
//		
//		public JvmFeatureScopeAcceptor() {
//			this.descriptions = Lists.newArrayList();
//		}
//		
//		public void acceptScope(
//				JvmTypeReference featureDeclarator, 
//				Function<JvmFeatureDescription,ITypeArgumentContext> contextFactory, 
//				IJvmFeatureDescriptionProvider provider) {
//			descriptions.add(new IJvmFeatureScopeProvider.FeatureScopeDescription(featureDeclarator, contextFactory, provider));
//		}
//		
//		public IScope createScope(IScope parent) {
//			if (descriptions.isEmpty())
//				return parent;
//			sortDescriptionsFromLowestToHighest(descriptions);
//			IScope result = jvmFeatureScopeProvider.createFeatureScope(parent, descriptions);
//			return result;
//		}
//	}
	
//	protected void sortDescriptionsFromLowestToHighest(List<IJvmFeatureScopeProvider.FeatureScopeDescription> list) {
//		Collections.sort(list, new Comparator<IJvmFeatureScopeProvider.FeatureScopeDescription>() {
//			public int compare(FeatureScopeDescription o1, FeatureScopeDescription o2) {
//				int prio1 = o1.getDescriptionProvider().getPriority();
//				int prio2 = o2.getDescriptionProvider().getPriority();
//				if (prio1 < prio2)
//					return 1;
//				if (prio1 > prio2)
//					return -1;
//				return 0;
//			}
//		});
//	}
	
//	protected class GenericTypeArgumentContextFactory implements Function<JvmFeatureDescription, ITypeArgumentContext> {
//
//		private final EObject expression;
//		private final JvmTypeReference receiverType;
//
//		public GenericTypeArgumentContextFactory(JvmTypeReference receiverType, EObject expression) {
//			this.receiverType = receiverType;
//			this.expression = expression;
//		}
//		
//		public ITypeArgumentContext apply(JvmFeatureDescription from) {
//			JvmIdentifiableElement feature = from.getEObjectOrProxy();
//			if (feature instanceof JvmExecutable && expression instanceof XAbstractFeatureCall) {
//				XAbstractFeatureCall featureCall = (XAbstractFeatureCall) expression;
//				List<XExpression> arguments = featureCallToJavaMapping.getActualArguments(
//						featureCall, feature, 
//						from.getImplicitReceiver(),
//						from.getImplicitArgument());
//				ITypeArgumentContext result = typeProvider.getTypeArgumentContext(
//						featureCall,
//						arguments,
//						receiverType != null ? Providers.of(receiverType) : null, 
//						feature);
//				return result;
//			}
//			return null;
//		}
//		
//	}
	
//	protected void addFeatureScopes(
//			JvmTypeReference receiverType, 
//			EObject expression,
//			JvmDeclaredType contextType, 
//			XExpression implicitReceiver, 
//			XExpression implicitArgument, 
//			int priority,
//			IJvmFeatureScopeAcceptor acceptor) {
//		IAcceptor<IJvmFeatureDescriptionProvider> curried = acceptor.curry(receiverType, expression);
//		if (expression instanceof XAssignment) {
//			addFeatureDescriptionProvidersForAssignment(expression.eResource(), contextType, implicitReceiver, implicitArgument, priority, curried);
//		} else {
//			addFeatureDescriptionProviders(expression.eResource(), contextType, implicitReceiver, implicitArgument, priority, curried);
//		}
//	}
	
	protected void addStaticFeatureDescriptionProviders(
			Resource resource, 
			JvmDeclaredType contextType,
			IAcceptor<IJvmFeatureDescriptionProvider> acceptor) {

		StaticImplicitMethodsFeatureForTypeProvider implicitMethodsProvider = newImplicitStaticFeaturesProvider();
		implicitMethodsProvider.setResourceContext(resource);
		addFeatureDescriptionProviders(contextType, implicitMethodsProvider, null, null, getImplicitStaticFeaturePriority(), true, acceptor);
	}
	
	protected int getThisPriority() {
		return DEFAULT_THIS_PRIORITY;
	}
	
	protected int getDefaultPriority() {
		return DEFAULT_MEMBER_CALL_PRIORITY;
	}

	protected int getItPriority() {
		return DEFAULT_IT_PRIORITY;
	}
	
	protected int getSugarPriorityOffset() {
		return DEFAULT_SUGAR_PRIORITY_OFFSET;
	}
	
	protected int getImplicitStaticExtensionPriorityOffset() {
		return DEFAULT_STATIC_EXTENSION_PRIORITY_OFFSET;
	}
	
	protected int getImplicitStaticFeaturePriority() {
		return DEFAULT_IMPLICIT_STATIC_FEATURE_PRIORITY;
	}
	
	protected void addFeatureDescriptionProviders(
			JvmDeclaredType contextType,
			IFeaturesForTypeProvider featureProvider,
			XExpression implicitReceiver,
			XExpression implicitArgument,
			int priority,
			boolean preferStatics,
			IAcceptor<IJvmFeatureDescriptionProvider> acceptor) {
		DefaultJvmFeatureDescriptionProvider defaultProvider = newDefaultFeatureDescriptionProvider();
		defaultProvider.setContextType(contextType);
		defaultProvider.setPriority(priority);
		if (featureProvider != null)
			defaultProvider.setFeaturesForTypeProvider(featureProvider);
		defaultProvider.setImplicitReceiver(implicitReceiver);
		defaultProvider.setImplicitArgument(implicitArgument);
		defaultProvider.setPreferStatics(preferStatics);
		acceptor.accept(defaultProvider);

		XFeatureCallSugarDescriptionProvider sugarProvider = newSugarDescriptionProvider();
		sugarProvider.setContextType(contextType);
		sugarProvider.setPriority(priority + getSugarPriorityOffset());
		if (featureProvider != null)
			sugarProvider.setFeaturesForTypeProvider(featureProvider);
		sugarProvider.setImplicitReceiver(implicitReceiver);
		sugarProvider.setImplicitArgument(implicitArgument);
		sugarProvider.setPreferStatics(preferStatics);
		acceptor.accept(sugarProvider);
	}

	protected void addFeatureDescriptionProviders(
			Resource resource, 
			JvmDeclaredType contextType, 
			XExpression implicitReceiver,
			XExpression implicitArgument,
			int priority,
			IAcceptor<IJvmFeatureDescriptionProvider> acceptor) {
		addFeatureDescriptionProviders(contextType, null, implicitReceiver, implicitArgument, priority, false, acceptor);
		
		if (implicitArgument == null) {
			StaticImplicitMethodsFeatureForTypeProvider implicitStaticFeatures = newImplicitStaticFeaturesProvider();
			implicitStaticFeatures.setResourceContext(resource);
			implicitStaticFeatures.setExtensionProvider(true);
			addFeatureDescriptionProviders(contextType, implicitStaticFeatures, implicitReceiver, implicitArgument, priority + getImplicitStaticExtensionPriorityOffset(), true, acceptor);
		}
	}

	private StaticImplicitMethodsFeatureForTypeProvider newImplicitStaticFeaturesProvider() {
		return implicitStaticFeatures.get();
	}
	
	/**
	 * @param resource the resource which may define implicitly available feature description providers.
	 */
	protected void addFeatureDescriptionProvidersForAssignment(
			Resource resource,
			JvmDeclaredType contextType, 
			XExpression implicitReceiver,
			XExpression implicitArgument,
			int priority,
			IAcceptor<IJvmFeatureDescriptionProvider> acceptor) {
		addFeatureDescriptionProvidersForAssignment(contextType, null, implicitReceiver, implicitArgument, priority, false, acceptor);
	}

	protected void addFeatureDescriptionProvidersForAssignment(
			JvmDeclaredType contextType,
			IFeaturesForTypeProvider featureProvider,
			XExpression implicitReceiver,
			XExpression implicitArgument, 
			int priority,
			boolean preferStatics,
			IAcceptor<IJvmFeatureDescriptionProvider> acceptor) {
		XAssignmentDescriptionProvider assignmentProvider = assignmentFeatureDescProvider.get();
		assignmentProvider.setContextType(contextType);
		if (featureProvider != null)
			assignmentProvider.setFeaturesForTypeProvider(featureProvider);
		assignmentProvider.setImplicitReceiver(implicitReceiver);
		assignmentProvider.setImplicitArgument(implicitArgument);
		assignmentProvider.setPriority(priority);
		assignmentProvider.setPreferStatics(preferStatics);
		acceptor.accept(assignmentProvider);
		
		XAssignmentSugarDescriptionProvider sugarProvider = assignmentSugarFeatureDescProvider.get();
		sugarProvider.setContextType(contextType);
		if (featureProvider != null)
			sugarProvider.setFeaturesForTypeProvider(featureProvider);
		sugarProvider.setImplicitReceiver(implicitReceiver);
		sugarProvider.setImplicitArgument(implicitArgument);
		sugarProvider.setPriority(getSugarPriorityOffset() + priority);
		sugarProvider.setPreferStatics(preferStatics);
		acceptor.accept(sugarProvider);
	}

	private DefaultJvmFeatureDescriptionProvider newDefaultFeatureDescriptionProvider() {
		return defaultFeatureDescProvider.get();
	}
	
	private XFeatureCallSugarDescriptionProvider newSugarDescriptionProvider() {
		return sugarFeatureDescProvider.get();
	}
	
}
