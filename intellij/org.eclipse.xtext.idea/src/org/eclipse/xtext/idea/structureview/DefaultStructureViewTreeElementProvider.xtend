/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.structureview

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.navigation.ItemPresentation
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.idea.presentation.ItemPresentationProvider
import org.eclipse.xtext.psi.impl.BaseXtextFile

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class DefaultStructureViewTreeElementProvider implements IStructureViewTreeElementProvider {

	@Inject
	Provider<EObjectTreeElement> objectTreeElementProvider

	@Inject
	protected extension ItemPresentationProvider itemPresentationProvider

	@Inject
	Provider<EStructuralFeatureTreeElement> structuralFeatureTreeElementProvider

	def dispatch void buildChildren(StructureViewTreeElement structureViewTreeElement) {
	}

	def dispatch void buildChildren(XtextFileTreeElement it) {
		val modelElement = element.resource.contents.head
		if (modelElement == null) {
			return
		}
		val itemPresentation = modelElement.itemPresentation ?: new PresentationData
		if (itemPresentation instanceof PresentationData)
			if (itemPresentation.presentableText == null)
				itemPresentation.presentableText = modelElement.eResource.URI.trimFileExtension.lastSegment
		addChild(
			modelElement.createEObjectTreeElement(
				element,
				modelElement.leaf,
				itemPresentation
			)
		)
	}

	def dispatch void buildChildren(EObjectTreeElement it) {
		addChildren(object.eContents.map[child|child.createEObjectTreeElement(xtextFile)])
	}

	def dispatch void buildChildren(EStructuralFeatureTreeElement it) {
		val values = owner.eGet(feature)
		if (values instanceof List<?>) {
			if (feature.many) {
				addChildren(values.filter(EObject).map[value|value.createEObjectTreeElement(xtextFile)])
			}
		} else if (values instanceof EObject) {
			addChild(values.createEObjectTreeElement(xtextFile))
		}
	}

	protected def createEObjectTreeElement(EObject modelElement, BaseXtextFile xtextFile) {
		createEObjectTreeElement(
			modelElement,
			xtextFile,
			modelElement.leaf,
			modelElement.itemPresentation
		)
	}

	protected def createEObjectTreeElement(EObject modelElement, BaseXtextFile xtextFile, boolean leaf,
		ItemPresentation itemPresentation) {
		if (itemPresentation?.presentableText == null && leaf) {
			return null
		}
		objectTreeElementProvider.get => [ objectTreeElement |
			objectTreeElement.object = modelElement
			objectTreeElement.xtextFile = xtextFile
			objectTreeElement.leaf = leaf
			objectTreeElement.itemPresentation = itemPresentation
			objectTreeElement.structureViewTreeElementProvider = this
		]
	}

	protected def createEStructuralFeatureTreeElement(EObject modelElement, EStructuralFeature feature,
		BaseXtextFile xtextFile, boolean leaf, ItemPresentation itemPresentation) {
		structuralFeatureTreeElementProvider.get => [ structuralFeatureTreeElement |
			structuralFeatureTreeElement.owner = modelElement
			structuralFeatureTreeElement.feature = feature
			structuralFeatureTreeElement.xtextFile = xtextFile
			structuralFeatureTreeElement.leaf = leaf
			structuralFeatureTreeElement.itemPresentation = itemPresentation
			structuralFeatureTreeElement.structureViewTreeElementProvider = this
		]
	}

	protected def isLeaf(EObject modelElement) {
		modelElement.eClass.getEAllContainments.exists [ containmentRef |
			modelElement.eIsSet(containmentRef)
		]
	}

}