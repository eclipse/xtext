/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi.impl

import com.google.inject.Inject
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.progress.ProgressIndicatorProvider
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.util.IncorrectOperationException
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.linking.lazy.CrossReferenceDescription
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.psi.PsiEObjectFactory
import org.eclipse.xtext.psi.XtextPsiElement
import org.eclipse.xtext.psi.XtextPsiReference
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

class XtextPsiReferenceImpl extends PsiReferenceBase<XtextPsiElement> implements XtextPsiReference {
	
	@Inject
	extension PsiEObjectFactory psiEObjectFactory

	@Inject
	IQualifiedNameConverter qualifiedNameConverter

	@Inject
	extension IPsiModelAssociations psiModelAssociations

	@Inject
	CrossReferenceDescription.CrossReferenceDescriptionProvider crossReferenceDescriptionProvider

	new(XtextPsiElement element) {
		super(element)
		val language = element.language
		if (language instanceof IXtextLanguage) {
			language.injectMembers(this)
		}
	}

	override create {
		val textRegion = crossReferenceDescription.textRegion
		var startOffset = textRegion.offset - myElement.textRange.startOffset
		if (startOffset < 0) {
			rangeInElement
		} else {
			val endOffset = startOffset + textRegion.length
			new TextRange(startOffset, endOffset)
		}
	} getRangeToHighlightInElement() {
	}

	override protected calculateDefaultRangeInElement() {
		val referencenNode = referenceNode
		val startOffset = referencenNode.startOffset - myElement.node.startOffset
		val endOffset = startOffset + referenceNode.textLength
		new TextRange(startOffset, endOffset)
	}

	override getRanges() {
		val rangeInElement = rangeInElement
		val rangeToHighlightInElement = rangeToHighlightInElement
		if (rangeInElement == rangeToHighlightInElement) {
			#[rangeInElement]
		} else {
			#[rangeInElement, rangeToHighlightInElement]
		}
	}

	override PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
		val myNode = myElement.node
		val referenceNode = referenceNode
		
		val newReferenceNode = psiEObjectFactory.createLeafIdentifier(newElementName, referenceNode)
		referenceNode.treeParent.replaceChild(referenceNode, newReferenceNode)

		if (referenceNode == myNode) {
			return newReferenceNode.psi
		}
		return myElement
	}

	// FIXME: we should come up with the better approach to detect editable part of the reference
	protected def getReferenceNode() {
		var referenceNode = myElement.node
		while (referenceNode instanceof CompositeElement) {
			referenceNode = referenceNode.lastChildNode
		}
		referenceNode
	}

	protected def getCrossReferenceDescription() {
		val crossReference = (myElement.node.elementType as IGrammarAwareElementType).grammarElement as CrossReference

		val node = myElement.xtextFile.getINode(myElement.node)
		val context = node.findActualSemanticObjectFor
		val reference = crossReference.reference
		val index = context.findNodesForFeature(reference).indexed.findFirst [
			value.totalOffset <= node.totalOffset && value.totalEndOffset >= node.totalEndOffset
		]?.key
		crossReferenceDescriptionProvider.get(context, reference, index)
	}

	override getVariants() {
		ProgressIndicatorProvider.checkCanceled
		var crossReferenceDescription = crossReferenceDescription
		if (crossReferenceDescription == null) {
			return emptyList
		}
		var variants = newArrayList
		for (objectDescription : crossReferenceDescription.variants) {
			ProgressIndicatorProvider.checkCanceled
			var name = qualifiedNameConverter.toString(objectDescription.name)
			// TODO for some unknown reason here we get an eobject description with a dangling object
			// see bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=481381
			if (objectDescription.EObjectOrProxy.eIsProxy || objectDescription.EObjectOrProxy.eResource !== null) {
				var element = objectDescription.getPsiElement(myElement.xtextFile.resource)
				if (element != null) {
					variants +=
						LookupElementBuilder.create(name).withTypeText(element.navigationElement.containingFile.name)
				}
			}
		}
		variants
	}

	override resolve() {
		ProgressIndicatorProvider.checkCanceled
		var crossReferenceDescription = crossReferenceDescription
		if (crossReferenceDescription == null) {
			return null
		}
		var object = crossReferenceDescription.resolve
		ProgressIndicatorProvider.checkCanceled
		object.psiElement
	}
	
	override toString() {
		class.simpleName
	}

}