/**
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.hover;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.util.ParseHelper;
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
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final Iterable<XtendClass> clazz = Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class);
      XtendMember _get = IterableExtensions.<XtendClass>head(clazz).getMembers().get(0);
      final XtendFunction function = ((XtendFunction) _get);
      XExpression _expression = function.getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      XExpression _get_1 = expression.getExpressions().get(0);
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
      final XtendFile xtendFile = this.parseHelper.parse(_builder, this.getResourceSet());
      final Iterable<XtendClass> clazz = Iterables.<XtendClass>filter(xtendFile.getXtendTypes(), XtendClass.class);
      XtendMember _get = IterableExtensions.<XtendClass>head(clazz).getMembers().get(0);
      final XtendFunction function = ((XtendFunction) _get);
      XExpression _expression = function.getExpression();
      final XBlockExpression expression = ((XBlockExpression) _expression);
      XExpression _get_1 = expression.getExpressions().get(0);
      final XAbstractFeatureCall call = ((XAbstractFeatureCall) _get_1);
      final String resolvedSignature = this.signatureProvider.getSignature(call);
      Assert.assertEquals("<String, Foo, RuntimeException> Foo Foo.something(Iterable<String> iterable, Foo type1, String type2) throws RuntimeException", resolvedSignature);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public ResourceSet getResourceSet() {
    return this.getInjector().<IResourceSetProvider>getInstance(IResourceSetProvider.class).get(this.testHelper.getProject());
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
