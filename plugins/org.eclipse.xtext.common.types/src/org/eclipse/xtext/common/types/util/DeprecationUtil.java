/*******************************************************************************
 * Copyright (c) 2011-14 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * @author Stéphane Galland - Add the deprecation utility for enclosing types.
 */
public class DeprecationUtil {
	public static boolean isDeprecated(JvmAnnotationTarget jvmAnnotationTarget) {
		if (jvmAnnotationTarget instanceof JvmMember) {
			return isDeprecatedMember((JvmMember) jvmAnnotationTarget);
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
	
	public static JvmMember getDeprecatedEnclosingTypeFor(JvmMember member) {
		EObject container = member.eContainer();
		while (container instanceof JvmMember) {
			JvmMember enclosingType = (JvmMember) container;
			if (isDeprecatedMember(enclosingType)) {
				return enclosingType;
			}
			container = enclosingType.eContainer();
		}
		return null;
	}
}
