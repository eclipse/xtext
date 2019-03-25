/**
 * Copyright (c) 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.rename;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collections;
import java.util.function.Function;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.WorkspaceEdit;
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
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.18
 */
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
  
  @Override
  public WorkspaceEdit rename(final ILanguageServerAccess access, final RenameParams renameParams, final CancelIndicator cancelIndicator) {
    try {
      WorkspaceEdit _xblockexpression = null;
      {
        final ServerRefactoringIssueAcceptor issueAcceptor = this.issueProvider.get();
        final Function<ILanguageServerAccess.Context, WorkspaceEdit> _function = (ILanguageServerAccess.Context context) -> {
          final WorkspaceEdit workspaceEdit = new WorkspaceEdit();
          final ResourceSet resourceSet = access.newLiveScopeResourceSet(context.getResource().getURI());
          final Resource xtextResource = resourceSet.getResource(context.getResource().getURI(), true);
          if ((xtextResource instanceof XtextResource)) {
            EObject element = null;
            try {
              element = this.getElementAtOffset(((XtextResource)xtextResource), context.getDocument(), renameParams.getPosition());
            } catch (final Throwable _t) {
              if (_t instanceof IndexOutOfBoundsException) {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("Invalid document position line:");
                int _line = renameParams.getPosition().getLine();
                _builder.append(_line);
                _builder.append(" column:");
                int _character = renameParams.getPosition().getCharacter();
                _builder.append(_character);
                issueAcceptor.add(
                  RefactoringIssueAcceptor.Severity.FATAL, _builder.toString());
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
            if ((((issueAcceptor.getMaximumSeverity() != RefactoringIssueAcceptor.Severity.FATAL) && (element == null)) || element.eIsProxy())) {
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("No element found at position line:");
              int _line_1 = renameParams.getPosition().getLine();
              _builder_1.append(_line_1);
              _builder_1.append(" column:");
              int _character_1 = renameParams.getPosition().getCharacter();
              _builder_1.append(_character_1);
              issueAcceptor.add(
                RefactoringIssueAcceptor.Severity.FATAL, _builder_1.toString());
            } else {
              final IResourceServiceProvider services = this.serviceProviderRegistry.getResourceServiceProvider(element.eResource().getURI());
              final IChangeSerializer changeSerializer = services.<IChangeSerializer>get(IChangeSerializer.class);
              String _newName = renameParams.getNewName();
              URI _uRI = EcoreUtil.getURI(element);
              final RenameChange change = new RenameChange(_newName, _uRI);
              final RenameContext renameContext = new RenameContext(Collections.<RenameChange>unmodifiableList(CollectionLiterals.<RenameChange>newArrayList(change)), resourceSet, changeSerializer, issueAcceptor);
              final IRenameStrategy2 renameStrategy = services.<IRenameStrategy2>get(IRenameStrategy2.class);
              renameStrategy.applyRename(renameContext);
              final ChangeConverter2.Factory converterFactory = services.<ChangeConverter2.Factory>get(ChangeConverter2.Factory.class);
              final ChangeConverter2 changeConverter = converterFactory.create(workspaceEdit, access);
              changeSerializer.applyModifications(changeConverter);
            }
          } else {
            issueAcceptor.add(RefactoringIssueAcceptor.Severity.FATAL, "Loaded resource is not an XtextResource", context.getResource().getURI());
          }
          return workspaceEdit;
        };
        _xblockexpression = access.<WorkspaceEdit>doRead(renameParams.getTextDocument().getUri(), _function).get();
      }
      return _xblockexpression;
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
}
