/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.autoedit;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.xbase.lib.ArrayExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class RichStringPartionIndentationStrategy extends DefaultIndentLineAutoEditStrategy {
  @Override
  public void customizeDocumentCommand(final IDocument d, final DocumentCommand c) {
    if (((c.text.length() > 1) && (!ArrayExtensions.contains(d.getLegalLineDelimiters(), c.text)))) {
      try {
        final String lineIndentation = this.getLineIndentation(d, c.offset);
        final Function1<String, Integer> _function = (String s) -> {
          return Integer.valueOf(s.length());
        };
        final List<String> legalLineDelimiters = ListExtensions.<String>reverseView(IterableExtensions.<String, Integer>sortBy(((Iterable<String>)Conversions.doWrapArray(d.getLegalLineDelimiters())), _function));
        final String defaultLineDelimiter = TextUtilities.getDefaultLineDelimiter(d);
        final Function1<String, CharSequence> _function_1 = (String delimiter) -> {
          return Pattern.quote(delimiter);
        };
        final String regex = IterableExtensions.<String>join(legalLineDelimiters, "(", ")|(", ")", _function_1);
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(c.text);
        final StringBuilder convertedText = new StringBuilder();
        int currentStart = 0;
        int currentEnd = 0;
        while (matcher.find()) {
          {
            currentEnd = matcher.start();
            if ((currentStart != 0)) {
              convertedText.append(lineIndentation);
            }
            convertedText.append(c.text.substring(currentStart, currentEnd));
            convertedText.append(defaultLineDelimiter);
            currentStart = matcher.end();
          }
        }
        int _length = c.text.length();
        boolean _lessThan = (currentStart < _length);
        if (_lessThan) {
          if ((currentStart != 0)) {
            convertedText.append(lineIndentation);
          }
          convertedText.append(c.text.substring(currentStart));
        }
        c.text = convertedText.toString();
      } catch (final Throwable _t) {
        if (_t instanceof BadLocationException) {
          super.customizeDocumentCommand(d, c);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    super.customizeDocumentCommand(d, c);
  }

  public String getLineIndentation(final IDocument document, final int offset) throws BadLocationException {
    String _xblockexpression = null;
    {
      int _xifexpression = (int) 0;
      int _length = document.getLength();
      boolean _tripleEquals = (offset == _length);
      if (_tripleEquals) {
        _xifexpression = (offset - 1);
      } else {
        _xifexpression = offset;
      }
      int adjustedOffset = _xifexpression;
      IRegion line = document.getLineInformationOfOffset(adjustedOffset);
      int start = line.getOffset();
      int end = this.findEndOfWhiteSpace(document, start, offset);
      _xblockexpression = document.get(start, (end - start));
    }
    return _xblockexpression;
  }
}
