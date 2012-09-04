package org.eclipse.xtend.core.formatting;

import com.google.inject.Inject;
import org.eclipse.xtend.core.formatting.FormattableDocument;
import org.eclipse.xtend.core.formatting.FormatterExtensions;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.core.formatting.FormattingDataInit;
import org.eclipse.xtend.core.formatting.NewLineData;
import org.eclipse.xtend.core.formatting.NodeModelAccess;
import org.eclipse.xtend.core.formatting.RendererConfiguration;
import org.eclipse.xtend.core.formatting.XtendFormatter;
import org.eclipse.xtend.core.richstring.AbstractRichStringPartAcceptor.ForLoopOnce;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class RichStringFormatterImpl extends ForLoopOnce {
  @Inject
  private NodeModelAccess _nodeModelAccess;
  
  @Inject
  private FormatterExtensions _formatterExtensions;
  
  private XtendFormatter _formatter;
  
  public XtendFormatter getFormatter() {
    return this._formatter;
  }
  
  public void setFormatter(final XtendFormatter formatter) {
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
  
  private boolean afterSemanticNewLine = false;
  
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
      boolean _startsWith_1 = t.startsWith("\u00AB\u00AB");
      if (_startsWith_1) {
        _matched=true;
        _switchResult = 2;
      }
    }
    if (!_matched) {
      boolean _startsWith_2 = t.startsWith("\u00AB");
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
    int _offset = node.getOffset();
    int _literalPrefixLenght = this.literalPrefixLenght(node);
    int _plus = (_offset + _literalPrefixLenght);
    this.offset = _plus;
    this.afterSemanticNewLine = false;
  }
  
  public void acceptSemanticLineBreak(final int charCount, final RichStringLiteral origin, final boolean controlStructureSeen) {
    int _plus = (this.offset + charCount);
    this.offset = _plus;
    this.afterSemanticNewLine = true;
  }
  
  public void acceptTemplateLineBreak(final int charCount, final RichStringLiteral origin) {
    FormattableDocument _document = this.getDocument();
    Pair<Integer,Integer> _mappedTo = Pair.<Integer, Integer>of(Integer.valueOf(this.offset), Integer.valueOf(charCount));
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.newLine();
        }
      };
    FormattingData _newFormattingData = this._formatterExtensions.newFormattingData(_mappedTo, _function);
    _document.operator_add(_newFormattingData);
    int _plus = (this.offset + charCount);
    this.offset = _plus;
    this.afterSemanticNewLine = false;
  }
  
  public void acceptSemanticText(final CharSequence text, final RichStringLiteral origin) {
    int _length = text.length();
    int _plus = (this.offset + _length);
    this.offset = _plus;
    this.afterSemanticNewLine = false;
  }
  
  public void acceptTemplateText(final CharSequence text, final RichStringLiteral origin) {
    final int length = text.length();
    boolean _greaterThan = (length > 0);
    if (_greaterThan) {
      if (this.afterSemanticNewLine) {
        FormattableDocument _document = this.getDocument();
        NewLineData _newLineData = new NewLineData(this.offset, length, 0, 0);
        _document.operator_add(_newLineData);
      } else {
        FormattableDocument _document_1 = this.getDocument();
        Pair<Integer,Integer> _mappedTo = Pair.<Integer, Integer>of(Integer.valueOf(this.offset), Integer.valueOf(length));
        final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              FormattableDocument _document = RichStringFormatterImpl.this.getDocument();
              RendererConfiguration _cfg = _document.getCfg();
              String _indentation = _cfg.getIndentation(1);
              it.space = _indentation;
            }
          };
        FormattingData _newFormattingData = this._formatterExtensions.newFormattingData(_mappedTo, _function);
        _document_1.operator_add(_newFormattingData);
      }
    }
    int _plus = (this.offset + length);
    this.offset = _plus;
    this.afterSemanticNewLine = false;
  }
}
