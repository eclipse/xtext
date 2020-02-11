/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.indentation;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.ChildList;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.OtherTreeNode;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode;
import org.eclipse.xtext.parser.indentation.tests.IndentationAwareTestLanguageInjectorProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
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
public class IndentationAwareLanguageTest {
  @Inject
  private ParseHelper<Tree> parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper validationTestHelper;
  
  @Inject
  @Extension
  private InvariantChecker invariantChecker;
  
  public Tree parse(final CharSequence seq) {
    try {
      return this.parseHelper.parse(seq.toString().replaceAll("\r\n", "\n"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEmptyTree() {
    final Tree tree = this.parse("");
    Assert.assertNotNull(tree);
    Assert.assertTrue(tree.getNodes().isEmpty());
  }
  
  @Test
  public void testSingleRootNode() {
    final Tree tree = this.parse("root");
    Assert.assertNotNull(tree);
    Assert.assertEquals(1, tree.getNodes().size());
    Assert.assertEquals("root", IterableExtensions.<TreeNode>head(tree.getNodes()).getName());
  }
  
  @Test
  public void testTwoRootNodes() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("first");
    _builder.newLine();
    _builder.append("second");
    _builder.newLine();
    final Tree tree = this.parse(_builder);
    Assert.assertNotNull(tree);
    Assert.assertEquals(2, tree.getNodes().size());
    Assert.assertEquals("first", IterableExtensions.<TreeNode>head(tree.getNodes()).getName());
    Assert.assertEquals("second", IterableExtensions.<TreeNode>last(tree.getNodes()).getName());
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
    final Tree tree = this.parse(_builder);
    Assert.assertNotNull(tree);
    Assert.assertEquals(2, tree.getNodes().size());
    Assert.assertEquals("first", IterableExtensions.<TreeNode>head(tree.getNodes()).getName());
    Assert.assertEquals(0, IterableExtensions.<TreeNode>head(tree.getNodes()).getChildren().size());
    Assert.assertEquals("second", IterableExtensions.<TreeNode>last(tree.getNodes()).getName());
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
    final Tree tree = this.parse(_builder);
    Assert.assertNotNull(tree);
    Assert.assertEquals(2, tree.getMoreNodes().size());
    Assert.assertEquals("first", IterableExtensions.<OtherTreeNode>head(tree.getMoreNodes()).getName());
    Assert.assertNull(IterableExtensions.<OtherTreeNode>head(tree.getMoreNodes()).getChildList());
    Assert.assertEquals("second", IterableExtensions.<OtherTreeNode>last(tree.getMoreNodes()).getName());
  }
  
  @Test
  public void testIgnoreEmptyLines_3() {
    final Tree tree = this.parse("first\n\t");
    Assert.assertNotNull(tree);
    Assert.assertEquals(1, tree.getNodes().size());
    Assert.assertEquals("first", IterableExtensions.<TreeNode>head(tree.getNodes()).getName());
    Assert.assertEquals(0, IterableExtensions.<TreeNode>head(tree.getNodes()).getChildren().size());
  }
  
  @Test
  public void testIgnoreEmptyLines_4() {
    final Tree tree = this.parse("\"first\"\n\t");
    Assert.assertNotNull(tree);
    Assert.assertEquals(1, tree.getMoreNodes().size());
    Assert.assertEquals("first", IterableExtensions.<OtherTreeNode>head(tree.getMoreNodes()).getName());
    Assert.assertNull(IterableExtensions.<OtherTreeNode>head(tree.getMoreNodes()).getChildList());
  }
  
  @Test
  public void testIgnoreEmptyLines_5() {
    final Tree tree = this.parse("first\n\t\tabc\n\t");
    Assert.assertNotNull(tree);
    Assert.assertEquals(1, tree.getNodes().size());
    Assert.assertEquals("first", IterableExtensions.<TreeNode>head(tree.getNodes()).getName());
    Assert.assertEquals(1, IterableExtensions.<TreeNode>head(tree.getNodes()).getChildren().size());
  }
  
  @Test
  public void testIgnoreEmptyLines_6() {
    final Tree tree = this.parse("\"first\"\n\t\t\"abc\"\n\t");
    Assert.assertNotNull(tree);
    Assert.assertEquals(1, tree.getMoreNodes().size());
    Assert.assertEquals("first", IterableExtensions.<OtherTreeNode>head(tree.getMoreNodes()).getName());
    Assert.assertNotNull(IterableExtensions.<OtherTreeNode>head(tree.getMoreNodes()).getChildList());
    Assert.assertEquals(1, IterableExtensions.<OtherTreeNode>head(tree.getMoreNodes()).getChildList().getChildren().size());
  }
  
  @Test
  public void testParentChild() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child");
    _builder.newLine();
    final Tree tree = this.parse(_builder);
    Assert.assertNotNull(tree);
    Assert.assertEquals(1, tree.getNodes().size());
    Assert.assertEquals("parent", IterableExtensions.<TreeNode>head(tree.getNodes()).getName());
    Assert.assertEquals("child", IterableExtensions.<TreeNode>head(IterableExtensions.<TreeNode>head(tree.getNodes()).getChildren()).getName());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("parent");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("child");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.asText(tree));
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
    final Tree tree = this.parse(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("parent");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("child");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("child");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.asText(tree));
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
    final Tree tree = this.parseAndValidate(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("b");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("c");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("d");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.asText(tree));
  }
  
  @Test
  public void testTree_02() {
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
    _builder.append("\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("f");
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("g");
    _builder.newLine();
    _builder.append("h");
    _builder.newLine();
    final Tree tree = this.parseAndValidate(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("b");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("c");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("d");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("e");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("f");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("g");
    _builder_1.newLine();
    _builder_1.append("h");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.asText(tree));
  }
  
  @Test
  public void testTree_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("b // single tab");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("c // 8 spaces eq 1 tab");
    _builder.newLine();
    _builder.append("d");
    _builder.newLine();
    final Tree tree = this.parseAndValidate(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("b");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("c");
    _builder_1.newLine();
    _builder_1.append("d");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.asText(tree));
  }
  
  @Test
  public void testTree_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("level0_1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("level1_1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("level1_2");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("level2_1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("level2_2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("level1_3");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("level2_3");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("level2_4");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("level3_1");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("level3_2");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("level2_5");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("level1_4");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("level2_6");
    _builder.newLine();
    _builder.append("level0_2");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("level1_5");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("level2_7");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("level3_8");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("level4_9");
    _builder.newLine();
    final Tree tree = this.parseAndValidate(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("level0_1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("level1_1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("level1_2");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("level2_1");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("level2_2");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("level1_3");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("level2_3");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("level2_4");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("level3_1");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("level3_2");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("level2_5");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("level1_4");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("level2_6");
    _builder_1.newLine();
    _builder_1.append("level0_2");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("level1_5");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("level2_7");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("level3_8");
    _builder_1.newLine();
    _builder_1.append("\t\t\t\t");
    _builder_1.append("level4_9");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.asText(tree));
  }
  
  @Test
  public void testTree_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("x");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b // two tabs");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("c // tab and 8 spaces (eq 2 tabs)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("y");
    _builder.newLine();
    final Tree tree = this.parseAndValidate(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("x");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("b");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("c");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("y");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.asText(tree));
  }
  
  @Test
  public void testTree_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"a\"");
    _builder.newLine();
    _builder.append("\"b\"");
    _builder.newLine();
    final Tree tree = this.parseAndValidate(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("b");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.asText(tree));
  }
  
  @Test
  public void testTree_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"a\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\"b\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    final Tree tree = this.parseAndValidate(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("b");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.asText(tree));
  }
  
  @Test
  public void testTree_08() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"a\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"1\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"2\"");
    _builder.newLine();
    _builder.append("\"b\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"3\"");
    _builder.newLine();
    final Tree tree = this.parseAndValidate(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append(">");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("1");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("2");
    _builder_1.newLine();
    _builder_1.append("b");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append(">");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("3");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.asText(tree));
  }
  
  private Tree parseAndValidate(final CharSequence s) {
    final Tree result = this.parse(s);
    this.validationTestHelper.assertNoIssues(result);
    Resource _eResource = result.eResource();
    final XtextResource resource = ((XtextResource) _eResource);
    final ICompositeNode node = resource.getParseResult().getRootNode();
    this.invariantChecker.checkInvariant(node);
    return result;
  }
  
  private String asText(final Tree tree) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<TreeNode> _nodes = tree.getNodes();
      for(final TreeNode node : _nodes) {
        StringConcatenation _asText = this.asText(node);
        _builder.append(_asText);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<OtherTreeNode> _moreNodes = tree.getMoreNodes();
      for(final OtherTreeNode node_1 : _moreNodes) {
        StringConcatenation _asText_1 = this.asText(node_1);
        _builder.append(_asText_1);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  private StringConcatenation asText(final TreeNode treeNode) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = treeNode.getName();
    _builder.append(_name);
    _builder.newLineIfNotEmpty();
    {
      EList<TreeNode> _children = treeNode.getChildren();
      for(final TreeNode node : _children) {
        _builder.append("\t");
        StringConcatenation _asText = this.asText(node);
        _builder.append(_asText, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private StringConcatenation asText(final OtherTreeNode treeNode) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = treeNode.getName();
    _builder.append(_name);
    _builder.newLineIfNotEmpty();
    {
      ChildList _childList = treeNode.getChildList();
      boolean _tripleNotEquals = (_childList != null);
      if (_tripleNotEquals) {
        _builder.append("\t");
        _builder.append(">");
        _builder.newLine();
        {
          EList<OtherTreeNode> _children = treeNode.getChildList().getChildren();
          for(final OtherTreeNode node : _children) {
            _builder.append("\t");
            _builder.append("\t");
            StringConcatenation _asText = this.asText(node);
            _builder.append(_asText, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
}
