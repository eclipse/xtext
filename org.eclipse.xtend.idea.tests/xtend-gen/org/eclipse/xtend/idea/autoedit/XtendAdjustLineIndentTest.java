/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.autoedit;

import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendAdjustLineIndentTest /* implements AbstractXbaseAdjustLineIndentTest  */{
  public XtendAdjustLineIndentTest() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method super(Object) is undefined"
      + "\nThe method or field XtendFileType is undefined"
      + "\nINSTANCE cannot be resolved");
  }
  
  @Override
  protected Object configureModule(final /* Module */Object module, final /* ModifiableRootModel */Object model, final /* ContentEntry */Object contentEntry) {
    throw new Error("Unresolved compilation problems:"
      + "\naddXtendLibrary cannot be resolved");
  }
  
  public void testXAssignment_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int a");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.a = 3");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("int a");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.a = 3");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString(), false);
  }
  
  public void testXAssignment_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int a");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.a");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("=");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("3");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("int a");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.a");
    _builder_1.newLine();
    _builder_1.append("\t\t\t\t");
    _builder_1.append("=");
    _builder_1.newLine();
    _builder_1.append("\t\t\t\t");
    _builder_1.append("3");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString(), false);
  }
  
  public void testXFeatureCall_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("values.head");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def java.util.List<String> values() { null }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("values.head");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def java.util.List<String> values() { null }");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString(), false);
  }
  
  public void testXFeatureCall_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("values");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(".");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("head");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def java.util.List<String> values() { null }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("values");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("head");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def java.util.List<String> values() { null }");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString(), false);
  }
  
  public void testXFeatureCall_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("values.get(0)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def java.util.List<String> values() { null }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("values.get(0)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def java.util.List<String> values() { null }");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString(), false);
  }
  
  public void testXFeatureCall_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("values.get(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("0");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def java.util.List<String> values() { null }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("values.get(");
    _builder_1.newLine();
    _builder_1.append("\t\t\t\t");
    _builder_1.append("0");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def java.util.List<String> values() { null }");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString(), false);
  }
  
  public void testXFeatureCall_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("values");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(".");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("get");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("0");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def java.util.List<String> values() { null }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("values");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("get");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t\t\t");
    _builder_1.append("0");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def java.util.List<String> values() { null }");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString(), false);
  }
  
  public void testXFeatureCall_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("values");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(".");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("get(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("0");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def java.util.List<String> values() { null }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("values");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("get(");
    _builder_1.newLine();
    _builder_1.append("\t\t\t\t");
    _builder_1.append("0");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def java.util.List<String> values() { null }");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString(), false);
  }
  
  public void testXConstructorCall_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("new");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString(), false);
  }
  
  public void testXConstructorCall_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Foo(0)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(int x) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("new Foo(0)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("new(int x) {}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString(), false);
  }
  
  public void testXConstructorCall_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Foo(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("0");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(int x) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("new Foo(");
    _builder_1.newLine();
    _builder_1.append("\t\t\t\t");
    _builder_1.append("0");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("new(int x) {}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString(), false);
  }
  
  public void testXConstructorCall_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Foo");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("0");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(int x) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("new");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t\t\t");
    _builder_1.append("0");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("new(int x) {}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString(), false);
  }
  
  public void testXConstructorCall_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Foo(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("0");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(int x) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("new");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Foo(");
    _builder_1.newLine();
    _builder_1.append("\t\t\t\t");
    _builder_1.append("0");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("new(int x) {}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString(), false);
  }
  
  protected void assertAdjustLineIndent(final CharSequence model, final String expectedAdjustedModel, final boolean wrap) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field super is undefined"
      + "\nThe method or field super is undefined"
      + "\nassertAdjustLineIndent cannot be resolved"
      + "\nassertAdjustLineIndent cannot be resolved");
  }
  
  @Override
  protected void assertAdjustLineIndent(final CharSequence model, final String expectedAdjustedModel) {
    this.assertAdjustLineIndent(model, expectedAdjustedModel, true);
  }
}
