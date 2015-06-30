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
import com.intellij.openapi.editor.Document;
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
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.ide.editor.bracketmatching.BracePair;
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.idea.editorActions.AutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AutoEditBlockRegion;
import org.eclipse.xtext.idea.editorActions.IdeaAutoEditHandler;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultAutoEditHandler extends IdeaAutoEditHandler {
  @Inject
  private TokenTypeProvider tokenTypeProvider;
  
  @Inject
  private IBracePairProvider bracePairProvider;
  
  protected List<Pair<String, String>> getQuotePairs() {
    Pair<String, String> _mappedTo = Pair.<String, String>of("\"", "\"");
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("\'", "\'");
    return Collections.<Pair<String, String>>unmodifiableList(CollectionLiterals.<Pair<String, String>>newArrayList(_mappedTo, _mappedTo_1));
  }
  
  protected Iterable<AutoEditBlock> getBlocks(final EditorEx editor) {
    Iterable<AutoEditBlock> _xblockexpression = null;
    {
      final AutoEditBlock multiLineCommentBlock = new AutoEditBlock("/*", " * ", " */");
      CaretModel _caretModel = editor.getCaretModel();
      int _offset = _caretModel.getOffset();
      final TokenSet tokenSet = this.getTokenSet(editor, _offset);
      Iterable<AutoEditBlock> _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        TokenSet _singleLineCommentTokens = this.getSingleLineCommentTokens();
        if (Objects.equal(tokenSet, _singleLineCommentTokens)) {
          _matched=true;
          _switchResult = CollectionLiterals.<AutoEditBlock>emptyList();
        }
      }
      if (!_matched) {
        TokenSet _commentTokens = this.getCommentTokens();
        if (Objects.equal(tokenSet, _commentTokens)) {
          _matched=true;
          _switchResult = Collections.<AutoEditBlock>unmodifiableList(CollectionLiterals.<AutoEditBlock>newArrayList(multiLineCommentBlock));
        }
      }
      if (!_matched) {
        Set<BracePair> _pairs = this.bracePairProvider.getPairs();
        final Function1<BracePair, AutoEditBlock> _function = new Function1<BracePair, AutoEditBlock>() {
          @Override
          public AutoEditBlock apply(final BracePair it) {
            String _leftBrace = it.getLeftBrace();
            String _rightBrace = it.getRightBrace();
            boolean _isStructural = it.isStructural();
            return new AutoEditBlock(_leftBrace, null, _rightBrace, _isStructural);
          }
        };
        Iterable<AutoEditBlock> _map = IterableExtensions.<BracePair, AutoEditBlock>map(_pairs, _function);
        _switchResult = Iterables.<AutoEditBlock>concat(_map, Collections.<AutoEditBlock>unmodifiableList(CollectionLiterals.<AutoEditBlock>newArrayList(multiLineCommentBlock)));
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  @Override
  public IdeaAutoEditHandler.Result beforeEnterTyped(final PsiFile file, final EditorEx editor, final Ref<Integer> caretOffset, final Ref<Integer> caretAdvance, final DataContext dataContext, final EditorActionHandler originalHandler) {
    return this.handleIndentation(editor);
  }
  
  protected final static String WHITESPACE_CHARACTERS = " \t";
  
  protected IdeaAutoEditHandler.Result handleIndentation(final EditorEx editor) {
    final String previousLineIndentation = this.getPreviousLineIndentaiton(editor);
    final String blockIndentaion = this.indentBlock(editor, previousLineIndentation);
    final String string = this.newLine((previousLineIndentation + blockIndentaion));
    final int cursorShift = string.length();
    EditorModificationUtil.insertStringAtCaret(editor, string, false, false);
    EditorModificationUtil.moveCaretRelatively(editor, cursorShift);
    return IdeaAutoEditHandler.Result.STOP;
  }
  
  protected String getPreviousLineIndentaiton(final EditorEx editor) {
    String _xblockexpression = null;
    {
      final DocumentEx document = editor.getDocument();
      CaretModel _caretModel = editor.getCaretModel();
      final int caretOffset = _caretModel.getOffset();
      final int lineNumber = document.getLineNumber(caretOffset);
      final int lineStartOffset = document.getLineStartOffset(lineNumber);
      String _text = document.getText();
      final int textStartOffset = CharArrayUtil.shiftForward(_text, lineStartOffset, caretOffset, 
        DefaultAutoEditHandler.WHITESPACE_CHARACTERS);
      String _xifexpression = null;
      if ((textStartOffset > lineStartOffset)) {
        TextRange _textRange = new TextRange(lineStartOffset, textStartOffset);
        _xifexpression = document.getText(_textRange);
      } else {
        _xifexpression = "";
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected String indentBlock(final EditorEx editor, final String previousLineIndentation) {
    final AutoEditBlockRegion region = this.findBlockRegion(editor);
    boolean _equals = Objects.equal(region, null);
    if (_equals) {
      return "";
    }
    final DocumentEx document = editor.getDocument();
    CaretModel _caretModel = editor.getCaretModel();
    final int caretOffset = _caretModel.getOffset();
    String _elvis = null;
    AutoEditBlock _block = region.getBlock();
    String _indentationTerminal = _block.getIndentationTerminal();
    if (_indentationTerminal != null) {
      _elvis = _indentationTerminal;
    } else {
      String _indentationTerminal_1 = this.getIndentationTerminal();
      _elvis = _indentationTerminal_1;
    }
    final String indentationTerminal = _elvis;
    DocumentEx _document = editor.getDocument();
    TextRegion _openingTerminal = region.getOpeningTerminal();
    int _offset = _openingTerminal.getOffset();
    boolean _isSameLine = this.isSameLine(_document, _offset, caretOffset);
    if (_isSameLine) {
      final TextRegion closingTerminal = this.getClosingTerminal(region, editor);
      boolean _equals_1 = Objects.equal(closingTerminal, null);
      if (_equals_1) {
        this.closeBlock(region, editor, previousLineIndentation);
      } else {
        boolean _and = false;
        int _offset_1 = closingTerminal.getOffset();
        boolean _isSameLine_1 = this.isSameLine(document, _offset_1, caretOffset);
        if (!_isSameLine_1) {
          _and = false;
        } else {
          int _offset_2 = closingTerminal.getOffset();
          boolean _greaterEqualsThan = (_offset_2 >= caretOffset);
          _and = _greaterEqualsThan;
        }
        if (_and) {
          int _offset_3 = closingTerminal.getOffset();
          TextRange _textRange = new TextRange(caretOffset, _offset_3);
          String _text = document.getText(_textRange);
          final String text = _text.trim();
          int _offset_4 = closingTerminal.getOffset();
          String _newLine = this.newLine(previousLineIndentation);
          String _plus = (text + _newLine);
          document.replaceString(caretOffset, _offset_4, _plus);
        }
      }
      return indentationTerminal;
    }
    TextRegion _closingTerminal = region.getClosingTerminal();
    boolean _equals_2 = Objects.equal(_closingTerminal, null);
    if (_equals_2) {
      this.closeBlock(region, editor, previousLineIndentation);
      return "";
    }
    return Strings.removeLeadingWhitespace(indentationTerminal);
  }
  
  public TextRegion getClosingTerminal(final AutoEditBlockRegion region, final EditorEx editor) {
    final AutoEditBlock block = region.getBlock();
    final TextRegion closingTerminal = region.getClosingTerminal();
    boolean _equals = Objects.equal(closingTerminal, null);
    if (_equals) {
      return null;
    }
    final DocumentEx document = editor.getDocument();
    CaretModel _caretModel = editor.getCaretModel();
    final int caretOffset = _caretModel.getOffset();
    boolean _and = false;
    int _length = closingTerminal.getLength();
    String _closingTerminal = block.getClosingTerminal();
    int _length_1 = _closingTerminal.length();
    boolean _lessThan = (_length < _length_1);
    if (!_lessThan) {
      _and = false;
    } else {
      int _offset = closingTerminal.getOffset();
      boolean _isSameLine = this.isSameLine(document, _offset, caretOffset);
      _and = _isSameLine;
    }
    if (_and) {
      return null;
    }
    return closingTerminal;
  }
  
  protected void closeBlock(final AutoEditBlockRegion region, final EditorEx editor, final String previousLineIndentation) {
    final DocumentEx document = editor.getDocument();
    CaretModel _caretModel = editor.getCaretModel();
    final int caretOffset = _caretModel.getOffset();
    boolean _isEndOfLine = this.isEndOfLine(document, caretOffset);
    if (_isEndOfLine) {
      DocumentEx _document = editor.getDocument();
      AutoEditBlock _block = region.getBlock();
      String _closingTerminal = _block.getClosingTerminal();
      String _removeLeadingWhitespace = Strings.removeLeadingWhitespace(_closingTerminal);
      String _plus = (previousLineIndentation + _removeLeadingWhitespace);
      String _newLine = this.newLine(_plus);
      _document.insertString(caretOffset, _newLine);
    }
  }
  
  protected String newLine(final String content) {
    return ("\n" + content);
  }
  
  protected AutoEditBlockRegion findBlockRegion(final EditorEx editor) {
    Iterable<AutoEditBlock> _blocks = this.getBlocks(editor);
    final Function1<AutoEditBlock, AutoEditBlockRegion> _function = new Function1<AutoEditBlock, AutoEditBlockRegion>() {
      @Override
      public AutoEditBlockRegion apply(final AutoEditBlock it) {
        CaretModel _caretModel = editor.getCaretModel();
        int _offset = _caretModel.getOffset();
        return DefaultAutoEditHandler.this.findBlockRegion(it, editor, _offset);
      }
    };
    Iterable<AutoEditBlockRegion> _map = IterableExtensions.<AutoEditBlock, AutoEditBlockRegion>map(_blocks, _function);
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
  
  protected String getIndentationTerminal() {
    return "\t";
  }
  
  @Override
  public IdeaAutoEditHandler.Result beforeCharTyped(final char c, final Project project, final EditorEx editor, final PsiFile file, final FileType fileType) {
    Iterable<AutoEditBlock> _blocks = this.getBlocks(editor);
    final Function1<AutoEditBlock, IdeaAutoEditHandler.Result> _function = new Function1<AutoEditBlock, IdeaAutoEditHandler.Result>() {
      @Override
      public IdeaAutoEditHandler.Result apply(final AutoEditBlock it) {
        return DefaultAutoEditHandler.this.handleBlock(it, editor, c);
      }
    };
    Iterable<IdeaAutoEditHandler.Result> _map = IterableExtensions.<AutoEditBlock, IdeaAutoEditHandler.Result>map(_blocks, _function);
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
    List<Pair<String, String>> _quotePairs = this.getQuotePairs();
    final Function1<Pair<String, String>, IdeaAutoEditHandler.Result> _function_1 = new Function1<Pair<String, String>, IdeaAutoEditHandler.Result>() {
      @Override
      public IdeaAutoEditHandler.Result apply(final Pair<String, String> it) {
        String _key = it.getKey();
        String _value = it.getValue();
        return DefaultAutoEditHandler.this.handleQuote(editor, c, _key, _value);
      }
    };
    List<IdeaAutoEditHandler.Result> _map_1 = ListExtensions.<Pair<String, String>, IdeaAutoEditHandler.Result>map(_quotePairs, _function_1);
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
    return super.beforeCharTyped(c, project, editor, file, fileType);
  }
  
  @Override
  public boolean charDeleted(final char c, final PsiFile file, final EditorEx editor) {
    List<Pair<String, String>> _quotePairs = this.getQuotePairs();
    final Function1<Pair<String, String>, Boolean> _function = new Function1<Pair<String, String>, Boolean>() {
      @Override
      public Boolean apply(final Pair<String, String> it) {
        String _key = it.getKey();
        String _value = it.getValue();
        return Boolean.valueOf(DefaultAutoEditHandler.this.handleDeleteQuote(editor, c, _key, _value));
      }
    };
    List<Boolean> _map = ListExtensions.<Pair<String, String>, Boolean>map(_quotePairs, _function);
    final Function1<Boolean, Boolean> _function_1 = new Function1<Boolean, Boolean>() {
      @Override
      public Boolean apply(final Boolean it) {
        return it;
      }
    };
    boolean _exists = IterableExtensions.<Boolean>exists(_map, _function_1);
    if (_exists) {
      return true;
    }
    return super.charDeleted(c, file, editor);
  }
  
  protected IdeaAutoEditHandler.Result handleQuote(final EditorEx editor, final char c, final String openingQuote, final String closingQuote) {
    boolean _endsWith = this.endsWith(editor, c, openingQuote);
    boolean _not = (!_endsWith);
    if (_not) {
      return IdeaAutoEditHandler.Result.CONTINUE;
    }
    CaretModel _caretModel = editor.getCaretModel();
    int _offset = _caretModel.getOffset();
    boolean _isStringLiteral = this.isStringLiteral(editor, _offset);
    if (_isStringLiteral) {
      return this.handleQuoteInStringLiteral(editor, c, openingQuote, closingQuote);
    }
    boolean _shouldInsertClosingQuote = this.shouldInsertClosingQuote(editor, openingQuote, closingQuote);
    if (_shouldInsertClosingQuote) {
      DocumentEx _document = editor.getDocument();
      int _type = this.type(editor, c);
      _document.insertString(_type, closingQuote);
    } else {
      this.type(editor, c);
    }
    return IdeaAutoEditHandler.Result.STOP;
  }
  
  protected boolean isStringLiteral(final EditorEx editor, final int offset) {
    boolean _xblockexpression = false;
    {
      boolean _or = false;
      if ((offset == 0)) {
        _or = true;
      } else {
        DocumentEx _document = editor.getDocument();
        int _textLength = _document.getTextLength();
        boolean _equals = (_textLength == offset);
        _or = _equals;
      }
      if (_or) {
        return false;
      }
      TokenSet _tokenSet = this.getTokenSet(editor, offset);
      TokenSet _stringLiteralTokens = this.getStringLiteralTokens();
      _xblockexpression = Objects.equal(_tokenSet, _stringLiteralTokens);
    }
    return _xblockexpression;
  }
  
  protected IdeaAutoEditHandler.Result handleQuoteInStringLiteral(final EditorEx editor, final char c, final String openingQuote, final String closingQuote) {
    boolean _isClosingQuote = this.isClosingQuote(editor, closingQuote);
    if (_isClosingQuote) {
      int _length = closingQuote.length();
      EditorModificationUtil.moveCaretRelatively(editor, _length);
    } else {
      this.type(editor, c);
    }
    return IdeaAutoEditHandler.Result.STOP;
  }
  
  protected boolean shouldInsertClosingQuote(final EditorEx editor, final String openingQuote, final String closingQuote) {
    DocumentEx _document = editor.getDocument();
    CaretModel _caretModel = editor.getCaretModel();
    int _offset = _caretModel.getOffset();
    boolean _isIdentifierPart = this.isIdentifierPart(_document, _offset);
    if (_isIdentifierPart) {
      return false;
    }
    boolean _equals = Objects.equal(openingQuote, closingQuote);
    if (_equals) {
      DocumentEx _document_1 = editor.getDocument();
      String _text = _document_1.getText();
      int _count = this.count(_text, openingQuote);
      int _modulo = (_count % 2);
      boolean _notEquals = (_modulo != 0);
      if (_notEquals) {
        return false;
      }
    }
    return true;
  }
  
  protected boolean isClosingQuote(final EditorEx editor, final String closingQuote) {
    CaretModel _caretModel = editor.getCaretModel();
    final int beginOffset = _caretModel.getOffset();
    final int closingQuoteLength = closingQuote.length();
    final int endOffset = (beginOffset + closingQuoteLength);
    DocumentEx _document = editor.getDocument();
    int _textLength = _document.getTextLength();
    boolean _greaterThan = (endOffset > _textLength);
    if (_greaterThan) {
      return false;
    }
    EditorHighlighter _highlighter = editor.getHighlighter();
    final HighlighterIterator iterator = _highlighter.createIterator(beginOffset);
    boolean _atEnd = iterator.atEnd();
    if (_atEnd) {
      return false;
    }
    final int start = iterator.getStart();
    final int end = iterator.getEnd();
    return (((end - start) >= closingQuoteLength) && (beginOffset == (end - closingQuoteLength)));
  }
  
  protected boolean handleDeleteQuote(final EditorEx editor, final char c, final String openingQuote, final String closingQuote) {
    char _charAt = openingQuote.charAt(0);
    boolean _notEquals = (c != _charAt);
    if (_notEquals) {
      return false;
    }
    CaretModel _caretModel = editor.getCaretModel();
    final int beginOffset = _caretModel.getOffset();
    if ((beginOffset < 0)) {
      return false;
    }
    int _length = closingQuote.length();
    final int endOffset = (beginOffset + _length);
    DocumentEx _document = editor.getDocument();
    int _textLength = _document.getTextLength();
    boolean _greaterThan = (endOffset > _textLength);
    if (_greaterThan) {
      return false;
    }
    DocumentEx _document_1 = editor.getDocument();
    TextRange _textRange = new TextRange(beginOffset, endOffset);
    final String s = _document_1.getText(_textRange);
    boolean _notEquals_1 = (!Objects.equal(s, closingQuote));
    if (_notEquals_1) {
      return false;
    }
    DocumentEx _document_2 = editor.getDocument();
    _document_2.deleteString(beginOffset, endOffset);
    return true;
  }
  
  protected IdeaAutoEditHandler.Result handleBlock(final AutoEditBlock block, final EditorEx editor, final char c) {
    String _openingTerminal = block.getOpeningTerminal();
    boolean _endsWith = this.endsWith(editor, c, _openingTerminal);
    boolean _not = (!_endsWith);
    if (_not) {
      return IdeaAutoEditHandler.Result.CONTINUE;
    }
    final int newCaretOffset = this.type(editor, c);
    boolean _shouldInsertClosingTerminal = this.shouldInsertClosingTerminal(editor, newCaretOffset);
    boolean _not_1 = (!_shouldInsertClosingTerminal);
    if (_not_1) {
      return IdeaAutoEditHandler.Result.STOP;
    }
    DocumentEx _document = editor.getDocument();
    final String documentContent = _document.getText();
    String _openingTerminal_1 = block.getOpeningTerminal();
    final int opening = this.count(documentContent, _openingTerminal_1);
    String _closingTerminal = block.getClosingTerminal();
    final int closing = this.count(documentContent, _closingTerminal);
    final int occurences = ((opening + closing) - 1);
    if (((occurences % 2) == 0)) {
      DocumentEx _document_1 = editor.getDocument();
      String _closingTerminal_1 = block.getClosingTerminal();
      _document_1.insertString(newCaretOffset, _closingTerminal_1);
    }
    return IdeaAutoEditHandler.Result.STOP;
  }
  
  private final static Set<Character> CHARACTERS = Collections.<Character>unmodifiableSet(CollectionLiterals.<Character>newHashSet(Character.valueOf('!'), Character.valueOf('-'), Character.valueOf('('), Character.valueOf('{'), Character.valueOf('['), Character.valueOf('\''), Character.valueOf('\"')));
  
  protected boolean shouldInsertClosingTerminal(final EditorEx editor, final int offset) {
    final DocumentEx document = editor.getDocument();
    int _textLength = document.getTextLength();
    boolean _lessEqualsThan = (_textLength <= offset);
    if (_lessEqualsThan) {
      return true;
    }
    CharSequence _charsSequence = document.getCharsSequence();
    final char charAtOffset = _charsSequence.charAt(offset);
    boolean _and = false;
    boolean _and_1 = false;
    boolean _isJavaIdentifierStart = Character.isJavaIdentifierStart(charAtOffset);
    boolean _not = (!_isJavaIdentifierStart);
    if (!_not) {
      _and_1 = false;
    } else {
      boolean _isDigit = Character.isDigit(charAtOffset);
      boolean _not_1 = (!_isDigit);
      _and_1 = _not_1;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _contains = DefaultAutoEditHandler.CHARACTERS.contains(Character.valueOf(charAtOffset));
      boolean _not_2 = (!_contains);
      _and = _not_2;
    }
    return _and;
  }
  
  protected boolean isIdentifierPart(final Document document, final int offset) {
    boolean _xifexpression = false;
    int _textLength = document.getTextLength();
    boolean _greaterThan = (_textLength > offset);
    if (_greaterThan) {
      CharSequence _charsSequence = document.getCharsSequence();
      char _charAt = _charsSequence.charAt(offset);
      _xifexpression = Character.isJavaIdentifierPart(_charAt);
    }
    return _xifexpression;
  }
  
  protected boolean endsWith(final EditorEx editor, final char c, final String terminal) {
    boolean _xblockexpression = false;
    {
      DocumentEx _document = editor.getDocument();
      CaretModel _caretModel = editor.getCaretModel();
      int _offset = _caretModel.getOffset();
      TextRange _textRange = new TextRange(0, _offset);
      String _text = _document.getText(_textRange);
      final String text = (_text + Character.valueOf(c));
      _xblockexpression = text.endsWith(terminal);
    }
    return _xblockexpression;
  }
  
  protected int type(final EditorEx editor, final char c) {
    String _valueOf = String.valueOf(c);
    return EditorModificationUtil.insertStringAtCaret(editor, _valueOf, true, true);
  }
  
  protected int count(final String searchMe, final String toFind) {
    final int length = toFind.length();
    int count = 0;
    int index = searchMe.indexOf(toFind);
    while ((index > (-1))) {
      {
        count++;
        int _indexOf = searchMe.indexOf(toFind, (index + length));
        index = _indexOf;
      }
    }
    return count;
  }
  
  protected TokenSet getTokenSet(final EditorEx editor, final int offset) {
    final IElementType tokenType = this.getTokenType(editor, offset);
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
  
  protected IElementType getTokenType(final EditorEx editor, final int offset) {
    IElementType _xblockexpression = null;
    {
      EditorHighlighter _highlighter = editor.getHighlighter();
      final HighlighterIterator iterator = _highlighter.createIterator(offset);
      boolean _atEnd = iterator.atEnd();
      if (_atEnd) {
        return null;
      }
      boolean _and = false;
      int _start = iterator.getStart();
      boolean _equals = (_start == offset);
      if (!_equals) {
        _and = false;
      } else {
        _and = (offset != 0);
      }
      if (_and) {
        iterator.retreat();
      }
      boolean _and_1 = false;
      int _end = iterator.getEnd();
      boolean _equals_1 = (_end == offset);
      if (!_equals_1) {
        _and_1 = false;
      } else {
        DocumentEx _document = editor.getDocument();
        int _textLength = _document.getTextLength();
        boolean _notEquals = (_textLength != offset);
        _and_1 = _notEquals;
      }
      if (_and_1) {
        iterator.advance();
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
  
  protected TokenSet getStringLiteralTokens() {
    return this.tokenTypeProvider.getStringLiteralTokens();
  }
  
  protected boolean isSameLine(final Document document, final int offset, final int offset2) {
    int _lineNumber = document.getLineNumber(offset);
    int _lineNumber_1 = document.getLineNumber(offset2);
    return (_lineNumber == _lineNumber_1);
  }
  
  protected boolean isStartOfLine(final Document document, final int offset) {
    boolean _xblockexpression = false;
    {
      final int lineNumber = document.getLineNumber(offset);
      final int lineStartOffset = document.getLineStartOffset(lineNumber);
      TextRange _textRange = new TextRange(lineStartOffset, offset);
      String _text = document.getText(_textRange);
      String _trim = _text.trim();
      _xblockexpression = _trim.isEmpty();
    }
    return _xblockexpression;
  }
  
  protected boolean isEndOfLine(final Document document, final int offset) {
    boolean _xblockexpression = false;
    {
      final int lineNumber = document.getLineNumber(offset);
      final int lineEndOffset = document.getLineEndOffset(lineNumber);
      TextRange _textRange = new TextRange(offset, lineEndOffset);
      String _text = document.getText(_textRange);
      String _trim = _text.trim();
      _xblockexpression = _trim.isEmpty();
    }
    return _xblockexpression;
  }
  
  protected AutoEditBlockRegion findBlockRegion(final AutoEditBlock block, final EditorEx editor, final int offset) {
    final TextRegion openingTerminal = this.findOpeningTerminal(block, editor, offset);
    boolean _equals = Objects.equal(openingTerminal, null);
    if (_equals) {
      return null;
    }
    TextRegion closingTerminal = this.findClosingTerminal(block, editor, offset);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(closingTerminal, Integer.valueOf((-1))));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _isNested = block.isNested();
      _and = _isNested;
    }
    if (_and) {
      TextRegion previousOpeningTerminal = openingTerminal;
      TextRegion previousClosingTerminal = closingTerminal;
      while ((((!Objects.equal(closingTerminal, null)) && (!Objects.equal(previousOpeningTerminal, null))) && (!Objects.equal(previousClosingTerminal, null)))) {
        {
          int _offset = previousOpeningTerminal.getOffset();
          TextRegion _findOpeningTerminal = this.findOpeningTerminal(block, editor, _offset);
          previousOpeningTerminal = _findOpeningTerminal;
          boolean _notEquals_1 = (!Objects.equal(previousOpeningTerminal, null));
          if (_notEquals_1) {
            int _offset_1 = previousClosingTerminal.getOffset();
            int _plus = (_offset_1 + 1);
            TextRegion _findClosingTerminal = this.findClosingTerminal(block, editor, _plus);
            previousClosingTerminal = _findClosingTerminal;
            boolean _equals_1 = Objects.equal(previousClosingTerminal, null);
            if (_equals_1) {
              closingTerminal = null;
            }
          }
        }
      }
    }
    return new AutoEditBlockRegion(block, openingTerminal, closingTerminal);
  }
  
  protected TextRegion findOpeningTerminal(final AutoEditBlock block, final EditorEx editor, final int offset) {
    String _openingTerminal = block.getOpeningTerminal();
    String _closingTerminal = block.getClosingTerminal();
    return this.findOpeningTerminal(editor, _openingTerminal, _closingTerminal, offset);
  }
  
  protected TextRegion findClosingTerminal(final AutoEditBlock block, final EditorEx editor, final int offset) {
    String _openingTerminal = block.getOpeningTerminal();
    String _closingTerminal = block.getClosingTerminal();
    return this.findClosingTerminal(editor, _openingTerminal, _closingTerminal, offset);
  }
  
  protected TextRegion findOpeningTerminal(final EditorEx editor, final String left, final String right, final int offset) {
    DocumentEx _document = editor.getDocument();
    final String text = _document.getText();
    int leftOffset = offset;
    int rightOffset = offset;
    while (true) {
      {
        final TextRegion openingTerminal = this.searchBackward(text, left, editor, leftOffset);
        boolean _equals = Objects.equal(openingTerminal, null);
        if (_equals) {
          return null;
        }
        final TextRegion closingTerminal = this.searchBackward(text, right, editor, rightOffset);
        boolean _or = false;
        boolean _equals_1 = Objects.equal(closingTerminal, null);
        if (_equals_1) {
          _or = true;
        } else {
          int _offset = closingTerminal.getOffset();
          int _offset_1 = openingTerminal.getOffset();
          boolean _lessThan = (_offset < _offset_1);
          _or = _lessThan;
        }
        if (_or) {
          return openingTerminal;
        }
        int _offset_2 = openingTerminal.getOffset();
        leftOffset = _offset_2;
        int _offset_3 = closingTerminal.getOffset();
        rightOffset = _offset_3;
      }
    }
  }
  
  protected TextRegion findClosingTerminal(final EditorEx editor, final String left, final String right, final int offset) {
    DocumentEx _document = editor.getDocument();
    final String text = _document.getText();
    int leftOffset = offset;
    int rightOffset = offset;
    while (true) {
      {
        final TextRegion closingTerminal = this.searchForward(text, right, editor, rightOffset);
        boolean _equals = Objects.equal(closingTerminal, null);
        if (_equals) {
          return null;
        }
        final TextRegion openingTerminal = this.searchForward(text, left, editor, leftOffset);
        boolean _or = false;
        boolean _equals_1 = Objects.equal(openingTerminal, null);
        if (_equals_1) {
          _or = true;
        } else {
          int _offset = openingTerminal.getOffset();
          int _offset_1 = closingTerminal.getOffset();
          boolean _greaterThan = (_offset > _offset_1);
          _or = _greaterThan;
        }
        if (_or) {
          return closingTerminal;
        }
        int _offset_2 = closingTerminal.getOffset();
        int _length = closingTerminal.getLength();
        int _plus = (_offset_2 + _length);
        rightOffset = _plus;
        int _offset_3 = openingTerminal.getOffset();
        int _length_1 = openingTerminal.getLength();
        int _plus_1 = (_offset_3 + _length_1);
        leftOffset = _plus_1;
      }
    }
  }
  
  protected TextRegion searchForward(final String text, final String toFind, final EditorEx editor, final int offset) {
    final int length = toFind.length();
    final TokenSet tokenSet = this.getTokenSet(editor, offset);
    int index = text.indexOf(toFind, offset);
    while (((index >= 0) && (index < text.length()))) {
      {
        TokenSet _tokenSet = this.getTokenSet(editor, index);
        boolean _equals = Objects.equal(_tokenSet, tokenSet);
        if (_equals) {
          int _length = toFind.length();
          return new TextRegion(index, _length);
        }
        int _indexOf = text.indexOf(toFind, (index + length));
        index = _indexOf;
      }
    }
    final String trimmed = toFind.trim();
    boolean _and = false;
    boolean _isEmpty = trimmed.isEmpty();
    boolean _not = (!_isEmpty);
    if (!_not) {
      _and = false;
    } else {
      int _length = trimmed.length();
      int _length_1 = toFind.length();
      boolean _notEquals = (_length != _length_1);
      _and = _notEquals;
    }
    if (_and) {
      return this.searchForward(text, trimmed, editor, offset);
    }
    return null;
  }
  
  protected TextRegion searchBackward(final String text, final String toFind, final EditorEx editor, final int offset) {
    final int length = toFind.length();
    final TokenSet tokenSet = this.getTokenSet(editor, offset);
    int index = text.lastIndexOf(toFind, (offset - length));
    while ((index >= 0)) {
      {
        TokenSet _tokenSet = this.getTokenSet(editor, index);
        boolean _equals = Objects.equal(_tokenSet, tokenSet);
        if (_equals) {
          int _length = toFind.length();
          return new TextRegion(index, _length);
        }
        int _lastIndexOf = text.lastIndexOf(toFind, (index - length));
        index = _lastIndexOf;
      }
    }
    final String trimmed = toFind.trim();
    boolean _and = false;
    boolean _isEmpty = trimmed.isEmpty();
    boolean _not = (!_isEmpty);
    if (!_not) {
      _and = false;
    } else {
      int _length = trimmed.length();
      int _length_1 = toFind.length();
      boolean _notEquals = (_length != _length_1);
      _and = _notEquals;
    }
    if (_and) {
      return this.searchBackward(text, trimmed, editor, offset);
    }
    return null;
  }
}
