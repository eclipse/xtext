/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.javadoc;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Joerg Reichert - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendDocumentationProviderTest extends AbstractXtendTestCase {
  @Inject
  private IEObjectDocumentationProvider documentationProvider;
  
  @Test
  public void testComputation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* my javadoc comment");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* my multi line comment");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/ ");
    _builder.newLine();
    _builder.append("class Foo{}");
    _builder.newLine();
    this.assertClassDocumentation(_builder, "my javadoc comment");
  }
  
  @Test
  public void testComputation_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* my multi line comment");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/ ");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* my javadoc comment");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo{}");
    _builder.newLine();
    this.assertClassDocumentation(_builder, "my javadoc comment");
  }
  
  @Test
  public void testComputation_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* my javadoc comment");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("/*************************");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* my copyright comment");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("************************/ ");
    _builder.newLine();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo{}");
    _builder.newLine();
    this.assertFileDocumentation(_builder, "my javadoc comment");
  }
  
  @Test
  public void testComputation_4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*************************");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* my copyright comment");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("************************/ ");
    _builder.newLine();
    _builder.append("/**my javadoc comment*/");
    _builder.newLine();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo{}");
    _builder.newLine();
    this.assertFileDocumentation(_builder, "my javadoc comment");
  }
  
  @Test
  public void testComputation_5() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/***my copyright comment*/ ");
    _builder.newLine();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo{}");
    _builder.newLine();
    this.assertFileDocumentation(_builder, null);
  }
  
  private void assertFileDocumentation(final CharSequence input, final String expectedDocumentation) {
    try {
      String _string = input.toString();
      XtendFile _file = this.file(_string);
      this.assertDocumentation(_file, expectedDocumentation);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertClassDocumentation(final CharSequence input, final String expectedDocumentation) {
    try {
      String _string = input.toString();
      XtendClass _clazz = this.clazz(_string);
      this.assertDocumentation(_clazz, expectedDocumentation);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertDocumentation(final EObject eObject, final String expectedDocumentation) {
    final String actualDocumentation = this.documentationProvider.getDocumentation(eObject);
    Assert.assertEquals(expectedDocumentation, actualDocumentation);
  }
}
