package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.xtend.core.formatting.FormattableDocument;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.core.formatting.FormattingDataInit;
import org.eclipse.xtend.core.formatting.NewLineConfiguration;
import org.eclipse.xtend.core.formatting.NewLineData;
import org.eclipse.xtend.core.formatting.NodeModelAccess;
import org.eclipse.xtend.core.formatting.RendererConfiguration;
import org.eclipse.xtend.core.formatting.WhitespaceData;
import org.eclipse.xtext.nodemodel.ICompositeNode;
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
  
  public FormattingData newFormattingData(final Pair<Integer,Integer> range, final String document, final NewLineConfiguration configuration) {
    int countedNewLines = 0;
    Integer i = range.getKey();
    Integer _value = range.getValue();
    Integer _key = range.getKey();
    int _plus = ((_value).intValue() + (_key).intValue());
    boolean _lessThan = ((i).intValue() < _plus);
    boolean _while = _lessThan;
    while (_while) {
      {
        char _charAt = document.charAt((i).intValue());
        String _string = Character.valueOf(_charAt).toString();
        boolean _equals = Objects.equal(_string, "\n");
        if (_equals) {
          int _plus_1 = (countedNewLines + 1);
          countedNewLines = _plus_1;
        }
        int _plus_2 = ((i).intValue() + 1);
        i = Integer.valueOf(_plus_2);
      }
      Integer _value_1 = range.getValue();
      Integer _key_1 = range.getKey();
      int _plus_1 = ((_value_1).intValue() + (_key_1).intValue());
      boolean _lessThan_1 = ((i).intValue() < _plus_1);
      _while = _lessThan_1;
    }
    int _minNewLines = configuration.getMinNewLines();
    int _max = Math.max(countedNewLines, _minNewLines);
    int _maxNewLines = configuration.getMaxNewLines();
    final int newLines = Math.min(_max, _maxNewLines);
    Integer _key_1 = range.getKey();
    Integer _value_1 = range.getValue();
    NewLineData _newLineData = new NewLineData((_key_1).intValue(), (_value_1).intValue(), 0, newLines);
    return _newLineData;
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
  
  public FormattingData append(final INode node, final NewLineConfiguration configuration) {
    FormattingData _xifexpression = null;
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      Pair<Integer,Integer> _rangeAfter = this._nodeModelAccess.getRangeAfter(node);
      ICompositeNode _rootNode = node.getRootNode();
      String _text = _rootNode.getText();
      FormattingData _newFormattingData = _rangeAfter==null?(FormattingData)null:this.newFormattingData(_rangeAfter, _text, configuration);
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
  
  public FormattingData prepend(final INode node, final NewLineConfiguration configuration) {
    FormattingData _xifexpression = null;
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      Pair<Integer,Integer> _rangeBefore = this._nodeModelAccess.getRangeBefore(node);
      ICompositeNode _rootNode = node.getRootNode();
      String _text = _rootNode.getText();
      FormattingData _newFormattingData = _rangeBefore==null?(FormattingData)null:this.newFormattingData(_rangeBefore, _text, configuration);
      _xifexpression = _newFormattingData;
    }
    return _xifexpression;
  }
}
