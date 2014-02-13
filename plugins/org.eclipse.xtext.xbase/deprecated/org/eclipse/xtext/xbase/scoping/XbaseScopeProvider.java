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

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.common.types.util.VisibilityService;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DelegatingScopeProvider;
import org.eclipse.xtext.util.IAcceptor;
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
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.impl.FeatureCallToJavaMapping;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.DefaultConstructorDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.DefaultJvmFeatureDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.IFeaturesForTypeProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.IJvmFeatureDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.IJvmFeatureScopeProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.IJvmFeatureScopeProvider.FeatureScopeDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.IValidatedEObjectDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureScope;
import org.eclipse.xtext.xbase.scoping.featurecalls.LocalVarDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.StaticImplicitMethodsFeatureForTypeProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.XAssignmentDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.XAssignmentSugarDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.XConstructorProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.XFeatureCallSugarDescriptionProvider;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.util.Providers;

/**
 * The scope provider for languages that use Xbase.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Refactored feature scoping to acceptor pattern
 */
@Deprecated
public class XbaseScopeProvider extends DelegatingScopeProvider {

	protected static final int DEFAULT_MEMBER_CALL_PRIORITY = 0;
	protected static final int DEFAULT_IT_PRIORITY = 10;
	protected static final int DEFAULT_THIS_PRIORITY = 20;
	protected static final int DEFAULT_IMPLICIT_STATIC_FEATURE_PRIORITY = 60;

	protected static final int DEFAULT_SUGAR_PRIORITY_OFFSET = 100;
	protected static final int DEFAULT_STATIC_EXTENSION_PRIORITY_OFFSET = 230;

	private final static Logger log = Logger.getLogger(XbaseScopeProvider.class);

	public static final QualifiedName THIS = QualifiedName.create("this");
	public static final QualifiedName SUPER = QualifiedName.create("super");
	public static final QualifiedName IT = QualifiedName.create("it");

	@Inject
	protected IJvmFeatureScopeProvider jvmFeatureScopeProvider;

	@Inject
	private Provider<DefaultJvmFeatureDescriptionProvider> defaultFeatureDescProvider;
	
	@Inject
	private Provider<DefaultConstructorDescriptionProvider> defaultConstructorDescProvider;
	
	@Inject
	private Provider<XConstructorProvider> constructorProvider;

	@Inject
	private Provider<XFeatureCallSugarDescriptionProvider> sugarFeatureDescProvider;

	@Inject
	private Provider<StaticImplicitMethodsFeatureForTypeProvider> implicitStaticFeatures;
	
	@Inject
	private Provider<XAssignmentDescriptionProvider> assignmentFeatureDescProvider;

	@Inject
	private Provider<XAssignmentSugarDescriptionProvider> assignmentSugarFeatureDescProvider;

	@Inject
	private ITypeProvider typeProvider;
	
	@Inject
	private IBatchTypeResolver batchTypeResolver;

	@Inject
	private FeatureCallToJavaMapping featureCallToJavaMapping;
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private ILogicalContainerProvider logicalContainerProvider;
	
	@Inject
	private VisibilityService visibilityService;
	
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

	
	protected boolean isVisible(JvmFeature feature, JvmDeclaredType contextType) {
		return visibilityService.isVisible(feature, contextType);
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
								JvmConstructor constructor = (JvmConstructor) from.getEObjectOrProxy();
								if (constructor.eIsProxy()) {
									EObject resolved = EcoreUtil.resolve(constructor, context);
									if (resolved instanceof JvmConstructor)
										constructor = (JvmConstructor) resolved;
								}
								XConstructorCall constructorCall = null;
								if (context instanceof XConstructorCall)
									constructorCall = (XConstructorCall) context;
								ITypeArgumentContext typeArgumentContext = typeProvider.getTypeArgumentContext(constructorCall, constructor);
								JvmDeclaredType contextType = getContextType(constructorCall);
								JvmFeatureDescription result = new JvmFeatureDescription(
										from.getQualifiedName(), 
										constructor,
										typeArgumentContext,
										constructor.getIdentifier(),
										isVisible(constructor, contextType),
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
	public IScope createSimpleFeatureCallScope(EObject context, EReference reference, Resource resource, boolean includeCurrentBlock, int idx) {
		DelegatingScope implicitFeaturesAndStatics = new DelegatingScope(IScope.NULLSCOPE);
		LocalVariableScopeContext scopeContext = createLocalVariableScopeContext(context, reference, includeCurrentBlock, idx);
		IScope localVariableScope = createLocalVarScope(implicitFeaturesAndStatics, scopeContext);
		IScope scopeForImplicitFeatures = createImplicitFeatureCallScope(context, resource, IScope.NULLSCOPE, localVariableScope);
		implicitFeaturesAndStatics.setDelegate(scopeForImplicitFeatures);
		return localVariableScope;
	}
	
	/**
	 * @param declaringType the type that declares the feature
	 * @param implicitReceiver the instance that will receive the message.
	 * @param expression the expression that is closest to the to-be-created scope. Usually the feature call.
	 */
	protected IScope createFeatureScopeForTypeRef(
			JvmTypeReference declaringType, 
			EObject expression,
			XExpression implicitReceiver,
			IScope parent) {
		JvmFeatureScopeAcceptor featureScopeDescriptions = new JvmFeatureScopeAcceptor();
		addFeatureScopes(declaringType, expression, getContextType(expression), implicitReceiver, null, getDefaultPriority(), featureScopeDescriptions);
		IScope result = featureScopeDescriptions.createScope(parent);
		return result;
	}

	protected LocalVariableScopeContext createLocalVariableScopeContext(final EObject context, EReference reference,
			boolean includeCurrentBlock, int idx) {
		return new LocalVariableScopeContext(context, reference, includeCurrentBlock, idx, false, logicalContainerProvider);
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
		if (context instanceof XNullLiteral)
			receiverType = unkownToObject(receiverType, receiver);
		if (receiverType != null) {
			if (receiver instanceof XAbstractFeatureCall && ((XAbstractFeatureCall) receiver).isTypeLiteral()) {
				XAbstractFeatureCall featureCall = (XAbstractFeatureCall) receiver;
				JvmTypeReference typeReference = typeReferences.createTypeRef((JvmType)featureCall.getFeature());
				JvmFeatureScopeAcceptor featureScopeDescriptions = new JvmFeatureScopeAcceptor();
				IAcceptor<IJvmFeatureDescriptionProvider> curried = featureScopeDescriptions.curry(typeReference, featureCall);
				addFeatureDescriptionProviders(getContextType(featureCall), null, null, null, getDefaultPriority(), true, curried);
				if (receiver.eContainingFeature() == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
					XMemberFeatureCall memberFeatureCall = (XMemberFeatureCall) receiver.eContainer();
					if (!memberFeatureCall.isExplicitStatic()) {
						addFeatureScopes(receiverType, context, getContextType(context), null, null, getDefaultPriority(), featureScopeDescriptions);
					}
				}
				IScope result = featureScopeDescriptions.createScope(IScope.NULLSCOPE);
				return result;
			}
			return createFeatureScopeForTypeRef(receiverType, context, null, IScope.NULLSCOPE);
		} else {
			return IScope.NULLSCOPE;
		}
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
	protected IScope createImplicitFeatureCallScope(EObject call, Resource resource, IScope parent, IScope localVariableScope) {
		JvmFeatureScopeAcceptor featureScopeDescriptions = new JvmFeatureScopeAcceptor();
		addFeatureCallScopes(call, localVariableScope, featureScopeDescriptions);
			
		JvmDeclaredType contextType = getContextType(call);
		IAcceptor<IJvmFeatureDescriptionProvider> acceptorWithoutContext = featureScopeDescriptions.curry(null, call);
		addStaticFeatureDescriptionProviders(resource, contextType, acceptorWithoutContext);
		if (contextType != null) {
			IAcceptor<IJvmFeatureDescriptionProvider> acceptorWithContext = featureScopeDescriptions.curry(typeReferences.createTypeRef(contextType), call);
			addFeatureDescriptionProviders(contextType, null, null, null, getImplicitStaticFeaturePriority(), true, acceptorWithContext);
		}

		IScope result = featureScopeDescriptions.createScope(parent);
		return result;
	}
	
	protected void addFeatureCallScopes(EObject featureCall, IScope localVariableScope,
			IJvmFeatureScopeAcceptor featureScopeDescriptions) {
		addFeatureCallScopes(featureCall, localVariableScope, THIS, getThisPriority(), featureScopeDescriptions);
		addFeatureCallScopes(featureCall, localVariableScope, IT, getItPriority(), featureScopeDescriptions);
		
		JvmIdentifiableElement logicalContainer = logicalContainerProvider.getNearestLogicalContainer(featureCall);
		if (logicalContainer instanceof JvmConstructor) {
			JvmConstructor constructor = (JvmConstructor) logicalContainer;
			JvmDeclaredType contextType = constructor.getDeclaringType();
			JvmTypeReference receiverType = typeReferences.createTypeRef(contextType);
			IAcceptor<IJvmFeatureDescriptionProvider> acceptor = featureScopeDescriptions.curry(receiverType, featureCall);
			DefaultConstructorDescriptionProvider defaultProvider = newDefaultConstructorDescriptionProvider();
			XConstructorProvider featureProvider = newConstructorProvider();
			defaultProvider.setContextType(contextType);
			defaultProvider.setPriority(getDefaultPriority());
			defaultProvider.setFeaturesForTypeProvider(featureProvider);
			acceptor.accept(defaultProvider);			
		}
	}

	protected void addFeatureCallScopes(
			EObject expression, 
			IScope localVariableScope,
			QualifiedName variableName,
			int priority,
			IJvmFeatureScopeAcceptor featureScopeDescriptions) {
		IEObjectDescription implicitVariable = localVariableScope.getSingleElement(variableName);
		if (implicitVariable != null) {
			EObject implicitReceiver = implicitVariable.getEObjectOrProxy();
			if (implicitReceiver instanceof JvmIdentifiableElement) {
				IResolvedTypes resolvedTypes = batchTypeResolver.getResolvedTypesInContextOf(expression);
				LightweightTypeReference lightweightReceiverType = resolvedTypes.getActualType((JvmIdentifiableElement) implicitReceiver);
				JvmTypeReference receiverType = null;
				if (lightweightReceiverType != null) {
					receiverType = lightweightReceiverType.toTypeReference();
				} else {
					receiverType = typeProvider.getTypeForIdentifiable((JvmIdentifiableElement) implicitReceiver);
				}
				receiverType = unkownToObject(receiverType, expression);
				if (receiverType != null) {
					XFeatureCall receiver = XbaseFactory.eINSTANCE.createXFeatureCall();
					receiver.setFeature((JvmIdentifiableElement) implicitReceiver);
					addFeatureScopes(receiverType, expression, getContextType(expression), receiver, null, priority, featureScopeDescriptions);
				}
			}
		}
	}
	
	protected JvmTypeReference unkownToObject(JvmTypeReference receiverType, EObject context) {
		if (receiverType instanceof JvmUnknownTypeReference) {
			return typeReferences.getTypeForName(Object.class, context);
		}
		if (receiverType instanceof JvmAnyTypeReference && receiverType.getType() != null && receiverType.getType().eIsProxy()) {
			EObject resolved = EcoreUtil.resolve(receiverType.getType(), context);
			((JvmAnyTypeReference) receiverType).setType((JvmType) resolved);
		}
		return receiverType;
	}

	protected JvmDeclaredType getContextType(EObject obj) {
		if (obj == null)
			return null;
		if (obj instanceof JvmDeclaredType) {
			return (JvmDeclaredType) obj;
		}
		if (obj instanceof XExpression) {
			JvmIdentifiableElement element = logicalContainerProvider.getLogicalContainer(obj);
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
	
	/**
	 * @noextend This interface is not intended to be extended by clients.
	 * @noimplement This interface is not intended to be implemented by clients.
	 */
	public interface LocalVariableAcceptor {

		void accept(String description, IValidatedEObjectDescription object);
		
		void accept(String description, List<? extends IValidatedEObjectDescription> objects);
		
	}
	
	protected IScope createLocalVarScope(final IScope parentScope, LocalVariableScopeContext scopeContext) {
		if (scopeContext == null || scopeContext.getContext() == null)
			return parentScope;
		class ScopeBuilder implements LocalVariableAcceptor {
			IScope scope = parentScope;

			public void accept(String description, IValidatedEObjectDescription object) {
				if (object != null)
					accept(description, Collections.singletonList(object));
			}

			public void accept(String description, List<? extends IValidatedEObjectDescription> objects) {
				if (!objects.isEmpty())
					scope = new JvmFeatureScope(scope, description, objects);
			}
		}
		
		ScopeBuilder builder = new ScopeBuilder();
		createLocalVarScope(builder, scopeContext);
		return builder.scope;
	}
	
	protected void createLocalVarScope(LocalVariableAcceptor acceptor, LocalVariableScopeContext scopeContext) {
		
		EObject context = scopeContext.getContext();
		if (context instanceof JvmOperation) {
			JvmOperation jvmOperation = (JvmOperation) context;
			if (jvmOperation.getDeclaringType() != null) {
				JvmDeclaredType declaredType = jvmOperation.getDeclaringType();
				if (!jvmOperation.isStatic()) {
					createLocalVarScopeForJvmDeclaredType(declaredType, acceptor);
				}
			}
			createLocalVarScopeForJvmOperation((JvmOperation)context, acceptor);
			return;
		}
		if (context instanceof JvmConstructor) {
			JvmConstructor constructor = (JvmConstructor) context;
			if (constructor.getDeclaringType() != null) {
				JvmDeclaredType declaredType = constructor.getDeclaringType();
				createLocalVarScopeForJvmDeclaredType(declaredType, acceptor);
			}
			createLocalVarScopeForJvmConstructor((JvmConstructor)context, acceptor);
			return;
		}
		if (context instanceof JvmField) {
			JvmField field = (JvmField) context;
			if (field.getDeclaringType() != null) {
				JvmDeclaredType declaredType = field.getDeclaringType();
				if (!field.isStatic()) {
					createLocalVarScopeForJvmDeclaredType(declaredType, acceptor);
				}
			}
			return;
		}
		if(context instanceof JvmDeclaredType) {
			createLocalVarScopeForJvmDeclaredType((JvmDeclaredType) context, acceptor);
			return;
		}
		if (scopeContext.canSpawnForContainer())
			createLocalVarScope(acceptor, scopeContext.spawnForContainer());
		if (context.eContainer() instanceof XBlockExpression) {
			XBlockExpression block = (XBlockExpression) context.eContainer();
			createLocalVarScopeForBlock(block, block.getExpressions().indexOf(context), scopeContext.isReferredFromClosure(), acceptor);
		}
		if (context.eContainer() instanceof XForLoopExpression && context.eContainingFeature() == XbasePackage.Literals.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION) {
			XForLoopExpression loop = (XForLoopExpression) context.eContainer();
			createLocalScopeForParameter(loop.getDeclaredParam(), acceptor);
		}
		if (context.eContainer() instanceof XCatchClause) {
			XCatchClause catchClause = (XCatchClause) context.eContainer();
			createLocalScopeForParameter(catchClause.getDeclaredParam(), acceptor);
		}
		if (context instanceof XClosure) {
			createLocalVarScopeForClosure((XClosure) context, acceptor);
		}
		if (context instanceof XCasePart) {
			createLocalVarScopeForTypeGuardedCase((XCasePart) context, acceptor);
		}
		if (context instanceof XSwitchExpression) {
			createLocalVarScopeForSwitchExpression((XSwitchExpression) context, acceptor);
		}
		if (scopeContext.isIncludeCurrentBlock()) {
			if (context instanceof XBlockExpression) {
				XBlockExpression block = (XBlockExpression) context;
				if (!block.getExpressions().isEmpty()) {
					createLocalVarScopeForBlock(block, scopeContext.getIndex(), scopeContext.isReferredFromClosure(), acceptor);
				}
			}
			if (context instanceof XForLoopExpression) {
				createLocalScopeForParameter(((XForLoopExpression) context).getDeclaredParam(), acceptor);
			}
			if (context instanceof XCatchClause) {
				createLocalScopeForParameter(((XCatchClause) context).getDeclaredParam(), acceptor);
			}
		}
	}

	protected void createLocalVarScopeForJvmOperation(JvmOperation context, LocalVariableAcceptor acceptor) {
		List<JvmFormalParameter> parameters = context.getParameters();
		if (parameters.isEmpty())
			return;
		List<LocalVarDescription> descriptions = newArrayList();
		for (JvmFormalParameter p : parameters) {
			if (p.getName() != null)
				descriptions.add(new LocalVarDescription(QualifiedName.create(p.getName()), p));
		}
		acceptor.accept("operation "+context.getSimpleName(), descriptions);
	}
	
	protected void createLocalVarScopeForJvmConstructor(JvmConstructor context, LocalVariableAcceptor acceptor) {
		List<JvmFormalParameter> parameters = context.getParameters();
		if (parameters.isEmpty())
			return;
		List<LocalVarDescription> descriptions = newArrayList();
		for (JvmFormalParameter p : parameters) {
			if (p.getName() != null)
				descriptions.add(new LocalVarDescription(QualifiedName.create(p.getName()), p));
		}
		acceptor.accept("constructor "+context.getSimpleName(), descriptions);
	}

	protected void createLocalVarScopeForJvmDeclaredType(JvmDeclaredType type, LocalVariableAcceptor acceptor) {
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
			acceptor.accept("this", new LocalVarDescription(THIS, type));
		} else {
			acceptor.accept("this & super", newArrayList(
					new LocalVarDescription(THIS, type), 
					new LocalVarDescription(SUPER, superType)));
		}
	}

	protected boolean adaptsToJvmElement(EObject context) {
		if (context instanceof XExpression) {
			return logicalContainerProvider.getLogicalContainer(context) != null;
		}
		return false;
	}

	protected void createLocalVarScopeForSwitchExpression(XSwitchExpression context, LocalVariableAcceptor acceptor) {
		JvmFormalParameter declaredParam = context.getDeclaredParam();
		if (declaredParam != null) {
			acceptor.accept("XSwitchExpression",
					new LocalVarDescription(QualifiedName.create(declaredParam.getName()), declaredParam));
		}
	}

	/**
	 * Allows to hook into the case guards to introduce new local variables with a specialized type.
	 * Implemented as no-op by default.
	 * @param context the case part.
	 * @param acceptor the acceptor.
	 */
	protected void createLocalVarScopeForTypeGuardedCase(XCasePart context, LocalVariableAcceptor acceptor) {
	}

	/**
	 * Allows to hook into the local variable definition for catch clauses.
	 * @param catchClause the catch clause.
	 * @param indexOfContextExpressionInBlock the index of the context expression in its surrounding block.
	 * @param acceptor the the acceptor.
	 */
	protected void createLocalVarScopeForCatchClause(XCatchClause catchClause, int indexOfContextExpressionInBlock,
			LocalVariableAcceptor acceptor) {
		createLocalScopeForParameter(catchClause.getDeclaredParam(), acceptor);
	}

	protected void createLocalVarScopeForBlock(
			XBlockExpression block, int indexOfContextExpressionInBlock,
			boolean referredFromClosure, LocalVariableAcceptor acceptor) {
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
		if (descriptions.isEmpty())
			return;
		acceptor.accept("XBlockExpression", descriptions);
	}

	protected void createLocalVarScopeForClosure(XClosure closure, LocalVariableAcceptor acceptor) {
		List<IValidatedEObjectDescription> descriptions = Lists.newArrayList();
		EList<JvmFormalParameter> params = closure.getFormalParameters();
		for (JvmFormalParameter p : params) {
			if (p.getName() != null) {
				IValidatedEObjectDescription desc = createLocalVarDescription(p);
				descriptions.add(desc);
			}
		}
		acceptor.accept("XClosure", descriptions);
	}

	public interface IJvmFeatureScopeAcceptor {
		void acceptScope(
				JvmTypeReference featureDeclarator, 
				Function<JvmFeatureDescription,ITypeArgumentContext> contextFactory, 
				IJvmFeatureDescriptionProvider provider);
		
		IAcceptor<IJvmFeatureDescriptionProvider> curry(
				JvmTypeReference featureDeclarator,
				EObject expression);
	}
	
	protected abstract class AbstractJvmFeatureScopeAcceptor implements IJvmFeatureScopeAcceptor {

		public IAcceptor<IJvmFeatureDescriptionProvider> curry(
				JvmTypeReference featureDeclarator,
				EObject expression) {
			return new SimpleAcceptor(this, featureDeclarator, expression);
		}
	}
	
	protected class SimpleAcceptor implements IAcceptor<IJvmFeatureDescriptionProvider> {
		private final Function<JvmFeatureDescription, ITypeArgumentContext> contextFactory;
		private final IJvmFeatureScopeAcceptor parent;
		private final JvmTypeReference receiverType;
		private final EObject expression;

		protected SimpleAcceptor(
				IJvmFeatureScopeAcceptor parent,
				JvmTypeReference receiverType, 
				EObject expression) {
			this.parent = parent;
			this.receiverType = receiverType;
			this.expression = expression;
			this.contextFactory = new GenericTypeArgumentContextFactory(receiverType, expression);
		}

		public void accept(IJvmFeatureDescriptionProvider provider) {
			parent.acceptScope(receiverType, contextFactory, provider);
		}
		
		public IJvmFeatureScopeAcceptor getParent() {
			return parent;
		}
		
		public EObject getExpression() {
			return expression;
		}
		
		public JvmTypeReference getReceiverType() {
			return receiverType;
		}
		
	}
	
	protected class JvmFeatureScopeAcceptor extends AbstractJvmFeatureScopeAcceptor {
		
		private final List<IJvmFeatureScopeProvider.FeatureScopeDescription> descriptions;
		
		public JvmFeatureScopeAcceptor() {
			this.descriptions = Lists.newArrayList();
		}
		
		public void acceptScope(
				JvmTypeReference featureDeclarator, 
				Function<JvmFeatureDescription,ITypeArgumentContext> contextFactory, 
				IJvmFeatureDescriptionProvider provider) {
			descriptions.add(new IJvmFeatureScopeProvider.FeatureScopeDescription(featureDeclarator, contextFactory, provider));
		}
		
		public IScope createScope(IScope parent) {
			if (descriptions.isEmpty())
				return parent;
			sortDescriptionsFromLowestToHighest(descriptions);
			IScope result = jvmFeatureScopeProvider.createFeatureScope(parent, descriptions);
			return result;
		}
	}
	
	protected void sortDescriptionsFromLowestToHighest(List<IJvmFeatureScopeProvider.FeatureScopeDescription> list) {
		Collections.sort(list, new Comparator<IJvmFeatureScopeProvider.FeatureScopeDescription>() {
			public int compare(FeatureScopeDescription o1, FeatureScopeDescription o2) {
				int prio1 = o1.getDescriptionProvider().getPriority();
				int prio2 = o2.getDescriptionProvider().getPriority();
				if (prio1 < prio2)
					return 1;
				if (prio1 > prio2)
					return -1;
				return 0;
			}
		});
		if (log.isDebugEnabled()) {
			log.debug("sortedDescriptionsFromLowestToHighest:\n" + Joiner.on('\n').join(list));
		}
	}
	
	protected class GenericTypeArgumentContextFactory implements Function<JvmFeatureDescription, ITypeArgumentContext> {

		private final EObject expression;
		private final JvmTypeReference receiverType;

		public GenericTypeArgumentContextFactory(JvmTypeReference receiverType, EObject expression) {
			this.receiverType = receiverType;
			this.expression = expression;
		}
		
		public ITypeArgumentContext apply(JvmFeatureDescription from) {
			JvmIdentifiableElement feature = from.getEObjectOrProxy();
			if (feature instanceof JvmExecutable && expression instanceof XAbstractFeatureCall) {
				XAbstractFeatureCall featureCall = (XAbstractFeatureCall) expression;
				List<XExpression> arguments = featureCallToJavaMapping.getActualArguments(
						featureCall, feature, 
						from.getImplicitReceiver(),
						from.getImplicitArgument());
				ITypeArgumentContext result = typeProvider.getTypeArgumentContext(
						featureCall,
						arguments,
						receiverType != null ? Providers.of(receiverType) : null, 
						feature);
				return result;
			}
			return null;
		}
		
	}
	
	protected void addFeatureScopes(
			JvmTypeReference receiverType, 
			EObject expression,
			JvmDeclaredType contextType, 
			XExpression implicitReceiver, 
			XExpression implicitArgument, 
			int priority,
			IJvmFeatureScopeAcceptor acceptor) {
		IAcceptor<IJvmFeatureDescriptionProvider> curried = acceptor.curry(receiverType, expression);
		if (expression instanceof XAssignment) {
			addFeatureDescriptionProvidersForAssignment(expression.eResource(), contextType, implicitReceiver, implicitArgument, priority, curried);
		} else {
			addFeatureDescriptionProviders(expression.eResource(), contextType, implicitReceiver, implicitArgument, priority, curried);
		}
	}
	
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

	protected StaticImplicitMethodsFeatureForTypeProvider newImplicitStaticFeaturesProvider() {
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

	protected void createLocalScopeForParameter(JvmFormalParameter p, LocalVariableAcceptor acceptor) {
		if (p.getName() != null)
			acceptor.accept("JvmFormalParameter", createLocalVarDescription(p));
	}

	protected IValidatedEObjectDescription createLocalVarDescription(JvmFormalParameter p) {
		return new LocalVarDescription(QualifiedName.create(p.getName()), p);
	}

	protected IValidatedEObjectDescription createLocalVarDescription(XVariableDeclaration varDecl) {
		return new LocalVarDescription(QualifiedName.create(varDecl.getName()), varDecl);
	}
	
	protected DefaultJvmFeatureDescriptionProvider newDefaultFeatureDescriptionProvider() {
		return defaultFeatureDescProvider.get();
	}
	
	protected DefaultConstructorDescriptionProvider newDefaultConstructorDescriptionProvider() {
		return defaultConstructorDescProvider.get();
	}
	
	protected XConstructorProvider newConstructorProvider() {
		return constructorProvider.get();
	}
	
	protected XFeatureCallSugarDescriptionProvider newSugarDescriptionProvider() {
		return sugarFeatureDescProvider.get();
	}
	
	protected FeatureCallToJavaMapping getFeatureCallToJavaMapping() {
		return featureCallToJavaMapping;
	}
	
}
