/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Sebastian Zarnekow - Use explicit deprecated bit if available
 */
public class DeprecationUtil {
	
	public static boolean isDeprecated(JvmAnnotationTarget jvmAnnotationTarget) {
		if (jvmAnnotationTarget instanceof JvmMember) {
			return isDeprecatedMember((JvmMember) jvmAnnotationTarget);
		}
		return false;
	}
	
	/**
	 * @since 2.13
	 */
	public static boolean isTransitivelyDeprecated(JvmAnnotationTarget jvmAnnotationTarget) {
		if (jvmAnnotationTarget instanceof JvmMember) {
			return isTransitivelyDeprecatedMember((JvmMember) jvmAnnotationTarget);
		}
		return false;
	}

	public static boolean isDeprecatedAnnotation(JvmAnnotationType jvmAnnotationType) {
		return !jvmAnnotationType.eIsProxy() && Deprecated.class.getName().equals(jvmAnnotationType.getIdentifier());
	}
	
	public static boolean isDeprecated(JvmType type) {
		if (type instanceof JvmMember) {
			return isDeprecatedMember((JvmMember) type);
		}
		return false;
	}
	
	public static boolean isDeprecatedMember(JvmMember member) {
		if (member.isSetDeprecated()) {
			return member.isDeprecated();
		}
		List<JvmAnnotationReference> annotations = member.getAnnotations();
		for(JvmAnnotationReference annotation: annotations) {
			JvmAnnotationType annotationType = annotation.getAnnotation();
			if (annotationType != null && Deprecated.class.getName().equals(annotationType.getIdentifier())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns {@code true} if the given member is contained in a deprecated member.
	 * @param member the member to be checked
	 */
	public static boolean isTransitivelyDeprecatedMember(JvmMember member) {
		EObject container = member;
		while(container instanceof JvmMember) {
			if (isDeprecatedMember((JvmMember) container)) {
				return true;
			}
			container = container.eContainer();
		}
		return false;
	}
	
}
