package org.eclipse.xtend.ide.tests.hover;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.ui.hover.HoverGenericsResolver;
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
  private HoverGenericsResolver hoverGenericsResolver;
  
  @Inject
  private XbaseDeclarativeHoverSignatureProvider signatureProvider;
  
  @Inject
  private IJavaElementFinder javaElementFinder;
  
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
      final JvmIdentifiableElement feature = call.getFeature();
      final String originalSignature = this.signatureProvider.getSignature(feature);
      String _replaceGenerics = this.hoverGenericsResolver.replaceGenerics(call, originalSignature);
      Assert.assertEquals("<String> String something(Iterable<String> iterable)", _replaceGenerics);
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
      _builder.append("def <T,Y> Y something(Iterable<T> iterable, Y type1, T type2)");
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
      final JvmIdentifiableElement feature = call.getFeature();
      final String originalSignature = this.signatureProvider.getSignature(feature);
      String _replaceGenerics = this.hoverGenericsResolver.replaceGenerics(call, originalSignature);
      Assert.assertEquals("<String, Foo> Foo something(Iterable<String> iterable, Foo type1, String type2)", _replaceGenerics);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGenerics_in_html_from_Java() {
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
      _builder.append("newArrayList(\"sd\").head");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
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
      final JvmIdentifiableElement feature = call.getFeature();
      final IJavaElement javaElement = this.javaElementFinder.findElementFor(feature);
      final String prefix = "something <T>T<T>T this is html";
      final String suffix = " and at the END TOOOOOOOO";
      final String originalSignature = this.hoverGenericsResolver.getJavaSignature(javaElement);
      String _replaceAll = originalSignature.replaceAll("\\bT\\b", "String");
      String _plus = (prefix + _replaceAll);
      String _plus_1 = (_plus + suffix);
      String _resolveSignatureInHtml = this.hoverGenericsResolver.resolveSignatureInHtml(call, javaElement, ((prefix + originalSignature) + suffix));
      Assert.assertEquals(_plus_1, _resolveSignatureInHtml);
    } catch (Throwable _e) {
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
  
  @After
  public void cleanup() {
    try {
      this.testHelper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
