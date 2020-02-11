/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.List;
import org.eclipse.lsp4j.CodeLens;
import org.eclipse.lsp4j.Position;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.testing.AbstractLanguageServerTest;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class CodeLensTest extends AbstractTestLangLanguageServerTest {
  @Test
  public void testCodeLens() {
    final Procedure1<AbstractLanguageServerTest.TestCodeLensConfiguration> _function = (AbstractLanguageServerTest.TestCodeLensConfiguration it) -> {
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
      final Procedure1<List<? extends CodeLens>> _function_1 = (List<? extends CodeLens> it_1) -> {
        this.assertEquals("Do Awesome Stuff(RESOLVED)", IterableExtensions.head(it_1).getCommand().getTitle());
        Object _data = IterableExtensions.head(it_1).getData();
        Assert.assertEquals(1, ((Position) _data).getLine());
      };
      it.setAssertCodeLenses(_function_1);
    };
    this.testCodeLens(_function);
  }
}
