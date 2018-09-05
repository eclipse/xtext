/**
 * Copyright (c) 2018 TypeFox and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.symbol;

import com.google.common.annotations.Beta;
import com.google.inject.ImplementedBy;
import java.util.List;
import org.eclipse.lsp4j.DocumentSymbol;
import org.eclipse.lsp4j.DocumentSymbolParams;
import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * Common service interface for providing document symbol information for text documents.
 * 
 * <p>
 * For more details, see the <a href="https://microsoft.github.io/language-server-protocol/specification#textDocument_documentSymbol">{@code textDocument/documentSymbol}</a> LSP method.
 * 
 * <p>
 * This interface is not meant to be injected. Use the {@link DocumentSymbolService} and the {@link HierarchicalDocumentSymbolService} directly instead.
 */
@Beta
@ImplementedBy(IDocumentSymbolService.Noop.class)
@SuppressWarnings("all")
public interface IDocumentSymbolService {
  public static class Noop implements IDocumentSymbolService {
    @Override
    public List<Either<SymbolInformation, DocumentSymbol>> getSymbols(final Document document, final XtextResource resource, final DocumentSymbolParams params, final CancelIndicator cancelIndicator) {
      return CollectionLiterals.<Either<SymbolInformation, DocumentSymbol>>emptyList();
    }
  }
  
  public abstract List<Either<SymbolInformation, DocumentSymbol>> getSymbols(final Document document, final XtextResource resource, final DocumentSymbolParams params, final CancelIndicator cancelIndicator);
}
