/**
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.testing;

import org.eclipse.lsp4j.Hover;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.testing.TextDocumentPositionConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class HoverTestConfiguration extends TextDocumentPositionConfiguration {
  private String expectedHover = "";
  
  private Procedure1<? super Hover> assertHover = null;
  
  @Pure
  public String getExpectedHover() {
    return this.expectedHover;
  }
  
  public void setExpectedHover(final String expectedHover) {
    this.expectedHover = expectedHover;
  }
  
  @Pure
  public Procedure1<? super Hover> getAssertHover() {
    return this.assertHover;
  }
  
  public void setAssertHover(final Procedure1<? super Hover> assertHover) {
    this.assertHover = assertHover;
  }
}
