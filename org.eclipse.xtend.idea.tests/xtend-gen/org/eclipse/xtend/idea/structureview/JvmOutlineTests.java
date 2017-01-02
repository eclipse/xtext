/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.structureview;

import org.eclipse.xtend.idea.structureview.AbstractOutlineTests;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmOutlineTests extends AbstractOutlineTests {
  @Override
  protected StructureViewComponent getStructureViewComponent(final /* StructureView */Object structureView) {
    throw new Error("Unresolved compilation problems:"
      + "\nStructureViewComposite cannot be resolved to a type."
      + "\nStructureViewComponent cannot be resolved to a type."
      + "\nThe method setActionActive(Object, boolean) is undefined"
      + "\nThe method or field SyntheticMemberFilter is undefined"
      + "\nstructureViews cannot be resolved"
      + "\nlast cannot be resolved"
      + "\nstructureView cannot be resolved"
      + "\n=> cannot be resolved"
      + "\nID cannot be resolved");
  }
  
  @Override
  protected String getNestedTypesExpectation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aaa.xtend");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Foo");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Bar");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("Baz");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("FooBar");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("X");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("bar() : Object");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("foo : int");
    _builder.newLine();
    return _builder.toString();
  }
  
  @Override
  protected String getTypeParameter1Expectation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aaa.xtend");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Foo<T extends Object>");
    _builder.newLine();
    return _builder.toString();
  }
  
  /* @Test
   */public void testDispatchMethod_1() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The method testStructureView(Consumer) is not applicable for the arguments (CharSequence,String)"
      + "\nThe method testStructureView(Consumer) from the type AbstractOutlineTests refers to the missing type Consumer");
  }
  
  @Override
  protected String getOperatorDeclarationWithSymbolExpectation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aaa.xtend");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Foo");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("operator_not(Object) : String");
    _builder.newLine();
    return _builder.toString();
  }
  
  @Override
  protected String getOperatorDeclarationWithNameExpectation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aaa.xtend");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Foo");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("operator_not(Object) : String");
    _builder.newLine();
    return _builder.toString();
  }
  
  @Override
  protected String getDispatchMethodExpectation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aaa.xtend");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Foo");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("_foo(Object) : String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("_foo(String) : String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("foo(Object) : String");
    _builder.newLine();
    return _builder.toString();
  }
  
  @Override
  protected String getAnnotationTypeExpectation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aaa.xtend");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Foo");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("bar() : int");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("foo() : String");
    _builder.newLine();
    return _builder.toString();
  }
  
  @Override
  protected String getCreateExtensionInfoExpectation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aaa.xtend");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Foo");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("foo() : String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("_createCache_foo : HashMap<ArrayList<?>, String>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("_init_foo(String) : void");
    _builder.newLine();
    return _builder.toString();
  }
  
  @Override
  protected String getCreateExtensionInfo_dispatchExpectation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aaa.xtend");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Foo");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("_foo(Integer) : String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("_createCache_foo : HashMap<ArrayList<?>, String>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("_init_foo(String, Integer) : void");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("_foo(String) : String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("_createCache_foo_1 : HashMap<ArrayList<?>, String>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("_init_foo_1(String, String) : void");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("foo(Object) : String");
    _builder.newLine();
    return _builder.toString();
  }
  
  /* @Test
  @Ignore("TODO: org.eclipse.xtend.ide.tests.outline.JvmOutlineTests.testActiveAnnotation()")
   */public void testActiveAnnotation() {
  }
}
