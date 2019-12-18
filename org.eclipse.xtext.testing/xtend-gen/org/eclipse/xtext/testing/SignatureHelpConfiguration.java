/**
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.testing;

import org.eclipse.lsp4j.SignatureHelp;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.testing.TextDocumentPositionConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class SignatureHelpConfiguration extends TextDocumentPositionConfiguration {
  private String expectedSignatureHelp = "";
  
  private Procedure1<? super SignatureHelp> assertSignatureHelp = null;
  
  @Pure
  public String getExpectedSignatureHelp() {
    return this.expectedSignatureHelp;
  }
  
  public void setExpectedSignatureHelp(final String expectedSignatureHelp) {
    this.expectedSignatureHelp = expectedSignatureHelp;
  }
  
  @Pure
  public Procedure1<? super SignatureHelp> getAssertSignatureHelp() {
    return this.assertSignatureHelp;
  }
  
  public void setAssertSignatureHelp(final Procedure1<? super SignatureHelp> assertSignatureHelp) {
    this.assertSignatureHelp = assertSignatureHelp;
  }
}
