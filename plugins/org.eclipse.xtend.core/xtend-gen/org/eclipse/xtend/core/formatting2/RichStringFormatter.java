/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.formatting2;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
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
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.internal.HiddenRegionReplacer;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextSegment;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
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
 * 
 * @author Moritz Eysholdt - Initial implementation and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class RichStringFormatter {
  public static class Factory {
    @Inject
    private RichStringProcessor richStringProcessor;
    
    public RichStringFormatter create(final ITextRegionAccess regionAccess) {
      ITextRegionExtensions _extensions = regionAccess.getExtensions();
      return new RichStringFormatter(this, _extensions);
    }
  }
  
  private final RichStringFormatter.Factory factory;
  
  @Extension
  private final ITextRegionExtensions _iTextRegionExtensions;
  
  protected void _format(final RichString richString, final IFormattableDocument doc) {
    EObject _eContainer = richString.eContainer();
    RichString _containerOfType = EcoreUtil2.<RichString>getContainerOfType(_eContainer, RichString.class);
    boolean _notEquals = (!Objects.equal(_containerOfType, null));
    if (_notEquals) {
      return;
    }
    IEObjectRegion _regionForEObject = this._iTextRegionExtensions.regionForEObject(richString);
    boolean _hasSyntaxError = this.hasSyntaxError(_regionForEObject);
    if (_hasSyntaxError) {
      return;
    }
    ITextRegionAccess _textRegionAccess = this._iTextRegionExtensions.getTextRegionAccess();
    final RichStringToLineModel impl = new RichStringToLineModel(_textRegionAccess, richString);
    DefaultIndentationHandler _defaultIndentationHandler = new DefaultIndentationHandler();
    this.factory.richStringProcessor.process(richString, impl, _defaultIndentationHandler);
    impl.finish();
    EList<XExpression> _expressions = richString.getExpressions();
    for (final XExpression e : _expressions) {
      this.format(e, doc);
    }
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
            @Override
            public CharSequence apply(final Chunk chunk) {
              CharSequence _switchResult = null;
              boolean _matched = false;
              if (chunk instanceof SemanticWhitespace) {
                _matched=true;
                _switchResult = ((SemanticWhitespace)chunk).getText();
              }
              if (!_matched) {
                if (chunk instanceof TemplateWhitespace) {
                  _matched=true;
                  AbstractFormatter2 _formatter = doc.getFormatter();
                  _switchResult = _formatter.<String>getPreference(FormatterPreferenceKeys.indentation);
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
  }
  
  protected boolean _hasSyntaxError(final IEObjectRegion region) {
    return false;
  }
  
  protected boolean _hasSyntaxError(final NodeEObjectRegion region) {
    INode _node = region.getNode();
    BidiTreeIterable<INode> _asTreeIterable = _node.getAsTreeIterable();
    final BidiTreeIterator<INode> i = _asTreeIterable.iterator();
    while (i.hasNext()) {
      INode _next = i.next();
      SyntaxErrorMessage _syntaxErrorMessage = _next.getSyntaxErrorMessage();
      boolean _notEquals = (!Objects.equal(_syntaxErrorMessage, null));
      if (_notEquals) {
        return true;
      }
    }
    return false;
  }
  
  protected void setNewLines(final IFormattableDocument doc, final int offset, final int length, final int indentationIncrease, final int indentationDecrease, final int newLines) {
    AbstractFormatter2 _formatter = doc.getFormatter();
    IHiddenRegionFormatting _createHiddenRegionFormatting = _formatter.createHiddenRegionFormatting();
    final Procedure1<IHiddenRegionFormatting> _function = new Procedure1<IHiddenRegionFormatting>() {
      @Override
      public void apply(final IHiddenRegionFormatting it) {
        it.setIndentationIncrease(Integer.valueOf(indentationIncrease));
        it.setIndentationDecrease(Integer.valueOf(indentationDecrease));
        it.setNewLinesMin(Integer.valueOf(newLines));
        it.setNewLinesDefault(Integer.valueOf(newLines));
        it.setNewLinesMax(Integer.valueOf(newLines));
      }
    };
    final IHiddenRegionFormatting fmt = ObjectExtensions.<IHiddenRegionFormatting>operator_doubleArrow(_createHiddenRegionFormatting, _function);
    AbstractFormatter2 _formatter_1 = doc.getFormatter();
    ITextRegionAccess _textRegionAccess = this._iTextRegionExtensions.getTextRegionAccess();
    TextSegment _textSegment = new TextSegment(_textRegionAccess, offset, length);
    final ITextReplacer replacer = _formatter_1.createWhitespaceReplacer(_textSegment, fmt);
    doc.addReplacer(replacer);
  }
  
  protected void setSpace(final IFormattableDocument doc, final int offset, final int length, final String space) {
    AbstractFormatter2 _formatter = doc.getFormatter();
    IHiddenRegionFormatting _createHiddenRegionFormatting = _formatter.createHiddenRegionFormatting();
    final Procedure1<IHiddenRegionFormatting> _function = new Procedure1<IHiddenRegionFormatting>() {
      @Override
      public void apply(final IHiddenRegionFormatting it) {
        it.setSpace(space);
      }
    };
    final IHiddenRegionFormatting fmt = ObjectExtensions.<IHiddenRegionFormatting>operator_doubleArrow(_createHiddenRegionFormatting, _function);
    AbstractFormatter2 _formatter_1 = doc.getFormatter();
    ITextRegionAccess _textRegionAccess = this._iTextRegionExtensions.getTextRegionAccess();
    TextSegment _textSegment = new TextSegment(_textRegionAccess, offset, length);
    final ITextReplacer replacer = _formatter_1.createWhitespaceReplacer(_textSegment, fmt);
    doc.addReplacer(replacer);
  }
  
  protected void _format(final RichStringLiteral expr, final IFormattableDocument doc) {
  }
  
  protected void _format(final Void expr, final IFormattableDocument doc) {
  }
  
  protected void formatIntoSingleLine(final IFormattableDocument doc, final EObject obj) {
    AbstractFormatter2 _formatter = doc.getFormatter();
    final Predicate<ITextReplacer> _function = new Predicate<ITextReplacer>() {
      @Override
      public boolean apply(final ITextReplacer it) {
        boolean _xblockexpression = false;
        {
          RichStringFormatter.this.suppressLineWraps(it);
          _xblockexpression = true;
        }
        return _xblockexpression;
      }
    };
    IFormattableDocument _withReplacerFilter = doc.withReplacerFilter(_function);
    _formatter.format(obj, _withReplacerFilter);
  }
  
  protected void _suppressLineWraps(final ITextReplacer it) {
  }
  
  protected void _suppressLineWraps(final HiddenRegionReplacer it) {
    IHiddenRegionFormatting _formatting = it.getFormatting();
    this.suppressLineWraps(_formatting);
  }
  
  protected void _suppressLineWraps(final IHiddenRegionFormatting it) {
    String _space = it.getSpace();
    boolean _equals = Objects.equal(_space, null);
    if (_equals) {
      it.setSpace(" ");
    }
    it.setNewLinesMin(null);
    it.setNewLinesDefault(null);
    it.setNewLinesMax(null);
    it.setAutowrap(null);
  }
  
  protected void _format(final XExpression expr, @Extension final IFormattableDocument doc) {
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    doc.<XExpression>surround(expr, _function);
    this.formatIntoSingleLine(doc, expr);
  }
  
  protected void _format(final RichStringIf expr, @Extension final IFormattableDocument doc) {
    ISemanticRegionsFinder _regionFor = this._iTextRegionExtensions.regionFor(expr);
    ISemanticRegion _keyword = _regionFor.keyword("IF");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    ISemanticRegion _prepend = doc.prepend(_keyword, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    doc.append(_prepend, _function_1);
    EList<RichStringElseIf> _elseIfs = expr.getElseIfs();
    RichStringElseIf _last = IterableExtensions.<RichStringElseIf>last(_elseIfs);
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    doc.<RichStringElseIf>append(_last, _function_2);
    XExpression _if = expr.getIf();
    this.formatIntoSingleLine(doc, _if);
    XExpression _then = expr.getThen();
    this.format(_then, doc);
    EList<RichStringElseIf> _elseIfs_1 = expr.getElseIfs();
    for (final RichStringElseIf elseif : _elseIfs_1) {
      this.format(elseif, doc);
    }
    ISemanticRegionsFinder _regionFor_1 = this._iTextRegionExtensions.regionFor(expr);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("ELSE");
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    doc.surround(_keyword_1, _function_3);
    XExpression _else = expr.getElse();
    this.format(_else, doc);
    ISemanticRegionsFinder _regionFor_2 = this._iTextRegionExtensions.regionFor(expr);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword("ENDIF");
    final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    doc.surround(_keyword_2, _function_4);
  }
  
  protected void _format(final RichStringElseIf expr, @Extension final IFormattableDocument doc) {
    ISemanticRegionsFinder _regionFor = this._iTextRegionExtensions.regionFor(expr);
    ISemanticRegion _keyword = _regionFor.keyword("ELSEIF");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    ISemanticRegion _prepend = doc.prepend(_keyword, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    doc.append(_prepend, _function_1);
    XExpression _if = expr.getIf();
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    doc.<XExpression>append(_if, _function_2);
    XExpression _if_1 = expr.getIf();
    this.formatIntoSingleLine(doc, _if_1);
  }
  
  protected void _format(final RichStringForLoop expr, @Extension final IFormattableDocument doc) {
    ISemanticRegionsFinder _regionFor = this._iTextRegionExtensions.regionFor(expr);
    ISemanticRegion _keyword = _regionFor.keyword("FOR");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    ISemanticRegion _prepend = doc.prepend(_keyword, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    doc.append(_prepend, _function_1);
    ISemanticRegionsFinder _regionFor_1 = this._iTextRegionExtensions.regionFor(expr);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword(":");
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    ISemanticRegion _prepend_1 = doc.prepend(_keyword_1, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    doc.append(_prepend_1, _function_3);
    JvmFormalParameter _declaredParam = expr.getDeclaredParam();
    this.formatIntoSingleLine(doc, _declaredParam);
    XExpression _forExpression = expr.getForExpression();
    this.formatIntoSingleLine(doc, _forExpression);
    XExpression _eachExpression = expr.getEachExpression();
    this.format(_eachExpression, doc);
    ISemanticRegionsFinder _regionFor_2 = this._iTextRegionExtensions.regionFor(expr);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword("BEFORE");
    final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    doc.surround(_keyword_2, _function_4);
    XExpression _before = expr.getBefore();
    this.formatIntoSingleLine(doc, _before);
    ISemanticRegionsFinder _regionFor_3 = this._iTextRegionExtensions.regionFor(expr);
    ISemanticRegion _keyword_3 = _regionFor_3.keyword("SEPARATOR");
    final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    doc.surround(_keyword_3, _function_5);
    XExpression _separator = expr.getSeparator();
    this.formatIntoSingleLine(doc, _separator);
    ISemanticRegionsFinder _regionFor_4 = this._iTextRegionExtensions.regionFor(expr);
    ISemanticRegion _keyword_4 = _regionFor_4.keyword("AFTER");
    final Procedure1<IHiddenRegionFormatter> _function_6 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    doc.surround(_keyword_4, _function_6);
    XExpression _after = expr.getAfter();
    this.formatIntoSingleLine(doc, _after);
    XExpression _eachExpression_1 = expr.getEachExpression();
    final Procedure1<IHiddenRegionFormatter> _function_7 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    doc.<XExpression>prepend(_eachExpression_1, _function_7);
    ISemanticRegionsFinder _regionFor_5 = this._iTextRegionExtensions.regionFor(expr);
    ISemanticRegion _keyword_5 = _regionFor_5.keyword("ENDFOR");
    final Procedure1<IHiddenRegionFormatter> _function_8 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    doc.surround(_keyword_5, _function_8);
  }
  
  public void format(final EObject richString, final IFormattableDocument doc) {
    if (richString instanceof RichString) {
      _format((RichString)richString, doc);
      return;
    } else if (richString instanceof RichStringForLoop) {
      _format((RichStringForLoop)richString, doc);
      return;
    } else if (richString instanceof RichStringLiteral) {
      _format((RichStringLiteral)richString, doc);
      return;
    } else if (richString instanceof RichStringIf) {
      _format((RichStringIf)richString, doc);
      return;
    } else if (richString instanceof RichStringElseIf) {
      _format((RichStringElseIf)richString, doc);
      return;
    } else if (richString instanceof XExpression) {
      _format((XExpression)richString, doc);
      return;
    } else if (richString == null) {
      _format((Void)null, doc);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(richString, doc).toString());
    }
  }
  
  protected boolean hasSyntaxError(final IEObjectRegion region) {
    if (region instanceof NodeEObjectRegion) {
      return _hasSyntaxError((NodeEObjectRegion)region);
    } else if (region != null) {
      return _hasSyntaxError(region);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(region).toString());
    }
  }
  
  protected void suppressLineWraps(final Object it) {
    if (it instanceof HiddenRegionReplacer) {
      _suppressLineWraps((HiddenRegionReplacer)it);
      return;
    } else if (it instanceof IHiddenRegionFormatting) {
      _suppressLineWraps((IHiddenRegionFormatting)it);
      return;
    } else if (it instanceof ITextReplacer) {
      _suppressLineWraps((ITextReplacer)it);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public RichStringFormatter(final RichStringFormatter.Factory factory, final ITextRegionExtensions _iTextRegionExtensions) {
    super();
    this.factory = factory;
    this._iTextRegionExtensions = _iTextRegionExtensions;
  }
}
