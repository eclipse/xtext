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
import org.eclipse.xtend.core.formatting.LeafInfo;
import org.eclipse.xtend.core.formatting.NewLineConfig;
import org.eclipse.xtend.core.formatting.NewLineData;
import org.eclipse.xtend.core.formatting.NodeModelAccess;
import org.eclipse.xtend.core.formatting.WhitespaceData;
import org.eclipse.xtend.core.formatting.WhitespaceInfo;
import org.eclipse.xtend.core.formatting.XtendFormatterConfig;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class FormatterExtensions {
  @Inject
  private NodeModelAccess _nodeModelAccess;
  
  public FormattingData newFormattingData(final Pair<Integer,Integer> range, final Procedure1<? super FormattingDataInit> init) {
    FormattingDataInit _formattingDataInit = new FormattingDataInit();
    final FormattingDataInit it = _formattingDataInit;
    init.apply(it);
    boolean _or = false;
    boolean _equals = (it.newLines == 0);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = Objects.equal(it.space, "");
      _or = (_equals || _equals_1);
    }
    if (_or) {
      Integer _key = range.getKey();
      Integer _value = range.getValue();
      WhitespaceData _whitespaceData = new WhitespaceData((_key).intValue(), (_value).intValue(), it.indentationChange, it.space);
      return _whitespaceData;
    } else {
      boolean _equals_2 = Objects.equal(it.space, null);
      if (_equals_2) {
        Integer _key_1 = range.getKey();
        Integer _value_1 = range.getValue();
        NewLineData _newLineData = new NewLineData((_key_1).intValue(), (_value_1).intValue(), it.indentationChange, it.newLines);
        return _newLineData;
      } else {
        String _string = init.toString();
        IllegalStateException _illegalStateException = new IllegalStateException(_string);
        throw _illegalStateException;
      }
    }
  }
  
  public Iterable<FormattingData> newFormattingData(final HiddenLeafs leafs, final NewLineConfig configuration) {
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
              int _offset = _whitespaceInfo.getOffset();
              int _length = _whitespaceInfo.getLength();
              WhitespaceData _whitespaceData = new WhitespaceData(_offset, _length, 0, " ");
              result.add(_whitespaceData);
            } else {
              boolean _not = (!applied);
              if (_not) {
                Integer _newLines = leafs.getNewLines();
                int _minNewLines = configuration.getMinNewLines();
                int _max = Math.max((_newLines).intValue(), _minNewLines);
                int _maxNewLines = configuration.getMaxNewLines();
                int newLines = Math.min(_max, _maxNewLines);
                CommentInfo _leadingComment = _whitespaceInfo.leadingComment();
                boolean _endsWithNewLine = _leadingComment==null?false:_leadingComment.endsWithNewLine();
                if (_endsWithNewLine) {
                  int _minus = (newLines - 1);
                  newLines = _minus;
                }
                int _offset_1 = _whitespaceInfo.getOffset();
                int _length_1 = _whitespaceInfo.getLength();
                NewLineData _newLineData = new NewLineData(_offset_1, _length_1, 0, newLines);
                result.add(_newLineData);
                applied = true;
              } else {
                int newLines_1 = 1;
                CommentInfo _leadingComment_1 = _whitespaceInfo.leadingComment();
                boolean _endsWithNewLine_1 = _leadingComment_1==null?false:_leadingComment_1.endsWithNewLine();
                if (_endsWithNewLine_1) {
                  int _minus_1 = (newLines_1 - 1);
                  newLines_1 = _minus_1;
                }
                int _offset_2 = _whitespaceInfo.getOffset();
                int _length_2 = _whitespaceInfo.getLength();
                NewLineData _newLineData_1 = new NewLineData(_offset_2, _length_2, 0, newLines_1);
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
  
  public WhitespaceInfo findWhitespaceToWrap(final HiddenLeafs leafs) {
    WhitespaceInfo _xblockexpression = null;
    {
      WhitespaceInfo ws = null;
      List<LeafInfo> _leafs = leafs.getLeafs();
      List<LeafInfo> _reverse = ListExtensions.<LeafInfo>reverse(_leafs);
      for (final LeafInfo l : _reverse) {
        boolean _matched = false;
        if (!_matched) {
          if (l instanceof WhitespaceInfo) {
            final WhitespaceInfo _whitespaceInfo = (WhitespaceInfo)l;
            _matched=true;
            ws = _whitespaceInfo;
          }
        }
        if (!_matched) {
          if (l instanceof CommentInfo) {
            final CommentInfo _commentInfo = (CommentInfo)l;
            _matched=true;
            boolean _isTrailing = _commentInfo.isTrailing();
            if (_isTrailing) {
              return ws;
            }
          }
        }
      }
      _xblockexpression = (ws);
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
      int _maxLineWidth = _cfg.getMaxLineWidth();
      return (line <= _maxLineWidth);
    }
  }
  
  public FormattingData append(final INode node, final Procedure1<? super FormattingDataInit> init) {
    FormattingData _xifexpression = null;
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      Pair<Integer,Integer> _rangeAfter = this._nodeModelAccess.getRangeAfter(node);
      FormattingData _newFormattingData = _rangeAfter==null?(FormattingData)null:this.newFormattingData(_rangeAfter, init);
      _xifexpression = _newFormattingData;
    }
    return _xifexpression;
  }
  
  public Iterable<FormattingData> append(final INode node, final NewLineConfig configuration) {
    Iterable<FormattingData> _xifexpression = null;
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsAfter = this._nodeModelAccess.getHiddenLeafsAfter(node);
      Iterable<FormattingData> _newFormattingData = this.newFormattingData(_hiddenLeafsAfter, configuration);
      _xifexpression = _newFormattingData;
    }
    return _xifexpression;
  }
  
  public FormattingData prepend(final INode node, final Procedure1<? super FormattingDataInit> init) {
    FormattingData _xifexpression = null;
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      Pair<Integer,Integer> _rangeBefore = this._nodeModelAccess.getRangeBefore(node);
      FormattingData _newFormattingData = _rangeBefore==null?(FormattingData)null:this.newFormattingData(_rangeBefore, init);
      _xifexpression = _newFormattingData;
    }
    return _xifexpression;
  }
  
  public Iterable<FormattingData> prepend(final INode node, final NewLineConfig configuration) {
    Iterable<FormattingData> _xifexpression = null;
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsAfter = this._nodeModelAccess.getHiddenLeafsAfter(node);
      Iterable<FormattingData> _newFormattingData = this.newFormattingData(_hiddenLeafsAfter, configuration);
      _xifexpression = _newFormattingData;
    }
    return _xifexpression;
  }
}
