/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace.node;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtext.generator.trace.AbstractStatefulTraceRegion;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.TraceNotFoundException;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.generator.trace.node.IGeneratorNode;
import org.eclipse.xtext.generator.trace.node.IndentNode;
import org.eclipse.xtext.generator.trace.node.NewLineNode;
import org.eclipse.xtext.generator.trace.node.TextNode;
import org.eclipse.xtext.generator.trace.node.TraceNode;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class GeneratorNodeProcessor {
  @Data
  public static class Result implements CharSequence, ITraceRegionProvider {
    @Delegate
    private final CharSequence contents;
    
    private final AbstractTraceRegion traceRegion;
    
    @Override
    public AbstractTraceRegion getTraceRegion() throws TraceNotFoundException {
      return this.traceRegion;
    }
    
    @Override
    public String toString() {
      return this.contents.toString();
    }
    
    public Result(final CharSequence contents, final AbstractTraceRegion traceRegion) {
      super();
      this.contents = contents;
      this.traceRegion = traceRegion;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.contents== null) ? 0 : this.contents.hashCode());
      result = prime * result + ((this.traceRegion== null) ? 0 : this.traceRegion.hashCode());
      return result;
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      GeneratorNodeProcessor.Result other = (GeneratorNodeProcessor.Result) obj;
      if (this.contents == null) {
        if (other.contents != null)
          return false;
      } else if (!this.contents.equals(other.contents))
        return false;
      if (this.traceRegion == null) {
        if (other.traceRegion != null)
          return false;
      } else if (!this.traceRegion.equals(other.traceRegion))
        return false;
      return true;
    }
    
    @Pure
    public CharSequence getContents() {
      return this.contents;
    }
    
    public char charAt(final int index) {
      return this.contents.charAt(index);
    }
    
    public IntStream chars() {
      return this.contents.chars();
    }
    
    public IntStream codePoints() {
      return this.contents.codePoints();
    }
    
    public int length() {
      return this.contents.length();
    }
    
    public CharSequence subSequence(final int start, final int end) {
      return this.contents.subSequence(start, end);
    }
  }
  
  @Accessors
  protected static class Context {
    private List<StringBuilder> lines;
    
    private Deque<String> currentIndents;
    
    private boolean pendingIndent;
    
    private AbstractTraceRegion currentRegion = null;
    
    public StringBuilder currentLine() {
      return this.lines.get(this.currentLineNumber());
    }
    
    public int contentLength() {
      final Function2<Integer, StringBuilder, Integer> _function = (Integer $0, StringBuilder $1) -> {
        int _length = $1.length();
        return Integer.valueOf((($0).intValue() + _length));
      };
      final Integer contentLength = IterableExtensions.<StringBuilder, Integer>fold(this.lines, Integer.valueOf(0), _function);
      if (this.pendingIndent) {
        final Function2<Integer, String, Integer> _function_1 = (Integer $0, String $1) -> {
          int _length = $1.length();
          return Integer.valueOf((($0).intValue() + _length));
        };
        Integer _fold = IterableExtensions.<String, Integer>fold(this.currentIndents, Integer.valueOf(0), _function_1);
        return ((contentLength).intValue() + (_fold).intValue());
      } else {
        return (contentLength).intValue();
      }
    }
    
    public int currentLineNumber() {
      int _size = this.lines.size();
      return (_size - 1);
    }
    
    @Pure
    public List<StringBuilder> getLines() {
      return this.lines;
    }
    
    public void setLines(final List<StringBuilder> lines) {
      this.lines = lines;
    }
    
    @Pure
    public Deque<String> getCurrentIndents() {
      return this.currentIndents;
    }
    
    public void setCurrentIndents(final Deque<String> currentIndents) {
      this.currentIndents = currentIndents;
    }
    
    @Pure
    public boolean isPendingIndent() {
      return this.pendingIndent;
    }
    
    public void setPendingIndent(final boolean pendingIndent) {
      this.pendingIndent = pendingIndent;
    }
    
    @Pure
    public AbstractTraceRegion getCurrentRegion() {
      return this.currentRegion;
    }
    
    public void setCurrentRegion(final AbstractTraceRegion currentRegion) {
      this.currentRegion = currentRegion;
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
        if ((this.delegate == null)) {
          throw new IllegalStateException("region not completed");
        }
        return this.delegate;
      }
      
      public int getEndLineNumber() {
        return this.getDelegate().getEndLineNumber();
      }
      
      public int getLineNumber() {
        return this.getDelegate().getLineNumber();
      }
      
      public ITextRegionWithLineInformation merge(final ITextRegionWithLineInformation other) {
        return this.getDelegate().merge(other);
      }
      
      public boolean contains(final ITextRegion other) {
        return this.getDelegate().contains(other);
      }
      
      public boolean contains(final int offset) {
        return this.getDelegate().contains(offset);
      }
      
      public int getLength() {
        return this.getDelegate().getLength();
      }
      
      public int getOffset() {
        return this.getDelegate().getOffset();
      }
      
      public ITextRegion merge(final ITextRegion region) {
        return this.getDelegate().merge(region);
      }
    }
    
    private GeneratorNodeProcessor.CompletableTraceRegion.CompletableTextRegion region;
    
    public CompletableTraceRegion(final boolean useForDebugging, final ILocationData associatedLocation, final AbstractTraceRegion parent) {
      this(new GeneratorNodeProcessor.CompletableTraceRegion.CompletableTextRegion(), useForDebugging, associatedLocation, parent);
    }
    
    protected CompletableTraceRegion(final GeneratorNodeProcessor.CompletableTraceRegion.CompletableTextRegion region, final boolean useForDebugging, final ILocationData associatedLocation, final AbstractTraceRegion parent) {
      super(region, useForDebugging, associatedLocation, parent);
      this.region = region;
    }
    
    public void complete(final int offset, final int length, final int startLine, final int endLine) {
      TextRegionWithLineInformation _textRegionWithLineInformation = new TextRegionWithLineInformation(offset, length, startLine, endLine);
      this.region.delegate = _textRegionWithLineInformation;
    }
    
    @Override
    protected boolean isConsistentWithParent() {
      return true;
    }
  }
  
  public GeneratorNodeProcessor.Result process(final IGeneratorNode root) {
    GeneratorNodeProcessor.Context _context = new GeneratorNodeProcessor.Context();
    final Procedure1<GeneratorNodeProcessor.Context> _function = (GeneratorNodeProcessor.Context it) -> {
      StringBuilder _stringBuilder = new StringBuilder();
      it.lines = CollectionLiterals.<StringBuilder>newArrayList(_stringBuilder);
      ArrayDeque<String> _arrayDeque = new ArrayDeque<String>();
      it.currentIndents = _arrayDeque;
      it.pendingIndent = true;
    };
    final GeneratorNodeProcessor.Context ctx = ObjectExtensions.<GeneratorNodeProcessor.Context>operator_doubleArrow(_context, _function);
    this.doProcess(root, ctx);
    String _join = IterableExtensions.join(ctx.lines);
    return new GeneratorNodeProcessor.Result(_join, ctx.currentRegion);
  }
  
  /**
   * Indent nodes apply indentation between newline and content of its children.
   */
  protected void _doProcess(final IndentNode node, final GeneratorNodeProcessor.Context ctx) {
    boolean _isEmpty = node.getChildren().isEmpty();
    if (_isEmpty) {
      return;
    }
    ctx.pendingIndent = false;
    ctx.currentLine().append(node.getIndentationString());
    try {
      ctx.currentIndents.push(node.getIndentationString());
      this.doProcessChildren(node, ctx);
    } finally {
      ctx.currentIndents.pop();
    }
  }
  
  protected void _doProcess(final NewLineNode node, final GeneratorNodeProcessor.Context ctx) {
    final String trimmedLine = ctx.currentLine().toString().trim();
    if ((node.isIfNotEmpty() && trimmedLine.isEmpty())) {
      int _currentLineNumber = ctx.currentLineNumber();
      StringBuilder _stringBuilder = new StringBuilder();
      ctx.lines.set(_currentLineNumber, _stringBuilder);
      return;
    }
    ctx.currentLine().append(node.getLineDelimiter());
    StringBuilder _stringBuilder_1 = new StringBuilder();
    ctx.lines.add(_stringBuilder_1);
    ctx.pendingIndent = true;
  }
  
  protected void _doProcess(final TextNode node, final GeneratorNodeProcessor.Context ctx) {
    final String txt = node.getText().toString();
    boolean _isEmpty = txt.isEmpty();
    if (_isEmpty) {
      return;
    }
    if (ctx.pendingIndent) {
      final StringBuilder indentString = new StringBuilder();
      for (final String indentationString : ctx.currentIndents) {
        indentString.append(indentationString);
      }
      ctx.currentLine().insert(0, indentString);
      ctx.pendingIndent = false;
    }
    ctx.currentLine().append(node.getText());
  }
  
  protected void _doProcess(final CompositeGeneratorNode node, final GeneratorNodeProcessor.Context ctx) {
    this.doProcessChildren(node, ctx);
  }
  
  protected void _doProcess(final TraceNode node, final GeneratorNodeProcessor.Context ctx) {
    final AbstractTraceRegion beforeRegion = ctx.currentRegion;
    ILocationData _sourceLocation = node.getSourceLocation();
    final GeneratorNodeProcessor.CompletableTraceRegion newRegion = new GeneratorNodeProcessor.CompletableTraceRegion(false, _sourceLocation, beforeRegion);
    final int offset = ctx.contentLength();
    final int startLineNumber = ctx.currentLineNumber();
    try {
      ctx.currentRegion = newRegion;
      this.doProcessChildren(node, ctx);
    } finally {
      if ((beforeRegion != null)) {
        ctx.currentRegion = beforeRegion;
      }
      int _contentLength = ctx.contentLength();
      int _minus = (_contentLength - offset);
      newRegion.complete(offset, _minus, startLineNumber, ctx.currentLineNumber());
    }
  }
  
  protected void doProcessChildren(final CompositeGeneratorNode node, final GeneratorNodeProcessor.Context ctx) {
    List<IGeneratorNode> _children = node.getChildren();
    for (final IGeneratorNode child : _children) {
      this.doProcess(child, ctx);
    }
  }
  
  protected void doProcess(final IGeneratorNode node, final GeneratorNodeProcessor.Context ctx) {
    if (node instanceof IndentNode) {
      _doProcess((IndentNode)node, ctx);
      return;
    } else if (node instanceof TraceNode) {
      _doProcess((TraceNode)node, ctx);
      return;
    } else if (node instanceof CompositeGeneratorNode) {
      _doProcess((CompositeGeneratorNode)node, ctx);
      return;
    } else if (node instanceof NewLineNode) {
      _doProcess((NewLineNode)node, ctx);
      return;
    } else if (node instanceof TextNode) {
      _doProcess((TextNode)node, ctx);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(node, ctx).toString());
    }
  }
}
