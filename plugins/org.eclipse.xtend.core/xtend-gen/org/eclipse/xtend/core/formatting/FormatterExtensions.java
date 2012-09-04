package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.xtend.core.formatting.FormattableDocument;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.core.formatting.FormattingDataInit;
import org.eclipse.xtend.core.formatting.NewLineData;
import org.eclipse.xtend.core.formatting.NodeModelAccess;
import org.eclipse.xtend.core.formatting.RendererConfiguration;
import org.eclipse.xtend.core.formatting.WhitespaceData;
import org.eclipse.xtext.nodemodel.INode;
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
      RendererConfiguration _cfg = fmt.getCfg();
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
}
