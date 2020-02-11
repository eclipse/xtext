/**
 * Copyright (c) 2018 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.editor.syntaxcoloring;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.ide.server.semanticHighlight.ISemanticHighlightingStyleToTokenMapper;
import org.eclipse.xtext.ide.tests.testlanguage.editor.syntaxcoloring.SemanticHighlightingCalculatorImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class SemanticHighlightingStyleToTokenMapper implements ISemanticHighlightingStyleToTokenMapper {
  @Override
  public List<String> toScopes(final String styleId) {
    return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(styleId));
  }
  
  @Override
  public Set<String> getAllStyleIds() {
    return SemanticHighlightingCalculatorImpl.STYLES;
  }
}
