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
      final TestLangLSPExtension ext = ServiceEndpoints.<TestLangLSPExtension>toServiceObject(this.languageServer, TestLangLSPExtension.class);
      ext.sayHello();
      try {
        ext.sayHello();
        Assert.fail("Expected exception on second call.");
      } catch (final Throwable _t) {
        if (_t instanceof RuntimeException) {
          final RuntimeException e = (RuntimeException)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      TestLangLSPExtension.Text _text = new TestLangLSPExtension.Text();
      final Procedure1<TestLangLSPExtension.Text> _function = (TestLangLSPExtension.Text it) -> {
        it.text = "World!";
      };
      TestLangLSPExtension.Text _doubleArrow = ObjectExtensions.<TestLangLSPExtension.Text>operator_doubleArrow(_text, _function);
      final CompletableFuture<TestLangLSPExtension.Text> result = ext.getFullText(_doubleArrow);
      TestLangLSPExtension.Text _get = result.get();
      Assert.assertEquals("Hello World!", _get.text);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
