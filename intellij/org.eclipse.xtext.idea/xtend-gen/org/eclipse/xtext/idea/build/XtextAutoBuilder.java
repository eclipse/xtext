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
import com.intellij.compiler.impl.CompilerUtil;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.progress.ProcessCanceledException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.OrderEnumerator;
import com.intellij.openapi.roots.OrderRootsEnumerator;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.encoding.EncodingProjectManager;
import com.intellij.util.Alarm;
import com.intellij.util.PathsList;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.standalone.IIssueHandler;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;
import org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs;
import org.eclipse.xtext.builder.standalone.incremental.IncrementalBuilder;
import org.eclipse.xtext.builder.standalone.incremental.IndexState;
import org.eclipse.xtext.idea.build.BuildEvent;
import org.eclipse.xtext.idea.resource.ModuleBasedResourceSetProvider;
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider;
import org.eclipse.xtext.idea.shared.XtextLanguages;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextAutoBuilder {
  private BlockingQueue<BuildEvent> queue = new LinkedBlockingQueue<BuildEvent>();
  
  private Alarm alarm;
  
  private Project project;
  
  @Inject
  private Provider<IncrementalBuilder> builderProvider;
  
  @Inject
  private XtextLanguages xtextLanguages;
  
  @Inject
  private ModuleBasedResourceSetProvider resourceSetProvider;
  
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
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(file, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _isDisposed = this.project.isDisposed();
        boolean _not = (!_isDisposed);
        _and = _not;
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
  
  protected void build() {
    final ArrayList<BuildEvent> allEvents = CollectionLiterals.<BuildEvent>newArrayList();
    this.queue.drainTo(allEvents);
    try {
      final HashMultimap<Module, BuildEvent> module2event = HashMultimap.<Module, BuildEvent>create();
      final ProjectFileIndex fileIndex = ProjectFileIndex.SERVICE.getInstance(this.project);
      final Procedure1<BuildEvent> _function = new Procedure1<BuildEvent>() {
        @Override
        public void apply(final BuildEvent it) {
          Map<String, LanguageAccess> _languageAccesses = XtextAutoBuilder.this.xtextLanguages.getLanguageAccesses();
          VirtualFile _file = it.getFile();
          String _extension = _file.getExtension();
          LanguageAccess _get = _languageAccesses.get(_extension);
          boolean _notEquals = (!Objects.equal(_get, null));
          if (_notEquals) {
            VirtualFile _file_1 = it.getFile();
            final Module module = fileIndex.getModuleForFile(_file_1);
            boolean _notEquals_1 = (!Objects.equal(module, null));
            if (_notEquals_1) {
              module2event.put(module, it);
            }
          }
        }
      };
      IterableExtensions.<BuildEvent>forEach(allEvents, _function);
      EncodingProjectManager _instance = EncodingProjectManager.getInstance(this.project);
      final String projectEncoding = _instance.getDefaultCharsetName();
      final ArrayList<URI> refreshFiles = CollectionLiterals.<URI>newArrayList();
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
                  return XtextAutoBuilder.this.getURI(_file);
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
                  return XtextAutoBuilder.this.getURI(_file);
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
                  return XtextAutoBuilder.this.getURI(it);
                }
              };
              Iterable<URI> _map_2 = IterableExtensions.<VirtualFile, URI>map(_filter_2, _function_5);
              Iterables.<URI>addAll(_classPath, _map_2);
              ModuleRootManager _instance = ModuleRootManager.getInstance(module);
              VirtualFile[] _contentRoots = _instance.getContentRoots();
              VirtualFile _head = IterableExtensions.<VirtualFile>head(((Iterable<VirtualFile>)Conversions.doWrapArray(_contentRoots)));
              URI _uRI = XtextAutoBuilder.this.getURI(_head);
              it.setBaseDir(_uRI);
              it.setDefaultEncoding(projectEncoding);
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
                  return XtextAutoBuilder.this.getURI(it);
                }
              };
              List<URI> _map_3 = ListExtensions.<VirtualFile, URI>map(_virtualFiles_1, _function_6);
              Iterables.<URI>addAll(_sourceRoots, _map_3);
              it.setFailOnValidationError(false);
              boolean _notEquals = (!Objects.equal(XtextAutoBuilder.this.indexState, null));
              if (_notEquals) {
                it.setPreviousState(XtextAutoBuilder.this.indexState);
              } else {
                it.setIsFullBuild(true);
              }
              IIssueHandler _issueHandler = it.getIssueHandler();
              it.setIssueHandler(_issueHandler);
              final Procedure2<URI, URI> _function_7 = new Procedure2<URI, URI>() {
                @Override
                public void apply(final URI $0, final URI $1) {
                  refreshFiles.add($1);
                }
              };
              it.setAfterGenerateFile(_function_7);
              final Procedure1<URI> _function_8 = new Procedure1<URI>() {
                @Override
                public void apply(final URI it) {
                  refreshFiles.add(it);
                }
              };
              it.setAfterDeleteFile(_function_8);
            }
          };
          final BuildRequest request = ObjectExtensions.<BuildRequest>operator_doubleArrow(_buildRequest, _function_1);
          Application _application = ApplicationManager.getApplication();
          final Computable<IndexState> _function_2 = new Computable<IndexState>() {
            @Override
            public IndexState compute() {
              IncrementalBuilder _get = XtextAutoBuilder.this.builderProvider.get();
              Map<String, LanguageAccess> _languageAccesses = XtextAutoBuilder.this.xtextLanguages.getLanguageAccesses();
              return _get.build(request, _languageAccesses);
            }
          };
          IndexState _runReadAction = _application.<IndexState>runReadAction(_function_2);
          this.indexState = _runReadAction;
        }
      }
      final Function1<URI, File> _function_1 = new Function1<URI, File>() {
        @Override
        public File apply(final URI it) {
          return FilesAndURIs.asFile(it);
        }
      };
      List<File> _map = ListExtensions.<URI, File>map(refreshFiles, _function_1);
      CompilerUtil.refreshIOFiles(_map);
    } catch (final Throwable _t) {
      if (_t instanceof ProcessCanceledException) {
        final ProcessCanceledException exc = (ProcessCanceledException)_t;
        this.queue.addAll(allEvents);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected URI getURI(final VirtualFile file) {
    URI _xblockexpression = null;
    {
      URI _xifexpression = null;
      boolean _isInLocalFileSystem = file.isInLocalFileSystem();
      if (_isInLocalFileSystem) {
        String _path = file.getPath();
        _xifexpression = URI.createFileURI(_path);
      } else {
        String _url = file.getUrl();
        _xifexpression = URI.createURI(_url);
      }
      final URI uri = _xifexpression;
      URI _xifexpression_1 = null;
      boolean _isDirectory = file.isDirectory();
      if (_isDirectory) {
        _xifexpression_1 = uri.appendSegment("");
      } else {
        _xifexpression_1 = uri;
      }
      _xblockexpression = _xifexpression_1;
    }
    return _xblockexpression;
  }
}
