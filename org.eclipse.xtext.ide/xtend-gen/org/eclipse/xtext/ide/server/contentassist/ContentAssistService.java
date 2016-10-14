/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.contentassist;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import io.typefox.lsapi.CompletionItemKind;
import io.typefox.lsapi.CompletionList;
import io.typefox.lsapi.Position;
import io.typefox.lsapi.TextDocumentPositionParams;
import io.typefox.lsapi.builders.CompletionListBuilder;
import io.typefox.lsapi.impl.CompletionItemImpl;
import io.typefox.lsapi.impl.PositionImpl;
import io.typefox.lsapi.impl.RangeImpl;
import io.typefox.lsapi.impl.TextEditImpl;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
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
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class ContentAssistService {
  public final static int DEFAULT_PROPOSALS_LIMIT = 1000;
  
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
      final CompletionListBuilder result = new CompletionListBuilder();
      result.isIncomplete(true);
      final IdeContentProposalAcceptor acceptor = this.proposalAcceptorProvider.get();
      Position _position = params.getPosition();
      final int caretOffset = document.getOffSet(_position);
      Position _position_1 = params.getPosition();
      final PositionImpl caretPosition = new PositionImpl(((PositionImpl) _position_1));
      final TextRegion position = new TextRegion(caretOffset, 0);
      try {
        String _contents = document.getContents();
        this.createProposals(_contents, position, caretOffset, resource, acceptor);
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
      Iterable<ContentAssistEntry> _entries = acceptor.getEntries();
      final Procedure2<ContentAssistEntry, Integer> _function = (ContentAssistEntry it, Integer idx) -> {
        final CompletionItemImpl item = this.toCompletionItem(it, caretOffset, caretPosition, document);
        String _string = Integer.toString((idx).intValue());
        String _padStart = Strings.padStart(_string, 5, '0');
        item.setSortText(_padStart);
        result.item(item);
      };
      IterableExtensions.<ContentAssistEntry>forEach(_entries, _function);
      return result.build();
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
  
  protected CompletionItemImpl toCompletionItem(final ContentAssistEntry entry, final int caretOffset, final PositionImpl caretPosition, final Document document) {
    final CompletionItemImpl completionItem = new CompletionItemImpl();
    String _elvis = null;
    String _label = entry.getLabel();
    if (_label != null) {
      _elvis = _label;
    } else {
      String _proposal = entry.getProposal();
      _elvis = _proposal;
    }
    completionItem.setLabel(_elvis);
    String _description = entry.getDescription();
    completionItem.setDetail(_description);
    String _documentation = entry.getDocumentation();
    completionItem.setDocumentation(_documentation);
    String _elvis_1 = null;
    String _prefix = entry.getPrefix();
    if (_prefix != null) {
      _elvis_1 = _prefix;
    } else {
      _elvis_1 = "";
    }
    int _length = _elvis_1.length();
    final int prefixOffset = (caretOffset - _length);
    final PositionImpl prefixPosition = document.getPosition(prefixOffset);
    RangeImpl _rangeImpl = new RangeImpl(prefixPosition, caretPosition);
    String _proposal_1 = entry.getProposal();
    TextEditImpl _textEditImpl = new TextEditImpl(_rangeImpl, _proposal_1);
    completionItem.setTextEdit(_textEditImpl);
    CompletionItemKind _translateKind = this.translateKind(entry);
    completionItem.setKind(_translateKind);
    return completionItem;
  }
  
  protected CompletionItemKind translateKind(final ContentAssistEntry entry) {
    CompletionItemKind _switchResult = null;
    String _kind = entry.getKind();
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
    return _switchResult;
  }
}
