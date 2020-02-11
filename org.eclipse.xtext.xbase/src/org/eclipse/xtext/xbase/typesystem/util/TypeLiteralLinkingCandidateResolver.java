/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;

/**
 * @author kosyakov - Initial contribution and API
 */
public class TypeLiteralLinkingCandidateResolver extends PendingLinkingCandidateResolver<XAbstractFeatureCall> {
	
	public TypeLiteralLinkingCandidateResolver(XAbstractFeatureCall expression) {
		super(expression);
	}

	@Override
	protected void internalSetValue(InternalEObject featureCall, EReference structuralFeature, JvmIdentifiableElement newValue) {
		super.internalSetValue(featureCall, structuralFeature, newValue);
		if (featureCall instanceof XFeatureCall) {
			XFeatureCall casted = (XFeatureCall) featureCall;
			if (casted != getExpression()) {
				casted.setPackageFragment(true);
			} else {
				casted.setTypeLiteral(true);
			}
		} else if (featureCall instanceof XMemberFeatureCall) {
			XMemberFeatureCall casted = (XMemberFeatureCall) featureCall;
			if (casted != getExpression()) {
				casted.setPackageFragment(true);
			} else {
				casted.setTypeLiteral(true);
			}
			XExpression target = casted.getMemberCallTarget();
			IFeatureLinkingCandidate candidate = getLinkingCandidate(target);
			if (candidate == null || !candidate.isTypeLiteral()) {
				resolveLinkingProxy((InternalEObject) target, newValue, structuralFeature, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE);
			}
		}
	}

	@SuppressWarnings("unused")
	protected IFeatureLinkingCandidate getLinkingCandidate(XExpression target) {
		return null;
	}

}

	
