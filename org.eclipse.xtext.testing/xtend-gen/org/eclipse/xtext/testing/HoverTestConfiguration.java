/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.testing;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.testing.TextDocumentPositionConfiguration;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class HoverTestConfiguration extends TextDocumentPositionConfiguration {
  private String expectedHover = "";
  
  @Pure
  public String getExpectedHover() {
    return this.expectedHover;
  }
  
  public void setExpectedHover(final String expectedHover) {
    this.expectedHover = expectedHover;
  }
}
