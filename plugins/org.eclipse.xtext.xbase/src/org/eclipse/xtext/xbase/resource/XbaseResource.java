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
	
	@Inject
	private OnChangeEvictingCache onChangeEvictingCache;
	
	private Map<JvmIdentifiableElement, JvmIdentifiableElement> proxyToAssumption = Maps.newHashMap();
	private Map<XAbstractFeatureCall, XExpression> featureCallToReceiverAssumption = Maps.newHashMap();
	
	protected synchronized <T> T assumeLinked(
			final JvmIdentifiableElement proxy, 
			final JvmIdentifiableElement candidate, 
			final XAbstractFeatureCall featureCall, 
			final XExpression implicitReceiver,
			final Provider<T> algorithm) {
		return onChangeEvictingCache.execWithoutCaching(this, new IUnitOfWork<T, XbaseResource>() {
			public T exec(XbaseResource state) throws Exception {
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
		});
		
	}
	
	protected synchronized XExpression getImplicitReceiver(XAbstractFeatureCall featureCall) {
		XExpression result = featureCallToReceiverAssumption.get(featureCall);
		if (result == null) {
			if (featureCallToReceiverAssumption.containsKey(featureCall))
				return null;
			return featureCall.getImplicitReceiver();
		}
		return result;
	}
	
	protected synchronized JvmIdentifiableElement getFeature(XAbstractFeatureCall featureCall, boolean resolve) {
		JvmIdentifiableElement potentialProxy = (JvmIdentifiableElement) featureCall.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
		if (potentialProxy == null || !potentialProxy.eIsProxy())
			return potentialProxy;
		JvmIdentifiableElement assumption = proxyToAssumption.get(potentialProxy);
		if (assumption != null)
			return assumption;
		if (!resolve)
			return potentialProxy;
		return featureCall.getFeature();
	}
	
	protected synchronized JvmConstructor getConstructor(XConstructorCall featureCall, boolean resolve) {
		JvmConstructor potentialProxy = (JvmConstructor) featureCall.eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, false);
		if (potentialProxy == null || !potentialProxy.eIsProxy())
			return potentialProxy;
		JvmConstructor assumption = (JvmConstructor) proxyToAssumption.get(potentialProxy);
		if (assumption != null)
			return assumption;
		if (!resolve)
			return potentialProxy;
		return featureCall.getConstructor();
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
	protected EObject handleCyclicResolution(Triple<EObject, EReference, INode> triple) throws AssertionError {
		return null;
	}
}
