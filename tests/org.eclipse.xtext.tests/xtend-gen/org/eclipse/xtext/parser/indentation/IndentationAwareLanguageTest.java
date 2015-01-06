/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.parser.indentation;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.parser.indentation.IndentationAwareTestLanguageStandaloneSetup;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class IndentationAwareLanguageTest extends AbstractXtextTests {
  @Inject
  @Extension
  private ParseHelper<Tree> parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper validationTestHelper;
  
  @Before
  public void setUp() throws Exception {
    super.setUp();
    this.with(IndentationAwareTestLanguageStandaloneSetup.class);
    Injector _injector = this.getInjector();
    _injector.injectMembers(this);
  }
  
  @Test
  public void testEmptyTree() {
    try {
      final Tree tree = this.parseHelper.parse("");
      Assert.assertNotNull(tree);
      EList<TreeNode> _nodes = tree.getNodes();
      boolean _isEmpty = _nodes.isEmpty();
      Assert.assertTrue(_isEmpty);
      this.validationTestHelper.assertNoIssues(tree);
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
      this.validationTestHelper.assertNoIssues(tree);
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
      this.validationTestHelper.assertNoIssues(tree);
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
      this.validationTestHelper.assertNoIssues(tree);
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
      this.validationTestHelper.assertNoIssues(tree);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTree_01() {
    try {
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
      final Tree tree = this.parseHelper.parse(_builder);
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
      this.validationTestHelper.assertNoIssues(tree);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTree_02() {
    try {
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
      final Tree tree = this.parseHelper.parse(_builder);
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
      this.validationTestHelper.assertNoIssues(tree);
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
