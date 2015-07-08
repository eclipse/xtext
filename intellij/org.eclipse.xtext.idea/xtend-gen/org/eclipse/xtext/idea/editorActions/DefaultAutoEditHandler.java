/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.ex.DocumentEx;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.text.CharArrayUtil;
import org.eclipse.xtext.idea.editorActions.AbstractAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AbstractIndentableAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AutoEditBlockProvider;
import org.eclipse.xtext.idea.editorActions.AutoEditBlockRegion;
import org.eclipse.xtext.idea.editorActions.AutoEditContext;
import org.eclipse.xtext.idea.editorActions.IdeaAutoEditHandler;
import org.eclipse.xtext.idea.editorActions.TokenSetProvider;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class DefaultAutoEditHandler extends IdeaAutoEditHandler {
  @Inject
  @Extension
  private TokenSetProvider tokenSetProvider;
  
  @Inject
  @Extension
  private AutoEditBlockProvider blockProvider;
  
  protected Iterable<AbstractIndentableAutoEditBlock> getBlocks(final EditorEx editor) {
    CaretModel _caretModel = editor.getCaretModel();
    int _offset = _caretModel.getOffset();
    TokenSet _tokenSet = this.tokenSetProvider.getTokenSet(editor, _offset);
    return this.blockProvider.getBlocks(_tokenSet);
  }
  
  @Override
  public IdeaAutoEditHandler.Result beforeEnterTyped(final PsiFile file, final EditorEx editor, final Ref<Integer> caretOffset, final Ref<Integer> caretAdvance, final DataContext dataContext, final EditorActionHandler originalHandler) {
    AutoEditContext _autoEditContext = new AutoEditContext(editor, this.tokenSetProvider);
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
    TokenSet _stringLiteralTokens = this.tokenSetProvider.getStringLiteralTokens();
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
    final AutoEditContext context = new AutoEditContext(editor, this.tokenSetProvider);
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
    Iterable<AbstractAutoEditBlock> _quotes = this.blockProvider.getQuotes();
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
    Iterable<AbstractAutoEditBlock> _quotes_1 = this.blockProvider.getQuotes();
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
    final AutoEditContext context = new AutoEditContext(editor, this.tokenSetProvider);
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
    Iterable<AbstractAutoEditBlock> _quotes = this.blockProvider.getQuotes();
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
}
