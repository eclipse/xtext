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
 * A builder API to create generator node trees
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
class GeneratorNodeExtensions {
	
	@Inject GeneratorWhiteSpaceConfig wsConfig = new GeneratorWhiteSpaceConfig
	
	/**
	 * @return a root trace node for the given location
	 */
	def CompositeGeneratorNode trace(ILocationData data) {
		val result =  new TraceNode(data)
		return result
	}
	
	/**
	 * @return a root trace node for the given location
	 */
	def CompositeGeneratorNode trace(ILocationData data, boolean useForDebugging) {
		val result =  new TraceNode(data)
		result.useForDebugging = useForDebugging
		return result
	}
	
	/**
	 * @return a trace node for the given location, appended as a child on the given parent
	 */
	def CompositeGeneratorNode trace(CompositeGeneratorNode parent, ILocationData data) {
		val result =  new TraceNode(data)
		parent.children += result
		return result
	}
	
	/**
	 * @return a trace node for the given location, appended as a child on the given parent
	 */
	def CompositeGeneratorNode trace(CompositeGeneratorNode parent, ILocationData data, boolean useForDebugging) {
		val result =  new TraceNode(data)
		result.useForDebugging = useForDebugging
		parent.children += result
		return result
	}
	
	/**
	 * @return an indentation node, using the default indentation string, appended as a child on the given parent
	 */
	def CompositeGeneratorNode indent(CompositeGeneratorNode parent) {
		return indent(parent, wsConfig.indentationString)
	}
	
	/**
	 * Appends the indentation string at the current position of the parent and adds a new composite node, indicating the same indentation for 
	 * subsequent lines.
	 * 
	 * @return an indentation node, using the given indentString, appended as a child on the given parent
	 */
	def CompositeGeneratorNode indent(CompositeGeneratorNode parent, String indentString) {
		val indent =  new IndentNode(indentString)
		parent.children += indent
		return indent
	}
	
	/**
	 * Appends a line separator node to the given parent.
	 * 
	 * @return the given parent node 
	 */
	def CompositeGeneratorNode appendNewLine(CompositeGeneratorNode parent) {
		parent.children += new NewLineNode(wsConfig.lineDelimiter, false)
		return parent
	}
	
	/**
	 * Appends a line separator node to the given parent.
	 * 
	 * @return the given parent node 
	 */
	def CompositeGeneratorNode appendNewLine(CompositeGeneratorNode parent, String lineSeparator) {
		parent.children += new NewLineNode(lineSeparator, false)
		return parent
	}
	
	/**
	 * Appends a line separator node that will only be effective if the current line contains non-whitespace text.
	 * 
	 * @return the given parent node 
	 */
	def CompositeGeneratorNode appendNewLineIfNotEmpty(CompositeGeneratorNode parent) {
		parent.children += new NewLineNode(wsConfig.lineDelimiter, true)
		return parent
	}
	/**
	 * Creates a text node containing the toString() representation of the given object and
	 * appends it to the given parent node.
	 * 
	 * @return the given parent node 
	 */
	def CompositeGeneratorNode append(CompositeGeneratorNode parent, Object object) {
		if (object instanceof StringConcatenationClient) {
			appendTemplate(parent, object)
		} else if (object instanceof IGeneratorNode) {
			parent.children += object
		} else if (object !== null) {
			parent.children += new TextNode(object.toString)
		}
		return parent
	}
	
	/**
	 * Creates a template node for the given templateString and appends it to the given parent node.
	 * 
	 * Templates are translated to generator node trees and expressions in templates can be of type IGeneratorNode.
	 * 
	 * @return the given parent node
	 */
	def CompositeGeneratorNode appendTemplate(CompositeGeneratorNode parent, StringConcatenationClient templateString) {
		val proc = new TemplateNode(templateString, this)
		parent.children += proc
		return parent
	}
	
	
}