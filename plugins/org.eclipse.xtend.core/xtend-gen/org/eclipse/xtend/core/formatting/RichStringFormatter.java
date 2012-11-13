package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.formatting.Chunk;
import org.eclipse.xtend.core.formatting.Expression;
import org.eclipse.xtend.core.formatting.FormattableDocument;
import org.eclipse.xtend.core.formatting.FormatterExtensions;
import org.eclipse.xtend.core.formatting.FormattingData;
import org.eclipse.xtend.core.formatting.FormattingDataInit;
import org.eclipse.xtend.core.formatting.Line;
import org.eclipse.xtend.core.formatting.LineModel;
import org.eclipse.xtend.core.formatting.NewLineData;
import org.eclipse.xtend.core.formatting.NodeModelAccess;
import org.eclipse.xtend.core.formatting.RichStringToLineModel;
import org.eclipse.xtend.core.formatting.SemanitcWhitespace;
import org.eclipse.xtend.core.formatting.TemplateWhitespace;
import org.eclipse.xtend.core.formatting.WhitespaceData;
import org.eclipse.xtend.core.richstring.DefaultIndentationHandler;
import org.eclipse.xtend.core.richstring.RichStringProcessor;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringIf;
import org.eclipse.xtend.core.xtend.XtendPackage.Literals;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

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
  private NodeModelAccess _nodeModelAccess;
  
  @Inject
  private FormatterExtensions _formatterExtensions;
  
  public void format(final Procedure2<? super EObject,? super FormattableDocument> formatter, final FormattableDocument doc, final RichString richString) {
    EObject _eContainer = richString.eContainer();
    RichString _containerOfType = EcoreUtil2.<RichString>getContainerOfType(_eContainer, RichString.class);
    boolean _notEquals = (!Objects.equal(_containerOfType, null));
    if (_notEquals) {
      return;
    }
    RichStringToLineModel _richStringToLineModel = new RichStringToLineModel(this._nodeModelAccess, richString);
    final RichStringToLineModel impl = _richStringToLineModel;
    DefaultIndentationHandler _defaultIndentationHandler = new DefaultIndentationHandler();
    this.richStringProcessor.process(richString, impl, _defaultIndentationHandler);
    LineModel _model = impl.getModel();
    final List<Line> lines = _model.getOtherLines();
    boolean _and = false;
    boolean _isEmpty = lines.isEmpty();
    boolean _not = (!_isEmpty);
    if (!_not) {
      _and = false;
    } else {
      final Function1<Line,Boolean> _function = new Function1<Line,Boolean>() {
          public Boolean apply(final Line it) {
            boolean _and = false;
            List<Chunk> _chunks = it.getChunks();
            Chunk _head = IterableExtensions.<Chunk>head(_chunks);
            if (!(_head instanceof TemplateWhitespace)) {
              _and = false;
            } else {
              List<Chunk> _chunks_1 = it.getChunks();
              Chunk _head_1 = IterableExtensions.<Chunk>head(_chunks_1);
              int _length = _head_1.getLength();
              boolean _greaterThan = (_length > 0);
              _and = ((_head instanceof TemplateWhitespace) && _greaterThan);
            }
            return Boolean.valueOf(_and);
          }
        };
      boolean _forall = IterableExtensions.<Line>forall(lines, _function);
      _and = (_not && _forall);
    }
    if (_and) {
      Line _last = IterableExtensions.<Line>last(lines);
      List<Chunk> _chunks = _last.getChunks();
      final Function1<Chunk,Boolean> _function_1 = new Function1<Chunk,Boolean>() {
          public Boolean apply(final Chunk it) {
            return Boolean.valueOf((it instanceof TemplateWhitespace));
          }
        };
      final boolean canIndent = IterableExtensions.<Chunk>forall(_chunks, _function_1);
      for (final Line line : lines) {
        {
          int _xifexpression = (int) 0;
          boolean _and_1 = false;
          if (!canIndent) {
            _and_1 = false;
          } else {
            Line _head = IterableExtensions.<Line>head(lines);
            boolean _equals = Objects.equal(line, _head);
            _and_1 = (canIndent && _equals);
          }
          if (_and_1) {
            _xifexpression = 1;
          } else {
            int _xifexpression_1 = (int) 0;
            boolean _and_2 = false;
            if (!canIndent) {
              _and_2 = false;
            } else {
              Line _last_1 = IterableExtensions.<Line>last(lines);
              boolean _equals_1 = Objects.equal(line, _last_1);
              _and_2 = (canIndent && _equals_1);
            }
            if (_and_2) {
              int _minus = (-1);
              _xifexpression_1 = _minus;
            } else {
              _xifexpression_1 = 0;
            }
            _xifexpression = _xifexpression_1;
          }
          final int indentChange = _xifexpression;
          boolean _isLeadingSemanticNewLine = line.isLeadingSemanticNewLine();
          if (_isLeadingSemanticNewLine) {
            int _offset = line.getOffset();
            int _newLineCharCount = line.getNewLineCharCount();
            int _plus = (_offset + _newLineCharCount);
            List<Chunk> _chunks_1 = line.getChunks();
            Chunk _head_1 = IterableExtensions.<Chunk>head(_chunks_1);
            int _length = _head_1.getLength();
            RuntimeException _xifexpression_2 = null;
            boolean _isDebugConflicts = doc.isDebugConflicts();
            if (_isDebugConflicts) {
              RuntimeException _runtimeException = new RuntimeException();
              _xifexpression_2 = _runtimeException;
            }
            NewLineData _newLineData = new NewLineData(_plus, _length, indentChange, _xifexpression_2, 0);
            doc.operator_add(_newLineData);
          } else {
            int _offset_1 = line.getOffset();
            int _newLineCharCount_1 = line.getNewLineCharCount();
            List<Chunk> _chunks_2 = line.getChunks();
            Chunk _head_2 = IterableExtensions.<Chunk>head(_chunks_2);
            int _length_1 = _head_2.getLength();
            int _plus_1 = (_newLineCharCount_1 + _length_1);
            RuntimeException _xifexpression_3 = null;
            boolean _isDebugConflicts_1 = doc.isDebugConflicts();
            if (_isDebugConflicts_1) {
              RuntimeException _runtimeException_1 = new RuntimeException();
              _xifexpression_3 = _runtimeException_1;
            }
            NewLineData _newLineData_1 = new NewLineData(_offset_1, _plus_1, indentChange, _xifexpression_3, 1);
            doc.operator_add(_newLineData_1);
          }
        }
      }
    }
    boolean _isEmpty_1 = lines.isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      final Function2<Integer,Line,Integer> _function_2 = new Function2<Integer,Line,Integer>() {
          public Integer apply(final Integer seed, final Line it) {
            List<Chunk> _chunks = it.getChunks();
            int _size = _chunks.size();
            int _max = Math.max((seed).intValue(), _size);
            return Integer.valueOf(_max);
          }
        };
      Integer _fold = IterableExtensions.<Line, Integer>fold(lines, Integer.valueOf(0), _function_2);
      IntegerRange _upTo = new IntegerRange(1, (_fold).intValue());
      for (final Integer col : _upTo) {
        for (final Line line_1 : lines) {
          boolean _and_1 = false;
          List<Chunk> _chunks_1 = line_1.getChunks();
          int _size = _chunks_1.size();
          boolean _lessThan = ((col).intValue() < _size);
          if (!_lessThan) {
            _and_1 = false;
          } else {
            List<Chunk> _chunks_2 = line_1.getChunks();
            List<Chunk> _subList = _chunks_2.subList(0, (col).intValue());
            final Function1<Chunk,Boolean> _function_3 = new Function1<Chunk,Boolean>() {
                public Boolean apply(final Chunk it) {
                  boolean _or = false;
                  if ((it instanceof TemplateWhitespace)) {
                    _or = true;
                  } else {
                    _or = ((it instanceof TemplateWhitespace) || (it instanceof SemanitcWhitespace));
                  }
                  return Boolean.valueOf(_or);
                }
              };
            boolean _forall_1 = IterableExtensions.<Chunk>forall(_subList, _function_3);
            _and_1 = (_lessThan && _forall_1);
          }
          if (_and_1) {
            List<Chunk> _chunks_3 = line_1.getChunks();
            final Chunk chunk = _chunks_3.get((col).intValue());
            if ((chunk instanceof TemplateWhitespace)) {
              final String space = doc.getIndentation(1);
              int _offset = chunk.getOffset();
              int _length = chunk.getLength();
              RuntimeException _xifexpression = null;
              boolean _isDebugConflicts = doc.isDebugConflicts();
              if (_isDebugConflicts) {
                RuntimeException _runtimeException = new RuntimeException();
                _xifexpression = _runtimeException;
              }
              WhitespaceData _whitespaceData = new WhitespaceData(_offset, _length, 0, _xifexpression, space);
              doc.operator_add(_whitespaceData);
            }
          }
        }
      }
    }
    LineModel _model_1 = impl.getModel();
    List<Chunk> _firstLine = _model_1.getFirstLine();
    final Function1<Line,List<Chunk>> _function_4 = new Function1<Line,List<Chunk>>() {
        public List<Chunk> apply(final Line it) {
          List<Chunk> _chunks = it.getChunks();
          return _chunks;
        }
      };
    List<List<Chunk>> _map = ListExtensions.<Line, List<Chunk>>map(lines, _function_4);
    Iterable<Chunk> _flatten = Iterables.<Chunk>concat(_map);
    Iterable<Chunk> _plus = Iterables.<Chunk>concat(_firstLine, _flatten);
    for (final Chunk chunk_1 : _plus) {
      boolean _matched = false;
      if (!_matched) {
        if (chunk_1 instanceof Expression) {
          final Expression _expression = (Expression)chunk_1;
          _matched=true;
          XExpression _expr = _expression.getExpr();
          this.fmt(formatter, doc, _expr);
        }
      }
    }
  }
  
  protected void _fmt(final Procedure2<? super EObject,? super FormattableDocument> formatter, final FormattableDocument doc, final XExpression expr) {
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(expr);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_nodeForEObject, _function);
    doc.operator_add(_surround);
    formatter.apply(expr, doc);
  }
  
  protected void _fmt(final Procedure2<? super EObject,? super FormattableDocument> formatter, final FormattableDocument doc, final RichStringIf expr) {
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
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formatterExtensions.surround(_nodeForKeyword, _function, _function_1);
    doc.operator_add(_surround);
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(expr, Literals.RICH_STRING_ELSE_IF__IF);
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formatterExtensions.append(_nodeForFeature, _function_2);
    doc.operator_add(_append);
    XExpression _if = expr.getIf();
    formatter.apply(_if, doc);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(expr, "ELSE");
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround_1 = this._formatterExtensions.surround(_nodeForKeyword_1, _function_3);
    doc.operator_add(_surround_1);
    ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(expr, "ENDIF");
    final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround_2 = this._formatterExtensions.surround(_nodeForKeyword_2, _function_4);
    doc.operator_add(_surround_2);
  }
  
  protected void fmt(final Procedure2<? super EObject,? super FormattableDocument> formatter, final FormattableDocument doc, final XExpression expr) {
    if (expr instanceof RichStringIf) {
      _fmt(formatter, doc, (RichStringIf)expr);
      return;
    } else if (expr != null) {
      _fmt(formatter, doc, expr);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(formatter, doc, expr).toString());
    }
  }
}
