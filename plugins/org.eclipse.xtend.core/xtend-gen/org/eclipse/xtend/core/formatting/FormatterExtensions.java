package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtend.core.formatting.BlankLineKey;
import org.eclipse.xtend.core.formatting.CommentInfo;
import org.eclipse.xtend.core.formatting.FormattableDocument;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.core.formatting.FormattingDataInit;
import org.eclipse.xtend.core.formatting.HiddenLeafAccess;
import org.eclipse.xtend.core.formatting.HiddenLeafs;
import org.eclipse.xtend.core.formatting.IConfigurationKey;
import org.eclipse.xtend.core.formatting.IConfigurationValues;
import org.eclipse.xtend.core.formatting.LeafInfo;
import org.eclipse.xtend.core.formatting.NewLineData;
import org.eclipse.xtend.core.formatting.NewLineKey;
import org.eclipse.xtend.core.formatting.NewLineOrPreserveKey;
import org.eclipse.xtend.core.formatting.WhitespaceData;
import org.eclipse.xtend.core.formatting.WhitespaceInfo;
import org.eclipse.xtend.core.formatting.WhitespaceKey;
import org.eclipse.xtend.core.formatting.XtendFormatterConfigKeys;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class FormatterExtensions {
  @Inject
  private HiddenLeafAccess _hiddenLeafAccess;
  
  public Function1<? super FormattableDocument,? extends Iterable<FormattingData>> newFormattingData(final HiddenLeafs leafs, final Procedure1<? super FormattingDataInit> init) {
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _xblockexpression = null;
    {
      FormattingDataInit _formattingDataInit = new FormattingDataInit();
      final FormattingDataInit data = _formattingDataInit;
      init.apply(data);
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _newFormattingData = this.newFormattingData(leafs, data.key, data);
      _xblockexpression = (_newFormattingData);
    }
    return _xblockexpression;
  }
  
  protected Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final Void key, final FormattingDataInit it) {
    final Function1<FormattableDocument,Iterable<FormattingData>> _function = new Function1<FormattableDocument,Iterable<FormattingData>>() {
        public Iterable<FormattingData> apply(final FormattableDocument doc) {
          boolean _and = false;
          Integer _newLinesInComments = leafs.getNewLinesInComments();
          boolean _equals = ((_newLinesInComments).intValue() == 0);
          if (!_equals) {
            _and = false;
          } else {
            boolean _or = false;
            boolean _equals_1 = (it.newLines == 0);
            if (_equals_1) {
              _or = true;
            } else {
              boolean _equals_2 = Objects.equal(it.space, "");
              _or = (_equals_1 || _equals_2);
            }
            _and = (_equals && _or);
          }
          if (_and) {
            boolean _isDebugConflicts = doc.isDebugConflicts();
            return FormatterExtensions.this.newWhitespaceData(leafs, it.space, it.indentationChange, _isDebugConflicts);
          } else {
            boolean _isDebugConflicts_1 = doc.isDebugConflicts();
            return FormatterExtensions.this.newNewLineData(leafs, it.newLines, it.newLines, it.indentationChange, _isDebugConflicts_1);
          }
        }
      };
    return _function;
  }
  
  protected Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final BlankLineKey key, final FormattingDataInit it) {
    final Function1<FormattableDocument,Iterable<FormattingData>> _function = new Function1<FormattableDocument,Iterable<FormattingData>>() {
        public Iterable<FormattingData> apply(final FormattableDocument doc) {
          Iterable<FormattingData> _xblockexpression = null;
          {
            IConfigurationValues<XtendFormatterConfigKeys> _cfg = doc.getCfg();
            final Integer blankline = _cfg.<Integer>get(key);
            IConfigurationValues<XtendFormatterConfigKeys> _cfg_1 = doc.getCfg();
            IConfigurationValues<XtendFormatterConfigKeys> _cfg_2 = doc.getCfg();
            XtendFormatterConfigKeys _keys = _cfg_2.getKeys();
            final Integer preserve = _cfg_1.<Integer>get(_keys.preserveBlankLines);
            final int min = ((blankline).intValue() + 1);
            int _plus = ((preserve).intValue() + 1);
            final int max = Math.max(_plus, min);
            boolean _isDebugConflicts = doc.isDebugConflicts();
            Iterable<FormattingData> _newNewLineData = FormatterExtensions.this.newNewLineData(leafs, min, max, it.indentationChange, _isDebugConflicts);
            _xblockexpression = (_newNewLineData);
          }
          return _xblockexpression;
        }
      };
    return _function;
  }
  
  protected Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final NewLineOrPreserveKey key, final FormattingDataInit it) {
    final Function1<FormattableDocument,Iterable<FormattingData>> _function = new Function1<FormattableDocument,Iterable<FormattingData>>() {
        public Iterable<FormattingData> apply(final FormattableDocument doc) {
          Iterable<FormattingData> _xblockexpression = null;
          {
            IConfigurationValues<XtendFormatterConfigKeys> _cfg = doc.getCfg();
            final Boolean newLine = _cfg.<Boolean>get(key);
            IConfigurationValues<XtendFormatterConfigKeys> _cfg_1 = doc.getCfg();
            IConfigurationValues<XtendFormatterConfigKeys> _cfg_2 = doc.getCfg();
            XtendFormatterConfigKeys _keys = _cfg_2.getKeys();
            final Boolean preserve = _cfg_1.<Boolean>get(_keys.preserveNewLines);
            int _xifexpression = (int) 0;
            if ((newLine).booleanValue()) {
              _xifexpression = 1;
            } else {
              _xifexpression = 0;
            }
            int _xifexpression_1 = (int) 0;
            boolean _or = false;
            if ((preserve).booleanValue()) {
              _or = true;
            } else {
              _or = ((preserve).booleanValue() || (newLine).booleanValue());
            }
            if (_or) {
              _xifexpression_1 = 1;
            } else {
              _xifexpression_1 = 0;
            }
            boolean _isDebugConflicts = doc.isDebugConflicts();
            Iterable<FormattingData> _newNewLineData = FormatterExtensions.this.newNewLineData(leafs, _xifexpression, _xifexpression_1, it.indentationChange, _isDebugConflicts);
            _xblockexpression = (_newNewLineData);
          }
          return _xblockexpression;
        }
      };
    return _function;
  }
  
  protected Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final NewLineKey key, final FormattingDataInit it) {
    final Function1<FormattableDocument,Iterable<FormattingData>> _function = new Function1<FormattableDocument,Iterable<FormattingData>>() {
        public Iterable<FormattingData> apply(final FormattableDocument doc) {
          Iterable<FormattingData> _xblockexpression = null;
          {
            IConfigurationValues<XtendFormatterConfigKeys> _cfg = doc.getCfg();
            final Boolean newLine = _cfg.<Boolean>get(key);
            int _xifexpression = (int) 0;
            if ((newLine).booleanValue()) {
              _xifexpression = 1;
            } else {
              _xifexpression = 0;
            }
            final int minmax = _xifexpression;
            boolean _isDebugConflicts = doc.isDebugConflicts();
            Iterable<FormattingData> _newNewLineData = FormatterExtensions.this.newNewLineData(leafs, minmax, minmax, it.indentationChange, _isDebugConflicts);
            _xblockexpression = (_newNewLineData);
          }
          return _xblockexpression;
        }
      };
    return _function;
  }
  
  protected Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final IConfigurationKey<? extends Object> key, final FormattingDataInit it) {
    Class<? extends Object> _class = key.getClass();
    String _plus = ("Unknown configuration key kind: " + _class);
    RuntimeException _runtimeException = new RuntimeException(_plus);
    throw _runtimeException;
  }
  
  protected Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final WhitespaceKey key, final FormattingDataInit it) {
    final Function1<FormattableDocument,Iterable<FormattingData>> _function = new Function1<FormattableDocument,Iterable<FormattingData>>() {
        public Iterable<FormattingData> apply(final FormattableDocument doc) {
          Iterable<FormattingData> _xblockexpression = null;
          {
            IConfigurationValues<XtendFormatterConfigKeys> _cfg = doc.getCfg();
            final Boolean space = _cfg.<Boolean>get(key);
            String _xifexpression = null;
            if ((space).booleanValue()) {
              _xifexpression = " ";
            } else {
              _xifexpression = "";
            }
            boolean _isDebugConflicts = doc.isDebugConflicts();
            Iterable<FormattingData> _newWhitespaceData = FormatterExtensions.this.newWhitespaceData(leafs, _xifexpression, it.indentationChange, _isDebugConflicts);
            _xblockexpression = (_newWhitespaceData);
          }
          return _xblockexpression;
        }
      };
    return _function;
  }
  
  protected Iterable<FormattingData> newWhitespaceData(final HiddenLeafs leafs, final String space, final int indentationChange, final boolean trace) {
    ArrayList<FormattingData> _xblockexpression = null;
    {
      final ArrayList<FormattingData> result = CollectionLiterals.<FormattingData>newArrayList();
      List<LeafInfo> _leafs = leafs.getLeafs();
      for (final LeafInfo leaf : _leafs) {
        boolean _matched = false;
        if (!_matched) {
          if (leaf instanceof WhitespaceInfo) {
            final WhitespaceInfo _whitespaceInfo = (WhitespaceInfo)leaf;
            _matched=true;
            int _offset = _whitespaceInfo.getOffset();
            int _length = _whitespaceInfo.getLength();
            RuntimeException _xifexpression = null;
            if (trace) {
              RuntimeException _runtimeException = new RuntimeException();
              _xifexpression = _runtimeException;
            }
            WhitespaceData _whitespaceData = new WhitespaceData(_offset, _length, indentationChange, _xifexpression, space);
            result.add(_whitespaceData);
          }
        }
        if (!_matched) {
          if (leaf instanceof CommentInfo) {
            final CommentInfo _commentInfo = (CommentInfo)leaf;
            _matched=true;
          }
        }
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  protected Iterable<FormattingData> newNewLineData(final HiddenLeafs leafs, final int minNewLines, final int maxNewLines, final int indentationChange, final boolean trace) {
    ArrayList<FormattingData> _xblockexpression = null;
    {
      final ArrayList<FormattingData> result = CollectionLiterals.<FormattingData>newArrayList();
      boolean applied = false;
      List<LeafInfo> _leafs = leafs.getLeafs();
      for (final LeafInfo leaf : _leafs) {
        boolean _matched = false;
        if (!_matched) {
          if (leaf instanceof WhitespaceInfo) {
            final WhitespaceInfo _whitespaceInfo = (WhitespaceInfo)leaf;
            _matched=true;
            boolean _and = false;
            CommentInfo _trailingComment = _whitespaceInfo.trailingComment();
            boolean _isTrailing = _trailingComment==null?false:_trailingComment.isTrailing();
            if (!_isTrailing) {
              _and = false;
            } else {
              CommentInfo _trailingComment_1 = _whitespaceInfo.trailingComment();
              boolean _isMultiline = _trailingComment_1==null?false:_trailingComment_1.isMultiline();
              boolean _not = (!_isMultiline);
              _and = (_isTrailing && _not);
            }
            if (_and) {
              String _xifexpression = null;
              int _offset = _whitespaceInfo.getOffset();
              boolean _equals = (_offset == 0);
              if (_equals) {
                _xifexpression = "";
              } else {
                _xifexpression = " ";
              }
              final String space = _xifexpression;
              int _offset_1 = _whitespaceInfo.getOffset();
              int _length = _whitespaceInfo.getLength();
              RuntimeException _xifexpression_1 = null;
              if (trace) {
                RuntimeException _runtimeException = new RuntimeException();
                _xifexpression_1 = _runtimeException;
              }
              WhitespaceData _whitespaceData = new WhitespaceData(_offset_1, _length, indentationChange, _xifexpression_1, space);
              result.add(_whitespaceData);
            } else {
              boolean _not_1 = (!applied);
              if (_not_1) {
                Integer _newLines = leafs.getNewLines();
                int _max = Math.max((_newLines).intValue(), minNewLines);
                int newLines = Math.min(_max, maxNewLines);
                boolean _and_1 = false;
                boolean _and_2 = false;
                boolean _lessThan = (newLines < 1);
                if (!_lessThan) {
                  _and_2 = false;
                } else {
                  int _offset_2 = _whitespaceInfo.getOffset();
                  boolean _greaterThan = (_offset_2 > 0);
                  _and_2 = (_lessThan && _greaterThan);
                }
                if (!_and_2) {
                  _and_1 = false;
                } else {
                  boolean _or = false;
                  CommentInfo _leadingComment = _whitespaceInfo.leadingComment();
                  boolean _isMultiline_1 = _leadingComment==null?false:_leadingComment.isMultiline();
                  if (_isMultiline_1) {
                    _or = true;
                  } else {
                    CommentInfo _trailingComment_2 = _whitespaceInfo.trailingComment();
                    boolean _isMultiline_2 = _trailingComment_2==null?false:_trailingComment_2.isMultiline();
                    _or = (_isMultiline_1 || _isMultiline_2);
                  }
                  _and_1 = (_and_2 && _or);
                }
                if (_and_1) {
                  newLines = 1;
                }
                CommentInfo _leadingComment_1 = _whitespaceInfo.leadingComment();
                boolean _endsWithNewLine = _leadingComment_1==null?false:_leadingComment_1.endsWithNewLine();
                if (_endsWithNewLine) {
                  int _minus = (newLines - 1);
                  newLines = _minus;
                }
                boolean _and_3 = false;
                CommentInfo _leadingComment_2 = _whitespaceInfo.leadingComment();
                boolean _endsWithNewLine_1 = _leadingComment_2==null?false:_leadingComment_2.endsWithNewLine();
                boolean _not_2 = (!_endsWithNewLine_1);
                if (!_not_2) {
                  _and_3 = false;
                } else {
                  boolean _equals_1 = (newLines == 0);
                  _and_3 = (_not_2 && _equals_1);
                }
                if (_and_3) {
                  int _offset_3 = _whitespaceInfo.getOffset();
                  int _length_1 = _whitespaceInfo.getLength();
                  RuntimeException _xifexpression_2 = null;
                  if (trace) {
                    RuntimeException _runtimeException_1 = new RuntimeException();
                    _xifexpression_2 = _runtimeException_1;
                  }
                  String _xifexpression_3 = null;
                  int _offset_4 = _whitespaceInfo.getOffset();
                  boolean _equals_2 = (_offset_4 == 0);
                  if (_equals_2) {
                    _xifexpression_3 = "";
                  } else {
                    _xifexpression_3 = " ";
                  }
                  WhitespaceData _whitespaceData_1 = new WhitespaceData(_offset_3, _length_1, indentationChange, _xifexpression_2, _xifexpression_3);
                  result.add(_whitespaceData_1);
                } else {
                  int _offset_5 = _whitespaceInfo.getOffset();
                  int _length_2 = _whitespaceInfo.getLength();
                  RuntimeException _xifexpression_4 = null;
                  if (trace) {
                    RuntimeException _runtimeException_2 = new RuntimeException();
                    _xifexpression_4 = _runtimeException_2;
                  }
                  NewLineData _newLineData = new NewLineData(_offset_5, _length_2, indentationChange, _xifexpression_4, newLines);
                  result.add(_newLineData);
                }
                applied = true;
              } else {
                int newLines_1 = 1;
                CommentInfo _leadingComment_3 = _whitespaceInfo.leadingComment();
                boolean _endsWithNewLine_2 = _leadingComment_3==null?false:_leadingComment_3.endsWithNewLine();
                if (_endsWithNewLine_2) {
                  int _minus_1 = (newLines_1 - 1);
                  newLines_1 = _minus_1;
                }
                int _offset_6 = _whitespaceInfo.getOffset();
                int _length_3 = _whitespaceInfo.getLength();
                RuntimeException _xifexpression_5 = null;
                if (trace) {
                  RuntimeException _runtimeException_3 = new RuntimeException();
                  _xifexpression_5 = _runtimeException_3;
                }
                NewLineData _newLineData_1 = new NewLineData(_offset_6, _length_3, indentationChange, _xifexpression_5, newLines_1);
                result.add(_newLineData_1);
              }
            }
          }
        }
        if (!_matched) {
          if (leaf instanceof CommentInfo) {
            final CommentInfo _commentInfo = (CommentInfo)leaf;
            _matched=true;
          }
        }
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public String lookahead(final FormattableDocument fmt, final int offset, final int length, final Procedure1<? super FormattableDocument> format) {
    String _xblockexpression = null;
    {
      FormattableDocument _formattableDocument = new FormattableDocument(fmt);
      final FormattableDocument lookahead = _formattableDocument;
      format.apply(lookahead);
      String _renderToString = lookahead.renderToString(offset, length);
      _xblockexpression = (_renderToString);
    }
    return _xblockexpression;
  }
  
  public boolean fitsIntoLine(final FormattableDocument fmt, final int offset, final int length, final Procedure1<? super FormattableDocument> format) {
    final String lookahead = this.lookahead(fmt, offset, length, format);
    boolean _contains = lookahead.contains("\n");
    if (_contains) {
      return false;
    } else {
      int _lineLengthBefore = fmt.lineLengthBefore(offset);
      int _length = lookahead.length();
      final int line = (_lineLengthBefore + _length);
      IConfigurationValues<XtendFormatterConfigKeys> _cfg = fmt.getCfg();
      IConfigurationValues<XtendFormatterConfigKeys> _cfg_1 = fmt.getCfg();
      XtendFormatterConfigKeys _keys = _cfg_1.getKeys();
      Integer _get = _cfg.<Integer>get(_keys.maxLineWidth);
      return (line <= (_get).intValue());
    }
  }
  
  public Function1<? super FormattableDocument,? extends Iterable<FormattingData>> append(final INode node, final Procedure1<? super FormattingDataInit> init) {
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _xifexpression = null;
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsAfter = this._hiddenLeafAccess.getHiddenLeafsAfter(node);
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _newFormattingData = this.newFormattingData(_hiddenLeafsAfter, init);
      _xifexpression = _newFormattingData;
    }
    return _xifexpression;
  }
  
  public Function1<? super FormattableDocument,? extends Iterable<FormattingData>> prepend(final INode node, final Procedure1<? super FormattingDataInit> init) {
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _xifexpression = null;
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsBefore = this._hiddenLeafAccess.getHiddenLeafsBefore(node);
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _newFormattingData = this.newFormattingData(_hiddenLeafsBefore, init);
      _xifexpression = _newFormattingData;
    }
    return _xifexpression;
  }
  
  public Function1<? super FormattableDocument,? extends Iterable<FormattingData>> surround(final INode node, final Procedure1<? super FormattingDataInit> init) {
    final Function1<FormattableDocument,ArrayList<FormattingData>> _function = new Function1<FormattableDocument,ArrayList<FormattingData>>() {
        public ArrayList<FormattingData> apply(final FormattableDocument doc) {
          ArrayList<FormattingData> _xblockexpression = null;
          {
            final ArrayList<FormattingData> result = CollectionLiterals.<FormattingData>newArrayList();
            boolean _notEquals = (!Objects.equal(node, null));
            if (_notEquals) {
              HiddenLeafs _hiddenLeafsBefore = FormatterExtensions.this._hiddenLeafAccess.getHiddenLeafsBefore(node);
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _newFormattingData = FormatterExtensions.this.newFormattingData(_hiddenLeafsBefore, init);
              Iterable<FormattingData> _apply = _newFormattingData==null?(Iterable<FormattingData>)null:_newFormattingData.apply(doc);
              List<FormattingData> _emptyList = CollectionLiterals.<FormattingData>emptyList();
              Iterable<FormattingData> _elvis = ObjectExtensions.<Iterable<FormattingData>>operator_elvis(_apply, _emptyList);
              Iterables.<FormattingData>addAll(result, _elvis);
              HiddenLeafs _hiddenLeafsAfter = FormatterExtensions.this._hiddenLeafAccess.getHiddenLeafsAfter(node);
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _newFormattingData_1 = FormatterExtensions.this.newFormattingData(_hiddenLeafsAfter, init);
              Iterable<FormattingData> _apply_1 = _newFormattingData_1==null?(Iterable<FormattingData>)null:_newFormattingData_1.apply(doc);
              List<FormattingData> _emptyList_1 = CollectionLiterals.<FormattingData>emptyList();
              Iterable<FormattingData> _elvis_1 = ObjectExtensions.<Iterable<FormattingData>>operator_elvis(_apply_1, _emptyList_1);
              Iterables.<FormattingData>addAll(result, _elvis_1);
            }
            _xblockexpression = (result);
          }
          return _xblockexpression;
        }
      };
    return _function;
  }
  
  public Function1<? super FormattableDocument,? extends Iterable<FormattingData>> surround(final INode node, final Procedure1<? super FormattingDataInit> before, final Procedure1<? super FormattingDataInit> after) {
    final Function1<FormattableDocument,ArrayList<FormattingData>> _function = new Function1<FormattableDocument,ArrayList<FormattingData>>() {
        public ArrayList<FormattingData> apply(final FormattableDocument doc) {
          ArrayList<FormattingData> _xblockexpression = null;
          {
            final ArrayList<FormattingData> result = CollectionLiterals.<FormattingData>newArrayList();
            boolean _notEquals = (!Objects.equal(node, null));
            if (_notEquals) {
              HiddenLeafs _hiddenLeafsBefore = FormatterExtensions.this._hiddenLeafAccess.getHiddenLeafsBefore(node);
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _newFormattingData = FormatterExtensions.this.newFormattingData(_hiddenLeafsBefore, before);
              Iterable<FormattingData> _apply = _newFormattingData==null?(Iterable<FormattingData>)null:_newFormattingData.apply(doc);
              List<FormattingData> _emptyList = CollectionLiterals.<FormattingData>emptyList();
              Iterable<FormattingData> _elvis = ObjectExtensions.<Iterable<FormattingData>>operator_elvis(_apply, _emptyList);
              Iterables.<FormattingData>addAll(result, _elvis);
              HiddenLeafs _hiddenLeafsAfter = FormatterExtensions.this._hiddenLeafAccess.getHiddenLeafsAfter(node);
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _newFormattingData_1 = FormatterExtensions.this.newFormattingData(_hiddenLeafsAfter, after);
              Iterable<FormattingData> _apply_1 = _newFormattingData_1==null?(Iterable<FormattingData>)null:_newFormattingData_1.apply(doc);
              List<FormattingData> _emptyList_1 = CollectionLiterals.<FormattingData>emptyList();
              Iterable<FormattingData> _elvis_1 = ObjectExtensions.<Iterable<FormattingData>>operator_elvis(_apply_1, _emptyList_1);
              Iterables.<FormattingData>addAll(result, _elvis_1);
            }
            _xblockexpression = (result);
          }
          return _xblockexpression;
        }
      };
    return _function;
  }
  
  protected Function1<? super FormattableDocument,? extends Iterable<FormattingData>> newFormattingData(final HiddenLeafs leafs, final IConfigurationKey<? extends Object> key, final FormattingDataInit it) {
    if (key instanceof BlankLineKey) {
      return _newFormattingData(leafs, (BlankLineKey)key, it);
    } else if (key instanceof NewLineKey) {
      return _newFormattingData(leafs, (NewLineKey)key, it);
    } else if (key instanceof NewLineOrPreserveKey) {
      return _newFormattingData(leafs, (NewLineOrPreserveKey)key, it);
    } else if (key instanceof WhitespaceKey) {
      return _newFormattingData(leafs, (WhitespaceKey)key, it);
    } else if (key == null) {
      return _newFormattingData(leafs, (Void)null, it);
    } else if (key != null) {
      return _newFormattingData(leafs, key, it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(leafs, key, it).toString());
    }
  }
}
