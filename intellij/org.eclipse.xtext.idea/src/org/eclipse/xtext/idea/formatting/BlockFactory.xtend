/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.formatting

import com.google.inject.ImplementedBy
import com.intellij.formatting.Block
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.codeStyle.CodeStyleSettings

/**
 * @author kosyakov - Initial contribution and API
 */
@ImplementedBy(DefaultBlockFactory)
interface BlockFactory {
	
	def Block createRootBlock(PsiElement element, CodeStyleSettings settings)
	
	def Block createBlock(ASTNode node, Block parentBlock)

}