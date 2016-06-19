/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.parser.indentation;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.indentation.IndentationAwareTestLanguageInjectorProvider;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode;
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
  @Extension
  private ParseHelper<Tree> parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper validationTestHelper;
  
  @Inject
  @Extension
  private InvariantChecker invariantChecker;
  
  @Test
  public void testEmptyTree() {
    try {
      final Tree tree = this.parseHelper.parse("");
      Assert.assertNotNull(tree);
      EList<TreeNode> _nodes = tree.getNodes();
      boolean _isEmpty = _nodes.isEmpty();
      Assert.assertTrue(_isEmpty);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSingleRootNode() {
    try {
      final Tree tree = this.parseHelper.parse("root");
      Assert.assertNotNull(tree);
      EList<TreeNode> _nodes = tree.getNodes();
      int _size = _nodes.size();
      Assert.assertEquals(1, _size);
      EList<TreeNode> _nodes_1 = tree.getNodes();
      TreeNode _head = IterableExtensions.<TreeNode>head(_nodes_1);
      String _name = _head.getName();
      Assert.assertEquals("root", _name);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTwoRootNodes() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("first");
      _builder.newLine();
      _builder.append("second");
      _builder.newLine();
      final Tree tree = this.parseHelper.parse(_builder);
      Assert.assertNotNull(tree);
      EList<TreeNode> _nodes = tree.getNodes();
      int _size = _nodes.size();
      Assert.assertEquals(2, _size);
      EList<TreeNode> _nodes_1 = tree.getNodes();
      TreeNode _head = IterableExtensions.<TreeNode>head(_nodes_1);
      String _name = _head.getName();
      Assert.assertEquals("first", _name);
      EList<TreeNode> _nodes_2 = tree.getNodes();
      TreeNode _last = IterableExtensions.<TreeNode>last(_nodes_2);
      String _name_1 = _last.getName();
      Assert.assertEquals("second", _name_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParentChild() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("parent");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("child");
      _builder.newLine();
      final Tree tree = this.parseHelper.parse(_builder);
      Assert.assertNotNull(tree);
      EList<TreeNode> _nodes = tree.getNodes();
      int _size = _nodes.size();
      Assert.assertEquals(1, _size);
      EList<TreeNode> _nodes_1 = tree.getNodes();
      TreeNode _head = IterableExtensions.<TreeNode>head(_nodes_1);
      String _name = _head.getName();
      Assert.assertEquals("parent", _name);
      EList<TreeNode> _nodes_2 = tree.getNodes();
      TreeNode _head_1 = IterableExtensions.<TreeNode>head(_nodes_2);
      EList<TreeNode> _children = _head_1.getChildren();
      TreeNode _head_2 = IterableExtensions.<TreeNode>head(_children);
      String _name_1 = _head_2.getName();
      Assert.assertEquals("child", _name_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("parent");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("child");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      String _asText = this.asText(tree);
      Assert.assertEquals(_string, _asText);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParentChildren() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("parent");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("child");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("child");
      _builder.newLine();
      final Tree tree = this.parseHelper.parse(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("parent");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("child");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("child");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      String _asText = this.asText(tree);
      Assert.assertEquals(_string, _asText);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
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
    String _string = _builder_1.toString();
    String _asText = this.asText(tree);
    Assert.assertEquals(_string, _asText);
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
    String _string = _builder_1.toString();
    String _asText = this.asText(tree);
    Assert.assertEquals(_string, _asText);
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
    String _string = _builder_1.toString();
    String _asText = this.asText(tree);
    Assert.assertEquals(_string, _asText);
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
    String _string = _builder_1.toString();
    String _asText = this.asText(tree);
    Assert.assertEquals(_string, _asText);
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
    String _string = _builder_1.toString();
    String _asText = this.asText(tree);
    Assert.assertEquals(_string, _asText);
  }
  
  private Tree parseAndValidate(final CharSequence s) {
    try {
      final Tree result = this.parseHelper.parse(s);
      this.validationTestHelper.assertNoIssues(result);
      Resource _eResource = result.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      IParseResult _parseResult = resource.getParseResult();
      final ICompositeNode node = _parseResult.getRootNode();
      this.invariantChecker.checkInvariant(node);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private String asText(final Tree tree) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<TreeNode> _nodes = tree.getNodes();
      for(final TreeNode node : _nodes) {
        StringConcatenation _asText = this.asText(node);
        _builder.append(_asText, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  private StringConcatenation asText(final TreeNode treeNode) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = treeNode.getName();
    _builder.append(_name, "");
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
}
