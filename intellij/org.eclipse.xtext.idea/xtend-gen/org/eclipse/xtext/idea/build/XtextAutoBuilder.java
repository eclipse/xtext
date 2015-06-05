/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build;

import com.google.common.base.Objects;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.progress.ProcessCanceledException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.OrderEnumerator;
import com.intellij.openapi.roots.OrderRootsEnumerator;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.Alarm;
import com.intellij.util.PathsList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;
import org.eclipse.xtext.builder.standalone.incremental.IncrementalBuilder;
import org.eclipse.xtext.builder.standalone.incremental.IndexState;
import org.eclipse.xtext.idea.build.BuildEvent;
import org.eclipse.xtext.idea.build.BuildProgressReporter;
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider;
import org.eclipse.xtext.idea.shared.XtextLanguages;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Log
@SuppressWarnings("all")
public class XtextAutoBuilder {
  private BlockingQueue<BuildEvent> queue = new LinkedBlockingQueue<BuildEvent>();
  
  private Alarm alarm;
  
  private Project project;
  
  @Inject
  private Provider<IncrementalBuilder> builderProvider;
  
  @Inject
  private Provider<BuildProgressReporter> buildProgressReporterProvider;
  
  @Inject
  private XtextLanguages xtextLanguages;
  
  @Inject
  private IdeaResourceSetProvider resourceSetProvider;
  
  private IndexState indexState;
  
  public XtextAutoBuilder(final Project project) {
    Injector _injector = IdeaSharedInjectorProvider.getInjector();
    _injector.injectMembers(this);
    this.project = project;
    Alarm _alarm = new Alarm(Alarm.ThreadToUse.OWN_THREAD, project);
    this.alarm = _alarm;
  }
  
  public void fileModified(final VirtualFile file) {
    this.enqueue(file, BuildEvent.Type.MODIFIED);
  }
  
  public void fileDeleted(final VirtualFile file) {
    this.enqueue(file, BuildEvent.Type.DELETED);
  }
  
  public void fileAdded(final VirtualFile file) {
    this.enqueue(file, BuildEvent.Type.ADDED);
  }
  
  protected void enqueue(final VirtualFile file, final BuildEvent.Type type) {
    try {
      boolean _isLoaded = this.isLoaded();
      boolean _not = (!_isLoaded);
      if (_not) {
        this.queueAllResources();
      }
      boolean _isDebugEnabled = XtextAutoBuilder.LOG.isDebugEnabled();
      if (_isDebugEnabled) {
        URI _uRI = VirtualFileURIUtil.getURI(file);
        String _plus = ("queuing " + _uRI);
        XtextAutoBuilder.LOG.debug(_plus);
      }
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(file, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _isDisposed = this.project.isDisposed();
        boolean _not_1 = (!_isDisposed);
        _and = _not_1;
      }
      if (_and) {
        BuildEvent _buildEvent = new BuildEvent(file, type);
        this.queue.put(_buildEvent);
        this.alarm.cancelAllRequests();
        final Runnable _function = new Runnable() {
          @Override
          public void run() {
            XtextAutoBuilder.this.build();
          }
        };
        this.alarm.addRequest(_function, 200);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected boolean isLoaded() {
    boolean _or = false;
    boolean _notEquals = (!Objects.equal(this.indexState, null));
    if (_notEquals) {
      _or = true;
    } else {
      boolean _isEmpty = this.queue.isEmpty();
      boolean _not = (!_isEmpty);
      _or = _not;
    }
    if (_or) {
      return true;
    }
    return false;
  }
  
  protected void queueAllResources() {
    final VirtualFile baseFile = this.project.getBaseDir();
    final Procedure1<VirtualFile> _function = new Procedure1<VirtualFile>() {
      @Override
      public void apply(final VirtualFile file) {
        try {
          boolean _and = false;
          boolean _isDirectory = file.isDirectory();
          boolean _not = (!_isDirectory);
          if (!_not) {
            _and = false;
          } else {
            boolean _exists = file.exists();
            _and = _exists;
          }
          if (_and) {
            BuildEvent _buildEvent = new BuildEvent(file, BuildEvent.Type.ADDED);
            XtextAutoBuilder.this.queue.put(_buildEvent);
          }
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    this.visitFileTree(baseFile, _function);
  }
  
  public void visitFileTree(final VirtualFile file, final Procedure1<? super VirtualFile> handler) {
    boolean _isDirectory = file.isDirectory();
    if (_isDirectory) {
      VirtualFile[] _children = file.getChildren();
      for (final VirtualFile child : _children) {
        this.visitFileTree(child, handler);
      }
    }
    handler.apply(file);
  }
  
  protected void build() {
    final ArrayList<BuildEvent> allEvents = CollectionLiterals.<BuildEvent>newArrayList();
    this.queue.drainTo(allEvents);
    this.build(allEvents);
  }
  
  public void build(final List<BuildEvent> allEvents) {
    final BuildProgressReporter buildProgressReporter = this.buildProgressReporterProvider.get();
    buildProgressReporter.setProject(this.project);
    try {
      final HashMultimap<Module, BuildEvent> module2event = HashMultimap.<Module, BuildEvent>create();
      final ProjectFileIndex fileIndex = ProjectFileIndex.SERVICE.getInstance(this.project);
      final Procedure1<BuildEvent> _function = new Procedure1<BuildEvent>() {
        @Override
        public void apply(final BuildEvent it) {
          final Module module = XtextAutoBuilder.this.findModule(it, fileIndex);
          boolean _notEquals = (!Objects.equal(module, null));
          if (_notEquals) {
            module2event.put(module, it);
          }
        }
      };
      IterableExtensions.<BuildEvent>forEach(allEvents, _function);
      Set<Module> _keySet = module2event.keySet();
      for (final Module module : _keySet) {
        {
          final Set<BuildEvent> events = module2event.get(module);
          final OrderEnumerator entries = OrderEnumerator.orderEntries(module);
          BuildRequest _buildRequest = new BuildRequest();
          final Procedure1<BuildRequest> _function_1 = new Procedure1<BuildRequest>() {
            @Override
            public void apply(final BuildRequest it) {
              XtextResourceSet _get = XtextAutoBuilder.this.resourceSetProvider.get(module);
              it.setResourceSet(_get);
              List<URI> _dirtyFiles = it.getDirtyFiles();
              final Function1<BuildEvent, Boolean> _function = new Function1<BuildEvent, Boolean>() {
                @Override
                public Boolean apply(final BuildEvent it) {
                  boolean _or = false;
                  BuildEvent.Type _type = it.getType();
                  boolean _equals = Objects.equal(_type, BuildEvent.Type.MODIFIED);
                  if (_equals) {
                    _or = true;
                  } else {
                    BuildEvent.Type _type_1 = it.getType();
                    boolean _equals_1 = Objects.equal(_type_1, BuildEvent.Type.ADDED);
                    _or = _equals_1;
                  }
                  return Boolean.valueOf(_or);
                }
              };
              Iterable<BuildEvent> _filter = IterableExtensions.<BuildEvent>filter(events, _function);
              final Function1<BuildEvent, URI> _function_1 = new Function1<BuildEvent, URI>() {
                @Override
                public URI apply(final BuildEvent it) {
                  VirtualFile _file = it.getFile();
                  return VirtualFileURIUtil.getURI(_file);
                }
              };
              Iterable<URI> _map = IterableExtensions.<BuildEvent, URI>map(_filter, _function_1);
              Iterables.<URI>addAll(_dirtyFiles, _map);
              List<URI> _deletedFiles = it.getDeletedFiles();
              final Function1<BuildEvent, Boolean> _function_2 = new Function1<BuildEvent, Boolean>() {
                @Override
                public Boolean apply(final BuildEvent it) {
                  BuildEvent.Type _type = it.getType();
                  return Boolean.valueOf(Objects.equal(_type, BuildEvent.Type.DELETED));
                }
              };
              Iterable<BuildEvent> _filter_1 = IterableExtensions.<BuildEvent>filter(events, _function_2);
              final Function1<BuildEvent, URI> _function_3 = new Function1<BuildEvent, URI>() {
                @Override
                public URI apply(final BuildEvent it) {
                  VirtualFile _file = it.getFile();
                  return VirtualFileURIUtil.getURI(_file);
                }
              };
              Iterable<URI> _map_1 = IterableExtensions.<BuildEvent, URI>map(_filter_1, _function_3);
              Iterables.<URI>addAll(_deletedFiles, _map_1);
              List<URI> _classPath = it.getClassPath();
              OrderEnumerator _withoutSdk = entries.withoutSdk();
              OrderRootsEnumerator _classes = _withoutSdk.classes();
              PathsList _pathsList = _classes.getPathsList();
              List<VirtualFile> _virtualFiles = _pathsList.getVirtualFiles();
              final Function1<VirtualFile, Boolean> _function_4 = new Function1<VirtualFile, Boolean>() {
                @Override
                public Boolean apply(final VirtualFile it) {
                  boolean _isDirectory = it.isDirectory();
                  return Boolean.valueOf((!_isDirectory));
                }
              };
              Iterable<VirtualFile> _filter_2 = IterableExtensions.<VirtualFile>filter(_virtualFiles, _function_4);
              final Function1<VirtualFile, URI> _function_5 = new Function1<VirtualFile, URI>() {
                @Override
                public URI apply(final VirtualFile it) {
                  return VirtualFileURIUtil.getURI(it);
                }
              };
              Iterable<URI> _map_2 = IterableExtensions.<VirtualFile, URI>map(_filter_2, _function_5);
              Iterables.<URI>addAll(_classPath, _map_2);
              ModuleRootManager _instance = ModuleRootManager.getInstance(module);
              VirtualFile[] _contentRoots = _instance.getContentRoots();
              VirtualFile _head = IterableExtensions.<VirtualFile>head(((Iterable<VirtualFile>)Conversions.doWrapArray(_contentRoots)));
              URI _uRI = VirtualFileURIUtil.getURI(_head);
              it.setBaseDir(_uRI);
              List<URI> _sourceRoots = it.getSourceRoots();
              OrderEnumerator _withoutSdk_1 = entries.withoutSdk();
              OrderEnumerator _withoutLibraries = _withoutSdk_1.withoutLibraries();
              OrderEnumerator _withoutDepModules = _withoutLibraries.withoutDepModules();
              OrderRootsEnumerator _sources = _withoutDepModules.sources();
              PathsList _pathsList_1 = _sources.getPathsList();
              List<VirtualFile> _virtualFiles_1 = _pathsList_1.getVirtualFiles();
              final Function1<VirtualFile, URI> _function_6 = new Function1<VirtualFile, URI>() {
                @Override
                public URI apply(final VirtualFile it) {
                  return VirtualFileURIUtil.getURI(it);
                }
              };
              List<URI> _map_3 = ListExtensions.<VirtualFile, URI>map(_virtualFiles_1, _function_6);
              Iterables.<URI>addAll(_sourceRoots, _map_3);
              it.setFailOnValidationError(false);
              IndexState _elvis = null;
              if (XtextAutoBuilder.this.indexState != null) {
                _elvis = XtextAutoBuilder.this.indexState;
              } else {
                IndexState _indexState = new IndexState();
                _elvis = _indexState;
              }
              it.setPreviousState(_elvis);
              it.setIssueHandler(buildProgressReporter);
              final Procedure1<URI> _function_7 = new Procedure1<URI>() {
                @Override
                public void apply(final URI it) {
                  buildProgressReporter.markAsAffected(it);
                }
              };
              it.setIssueCleaner(_function_7);
            }
          };
          final BuildRequest request = ObjectExtensions.<BuildRequest>operator_doubleArrow(_buildRequest, _function_1);
          final Application app = ApplicationManager.getApplication();
          final Computable<IndexState> _function_2 = new Computable<IndexState>() {
            @Override
            public IndexState compute() {
              IncrementalBuilder _get = XtextAutoBuilder.this.builderProvider.get();
              Map<String, LanguageAccess> _languageAccesses = XtextAutoBuilder.this.xtextLanguages.getLanguageAccesses();
              return _get.build(request, _languageAccesses);
            }
          };
          IndexState _runReadAction = app.<IndexState>runReadAction(_function_2);
          this.indexState = _runReadAction;
          final Runnable _function_3 = new Runnable() {
            @Override
            public void run() {
              final Runnable _function = new Runnable() {
                @Override
                public void run() {
                  XtextResourceSet _resourceSet = request.getResourceSet();
                  final IdeaResourceSetProvider.VirtualFileBasedUriHandler handler = IdeaResourceSetProvider.VirtualFileBasedUriHandler.find(_resourceSet);
                  handler.flushToDisk();
                }
              };
              app.runWriteAction(_function);
            }
          };
          ModalityState _any = ModalityState.any();
          app.invokeAndWait(_function_3, _any);
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof ProcessCanceledException) {
        final ProcessCanceledException exc = (ProcessCanceledException)_t;
        this.queue.addAll(allEvents);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      buildProgressReporter.clearProgress();
    }
  }
  
  protected IndexState getIndexState() {
    boolean _equals = Objects.equal(this.indexState, null);
    if (_equals) {
      boolean _isLoaded = this.isLoaded();
      boolean _not = (!_isLoaded);
      if (_not) {
        this.queueAllResources();
        this.alarm.cancelAllRequests();
        final Runnable _function = new Runnable() {
          @Override
          public void run() {
            XtextAutoBuilder.this.build();
          }
        };
        this.alarm.addRequest(_function, 200);
      }
      return new IndexState();
    }
    return this.indexState;
  }
  
  public IResourceDescriptions getResourceDescriptions() {
    IndexState _indexState = this.getIndexState();
    return _indexState.getResourceDescriptions();
  }
  
  protected Module findModule(final BuildEvent it, final ProjectFileIndex fileIndex) {
    Module _xblockexpression = null;
    {
      Map<String, LanguageAccess> _languageAccesses = this.xtextLanguages.getLanguageAccesses();
      VirtualFile _file = it.getFile();
      String _extension = _file.getExtension();
      LanguageAccess _get = _languageAccesses.get(_extension);
      boolean _equals = Objects.equal(_get, null);
      if (_equals) {
        return null;
      }
      Module _xifexpression = null;
      BuildEvent.Type _type = it.getType();
      boolean _equals_1 = Objects.equal(_type, BuildEvent.Type.DELETED);
      if (_equals_1) {
        VirtualFile _file_1 = it.getFile();
        _xifexpression = this.findModule(_file_1, fileIndex);
      } else {
        VirtualFile _file_2 = it.getFile();
        _xifexpression = fileIndex.getModuleForFile(_file_2, true);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected Module findModule(final VirtualFile file, final ProjectFileIndex fileIndex) {
    Module _xblockexpression = null;
    {
      boolean _equals = Objects.equal(file, null);
      if (_equals) {
        return null;
      }
      final Module module = fileIndex.getModuleForFile(file, true);
      boolean _notEquals = (!Objects.equal(module, null));
      if (_notEquals) {
        return module;
      }
      VirtualFile _parent = file.getParent();
      _xblockexpression = this.findModule(_parent, fileIndex);
    }
    return _xblockexpression;
  }
  
  private final static Logger LOG = Logger.getLogger(XtextAutoBuilder.class);
}
