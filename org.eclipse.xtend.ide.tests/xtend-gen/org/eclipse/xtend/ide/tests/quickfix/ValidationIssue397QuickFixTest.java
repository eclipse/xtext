/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.quickfix;

import com.google.inject.Inject;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Eva Poell - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtendIDEInjectorProvider.class)
@SuppressWarnings("all")
public class ValidationIssue397QuickFixTest extends AbstractQuickfixTest {
  @Inject
  private IPreferenceStoreAccess preferenceStoreAccess;

  @Before
  public void setup() {
    try {
      final IProject project = JavaProjectSetupUtil.createJavaProject(this.getProjectName()).getProject();
      final IPreferenceStore prefStore = this.preferenceStoreAccess.getWritablePreferenceStore(project);
      prefStore.setValue(IssueCodes.TERNARY_EXPRESSION_NOT_ALLOWED, "error");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_fixTernExpSimple1() {
    this.applyFix("bool? 1 : 2", 
      "if (bool) 1 else 2");
  }

  @Test
  public void test_fixTernExpSimple2() {
    this.applyFix("(bool)? 1 : 2", 
      "if (bool) 1 else 2");
  }

  @Test
  public void test_fixTernExpSimple3() {
    this.applyFix("a < b? 1 : 2", 
      "if (a < b) 1 else 2");
  }

  @Test
  public void test_fixTernExpNoElse() {
    this.applyFix("bool? 1", 
      "if (bool) 1");
  }

  @Test
  public void test_fixTernExpNoElse2() {
    this.applyFix("!bool? 1", 
      "if (!bool) 1");
  }

  @Test
  public void test_fixTernExpNoElse3() {
    this.applyFix("a < b? 1", 
      "if (a < b) 1");
  }

  @Test
  public void test_fixTernExpNestedThen() {
    this.applyFix("bool? if (!bool) 3 else 4 : 2", 
      "if (bool) if (!bool) 3 else 4 else 2");
  }

  @Test
  public void test_fixTernExpNestedElse() {
    this.applyFix("bool? 1 : if(!bool) 5 else 6", 
      "if (bool) 1 else if(!bool) 5 else 6");
  }

  @Test
  public void test_fixTernExpNestedBoth() {
    this.applyFix("bool? if (!bool) 3 else 4 : if(!bool) 5 else 6", 
      "if (bool) if (!bool) 3 else 4 else if(!bool) 5 else 6");
  }

  @Test
  public void test_fixTernExpNestedInThen1() {
    this.applyFix("if (bool) (!bool)? 3 : 4 else 2", 
      "if (bool) if (!bool) 3 else 4 else 2");
  }

  @Test
  public void test_fixTernExpNestedInThen2() {
    this.applyFix("if (bool) a < b? 3 : 4 else 2", 
      "if (bool) if (a < b) 3 else 4 else 2");
  }

  @Test
  public void test_fixTernExpNestedInThenBrackets1() {
    this.applyFix("if (bool) (bool? 1) else 2", 
      "if (bool) (if (bool) 1) else 2");
  }

  @Test
  public void test_fixTernExpNestedInThenBrackets2() {
    this.applyFix("if (bool) (bool? 3 : 4) else 2", 
      "if (bool) (if (bool) 3 else 4) else 2");
  }

  @Test
  public void test_fixTernExpNestedInElse() {
    this.applyFix("if (bool) 1 else (!bool)? 5 : 6", 
      "if (bool) 1 else if (!bool) 5 else 6");
  }

  @Test
  public void test_fixTernExpNestedInElseBrackets() {
    this.applyFix("if (bool) 1 else ((bool)? 5 : 6)", 
      "if (bool) 1 else (if (bool) 5 else 6)");
  }

  @Test
  public void test_fixTernExpNestedDoubleTrouble1() {
    this.applyFix("if (bool) !bool? 5 : 7 else if (bool) 4 else 6", 
      "if (bool) if (!bool) 5 else 7 else if (bool) 4 else 6");
  }

  @Test
  public void test_fixTernExpNestedDoubleTrouble2() {
    this.applyFix("bool? !bool? 5 : 7 : (bool)? 4 : 6", 
      "if (bool) if (!bool) 5 else 7 else if (bool) 4 else 6");
  }

  @Test
  public void test_fixTernExpNestedDoubleTrouble3() {
    this.applyFix("bool? !bool? if (!bool) 1 else 2 : 3 : (bool)? 5 : 4", 
      "if (bool) if (!bool) if (!bool) 1 else 2 else 3 else if (bool) 5 else 4");
  }

  @Test
  public void test_fixTernExpDoubleNestedInThenBrackets() {
    this.applyFix("if (bool) (bool? if (a < b) 8 else 9 : 4) else 2", 
      "if (bool) (if (bool) if (a < b) 8 else 9 else 4) else 2");
  }

  @Test
  public void test_fixTernExpSpaces1() {
    this.applyFix("bool  ?         1   :    2", 
      "if (bool) 1 else 2");
  }

  @Test
  public void test_fixTernExpSpaces2() {
    this.applyFix("if (bool ) (!bool  )?    3    :   4  else       2", 
      "if (bool ) if (!bool  ) 3 else 4  else       2");
  }

  @Test
  public void test_fixTernExpSimpleWithHardEnd() {
    this.applyFix("(a < b)? 4 : 2;System.out.println(\"test\")", 
      "if (a < b) 4 else 2;System.out.println(\"test\")");
  }

  @Test
  public void test_fixTernExpNestedWithHardEnd() {
    this.applyFix("if (a < b) 4 else (a > b)           ? 3 : 2;System.out.println(\"test\")", 
      "if (a < b) 4 else if (a > b) 3 else 2;System.out.println(\"test\")");
  }

  private void applyFix(final CharSequence input, final CharSequence result) {
    final String issueCode = IssueCodes.TERNARY_EXPRESSION_NOT_ALLOWED;
    final String fixlabel = "Refactor into inline if-expression.";
    final String fixdescription = "Refactor ternary expression (cond? a : b) \ninto an inline if-expression (if cond a else b).";
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo  {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var a = 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var a = 2");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def fooMethod(boolean bool) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var c = ");
    final String start = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return c");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String end = _builder_1.toString();
    final String toTest = ((start + input) + end);
    final String toExpect = ((start + result) + end);
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix(fixlabel, fixdescription, toExpect);
    this.testQuickfixesOn(toTest, issueCode, _quickfix);
  }
}
