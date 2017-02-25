/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.generator.trace.AbstractStatefulTraceRegion
import org.eclipse.xtext.generator.trace.AbstractTraceRegion
import org.eclipse.xtext.generator.trace.ILocationData
import org.eclipse.xtext.util.ITextRegionWithLineInformation
import org.eclipse.xtext.util.TextRegionWithLineInformation

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@FinalFieldsConstructor class GeneratorNodeProcessor {

	@Accessors(PUBLIC_GETTER) val StringBuilder contents
	val String indentationString
	val String newLineString

	int currentIndentLevel = 0
	int currentLine = 0
	@Accessors(PUBLIC_GETTER) AbstractTraceRegion currentRegion = null

	def dispatch void process(IGeneratorNode node) {
		throw new IllegalArgumentException("No processing for " + node)
	}

	def dispatch void process(IndentNode node) {
		try {
			this.currentIndentLevel++
			this.contents.append(indentationString)
			processChildren(node);
		} finally {
			this.currentIndentLevel--
		}
	}

	def dispatch void process(NewLineNode node) {
		currentLine++
		contents.append(newLineString)
		for (i : 0 ..< currentIndentLevel) {
			contents.append(indentationString)
		}
	}

	def dispatch void process(TextNode node) {
		contents.append(node.text)
	}
	
	def dispatch void process(CompositeNode node) {
		processChildren(node)
	}

	def dispatch void process(TraceNode node) {
		val beforeRegion = currentRegion
		val newRegion = new CompletableTraceRegion(false, node.sourceLocation, beforeRegion)
		val offset = contents.length
		val startLine = currentLine;
		try {
			currentRegion = newRegion
			processChildren(node);
		} finally {
			if (beforeRegion !== null)
				currentRegion = beforeRegion
			newRegion.complete(offset, contents.length - offset, startLine, currentLine)
		}
	}

	protected def void processChildren(CompositeNode node) {
		for (child : node.children) {
			process(child)
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
