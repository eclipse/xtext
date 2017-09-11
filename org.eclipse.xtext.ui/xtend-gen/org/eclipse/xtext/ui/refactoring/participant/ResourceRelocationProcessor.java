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
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationStrategyExecutor;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ui.refactoring.participant.ChangeConverter;
import org.eclipse.xtext.ui.refactoring.participant.LtkIssueAcceptor;
import org.eclipse.xtext.ui.refactoring.participant.ResourceRelocationStrategyRegistry;
import org.eclipse.xtext.ui.refactoring.participant.ResourceURIConverter;
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
public class ResourceRelocationProcessor {
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
  private ResourceRelocationStrategyRegistry strategyRegistry;
  
  @Inject
  private ChangeConverter changeConverter;
  
  @Inject
  private ResourceRelocationStrategyExecutor executor;
  
  private List<ResourceRelocationChange> uriChanges = CollectionLiterals.<ResourceRelocationChange>newArrayList();
  
  private Set<IResource> excludedResources = CollectionLiterals.<IResource>newHashSet();
  
  private IProject project;
  
  public Change createChange(final String name, final IProgressMonitor pm) throws CoreException, OperationCanceledException {
    boolean _isEmpty = this.uriChanges.isEmpty();
    if (_isEmpty) {
      return null;
    }
    final ResourceSet resourceSet = this.resourceSetProvider.get(this.project);
    this.liveScopeResourceSetInitializer.initialize(resourceSet);
    final ResourceRelocationContext context = new ResourceRelocationContext(this.uriChanges, this.issues, this.changeSerializer, resourceSet);
    this.executeParticipants(context);
    final Predicate<Change> _function = (Change it) -> {
      return ((!((it instanceof MoveResourceChange) || (it instanceof RenameResourceChange))) || (!this.excludedResources.contains(it.getModifiedElement())));
    };
    this.changeConverter.initialize(name, _function, this.issues);
    this.changeSerializer.endRecordChanges(this.changeConverter);
    return this.changeConverter.getChange();
  }
  
  protected void executeParticipants(final ResourceRelocationContext context) {
    this.executor.executeParticipants(this.strategyRegistry.getStrategies(), context);
  }
  
  public void addChangedResource(final IResource resource, final IPath fromPath, final IPath toPath, final ResourceRelocationChange.Type type) {
    try {
      if ((this.project == null)) {
        this.project = resource.getProject();
      }
      boolean _isPrefixOf = fromPath.isPrefixOf(resource.getFullPath());
      if (_isPrefixOf) {
        final URI oldURI = this._resourceURIConverter.toURI(resource);
        final URI newURI = this._resourceURIConverter.toURI(toPath.append(resource.getFullPath().removeFirstSegments(fromPath.segmentCount())));
        this.excludedResources.add(resource);
        if ((resource instanceof IFile)) {
          final ResourceRelocationChange uriChange = new ResourceRelocationChange(oldURI, newURI, type, true);
          this.uriChanges.add(uriChange);
        } else {
          if ((resource instanceof IContainer)) {
            final ResourceRelocationChange uriChange_1 = new ResourceRelocationChange(oldURI, newURI, type, false);
            this.uriChanges.add(uriChange_1);
            final Consumer<IResource> _function = (IResource member) -> {
              this.addChangedResource(member, fromPath, toPath, type);
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
