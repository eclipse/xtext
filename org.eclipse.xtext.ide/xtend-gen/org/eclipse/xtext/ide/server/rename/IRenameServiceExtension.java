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
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * The implementation of rename refactoring for a language.
 * 
 * As opposed to {@link IRenameService} this returns {@link TextDocumentChanges} if the
 * client supports versioned documents.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.17
 */
@SuppressWarnings("all")
public interface IRenameServiceExtension {
  @Data
  public static class Options {
    private final boolean clientSupportsVerisonedDocuments;
    
    public Options(final boolean clientSupportsVerisonedDocuments) {
      super();
      this.clientSupportsVerisonedDocuments = clientSupportsVerisonedDocuments;
    }
    
    @Override
    @Pure
    public int hashCode() {
      return 31 * 1 + (this.clientSupportsVerisonedDocuments ? 1231 : 1237);
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      IRenameServiceExtension.Options other = (IRenameServiceExtension.Options) obj;
      if (other.clientSupportsVerisonedDocuments != this.clientSupportsVerisonedDocuments)
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("clientSupportsVerisonedDocuments", this.clientSupportsVerisonedDocuments);
      return b.toString();
    }
    
    @Pure
    public boolean isClientSupportsVerisonedDocuments() {
      return this.clientSupportsVerisonedDocuments;
    }
  }
  
  public abstract WorkspaceEdit rename(final WorkspaceManager workspaceManager, final RenameParams renameParams, final IRenameServiceExtension.Options options, final CancelIndicator cancelIndicator);
}
