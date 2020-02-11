/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import java.util.ArrayDeque
import java.util.Deque
import java.util.List
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtext.generator.trace.AbstractStatefulTraceRegion
import org.eclipse.xtext.generator.trace.AbstractTraceRegion
import org.eclipse.xtext.generator.trace.ILocationData
import org.eclipse.xtext.generator.trace.ITraceRegionProvider
import org.eclipse.xtext.generator.trace.TraceNotFoundException
import org.eclipse.xtext.util.ITextRegionWithLineInformation
import org.eclipse.xtext.util.TextRegionWithLineInformation

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Dennis Huebner - New GeneratorNodeProcessor.Context implementation
 */
class GeneratorNodeProcessor {
	
	@Data static class Result implements CharSequence, ITraceRegionProvider {
		@Delegate CharSequence contents
		AbstractTraceRegion traceRegion
		
		override getTraceRegion() throws TraceNotFoundException {
			if (traceRegion === null) {
				throw new TraceNotFoundException()
			}
			return traceRegion
		}
		
		override toString() {
			contents.toString()
		}
	}
	
	protected static class Context {
		List<StringBuilder> _lines = newArrayList(new StringBuilder)
		Deque<IndentNode> _currentIndents = new ArrayDeque
		boolean _pendingIndent = true
		AbstractTraceRegion _currentRegion = null
		
		int _contentLength = 0
		int _indentLength = 0
		
		def String currentLineContent() {
			return _lines.get(currentLineNumber).toString
		}
		
		def int contentLength() {
			if (isPendingIndent) {
				return _contentLength + _indentLength
			} else {
				return _contentLength
			}
		}
		
		def int currentLineNumber() {
			return _lines.size - 1
		}

		def String getContent() {
			_lines.join
		}
		
		def getCurrentRegion() {
			_currentRegion
		}
		
		def void increaseIndent(IndentNode node) {
			_currentIndents.push(node)
			recalculateIndentLength
		}
		
		def void decreaseIndents() {
			_currentIndents.pop
			recalculateIndentLength
		}
		
		protected def recalculateIndentLength() {
			_indentLength = currentIndents.fold(0)[$0 + $1.indentationString.length]
		}
		
		def void appendToCurrentLine(CharSequence chars) {
			_lines.get(currentLineNumber).append(chars)
			_contentLength = _contentLength + chars.length
		}
		
		def isPendingIndent() {
			_pendingIndent
		}
		
		def void addNewLine() {
			_lines.add(new StringBuilder)
		}
		
		def void setPendingIndent(boolean pending) {
			_pendingIndent = pending
		}
		
		/**
		 * Replace the current line with new StringBuilder
		 */
		def void resetCurrentLine() {
			val lineContent = _lines.get(currentLineNumber)
			if (!lineContent.nullOrEmpty) {
				_contentLength = _contentLength - lineContent.length
			}
			_lines.set(currentLineNumber, new StringBuilder)
		}
		
		def void insertIntoCurrentLine(int i, StringBuilder builder) {
			_lines.get(currentLineNumber).insert(i, builder)
			_contentLength = _contentLength + builder.length
		}
		
		/**
		 * @return a copy of current indent nodes
		 */
		def Deque<IndentNode> getCurrentIndents() {
			new ArrayDeque(_currentIndents)
		}
		
		def setCurrentRegion(AbstractTraceRegion region) {
			_currentRegion = region
		}
		
	}
	
	def Result process(IGeneratorNode root) {
		val ctx = new Context()
		doProcess(root, ctx)
		return new Result(ctx.content, ctx.currentRegion)
	}

	/**
	 * An indent node prepends indentation to each line of its children.
	 */
	protected def dispatch void doProcess(IndentNode node, Context ctx) {
		if (node._hasContent(ctx)) {
			if (node.indentImmediately && !ctx.pendingIndent) {
				ctx.appendToCurrentLine(node.indentationString)
			}
			try {
				ctx.increaseIndent(node)
				doProcessChildren(node, ctx)
			} finally {
				ctx.decreaseIndents
			}
		}
	}
	
	protected def dispatch void doProcess(NewLineNode node, Context ctx) {
		if (node.ifNotEmpty && !ctx.currentLineContent.hasNonWhitespace) {
			ctx.resetCurrentLine()
		} else {
			if (ctx.pendingIndent)
				handlePendingIndent(ctx, true)
			ctx.appendToCurrentLine(node.lineDelimiter)
			ctx.addNewLine()
		}
		ctx.setPendingIndent = true
	}
		
		

	protected def dispatch void doProcess(TextNode node, Context ctx) {
		if (node._hasContent(ctx)) {
			if (ctx.pendingIndent)
				handlePendingIndent(ctx, false)
			ctx.appendToCurrentLine(node.text)
		}
	}
	
	protected def void handlePendingIndent(Context ctx, boolean endOfLine) {
		val indentString = new StringBuilder
		for (indentNode : ctx.currentIndents) {
			if (indentNode.indentEmptyLines || !endOfLine)
				indentString.append(indentNode.indentationString)
		}
		if (indentString.length > 0) {
			ctx.insertIntoCurrentLine(0, indentString)
		}
		ctx.pendingIndent = false
	}

	protected def dispatch void doProcess(TraceNode node, Context ctx) {
		if (node._hasContent(ctx)) {
			val beforeRegion = ctx.currentRegion
			val newRegion = new CompletableTraceRegion(node.useForDebugging, node.sourceLocation, beforeRegion)
			val offset = ctx.contentLength
			val startLineNumber = ctx.currentLineNumber
			try {
				ctx.currentRegion = newRegion
				doProcessChildren(node, ctx)
			} finally {
				if (beforeRegion !== null)
					ctx.currentRegion = beforeRegion
				newRegion.complete(offset, ctx.contentLength - offset, startLineNumber, ctx.currentLineNumber)
			}
		}
	}
	
	protected def dispatch void doProcess(CompositeGeneratorNode node, Context ctx) {
		doProcessChildren(node, ctx)
	}

	protected def void doProcessChildren(CompositeGeneratorNode node, Context ctx) {
		for (child : node.children) {
			doProcess(child, ctx)
		}
	}
	protected def dispatch boolean hasContent(CompositeGeneratorNode node, Context ctx) {
		node.children.exists[hasContent(ctx)]
	}
	
	protected def dispatch boolean hasContent(NewLineNode node, Context ctx) {
		!(node.ifNotEmpty && ctx.currentLineContent.length == 0)
	}

	protected def dispatch boolean hasContent(TextNode node, Context ctx) {
		!node.text.nullOrEmpty
	}

	protected static def boolean hasNonWhitespace(CharSequence s) {
		for (var i = 0; i < s.length; i++) {
			if (!Character.isWhitespace(s.charAt(i)))
				return true
		}
		return false
	}
	
	protected static def boolean isNullOrEmpty(CharSequence s) {
		s === null || s.length == 0
	}
	
	/**
	 * Used to avoid multi-pass processing, when constructing a trace region tree.
	 * 
	 * @author Sven Efftinge - Initial contribution and API
	 */
	static class CompletableTraceRegion extends AbstractStatefulTraceRegion {

		static class CompletableTextRegion implements ITextRegionWithLineInformation {
			ITextRegionWithLineInformation delegate

			@Delegate def ITextRegionWithLineInformation getDelegate() {
				if (delegate === null) {
					throw new IllegalStateException("region not completed")
				}
				return delegate
			}
		}

		CompletableTextRegion region

		new(boolean useForDebugging, ILocationData associatedLocation, AbstractTraceRegion parent) {
			this(new CompletableTextRegion(), useForDebugging, associatedLocation, parent)
		}

		protected new(CompletableTextRegion region, boolean useForDebugging, ILocationData associatedLocation,
			AbstractTraceRegion parent) {
			super(region, useForDebugging, associatedLocation, parent)
			this.region = region
		}

		def void complete(int offset, int length, int startLine, int endLine) {
			this.region.delegate = new TextRegionWithLineInformation(offset, length, startLine, endLine)
		}

		override protected isConsistentWithParent() {
			return true
		}

	}
}
