/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.rename;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ide.refactoring.RenameChange;
import org.eclipse.xtext.ide.refactoring.RenameContext;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.ide.server.rename.ChangeConverter;
import org.eclipse.xtext.ide.server.rename.IRenameService;
import org.eclipse.xtext.ide.server.rename.IRenameServiceExtension;
import org.eclipse.xtext.ide.server.rename.ServerRefactoringIssueAcceptor;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@Accessors(AccessorType.PROTECTED_GETTER)
@SuppressWarnings("all")
public class RenameService implements IRenameService, IRenameServiceExtension {
  @Inject
  @Extension
  private EObjectAtOffsetHelper eObjectAtOffsetHelper;
  
  @Inject
  private IRenameStrategy2 renameStrategy;
  
  @Inject
  private ChangeConverter.Factory converterFactory;
  
  @Inject
  @Extension
  private UriExtensions uriExtensions;
  
  @Inject
  private Provider<IChangeSerializer> changeSerializerProvider;
  
  @Inject
  private Provider<ServerRefactoringIssueAcceptor> issueProvider;
  
  @Inject
  private IResourceServiceProvider.Registry serviceProviderRegistry;
  
  @Inject
  private TokenUtil tokenUtil;
  
  /**
   * @deprecated use {@link #rename(WorkspaceManager, RenameParams, Options, CancelIndicator)}
   *    instead.
   */
  @Deprecated
  @Override
  public WorkspaceEdit rename(final WorkspaceManager workspaceManager, final RenameParams renameParams, final CancelIndicator cancelIndicator) {
    IRenameServiceExtension.Options _options = new IRenameServiceExtension.Options(false);
    return this.rename(workspaceManager, renameParams, _options, cancelIndicator);
  }
  
  @Override
  public WorkspaceEdit rename(final WorkspaceManager workspaceManager, final RenameParams renameParams, final IRenameServiceExtension.Options options, final CancelIndicator cancelIndicator) {
    WorkspaceEdit _xblockexpression = null;
    {
      final URI uri = this.uriExtensions.toUri(renameParams.getTextDocument().getUri());
      final ServerRefactoringIssueAcceptor issueAcceptor = this.issueProvider.get();
      final Function2<Document, XtextResource, WorkspaceEdit> _function = (Document document, XtextResource resource) -> {
        final ProjectManager projectManager = workspaceManager.getProjectManager(uri);
        final XtextResourceSet resourceSet = projectManager.createNewResourceSet(projectManager.getIndexState().getResourceDescriptions());
        resourceSet.getLoadOptions().put(ResourceDescriptionsProvider.LIVE_SCOPE, Boolean.valueOf(true));
        final WorkspaceEdit workspaceEdit = new WorkspaceEdit();
        final Resource xtextResource = resourceSet.getResource(resource.getURI(), true);
        if ((xtextResource instanceof XtextResource)) {
          final EObject element = this.getElementAtOffset(((XtextResource)xtextResource), document, renameParams.getPosition());
          if (((element == null) || element.eIsProxy())) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("No element found at position line:");
            int _line = renameParams.getPosition().getLine();
            _builder.append(_line);
            _builder.append(" column:");
            int _character = renameParams.getPosition().getCharacter();
            _builder.append(_character);
            issueAcceptor.add(
              RefactoringIssueAcceptor.Severity.FATAL, _builder.toString());
          } else {
            final IResourceServiceProvider services = this.serviceProviderRegistry.getResourceServiceProvider(element.eResource().getURI());
            final IChangeSerializer changeSerializer = services.<IChangeSerializer>get(IChangeSerializer.class);
            String _newName = renameParams.getNewName();
            URI _uRI = EcoreUtil.getURI(element);
            final RenameChange change = new RenameChange(_newName, _uRI);
            final RenameContext context = new RenameContext(Collections.<RenameChange>unmodifiableList(CollectionLiterals.<RenameChange>newArrayList(change)), resourceSet, changeSerializer, issueAcceptor);
            final IRenameStrategy2 renameStrategy = services.<IRenameStrategy2>get(IRenameStrategy2.class);
            renameStrategy.applyRename(context);
            final ChangeConverter.Factory converterFactory = services.<ChangeConverter.Factory>get(ChangeConverter.Factory.class);
            final ChangeConverter changeConverter = converterFactory.create(workspaceManager, workspaceEdit, options);
            changeSerializer.applyModifications(changeConverter);
          }
        } else {
          issueAcceptor.add(RefactoringIssueAcceptor.Severity.FATAL, "Loaded resource is not an XtextResource", resource.getURI());
        }
        return workspaceEdit;
      };
      _xblockexpression = workspaceManager.<WorkspaceEdit>doRead(uri, _function);
    }
    return _xblockexpression;
  }
  
  protected EObject getElementAtOffset(final XtextResource xtextResource, final Document document, final Position caretPosition) {
    final int caretOffset = document.getOffSet(caretPosition);
    final ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(xtextResource.getParseResult().getRootNode(), caretOffset);
    int _xifexpression = (int) 0;
    if ((((caretOffset > 0) && (leafNode.getOffset() == caretOffset)) && (!this.isIdentifier(leafNode)))) {
      _xifexpression = (caretOffset - 1);
    } else {
      _xifexpression = caretOffset;
    }
    final int offset = _xifexpression;
    return this.eObjectAtOffsetHelper.resolveElementAt(xtextResource, offset);
  }
  
  protected boolean isIdentifier(final ILeafNode leafNode) {
    return ((leafNode.getGrammarElement() instanceof TerminalRule) && (!this.tokenUtil.isWhitespaceOrCommentNode(leafNode)));
  }
  
  @Pure
  protected EObjectAtOffsetHelper getEObjectAtOffsetHelper() {
    return this.eObjectAtOffsetHelper;
  }
  
  @Pure
  protected IRenameStrategy2 getRenameStrategy() {
    return this.renameStrategy;
  }
  
  @Pure
  protected ChangeConverter.Factory getConverterFactory() {
    return this.converterFactory;
  }
  
  @Pure
  protected UriExtensions getUriExtensions() {
    return this.uriExtensions;
  }
  
  @Pure
  protected Provider<IChangeSerializer> getChangeSerializerProvider() {
    return this.changeSerializerProvider;
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
