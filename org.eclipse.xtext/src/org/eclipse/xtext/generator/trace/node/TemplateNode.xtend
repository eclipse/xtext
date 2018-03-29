/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import com.google.common.base.Splitter
import com.google.common.collect.Iterables
import java.util.regex.Pattern
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtend2.lib.StringConcatenationClient.TargetStringConcatenation
import com.google.common.collect.Lists

/**
 * A template node applies a {@link StringConcatenationClient} to compute its children.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
class TemplateNode extends CompositeGeneratorNode implements TargetStringConcatenation {

	val GeneratorNodeExtensions nodeFactory

	new(StringConcatenationClient contents, GeneratorNodeExtensions nodeFactory) {
		this.nodeFactory = nodeFactory
		StringConcatenationClient.appendTo(contents, this)
	}

	CompositeGeneratorNode currentParent = this

	override append(Object object, String indentation) {
		if (indentation.length > 0) {
			val before = currentParent
			try {
				currentParent = new IndentNode(indentation, false, true)
				before.children += currentParent
				append(object)
			} finally {
				currentParent = before
			}
		} else {
			append(object)
		}
	}
	
	val lineSplitter = Splitter.on(Pattern.compile("\\R"))
	
	override append(Object object) {
		if (object === null) {
			return;
		}
		switch object {
			StringConcatenationClient:
				nodeFactory.appendTemplate(currentParent, object)
			IGeneratorNode: {
				currentParent.children += object
			}
			default: {
				val str = object.toString
				val iter = lineSplitter.split(str).iterator
				while (iter.hasNext) {
					val segment = iter.next
					nodeFactory.append(currentParent, segment)
					if (iter.hasNext) {
						newLine
					}
				}
			}
		}
	}
	
	protected def Iterable<IGeneratorNode> leafsBackwards(IGeneratorNode it) {
		switch it {
			CompositeGeneratorNode : {
				children.reverseView.map[leafsBackwards].reduce[p1, p2| Iterables.concat(p1, p2)]
			}
			default : {
				#[it]
			}
		}
	}

	override appendImmediate(Object object, String indentation) {
		val removed = Lists.newArrayList
		for (var i = currentParent.children.size - 1; i >= 0; i--) {
			val node = currentParent.children.get(i)
			if (node instanceof TextNode && !(node as TextNode).text.hasContent) {
				removed += currentParent.children.remove(i)
			} else if (node instanceof NewLineNode) {
				removed += currentParent.children.remove(i)
			} else {
				append(object, indentation)
				removed.reverse.forEach[append(it, indentation)]
				return
			}
		}
		append(object, indentation)
	}

	protected static def boolean hasContent(CharSequence s) {
		for (var i = 0; i < s.length; i++) {
			if (!Character.isWhitespace(s.charAt(i)))
				return true
		}
		return false
	}

	override newLine() {
		this.nodeFactory.appendNewLine(currentParent)
	}

	override newLineIfNotEmpty() {
		this.nodeFactory.appendNewLineIfNotEmpty(currentParent)
	}
	
	override charAt(int index) {
		throw new UnsupportedOperationException
	}

	override length() {
		throw new UnsupportedOperationException
	}

	override subSequence(int start, int end) {
		throw new UnsupportedOperationException
	}

}
