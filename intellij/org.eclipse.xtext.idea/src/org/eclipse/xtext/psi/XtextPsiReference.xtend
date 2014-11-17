package org.eclipse.xtext.psi

import com.google.inject.Inject
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.lang.ASTFactory
import com.intellij.openapi.progress.ProgressIndicatorProvider
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.util.IncorrectOperationException
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.linking.lazy.CrossReferenceDescription
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType

import static extension com.intellij.psi.impl.source.codeStyle.CodeEditUtil.*
import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

class XtextPsiReference extends PsiReferenceBase<XtextPsiElement> implements PsiReference {

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

	protected def getReferenceNode() {
		var referenceNode = myElement.node
		while (referenceNode instanceof CompositeElement) {
			referenceNode = referenceNode.lastChildNode
		}
		referenceNode
	}

	override protected calculateDefaultRangeInElement() {
		val node = myElement.node
		val referenceNode = referenceNode
		val startOffset = referenceNode.startOffset - node.startOffset
		val endOffset = startOffset + referenceNode.textLength
		new TextRange(startOffset, endOffset)
	}

	override PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
		val myNode = myElement.node
		val referenceNode = referenceNode

		val newReferenceNode = ASTFactory.leaf(referenceNode.elementType, newElementName) => [
			nodeGenerated = true
		]
		referenceNode.treeParent.replaceChild(referenceNode, newReferenceNode)

		if (referenceNode == myNode) {
			return newReferenceNode.psi
		}
		return myElement
	}

	protected def getCrossReferenceDescription() {
		val crossReference = (myElement.node.elementType as IGrammarAwareElementType).grammarElement as CrossReference

		val node = myElement.containingFile.getINode(myElement.node)
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
			var element = objectDescription.getPsiElement(myElement.containingFile.resource)
			if (element != null) {
				variants +=
					LookupElementBuilder.create(name).withTypeText(element.navigationElement.containingFile.name)
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

}