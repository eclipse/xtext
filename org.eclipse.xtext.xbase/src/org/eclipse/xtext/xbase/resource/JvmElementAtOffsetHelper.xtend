/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations

/**
 * @author Holger Schill - Initial contribution and API
 */
class JvmElementAtOffsetHelper {

	@Inject
	EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	IJvmModelAssociations associations;

	def JvmIdentifiableElement getJvmIdentifiableElement(XtextResource resource, int offset) {
		val selectedElement = eObjectAtOffsetHelper.resolveElementAt(resource, offset)
		if(selectedElement === null)
			return null
		if(selectedElement instanceof JvmIdentifiableElement)
			return selectedElement
		val jvmElements = associations.getJvmElements(selectedElement);
		if (!jvmElements.isEmpty()) {
			val firstElement = jvmElements.head
			if(firstElement instanceof JvmIdentifiableElement){
				return firstElement;	
			}
		}
		return null;
	}
}
