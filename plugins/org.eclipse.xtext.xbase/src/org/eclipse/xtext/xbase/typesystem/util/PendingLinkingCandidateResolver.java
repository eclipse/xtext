/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.resource.DeliverNotificationAdapter;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.Inject;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class PendingLinkingCandidateResolver<Expression extends XExpression> {
	
	@Inject
	private DeliverNotificationAdapter.Provider notificationAdapterProvider;

	private final Expression expression;
	
	public PendingLinkingCandidateResolver(Expression expression) {
		this.expression = expression;
	}
	
	protected Expression getExpression() {
		return expression;
	}
	
	public void resolveLinkingProxy(InternalEObject owner, JvmIdentifiableElement newValue, EReference structuralFeature, int featureId) {
		EObject oldFeature = (EObject) owner.eGet(structuralFeature, false);
		if (oldFeature == null || !(oldFeature.eIsProxy())) {
			throw new IllegalStateException("Feature was already resolved to " + oldFeature);
		}
		if (owner.eNotificationRequired()) {
			try {
				notificationAdapterProvider.get(owner.eResource()).setDeliver(owner);
				internalSetValue(owner, structuralFeature, newValue);
			} finally {
				notificationAdapterProvider.get(owner.eResource()).resetDeliver(owner);
			}
			if (newValue != oldFeature) {
				owner.eNotify(new ENotificationImpl(owner, Notification.RESOLVE, featureId, oldFeature, newValue));
			}
		} else {
			internalSetValue(owner, structuralFeature, newValue);
		}
	}

	protected void internalSetValue(InternalEObject featureCall, EReference structuralFeature, JvmIdentifiableElement newValue) {
		featureCall.eSet(structuralFeature, newValue);
	}

}
