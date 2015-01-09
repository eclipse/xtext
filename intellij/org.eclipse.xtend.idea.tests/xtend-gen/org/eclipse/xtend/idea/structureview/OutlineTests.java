/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.structureview;

import com.google.common.base.Objects;
import com.intellij.ide.structureView.StructureView;
import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.ide.structureView.impl.StructureViewComposite;
import com.intellij.ide.structureView.newStructureView.StructureViewComponent;
import com.intellij.ide.util.treeView.AbstractTreeStructure;
import com.intellij.lang.LanguageStructureViewBuilder;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.testFramework.PlatformTestUtil;
import com.intellij.util.Consumer;
import org.eclipse.xtend.core.idea.lang.XtendFileType;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.tests.LightToolingTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.jetbrains.annotations.NotNull;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class OutlineTests extends LightToolingTest {
  public OutlineTests() {
    super(XtendFileType.INSTANCE);
  }
  
  public void testSimpleClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testPackage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test class Foo {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("test");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testTypeParameter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo <T extends Object> {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo<T extends Object>");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testTypeParameter1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo <T> {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo<T>");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testField() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo { String bar }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("bar : String");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testConstructor() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo { new(int foo) {} }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("new(int)");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testSimpleMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo { def foo() {null} }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo() : Object");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testMethodWithParameter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo { def foo(int bar) {null} }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo(int) : Object");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testMethodWithParameters() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo { def foo(int bar, java.lang.Object x) {null} }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo(int, Object) : Object");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testMethodWithReturnType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo { def <T> foo() {null} }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo() <T extends Object> : Object");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testMethodWithTypeParameter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo { def <T> foo() {null} }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo() <T extends Object> : Object");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testMethodWithReturnTypeParameter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo { def <T> Foo<T> foo() {null} }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo() <T extends Object> : Foo<T>");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testOperatorDeclarationWithSymbol() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo { def java.lang.String !(Object o) {null} }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("!(Object) : String (operator_not)");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testOperatorDeclarationWithName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo { def java.lang.String operator_not(Object o) {null} }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("!(Object) : String (operator_not)");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testDispatchMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo { def dispatch foo(Object x) {\'\'} def dispatch foo(String y) {\'\'} }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo(Object) : String");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("foo(Object) : String");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("foo(String) : String");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testInterface() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface Foo { int bar def String foo() }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("bar : int");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo() : String");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testEnum() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum Foo { BAR, BAZ }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("BAR");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("BAZ");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testAnnotationType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME) annotation Foo { int bar String foo = \'\' }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("bar : int");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo : String");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testAnnotationTypeNoMembers() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME) annotation Foo { }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testInterfaceNoMembers() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@SuppressWarnings(\'foo\') interface Foo { }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testCreateExtensionInfo() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo { def create \'lalala\' foo() {} }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo() : String");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testCreateExtensionInfo_dispatch() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {  dispatch def create value : \'bar\' foo(Integer it) {}  dispatch def create value : \'foo\' foo(String it) {} }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo(Object) : String");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("foo(Integer) : String");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("foo(String) : String");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testNestedTypes() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo { int foo static class Bar { def bar() {} interface Baz {} enum FooBar{ X } } }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo : int");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("Bar");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("bar() : Object");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("Baz");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("FooBar");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testAnonymousTypes() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo<T extends Object> { def Foo<String> bar() { new Foo<String>() { override bar() { } } } }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Foo.xtend");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("Foo<T extends Object>");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("bar() : Foo<String>");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("new Foo<String>() {...}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("bar() : Foo<String>");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  protected void testStructureView(final String model, final String expected) {
    this.myFixture.configureByText("Foo.xtend", model);
    this.testStructureView(expected);
  }
  
  protected void testStructureView(final String expected) {
    final Consumer<StructureViewComponent> _function = new Consumer<StructureViewComponent>() {
      public void consume(final StructureViewComponent component) {
        AbstractTreeStructure _treeStructure = component.getTreeStructure();
        PlatformTestUtil.assertTreeStructureEquals(_treeStructure, expected);
      }
    };
    this.testStructureView(_function);
  }
  
  public void testStructureView(@NotNull final Consumer<StructureViewComponent> consumer) {
    try {
      PsiFile _file = this.myFixture.getFile();
      final VirtualFile myFile = _file.getVirtualFile();
      boolean _notEquals = (!Objects.equal(myFile, null));
      boolean _not = (!_notEquals);
      if (_not) {
        throw new AssertionError("configure first");
      }
      Project _project = this.getProject();
      FileEditorManager _instance = FileEditorManager.getInstance(_project);
      final FileEditor fileEditor = _instance.getSelectedEditor(myFile);
      boolean _equals = Objects.equal(fileEditor, null);
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("editor not opened for ");
        _builder.append(myFile, "");
        throw new AssertionError(_builder);
      }
      PsiFile _file_1 = this.myFixture.getFile();
      final StructureViewBuilder builder = LanguageStructureViewBuilder.INSTANCE.getStructureViewBuilder(_file_1);
      boolean _equals_1 = Objects.equal(builder, null);
      if (_equals_1) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("no builder for ");
        _builder_1.append(myFile, "");
        throw new AssertionError(_builder_1);
      }
      StructureViewComponent component = null;
      try {
        StructureViewComponent _switchResult = null;
        Project _project_1 = this.getProject();
        StructureView _createStructureView = builder.createStructureView(fileEditor, _project_1);
        final StructureView structureView = _createStructureView;
        boolean _matched = false;
        if (!_matched) {
          if (structureView instanceof StructureViewComponent) {
            _matched=true;
            _switchResult = ((StructureViewComponent)structureView);
          }
        }
        if (!_matched) {
          if (structureView instanceof StructureViewComposite) {
            _matched=true;
            StructureView _selectedStructureView = ((StructureViewComposite)structureView).getSelectedStructureView();
            _switchResult = ((StructureViewComponent) _selectedStructureView);
          }
        }
        component = _switchResult;
        consumer.consume(component);
      } finally {
        boolean _notEquals_1 = (!Objects.equal(component, null));
        if (_notEquals_1) {
          Disposer.dispose(component);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
