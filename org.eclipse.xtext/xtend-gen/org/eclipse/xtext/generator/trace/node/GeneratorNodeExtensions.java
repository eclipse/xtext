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
import org.eclipse.xtext.generator.trace.node.GeneratorWhiteSpaceConfig;
import org.eclipse.xtext.generator.trace.node.IGeneratorNode;
import org.eclipse.xtext.generator.trace.node.IndentNode;
import org.eclipse.xtext.generator.trace.node.NewLineNode;
import org.eclipse.xtext.generator.trace.node.TemplateNode;
import org.eclipse.xtext.generator.trace.node.TextNode;
import org.eclipse.xtext.generator.trace.node.TraceNode;

/**
 * A builder API to create generator node trees
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class GeneratorNodeExtensions {
  @Inject
  private GeneratorWhiteSpaceConfig wsConfig = new GeneratorWhiteSpaceConfig();
  
  /**
   * @return a root trace node for the given location
   */
  public CompositeGeneratorNode trace(final ILocationData data) {
    final TraceNode result = new TraceNode(data);
    return result;
  }
  
  /**
   * @return a root trace node for the given location
   */
  public CompositeGeneratorNode trace(final ILocationData data, final boolean useForDebugging) {
    final TraceNode result = new TraceNode(data);
    result.setUseForDebugging(useForDebugging);
    return result;
  }
  
  /**
   * @return a trace node for the given location, appended as a child on the given parent
   */
  public CompositeGeneratorNode trace(final CompositeGeneratorNode parent, final ILocationData data) {
    final TraceNode result = new TraceNode(data);
    List<IGeneratorNode> _children = parent.getChildren();
    _children.add(result);
    return result;
  }
  
  /**
   * @return a trace node for the given location, appended as a child on the given parent
   */
  public CompositeGeneratorNode trace(final CompositeGeneratorNode parent, final ILocationData data, final boolean useForDebugging) {
    final TraceNode result = new TraceNode(data);
    result.setUseForDebugging(useForDebugging);
    List<IGeneratorNode> _children = parent.getChildren();
    _children.add(result);
    return result;
  }
  
  /**
   * @return an indentation node, using the default indentation string, appended as a child on the given parent
   */
  public CompositeGeneratorNode indent(final CompositeGeneratorNode parent) {
    return this.indent(parent, this.wsConfig.getIndentationString());
  }
  
  /**
   * Appends the indentation string at the current position of the parent and adds a new composite node, indicating the same indentation for
   * subsequent lines.
   * 
   * @return an indentation node, using the given indentString, appended as a child on the given parent
   */
  public CompositeGeneratorNode indent(final CompositeGeneratorNode parent, final String indentString) {
    final IndentNode indent = new IndentNode(indentString);
    List<IGeneratorNode> _children = parent.getChildren();
    _children.add(indent);
    return indent;
  }
  
  /**
   * Appends a line separator node to the given parent.
   * 
   * @return the given parent node
   */
  public CompositeGeneratorNode appendNewLine(final CompositeGeneratorNode parent) {
    List<IGeneratorNode> _children = parent.getChildren();
    String _lineDelimiter = this.wsConfig.getLineDelimiter();
    NewLineNode _newLineNode = new NewLineNode(_lineDelimiter, false);
    _children.add(_newLineNode);
    return parent;
  }
  
  /**
   * Appends a line separator node to the given parent.
   * 
   * @return the given parent node
   */
  public CompositeGeneratorNode appendNewLine(final CompositeGeneratorNode parent, final String lineSeparator) {
    List<IGeneratorNode> _children = parent.getChildren();
    NewLineNode _newLineNode = new NewLineNode(lineSeparator, false);
    _children.add(_newLineNode);
    return parent;
  }
  
  /**
   * Appends a line separator node that will only be effective if the current line contains non-whitespace text.
   * 
   * @return the given parent node
   */
  public CompositeGeneratorNode appendNewLineIfNotEmpty(final CompositeGeneratorNode parent) {
    List<IGeneratorNode> _children = parent.getChildren();
    String _lineDelimiter = this.wsConfig.getLineDelimiter();
    NewLineNode _newLineNode = new NewLineNode(_lineDelimiter, true);
    _children.add(_newLineNode);
    return parent;
  }
  
  /**
   * Creates a text node containing the toString() representation of the given object and
   * appends it to the given parent node.
   * 
   * @return the given parent node
   */
  public CompositeGeneratorNode append(final CompositeGeneratorNode parent, final Object object) {
    if ((object instanceof StringConcatenationClient)) {
      this.appendTemplate(parent, ((StringConcatenationClient)object));
    } else {
      if ((object instanceof IGeneratorNode)) {
        List<IGeneratorNode> _children = parent.getChildren();
        _children.add(((IGeneratorNode)object));
      } else {
        if ((object != null)) {
          List<IGeneratorNode> _children_1 = parent.getChildren();
          String _string = object.toString();
          TextNode _textNode = new TextNode(_string);
          _children_1.add(_textNode);
        }
      }
    }
    return parent;
  }
  
  /**
   * Creates a template node for the given templateString and appends it to the given parent node.
   * 
   * Templates are translated to generator node trees and expressions in templates can be of type IGeneratorNode.
   * 
   * @return the given parent node
   */
  public CompositeGeneratorNode appendTemplate(final CompositeGeneratorNode parent, final StringConcatenationClient templateString) {
    final TemplateNode proc = new TemplateNode(templateString, this);
    List<IGeneratorNode> _children = parent.getChildren();
    _children.add(proc);
    return parent;
  }
}
