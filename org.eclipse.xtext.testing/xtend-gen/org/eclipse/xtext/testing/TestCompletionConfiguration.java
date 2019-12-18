/**
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.testing;

import org.eclipse.lsp4j.CompletionList;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.testing.TextDocumentPositionConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class TestCompletionConfiguration extends TextDocumentPositionConfiguration {
  private String expectedCompletionItems = "";
  
  private Procedure1<? super CompletionList> assertCompletionList = null;
  
  @Pure
  public String getExpectedCompletionItems() {
    return this.expectedCompletionItems;
  }
  
  public void setExpectedCompletionItems(final String expectedCompletionItems) {
    this.expectedCompletionItems = expectedCompletionItems;
  }
  
  @Pure
  public Procedure1<? super CompletionList> getAssertCompletionList() {
    return this.assertCompletionList;
  }
  
  public void setAssertCompletionList(final Procedure1<? super CompletionList> assertCompletionList) {
    this.assertCompletionList = assertCompletionList;
  }
}
