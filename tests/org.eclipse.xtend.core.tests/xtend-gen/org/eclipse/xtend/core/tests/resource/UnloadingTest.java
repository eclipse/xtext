/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.resource;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class UnloadingTest extends AbstractXtendTestCase {
  @Test
  public void testProperUnloading() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new A(this)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String fileB = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class A {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("new (B b) {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Iterable<XtendFile> _files = this.files(true, _builder_1.toString(), fileB);
      final List<XtendFile> parsedFiles = IterableExtensions.<XtendFile>toList(_files);
      XtendFile _get = parsedFiles.get(1);
      Resource _eResource = _get.eResource();
      final DerivedStateAwareResource resource = ((DerivedStateAwareResource) _eResource);
      XtendFile _head = IterableExtensions.<XtendFile>head(parsedFiles);
      final Resource resourceA = _head.eResource();
      resource.reparse(fileB);
      EList<EObject> _contents = resourceA.getContents();
      EObject _head_1 = IterableExtensions.<EObject>head(_contents);
      final XtendFile file = ((XtendFile) _head_1);
      EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
      XtendTypeDeclaration _head_2 = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = ((XtendClass) _head_2).getMembers();
      XtendMember _head_3 = IterableExtensions.<XtendMember>head(_members);
      EList<XtendParameter> _parameters = ((XtendConstructor) _head_3).getParameters();
      XtendParameter _head_4 = IterableExtensions.<XtendParameter>head(_parameters);
      JvmTypeReference _parameterType = _head_4.getParameterType();
      JvmType _type = _parameterType.getType();
      Resource _eResource_1 = _type.eResource();
      Assert.assertNotNull(_eResource_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
