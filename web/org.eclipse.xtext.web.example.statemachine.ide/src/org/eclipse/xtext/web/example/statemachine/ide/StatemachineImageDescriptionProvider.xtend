/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.ide

import org.eclipse.xtext.ide.labels.DecoratedImageDescription
import org.eclipse.xtext.ide.labels.EClassImageDescriptionProvider
import org.eclipse.xtext.ide.labels.SimpleImageDescription
import org.eclipse.xtext.web.example.statemachine.statemachine.OutputSignal

class StatemachineImageDescriptionProvider extends EClassImageDescriptionProvider {
	
	override getImageDescription(Object element) {
		val baseImage = super.getImageDescription(element)
		switch element {
			OutputSignal:
				new DecoratedImageDescription(baseImage, new SimpleImageDescription('output'))
			default:
				baseImage
		}
	}
	
}