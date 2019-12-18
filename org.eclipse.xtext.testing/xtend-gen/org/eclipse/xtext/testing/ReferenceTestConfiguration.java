/**
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.testing;

import java.util.List;
import org.eclipse.lsp4j.Location;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.testing.TextDocumentPositionConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class ReferenceTestConfiguration extends TextDocumentPositionConfiguration {
  private boolean includeDeclaration = false;
  
  private String expectedReferences = "";
  
  private Procedure1<? super List<? extends Location>> assertReferences = null;
  
  @Pure
  public boolean isIncludeDeclaration() {
    return this.includeDeclaration;
  }
  
  public void setIncludeDeclaration(final boolean includeDeclaration) {
    this.includeDeclaration = includeDeclaration;
  }
  
  @Pure
  public String getExpectedReferences() {
    return this.expectedReferences;
  }
  
  public void setExpectedReferences(final String expectedReferences) {
    this.expectedReferences = expectedReferences;
  }
  
  @Pure
  public Procedure1<? super List<? extends Location>> getAssertReferences() {
    return this.assertReferences;
  }
  
  public void setAssertReferences(final Procedure1<? super List<? extends Location>> assertReferences) {
    this.assertReferences = assertReferences;
  }
}
