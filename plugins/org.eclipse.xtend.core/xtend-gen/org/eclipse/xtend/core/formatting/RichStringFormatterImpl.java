package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.formatting.FormattableDocument;
import org.eclipse.xtend.core.formatting.FormatterExtensions;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.core.formatting.FormattingDataInit;
import org.eclipse.xtend.core.formatting.NewLineData;
import org.eclipse.xtend.core.formatting.NodeModelAccess;
import org.eclipse.xtend.core.richstring.AbstractRichStringPartAcceptor.ForLoopOnce;
import org.eclipse.xtend.core.xtend.RichStringIf;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class RichStringFormatterImpl extends ForLoopOnce {
  @Inject
  private NodeModelAccess _nodeModelAccess;
  
  @Inject
  private FormatterExtensions _formatterExtensions;
  
  private Procedure2<? super EObject,? super FormattableDocument> _formatter;
  
  public Procedure2<? super EObject,? super FormattableDocument> getFormatter() {
    return this._formatter;
  }
  
  public void setFormatter(final Procedure2<? super EObject,? super FormattableDocument> formatter) {
    this._formatter = formatter;
  }
  
  private FormattableDocument _document;
  
  public FormattableDocument getDocument() {
    return this._document;
  }
  
  public void setDocument(final FormattableDocument document) {
    this._document = document;
  }
  
  private int offset;
  
  private boolean afterNewLine = false;
  
  private boolean semanticSeen = false;
  
  private RichStringLiteral lastLiteral;
  
  private int _bodyIndent = Integer.MAX_VALUE;
  
  public int getBodyIndent() {
    return this._bodyIndent;
  }
  
  public void setBodyIndent(final int bodyIndent) {
    this._bodyIndent = bodyIndent;
  }
  
  private List<Integer> _indentOffsets = new Function0<List<Integer>>() {
    public List<Integer> apply() {
      ArrayList<Integer> _newArrayList = CollectionLiterals.<Integer>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public List<Integer> getIndentOffsets() {
    return this._indentOffsets;
  }
  
  public void setIndentOffsets(final List<Integer> indentOffsets) {
    this._indentOffsets = indentOffsets;
  }
  
  private int _indentOffset = new Function0<Integer>() {
    public Integer apply() {
      int _minus = (-1);
      return _minus;
    }
  }.apply();
  
  public int getIndentOffset() {
    return this._indentOffset;
  }
  
  public void setIndentOffset(final int indentOffset) {
    this._indentOffset = indentOffset;
  }
  
  private int _outdentOffset = new Function0<Integer>() {
    public Integer apply() {
      int _minus = (-1);
      return _minus;
    }
  }.apply();
  
  public int getOutdentOffset() {
    return this._outdentOffset;
  }
  
  public void setOutdentOffset(final int outdentOffset) {
    this._outdentOffset = outdentOffset;
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
    final INode node = this._nodeModelAccess.nodeForFeature(object, Literals.XSTRING_LITERAL__VALUE);
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      String _text = node.getText();
      boolean _startsWith = _text.startsWith("\u00BB");
      if (_startsWith) {
        FormattableDocument _document = this.getDocument();
        final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formatterExtensions.prepend(node, _function);
        _document.operator_add(_prepend);
      }
      String _text_1 = node.getText();
      boolean _endsWith = _text_1.endsWith("\u00AB");
      if (_endsWith) {
        FormattableDocument _document_1 = this.getDocument();
        final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(node, _function_1);
        _document_1.operator_add(_append);
      }
      this.lastLiteral = object;
      int _offset = node.getOffset();
      int _literalPrefixLenght = this.literalPrefixLenght(node);
      int _plus = (_offset + _literalPrefixLenght);
      this.offset = _plus;
      this.afterNewLine = false;
    }
  }
  
  public void acceptSemanticLineBreak(final int charCount, final RichStringLiteral origin, final boolean controlStructureSeen) {
    int _plus = (this.offset + charCount);
    this.offset = _plus;
    this.afterNewLine = true;
    this.semanticSeen = true;
  }
  
  public void acceptTemplateLineBreak(final int charCount, final RichStringLiteral origin) {
    boolean _not = (!this.semanticSeen);
    if (_not) {
      this.setIndentOffset(this.offset);
    }
    int _plus = (this.offset + charCount);
    this.offset = _plus;
    this.afterNewLine = true;
  }
  
  public void acceptSemanticText(final CharSequence text, final RichStringLiteral origin) {
    int _length = text.length();
    int _plus = (this.offset + _length);
    this.offset = _plus;
    this.afterNewLine = false;
    this.semanticSeen = true;
  }
  
  public void acceptTemplateText(final CharSequence text, final RichStringLiteral origin) {
    int _length = text.length();
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      boolean _and = false;
      if (!this.afterNewLine) {
        _and = false;
      } else {
        boolean _notEquals = (!Objects.equal(this.lastLiteral, null));
        _and = (this.afterNewLine && _notEquals);
      }
      if (_and) {
        final INode node = this._nodeModelAccess.nodeForFeature(this.lastLiteral, Literals.XSTRING_LITERAL__VALUE);
        int _length_1 = text.length();
        int _plus = (this.offset + _length_1);
        int _plus_1 = (_plus + 3);
        int _offset = node.getOffset();
        int _length_2 = node.getLength();
        int _plus_2 = (_offset + _length_2);
        boolean _equals = (_plus_1 == _plus_2);
        if (_equals) {
          FormattableDocument _document = this.getDocument();
          int _length_3 = text.length();
          RuntimeException _xifexpression = null;
          FormattableDocument _document_1 = this.getDocument();
          boolean _isDebugConflicts = _document_1.isDebugConflicts();
          if (_isDebugConflicts) {
            RuntimeException _runtimeException = new RuntimeException();
            _xifexpression = _runtimeException;
          }
          NewLineData _newLineData = new NewLineData(this.offset, _length_3, 0, _xifexpression, 0);
          _document.operator_add(_newLineData);
          int _minus = (this.offset - 2);
          this.setOutdentOffset(_minus);
        } else {
          int _bodyIndent = this.getBodyIndent();
          int _length_4 = text.length();
          int _min = Math.min(_bodyIndent, _length_4);
          this.setBodyIndent(_min);
          List<Integer> _indentOffsets = this.getIndentOffsets();
          _indentOffsets.add(Integer.valueOf(this.offset));
        }
      }
      this.afterNewLine = false;
    }
    int _length_5 = text.length();
    int _plus_3 = (this.offset + _length_5);
    this.offset = _plus_3;
  }
  
  public void acceptIfCondition(final XExpression condition) {
    boolean _notEquals = (!Objects.equal(condition, null));
    if (_notEquals) {
      EObject _eContainer = condition.eContainer();
      if ((_eContainer instanceof RichStringIf)) {
        EObject _eContainer_1 = condition.eContainer();
        final RichStringIf rsif = ((RichStringIf) _eContainer_1);
        FormattableDocument _document = this.getDocument();
        ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(rsif, "IF");
        final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.oneSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForKeyword, _function);
        _document.operator_add(_append);
      }
      Procedure2<? super EObject,? super FormattableDocument> _formatter = this.getFormatter();
      FormattableDocument _document_1 = this.getDocument();
      _formatter.apply(condition, _document_1);
    }
  }
  
  public void acceptExpression(final XExpression expression, final CharSequence indentation) {
    Procedure2<? super EObject,? super FormattableDocument> _formatter = this.getFormatter();
    FormattableDocument _document = this.getDocument();
    _formatter.apply(expression, _document);
  }
}
