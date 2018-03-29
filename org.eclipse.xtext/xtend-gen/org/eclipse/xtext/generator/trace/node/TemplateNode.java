/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace.node;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.generator.trace.node.GeneratorNodeExtensions;
import org.eclipse.xtext.generator.trace.node.IGeneratorNode;
import org.eclipse.xtext.generator.trace.node.IndentNode;
import org.eclipse.xtext.generator.trace.node.NewLineNode;
import org.eclipse.xtext.generator.trace.node.TextNode;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * A template node applies a {@link StringConcatenationClient} to compute its children.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class TemplateNode extends CompositeGeneratorNode implements StringConcatenationClient.TargetStringConcatenation {
  private final GeneratorNodeExtensions nodeFactory;
  
  public TemplateNode(final StringConcatenationClient contents, final GeneratorNodeExtensions nodeFactory) {
    this.nodeFactory = nodeFactory;
    StringConcatenationClient.appendTo(contents, this);
  }
  
  private CompositeGeneratorNode currentParent = this;
  
  @Override
  public void append(final Object object, final String indentation) {
    int _length = indentation.length();
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      final CompositeGeneratorNode before = this.currentParent;
      try {
        IndentNode _indentNode = new IndentNode(indentation, false, true);
        this.currentParent = _indentNode;
        List<IGeneratorNode> _children = before.getChildren();
        _children.add(this.currentParent);
        this.append(object);
      } finally {
        this.currentParent = before;
      }
    } else {
      this.append(object);
    }
  }
  
  private final Splitter lineSplitter = Splitter.on(Pattern.compile("\\R"));
  
  @Override
  public void append(final Object object) {
    if ((object == null)) {
      return;
    }
    boolean _matched = false;
    if (object instanceof StringConcatenationClient) {
      _matched=true;
      this.nodeFactory.appendTemplate(this.currentParent, ((StringConcatenationClient)object));
    }
    if (!_matched) {
      if (object instanceof IGeneratorNode) {
        _matched=true;
        List<IGeneratorNode> _children = this.currentParent.getChildren();
        _children.add(((IGeneratorNode)object));
      }
    }
    if (!_matched) {
      {
        final String str = object.toString();
        final Iterator<String> iter = this.lineSplitter.split(str).iterator();
        while (iter.hasNext()) {
          {
            final String segment = iter.next();
            this.nodeFactory.append(this.currentParent, segment);
            boolean _hasNext = iter.hasNext();
            if (_hasNext) {
              this.newLine();
            }
          }
        }
      }
    }
  }
  
  protected Iterable<IGeneratorNode> leafsBackwards(final IGeneratorNode it) {
    Iterable<IGeneratorNode> _switchResult = null;
    boolean _matched = false;
    if (it instanceof CompositeGeneratorNode) {
      _matched=true;
      final Function1<IGeneratorNode, Iterable<IGeneratorNode>> _function = (IGeneratorNode it_1) -> {
        return this.leafsBackwards(it_1);
      };
      final Function2<Iterable<IGeneratorNode>, Iterable<IGeneratorNode>, Iterable<IGeneratorNode>> _function_1 = (Iterable<IGeneratorNode> p1, Iterable<IGeneratorNode> p2) -> {
        return Iterables.<IGeneratorNode>concat(p1, p2);
      };
      _switchResult = IterableExtensions.<Iterable<IGeneratorNode>>reduce(ListExtensions.<IGeneratorNode, Iterable<IGeneratorNode>>map(ListExtensions.<IGeneratorNode>reverseView(((CompositeGeneratorNode)it).getChildren()), _function), _function_1);
    }
    if (!_matched) {
      _switchResult = Collections.<IGeneratorNode>unmodifiableList(CollectionLiterals.<IGeneratorNode>newArrayList(it));
    }
    return _switchResult;
  }
  
  @Override
  public void appendImmediate(final Object object, final String indentation) {
    final ArrayList<IGeneratorNode> removed = Lists.<IGeneratorNode>newArrayList();
    for (int i = (this.currentParent.getChildren().size() - 1); (i >= 0); i--) {
      {
        final IGeneratorNode node = this.currentParent.getChildren().get(i);
        if (((node instanceof TextNode) && (!TemplateNode.hasContent(((TextNode) node).getText())))) {
          IGeneratorNode _remove = this.currentParent.getChildren().remove(i);
          removed.add(_remove);
        } else {
          if ((node instanceof NewLineNode)) {
            IGeneratorNode _remove_1 = this.currentParent.getChildren().remove(i);
            removed.add(_remove_1);
          } else {
            this.append(object, indentation);
            final Consumer<IGeneratorNode> _function = (IGeneratorNode it) -> {
              this.append(it, indentation);
            };
            ListExtensions.<IGeneratorNode>reverse(removed).forEach(_function);
            return;
          }
        }
      }
    }
    this.append(object, indentation);
  }
  
  protected static boolean hasContent(final CharSequence s) {
    for (int i = 0; (i < s.length()); i++) {
      boolean _isWhitespace = Character.isWhitespace(s.charAt(i));
      boolean _not = (!_isWhitespace);
      if (_not) {
        return true;
      }
    }
    return false;
  }
  
  @Override
  public void newLine() {
    this.nodeFactory.appendNewLine(this.currentParent);
  }
  
  @Override
  public void newLineIfNotEmpty() {
    this.nodeFactory.appendNewLineIfNotEmpty(this.currentParent);
  }
  
  @Override
  public char charAt(final int index) {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public int length() {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public CharSequence subSequence(final int start, final int end) {
    throw new UnsupportedOperationException();
  }
}
