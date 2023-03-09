/*******************************************************************************
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class JvmElementAtOffsetHelper {
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private IJvmModelAssociations associations;

	public JvmIdentifiableElement getJvmIdentifiableElement(XtextResource resource, int offset) {
		EObject selectedElement = eObjectAtOffsetHelper.resolveElementAt(resource, offset);
		if (selectedElement == null) {
			return null;
		}
		if (selectedElement instanceof JvmIdentifiableElement) {
			return ((JvmIdentifiableElement) selectedElement);
		}
		Set<EObject> jvmElements = associations.getJvmElements(selectedElement);
		if (!jvmElements.isEmpty()) {
			EObject firstElement = Iterables.getFirst(jvmElements, null);
			if (firstElement instanceof JvmIdentifiableElement) {
				return ((JvmIdentifiableElement) firstElement);
			}
		}
		return null;
	}
}
