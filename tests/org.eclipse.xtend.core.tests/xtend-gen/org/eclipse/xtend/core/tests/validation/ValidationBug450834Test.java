/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidationBug450834Test extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ValidationTestHelper helper;
  
  @Inject
  private ParseHelper<XtendFile> parser;
  
  @Test
  public void test_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static val c1 = 5");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile c = this.parser.parse(_builder);
      Resource _eResource = c.eResource();
      final ResourceSet resourceSet = _eResource.getResourceSet();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class D {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public static val d1 = 5");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void m() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("if (C.c1 == D.d1) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final XtendFile d = this.parser.parse(_builder_1, resourceSet);
      this.helper.assertWarning(d, XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.CONSTANT_BOOLEAN_CONDITION, "Constant condition is always true");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
