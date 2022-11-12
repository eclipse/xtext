/**
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.formatting2;

import com.google.common.collect.Iterables;
import java.util.List;
import java.util.Stack;
import org.eclipse.xtend.core.richstring.AbstractRichStringPartAcceptor;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@SuppressWarnings("all")
public class RichStringToLineModel extends AbstractRichStringPartAcceptor.ForLoopOnce {
  private final String document;

  private final ITextRegionAccess nodeModelAccess;

  @Accessors
  private final LineModel model = new LineModel();

  private int offset = (-1);

  private int contentStartOffset = (-1);

  private int contentStartColumn = (-1);

  private Stack<Chunk> indentationStack = new Stack<Chunk>();

  private boolean content = false;

  private boolean indentNextLine = false;

  private boolean _outdentThisLine = false;

  private int lastLiteralEndOffset;

  public RichStringToLineModel(final ITextRegionAccess nodeModelAccess) {
    this.nodeModelAccess = nodeModelAccess;
    this.document = nodeModelAccess.regionForDocument().getText();
  }

  public boolean outdentThisLine() {
    boolean _xifexpression = false;
    if (this.indentNextLine) {
      _xifexpression = this.indentNextLine = false;
    } else {
      _xifexpression = this._outdentThisLine = true;
    }
    return _xifexpression;
  }

  public void finish() {
    this.acceptLineBreak(0, false, false);
  }

  protected int literalPrefixLenght(final ITextSegment node) {
    int _switchResult = (int) 0;
    String _text = node.getText();
    final String t = _text;
    boolean _matched = false;
    boolean _startsWith = t.startsWith("\'\'\'");
    if (_startsWith) {
      _matched=true;
      _switchResult = 3;
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

  protected int literalPostfixLenght(final ITextSegment node) {
    int _switchResult = (int) 0;
    String _text = node.getText();
    final String t = _text;
    boolean _matched = false;
    boolean _endsWith = t.endsWith("\'\'\'");
    if (_endsWith) {
      _matched=true;
      _switchResult = 3;
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

  @Override
  public void announceNextLiteral(final RichStringLiteral object) {
    super.announceNextLiteral(object);
    if (((this.lastLiteralEndOffset > 0) && (this.contentStartOffset < 0))) {
      this.contentStartOffset = this.lastLiteralEndOffset;
    }
    IEObjectRegion _regionForEObject = this.nodeModelAccess.regionForEObject(object);
    ISemanticRegionsFinder _regionFor = null;
    if (_regionForEObject!=null) {
      _regionFor=_regionForEObject.getRegionFor();
    }
    ISemanticRegion _feature = null;
    if (_regionFor!=null) {
      _feature=_regionFor.feature(XbasePackage.Literals.XSTRING_LITERAL__VALUE);
    }
    final ISemanticRegion node = _feature;
    if ((node != null)) {
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

  @Override
  public void acceptSemanticLineBreak(final int charCount, final RichStringLiteral origin, final boolean controlStructureSeen) {
    super.acceptSemanticLineBreak(charCount, origin, controlStructureSeen);
    this.acceptLineBreak(charCount, true, true);
    this.offset = (this.offset + charCount);
  }

  @Override
  public void acceptTemplateLineBreak(final int charCount, final RichStringLiteral origin) {
    super.acceptTemplateLineBreak(charCount, origin);
    this.acceptLineBreak(charCount, false, true);
    this.offset = (this.offset + charCount);
  }

  public void acceptLineBreak(final int charCount, final boolean semantic, final boolean startNewLine) {
    this.startContent();
    if ((this.contentStartOffset > 0)) {
      final String lastLinesContent = this.document.substring(this.contentStartOffset, this.offset);
      boolean _isEmpty = this.model.getLines().isEmpty();
      if (_isEmpty) {
        this.model.setLeadingText(lastLinesContent);
        this.contentStartColumn = 0;
      } else {
        final Line lastLine = IterableExtensions.<Line>last(this.model.getLines());
        lastLine.setContent(lastLinesContent);
        int _offset = lastLine.getOffset();
        int _newLineCharCount = lastLine.getNewLineCharCount();
        int _plus = (_offset + _newLineCharCount);
        final int newContentStartColumn = (this.contentStartOffset - _plus);
        boolean _isLeadingSemanticNewLine = lastLine.isLeadingSemanticNewLine();
        if (_isLeadingSemanticNewLine) {
          if ((newContentStartColumn > this.contentStartColumn)) {
            final int length = (newContentStartColumn - this.contentStartColumn);
            final String text = this.document.substring((this.contentStartOffset - length), this.contentStartOffset);
            SemanticWhitespace _semanticWhitespace = new SemanticWhitespace(text, newContentStartColumn);
            this.indentationStack.push(_semanticWhitespace);
          }
        }
        if ((newContentStartColumn < this.contentStartColumn)) {
          List<SemanticWhitespace> _list = IterableExtensions.<SemanticWhitespace>toList(Iterables.<SemanticWhitespace>filter(this.indentationStack, SemanticWhitespace.class));
          for (final SemanticWhitespace ws : _list) {
            int _column = ws.getColumn();
            boolean _greaterThan = (_column > newContentStartColumn);
            if (_greaterThan) {
              this.indentationStack.remove(ws);
            }
          }
          final Chunk lastWs = IterableExtensions.<Chunk>last(this.indentationStack);
          int _xifexpression = (int) 0;
          if ((lastWs == null)) {
            int _rootIndentLenght = this.model.getRootIndentLenght();
            _xifexpression = (newContentStartColumn - _rootIndentLenght);
          } else {
            int _xifexpression_1 = (int) 0;
            if ((lastWs instanceof SemanticWhitespace)) {
              int _column_1 = ((SemanticWhitespace)lastWs).getColumn();
              _xifexpression_1 = (newContentStartColumn - _column_1);
            } else {
              _xifexpression_1 = 0;
            }
            _xifexpression = _xifexpression_1;
          }
          final int length_1 = _xifexpression;
          if ((length_1 > 0)) {
            final String text_1 = this.document.substring((this.contentStartOffset - length_1), this.contentStartOffset);
            SemanticWhitespace _semanticWhitespace_1 = new SemanticWhitespace(text_1, newContentStartColumn);
            this.indentationStack.push(_semanticWhitespace_1);
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
        if ((newContentStartColumn != 0)) {
          this.contentStartColumn = newContentStartColumn;
        }
        List<Chunk> _chunks = IterableExtensions.<Line>last(this.model.getLines()).getChunks();
        Iterables.<Chunk>addAll(_chunks, this.indentationStack);
      }
    }
    if (this.indentNextLine) {
      TemplateWhitespace _templateWhitespace = new TemplateWhitespace("");
      this.indentationStack.push(_templateWhitespace);
      this.indentNextLine = false;
    }
    this.contentStartOffset = (-1);
    this.content = false;
    if (startNewLine) {
      List<Line> _lines = this.model.getLines();
      Line _line = new Line(this.offset, semantic, charCount);
      _lines.add(_line);
    }
  }

  public void startContent() {
    if ((!this.content)) {
      this.contentStartOffset = this.offset;
      this.content = true;
    }
  }

  @Override
  public void acceptSemanticText(final CharSequence text, final RichStringLiteral origin) {
    super.acceptSemanticText(text, origin);
    if ((!this.content)) {
      if (((text.length() > 0) && (IterableExtensions.<Integer, Boolean>fold(new IntegerRange(0, (text.length() - 1)), Boolean.valueOf(false), ((Function2<Boolean, Integer, Boolean>) (Boolean v, Integer i) -> {
        return Boolean.valueOf(((v).booleanValue() || (!Character.isWhitespace(text.charAt((i).intValue())))));
      }))).booleanValue())) {
        this.startContent();
      }
    }
    int _length = text.length();
    int _plus = (this.offset + _length);
    this.offset = _plus;
  }

  @Override
  public void acceptTemplateText(final CharSequence text, final RichStringLiteral origin) {
    super.acceptTemplateText(text, origin);
    if ((!this.content)) {
      int _rootIndentLenght = this.model.getRootIndentLenght();
      boolean _lessThan = (_rootIndentLenght < 0);
      if (_lessThan) {
        this.model.setRootIndentLenght(text.length());
        this.contentStartColumn = text.length();
      }
    }
    int _length = text.length();
    int _plus = (this.offset + _length);
    this.offset = _plus;
  }

  @Override
  public void acceptExpression(final XExpression expression, final CharSequence indentation) {
    super.acceptExpression(expression, indentation);
    this.startContent();
  }

  @Override
  public void acceptIfCondition(final XExpression condition) {
    super.acceptIfCondition(condition);
    this.startContent();
    this.indentNextLine = true;
  }

  @Override
  public void acceptElseIfCondition(final XExpression condition) {
    super.acceptElseIfCondition(condition);
    this.outdentThisLine();
    this.startContent();
    this.indentNextLine = true;
  }

  @Override
  public void acceptElse() {
    super.acceptElse();
    this.outdentThisLine();
    this.startContent();
    this.indentNextLine = true;
  }

  @Override
  public void acceptEndIf() {
    super.acceptEndIf();
    this.outdentThisLine();
    this.startContent();
  }

  @Override
  public void acceptForLoop(final JvmFormalParameter parameter, final XExpression expression) {
    super.acceptForLoop(parameter, expression);
    this.startContent();
    this.indentNextLine = true;
  }

  @Override
  public void acceptEndFor(final XExpression after, final CharSequence indentation) {
    super.acceptEndFor(after, indentation);
    this.outdentThisLine();
    this.startContent();
  }

  @Pure
  public LineModel getModel() {
    return this.model;
  }
}
