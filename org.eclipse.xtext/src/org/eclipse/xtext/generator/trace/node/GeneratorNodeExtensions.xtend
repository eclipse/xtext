/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import com.google.inject.Inject
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.generator.trace.ILocationData

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class GeneratorNodeExtensions {
	
	@Inject WhiteSpaceConfig wsConfig = new WhiteSpaceConfig
	
	def CompositeGeneratorNode startTrace(ILocationData data) {
		val result =  new TraceNode(data)
		return result
	}
	
	def CompositeGeneratorNode trace(CompositeGeneratorNode parent, ILocationData data) {
		val result =  new TraceNode(data)
		parent.children += result
		return result
	}
	
	def CompositeGeneratorNode indent(CompositeGeneratorNode parent) {
		val result =  new IndentNode
		parent.children += result
		return result
	}
	
	def CompositeGeneratorNode appendNewLine(CompositeGeneratorNode parent) {
		parent.children += new NewLineNode
		return parent
	}
	
	def CompositeGeneratorNode append(CompositeGeneratorNode parent, Object object) {
		if (object !== null) {
			parent.children += new TextNode(object.toString)
		}
		return parent
	}
	
	def CompositeGeneratorNode appendTemplate(CompositeGeneratorNode parent, StringConcatenationClient contents) {
		val proc = new TemplateNode(wsConfig.indentationString, contents, this)
		parent.children += proc
		return parent
	}
}