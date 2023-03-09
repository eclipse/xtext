/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace.node;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtext.generator.trace.AbstractStatefulTraceRegion;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.TraceNotFoundException;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Dennis Huebner - New GeneratorNodeProcessor.Context implementation
 */
public class GeneratorNodeProcessor {
	public static class Result implements CharSequence, ITraceRegionProvider {
		private final CharSequence contentsDelegate;

		private final AbstractTraceRegion traceRegion;

		@Override
		public AbstractTraceRegion getTraceRegion() throws TraceNotFoundException {
			if (traceRegion == null) {
				throw new TraceNotFoundException();
			}
			return traceRegion;
		}

		@Override
		public String toString() {
			return contentsDelegate.toString();
		}

		public Result(CharSequence contents, AbstractTraceRegion traceRegion) {
			this.contentsDelegate = contents;
			this.traceRegion = traceRegion;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((contentsDelegate == null) ? 0 : contentsDelegate.hashCode());
			result = prime * result + ((traceRegion == null) ? 0 : traceRegion.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Result other = (Result) obj;
			if (contentsDelegate == null) {
				if (other.contentsDelegate != null)
					return false;
			} else if (!contentsDelegate.equals(other.contentsDelegate))
				return false;
			if (traceRegion == null) {
				if (other.traceRegion != null)
					return false;
			} else if (!traceRegion.equals(other.traceRegion))
				return false;
			return true;
		}

		public CharSequence getContents() {
			return contentsDelegate;
		}

		public char charAt(int index) {
			return contentsDelegate.charAt(index);
		}

		public IntStream chars() {
			return contentsDelegate.chars();
		}

		public IntStream codePoints() {
			return contentsDelegate.codePoints();
		}

		public int length() {
			return contentsDelegate.length();
		}

		public CharSequence subSequence(int start, int end) {
			return contentsDelegate.subSequence(start, end);
		}
	}

	protected static class Context {
		private List<StringBuilder> lines = Lists.newArrayList(new StringBuilder());

		private Deque<IndentNode> currentIndents = new ArrayDeque<IndentNode>();

		private boolean pendingIndent = true;

		private AbstractTraceRegion currentRegion = null;

		private int contentLength = 0;

		private int indentLength = 0;

		public String currentLineContent() {
			return lines.get(currentLineNumber()).toString();
		}

		public int contentLength() {
			if (isPendingIndent()) {
				return (contentLength + indentLength);
			} else {
				return contentLength;
			}
		}

		public int currentLineNumber() {
			return lines.size() - 1;
		}

		public String getContent() {
			return Joiner.on("").join(lines);
		}

		public AbstractTraceRegion getCurrentRegion() {
			return currentRegion;
		}

		public void increaseIndent(IndentNode node) {
			currentIndents.push(node);
			recalculateIndentLength();
		}

		public void decreaseIndents() {
			currentIndents.pop();
			recalculateIndentLength();
		}

		protected int recalculateIndentLength() {
			return indentLength = IterableExtensions.fold(getCurrentIndents(), 0,
					($0, $1) -> $0.intValue() + $1.getIndentationString().length());
		}

		public void appendToCurrentLine(CharSequence chars) {
			lines.get(currentLineNumber()).append(chars);
			contentLength = contentLength + chars.length();
		}

		public boolean isPendingIndent() {
			return pendingIndent;
		}

		public void addNewLine() {
			lines.add(new StringBuilder());
		}

		public void setPendingIndent(boolean pending) {
			this.pendingIndent = pending;
		}

		/**
		 * Replace the current line with new StringBuilder
		 */
		public void resetCurrentLine() {
			StringBuilder lineContent = lines.get(currentLineNumber());
			if (!isNullOrEmpty(lineContent)) {
				contentLength = contentLength - lineContent.length();
			}
			lines.set(currentLineNumber(), new StringBuilder());
		}

		public void insertIntoCurrentLine(int i, StringBuilder builder) {
			lines.get(currentLineNumber()).insert(i, builder);
			contentLength = contentLength + builder.length();
		}

		/**
		 * @return a copy of current indent nodes
		 */
		public Deque<IndentNode> getCurrentIndents() {
			return new ArrayDeque<IndentNode>(currentIndents);
		}

		public AbstractTraceRegion setCurrentRegion(AbstractTraceRegion region) {
			return currentRegion = region;
		}
	}

	/**
	 * Used to avoid multi-pass processing, when constructing a trace region tree.
	 * 
	 * @author Sven Efftinge - Initial contribution and API
	 */
	public static class CompletableTraceRegion extends AbstractStatefulTraceRegion {
		public static class CompletableTextRegion implements ITextRegionWithLineInformation {
			private ITextRegionWithLineInformation delegate;

			@Delegate
			public ITextRegionWithLineInformation getDelegate() {
				if (delegate == null) {
					throw new IllegalStateException("region not completed");
				}
				return delegate;
			}

			public boolean contains(ITextRegion other) {
				return getDelegate().contains(other);
			}

			public boolean contains(int offset) {
				return getDelegate().contains(offset);
			}

			public int getEndLineNumber() {
				return getDelegate().getEndLineNumber();
			}

			public int getLength() {
				return getDelegate().getLength();
			}

			public int getLineNumber() {
				return getDelegate().getLineNumber();
			}

			public int getOffset() {
				return getDelegate().getOffset();
			}

			public ITextRegion merge(ITextRegion region) {
				return getDelegate().merge(region);
			}

			public ITextRegionWithLineInformation merge(ITextRegionWithLineInformation other) {
				return getDelegate().merge(other);
			}
		}

		private CompletableTraceRegion.CompletableTextRegion region;

		public CompletableTraceRegion(boolean useForDebugging, ILocationData associatedLocation,
				AbstractTraceRegion parent) {
			this(new CompletableTraceRegion.CompletableTextRegion(), useForDebugging, associatedLocation, parent);
		}

		protected CompletableTraceRegion(CompletableTraceRegion.CompletableTextRegion region, boolean useForDebugging,
				ILocationData associatedLocation, AbstractTraceRegion parent) {
			super(region, useForDebugging, associatedLocation, parent);
			this.region = region;
		}

		public void complete(int offset, int length, int startLine, int endLine) {
			region.delegate = new TextRegionWithLineInformation(offset,
					length, startLine, endLine);
		}

		@Override
		protected boolean isConsistentWithParent() {
			return true;
		}
	}

	public Result process(IGeneratorNode root) {
		Context ctx = new Context();
		doProcess(root, ctx);
		return new Result(ctx.getContent(), ctx.getCurrentRegion());
	}

	/**
	 * An indent node prepends indentation to each line of its children.
	 */
	protected void _doProcess(IndentNode node, Context ctx) {
		if (_hasContent(node, ctx)) {
			if (node.isIndentImmediately() && !ctx.isPendingIndent()) {
				ctx.appendToCurrentLine(node.getIndentationString());
			}
			try {
				ctx.increaseIndent(node);
				doProcessChildren(node, ctx);
			} finally {
				ctx.decreaseIndents();
			}
		}
	}

	protected void _doProcess(NewLineNode node, Context ctx) {
		if (node.isIfNotEmpty() && !hasNonWhitespace(ctx.currentLineContent())) {
			ctx.resetCurrentLine();
		} else {
			if (ctx.isPendingIndent()) {
				handlePendingIndent(ctx, true);
			}
			ctx.appendToCurrentLine(node.getLineDelimiter());
			ctx.addNewLine();
		}
		ctx.setPendingIndent(true);
	}

	protected void _doProcess(TextNode node, Context ctx) {
		if (_hasContent(node, ctx)) {
			if (ctx.isPendingIndent()) {
				handlePendingIndent(ctx, false);
			}
			ctx.appendToCurrentLine(node.getText());
		}
	}

	protected void handlePendingIndent(Context ctx, boolean endOfLine) {
		StringBuilder indentString = new StringBuilder();
		for (IndentNode indentNode : ctx.getCurrentIndents()) {
			if (indentNode.isIndentEmptyLines() || !endOfLine) {
				indentString.append(indentNode.getIndentationString());
			}
		}
		if (indentString.length() > 0) {
			ctx.insertIntoCurrentLine(0, indentString);
		}
		ctx.setPendingIndent(false);
	}

	protected void _doProcess(TraceNode node, Context ctx) {
		if (_hasContent(node, ctx)) {
			AbstractTraceRegion beforeRegion = ctx.getCurrentRegion();
			CompletableTraceRegion newRegion = new CompletableTraceRegion(node.isUseForDebugging(), node.getSourceLocation(),
					beforeRegion);
			int offset = ctx.contentLength();
			int startLineNumber = ctx.currentLineNumber();
			try {
				ctx.setCurrentRegion(newRegion);
				doProcessChildren(node, ctx);
			} finally {
				if (beforeRegion != null) {
					ctx.setCurrentRegion(beforeRegion);
				}
				newRegion.complete(offset, ctx.contentLength() - offset, startLineNumber, ctx.currentLineNumber());
			}
		}
	}

	protected void _doProcess(CompositeGeneratorNode node, Context ctx) {
		doProcessChildren(node, ctx);
	}

	protected void doProcessChildren(CompositeGeneratorNode node, Context ctx) {
		for (IGeneratorNode child : node.getChildren()) {
			doProcess(child, ctx);
		}
	}

	protected boolean _hasContent(CompositeGeneratorNode node, Context ctx) {
		return node.getChildren().stream().anyMatch((IGeneratorNode it) -> hasContent(it, ctx));
	}

	protected boolean _hasContent(NewLineNode node, Context ctx) {
		return !(node.isIfNotEmpty() && ctx.currentLineContent().length() == 0);
	}

	protected boolean _hasContent(TextNode node, Context ctx) {
		return !isNullOrEmpty(node.getText());
	}

	protected static boolean hasNonWhitespace(CharSequence s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isWhitespace(s.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	protected static boolean isNullOrEmpty(CharSequence s) {
		return s == null || s.length() == 0;
	}

	protected void doProcess(IGeneratorNode node, Context ctx) {
		if (node instanceof IndentNode) {
			_doProcess((IndentNode) node, ctx);
			return;
		} else if (node instanceof TraceNode) {
			_doProcess((TraceNode) node, ctx);
			return;
		} else if (node instanceof CompositeGeneratorNode) {
			_doProcess((CompositeGeneratorNode) node, ctx);
			return;
		} else if (node instanceof NewLineNode) {
			_doProcess((NewLineNode) node, ctx);
			return;
		} else if (node instanceof TextNode) {
			_doProcess((TextNode) node, ctx);
			return;
		} else {
			throw new IllegalArgumentException(
					"Unhandled parameter types: " + Arrays.<Object>asList(node, ctx).toString());
		}
	}

	protected boolean hasContent(IGeneratorNode node, Context ctx) {
		if (node instanceof CompositeGeneratorNode) {
			return _hasContent((CompositeGeneratorNode) node, ctx);
		} else if (node instanceof NewLineNode) {
			return _hasContent((NewLineNode) node, ctx);
		} else if (node instanceof TextNode) {
			return _hasContent((TextNode) node, ctx);
		} else {
			throw new IllegalArgumentException(
					"Unhandled parameter types: " + Arrays.<Object>asList(node, ctx).toString());
		}
	}
}
