package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.formatting.Chunk;
import org.eclipse.xtend.core.formatting.Line;
import org.eclipse.xtend.core.formatting.LineModel;
import org.eclipse.xtend.core.formatting.RichStringToLineModel;
import org.eclipse.xtend.core.formatting.SemanticWhitespace;
import org.eclipse.xtend.core.formatting.TemplateWhitespace;
import org.eclipse.xtend.core.richstring.DefaultIndentationHandler;
import org.eclipse.xtend.core.richstring.RichStringProcessor;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringElseIf;
import org.eclipse.xtend.core.xtend.RichStringForLoop;
import org.eclipse.xtend.core.xtend.RichStringIf;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.formatting.FormattableDocument;
import org.eclipse.xtext.xbase.formatting.FormattingData;
import org.eclipse.xtext.xbase.formatting.FormattingDataFactory;
import org.eclipse.xtext.xbase.formatting.FormattingDataInit;
import org.eclipse.xtext.xbase.formatting.NewLineData;
import org.eclipse.xtext.xbase.formatting.NodeModelAccess;
import org.eclipse.xtext.xbase.formatting.WhitespaceData;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.Synthetic;

/**
 * cases to distinguish:
 * 	1. single-line
 *  2. multi-line with text after opening ''': lines start with semantic whitespace
 *  3. multi-line with text before closing ''': no indentation
 *  4. multi-line with only whitespace after opening ''' and before closing ''': one level of extra indentation between ''' and '''
 */
@SuppressWarnings("all")
public class RichStringFormatter {
  @Inject
  private RichStringProcessor richStringProcessor;
  
  @Inject
  @Extension
  private NodeModelAccess _nodeModelAccess;
  
  @Inject
  @Extension
  private FormattingDataFactory _formattingDataFactory;
  
  public void format(final Procedure2<? super EObject, ? super FormattableDocument> formatter, final FormattableDocument doc, final RichString richString) {
    EObject _eContainer = richString.eContainer();
    RichString _containerOfType = EcoreUtil2.<RichString>getContainerOfType(_eContainer, RichString.class);
    boolean _notEquals = (!Objects.equal(_containerOfType, null));
    if (_notEquals) {
      return;
    }
    boolean _hasSyntaxError = this.hasSyntaxError(richString);
    if (_hasSyntaxError) {
      return;
    }
    final RichStringToLineModel impl = new RichStringToLineModel(this._nodeModelAccess, richString);
    DefaultIndentationHandler _defaultIndentationHandler = new DefaultIndentationHandler();
    this.richStringProcessor.process(richString, impl, _defaultIndentationHandler);
    impl.finish();
    this.fmt(formatter, doc, richString);
    LineModel _model = impl.getModel();
    final List<Line> lines = _model.getLines();
    boolean _and = false;
    boolean _isEmpty = lines.isEmpty();
    boolean _not = (!_isEmpty);
    if (!_not) {
      _and = false;
    } else {
      Line _last = IterableExtensions.<Line>last(lines);
      String _content = _last.getContent();
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_content);
      _and = _isNullOrEmpty;
    }
    final boolean canIndent = _and;
    for (final Line line : lines) {
      LineModel _model_1 = impl.getModel();
      int _rootIndentLenght = _model_1.getRootIndentLenght();
      boolean _greaterThan = (_rootIndentLenght > 0);
      if (_greaterThan) {
        int _xifexpression = (int) 0;
        boolean _and_1 = false;
        if (!canIndent) {
          _and_1 = false;
        } else {
          Line _head = IterableExtensions.<Line>head(lines);
          boolean _equals = Objects.equal(line, _head);
          _and_1 = _equals;
        }
        if (_and_1) {
          _xifexpression = 1;
        } else {
          _xifexpression = 0;
        }
        final int increaseIndentationChange = _xifexpression;
        int _xifexpression_1 = (int) 0;
        boolean _and_2 = false;
        if (!canIndent) {
          _and_2 = false;
        } else {
          Line _last_1 = IterableExtensions.<Line>last(lines);
          boolean _equals_1 = Objects.equal(line, _last_1);
          _and_2 = _equals_1;
        }
        if (_and_2) {
          _xifexpression_1 = (-1);
        } else {
          _xifexpression_1 = 0;
        }
        final int decraseIndentationChange = _xifexpression_1;
        int _xifexpression_2 = (int) 0;
        boolean _isLeadingSemanticNewLine = line.isLeadingSemanticNewLine();
        if (_isLeadingSemanticNewLine) {
          int _offset = line.getOffset();
          int _newLineCharCount = line.getNewLineCharCount();
          _xifexpression_2 = (_offset + _newLineCharCount);
        } else {
          _xifexpression_2 = line.getOffset();
        }
        final int nloffset = _xifexpression_2;
        int _indentLength = line.getIndentLength();
        LineModel _model_2 = impl.getModel();
        int _rootIndentLenght_1 = _model_2.getRootIndentLenght();
        final int i = Math.min(_indentLength, _rootIndentLenght_1);
        int _xifexpression_3 = (int) 0;
        boolean _isLeadingSemanticNewLine_1 = line.isLeadingSemanticNewLine();
        if (_isLeadingSemanticNewLine_1) {
          _xifexpression_3 = i;
        } else {
          int _newLineCharCount_1 = line.getNewLineCharCount();
          _xifexpression_3 = (_newLineCharCount_1 + i);
        }
        final int nllength = _xifexpression_3;
        boolean _isLeadingSemanticNewLine_2 = line.isLeadingSemanticNewLine();
        if (_isLeadingSemanticNewLine_2) {
          RuntimeException _xifexpression_4 = null;
          boolean _isDebugConflicts = doc.isDebugConflicts();
          if (_isDebugConflicts) {
            _xifexpression_4 = new RuntimeException();
          }
          NewLineData _newLineData = new NewLineData(nloffset, nllength, increaseIndentationChange, decraseIndentationChange, _xifexpression_4, Integer.valueOf(0));
          doc.operator_add(_newLineData);
        } else {
          RuntimeException _xifexpression_5 = null;
          boolean _isDebugConflicts_1 = doc.isDebugConflicts();
          if (_isDebugConflicts_1) {
            _xifexpression_5 = new RuntimeException();
          }
          NewLineData _newLineData_1 = new NewLineData(nloffset, nllength, increaseIndentationChange, decraseIndentationChange, _xifexpression_5, Integer.valueOf(1));
          doc.operator_add(_newLineData_1);
        }
        List<Chunk> _chunks = line.getChunks();
        boolean _isEmpty_1 = _chunks.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          final int offset = (nloffset + nllength);
          int _indentLength_1 = line.getIndentLength();
          LineModel _model_3 = impl.getModel();
          int _rootIndentLenght_2 = _model_3.getRootIndentLenght();
          final int length = (_indentLength_1 - _rootIndentLenght_2);
          List<Chunk> _chunks_1 = line.getChunks();
          final Function1<Chunk, CharSequence> _function = new Function1<Chunk, CharSequence>() {
            public CharSequence apply(final Chunk chunk) {
              CharSequence _switchResult = null;
              boolean _matched = false;
              if (!_matched) {
                if (chunk instanceof SemanticWhitespace) {
                  _matched=true;
                  _switchResult = ((SemanticWhitespace)chunk).getText();
                }
              }
              if (!_matched) {
                if (chunk instanceof TemplateWhitespace) {
                  _matched=true;
                  _switchResult = doc.getIndentation(1);
                }
              }
              return _switchResult;
            }
          };
          List<CharSequence> _map = ListExtensions.<Chunk, CharSequence>map(_chunks_1, _function);
          final String text = IterableExtensions.join(_map);
          RuntimeException _xifexpression_6 = null;
          boolean _isDebugConflicts_2 = doc.isDebugConflicts();
          if (_isDebugConflicts_2) {
            _xifexpression_6 = new RuntimeException();
          }
          WhitespaceData _whitespaceData = new WhitespaceData(offset, length, 0, 0, _xifexpression_6, text);
          doc.operator_add(_whitespaceData);
        }
      }
    }
  }
  
  protected boolean hasSyntaxError(final EObject obj) {
    boolean _xblockexpression = false;
    {
      final INode node = this._nodeModelAccess.nodeForEObject(obj);
      boolean _or = false;
      boolean _equals = Objects.equal(node, null);
      if (_equals) {
        _or = true;
      } else {
        SyntaxErrorMessage _syntaxErrorMessage = node.getSyntaxErrorMessage();
        boolean _notEquals = (!Objects.equal(_syntaxErrorMessage, null));
        _or = _notEquals;
      }
      if (_or) {
        return true;
      }
      BidiTreeIterable<INode> _asTreeIterable = node.getAsTreeIterable();
      final Function1<INode, Boolean> _function = new Function1<INode, Boolean>() {
        public Boolean apply(final INode it) {
          SyntaxErrorMessage _syntaxErrorMessage = it.getSyntaxErrorMessage();
          return Boolean.valueOf((!Objects.equal(_syntaxErrorMessage, null)));
        }
      };
      _xblockexpression = IterableExtensions.<INode>exists(_asTreeIterable, _function);
    }
    return _xblockexpression;
  }
  
  protected void _fmt(final Procedure2<? super EObject, ? super FormattableDocument> formatter, final FormattableDocument doc, final RichString expr) {
    EList<XExpression> _expressions = expr.getExpressions();
    for (final XExpression e : _expressions) {
      this.fmt(formatter, doc, e);
    }
  }
  
  protected void _fmt(final Procedure2<? super EObject, ? super FormattableDocument> formatter, final FormattableDocument doc, final RichStringLiteral expr) {
  }
  
  protected void _fmt(final Procedure2<? super EObject, ? super FormattableDocument> formatter, final FormattableDocument doc, final Void expr) {
  }
  
  protected void _fmt(final Procedure2<? super EObject, ? super FormattableDocument> formatter, final FormattableDocument doc, final XExpression expr) {
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(expr);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.noSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForEObject, _function);
    doc.operator_add(_surround);
    formatter.apply(expr, doc);
  }
  
  protected void _fmt(final Procedure2<? super EObject, ? super FormattableDocument> formatter, final FormattableDocument doc, final RichStringIf expr) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "IF");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.noSpace();
      }
    };
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword, _function, _function_1);
    doc.operator_add(_surround);
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(expr, XtendPackage.Literals.RICH_STRING_ELSE_IF__IF);
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.noSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForFeature, _function_2);
    doc.operator_add(_append);
    XExpression _if = expr.getIf();
    formatter.apply(_if, doc);
    XExpression _then = expr.getThen();
    this.fmt(formatter, doc, _then);
    EList<RichStringElseIf> _elseIfs = expr.getElseIfs();
    for (final RichStringElseIf elseif : _elseIfs) {
      this.fmt(formatter, doc, elseif);
    }
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(expr, "ELSE");
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.noSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_1 = this._formattingDataFactory.surround(_nodeForKeyword_1, _function_3);
    doc.operator_add(_surround_1);
    XExpression _else = expr.getElse();
    this.fmt(formatter, doc, _else);
    ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(expr, "ENDIF");
    final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.noSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_2 = this._formattingDataFactory.surround(_nodeForKeyword_2, _function_4);
    doc.operator_add(_surround_2);
  }
  
  protected void _fmt(final Procedure2<? super EObject, ? super FormattableDocument> formatter, final FormattableDocument doc, final RichStringElseIf expr) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "ELSEIF");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.noSpace();
      }
    };
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword, _function, _function_1);
    doc.operator_add(_surround);
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(expr, XtendPackage.Literals.RICH_STRING_ELSE_IF__IF);
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.noSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForFeature, _function_2);
    doc.operator_add(_append);
    XExpression _if = expr.getIf();
    formatter.apply(_if, doc);
  }
  
  protected void _fmt(final Procedure2<? super EObject, ? super FormattableDocument> formatter, final FormattableDocument doc, final RichStringForLoop expr) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "FOR");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.noSpace();
      }
    };
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword, _function, _function_1);
    doc.operator_add(_surround);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(expr, ":");
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_1 = this._formattingDataFactory.surround(_nodeForKeyword_1, _function_2, _function_3);
    doc.operator_add(_surround_1);
    JvmFormalParameter _declaredParam = expr.getDeclaredParam();
    formatter.apply(_declaredParam, doc);
    XExpression _forExpression = expr.getForExpression();
    formatter.apply(_forExpression, doc);
    XExpression _eachExpression = expr.getEachExpression();
    this.fmt(formatter, doc, _eachExpression);
    ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(expr, "BEFORE");
    final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_2 = this._formattingDataFactory.surround(_nodeForKeyword_2, _function_4);
    doc.operator_add(_surround_2);
    XExpression _before = expr.getBefore();
    formatter.apply(_before, doc);
    ILeafNode _nodeForKeyword_3 = this._nodeModelAccess.nodeForKeyword(expr, "SEPARATOR");
    final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_3 = this._formattingDataFactory.surround(_nodeForKeyword_3, _function_5);
    doc.operator_add(_surround_3);
    XExpression _separator = expr.getSeparator();
    formatter.apply(_separator, doc);
    ILeafNode _nodeForKeyword_4 = this._nodeModelAccess.nodeForKeyword(expr, "AFTER");
    final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.oneSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_4 = this._formattingDataFactory.surround(_nodeForKeyword_4, _function_6);
    doc.operator_add(_surround_4);
    XExpression _after = expr.getAfter();
    formatter.apply(_after, doc);
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(expr, XbasePackage.Literals.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION);
    final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.noSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForFeature, _function_7);
    doc.operator_add(_prepend);
    ILeafNode _nodeForKeyword_5 = this._nodeModelAccess.nodeForKeyword(expr, "ENDFOR");
    final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
      public void apply(final FormattingDataInit it) {
        it.noSpace();
      }
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_5 = this._formattingDataFactory.surround(_nodeForKeyword_5, _function_8);
    doc.operator_add(_surround_5);
  }
  
  @Synthetic
  protected void fmt(final Procedure2<? super EObject, ? super FormattableDocument> formatter, final FormattableDocument doc, final EObject expr) {
    if (formatter != null
         && expr instanceof RichString) {
      _fmt(formatter, doc, (RichString)expr);
      return;
    } else if (formatter != null
         && expr instanceof RichStringForLoop) {
      _fmt(formatter, doc, (RichStringForLoop)expr);
      return;
    } else if (formatter != null
         && expr instanceof RichStringLiteral) {
      _fmt(formatter, doc, (RichStringLiteral)expr);
      return;
    } else if (formatter != null
         && expr instanceof RichStringIf) {
      _fmt(formatter, doc, (RichStringIf)expr);
      return;
    } else if (formatter != null
         && expr instanceof RichStringElseIf) {
      _fmt(formatter, doc, (RichStringElseIf)expr);
      return;
    } else if (formatter != null
         && expr instanceof XExpression) {
      _fmt(formatter, doc, (XExpression)expr);
      return;
    } else if (formatter != null
         && expr == null) {
      _fmt(formatter, doc, (Void)null);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(formatter, doc, expr).toString());
    }
  }
}
