/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.editorActions;

import com.google.common.base.Objects;
import org.eclipse.xtext.idea.editorActions.AutoEditContext;
import org.eclipse.xtext.idea.editorActions.AutoEditMultiLineBlock;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class AutoEditMultiLineBlockInRichString extends AutoEditMultiLineBlock {
  public AutoEditMultiLineBlockInRichString(final String openingTerminal, final String closingTerminal) {
    super(openingTerminal, closingTerminal);
  }
  
  public AutoEditMultiLineBlockInRichString(final String openingTerminal, final String closingTerminal, final boolean nested) {
    super(openingTerminal, null, closingTerminal, nested);
  }
  
  public AutoEditMultiLineBlockInRichString(final String openingTerminal, final String indentationTerminal, final String closingTerminal) {
    super(openingTerminal, indentationTerminal, closingTerminal, false);
  }
  
  public AutoEditMultiLineBlockInRichString(final String openingTerminal, final String indentationTerminal, final String closingTerminal, final boolean nested) {
    super(openingTerminal, indentationTerminal, closingTerminal, nested);
  }
  
  @Override
  protected TextRegion findOpeningTerminal(final int offset, @Extension final AutoEditContext context) {
    final TextRegion result = super.findOpeningTerminal(offset, context);
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      return null;
    }
    int _offset = result.getOffset();
    int _length = result.getLength();
    final int endOffset = (_offset + _length);
    final String textBetween = context.getText(endOffset, offset);
    String _trim = textBetween.trim();
    boolean _isEmpty = _trim.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      return null;
    }
    return result;
  }
}
