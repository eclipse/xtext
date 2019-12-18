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
public class DefinitionTestConfiguration extends TextDocumentPositionConfiguration {
  private String expectedDefinitions = "";
  
  private Procedure1<? super List<? extends Location>> assertDefinitions = null;
  
  @Pure
  public String getExpectedDefinitions() {
    return this.expectedDefinitions;
  }
  
  public void setExpectedDefinitions(final String expectedDefinitions) {
    this.expectedDefinitions = expectedDefinitions;
  }
  
  @Pure
  public Procedure1<? super List<? extends Location>> getAssertDefinitions() {
    return this.assertDefinitions;
  }
  
  public void setAssertDefinitions(final Procedure1<? super List<? extends Location>> assertDefinitions) {
    this.assertDefinitions = assertDefinitions;
  }
}
