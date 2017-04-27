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
			return traceRegion
		}
		
		override toString() {
			contents.toString()
		}
	}
	
	@Accessors protected static class Context {
		List<StringBuilder> lines
		Deque<String> currentIndents
		boolean pendingIndent
		AbstractTraceRegion currentRegion = null
		
		def StringBuilder currentLine() {
			return lines.get(currentLineNumber);
		}
		
		def int contentLength() {
			val contentLength = lines.fold(0) [ $0 + $1.length ]
			if (pendingIndent) {
				return contentLength + currentIndents.fold(0) [ $0 + $1.length ] 
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
			lines = newArrayList(new StringBuilder())
			currentIndents = new ArrayDeque<String>()
			pendingIndent = true
		]
		doProcess(root, ctx)
		return new Result(ctx.lines.join, ctx.currentRegion);
	}

	/**
	 * Indent nodes apply indentation between newline and content of its children.
	 */
	protected def dispatch void doProcess(IndentNode node, Context ctx) {
		// do nothing if the indent node is empty
		if (node.children.empty) {
			return;
		}
		ctx.pendingIndent = false;
		ctx.currentLine.append(node.indentationString)
		try {
			ctx.currentIndents.push(node.indentationString);
			doProcessChildren(node, ctx);
		} finally {
			ctx.currentIndents.pop
		}
	}
	
	protected def dispatch void doProcess(NewLineNode node, Context ctx) {
		val trimmedLine = ctx.currentLine.toString.trim
		if (node.ifNotEmpty && trimmedLine.empty) {
			ctx.lines.set(ctx.currentLineNumber, new StringBuilder())
			return
		}
		ctx.currentLine.append(node.lineDelimiter)
		ctx.lines.add(new StringBuilder)
		ctx.pendingIndent = true
	}

	protected def dispatch void doProcess(TextNode node, Context ctx) {
		val txt = node.text.toString
		if (txt.empty) {
			return;
		}
		if (ctx.pendingIndent) {
			val indentString = new StringBuilder()
			for (indentationString : ctx.currentIndents) {
				indentString.append(indentationString)
			}
			ctx.currentLine.insert(0, indentString)
			ctx.pendingIndent = false
		}
		ctx.currentLine.append(node.text)
	}
	
	protected def dispatch void doProcess(CompositeGeneratorNode node, Context ctx) {
		doProcessChildren(node, ctx)
	}

	protected def dispatch void doProcess(TraceNode node, Context ctx) {
		val beforeRegion = ctx.currentRegion
		val newRegion = new CompletableTraceRegion(false, node.sourceLocation, beforeRegion)
		val offset = ctx.contentLength
		val startLineNumber = ctx.currentLineNumber;
		try {
			ctx.currentRegion = newRegion
			doProcessChildren(node, ctx);
		} finally {
			if (beforeRegion !== null)
				ctx.currentRegion = beforeRegion
			newRegion.complete(offset, ctx.contentLength - offset, startLineNumber, ctx.currentLineNumber)
		}
	}

	protected def void doProcessChildren(CompositeGeneratorNode node, Context ctx) {
		for (child : node.children) {
			doProcess(child, ctx)
		}
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
