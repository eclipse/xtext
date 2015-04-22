/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi.impl

import com.google.inject.Inject
import com.intellij.extapi.psi.StubBasedPsiElementBase
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.tree.IElementType
import javax.swing.Icon
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.psi.PsiEObject
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.service.OperationCanceledError

class PsiEObjectImpl<T extends StubElement> extends StubBasedPsiElementBase<T> implements PsiEObject {

	@Inject
	protected extension ILocationInFileProvider locationInFileProvider
	
	final IElementType elementType

	protected new(T stub, IStubElementType nodeType) {
		super(stub, nodeType)
		this.elementType = nodeType
		getXtextLanguage().injectMembers(this)
	}

	new(ASTNode node) {
		super(node)
		this.elementType = node.getElementType()
		getXtextLanguage().injectMembers(this)
	}

	override EClass getEClass() {
		var INode node = getINode()
		if (node.hasDirectSemanticElement()) {
			return node.getSemanticElement().eClass()
		}
		var EReference eReference = getEReference()
		if (eReference !== null) {
			return eReference.getEReferenceType()
		}
		return null
	}

	override EReference getEReference() {
		if (elementType instanceof IGrammarAwareElementType) {
			var EObject grammarElement = (elementType as IGrammarAwareElementType).getGrammarElement()
			if (grammarElement instanceof CrossReference) {
				return GrammarUtil.getReference(grammarElement as CrossReference)
			}
		}
		var INode node = getINode()
		if (node === null) {
			return null
		}
		var EObject grammarElement = node.getGrammarElement()
		if (grammarElement instanceof CrossReference) {
			return GrammarUtil.getReference(grammarElement as CrossReference)
		}
		if (node.hasDirectSemanticElement()) {
			var EObject semanticElement = node.getSemanticElement()
			return semanticElement.eContainmentFeature()
		}
		return null
	}

	override INode getINode() {
		return getXtextFile().getINode(getNode())
	}

	override boolean isRoot() {
		return getParent() instanceof BaseXtextFile
	}

	override EObject getEObject() {
		return getINode().getSemanticElement()
	}

	override Resource getResource() {
		return getXtextFile().getResource()
	}

	override IXtextLanguage getXtextLanguage() {
		return getLanguage() as IXtextLanguage
	}

	override BaseXtextFile getXtextFile() {
		return getContainingFile() as BaseXtextFile
	}

	override protected Icon getElementIcon(int flags) {
		return AllIcons.General.SecondaryGroup
	}

	override String toString() {
		var StringBuilder builder = new StringBuilder(getClass().getName())
		builder.append("(").append(elementType).append(")")
		return builder.toString()
	}

	override getTextOffset() {
		significantTextRegion.offset
	}

	/** 
	 * @return
	 */
	def protected getSignificantTextRegion() {
		try {
			EObject.significantTextRegion
		} catch (OperationCanceledError e) {
			throw e.wrapped
		}
	}

}
