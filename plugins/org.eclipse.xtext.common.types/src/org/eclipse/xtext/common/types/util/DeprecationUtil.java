/*******************************************************************************
 * Copyright (c) 2011-14 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmMember;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Stéphane Galland
 */
public class DeprecationUtil {
	public static boolean isDeprecated(JvmAnnotationTarget jvmAnnotationTarget) {
		for (JvmAnnotationReference ref : jvmAnnotationTarget.getAnnotations()) {
			if (ref != null && !ref.eIsProxy()) {
				JvmAnnotationType annotation = ref.getAnnotation();
				if(annotation != null && !annotation.eIsProxy() && isDeprecated(annotation))
					return true;
			}
		}
		return false;
	}

	public static boolean isDeprecated(JvmAnnotationType jvmAnnotationType) {
		return jvmAnnotationType.getIdentifier().equals(Deprecated.class.getName());
	}

	public static boolean isDeprecated(EObject t) {
		if (t instanceof JvmAnnotationTarget) {
			return isDeprecated((JvmAnnotationTarget)t);
		}
		return false;
	}

	public static boolean isContainerDeprecated(EObject t) {
		EObject visitor = t;
		while (visitor instanceof JvmMember) {
			JvmMember member = (JvmMember)visitor;
			if (isDeprecated(member)) {
				return true;
			}
			visitor = member.getDeclaringType();
		}
		return false;
	}
}
