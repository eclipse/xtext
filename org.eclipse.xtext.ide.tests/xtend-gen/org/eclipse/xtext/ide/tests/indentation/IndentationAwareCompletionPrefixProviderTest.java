/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.indentation;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.editor.contentassist.CompletionPrefixProvider;
import org.eclipse.xtext.ide.editor.contentassist.IndentationAwareCompletionPrefixProvider;
import org.eclipse.xtext.ide.tests.indentation.AbstractCompletePrefixProviderTest;
import org.eclipse.xtext.ide.tests.testlanguage.tests.IndentationAwareUiTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(IndentationAwareUiTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class IndentationAwareCompletionPrefixProviderTest extends AbstractCompletePrefixProviderTest {
  @Inject
  private IndentationAwareCompletionPrefixProvider testee;
  
  @Override
  public CompletionPrefixProvider getTestee() {
    return this.testee;
  }
  
  @Test
  @Override
  public void testInputToParse_02() {
    Assert.assertEquals("abc  ", this.testee.getInputToParse("abc   defg", 3, 5));
  }
  
  @Test
  @Override
  public void testLastCompleteNode_1_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("parent1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<|>child1");
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    _builder_1.append("[ID:grandChild2]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    _builder_1.append("[ID:e]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    _builder_1.append("[DEDENT:]");
    _builder_1.newLine();
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
  @Override
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
  @Override
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
  
  @Test
  @Override
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
  @Override
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
    this.assertLastCompleteNode(_builder, _builder_1.toString());
  }
}
