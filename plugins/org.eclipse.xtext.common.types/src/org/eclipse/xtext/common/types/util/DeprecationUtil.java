/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;

/**
 * @author Holger Schill - Initial contribution and API
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
}
