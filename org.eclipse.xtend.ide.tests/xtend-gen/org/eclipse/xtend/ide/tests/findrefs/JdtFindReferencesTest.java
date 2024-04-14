/**
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.findrefs;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.Match;
import org.eclipse.search.ui.text.MatchEvent;
import org.eclipse.search.ui.text.MatchFilter;
import org.eclipse.search.ui.text.RemoveAllEvent;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JdtReferenceFinder;
import org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelFindReferenceHandler;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class JdtFindReferencesTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper _workbenchTestHelper;

  @Inject
  @Extension
  private JdtReferenceFinder _jdtReferenceFinder;

  @Inject
  private IWorkbench workbench;

  @Inject
  @Extension
  private JvmModelFindReferenceHandler _jvmModelFindReferenceHandler;

  @Before
  @After
  public void cleanup() {
    try {
      this._workbenchTestHelper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFindClassRef() {
    try {
      Assert.assertTrue(this._workbenchTestHelper.createFile("Xtend.xtend", "class Xtend { }").exists());
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class JavaRef {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private Xtend x;");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Xtend foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return null;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Xtend();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void baz() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Xtend y;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Assert.assertTrue(this._workbenchTestHelper.createFile("JavaRef.java", _builder.toString()).exists());
      IResourcesSetupUtil.waitForBuild();
      Assert.assertNotNull("Couldn\'t find \'src/Xtend.xtend\'.", this._workbenchTestHelper.getProject().findMember("/src/Xtend.xtend"));
      Assert.assertNotNull("Couldn\'t find \'src/JavaRef.java\'.", this._workbenchTestHelper.getProject().findMember("/src/JavaRef.java"));
      final IResource member = this._workbenchTestHelper.getProject().findMember("/xtend-gen/Xtend.java");
      if ((member == null)) {
        Assert.assertNotNull("Couldn\'t find \'xtend-gen/Xtend.java\'.", member);
      }
      IType type = JavaCore.create(this._workbenchTestHelper.getProject()).findType("Xtend");
      if ((type == null)) {
        Assert.assertNotNull("Couldn\'t find type \'Xtend\'.", type);
      }
      final IMethod constructor = type.getMethod("Xtend", ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList(), String.class)));
      ArrayList<Object> _findReferences = this.findReferences(type, constructor);
      final Procedure1<ArrayList<Object>> _function = (ArrayList<Object> it) -> {
        Assert.assertEquals(4, it.size());
        final Function1<IField, Boolean> _function_1 = (IField it_1) -> {
          String _elementName = it_1.getElementName();
          return Boolean.valueOf(Objects.equals(_elementName, "x"));
        };
        Assert.assertTrue(IterableExtensions.<IField>exists(Iterables.<IField>filter(it, IField.class), _function_1));
        final Function1<IMethod, Boolean> _function_2 = (IMethod it_1) -> {
          String _elementName = it_1.getElementName();
          return Boolean.valueOf(Objects.equals(_elementName, "foo"));
        };
        Assert.assertTrue(IterableExtensions.<IMethod>exists(Iterables.<IMethod>filter(it, IMethod.class), _function_2));
        final Function1<IMethod, Boolean> _function_3 = (IMethod it_1) -> {
          String _elementName = it_1.getElementName();
          return Boolean.valueOf(Objects.equals(_elementName, "bar"));
        };
        Assert.assertTrue(IterableExtensions.<IMethod>exists(Iterables.<IMethod>filter(it, IMethod.class), _function_3));
        final Function1<IMethod, Boolean> _function_4 = (IMethod it_1) -> {
          String _elementName = it_1.getElementName();
          return Boolean.valueOf(Objects.equals(_elementName, "baz"));
        };
        Assert.assertTrue(IterableExtensions.<IMethod>exists(Iterables.<IMethod>filter(it, IMethod.class), _function_4));
      };
      ObjectExtensions.<ArrayList<Object>>operator_doubleArrow(_findReferences, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFindMethodRef() {
    try {
      this._workbenchTestHelper.createFile("Xtend.xtend", "class Xtend { def foo() { 0 }}");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class JavaRef {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private Xtend x = new Xtend();");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private int y = x.foo();");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public int bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return x.foo();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._workbenchTestHelper.createFile("JavaRef.java", _builder.toString());
      IResourcesSetupUtil.waitForBuild();
      final IType type = JavaCore.create(this._workbenchTestHelper.getProject()).findType("Xtend");
      final IMethod method = type.getMethod("foo", ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList(), String.class)));
      ArrayList<Object> _findReferences = this.findReferences(method);
      final Procedure1<ArrayList<Object>> _function = (ArrayList<Object> it) -> {
        Assert.assertEquals(2, it.size());
        final Function1<Object, Boolean> _function_1 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IField) && Objects.equals(((IField) it_1).getElementName(), "y")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_1));
        final Function1<Object, Boolean> _function_2 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "bar")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_2));
      };
      ObjectExtensions.<ArrayList<Object>>operator_doubleArrow(_findReferences, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFindFieldRef() {
    try {
      this._workbenchTestHelper.createFile("Xtend.xtend", "class Xtend { public int foo = 0 }");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class JavaRef extends Xtend {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private int bar = foo;");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public int baz() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return foo;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void fooBar_0() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return new Xtend().foo;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void fooBar_1() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return new JavaRef().foo;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._workbenchTestHelper.createFile("JavaRef.java", _builder.toString());
      IResourcesSetupUtil.waitForBuild();
      final IType type = JavaCore.create(this._workbenchTestHelper.getProject()).findType("Xtend");
      final IField field = type.getField("foo");
      ArrayList<Object> _findReferences = this.findReferences(field);
      final Procedure1<ArrayList<Object>> _function = (ArrayList<Object> it) -> {
        Assert.assertEquals(4, it.size());
        final Function1<Object, Boolean> _function_1 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IField) && Objects.equals(((IField) it_1).getElementName(), "bar")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_1));
        final Function1<Object, Boolean> _function_2 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "baz")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_2));
        final Function1<Object, Boolean> _function_3 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "fooBar_0")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_3));
        final Function1<Object, Boolean> _function_4 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "fooBar_1")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_4));
      };
      ObjectExtensions.<ArrayList<Object>>operator_doubleArrow(_findReferences, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFindPropertyRef() {
    try {
      this._workbenchTestHelper.createFile("Xtend.xtend", "class Xtend { @Property public int foo = 0 }");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class JavaRef {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private Xtend x = new Xtend();");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private int bar = x.getFoo();");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void baz() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("x.setFoo(1);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public int fooBar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return x._foo;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._workbenchTestHelper.createFile("JavaRef.java", _builder.toString());
      IResourcesSetupUtil.waitForBuild();
      final IType type = JavaCore.create(this._workbenchTestHelper.getProject()).findType("Xtend");
      final IField field = type.getField("_foo");
      final IMethod getter = type.getMethod("getFoo", ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList(), String.class)));
      final IMethod setter = type.getMethod("setFoo", ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList("I"), String.class)));
      ArrayList<Object> _findReferences = this.findReferences(field, getter, setter);
      final Procedure1<ArrayList<Object>> _function = (ArrayList<Object> it) -> {
        Assert.assertEquals(5, it.size());
        final Function1<Object, Boolean> _function_1 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IField) && Objects.equals(((IField) it_1).getElementName(), "bar")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_1));
        final Function1<Object, Boolean> _function_2 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "baz")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_2));
        final Function1<Object, Boolean> _function_3 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "fooBar")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_3));
        final Function1<Object, Boolean> _function_4 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "getFoo")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_4));
        final Function1<Object, Boolean> _function_5 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "setFoo")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_5));
      };
      ObjectExtensions.<ArrayList<Object>>operator_doubleArrow(_findReferences, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDispatchMethodRef() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Xtend { ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def dispatch foo(String x) {}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def dispatch foo(Number x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._workbenchTestHelper.createFile("Xtend.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public class JavaRef {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("private Xtend x = new Xtend();");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void foo_1() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("x._foo(\"\");");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void bar() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("x._foo(1);");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void baz() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("x.foo(null);");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._workbenchTestHelper.createFile("JavaRef.java", _builder_1.toString());
      IResourcesSetupUtil.waitForBuild();
      final IType type = JavaCore.create(this._workbenchTestHelper.getProject()).findType("Xtend");
      final IMethod dispatcher = type.getMethod("foo", ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList("QSerializable;"), String.class)));
      Assert.assertTrue(dispatcher.exists());
      final IMethod caseMethod = type.getMethod("_foo", ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList("QString;"), String.class)));
      Assert.assertTrue(caseMethod.exists());
      ArrayList<Object> _findReferences = this.findReferences(dispatcher, caseMethod);
      final Procedure1<ArrayList<Object>> _function = (ArrayList<Object> it) -> {
        Assert.assertEquals(3, it.size());
        final Function1<Object, Boolean> _function_1 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "foo_1")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_1));
        final Function1<Object, Boolean> _function_2 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "baz")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_2));
        final Function1<Object, Boolean> _function_3 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "foo")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_3));
      };
      ObjectExtensions.<ArrayList<Object>>operator_doubleArrow(_findReferences, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJavaClassRef() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Xtend { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Java foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def Java bar() { ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void baz() { ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Java()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._workbenchTestHelper.createFile("Xtend.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public class Java {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._workbenchTestHelper.createFile("Java.java", _builder_1.toString());
      IResourcesSetupUtil.waitForBuild();
      final IType javaType = JavaCore.create(this._workbenchTestHelper.getProject()).findType("Java");
      ArrayList<Object> _findReferences = this.findReferences(javaType);
      final Procedure1<ArrayList<Object>> _function = (ArrayList<Object> it) -> {
        Assert.assertEquals(3, it.size());
        final Function1<Object, Boolean> _function_1 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IField) && Objects.equals(((IField) it_1).getElementName(), "foo")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_1));
        final Function1<Object, Boolean> _function_2 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "bar")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_2));
        final Function1<Object, Boolean> _function_3 = (Object it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "baz")));
        };
        Assert.assertTrue(IterableExtensions.<Object>exists(it, _function_3));
      };
      ObjectExtensions.<ArrayList<Object>>operator_doubleArrow(_findReferences, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testClassJavaElements() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Xtend {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendTypeDeclaration clazz = IterableExtensions.<XtendTypeDeclaration>head(this._workbenchTestHelper.xtendFile("Xtend.xtend", _builder.toString()).getXtendTypes());
      IResourcesSetupUtil.waitForBuild();
      Iterable<IJavaElement> _javaElements = this._jvmModelFindReferenceHandler.getJavaElements(clazz);
      final Procedure1<Iterable<IJavaElement>> _function = (Iterable<IJavaElement> it) -> {
        Assert.assertEquals(1, IterableExtensions.size(it));
        final Function1<IJavaElement, Boolean> _function_1 = (IJavaElement it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IType) && Objects.equals(((IType) it_1).getElementName(), "Xtend")));
        };
        Assert.assertTrue(IterableExtensions.<IJavaElement>exists(it, _function_1));
      };
      ObjectExtensions.<Iterable<IJavaElement>>operator_doubleArrow(_javaElements, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMethodJavaElements() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Xtend {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendMember method = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(this._workbenchTestHelper.xtendFile("Xtend.xtend", _builder.toString()).getXtendTypes(), XtendClass.class)).getMembers());
      IResourcesSetupUtil.waitForBuild();
      Iterable<IJavaElement> _javaElements = this._jvmModelFindReferenceHandler.getJavaElements(method);
      final Procedure1<Iterable<IJavaElement>> _function = (Iterable<IJavaElement> it) -> {
        Assert.assertEquals(1, IterableExtensions.size(it));
        final Function1<IJavaElement, Boolean> _function_1 = (IJavaElement it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "foo")));
        };
        Assert.assertTrue(IterableExtensions.<IJavaElement>exists(it, _function_1));
      };
      ObjectExtensions.<Iterable<IJavaElement>>operator_doubleArrow(_javaElements, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFieldJavaElements() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Xtend {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendMember field = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(this._workbenchTestHelper.xtendFile("Xtend.xtend", _builder.toString()).getXtendTypes(), XtendClass.class)).getMembers());
      IResourcesSetupUtil.waitForBuild();
      Iterable<IJavaElement> _javaElements = this._jvmModelFindReferenceHandler.getJavaElements(field);
      final Procedure1<Iterable<IJavaElement>> _function = (Iterable<IJavaElement> it) -> {
        Assert.assertEquals(1, IterableExtensions.size(it));
        final Function1<IJavaElement, Boolean> _function_1 = (IJavaElement it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IField) && Objects.equals(((IField) it_1).getElementName(), "foo")));
        };
        Assert.assertTrue(IterableExtensions.<IJavaElement>exists(it, _function_1));
      };
      ObjectExtensions.<Iterable<IJavaElement>>operator_doubleArrow(_javaElements, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testPropertyJavaElements() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Xtend {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Property int foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendMember field = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(this._workbenchTestHelper.xtendFile("Xtend.xtend", _builder.toString()).getXtendTypes(), XtendClass.class)).getMembers());
      IResourcesSetupUtil.waitForBuild();
      Iterable<IJavaElement> _javaElements = this._jvmModelFindReferenceHandler.getJavaElements(field);
      final Procedure1<Iterable<IJavaElement>> _function = (Iterable<IJavaElement> it) -> {
        Assert.assertEquals(3, IterableExtensions.size(it));
        final Function1<IJavaElement, Boolean> _function_1 = (IJavaElement it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "getFoo")));
        };
        Assert.assertTrue(IterableExtensions.<IJavaElement>exists(it, _function_1));
        final Function1<IJavaElement, Boolean> _function_2 = (IJavaElement it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "setFoo")));
        };
        Assert.assertTrue(IterableExtensions.<IJavaElement>exists(it, _function_2));
        final Function1<IJavaElement, Boolean> _function_3 = (IJavaElement it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IField) && Objects.equals(((IField) it_1).getElementName(), "_foo")));
        };
        Assert.assertTrue(IterableExtensions.<IJavaElement>exists(it, _function_3));
      };
      ObjectExtensions.<Iterable<IJavaElement>>operator_doubleArrow(_javaElements, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDispatchMethodJavaElements() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Xtend {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(String x) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Number x) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendMember method = IterableExtensions.<XtendMember>head(IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(this._workbenchTestHelper.xtendFile("Xtend.xtend", _builder.toString()).getXtendTypes(), XtendClass.class)).getMembers());
      IResourcesSetupUtil.waitForBuild();
      Iterable<IJavaElement> _javaElements = this._jvmModelFindReferenceHandler.getJavaElements(method);
      final Procedure1<Iterable<IJavaElement>> _function = (Iterable<IJavaElement> it) -> {
        Assert.assertEquals(2, IterableExtensions.size(it));
        final Function1<IJavaElement, Boolean> _function_1 = (IJavaElement it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "_foo")));
        };
        Assert.assertTrue(IterableExtensions.<IJavaElement>exists(it, _function_1));
        final Function1<IJavaElement, Boolean> _function_2 = (IJavaElement it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "foo")));
        };
        Assert.assertTrue(IterableExtensions.<IJavaElement>exists(it, _function_2));
      };
      ObjectExtensions.<Iterable<IJavaElement>>operator_doubleArrow(_javaElements, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public ArrayList<Object> findReferences(final IJavaElement... targets) {
    try {
      ArrayList<Object> _xblockexpression = null;
      {
        final ISearchQuery query = this._jdtReferenceFinder.createCompositeQuery("test", CollectionLiterals.<IJavaElement>newArrayList(targets));
        final ArrayList<SearchResultEvent> events = CollectionLiterals.<SearchResultEvent>newArrayList();
        final ArrayList<Object> elements = CollectionLiterals.<Object>newArrayList();
        final ISearchResult searchResult = query.getSearchResult();
        final MatchFilter[] filters = ((AbstractTextSearchResult) searchResult).getActiveMatchFilters();
        final ISearchResultListener _function = (SearchResultEvent it) -> {
          events.add(it);
          if ((it instanceof MatchEvent)) {
            final Function1<Match, Boolean> _function_1 = (Match m) -> {
              final Function1<MatchFilter, Boolean> _function_2 = (MatchFilter it_1) -> {
                boolean _filters = it_1.filters(m);
                return Boolean.valueOf((!_filters));
              };
              return Boolean.valueOf(IterableExtensions.<MatchFilter>forall(((Iterable<MatchFilter>)Conversions.doWrapArray(filters)), _function_2));
            };
            final Iterable<Match> matches = IterableExtensions.<Match>filter(((Iterable<Match>)Conversions.doWrapArray(((MatchEvent)it).getMatches())), _function_1);
            int _kind = ((MatchEvent)it).getKind();
            boolean _equals = (_kind == MatchEvent.ADDED);
            if (_equals) {
              final Consumer<Match> _function_2 = (Match it_1) -> {
                Object _element = it_1.getElement();
                elements.add(_element);
              };
              matches.forEach(_function_2);
            } else {
              final Consumer<Match> _function_3 = (Match it_1) -> {
                elements.remove(it_1.getElement());
              };
              matches.forEach(_function_3);
            }
          }
        };
        searchResult.addListener(_function);
        NewSearchUI.runQueryInForeground(this.workbench.getActiveWorkbenchWindow(), query);
        SearchResultEvent _head = IterableExtensions.<SearchResultEvent>head(events);
        Assert.assertTrue((_head instanceof RemoveAllEvent));
        Iterable<SearchResultEvent> _tail = IterableExtensions.<SearchResultEvent>tail(events);
        for (final SearchResultEvent event : _tail) {
          Assert.assertTrue((event instanceof MatchEvent));
        }
        _xblockexpression = elements;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testBug387230() {
    try {
      final XtendClass cls = IterableExtensions.<XtendClass>head(Iterables.<XtendClass>filter(this._workbenchTestHelper.xtendFile("Xtend.xtend", "@Data class Xtend { String field }").getXtendTypes(), XtendClass.class));
      IResourcesSetupUtil.waitForBuild();
      Iterable<IJavaElement> _javaElements = this._jvmModelFindReferenceHandler.getJavaElements(cls);
      final Procedure1<Iterable<IJavaElement>> _function = (Iterable<IJavaElement> it) -> {
        Assert.assertEquals(2, IterableExtensions.size(it));
        final Function1<IJavaElement, Boolean> _function_1 = (IJavaElement it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IType) && Objects.equals(((IType) it_1).getElementName(), "Xtend")));
        };
        Assert.assertTrue(IterableExtensions.<IJavaElement>exists(it, _function_1));
        final Function1<IJavaElement, Boolean> _function_2 = (IJavaElement it_1) -> {
          return Boolean.valueOf(((it_1 instanceof IMethod) && Objects.equals(((IMethod) it_1).getElementName(), "Xtend")));
        };
        Assert.assertTrue(IterableExtensions.<IJavaElement>exists(it, _function_2));
      };
      ObjectExtensions.<Iterable<IJavaElement>>operator_doubleArrow(_javaElements, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
