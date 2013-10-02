package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.List;
import java.util.Stack;
import org.eclipse.xtend.core.formatting.Chunk;
import org.eclipse.xtend.core.formatting.Line;
import org.eclipse.xtend.core.formatting.LineModel;
import org.eclipse.xtend.core.formatting.SemanticWhitespace;
import org.eclipse.xtend.core.formatting.TemplateWhitespace;
import org.eclipse.xtend.core.richstring.AbstractRichStringPartAcceptor.ForLoopOnce;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.formatting.NodeModelAccess;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class RichStringToLineModel extends ForLoopOnce {
  private final RichString string;
  
  private final String document;
  
  private final NodeModelAccess nodeModelAccess;
  
  private final LineModel _model = new Function0<LineModel>() {
    public LineModel apply() {
      LineModel _lineModel = new LineModel();
      return _lineModel;
    }
  }.apply();
  
  public LineModel getModel() {
    return this._model;
  }
  
  private int offset = new Function0<Integer>() {
    public Integer apply() {
      int _minus = (-1);
      return _minus;
    }
  }.apply();
  
  private int contentStartOffset = new Function0<Integer>() {
    public Integer apply() {
      int _minus = (-1);
      return _minus;
    }
  }.apply();
  
  private int contentStartColumn = new Function0<Integer>() {
    public Integer apply() {
      int _minus = (-1);
      return _minus;
    }
  }.apply();
  
  private Stack<Chunk> indentationStack = new Function0<Stack<Chunk>>() {
    public Stack<Chunk> apply() {
      Stack<Chunk> _stack = new Stack<Chunk>();
      return _stack;
    }
  }.apply();
  
  private boolean content = false;
  
  private boolean indentNextLine = false;
  
  private boolean _outdentThisLine = false;
  
  private int lastLiteralEndOffset;
  
  public RichStringToLineModel(final NodeModelAccess nodeModelAccess, final RichString string) {
    this.nodeModelAccess = nodeModelAccess;
    this.string = string;
    INode _nodeForEObject = nodeModelAccess.nodeForEObject(string);
    ICompositeNode _rootNode = _nodeForEObject.getRootNode();
    String _text = _rootNode.getText();
    this.document = _text;
  }
  
  public boolean outdentThisLine() {
    boolean _xifexpression = false;
    if (this.indentNextLine) {
      boolean _indentNextLine = this.indentNextLine = false;
      _xifexpression = _indentNextLine;
    } else {
      boolean __outdentThisLine = this._outdentThisLine = true;
      _xifexpression = __outdentThisLine;
    }
    return _xifexpression;
  }
  
  public void finish() {
    this.acceptLineBreak(0, false, false);
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
      boolean _startsWith_1 = t.startsWith("»»");
      if (_startsWith_1) {
        _matched=true;
        _switchResult = 2;
      }
    }
    if (!_matched) {
      boolean _startsWith_2 = t.startsWith("»");
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
  
  protected int literalPostfixLenght(final INode node) {
    int _switchResult = (int) 0;
    String _text = node.getText();
    final String t = _text;
    boolean _matched = false;
    if (!_matched) {
      boolean _endsWith = t.endsWith("\'\'\'");
      if (_endsWith) {
        _matched=true;
        _switchResult = 3;
      }
    }
    if (!_matched) {
      boolean _endsWith_1 = t.endsWith("««");
      if (_endsWith_1) {
        _matched=true;
        _switchResult = 2;
      }
    }
    if (!_matched) {
      boolean _endsWith_2 = t.endsWith("«");
      if (_endsWith_2) {
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
    super.announceNextLiteral(object);
    boolean _and = false;
    boolean _greaterThan = (this.lastLiteralEndOffset > 0);
    if (!_greaterThan) {
      _and = false;
    } else {
      boolean _lessThan = (this.contentStartOffset < 0);
      _and = (_greaterThan && _lessThan);
    }
    if (_and) {
      this.contentStartOffset = this.lastLiteralEndOffset;
    }
    final INode node = this.nodeModelAccess.nodeForFeature(object, Literals.XSTRING_LITERAL__VALUE);
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      int _offset = node.getOffset();
      int _literalPrefixLenght = this.literalPrefixLenght(node);
      int _plus = (_offset + _literalPrefixLenght);
      this.offset = _plus;
      int _endOffset = node.getEndOffset();
      int _literalPostfixLenght = this.literalPostfixLenght(node);
      int _minus = (_endOffset - _literalPostfixLenght);
      this.lastLiteralEndOffset = _minus;
    }
    this.content = true;
  }
  
  public void acceptSemanticLineBreak(final int charCount, final RichStringLiteral origin, final boolean controlStructureSeen) {
    super.acceptSemanticLineBreak(charCount, origin, controlStructureSeen);
    this.acceptLineBreak(charCount, true, true);
    int _plus = (this.offset + charCount);
    this.offset = _plus;
  }
  
  public void acceptTemplateLineBreak(final int charCount, final RichStringLiteral origin) {
    super.acceptTemplateLineBreak(charCount, origin);
    this.acceptLineBreak(charCount, false, true);
    int _plus = (this.offset + charCount);
    this.offset = _plus;
  }
  
  public void acceptLineBreak(final int charCount, final boolean semantic, final boolean startNewLine) {
    this.startContent();
    boolean _greaterThan = (this.contentStartOffset > 0);
    if (_greaterThan) {
      final String lastLinesContent = this.document.substring(this.contentStartOffset, this.offset);
      LineModel _model = this.getModel();
      List<Line> _lines = _model.getLines();
      boolean _isEmpty = _lines.isEmpty();
      if (_isEmpty) {
        LineModel _model_1 = this.getModel();
        _model_1.setLeadingText(lastLinesContent);
        this.contentStartColumn = 0;
      } else {
        LineModel _model_2 = this.getModel();
        List<Line> _lines_1 = _model_2.getLines();
        final Line lastLine = IterableExtensions.<Line>last(_lines_1);
        lastLine.setContent(lastLinesContent);
        int _offset = lastLine.getOffset();
        int _newLineCharCount = lastLine.getNewLineCharCount();
        int _plus = (_offset + _newLineCharCount);
        final int newContentStartColumn = (this.contentStartOffset - _plus);
        boolean _isLeadingSemanticNewLine = lastLine.isLeadingSemanticNewLine();
        if (_isLeadingSemanticNewLine) {
          boolean _greaterThan_1 = (newContentStartColumn > this.contentStartColumn);
          if (_greaterThan_1) {
            final int length = (newContentStartColumn - this.contentStartColumn);
            int _minus = (this.contentStartOffset - length);
            final String text = this.document.substring(_minus, this.contentStartOffset);
            SemanticWhitespace _semanticWhitespace = new SemanticWhitespace(text, newContentStartColumn);
            this.indentationStack.push(_semanticWhitespace);
          }
        }
        boolean _lessThan = (newContentStartColumn < this.contentStartColumn);
        if (_lessThan) {
          Iterable<SemanticWhitespace> _filter = Iterables.<SemanticWhitespace>filter(this.indentationStack, SemanticWhitespace.class);
          List<SemanticWhitespace> _list = IterableExtensions.<SemanticWhitespace>toList(_filter);
          for (final SemanticWhitespace ws : _list) {
            int _column = ws.getColumn();
            boolean _greaterThan_2 = (_column > newContentStartColumn);
            if (_greaterThan_2) {
              this.indentationStack.remove(ws);
            }
          }
        }
        if (this._outdentThisLine) {
          boolean _empty = this.indentationStack.empty();
          boolean _not = (!_empty);
          if (_not) {
            this.indentationStack.pop();
          }
          this._outdentThisLine = false;
        }
        lastLine.setIndentLength(newContentStartColumn);
        boolean _notEquals = (newContentStartColumn != 0);
        if (_notEquals) {
          this.contentStartColumn = newContentStartColumn;
        }
        LineModel _model_3 = this.getModel();
        List<Line> _lines_2 = _model_3.getLines();
        Line _last = IterableExtensions.<Line>last(_lines_2);
        List<Chunk> _chunks = _last.getChunks();
        Iterables.<Chunk>addAll(_chunks, this.indentationStack);
      }
    }
    if (this.indentNextLine) {
      TemplateWhitespace _templateWhitespace = new TemplateWhitespace("");
      this.indentationStack.push(_templateWhitespace);
      this.indentNextLine = false;
    }
    int _minus_1 = (-1);
    this.contentStartOffset = _minus_1;
    this.content = false;
    if (startNewLine) {
      LineModel _model_4 = this.getModel();
      List<Line> _lines_3 = _model_4.getLines();
      Line _line = new Line(this.offset, semantic, charCount);
      _lines_3.add(_line);
    }
  }
  
  public void startContent() {
    boolean _not = (!this.content);
    if (_not) {
      this.contentStartOffset = this.offset;
      this.content = true;
    }
  }
  
  public void acceptSemanticText(final CharSequence text, final RichStringLiteral origin) {
    super.acceptSemanticText(text, origin);
    boolean _not = (!this.content);
    if (_not) {
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
        this.startContent();
      }
    }
    int _length_2 = text.length();
    int _plus = (this.offset + _length_2);
    this.offset = _plus;
  }
  
  public void acceptTemplateText(final CharSequence text, final RichStringLiteral origin) {
    super.acceptTemplateText(text, origin);
    boolean _not = (!this.content);
    if (_not) {
      LineModel _model = this.getModel();
      int _rootIndentLenght = _model.getRootIndentLenght();
      boolean _lessThan = (_rootIndentLenght < 0);
      if (_lessThan) {
        LineModel _model_1 = this.getModel();
        int _length = text.length();
        _model_1.setRootIndentLenght(_length);
        int _length_1 = text.length();
        this.contentStartColumn = _length_1;
      }
    }
    int _length_2 = text.length();
    int _plus = (this.offset + _length_2);
    this.offset = _plus;
  }
  
  public void acceptExpression(final XExpression expression, final CharSequence indentation) {
    super.acceptExpression(expression, indentation);
    this.startContent();
  }
  
  public void acceptIfCondition(final XExpression condition) {
    super.acceptIfCondition(condition);
    this.startContent();
    this.indentNextLine = true;
  }
  
  public void acceptElseIfCondition(final XExpression condition) {
    super.acceptElseIfCondition(condition);
    this.outdentThisLine();
    this.startContent();
    this.indentNextLine = true;
  }
  
  public void acceptElse() {
    super.acceptElse();
    this.outdentThisLine();
    this.startContent();
    this.indentNextLine = true;
  }
  
  public void acceptEndIf() {
    super.acceptEndIf();
    this.outdentThisLine();
    this.startContent();
  }
  
  public void acceptForLoop(final JvmFormalParameter parameter, final XExpression expression) {
    super.acceptForLoop(parameter, expression);
    this.startContent();
    this.indentNextLine = true;
  }
  
  public void acceptEndFor(final XExpression after, final CharSequence indentation) {
    super.acceptEndFor(after, indentation);
    this.outdentThisLine();
    this.startContent();
  }
}
