/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.completion;

import java.util.List;
import junit.framework.TestCase;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class XtendCompletionTest extends LightXtendTest {
  public void testClassKeyword() {
    this.complete("cl<caret>");
    this.assertLookupStrings("class");
  }
  
  public void testExtendsKeyword() {
    this.complete("class Foo ex<caret>");
    this.assertLookupStrings("extends");
  }
  
  public void testEmptyFile() {
    this.complete("");
    this.assertLookupStrings(
      "annotation", 
      "class", 
      "enum", 
      "import", 
      "interface", 
      "package");
  }
  
  public void testJvmParameterizedTypeReference_Type() {
    this.complete("class Foo extends Array<caret>");
    final List<String> lookupElementStrings = this.myFixture.getLookupElementStrings();
    String _string = lookupElementStrings.toString();
    boolean _contains = lookupElementStrings.contains("ArrayList");
    TestCase.assertTrue(_string, _contains);
  }
  
  public void testJvmParameterizedTypeReference_Type_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def Array<caret> foo() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String _string = _builder.toString();
    this.complete(_string);
    final List<String> lookupElementStrings = this.myFixture.getLookupElementStrings();
    String _string_1 = lookupElementStrings.toString();
    boolean _contains = lookupElementStrings.contains("ArrayList");
    TestCase.assertTrue(_string_1, _contains);
  }
  
  public void testJvmParameterizedTypeReference_Type_03() {
    this.complete("class Foo <caret> {");
    this.assertLookupStrings(
      "extends", 
      "implements");
  }
  
  public void testXImportDeclaration_ImportedType() {
    this.complete("import <caret>");
    final List<String> lookupElementStrings = this.myFixture.getLookupElementStrings();
    String _string = lookupElementStrings.toString();
    boolean _contains = lookupElementStrings.contains("ArrayList");
    TestCase.assertTrue(_string, _contains);
  }
  
  public void testXImportDeclaration_ImportedType_02() {
    this.complete("import java.util.Array<caret>");
    final List<String> lookupElementStrings = this.myFixture.getLookupElementStrings();
    String _string = lookupElementStrings.toString();
    boolean _contains = lookupElementStrings.contains("ArrayList");
    TestCase.assertTrue(_string, _contains);
  }
  
  public void testXConstructorCall_Constructor() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("new <caret>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Bar {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("abstract class AbstractBar {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface InterfaceBar {}");
    _builder.newLine();
    String _string = _builder.toString();
    this.complete(_string);
    final List<String> lookupElementStrings = this.myFixture.getLookupElementStrings();
    String _string_1 = lookupElementStrings.toString();
    boolean _contains = lookupElementStrings.contains("ArrayList");
    TestCase.assertTrue(_string_1, _contains);
    String _string_2 = lookupElementStrings.toString();
    boolean _contains_1 = lookupElementStrings.contains("Bar");
    TestCase.assertTrue(_string_2, _contains_1);
    String _string_3 = lookupElementStrings.toString();
    boolean _contains_2 = lookupElementStrings.contains("AbstractBar");
    TestCase.assertFalse(_string_3, _contains_2);
    String _string_4 = lookupElementStrings.toString();
    boolean _contains_3 = lookupElementStrings.contains("InterfaceBar");
    TestCase.assertFalse(_string_4, _contains_3);
  }
  
  public void testXTypeLiteral_Type() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("typeof(<caret>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String _string = _builder.toString();
    this.complete(_string);
    final List<String> lookupElementStrings = this.myFixture.getLookupElementStrings();
    String _string_1 = lookupElementStrings.toString();
    boolean _contains = lookupElementStrings.contains("ArrayList");
    TestCase.assertTrue(_string_1, _contains);
    String _string_2 = lookupElementStrings.toString();
    boolean _contains_1 = lookupElementStrings.contains("Foo");
    TestCase.assertTrue(_string_2, _contains_1);
  }
}
