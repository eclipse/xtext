/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.generator.trace.ILocationData

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Data class GeneratorNodeExtensions {
	
	def CompositeNode startTrace(ILocationData data) {
		val result =  new TraceNode(data)
		return result
	}
	
	def CompositeNode trace(CompositeNode parent, ILocationData data) {
		val result =  new TraceNode(data)
		parent.children += result
		return result
	}
	
	def CompositeNode indent(CompositeNode parent) {
		val result =  new IndentNode
		parent.children += result
		return result
	}
	
	def CompositeNode appendNewLine(CompositeNode parent) {
		parent.children += new NewLineNode
		return parent
	}
	
	def CompositeNode append(CompositeNode parent, String text) {
		parent.children += new TextNode(text)
		return parent
	}
	
	def CompositeNode append(CompositeNode parent, CharSequence text) {
		parent.children += new TextNode(text)
		return parent
	}
	
	String indentationString
	
	def IGeneratorNode appendTemplate(CompositeNode parent, StringConcatenationClient contents) {
		val proc = new TemplateNode(indentationString, contents, this)
		parent.children += proc
		return parent
	}
}