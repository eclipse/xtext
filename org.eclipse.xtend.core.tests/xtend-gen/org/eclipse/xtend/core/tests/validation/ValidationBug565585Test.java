/**
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.util.ResourceHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;

/**
 * @author cdietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidationBug565585Test extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ResourceHelper resourceHelper;

  @Inject
  @Extension
  private ValidationTestHelper validationHelper;

  @Test
  public void testNoCrash() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Base {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch void doit(String a) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch void doit(Integer i) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Resource first = this.resourceHelper.resource(_builder, URI.createPlatformResourceURI("projectName/src/Base.xtend", true));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.newLine();
      _builder_1.append("class Sub extends Base {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch void doit(Byte a) {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void doit(Long s) { ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final Resource second = this.resourceHelper.resource(_builder_1, URI.createPlatformResourceURI("projectName/src/Sub.xtend", true), first.getResourceSet());
      this.validationHelper.assertNoErrors(second);
      this.validationHelper.assertWarning(second, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.DISPATCH_PLAIN_FUNCTION_NAME_CLASH, 
        "Non-dispatch method has same name and number of parameters as dispatch method");
      this.validationHelper.assertWarning(second, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.DISPATCH_PLAIN_FUNCTION_NAME_CLASH, 
        "Dispatch method has same name and number of parameters as non-dispatch method");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
