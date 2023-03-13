/**
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.formatting2;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.xtend.core.richstring.DefaultIndentationHandler;
import org.eclipse.xtend.core.richstring.RichStringProcessor;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringElseIf;
import org.eclipse.xtend.core.xtend.RichStringForLoop;
import org.eclipse.xtend.core.xtend.RichStringIf;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.internal.HiddenRegionReplacer;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextSegment;
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
 * @author Arne Deutsch - Workaround for exception thrown for blank lines
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
    RichString _containerOfType = EcoreUtil2.<RichString>getContainerOfType(richString.eContainer(), RichString.class);
    boolean _tripleNotEquals = (_containerOfType != null);
    if (_tripleNotEquals) {
      return;
    }
    boolean _hasSyntaxError = this.hasSyntaxError(this._iTextRegionExtensions.regionForEObject(richString));
    if (_hasSyntaxError) {
      return;
    }
    ITextRegionAccess _textRegionAccess = this._iTextRegionExtensions.getTextRegionAccess();
    final RichStringToLineModel impl = new RichStringToLineModel(_textRegionAccess);
    DefaultIndentationHandler _defaultIndentationHandler = new DefaultIndentationHandler();
    this.factory.richStringProcessor.process(richString, impl, _defaultIndentationHandler);
    impl.finish();
    EList<XExpression> _expressions = richString.getExpressions();
    for (final XExpression e : _expressions) {
      this.format(e, doc);
    }
    final List<Line> lines = impl.getModel().getLines();
    final boolean canIndent = ((!lines.isEmpty()) && StringExtensions.isNullOrEmpty(IterableExtensions.<Line>last(lines).getContent()));
    for (final Line line : lines) {
      int _rootIndentLenght = impl.getModel().getRootIndentLenght();
      boolean _greaterThan = (_rootIndentLenght > 0);
      if (_greaterThan) {
        int _xifexpression = (int) 0;
        if ((canIndent && Objects.equal(line, IterableExtensions.<Line>head(lines)))) {
          _xifexpression = 1;
        } else {
          _xifexpression = 0;
        }
        final int increaseIndentationChange = _xifexpression;
        int _xifexpression_1 = (int) 0;
        if ((canIndent && Objects.equal(line, IterableExtensions.<Line>last(lines)))) {
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
        final int i = Math.min(line.getIndentLength(), impl.getModel().getRootIndentLenght());
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
        boolean _isEmpty = line.getChunks().isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          final int offset = (nloffset + nllength);
          int _indentLength = line.getIndentLength();
          int _rootIndentLenght_1 = impl.getModel().getRootIndentLenght();
          final int length = (_indentLength - _rootIndentLenght_1);
          final Function1<Chunk, CharSequence> _function = (Chunk chunk) -> {
            CharSequence _switchResult = null;
            boolean _matched = false;
            if (chunk instanceof SemanticWhitespace) {
              _matched=true;
              _switchResult = ((SemanticWhitespace)chunk).getText();
            }
            if (!_matched) {
              if (chunk instanceof TemplateWhitespace) {
                _matched=true;
                _switchResult = doc.getFormatter().<String>getPreference(FormatterPreferenceKeys.indentation);
              }
            }
            return _switchResult;
          };
          final String text = IterableExtensions.join(ListExtensions.<Chunk, CharSequence>map(line.getChunks(), _function));
          if ((length >= 0)) {
            this.setSpace(doc, offset, length, text);
          } else {
            RuntimeException _runtimeException = new RuntimeException(("Programmatic error: length == " + Integer.valueOf(length)));
            EcorePlugin.INSTANCE.log(_runtimeException);
          }
        }
      }
    }
  }

  protected boolean _hasSyntaxError(final IEObjectRegion region) {
    return false;
  }

  protected boolean _hasSyntaxError(final NodeEObjectRegion region) {
    final BidiTreeIterator<INode> i = region.getNode().getAsTreeIterable().iterator();
    while (i.hasNext()) {
      SyntaxErrorMessage _syntaxErrorMessage = i.next().getSyntaxErrorMessage();
      boolean _tripleNotEquals = (_syntaxErrorMessage != null);
      if (_tripleNotEquals) {
        return true;
      }
    }
    return false;
  }

  protected void setNewLines(final IFormattableDocument doc, final int offset, final int length, final int indentationIncrease, final int indentationDecrease, final int newLines) {
    IHiddenRegionFormatting _createHiddenRegionFormatting = doc.getFormatter().createHiddenRegionFormatting();
    final Procedure1<IHiddenRegionFormatting> _function = (IHiddenRegionFormatting it) -> {
      it.setIndentationIncrease(Integer.valueOf(indentationIncrease));
      it.setIndentationDecrease(Integer.valueOf(indentationDecrease));
      it.setNewLinesMin(Integer.valueOf(newLines));
      it.setNewLinesDefault(Integer.valueOf(newLines));
      it.setNewLinesMax(Integer.valueOf(newLines));
    };
    final IHiddenRegionFormatting fmt = ObjectExtensions.<IHiddenRegionFormatting>operator_doubleArrow(_createHiddenRegionFormatting, _function);
    AbstractFormatter2 _formatter = doc.getFormatter();
    ITextRegionAccess _textRegionAccess = this._iTextRegionExtensions.getTextRegionAccess();
    TextSegment _textSegment = new TextSegment(_textRegionAccess, offset, length);
    final ITextReplacer replacer = _formatter.createWhitespaceReplacer(_textSegment, fmt);
    doc.addReplacer(replacer);
  }

  protected void setSpace(final IFormattableDocument doc, final int offset, final int length, final String space) {
    IHiddenRegionFormatting _createHiddenRegionFormatting = doc.getFormatter().createHiddenRegionFormatting();
    final Procedure1<IHiddenRegionFormatting> _function = (IHiddenRegionFormatting it) -> {
      it.setSpace(space);
    };
    final IHiddenRegionFormatting fmt = ObjectExtensions.<IHiddenRegionFormatting>operator_doubleArrow(_createHiddenRegionFormatting, _function);
    AbstractFormatter2 _formatter = doc.getFormatter();
    ITextRegionAccess _textRegionAccess = this._iTextRegionExtensions.getTextRegionAccess();
    TextSegment _textSegment = new TextSegment(_textRegionAccess, offset, length);
    final ITextReplacer replacer = _formatter.createWhitespaceReplacer(_textSegment, fmt);
    doc.addReplacer(replacer);
  }

  protected void _format(final RichStringLiteral expr, final IFormattableDocument doc) {
  }

  protected void _format(final Void expr, final IFormattableDocument doc) {
  }

  protected void formatIntoSingleLine(final IFormattableDocument doc, final EObject obj) {
    final Predicate<ITextReplacer> _function = (ITextReplacer it) -> {
      boolean _xblockexpression = false;
      {
        this.suppressLineWraps(it);
        _xblockexpression = true;
      }
      return _xblockexpression;
    };
    doc.getFormatter().format(obj, doc.withReplacerFilter(_function));
  }

  protected void _suppressLineWraps(final ITextReplacer it) {
  }

  protected void _suppressLineWraps(final HiddenRegionReplacer it) {
    this.suppressLineWraps(it.getFormatting());
  }

  protected void _suppressLineWraps(final IHiddenRegionFormatting it) {
    String _space = it.getSpace();
    boolean _tripleEquals = (_space == null);
    if (_tripleEquals) {
      it.setSpace(" ");
    }
    it.setNewLinesMin(null);
    it.setNewLinesDefault(null);
    it.setNewLinesMax(null);
    it.setAutowrap(null);
  }

  protected void _format(final XExpression expr, @Extension final IFormattableDocument doc) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    doc.<XExpression>surround(expr, _function);
    this.formatIntoSingleLine(doc, expr);
  }

  protected void _format(final RichStringIf expr, @Extension final IFormattableDocument doc) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    doc.append(doc.prepend(this._iTextRegionExtensions.regionFor(expr).keyword("IF"), _function), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    doc.<RichStringElseIf>append(IterableExtensions.<RichStringElseIf>last(expr.getElseIfs()), _function_2);
    this.formatIntoSingleLine(doc, expr.getIf());
    this.format(expr.getThen(), doc);
    EList<RichStringElseIf> _elseIfs = expr.getElseIfs();
    for (final RichStringElseIf elseif : _elseIfs) {
      this.format(elseif, doc);
    }
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    doc.surround(this._iTextRegionExtensions.regionFor(expr).keyword("ELSE"), _function_3);
    this.format(expr.getElse(), doc);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    doc.surround(this._iTextRegionExtensions.regionFor(expr).keyword("ENDIF"), _function_4);
  }

  protected void _format(final RichStringElseIf expr, @Extension final IFormattableDocument doc) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    doc.append(doc.prepend(this._iTextRegionExtensions.regionFor(expr).keyword("ELSEIF"), _function), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    doc.<XExpression>append(expr.getIf(), _function_2);
    this.formatIntoSingleLine(doc, expr.getIf());
  }

  protected void _format(final RichStringForLoop expr, @Extension final IFormattableDocument doc) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    doc.append(doc.prepend(this._iTextRegionExtensions.regionFor(expr).keyword("FOR"), _function), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    doc.append(doc.prepend(this._iTextRegionExtensions.regionFor(expr).keyword(":"), _function_2), _function_3);
    this.formatIntoSingleLine(doc, expr.getDeclaredParam());
    this.formatIntoSingleLine(doc, expr.getForExpression());
    this.format(expr.getEachExpression(), doc);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    doc.surround(this._iTextRegionExtensions.regionFor(expr).keyword("BEFORE"), _function_4);
    this.formatIntoSingleLine(doc, expr.getBefore());
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    doc.surround(this._iTextRegionExtensions.regionFor(expr).keyword("SEPARATOR"), _function_5);
    this.formatIntoSingleLine(doc, expr.getSeparator());
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    doc.surround(this._iTextRegionExtensions.regionFor(expr).keyword("AFTER"), _function_6);
    this.formatIntoSingleLine(doc, expr.getAfter());
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    doc.<XExpression>prepend(expr.getEachExpression(), _function_7);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    doc.surround(this._iTextRegionExtensions.regionFor(expr).keyword("ENDFOR"), _function_8);
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
