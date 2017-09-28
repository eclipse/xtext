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
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.refactoring.IRenameStrategy;
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
import org.eclipse.xtext.ide.server.rename.ServerRefactoringIssueAcceptor;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

/**
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class RenameService implements IRenameService {
  @Inject
  @Extension
  private EObjectAtOffsetHelper _eObjectAtOffsetHelper;
  
  @Inject
  private IRenameStrategy renameStrategy;
  
  @Inject
  private ChangeConverter.Factory converterFactory;
  
  @Inject
  @Extension
  private UriExtensions _uriExtensions;
  
  @Inject
  private Provider<IChangeSerializer> changeSerializerProvider;
  
  @Inject
  private Provider<ServerRefactoringIssueAcceptor> issueProvider;
  
  @Override
  public WorkspaceEdit rename(final WorkspaceManager workspaceManager, final RenameParams renameParams, final CancelIndicator cancelIndicator) {
    WorkspaceEdit _xblockexpression = null;
    {
      final URI uri = this._uriExtensions.toUri(renameParams.getTextDocument().getUri());
      final ServerRefactoringIssueAcceptor issueAcceptor = this.issueProvider.get();
      final Function2<Document, XtextResource, WorkspaceEdit> _function = (Document document, XtextResource resource) -> {
        final ProjectManager projectManager = workspaceManager.getProjectManager(uri);
        final XtextResourceSet resourceSet = projectManager.createNewResourceSet(projectManager.getIndexState().getResourceDescriptions());
        final int offset = document.getOffSet(renameParams.getPosition());
        final WorkspaceEdit workspaceEdit = new WorkspaceEdit();
        final Resource xtextResource = resourceSet.getResource(resource.getURI(), true);
        if ((xtextResource instanceof XtextResource)) {
          final EObject element = this._eObjectAtOffsetHelper.resolveElementAt(((XtextResource)xtextResource), offset);
          if ((element == null)) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("No element found at position line:");
            int _line = renameParams.getPosition().getLine();
            _builder.append(_line);
            _builder.append(" column:");
            int _character = renameParams.getPosition().getCharacter();
            _builder.append(_character);
            issueAcceptor.add(RefactoringIssueAcceptor.Severity.FATAL, _builder.toString());
          }
          String _newName = renameParams.getNewName();
          URI _uRI = EcoreUtil.getURI(element);
          final RenameChange change = new RenameChange(_newName, _uRI);
          final IChangeSerializer changeSerializer = this.changeSerializerProvider.get();
          final RenameContext context = new RenameContext(Collections.<RenameChange>unmodifiableList(CollectionLiterals.<RenameChange>newArrayList(change)), resourceSet, changeSerializer, issueAcceptor);
          this.renameStrategy.loadAndWatchResources(context);
          this.renameStrategy.applyRename(context);
          this.renameStrategy.applySideEffects(context);
          final ChangeConverter changeConverter = this.converterFactory.create(workspaceManager, workspaceEdit);
          changeSerializer.endRecordChanges(changeConverter);
        } else {
          issueAcceptor.add(RefactoringIssueAcceptor.Severity.FATAL, "Loaded resource is not an XtextResource", resource.getURI());
        }
        return workspaceEdit;
      };
      _xblockexpression = workspaceManager.<WorkspaceEdit>doRead(uri, _function);
    }
    return _xblockexpression;
  }
}
