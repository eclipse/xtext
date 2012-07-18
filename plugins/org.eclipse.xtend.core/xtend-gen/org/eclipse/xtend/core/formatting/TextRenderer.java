package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import java.util.HashSet;
import java.util.List;
import org.eclipse.xtend.core.formatting.Anchors;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.core.formatting.Line;
import org.eclipse.xtend.core.formatting.NewLineData;
import org.eclipse.xtend.core.formatting.RenderState;
import org.eclipse.xtend.core.formatting.RendererConfiguration;
import org.eclipse.xtend.core.formatting.TextReplacement;
import org.eclipse.xtend.core.formatting.WhitespaceData;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class TextRenderer {
  public List<TextReplacement> render(final String document, final RendererConfiguration cfg, final Iterable<FormattingData> data) {
    List<TextReplacement> _xblockexpression = null;
    {
      RenderState state = null;
      Anchors _anchors = new Anchors();
      final HashSet<Anchors> allanchors = CollectionLiterals.<Anchors>newHashSet(_anchors);
      boolean _dowhile = false;
      do {
        {
          Anchors _xifexpression = null;
          boolean _notEquals = (!Objects.equal(state, null));
          if (_notEquals) {
            Anchors _anchors_1 = state.getAnchors();
            Anchors _anchors_2 = new Anchors(_anchors_1);
            _xifexpression = _anchors_2;
          } else {
            Anchors _anchors_3 = new Anchors();
            _xifexpression = _anchors_3;
          }
          final Anchors anchors = _xifexpression;
          Line _line = new Line(0, 0);
          RenderState _renderState = new RenderState(0, 0, _line, anchors);
          state = _renderState;
          this.render(document, cfg, data, state, false);
        }
        Anchors _anchors_1 = state.getAnchors();
        boolean _add = allanchors.add(_anchors_1);
        _dowhile = _add;
      } while(_dowhile);
      List<TextReplacement> _replacements = state.getReplacements();
      _xblockexpression = (_replacements);
    }
    return _xblockexpression;
  }
  
  protected RenderState render(final String document, final RendererConfiguration cfg, final Iterable<FormattingData> data, final RenderState renderState, final boolean cancelIfLineFull) {
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
              Line _line = state.getLine();
              Line _line_1 = state.getLine();
              int _column = _line_1.getColumn();
              int _plus = (_column + textlength);
              _line.setColumn(_plus);
              final String replacement = _whitespaceData.getSpace();
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
              Line _line = state.getLine();
              Line _line_1 = state.getLine();
              int _column = _line_1.getColumn();
              int _plus = (_column + textlength);
              _line.setColumn(_plus);
              int _indentation = state.getIndentation();
              int _indentationChange = _newLineData.getIndentationChange();
              int _plus_1 = (_indentation + _indentationChange);
              state.setIndentation(_plus_1);
              int _offset_2 = _newLineData.getOffset();
              int _length = _newLineData.getLength();
              int _plus_2 = (_offset_2 + _length);
              int _indentation_1 = state.getIndentation();
              int _indentationLength = cfg.getIndentationLength();
              int _multiply = (_indentation_1 * _indentationLength);
              Line _line_2 = new Line(_plus_2, _multiply);
              state.setLine(_line_2);
              int _newLines = _newLineData.getNewLines();
              String _wrap = cfg.getWrap(_newLines);
              int _indentation_2 = state.getIndentation();
              String _indentation_3 = cfg.getIndentation(_indentation_2);
              final String replacement = (_wrap + _indentation_3);
              List<TextReplacement> _replacements = state.getReplacements();
              int _offset_3 = _newLineData.getOffset();
              int _length_1 = _newLineData.getLength();
              TextReplacement _textReplacement = new TextReplacement(_offset_3, _length_1, replacement);
              _replacements.add(_textReplacement);
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
