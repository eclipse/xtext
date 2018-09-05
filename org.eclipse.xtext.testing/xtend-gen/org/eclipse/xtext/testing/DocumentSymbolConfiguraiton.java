/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.testing;

import java.util.List;
import org.eclipse.lsp4j.DocumentSymbol;
import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.testing.TextDocumentConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class DocumentSymbolConfiguraiton extends TextDocumentConfiguration {
  private String expectedSymbols = "";
  
  private Procedure1<? super List<Either<SymbolInformation, DocumentSymbol>>> assertSymbols = null;
  
  @Pure
  public String getExpectedSymbols() {
    return this.expectedSymbols;
  }
  
  public void setExpectedSymbols(final String expectedSymbols) {
    this.expectedSymbols = expectedSymbols;
  }
  
  @Pure
  public Procedure1<? super List<Either<SymbolInformation, DocumentSymbol>>> getAssertSymbols() {
    return this.assertSymbols;
  }
  
  public void setAssertSymbols(final Procedure1<? super List<Either<SymbolInformation, DocumentSymbol>>> assertSymbols) {
    this.assertSymbols = assertSymbols;
  }
}
