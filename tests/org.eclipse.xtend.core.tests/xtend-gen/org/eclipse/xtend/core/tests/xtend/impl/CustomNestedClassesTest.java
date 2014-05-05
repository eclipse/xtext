/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.xtend.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.tests.xtend.impl.CustomClassesTest;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
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
  protected XtendClass clazz(final String string) throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C { ");
    _builder.append(string, "");
    _builder.append(" }");
    XtendFile _file = this.file(_builder.toString());
    EList<XtendTypeDeclaration> _xtendTypes = _file.getXtendTypes();
    XtendTypeDeclaration _get = _xtendTypes.get(0);
    EList<XtendMember> _members = _get.getMembers();
    XtendMember _head = IterableExtensions.<XtendMember>head(_members);
    return ((XtendClass) _head);
  }
  
  protected XtendInterface interfaze(final String string) throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C { ");
    _builder.append(string, "");
    _builder.append(" }");
    XtendFile _file = this.file(_builder.toString());
    EList<XtendTypeDeclaration> _xtendTypes = _file.getXtendTypes();
    XtendTypeDeclaration _get = _xtendTypes.get(0);
    EList<XtendMember> _members = _get.getMembers();
    XtendMember _head = IterableExtensions.<XtendMember>head(_members);
    return ((XtendInterface) _head);
  }
  
  protected XtendEnum enumeration(final String string) throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C { ");
    _builder.append(string, "");
    _builder.append(" }");
    XtendFile _file = this.file(_builder.toString());
    EList<XtendTypeDeclaration> _xtendTypes = _file.getXtendTypes();
    XtendTypeDeclaration _get = _xtendTypes.get(0);
    EList<XtendMember> _members = _get.getMembers();
    XtendMember _head = IterableExtensions.<XtendMember>head(_members);
    return ((XtendEnum) _head);
  }
  
  protected XtendAnnotationType annotationType(final String string) throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C { ");
    _builder.append(string, "");
    _builder.append(" }");
    XtendFile _file = this.file(_builder.toString());
    EList<XtendTypeDeclaration> _xtendTypes = _file.getXtendTypes();
    XtendTypeDeclaration _get = _xtendTypes.get(0);
    EList<XtendMember> _members = _get.getMembers();
    XtendMember _head = IterableExtensions.<XtendMember>head(_members);
    return ((XtendAnnotationType) _head);
  }
  
  @Test
  public void testInterfaceFinalAndStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo {}");
      XtendInterface _interfaze = this.interfaze(_builder.toString());
      boolean _isFinal = _interfaze.isFinal();
      Assert.assertFalse(_isFinal);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("interface Foo {}");
      XtendInterface _interfaze_1 = this.interfaze(_builder_1.toString());
      boolean _isStatic = _interfaze_1.isStatic();
      Assert.assertTrue(_isStatic);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumFinalAndStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum Foo {}");
      XtendEnum _enumeration = this.enumeration(_builder.toString());
      boolean _isStatic = _enumeration.isStatic();
      Assert.assertTrue(_isStatic);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("enum Foo {}");
      XtendEnum _enumeration_1 = this.enumeration(_builder_1.toString());
      boolean _isFinal = _enumeration_1.isFinal();
      Assert.assertTrue(_isFinal);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnnotationTypeStaticAndFinal() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("static annotation Foo {}");
      XtendAnnotationType _annotationType = this.annotationType(_builder.toString());
      boolean _isStatic = _annotationType.isStatic();
      Assert.assertTrue(_isStatic);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final annotation Foo {}");
      XtendAnnotationType _annotationType_1 = this.annotationType(_builder_1.toString());
      boolean _isFinal = _annotationType_1.isFinal();
      Assert.assertFalse(_isFinal);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
