/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;

import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
@Singleton
public class LinkingAssumptions {

	public static interface Tracker {
		
		boolean isIndependentOfAssumptions();
		
		void stopTracking();
		
	}
	
	private static class NullTracker implements Tracker {

		public boolean isIndependentOfAssumptions() {
			return true;
		}

		public void stopTracking() {
			// ignore
		}
		
	}
	
	public static class Assumption {
		private final JvmIdentifiableElement proxy;
		private final JvmIdentifiableElement candidate;
		private final XAbstractFeatureCall featureCall;
		private final XExpression implicitReceiver;
		private final XExpression implicitFirstArgumentReceiver;

		public Assumption(JvmIdentifiableElement proxy, JvmIdentifiableElement candidate) {
			this(proxy, candidate, null, null, null);
		}
		
		public Assumption(JvmIdentifiableElement proxy, JvmIdentifiableElement candidate, 
				XAbstractFeatureCall featureCall, XExpression implicitReceiver,
				XExpression implicitFirstArgumentReceiver) {
			this.proxy = proxy;
			this.candidate = candidate;
			this.featureCall = featureCall;
			this.implicitReceiver = implicitReceiver;
			this.implicitFirstArgumentReceiver = implicitFirstArgumentReceiver;
		}
	}
	
	public Tracker trackAssumptions(Resource resource) {
		if (resource instanceof XbaseResource) {
			return ((XbaseResource) resource).trackAssumptions();
		}
		return new NullTracker();
	}
	
	public Assumption createAssumption(JvmIdentifiableElement proxy, JvmIdentifiableElement candidate,
			XAbstractFeatureCall featureCall, XExpression implicitReceiver,
			XExpression implicitFirstArgumentReceiver) {
		return new Assumption(proxy, candidate, featureCall, implicitReceiver, implicitFirstArgumentReceiver);
	}
	
	public Assumption createAssumption(JvmIdentifiableElement proxy, JvmIdentifiableElement candidate) {
		return new Assumption(proxy, candidate);
	}
	
	public <T> T assumeLinkedAndRun(Resource resource, Assumption assumption, Provider<T> strategy) {
		if (resource instanceof XbaseResource) {
			T result = ((XbaseResource) resource).assumeLinked(
					assumption.proxy,
					assumption.candidate,
					assumption.featureCall,
					assumption.implicitReceiver,
					assumption.implicitFirstArgumentReceiver,
					strategy);
			return result;
		} else {
			return strategy.get();
		}
	}
	
	public XExpression getImplicitReceiver(XAbstractFeatureCall featureCall) {
		Resource resource = featureCall.eResource();
		if (resource instanceof XbaseResource) {
			return ((XbaseResource) resource).getImplicitReceiver(featureCall);
		}
		return featureCall.getImplicitReceiver();
	}
	
	public XExpression getImplicitFirstArgument(XAbstractFeatureCall featureCall) {
		Resource resource = featureCall.eResource();
		if (resource instanceof XbaseResource) {
			return ((XbaseResource) resource).getImplicitFirstArgument(featureCall);
		}
		return featureCall.getImplicitFirstArgument();
	}
	
	public JvmIdentifiableElement getFeature(XAbstractFeatureCall featureCall, boolean resolve) {
		Resource resource = featureCall.eResource();
		if (resource instanceof XbaseResource) {
			return ((XbaseResource) resource).getFeature(featureCall, resolve);
		}
		return (JvmIdentifiableElement) featureCall.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, resolve);
	}
	
	public JvmConstructor getConstructor(XConstructorCall constructorCall, boolean resolve) {
		Resource resource = constructorCall.eResource();
		if (resource instanceof XbaseResource) {
			return ((XbaseResource) resource).getConstructor(constructorCall, resolve);
		}
		return (JvmConstructor) constructorCall.eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, resolve);
	}

}
