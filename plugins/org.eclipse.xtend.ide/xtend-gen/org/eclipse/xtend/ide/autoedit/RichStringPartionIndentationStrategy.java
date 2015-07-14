package org.eclipse.xtend.ide.autoedit;

import java.util.List;
import java.util.regex.Pattern;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class RichStringPartionIndentationStrategy extends DefaultIndentLineAutoEditStrategy {
  @Override
  public void customizeDocumentCommand(final IDocument d, final DocumentCommand c) {
    boolean _and = false;
    int _length = c.text.length();
    boolean _greaterThan = (_length > 1);
    if (!_greaterThan) {
      _and = false;
    } else {
      String[] _legalLineDelimiters = d.getLegalLineDelimiters();
      boolean _contains = ((List<String>)Conversions.doWrapArray(_legalLineDelimiters)).contains(c.text);
      boolean _not = (!_contains);
      _and = _not;
    }
    if (_and) {
      try {
        String lineIndentation = this.getLineIndentation(d, c.offset);
        String[] _legalLineDelimiters_1 = d.getLegalLineDelimiters();
        final Function1<String, Integer> _function = new Function1<String, Integer>() {
          @Override
          public Integer apply(final String s) {
            return Integer.valueOf(s.length());
          }
        };
        List<String> _sortBy = IterableExtensions.<String, Integer>sortBy(((Iterable<String>)Conversions.doWrapArray(_legalLineDelimiters_1)), _function);
        List<String> legalLineDelimiters = ListExtensions.<String>reverseView(_sortBy);
        String _get = legalLineDelimiters.get(0);
        String _quote = Pattern.quote(_get);
        StringBuilder regex = new StringBuilder(_quote);
        Iterable<String> _tail = IterableExtensions.<String>tail(legalLineDelimiters);
        for (final String delimiter : _tail) {
          String _quote_1 = Pattern.quote(delimiter);
          String _plus = ("|(" + _quote_1);
          String _plus_1 = (_plus + ")");
          regex.append(_plus_1);
        }
        String _string = regex.toString();
        String[] lines = c.text.split(_string);
        String defaultLineDelimiter = ((IDocumentExtension4) d).getDefaultLineDelimiter();
        StringConcatenation _builder = new StringConcatenation();
        {
          boolean _hasElements = false;
          for(final String l : lines) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate((defaultLineDelimiter + lineIndentation), "");
            }
            _builder.append(l, "");
          }
        }
        String convertedText = _builder.toString();
        c.text = convertedText;
      } catch (final Throwable _t) {
        if (_t instanceof BadLocationException) {
          final BadLocationException e = (BadLocationException)_t;
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
