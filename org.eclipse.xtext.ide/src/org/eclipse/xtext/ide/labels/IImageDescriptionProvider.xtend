/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.labels

import org.eclipse.emf.ecore.EObject
import com.google.inject.ImplementedBy
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.emf.ecore.EClass

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(EClassImageDescriptionProvider)
interface IImageDescriptionProvider {
	def IImageDescription getImageDescription(Object element)
}


class EClassImageDescriptionProvider implements IImageDescriptionProvider {
	
	override getImageDescription(Object element) {
		switch element {
			EClass:
				new AlternativeImageDescription(#[element.name] + element.EAllSuperTypes.map[name] + #[IImageDescription.DEFAULT.imageID])
			EObject: 
				element.eClass.imageDescription
			IEObjectDescription:
				element.EClass.imageDescription
			default:
				 IImageDescription.DEFAULT
		}
	}
}