/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Switches between legacy and new ISemanticHighlightingCalculator
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 * @noextend
 * @noimplement
 * @noreference
 */
@SuppressWarnings("all")
public class SemanticHighlightingCalculatorDelegate implements ISemanticHighlightingCalculator {
  @Inject(optional = true)
  private org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator legacyDelegate;
  
  @Inject(optional = true)
  private ISemanticHighlightingCalculator newDelegate;
  
  @Override
  public void provideHighlightingFor(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    boolean _notEquals = (!Objects.equal(this.newDelegate, null));
    if (_notEquals) {
      this.newDelegate.provideHighlightingFor(resource, acceptor);
    } else {
      boolean _notEquals_1 = (!Objects.equal(this.legacyDelegate, null));
      if (_notEquals_1) {
        final org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor _function = new org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor() {
          @Override
          public void addPosition(final int offset, final int length, final String[] id) {
            acceptor.addPosition(offset, length, id);
          }
        };
        this.legacyDelegate.provideHighlightingFor(resource, _function);
      }
    }
  }
}
