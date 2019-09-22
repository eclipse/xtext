/*******************************************************************************
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.labeling

import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider

/**
 * Provides labels for IEObjectDescriptions and IResourceDescriptions.
 *
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
class DomainmodelDescriptionLabelProvider extends DefaultDescriptionLabelProvider {
	override String image(IEObjectDescription description) {
		return '''«description.getEClass().getName()».gif'''
	}
}
