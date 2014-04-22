package org.eclipse.xtend.ide.tests.hover;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.Iterator;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend.ide.tests.hover.TestingXbaseHoverProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendHoverDocumentationProviderTest extends AbstractXtendUITestCase {
  @Inject
  private ParseHelper<XtendFile> parseHelper;
  
  @Inject
  private WorkbenchTestHelper testHelper;
  
  @Inject
  private IEObjectHoverDocumentationProvider documentationProvider;
  
  @Inject
  private TestingXbaseHoverProvider hoverProvider;
  
  @Inject
  private IXtendJvmAssociations jvmModelAssociations;
  
  /**
   * https://bugs.eclipse.org/bugs/show_bug.cgi?id=390429
   */
  @Test
  public void bug390429WithoutDeclaringTypeAndOneTargetMethod() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("* {@link #foo}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def bar(String a, String b) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _last = IterableExtensions.<XtendMember>last(_members);
      final XtendFunction function = ((XtendFunction) _last);
      final String docu = this.documentationProvider.getDocumentation(function);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<code><a href=\"eclipse-xtext-doc:__synthetic0.xtend%23/1/@members.1\">#foo</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>");
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, docu);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * https://bugs.eclipse.org/bugs/show_bug.cgi?id=390429
   */
  @Test
  public void bug390429WithoutDeclaringType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def foo(String string) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def foo(Object object) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("* {@link #foo(Object)}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def bar(String a, String b) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _last = IterableExtensions.<XtendMember>last(_members);
      final XtendFunction function = ((XtendFunction) _last);
      final String docu = this.documentationProvider.getDocumentation(function);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<code><a href=\"eclipse-xtext-doc:__synthetic0.xtend%23/1/@members.2\">#foo(Object)</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>");
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, docu);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * https://bugs.eclipse.org/bugs/show_bug.cgi?id=390429
   */
  @Test
  public void bug390429WithoutDeclaringTypeAndParameters() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def foo(String string) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def foo(Object object) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("* {@link #foo}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def bar(String a, String b) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _last = IterableExtensions.<XtendMember>last(_members);
      final XtendFunction function = ((XtendFunction) _last);
      final String docu = this.documentationProvider.getDocumentation(function);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<code><a href=\"eclipse-xtext-doc:__synthetic0.xtend%23/1/@members.1\">#foo</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>");
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, docu);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * https://bugs.eclipse.org/bugs/show_bug.cgi?id=390429
   */
  @Test
  public void bug390429WithoutDeclaringTypeAndMissingClosingParenthesis() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def foo(String string) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def foo(Object object) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("* {@link #foo(}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def bar(String a, String b) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _last = IterableExtensions.<XtendMember>last(_members);
      final XtendFunction function = ((XtendFunction) _last);
      final String docu = this.documentationProvider.getDocumentation(function);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<code><a href=\"eclipse-xtext-doc:__synthetic0.xtend%23/1/@members.1\"> #foo(");
      boolean _startsWith = docu.startsWith(_builder_1.toString());
      Assert.assertTrue(_startsWith);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>");
      boolean _endsWith = docu.endsWith(_builder_2.toString());
      Assert.assertTrue(_endsWith);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSimpleJavaDocWithMixedParameters() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* SimpleJavaDoc");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* @param a something");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a, String b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      final XtendFunction member = this.getFirstMethod(xtendFile);
      final String docu = this.documentationProvider.getDocumentation(member);
      Assert.assertEquals("SimpleJavaDoc<dl><dt>Parameters:</dt><dd><b>a</b>  something</dd><dd><b>b</b> </dd></dl>", docu);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public XtendFunction getFirstMethod(final XtendFile file) {
    TreeIterator<EObject> _eAllContents = file.eAllContents();
    Iterator<XtendFunction> _filter = Iterators.<XtendFunction>filter(_eAllContents, XtendFunction.class);
    return IteratorExtensions.<XtendFunction>head(_filter);
  }
  
  @Test
  public void testSimpleJavaDocWithSeeAndAuthor() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("import java.util.Collections");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* SimpleJavaDoc");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* @see Collections");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* @see java.util.List");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* @author FooBar");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* @since 2.3");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* @deprecated");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a, String b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      final XtendFunction member = this.getFirstMethod(xtendFile);
      final String docu = this.documentationProvider.getDocumentation(member);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<p><b>Deprecated.</b> <i></i></p>SimpleJavaDoc<dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd><dt>Since:</dt><dd> 2.3</dd><dt>Author:</dt><dd> FooBar</dd><dt>See Also:</dt><dd><a href=\"eclipse-xtext-doc:java:/Objects/java.util.Collections%23java.util.Collections\">Collections</a></dd><dd><a href=\"eclipse-xtext-doc:java:/Objects/java.util.List%23java.util.List\">java.util.List</a></dd></dl>");
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, docu);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSimpleJavaDocWithMixedExceptions() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* SimpleJavaDoc");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* @throws NullPointerException not so good");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a, String b) throws NullPointerException, RuntimeException{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      final XtendFunction member = this.getFirstMethod(xtendFile);
      final String docu = this.documentationProvider.getDocumentation(member);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("SimpleJavaDoc<dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd><dt>Throws:</dt><dd><a href=\"eclipse-xtext-doc:java:/Objects/java.lang.NullPointerException%23java.lang.NullPointerException\">NullPointerException</a> -  not so good</dd><dd><a href=\"eclipse-xtext-doc:java:/Objects/java.lang.RuntimeException%23java.lang.RuntimeException\">RuntimeException</a></dd></dl>");
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, docu);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJavaDocWithLinkWithOutLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* SimpleJavaDoc");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* {@link java.util.Collections}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a, String b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      final XtendFunction member = this.getFirstMethod(xtendFile);
      final String docu = this.documentationProvider.getDocumentation(member);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("SimpleJavaDoc");
      _builder_1.newLine();
      _builder_1.append("<code><a href=\"eclipse-xtext-doc:java:/Objects/java.util.Collections%23java.util.Collections\">java.util.Collections</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>");
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, docu);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJavaDocWithLinkWithLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* SimpleJavaDoc");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* {@link java.util.Collections label foo bar}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a, String b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      final XtendFunction member = this.getFirstMethod(xtendFile);
      final String docu = this.documentationProvider.getDocumentation(member);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("SimpleJavaDoc");
      _builder_1.newLine();
      _builder_1.append("<code><a href=\"eclipse-xtext-doc:java:/Objects/java.util.Collections%23java.util.Collections\"> label foo bar</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>");
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, docu);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJavaDocWithBrokenLink() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* SimpleJavaDoc");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* {@link Collections}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a, String b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      final XtendFunction member = this.getFirstMethod(xtendFile);
      final String docu = this.documentationProvider.getDocumentation(member);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("SimpleJavaDoc");
      _builder_1.newLine();
      _builder_1.append("<code>Collections</code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>");
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, docu);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJavaDocWithLinkToMethodWithoutLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* SimpleJavaDoc");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* {@link java.util.Collections#sort(java.util.List)}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a, String b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      final XtendFunction member = this.getFirstMethod(xtendFile);
      final String docu = this.documentationProvider.getDocumentation(member);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("SimpleJavaDoc");
      _builder_1.newLine();
      _builder_1.append("<code><a href=\"eclipse-xtext-doc:java:/Objects/java.util.Collections%23java.util.Collections.sort(java.util.List)\">java.util.Collections#sort(java.util.List)</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>");
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, docu);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJavaDocWithLinkToMethodWithLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* SimpleJavaDoc");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* {@link java.util.Collections#sort(java.util.List) label foo bar}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a, String b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      final XtendFunction member = this.getFirstMethod(xtendFile);
      final String docu = this.documentationProvider.getDocumentation(member);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("SimpleJavaDoc");
      _builder_1.newLine();
      _builder_1.append("<code><a href=\"eclipse-xtext-doc:java:/Objects/java.util.Collections%23java.util.Collections.sort(java.util.List)\"> label foo bar</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>");
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, docu);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJavaDocWithLinkToXtendFunction() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* SimpleJavaDoc");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* {@link testpackage.Foo#foo(java.util.List)}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a, String b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo(List a)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      final XtendFunction member = this.getFirstMethod(xtendFile);
      final String docu = this.documentationProvider.getDocumentation(member);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("SimpleJavaDoc");
      _builder_1.newLine();
      _builder_1.append("<code><a href=\"eclipse-xtext-doc:__synthetic0.xtend%23/1/@members.2\">testpackage.Foo#foo(java.util.List)</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>");
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, docu);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJavaDocWithLinkToXtendFunctionOnReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* SimpleJavaDoc");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* {@link testpackage.Foo#foo(java.util.List)}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a, String b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo(List a){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("bar(\"42\",\"43\")");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      XtendClass _head = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _get = _members.get(1);
      final XtendFunction function = ((XtendFunction) _get);
      XExpression _expression = function.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      XExpression _get_1 = _expressions.get(0);
      final XAbstractFeatureCall call = ((XAbstractFeatureCall) _get_1);
      JvmIdentifiableElement _feature = call.getFeature();
      final String docu = this.documentationProvider.getDocumentation(_feature);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("SimpleJavaDoc");
      _builder_1.newLine();
      _builder_1.append("<code><a href=\"eclipse-xtext-doc:__synthetic0.xtend%23/1/@members.2\">testpackage.Foo#foo(java.util.List)</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>");
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, docu);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void bug380551() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("@A");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("annotation A {}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      final String docu = this.documentationProvider.getDocumentation(clazz);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@<a href=\"eclipse-xtext-doc:__synthetic0.xtend%23/2\">A</a><br>");
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, docu);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void bug380551_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("@A");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(Foo x){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("annotation A {}");
      _builder.newLine();
      ResourceSet _resourceSet = this.getResourceSet();
      final XtendFile xtendFile = this.parseHelper.parse(_builder, _resourceSet);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      Iterable<XtendClass> _filter = Iterables.<XtendClass>filter(_xtendTypes, XtendClass.class);
      final XtendClass clazz = IterableExtensions.<XtendClass>head(_filter);
      EList<XtendMember> _members = clazz.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      final XtendFunction func = ((XtendFunction) _head);
      EList<XtendParameter> _parameters = func.getParameters();
      XtendParameter _head_1 = IterableExtensions.<XtendParameter>head(_parameters);
      JvmTypeReference _parameterType = _head_1.getParameterType();
      JvmType _type = _parameterType.getType();
      final String docu = this.documentationProvider.getDocumentation(_type);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@<a href=\"eclipse-xtext-doc:__synthetic0.xtend%23/2\">A</a><br>");
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, docu);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void bug380551_TestLinkToNativeJavaType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testpackage");
      _builder.newLine();
      _builder.append("import javax.annotation.Resource");
      _builder.newLine();
      _builder.append("@Resource");
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
      JvmGenericType _inferredType = this.jvmModelAssociations.getInferredType(clazz);
      final JvmAnnotationTarget target = ((JvmAnnotationTarget) _inferredType);
      EList<JvmAnnotationReference> _annotations = target.getAnnotations();
      JvmAnnotationReference _head = IterableExtensions.<JvmAnnotationReference>head(_annotations);
      JvmAnnotationType _annotation = _head.getAnnotation();
      XtextBrowserInformationControlInput _hoverInfo = this.hoverProvider.getHoverInfo(_annotation);
      Assert.assertNotNull(_hoverInfo);
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
