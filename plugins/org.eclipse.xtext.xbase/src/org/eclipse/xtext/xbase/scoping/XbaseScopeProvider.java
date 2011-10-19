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

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
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
import org.eclipse.xtext.xbase.impl.FeatureCallToJavaMapping;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
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
import org.eclipse.xtext.xbase.typing.ITypeArgumentContextHelper;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.util.Providers;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseScopeProvider extends XtypeScopeProvider {

	private final static Logger log = Logger.getLogger(XbaseScopeProvider.class);

	public static final QualifiedName THIS = QualifiedName.create("this");
	public static final QualifiedName IT = QualifiedName.create("it");

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
	private ITypeArgumentContextHelper typeArgumentContextHelper;
	
	@Inject
	private FeatureCallToJavaMapping featureCallToJavaMapping;
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private ILogicalContainerProvider expressionContext;
	
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
			if (isTypeScope(reference)) {
				return createTypeScope(context, reference);
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

	protected IScope createTypeScope(EObject context, EReference reference) {
		final IScope parentScope = super.getScope(context, reference);
		JvmIdentifiableElement logicalContainer = getLogicalContainer(context);
		if (logicalContainer != null) {
			 return createTypeScope(logicalContainer, reference, parentScope);
		}
		return parentScope;
	}
	
	protected IScope createTypeScope(JvmIdentifiableElement context, EReference reference, IScope parentScope) {
		if (context == null)
			return parentScope;
		if (context.eContainer() instanceof JvmIdentifiableElement) {
			parentScope = createTypeScope((JvmIdentifiableElement) context.eContainer(), reference, parentScope);
		}
		if (context instanceof JvmGenericType) {
			JvmGenericType genericType = (JvmGenericType) context;
			List<IEObjectDescription> descriptions = Lists.newArrayList();
			if (genericType.getSimpleName() != null) {
				QualifiedName inferredDeclaringTypeName = QualifiedName.create(genericType.getSimpleName());
				descriptions.add(EObjectDescription.create(inferredDeclaringTypeName, genericType));
			}
			for (JvmTypeParameter param : genericType.getTypeParameters()) {
				if (param.getSimpleName() != null) {
					QualifiedName paramName = QualifiedName.create(param.getSimpleName());
					descriptions.add(EObjectDescription.create(paramName, param));
				}
			}
			if (!descriptions.isEmpty())
				return MapBasedScope.createScope(parentScope, descriptions);
		} else if ( context instanceof JvmOperation) {
			JvmOperation operation = (JvmOperation) context;
			List<IEObjectDescription> descriptions = null;
			for (JvmTypeParameter param : operation.getTypeParameters()) {
				if (param.getSimpleName() != null) {
					if (descriptions == null)
						descriptions = Lists.newArrayList();
					QualifiedName paramName = QualifiedName.create(param.getSimpleName());
					descriptions.add(EObjectDescription.create(paramName, param));
				}
			}
			if (descriptions != null && !descriptions.isEmpty())
				return MapBasedScope.createScope(parentScope, descriptions);
		}
		return parentScope;
	}

	protected JvmIdentifiableElement getLogicalContainer(EObject context) {
		if (context == null)
			return null;
		JvmIdentifiableElement associatedContainer = expressionContext.getLogicalContainer(context);
		if (associatedContainer != null)
			return associatedContainer;
		return getLogicalContainer(context.eContainer());
	}
	
	protected boolean isTypeScope(EReference reference) {
		return TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(reference.getEReferenceType());
	}

	protected IScope createConstructorCallScope(final EObject context, EReference reference) {
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
								XConstructorCall constructorCall = null;
								if (context instanceof XConstructorCall)
									constructorCall = (XConstructorCall) context;
								ITypeArgumentContext typeArgumentContext = typeArgumentContextHelper.getTypeArgumentContext(constructorCall, constructor);
								JvmFeatureDescription result = new JvmFeatureDescription(
										from.getQualifiedName(), 
										constructor,
										typeArgumentContext,
										constructor.getIdentifier(),
										true,
										null,
										null,
										0);
								result.setGenericTypeContext(typeArgumentContext);
								return result;
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
		IScope staticScope = createStaticScope(context, resource, IScope.NULLSCOPE);
		DelegatingScope delegatingStaticScope = new DelegatingScope(IScope.NULLSCOPE);
		DelegatingScope implicitThis = new DelegatingScope(delegatingStaticScope);
		LocalVariableScopeContext scopeContext = createLocalVariableScopeContext(context, reference, includeCurrentBlock, idx);
		IScope localVariableScope = createLocalVarScope(implicitThis, scopeContext);
		IScope scopeForImplicitFeatures = createImplicitFeatureCallScope(context, IScope.NULLSCOPE, localVariableScope);
		implicitThis.setDelegate(scopeForImplicitFeatures);
		delegatingStaticScope.setDelegate(staticScope);
		return localVariableScope;
	}

	protected LocalVariableScopeContext createLocalVariableScopeContext(final EObject context, EReference reference,
			boolean includeCurrentBlock, int idx) {
		return new LocalVariableScopeContext(context, reference, includeCurrentBlock, idx, false, expressionContext);
	}

	protected IScope createStaticScope(final EObject context, Resource resource, IScope parent) {
		JvmDeclaredType contextType = getContextType(context);
		List<IJvmFeatureDescriptionProvider> descriptionProviders = getStaticFeatureDescriptionProviders(resource, contextType);
		Function<JvmFeatureDescription, ITypeArgumentContext> contextFactory = new Function<JvmFeatureDescription, ITypeArgumentContext>() {

			public ITypeArgumentContext apply(JvmFeatureDescription from) {
				JvmIdentifiableElement feature = from.getEObjectOrProxy();
				if (feature instanceof JvmExecutable && context instanceof XAbstractFeatureCall) {
					XAbstractFeatureCall featureCall = (XAbstractFeatureCall) context;
					List<XExpression> arguments = featureCallToJavaMapping.getActualArguments(
							featureCall, feature, from.getImplicitReceiver(), from.getImplicitArgument());
					ITypeArgumentContext result = typeArgumentContextHelper.getTypeArgumentContext(
							featureCall,
							arguments,
							null, 
							feature);
					return result;
				}
				return null;
			}
			
		};
		return jvmFeatureScopeProvider.createFeatureScopeForTypeRef(parent, null, contextFactory, descriptionProviders);
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
	protected IScope createImplicitFeatureCallScope(final EObject call, final IScope parent, IScope localVariableScope) {
		IScope result = parent;
		IEObjectDescription thisVariable = localVariableScope.getSingleElement(THIS);
		if (thisVariable != null) {
			EObject implicitReceiver = thisVariable.getEObjectOrProxy();
			JvmTypeReference implicitReceiverType = typeProvider.getTypeForIdentifiable((JvmIdentifiableElement) implicitReceiver);
			if (implicitReceiverType != null && implicitReceiver instanceof JvmIdentifiableElement) {
				XFeatureCall receiver = XbaseFactory.eINSTANCE.createXFeatureCall();
				receiver.setFeature((JvmIdentifiableElement) implicitReceiver);
				result = createFeatureScopeForTypeRef(
						implicitReceiverType, 
						call, 
						getContextType(call),
						receiver,
						result);
			}
		}
		IEObjectDescription itVariable = localVariableScope.getSingleElement(IT);
		if (itVariable != null) {
			EObject implicitReceiver = itVariable.getEObjectOrProxy();
			JvmTypeReference implicitReceiverType = typeProvider.getTypeForIdentifiable((JvmIdentifiableElement) implicitReceiver);
			if (implicitReceiverType != null && implicitReceiver instanceof JvmIdentifiableElement) {
				XFeatureCall receiver = XbaseFactory.eINSTANCE.createXFeatureCall();
				receiver.setFeature((JvmIdentifiableElement) implicitReceiver);
				result = createFeatureScopeForTypeRef(
						implicitReceiverType, 
						call, 
						getContextType(call),
						receiver,
						result);
			}
		}
		return result;
	}
	
	protected JvmDeclaredType getContextType(EObject obj) {
		if (obj == null)
			return null;
		if (obj instanceof JvmDeclaredType) {
			return (JvmDeclaredType) obj;
		}
		if (obj instanceof XExpression) {
			JvmIdentifiableElement element = expressionContext.getLogicalContainer(obj);
			if (element != null) {
				if (element instanceof JvmDeclaredType) {
					return (JvmDeclaredType) element;
				} else if (element instanceof JvmMember) {
					return ((JvmMember) element).getDeclaringType();
				}
			}
		}
		return getContextType(obj.eContainer());
	}
	
	protected IScope createLocalVarScope(IScope parentScope, LocalVariableScopeContext scopeContext) {
		if (scopeContext == null || scopeContext.getContext() == null)
			return parentScope;
		if (scopeContext.canSpawnForContainer())
			parentScope = createLocalVarScope(parentScope, scopeContext.spawnForContainer());
		EObject context = scopeContext.getContext();
		if (context.eContainer() instanceof XBlockExpression) {
			XBlockExpression block = (XBlockExpression) context.eContainer();
			parentScope = createLocalVarScopeForBlock(block, block.getExpressions().indexOf(context), scopeContext.isReferredFromClosure(), parentScope);
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
		if (context instanceof JvmOperation) {
			parentScope = createLocalVarScopeForJvmOperation((JvmOperation)context, parentScope);
		}
		if (context instanceof JvmConstructor) {
			parentScope = createLocalVarScopeForJvmConstructor((JvmConstructor)context, parentScope);
		}
		if (context instanceof JvmDeclaredType) {
			parentScope = createLocalVarScopeForJvmDeclaredType((JvmDeclaredType)context, parentScope);
		}
		if (scopeContext.isIncludeCurrentBlock()) {
			if (context instanceof XBlockExpression) {
				XBlockExpression block = (XBlockExpression) context;
				if (!block.getExpressions().isEmpty()) {
					parentScope = createLocalVarScopeForBlock(block, scopeContext.getIndex(), scopeContext.isReferredFromClosure(), parentScope);
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

	protected IScope createLocalVarScopeForJvmOperation(JvmOperation context, IScope parentScope) {
		EList<JvmFormalParameter> parameters = context.getParameters();
		List<LocalVarDescription> descriptions = newArrayList();
		for (JvmFormalParameter p : parameters) {
			if (p.getName() != null)
				descriptions.add(new LocalVarDescription(QualifiedName.create(p.getName()), p));
		}
		return new JvmFeatureScope(parentScope, "operation "+context.getSimpleName(), descriptions);
	}
	
	protected IScope createLocalVarScopeForJvmConstructor(JvmConstructor context, IScope parentScope) {
		EList<JvmFormalParameter> parameters = context.getParameters();
		List<LocalVarDescription> descriptions = newArrayList();
		for (JvmFormalParameter p : parameters) {
			if (p.getName() != null)
				descriptions.add(new LocalVarDescription(QualifiedName.create(p.getName()), p));
		}
		return new JvmFeatureScope(parentScope, "constructor "+context.getSimpleName(), descriptions);
	}

	protected IScope createLocalVarScopeForJvmDeclaredType(JvmDeclaredType type, IScope parentScope) {
		Iterator<JvmTypeReference> classes = filter(type.getSuperTypes(), new Predicate<JvmTypeReference>() {
			public boolean apply(JvmTypeReference input) {
				if (input.getType() instanceof JvmGenericType) {
					return !((JvmGenericType)input.getType()).isInterface();
				}
				return false;
			}
		}).iterator();
		JvmGenericType superType = null;
		if (classes.hasNext()) {
			superType = (JvmGenericType) classes.next().getType();
		}
		if (superType == null) {
			return new JvmFeatureScope(parentScope, "this", new LocalVarDescription(THIS, type));
		} else {
			return new JvmFeatureScope(parentScope, "this & super", newArrayList(
					new LocalVarDescription(THIS, type), 
					new LocalVarDescription(QualifiedName.create("super"), superType)));
		}
	}

	protected boolean adaptsToJvmElement(EObject context) {
		if (context instanceof XExpression) {
			return expressionContext.getLogicalContainer(context) != null;
		}
		return false;
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

	protected JvmFeatureScope createFeatureScopeForTypeRef(final JvmTypeReference receiverType, 
			final EObject expression,
			JvmDeclaredType currentContext, XExpression implicitReceiver, IScope parent) {
		class ContextFactory implements Function<JvmFeatureDescription, ITypeArgumentContext> {

			public ITypeArgumentContext apply(JvmFeatureDescription from) {
				JvmIdentifiableElement feature = from.getEObjectOrProxy();
				if (feature instanceof JvmExecutable && expression instanceof XAbstractFeatureCall) {
					XAbstractFeatureCall featureCall = (XAbstractFeatureCall) expression;
					List<XExpression> arguments = featureCallToJavaMapping.getActualArguments(
							featureCall, feature, 
							from.getImplicitReceiver(),
							from.getImplicitArgument());
					ITypeArgumentContext result = typeArgumentContextHelper.getTypeArgumentContext(
							featureCall,
							arguments,
							Providers.of(receiverType), 
							feature);
					return result;
				}
				return null;
			}
			
		}
		if (expression instanceof XAssignment) {
			List<IJvmFeatureDescriptionProvider> providers = getFeatureDescriptionProvidersForAssignment(receiverType, (XAssignment) expression, 
					currentContext, implicitReceiver);
			return jvmFeatureScopeProvider.createFeatureScopeForTypeRef(parent, receiverType, new ContextFactory(), providers);
		} else {
			List<IJvmFeatureDescriptionProvider> providers = getFeatureDescriptionProviders(receiverType, expression,
					currentContext, implicitReceiver);
			return jvmFeatureScopeProvider.createFeatureScopeForTypeRef(parent, receiverType, new ContextFactory(), providers);
		}
	}
	
	protected List<IJvmFeatureDescriptionProvider> getStaticFeatureDescriptionProviders(Resource context, JvmDeclaredType contextType) {
		StaticMethodsFeatureForTypeProvider staticProvider = newImplicitStaticFeaturesProvider();
		staticProvider.setContext(context);

		DefaultJvmFeatureDescriptionProvider defaultProvider = newDefaultFeatureDescProvider();
		XFeatureCallSugarDescriptionProvider sugarProvider = newSugarDescriptionProvider();
		
		defaultProvider.setContextType(contextType);
		defaultProvider.setFeaturesForTypeProvider(staticProvider);
		sugarProvider.setContextType(contextType);
		sugarProvider.setFeaturesForTypeProvider(staticProvider);
		
		return Lists.<IJvmFeatureDescriptionProvider>newArrayList(defaultProvider, sugarProvider);
	}

	protected List<IJvmFeatureDescriptionProvider> getFeatureDescriptionProviders(JvmTypeReference type,
			EObject expression, JvmDeclaredType currentContext, XExpression implicitReceiver) {
		DefaultJvmFeatureDescriptionProvider provider1 = newDefaultFeatureDescProvider();
		XFeatureCallSugarDescriptionProvider provider2 = newSugarDescriptionProvider();
		
		StaticMethodsFeatureForTypeProvider staticExtensionsProvider = newImplicitStaticFeaturesProvider();
		staticExtensionsProvider.setContext(expression.eResource());
		staticExtensionsProvider.setExtensionProvider(true);
		
		DefaultJvmFeatureDescriptionProvider provider3 = newDefaultFeatureDescProvider();
		provider3.setFeaturesForTypeProvider(staticExtensionsProvider);
		
		XFeatureCallSugarDescriptionProvider provider4 = newSugarDescriptionProvider();
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
		XAssignmentDescriptionProvider assignmentProvider = assignmentFeatureDescProvider.get();
		XAssignmentSugarDescriptionProvider sugarProvider = assignmentSugarFeatureDescProvider.get();
		assignmentProvider.setContextType(currentContext);
		assignmentProvider.setImplicitReceiver(implicitReceiver);
		sugarProvider.setContextType(currentContext);
		sugarProvider.setImplicitReceiver(implicitReceiver);
		List<IJvmFeatureDescriptionProvider> result = Lists.<IJvmFeatureDescriptionProvider>newArrayList(assignmentProvider, sugarProvider);
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
	
	protected FeatureCallToJavaMapping getFeatureCallToJavaMapping() {
		return featureCallToJavaMapping;
	}
	
	protected ITypeArgumentContextHelper getTypeArgumentContextHelper() {
		return typeArgumentContextHelper;
	}
}
