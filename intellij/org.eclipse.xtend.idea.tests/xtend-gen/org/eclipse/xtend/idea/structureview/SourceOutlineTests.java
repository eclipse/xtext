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
import com.intellij.util.Consumer;
import org.eclipse.xtend.idea.structureview.AbstractOutlineTests;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.structureview.AlphaSorter;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class SourceOutlineTests extends AbstractOutlineTests {
  @Override
  protected StructureViewComponent getStructureViewComponent(final StructureView structureView) {
    StructureViewComposite.StructureViewDescriptor[] _structureViews = ((StructureViewComposite) structureView).getStructureViews();
    StructureViewComposite.StructureViewDescriptor _head = IterableExtensions.<StructureViewComposite.StructureViewDescriptor>head(((Iterable<StructureViewComposite.StructureViewDescriptor>)Conversions.doWrapArray(_structureViews)));
    return ((StructureViewComponent) _head.structureView);
  }
  
  @Test
  public void testImport() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.lang.* class Foo {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("aaa.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("import declarations");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("java.lang.*");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  @Test
  public void testDispatchMethod_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo { def dispatch foo(String x) {\'\'} def dispatch foo(Object y) {\'\'} }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("aaa.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo(Object) : String");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("foo(String) : String");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("foo(Object) : String");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  @Test
  public void testDispatchMethod_2() {
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
    _builder_1.append("foo(Object) : String");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("foo(String) : String");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("foo(Object) : String");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("bar(Object) : String");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("bar(String) : String");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("bar(Object) : String");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  @Test
  public void testMixedeMethods_Order() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz() {null}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch foo(String x) {\'\'}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch bar(String x) {\'\'}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch bar(Object y) {\'\'}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch foo(Object y) {\'\'}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String fooBar");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void s() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static String ss");
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
    _builder_1.append("baz() : Object");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo(Object) : String");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("foo(String) : String");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("foo(Object) : String");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("bar(Object) : String");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("bar(String) : String");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("bar(Object) : String");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("fooBar : String");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("new()");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("s() : void");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("ss : String");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  @Test
  public void testMixmethods_Sorting() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.lang.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz() {null}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch foo(String x) {\'\'}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch bar(String x) {\'\'}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch bar(Object y) {\'\'}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch foo(Object y) {\'\'}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String fooBar");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void s() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static String ss");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Consumer<StructureViewComponent> _function = new Consumer<StructureViewComponent>() {
      @Override
      public void consume(final StructureViewComponent component) {
        component.setActionActive(AlphaSorter.ALPHA_SORTER_ID, true);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("aaa.xtend");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("test");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("import declarations");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("java.lang.*");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("Foo");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("ss : String");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("s() : void");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("fooBar : String");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("new()");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("bar(Object) : String");
        _builder.newLine();
        _builder.append("   ");
        _builder.append("bar(Object) : String");
        _builder.newLine();
        _builder.append("   ");
        _builder.append("bar(String) : String");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("foo(Object) : String");
        _builder.newLine();
        _builder.append("   ");
        _builder.append("foo(Object) : String");
        _builder.newLine();
        _builder.append("   ");
        _builder.append("foo(String) : String");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("baz() : Object");
        _builder.newLine();
        SourceOutlineTests.this.assertTreeStructure(component, _builder.toString());
      }
    };
    this.testStructureView(_builder.toString(), _function);
  }
}
