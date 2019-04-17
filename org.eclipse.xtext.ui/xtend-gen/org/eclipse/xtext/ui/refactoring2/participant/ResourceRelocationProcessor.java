/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.refactoring2.participant;

import com.google.common.base.Predicate;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.resource.MoveResourceChange;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.refactoring.IResourceRelocationStrategy;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ui.refactoring2.ChangeConverter;
import org.eclipse.xtext.ui.refactoring2.LtkIssueAcceptor;
import org.eclipse.xtext.ui.refactoring2.ResourceURIConverter;
import org.eclipse.xtext.ui.refactoring2.participant.ResourceRelocationStrategyRegistry;
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
  private static final Logger LOG = Logger.getLogger(ResourceRelocationProcessor.class);
  
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
  private Provider<IChangeSerializer> changeSerializerProvider;
  
  @Inject
  private ResourceRelocationStrategyRegistry strategyRegistry;
  
  @Inject
  private ChangeConverter.Factory changeConverterFactory;
  
  private List<ResourceRelocationChange> uriChanges = CollectionLiterals.<ResourceRelocationChange>newArrayList();
  
  private Set<IResource> excludedResources = CollectionLiterals.<IResource>newHashSet();
  
  private IProject project;
  
  public Change createChange(final String name, final ResourceRelocationContext.ChangeType type, final IProgressMonitor pm) throws CoreException, OperationCanceledException {
    boolean _isEmpty = this.uriChanges.isEmpty();
    if (_isEmpty) {
      return null;
    }
    final SubMonitor subMonitor = SubMonitor.convert(pm);
    subMonitor.beginTask("Preparing the refactoring...", 5);
    final IChangeSerializer changeSerializer = this.changeSerializerProvider.get();
    final ResourceSet resourceSet = this.resourceSetProvider.get(this.project);
    this.liveScopeResourceSetInitializer.initialize(resourceSet);
    final ResourceRelocationContext context = new ResourceRelocationContext(type, this.uriChanges, this.issues, changeSerializer, resourceSet);
    this.executeParticipants(context, subMonitor.split(1));
    final Predicate<Change> _function = (Change it) -> {
      return ((!((it instanceof MoveResourceChange) || (it instanceof RenameResourceChange))) || (!this.excludedResources.contains(it.getModifiedElement())));
    };
    final ChangeConverter changeConverter = this.changeConverterFactory.create(name, _function, this.issues);
    final SubMonitor modificationApplicationMonitor = subMonitor.split(4);
    changeSerializer.setProgressMonitor(modificationApplicationMonitor);
    changeSerializer.applyModifications(changeConverter);
    modificationApplicationMonitor.done();
    return changeConverter.getChange();
  }
  
  protected void executeParticipants(final ResourceRelocationContext context, final SubMonitor monitor) {
    final List<? extends IResourceRelocationStrategy> strategies = this.strategyRegistry.getStrategies();
    ResourceRelocationContext.ChangeType _changeType = context.getChangeType();
    boolean _tripleEquals = (_changeType == ResourceRelocationContext.ChangeType.COPY);
    if (_tripleEquals) {
      IChangeSerializer _changeSerializer = context.getChangeSerializer();
      _changeSerializer.setUpdateRelatedFiles(false);
    }
    monitor.setWorkRemaining(strategies.size());
    final Consumer<IResourceRelocationStrategy> _function = (IResourceRelocationStrategy it) -> {
      try {
        monitor.split(1);
        it.applyChange(context);
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable t = (Throwable)_t;
          this.issues.add(RefactoringIssueAcceptor.Severity.ERROR, "Error applying resource changes", t);
          ResourceRelocationProcessor.LOG.error(t.getMessage(), t);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    };
    strategies.forEach(_function);
  }
  
  public void addChangedResource(final IResource resource, final IPath fromPath, final IPath toPath) {
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
          final ResourceRelocationChange uriChange = new ResourceRelocationChange(oldURI, newURI, true);
          this.uriChanges.add(uriChange);
        } else {
          if ((resource instanceof IContainer)) {
            final ResourceRelocationChange uriChange_1 = new ResourceRelocationChange(oldURI, newURI, false);
            this.uriChanges.add(uriChange_1);
            final Consumer<IResource> _function = (IResource member) -> {
              this.addChangedResource(member, fromPath, toPath);
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
