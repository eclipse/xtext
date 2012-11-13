package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.formatting.Chunk;
import org.eclipse.xtend.core.formatting.Dummy;
import org.eclipse.xtend.core.formatting.Expression;
import org.eclipse.xtend.core.formatting.Line;
import org.eclipse.xtend.core.formatting.LineModel;
import org.eclipse.xtend.core.formatting.NodeModelAccess;
import org.eclipse.xtend.core.formatting.SemanitcText;
import org.eclipse.xtend.core.formatting.SemanitcWhitespace;
import org.eclipse.xtend.core.formatting.TemplateWhitespace;
import org.eclipse.xtend.core.richstring.AbstractRichStringPartAcceptor.ForLoopOnce;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class RichStringToLineModel extends ForLoopOnce {
  private final RichString string;
  
  private final NodeModelAccess nodeModelAccess;
  
  private final LineModel _model = new Function0<LineModel>() {
    public LineModel apply() {
      LineModel _lineModel = new LineModel(RichStringToLineModel.this.string);
      return _lineModel;
    }
  }.apply();
  
  public LineModel getModel() {
    return this._model;
  }
  
  private int offset;
  
  public RichStringToLineModel(final NodeModelAccess nodeModelAccess, final RichString string) {
    this.nodeModelAccess = nodeModelAccess;
    this.string = string;
  }
  
  protected List<Chunk> currentLine() {
    List<Chunk> _xifexpression = null;
    LineModel _model = this.getModel();
    List<Line> _otherLines = _model.getOtherLines();
    boolean _isEmpty = _otherLines.isEmpty();
    if (_isEmpty) {
      LineModel _model_1 = this.getModel();
      List<Chunk> _firstLine = _model_1.getFirstLine();
      _xifexpression = _firstLine;
    } else {
      LineModel _model_2 = this.getModel();
      List<Line> _otherLines_1 = _model_2.getOtherLines();
      Line _last = IterableExtensions.<Line>last(_otherLines_1);
      List<Chunk> _chunks = _last.getChunks();
      _xifexpression = _chunks;
    }
    return _xifexpression;
  }
  
  protected int literalPrefixLenght(final INode node) {
    int _switchResult = (int) 0;
    String _text = node.getText();
    final String t = _text;
    boolean _matched = false;
    if (!_matched) {
      boolean _startsWith = t.startsWith("\'\'\'");
      if (_startsWith) {
        _matched=true;
        _switchResult = 3;
      }
    }
    if (!_matched) {
      boolean _startsWith_1 = t.startsWith("\u00BB\u00BB");
      if (_startsWith_1) {
        _matched=true;
        _switchResult = 2;
      }
    }
    if (!_matched) {
      boolean _startsWith_2 = t.startsWith("\u00BB");
      if (_startsWith_2) {
        _matched=true;
        _switchResult = 1;
      }
    }
    if (!_matched) {
      _switchResult = 1;
    }
    return _switchResult;
  }
  
  public void announceNextLiteral(final RichStringLiteral object) {
    final INode node = this.nodeModelAccess.nodeForFeature(object, Literals.XSTRING_LITERAL__VALUE);
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      int _offset = node.getOffset();
      int _literalPrefixLenght = this.literalPrefixLenght(node);
      int _plus = (_offset + _literalPrefixLenght);
      this.offset = _plus;
    }
  }
  
  public void acceptSemanticLineBreak(final int charCount, final RichStringLiteral origin, final boolean controlStructureSeen) {
    LineModel _model = this.getModel();
    List<Line> _otherLines = _model.getOtherLines();
    Line _line = new Line(this.offset, true, charCount);
    _otherLines.add(_line);
    int _plus = (this.offset + charCount);
    this.offset = _plus;
  }
  
  public void acceptTemplateLineBreak(final int charCount, final RichStringLiteral origin) {
    LineModel _model = this.getModel();
    List<Line> _otherLines = _model.getOtherLines();
    Line _line = new Line(this.offset, false, charCount);
    _otherLines.add(_line);
    int _plus = (this.offset + charCount);
    this.offset = _plus;
  }
  
  public void acceptSemanticText(final CharSequence text, final RichStringLiteral origin) {
    boolean _and = false;
    int _length = text.length();
    boolean _greaterThan = (_length > 0);
    if (!_greaterThan) {
      _and = false;
    } else {
      int _length_1 = text.length();
      int _minus = (_length_1 - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      final Function2<Boolean,Integer,Boolean> _function = new Function2<Boolean,Integer,Boolean>() {
          public Boolean apply(final Boolean v, final Integer i) {
            boolean _or = false;
            if ((v).booleanValue()) {
              _or = true;
            } else {
              char _charAt = text.charAt((i).intValue());
              boolean _isWhitespace = Character.isWhitespace(_charAt);
              boolean _not = (!_isWhitespace);
              _or = ((v).booleanValue() || _not);
            }
            return Boolean.valueOf(_or);
          }
        };
      Boolean _fold = IterableExtensions.<Integer, Boolean>fold(_upTo, Boolean.valueOf(false), _function);
      _and = (_greaterThan && (_fold).booleanValue());
    }
    if (_and) {
      List<Chunk> _currentLine = this.currentLine();
      SemanitcText _semanitcText = new SemanitcText(this.offset, text);
      _currentLine.add(_semanitcText);
    } else {
      List<Chunk> _currentLine_1 = this.currentLine();
      SemanitcWhitespace _semanitcWhitespace = new SemanitcWhitespace(this.offset, text);
      _currentLine_1.add(_semanitcWhitespace);
    }
    int _length_2 = text.length();
    int _plus = (this.offset + _length_2);
    this.offset = _plus;
  }
  
  public void acceptTemplateText(final CharSequence text, final RichStringLiteral origin) {
    List<Chunk> _currentLine = this.currentLine();
    TemplateWhitespace _templateWhitespace = new TemplateWhitespace(this.offset, text);
    _currentLine.add(_templateWhitespace);
    int _length = text.length();
    int _plus = (this.offset + _length);
    this.offset = _plus;
  }
  
  public void acceptExpression(final XExpression expression, final CharSequence indentation) {
    List<Chunk> _currentLine = this.currentLine();
    Expression _expression = new Expression(this.offset, null, expression);
    _currentLine.add(_expression);
  }
  
  public void acceptIfCondition(final XExpression condition) {
    List<Chunk> _currentLine = this.currentLine();
    EObject _eContainer = condition.eContainer();
    Expression _expression = new Expression(this.offset, null, ((XExpression) _eContainer));
    _currentLine.add(_expression);
  }
  
  public void acceptElseIfCondition(final XExpression condition) {
    List<Chunk> _currentLine = this.currentLine();
    Dummy _dummy = new Dummy(this.offset, null);
    _currentLine.add(_dummy);
  }
  
  public void acceptElse() {
    List<Chunk> _currentLine = this.currentLine();
    Dummy _dummy = new Dummy(this.offset, null);
    _currentLine.add(_dummy);
  }
  
  public void acceptEndIf() {
    List<Chunk> _currentLine = this.currentLine();
    Dummy _dummy = new Dummy(this.offset, null);
    _currentLine.add(_dummy);
  }
}
