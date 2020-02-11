/**
 * Copyright (c) 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.rename;

import com.google.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.ResourceOperation;
import org.eclipse.lsp4j.TextDocumentEdit;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.lsp4j.WorkspaceClientCapabilities;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.WorkspaceEditCapabilities;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.ITextDocumentChange;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.18
 */
@SuppressWarnings("all")
public class ChangeConverter2 implements IAcceptor<IEmfResourceChange> {
  public static class Factory {
    @Inject
    protected IResourceServiceProvider.Registry registry;
    
    @Inject
    protected UriExtensions uriExtensions;
    
    /**
     * @since 2.18
     */
    public ChangeConverter2 create(final WorkspaceEdit edit, final ILanguageServerAccess access) {
      return new ChangeConverter2(this.registry, edit, access, this.uriExtensions);
    }
  }
  
  private final IResourceServiceProvider.Registry registry;
  
  @Extension
  private final UriExtensions uriExtensions;
  
  private final WorkspaceEdit edit;
  
  private final ILanguageServerAccess access;
  
  private final boolean useDocumentChanges;
  
  protected ChangeConverter2(final IResourceServiceProvider.Registry registry, final WorkspaceEdit edit, final ILanguageServerAccess access, final UriExtensions uriExtensions) {
    this.registry = registry;
    this.uriExtensions = uriExtensions;
    this.edit = edit;
    this.access = access;
    InitializeParams _initializeParams = null;
    if (access!=null) {
      _initializeParams=access.getInitializeParams();
    }
    ClientCapabilities _capabilities = null;
    if (_initializeParams!=null) {
      _capabilities=_initializeParams.getCapabilities();
    }
    WorkspaceClientCapabilities _workspace = null;
    if (_capabilities!=null) {
      _workspace=_capabilities.getWorkspace();
    }
    WorkspaceEditCapabilities _workspaceEdit = null;
    if (_workspace!=null) {
      _workspaceEdit=_workspace.getWorkspaceEdit();
    }
    Boolean _documentChanges = null;
    if (_workspaceEdit!=null) {
      _documentChanges=_workspaceEdit.getDocumentChanges();
    }
    boolean _tripleEquals = (_documentChanges == Boolean.TRUE);
    this.useDocumentChanges = _tripleEquals;
    if (this.useDocumentChanges) {
      this.edit.setDocumentChanges(CollectionLiterals.<Either<TextDocumentEdit, ResourceOperation>>newArrayList());
    } else {
      this.edit.setChanges(CollectionLiterals.<String, List<TextEdit>>newLinkedHashMap());
    }
  }
  
  @Override
  public void accept(final IEmfResourceChange change) {
    this.handleReplacements(change);
  }
  
  protected void _handleReplacements(final IEmfResourceChange change) {
    try {
      final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      final String uri = this.uriExtensions.toUriString(change.getResource().getURI());
      change.getResource().save(outputStream, null);
      byte[] _byteArray = outputStream.toByteArray();
      String _charset = this.getCharset(change.getResource());
      final String newContent = new String(_byteArray, _charset);
      final Function<ILanguageServerAccess.Context, Object> _function = (ILanguageServerAccess.Context context) -> {
        Object _xblockexpression = null;
        {
          final Document document = context.getDocument();
          Position _position = document.getPosition(0);
          Position _position_1 = document.getPosition(document.getContents().length());
          final Range range = new Range(_position, _position_1);
          final TextEdit textEdit = new TextEdit(range, newContent);
          _xblockexpression = this.addTextEdit(uri, document, textEdit);
        }
        return _xblockexpression;
      };
      this.access.<Object>doRead(uri, _function).get();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String getCharset(final Resource resource) {
    String _xblockexpression = null;
    {
      final IEncodingProvider xtextEncodingProvider = this.registry.getResourceServiceProvider(resource.getURI()).<IEncodingProvider>get(IEncodingProvider.class);
      String _xifexpression = null;
      if ((xtextEncodingProvider != null)) {
        return xtextEncodingProvider.getEncoding(resource.getURI());
      } else {
        String _xifexpression_1 = null;
        if ((resource instanceof XMLResource)) {
          _xifexpression_1 = ((XMLResource)resource).getEncoding();
        } else {
          _xifexpression_1 = Charset.defaultCharset().toString();
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected void _handleReplacements(final ITextDocumentChange change) {
    try {
      int _size = change.getReplacements().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        final String uri = this.uriExtensions.toUriString(change.getNewURI());
        final Function<ILanguageServerAccess.Context, Object> _function = (ILanguageServerAccess.Context context) -> {
          Object _xblockexpression = null;
          {
            final Document document = context.getDocument();
            final Function1<ITextReplacement, TextEdit> _function_1 = (ITextReplacement replacement) -> {
              TextEdit _xblockexpression_1 = null;
              {
                final Position start = document.getPosition(replacement.getOffset());
                int _offset = replacement.getOffset();
                int _length = replacement.getLength();
                int _plus = (_offset + _length);
                final Position end = document.getPosition(_plus);
                final Range range = new Range(start, end);
                String _replacementText = replacement.getReplacementText();
                _xblockexpression_1 = new TextEdit(range, _replacementText);
              }
              return _xblockexpression_1;
            };
            final List<TextEdit> textEdits = ListExtensions.<ITextReplacement, TextEdit>map(change.getReplacements(), _function_1);
            _xblockexpression = this.addTextEdit(uri, document, ((TextEdit[])Conversions.unwrapArray(textEdits, TextEdit.class)));
          }
          return _xblockexpression;
        };
        this.access.<Object>doRead(uri, _function).get();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Object addTextEdit(final String theUri, final Document document, final TextEdit... textEdits) {
    Object _xifexpression = null;
    if (this.useDocumentChanges) {
      List<Either<TextDocumentEdit, ResourceOperation>> _documentChanges = this.edit.getDocumentChanges();
      TextDocumentEdit _textDocumentEdit = new TextDocumentEdit();
      final Procedure1<TextDocumentEdit> _function = (TextDocumentEdit it) -> {
        VersionedTextDocumentIdentifier _versionedTextDocumentIdentifier = new VersionedTextDocumentIdentifier();
        final Procedure1<VersionedTextDocumentIdentifier> _function_1 = (VersionedTextDocumentIdentifier it_1) -> {
          it_1.setUri(theUri);
          it_1.setVersion(document.getVersion());
        };
        VersionedTextDocumentIdentifier _doubleArrow = ObjectExtensions.<VersionedTextDocumentIdentifier>operator_doubleArrow(_versionedTextDocumentIdentifier, _function_1);
        it.setTextDocument(_doubleArrow);
        it.setEdits(((List<TextEdit>)Conversions.doWrapArray(textEdits)));
      };
      TextDocumentEdit _doubleArrow = ObjectExtensions.<TextDocumentEdit>operator_doubleArrow(_textDocumentEdit, _function);
      Either<TextDocumentEdit, ResourceOperation> _forLeft = Either.<TextDocumentEdit, ResourceOperation>forLeft(_doubleArrow);
      _xifexpression = Boolean.valueOf(_documentChanges.add(_forLeft));
    } else {
      _xifexpression = this.edit.getChanges().put(theUri, ((List<TextEdit>)Conversions.doWrapArray(textEdits)));
    }
    return _xifexpression;
  }
  
  protected void handleReplacements(final IEmfResourceChange change) {
    if (change instanceof ITextDocumentChange) {
      _handleReplacements((ITextDocumentChange)change);
      return;
    } else if (change != null) {
      _handleReplacements(change);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(change).toString());
    }
  }
}
