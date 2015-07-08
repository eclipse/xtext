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