/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace.node;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.node.CompositeNode;
import org.eclipse.xtext.generator.trace.node.IGeneratorNode;
import org.eclipse.xtext.generator.trace.node.IndentNode;
import org.eclipse.xtext.generator.trace.node.NewLineNode;
import org.eclipse.xtext.generator.trace.node.TemplateNode;
import org.eclipse.xtext.generator.trace.node.TextNode;
import org.eclipse.xtext.generator.trace.node.TraceNode;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class GeneratorNodeExtensions {
  public CompositeNode startTrace(final ILocationData data) {
    final TraceNode result = new TraceNode(data);
    return result;
  }
  
  public CompositeNode trace(final CompositeNode parent, final ILocationData data) {
    final TraceNode result = new TraceNode(data);
    List<IGeneratorNode> _children = parent.getChildren();
    _children.add(result);
    return result;
  }
  
  public CompositeNode indent(final CompositeNode parent) {
    final IndentNode result = new IndentNode();
    List<IGeneratorNode> _children = parent.getChildren();
    _children.add(result);
    return result;
  }
  
  public CompositeNode appendNewLine(final CompositeNode parent) {
    List<IGeneratorNode> _children = parent.getChildren();
    NewLineNode _newLineNode = new NewLineNode();
    _children.add(_newLineNode);
    return parent;
  }
  
  public CompositeNode append(final CompositeNode parent, final String text) {
    List<IGeneratorNode> _children = parent.getChildren();
    TextNode _textNode = new TextNode(text);
    _children.add(_textNode);
    return parent;
  }
  
  public CompositeNode append(final CompositeNode parent, final CharSequence text) {
    List<IGeneratorNode> _children = parent.getChildren();
    TextNode _textNode = new TextNode(text);
    _children.add(_textNode);
    return parent;
  }
  
  private final String indentationString;
  
  public IGeneratorNode appendTemplate(final CompositeNode parent, final StringConcatenationClient contents) {
    final TemplateNode proc = new TemplateNode(this.indentationString, contents, this);
    List<IGeneratorNode> _children = parent.getChildren();
    _children.add(proc);
    return parent;
  }
  
  public GeneratorNodeExtensions(final String indentationString) {
    super();
    this.indentationString = indentationString;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.indentationString== null) ? 0 : this.indentationString.hashCode());
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
    GeneratorNodeExtensions other = (GeneratorNodeExtensions) obj;
    if (this.indentationString == null) {
      if (other.indentationString != null)
        return false;
    } else if (!this.indentationString.equals(other.indentationString))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("indentationString", this.indentationString);
    return b.toString();
  }
  
  @Pure
  public String getIndentationString() {
    return this.indentationString;
  }
}
