/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.refactoring.participant;

import com.google.common.base.Predicate;
import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.resource.MoveResourceChange;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.refactoring.MoveResourceContext;
import org.eclipse.xtext.ide.refactoring.ResourceURIChange;
import org.eclipse.xtext.ide.refactoring.XtextMoveResourceStrategy;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ui.refactoring.participant.ChangeConverter;
import org.eclipse.xtext.ui.refactoring.participant.LtkIssueAcceptor;
import org.eclipse.xtext.ui.refactoring.participant.ResourceURIConverter;
import org.eclipse.xtext.ui.refactoring.participant.XtextMoveResourceStrategyRegistry;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.LiveScopeResourceSetInitializer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public class XtextMoveResourceProcessor {
  @Inject
  private IResourceSetProvider resourceSetProvider;
  
  @Inject
  private LiveScopeResourceSetInitializer liveScopeResourceSetInitializer;
  
  @Accessors(AccessorType.PACKAGE_GETTER)
  @Inject
  private LtkIssueAcceptor issues;
  
  @Inject
  @Extension
  private ResourceURIConverter _resourceURIConverter;
  
  @Inject
  private IChangeSerializer changeSerializer;
  
  @Inject
  private XtextMoveResourceStrategyRegistry strategyRegistry;
  
  @Inject
  private ChangeConverter changeConverter;
  
  private List<ResourceURIChange> folderUriChanges = CollectionLiterals.<ResourceURIChange>newArrayList();
  
  private List<ResourceURIChange> fileUriChanges = CollectionLiterals.<ResourceURIChange>newArrayList();
  
  private Set<IResource> excludedResources = CollectionLiterals.<IResource>newHashSet();
  
  public Change createChange(final String name, final IProject project, final IProgressMonitor pm) throws CoreException, OperationCanceledException {
    if ((this.folderUriChanges.isEmpty() && this.fileUriChanges.isEmpty())) {
      return null;
    }
    final ResourceSet resourceSet = this.resourceSetProvider.get(project);
    this.liveScopeResourceSetInitializer.initialize(resourceSet);
    final MoveResourceContext moveContext = new MoveResourceContext(this.fileUriChanges, this.folderUriChanges, this.issues, this.changeSerializer, resourceSet);
    this.applyMoveStrategies(moveContext);
    final Predicate<Change> _function = (Change it) -> {
      return ((!((it instanceof MoveResourceChange) || (it instanceof RenameResourceChange))) || (!this.excludedResources.contains(it.getModifiedElement())));
    };
    this.changeConverter.initialize(name, _function, this.issues);
    this.changeSerializer.endRecordChanges(this.changeConverter);
    return this.changeConverter.getChange();
  }
  
  protected void applyMoveStrategies(final MoveResourceContext context) {
    final Consumer<XtextMoveResourceStrategy> _function = (XtextMoveResourceStrategy it) -> {
      it.applyMove(context);
    };
    this.strategyRegistry.getStrategies().forEach(_function);
    context.executeModifications();
  }
  
  public void addMovedResource(final IResource resource, final IPath oldPath, final IPath newPath) {
    try {
      boolean _isPrefixOf = oldPath.isPrefixOf(resource.getFullPath());
      if (_isPrefixOf) {
        final URI oldURI = this._resourceURIConverter.toURI(resource);
        final URI newURI = this._resourceURIConverter.toURI(newPath.append(resource.getFullPath().removeFirstSegments(oldPath.segmentCount())));
        final ResourceURIChange uriChange = new ResourceURIChange(oldURI, newURI);
        this.excludedResources.add(resource);
        if ((resource instanceof IFile)) {
          this.fileUriChanges.add(uriChange);
        } else {
          if ((resource instanceof IContainer)) {
            this.folderUriChanges.add(uriChange);
            final Consumer<IResource> _function = (IResource member) -> {
              this.addMovedResource(member, oldPath, newPath);
            };
            ((List<IResource>)Conversions.doWrapArray(((IContainer)resource).members())).forEach(_function);
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Pure
  LtkIssueAcceptor getIssues() {
    return this.issues;
  }
}
