package org.eclipse.xtend.ide.tests.hover;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.ide.hover.XtendHoverSignatureProvider;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
      XtendFile _parse = this.parseHelper.parse(_builder, _resourceSet);
      final XtendFile xtendFile = _parse;
      XtendClass _xtendClass = xtendFile.getXtendClass();
      final XtendClass clazz = _xtendClass;
      String _signature = this.signatureProvider.getSignature(clazz);
      final String signature = _signature;
      Assert.assertEquals("<b>testPackage.Foo</b>", signature);
    } catch (Exception _e) {
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
      _builder.append("def bar(String a) throws NullPointerException");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar(String a, int b) throws NullPointerException, RuntimeException");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      XtendFile _parse = this.parseHelper.parse(_builder, _resourceSet);
      final XtendFile xtendFile = _parse;
      XtendClass _xtendClass = xtendFile.getXtendClass();
      final XtendClass clazz = _xtendClass;
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendMember xtendFunction1 = _get;
      EList<XtendMember> _members_1 = clazz.getMembers();
      XtendMember _get_1 = _members_1.get(1);
      final XtendMember xtendFunction2 = _get_1;
      String _signature = this.signatureProvider.getSignature(xtendFunction1);
      final String signature1 = _signature;
      String _signature_1 = this.signatureProvider.getSignature(xtendFunction2);
      final String signature2 = _signature_1;
      Assert.assertEquals("<b>Object bar(String a) throws NullPointerException</b>", signature1);
      Assert.assertEquals("<b>void bar(String a, int b) throws NullPointerException, RuntimeException</b>", signature2);
    } catch (Exception _e) {
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
      XtendFile _parse = this.parseHelper.parse(_builder, _resourceSet);
      final XtendFile xtendFile = _parse;
      XtendClass _xtendClass = xtendFile.getXtendClass();
      final XtendClass clazz = _xtendClass;
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      EList<XtendParameter> _parameters = xtendFunction.getParameters();
      XtendParameter _get_1 = _parameters.get(0);
      final XtendParameter xtendParameter = _get_1;
      String _signature = this.signatureProvider.getSignature(xtendParameter);
      final String signature = _signature;
      Assert.assertEquals("<b>String a - bar(String)</b>", signature);
    } catch (Exception _e) {
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
      XtendFile _parse = this.parseHelper.parse(_builder, _resourceSet);
      final XtendFile xtendFile = _parse;
      XtendClass _xtendClass = xtendFile.getXtendClass();
      final XtendClass clazz = _xtendClass;
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendField xtendField = ((XtendField) _get);
      String _signature = this.signatureProvider.getSignature(xtendField);
      final String signature = _signature;
      Assert.assertEquals("<b>Collections testPackage.Foo.collections</b>", signature);
    } catch (Exception _e) {
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
      XtendFile _parse = this.parseHelper.parse(_builder, _resourceSet);
      final XtendFile xtendFile = _parse;
      XtendClass _xtendClass = xtendFile.getXtendClass();
      final XtendClass clazz = _xtendClass;
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendMember xtendConstructor = _get;
      String _signature = this.signatureProvider.getSignature(xtendConstructor);
      final String signature = _signature;
      Assert.assertEquals("<b>testPackage.Foo (String a, int b)</b>", signature);
    } catch (Exception _e) {
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
      XtendFile _parse = this.parseHelper.parse(_builder, _resourceSet);
      final XtendFile xtendFile = _parse;
      XtendClass _xtendClass = xtendFile.getXtendClass();
      final XtendClass clazz = _xtendClass;
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _get = _members.get(0);
      final XtendFunction xtendFunction = ((XtendFunction) _get);
      XExpression _expression = xtendFunction.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _get_1 = _expressions.get(0);
      final XConstructorCall constructorCall = ((XConstructorCall) _get_1);
      JvmConstructor _constructor = constructorCall.getConstructor();
      String _signature = this.signatureProvider.getSignature(_constructor);
      final String signature = _signature;
      Assert.assertEquals("<b>testPackage.Foo ()</b>", signature);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ResourceSet getResourceSet() {
    Injector _injector = this.getInjector();
    IResourceSetProvider _instance = _injector.<IResourceSetProvider>getInstance(IResourceSetProvider.class);
    IProject _project = this.testHelper.getProject();
    ResourceSet _get = _instance.get(_project);
    return _get;
  }
  
  @Before
  @After
  public void cleanup() {
    try {
      this.testHelper.tearDown();
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
