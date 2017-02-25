/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtend2.lib.StringConcatenationClient.TargetStringConcatenation
import com.google.common.base.Splitter
import java.util.regex.Pattern

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class TemplateNode extends CompositeNode implements TargetStringConcatenation {

	val String indentationString
	val GeneratorNodeExtensions nodeFactory

	new(String indentationString, StringConcatenationClient contents, GeneratorNodeExtensions nodeFactory) {
		this.indentationString = indentationString
		this.nodeFactory = nodeFactory
		StringConcatenationClient.appendTo(contents, this)
	}

	CompositeNode currentParent = this
	boolean isEmptyLine = true;

	override append(Object object, String indentation) {
		val idx = indentation.indexOf(indentationString)
		if (idx === 0) {
			val before = currentParent
			try {
				currentParent = new IndentNode
				before.children += currentParent
				append(object, indentation.substring(indentationString.length))
			} finally {
				currentParent = before
			}
		}
		// TODO check indentation string
		append(object)
	}
	
	val splitter = Splitter.on(Pattern.compile("\\R"))
	
	override append(Object object) {
		switch object {
			StringConcatenationClient:
				nodeFactory.appendTemplate(currentParent, object)
			IGeneratorNode: {
				isEmptyLine = false				
				currentParent.children += object
			}
			default: {
				val str = object.toString
				val iter = splitter.split(str).iterator
				while (iter.hasNext) {
					val segment = iter.next
					if (!segment.isEmpty)
						isEmptyLine = false				
					nodeFactory.append(currentParent, segment)
					if (iter.hasNext) {
						newLine
					}
				}
			}
		}
	}

	override appendImmediate(Object object, String indentation) {
		for (var i = currentParent.children.size; i >= 0; i--) {
			val node = currentParent.children.get(i)
			if (node instanceof TextNode) {
				if (node.text.toString.trim.length === 0) {
					currentParent.children.remove(i)					
				}
			}
		}
		append(object, indentation)
	}

	override newLine() {
		currentParent.children += new NewLineNode
		isEmptyLine = true
	}

	override newLineIfNotEmpty() {
		if (!isEmptyLine)
			newLine
	}
	
	//
	override charAt(int index) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override length() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override subSequence(int start, int end) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
