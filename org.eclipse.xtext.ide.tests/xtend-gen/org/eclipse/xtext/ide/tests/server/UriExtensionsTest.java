/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.function.Consumer;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class UriExtensionsTest extends AbstractTestLangLanguageServerTest {
  @Test
  public void testFilesWithSpaces() {
    this.initialize();
    final String fileURI = this.getVirtualFile("Foo Bar.testlang");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type FooBar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.open(fileURI, _builder.toString());
    final Consumer<Diagnostic> _function = (Diagnostic it) -> {
      String _message = it.getMessage();
      String _plus = ("err: " + _message);
      InputOutput.<String>println(_plus);
    };
    this.getDiagnostics().get(fileURI).forEach(_function);
    Assert.assertTrue(this.getDiagnostics().get(fileURI).isEmpty());
  }
  
  @Test
  public void testFilesWithCyrillic() {
    this.initialize();
    final String fileURI = this.getVirtualFile("\u0424\u0443 \u0411\u0430\u0440.testlang");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type FooBar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.open(fileURI, _builder.toString());
    final Consumer<Diagnostic> _function = (Diagnostic it) -> {
      String _message = it.getMessage();
      String _plus = ("err: " + _message);
      InputOutput.<String>println(_plus);
    };
    this.getDiagnostics().get(fileURI).forEach(_function);
    Assert.assertTrue(this.getDiagnostics().get(fileURI).isEmpty());
  }
}

