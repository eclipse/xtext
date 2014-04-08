/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tasks;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.tasks.DefaultTaskFinder;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@SuppressWarnings("all")
public class XTypeTaskFinder extends DefaultTaskFinder {
  @Inject
  private XtypeGrammarAccess grammar;
  
  protected boolean canContainTaskTags(final ILeafNode node) {
    boolean _or = false;
    EObject _grammarElement = node.getGrammarElement();
    TerminalRule _sL_COMMENTRule = this.grammar.getSL_COMMENTRule();
    boolean _equals = Objects.equal(_grammarElement, _sL_COMMENTRule);
    if (_equals) {
      _or = true;
    } else {
      EObject _grammarElement_1 = node.getGrammarElement();
      TerminalRule _mL_COMMENTRule = this.grammar.getML_COMMENTRule();
      boolean _equals_1 = Objects.equal(_grammarElement_1, _mL_COMMENTRule);
      _or = _equals_1;
    }
    return _or;
  }
}
