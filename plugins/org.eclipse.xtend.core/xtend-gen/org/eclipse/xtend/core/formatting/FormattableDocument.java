package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.core.formatting.NewLineData;
import org.eclipse.xtend.core.formatting.RendererConfiguration;
import org.eclipse.xtend.core.formatting.TextReplacement;
import org.eclipse.xtend.core.formatting.WhitespaceData;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class FormattableDocument {
  private final RendererConfiguration _cfg;
  
  public RendererConfiguration getCfg() {
    return this._cfg;
  }
  
  private final String _document;
  
  public String getDocument() {
    return this._document;
  }
  
  private TreeMap<Integer,FormattingData> _formattings;
  
  public TreeMap<Integer,FormattingData> getFormattings() {
    return this._formattings;
  }
  
  public void setFormattings(final TreeMap<Integer,FormattingData> formattings) {
    this._formattings = formattings;
  }
  
  public FormattableDocument(final RendererConfiguration cfg, final String document) {
    this._cfg = cfg;
    this._document = document;
    TreeMap<Integer,FormattingData> _treeMap = new TreeMap<Integer,FormattingData>();
    this._formattings = _treeMap;
  }
  
  public FormattableDocument(final FormattableDocument fmt) {
    RendererConfiguration _cfg = fmt.getCfg();
    this._cfg = _cfg;
    String _document = fmt.getDocument();
    this._document = _document;
    TreeMap<Integer,FormattingData> _formattings = fmt.getFormattings();
    TreeMap<Integer,FormattingData> _treeMap = new TreeMap<Integer,FormattingData>(_formattings);
    this._formattings = _treeMap;
  }
  
  protected FormattingData addFormatting(final FormattingData data) {
    FormattingData _xifexpression = null;
    boolean _notEquals = (!Objects.equal(data, null));
    if (_notEquals) {
      FormattingData _xblockexpression = null;
      {
        int _length = data.getLength();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          String _document = this.getDocument();
          int _offset = data.getOffset();
          int _offset_1 = data.getOffset();
          int _length_1 = data.getLength();
          int _plus = (_offset_1 + _length_1);
          final String oldText = _document.substring(_offset, _plus);
          boolean _isWhitespace = this.isWhitespace(oldText);
          boolean _not = (!_isWhitespace);
          if (_not) {
            String _plus_1 = ("Can non format non-whitespace: " + oldText);
            IllegalStateException _illegalStateException = new IllegalStateException(_plus_1);
            throw _illegalStateException;
          }
        }
        TreeMap<Integer,FormattingData> _formattings = this.getFormattings();
        int _offset_2 = data.getOffset();
        final FormattingData old = _formattings.get(Integer.valueOf(_offset_2));
        TreeMap<Integer,FormattingData> _formattings_1 = this.getFormattings();
        int _offset_3 = data.getOffset();
        FormattingData _xifexpression_1 = null;
        boolean _equals = Objects.equal(old, null);
        if (_equals) {
          _xifexpression_1 = data;
        } else {
          FormattingData _merge = this.merge(old, data);
          _xifexpression_1 = _merge;
        }
        FormattingData _put = _formattings_1.put(Integer.valueOf(_offset_3), _xifexpression_1);
        _xblockexpression = (_put);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected FormattingData merge(final FormattingData data1, final FormattingData data2) {
    FormattingData _xblockexpression = null;
    {
      FormattingData old = null;
      int indentationChange = 0;
      boolean _and = false;
      boolean _isEmpty = data1.isEmpty();
      boolean _not = (!_isEmpty);
      if (!_not) {
        _and = false;
      } else {
        boolean _isEmpty_1 = data2.isEmpty();
        _and = (_not && _isEmpty_1);
      }
      if (_and) {
        int _indentationChange = data1.getIndentationChange();
        int _indentationChange_1 = data2.getIndentationChange();
        int _plus = (_indentationChange + _indentationChange_1);
        indentationChange = _plus;
        old = data1;
      } else {
        boolean _and_1 = false;
        boolean _isEmpty_2 = data1.isEmpty();
        if (!_isEmpty_2) {
          _and_1 = false;
        } else {
          boolean _isEmpty_3 = data2.isEmpty();
          boolean _not_1 = (!_isEmpty_3);
          _and_1 = (_isEmpty_2 && _not_1);
        }
        if (_and_1) {
          int _indentationChange_2 = data2.getIndentationChange();
          int _indentationChange_3 = data1.getIndentationChange();
          int _plus_1 = (_indentationChange_2 + _indentationChange_3);
          indentationChange = _plus_1;
          old = data2;
        }
      }
      FormattingData _xifexpression = null;
      boolean _notEquals = (!Objects.equal(old, null));
      if (_notEquals) {
        FormattingData _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (old instanceof NewLineData) {
            final NewLineData _newLineData = (NewLineData)old;
            _matched=true;
            int _offset = _newLineData.getOffset();
            int _length = _newLineData.getLength();
            int _newLines = _newLineData.getNewLines();
            NewLineData _newLineData_1 = new NewLineData(_offset, _length, indentationChange, _newLines);
            _switchResult = _newLineData_1;
          }
        }
        if (!_matched) {
          if (old instanceof WhitespaceData) {
            final WhitespaceData _whitespaceData = (WhitespaceData)old;
            _matched=true;
            int _offset = _whitespaceData.getOffset();
            int _length = _whitespaceData.getLength();
            String _space = _whitespaceData.getSpace();
            WhitespaceData _whitespaceData_1 = new WhitespaceData(_offset, _length, indentationChange, _space);
            _switchResult = _whitespaceData_1;
          }
        }
        _xifexpression = _switchResult;
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Can not merge ");
        _builder.append(data1, "");
        _builder.append(" and ");
        _builder.append(data2, "");
        _builder.append(".");
        IllegalStateException _illegalStateException = new IllegalStateException(_builder.toString());
        throw _illegalStateException;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public FormattingData operator_add(final FormattingData data) {
    FormattingData _addFormatting = this.addFormatting(data);
    return _addFormatting;
  }
  
  public List<TextReplacement> renderToEdits() {
    String _document = this.getDocument();
    int _length = _document.length();
    List<TextReplacement> _renderToEdits = this.renderToEdits(0, _length);
    return _renderToEdits;
  }
  
  public List<TextReplacement> renderToEdits(final int offset, final int length) {
    ArrayList<TextReplacement> _xblockexpression = null;
    {
      final ArrayList<TextReplacement> replacements = CollectionLiterals.<TextReplacement>newArrayList();
      int oldOffset = offset;
      int indentation = 0;
      TreeMap<Integer,FormattingData> _formattings = this.getFormattings();
      Collection<FormattingData> _values = _formattings.values();
      for (final FormattingData f : _values) {
        boolean _and = false;
        int _offset = f.getOffset();
        boolean _greaterEqualsThan = (_offset >= offset);
        if (!_greaterEqualsThan) {
          _and = false;
        } else {
          int _offset_1 = f.getOffset();
          int _length = f.getLength();
          int _plus = (_offset_1 + _length);
          int _plus_1 = (offset + length);
          boolean _lessEqualsThan = (_plus <= _plus_1);
          _and = (_greaterEqualsThan && _lessEqualsThan);
        }
        if (_and) {
          int _offset_2 = f.getOffset();
          final int textlength = (_offset_2 - oldOffset);
          boolean _matched = false;
          if (!_matched) {
            if (f instanceof WhitespaceData) {
              final WhitespaceData _whitespaceData = (WhitespaceData)f;
              _matched=true;
              int _indentationChange = _whitespaceData.getIndentationChange();
              int _plus_2 = (indentation + _indentationChange);
              indentation = _plus_2;
              String _space = _whitespaceData.getSpace();
              final String replacement = ObjectExtensions.<String>operator_elvis(_space, " ");
              int _offset_3 = _whitespaceData.getOffset();
              int _length_1 = _whitespaceData.getLength();
              TextReplacement _textReplacement = new TextReplacement(_offset_3, _length_1, replacement);
              replacements.add(_textReplacement);
            }
          }
          if (!_matched) {
            if (f instanceof NewLineData) {
              final NewLineData _newLineData = (NewLineData)f;
              _matched=true;
              int _indentationChange = _newLineData.getIndentationChange();
              int _plus_2 = (indentation + _indentationChange);
              indentation = _plus_2;
              int _newLines = _newLineData.getNewLines();
              boolean _greaterThan = (_newLines > 0);
              if (_greaterThan) {
                RendererConfiguration _cfg = this.getCfg();
                int _newLines_1 = _newLineData.getNewLines();
                String _wrap = _cfg.getWrap(_newLines_1);
                RendererConfiguration _cfg_1 = this.getCfg();
                String _indentation = _cfg_1.getIndentation(indentation);
                final String replacement = (_wrap + _indentation);
                int _offset_3 = _newLineData.getOffset();
                int _length_1 = _newLineData.getLength();
                TextReplacement _textReplacement = new TextReplacement(_offset_3, _length_1, replacement);
                replacements.add(_textReplacement);
              }
            }
          }
          int _length_1 = f.getLength();
          int _plus_2 = (textlength + _length_1);
          oldOffset = _plus_2;
        }
      }
      _xblockexpression = (replacements);
    }
    return _xblockexpression;
  }
  
  public String renderToString() {
    String _document = this.getDocument();
    int _length = _document.length();
    String _renderToString = this.renderToString(0, _length);
    return _renderToString;
  }
  
  public String renderToString(final int offset, final int length) {
    String _xblockexpression = null;
    {
      final List<TextReplacement> edits = this.renderToEdits(offset, length);
      int lastOffset = offset;
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder newDocument = _stringBuilder;
      final Function1<TextReplacement,Integer> _function = new Function1<TextReplacement,Integer>() {
          public Integer apply(final TextReplacement it) {
            return Integer.valueOf(offset);
          }
        };
      List<TextReplacement> _sortBy = IterableExtensions.<TextReplacement, Integer>sortBy(edits, _function);
      for (final TextReplacement edit : _sortBy) {
        {
          String _document = this.getDocument();
          int _offset = edit.getOffset();
          final String text = _document.substring(lastOffset, _offset);
          newDocument.append(text);
          String _text = edit.getText();
          newDocument.append(_text);
          int _offset_1 = edit.getOffset();
          int _length = edit.getLength();
          int _plus = (_offset_1 + _length);
          lastOffset = _plus;
        }
      }
      String _document = this.getDocument();
      int _plus = (offset + length);
      final String text = _document.substring(lastOffset, _plus);
      newDocument.append(text);
      String _string = newDocument.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  protected boolean isWhitespace(final String doc) {
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
  
  public int lineLengthBefore(final int offset) {
    int _xblockexpression = (int) 0;
    {
      int currentIndentation = 0;
      NewLineData lastWrap = null;
      int lastIndentation = 0;
      TreeMap<Integer,FormattingData> _formattings = this.getFormattings();
      Collection<FormattingData> _values = _formattings.values();
      for (final FormattingData f : _values) {
        int _offset = f.getOffset();
        boolean _lessThan = (_offset < offset);
        if (_lessThan) {
          int _indentationChange = f.getIndentationChange();
          int _plus = (currentIndentation + _indentationChange);
          currentIndentation = _plus;
          if ((f instanceof NewLineData)) {
            lastWrap = ((NewLineData) f);
            lastIndentation = currentIndentation;
          }
        }
      }
      int _offset_1 = lastWrap.getOffset();
      int _length = lastWrap.getLength();
      int lastOffset = (_offset_1 + _length);
      int lineStart = lastOffset;
      TreeMap<Integer,FormattingData> _formattings_1 = this.getFormattings();
      int _offset_2 = lastWrap.getOffset();
      NavigableMap<Integer,FormattingData> _subMap = _formattings_1.subMap(Integer.valueOf(_offset_2), false, Integer.valueOf(offset), false);
      Collection<FormattingData> _values_1 = _subMap.values();
      for (final FormattingData f_1 : _values_1) {
        {
          String _document = this.getDocument();
          int _offset_3 = f_1.getOffset();
          final String text = _document.substring(lastOffset, _offset_3);
          final int index = text.lastIndexOf("\n");
          boolean _greaterEqualsThan = (index >= 0);
          if (_greaterEqualsThan) {
            int _plus_1 = (index + lastOffset);
            lineStart = _plus_1;
            currentIndentation = 0;
          }
          int _offset_4 = f_1.getOffset();
          int _length_1 = f_1.getLength();
          int _plus_2 = (_offset_4 + _length_1);
          lastOffset = _plus_2;
        }
      }
      int lengthDiff = 0;
      TreeMap<Integer,FormattingData> _formattings_2 = this.getFormattings();
      int _offset_3 = lastWrap.getOffset();
      NavigableMap<Integer,FormattingData> _subMap_1 = _formattings_2.subMap(Integer.valueOf(_offset_3), false, Integer.valueOf(offset), false);
      Collection<FormattingData> _values_2 = _subMap_1.values();
      for (final FormattingData f_2 : _values_2) {
        if ((f_2 instanceof WhitespaceData)) {
          String _space = ((WhitespaceData) f_2).getSpace();
          int _length_1 = _space==null?0:_space.length();
          Integer _elvis = ObjectExtensions.<Integer>operator_elvis(Integer.valueOf(_length_1), Integer.valueOf(0));
          int _length_2 = f_2.getLength();
          int _minus = ((_elvis).intValue() - _length_2);
          int _plus_1 = (lengthDiff + _minus);
          lengthDiff = _plus_1;
        }
      }
      int _minus_1 = (offset - lineStart);
      RendererConfiguration _cfg = this.getCfg();
      int _indentationLenght = _cfg.getIndentationLenght(currentIndentation);
      int _plus_2 = (_minus_1 + _indentationLenght);
      int _plus_3 = (_plus_2 + lengthDiff);
      _xblockexpression = (_plus_3);
    }
    return _xblockexpression;
  }
}
