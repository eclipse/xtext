/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.idea.parser.antlr;

import org.eclipse.xtext.xtext.generator.parser.antlr.AbstractAntlrGeneratorFragment2;

@Deprecated
@SuppressWarnings("all")
public class XtextAntlrIDEAGeneratorFragment extends AbstractAntlrGeneratorFragment2 {
  @Override
  protected void doGenerate() {
    boolean _isEnabled = this.getProjectConfig().getIdeaPlugin().isEnabled();
    boolean _not = (!_isEnabled);
    if (_not) {
      return;
    }
    System.err.println("The support for Idea has been removed!");
  }
}
