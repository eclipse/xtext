/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.ex.DocumentEx;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Ref;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.text.CharArrayUtil;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtext.ide.editor.bracketmatching.BracePair;
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.idea.editorActions.AbstractAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AbstractIndentableAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AutoEditBlockRegion;
import org.eclipse.xtext.idea.editorActions.AutoEditContext;
import org.eclipse.xtext.idea.editorActions.AutoEditMultiLineBlock;
import org.eclipse.xtext.idea.editorActions.AutoEditString;
import org.eclipse.xtext.idea.editorActions.IdeaAutoEditHandler;
import org.eclipse.xtext.idea.editorActions.TokenSetProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultAutoEditHandler extends IdeaAutoEditHandler implements TokenSetProvider {
  @Inject
  private TokenTypeProvider tokenTypeProvider;
  
  @Inject
  private IBracePairProvider bracePairProvider;
  
  protected Iterable<AbstractAutoEditBlock> getQuotes() {
    AutoEditString _autoEditString = new AutoEditString("\"");
    AutoEditString _autoEditString_1 = new AutoEditString("\'");
    return Collections.<AbstractAutoEditBlock>unmodifiableList(CollectionLiterals.<AbstractAutoEditBlock>newArrayList(_autoEditString, _autoEditString_1));
  }
  
  protected Iterable<AbstractIndentableAutoEditBlock> getBlocks(final EditorEx editor) {
    CaretModel _caretModel = editor.getCaretModel();
    int _offset = _caretModel.getOffset();
    TokenSet _tokenSet = this.getTokenSet(editor, _offset);
    return this.getBlocks(_tokenSet);
  }
  
  protected Iterable<AbstractIndentableAutoEditBlock> getBlocks(final TokenSet tokenSet) {
    Iterable<AbstractIndentableAutoEditBlock> _xblockexpression = null;
    {
      final AutoEditMultiLineBlock multiLineCommentBlock = new AutoEditMultiLineBlock("/*", " * ", " */");
      Iterable<AbstractIndentableAutoEditBlock> _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        TokenSet _singleLineCommentTokens = this.getSingleLineCommentTokens();
        if (Objects.equal(tokenSet, _singleLineCommentTokens)) {
          _matched=true;
          _switchResult = CollectionLiterals.<AbstractIndentableAutoEditBlock>emptyList();
        }
      }
      if (!_matched) {
        TokenSet _commentTokens = this.getCommentTokens();
        if (Objects.equal(tokenSet, _commentTokens)) {
          _matched=true;
          _switchResult = Collections.<AbstractIndentableAutoEditBlock>unmodifiableList(CollectionLiterals.<AbstractIndentableAutoEditBlock>newArrayList(multiLineCommentBlock));
        }
      }
      if (!_matched) {
        Set<BracePair> _pairs = this.bracePairProvider.getPairs();
        final Function1<BracePair, AutoEditMultiLineBlock> _function = new Function1<BracePair, AutoEditMultiLineBlock>() {
          @Override
          public AutoEditMultiLineBlock apply(final BracePair it) {
            String _leftBrace = it.getLeftBrace();
            String _rightBrace = it.getRightBrace();
            boolean _isStructural = it.isStructural();
            return new AutoEditMultiLineBlock(_leftBrace, null, _rightBrace, _isStructural);
          }
        };
        Iterable<AutoEditMultiLineBlock> _map = IterableExtensions.<BracePair, AutoEditMultiLineBlock>map(_pairs, _function);
        _switchResult = Iterables.<AbstractIndentableAutoEditBlock>concat(_map, Collections.<AutoEditMultiLineBlock>unmodifiableList(CollectionLiterals.<AutoEditMultiLineBlock>newArrayList(multiLineCommentBlock)));
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  @Override
  public IdeaAutoEditHandler.Result beforeEnterTyped(final PsiFile file, final EditorEx editor, final Ref<Integer> caretOffset, final Ref<Integer> caretAdvance, final DataContext dataContext, final EditorActionHandler originalHandler) {
    AutoEditContext _autoEditContext = new AutoEditContext(editor, this);
    return this.handleIndentation(_autoEditContext);
  }
  
  protected final static String WHITESPACE_CHARACTERS = " \t";
  
  protected IdeaAutoEditHandler.Result handleIndentation(@Extension final AutoEditContext context) {
    final String previousLineIndentation = this.getPreviousLineIndentaiton(context);
    final String blockIndentaion = this.indentBlock(previousLineIndentation, context);
    final String string = context.newLine((previousLineIndentation + blockIndentaion));
    final int cursorShift = string.length();
    EditorEx _editor = context.getEditor();
    EditorModificationUtil.insertStringAtCaret(_editor, string, false, false);
    EditorEx _editor_1 = context.getEditor();
    EditorModificationUtil.moveCaretRelatively(_editor_1, cursorShift);
    return IdeaAutoEditHandler.Result.STOP;
  }
  
  protected String getPreviousLineIndentaiton(@Extension final AutoEditContext context) {
    String _xblockexpression = null;
    {
      boolean _shouldIndent = this.shouldIndent(context);
      boolean _not = (!_shouldIndent);
      if (_not) {
        return "";
      }
      DocumentEx _document = context.getDocument();
      int _caretOffset = context.getCaretOffset();
      final int lineNumber = _document.getLineNumber(_caretOffset);
      DocumentEx _document_1 = context.getDocument();
      final int lineStartOffset = _document_1.getLineStartOffset(lineNumber);
      DocumentEx _document_2 = context.getDocument();
      String _text = _document_2.getText();
      int _caretOffset_1 = context.getCaretOffset();
      final int textStartOffset = CharArrayUtil.shiftForward(_text, lineStartOffset, _caretOffset_1, 
        DefaultAutoEditHandler.WHITESPACE_CHARACTERS);
      String _xifexpression = null;
      if ((textStartOffset > lineStartOffset)) {
        _xifexpression = context.getText(lineStartOffset, textStartOffset);
      } else {
        _xifexpression = "";
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected boolean shouldIndent(@Extension final AutoEditContext context) {
    int _caretOffset = context.getCaretOffset();
    TokenSet _tokenSet = context.getTokenSet(_caretOffset);
    TokenSet _stringLiteralTokens = this.getStringLiteralTokens();
    return (!Objects.equal(_tokenSet, _stringLiteralTokens));
  }
  
  protected String indentBlock(final String previousLineIndentation, @Extension final AutoEditContext context) {
    final AutoEditBlockRegion region = this.findBlockRegion(context);
    boolean _notEquals = (!Objects.equal(region, null));
    if (_notEquals) {
      AbstractIndentableAutoEditBlock _block = region.getBlock();
      return _block.indent(region, previousLineIndentation, context);
    }
    return "";
  }
  
  protected AutoEditBlockRegion findBlockRegion(@Extension final AutoEditContext context) {
    EditorEx _editor = context.getEditor();
    Iterable<AbstractIndentableAutoEditBlock> _blocks = this.getBlocks(_editor);
    final Function1<AbstractIndentableAutoEditBlock, AutoEditBlockRegion> _function = new Function1<AbstractIndentableAutoEditBlock, AutoEditBlockRegion>() {
      @Override
      public AutoEditBlockRegion apply(final AbstractIndentableAutoEditBlock it) {
        return it.findRegion(context);
      }
    };
    Iterable<AutoEditBlockRegion> _map = IterableExtensions.<AbstractIndentableAutoEditBlock, AutoEditBlockRegion>map(_blocks, _function);
    Iterable<AutoEditBlockRegion> _filterNull = IterableExtensions.<AutoEditBlockRegion>filterNull(_map);
    final Function2<AutoEditBlockRegion, AutoEditBlockRegion, AutoEditBlockRegion> _function_1 = new Function2<AutoEditBlockRegion, AutoEditBlockRegion, AutoEditBlockRegion>() {
      @Override
      public AutoEditBlockRegion apply(final AutoEditBlockRegion $0, final AutoEditBlockRegion $1) {
        AutoEditBlockRegion _xifexpression = null;
        TextRegion _openingTerminal = $0.getOpeningTerminal();
        int _offset = _openingTerminal.getOffset();
        TextRegion _openingTerminal_1 = $1.getOpeningTerminal();
        int _offset_1 = _openingTerminal_1.getOffset();
        boolean _lessThan = (_offset < _offset_1);
        if (_lessThan) {
          _xifexpression = $1;
        } else {
          _xifexpression = $0;
        }
        return _xifexpression;
      }
    };
    return IterableExtensions.<AutoEditBlockRegion>reduce(_filterNull, _function_1);
  }
  
  @Override
  public IdeaAutoEditHandler.Result beforeCharTyped(final char c, final Project project, final EditorEx editor, final PsiFile file, final FileType fileType) {
    final AutoEditContext context = new AutoEditContext(editor, this);
    Iterable<AbstractIndentableAutoEditBlock> _blocks = this.getBlocks(editor);
    final Function1<AbstractIndentableAutoEditBlock, IdeaAutoEditHandler.Result> _function = new Function1<AbstractIndentableAutoEditBlock, IdeaAutoEditHandler.Result>() {
      @Override
      public IdeaAutoEditHandler.Result apply(final AbstractIndentableAutoEditBlock it) {
        return DefaultAutoEditHandler.this.closeBlock(it, c, context);
      }
    };
    Iterable<IdeaAutoEditHandler.Result> _map = IterableExtensions.<AbstractIndentableAutoEditBlock, IdeaAutoEditHandler.Result>map(_blocks, _function);
    for (final IdeaAutoEditHandler.Result result : _map) {
      boolean _or = false;
      boolean _equals = Objects.equal(result, IdeaAutoEditHandler.Result.DEFAULT);
      if (_equals) {
        _or = true;
      } else {
        boolean _equals_1 = Objects.equal(result, IdeaAutoEditHandler.Result.STOP);
        _or = _equals_1;
      }
      if (_or) {
        return result;
      }
    }
    Iterable<AbstractAutoEditBlock> _quotes = this.getQuotes();
    final Function1<AbstractAutoEditBlock, IdeaAutoEditHandler.Result> _function_1 = new Function1<AbstractAutoEditBlock, IdeaAutoEditHandler.Result>() {
      @Override
      public IdeaAutoEditHandler.Result apply(final AbstractAutoEditBlock it) {
        return DefaultAutoEditHandler.this.closeBlock(it, c, context);
      }
    };
    Iterable<IdeaAutoEditHandler.Result> _map_1 = IterableExtensions.<AbstractAutoEditBlock, IdeaAutoEditHandler.Result>map(_quotes, _function_1);
    for (final IdeaAutoEditHandler.Result result_1 : _map_1) {
      boolean _or_1 = false;
      boolean _equals_2 = Objects.equal(result_1, IdeaAutoEditHandler.Result.DEFAULT);
      if (_equals_2) {
        _or_1 = true;
      } else {
        boolean _equals_3 = Objects.equal(result_1, IdeaAutoEditHandler.Result.STOP);
        _or_1 = _equals_3;
      }
      if (_or_1) {
        return result_1;
      }
    }
    Iterable<AbstractIndentableAutoEditBlock> _blocks_1 = this.getBlocks(editor);
    final Function1<AbstractIndentableAutoEditBlock, IdeaAutoEditHandler.Result> _function_2 = new Function1<AbstractIndentableAutoEditBlock, IdeaAutoEditHandler.Result>() {
      @Override
      public IdeaAutoEditHandler.Result apply(final AbstractIndentableAutoEditBlock it) {
        return DefaultAutoEditHandler.this.openBlock(it, c, context);
      }
    };
    Iterable<IdeaAutoEditHandler.Result> _map_2 = IterableExtensions.<AbstractIndentableAutoEditBlock, IdeaAutoEditHandler.Result>map(_blocks_1, _function_2);
    for (final IdeaAutoEditHandler.Result result_2 : _map_2) {
      boolean _or_2 = false;
      boolean _equals_4 = Objects.equal(result_2, IdeaAutoEditHandler.Result.DEFAULT);
      if (_equals_4) {
        _or_2 = true;
      } else {
        boolean _equals_5 = Objects.equal(result_2, IdeaAutoEditHandler.Result.STOP);
        _or_2 = _equals_5;
      }
      if (_or_2) {
        return result_2;
      }
    }
    Iterable<AbstractAutoEditBlock> _quotes_1 = this.getQuotes();
    final Function1<AbstractAutoEditBlock, IdeaAutoEditHandler.Result> _function_3 = new Function1<AbstractAutoEditBlock, IdeaAutoEditHandler.Result>() {
      @Override
      public IdeaAutoEditHandler.Result apply(final AbstractAutoEditBlock it) {
        return DefaultAutoEditHandler.this.openBlock(it, c, context);
      }
    };
    Iterable<IdeaAutoEditHandler.Result> _map_3 = IterableExtensions.<AbstractAutoEditBlock, IdeaAutoEditHandler.Result>map(_quotes_1, _function_3);
    for (final IdeaAutoEditHandler.Result result_3 : _map_3) {
      boolean _or_3 = false;
      boolean _equals_6 = Objects.equal(result_3, IdeaAutoEditHandler.Result.DEFAULT);
      if (_equals_6) {
        _or_3 = true;
      } else {
        boolean _equals_7 = Objects.equal(result_3, IdeaAutoEditHandler.Result.STOP);
        _or_3 = _equals_7;
      }
      if (_or_3) {
        return result_3;
      }
    }
    return super.beforeCharTyped(c, project, editor, file, fileType);
  }
  
  @Override
  public boolean charDeleted(final char c, final PsiFile file, final EditorEx editor) {
    final AutoEditContext context = new AutoEditContext(editor, this);
    Iterable<AbstractIndentableAutoEditBlock> _blocks = this.getBlocks(editor);
    final Function1<AbstractIndentableAutoEditBlock, Boolean> _function = new Function1<AbstractIndentableAutoEditBlock, Boolean>() {
      @Override
      public Boolean apply(final AbstractIndentableAutoEditBlock it) {
        return Boolean.valueOf(it.delete(c, context));
      }
    };
    boolean _exists = IterableExtensions.<AbstractIndentableAutoEditBlock>exists(_blocks, _function);
    if (_exists) {
      return true;
    }
    Iterable<AbstractAutoEditBlock> _quotes = this.getQuotes();
    final Function1<AbstractAutoEditBlock, Boolean> _function_1 = new Function1<AbstractAutoEditBlock, Boolean>() {
      @Override
      public Boolean apply(final AbstractAutoEditBlock it) {
        return Boolean.valueOf(it.delete(c, context));
      }
    };
    boolean _exists_1 = IterableExtensions.<AbstractAutoEditBlock>exists(_quotes, _function_1);
    if (_exists_1) {
      return true;
    }
    return super.charDeleted(c, file, editor);
  }
  
  protected IdeaAutoEditHandler.Result closeBlock(final AbstractAutoEditBlock block, final char c, final AutoEditContext context) {
    String _closingTerminal = block.getClosingTerminal();
    boolean _isAtTerminal = this.isAtTerminal(_closingTerminal, c, context);
    if (_isAtTerminal) {
      boolean _close = block.close(c, context);
      if (_close) {
        return IdeaAutoEditHandler.Result.STOP;
      }
    }
    return IdeaAutoEditHandler.Result.CONTINUE;
  }
  
  protected IdeaAutoEditHandler.Result openBlock(final AbstractAutoEditBlock block, final char c, final AutoEditContext context) {
    String _openingTerminal = block.getOpeningTerminal();
    boolean _isAtTerminal = this.isAtTerminal(_openingTerminal, c, context);
    if (_isAtTerminal) {
      block.open(c, context);
      return IdeaAutoEditHandler.Result.STOP;
    }
    return IdeaAutoEditHandler.Result.CONTINUE;
  }
  
  protected boolean isAtTerminal(final String terminal, final char c, @Extension final AutoEditContext context) {
    boolean _xblockexpression = false;
    {
      int _caretOffset = context.getCaretOffset();
      int _length = terminal.length();
      int _minus = (_caretOffset - _length);
      final int startOffset = (_minus + 1);
      String _xifexpression = null;
      int _caretOffset_1 = context.getCaretOffset();
      boolean _equals = (startOffset == _caretOffset_1);
      if (_equals) {
        _xifexpression = "";
      } else {
        int _max = Math.max(0, startOffset);
        int _caretOffset_2 = context.getCaretOffset();
        _xifexpression = context.getText(_max, _caretOffset_2);
      }
      final String startText = _xifexpression;
      int _caretOffset_3 = context.getCaretOffset();
      int _length_1 = terminal.length();
      int _plus = (_caretOffset_3 + _length_1);
      final int endOffset = (_plus - 1);
      String _xifexpression_1 = null;
      int _caretOffset_4 = context.getCaretOffset();
      boolean _equals_1 = (endOffset == _caretOffset_4);
      if (_equals_1) {
        _xifexpression_1 = "";
      } else {
        int _caretOffset_5 = context.getCaretOffset();
        DocumentEx _document = context.getDocument();
        int _textLength = _document.getTextLength();
        int _min = Math.min(endOffset, _textLength);
        _xifexpression_1 = context.getText(_caretOffset_5, _min);
      }
      final String endText = _xifexpression_1;
      final String text = ((startText + Character.valueOf(c)) + endText);
      int _lastIndexOf = text.lastIndexOf(terminal);
      _xblockexpression = (_lastIndexOf != (-1));
    }
    return _xblockexpression;
  }
  
  @Override
  public TokenSet getTokenSet(final EditorEx editor, final int offset) {
    IElementType _tokenType = this.getTokenType(editor, offset);
    return this.getTokenSet(_tokenType);
  }
  
  @Override
  public TokenSet getTokenSet(final IElementType tokenType) {
    TokenSet _stringLiteralTokens = this.getStringLiteralTokens();
    boolean _contains = _stringLiteralTokens.contains(tokenType);
    if (_contains) {
      return this.getStringLiteralTokens();
    }
    TokenSet _singleLineCommentTokens = this.getSingleLineCommentTokens();
    boolean _contains_1 = _singleLineCommentTokens.contains(tokenType);
    if (_contains_1) {
      return this.getSingleLineCommentTokens();
    }
    TokenSet _commentTokens = this.getCommentTokens();
    boolean _contains_2 = _commentTokens.contains(tokenType);
    if (_contains_2) {
      return this.getCommentTokens();
    }
    return null;
  }
  
  @Override
  public boolean isStartOfLine(final EditorEx editor, final int offset) {
    TokenSet _tokenSet = this.getTokenSet(editor, offset);
    return this.isStartOfLine(_tokenSet, editor, offset);
  }
  
  @Override
  public boolean isStartOfLine(final TokenSet tokenSet, final EditorEx editor, final int offset) {
    String _beginningOfLine = this.getBeginningOfLine(editor, offset);
    String _trim = _beginningOfLine.trim();
    return _trim.isEmpty();
  }
  
  @Override
  public boolean isEndOfLine(final EditorEx editor, final int offset) {
    TokenSet _tokenSet = this.getTokenSet(editor, offset);
    return this.isEndOfLine(_tokenSet, editor, offset);
  }
  
  @Override
  public boolean isEndOfLine(final TokenSet tokenSet, final EditorEx editor, final int offset) {
    String _endOfLine = this.getEndOfLine(editor, offset);
    String _trim = _endOfLine.trim();
    return _trim.isEmpty();
  }
  
  public String getBeginningOfLine(final EditorEx editor, final int offset) {
    String _xblockexpression = null;
    {
      final DocumentEx document = editor.getDocument();
      DocumentEx _document = editor.getDocument();
      final int lineNumber = _document.getLineNumber(offset);
      DocumentEx _document_1 = editor.getDocument();
      final int lineStartOffset = _document_1.getLineStartOffset(lineNumber);
      TextRange _textRange = new TextRange(lineStartOffset, offset);
      _xblockexpression = document.getText(_textRange);
    }
    return _xblockexpression;
  }
  
  public String getEndOfLine(final EditorEx editor, final int offset) {
    String _xblockexpression = null;
    {
      final DocumentEx document = editor.getDocument();
      DocumentEx _document = editor.getDocument();
      final int lineNumber = _document.getLineNumber(offset);
      DocumentEx _document_1 = editor.getDocument();
      final int lineEndOffset = _document_1.getLineEndOffset(lineNumber);
      TextRange _textRange = new TextRange(offset, lineEndOffset);
      _xblockexpression = document.getText(_textRange);
    }
    return _xblockexpression;
  }
  
  protected IElementType getTokenType(final EditorEx editor, final int offset) {
    IElementType _xblockexpression = null;
    {
      boolean _or = false;
      if ((offset < 0)) {
        _or = true;
      } else {
        DocumentEx _document = editor.getDocument();
        int _textLength = _document.getTextLength();
        boolean _greaterThan = (offset > _textLength);
        _or = _greaterThan;
      }
      if (_or) {
        return null;
      }
      EditorHighlighter _highlighter = editor.getHighlighter();
      final HighlighterIterator iterator = _highlighter.createIterator(offset);
      boolean _atEnd = iterator.atEnd();
      if (_atEnd) {
        return null;
      }
      _xblockexpression = iterator.getTokenType();
    }
    return _xblockexpression;
  }
  
  protected TokenSet getCommentTokens() {
    return this.tokenTypeProvider.getCommentTokens();
  }
  
  protected TokenSet getSingleLineCommentTokens() {
    return TokenSet.EMPTY;
  }
  
  @Override
  public TokenSet getStringLiteralTokens() {
    return this.tokenTypeProvider.getStringLiteralTokens();
  }
}
