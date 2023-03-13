/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.common.highlighting;

import java.util.Collections;
import java.util.Set;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {
  private static final Set<String> RICH_TEXT_TERMINAL_RULE_NAMES = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("RULE_RICH_TEXT", "RULE_RICH_TEXT_START", "RULE_RICH_TEXT_END", "RULE_RICH_TEXT_INBETWEEN"));

  @Override
  protected String calculateId(final String tokenName, final int tokenType) {
    String _xifexpression = null;
    boolean _contains = XtendAntlrTokenToAttributeIdMapper.RICH_TEXT_TERMINAL_RULE_NAMES.contains(tokenName);
    if (_contains) {
      _xifexpression = XtendHighlightingStyles.RICH_TEXT_ID;
    } else {
      _xifexpression = super.calculateId(tokenName, tokenType);
    }
    return _xifexpression;
  }
}
