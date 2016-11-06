/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide;

import com.google.inject.ImplementedBy;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import org.eclipse.lsp4j.jsonrpc.CancelIndicator;
import org.eclipse.lsp4j.jsonrpc.CompletableFutures;
import org.eclipse.lsp4j.jsonrpc.services.JsonNotification;
import org.eclipse.lsp4j.jsonrpc.services.JsonRequest;
import org.eclipse.xtext.ide.server.LanguageServerExtension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author efftinge - Initial contribution and API
 */
@ImplementedBy(TestLangLSPExtension.Impl.class)
@SuppressWarnings("all")
public interface TestLangLSPExtension extends LanguageServerExtension {
  public static class Text {
    public String text;
  }
  
  public static class Impl implements LanguageServerExtension, TestLangLSPExtension {
    private String text = "";
    
    @Override
    public void sayHello() {
      int _length = this.text.length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        throw LanguageServerExtension.NOT_HANDLED_EXCEPTION;
      }
      String _text = this.text;
      this.text = (_text + "Hello ");
    }
    
    @Override
    public CompletableFuture<TestLangLSPExtension.Text> getFullText(final TestLangLSPExtension.Text param) {
      final Function<CancelIndicator, TestLangLSPExtension.Text> _function = (CancelIndicator it) -> {
        TestLangLSPExtension.Text _text = new TestLangLSPExtension.Text();
        final Procedure1<TestLangLSPExtension.Text> _function_1 = (TestLangLSPExtension.Text it_1) -> {
          it_1.text = (this.text + param.text);
        };
        return ObjectExtensions.<TestLangLSPExtension.Text>operator_doubleArrow(_text, _function_1);
      };
      return CompletableFutures.<TestLangLSPExtension.Text>computeAsync(_function);
    }
  }
  
  @JsonNotification
  public abstract void sayHello();
  
  @JsonRequest
  public abstract CompletableFuture<TestLangLSPExtension.Text> getFullText(final TestLangLSPExtension.Text param);
}
