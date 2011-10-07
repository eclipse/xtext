/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
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
	
	private static final Logger log = Logger.getLogger(XbaseResource.class);
	
	protected static class AssumptionTracker implements LinkingAssumptions.Tracker {
		private boolean independent = true;
		private final AssumptionTracker delegate;
		private final XbaseResource host;
		
		protected AssumptionTracker(XbaseResource host) {
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
	}
	
	@Inject
	private OnChangeEvictingCache onChangeEvictingCache;
	
	private Map<JvmIdentifiableElement, JvmIdentifiableElement> proxyToAssumption = Maps.newHashMap();
	private Map<XAbstractFeatureCall, XExpression> featureCallToReceiverAssumption = Maps.newHashMap();
	private AssumptionTracker assumptionTracker = new RootAssumptionTracker();
	
	protected LinkingAssumptions.Tracker trackAssumptions() {
		return new AssumptionTracker(this);
	}
	
	protected synchronized <T> T assumeLinked(
			final JvmIdentifiableElement proxy, 
			final JvmIdentifiableElement candidate, 
			final XAbstractFeatureCall featureCall, 
			final XExpression implicitReceiver,
			final Provider<T> algorithm) {
		try {
			if (proxyToAssumption.put(proxy, candidate) != null)
				throw new AssertionError("there is already another assumption about the given proxy. " +
						"Please make sure that you don't use AbstractFeatureCall#getFeature in the type inference or" +
						"in your scoping implementation but AbstractTypeProvider#getFeature instead.");
			if (featureCall != null) {
				featureCallToReceiverAssumption.put(featureCall, implicitReceiver);
			}
			return algorithm.get();
		} finally {
			proxyToAssumption.remove(proxy);
			featureCallToReceiverAssumption.remove(featureCall);
		}
	}
	
	protected synchronized XExpression getImplicitReceiver(XAbstractFeatureCall featureCall) {
		XExpression result = featureCallToReceiverAssumption.get(featureCall);
		if (result == null) {
			if (featureCallToReceiverAssumption.containsKey(featureCall)) {
				assumptionTracker.markDependent();
				return null;
			}
			return featureCall.getImplicitReceiver();
		}
		assumptionTracker.markDependent();
		return result;
	}
	
	protected synchronized JvmIdentifiableElement getFeature(XAbstractFeatureCall featureCall, boolean resolve) {
		JvmIdentifiableElement potentialProxy = (JvmIdentifiableElement) featureCall.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
		if (potentialProxy == null || !potentialProxy.eIsProxy())
			return potentialProxy;
		JvmIdentifiableElement assumption = proxyToAssumption.get(potentialProxy);
		if (assumption != null) {
			assumptionTracker.markDependent();
			return assumption;
		}
		if (!resolve)
			return potentialProxy;
		JvmIdentifiableElement resolvedResult = trackResolution(potentialProxy, featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
		return resolvedResult;
	}
	
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
	
	protected synchronized JvmConstructor getConstructor(XConstructorCall featureCall, boolean resolve) {
		JvmConstructor potentialProxy = (JvmConstructor) featureCall.eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, false);
		if (potentialProxy == null || !potentialProxy.eIsProxy())
			return potentialProxy;
		JvmConstructor assumption = (JvmConstructor) proxyToAssumption.get(potentialProxy);
		if (assumption != null) {
			assumptionTracker.markDependent();
			return assumption;
		}
		if (!resolve)
			return potentialProxy;
		return (JvmConstructor) trackResolution(potentialProxy, featureCall, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR);
	}
	
	@Override
	public synchronized EObject getEObject(final String uriFragment) {
//		if (!proxyToAssumption.isEmpty() && getEncoder().isCrossLinkFragment(this, uriFragment)) {
//			Triple<EObject, EReference, INode> triple = getEncoder().decode(this, uriFragment);
//			EReference reference = triple.getSecond();
//			if (XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE == reference || XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR == reference) {
//				log.error("Tried to use #getFeature directly during scoping / type resolution", new Exception());
//			}
//			
//		}
		return uncheckedGetEObject(uriFragment);
	}

	protected EObject uncheckedGetEObject(final String uriFragment) {
		return onChangeEvictingCache.execWithoutCacheClear(this, new IUnitOfWork<EObject, XbaseResource>(){
			public EObject exec(XbaseResource state) throws Exception {
				return XbaseResource.super.getEObject(uriFragment);
			}
		});
	}
	
	@Override
	protected EObject handleCyclicResolution(Triple<EObject, EReference, INode> triple) throws AssertionError {
		return null;
	}
}
