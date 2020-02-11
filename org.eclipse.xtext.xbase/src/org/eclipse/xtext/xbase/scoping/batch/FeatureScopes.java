/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.internal.FeatureLinkHelper;
import org.eclipse.xtext.xbase.typesystem.internal.ScopeProviderAccess;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.util.FeatureCallAsTypeLiteralHelper;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Utility class when dealing with feature scopes or constructor scopes.
 * Clients may want to override this one if they want to 
 * add a new implicit receiver.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * TODO constructor scopes
 */
@Singleton
public class FeatureScopes implements IFeatureNames {

	@Inject
	private OperatorMapping operatorMapping;
	
	@Inject
	private IResolvedFeatures.Provider resolvedFeaturesProvider;
	
	@Inject
	private SynonymTypesProvider synonymProvider;
	
	@Inject(optional = true)
	private XbaseFactory xbaseFactory = XbaseFactory.eINSTANCE;
	
	@Inject
	private FeatureCallAsTypeLiteralHelper typeLiteralHelper;
	
	/**
	 * creates the feature scope for {@link XAbstractFeatureCall}, including the local variables in case it is a feature
	 * call without receiver (XFeatureCall).
	 * @param session the currently available session data
	 */
	public IScope createFeatureCallScope(EObject context, EReference reference, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		if (!isFeatureCallScope(reference)) {
			throw new IllegalArgumentException(String.valueOf(reference));
		}
		if (!(context instanceof XAbstractFeatureCall)) {
			return IScope.NULLSCOPE;
		}
		XAbstractFeatureCall call = (XAbstractFeatureCall) context;
		final XExpression syntacticalReceiver = getSyntacticalReceiver(call);
		if (syntacticalReceiver == null) {
			IScope result = createSimpleFeatureCallScope(call, session, resolvedTypes);
			return result;
		}
		IScope result = createFeatureCallScopeForReceiver(call, syntacticalReceiver, session, resolvedTypes);
		return result;
	}

	public boolean isFeatureCallScope(EReference reference) {
		return reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
	}
	
	/**
	 * This method serves as an entry point for the content assist scoping for simple feature calls.
	 * @param context the context e.g. a for loop expression, a block or a catch clause
	 */
	public IScope createSimpleFeatureCallScope(EObject context, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		IScope root = IScope.NULLSCOPE;
		if (context instanceof XFeatureCall) {
			XFeatureCall featureCall = (XFeatureCall) context;
			if (!featureCall.isExplicitOperationCallOrBuilderSyntax()) {
				root = createTypeLiteralScope(context, QualifiedName.EMPTY, root, session, resolvedTypes);
				if (isDefiniteTypeLiteral(featureCall)) {
					return root;
				}
			}
		}
		IScope staticImports = createStaticFeaturesScope(context, root, session);
		IScope staticMembers = createStaticScope(asAbstractFeatureCall(context), null, null, staticImports, session, resolvedTypes);
		IScope staticExtensions = createStaticExtensionsScope(null, null, context, staticMembers, session, resolvedTypes);
		// we don't want to use captured instances of 'IT' as dynamic extension implicit argument
		// thus the dynamic extension scope only works for the *real* local variables
		IScope dynamicExtensions = createDynamicExtensionsScope(null, null, context, staticExtensions, session, resolvedTypes);
		IScope localVariables = createImplicitFeatureCallAndLocalVariableScope(context, dynamicExtensions, session, resolvedTypes);
		return localVariables;
	}

	protected IScope createImplicitFeatureCallAndLocalVariableScope(EObject context, IScope parent, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		IFeatureScopeSession nextCaptureLayer = session.getNextCaptureLayer();
		if (nextCaptureLayer != null) {
			parent = createImplicitFeatureCallAndLocalVariableScope(context, parent, nextCaptureLayer, resolvedTypes);
		}
		IScope implicitReceivers = createImplicitFeatureCallScope(context, parent, session, resolvedTypes);
		IScope constructors = createConstructorDelegates(context, implicitReceivers, session, resolvedTypes);
		IScope localVariables = createLocalVariableScope(context, constructors, session, resolvedTypes);
		return localVariables;
	}

	protected boolean isDefiniteTypeLiteral(XFeatureCall featureCall) {
		return typeLiteralHelper.isDefiniteTypeLiteral(featureCall);
	}

	protected IScope createConstructorDelegates(EObject context, IScope parent, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		if (session.isConstructorContext()) {
			IEObjectDescription thisDescription = session.getLocalElement(THIS);
			if (thisDescription != null) {
				JvmIdentifiableElement thisElement = (JvmIdentifiableElement) thisDescription.getEObjectOrProxy();
				LightweightTypeReference type = resolvedTypes.getActualType(thisElement);
				if (type != null && !type.isUnknown()) {
					return createConstructorDelegateScope(context, type, parent, session);
				}
			}
		}
		return parent;
	}

	/* @Nullable */
	protected XAbstractFeatureCall asAbstractFeatureCall(EObject context) {
		return context instanceof XAbstractFeatureCall ? (XAbstractFeatureCall) context : null;
	}

	protected IScope createFeatureScopeForTypeRef(
			final XExpression receiver,
			final LightweightTypeReference featureDeclarator,
			final boolean implicit,
			final EObject featureCall,
			final IFeatureScopeSession session,
			final JvmIdentifiableElement receiverFeature,
			IScope parent, 
			final boolean validStaticScope) {
		final Wrapper<IScope> wrapper = Wrapper.wrap(parent);
		synonymProvider.collectSynonymTypes(featureDeclarator, new SynonymTypesProvider.Acceptor() {

			int id = 100;
			
			@Override
			protected boolean accept(LightweightTypeReference synonymType, int flags) {
				List<JvmType> rawTypes = synonymType.getRawTypes();
				ConformanceFlags.sanityCheck(flags);
				SynonymTypeBucket bucket = new SynonymTypeBucket(id++, rawTypes, resolvedFeaturesProvider, flags);
				CompoundTypeReference compoundTypeReference = synonymType.getOwner().newCompoundTypeReference(true);
				compoundTypeReference.addComponent(featureDeclarator);
				compoundTypeReference.addComponent(synonymType);
				wrapper.set(createReceiverFeatureScope(featureCall, receiver, compoundTypeReference, receiverFeature, implicit, validStaticScope, bucket, wrapper.get(), session));
				return true;
			}
			
		});
		if (featureDeclarator.isMultiType()) {
			List<LightweightTypeReference> components = featureDeclarator.getMultiTypeComponents();
			IScope result = wrapper.get();
			for(int i = components.size() - 1; i >= 0; i--) {
				LightweightTypeReference component = components.get(i);
				List<JvmType> rawTypes = component.getRawTypes();
				TypeBucket typeBucket = new TypeBucket(-1 - i, rawTypes, resolvedFeaturesProvider);
				result = createReceiverFeatureScope(featureCall, receiver, featureDeclarator, receiverFeature, implicit, validStaticScope, typeBucket, result, session);
			}
			return result;
		} else {
			List<JvmType> rawTypes = featureDeclarator.getRawTypes();
			TypeBucket typeBucket = new TypeBucket(-1, rawTypes, resolvedFeaturesProvider);
			IScope result = createReceiverFeatureScope(featureCall, receiver, featureDeclarator, receiverFeature, implicit, validStaticScope, typeBucket, wrapper.get(), session);
			return result;
		}
	}

	/**
	 * This method serves as an entry point for the content assist scoping for features.
	 * @param featureCall the context provides access to the resource set. If it is an assignment, it 
	 *   will be used to restrict scoping.
	 * @param receiver the receiver of the feature call.
	 * @param resolvedTypes TODO
	 * @param session TODO
	 */
	public IScope createFeatureCallScopeForReceiver(final XExpression featureCall, final XExpression receiver, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		if (receiver == null || receiver.eIsProxy())
			return IScope.NULLSCOPE;
		LightweightTypeReference receiverType = resolvedTypes.getActualType(receiver);
		if (receiverType != null && !isUnknownReceiverType(receiverType)) {
			JvmIdentifiableElement linkedReceiver = resolvedTypes.getLinkedFeature(asAbstractFeatureCall(receiver));
			boolean typeLiteral = false;
			IScope root = createTypeLiteralScope(featureCall, receiver, session, resolvedTypes, receiverType, linkedReceiver);
			if (root != null) {
				if (featureCall instanceof XMemberFeatureCall && ((XMemberFeatureCall) featureCall).isExplicitStatic()) {
                    return root;
                }
				typeLiteral = true;
			} else {
				root = IScope.NULLSCOPE;
			}
			// check if 'super' was used as receiver which renders extension features and static features invalid
			if (typeLiteral || isValidFeatureCallArgument(receiver, linkedReceiver, session)) {
				// static members that are invoked on a receiver, e.g. myString.CASE_INSENSITIVE_ORDER
				IScope staticScope = createStaticScope(asAbstractFeatureCall(featureCall), receiver, receiverType, root, session, resolvedTypes);
				
				// static extensions, if any, e.g. iterable.map [], or things that have been imported by means of import static extension MyType
				IScope staticExtensionScope = createStaticExtensionsScope(receiver, receiverType, featureCall, staticScope, session, resolvedTypes);
				
				// instance extensions, e.g. extension ReflectionUtils with myObject.get('privateField')
				IScope extensionScope = createDynamicExtensionsScope(receiver, receiverType, featureCall, staticExtensionScope, session, resolvedTypes);
				
				// instance members, e.g. this.toString
				return createFeatureScopeForTypeRef(receiver, receiverType, false, featureCall, session, linkedReceiver, extensionScope, true);
			} else {
				// put only instance members into the scope
				return createFeatureScopeForTypeRef(receiver, receiverType, false, featureCall, session, linkedReceiver, IScope.NULLSCOPE, true);
			}
		} else if (typeLiteralHelper.isPotentialTypeLiteral(featureCall, resolvedTypes)) {
			IScope errorScope = createFollowUpErrorScope(receiverType);
			List<String> prefix = typeLiteralHelper.getTypeNameSegmentsFromConcreteSyntax((XMemberFeatureCall) featureCall);
			if (prefix == null) {
				return errorScope;
			}
			return createTypeLiteralScope(featureCall, QualifiedName.create(prefix), errorScope, session, resolvedTypes);
		} else {
			return createFollowUpErrorScope(receiverType);
		}
	}

	/* @Nullable */
	protected IScope createTypeLiteralScope(XExpression featureCall, XExpression receiver, IFeatureScopeSession session,
			IResolvedTypes resolvedTypes, LightweightTypeReference receiverType, JvmIdentifiableElement linkedReceiver) {
		if (linkedReceiver instanceof JvmDeclaredType) {
			IFeatureLinkingCandidate candidate = resolvedTypes.getLinkingCandidate(asAbstractFeatureCall(receiver));
			if (candidate != null && candidate.isTypeLiteral()) {
				JvmDeclaredType declaringType = (JvmDeclaredType) linkedReceiver;
				IScope result = createNestedTypeLiteralScope(featureCall, receiverType, declaringType, IScope.NULLSCOPE, session);
				result = createStaticFeatureOnTypeLiteralScope(asAbstractFeatureCall(featureCall), declaringType, receiver, receiverType, result, session);
				return result;
			}
		}
		return null;
	}

	protected boolean isUnknownReceiverType(LightweightTypeReference receiverType) {
		if (receiverType.isUnknown()) {
			return true;
		}
		if (receiverType instanceof UnboundTypeReference) {
			List<LightweightBoundTypeArgument> hints = ((UnboundTypeReference) receiverType).getAllHints();
			for(LightweightBoundTypeArgument hint: hints) {
				LightweightTypeReference typeReference = hint.getTypeReference();
				if (typeReference != null && typeReference.isUnknown())
					return true;
			}
		}
		return false;
	}

	/**
	 * Returns <code>true</code> if the linked receiver may be passed as an argument. Basically everything could
	 * be passed as an argument except the linked receiver is null, a proxy or a reference to <code>super</code>.
	 */
	protected boolean isValidFeatureCallArgument(XExpression expression, JvmIdentifiableElement linkedReceiver, IFeatureScopeSession session) {
		if (linkedReceiver instanceof JvmType) {
			IEObjectDescription knownSuperType = session.getLocalElement(SUPER);
			if (knownSuperType != null && linkedReceiver == knownSuperType.getEObjectOrProxy()) {
				return false;
			}
		}
		return !(expression instanceof XAbstractFeatureCall) || linkedReceiver != null && !linkedReceiver.eIsProxy();
	}

	protected IScope createStaticExtensionsScope(XExpression receiver, LightweightTypeReference receiverType, EObject featureCall, IScope parent, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		IFeatureScopeSession nextCaptureLayer = session.getNextCaptureLayer();
		if (nextCaptureLayer != null) {
			parent = createStaticExtensionsScope(receiver, receiverType, featureCall, parent, nextCaptureLayer, resolvedTypes);
		}
		IScope result = parent;
		if (receiver == null) {
			// 'this' is a valid implicit first argument, e.g. implementations of Iterable may use #filter on themselves
			result = createImplicitExtensionScope(THIS, featureCall, session, resolvedTypes, result);
			// 'it' has a higher priority than 'this' as implicit first argument
			result = createImplicitExtensionScope(IT, featureCall, session, resolvedTypes, result);
			return result;
		} else {
			if (receiverType == null) {
				throw new IllegalStateException("Unknown receiver type");
			}
			result = createStaticExtensionsScope(featureCall, receiver, receiverType, false, parent, session);
		}
		return result;
	}
	
	protected IScope createStaticScope(XAbstractFeatureCall featureCall, XExpression receiver, LightweightTypeReference receiverType, IScope parent,
			IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		IScope result = parent;
		if (receiver == null) {
			result = createImplicitStaticScope(THIS, featureCall, session, resolvedTypes, result);
			result = createImplicitStaticScope(IT, featureCall, session, resolvedTypes, result);
			return result;
		} else {
			TypeBucket receiverBucket = new TypeBucket(-1, Collections.singletonList(receiverType.getType()), resolvedFeaturesProvider);
			return createStaticFeatureScope(featureCall, receiver, receiverType, receiverBucket, parent, session);
		}
	}

	protected IScope createStaticFeatureOnTypeLiteralScope(XAbstractFeatureCall featureCall, JvmType type, XExpression receiver, LightweightTypeReference receiverType,
			IScope parent, IFeatureScopeSession session) {
		TypeBucket receiverBucket = new TypeBucket(-1, Collections.singletonList(type), resolvedFeaturesProvider);
		return createStaticFeatureOnTypeLiteralScope(featureCall, receiver, receiverType, receiverBucket, parent, session);
	}

	protected IScope createDynamicExtensionsScope(XExpression firstArgument, LightweightTypeReference firstArgumentType, EObject featureCall, IScope parent, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		return createDynamicExtensionsScope(firstArgument, firstArgumentType, featureCall, parent, session, session, resolvedTypes);
	}
	
	protected IScope createDynamicExtensionsScope(XExpression firstArgument, LightweightTypeReference firstArgumentType, EObject featureCall, IScope parent, IFeatureScopeSession captureLayer, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		IFeatureScopeSession nextCaptureLayer = captureLayer.getNextCaptureLayer();
		if (nextCaptureLayer != null) {
			parent = createDynamicExtensionsScope(firstArgument, firstArgumentType, featureCall, parent, nextCaptureLayer, session, resolvedTypes);
		}
		List<ExpressionBucket> extensionProviders = captureLayer.getExtensionProviders();
		if (extensionProviders.isEmpty()) {
			return parent;
		}
		IScope result = parent;
		if (firstArgument == null) {
			result = createDynamicExtensionsScope(THIS, featureCall, captureLayer, session, resolvedTypes, result, true);
			result = createDynamicExtensionsScope(IT, featureCall, captureLayer, session, resolvedTypes, result, false);
			return result;
		} else {
			result = createDynamicExtensionsScope(featureCall, firstArgument, firstArgumentType, false, parent, captureLayer);
		}
		return result;
	}
	
	protected IScope createDynamicExtensionsScope(QualifiedName implicitFirstArgumentName, EObject featureCall,
			IFeatureScopeSession captureLayer, IFeatureScopeSession session, IResolvedTypes resolvedTypes, IScope parent, boolean all) {
		if (all) {
			List<IEObjectDescription> firstArguments = getDeepLocalElements(session, implicitFirstArgumentName);
			switch(firstArguments.size()) {
				case 0:
					return createDynamicExtensionsScope(featureCall, null, null, true, parent, captureLayer);
				case 1:
					return createDynamicExtensionsScope(implicitFirstArgumentName, firstArguments.get(0), featureCall, captureLayer, session, resolvedTypes,
							parent);
				default:
					CompositeScope result = createCompositeScope(featureCall, parent, session);
					for(IEObjectDescription firstArgumentDescription: firstArguments) {
						IScope extensionsScope = createDynamicExtensionsScope(implicitFirstArgumentName, firstArgumentDescription, featureCall, captureLayer, session, resolvedTypes,
								IScope.NULLSCOPE);
						if (IScope.NULLSCOPE != extensionsScope) {
							result.addDelegate((AbstractSessionBasedScope) extensionsScope);
						}
					}
					if (result.hasDelegates())
						return result;
					return parent;
			}
		} else {
			IEObjectDescription firstArgumentDescription = getDeepLocalElement(session, implicitFirstArgumentName);
			if (firstArgumentDescription != null) {
				return createDynamicExtensionsScope(implicitFirstArgumentName, firstArgumentDescription, featureCall, captureLayer, session, resolvedTypes,
						parent);
			} else {
				return createDynamicExtensionsScope(featureCall, null, null, true, parent, captureLayer);
			}
		}
	}

	protected IEObjectDescription getDeepLocalElement(IFeatureScopeSession session, QualifiedName name) {
		while(session != null) {
			IEObjectDescription element = session.getLocalElement(name);
			if (element != null) {
				return element;
			}
			session = session.getNextCaptureLayer();
		}
		return null;
	}
	
	protected List<IEObjectDescription> getDeepLocalElements(IFeatureScopeSession session, QualifiedName name) {
		List<IEObjectDescription> result = Lists.newArrayList();
		while(session != null) {
			IEObjectDescription element = session.getLocalElement(name);
			if (element != null) {
				result.add(element);
			}
			session = session.getNextCaptureLayer();
		}
		return result;
	}

	protected IScope createDynamicExtensionsScope(QualifiedName implicitFirstArgumentName, IEObjectDescription firstArgumentDescription, EObject featureCall,
			IFeatureScopeSession captureLayer, IFeatureScopeSession session, IResolvedTypes resolvedTypes, IScope parent) {
		JvmIdentifiableElement feature = (JvmIdentifiableElement) firstArgumentDescription.getEObjectOrProxy();
		if (feature instanceof JvmType && THIS.equals(implicitFirstArgumentName) && !session.isInstanceContext()) {
			return parent;
		}
		LightweightTypeReference type = resolvedTypes.getActualType(feature);
		if (type != null && !type.isUnknown()) {
			XFeatureCall implicitArgument = xbaseFactory.createXFeatureCall();
			implicitArgument.setFeature(feature);
			return createDynamicExtensionsScope(featureCall, implicitArgument, type, true, parent, captureLayer);
		}
		return parent;
	}

	protected XExpression getSyntacticalReceiver(final XAbstractFeatureCall call) {
		return new FeatureLinkHelper().getSyntacticReceiver(call);
	}

	protected IScope createImplicitFeatureCallScope(EObject featureCall, IScope parent, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		IScope result = parent;
		result = createImplicitFeatureCallScope(THIS, featureCall, session, resolvedTypes, result);
		result = createImplicitFeatureCallScope(IT, featureCall, session, resolvedTypes, result);
		return result;
	}

	protected IScope createImplicitFeatureCallScope(QualifiedName implicitName, EObject featureCall,
			IFeatureScopeSession session, IResolvedTypes resolvedTypes, IScope parent) {
		IEObjectDescription thisDescription = session.getLocalElement(implicitName);
		if (thisDescription != null) {
			JvmIdentifiableElement thisElement = (JvmIdentifiableElement) thisDescription.getEObjectOrProxy();
			boolean validStaticScope = true;
			if (thisElement instanceof JvmType && THIS.equals(implicitName) && !session.isInstanceContext()) {
				validStaticScope = false;
			}
			LightweightTypeReference type = resolvedTypes.getActualType(thisElement);
			if (type !=null && !type.isUnknown()) {
				XFeatureCall implicitReceiver = xbaseFactory.createXFeatureCall();
				implicitReceiver.setFeature(thisElement);
				return createFeatureScopeForTypeRef(implicitReceiver, type, true, featureCall, session, thisElement, parent, validStaticScope);
			}
		}
		return parent;
	}
	
	protected IScope createImplicitExtensionScope(QualifiedName implicitName, EObject featureCall,
			IFeatureScopeSession session, IResolvedTypes resolvedTypes, IScope parent) {
		IEObjectDescription thisDescription = session.getLocalElement(implicitName);
		if (thisDescription != null) {
			JvmIdentifiableElement thisElement = (JvmIdentifiableElement) thisDescription.getEObjectOrProxy();
			LightweightTypeReference type = resolvedTypes.getActualType(thisElement);
			if (type != null && !type.isUnknown()) {
				XFeatureCall implicitReceiver = xbaseFactory.createXFeatureCall();
				implicitReceiver.setFeature(thisElement);
				return createStaticExtensionsScope(featureCall, implicitReceiver, type, true, parent, session);
			}
		}
		return parent;
	}
	
	protected IScope createImplicitStaticScope(QualifiedName implicitName, XAbstractFeatureCall featureCall, IFeatureScopeSession session,
			IResolvedTypes resolvedTypes, IScope parent) {
		IEObjectDescription thisDescription = session.getLocalElement(implicitName);
		if (thisDescription != null) {
			JvmIdentifiableElement thisElement = (JvmIdentifiableElement) thisDescription.getEObjectOrProxy();
			LightweightTypeReference type = resolvedTypes.getActualType(thisElement);
			if (type != null && !type.isUnknown()) {
				TypeBucket receiverBucket = new TypeBucket(-1, Collections.singletonList(type.getType()), resolvedFeaturesProvider);
				return createStaticFeatureScope(featureCall, null, type, receiverBucket, parent, session);
			}
		}
		return parent;
	}

	/**
	 * Create a scope that contains static features. The features may be obtained implicitly from a given type ({@code receiver} is
	 * {@code null}), or the features may be obtained from a concrete instance.
	 * 
	 * @param featureCall the feature call that is currently processed by the scoping infrastructure
	 * @param receiver an optionally available receiver expression
	 * @param receiverType the type of the receiver. It may be available even if the receiver itself is null, which indicates an implicit receiver.
	 * @param receiverBucket the types that contribute the static features.
	 * @param parent the parent scope. Is never null.
	 * @param session the currently known scope session. Is never null.
	 */
	protected IScope createStaticFeatureScope(
			XAbstractFeatureCall featureCall,
			XExpression receiver,
			LightweightTypeReference receiverType,
			TypeBucket receiverBucket,
			IScope parent,
			IFeatureScopeSession session) {
		return new StaticFeatureScope(parent, session, featureCall, receiver, receiverType, receiverBucket, operatorMapping);
	}
	
	/**
	 * Creates a scope for the static features that are exposed by a type that was used, e.g.
	 * {@code java.lang.String.valueOf(1)} where {@code valueOf(1)} is to be linked.
	 * 
	 * @param featureCall the feature call that is currently processed by the scoping infrastructure
	 * @param receiver an optionally available receiver expression
	 * @param receiverType the type of the receiver. It may be available even if the receiver itself is null, which indicates an implicit receiver.
	 * @param receiverBucket the types that contribute the static features.
	 * @param parent the parent scope. Is never null.
	 * @param session the currently known scope session. Is never null.
	 */
	protected IScope createStaticFeatureOnTypeLiteralScope(
			EObject featureCall,
			XExpression receiver,
			LightweightTypeReference receiverType,
			TypeBucket receiverBucket,
			IScope parent,
			IFeatureScopeSession session) {
		return new StaticFeatureOnTypeLiteralScope(parent, session, asAbstractFeatureCall(featureCall), receiver, receiverType, receiverBucket, operatorMapping);
	}
	
	/**
	 * Create a scope that contains dynamic extension features, which are features that are contributed by an instance of a type.
	 * 
	 * @param featureCall the feature call that is currently processed by the scoping infrastructure
	 * @param firstArgument an optionally available first argument expression.
	 * @param firstArgumentType optionally the type of the first argument
	 * @param implicitArgument if the argument is an implicit argument or explicitly given (in concrete syntax)
	 * @param parent the parent scope. Is never null.
	 * @param session the currently known scope session. Is never null.
	 */
	protected IScope createDynamicExtensionsScope(
			EObject featureCall,
			XExpression firstArgument,
			LightweightTypeReference firstArgumentType,
			boolean implicitArgument,
			IScope parent,
			IFeatureScopeSession session) {
		return new DynamicExtensionsScope(parent, session, firstArgument, firstArgumentType, implicitArgument, asAbstractFeatureCall(featureCall), operatorMapping);
	}

	/**
	 * Create a scope that contains static extension features, which are features that are contributed statically via an import.
	 * 
	 * @param featureCall the feature call that is currently processed by the scoping infrastructure
	 * @param firstArgument an optionally available first argument expression.
	 * @param firstArgumentType optionally the type of the first argument
	 * @param implicitArgument if the argument is an implicit argument or explicitly given (in concrete syntax)
	 * @param parent the parent scope. Is never null.
	 * @param session the currently known scope session. Is never null.
	 */
	protected IScope createStaticExtensionsScope(
			EObject featureCall,
			XExpression firstArgument,
			LightweightTypeReference firstArgumentType,
			boolean implicitArgument,
			IScope parent,
			IFeatureScopeSession session) {
		return new StaticExtensionImportsScope(parent, session, firstArgument, firstArgumentType, implicitArgument, asAbstractFeatureCall(featureCall), operatorMapping);
	}
	
	/**
	 * Create a scope that returns types, e.g. for member feature calls that are actually type references like
	 * {@code java.lang.String}.
	 * 
	 * @param featureCall the feature call that is currently processed by the scoping infrastructure
	 * @param parentSegments the segments of the fully qualified type name that are already known. The queried element name will be appended to them.
	 * @param parent the parent scope. Is never null.
	 * @param session the currently known scope session. Is never null.
	 */
	protected IScope createTypeLiteralScope(EObject featureCall, QualifiedName parentSegments, IScope parent, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		return new TypeLiteralScope(parent, session, asAbstractFeatureCall(featureCall), resolvedTypes, parentSegments);
	}
	
	/**
	 * Create a scope that returns nested types.
	 * 
	 * @param featureCall the feature call that is currently processed by the scoping infrastructure
	 * @param enclosingType the enclosing type including type parameters for the nested type literal scope.
	 * @param rawEnclosingType the raw type that is used to query the nested types.
	 * @param parent the parent scope. Is never null.
	 * @param session the currently known scope session. Is never null.
	 */
	protected IScope createNestedTypeLiteralScope(
			EObject featureCall,
			LightweightTypeReference enclosingType,
			JvmDeclaredType rawEnclosingType,
			IScope parent,
			IFeatureScopeSession session) {
		return new NestedTypeLiteralScope(parent, session, asAbstractFeatureCall(featureCall), enclosingType, rawEnclosingType);
	}
	
	/**
	 * Creates a scope for the statically imported features.
	 * 
	 * @param featureCall the feature call that is currently processed by the scoping infrastructure
	 * @param parent the parent scope. Is never null.
	 * @param session the currently known scope session. Is never null.
	 */
	protected IScope createStaticFeaturesScope(EObject featureCall, IScope parent, IFeatureScopeSession session) {
		return new StaticImportsScope(parent, session, asAbstractFeatureCall(featureCall));
	}
	
	/**
	 * Creates a scope for the local variables that have been registered in the given session.
	 * 
	 * @param featureCall the feature call that is currently processed by the scoping infrastructure
	 * @param parent the parent scope. Is never null.
	 * @param session the currently known scope session. Is never null.
	 * @param resolvedTypes may be used by inheritors. 
	 */
	protected IScope createLocalVariableScope(EObject featureCall, IScope parent, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		return new LocalVariableScope(parent, session, asAbstractFeatureCall(featureCall));
	}
	
	/**
	 * A constructor delegate scope provides the descriptions for {@code this()} and {@code super()}
	 * calls in a constructor body.
	 */
	protected IScope createConstructorDelegateScope(EObject featureCall, LightweightTypeReference type, IScope parent, IFeatureScopeSession session) {
		return new ConstructorDelegateScope(parent, type, session, asAbstractFeatureCall(featureCall));
	}
	
	/**
	 * Create a composite scope that returns description from multiple other scopes without applying shadowing semantics to then.
	 */
	protected CompositeScope createCompositeScope(EObject featureCall, IScope parent, IFeatureScopeSession session) {
		return new CompositeScope(parent, session, asAbstractFeatureCall(featureCall));
	}
	
	/**
	 * Creates a scope that returns the features of a given receiver type.
	 * 
	 * @param featureCall the feature call that is currently processed by the scoping infrastructure
	 * @param receiver an optionally available receiver expression
	 * @param receiverType the type of the receiver. It may be available even if the receiver itself is null, which indicates an implicit receiver.
	 * @param receiverFeature the feature that was linked as the receiver
	 * @param implicitReceiver true if the receiver is an implicit receiver
	 * @param validStatic true if the receiver is valid according the its static flag, e.g an implicit this in a static method is invalid
	 * @param receiverBucket the types that contribute the static features.
	 * @param parent the parent scope. Is never null.
	 * @param session the currently known scope session. Is never null.
	 */
	protected IScope createReceiverFeatureScope(
			EObject featureCall,
			XExpression receiver,
			LightweightTypeReference receiverType,
			JvmIdentifiableElement receiverFeature,
			boolean implicitReceiver,
			boolean validStatic,
			TypeBucket receiverBucket,
			IScope parent,
			IFeatureScopeSession session) {
		return new ReceiverFeatureScope(parent, session, receiver, receiverType, implicitReceiver, asAbstractFeatureCall(featureCall), receiverBucket, receiverFeature, operatorMapping, validStatic);
	}
	
	protected IScope createFollowUpErrorScope(/* @Nullable */ final LightweightTypeReference receiverType) {
		return new SimpleScope(Collections.<IEObjectDescription>emptyList()) {
			@Override
			public Iterable<IEObjectDescription> getElements(QualifiedName name) {
				return Collections.<IEObjectDescription>singletonList(new ScopeProviderAccess.ErrorDescription(receiverType));
			}
		};
	}
	
	protected OperatorMapping getOperatorMapping() {
		return operatorMapping;
	}
	
	protected IResolvedFeatures.Provider getResolvedFeaturesProvider() {
		return resolvedFeaturesProvider;
	}
	
	protected SynonymTypesProvider getSynonymProvider() {
		return synonymProvider;
	}
	
	protected FeatureCallAsTypeLiteralHelper getTypeLiteralHelper() {
		return typeLiteralHelper;
	}
	
	protected XbaseFactory getXbaseFactory() {
		return xbaseFactory;
	}
}
