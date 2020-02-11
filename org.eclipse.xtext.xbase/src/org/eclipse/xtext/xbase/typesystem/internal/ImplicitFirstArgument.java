/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.validation.IssueCodes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ImplicitFirstArgument extends AbstractImplicitFeature {

	protected ImplicitFirstArgument(XAbstractFeatureCall featureCall, XAbstractFeatureCall implicit,
			ExpressionTypeComputationState state) {
		super(featureCall, implicit, state);
	}

	@Override
	public void applyToModel(IResolvedTypes resolvedTypes) {
		getOwner().setImplicitFirstArgument(getFeatureCall());
	}
	
	@Override
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		if (!getState().isInstanceContext()) {
			JvmIdentifiableElement implicitFeature = getFeature();
			if (implicitFeature instanceof JvmType) {
				JvmIdentifiableElement feature = getState().getResolvedTypes().getLinkedFeature(getOwner());
				if (feature == null || feature.eIsProxy() || !(feature instanceof JvmFeature))
					return true;
				String message = "Cannot make an implicit reference to this from a static context";
				AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
						IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, message, getOwner(),
						XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
				result.accept(diagnostic);
				return false;
			}
		}
		return super.validate(result);
	}
	
}
