/**
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.testing;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.testing.TextDocumentConfiguration;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class ColoringConfiguration extends TextDocumentConfiguration {
  private String expectedColoredRangesWithStyles = "";
  
  @Pure
  public String getExpectedColoredRangesWithStyles() {
    return this.expectedColoredRangesWithStyles;
  }
  
  public void setExpectedColoredRangesWithStyles(final String expectedColoredRangesWithStyles) {
    this.expectedColoredRangesWithStyles = expectedColoredRangesWithStyles;
  }
}
