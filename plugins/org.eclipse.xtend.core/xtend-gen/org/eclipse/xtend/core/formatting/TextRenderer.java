package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.core.formatting.NewLineData;
import org.eclipse.xtend.core.formatting.RenderState;
import org.eclipse.xtend.core.formatting.RendererConfiguration;
import org.eclipse.xtend.core.formatting.TextReplacement;
import org.eclipse.xtend.core.formatting.WhitespaceData;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class TextRenderer {
  public List<TextReplacement> createEdits(final String document, final RendererConfiguration cfg, final Iterable<FormattingData> data, final int offset, final int length) {
    List<TextReplacement> _xblockexpression = null;
    {
      final Function1<FormattingData,Boolean> _function = new Function1<FormattingData,Boolean>() {
          public Boolean apply(final FormattingData e) {
            boolean _and = false;
            int _offset = e.getOffset();
            boolean _greaterEqualsThan = (_offset >= offset);
            if (!_greaterEqualsThan) {
              _and = false;
            } else {
              int _offset_1 = e.getOffset();
              int _length = e.getLength();
              int _plus = (_offset_1 + _length);
              int _plus_1 = (offset + length);
              boolean _lessEqualsThan = (_plus <= _plus_1);
              _and = (_greaterEqualsThan && _lessEqualsThan);
            }
            return Boolean.valueOf(_and);
          }
        };
      final Iterable<FormattingData> filtered = IterableExtensions.<FormattingData>filter(data, _function);
      RenderState _renderState = new RenderState(0, 0);
      RenderState state = _renderState;
      this.render(document, cfg, filtered, state);
      List<TextReplacement> _replacements = state.getReplacements();
      _xblockexpression = (_replacements);
    }
    return _xblockexpression;
  }
  
  protected RenderState render(final String document, final RendererConfiguration cfg, final Iterable<FormattingData> data, final RenderState renderState) {
    RenderState _xblockexpression = null;
    {
      RenderState state = renderState;
      final Function1<FormattingData,Boolean> _function = new Function1<FormattingData,Boolean>() {
          public Boolean apply(final FormattingData it) {
            boolean _and = false;
            boolean _notEquals = (!Objects.equal(it, null));
            if (!_notEquals) {
              _and = false;
            } else {
              boolean _or = false;
              int _length = it.getLength();
              boolean _equals = (_length == 0);
              if (_equals) {
                _or = true;
              } else {
                int _offset = it.getOffset();
                int _offset_1 = it.getOffset();
                int _length_1 = it.getLength();
                int _plus = (_offset_1 + _length_1);
                String _substring = document.substring(_offset, _plus);
                boolean _isWhitespace = TextRenderer.this.isWhitespace(_substring);
                _or = (_equals || _isWhitespace);
              }
              _and = (_notEquals && _or);
            }
            return Boolean.valueOf(_and);
          }
        };
      Iterable<FormattingData> _filter = IterableExtensions.<FormattingData>filter(data, _function);
      final Function1<FormattingData,Integer> _function_1 = new Function1<FormattingData,Integer>() {
          public Integer apply(final FormattingData it) {
            int _offset = it.getOffset();
            return Integer.valueOf(_offset);
          }
        };
      final List<FormattingData> fmt = IterableExtensions.<FormattingData, Integer>sortBy(_filter, _function_1);
      for (final FormattingData f : fmt) {
        {
          int _offset = f.getOffset();
          int _offset_1 = state.getOffset();
          final int textlength = (_offset - _offset_1);
          boolean _matched = false;
          if (!_matched) {
            if (f instanceof WhitespaceData) {
              final WhitespaceData _whitespaceData = (WhitespaceData)f;
              _matched=true;
              int _indentation = state.getIndentation();
              int _indentationChange = _whitespaceData.getIndentationChange();
              int _plus = (_indentation + _indentationChange);
              state.setIndentation(_plus);
              String _space = _whitespaceData.getSpace();
              final String replacement = ObjectExtensions.<String>operator_elvis(_space, " ");
              List<TextReplacement> _replacements = state.getReplacements();
              int _offset_2 = _whitespaceData.getOffset();
              int _length = _whitespaceData.getLength();
              TextReplacement _textReplacement = new TextReplacement(_offset_2, _length, replacement);
              _replacements.add(_textReplacement);
            }
          }
          if (!_matched) {
            if (f instanceof NewLineData) {
              final NewLineData _newLineData = (NewLineData)f;
              _matched=true;
              int _indentation = state.getIndentation();
              int _indentationChange = _newLineData.getIndentationChange();
              int _plus = (_indentation + _indentationChange);
              state.setIndentation(_plus);
              int _newLines = _newLineData.getNewLines();
              boolean _greaterThan = (_newLines > 0);
              if (_greaterThan) {
                int _newLines_1 = _newLineData.getNewLines();
                String _wrap = cfg.getWrap(_newLines_1);
                int _indentation_1 = state.getIndentation();
                String _indentation_2 = cfg.getIndentation(_indentation_1);
                final String replacement = (_wrap + _indentation_2);
                List<TextReplacement> _replacements = state.getReplacements();
                int _offset_2 = _newLineData.getOffset();
                int _length = _newLineData.getLength();
                TextReplacement _textReplacement = new TextReplacement(_offset_2, _length, replacement);
                _replacements.add(_textReplacement);
              }
            }
          }
          int _length = f.getLength();
          int _plus = (textlength + _length);
          state.setOffset(_plus);
        }
      }
      _xblockexpression = (state);
    }
    return _xblockexpression;
  }
  
  public boolean isWhitespace(final String doc) {
    int _length = doc.length();
    int _minus = (_length - 1);
    IntegerRange _upTo = new IntegerRange(0, _minus);
    final Function1<Integer,Boolean> _function = new Function1<Integer,Boolean>() {
        public Boolean apply(final Integer it) {
          char _charAt = doc.charAt((it).intValue());
          boolean _isWhitespace = Character.isWhitespace(_charAt);
          return Boolean.valueOf(_isWhitespace);
        }
      };
    boolean _forall = IterableExtensions.<Integer>forall(_upTo, _function);
    return _forall;
  }
  
  public TextRenderer() {
    super();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TextRenderer other = (TextRenderer) obj;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
