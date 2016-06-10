/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.tests.server.TextDocumentPositionConfiguration;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class TestCompletionConfiguration extends TextDocumentPositionConfiguration {
  private String expectedCompletionItems = "";
  
  @Pure
  public String getExpectedCompletionItems() {
    return this.expectedCompletionItems;
  }
  
  public void setExpectedCompletionItems(final String expectedCompletionItems) {
    this.expectedCompletionItems = expectedCompletionItems;
  }
}
