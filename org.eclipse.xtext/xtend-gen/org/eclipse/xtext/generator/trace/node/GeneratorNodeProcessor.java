/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace.node;

import java.util.Arrays;
import java.util.List;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.generator.trace.AbstractStatefulTraceRegion;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.generator.trace.node.IGeneratorNode;
import org.eclipse.xtext.generator.trace.node.IndentNode;
import org.eclipse.xtext.generator.trace.node.NewLineNode;
import org.eclipse.xtext.generator.trace.node.TextNode;
import org.eclipse.xtext.generator.trace.node.TraceNode;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class GeneratorNodeProcessor {
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
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final StringBuilder contents;
  
  private final String indentationString;
  
  private final String newLineString;
  
  private int currentIndentLevel = 0;
  
  private int currentLine = 0;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private AbstractTraceRegion currentRegion = null;
  
  protected void _process(final IGeneratorNode node) {
    throw new IllegalArgumentException(("No processing for " + node));
  }
  
  protected void _process(final IndentNode node) {
    try {
      this.currentIndentLevel++;
      this.contents.append(this.indentationString);
      this.processChildren(node);
    } finally {
      this.currentIndentLevel--;
    }
  }
  
  protected void _process(final NewLineNode node) {
    this.currentLine++;
    this.contents.append(this.newLineString);
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, this.currentIndentLevel, true);
    for (final Integer i : _doubleDotLessThan) {
      this.contents.append(this.indentationString);
    }
  }
  
  protected void _process(final TextNode node) {
    this.contents.append(node.getText());
  }
  
  protected void _process(final CompositeGeneratorNode node) {
    this.processChildren(node);
  }
  
  protected void _process(final TraceNode node) {
    final AbstractTraceRegion beforeRegion = this.currentRegion;
    ILocationData _sourceLocation = node.getSourceLocation();
    final GeneratorNodeProcessor.CompletableTraceRegion newRegion = new GeneratorNodeProcessor.CompletableTraceRegion(false, _sourceLocation, beforeRegion);
    final int offset = this.contents.length();
    final int startLine = this.currentLine;
    try {
      this.currentRegion = newRegion;
      this.processChildren(node);
    } finally {
      if ((beforeRegion != null)) {
        this.currentRegion = beforeRegion;
      }
      int _length = this.contents.length();
      int _minus = (_length - offset);
      newRegion.complete(offset, _minus, startLine, this.currentLine);
    }
  }
  
  protected void processChildren(final CompositeGeneratorNode node) {
    List<IGeneratorNode> _children = node.getChildren();
    for (final IGeneratorNode child : _children) {
      this.process(child);
    }
  }
  
  public void process(final IGeneratorNode node) {
    if (node instanceof IndentNode) {
      _process((IndentNode)node);
      return;
    } else if (node instanceof TraceNode) {
      _process((TraceNode)node);
      return;
    } else if (node instanceof CompositeGeneratorNode) {
      _process((CompositeGeneratorNode)node);
      return;
    } else if (node instanceof NewLineNode) {
      _process((NewLineNode)node);
      return;
    } else if (node instanceof TextNode) {
      _process((TextNode)node);
      return;
    } else if (node != null) {
      _process(node);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(node).toString());
    }
  }
  
  public GeneratorNodeProcessor(final StringBuilder contents, final String indentationString, final String newLineString) {
    super();
    this.contents = contents;
    this.indentationString = indentationString;
    this.newLineString = newLineString;
  }
  
  @Pure
  public StringBuilder getContents() {
    return this.contents;
  }
  
  @Pure
  public AbstractTraceRegion getCurrentRegion() {
    return this.currentRegion;
  }
}
