/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.jvm

import com.intellij.lang.ASTNode
import com.intellij.lang.LighterASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.java.parser.JavaParser
import com.intellij.lang.java.parser.JavaParserUtil
import com.intellij.psi.impl.source.JavaFileElementType
import com.intellij.psi.impl.source.tree.java.JavaFileElement
import com.intellij.psi.tree.IElementType
import com.intellij.util.diff.FlyweightCapableTreeStructure

/**
 * @author kosyakov - Initial contribution and API
 */
class JvmFileElementType extends JavaFileElementType {

	public static val INSTANCE = new JvmFileElementType
	
	override createNode(CharSequence text) {
		new JvmFileElement(text, this)
	}

	override FlyweightCapableTreeStructure<LighterASTNode> parseContentsLight(ASTNode chameleon) {
		val PsiBuilder builder = new JvmPsiBuilder(JavaParserUtil.createBuilder(chameleon))
		doParse(builder)
		return builder.getLightTree()
	}

	override ASTNode parseContents(ASTNode chameleon) {
		val PsiBuilder builder = new JvmPsiBuilder(JavaParserUtil.createBuilder(chameleon))
		doParse(builder)
		return builder.getTreeBuilt().getFirstChildNode()
	}

	def private void doParse(PsiBuilder builder) {
		val PsiBuilder.Marker root = builder.mark()
		JavaParser.INSTANCE.getFileParser().parse(builder)
		root.done(this)
	}

}

class JvmFileElement extends JavaFileElement {
	
	val IElementType elementType
	
	new(CharSequence text, IElementType elementType) {
		super(text)
		this.elementType = elementType
	}
	
	override getElementType() {
		elementType
	}
	
}