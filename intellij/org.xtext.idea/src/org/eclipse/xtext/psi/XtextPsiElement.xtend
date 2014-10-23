package org.eclipse.xtext.psi

import com.intellij.psi.PsiElement
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.psi.impl.BaseXtextFile

interface XtextPsiElement extends PsiElement {

	def IXtextLanguage getXtextLanguage()

	override BaseXtextFile getContainingFile()

	def Resource getResource()

	def INode getINode()

}
