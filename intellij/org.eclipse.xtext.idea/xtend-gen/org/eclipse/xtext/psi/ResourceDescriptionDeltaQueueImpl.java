package org.eclipse.xtext.psi;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.util.Alarm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.idea.resource.ProjectAwareResourceDescriptions;
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.ResourceDescriptionDeltaQueue;
import org.eclipse.xtext.psi.ResourceDescriptionEventSource;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class ResourceDescriptionDeltaQueueImpl extends ResourceDescriptionDeltaQueue {
  private final Project project;
  
  private final Alarm alarm;
  
  private final int delayMillis;
  
  private final Queue<IResourceDescription.Event> pendingChanges;
  
  private final Runnable processChangesRequest;
  
  @Inject
  private IPsiModelAssociations psiModelAssociations;
  
  @Inject
  @Extension
  private IResourceServiceProvider.Registry _registry;
  
  private final IResourceDescriptions resourceDescriptions;
  
  public ResourceDescriptionDeltaQueueImpl(final Project project) {
    Injector _injector = IdeaSharedInjectorProvider.getInjector();
    _injector.injectMembers(this);
    this.project = project;
    this.delayMillis = 500;
    Alarm _alarm = new Alarm(Alarm.ThreadToUse.POOLED_THREAD, project);
    this.alarm = _alarm;
    ConcurrentLinkedQueue<IResourceDescription.Event> _concurrentLinkedQueue = new ConcurrentLinkedQueue<IResourceDescription.Event>();
    this.pendingChanges = _concurrentLinkedQueue;
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        ResourceDescriptionDeltaQueueImpl.this.processChanges();
      }
    };
    this.processChangesRequest = _function;
    IResourceDescriptions _instance = ProjectAwareResourceDescriptions.getInstance(project);
    this.resourceDescriptions = _instance;
    IResourceDescription.Event.Source _instance_1 = ResourceDescriptionEventSource.getInstance(project);
    _instance_1.addListener(this);
  }
  
  @Override
  public void descriptionsChanged(final IResourceDescription.Event event) {
    this.pendingChanges.add(event);
    int _activeRequestCount = this.alarm.getActiveRequestCount();
    boolean _equals = (_activeRequestCount == 0);
    if (_equals) {
      this.alarm.addRequest(this.processChangesRequest, this.delayMillis);
    }
  }
  
  protected void processChanges() {
    this.alarm.cancelAllRequests();
    try {
      Application _application = ApplicationManager.getApplication();
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          Iterator<IResourceDescription.Event> _iterator = ResourceDescriptionDeltaQueueImpl.this.pendingChanges.iterator();
          final ArrayList<IResourceDescription.Event> changes = Lists.<IResourceDescription.Event>newArrayList(_iterator);
          final int count = changes.size();
          final Function1<IResourceDescription.Event, ImmutableList<IResourceDescription.Delta>> _function = new Function1<IResourceDescription.Event, ImmutableList<IResourceDescription.Delta>>() {
            @Override
            public ImmutableList<IResourceDescription.Delta> apply(final IResourceDescription.Event it) {
              return it.getDeltas();
            }
          };
          List<ImmutableList<IResourceDescription.Delta>> _map = ListExtensions.<IResourceDescription.Event, ImmutableList<IResourceDescription.Delta>>map(changes, _function);
          Iterable<IResourceDescription.Delta> _flatten = Iterables.<IResourceDescription.Delta>concat(_map);
          final List<IResourceDescription.Delta> deltas = IterableExtensions.<IResourceDescription.Delta>toList(_flatten);
          boolean _isEmpty = deltas.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            ResourceDescriptionDeltaQueueImpl.this.processDeltas(deltas);
          }
          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, count, true);
          for (final Integer i : _doubleDotLessThan) {
            ResourceDescriptionDeltaQueueImpl.this.pendingChanges.poll();
          }
        }
      };
      _application.runReadAction(_function);
    } finally {
      this.alarm.addRequest(this.processChangesRequest, this.delayMillis);
    }
  }
  
  protected void processDeltas(final Collection<IResourceDescription.Delta> pendingChanges) {
    final Collection<IResourceDescription.Delta> allDeltas = pendingChanges;
    Iterable<IResourceDescription> _allResourceDescriptions = this.resourceDescriptions.getAllResourceDescriptions();
    final Function1<IResourceDescription, URI> _function = new Function1<IResourceDescription, URI>() {
      @Override
      public URI apply(final IResourceDescription it) {
        return it.getURI();
      }
    };
    Iterable<URI> _map = IterableExtensions.<IResourceDescription, URI>map(_allResourceDescriptions, _function);
    final Set<URI> allRemainingURIs = IterableExtensions.<URI>toSet(_map);
    final Function1<IResourceDescription.Delta, URI> _function_1 = new Function1<IResourceDescription.Delta, URI>() {
      @Override
      public URI apply(final IResourceDescription.Delta it) {
        return it.getUri();
      }
    };
    Iterable<URI> _map_1 = IterableExtensions.<IResourceDescription.Delta, URI>map(allDeltas, _function_1);
    Set<URI> _set = IterableExtensions.<URI>toSet(_map_1);
    Iterables.removeAll(allRemainingURIs, _set);
    final Queue<IResourceDescription> affectedResources = CollectionLiterals.<IResourceDescription>newLinkedList();
    this.queueAffectedResources(allRemainingURIs, allDeltas, allDeltas, affectedResources);
    while ((!affectedResources.isEmpty())) {
      {
        final ArrayList<IResourceDescription.Delta> changedDeltas = CollectionLiterals.<IResourceDescription.Delta>newArrayList();
        this.invalidate(affectedResources, changedDeltas, allDeltas);
        this.queueAffectedResources(allRemainingURIs, changedDeltas, allDeltas, affectedResources);
      }
    }
  }
  
  protected void invalidate(final Queue<IResourceDescription> affectedResources, final Collection<IResourceDescription.Delta> changedDeltas, final Collection<IResourceDescription.Delta> allDeltas) {
    while ((!affectedResources.isEmpty())) {
      {
        IResourceDescription _poll = affectedResources.poll();
        final IResourceDescription.Delta delta = this.invalidate(_poll);
        boolean _notEquals = (!Objects.equal(delta, null));
        if (_notEquals) {
          allDeltas.add(delta);
          boolean _haveEObjectDescriptionsChanged = delta.haveEObjectDescriptionsChanged();
          if (_haveEObjectDescriptionsChanged) {
            changedDeltas.add(delta);
          }
        }
      }
    }
  }
  
  protected IResourceDescription.Delta invalidate(final IResourceDescription resourceDescription) {
    IResourceDescription.Delta _xblockexpression = null;
    {
      final URI resourceURI = resourceDescription.getURI();
      IResourceServiceProvider _resourceServiceProvider = this._registry.getResourceServiceProvider(resourceURI);
      IResourceDescription.Manager _resourceDescriptionManager = null;
      if (_resourceServiceProvider!=null) {
        _resourceDescriptionManager=_resourceServiceProvider.getResourceDescriptionManager();
      }
      final IResourceDescription.Manager manager = _resourceDescriptionManager;
      boolean _equals = Objects.equal(manager, null);
      if (_equals) {
        return null;
      }
      final PsiFile psiFile = this.psiModelAssociations.getPsiFile(resourceURI, this.project);
      IResourceDescription.Delta _xifexpression = null;
      if ((psiFile instanceof BaseXtextFile)) {
        IResourceDescription.Delta _xblockexpression_1 = null;
        {
          ((BaseXtextFile)psiFile).invalidate();
          final IResourceDescription newDescription = this.resourceDescriptions.getResourceDescription(resourceURI);
          _xblockexpression_1 = manager.createDelta(resourceDescription, newDescription);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected void queueAffectedResources(final Set<URI> allRemainingURIs, final Collection<IResourceDescription.Delta> changedDeltas, final Collection<IResourceDescription.Delta> allDeltas, final Queue<IResourceDescription> affectedResources) {
    boolean _isEmpty = allDeltas.isEmpty();
    if (_isEmpty) {
      return;
    }
    final Iterator<URI> i = allRemainingURIs.iterator();
    while (i.hasNext()) {
      {
        final URI candidateURI = i.next();
        final IResourceDescription candidateDescription = this.resourceDescriptions.getResourceDescription(candidateURI);
        IResourceServiceProvider _resourceServiceProvider = this._registry.getResourceServiceProvider(candidateURI);
        IResourceDescription.Manager _resourceDescriptionManager = null;
        if (_resourceServiceProvider!=null) {
          _resourceDescriptionManager=_resourceServiceProvider.getResourceDescriptionManager();
        }
        final IResourceDescription.Manager manager = _resourceDescriptionManager;
        boolean _or = false;
        boolean _equals = Objects.equal(candidateDescription, null);
        if (_equals) {
          _or = true;
        } else {
          boolean _equals_1 = Objects.equal(manager, null);
          _or = _equals_1;
        }
        if (_or) {
          i.remove();
        } else {
          boolean _xifexpression = false;
          if ((manager instanceof IResourceDescription.Manager.AllChangeAware)) {
            _xifexpression = ((IResourceDescription.Manager.AllChangeAware)manager).isAffectedByAny(allDeltas, candidateDescription, this.resourceDescriptions);
          } else {
            boolean _xifexpression_1 = false;
            boolean _isEmpty_1 = changedDeltas.isEmpty();
            if (_isEmpty_1) {
              _xifexpression_1 = false;
            } else {
              _xifexpression_1 = manager.isAffected(changedDeltas, candidateDescription, this.resourceDescriptions);
            }
            _xifexpression = _xifexpression_1;
          }
          final boolean affected = _xifexpression;
          if (affected) {
            affectedResources.add(candidateDescription);
            i.remove();
          }
        }
      }
    }
  }
}
