/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
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
