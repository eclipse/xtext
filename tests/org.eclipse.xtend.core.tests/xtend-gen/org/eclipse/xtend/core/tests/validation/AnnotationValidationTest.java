/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnnotationValidationTest extends AbstractXtendTestCase {
  @Inject
  private ValidationTestHelper helper;
  
  @Inject
  private ParseHelper<XtendFile> parser;
  
  @Test
  public void testAnnotationValueTypeCheck_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation MyAnnotation {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("StringBuilder notAllowed");
      _builder.newLine();
      _builder.append("}");
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_ANNOTATION_VALUE_TYPE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnnotationValueTypeCheck_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation MyAnnotation {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Class<? extends StringBuilder>[] allowed1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String allowed2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("boolean allowed3");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int allowed4");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("javax.inject.Inject allowed5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.common.base.CaseFormat allowed6");
      _builder.newLine();
      _builder.append("}");
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnnotationValueTypeCheck_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation MyAnnotation {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String[][] notAllowed");
      _builder.newLine();
      _builder.append("}");
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_ANNOTATION_VALUE_TYPE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
