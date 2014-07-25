package org.eclipse.xtend.core.formatting2;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.formatting2.Chunk;
import org.eclipse.xtend.core.formatting2.Line;
import org.eclipse.xtend.core.formatting2.LineModel;
import org.eclipse.xtend.core.formatting2.RichStringToLineModel;
import org.eclipse.xtend.core.formatting2.SemanticWhitespace;
import org.eclipse.xtend.core.formatting2.TemplateWhitespace;
import org.eclipse.xtend.core.formatting2.XtendFormatter;
import org.eclipse.xtend.core.richstring.DefaultIndentationHandler;
import org.eclipse.xtend.core.richstring.RichStringProcessor;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringElseIf;
import org.eclipse.xtend.core.xtend.RichStringForLoop;
import org.eclipse.xtend.core.xtend.RichStringIf;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.internal.TextSegment;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * cases to distinguish:
 * 	1. single-line
 *  2. multi-line with text after opening ''': lines start with semantic whitespace
 *  3. multi-line with text before closing ''': no indentation
 *  4. multi-line with only whitespace after opening ''' and before closing ''': one level of extra indentation between ''' and '''
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class RichStringFormatter {
  public static class Factory {
    @Inject
    private RichStringProcessor richStringProcessor;
    
    public RichStringFormatter create(final ITextRegionAccess regionAccess, final XtendFormatter formatter) {
      return new RichStringFormatter(this, regionAccess, formatter);
    }
  }
  
  private final RichStringFormatter.Factory factory;
  
  @Extension
  private final ITextRegionAccess _iTextRegionAccess;
  
  private final XtendFormatter formatter;
  
  public void format(final IFormattableDocument doc, final RichString richString) {
    EObject _eContainer = richString.eContainer();
    RichString _containerOfType = EcoreUtil2.<RichString>getContainerOfType(_eContainer, RichString.class);
    boolean _notEquals = (!Objects.equal(_containerOfType, null));
    if (_notEquals) {
      return;
    }
    boolean _hasSyntaxError = this._iTextRegionAccess.hasSyntaxError(richString);
    if (_hasSyntaxError) {
      return;
    }
    final RichStringToLineModel impl = new RichStringToLineModel(this._iTextRegionAccess, richString);
    DefaultIndentationHandler _defaultIndentationHandler = new DefaultIndentationHandler();
    this.factory.richStringProcessor.process(richString, impl, _defaultIndentationHandler);
    impl.finish();
    this.fmt(doc, richString);
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
          _xifexpression_1 = 1;
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
          this.setNewLines(doc, nloffset, nllength, increaseIndentationChange, decraseIndentationChange, 0);
        } else {
          this.setNewLines(doc, nloffset, nllength, increaseIndentationChange, decraseIndentationChange, 1);
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
                  ITypedPreferenceValues _preferences = doc.getPreferences();
                  _switchResult = _preferences.getPreference(FormatterPreferenceKeys.indentation);
                }
              }
              return _switchResult;
            }
          };
          List<CharSequence> _map = ListExtensions.<Chunk, CharSequence>map(_chunks_1, _function);
          final String text = IterableExtensions.join(_map);
          this.setSpace(doc, offset, length, text);
        }
      }
    }
    InputOutput.println();
  }
  
  protected void setNewLines(final IFormattableDocument doc, final int offset, final int length, final int indentationIncrease, final int indentationDecrease, final int newLines) {
    IHiddenRegionFormatting _createHiddenRegionFormatting = this.formatter.createHiddenRegionFormatting();
    final Procedure1<IHiddenRegionFormatting> _function = new Procedure1<IHiddenRegionFormatting>() {
      public void apply(final IHiddenRegionFormatting it) {
        it.setIndentationIncrease(Integer.valueOf(indentationIncrease));
        it.setIndentationDecrease(Integer.valueOf(indentationDecrease));
        it.setNewLinesMin(Integer.valueOf(newLines));
        it.setNewLinesDefault(Integer.valueOf(newLines));
        it.setNewLinesMax(Integer.valueOf(newLines));
      }
    };
    final IHiddenRegionFormatting fmt = ObjectExtensions.<IHiddenRegionFormatting>operator_doubleArrow(_createHiddenRegionFormatting, _function);
    TextSegment _textSegment = new TextSegment(this._iTextRegionAccess, offset, length);
    final ITextReplacer replacer = this.formatter.createWhitespaceReplacer(_textSegment, fmt);
    doc.addReplacer(replacer);
  }
  
  protected void setSpace(final IFormattableDocument doc, final int offset, final int length, final String space) {
    IHiddenRegionFormatting _createHiddenRegionFormatting = this.formatter.createHiddenRegionFormatting();
    final Procedure1<IHiddenRegionFormatting> _function = new Procedure1<IHiddenRegionFormatting>() {
      public void apply(final IHiddenRegionFormatting it) {
        it.setSpace(space);
      }
    };
    final IHiddenRegionFormatting fmt = ObjectExtensions.<IHiddenRegionFormatting>operator_doubleArrow(_createHiddenRegionFormatting, _function);
    TextSegment _textSegment = new TextSegment(this._iTextRegionAccess, offset, length);
    final ITextReplacer replacer = this.formatter.createWhitespaceReplacer(_textSegment, fmt);
    doc.addReplacer(replacer);
  }
  
  protected void _fmt(final IFormattableDocument doc, final RichString expr) {
    EList<XExpression> _expressions = expr.getExpressions();
    for (final XExpression e : _expressions) {
      this.fmt(doc, e);
    }
  }
  
  protected void _fmt(final IFormattableDocument doc, final RichStringLiteral expr) {
  }
  
  protected void _fmt(final IFormattableDocument doc, final Void expr) {
  }
  
  protected void _fmt(@Extension final IFormattableDocument doc, final XExpression expr) {
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    doc.<XExpression>surround(expr, _function);
    this.formatter.format(expr, doc);
  }
  
  protected void _fmt(@Extension final IFormattableDocument doc, final RichStringIf expr) {
    ISemanticRegion _regionForKeyword = this._iTextRegionAccess.regionForKeyword(expr, "IF");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    ISemanticRegion _prepend = doc.prepend(_regionForKeyword, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    doc.append(_prepend, _function_1);
    EList<RichStringElseIf> _elseIfs = expr.getElseIfs();
    RichStringElseIf _last = IterableExtensions.<RichStringElseIf>last(_elseIfs);
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    doc.<RichStringElseIf>append(_last, _function_2);
    XExpression _if = expr.getIf();
    this.formatter.format(_if, doc);
    XExpression _then = expr.getThen();
    this.fmt(doc, _then);
    EList<RichStringElseIf> _elseIfs_1 = expr.getElseIfs();
    for (final RichStringElseIf elseif : _elseIfs_1) {
      this.fmt(doc, elseif);
    }
    ISemanticRegion _regionForKeyword_1 = this._iTextRegionAccess.regionForKeyword(expr, "ELSE");
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    doc.surround(_regionForKeyword_1, _function_3);
    XExpression _else = expr.getElse();
    this.fmt(doc, _else);
    ISemanticRegion _regionForKeyword_2 = this._iTextRegionAccess.regionForKeyword(expr, "ENDIF");
    final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    doc.surround(_regionForKeyword_2, _function_4);
  }
  
  protected void _fmt(@Extension final IFormattableDocument doc, final RichStringElseIf expr) {
    ISemanticRegion _regionForKeyword = this._iTextRegionAccess.regionForKeyword(expr, "ELSEIF");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    ISemanticRegion _prepend = doc.prepend(_regionForKeyword, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    doc.append(_prepend, _function_1);
    XExpression _if = expr.getIf();
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    doc.<XExpression>append(_if, _function_2);
    XExpression _if_1 = expr.getIf();
    this.formatter.format(_if_1, doc);
  }
  
  protected void _fmt(@Extension final IFormattableDocument doc, final RichStringForLoop expr) {
    ISemanticRegion _regionForKeyword = this._iTextRegionAccess.regionForKeyword(expr, "FOR");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    ISemanticRegion _prepend = doc.prepend(_regionForKeyword, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    doc.append(_prepend, _function_1);
    ISemanticRegion _regionForKeyword_1 = this._iTextRegionAccess.regionForKeyword(expr, ":");
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    ISemanticRegion _prepend_1 = doc.prepend(_regionForKeyword_1, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    doc.append(_prepend_1, _function_3);
    JvmFormalParameter _declaredParam = expr.getDeclaredParam();
    this.formatter.format(_declaredParam, doc);
    XExpression _forExpression = expr.getForExpression();
    this.formatter.format(_forExpression, doc);
    XExpression _eachExpression = expr.getEachExpression();
    this.fmt(doc, _eachExpression);
    ISemanticRegion _regionForKeyword_2 = this._iTextRegionAccess.regionForKeyword(expr, "BEFORE");
    final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    doc.surround(_regionForKeyword_2, _function_4);
    XExpression _before = expr.getBefore();
    this.formatter.format(_before, doc);
    ISemanticRegion _regionForKeyword_3 = this._iTextRegionAccess.regionForKeyword(expr, "SEPARATOR");
    final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    doc.surround(_regionForKeyword_3, _function_5);
    XExpression _separator = expr.getSeparator();
    this.formatter.format(_separator, doc);
    ISemanticRegion _regionForKeyword_4 = this._iTextRegionAccess.regionForKeyword(expr, "AFTER");
    final Procedure1<IHiddenRegionFormatter> _function_6 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    doc.surround(_regionForKeyword_4, _function_6);
    XExpression _after = expr.getAfter();
    this.formatter.format(_after, doc);
    XExpression _eachExpression_1 = expr.getEachExpression();
    final Procedure1<IHiddenRegionFormatter> _function_7 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    doc.<XExpression>prepend(_eachExpression_1, _function_7);
    ISemanticRegion _regionForKeyword_5 = this._iTextRegionAccess.regionForKeyword(expr, "ENDFOR");
    final Procedure1<IHiddenRegionFormatter> _function_8 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    doc.surround(_regionForKeyword_5, _function_8);
  }
  
  protected void fmt(final IFormattableDocument doc, final EObject expr) {
    if (expr instanceof RichString) {
      _fmt(doc, (RichString)expr);
      return;
    } else if (expr instanceof RichStringForLoop) {
      _fmt(doc, (RichStringForLoop)expr);
      return;
    } else if (expr instanceof RichStringLiteral) {
      _fmt(doc, (RichStringLiteral)expr);
      return;
    } else if (expr instanceof RichStringIf) {
      _fmt(doc, (RichStringIf)expr);
      return;
    } else if (expr instanceof RichStringElseIf) {
      _fmt(doc, (RichStringElseIf)expr);
      return;
    } else if (expr instanceof XExpression) {
      _fmt(doc, (XExpression)expr);
      return;
    } else if (expr == null) {
      _fmt(doc, (Void)null);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(doc, expr).toString());
    }
  }
  
  public RichStringFormatter(final RichStringFormatter.Factory factory, final ITextRegionAccess _iTextRegionAccess, final XtendFormatter formatter) {
    super();
    this.factory = factory;
    this._iTextRegionAccess = _iTextRegionAccess;
    this.formatter = formatter;
  }
}
