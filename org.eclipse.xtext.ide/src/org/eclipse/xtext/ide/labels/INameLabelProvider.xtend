/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.labels

import com.google.inject.ImplementedBy
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.IEObjectDescription

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(SimpleNameLabelProvider)
interface INameLabelProvider {
	def String getNameLabel(Object element)
}

class SimpleNameLabelProvider implements INameLabelProvider {

	override getNameLabel(Object element) {
		switch element {
			EObject:
				SimpleAttributeResolver.NAME_RESOLVER.apply(element)
			IEObjectDescription:
				element.name.lastSegment
			default:
				null
		}
	}
}