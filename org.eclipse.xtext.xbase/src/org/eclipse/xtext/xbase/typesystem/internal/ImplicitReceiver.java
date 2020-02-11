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
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.internal.util.FeatureKinds;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.validation.IssueCodes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ImplicitReceiver extends AbstractImplicitFeature {

	public ImplicitReceiver(XAbstractFeatureCall featureCall, XAbstractFeatureCall implicit,
			ExpressionTypeComputationState state) {
		super(featureCall, implicit, state);
	}
	
	@Override
	public void applyToComputationState() {
		super.applyToComputationState();
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XMemberFeatureCall) {
			XExpression target = ((XMemberFeatureCall) featureCall).getMemberCallTarget();
			if (target == null || !(target instanceof XAbstractFeatureCall))
				throw new IllegalStateException();
			XAbstractFeatureCall targetFeatureCall = (XAbstractFeatureCall) target;
			ResolvedTypes resolvedTypes = getState().getResolvedTypes();
			LightweightTypeReference targetType = resolvedTypes.getActualType(targetFeatureCall.getFeature());
			if (targetType == null) {
				throw new IllegalStateException();
			}
			TypeExpectation expectation = new TypeExpectation(null, getState(), false);
			resolvedTypes.acceptType(targetFeatureCall, expectation, targetType.copyInto(resolvedTypes.getReferenceOwner()), false, ConformanceFlags.UNCHECKED);
		}
	}

	@Override
	public void applyToModel(IResolvedTypes resolvedTypes) {
		getOwner().setImplicitReceiver(getFeatureCall());
	}
	
	@Override
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		if (!getState().isInstanceContext()) {
			JvmIdentifiableElement implicitFeature = getFeature();
			if (implicitFeature instanceof JvmType) {
				JvmIdentifiableElement feature = getState().getResolvedTypes().getLinkedFeature(getOwner());
				if (feature == null || feature.eIsProxy() || !(feature instanceof JvmFeature))
					return true;
				// TODO validation may be suppressed
				String typeName = FeatureKinds.getTypeName(feature);
				String message = String.format("Cannot make a static reference to the non-static %s %s from the type %s", typeName, feature.getSimpleName(), getFeature().getSimpleName());
				AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
						IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, message, getOwner(),
						XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
				result.accept(diagnostic);
				return false;
			} else if (implicitFeature instanceof JvmFeature && !((JvmFeature) implicitFeature).isStatic()) {
				JvmIdentifiableElement feature = getState().getResolvedTypes().getLinkedFeature(getOwner());
				if (feature == null || feature.eIsProxy() || !(feature instanceof JvmFeature))
					return true;
				// TODO validation may be suppressed
				String message = String.format("Cannot make an implicit static reference to the non-static extension %s", feature.getSimpleName());
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
