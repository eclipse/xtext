/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.concurrent.CompletableFuture;
import org.eclipse.lsp4j.jsonrpc.services.ServiceEndpoints;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.ide.tests.testlanguage.ide.TestLangLSPExtension;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class LspExtensionTest extends AbstractTestLangLanguageServerTest {
  @Test
  public void testExtension() {
    try {
      this.initialize();
      final TestLangLSPExtension ext = ServiceEndpoints.<TestLangLSPExtension>toServiceObject(this.languageServer, TestLangLSPExtension.class);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo bar");
      _builder.newLine();
      _builder.append("baz test");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("bla blubb");
      _builder.newLine();
      final String fileURI = this.writeFile("mydoc.testlang", _builder);
      TestLangLSPExtension.TextOfLineParam _textOfLineParam = new TestLangLSPExtension.TextOfLineParam();
      final Procedure1<TestLangLSPExtension.TextOfLineParam> _function = (TestLangLSPExtension.TextOfLineParam it) -> {
        it.uri = fileURI;
        it.line = 1;
      };
      TestLangLSPExtension.TextOfLineParam _doubleArrow = ObjectExtensions.<TestLangLSPExtension.TextOfLineParam>operator_doubleArrow(_textOfLineParam, _function);
      CompletableFuture<TestLangLSPExtension.TextOfLineResult> _textOfLine = ext.getTextOfLine(_doubleArrow);
      final TestLangLSPExtension.TextOfLineResult result = _textOfLine.get();
      Assert.assertEquals("baz test", result.text);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
