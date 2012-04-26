/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Linking assumptions
 */
public class XbaseResource extends DerivedStateAwareResource {
	
	protected static class AssumptionTracker implements LinkingAssumptions.Tracker {
		private boolean independent = true;
		private final AssumptionTracker delegate;
		private final AssumptionState host;
		
		protected AssumptionTracker(AssumptionState host) {
			this.host = host;
			if (host != null) {
				this.delegate = host.assumptionTracker;
				host.assumptionTracker = this;
			} else {
				this.delegate = null;
			}
		}
		
		public boolean isIndependentOfAssumptions() {
			return independent;
		}
		
		public void stopTracking() {
			if (host.assumptionTracker != this) {
				throw new IllegalStateException("Unexpected assumption tracker");
			}
			host.assumptionTracker = delegate;
		}
		
		protected void markDependent() {
			if (independent) {
				independent = false;
				if (delegate != null) {
					delegate.markDependent();
				}
			}
		}
		
		@Override
		public String toString() {
			return "AssumptionTracker [independent=" + independent + "]";
		}
	}
	
	protected static class RootAssumptionTracker extends AssumptionTracker {
		protected RootAssumptionTracker() {
			super(null);
		}
		@Override
		public boolean isIndependentOfAssumptions() {
			return true;
		}
		@Override
		public void stopTracking() {
			throw new UnsupportedOperationException();
		}
		@Override
		protected void markDependent() {
		}
		@Override
		public String toString() {
			return "RootAssumptionTracker";
		}
	}
	
	protected static class AssumptionState {
		protected Map<JvmIdentifiableElement, JvmIdentifiableElement> proxyToAssumption = Maps.newHashMap();
		protected Map<XAbstractFeatureCall, XExpression> featureCallToReceiverAssumption = Maps.newHashMap();
		protected Map<XAbstractFeatureCall, XExpression> featureCallToFirstArgumentAssumption = Maps.newHashMap();
		protected AssumptionTracker assumptionTracker = new RootAssumptionTracker();
	}
	
	@Inject
	private OnChangeEvictingCache onChangeEvictingCache;
	
	private ThreadLocal<AssumptionState> assumptionState = new ThreadLocal<AssumptionState>() {
		@Override
		protected AssumptionState initialValue() {
			return new AssumptionState();
		}
	};
	
	protected LinkingAssumptions.Tracker trackAssumptions() {
		return new AssumptionTracker(assumptionState.get());
	}
	
	protected <T> T assumeLinked(
			final JvmIdentifiableElement proxy, 
			final JvmIdentifiableElement candidate, 
			final XAbstractFeatureCall featureCall, 
			final XExpression implicitReceiver,
			final XExpression implicitFirstArgument,
			final Provider<T> algorithm) {
		AssumptionState state = assumptionState.get();
		try {
			if (state.proxyToAssumption.put(proxy, candidate) != null)
				throw new AssertionError("There is already another assumption about the given proxy. " +
						"Please make sure that you don't use XAbstractFeatureCall#getFeature in the type inference or " +
						"in your scoping implementation but AbstractTypeProvider#getFeature instead.\n" +
						"You may want to look out for invocations of XAbstractFeatureCall#getFeature in the " +
						"stack trace to spot the misbehaving implementation.");
			if (featureCall != null) {
				state.featureCallToReceiverAssumption.put(featureCall, implicitReceiver);
				state.featureCallToFirstArgumentAssumption.put(featureCall, implicitFirstArgument);
			}
			return algorithm.get();
		} finally {
			state.proxyToAssumption.remove(proxy);
			state.featureCallToFirstArgumentAssumption.remove(featureCall);
			state.featureCallToReceiverAssumption.remove(featureCall);
		}
	}
	
	protected XExpression getImplicitReceiver(XAbstractFeatureCall featureCall) {
		AssumptionState state = assumptionState.get();
		XExpression result = state.featureCallToReceiverAssumption.get(featureCall);
		if (result == null) {
			if (state.featureCallToReceiverAssumption.containsKey(featureCall)) {
				state.assumptionTracker.markDependent();
				return null;
			}
			return featureCall.getImplicitReceiver();
		}
		state.assumptionTracker.markDependent();
		return result;
	}
	
	protected XExpression getImplicitFirstArgument(XAbstractFeatureCall featureCall) {
		AssumptionState state = assumptionState.get();
		XExpression result = state.featureCallToFirstArgumentAssumption.get(featureCall);
		if (result == null) {
			if (state.featureCallToFirstArgumentAssumption.containsKey(featureCall)) {
				state.assumptionTracker.markDependent();
				return null;
			}
			return featureCall.getImplicitFirstArgument();
		}
		state.assumptionTracker.markDependent();
		return result;
	}
	
	protected JvmIdentifiableElement getFeature(XAbstractFeatureCall featureCall, boolean resolve) {
		JvmIdentifiableElement potentialProxy = (JvmIdentifiableElement) featureCall.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
		if (potentialProxy == null || !potentialProxy.eIsProxy())
			return potentialProxy;
		AssumptionState state = assumptionState.get();
		JvmIdentifiableElement assumption = state.proxyToAssumption.get(potentialProxy);
		if (assumption != null) {
			state.assumptionTracker.markDependent();
			return assumption;
		}
		if (!resolve)
			return potentialProxy;
		JvmIdentifiableElement resolvedResult = trackResolution(potentialProxy, featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
		return resolvedResult;
	}
	
	/**
	 * This one is currently implemented as a no-op.
	 * 
	 * Intentional implementation would return the resolved instance without changing the owner of the reference. Only single-valued references
	 * are currently supported.
	 * 
	 * @param proxy the proxy which should be resolved with tracking.
	 * @param owner the owner of the proxy.
	 * @param reference the cross reference.
	 */
	protected JvmIdentifiableElement trackResolution(JvmIdentifiableElement proxy, XExpression owner, EReference reference) {
		return (JvmIdentifiableElement) owner.eGet(reference);
//		Tracker tracker = trackAssumptions();
//		try {
//			URI proxyURI = EcoreUtil.getURI(proxy);
//			String proxyFragment = proxyURI.fragment();
//			EObject result = uncheckedGetEObject(proxyFragment);
//			if (result != null) {
//				if (tracker.isIndependentOfAssumptions()) {
//					owner.eSet(reference, result);
//				}
//				return (JvmIdentifiableElement) result;
//			}
//		} finally {
//			tracker.stopTracking();			
//		}
//		return proxy;
	}
	
	protected JvmConstructor getConstructor(XConstructorCall featureCall, boolean resolve) {
		JvmConstructor potentialProxy = (JvmConstructor) featureCall.eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, false);
		if (potentialProxy == null || !potentialProxy.eIsProxy())
			return potentialProxy;
		AssumptionState state = assumptionState.get();
		JvmConstructor assumption = (JvmConstructor) state.proxyToAssumption.get(potentialProxy);
		if (assumption != null) {
			state.assumptionTracker.markDependent();
			return assumption;
		}
		if (!resolve)
			return potentialProxy;
		return (JvmConstructor) trackResolution(potentialProxy, featureCall, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR);
	}
	
	@Override
	public synchronized EObject getEObject(final String uriFragment) {
		return onChangeEvictingCache.execWithoutCacheClear(this, new IUnitOfWork<EObject, XbaseResource>(){
			public EObject exec(XbaseResource state) throws Exception {
				return XbaseResource.super.getEObject(uriFragment);
			}
		});
	}
	
	@Override
	protected boolean isUnresolveableProxyCacheable(Triple<EObject, EReference, INode> triple) {
		boolean result = TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(triple.getSecond().getEReferenceType());
		return result;
	}

	@Override
	protected EObject handleCyclicResolution(Triple<EObject, EReference, INode> triple) throws AssertionError {
		return null;
	}
}
