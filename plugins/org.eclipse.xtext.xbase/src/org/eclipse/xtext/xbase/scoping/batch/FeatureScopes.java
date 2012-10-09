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
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.inject.Inject;

/**
 * Utility class when dealing with feature scopes or constructor scopes.
 * Clients may want to override this one if they want to 
 * add a new implicit receiver.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * TODO constructor scopes
 */
public class FeatureScopes implements IFeatureNames {

	@Inject
	private OperatorMapping operatorMapping;
	
	@Inject
	private SynonymTypesProvider synonymProvider;
	
	@Inject(optional = true)
	private XbaseFactory xbaseFactory = XbaseFactory.eINSTANCE;
	
	@Inject
	private SuperTypeCollector superTypeCollector;
	
	/**
	 * creates the feature scope for {@link XAbstractFeatureCall}, including the local variables in case it is a feature
	 * call without receiver (XFeatureCall).
	 * @param session the currently available session data
	 */
	public IScope createFeatureCallScope(EObject context, EReference reference, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
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
	
	protected SuperTypeCollector getSuperTypeCollector() {
		return superTypeCollector;
	}
	
	/**
	 * This method serves as an entry point for the content assist scoping for simple feature calls.
	 * @param context the context e.g. a for loop expression, a block or a catch clause
	 * @param reference the reference who's value shall be scoped. Not necessarily a feature of the context.
	 */
	public IScope createSimpleFeatureCallScope(EObject context, EReference reference, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		if (context instanceof XFeatureCall) {
			XFeatureCall featureCall = (XFeatureCall) context;
			if (featureCall.getDeclaringType() != null) {
				TypeBucket receiverBucket = new TypeBucket(-1, Collections.<JvmType>singletonList(featureCall.getDeclaringType()));
				return new StaticFeatureScope(IScope.NULLSCOPE, session, asAbstractFeatureCall(context), receiverBucket, operatorMapping);
			}
		}
		
		IScope staticImports = createStaticFeaturesScope(context, IScope.NULLSCOPE, session);
		IScope staticExtensions = createStaticExtensionsScope(null, null, context, staticImports, session, resolvedTypes);
		IScope implicitReceivers = createImplicitFeatureCallScope(context, staticExtensions, session, resolvedTypes);
		IScope localVariables = new LocalVariableScope(implicitReceivers, session, asAbstractFeatureCall(context));
		return localVariables;
	}

	protected XAbstractFeatureCall asAbstractFeatureCall(EObject context) {
		return context instanceof XAbstractFeatureCall ? (XAbstractFeatureCall) context : null;
	}

	protected IScope createFeatureScopeForTypeRef(
			final XExpression receiver,
			final LightweightTypeReference featureDeclarator,
			final boolean implicit,
			final EObject featureCall,
			final IFeatureScopeSession session,
			IScope parent) {
		final Wrapper<IScope> wrapper = Wrapper.wrap(parent);
		synonymProvider.collectSynonymTypes(featureDeclarator, new SynonymTypesProvider.Acceptor() {

			int id = 100;
			
			@NonNullByDefault
			@Override
			protected boolean accept(LightweightTypeReference synonymType, Set<ConformanceHint> hints) {
				List<JvmType> rawTypes = synonymType.getRawTypes();
				SynonymTypeBucket bucket = new SynonymTypeBucket(id++, rawTypes, hints);
				wrapper.set(new ReceiverFeatureScope(wrapper.get(), session, receiver, synonymType, implicit, asAbstractFeatureCall(featureCall), bucket, operatorMapping));
				return true;
			}
			
		});
		List<JvmType> rawTypes = featureDeclarator.getRawTypes();
		TypeBucket typeBucket = new TypeBucket(-1, rawTypes);
		IScope result = new ReceiverFeatureScope(wrapper.get(), session, receiver, featureDeclarator, implicit, asAbstractFeatureCall(featureCall), typeBucket, operatorMapping);
		return result;
	}

	/**
	 * This method serves as an entry point for the content assist scoping for features.
	 * @param featureCall the context provides access to the resource set. If it is an assignment, it 
	 *   will be used to restrict scoping.
	 * @param receiver the receiver of the feature call.
	 * @param resolvedTypes TODO
	 * @param session TODO
	 */
	public IScope createFeatureCallScopeForReceiver(final XExpression featureCall, final XExpression receiver, EReference reference, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		if (!isFeatureCallScope(reference))
			return IScope.NULLSCOPE;
		if (receiver == null || receiver.eIsProxy())
			return IScope.NULLSCOPE;
		LightweightTypeReference receiverType = resolvedTypes.getActualType(receiver);
		if (receiverType != null) {
			IScope result = createStaticExtensionsScope(receiver, receiverType, featureCall, IScope.NULLSCOPE, session, resolvedTypes);
			return createFeatureScopeForTypeRef(receiver, receiverType, false, featureCall, session, result);
		} else {
			return IScope.NULLSCOPE;
		}
	}

	protected IScope createStaticExtensionsScope(XExpression receiver, LightweightTypeReference receiverType, EObject featureCall, IScope parent, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		IScope result = parent;
		if (receiver == null) {
			result = createImplicitExtensionScope(THIS, featureCall, session, resolvedTypes, result);
			result = createImplicitExtensionScope(IT, featureCall, session, resolvedTypes, result);
			return result;
		} else {
			result = createStaticExtensionsScope(receiver, receiverType, false, featureCall, parent, session);
		}
		return result;
	}

	protected StaticExtensionImportsScope createStaticExtensionsScope(XExpression receiver,
			LightweightTypeReference receiverType, boolean implicit, EObject featureCall, IScope parent, IFeatureScopeSession session) {
		return new StaticExtensionImportsScope(parent, session, receiver, receiverType, implicit, asAbstractFeatureCall(featureCall), operatorMapping);
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
			LightweightTypeReference type = resolvedTypes.getActualType(thisElement);
			
			XFeatureCall implicitReceiver = xbaseFactory.createXFeatureCall();
			implicitReceiver.setFeature(thisElement);
			return createFeatureScopeForTypeRef(implicitReceiver, type, true, featureCall, session, parent);
		}
		return parent;
	}
	
	protected IScope createImplicitExtensionScope(QualifiedName implicitName, EObject featureCall,
			IFeatureScopeSession session, IResolvedTypes resolvedTypes, IScope parent) {
		IEObjectDescription thisDescription = session.getLocalElement(implicitName);
		if (thisDescription != null) {
			JvmIdentifiableElement thisElement = (JvmIdentifiableElement) thisDescription.getEObjectOrProxy();
			LightweightTypeReference type = resolvedTypes.getActualType(thisElement);
			XFeatureCall implicitReceiver = xbaseFactory.createXFeatureCall();
			implicitReceiver.setFeature(thisElement);
			return createStaticExtensionsScope(implicitReceiver, type, true, featureCall, parent, session);
		}
		return parent;
	}
	
}
