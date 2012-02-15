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
      {
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
        String _hoverSignature = this.signatureProvider.getHoverSignature(clazz);
        final String signature = _hoverSignature;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("<b><image src=");
        String _string = _builder_1.toString();
        boolean _startsWith = signature.startsWith(_string);
        Assert.assertTrue(_startsWith);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(".metadata/.plugins/org.eclipse.jdt.ui/jdt-images/0.png\'/>testPackage.Foo</b>");
        String _string_1 = _builder_2.toString();
        boolean _endsWith = signature.endsWith(_string_1);
        Assert.assertTrue(_endsWith);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForXtendFunction() {
    try {
      {
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
        String _hoverSignature = this.signatureProvider.getHoverSignature(xtendFunction1);
        final String signature1 = _hoverSignature;
        String _hoverSignature_1 = this.signatureProvider.getHoverSignature(xtendFunction2);
        final String signature2 = _hoverSignature_1;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("<b><image src=");
        String _string = _builder_1.toString();
        boolean _startsWith = signature1.startsWith(_string);
        Assert.assertTrue(_startsWith);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(".metadata/.plugins/org.eclipse.jdt.ui/jdt-images/1.png\'/> Object bar(String a) throws NullPointerException</b>");
        String _string_1 = _builder_2.toString();
        boolean _endsWith = signature1.endsWith(_string_1);
        Assert.assertTrue(_endsWith);
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("<b><image src=");
        String _string_2 = _builder_3.toString();
        boolean _startsWith_1 = signature2.startsWith(_string_2);
        Assert.assertTrue(_startsWith_1);
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append(".metadata/.plugins/org.eclipse.jdt.ui/jdt-images/1.png\'/> void bar(String a, int b) throws NullPointerException, RuntimeException</b>");
        String _string_3 = _builder_4.toString();
        boolean _endsWith_1 = signature2.endsWith(_string_3);
        Assert.assertTrue(_endsWith_1);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForXtendParameter() {
    try {
      {
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
        String _hoverSignature = this.signatureProvider.getHoverSignature(xtendParameter);
        final String signature = _hoverSignature;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("<b><image src=");
        String _string = _builder_1.toString();
        boolean _startsWith = signature.startsWith(_string);
        Assert.assertTrue(_startsWith);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(".metadata/.plugins/org.eclipse.jdt.ui/jdt-images/2.png\'/> String a - bar(String)</b>");
        String _string_1 = _builder_2.toString();
        boolean _endsWith = signature.endsWith(_string_1);
        Assert.assertTrue(_endsWith);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForXtendField() {
    try {
      {
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
        String _hoverSignature = this.signatureProvider.getHoverSignature(xtendField);
        final String signature = _hoverSignature;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("<b><image src=");
        String _string = _builder_1.toString();
        boolean _startsWith = signature.startsWith(_string);
        Assert.assertTrue(_startsWith);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(".metadata/.plugins/org.eclipse.jdt.ui/jdt-images/3.png\'/>Collections testPackage.Foo.collections</b>");
        String _string_1 = _builder_2.toString();
        boolean _endsWith = signature.endsWith(_string_1);
        Assert.assertTrue(_endsWith);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForXtendConstructor() {
    try {
      {
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
        String _hoverSignature = this.signatureProvider.getHoverSignature(xtendConstructor);
        final String signature = _hoverSignature;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("<b><image src=");
        String _string = _builder_1.toString();
        boolean _startsWith = signature.startsWith(_string);
        Assert.assertTrue(_startsWith);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(".metadata/.plugins/org.eclipse.jdt.ui/jdt-images/4.png\'/>testPackage.Foo (String a, int b)</b>");
        String _string_1 = _builder_2.toString();
        boolean _endsWith = signature.endsWith(_string_1);
        Assert.assertTrue(_endsWith);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSignatureForXtendDefaultConstructor() {
    try {
      {
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
        String _hoverSignature = this.signatureProvider.getHoverSignature(_constructor);
        final String signature = _hoverSignature;
        System.out.println(signature);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("<b><image src=");
        String _string = _builder_1.toString();
        boolean _startsWith = signature.startsWith(_string);
        Assert.assertTrue(_startsWith);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(".metadata/.plugins/org.eclipse.jdt.ui/jdt-images/4.png\'/>testPackage.Foo ()</b>");
        String _string_1 = _builder_2.toString();
        boolean _endsWith = signature.endsWith(_string_1);
        Assert.assertTrue(_endsWith);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ResourceSet getResourceSet() {
    Injector _injector = this.getInjector();
    IResourceSetProvider _instance = _injector.<IResourceSetProvider>getInstance(org.eclipse.xtext.ui.resource.IResourceSetProvider.class);
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
