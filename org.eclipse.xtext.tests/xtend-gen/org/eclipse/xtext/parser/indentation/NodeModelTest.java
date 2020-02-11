/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.indentation;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree;
import org.eclipse.xtext.parser.indentation.tests.IndentationAwareTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(IndentationAwareTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class NodeModelTest {
  public static void assertEquals(final Object expected, final Object actual) {
    Assert.assertEquals(expected.toString().replaceAll("\r\n", "\n"), actual.toString().replaceAll("\r\n", "\n"));
  }
  
  @Inject
  private ParseHelper<Tree> parseHelper;
  
  @Inject
  @Extension
  private InvariantChecker invariantChecker;
  
  @Test
  public void testEmptyTree() {
    final ICompositeNode tree = this.getRootNode("");
    NodeModelTest.assertEquals("", this.asText(tree));
  }
  
  @Test
  public void testSingleRootNode() {
    final ICompositeNode tree = this.getRootNode("root");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[ID:root]");
    _builder.newLine();
    NodeModelTest.assertEquals(_builder.toString().trim(), this.asText(tree));
  }
  
  @Test
  public void testTwoRootNodes() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("first");
    _builder.newLine();
    _builder.append("second");
    _builder.newLine();
    final ICompositeNode tree = this.getRootNode(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:first][-WS:");
    _builder_1.newLine();
    _builder_1.append("][ID:second][-WS:");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    NodeModelTest.assertEquals(_builder_1.toString().trim(), this.asText(tree));
  }
  
  @Test
  public void testParentChild() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child");
    _builder.newLine();
    final ICompositeNode tree = this.getRootNode(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent][-WS:");
    _builder_1.newLine();
    _builder_1.append("\\t][INDENT:][ID:child][-WS:");
    _builder_1.newLine();
    _builder_1.append("][DEDENT:]");
    _builder_1.newLine();
    NodeModelTest.assertEquals(_builder_1.toString().trim(), this.asText(tree));
  }
  
  @Test
  public void testParentChildWithEof() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child");
    _builder.newLine();
    final ICompositeNode tree = this.getRootNode(_builder.toString().trim());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent][-WS:");
    _builder_1.newLine();
    _builder_1.append("\\t][INDENT:][ID:child][DEDENT:]");
    _builder_1.newLine();
    NodeModelTest.assertEquals(_builder_1.toString().trim(), this.asText(tree));
  }
  
  @Test
  public void testParentChildren() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child");
    _builder.newLine();
    final ICompositeNode tree = this.getRootNode(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent][-WS:");
    _builder_1.newLine();
    _builder_1.append("\\t][INDENT:][ID:child][-WS:");
    _builder_1.newLine();
    _builder_1.append("\\t][ID:child][-WS:");
    _builder_1.newLine();
    _builder_1.append("][DEDENT:]");
    _builder_1.newLine();
    NodeModelTest.assertEquals(_builder_1.toString().trim(), this.asText(tree));
  }
  
  @Test
  public void testTree_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("d");
    _builder.newLine();
    final ICompositeNode tree = this.getRootNode(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a][-WS:");
    _builder_1.newLine();
    _builder_1.append("\\t][INDENT:][ID:b][-WS:");
    _builder_1.newLine();
    _builder_1.append("\\t ][INDENT:][ID:c][-WS:");
    _builder_1.newLine();
    _builder_1.append("][DEDENT:][-WS:\\t][ID:d][-WS:");
    _builder_1.newLine();
    _builder_1.append("][DEDENT:]");
    _builder_1.newLine();
    NodeModelTest.assertEquals(_builder_1.toString().trim(), this.asText(tree));
  }
  
  @Test
  public void testWeirdTree() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("root");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("s4");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("s8");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("s6");
    _builder.newLine();
    final ICompositeNode tree = this.getRootNode(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:root][-WS:");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("][INDENT:][ID:s4][-WS:");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("][INDENT:][ID:s8][-WS:");
    _builder_1.newLine();
    _builder_1.append("][DEDENT:][-WS:      ][INDENT:][ID:s6][-WS:");
    _builder_1.newLine();
    _builder_1.append("][DEDENT:][DEDENT:]");
    _builder_1.newLine();
    NodeModelTest.assertEquals(_builder_1.toString().trim(), this.asText(tree));
  }
  
  @Test
  public void testWeirdTreeEof() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("root");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("s4");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("s8");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("s6");
    _builder.newLine();
    final ICompositeNode tree = this.getRootNode(_builder.toString().trim());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:root][-WS:");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("][INDENT:][ID:s4][-WS:");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("][INDENT:][ID:s8][-WS:");
    _builder_1.newLine();
    _builder_1.append("][DEDENT:][-WS:      ][INDENT:][ID:s6][DEDENT:][DEDENT:]");
    _builder_1.newLine();
    NodeModelTest.assertEquals(_builder_1.toString().trim(), this.asText(tree));
  }
  
  @Test
  public void testIgnoreEmptyLines_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("first");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("second");
    _builder.newLine();
    final ICompositeNode tree = this.getRootNode(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:first][-WS:");
    _builder_1.newLine();
    _builder_1.append("\\t");
    _builder_1.newLine();
    _builder_1.append("][ID:second][-WS:");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    NodeModelTest.assertEquals(_builder_1.toString().trim(), this.asText(tree));
  }
  
  @Test
  public void testIgnoreEmptyLines_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"first\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\"second\"");
    _builder.newLine();
    final ICompositeNode tree = this.getRootNode(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[STRING:\"first\"][-WS:");
    _builder_1.newLine();
    _builder_1.append("\\t");
    _builder_1.newLine();
    _builder_1.append("][STRING:\"second\"][-WS:");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    NodeModelTest.assertEquals(_builder_1.toString().trim(), this.asText(tree));
  }
  
  @Test
  public void testIgnoreEmptyLines_3() {
    final ICompositeNode tree = this.getRootNode("first\n\t");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[ID:first][-WS:");
    _builder.newLine();
    _builder.append("\\t]");
    _builder.newLine();
    NodeModelTest.assertEquals(_builder.toString().trim(), this.asText(tree));
  }
  
  @Test
  public void testIgnoreEmptyLines_4() {
    final ICompositeNode tree = this.getRootNode("first\n\t\tabc\n\t");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[ID:first][-WS:");
    _builder.newLine();
    _builder.append("\\t\\t][INDENT:][ID:abc][-WS:");
    _builder.newLine();
    _builder.append("][DEDENT:][-WS:\\t]");
    _builder.newLine();
    NodeModelTest.assertEquals(_builder.toString().trim(), this.asText(tree));
  }
  
  @Test
  public void testIgnoreEmptyLines_5() {
    final ICompositeNode tree = this.getRootNode("first\n\t\tabc\n\n");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[ID:first][-WS:");
    _builder.newLine();
    _builder.append("\\t\\t][INDENT:][ID:abc][-WS:");
    _builder.newLine();
    _builder.append("][DEDENT:][-WS:");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    NodeModelTest.assertEquals(_builder.toString().trim(), this.asText(tree));
  }
  
  @Test
  public void testIgnoreEmptyLines_6() {
    final ICompositeNode tree = this.getRootNode("first\n\t\tabc\n\t\n");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[ID:first][-WS:");
    _builder.newLine();
    _builder.append("\\t\\t][INDENT:][ID:abc][-WS:");
    _builder.newLine();
    _builder.append("][DEDENT:][-WS:\\t");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    NodeModelTest.assertEquals(_builder.toString().trim(), this.asText(tree));
  }
  
  @Test
  public void testIgnoreEmptyLines_7() {
    final ICompositeNode tree = this.getRootNode("a\n\tb\n\t ");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[ID:a][-WS:");
    _builder.newLine();
    _builder.append("\\t][INDENT:][ID:b][-WS:");
    _builder.newLine();
    _builder.append("\\t ][DEDENT:]");
    _builder.newLine();
    NodeModelTest.assertEquals(_builder.toString().trim(), this.asText(tree));
  }
  
  private ICompositeNode getRootNode(final CharSequence seq) {
    try {
      final Tree model = this.parseHelper.parse(seq.toString().replaceAll("\r\n", "\n"));
      final ICompositeNode result = NodeModelUtils.getNode(model).getRootNode();
      this.invariantChecker.checkInvariant(result);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private String asText(final INode node) {
    final Function1<ILeafNode, Boolean> _function = (ILeafNode it) -> {
      EObject _grammarElement = it.getGrammarElement();
      return Boolean.valueOf((!(_grammarElement instanceof Action)));
    };
    final Function1<ILeafNode, CharSequence> _function_1 = (ILeafNode it) -> {
      String _xifexpression = null;
      boolean _isHidden = it.isHidden();
      if (_isHidden) {
        _xifexpression = "-";
      } else {
        _xifexpression = "";
      }
      String _kenType = this.tokenType(it.getGrammarElement());
      String _plus = (_xifexpression + _kenType);
      String _plus_1 = (_plus + ":");
      String _replace = it.getText().replace("\t", "\\t");
      return (_plus_1 + _replace);
    };
    return IterableExtensions.<ILeafNode>join(IterableExtensions.<ILeafNode>filter(node.getLeafNodes(), _function), "[", "][", "]", _function_1);
  }
  
  private String tokenType(final EObject obj) {
    String _switchResult = null;
    boolean _matched = false;
    if (obj instanceof RuleCall) {
      _matched=true;
      _switchResult = ((RuleCall)obj).getRule().getName();
    }
    if (!_matched) {
      if (obj instanceof Keyword) {
        _matched=true;
        _switchResult = ((Keyword)obj).getValue();
      }
    }
    if (!_matched) {
      if (obj instanceof AbstractRule) {
        _matched=true;
        _switchResult = ((AbstractRule)obj).getName();
      }
    }
    return _switchResult;
  }
}
