/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.resource;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.resource.JvmElementAtOffsetHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmElementAtOffsetHelperTest extends AbstractXtendTestCase {
  @Inject
  private JvmElementAtOffsetHelper jvmElementAtOffsetHelper;

  @Test
  public void testdeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class TestCase {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def fo|o(String a){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("bar(a)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String content = _builder.toString();
      final XtendFile file = this.file(content.replace("|", ""));
      Resource _eResource = file.eResource();
      JvmIdentifiableElement jvmIdentifiableElement = this.jvmElementAtOffsetHelper.getJvmIdentifiableElement(((XtextResource) _eResource), 
        content.indexOf("|"));
      Assert.assertTrue((jvmIdentifiableElement instanceof JvmOperation));
      Assert.assertEquals("testPackage.TestCase.foo", jvmIdentifiableElement.getQualifiedName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testRef() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class TestCase {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo(String a){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("ba|r(a)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String content = _builder.toString();
      final XtendFile file = this.file(content.replace("|", ""));
      Resource _eResource = file.eResource();
      JvmIdentifiableElement jvmIdentifiableElement = this.jvmElementAtOffsetHelper.getJvmIdentifiableElement(((XtextResource) _eResource), 
        content.indexOf("|"));
      Assert.assertTrue((jvmIdentifiableElement instanceof JvmOperation));
      Assert.assertEquals("testPackage.TestCase.bar", jvmIdentifiableElement.getQualifiedName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testRefOtherClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package testPackage");
      _builder.newLine();
      _builder.append("class TestCase {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo(String a){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("a.toStr|ing");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String a){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String content = _builder.toString();
      final XtendFile file = this.file(content.replace("|", ""));
      Resource _eResource = file.eResource();
      JvmIdentifiableElement jvmIdentifiableElement = this.jvmElementAtOffsetHelper.getJvmIdentifiableElement(((XtextResource) _eResource), 
        content.indexOf("|"));
      Assert.assertTrue((jvmIdentifiableElement instanceof JvmOperation));
      Assert.assertEquals("java.lang.String.toString", jvmIdentifiableElement.getQualifiedName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
