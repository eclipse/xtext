/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class PendingLinkingCandidateResolver<Expression extends XExpression> {
	
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
			boolean wasDeliver = owner.eDeliver();
			owner.eSetDeliver(false);
			internalSetValue(owner, structuralFeature, newValue);
			owner.eSetDeliver(wasDeliver);
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
