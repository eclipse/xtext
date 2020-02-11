/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.contentassist;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionItemKind;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4j.InsertTextFormat;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author kosyakov - Initial contribution and API
 * @author Dennis Huebner - additionalTextEdits support
 * 
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class ContentAssistService {
  public static final int DEFAULT_PROPOSALS_LIMIT = 1000;
  
  @Inject
  private Provider<ContentAssistContextFactory> contextFactoryProvider;
  
  @Inject
  private ExecutorService executorService;
  
  @Inject
  private IdeContentProposalProvider proposalProvider;
  
  @Inject
  private Provider<IdeContentProposalAcceptor> proposalAcceptorProvider;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  public CompletionList createCompletionList(final Document document, final XtextResource resource, final TextDocumentPositionParams params, final CancelIndicator cancelIndicator) {
    try {
      final CompletionList result = new CompletionList();
      result.setIsIncomplete(true);
      final IdeContentProposalAcceptor acceptor = this.proposalAcceptorProvider.get();
      final int caretOffset = document.getOffSet(params.getPosition());
      final Position caretPosition = params.getPosition();
      final TextRegion position = new TextRegion(caretOffset, 0);
      try {
        this.createProposals(document.getContents(), position, caretOffset, resource, acceptor);
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable t = (Throwable)_t;
          boolean _isOperationCanceledException = this.operationCanceledManager.isOperationCanceledException(t);
          boolean _not = (!_isOperationCanceledException);
          if (_not) {
            throw t;
          }
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      final Procedure2<ContentAssistEntry, Integer> _function = (ContentAssistEntry it, Integer idx) -> {
        final CompletionItem item = this.toCompletionItem(it, caretOffset, caretPosition, document);
        item.setSortText(Strings.padStart(Integer.toString((idx).intValue()), 5, '0'));
        List<CompletionItem> _items = result.getItems();
        _items.add(item);
      };
      IterableExtensions.<ContentAssistEntry>forEach(acceptor.getEntries(), _function);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void createProposals(final String document, final TextRegion selection, final int caretOffset, final XtextResource resource, final IIdeContentProposalAcceptor acceptor) {
    int _length = document.length();
    boolean _greaterThan = (caretOffset > _length);
    if (_greaterThan) {
      return;
    }
    final ContentAssistContextFactory contextFactory = this.contextFactoryProvider.get();
    contextFactory.setPool(this.executorService);
    final ContentAssistContext[] contexts = contextFactory.create(document, selection, caretOffset, resource);
    this.proposalProvider.createProposals(((Collection<ContentAssistContext>)Conversions.doWrapArray(contexts)), acceptor);
  }
  
  protected CompletionItem toCompletionItem(final ContentAssistEntry entry, final int caretOffset, final Position caretPosition, final Document document) {
    final CompletionItem completionItem = new CompletionItem();
    String _elvis = null;
    String _label = entry.getLabel();
    if (_label != null) {
      _elvis = _label;
    } else {
      String _proposal = entry.getProposal();
      _elvis = _proposal;
    }
    completionItem.setLabel(_elvis);
    completionItem.setDetail(entry.getDescription());
    completionItem.setDocumentation(entry.getDocumentation());
    String _elvis_1 = null;
    String _prefix = entry.getPrefix();
    if (_prefix != null) {
      _elvis_1 = _prefix;
    } else {
      _elvis_1 = "";
    }
    int _length = _elvis_1.length();
    final int prefixOffset = (caretOffset - _length);
    final Position prefixPosition = document.getPosition(prefixOffset);
    Range _range = new Range(prefixPosition, caretPosition);
    String _proposal_1 = entry.getProposal();
    TextEdit _textEdit = new TextEdit(_range, _proposal_1);
    completionItem.setTextEdit(_textEdit);
    completionItem.setKind(this.translateKind(entry));
    boolean _isEmpty = entry.getTextReplacements().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      List<TextEdit> _additionalTextEdits = completionItem.getAdditionalTextEdits();
      boolean _tripleEquals = (_additionalTextEdits == null);
      if (_tripleEquals) {
        int _size = entry.getTextReplacements().size();
        ArrayList<TextEdit> _arrayList = new ArrayList<TextEdit>(_size);
        completionItem.setAdditionalTextEdits(_arrayList);
      }
      final Consumer<ReplaceRegion> _function = (ReplaceRegion it) -> {
        List<TextEdit> _additionalTextEdits_1 = completionItem.getAdditionalTextEdits();
        TextEdit _textEdit_1 = this.toTextEdit(it, document);
        _additionalTextEdits_1.add(_textEdit_1);
      };
      entry.getTextReplacements().forEach(_function);
    }
    String _kind = entry.getKind();
    boolean _equals = Objects.equal(_kind, ContentAssistEntry.KIND_SNIPPET);
    if (_equals) {
      completionItem.setInsertTextFormat(InsertTextFormat.Snippet);
    }
    return completionItem;
  }
  
  protected CompletionItemKind translateKind(final ContentAssistEntry entry) {
    CompletionItemKind _switchResult = null;
    String _kind = entry.getKind();
    if (_kind != null) {
      switch (_kind) {
        case ContentAssistEntry.KIND_CLASS:
          _switchResult = CompletionItemKind.Class;
          break;
        case ContentAssistEntry.KIND_COLOR:
          _switchResult = CompletionItemKind.Color;
          break;
        case ContentAssistEntry.KIND_CONSTRUCTOR:
          _switchResult = CompletionItemKind.Constructor;
          break;
        case ContentAssistEntry.KIND_ENUM:
          _switchResult = CompletionItemKind.Enum;
          break;
        case ContentAssistEntry.KIND_FIELD:
          _switchResult = CompletionItemKind.Field;
          break;
        case ContentAssistEntry.KIND_FILE:
          _switchResult = CompletionItemKind.File;
          break;
        case ContentAssistEntry.KIND_FUNCTION:
          _switchResult = CompletionItemKind.Function;
          break;
        case ContentAssistEntry.KIND_INTERFACE:
          _switchResult = CompletionItemKind.Interface;
          break;
        case ContentAssistEntry.KIND_KEYWORD:
          _switchResult = CompletionItemKind.Keyword;
          break;
        case ContentAssistEntry.KIND_METHOD:
          _switchResult = CompletionItemKind.Method;
          break;
        case ContentAssistEntry.KIND_MODULE:
          _switchResult = CompletionItemKind.Module;
          break;
        case ContentAssistEntry.KIND_PROPERTY:
          _switchResult = CompletionItemKind.Property;
          break;
        case ContentAssistEntry.KIND_REFERENCE:
          _switchResult = CompletionItemKind.Reference;
          break;
        case ContentAssistEntry.KIND_SNIPPET:
          _switchResult = CompletionItemKind.Snippet;
          break;
        case ContentAssistEntry.KIND_TEXT:
          _switchResult = CompletionItemKind.Text;
          break;
        case ContentAssistEntry.KIND_UNIT:
          _switchResult = CompletionItemKind.Unit;
          break;
        case ContentAssistEntry.KIND_VALUE:
          _switchResult = CompletionItemKind.Value;
          break;
        case ContentAssistEntry.KIND_VARIABLE:
          _switchResult = CompletionItemKind.Variable;
          break;
        default:
          _switchResult = CompletionItemKind.Value;
          break;
      }
    } else {
      _switchResult = CompletionItemKind.Value;
    }
    return _switchResult;
  }
  
  protected TextEdit toTextEdit(final ReplaceRegion region, final Document doc) {
    TextEdit _xblockexpression = null;
    {
      Position _xifexpression = null;
      int _offset = region.getOffset();
      int _length = doc.getContents().length();
      boolean _greaterThan = (_offset > _length);
      if (_greaterThan) {
        Position _xblockexpression_1 = null;
        {
          final Position docEnd = doc.getPosition(doc.getContents().length());
          int _line = docEnd.getLine();
          int _character = docEnd.getCharacter();
          int _length_1 = region.getLength();
          int _plus = (_character + _length_1);
          _xblockexpression_1 = new Position(_line, _plus);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = doc.getPosition(region.getOffset());
      }
      final Position start = _xifexpression;
      Position _xifexpression_1 = null;
      int _endOffset = region.getEndOffset();
      int _length_1 = doc.getContents().length();
      boolean _greaterThan_1 = (_endOffset > _length_1);
      if (_greaterThan_1) {
        int _line = start.getLine();
        int _character = start.getCharacter();
        int _length_2 = region.getLength();
        int _plus = (_character + _length_2);
        _xifexpression_1 = new Position(_line, _plus);
      } else {
        _xifexpression_1 = doc.getPosition(region.getEndOffset());
      }
      final Position end = _xifexpression_1;
      Range _range = new Range(start, end);
      String _text = region.getText();
      _xblockexpression = new TextEdit(_range, _text);
    }
    return _xblockexpression;
  }
}
