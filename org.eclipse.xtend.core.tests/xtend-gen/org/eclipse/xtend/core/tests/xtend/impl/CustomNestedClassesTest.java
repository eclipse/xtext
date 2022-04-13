/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.xtend.impl;

import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class CustomNestedClassesTest extends CustomClassesTest {
  @Override
  protected XtendClass clazz(final String string) throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C { ");
    _builder.append(string);
    _builder.append(" }");
    XtendMember _head = IterableExtensions.<XtendMember>head(this.file(_builder.toString()).getXtendTypes().get(0).getMembers());
    return ((XtendClass) _head);
  }

  @Override
  protected XtendInterface interfaze(final String string) throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C { ");
    _builder.append(string);
    _builder.append(" }");
    XtendMember _head = IterableExtensions.<XtendMember>head(this.file(_builder.toString()).getXtendTypes().get(0).getMembers());
    return ((XtendInterface) _head);
  }

  @Override
  protected XtendEnum enumeration(final String string) throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C { ");
    _builder.append(string);
    _builder.append(" }");
    XtendMember _head = IterableExtensions.<XtendMember>head(this.file(_builder.toString()).getXtendTypes().get(0).getMembers());
    return ((XtendEnum) _head);
  }

  @Override
  protected XtendAnnotationType annotationType(final String string) throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C { ");
    _builder.append(string);
    _builder.append(" }");
    XtendMember _head = IterableExtensions.<XtendMember>head(this.file(_builder.toString()).getXtendTypes().get(0).getMembers());
    return ((XtendAnnotationType) _head);
  }

  @Test
  @Override
  public void testInterfaceFinalAndStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo {}");
      Assert.assertFalse(this.interfaze(_builder.toString()).isFinal());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("interface Foo {}");
      Assert.assertTrue(this.interfaze(_builder_1.toString()).isStatic());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  @Override
  public void testEnumFinalAndStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum Foo {}");
      Assert.assertTrue(this.enumeration(_builder.toString()).isStatic());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("enum Foo {}");
      Assert.assertTrue(this.enumeration(_builder_1.toString()).isFinal());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  @Override
  public void testAnnotationTypeStaticAndFinal() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("static annotation Foo {}");
      Assert.assertTrue(this.annotationType(_builder.toString()).isStatic());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final annotation Foo {}");
      Assert.assertFalse(this.annotationType(_builder_1.toString()).isFinal());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
