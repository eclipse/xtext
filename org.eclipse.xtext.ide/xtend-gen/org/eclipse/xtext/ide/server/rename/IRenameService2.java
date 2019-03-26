/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.rename;

import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.WorkspaceEdit;
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
  public static class Options {
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
  
  public abstract WorkspaceEdit rename(final IRenameService2.Options options);
}
