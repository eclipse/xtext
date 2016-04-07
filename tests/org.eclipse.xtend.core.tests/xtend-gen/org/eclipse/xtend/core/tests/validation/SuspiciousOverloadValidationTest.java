/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.junit4.internal.LineDelimiters;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ISuspiciouslyOverloadedCandidate;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class SuspiciousOverloadValidationTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ParseHelper<XtendFile> _parseHelper;
  
  @Inject
  @Extension
  private IBatchTypeResolver _iBatchTypeResolver;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  protected void assertSuspicious(final CharSequence contents, final String... messageParts) {
    final XtendFile file = this.getParsedXtendFile(contents);
    Resource _eResource = file.eResource();
    final EList<Resource.Diagnostic> errors = _eResource.getErrors();
    String _string = errors.toString();
    int _size = errors.size();
    Assert.assertEquals(_string, 1, _size);
    Resource.Diagnostic _head = IterableExtensions.<Resource.Diagnostic>head(errors);
    final AbstractDiagnostic singleError = ((AbstractDiagnostic) _head);
    String _message = singleError.getMessage();
    String _code = singleError.getCode();
    Assert.assertEquals(_message, IssueCodes.SUSPICIOUSLY_OVERLOADED_FEATURE, _code);
    final Function1<String, String> _function = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        return LineDelimiters.toUnix(it);
      }
    };
    List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(messageParts)), _function);
    for (final String it : _map) {
      {
        final String message = singleError.getMessage();
        boolean _contains = message.contains(it);
        boolean _not = (!_contains);
        if (_not) {
          Assert.assertEquals(it, message);
        }
      }
    }
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration firstType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    EList<XtendMember> _members = firstType.getMembers();
    XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
    final XtendFunction firstMember = ((XtendFunction) _head_1);
    XExpression _expression = firstMember.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    TreeIterator<EObject> _eAllContents = block.eAllContents();
    Iterator<XAbstractFeatureCall> _filter = Iterators.<XAbstractFeatureCall>filter(_eAllContents, XAbstractFeatureCall.class);
    final Function1<XAbstractFeatureCall, Boolean> _function_1 = new Function1<XAbstractFeatureCall, Boolean>() {
      @Override
      public Boolean apply(final XAbstractFeatureCall it) {
        boolean _and = false;
        EStructuralFeature _eContainingFeature = it.eContainingFeature();
        boolean _notEquals = (!Objects.equal(_eContainingFeature, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER));
        if (!_notEquals) {
          _and = false;
        } else {
          JvmIdentifiableElement _feature = it.getFeature();
          _and = (_feature instanceof JvmOperation);
        }
        return Boolean.valueOf(_and);
      }
    };
    final XAbstractFeatureCall featureCall = IteratorExtensions.<XAbstractFeatureCall>findLast(_filter, _function_1);
    IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(file);
    final IFeatureLinkingCandidate linkingCandidate = _resolveTypes.getLinkingCandidate(featureCall);
    Assert.assertTrue((linkingCandidate instanceof ISuspiciouslyOverloadedCandidate));
  }
  
  protected void assertSuspiciousInInnerClass(final CharSequence contents, final String... messageParts) {
    final XtendFile file = this.getParsedXtendFile(contents);
    Resource _eResource = file.eResource();
    final EList<Resource.Diagnostic> errors = _eResource.getErrors();
    String _string = errors.toString();
    int _size = errors.size();
    Assert.assertEquals(_string, 1, _size);
    Resource.Diagnostic _head = IterableExtensions.<Resource.Diagnostic>head(errors);
    final AbstractDiagnostic singleError = ((AbstractDiagnostic) _head);
    String _message = singleError.getMessage();
    String _code = singleError.getCode();
    Assert.assertEquals(_message, IssueCodes.SUSPICIOUSLY_OVERLOADED_FEATURE, _code);
    final Function1<String, String> _function = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        return LineDelimiters.toUnix(it);
      }
    };
    List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(messageParts)), _function);
    for (final String it : _map) {
      {
        final String message = singleError.getMessage();
        boolean _contains = message.contains(it);
        boolean _not = (!_contains);
        if (_not) {
          Assert.assertEquals(it, message);
        }
      }
    }
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration firstType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    EList<XtendMember> _members = firstType.getMembers();
    XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
    final XtendClass innerType = ((XtendClass) _head_1);
    EList<XtendMember> _members_1 = innerType.getMembers();
    XtendMember _head_2 = IterableExtensions.<XtendMember>head(_members_1);
    final XtendFunction firstMember = ((XtendFunction) _head_2);
    XExpression _expression = firstMember.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    TreeIterator<EObject> _eAllContents = block.eAllContents();
    Iterator<XAbstractFeatureCall> _filter = Iterators.<XAbstractFeatureCall>filter(_eAllContents, XAbstractFeatureCall.class);
    final Function1<XAbstractFeatureCall, Boolean> _function_1 = new Function1<XAbstractFeatureCall, Boolean>() {
      @Override
      public Boolean apply(final XAbstractFeatureCall it) {
        boolean _and = false;
        EStructuralFeature _eContainingFeature = it.eContainingFeature();
        boolean _notEquals = (!Objects.equal(_eContainingFeature, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER));
        if (!_notEquals) {
          _and = false;
        } else {
          JvmIdentifiableElement _feature = it.getFeature();
          _and = (_feature instanceof JvmOperation);
        }
        return Boolean.valueOf(_and);
      }
    };
    final XAbstractFeatureCall featureCall = IteratorExtensions.<XAbstractFeatureCall>findLast(_filter, _function_1);
    IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(file);
    final IFeatureLinkingCandidate linkingCandidate = _resolveTypes.getLinkingCandidate(featureCall);
    Assert.assertTrue((linkingCandidate instanceof ISuspiciouslyOverloadedCandidate));
  }
  
  protected void assertValid(final CharSequence contents) {
    final XtendFile file = this.getParsedXtendFile(contents);
    Resource _eResource = file.eResource();
    final EList<Resource.Diagnostic> errors = _eResource.getErrors();
    String _string = errors.toString();
    int _size = errors.size();
    Assert.assertEquals(_string, 0, _size);
    this._validationTestHelper.assertNoErrors(file);
  }
  
  private XtendFile getParsedXtendFile(final CharSequence contents) {
    try {
      final XtendFile file = this._parseHelper.parse(contents);
      Resource _eResource = file.eResource();
      final EList<Resource.Diagnostic> errors = _eResource.getErrors();
      String _string = errors.toString();
      boolean _isEmpty = errors.isEmpty();
      Assert.assertTrue(_string, _isEmpty);
      EcoreUtil.resolveAll(file);
      return file;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSuspiciousMethods_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(D it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(String s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Suspiciously overloaded method.");
    _builder_1.newLine();
    _builder_1.append("The method");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(String) in C on \'this\'");
    _builder_1.newLine();
    _builder_1.append("overloads the method");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(CharSequence) in D on parameter \'it\'.");
    this.assertSuspicious(_builder, _builder_1.toString());
  }
  
  @Test
  public void testSuspiciousMethods_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class B {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m(extension A a) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("foo(\"\")");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def foo(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def foo(String s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Suspiciously overloaded method.");
    _builder_1.newLine();
    _builder_1.append("The method");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("foo(String) in A on parameter \'a\'");
    _builder_1.newLine();
    _builder_1.append("overloads the method");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("foo(CharSequence) in B on \'this\'.");
    this.assertSuspicious(_builder, _builder_1.toString());
  }
  
  @Test
  public void testSuspiciousMethods_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class B {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("new A => [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("foo(\"baz\")");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def foo(String str) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def foo(CharSequence chars) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Suspiciously overloaded method.");
    _builder_1.newLine();
    _builder_1.append("The method");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("foo(String) in B on \'this\'");
    _builder_1.newLine();
    _builder_1.append("overloads the method");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("foo(CharSequence) in A on parameter \'it\'.");
    this.assertSuspicious(_builder, _builder_1.toString());
  }
  
  @Test
  public void testSuspiciousMethods_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(StringBuilder b, D it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2(b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(Appendable a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(Object o) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Suspiciously overloaded method.");
    _builder_1.newLine();
    _builder_1.append("The method");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(Appendable) in C on \'this\'");
    _builder_1.newLine();
    _builder_1.append("overloads the method");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(Object) in D on parameter \'it\'.");
    this.assertSuspicious(_builder, _builder_1.toString());
  }
  
  @Test
  public void testSuspiciousMethods_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static class B {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def static void m(CharSequence c) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("m(\'\')");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void m(String s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Suspiciously overloaded method.");
    _builder_1.newLine();
    _builder_1.append("The method");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(String) in A");
    _builder_1.newLine();
    _builder_1.append("overloads the method");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(CharSequence) in B.");
    this.assertSuspiciousInInnerClass(_builder, _builder_1.toString());
  }
  
  @Test
  public void testValidOverloads_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class B {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def bar(A it) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("foo(\"\")");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def foo(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def foo(String s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertValid(_builder);
  }
  
  @Test
  public void testValidOverloads_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def foo(){}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class B {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def foo(){}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("new A => [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertValid(_builder);
  }
  
  @Test
  public void testValidOverloads_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static class B {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def static void m(CharSequence c) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("m(\'\')");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertValid(_builder);
  }
  
  @Test
  public void testValidOverloads_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static class B {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def void m(CharSequence c) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("m(\'\')");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void m(String s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertValid(_builder);
  }
}
