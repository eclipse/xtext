/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.editor.syntaxcoloring;

import com.google.inject.Inject;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.tests.editor.syntaxcoloring.TaskHighlightingTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class DeprecatedTaskHighlightingTest extends TaskHighlightingTest implements IHighlightedPositionAcceptor {
  @Inject
  private DefaultSemanticHighlightingCalculator highlighter;
  
  @Override
  public org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator getHighlighter() {
    return this.highlighter;
  }
}
