/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Inject;

public class ElementAtOffsetUtil {
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	public EObject getElementAt(XtextResource resource, int offset) {
		EObject crossLinkedEObject = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, offset);
		if (crossLinkedEObject != null) {
			return crossLinkedEObject;
		} else {
			EObject containedEObject = eObjectAtOffsetHelper.resolveContainedElementAt(resource, offset);
			if (containedEObject != null) {
				ITextRegion nameRegion = locationInFileProvider.getSignificantTextRegion(containedEObject);
				if (nameRegion.contains(offset)) {
					return containedEObject;
				}
			}
		}
		return null;
	}
}
