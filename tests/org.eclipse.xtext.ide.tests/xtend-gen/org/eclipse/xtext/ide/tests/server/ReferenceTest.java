/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.testing.ReferenceTestConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class ReferenceTest extends AbstractTestLangLanguageServerTest {
  @Test
  public void testReferences_01() {
    final Procedure1<ReferenceTestConfiguration> _function = (ReferenceTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo {}");
      _builder.newLine();
      _builder.append("type Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      int _length = "type F".length();
      it.setColumn(_length);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("MyModel.testlang [[2, 1] .. [2, 4]]");
      _builder_1.newLine();
      it.setExpectedReferences(_builder_1.toString());
    };
    this.testReferences(_function);
  }
  
  @Test
  public void testReferences_02() {
    final Procedure1<ReferenceTestConfiguration> _function = (ReferenceTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo {}");
      _builder.newLine();
      _builder.append("type Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      int _length = "type F".length();
      it.setColumn(_length);
      it.setIncludeDeclaration(true);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("MyModel.testlang [[0, 5] .. [0, 8]]");
      _builder_1.newLine();
      _builder_1.append("MyModel.testlang [[2, 1] .. [2, 4]]");
      _builder_1.newLine();
      it.setExpectedReferences(_builder_1.toString());
    };
    this.testReferences(_function);
  }
}
