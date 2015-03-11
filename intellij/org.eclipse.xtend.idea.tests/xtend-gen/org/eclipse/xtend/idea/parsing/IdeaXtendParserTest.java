/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.parsing;

import org.eclipse.xtend.core.tests.parsing.ParserTest;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@FinalFieldsConstructor
@Ignore("Only here as a delegate")
@SuppressWarnings("all")
public class IdeaXtendParserTest extends ParserTest {
  private final ModelChecker modelChecker;
  
  @Override
  public XtendFile file(final String string, final boolean validate) {
    return this.modelChecker.<XtendFile>checkModel(string, validate);
  }
  
  @Test
  public void testErrorRecovery() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo2323 {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def create val result = newArrayList foo() {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("result.");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.file(_builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IdeaXtendParserTest(final ModelChecker modelChecker) {
    super();
    this.modelChecker = modelChecker;
  }
}
