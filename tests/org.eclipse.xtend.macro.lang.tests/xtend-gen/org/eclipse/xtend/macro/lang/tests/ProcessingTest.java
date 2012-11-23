/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.macro.lang.tests;

import com.google.inject.Inject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.macro.lang.tests.MacroInjectorProvider;
import org.eclipse.xtend.macro.lang.tests.MacroTestExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper.Result;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = MacroInjectorProvider.class)
@SuppressWarnings("all")
public class ProcessingTest {
  @Inject
  private CompilationTestHelper _compilationTestHelper;
  
  @Inject
  private MacroTestExtensions _macroTestExtensions;
  
  @Test
  public void testProcessing_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@AsInterface");
      _builder.newLine();
      _builder.append("abstract class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String sayHi()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String,CharSequence> _xtend = this._macroTestExtensions.xtend(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@AsInterface for class {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("process elements {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("for (e : elements) {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("with(e.name) [");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("interface = true");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("^abstract = false");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("superTypes.clear");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Pair<String,CharSequence> _macro = this._macroTestExtensions.macro(_builder_1);
      ResourceSet _resourceSet = this._compilationTestHelper.resourceSet(_xtend, _macro);
      final Procedure1<Result> _function = new Procedure1<Result>() {
          public void apply(final Result it) {
            final Class<? extends Object> clazz = it.getCompiledClass("MyClass");
            Assert.assertNotNull(clazz);
            boolean _isInterface = clazz.isInterface();
            Assert.assertTrue(_isInterface);
          }
        };
      this._compilationTestHelper.compile(_resourceSet, new IAcceptor<Result>() {
          public void accept(Result t) {
            _function.apply(t);
          }
      });
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testProcessing_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@WithStringField(\'hello\')");
      _builder.newLine();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("@WithStringField");
      _builder.newLine();
      _builder.append("class MyClass2 {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String,CharSequence> _xtend = this._macroTestExtensions.xtend(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@WithStringField for class {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("static String value = \'foo\'");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("process each e {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("with(e.name) [");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("field(value(e), <String>type)");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Pair<String,CharSequence> _macro = this._macroTestExtensions.macro(_builder_1);
      ResourceSet _resourceSet = this._compilationTestHelper.resourceSet(_xtend, _macro);
      final Procedure1<Result> _function = new Procedure1<Result>() {
          public void apply(final Result it) {
            try {
              final Class<? extends Object> myClass = it.getCompiledClass("MyClass");
              Field _declaredField = myClass.getDeclaredField("hello");
              Assert.assertNotNull(_declaredField);
              final Class<? extends Object> myClass2 = it.getCompiledClass("MyClass2");
              Field _declaredField_1 = myClass2.getDeclaredField("foo");
              Class<? extends Object> _type = _declaredField_1.getType();
              Assert.assertEquals(String.class, _type);
            } catch (Exception _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
      this._compilationTestHelper.compile(_resourceSet, new IAcceptor<Result>() {
          public void accept(Result t) {
            _function.apply(t);
          }
      });
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testProcessing_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@GWTService");
      _builder.newLine();
      _builder.append("class AsyncTest {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override String myService(String x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("x.toUpperCase");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override boolean anotherFunc(Iterable<Boolean> trues) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("trues.head");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String,CharSequence> _xtend = this._macroTestExtensions.xtend(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package foo");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.core.xtend.XtendFunction");
      _builder_1.newLine();
      _builder_1.append("import java.util.concurrent.Future");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@GWTService for class {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("register each {");
      _builder_1.newLine();
      _builder_1.append("  \t");
      _builder_1.append("registerInterface(source.^package + \".\" + name + \"InterfaceAsync\")");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("registerInterface(source.^package + \".\" + name + \"Interface\")");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("process each {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("with(source.^package + \".\" + name + \"InterfaceAsync\") [ asyncInterface |");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("for (m : members.filter(typeof(XtendFunction))) {");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("method (m.name, type(Void::TYPE)) [");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("m.parameters.forEach [ param(name, parameterType) ]");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("param(\'result\', type( typeof(Future), m.returnType))");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("with(source.^package + \".\" + name + \"Interface\") [ interface |");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("for (m : members.filter(typeof(XtendFunction))) {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("method (m.name, m.returnType) [");
      _builder_1.newLine();
      _builder_1.append("\t\t    \t");
      _builder_1.append("m.parameters.forEach [ param(name, parameterType) ]");
      _builder_1.newLine();
      _builder_1.append("\t\t  \t");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("with(source.^package + \".\" + name) [ mainType |");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("mainType.superTypes += type(interface)");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Pair<String,CharSequence> _macro = this._macroTestExtensions.macro(_builder_1);
      ResourceSet _resourceSet = this._compilationTestHelper.resourceSet(_xtend, _macro);
      final Procedure1<Result> _function = new Procedure1<Result>() {
          public void apply(final Result it) {
            try {
              final Class<? extends Object> myClass = it.getCompiledClass("foo.AsyncTest");
              Assert.assertNotNull(myClass);
              final Class<? extends Object> interf = it.getCompiledClass("foo.AsyncTestInterface");
              Class<? extends Object>[] _interfaces = myClass.getInterfaces();
              Class<? extends Object> _get = ((List<Class<? extends Object>>)Conversions.doWrapArray(_interfaces)).get(0);
              Assert.assertSame(_get, interf);
              final Class<? extends Object> asyncInterf = it.getCompiledClass("foo.AsyncTestInterfaceAsync");
              ArrayList<Class<? extends Object>> _newArrayList = CollectionLiterals.<Class<? extends Object>>newArrayList(String.class, Future.class);
              Method _method = asyncInterf.getMethod("myService", ((Class<?>[]) ((Class<?>[])Conversions.unwrapArray(_newArrayList, Class.class))));
              Assert.assertNotNull(_method);
            } catch (Exception _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
      this._compilationTestHelper.compile(_resourceSet, new IAcceptor<Result>() {
          public void accept(Result t) {
            _function.apply(t);
          }
      });
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testProcessingWithClassFunction_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import anotherPack.MyService");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@MyService");
      _builder.newLine();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String,CharSequence> _xtend = this._macroTestExtensions.xtend(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package anotherPack");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.core.xtend.XtendClass");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.core.xtend.XtendFile");
      _builder_1.newLine();
      _builder_1.append("import static extension anotherPack.HelperClass.*");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class HelperClass {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def static String interfaceName(XtendClass it) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("it.qualifiedName + \"Interface\"");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def static String qualifiedName(XtendClass it) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("(eContainer as XtendFile).^package + \".\" + name");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@MyService for class {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("register each e {");
      _builder_1.newLine();
      _builder_1.append("\t ");
      _builder_1.append("registerInterface(e.interfaceName)");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("process elements {");
      _builder_1.newLine();
      _builder_1.append("  \t");
      _builder_1.append("elements.forEach [ e |");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("with(e.qualifiedName) [");
      _builder_1.newLine();
      _builder_1.append("\t\t  ");
      _builder_1.append("superTypes += type(e.interfaceName)");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("  \t");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Pair<String,CharSequence> _macro = this._macroTestExtensions.macro(_builder_1);
      ResourceSet _resourceSet = this._compilationTestHelper.resourceSet(_xtend, _macro);
      final Procedure1<Result> _function = new Procedure1<Result>() {
          public void apply(final Result it) {
            final Class<? extends Object> myClass = it.getCompiledClass("foo.MyClass");
            Assert.assertNotNull(myClass);
            final Class<? extends Object> interf = it.getCompiledClass("foo.MyClassInterface");
            Class<? extends Object>[] _interfaces = myClass.getInterfaces();
            Class<? extends Object> _get = ((List<Class<? extends Object>>)Conversions.doWrapArray(_interfaces)).get(0);
            Assert.assertSame(_get, interf);
          }
        };
      this._compilationTestHelper.compile(_resourceSet, new IAcceptor<Result>() {
          public void accept(Result t) {
            _function.apply(t);
          }
      });
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testProcessingWithClassFunction_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import anotherPack.MyService");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@MyService");
      _builder.newLine();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String,CharSequence> _xtend = this._macroTestExtensions.xtend(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package anotherPack");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import static extension anotherPack.HelperClass.*");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@MyService for class {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("register elements {");
      _builder_1.newLine();
      _builder_1.append("  \t");
      _builder_1.append("elements.forEach [e |");
      _builder_1.newLine();
      _builder_1.append("\t  \t");
      _builder_1.append("registerInterface(e.interfaceName)");
      _builder_1.newLine();
      _builder_1.append("  \t");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("process each e {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("with(e.qualifiedName) [");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("superTypes += type(e.interfaceName)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Pair<String,CharSequence> _mappedTo = Pair.<String, CharSequence>of("MyService.macro", _builder_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package anotherPack");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import org.eclipse.xtend.core.xtend.XtendClass");
      _builder_2.newLine();
      _builder_2.append("import org.eclipse.xtend.core.xtend.XtendFile");
      _builder_2.newLine();
      _builder_2.append("import static extension anotherPack.HelperClass.*");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class HelperClass {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def static String interfaceName(XtendClass it) {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("it.qualifiedName + \"Interface\"");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def static String qualifiedName(XtendClass it) {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("(eContainer as XtendFile).^package + \".\" + name");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      Pair<String,CharSequence> _mappedTo_1 = Pair.<String, CharSequence>of("HelperClass.macro", _builder_2);
      ResourceSet _resourceSet = this._compilationTestHelper.resourceSet(_xtend, _mappedTo, _mappedTo_1);
      final Procedure1<Result> _function = new Procedure1<Result>() {
          public void apply(final Result it) {
            final Class<? extends Object> myClass = it.getCompiledClass("foo.MyClass");
            Assert.assertNotNull(myClass);
            final Class<? extends Object> interf = it.getCompiledClass("foo.MyClassInterface");
            Class<? extends Object>[] _interfaces = myClass.getInterfaces();
            Class<? extends Object> _get = ((List<Class<? extends Object>>)Conversions.doWrapArray(_interfaces)).get(0);
            Assert.assertSame(_get, interf);
          }
        };
      this._compilationTestHelper.compile(_resourceSet, new IAcceptor<Result>() {
          public void accept(Result t) {
            _function.apply(t);
          }
      });
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFields() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import anotherPack.MyService");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@MyService(specialClass=typeof(String))");
      _builder.newLine();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String,CharSequence> _xtend = this._macroTestExtensions.xtend(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package anotherPack");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@MyService for class {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("static Class<?> specialClass");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("static String value = \'foo\'");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("process each e {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("with(\'foo.MyClass\') [");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("field(value(e), type(specialClass(e)))");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Pair<String,CharSequence> _mappedTo = Pair.<String, CharSequence>of("MyService.macro", _builder_1);
      ResourceSet _resourceSet = this._compilationTestHelper.resourceSet(_xtend, _mappedTo);
      final Procedure1<Result> _function = new Procedure1<Result>() {
          public void apply(final Result it) {
            try {
              final Class<? extends Object> myClass = it.getCompiledClass("foo.MyClass");
              Assert.assertNotNull(myClass);
              Field _declaredField = myClass.getDeclaredField("foo");
              Class<? extends Object> _type = _declaredField.getType();
              boolean _equals = ObjectExtensions.operator_equals(_type, String.class);
              Assert.assertTrue(_equals);
            } catch (Exception _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
      this._compilationTestHelper.compile(_resourceSet, new IAcceptor<Result>() {
          public void accept(Result t) {
            _function.apply(t);
          }
      });
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFields_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import anotherPack.MyService");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@MyService(\"myField\")");
      _builder.newLine();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String,CharSequence> _xtend = this._macroTestExtensions.xtend(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package anotherPack");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@MyService for class {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("static Class<?> specialClass = typeof(Boolean)");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("static String value = \'foo\'");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("process each e {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("with(\'foo.MyClass\') [");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("field(value(e), type(specialClass(e)))");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Pair<String,CharSequence> _mappedTo = Pair.<String, CharSequence>of("MyService.macro", _builder_1);
      ResourceSet _resourceSet = this._compilationTestHelper.resourceSet(_xtend, _mappedTo);
      final Procedure1<Result> _function = new Procedure1<Result>() {
          public void apply(final Result it) {
            try {
              final Class<? extends Object> myClass = it.getCompiledClass("foo.MyClass");
              Assert.assertNotNull(myClass);
              Field _declaredField = myClass.getDeclaredField("myField");
              Class<? extends Object> _type = _declaredField.getType();
              boolean _equals = ObjectExtensions.operator_equals(_type, Boolean.class);
              Assert.assertTrue(_equals);
            } catch (Exception _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
      this._compilationTestHelper.compile(_resourceSet, new IAcceptor<Result>() {
          public void accept(Result t) {
            _function.apply(t);
          }
      });
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
