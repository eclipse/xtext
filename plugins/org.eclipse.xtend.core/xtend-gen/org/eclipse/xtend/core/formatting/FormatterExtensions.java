package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.core.formatting.CommentInfo;
import org.eclipse.xtend.core.formatting.FormattableDocument;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.core.formatting.FormattingDataInit;
import org.eclipse.xtend.core.formatting.HiddenLeafs;
import org.eclipse.xtend.core.formatting.IntegerEntry;
import org.eclipse.xtend.core.formatting.LeafInfo;
import org.eclipse.xtend.core.formatting.NewLineConfig;
import org.eclipse.xtend.core.formatting.NewLineData;
import org.eclipse.xtend.core.formatting.NodeModelAccess;
import org.eclipse.xtend.core.formatting.WhitespaceData;
import org.eclipse.xtend.core.formatting.WhitespaceInfo;
import org.eclipse.xtend.core.formatting.XtendFormatterConfig;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class FormatterExtensions {
  @Inject
  private NodeModelAccess _nodeModelAccess;
  
  public Iterable<FormattingData> newFormattingData(final HiddenLeafs leafs, final Procedure1<? super FormattingDataInit> init) {
    FormattingDataInit _formattingDataInit = new FormattingDataInit();
    final FormattingDataInit it = _formattingDataInit;
    init.apply(it);
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
      return this.newFormattingData(leafs, it.space, it.indentationChange);
    } else {
      int _newLine = it.newLine();
      int _newLine_1 = it.newLine();
      return this.newFormattingData(leafs, _newLine, _newLine_1, it.indentationChange);
    }
  }
  
  public Iterable<FormattingData> newFormattingData(final HiddenLeafs leafs, final String space, final int indentationChange) {
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
            WhitespaceData _whitespaceData = new WhitespaceData(_offset, _length, indentationChange, space);
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
  
  public Iterable<FormattingData> newFormattingData(final HiddenLeafs leafs, final NewLineConfig configuration, final int indentationChange) {
    IntegerEntry _minNewLines = configuration.getMinNewLines();
    int _value = _minNewLines.getValue();
    IntegerEntry _maxNewLines = configuration.getMaxNewLines();
    int _value_1 = _maxNewLines.getValue();
    Iterable<FormattingData> _newFormattingData = this.newFormattingData(leafs, _value, _value_1, indentationChange);
    return _newFormattingData;
  }
  
  public Iterable<FormattingData> newFormattingData(final HiddenLeafs leafs, final int minNewLines, final int maxNewLines, final int indentationChange) {
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
            final CommentInfo next = _whitespaceInfo.trailingComment();
            boolean _isTrailing = next==null?false:next.isTrailing();
            if (_isTrailing) {
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
              WhitespaceData _whitespaceData = new WhitespaceData(_offset_1, _length, indentationChange, space);
              result.add(_whitespaceData);
            } else {
              boolean _not = (!applied);
              if (_not) {
                Integer _newLines = leafs.getNewLines();
                int _max = Math.max((_newLines).intValue(), minNewLines);
                int newLines = Math.min(_max, maxNewLines);
                CommentInfo _leadingComment = _whitespaceInfo.leadingComment();
                boolean _endsWithNewLine = _leadingComment==null?false:_leadingComment.endsWithNewLine();
                if (_endsWithNewLine) {
                  int _minus = (newLines - 1);
                  newLines = _minus;
                }
                boolean _and = false;
                CommentInfo _leadingComment_1 = _whitespaceInfo.leadingComment();
                boolean _endsWithNewLine_1 = _leadingComment_1==null?false:_leadingComment_1.endsWithNewLine();
                boolean _not_1 = (!_endsWithNewLine_1);
                if (!_not_1) {
                  _and = false;
                } else {
                  boolean _equals_1 = (newLines == 0);
                  _and = (_not_1 && _equals_1);
                }
                if (_and) {
                  int _offset_2 = _whitespaceInfo.getOffset();
                  int _length_1 = _whitespaceInfo.getLength();
                  WhitespaceData _whitespaceData_1 = new WhitespaceData(_offset_2, _length_1, indentationChange, " ");
                  result.add(_whitespaceData_1);
                } else {
                  int _offset_3 = _whitespaceInfo.getOffset();
                  int _length_2 = _whitespaceInfo.getLength();
                  NewLineData _newLineData = new NewLineData(_offset_3, _length_2, indentationChange, newLines);
                  result.add(_newLineData);
                }
                applied = true;
              } else {
                int newLines_1 = 1;
                CommentInfo _leadingComment_2 = _whitespaceInfo.leadingComment();
                boolean _endsWithNewLine_2 = _leadingComment_2==null?false:_leadingComment_2.endsWithNewLine();
                if (_endsWithNewLine_2) {
                  int _minus_1 = (newLines_1 - 1);
                  newLines_1 = _minus_1;
                }
                int _offset_4 = _whitespaceInfo.getOffset();
                int _length_3 = _whitespaceInfo.getLength();
                NewLineData _newLineData_1 = new NewLineData(_offset_4, _length_3, indentationChange, newLines_1);
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
      XtendFormatterConfig _cfg = fmt.getCfg();
      IntegerEntry _maxLineWidth = _cfg.getMaxLineWidth();
      int _value = _maxLineWidth.getValue();
      return (line <= _value);
    }
  }
  
  public Iterable<FormattingData> append(final INode node, final Procedure1<? super FormattingDataInit> init) {
    Iterable<FormattingData> _xifexpression = null;
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsAfter = this._nodeModelAccess.getHiddenLeafsAfter(node);
      Iterable<FormattingData> _newFormattingData = this.newFormattingData(_hiddenLeafsAfter, init);
      _xifexpression = _newFormattingData;
    }
    return _xifexpression;
  }
  
  public Iterable<FormattingData> append(final INode node, final NewLineConfig configuration) {
    Iterable<FormattingData> _xifexpression = null;
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsAfter = this._nodeModelAccess.getHiddenLeafsAfter(node);
      Iterable<FormattingData> _newFormattingData = this.newFormattingData(_hiddenLeafsAfter, configuration, 0);
      _xifexpression = _newFormattingData;
    }
    return _xifexpression;
  }
  
  public Iterable<FormattingData> prepend(final INode node, final Procedure1<? super FormattingDataInit> init) {
    Iterable<FormattingData> _xifexpression = null;
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsBefore = this._nodeModelAccess.getHiddenLeafsBefore(node);
      Iterable<FormattingData> _newFormattingData = this.newFormattingData(_hiddenLeafsBefore, init);
      _xifexpression = _newFormattingData;
    }
    return _xifexpression;
  }
  
  public Iterable<FormattingData> prepend(final INode node, final NewLineConfig configuration) {
    Iterable<FormattingData> _xifexpression = null;
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsBefore = this._nodeModelAccess.getHiddenLeafsBefore(node);
      Iterable<FormattingData> _newFormattingData = this.newFormattingData(_hiddenLeafsBefore, configuration, 0);
      _xifexpression = _newFormattingData;
    }
    return _xifexpression;
  }
}
