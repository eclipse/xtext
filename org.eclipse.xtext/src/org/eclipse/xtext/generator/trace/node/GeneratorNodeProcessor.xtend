/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import java.util.ArrayDeque
import java.util.Deque
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
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
	
	@Accessors protected static class Context {
		List<StringBuilder> lines
		Deque<IndentNode> currentIndents
		boolean pendingIndent
		AbstractTraceRegion currentRegion = null
		
		def StringBuilder currentLine() {
			return lines.get(currentLineNumber)
		}
		
		def int contentLength() {
			val contentLength = lines.fold(0) [ $0 + $1.length ]
			if (pendingIndent) {
				return contentLength + currentIndents.fold(0) [ $0 + $1.indentationString.length ] 
			} else {
				return contentLength
			}
		}
		
		def int currentLineNumber() {
			return lines.size - 1	
		}
	}
	
	def Result process(IGeneratorNode root) {
		val ctx = new Context => [
			lines = newArrayList(new StringBuilder)
			currentIndents = new ArrayDeque
			pendingIndent = true
		]
		doProcess(root, ctx)
		return new Result(ctx.lines.join, ctx.currentRegion)
	}

	/**
	 * An indent node prepends indentation to each line of its children.
	 */
	protected def dispatch void doProcess(IndentNode node, Context ctx) {
		if (node._hasContent(ctx)) {
			if (node.indentImmediately && !ctx.pendingIndent) {
				ctx.currentLine.append(node.indentationString)
			}
			try {
				ctx.currentIndents.push(node)
				doProcessChildren(node, ctx)
			} finally {
				ctx.currentIndents.pop
			}
		}
	}
	
	protected def dispatch void doProcess(NewLineNode node, Context ctx) {
		if (node.ifNotEmpty && !ctx.currentLine.hasNonWhitespace) {
			ctx.lines.set(ctx.currentLineNumber, new StringBuilder)
		} else {
			if (ctx.pendingIndent)
				handlePendingIndent(ctx, true)
			ctx.currentLine.append(node.lineDelimiter)
			ctx.lines.add(new StringBuilder)
		}
		ctx.pendingIndent = true
	}

	protected def dispatch void doProcess(TextNode node, Context ctx) {
		if (node._hasContent(ctx)) {
			if (ctx.pendingIndent)
				handlePendingIndent(ctx, false)
			ctx.currentLine.append(node.text)
		}
	}
	
	protected def void handlePendingIndent(Context ctx, boolean endOfLine) {
		val indentString = new StringBuilder
		for (indentNode : ctx.currentIndents) {
			if (indentNode.indentEmptyLines || !endOfLine)
				indentString.append(indentNode.indentationString)
		}
		if (indentString.length > 0) {
			ctx.currentLine.insert(0, indentString)
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
		!(node.ifNotEmpty && ctx.currentLine.length == 0)
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
