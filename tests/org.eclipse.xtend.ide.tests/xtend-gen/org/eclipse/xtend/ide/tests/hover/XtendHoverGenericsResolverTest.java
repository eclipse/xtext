package org.eclipse.xtend.ide.tests.hover;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.ui.hover.XbaseDeclarativeHoverSignatureProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendHoverGenericsResolverTest extends AbstractXtendUITestCase {
  @Inject
  private ParseHelper<XtendFile> parseHelper;
  
  @Inject
  private WorkbenchTestHelper testHelper;
  
  @Inject
  private XbaseDeclarativeHoverSignatureProvider signatureProvider;
  
  @Test
  public void testGenerics_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("newArrayList(\"sd\").something");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T> T something(Iterable<T> iterable)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final Iterable<XtendClass> clazz = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(clazz);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _get = _members.get(0);
      final XtendFunction function = ((XtendFunction) _get);
      XExpression _expression = function.getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = expression.getExpressions();
      XExpression _get_1 = _expressions.get(0);
      final XAbstractFeatureCall call = ((XAbstractFeatureCall) _get_1);
      final String resolvedSignature = this.signatureProvider.getSignature(call);
      Assert.assertEquals("<String> String Foo.something(Iterable<String> iterable)", resolvedSignature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGenerics_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("something(newArrayList(\"zonk\"), new Foo(),\"42\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T,Y,E extends RuntimeException> Y something(Iterable<T> iterable, Y type1, T type2) throws E");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      final Iterable<XtendClass> clazz = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(clazz);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _get = _members.get(0);
      final XtendFunction function = ((XtendFunction) _get);
      XExpression _expression = function.getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = expression.getExpressions();
      XExpression _get_1 = _expressions.get(0);
      final XAbstractFeatureCall call = ((XAbstractFeatureCall) _get_1);
      final String resolvedSignature = this.signatureProvider.getSignature(call);
      Assert.assertEquals("<String, Foo, RuntimeException> Foo Foo.something(Iterable<String> iterable, Foo type1, String type2) throws RuntimeException", resolvedSignature);
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
