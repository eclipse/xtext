/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tasks;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.tasks.DefaultTaskFinder;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Christian Dietrich - Initial contribution and API
 * @since
 */
@SuppressWarnings("all")
public class XtendTaskFinder extends DefaultTaskFinder {
  @Inject
  @Extension
  private XtendGrammarAccess _xtendGrammarAccess;

  @Override
  protected boolean canContainTaskTags(final ILeafNode node) {
    boolean result = super.canContainTaskTags(node);
    if ((!result)) {
      return this.isRichComment(node);
    }
    return result;
  }

  @Override
  protected String stripText(final ILeafNode node, final String text) {
    String _xblockexpression = null;
    {
      boolean _isRichComment = this.isRichComment(node);
      if (_isRichComment) {
        final char newLine = '\n';
        final int index = text.indexOf(newLine);
        if ((index != (-1))) {
          return text.substring(0, index);
        }
        return text;
      }
      _xblockexpression = super.stripText(node, text);
    }
    return _xblockexpression;
  }

  private boolean isRichComment(final ILeafNode node) {
    EObject _grammarElement = node.getGrammarElement();
    if ((_grammarElement instanceof RuleCall)) {
      return (Objects.equal(((RuleCall) node.getGrammarElement()).getRule(), this._xtendGrammarAccess.getCOMMENT_RICH_TEXT_ENDRule()) || 
        Objects.equal(((RuleCall) node.getGrammarElement()).getRule(), this._xtendGrammarAccess.getCOMMENT_RICH_TEXT_INBETWEENRule()));
    }
    return false;
  }
}
