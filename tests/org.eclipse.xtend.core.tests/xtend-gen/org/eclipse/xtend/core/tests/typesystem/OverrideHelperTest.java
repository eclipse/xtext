/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class OverrideHelperTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  private OverrideHelper overrideHelper;
  
  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;
  
  @Test
  public void checkFindOverriddenOperation_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("import java.util.Set");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo extends Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override bar(List<Object> list, ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Map<Object, Object> map,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var List<Object> blabla = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Set<Object> set");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super.bar(list, map, set)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void bar(List<Object> list, ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Map<Object, Object> map, ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Set<Object> set");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile xtendFile = this.fileWithErrors(_builder.toString());
    EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
    XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    EList<XtendMember> _members = _head.getMembers();
    Iterable<XtendFunction> _filter = Iterables.<XtendFunction>filter(_members, XtendFunction.class);
    XtendFunction _head_1 = IterableExtensions.<XtendFunction>head(_filter);
    EObject _primaryJvmElement = this._iJvmModelAssociations.getPrimaryJvmElement(_head_1);
    final JvmOperation operation = ((JvmOperation) _primaryJvmElement);
    JvmOperation _findOverriddenOperation = this.overrideHelper.findOverriddenOperation(operation);
    Assert.assertNull(_findOverriddenOperation);
  }
  
  @Test
  public void checkFindOverriddenOperation_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("import java.util.Map");
      _builder.newLine();
      _builder.append("import java.util.Set");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo extends Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override bar(List<Object> list, ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Map<Object, Object> map,");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Set<Object> set");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(") {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.bar(list, map, set)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar(List<Object> list, ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Map<Object, Object> map, ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Set<Object> set");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(") {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile xtendFile = this.file(_builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = _head.getMembers();
      Iterable<XtendFunction> _filter = Iterables.<XtendFunction>filter(_members, XtendFunction.class);
      XtendFunction _head_1 = IterableExtensions.<XtendFunction>head(_filter);
      EObject _primaryJvmElement = this._iJvmModelAssociations.getPrimaryJvmElement(_head_1);
      final JvmOperation operation = ((JvmOperation) _primaryJvmElement);
      JvmOperation _findOverriddenOperation = this.overrideHelper.findOverriddenOperation(operation);
      Assert.assertNotNull(_findOverriddenOperation);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected XtendFile fileWithErrors(final String content) {
    try {
      XtendFile _xblockexpression = null;
      {
        final String fileName = this.getFileName(content);
        XtextResourceSet _resourceSet = this.getResourceSet();
        URI _createURI = URI.createURI((fileName + ".xtend"));
        final Resource resource = _resourceSet.createResource(_createURI);
        StringInputStream _stringInputStream = new StringInputStream(content);
        resource.load(_stringInputStream, null);
        EList<EObject> _contents = resource.getContents();
        EObject _head = IterableExtensions.<EObject>head(_contents);
        _xblockexpression = ((XtendFile) _head);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
