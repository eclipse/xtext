/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace.node;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.generator.trace.node.IGeneratorNode;
import org.eclipse.xtext.generator.trace.node.IndentNode;
import org.eclipse.xtext.generator.trace.node.NewLineNode;
import org.eclipse.xtext.generator.trace.node.TemplateNode;
import org.eclipse.xtext.generator.trace.node.TextNode;
import org.eclipse.xtext.generator.trace.node.TraceNode;
import org.eclipse.xtext.generator.trace.node.WhiteSpaceConfig;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class GeneratorNodeExtensions {
  @Inject
  private WhiteSpaceConfig wsConfig = new WhiteSpaceConfig();
  
  public CompositeGeneratorNode startTrace(final ILocationData data) {
    final TraceNode result = new TraceNode(data);
    return result;
  }
  
  public CompositeGeneratorNode trace(final CompositeGeneratorNode parent, final ILocationData data) {
    final TraceNode result = new TraceNode(data);
    List<IGeneratorNode> _children = parent.getChildren();
    _children.add(result);
    return result;
  }
  
  public CompositeGeneratorNode indent(final CompositeGeneratorNode parent) {
    final IndentNode result = new IndentNode();
    List<IGeneratorNode> _children = parent.getChildren();
    _children.add(result);
    return result;
  }
  
  public CompositeGeneratorNode appendNewLine(final CompositeGeneratorNode parent) {
    List<IGeneratorNode> _children = parent.getChildren();
    NewLineNode _newLineNode = new NewLineNode();
    _children.add(_newLineNode);
    return parent;
  }
  
  public CompositeGeneratorNode append(final CompositeGeneratorNode parent, final Object object) {
    if ((object != null)) {
      List<IGeneratorNode> _children = parent.getChildren();
      String _string = object.toString();
      TextNode _textNode = new TextNode(_string);
      _children.add(_textNode);
    }
    return parent;
  }
  
  public CompositeGeneratorNode appendTemplate(final CompositeGeneratorNode parent, final StringConcatenationClient contents) {
    String _indentationString = this.wsConfig.getIndentationString();
    final TemplateNode proc = new TemplateNode(_indentationString, contents, this);
    List<IGeneratorNode> _children = parent.getChildren();
    _children.add(proc);
    return parent;
  }
}
