package org.eclipse.xtext.xbase.formatting;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.log4j.Logger;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.xbase.formatting.BasicFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.formatting.FormattingData;
import org.eclipse.xtext.xbase.formatting.FormattingPreferenceValues;
import org.eclipse.xtext.xbase.formatting.NewLineData;
import org.eclipse.xtext.xbase.formatting.TextReplacement;
import org.eclipse.xtext.xbase.formatting.WhitespaceData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @deprecated use {@link IFormattableDocument}
 */
@Deprecated
@SuppressWarnings("all")
public class FormattableDocument {
  private final static Logger log = Logger.getLogger(FormattableDocument.class);
  
  @Accessors
  private final FormattingPreferenceValues cfg;
  
  @Accessors
  private final String document;
  
  @Accessors
  private final TreeMap<Integer, FormattingData> formattings;
  
  @Accessors
  private Throwable rootTrace = null;
  
  @Accessors
  private boolean conflictOccurred = false;
  
  public FormattableDocument(final FormattingPreferenceValues cfg, final String document) {
    this.cfg = cfg;
    this.document = document;
    TreeMap<Integer, FormattingData> _treeMap = new TreeMap<Integer, FormattingData>();
    this.formattings = _treeMap;
  }
  
  public FormattableDocument(final FormattableDocument fmt) {
    this.cfg = fmt.cfg;
    this.document = fmt.document;
    TreeMap<Integer, FormattingData> _treeMap = new TreeMap<Integer, FormattingData>(fmt.formattings);
    this.formattings = _treeMap;
  }
  
  public boolean isDebugConflicts() {
    return (!Objects.equal(this.rootTrace, null));
  }
  
  protected FormattingData addFormatting(final FormattingData data) {
    FormattingData _xifexpression = null;
    boolean _notEquals = (!Objects.equal(data, null));
    if (_notEquals) {
      FormattingData _xblockexpression = null;
      {
        int _length = data.getLength();
        boolean _lessThan = (_length < 0);
        if (_lessThan) {
          final Pair<String, String> text = this.getTextAround(data);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("lenght of text-edit can not be negative:");
          _builder.newLine();
          _builder.append("--------------------------------- document snippet ------------------------------");
          _builder.newLine();
          String _key = text.getKey();
          _builder.append(_key, "");
          _builder.append("[[[!!]]]");
          String _value = text.getValue();
          _builder.append(_value, "");
          _builder.newLineIfNotEmpty();
          _builder.append("---------------------------------------------------------------------------------");
          _builder.newLine();
          FormattableDocument.log.error(_builder);
          throw new IllegalStateException("Length of text edit can not be negative");
        }
        int _length_1 = data.getLength();
        boolean _greaterThan = (_length_1 > 0);
        if (_greaterThan) {
          int _offset = data.getOffset();
          int _offset_1 = data.getOffset();
          int _length_2 = data.getLength();
          int _plus = (_offset_1 + _length_2);
          final String oldText = this.document.substring(_offset, _plus);
          boolean _isWhitespace = this.isWhitespace(oldText);
          boolean _not = (!_isWhitespace);
          if (_not) {
            final Pair<String, String> text_1 = this.getTextAround(data);
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("Can not edit non-whitespace:");
            _builder_1.newLine();
            _builder_1.append("------------------------------- document snippet --------------------------------");
            _builder_1.newLine();
            String _key_1 = text_1.getKey();
            _builder_1.append(_key_1, "");
            _builder_1.append("[[[");
            _builder_1.append(oldText, "");
            _builder_1.append("]]]");
            String _value_1 = text_1.getValue();
            _builder_1.append(_value_1, "");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("---------------------------------------------------------------------------------");
            _builder_1.newLine();
            FormattableDocument.log.error(_builder_1);
            throw new IllegalStateException(("Can non format non-whitespace: " + oldText));
          }
        }
        int _offset_2 = data.getOffset();
        final FormattingData old = this.formattings.get(Integer.valueOf(_offset_2));
        FormattingData _xifexpression_1 = null;
        boolean _equals = Objects.equal(old, null);
        if (_equals) {
          _xifexpression_1 = data;
        } else {
          _xifexpression_1 = this.merge(old, data);
        }
        final FormattingData newData = _xifexpression_1;
        FormattingData _xifexpression_2 = null;
        boolean _notEquals_1 = (!Objects.equal(newData, null));
        if (_notEquals_1) {
          int _offset_3 = data.getOffset();
          _xifexpression_2 = this.formattings.put(Integer.valueOf(_offset_3), newData);
        }
        _xblockexpression = _xifexpression_2;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected FormattingData merge(final FormattingData data1, final FormattingData data2) {
    FormattingData _xblockexpression = null;
    {
      FormattingData old = null;
      int increaseIndentationChange = 0;
      int decreaseIndentationChange = 0;
      int indentationChange = 0;
      boolean _isEmpty = data2.isEmpty();
      if (_isEmpty) {
        int _indentationChange = data1.getIndentationChange();
        int _indentationChange_1 = data2.getIndentationChange();
        int _plus = (_indentationChange + _indentationChange_1);
        indentationChange = _plus;
        old = data1;
      } else {
        boolean _isEmpty_1 = data1.isEmpty();
        if (_isEmpty_1) {
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
        FormattingData _xblockexpression_1 = null;
        {
          if ((indentationChange > 0)) {
            increaseIndentationChange = indentationChange;
          } else {
            decreaseIndentationChange = indentationChange;
          }
          FormattingData _switchResult = null;
          boolean _matched = false;
          if (old instanceof NewLineData) {
            _matched=true;
            int _offset = ((NewLineData)old).getOffset();
            int _length = ((NewLineData)old).getLength();
            Throwable _trace = ((NewLineData)old).getTrace();
            Integer _newLines = ((NewLineData)old).getNewLines();
            _switchResult = new NewLineData(_offset, _length, increaseIndentationChange, decreaseIndentationChange, _trace, _newLines);
          }
          if (!_matched) {
            if (old instanceof WhitespaceData) {
              _matched=true;
              int _offset = ((WhitespaceData)old).getOffset();
              int _length = ((WhitespaceData)old).getLength();
              Throwable _trace = ((WhitespaceData)old).getTrace();
              String _space = ((WhitespaceData)old).getSpace();
              _switchResult = new WhitespaceData(_offset, _length, increaseIndentationChange, decreaseIndentationChange, _trace, _space);
            }
          }
          _xblockexpression_1 = _switchResult;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        Object _xblockexpression_2 = null;
        {
          this.conflictOccurred = true;
          boolean _isDebugConflicts = this.isDebugConflicts();
          if (_isDebugConflicts) {
            this.reportConflict(data1, data2);
          }
          _xblockexpression_2 = null;
        }
        _xifexpression = ((FormattingData)_xblockexpression_2);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected Pair<String, String> getTextAround(final FormattingData data1) {
    Pair<String, String> _xblockexpression = null;
    {
      IntegerRange _upTo = new IntegerRange(0, 5);
      int _offset = data1.getOffset();
      final Function2<Integer, Integer, Integer> _function = new Function2<Integer, Integer, Integer>() {
        @Override
        public Integer apply(final Integer last, final Integer i) {
          int _xifexpression = (int) 0;
          if (((last).intValue() > 0)) {
            _xifexpression = FormattableDocument.this.document.lastIndexOf("\n", ((last).intValue() - 1));
          } else {
            _xifexpression = (-1);
          }
          return Integer.valueOf(_xifexpression);
        }
      };
      final Integer back = IterableExtensions.<Integer, Integer>fold(_upTo, Integer.valueOf(_offset), _function);
      IntegerRange _upTo_1 = new IntegerRange(0, 5);
      int _offset_1 = data1.getOffset();
      final Function2<Integer, Integer, Integer> _function_1 = new Function2<Integer, Integer, Integer>() {
        @Override
        public Integer apply(final Integer last, final Integer i) {
          int _xifexpression = (int) 0;
          if (((last).intValue() > 0)) {
            _xifexpression = FormattableDocument.this.document.indexOf("\n", ((last).intValue() + 1));
          } else {
            _xifexpression = (-1);
          }
          return Integer.valueOf(_xifexpression);
        }
      };
      final Integer forward = IterableExtensions.<Integer, Integer>fold(_upTo_1, Integer.valueOf(_offset_1), _function_1);
      Integer _xifexpression = null;
      if (((back).intValue() >= 0)) {
        _xifexpression = back;
      } else {
        _xifexpression = Integer.valueOf(0);
      }
      final Integer fiveLinesBackOffset = _xifexpression;
      Integer _xifexpression_1 = null;
      if (((forward).intValue() >= 0)) {
        _xifexpression_1 = forward;
      } else {
        _xifexpression_1 = Integer.valueOf(this.document.length());
      }
      final Integer fiveLinesForwardOffset = _xifexpression_1;
      int _offset_2 = data1.getOffset();
      final String prefix = this.document.substring((fiveLinesBackOffset).intValue(), _offset_2);
      int _offset_3 = data1.getOffset();
      int _length = data1.getLength();
      int _plus = (_offset_3 + _length);
      final String postfix = this.document.substring(_plus, (fiveLinesForwardOffset).intValue());
      _xblockexpression = Pair.<String, String>of(prefix, postfix);
    }
    return _xblockexpression;
  }
  
  protected void reportConflict(final FormattingData data1, final FormattingData data2) {
    final Pair<String, String> text = this.getTextAround(data1);
    StackTraceElement[] _stackTrace = this.rootTrace.getStackTrace();
    int _size = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).size();
    final int traceStart = (_size - 1);
    Throwable _trace = data1.getTrace();
    final StackTraceElement[] fullTrace1 = _trace.getStackTrace();
    int _size_1 = ((List<StackTraceElement>)Conversions.doWrapArray(fullTrace1)).size();
    int _minus = (_size_1 - traceStart);
    List<StackTraceElement> _subList = ((List<StackTraceElement>)Conversions.doWrapArray(fullTrace1)).subList(0, _minus);
    final String shortTrace1 = IterableExtensions.join(_subList, "\n");
    Throwable _trace_1 = data2.getTrace();
    final StackTraceElement[] fullTrace2 = _trace_1.getStackTrace();
    int _size_2 = ((List<StackTraceElement>)Conversions.doWrapArray(fullTrace2)).size();
    int _minus_1 = (_size_2 - traceStart);
    List<StackTraceElement> _subList_1 = ((List<StackTraceElement>)Conversions.doWrapArray(fullTrace2)).subList(0, _minus_1);
    final String shortTrace2 = IterableExtensions.join(_subList_1, "\n");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Conflicting TextEdits during formatting:");
    _builder.newLine();
    _builder.append("------------------------------- document snippet --------------------------------");
    _builder.newLine();
    String _key = text.getKey();
    _builder.append(_key, "");
    _builder.append("[!!!]");
    String _value = text.getValue();
    _builder.append(_value, "");
    _builder.newLineIfNotEmpty();
    _builder.append("---------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("TextEdit1: ");
    String _string = data1.toString();
    String _replaceAll = _string.replaceAll("\\n\\s*", " ");
    _builder.append(_replaceAll, "");
    _builder.newLineIfNotEmpty();
    _builder.append("TextEdit2: ");
    String _string_1 = data2.toString();
    String _replaceAll_1 = _string_1.replaceAll("\\n\\s*", " ");
    _builder.append(_replaceAll_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("---------------------------------- Trace 1 --------------------------------------");
    _builder.newLine();
    _builder.append(shortTrace1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("---------------------------------- Trace 2 --------------------------------------");
    _builder.newLine();
    _builder.append(shortTrace2, "");
    _builder.newLineIfNotEmpty();
    _builder.append("---------------------------------------------------------------------------------");
    _builder.newLine();
    FormattableDocument.log.error(_builder);
  }
  
  public FormattingData operator_add(final FormattingData data) {
    return this.addFormatting(data);
  }
  
  public void operator_add(final Iterable<FormattingData> data) {
    boolean _notEquals = (!Objects.equal(data, null));
    if (_notEquals) {
      final Procedure1<FormattingData> _function = new Procedure1<FormattingData>() {
        @Override
        public void apply(final FormattingData it) {
          FormattableDocument.this.addFormatting(it);
        }
      };
      IterableExtensions.<FormattingData>forEach(data, _function);
    }
  }
  
  public void operator_add(final Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> data) {
    boolean _notEquals = (!Objects.equal(data, null));
    if (_notEquals) {
      Iterable<FormattingData> _apply = data.apply(this);
      this.operator_add(_apply);
    }
  }
  
  public List<TextReplacement> renderToEdits() {
    int _length = this.document.length();
    return this.renderToEdits(0, _length);
  }
  
  public List<TextReplacement> renderToEdits(final int offset, final int length) {
    ArrayList<TextReplacement> _xblockexpression = null;
    {
      final ArrayList<TextReplacement> replacements = CollectionLiterals.<TextReplacement>newArrayList();
      int oldOffset = offset;
      int indentation = 0;
      Collection<FormattingData> _values = this.formattings.values();
      for (final FormattingData f : _values) {
        {
          int _indentationChange = f.getIndentationChange();
          int _plus = (indentation + _indentationChange);
          indentation = _plus;
          boolean _and = false;
          int _offset = f.getOffset();
          boolean _greaterEqualsThan = (_offset >= offset);
          if (!_greaterEqualsThan) {
            _and = false;
          } else {
            int _offset_1 = f.getOffset();
            int _length = f.getLength();
            int _plus_1 = (_offset_1 + _length);
            boolean _lessEqualsThan = (_plus_1 <= (offset + length));
            _and = _lessEqualsThan;
          }
          if (_and) {
            int _offset_2 = f.getOffset();
            final int textlength = (_offset_2 - oldOffset);
            boolean _matched = false;
            if (f instanceof WhitespaceData) {
              _matched=true;
              String _space = ((WhitespaceData)f).getSpace();
              boolean _notEquals = (!Objects.equal(_space, null));
              if (_notEquals) {
                final String replacement = ((WhitespaceData)f).getSpace();
                int _offset_3 = ((WhitespaceData)f).getOffset();
                int _length_1 = ((WhitespaceData)f).getLength();
                TextReplacement _textReplacement = new TextReplacement(_offset_3, _length_1, replacement);
                replacements.add(_textReplacement);
              }
            }
            if (!_matched) {
              if (f instanceof NewLineData) {
                _matched=true;
                int _xifexpression = (int) 0;
                int _increaseIndentationChange = ((NewLineData)f).getIncreaseIndentationChange();
                int _decreaseIndentationChange = ((NewLineData)f).getDecreaseIndentationChange();
                int _multiply = (_decreaseIndentationChange * (-1));
                boolean _equals = (_increaseIndentationChange == _multiply);
                if (_equals) {
                  int _increaseIndentationChange_1 = ((NewLineData)f).getIncreaseIndentationChange();
                  _xifexpression = (indentation + _increaseIndentationChange_1);
                } else {
                  _xifexpression = indentation;
                }
                final int computedIndentation = _xifexpression;
                Integer _newLines = ((NewLineData)f).getNewLines();
                String _wrap = this.getWrap((_newLines).intValue());
                String _indentation = this.getIndentation(computedIndentation);
                final String replacement = (_wrap + _indentation);
                int _offset_3 = ((NewLineData)f).getOffset();
                int _length_1 = ((NewLineData)f).getLength();
                TextReplacement _textReplacement = new TextReplacement(_offset_3, _length_1, replacement);
                replacements.add(_textReplacement);
              }
            }
            int _length_1 = f.getLength();
            int _plus_2 = (textlength + _length_1);
            oldOffset = _plus_2;
          }
        }
      }
      _xblockexpression = replacements;
    }
    return _xblockexpression;
  }
  
  public String renderToString() {
    int _length = this.document.length();
    return this.renderToString(0, _length);
  }
  
  public String renderToString(final int offset, final int length) {
    String _xblockexpression = null;
    {
      final List<TextReplacement> edits = this.renderToEdits(offset, length);
      int lastOffset = offset;
      final StringBuilder newDocument = new StringBuilder();
      final Function1<TextReplacement, Integer> _function = new Function1<TextReplacement, Integer>() {
        @Override
        public Integer apply(final TextReplacement it) {
          return Integer.valueOf(offset);
        }
      };
      List<TextReplacement> _sortBy = IterableExtensions.<TextReplacement, Integer>sortBy(edits, _function);
      for (final TextReplacement edit : _sortBy) {
        {
          int _offset = edit.getOffset();
          final String text = this.document.substring(lastOffset, _offset);
          newDocument.append(text);
          String _text = edit.getText();
          newDocument.append(_text);
          int _offset_1 = edit.getOffset();
          int _length = edit.getLength();
          int _plus = (_offset_1 + _length);
          lastOffset = _plus;
        }
      }
      final String text = this.document.substring(lastOffset, (offset + length));
      newDocument.append(text);
      _xblockexpression = newDocument.toString();
    }
    return _xblockexpression;
  }
  
  protected boolean isWhitespace(final String doc) {
    int _length = doc.length();
    int _minus = (_length - 1);
    IntegerRange _upTo = new IntegerRange(0, _minus);
    final Function1<Integer, Boolean> _function = new Function1<Integer, Boolean>() {
      @Override
      public Boolean apply(final Integer it) {
        char _charAt = doc.charAt((it).intValue());
        return Boolean.valueOf(Character.isWhitespace(_charAt));
      }
    };
    return IterableExtensions.<Integer>forall(_upTo, _function);
  }
  
  public int lineLengthBefore(final int offset) {
    int _xblockexpression = (int) 0;
    {
      int currentIndentation = 0;
      NewLineData lastWrap = null;
      int lastIndentation = 0;
      Collection<FormattingData> _values = this.formattings.values();
      for (final FormattingData f : _values) {
        int _offset = f.getOffset();
        boolean _lessThan = (_offset < offset);
        if (_lessThan) {
          int _indentationChange = f.getIndentationChange();
          int _plus = (currentIndentation + _indentationChange);
          currentIndentation = _plus;
          if ((f instanceof NewLineData)) {
            lastWrap = ((NewLineData)f);
            lastIndentation = currentIndentation;
          }
        }
      }
      int _offset_1 = lastWrap.getOffset();
      int _length = lastWrap.getLength();
      int lastOffset = (_offset_1 + _length);
      int lineStart = lastOffset;
      int _offset_2 = lastWrap.getOffset();
      int _plus_1 = (_offset_2 + 1);
      SortedMap<Integer, FormattingData> _subMap = this.formattings.subMap(Integer.valueOf(_plus_1), Integer.valueOf(offset));
      Collection<FormattingData> _values_1 = _subMap.values();
      for (final FormattingData f_1 : _values_1) {
        {
          int _offset_3 = f_1.getOffset();
          final String text = this.document.substring(lastOffset, _offset_3);
          final int index = text.lastIndexOf("\n");
          if ((index >= 0)) {
            lineStart = (index + lastOffset);
            currentIndentation = 0;
          }
          int _offset_4 = f_1.getOffset();
          int _length_1 = f_1.getLength();
          int _plus_2 = (_offset_4 + _length_1);
          lastOffset = _plus_2;
        }
      }
      int lengthDiff = 0;
      int _offset_3 = lastWrap.getOffset();
      int _plus_2 = (_offset_3 + 1);
      SortedMap<Integer, FormattingData> _subMap_1 = this.formattings.subMap(Integer.valueOf(_plus_2), Integer.valueOf(offset));
      Collection<FormattingData> _values_2 = _subMap_1.values();
      for (final FormattingData f_2 : _values_2) {
        if ((f_2 instanceof WhitespaceData)) {
          final String space = ((WhitespaceData)f_2).getSpace();
          int _xifexpression = (int) 0;
          boolean _equals = Objects.equal(space, null);
          if (_equals) {
            _xifexpression = 0;
          } else {
            _xifexpression = space.length();
          }
          final int length = _xifexpression;
          int _length_1 = ((WhitespaceData)f_2).getLength();
          int _minus = ((lengthDiff + length) - _length_1);
          lengthDiff = _minus;
        }
      }
      int _indentationLenght = this.getIndentationLenght(currentIndentation);
      int _plus_3 = ((offset - lineStart) + _indentationLenght);
      _xblockexpression = (_plus_3 + lengthDiff);
    }
    return _xblockexpression;
  }
  
  public String lookahead(final int offset, final int length, final Procedure1<? super FormattableDocument> format) {
    String _xblockexpression = null;
    {
      final FormattableDocument lookahead = new FormattableDocument(this);
      format.apply(lookahead);
      _xblockexpression = lookahead.renderToString(offset, length);
    }
    return _xblockexpression;
  }
  
  public boolean fitsIntoLine(final int offset, final int length, final Procedure1<? super FormattableDocument> format) {
    final String lookahead = this.lookahead(offset, length, format);
    boolean _contains = lookahead.contains("\n");
    if (_contains) {
      return false;
    } else {
      int _lineLengthBefore = this.lineLengthBefore(offset);
      int _length = lookahead.length();
      final int line = (_lineLengthBefore + _length);
      int _get = this.cfg.get(BasicFormatterPreferenceKeys.maxLineWidth);
      return (line <= _get);
    }
  }
  
  @Override
  public String toString() {
    String _xblockexpression = null;
    {
      int lastOffset = 0;
      final StringBuilder debugTrace = new StringBuilder();
      List<TextReplacement> _renderToEdits = this.renderToEdits();
      for (final TextReplacement edit : _renderToEdits) {
        {
          int _offset = edit.getOffset();
          final String text = this.document.substring(lastOffset, _offset);
          debugTrace.append(text);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("[");
          int _offset_1 = edit.getOffset();
          int _offset_2 = edit.getOffset();
          int _length = edit.getLength();
          int _plus = (_offset_2 + _length);
          String _substring = this.document.substring(_offset_1, _plus);
          _builder.append(_substring, "");
          _builder.append("|");
          String _text = edit.getText();
          _builder.append(_text, "");
          _builder.append("]");
          debugTrace.append(_builder);
          int _offset_3 = edit.getOffset();
          int _length_1 = edit.getLength();
          int _plus_1 = (_offset_3 + _length_1);
          lastOffset = _plus_1;
        }
      }
      int _length = this.document.length();
      final String text = this.document.substring(lastOffset, _length);
      debugTrace.append(text);
      _xblockexpression = debugTrace.toString();
    }
    return _xblockexpression;
  }
  
  public String getIndentation(final int levels) {
    String _xifexpression = null;
    if ((levels > 0)) {
      String _xblockexpression = null;
      {
        final String indent = this.cfg.get(BasicFormatterPreferenceKeys.indentation);
        IntegerRange _upTo = new IntegerRange(0, (levels - 1));
        final Function1<Integer, String> _function = new Function1<Integer, String>() {
          @Override
          public String apply(final Integer it) {
            return indent;
          }
        };
        Iterable<String> _map = IterableExtensions.<Integer, String>map(_upTo, _function);
        _xblockexpression = IterableExtensions.join(_map);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  public int getIndentationLenght(final int levels) {
    int _get = this.cfg.get(BasicFormatterPreferenceKeys.indentationLength);
    return (levels * _get);
  }
  
  public String getWrap(final int levels) {
    String _xifexpression = null;
    if ((levels > 0)) {
      String _xblockexpression = null;
      {
        final String sep = this.cfg.get(BasicFormatterPreferenceKeys.lineSeparator);
        IntegerRange _upTo = new IntegerRange(0, (levels - 1));
        final Function1<Integer, String> _function = new Function1<Integer, String>() {
          @Override
          public String apply(final Integer it) {
            return sep;
          }
        };
        Iterable<String> _map = IterableExtensions.<Integer, String>map(_upTo, _function);
        _xblockexpression = IterableExtensions.join(_map);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  @Pure
  public FormattingPreferenceValues getCfg() {
    return this.cfg;
  }
  
  @Pure
  public String getDocument() {
    return this.document;
  }
  
  @Pure
  public TreeMap<Integer, FormattingData> getFormattings() {
    return this.formattings;
  }
  
  @Pure
  public Throwable getRootTrace() {
    return this.rootTrace;
  }
  
  public void setRootTrace(final Throwable rootTrace) {
    this.rootTrace = rootTrace;
  }
  
  @Pure
  public boolean isConflictOccurred() {
    return this.conflictOccurred;
  }
  
  public void setConflictOccurred(final boolean conflictOccurred) {
    this.conflictOccurred = conflictOccurred;
  }
}
