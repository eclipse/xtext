package org.eclipse.xtend.ide.tests.hover;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.hover.XtendHoverSignatureProvider;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendHoverSignatureProviderTest extends AbstractXtendUITestCase {
  @Inject
  private ParseHelper<XtendFile> parseHelper;
  
  @Inject
  private WorkbenchTestHelper testHelper;
  
  @Inject
  private XtendHoverSignatureProvider signatureProvider;
  
  @Test
  public void testSignatureForXtendClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      final String signature = this.signatureProvider.getSignature(clazz);
      Assert.assertEquals("Foo", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForXtendFunction() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a) throws NullPointerException { }");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar(String a, int b) throws NullPointerException, RuntimeException {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      final XtendMember xtendFunction1 = _members.get(0);
      EList<XtendMember> _members_1 = clazz.getMembers();
      final XtendMember xtendFunction2 = _members_1.get(1);
      final String signature1 = this.signatureProvider.getSignature(xtendFunction1);
      final String signature2 = this.signatureProvider.getSignature(xtendFunction2);
      Assert.assertEquals("Object bar(String a) throws NullPointerException", signature1);
      Assert.assertEquals("void bar(String a, int b) throws NullPointerException, RuntimeException", signature2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForXtendParameter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a) throws NullPointerException");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      EList<XtendParameter> _parameters = xtendFunction.getParameters();
      final XtendParameter xtendParameter = _parameters.get(0);
      final String signature = this.signatureProvider.getSignature(xtendParameter);
      Assert.assertEquals("String a - bar(String)", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForXtendField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("import java.util.Collections");
      _builder.newLine();
      _builder.append("import com.google.inject.Inject");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Inject");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Collections collections");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a) throws NullPointerException");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendField xtendField = ((XtendField) _get);
      final String signature = this.signatureProvider.getSignature(xtendField);
      Assert.assertEquals("Collections collections", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForXtendFieldWithoutTypeDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("import java.util.Collections");
      _builder.newLine();
      _builder.append("import com.google.inject.Inject");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val collections = <String>newArrayList");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendField xtendField = ((XtendField) _get);
      final String signature = this.signatureProvider.getSignature(xtendField);
      Assert.assertEquals("ArrayList<String> collections", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForExtensionFieldWithoutName() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("import java.util.Collections");
      _builder.newLine();
      _builder.append("import com.google.inject.Inject");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension String");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendField xtendField = ((XtendField) _get);
      final String signature = this.signatureProvider.getSignature(xtendField);
      Assert.assertEquals("String", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForXtendFieldWithoutNameOrType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("import java.util.Collections");
      _builder.newLine();
      _builder.append("import com.google.inject.Inject");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val = \"\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendField xtendField = ((XtendField) _get);
      final String signature = this.signatureProvider.getSignature(xtendField);
      Assert.assertEquals("", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForXtendConstructor() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new(String a, int b){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      final XtendMember xtendConstructor = _members.get(0);
      final String signature = this.signatureProvider.getSignature(xtendConstructor);
      Assert.assertEquals("Foo(String a, int b)", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForXtendDefaultConstructor() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new Foo()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _get_1 = _expressions.get(0);
      final XConstructorCall constructorCall = ((XConstructorCall) _get_1);
      JvmConstructor _constructor = constructorCall.getConstructor();
      final String signature = this.signatureProvider.getSignature(_constructor);
      Assert.assertEquals("Foo()", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeclarationOfClazzWithGenrics() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo<T,Y> {}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      final String signature = this.signatureProvider.getSignature(clazz);
      Assert.assertEquals("Foo<T, Y>", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureXtendConstructorWithGenerics_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo<S extends CharSequence> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _get_1 = _expressions.get(0);
      final XConstructorCall constructorCall = ((XConstructorCall) _get_1);
      JvmConstructor _constructor = constructorCall.getConstructor();
      final String signature = this.signatureProvider.getSignature(_constructor);
      Assert.assertEquals("Foo<S extends CharSequence>()", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureConstructorCall_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo<S extends CharSequence> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _get_1 = _expressions.get(0);
      final XConstructorCall constructorCall = ((XConstructorCall) _get_1);
      final String signature = this.signatureProvider.getSignature(constructorCall);
      Assert.assertEquals("Foo<CharSequence>()", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureConstructorCall_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo<S> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo(StringBuilder, StringBuffer)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new <X>(Class<X> c, Class<S> c2) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _get_1 = _expressions.get(0);
      final XConstructorCall constructorCall = ((XConstructorCall) _get_1);
      final String signature = this.signatureProvider.getSignature(constructorCall);
      Assert.assertEquals("<StringBuilder> Foo<StringBuffer>(Class<StringBuilder> c, Class<StringBuffer> c2)", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureConstructorCall_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo<S> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo<String>()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _get_1 = _expressions.get(0);
      final XConstructorCall constructorCall = ((XConstructorCall) _get_1);
      final String signature = this.signatureProvider.getSignature(constructorCall);
      Assert.assertEquals("Foo<String>()", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Ignore
  @Test
  public void testSignatureDelegateConstructorCall_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo<S extends CharSequence> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new(int i) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendConstructor xtendConstructor = ((XtendConstructor) _get);
      XExpression _expression = xtendConstructor.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _get_1 = _expressions.get(0);
      final XFeatureCall featureCall = ((XFeatureCall) _get_1);
      final String signature = this.signatureProvider.getSignature(featureCall);
      Assert.assertEquals("Foo<S>()", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Ignore
  @Test
  public void testSignatureDelegateConstructorCall_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo<S extends CharSequence> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new(int i) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this(StringBuilder)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new<X>(Class<X> c) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendConstructor xtendConstructor = ((XtendConstructor) _get);
      XExpression _expression = xtendConstructor.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _get_1 = _expressions.get(0);
      final XFeatureCall featureCall = ((XFeatureCall) _get_1);
      final String signature = this.signatureProvider.getSignature(featureCall);
      Assert.assertEquals("Foo<S>()", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForForLoopVariable() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def bar(List<String> list){");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("for(foo : list){");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _get_1 = _expressions.get(0);
      final JvmFormalParameter param = ((XForLoopExpression) _get_1).getDeclaredParam();
      final String signature = this.signatureProvider.getSignature(param);
      Assert.assertEquals("String foo", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForForXClosureVariable() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t");
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def zonk(){");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("bar(s | s + \"42\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def bar((String)=>String fun){");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _get_1 = _expressions.get(0);
      EList<XExpression> _featureCallArguments = ((XFeatureCall) _get_1).getFeatureCallArguments();
      XExpression _get_2 = _featureCallArguments.get(0);
      final XClosure closure = ((XClosure) _get_2);
      EList<JvmFormalParameter> _declaredFormalParameters = closure.getDeclaredFormalParameters();
      final JvmFormalParameter param = _declaredFormalParameters.get(0);
      final String signature = this.signatureProvider.getSignature(param);
      Assert.assertEquals("String s", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForXVariableDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(List<String> list){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val a = \"42\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _get_1 = _expressions.get(0);
      final XVariableDeclaration variable = ((XVariableDeclaration) _get_1);
      final String signature = this.signatureProvider.getSignature(variable);
      Assert.assertEquals("String a", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug378082() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("@Data");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int id");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch void a(int i){}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch void a(int i){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      final XtendMember field = IterableExtensions.<XtendMember>head(_members);
      EList<XtendMember> _members_1 = clazz.getMembers();
      final XtendMember function = _members_1.get(1);
      final String fieldSignature = this.signatureProvider.getSignature(field);
      Assert.assertEquals("int id", fieldSignature);
      final String functionSignature = this.signatureProvider.getSignature(function);
      Assert.assertEquals("void a(int i)", functionSignature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug379019() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def error() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val start = System::currentTimeMillis()");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var time = System::currentTimeMillis() - start");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("time");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      final XtendMember function = IterableExtensions.<XtendMember>head(_members);
      final String signature = this.signatureProvider.getSignature(function);
      EcoreUtil.resolveAll(xtendFile);
      Assert.assertEquals("long error()", signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("enum Foo { BAR, BAZ }");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration en = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      String _signature = this.signatureProvider.getSignature(en);
      Assert.assertEquals("Foo", _signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def baz(Foo f){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("enum Foo { BAR, BAZ }");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      EList<XtendParameter> _parameters = ((XtendFunction) _head_1).getParameters();
      XtendParameter _head_2 = IterableExtensions.<XtendParameter>head(_parameters);
      JvmTypeReference _parameterType = _head_2.getParameterType();
      final JvmType en = _parameterType.getType();
      String _signature = this.signatureProvider.getSignature(en);
      Assert.assertEquals("Foo", _signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInterfaceDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("interface Foo { }");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration in = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      String _signature = this.signatureProvider.getSignature(in);
      Assert.assertEquals("Foo", _signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInterfaceReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Bar implements Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface Foo { }");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<JvmTypeReference> _implements = ((XtendClass) _head).getImplements();
      JvmTypeReference _head_1 = IterableExtensions.<JvmTypeReference>head(_implements);
      final JvmType in = _head_1.getType();
      String _signature = this.signatureProvider.getSignature(in);
      Assert.assertEquals("Foo", _signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnnotationDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("annotation Foo { }");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final XtendTypeDeclaration in = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      String _signature = this.signatureProvider.getSignature(in);
      Assert.assertEquals("Foo", _signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnnotationReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("@Foo");
      _builder.newLine();
      _builder.append("class Bar {}");
      _builder.newLine();
      _builder.append("annotation Foo { }");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XAnnotation> _annotations = ((XtendClass) _head).getAnnotations();
      XAnnotation _head_1 = IterableExtensions.<XAnnotation>head(_annotations);
      final JvmType in = _head_1.getAnnotationType();
      String _signature = this.signatureProvider.getSignature(in);
      Assert.assertEquals("Foo", _signature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test381185() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Bar b");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(){ ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("b.foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo f");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("f.bar");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendTypeDeclaration> _xtendTypes_1 = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter_1 = Iterables.<XtendClass>filter(_xtendTypes_1, XtendClass.class);
      Iterable<XtendClass> _drop = IterableExtensions.<XtendClass>drop(_filter_1, 1);
      final XtendClass clazz2 = IterableExtensions.<XtendClass>head(_drop);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(1);
      final XtendFunction function1 = ((XtendFunction) _get);
      EList<XtendMember> _members_1 = clazz2.getMembers();
      XtendMember _get_1 = _members_1.get(1);
      final XtendFunction function2 = ((XtendFunction) _get_1);
      XExpression _expression = function1.getExpression();
      final XBlockExpression expression1 = ((XBlockExpression) _expression);
      XExpression _expression_1 = function2.getExpression();
      final XBlockExpression expression2 = ((XBlockExpression) _expression_1);
      EList<XExpression> _expressions = expression1.getExpressions();
      XExpression _get_2 = _expressions.get(0);
      final XMemberFeatureCall call1 = ((XMemberFeatureCall) _get_2);
      EList<XExpression> _expressions_1 = expression2.getExpressions();
      XExpression _get_3 = _expressions_1.get(0);
      final XMemberFeatureCall call2 = ((XMemberFeatureCall) _get_3);
      JvmIdentifiableElement _feature = call1.getFeature();
      String _signature = this.signatureProvider.getSignature(_feature);
      Assert.assertEquals("Object Bar.foo()", _signature);
      JvmIdentifiableElement _feature_1 = call2.getFeature();
      String _signature_1 = this.signatureProvider.getSignature(_feature_1);
      Assert.assertEquals("Object Foo.bar()", _signature_1);
      XExpression _memberCallTarget = call1.getMemberCallTarget();
      JvmIdentifiableElement _feature_2 = ((XFeatureCall) _memberCallTarget).getFeature();
      String _signature_2 = this.signatureProvider.getSignature(_feature_2);
      Assert.assertEquals("Bar Foo.b", _signature_2);
      XExpression _memberCallTarget_1 = call2.getMemberCallTarget();
      JvmIdentifiableElement _feature_3 = ((XFeatureCall) _memberCallTarget_1).getFeature();
      String _signature_3 = this.signatureProvider.getSignature(_feature_3);
      Assert.assertEquals("Foo Bar.f", _signature_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ResourceSet getResourceSet() {
    Injector _injector = this.getInjector();
    IResourceSetProvider _instance = _injector.<IResourceSetProvider>getInstance(IResourceSetProvider.class);
    IProject _project = this.testHelper.getProject();
    return _instance.get(_project);
  }
  
  @After
  public void cleanup() {
    try {
      this.testHelper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
