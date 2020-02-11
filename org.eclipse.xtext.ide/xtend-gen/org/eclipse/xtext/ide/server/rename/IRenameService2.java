/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.rename;

import org.eclipse.lsp4j.PrepareRenameResult;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Service called for rename refactoring.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.18
 */
@SuppressWarnings("all")
public interface IRenameService2 {
  @Accessors
  class Options {
    private ILanguageServerAccess languageServerAccess;
    
    private RenameParams renameParams;
    
    private CancelIndicator cancelIndicator;
    
    @Pure
    public ILanguageServerAccess getLanguageServerAccess() {
      return this.languageServerAccess;
    }
    
    public void setLanguageServerAccess(final ILanguageServerAccess languageServerAccess) {
      this.languageServerAccess = languageServerAccess;
    }
    
    @Pure
    public RenameParams getRenameParams() {
      return this.renameParams;
    }
    
    public void setRenameParams(final RenameParams renameParams) {
      this.renameParams = renameParams;
    }
    
    @Pure
    public CancelIndicator getCancelIndicator() {
      return this.cancelIndicator;
    }
    
    public void setCancelIndicator(final CancelIndicator cancelIndicator) {
      this.cancelIndicator = cancelIndicator;
    }
  }
  
  @Accessors
  class PrepareRenameOptions {
    private ILanguageServerAccess languageServerAccess;
    
    private TextDocumentPositionParams params;
    
    private CancelIndicator cancelIndicator;
    
    @Pure
    public ILanguageServerAccess getLanguageServerAccess() {
      return this.languageServerAccess;
    }
    
    public void setLanguageServerAccess(final ILanguageServerAccess languageServerAccess) {
      this.languageServerAccess = languageServerAccess;
    }
    
    @Pure
    public TextDocumentPositionParams getParams() {
      return this.params;
    }
    
    public void setParams(final TextDocumentPositionParams params) {
      this.params = params;
    }
    
    @Pure
    public CancelIndicator getCancelIndicator() {
      return this.cancelIndicator;
    }
    
    public void setCancelIndicator(final CancelIndicator cancelIndicator) {
      this.cancelIndicator = cancelIndicator;
    }
  }
  
  WorkspaceEdit rename(final IRenameService2.Options options);
  
  /**
   * Returns a {@link Range range} describing the range of the string to rename and optionally a placeholder text of
   * the string content to be renamed.
   * 
   * <p>
   * If {@code null} is returned then it is deemed that invoking {@link #rename rename} with the same text document
   * position will not result in a valid {@link WorkspaceEdit workspace edit}.
   * 
   * <p>
   * The default implementation only checks whether there is an identifier under the give text document position or not.
   * 
   * <p>
   * This method should be used to set up and to test the validity of a rename operation at a given location.</br>
   * See <a href="https://microsoft.github.io/language-server-protocol/specification#textDocument_prepareRename">{@code textDocument/prepareRename}</a> for more details.
   */
  Either<Range, PrepareRenameResult> prepareRename(final IRenameService2.PrepareRenameOptions options);
}
