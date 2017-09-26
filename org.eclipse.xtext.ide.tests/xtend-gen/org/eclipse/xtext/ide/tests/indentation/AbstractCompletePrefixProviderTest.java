/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.indentation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.contentassist.CompletionPrefixProvider;
import org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.Tree;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractCompletePrefixProviderTest {
  public abstract CompletionPrefixProvider getTestee();
  
  @Inject
  private ParseHelper<Tree> parseHelper;
  
  @Test
  public void testInputToParse_01() {
    Assert.assertEquals("abc", this.getTestee().getInputToParse("abcdefg", 3, 7));
  }
  
  @Test
  public void testInputToParse_02() {
    Assert.assertEquals("abc", this.getTestee().getInputToParse("abc   defg", 3, 7));
  }
  
  @Test
  public void testWholeNodeModel() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("grandChild3");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("grandChild4");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child2");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild5");
    _builder.newLine();
    _builder.append("parent2");
    _builder.newLine();
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild1]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild2]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild3]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild4]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child2]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild5]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:parent2]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_0_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<|>parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_0_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("pa<|>rent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_1_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("<|>\tchild1");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_1_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<|>child1");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_1_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c<|>hild1");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_2_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("<|>\t\tgrandChild1");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_2_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<|>\tgrandChild1");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_2_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<|>grandChild1");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_3_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("g");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<|>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_3_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<|>grandChild2");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild1]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_4_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<|>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild1]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_4_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<|>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild1]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_4_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild1");
    _builder.newLine();
    _builder.append("<|>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild1]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_4_2b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild2");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild1]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_4_1b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild2");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild1]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_4_0b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild1");
    _builder.newLine();
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild2");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild1]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_4_2c() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child2");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild1]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_4_1c() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child2");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild1]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_4_0c() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild1");
    _builder.newLine();
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child2");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild1]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_4_2d() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("parent2");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild1]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_4_1d() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("parent2");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild1]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_4_0d() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("grandChild1");
    _builder.newLine();
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("parent2");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:parent1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:child1]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:grandChild1]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_6_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("<|>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_6_0b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("f");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_6_1b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("f");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_5_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("e");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_6_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("g <|>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_6_3b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("g <|>");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_6_3c() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("g <|> ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_6_3d() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("g <|> // comment");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_7_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("g");
    _builder.newLine();
    _builder.append("<|>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_7_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("g");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<|>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_8_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("f");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("g");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<|>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:f]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_8_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("f");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("g");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<|>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:f]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_8_2b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("f");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("g");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("h");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:f]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_8_2c() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("f");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("g");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("h");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:f]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_8_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("f");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("g");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<|>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:f]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_8_3b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("f");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("g");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("h");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:f]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_8_3c() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("f");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("g");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("h");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:f]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_8_4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("f");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("g");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<|>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:f]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_8_4b() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("f");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("g");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("h");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:f]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  public void testLastCompleteNode_8_4c() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("d");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("e");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("f");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("g");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("h");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[ID:a]");
    _builder_1.newLine();
    _builder_1.append("[ID:b]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:c]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:d]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[INDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:f]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[ID:g]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  protected void assertLastCompleteNode(final CharSequence model, final String expectation) {
    final String modelAsString = model.toString().replaceAll("\r\n", "\n");
    this.assertLastCompleteNode(modelAsString, expectation);
    final String withStringLiterals = modelAsString.replaceAll("(\\w+(<\\|>\\w+)?)", "\"$1\"");
    final String expectationWithLiterals = expectation.replaceAll("ID:(\\w+)", "STRING:\"$1\"");
    this.assertLastCompleteNode(withStringLiterals, expectationWithLiterals);
  }
  
  private void assertLastCompleteNode(final String model, final String expectation) {
    try {
      int offset = model.indexOf("<|>");
      if ((offset == (-1))) {
        offset = model.length();
      }
      int completionOffset = model.indexOf("<|>", offset);
      if ((completionOffset == (-1))) {
        completionOffset = offset;
      }
      final Tree tree = this.parseHelper.parse(model.replace("<|>", ""));
      final ICompositeNode nodeModel = NodeModelUtils.findActualNodeFor(tree);
      final INode completeNode = this.getTestee().getLastCompleteNodeByOffset(nodeModel, offset, completionOffset);
      this.assertNodeModel(expectation, completeNode);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertNodeModel(final String expectation, final INode node) {
    Assert.assertEquals(expectation, this.asText(node.getRootNode(), node));
  }
  
  private String asText(final INode node, final INode stop) {
    StringConcatenation _builder = new StringConcatenation();
    {
      final Function1<ILeafNode, Boolean> _function = (ILeafNode it) -> {
        EObject _grammarElement = it.getGrammarElement();
        return Boolean.valueOf((!(_grammarElement instanceof Action)));
      };
      final Function1<ILeafNode, Boolean> _function_1 = (ILeafNode it) -> {
        boolean _isHidden = it.isHidden();
        return Boolean.valueOf((!_isHidden));
      };
      Iterable<ILeafNode> _upTo = this.<ILeafNode>upTo(IterableExtensions.<ILeafNode>filter(IterableExtensions.<ILeafNode>filter(node.getLeafNodes(), _function), _function_1), stop);
      for(final ILeafNode leaf : _upTo) {
        _builder.append("[");
        String _kenType = this.tokenType(leaf.getGrammarElement());
        _builder.append(_kenType);
        _builder.append(":");
        String _replace = leaf.getText().replace("\t", "\\t");
        _builder.append(_replace);
        _builder.append("]");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  private <T extends Object> Iterable<T> upTo(final Iterable<T> iter, final Object element) {
    abstract class __AbstractCompletePrefixProviderTest_1 implements Function1<T, Boolean> {
      boolean found;
    }
    
    __AbstractCompletePrefixProviderTest_1 ___AbstractCompletePrefixProviderTest_1 = new __AbstractCompletePrefixProviderTest_1() {
      {
        found = false;
      }
      @Override
      public Boolean apply(final T t) {
        if (this.found) {
          return Boolean.valueOf(false);
        }
        try {
          return Boolean.valueOf(true);
        } finally {
          boolean _equals = Objects.equal(t, element);
          this.found = _equals;
        }
      }
    };
    return IterableExtensions.<T>filter(iter, ___AbstractCompletePrefixProviderTest_1);
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
