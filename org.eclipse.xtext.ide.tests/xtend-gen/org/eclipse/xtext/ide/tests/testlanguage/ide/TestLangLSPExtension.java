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
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.jsonrpc.services.JsonRequest;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.DocumentAccess;
import org.eclipse.xtext.ide.server.LanguageServerExtension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author efftinge - Initial contribution and API
 */
@ImplementedBy(TestLangLSPExtension.Impl.class)
@SuppressWarnings("all")
public interface TestLangLSPExtension extends LanguageServerExtension {
  public static class TextOfLineResult {
    public String text;
  }
  
  public static class TextOfLineParam {
    public String uri;
    
    public int line;
  }
  
  public static class Impl implements LanguageServerExtension, TestLangLSPExtension {
    private DocumentAccess access;
    
    @Override
    public CompletableFuture<TestLangLSPExtension.TextOfLineResult> getTextOfLine(final TestLangLSPExtension.TextOfLineParam param) {
      final Function<DocumentAccess.Context, TestLangLSPExtension.TextOfLineResult> _function = (DocumentAccess.Context ctx) -> {
        Document _document = ctx.getDocument();
        Position _position = new Position(param.line, 0);
        final int start = _document.getOffSet(_position);
        Document _document_1 = ctx.getDocument();
        Position _position_1 = new Position((param.line + 1), 0);
        int _offSet = _document_1.getOffSet(_position_1);
        final int end = (_offSet - 1);
        TestLangLSPExtension.TextOfLineResult _textOfLineResult = new TestLangLSPExtension.TextOfLineResult();
        final Procedure1<TestLangLSPExtension.TextOfLineResult> _function_1 = (TestLangLSPExtension.TextOfLineResult it) -> {
          Document _document_2 = ctx.getDocument();
          String _contents = _document_2.getContents();
          String _substring = _contents.substring(start, end);
          it.text = _substring;
        };
        return ObjectExtensions.<TestLangLSPExtension.TextOfLineResult>operator_doubleArrow(_textOfLineResult, _function_1);
      };
      return this.access.<TestLangLSPExtension.TextOfLineResult>doRead(param.uri, _function);
    }
    
    @Override
    public void initialize(final DocumentAccess access) {
      this.access = access;
    }
  }
  
  @JsonRequest
  public abstract CompletableFuture<TestLangLSPExtension.TextOfLineResult> getTextOfLine(final TestLangLSPExtension.TextOfLineParam param);
}
