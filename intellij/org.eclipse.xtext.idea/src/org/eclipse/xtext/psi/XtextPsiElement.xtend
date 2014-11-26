package org.eclipse.xtext.psi

import com.intellij.psi.PsiElement
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.psi.impl.BaseXtextFile
import com.intellij.psi.PsiTarget

interface XtextPsiElement extends PsiElement, PsiTarget {

	def IXtextLanguage getXtextLanguage()

	def BaseXtextFile getXtextFile()

	def Resource getResource()

	def INode getINode()

}
