/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.structureview;

import com.intellij.ide.structureView.StructureView;
import com.intellij.ide.structureView.impl.StructureViewComposite;
import com.intellij.ide.structureView.newStructureView.StructureViewComponent;
import org.eclipse.xtend.core.idea.structureview.SyntheticMemberFilter;
import org.eclipse.xtend.idea.structureview.AbstractOutlineTests;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmOutlineTests extends AbstractOutlineTests {
  @Override
  protected StructureViewComponent getStructureViewComponent(final StructureView structureView) {
    StructureViewComposite.StructureViewDescriptor[] _structureViews = ((StructureViewComposite) structureView).getStructureViews();
    StructureViewComposite.StructureViewDescriptor _last = IterableExtensions.<StructureViewComposite.StructureViewDescriptor>last(((Iterable<StructureViewComposite.StructureViewDescriptor>)Conversions.doWrapArray(_structureViews)));
    final Procedure1<StructureViewComponent> _function = new Procedure1<StructureViewComponent>() {
      @Override
      public void apply(final StructureViewComponent it) {
        it.setActionActive(SyntheticMemberFilter.ID, true);
      }
    };
    return ObjectExtensions.<StructureViewComponent>operator_doubleArrow(
      ((StructureViewComponent) _last.structureView), _function);
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
  
  @Test
  public void testDispatchMethod_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch foo(String x) {\'\'}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch foo(Object y) {\'\'}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch bar(String x) {\'\'}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch bar(Object y) {\'\'}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("aaa.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("_foo(String) : String");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("_foo(Object) : String");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("_bar(String) : String");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("_bar(Object) : String");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo(Object) : String");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("bar(Object) : String");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
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
  
  @Test
  @Ignore("TODO: org.eclipse.xtend.ide.tests.outline.JvmOutlineTests.testActiveAnnotation()")
  public void testActiveAnnotation() {
  }
}
