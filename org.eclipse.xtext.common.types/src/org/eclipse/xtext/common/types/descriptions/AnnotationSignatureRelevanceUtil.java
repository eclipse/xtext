/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.descriptions;

import static com.google.common.collect.Sets.*;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmAnnotationReference;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class AnnotationSignatureRelevanceUtil {

	private Set<String> relevantAnnotations;

	protected Set<String> getRelevantAnnotations() {
		if (relevantAnnotations == null)
			relevantAnnotations = createRelevantAnnotations();
		return relevantAnnotations;
	}

	protected HashSet<String> createRelevantAnnotations() {
		return newHashSet("java.lang.Deprecated", "org.eclipse.jdt.annotation.Nullable",
				"org.eclipse.jdt.annotation.NonNull", "org.eclipse.jdt.annotation.NonNullByDefault");
	}

	protected boolean isRelevant(JvmAnnotationReference annotationReference) {
		if (annotationReference == null 
				|| annotationReference.getAnnotation() == null
				|| annotationReference.getAnnotation().getIdentifier() == null)
			return false;
		return getRelevantAnnotations().contains(annotationReference.getAnnotation().getIdentifier());
	}

}
