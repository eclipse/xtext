/**
 * Copyright (c) 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.rename;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Throwables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.FileNotFoundException;
import java.util.Collections;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.PrepareRenameResult;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.RenameOptions;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.util.Ranges;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ide.refactoring.RenameChange;
import org.eclipse.xtext.ide.refactoring.RenameContext;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.rename.ChangeConverter2;
import org.eclipse.xtext.ide.server.rename.IRenameService2;
import org.eclipse.xtext.ide.server.rename.ServerRefactoringIssueAcceptor;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.18
 */
@Log
@Accessors(AccessorType.PROTECTED_GETTER)
@SuppressWarnings("all")
public class RenameService2 implements IRenameService2 {
  @Inject
  @Extension
  private EObjectAtOffsetHelper eObjectAtOffsetHelper;
  
  @Inject
  private Provider<ServerRefactoringIssueAcceptor> issueProvider;
  
  @Inject
  private IResourceServiceProvider.Registry serviceProviderRegistry;
  
  @Inject
  private TokenUtil tokenUtil;
  
  private Function<EObject, String> attributeResolver = SimpleAttributeResolver.<EObject, String>newResolver(String.class, "name");
  
  @Override
  public WorkspaceEdit rename(final IRenameService2.Options options) {
    try {
      final TextDocumentIdentifier textDocument = options.getRenameParams().getTextDocument();
      final String uri = textDocument.getUri();
      final ServerRefactoringIssueAcceptor issueAcceptor = this.issueProvider.get();
      final boolean shouldPrepareRename = this.shouldPrepareRename(options.getLanguageServerAccess());
      final java.util.function.Function<ILanguageServerAccess.Context, WorkspaceEdit> _function = (ILanguageServerAccess.Context context) -> {
        if (shouldPrepareRename) {
          String _uri = textDocument.getUri();
          final TextDocumentIdentifier identifier = new TextDocumentIdentifier(_uri);
          final Position position = options.getRenameParams().getPosition();
          final TextDocumentPositionParams positionParams = new TextDocumentPositionParams(identifier, position);
          final Resource resource = context.getResource();
          final Document document = context.getDocument();
          final CancelIndicator cancelIndicator = options.getCancelIndicator();
          final Either<Range, PrepareRenameResult> prepareRenameResult = this.doPrepareRename(resource, document, positionParams, cancelIndicator);
          boolean _mayPerformRename = this.mayPerformRename(prepareRenameResult, options.getRenameParams());
          boolean _not = (!_mayPerformRename);
          if (_not) {
            return null;
          }
        }
        final WorkspaceEdit workspaceEdit = new WorkspaceEdit();
        final ResourceSet resourceSet = options.getLanguageServerAccess().newLiveScopeResourceSet(context.getResource().getURI());
        final Resource xtextResource = resourceSet.getResource(context.getResource().getURI(), true);
        if ((xtextResource instanceof XtextResource)) {
          final Position position_1 = options.getRenameParams().getPosition();
          EObject element = null;
          try {
            element = this.getElementAtOffset(((XtextResource)xtextResource), context.getDocument(), position_1);
          } catch (final Throwable _t) {
            if (_t instanceof IndexOutOfBoundsException) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Invalid document ");
              String _positionFragment = this.toPositionFragment(position_1, uri);
              _builder.append(_positionFragment);
              issueAcceptor.add(RefactoringIssueAcceptor.Severity.FATAL, _builder.toString());
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          if (((element == null) || element.eIsProxy())) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("No element found at ");
            String _positionFragment = this.toPositionFragment(position_1, uri);
            _builder.append(_positionFragment);
            issueAcceptor.add(RefactoringIssueAcceptor.Severity.FATAL, _builder.toString());
          } else {
            final IResourceServiceProvider services = this.serviceProviderRegistry.getResourceServiceProvider(element.eResource().getURI());
            final IChangeSerializer changeSerializer = services.<IChangeSerializer>get(IChangeSerializer.class);
            String _newName = options.getRenameParams().getNewName();
            URI _uRI = EcoreUtil.getURI(element);
            final RenameChange change = new RenameChange(_newName, _uRI);
            final RenameContext renameContext = new RenameContext(Collections.<RenameChange>unmodifiableList(CollectionLiterals.<RenameChange>newArrayList(change)), resourceSet, changeSerializer, issueAcceptor);
            final IRenameStrategy2 renameStrategy = services.<IRenameStrategy2>get(IRenameStrategy2.class);
            renameStrategy.applyRename(renameContext);
            final ChangeConverter2.Factory converterFactory = services.<ChangeConverter2.Factory>get(ChangeConverter2.Factory.class);
            final ChangeConverter2 changeConverter = converterFactory.create(workspaceEdit, options.getLanguageServerAccess());
            changeSerializer.applyModifications(changeConverter);
          }
        } else {
          issueAcceptor.add(RefactoringIssueAcceptor.Severity.FATAL, "Loaded resource is not an XtextResource", context.getResource().getURI());
        }
        issueAcceptor.checkSeverity();
        return workspaceEdit;
      };
      final java.util.function.Function<Throwable, WorkspaceEdit> _function_1 = (Throwable exception) -> {
        try {
          final Throwable rootCause = Throwables.getRootCause(exception);
          if ((rootCause instanceof FileNotFoundException)) {
            if (shouldPrepareRename) {
              return null;
            }
          }
          throw exception;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      return options.getLanguageServerAccess().<WorkspaceEdit>doRead(uri, _function).exceptionally(_function_1).get();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected EObject getElementAtOffset(final XtextResource xtextResource, final Document document, final Position caretPosition) {
    final int caretOffset = document.getOffSet(caretPosition);
    EObject _elvis = null;
    EObject _elementWithIdentifierAt = this.getElementWithIdentifierAt(xtextResource, caretOffset);
    if (_elementWithIdentifierAt != null) {
      _elvis = _elementWithIdentifierAt;
    } else {
      EObject _elementWithIdentifierAt_1 = this.getElementWithIdentifierAt(xtextResource, (caretOffset - 1));
      _elvis = _elementWithIdentifierAt_1;
    }
    return _elvis;
  }
  
  protected EObject getElementWithIdentifierAt(final XtextResource xtextResource, final int offset) {
    if ((offset >= 0)) {
      IParseResult _parseResult = null;
      if (xtextResource!=null) {
        _parseResult=xtextResource.getParseResult();
      }
      ICompositeNode _rootNode = null;
      if (_parseResult!=null) {
        _rootNode=_parseResult.getRootNode();
      }
      final ICompositeNode rootNode = _rootNode;
      if ((rootNode != null)) {
        final ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset);
        if (((leaf != null) && this.isIdentifier(leaf))) {
          return this.eObjectAtOffsetHelper.resolveElementAt(xtextResource, offset);
        }
      }
    }
    return null;
  }
  
  protected boolean isIdentifier(final ILeafNode leafNode) {
    return (((leafNode.getGrammarElement() instanceof RuleCall) || (leafNode.getGrammarElement() instanceof CrossReference)) && (!this.tokenUtil.isWhitespaceOrCommentNode(leafNode)));
  }
  
  @Override
  public Either<Range, PrepareRenameResult> prepareRename(final IRenameService2.PrepareRenameOptions options) {
    try {
      final String uri = options.getParams().getTextDocument().getUri();
      final boolean shouldPrepareRename = this.shouldPrepareRename(options.getLanguageServerAccess());
      final java.util.function.Function<ILanguageServerAccess.Context, Either<Range, PrepareRenameResult>> _function = (ILanguageServerAccess.Context context) -> {
        if ((!shouldPrepareRename)) {
          return null;
        }
        final Resource resource = context.getResource();
        final Document document = context.getDocument();
        final TextDocumentPositionParams params = options.getParams();
        final CancelIndicator cancelIndicator = options.getCancelIndicator();
        return this.doPrepareRename(resource, document, params, cancelIndicator);
      };
      final java.util.function.Function<Throwable, Either<Range, PrepareRenameResult>> _function_1 = (Throwable exception) -> {
        try {
          final Throwable rootCause = Throwables.getRootCause(exception);
          if ((rootCause instanceof FileNotFoundException)) {
            if (shouldPrepareRename) {
              return null;
            }
          }
          throw exception;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      return options.getLanguageServerAccess().<Either<Range, PrepareRenameResult>>doRead(uri, _function).exceptionally(_function_1).get();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Either<Range, PrepareRenameResult> doPrepareRename(final Resource resource, final Document document, final TextDocumentPositionParams params, final CancelIndicator cancelIndicator) {
    final String uri = params.getTextDocument().getUri();
    if ((resource instanceof XtextResource)) {
      IParseResult _parseResult = null;
      if (((XtextResource)resource)!=null) {
        _parseResult=((XtextResource)resource).getParseResult();
      }
      ICompositeNode _rootNode = null;
      if (_parseResult!=null) {
        _rootNode=_parseResult.getRootNode();
      }
      final ICompositeNode rootNode = _rootNode;
      if ((rootNode == null)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Could not retrieve root node for resource. URI: ");
        _builder.append(uri);
        _builder.append(".");
        RenameService2.LOG.trace(_builder);
        return null;
      }
      final Position caretPosition = params.getPosition();
      try {
        final int caretOffset = document.getOffSet(caretPosition);
        EObject element = null;
        int candidateOffset = caretOffset;
        do {
          {
            element = this.getElementWithIdentifierAt(((XtextResource)resource), candidateOffset);
            if (((element != null) && (!element.eIsProxy()))) {
              final ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, candidateOffset);
              if (((leaf != null) && this.isIdentifier(leaf))) {
                final String leafText = NodeModelUtils.getTokenText(leaf);
                final String elementName = this.getElementName(element);
                if ((((!StringExtensions.isNullOrEmpty(leafText)) && (!StringExtensions.isNullOrEmpty(elementName))) && Objects.equal(leafText, elementName))) {
                  final Position start = document.getPosition(leaf.getOffset());
                  int _offset = leaf.getOffset();
                  int _length = elementName.length();
                  int _plus = (_offset + _length);
                  final Position end = document.getPosition(_plus);
                  Range _range = new Range(start, end);
                  return Either.<Range, PrepareRenameResult>forLeft(_range);
                }
              }
            }
            candidateOffset = (candidateOffset - 1);
          }
        } while(((candidateOffset >= 0) && ((candidateOffset + 1) >= caretOffset)));
      } catch (final Throwable _t) {
        if (_t instanceof IndexOutOfBoundsException) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Invalid document ");
          String _positionFragment = this.toPositionFragment(caretPosition, uri);
          _builder_1.append(_positionFragment);
          RenameService2.LOG.trace(_builder_1);
          return null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("No element found at ");
      String _positionFragment = this.toPositionFragment(caretPosition, uri);
      _builder_1.append(_positionFragment);
      RenameService2.LOG.trace(_builder_1);
    } else {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Loaded resource is not an XtextResource. URI: ");
      URI _uRI = resource.getURI();
      _builder_2.append(_uRI);
      RenameService2.LOG.trace(_builder_2);
    }
    return null;
  }
  
  /**
   * If this method returns {@code false}, it is sure, that the rename operation will fail.
   * There is no guarantee that it will succeed even if it returns {@code true}.
   */
  protected boolean mayPerformRename(final Either<Range, PrepareRenameResult> prepareRenameResult, final RenameParams renameParams) {
    return (((prepareRenameResult != null) && (prepareRenameResult.getLeft() != null)) && 
      Ranges.containsPosition(prepareRenameResult.getLeft(), renameParams.getPosition()));
  }
  
  /**
   * Tries to read the {@code name} {@link EAttribute} from the
   * the given {@code element}.
   * 
   * It never returns an empty string, but a {@code null} instead.
   */
  protected String getElementName(final EObject element) {
    if ((element == null)) {
      return null;
    }
    final String name = this.attributeResolver.apply(element);
    String _xifexpression = null;
    boolean _isEmpty = Strings.isEmpty(name);
    if (_isEmpty) {
      _xifexpression = null;
    } else {
      _xifexpression = name;
    }
    return _xifexpression;
  }
  
  private String toPositionFragment(final Position it, final String uri) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("position line: ");
    int _line = it.getLine();
    _builder.append(_line);
    _builder.append(" column: ");
    int _character = it.getCharacter();
    _builder.append(_character);
    _builder.append(" in resource: ");
    _builder.append(uri);
    return _builder.toString();
  }
  
  private boolean shouldPrepareRename(final ILanguageServerAccess access) {
    InitializeResult _initializeResult = null;
    if (access!=null) {
      _initializeResult=access.getInitializeResult();
    }
    ServerCapabilities _capabilities = null;
    if (_initializeResult!=null) {
      _capabilities=_initializeResult.getCapabilities();
    }
    Either<Boolean, RenameOptions> _renameProvider = null;
    if (_capabilities!=null) {
      _renameProvider=_capabilities.getRenameProvider();
    }
    final Either<Boolean, RenameOptions> provider = _renameProvider;
    boolean _xifexpression = false;
    if (((provider != null) && provider.isRight())) {
      Boolean _prepareProvider = provider.getRight().getPrepareProvider();
      _xifexpression = Objects.equal(Boolean.TRUE, _prepareProvider);
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
  
  private static final Logger LOG = Logger.getLogger(RenameService2.class);
  
  @Pure
  protected EObjectAtOffsetHelper getEObjectAtOffsetHelper() {
    return this.eObjectAtOffsetHelper;
  }
  
  @Pure
  protected Provider<ServerRefactoringIssueAcceptor> getIssueProvider() {
    return this.issueProvider;
  }
  
  @Pure
  protected IResourceServiceProvider.Registry getServiceProviderRegistry() {
    return this.serviceProviderRegistry;
  }
  
  @Pure
  protected TokenUtil getTokenUtil() {
    return this.tokenUtil;
  }
  
  @Pure
  protected Function<EObject, String> getAttributeResolver() {
    return this.attributeResolver;
  }
}
