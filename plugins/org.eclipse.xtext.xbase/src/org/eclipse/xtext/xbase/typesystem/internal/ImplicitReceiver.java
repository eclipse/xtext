/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.validation.IssueCodes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ImplicitReceiver extends AbstractImplicitFeature {

	public ImplicitReceiver(XAbstractFeatureCall featureCall, XAbstractFeatureCall implicit,
			ExpressionTypeComputationState state) {
		super(featureCall, implicit, state);
	}

	public void applyToModel() {
		getOwner().setImplicitReceiver(getFeatureCall());
	}
	
	@Override
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		if (!getState().isInstanceContext()) {
			JvmIdentifiableElement implicitFeature = getFeature();
			if (implicitFeature instanceof JvmType && !getState().isInstanceContext()) {
				JvmIdentifiableElement feature = getState().getResolvedTypes().getLinkedFeature(getOwner());
				if (feature == null || feature.eIsProxy() || !(feature instanceof JvmFeature))
					return true;
				// TODO validation may be suppressed
				String typeName = getFeatureTypeName(feature);
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
	
	protected String getFeatureTypeName(JvmIdentifiableElement feature) {
		if (feature instanceof JvmFormalParameter) {
			return "parameter";
		}
		if (feature instanceof XVariableDeclaration) {
			return "local variable";
		}
		if (feature instanceof JvmField) {
			return "field";
		}
		if (feature instanceof JvmOperation) {
			return "method";
		}
		if (feature instanceof JvmConstructor) {
			return "constructor";
		}
		throw new IllegalStateException();
	}

}
