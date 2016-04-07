/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.findrefs;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.search.SearchUtil;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.Match;
import org.eclipse.search.ui.text.MatchEvent;
import org.eclipse.search.ui.text.MatchFilter;
import org.eclipse.search.ui.text.RemoveAllEvent;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
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
      IFile _createFile = this._workbenchTestHelper.createFile("Xtend.xtend", "class Xtend { }");
      boolean _exists = _createFile.exists();
      Assert.assertTrue(_exists);
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
      String _string = _builder.toString();
      IFile _createFile_1 = this._workbenchTestHelper.createFile("JavaRef.java", _string);
      boolean _exists_1 = _createFile_1.exists();
      Assert.assertTrue(_exists_1);
      IResourcesSetupUtil.waitForBuild();
      IProject _project = this._workbenchTestHelper.getProject();
      IResource _findMember = _project.findMember("/src/Xtend.xtend");
      Assert.assertNotNull("Couldn\'t find \'src/Xtend.xtend\'.", _findMember);
      IProject _project_1 = this._workbenchTestHelper.getProject();
      IResource _findMember_1 = _project_1.findMember("/src/JavaRef.java");
      Assert.assertNotNull("Couldn\'t find \'src/JavaRef.java\'.", _findMember_1);
      IProject _project_2 = this._workbenchTestHelper.getProject();
      final IResource member = _project_2.findMember("/xtend-gen/Xtend.java");
      boolean _equals = Objects.equal(member, null);
      if (_equals) {
        Assert.assertNotNull("Couldn\'t find \'xtend-gen/Xtend.java\'.", member);
      }
      IProject _project_3 = this._workbenchTestHelper.getProject();
      IJavaProject _create = JavaCore.create(_project_3);
      IType type = _create.findType("Xtend");
      boolean _equals_1 = Objects.equal(type, null);
      if (_equals_1) {
        Assert.assertNotNull("Couldn\'t find type \'Xtend\'.", type);
      }
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
      final IMethod constructor = type.getMethod("Xtend", ((String[])Conversions.unwrapArray(_newArrayList, String.class)));
      ArrayList<Object> _findReferences = this.findReferences(type, constructor);
      final Procedure1<ArrayList<Object>> _function = new Procedure1<ArrayList<Object>>() {
        @Override
        public void apply(final ArrayList<Object> it) {
          int _size = it.size();
          Assert.assertEquals(4, _size);
          Iterable<IField> _filter = Iterables.<IField>filter(it, IField.class);
          final Function1<IField, Boolean> _function = new Function1<IField, Boolean>() {
            @Override
            public Boolean apply(final IField it) {
              String _elementName = it.getElementName();
              return Boolean.valueOf(Objects.equal(_elementName, "x"));
            }
          };
          boolean _exists = IterableExtensions.<IField>exists(_filter, _function);
          Assert.assertTrue(_exists);
          Iterable<IMethod> _filter_1 = Iterables.<IMethod>filter(it, IMethod.class);
          final Function1<IMethod, Boolean> _function_1 = new Function1<IMethod, Boolean>() {
            @Override
            public Boolean apply(final IMethod it) {
              String _elementName = it.getElementName();
              return Boolean.valueOf(Objects.equal(_elementName, "foo"));
            }
          };
          boolean _exists_1 = IterableExtensions.<IMethod>exists(_filter_1, _function_1);
          Assert.assertTrue(_exists_1);
          Iterable<IMethod> _filter_2 = Iterables.<IMethod>filter(it, IMethod.class);
          final Function1<IMethod, Boolean> _function_2 = new Function1<IMethod, Boolean>() {
            @Override
            public Boolean apply(final IMethod it) {
              String _elementName = it.getElementName();
              return Boolean.valueOf(Objects.equal(_elementName, "bar"));
            }
          };
          boolean _exists_2 = IterableExtensions.<IMethod>exists(_filter_2, _function_2);
          Assert.assertTrue(_exists_2);
          Iterable<IMethod> _filter_3 = Iterables.<IMethod>filter(it, IMethod.class);
          final Function1<IMethod, Boolean> _function_3 = new Function1<IMethod, Boolean>() {
            @Override
            public Boolean apply(final IMethod it) {
              String _elementName = it.getElementName();
              return Boolean.valueOf(Objects.equal(_elementName, "baz"));
            }
          };
          boolean _exists_3 = IterableExtensions.<IMethod>exists(_filter_3, _function_3);
          Assert.assertTrue(_exists_3);
        }
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
      String _string = _builder.toString();
      this._workbenchTestHelper.createFile("JavaRef.java", _string);
      IResourcesSetupUtil.waitForBuild();
      IProject _project = this._workbenchTestHelper.getProject();
      IJavaProject _create = JavaCore.create(_project);
      final IType type = _create.findType("Xtend");
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
      final IMethod method = type.getMethod("foo", ((String[])Conversions.unwrapArray(_newArrayList, String.class)));
      ArrayList<Object> _findReferences = this.findReferences(method);
      final Procedure1<ArrayList<Object>> _function = new Procedure1<ArrayList<Object>>() {
        @Override
        public void apply(final ArrayList<Object> it) {
          int _size = it.size();
          Assert.assertEquals(2, _size);
          final Function1<Object, Boolean> _function = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IField)) {
                _and = false;
              } else {
                String _elementName = ((IField) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "y");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists = IterableExtensions.<Object>exists(it, _function);
          Assert.assertTrue(_exists);
          final Function1<Object, Boolean> _function_1 = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "bar");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_1 = IterableExtensions.<Object>exists(it, _function_1);
          Assert.assertTrue(_exists_1);
        }
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
      String _string = _builder.toString();
      this._workbenchTestHelper.createFile("JavaRef.java", _string);
      IResourcesSetupUtil.waitForBuild();
      IProject _project = this._workbenchTestHelper.getProject();
      IJavaProject _create = JavaCore.create(_project);
      final IType type = _create.findType("Xtend");
      final IField field = type.getField("foo");
      ArrayList<Object> _findReferences = this.findReferences(field);
      final Procedure1<ArrayList<Object>> _function = new Procedure1<ArrayList<Object>>() {
        @Override
        public void apply(final ArrayList<Object> it) {
          int _size = it.size();
          Assert.assertEquals(4, _size);
          final Function1<Object, Boolean> _function = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IField)) {
                _and = false;
              } else {
                String _elementName = ((IField) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "bar");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists = IterableExtensions.<Object>exists(it, _function);
          Assert.assertTrue(_exists);
          final Function1<Object, Boolean> _function_1 = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "baz");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_1 = IterableExtensions.<Object>exists(it, _function_1);
          Assert.assertTrue(_exists_1);
          final Function1<Object, Boolean> _function_2 = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "fooBar_0");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_2 = IterableExtensions.<Object>exists(it, _function_2);
          Assert.assertTrue(_exists_2);
          final Function1<Object, Boolean> _function_3 = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "fooBar_1");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_3 = IterableExtensions.<Object>exists(it, _function_3);
          Assert.assertTrue(_exists_3);
        }
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
      String _string = _builder.toString();
      this._workbenchTestHelper.createFile("JavaRef.java", _string);
      IResourcesSetupUtil.waitForBuild();
      IProject _project = this._workbenchTestHelper.getProject();
      IJavaProject _create = JavaCore.create(_project);
      final IType type = _create.findType("Xtend");
      final IField field = type.getField("_foo");
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
      final IMethod getter = type.getMethod("getFoo", ((String[])Conversions.unwrapArray(_newArrayList, String.class)));
      ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList("I");
      final IMethod setter = type.getMethod("setFoo", ((String[])Conversions.unwrapArray(_newArrayList_1, String.class)));
      ArrayList<Object> _findReferences = this.findReferences(field, getter, setter);
      final Procedure1<ArrayList<Object>> _function = new Procedure1<ArrayList<Object>>() {
        @Override
        public void apply(final ArrayList<Object> it) {
          int _size = it.size();
          Assert.assertEquals(5, _size);
          final Function1<Object, Boolean> _function = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IField)) {
                _and = false;
              } else {
                String _elementName = ((IField) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "bar");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists = IterableExtensions.<Object>exists(it, _function);
          Assert.assertTrue(_exists);
          final Function1<Object, Boolean> _function_1 = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "baz");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_1 = IterableExtensions.<Object>exists(it, _function_1);
          Assert.assertTrue(_exists_1);
          final Function1<Object, Boolean> _function_2 = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "fooBar");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_2 = IterableExtensions.<Object>exists(it, _function_2);
          Assert.assertTrue(_exists_2);
          final Function1<Object, Boolean> _function_3 = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "getFoo");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_3 = IterableExtensions.<Object>exists(it, _function_3);
          Assert.assertTrue(_exists_3);
          final Function1<Object, Boolean> _function_4 = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "setFoo");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_4 = IterableExtensions.<Object>exists(it, _function_4);
          Assert.assertTrue(_exists_4);
        }
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
      String _string = _builder.toString();
      this._workbenchTestHelper.createFile("Xtend.xtend", _string);
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
      String _string_1 = _builder_1.toString();
      this._workbenchTestHelper.createFile("JavaRef.java", _string_1);
      IResourcesSetupUtil.waitForBuild();
      IProject _project = this._workbenchTestHelper.getProject();
      IJavaProject _create = JavaCore.create(_project);
      final IType type = _create.findType("Xtend");
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("QSerializable;");
      final IMethod dispatcher = type.getMethod("foo", ((String[])Conversions.unwrapArray(_newArrayList, String.class)));
      boolean _exists = dispatcher.exists();
      Assert.assertTrue(_exists);
      ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList("QString;");
      final IMethod caseMethod = type.getMethod("_foo", ((String[])Conversions.unwrapArray(_newArrayList_1, String.class)));
      boolean _exists_1 = caseMethod.exists();
      Assert.assertTrue(_exists_1);
      ArrayList<Object> _findReferences = this.findReferences(dispatcher, caseMethod);
      final Procedure1<ArrayList<Object>> _function = new Procedure1<ArrayList<Object>>() {
        @Override
        public void apply(final ArrayList<Object> it) {
          int _size = it.size();
          Assert.assertEquals(3, _size);
          final Function1<Object, Boolean> _function = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "foo_1");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists = IterableExtensions.<Object>exists(it, _function);
          Assert.assertTrue(_exists);
          final Function1<Object, Boolean> _function_1 = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "baz");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_1 = IterableExtensions.<Object>exists(it, _function_1);
          Assert.assertTrue(_exists_1);
          final Function1<Object, Boolean> _function_2 = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "foo");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_2 = IterableExtensions.<Object>exists(it, _function_2);
          Assert.assertTrue(_exists_2);
        }
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
      String _string = _builder.toString();
      this._workbenchTestHelper.createFile("Xtend.xtend", _string);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public class Java {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      String _string_1 = _builder_1.toString();
      this._workbenchTestHelper.createFile("Java.java", _string_1);
      IResourcesSetupUtil.waitForBuild();
      IProject _project = this._workbenchTestHelper.getProject();
      IJavaProject _create = JavaCore.create(_project);
      final IType javaType = _create.findType("Java");
      ArrayList<Object> _findReferences = this.findReferences(javaType);
      final Procedure1<ArrayList<Object>> _function = new Procedure1<ArrayList<Object>>() {
        @Override
        public void apply(final ArrayList<Object> it) {
          int _size = it.size();
          Assert.assertEquals(3, _size);
          final Function1<Object, Boolean> _function = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IField)) {
                _and = false;
              } else {
                String _elementName = ((IField) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "foo");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists = IterableExtensions.<Object>exists(it, _function);
          Assert.assertTrue(_exists);
          final Function1<Object, Boolean> _function_1 = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "bar");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_1 = IterableExtensions.<Object>exists(it, _function_1);
          Assert.assertTrue(_exists_1);
          final Function1<Object, Boolean> _function_2 = new Function1<Object, Boolean>() {
            @Override
            public Boolean apply(final Object it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "baz");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_2 = IterableExtensions.<Object>exists(it, _function_2);
          Assert.assertTrue(_exists_2);
        }
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
      String _string = _builder.toString();
      XtendFile _xtendFile = this._workbenchTestHelper.xtendFile("Xtend.xtend", _string);
      EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
      final XtendTypeDeclaration clazz = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      IResourcesSetupUtil.waitForBuild();
      Iterable<IJavaElement> _javaElements = this._jvmModelFindReferenceHandler.getJavaElements(clazz);
      final Procedure1<Iterable<IJavaElement>> _function = new Procedure1<Iterable<IJavaElement>>() {
        @Override
        public void apply(final Iterable<IJavaElement> it) {
          int _size = IterableExtensions.size(it);
          Assert.assertEquals(1, _size);
          final Function1<IJavaElement, Boolean> _function = new Function1<IJavaElement, Boolean>() {
            @Override
            public Boolean apply(final IJavaElement it) {
              boolean _and = false;
              if (!(it instanceof IType)) {
                _and = false;
              } else {
                String _elementName = ((IType) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "Xtend");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists = IterableExtensions.<IJavaElement>exists(it, _function);
          Assert.assertTrue(_exists);
        }
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
      String _string = _builder.toString();
      XtendFile _xtendFile = this._workbenchTestHelper.xtendFile("Xtend.xtend", _string);
      EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      final XtendMember method = IterableExtensions.<XtendMember>head(_members);
      IResourcesSetupUtil.waitForBuild();
      Iterable<IJavaElement> _javaElements = this._jvmModelFindReferenceHandler.getJavaElements(method);
      final Procedure1<Iterable<IJavaElement>> _function = new Procedure1<Iterable<IJavaElement>>() {
        @Override
        public void apply(final Iterable<IJavaElement> it) {
          int _size = IterableExtensions.size(it);
          Assert.assertEquals(1, _size);
          final Function1<IJavaElement, Boolean> _function = new Function1<IJavaElement, Boolean>() {
            @Override
            public Boolean apply(final IJavaElement it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "foo");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists = IterableExtensions.<IJavaElement>exists(it, _function);
          Assert.assertTrue(_exists);
        }
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
      String _string = _builder.toString();
      XtendFile _xtendFile = this._workbenchTestHelper.xtendFile("Xtend.xtend", _string);
      EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      final XtendMember field = IterableExtensions.<XtendMember>head(_members);
      IResourcesSetupUtil.waitForBuild();
      Iterable<IJavaElement> _javaElements = this._jvmModelFindReferenceHandler.getJavaElements(field);
      final Procedure1<Iterable<IJavaElement>> _function = new Procedure1<Iterable<IJavaElement>>() {
        @Override
        public void apply(final Iterable<IJavaElement> it) {
          int _size = IterableExtensions.size(it);
          Assert.assertEquals(1, _size);
          final Function1<IJavaElement, Boolean> _function = new Function1<IJavaElement, Boolean>() {
            @Override
            public Boolean apply(final IJavaElement it) {
              boolean _and = false;
              if (!(it instanceof IField)) {
                _and = false;
              } else {
                String _elementName = ((IField) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "foo");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists = IterableExtensions.<IJavaElement>exists(it, _function);
          Assert.assertTrue(_exists);
        }
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
      String _string = _builder.toString();
      XtendFile _xtendFile = this._workbenchTestHelper.xtendFile("Xtend.xtend", _string);
      EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      final XtendMember field = IterableExtensions.<XtendMember>head(_members);
      IResourcesSetupUtil.waitForBuild();
      Iterable<IJavaElement> _javaElements = this._jvmModelFindReferenceHandler.getJavaElements(field);
      final Procedure1<Iterable<IJavaElement>> _function = new Procedure1<Iterable<IJavaElement>>() {
        @Override
        public void apply(final Iterable<IJavaElement> it) {
          int _size = IterableExtensions.size(it);
          Assert.assertEquals(3, _size);
          final Function1<IJavaElement, Boolean> _function = new Function1<IJavaElement, Boolean>() {
            @Override
            public Boolean apply(final IJavaElement it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "getFoo");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists = IterableExtensions.<IJavaElement>exists(it, _function);
          Assert.assertTrue(_exists);
          final Function1<IJavaElement, Boolean> _function_1 = new Function1<IJavaElement, Boolean>() {
            @Override
            public Boolean apply(final IJavaElement it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "setFoo");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_1 = IterableExtensions.<IJavaElement>exists(it, _function_1);
          Assert.assertTrue(_exists_1);
          final Function1<IJavaElement, Boolean> _function_2 = new Function1<IJavaElement, Boolean>() {
            @Override
            public Boolean apply(final IJavaElement it) {
              boolean _and = false;
              if (!(it instanceof IField)) {
                _and = false;
              } else {
                String _elementName = ((IField) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "_foo");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_2 = IterableExtensions.<IJavaElement>exists(it, _function_2);
          Assert.assertTrue(_exists_2);
        }
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
      String _string = _builder.toString();
      XtendFile _xtendFile = this._workbenchTestHelper.xtendFile("Xtend.xtend", _string);
      EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      final XtendMember method = IterableExtensions.<XtendMember>head(_members);
      IResourcesSetupUtil.waitForBuild();
      Iterable<IJavaElement> _javaElements = this._jvmModelFindReferenceHandler.getJavaElements(method);
      final Procedure1<Iterable<IJavaElement>> _function = new Procedure1<Iterable<IJavaElement>>() {
        @Override
        public void apply(final Iterable<IJavaElement> it) {
          int _size = IterableExtensions.size(it);
          Assert.assertEquals(2, _size);
          final Function1<IJavaElement, Boolean> _function = new Function1<IJavaElement, Boolean>() {
            @Override
            public Boolean apply(final IJavaElement it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "_foo");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists = IterableExtensions.<IJavaElement>exists(it, _function);
          Assert.assertTrue(_exists);
          final Function1<IJavaElement, Boolean> _function_1 = new Function1<IJavaElement, Boolean>() {
            @Override
            public Boolean apply(final IJavaElement it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "foo");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_1 = IterableExtensions.<IJavaElement>exists(it, _function_1);
          Assert.assertTrue(_exists_1);
        }
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
        ArrayList<IJavaElement> _newArrayList = CollectionLiterals.<IJavaElement>newArrayList(targets);
        final ISearchQuery query = this._jdtReferenceFinder.createCompositeQuery("test", _newArrayList);
        final ArrayList<SearchResultEvent> events = CollectionLiterals.<SearchResultEvent>newArrayList();
        final ArrayList<Object> elements = CollectionLiterals.<Object>newArrayList();
        final ISearchResult searchResult = query.getSearchResult();
        final MatchFilter[] filters = ((AbstractTextSearchResult) searchResult).getActiveMatchFilters();
        final ISearchResultListener _function = new ISearchResultListener() {
          @Override
          public void searchResultChanged(final SearchResultEvent it) {
            events.add(it);
            if ((it instanceof MatchEvent)) {
              Match[] _matches = ((MatchEvent)it).getMatches();
              final Function1<Match, Boolean> _function = new Function1<Match, Boolean>() {
                @Override
                public Boolean apply(final Match m) {
                  final Function1<MatchFilter, Boolean> _function = new Function1<MatchFilter, Boolean>() {
                    @Override
                    public Boolean apply(final MatchFilter it) {
                      boolean _filters = it.filters(m);
                      return Boolean.valueOf((!_filters));
                    }
                  };
                  return Boolean.valueOf(IterableExtensions.<MatchFilter>forall(((Iterable<MatchFilter>)Conversions.doWrapArray(filters)), _function));
                }
              };
              final Iterable<Match> matches = IterableExtensions.<Match>filter(((Iterable<Match>)Conversions.doWrapArray(_matches)), _function);
              int _kind = ((MatchEvent)it).getKind();
              boolean _equals = (_kind == MatchEvent.ADDED);
              if (_equals) {
                for (final Match it_1 : matches) {
                  Object _element = it_1.getElement();
                  elements.add(_element);
                }
              } else {
                for (final Match it_2 : matches) {
                  Object _element_1 = it_2.getElement();
                  elements.remove(_element_1);
                }
              }
            }
          }
        };
        searchResult.addListener(_function);
        IWorkbenchWindow _activeWorkbenchWindow = this.workbench.getActiveWorkbenchWindow();
        SearchUtil.runQueryInForeground(_activeWorkbenchWindow, query);
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
      XtendFile _xtendFile = this._workbenchTestHelper.xtendFile("Xtend.xtend", "@Data class Xtend { String field }");
      EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass cls = IterableExtensions.<XtendClass>head(_filter);
      IResourcesSetupUtil.waitForBuild();
      Iterable<IJavaElement> _javaElements = this._jvmModelFindReferenceHandler.getJavaElements(cls);
      final Procedure1<Iterable<IJavaElement>> _function = new Procedure1<Iterable<IJavaElement>>() {
        @Override
        public void apply(final Iterable<IJavaElement> it) {
          int _size = IterableExtensions.size(it);
          Assert.assertEquals(2, _size);
          final Function1<IJavaElement, Boolean> _function = new Function1<IJavaElement, Boolean>() {
            @Override
            public Boolean apply(final IJavaElement it) {
              boolean _and = false;
              if (!(it instanceof IType)) {
                _and = false;
              } else {
                String _elementName = ((IType) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "Xtend");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists = IterableExtensions.<IJavaElement>exists(it, _function);
          Assert.assertTrue(_exists);
          final Function1<IJavaElement, Boolean> _function_1 = new Function1<IJavaElement, Boolean>() {
            @Override
            public Boolean apply(final IJavaElement it) {
              boolean _and = false;
              if (!(it instanceof IMethod)) {
                _and = false;
              } else {
                String _elementName = ((IMethod) it).getElementName();
                boolean _equals = Objects.equal(_elementName, "Xtend");
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_1 = IterableExtensions.<IJavaElement>exists(it, _function_1);
          Assert.assertTrue(_exists_1);
        }
      };
      ObjectExtensions.<Iterable<IJavaElement>>operator_doubleArrow(_javaElements, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
