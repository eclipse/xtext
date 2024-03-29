/**
 * Copyright (c) 2016, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * @author dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidationBug471580Test extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Inject
  @Extension
  private ParseHelper<XtendFile> _parseHelper;

  @Test
  public void testBug471580() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.Vector");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m(Vector<?> items) {");
      _builder.newLine();
      _builder.append("\t \t");
      _builder.append("m(#[\'a\'])");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XLIST_LITERAL, 
        IssueCodes.INCOMPATIBLE_TYPES, 
        "Type mismatch: cannot convert from List<Object> to Vector<?>");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
