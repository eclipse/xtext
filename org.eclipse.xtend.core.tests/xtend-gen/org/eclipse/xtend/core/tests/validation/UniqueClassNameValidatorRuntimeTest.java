/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.util.ResourceHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class UniqueClassNameValidatorRuntimeTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ParseHelper<XtendFile> parseHelper;

  @Inject
  @Extension
  private ResourceHelper resourceHelper;

  @Inject
  @Extension
  private ValidationTestHelper validationHelper;

  @Test
  public void testSameFile() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface C {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.validationHelper.assertError(this.parseHelper.parse(_builder), XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.DUPLICATE_TYPE, "The type C is already defined.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testNestedFile() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("interface C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.validationHelper.assertError(this.parseHelper.parse(_builder), XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.DUPLICATE_TYPE, "Duplicate nested type C");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testTwoFilesSameProject() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {}");
      _builder.newLine();
      final Resource first = this.resourceHelper.resource(_builder, URI.createPlatformResourceURI("projectName/src/C1.xtend", true));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("interface C {}");
      _builder_1.newLine();
      final Resource second = this.resourceHelper.resource(_builder_1, URI.createPlatformResourceURI("projectName/src/C2.xtend", true), first.getResourceSet());
      this.validationHelper.assertError(first, XtendPackage.Literals.XTEND_CLASS, IssueCodes.DUPLICATE_TYPE, "The type C is already defined in C2.xtend.");
      this.validationHelper.assertError(second, XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.DUPLICATE_TYPE, "The type C is already defined in C1.xtend.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
