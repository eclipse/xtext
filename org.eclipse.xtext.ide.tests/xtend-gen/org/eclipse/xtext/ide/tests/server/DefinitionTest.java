/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.testing.DefinitionTestConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefinitionTest extends AbstractTestLangLanguageServerTest {
  @Test
  public void testDefinition_01() {
    final Procedure1<DefinitionTestConfiguration> _function = (DefinitionTestConfiguration it) -> {
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
      it.setLine(2);
      it.setColumn(3);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("MyModel.testlang [[0, 5] .. [0, 8]]");
      _builder_1.newLine();
      it.setExpectedDefinitions(_builder_1.toString());
    };
    this.testDefinition(_function);
  }
}
