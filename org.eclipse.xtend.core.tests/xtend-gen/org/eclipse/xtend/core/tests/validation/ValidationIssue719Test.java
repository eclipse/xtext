/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;

/**
 * @author Eva Poell - Initial contribution
 */
@SuppressWarnings("all")
public class ValidationIssue719Test extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Inject
  @Extension
  private ParseHelper<XtendFile> _parseHelper;

  @Test
  public void namedAndDeclaredAbstract() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("abstract class AbstractC {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void namedAndNotDeclaredAbstract() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class AbstractC {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.warn(_builder);
  }

  @Test
  public void namedAndNotDeclaredAbstractPackage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package class AbstractC {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.warn(_builder);
  }

  @Test
  public void namedAndNotDeclaredAbstractFinal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("final class AbstractC {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.warn(_builder);
  }

  @Test
  public void namedAndNotDeclaredAbstractAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Depreciated");
    _builder.newLine();
    _builder.append("class AbstractX{");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.warn(_builder);
  }

  @Test
  public void namedAndNotDeclaredAbstractJavaDoc() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This is a doc for this abstract class.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* It even has two lines.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class AbstractX{");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.warn(_builder);
  }

  private void warn(final CharSequence input) {
    try {
      this._validationTestHelper.assertWarning(this._parseHelper.parse(input), XtendPackage.Literals.XTEND_CLASS, IssueCodes.MODIFIER_DOES_NOT_MATCH_TYPENAME, "not declared abstract");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
