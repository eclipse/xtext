/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnresolvedAnnotationTypeAwareMessageProvider extends UnresolvedFeatureCallTypeAwareMessageProvider {

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		if (isPropertyOfUnresolvedAnnotation(context))
			return null;
		return super.getUnresolvedProxyMessage(context);
	}
	
	protected boolean isPropertyOfUnresolvedAnnotation(ILinkingDiagnosticContext context) {
		EObject object = context.getContext();
		if (object instanceof XAnnotationElementValuePair && context.getReference() == XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT) {
			XAnnotation annotation = EcoreUtil2.getContainerOfType(object, XAnnotation.class);
			if (annotation != null) {
				JvmType annotationType = annotation.getAnnotationType();
				if (annotationType == null || annotationType.eIsProxy() || !(annotationType instanceof JvmAnnotationType)) {
					return true;
				}
			}
		}
		return false;
	}

}
