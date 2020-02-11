/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.codeActions;

import java.util.List;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Jan Koehnlein
 * @since 2.18
 */
@SuppressWarnings("all")
public interface ICodeActionService2 {
  @Accessors
  class Options {
    private Document document;
    
    private XtextResource resource;
    
    private ILanguageServerAccess languageServerAccess;
    
    private CodeActionParams codeActionParams;
    
    private CancelIndicator cancelIndicator;
    
    @Pure
    public Document getDocument() {
      return this.document;
    }
    
    public void setDocument(final Document document) {
      this.document = document;
    }
    
    @Pure
    public XtextResource getResource() {
      return this.resource;
    }
    
    public void setResource(final XtextResource resource) {
      this.resource = resource;
    }
    
    @Pure
    public ILanguageServerAccess getLanguageServerAccess() {
      return this.languageServerAccess;
    }
    
    public void setLanguageServerAccess(final ILanguageServerAccess languageServerAccess) {
      this.languageServerAccess = languageServerAccess;
    }
    
    @Pure
    public CodeActionParams getCodeActionParams() {
      return this.codeActionParams;
    }
    
    public void setCodeActionParams(final CodeActionParams codeActionParams) {
      this.codeActionParams = codeActionParams;
    }
    
    @Pure
    public CancelIndicator getCancelIndicator() {
      return this.cancelIndicator;
    }
    
    public void setCancelIndicator(final CancelIndicator cancelIndicator) {
      this.cancelIndicator = cancelIndicator;
    }
  }
  
  List<Either<Command, CodeAction>> getCodeActions(final ICodeActionService2.Options options);
}
