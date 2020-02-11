/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
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
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Dennis Huebner - New GeneratorNodeProcessor.Context implementation
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
      if ((this.traceRegion == null)) {
        throw new TraceNotFoundException();
      }
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
      return prime * result + ((this.traceRegion== null) ? 0 : this.traceRegion.hashCode());
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
  
  protected static class Context {
    private List<StringBuilder> _lines = CollectionLiterals.<StringBuilder>newArrayList(new StringBuilder());
    
    private Deque<IndentNode> _currentIndents = new ArrayDeque<IndentNode>();
    
    private boolean _pendingIndent = true;
    
    private AbstractTraceRegion _currentRegion = null;
    
    private int _contentLength = 0;
    
    private int _indentLength = 0;
    
    public String currentLineContent() {
      return this._lines.get(this.currentLineNumber()).toString();
    }
    
    public int contentLength() {
      boolean _isPendingIndent = this.isPendingIndent();
      if (_isPendingIndent) {
        return (this._contentLength + this._indentLength);
      } else {
        return this._contentLength;
      }
    }
    
    public int currentLineNumber() {
      int _size = this._lines.size();
      return (_size - 1);
    }
    
    public String getContent() {
      return IterableExtensions.join(this._lines);
    }
    
    public AbstractTraceRegion getCurrentRegion() {
      return this._currentRegion;
    }
    
    public void increaseIndent(final IndentNode node) {
      this._currentIndents.push(node);
      this.recalculateIndentLength();
    }
    
    public void decreaseIndents() {
      this._currentIndents.pop();
      this.recalculateIndentLength();
    }
    
    protected int recalculateIndentLength() {
      final Function2<Integer, IndentNode, Integer> _function = (Integer $0, IndentNode $1) -> {
        int _length = $1.getIndentationString().length();
        return Integer.valueOf((($0).intValue() + _length));
      };
      return this._indentLength = (IterableExtensions.<IndentNode, Integer>fold(this.getCurrentIndents(), Integer.valueOf(0), _function)).intValue();
    }
    
    public void appendToCurrentLine(final CharSequence chars) {
      this._lines.get(this.currentLineNumber()).append(chars);
      int _length = chars.length();
      int _plus = (this._contentLength + _length);
      this._contentLength = _plus;
    }
    
    public boolean isPendingIndent() {
      return this._pendingIndent;
    }
    
    public void addNewLine() {
      StringBuilder _stringBuilder = new StringBuilder();
      this._lines.add(_stringBuilder);
    }
    
    public void setPendingIndent(final boolean pending) {
      this._pendingIndent = pending;
    }
    
    /**
     * Replace the current line with new StringBuilder
     */
    public void resetCurrentLine() {
      final StringBuilder lineContent = this._lines.get(this.currentLineNumber());
      boolean _isNullOrEmpty = GeneratorNodeProcessor.isNullOrEmpty(lineContent);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        int _length = lineContent.length();
        int _minus = (this._contentLength - _length);
        this._contentLength = _minus;
      }
      int _currentLineNumber = this.currentLineNumber();
      StringBuilder _stringBuilder = new StringBuilder();
      this._lines.set(_currentLineNumber, _stringBuilder);
    }
    
    public void insertIntoCurrentLine(final int i, final StringBuilder builder) {
      this._lines.get(this.currentLineNumber()).insert(i, builder);
      int _length = builder.length();
      int _plus = (this._contentLength + _length);
      this._contentLength = _plus;
    }
    
    /**
     * @return a copy of current indent nodes
     */
    public Deque<IndentNode> getCurrentIndents() {
      return new ArrayDeque<IndentNode>(this._currentIndents);
    }
    
    public AbstractTraceRegion setCurrentRegion(final AbstractTraceRegion region) {
      return this._currentRegion = region;
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
      
      public boolean contains(final ITextRegion other) {
        return this.getDelegate().contains(other);
      }
      
      public boolean contains(final int offset) {
        return this.getDelegate().contains(offset);
      }
      
      public int getEndLineNumber() {
        return this.getDelegate().getEndLineNumber();
      }
      
      public int getLength() {
        return this.getDelegate().getLength();
      }
      
      public int getLineNumber() {
        return this.getDelegate().getLineNumber();
      }
      
      public int getOffset() {
        return this.getDelegate().getOffset();
      }
      
      public ITextRegion merge(final ITextRegion region) {
        return this.getDelegate().merge(region);
      }
      
      public ITextRegionWithLineInformation merge(final ITextRegionWithLineInformation other) {
        return this.getDelegate().merge(other);
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
    final GeneratorNodeProcessor.Context ctx = new GeneratorNodeProcessor.Context();
    this.doProcess(root, ctx);
    String _content = ctx.getContent();
    AbstractTraceRegion _currentRegion = ctx.getCurrentRegion();
    return new GeneratorNodeProcessor.Result(_content, _currentRegion);
  }
  
  /**
   * An indent node prepends indentation to each line of its children.
   */
  protected void _doProcess(final IndentNode node, final GeneratorNodeProcessor.Context ctx) {
    boolean __hasContent = this._hasContent(node, ctx);
    if (__hasContent) {
      if ((node.isIndentImmediately() && (!ctx.isPendingIndent()))) {
        ctx.appendToCurrentLine(node.getIndentationString());
      }
      try {
        ctx.increaseIndent(node);
        this.doProcessChildren(node, ctx);
      } finally {
        ctx.decreaseIndents();
      }
    }
  }
  
  protected void _doProcess(final NewLineNode node, final GeneratorNodeProcessor.Context ctx) {
    if ((node.isIfNotEmpty() && (!GeneratorNodeProcessor.hasNonWhitespace(ctx.currentLineContent())))) {
      ctx.resetCurrentLine();
    } else {
      boolean _isPendingIndent = ctx.isPendingIndent();
      if (_isPendingIndent) {
        this.handlePendingIndent(ctx, true);
      }
      ctx.appendToCurrentLine(node.getLineDelimiter());
      ctx.addNewLine();
    }
    ctx.setPendingIndent(true);
  }
  
  protected void _doProcess(final TextNode node, final GeneratorNodeProcessor.Context ctx) {
    boolean __hasContent = this._hasContent(node, ctx);
    if (__hasContent) {
      boolean _isPendingIndent = ctx.isPendingIndent();
      if (_isPendingIndent) {
        this.handlePendingIndent(ctx, false);
      }
      ctx.appendToCurrentLine(node.getText());
    }
  }
  
  protected void handlePendingIndent(final GeneratorNodeProcessor.Context ctx, final boolean endOfLine) {
    final StringBuilder indentString = new StringBuilder();
    Deque<IndentNode> _currentIndents = ctx.getCurrentIndents();
    for (final IndentNode indentNode : _currentIndents) {
      if ((indentNode.isIndentEmptyLines() || (!endOfLine))) {
        indentString.append(indentNode.getIndentationString());
      }
    }
    int _length = indentString.length();
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      ctx.insertIntoCurrentLine(0, indentString);
    }
    ctx.setPendingIndent(false);
  }
  
  protected void _doProcess(final TraceNode node, final GeneratorNodeProcessor.Context ctx) {
    boolean __hasContent = this._hasContent(node, ctx);
    if (__hasContent) {
      final AbstractTraceRegion beforeRegion = ctx.getCurrentRegion();
      boolean _isUseForDebugging = node.isUseForDebugging();
      ILocationData _sourceLocation = node.getSourceLocation();
      final GeneratorNodeProcessor.CompletableTraceRegion newRegion = new GeneratorNodeProcessor.CompletableTraceRegion(_isUseForDebugging, _sourceLocation, beforeRegion);
      final int offset = ctx.contentLength();
      final int startLineNumber = ctx.currentLineNumber();
      try {
        ctx.setCurrentRegion(newRegion);
        this.doProcessChildren(node, ctx);
      } finally {
        if ((beforeRegion != null)) {
          ctx.setCurrentRegion(beforeRegion);
        }
        int _contentLength = ctx.contentLength();
        int _minus = (_contentLength - offset);
        newRegion.complete(offset, _minus, startLineNumber, ctx.currentLineNumber());
      }
    }
  }
  
  protected void _doProcess(final CompositeGeneratorNode node, final GeneratorNodeProcessor.Context ctx) {
    this.doProcessChildren(node, ctx);
  }
  
  protected void doProcessChildren(final CompositeGeneratorNode node, final GeneratorNodeProcessor.Context ctx) {
    List<IGeneratorNode> _children = node.getChildren();
    for (final IGeneratorNode child : _children) {
      this.doProcess(child, ctx);
    }
  }
  
  protected boolean _hasContent(final CompositeGeneratorNode node, final GeneratorNodeProcessor.Context ctx) {
    final Function1<IGeneratorNode, Boolean> _function = (IGeneratorNode it) -> {
      return Boolean.valueOf(this.hasContent(it, ctx));
    };
    return IterableExtensions.<IGeneratorNode>exists(node.getChildren(), _function);
  }
  
  protected boolean _hasContent(final NewLineNode node, final GeneratorNodeProcessor.Context ctx) {
    return (!(node.isIfNotEmpty() && (ctx.currentLineContent().length() == 0)));
  }
  
  protected boolean _hasContent(final TextNode node, final GeneratorNodeProcessor.Context ctx) {
    boolean _isNullOrEmpty = GeneratorNodeProcessor.isNullOrEmpty(node.getText());
    return (!_isNullOrEmpty);
  }
  
  protected static boolean hasNonWhitespace(final CharSequence s) {
    for (int i = 0; (i < s.length()); i++) {
      boolean _isWhitespace = Character.isWhitespace(s.charAt(i));
      boolean _not = (!_isWhitespace);
      if (_not) {
        return true;
      }
    }
    return false;
  }
  
  protected static boolean isNullOrEmpty(final CharSequence s) {
    return ((s == null) || (s.length() == 0));
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
  
  protected boolean hasContent(final IGeneratorNode node, final GeneratorNodeProcessor.Context ctx) {
    if (node instanceof CompositeGeneratorNode) {
      return _hasContent((CompositeGeneratorNode)node, ctx);
    } else if (node instanceof NewLineNode) {
      return _hasContent((NewLineNode)node, ctx);
    } else if (node instanceof TextNode) {
      return _hasContent((TextNode)node, ctx);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(node, ctx).toString());
    }
  }
}
