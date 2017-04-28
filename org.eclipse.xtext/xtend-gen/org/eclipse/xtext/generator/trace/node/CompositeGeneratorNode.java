/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace.node;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.trace.node.IGeneratorNode;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * A composite node does not contribute any output directly, but only through its children.
 * Thus it is an <em>inner</em> node of the code generator tree.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public class CompositeGeneratorNode implements IGeneratorNode {
  private final List<IGeneratorNode> children = CollectionLiterals.<IGeneratorNode>newArrayList();
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    String _simpleName = this.getClass().getSimpleName();
    _builder.append(_simpleName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      for(final IGeneratorNode c : this.children) {
        _builder.append("\t");
        String _string = c.toString();
        _builder.append(_string, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  @Pure
  public List<IGeneratorNode> getChildren() {
    return this.children;
  }
}
