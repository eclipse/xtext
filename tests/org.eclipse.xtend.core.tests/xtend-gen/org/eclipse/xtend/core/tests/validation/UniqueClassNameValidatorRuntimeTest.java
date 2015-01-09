/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.util.ResourceHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
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
      XtendFile _parse = this.parseHelper.parse(_builder);
      this.validationHelper.assertError(_parse, XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.DUPLICATE_TYPE, "The type C is already defined.");
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
      XtendFile _parse = this.parseHelper.parse(_builder);
      this.validationHelper.assertError(_parse, XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.DUPLICATE_TYPE, "Duplicate nested type C");
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
      URI _createPlatformResourceURI = URI.createPlatformResourceURI("projectName/src/C1.xtend", true);
      final Resource first = this.resourceHelper.resource(_builder, _createPlatformResourceURI);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("interface C {}");
      _builder_1.newLine();
      URI _createPlatformResourceURI_1 = URI.createPlatformResourceURI("projectName/src/C2.xtend", true);
      ResourceSet _resourceSet = first.getResourceSet();
      final Resource second = this.resourceHelper.resource(_builder_1, _createPlatformResourceURI_1, _resourceSet);
      this.validationHelper.assertError(first, XtendPackage.Literals.XTEND_CLASS, IssueCodes.DUPLICATE_TYPE, "The type C is already defined in C2.xtend.");
      this.validationHelper.assertError(second, XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.DUPLICATE_TYPE, "The type C is already defined in C1.xtend.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
