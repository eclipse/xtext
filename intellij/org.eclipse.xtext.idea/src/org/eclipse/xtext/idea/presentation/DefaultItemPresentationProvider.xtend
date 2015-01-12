/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.presentation

import com.google.inject.Inject
import com.google.inject.Singleton
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import javax.swing.Icon
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.FeatureMap
import org.eclipse.xtext.psi.IPsiModelAssociations

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class DefaultItemPresentationProvider implements ItemPresentationProvider {
	
	@Inject IPsiModelAssociations psiModelAssociations
	
	override getItemPresentation(Object element) {
		new PresentationData => [
			icon = element.image
			presentableText = element.text
		]
	}
	
	def dispatch Icon image(Void element) {
		AllIcons.General.SecondaryGroup
	}
	
	def dispatch Icon image(Object element) {
		AllIcons.General.SecondaryGroup
	}
	
	def dispatch Icon image(EObject element) {
		val psiElement = psiModelAssociations.getPsiElement(element)
		if (psiElement != null) {
			return psiElement.getIcon(0)
		}
		AllIcons.General.SecondaryGroup
	}
	
	def dispatch String text(Void element) {
		'<null>'
	}
	
	def dispatch String text(Object element) {
		'<null>'
	}
	
	def dispatch String text(EObject element) {
		val labelFeature = element.eClass.labelFeature
		if (labelFeature != null) {
			element.eGet(labelFeature)?.toString
		}
	}

	def protected getLabelFeature(EClass eClass) {
		var EAttribute result = null
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			if (!eAttribute.isMany() && eAttribute.getEType().getInstanceClass() != FeatureMap.Entry) {
				if ("name".equalsIgnoreCase(eAttribute.getName())) {
					return eAttribute
				} else if (result == null) {
					result = eAttribute
				} else if (eAttribute.getEAttributeType().getInstanceClass() == String &&
					result.getEAttributeType().getInstanceClass() != String) {
					result = eAttribute
				}
			}
		}
		return result
	}
	
}