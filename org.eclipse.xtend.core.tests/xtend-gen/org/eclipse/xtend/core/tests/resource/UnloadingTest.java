/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.resource;

import java.util.List;
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
      final List<XtendFile> parsedFiles = IterableExtensions.<XtendFile>toList(this.files(true, _builder_1.toString(), fileB));
      Resource _eResource = parsedFiles.get(1).eResource();
      final DerivedStateAwareResource resource = ((DerivedStateAwareResource) _eResource);
      final Resource resourceA = IterableExtensions.<XtendFile>head(parsedFiles).eResource();
      resource.reparse(fileB);
      EObject _head = IterableExtensions.<EObject>head(resourceA.getContents());
      final XtendFile file = ((XtendFile) _head);
      XtendTypeDeclaration _head_1 = IterableExtensions.<XtendTypeDeclaration>head(file.getXtendTypes());
      XtendMember _head_2 = IterableExtensions.<XtendMember>head(((XtendClass) _head_1).getMembers());
      Assert.assertNotNull(IterableExtensions.<XtendParameter>head(((XtendConstructor) _head_2).getParameters()).getParameterType().getType().eResource());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
