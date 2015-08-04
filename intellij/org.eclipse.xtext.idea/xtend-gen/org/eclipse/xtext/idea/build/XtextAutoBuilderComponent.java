/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.intellij.ProjectTopics;
import com.intellij.compiler.ModuleCompilerUtil;
import com.intellij.facet.Facet;
import com.intellij.facet.FacetType;
import com.intellij.facet.ProjectWideFacetAdapter;
import com.intellij.facet.ProjectWideFacetListenersRegistry;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.event.DocumentAdapter;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.EditorEventMulticaster;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.ModuleAdapter;
import com.intellij.openapi.project.ModuleListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModuleRootAdapter;
import com.intellij.openapi.roots.ModuleRootEvent;
import com.intellij.openapi.roots.ModuleRootListener;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileAdapter;
import com.intellij.openapi.vfs.VirtualFileEvent;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.openapi.vfs.VirtualFileMoveEvent;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.PsiModificationTrackerImpl;
import com.intellij.psi.util.PsiModificationTracker;
import com.intellij.util.Alarm;
import com.intellij.util.Function;
import com.intellij.util.graph.Graph;
import com.intellij.util.messages.MessageBus;
import com.intellij.util.messages.MessageBusConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.build.IncrementalBuilder;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.build.Source2GeneratedMapping;
import org.eclipse.xtext.common.types.descriptions.TypeResourceDescription;
import org.eclipse.xtext.idea.build.BuildEvent;
import org.eclipse.xtext.idea.build.BuildProgressReporter;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;
import org.eclipse.xtext.idea.facet.FacetProvider;
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
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
public class XtextAutoBuilderComponent extends AbstractProjectComponent implements Disposable {
  public static class MutableCancelIndicator implements CancelIndicator {
    private volatile boolean canceled;
    
    @Override
    public boolean isCanceled() {
      return this.canceled;
    }
    
    public boolean setCanceled(final boolean canceled) {
      return this.canceled = canceled;
    }
  }
  
  private volatile boolean disposed;
  
  private final LinkedBlockingQueue<BuildEvent> queue = new LinkedBlockingQueue<BuildEvent>();
  
  private final LinkedBlockingQueue<XtextAutoBuilderComponent.MutableCancelIndicator> cancelIndicators = new LinkedBlockingQueue<XtextAutoBuilderComponent.MutableCancelIndicator>();
  
  private Alarm alarm;
  
  private Project project;
  
  @Inject
  private Provider<IncrementalBuilder> builderProvider;
  
  @Inject
  private Provider<BuildProgressReporter> buildProgressReporterProvider;
  
  @Inject
  private IdeaResourceSetProvider resourceSetProvider;
  
  @Inject
  private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Inject
  private Provider<ChunkedResourceDescriptions> chunkedResourceDescriptionsProvider;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  private ChunkedResourceDescriptions chunkedResourceDescriptions;
  
  private Map<Module, Source2GeneratedMapping> module2GeneratedMapping = CollectionLiterals.<Module, Source2GeneratedMapping>newHashMap();
  
  public Iterable<URI> getGeneratedSources(final URI source) {
    Collection<Source2GeneratedMapping> _values = this.module2GeneratedMapping.values();
    final Function1<Source2GeneratedMapping, List<URI>> _function = new Function1<Source2GeneratedMapping, List<URI>>() {
      @Override
      public List<URI> apply(final Source2GeneratedMapping it) {
        return it.getGenerated(source);
      }
    };
    Iterable<List<URI>> _map = IterableExtensions.<Source2GeneratedMapping, List<URI>>map(_values, _function);
    Iterable<URI> _flatten = Iterables.<URI>concat(_map);
    return IterableExtensions.<URI>toList(_flatten);
  }
  
  public Iterable<URI> getSource4GeneratedSource(final URI generated) {
    Collection<Source2GeneratedMapping> _values = this.module2GeneratedMapping.values();
    final Function1<Source2GeneratedMapping, List<URI>> _function = new Function1<Source2GeneratedMapping, List<URI>>() {
      @Override
      public List<URI> apply(final Source2GeneratedMapping it) {
        return it.getSource(generated);
      }
    };
    Iterable<List<URI>> _map = IterableExtensions.<Source2GeneratedMapping, List<URI>>map(_values, _function);
    Iterable<URI> _flatten = Iterables.<URI>concat(_map);
    return IterableExtensions.<URI>toList(_flatten);
  }
  
  public XtextAutoBuilderComponent(final Project project) {
    super(project);
    Application _application = ApplicationManager.getApplication();
    boolean _isUnitTestMode = _application.isUnitTestMode();
    XtextAutoBuilderComponent.TEST_MODE = _isUnitTestMode;
    Injector _injector = IdeaSharedInjectorProvider.getInjector();
    _injector.injectMembers(this);
    ChunkedResourceDescriptions _get = this.chunkedResourceDescriptionsProvider.get();
    this.chunkedResourceDescriptions = _get;
    this.project = project;
    Alarm _alarm = new Alarm(Alarm.ThreadToUse.OWN_THREAD, this);
    this.alarm = _alarm;
    this.disposed = false;
    Disposer.register(project, this);
    EditorFactory _instance = EditorFactory.getInstance();
    EditorEventMulticaster _eventMulticaster = _instance.getEventMulticaster();
    _eventMulticaster.addDocumentListener(new DocumentAdapter() {
      @Override
      public void documentChanged(final DocumentEvent event) {
        FileDocumentManager _instance = FileDocumentManager.getInstance();
        Document _document = event.getDocument();
        VirtualFile file = _instance.getFile(_document);
        boolean _notEquals = (!Objects.equal(file, null));
        if (_notEquals) {
          XtextAutoBuilderComponent.this.fileModified(file);
        } else {
          Document _document_1 = event.getDocument();
          String _plus = ("No virtual file for document. Contents was " + _document_1);
          XtextAutoBuilderComponent.LOG.info(_plus);
        }
      }
    }, project);
    VirtualFileManager _instance_1 = VirtualFileManager.getInstance();
    _instance_1.addVirtualFileListener(new VirtualFileAdapter() {
      @Override
      public void contentsChanged(final VirtualFileEvent event) {
        VirtualFile _file = event.getFile();
        XtextAutoBuilderComponent.this.fileModified(_file);
      }
      
      @Override
      public void fileCreated(final VirtualFileEvent event) {
        VirtualFile _file = event.getFile();
        XtextAutoBuilderComponent.this.fileAdded(_file);
      }
      
      @Override
      public void fileDeleted(final VirtualFileEvent event) {
        VirtualFile _file = event.getFile();
        XtextAutoBuilderComponent.this.fileDeleted(_file);
      }
      
      @Override
      public void beforeFileMovement(final VirtualFileMoveEvent event) {
        VirtualFile _file = event.getFile();
        XtextAutoBuilderComponent.this.fileDeleted(_file);
      }
      
      @Override
      public void fileMoved(final VirtualFileMoveEvent event) {
        VirtualFile _file = event.getFile();
        XtextAutoBuilderComponent.this.fileAdded(_file);
      }
    }, project);
    MessageBus _messageBus = project.getMessageBus();
    final MessageBusConnection connection = _messageBus.connect(project);
    connection.<ModuleRootListener>subscribe(ProjectTopics.PROJECT_ROOTS, new ModuleRootAdapter() {
      @Override
      public void rootsChanged(final ModuleRootEvent event) {
        XtextAutoBuilderComponent.this.doCleanBuild();
      }
    });
    connection.<ModuleListener>subscribe(ProjectTopics.MODULES, new ModuleAdapter() {
      @Override
      public void moduleAdded(final Project project, final Module module) {
        XtextAutoBuilderComponent.this.doCleanBuild(module);
      }
      
      @Override
      public void moduleRemoved(final Project project, final Module module) {
        String _name = module.getName();
        XtextAutoBuilderComponent.this.chunkedResourceDescriptions.removeContainer(_name);
        XtextAutoBuilderComponent.this.module2GeneratedMapping.remove(module);
      }
      
      @Override
      public void modulesRenamed(final Project project, final List<Module> modules, final Function<Module, String> oldNameProvider) {
        for (final Module module : modules) {
          {
            String _fun = oldNameProvider.fun(module);
            XtextAutoBuilderComponent.this.chunkedResourceDescriptions.removeContainer(_fun);
            XtextAutoBuilderComponent.this.module2GeneratedMapping.remove(module);
            XtextAutoBuilderComponent.this.doCleanBuild(module);
          }
        }
      }
    });
    ProjectWideFacetListenersRegistry _instance_2 = ProjectWideFacetListenersRegistry.getInstance(project);
    _instance_2.registerListener(new ProjectWideFacetAdapter<Facet>() {
      @Override
      public void facetAdded(final Facet facet) {
        boolean _isXtextFacet = XtextAutoBuilderComponent.this.isXtextFacet(facet);
        boolean _not = (!_isXtextFacet);
        if (_not) {
          return;
        }
        Module _module = facet.getModule();
        XtextAutoBuilderComponent.this.doCleanBuild(_module);
      }
      
      @Override
      public void facetRemoved(final Facet facet) {
        boolean _isXtextFacet = XtextAutoBuilderComponent.this.isXtextFacet(facet);
        boolean _not = (!_isXtextFacet);
        if (_not) {
          return;
        }
        Module _module = facet.getModule();
        XtextAutoBuilderComponent.this.doCleanBuild(_module);
      }
      
      @Override
      public void facetConfigurationChanged(final Facet facet) {
        boolean _isXtextFacet = XtextAutoBuilderComponent.this.isXtextFacet(facet);
        boolean _not = (!_isXtextFacet);
        if (_not) {
          return;
        }
        Module _module = facet.getModule();
        XtextAutoBuilderComponent.this.doCleanBuild(_module);
      }
    }, this);
  }
  
  protected boolean isXtextFacet(final Facet<?> facet) {
    final FacetType facetType = facet.getType();
    return (facetType instanceof AbstractFacetType<?>);
  }
  
  @Override
  public void dispose() {
    this.disposed = true;
    this.alarm.cancelAllRequests();
    this.queue.clear();
    ChunkedResourceDescriptions _get = this.chunkedResourceDescriptionsProvider.get();
    this.chunkedResourceDescriptions = _get;
  }
  
  protected Project getProject() {
    return this.myProject;
  }
  
  public void fileModified(final VirtualFile file) {
    this.enqueue(file, BuildEvent.Type.MODIFIED);
  }
  
  public void fileDeleted(final VirtualFile file) {
    this.enqueue(file, BuildEvent.Type.DELETED);
  }
  
  public void fileAdded(final VirtualFile file) {
    boolean _and = false;
    boolean _isDirectory = file.isDirectory();
    boolean _not = (!_isDirectory);
    if (!_not) {
      _and = false;
    } else {
      long _length = file.getLength();
      boolean _greaterThan = (_length > 0);
      _and = _greaterThan;
    }
    if (_and) {
      this.enqueue(file, BuildEvent.Type.ADDED);
    } else {
      boolean _isInfoEnabled = XtextAutoBuilderComponent.LOG.isInfoEnabled();
      if (_isInfoEnabled) {
        String _path = file.getPath();
        String _plus = ("Ignoring new empty file " + _path);
        String _plus_1 = (_plus + ". Waiting for content.");
        XtextAutoBuilderComponent.LOG.info(_plus_1);
      }
    }
  }
  
  /**
   * For testing purposes! When set to <code>true</code>, the builds are not running asynchronously and delayed, but directly when the event comes in
   */
  public static boolean TEST_MODE = false;
  
  protected void enqueue(final VirtualFile file, final BuildEvent.Type type) {
    try {
      boolean _isExcluded = this.isExcluded(file);
      if (_isExcluded) {
        return;
      }
      boolean _and = false;
      if (!(!this.disposed)) {
        _and = false;
      } else {
        boolean _isLoaded = this.isLoaded();
        boolean _not = (!_isLoaded);
        _and = _not;
      }
      if (_and) {
        this.queueAllResources();
      }
      boolean _isInfoEnabled = XtextAutoBuilderComponent.LOG.isInfoEnabled();
      if (_isInfoEnabled) {
        URI _uRI = VirtualFileURIUtil.getURI(file);
        String _plus = ((("Queuing " + type) + " - ") + _uRI);
        String _plus_1 = (_plus + ".");
        XtextAutoBuilderComponent.LOG.info(_plus_1);
      }
      boolean _and_1 = false;
      boolean _notEquals = (!Objects.equal(file, null));
      if (!_notEquals) {
        _and_1 = false;
      } else {
        _and_1 = (!this.disposed);
      }
      if (_and_1) {
        BuildEvent _buildEvent = new BuildEvent(file, type);
        this.queue.put(_buildEvent);
        this.doRunBuild();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void doCleanBuild() {
    if (this.ignoreIncomingEvents) {
      return;
    }
    this.alarm.cancelAllRequests();
    ChunkedResourceDescriptions _get = this.chunkedResourceDescriptionsProvider.get();
    this.chunkedResourceDescriptions = _get;
    Collection<Source2GeneratedMapping> _values = this.module2GeneratedMapping.values();
    final Function1<Source2GeneratedMapping, List<URI>> _function = new Function1<Source2GeneratedMapping, List<URI>>() {
      @Override
      public List<URI> apply(final Source2GeneratedMapping it) {
        return it.getAllGenerated();
      }
    };
    Iterable<List<URI>> _map = IterableExtensions.<Source2GeneratedMapping, List<URI>>map(_values, _function);
    Iterable<URI> _flatten = Iterables.<URI>concat(_map);
    List<URI> _list = IterableExtensions.<URI>toList(_flatten);
    this.safeDeleteUris(_list);
    this.module2GeneratedMapping.clear();
    this.queueAllResources();
    this.doRunBuild();
  }
  
  protected void doCleanBuild(final Module module) {
    if (this.ignoreIncomingEvents) {
      return;
    }
    this.alarm.cancelAllRequests();
    String _name = module.getName();
    this.chunkedResourceDescriptions.removeContainer(_name);
    final Source2GeneratedMapping before = this.module2GeneratedMapping.remove(module);
    boolean _notEquals = (!Objects.equal(before, null));
    if (_notEquals) {
      List<URI> _allGenerated = before.getAllGenerated();
      this.safeDeleteUris(_allGenerated);
    }
    this.queueAllResources(module);
    this.doRunBuild();
  }
  
  protected void safeDeleteUris(final List<URI> uris) {
    boolean _isEmpty = uris.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Application app = ApplicationManager.getApplication();
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          try {
            try {
              XtextAutoBuilderComponent.this.ignoreIncomingEvents = true;
              for (final URI uri : uris) {
                {
                  final VirtualFile file = VirtualFileURIUtil.getVirtualFile(uri);
                  boolean _and = false;
                  if (!(file != null)) {
                    _and = false;
                  } else {
                    boolean _exists = file.exists();
                    _and = _exists;
                  }
                  if (_and) {
                    file.delete(XtextAutoBuilderComponent.this);
                  }
                }
              }
            } finally {
              XtextAutoBuilderComponent.this.ignoreIncomingEvents = false;
            }
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      final Runnable runnable = _function;
      boolean _isDispatchThread = app.isDispatchThread();
      if (_isDispatchThread) {
        app.runWriteAction(runnable);
      } else {
        final Runnable _function_1 = new Runnable() {
          @Override
          public void run() {
            app.runWriteAction(runnable);
          }
        };
        app.invokeLater(_function_1);
      }
    }
  }
  
  protected void doRunBuild() {
    if (XtextAutoBuilderComponent.TEST_MODE) {
      Project _project = this.getProject();
      PsiManager _instance = PsiManager.getInstance(_project);
      PsiModificationTracker _modificationTracker = _instance.getModificationTracker();
      ((PsiModificationTrackerImpl) _modificationTracker).incCounter();
      this.build();
    } else {
      this.alarm.cancelAllRequests();
      final Procedure1<XtextAutoBuilderComponent.MutableCancelIndicator> _function = new Procedure1<XtextAutoBuilderComponent.MutableCancelIndicator>() {
        @Override
        public void apply(final XtextAutoBuilderComponent.MutableCancelIndicator it) {
          it.canceled = true;
        }
      };
      IterableExtensions.<XtextAutoBuilderComponent.MutableCancelIndicator>forEach(this.cancelIndicators, _function);
      final Runnable _function_1 = new Runnable() {
        @Override
        public void run() {
          XtextAutoBuilderComponent.this.build();
        }
      };
      this.alarm.addRequest(_function_1, 200);
    }
  }
  
  protected boolean isExcluded(final VirtualFile file) {
    if (this.ignoreIncomingEvents) {
      boolean _isDebugEnabled = XtextAutoBuilderComponent.LOG.isDebugEnabled();
      if (_isDebugEnabled) {
        String _path = file.getPath();
        String _plus = ("Ignoring transitive file change " + _path);
        XtextAutoBuilderComponent.LOG.debug(_plus);
      }
      return true;
    }
    boolean _or = false;
    boolean _equals = Objects.equal(file, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _isDirectory = file.isDirectory();
      _or = _isDirectory;
    }
    return _or;
  }
  
  protected boolean isLoaded() {
    boolean _or = false;
    boolean _isEmpty = this.chunkedResourceDescriptions.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      _or = true;
    } else {
      boolean _isEmpty_1 = this.queue.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      _or = _not_1;
    }
    return _or;
  }
  
  protected void queueAllResources(final Module module) {
    ModuleRootManager _instance = ModuleRootManager.getInstance(module);
    final ContentEntry[] entries = _instance.getContentEntries();
    final Function1<ContentEntry, Set<VirtualFile>> _function = new Function1<ContentEntry, Set<VirtualFile>>() {
      @Override
      public Set<VirtualFile> apply(final ContentEntry it) {
        VirtualFile[] _sourceFolderFiles = it.getSourceFolderFiles();
        return IterableExtensions.<VirtualFile>toSet(((Iterable<VirtualFile>)Conversions.doWrapArray(_sourceFolderFiles)));
      }
    };
    List<Set<VirtualFile>> _map = ListExtensions.<ContentEntry, Set<VirtualFile>>map(((List<ContentEntry>)Conversions.doWrapArray(entries)), _function);
    Iterable<VirtualFile> _flatten = Iterables.<VirtualFile>concat(_map);
    for (final VirtualFile root : _flatten) {
      final Procedure1<VirtualFile> _function_1 = new Procedure1<VirtualFile>() {
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
              XtextAutoBuilderComponent.this.queue.put(_buildEvent);
            }
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      this.visitFileTree(root, _function_1);
    }
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
            XtextAutoBuilderComponent.this.queue.put(_buildEvent);
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
  
  private volatile boolean ignoreIncomingEvents = false;
  
  protected void build() {
    if (this.disposed) {
      return;
    }
    boolean _isReadyToBeBuilt = this.isReadyToBeBuilt();
    if (_isReadyToBeBuilt) {
      XtextAutoBuilderComponent.LOG.info("Project not yet initialized, wait some more");
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          XtextAutoBuilderComponent.this.build();
        }
      };
      this.alarm.addRequest(_function, 500);
    } else {
      final ArrayList<BuildEvent> allEvents = CollectionLiterals.<BuildEvent>newArrayList();
      this.queue.drainTo(allEvents);
      this.internalBuild(allEvents);
    }
  }
  
  private boolean isReadyToBeBuilt() {
    boolean _and = false;
    boolean _and_1 = false;
    if (!(!XtextAutoBuilderComponent.TEST_MODE)) {
      _and_1 = false;
    } else {
      boolean _isInitialized = this.project.isInitialized();
      boolean _not = (!_isInitialized);
      _and_1 = _not;
    }
    if (!_and_1) {
      _and = false;
    } else {
      DumbService _instance = DumbService.getInstance(this.project);
      boolean _isDumb = _instance.isDumb();
      boolean _not_1 = (!_isDumb);
      _and = _not_1;
    }
    return _and;
  }
  
  protected void internalBuild(final List<BuildEvent> allEvents) {
    final ArrayList<BuildEvent> unProcessedEvents = CollectionLiterals.<BuildEvent>newArrayList();
    Iterables.<BuildEvent>addAll(unProcessedEvents, allEvents);
    final Application app = ApplicationManager.getApplication();
    final XtextAutoBuilderComponent.MutableCancelIndicator cancelIndicator = new XtextAutoBuilderComponent.MutableCancelIndicator();
    this.cancelIndicators.add(cancelIndicator);
    Project _project = this.getProject();
    final ModuleManager moduleManager = ModuleManager.getInstance(_project);
    final BuildProgressReporter buildProgressReporter = this.buildProgressReporterProvider.get();
    buildProgressReporter.setProject(this.project);
    try {
      final ProjectFileIndex fileIndex = ProjectFileIndex.SERVICE.getInstance(this.project);
      final Computable<Graph<Module>> _function = new Computable<Graph<Module>>() {
        @Override
        public Graph<Module> compute() {
          return moduleManager.moduleGraph();
        }
      };
      final Graph<Module> moduleGraph = app.<Graph<Module>>runReadAction(_function);
      final ArrayList<IResourceDescription.Delta> deltas = CollectionLiterals.<IResourceDescription.Delta>newArrayList();
      Collection<Module> _nodes = moduleGraph.getNodes();
      final ArrayList<Module> sortedModules = new ArrayList<Module>(_nodes);
      ModuleCompilerUtil.sortModules(this.project, sortedModules);
      for (final Module module : sortedModules) {
        {
          Source2GeneratedMapping _elvis = null;
          Source2GeneratedMapping _get = this.module2GeneratedMapping.get(module);
          if (_get != null) {
            _elvis = _get;
          } else {
            Source2GeneratedMapping _source2GeneratedMapping = new Source2GeneratedMapping();
            _elvis = _source2GeneratedMapping;
          }
          final Source2GeneratedMapping fileMappings = _elvis;
          ResourceDescriptionsData _elvis_1 = null;
          String _name = module.getName();
          ResourceDescriptionsData _container = this.chunkedResourceDescriptions.getContainer(_name);
          if (_container != null) {
            _elvis_1 = _container;
          } else {
            List<IResourceDescription> _emptyList = CollectionLiterals.<IResourceDescription>emptyList();
            ResourceDescriptionsData _resourceDescriptionsData = new ResourceDescriptionsData(_emptyList);
            _elvis_1 = _resourceDescriptionsData;
          }
          final ResourceDescriptionsData moduleDescriptions = _elvis_1;
          final HashSet<URI> changedUris = CollectionLiterals.<URI>newHashSet();
          final HashSet<URI> deletedUris = CollectionLiterals.<URI>newHashSet();
          ModuleRootManager _instance = ModuleRootManager.getInstance(module);
          final VirtualFile[] contentRoots = _instance.getContentRoots();
          final Function1<BuildEvent, Boolean> _function_1 = new Function1<BuildEvent, Boolean>() {
            @Override
            public Boolean apply(final BuildEvent event) {
              Module _findModule = XtextAutoBuilderComponent.this.findModule(event, fileIndex);
              return Boolean.valueOf(Objects.equal(_findModule, module));
            }
          };
          Iterable<BuildEvent> _filter = IterableExtensions.<BuildEvent>filter(allEvents, _function_1);
          final Set<BuildEvent> events = IterableExtensions.<BuildEvent>toSet(_filter);
          boolean _or = false;
          boolean _isEmpty = ((List<VirtualFile>)Conversions.doWrapArray(contentRoots)).isEmpty();
          if (_isEmpty) {
            _or = true;
          } else {
            boolean _and = false;
            boolean _isEmpty_1 = events.isEmpty();
            if (!_isEmpty_1) {
              _and = false;
            } else {
              boolean _isEmpty_2 = deltas.isEmpty();
              _and = _isEmpty_2;
            }
            _or = _and;
          }
          if (_or) {
            String _name_1 = module.getName();
            String _plus = ("Skipping module \'" + _name_1);
            String _plus_1 = (_plus + "\'. Nothing to do here.");
            XtextAutoBuilderComponent.LOG.info(_plus_1);
          } else {
            this.collectChanges(events, module, changedUris, deletedUris, deltas);
            final ResourceDescriptionsData newIndex = moduleDescriptions.copy();
            BuildRequest _buildRequest = new BuildRequest();
            final Procedure1<BuildRequest> _function_2 = new Procedure1<BuildRequest>() {
              @Override
              public void apply(final BuildRequest it) {
                XtextResourceSet _createResourceSet = XtextAutoBuilderComponent.this.createResourceSet(module, newIndex);
                it.setResourceSet(_createResourceSet);
                List<URI> _dirtyFiles = it.getDirtyFiles();
                Iterables.<URI>addAll(_dirtyFiles, changedUris);
                List<URI> _deletedFiles = it.getDeletedFiles();
                Iterables.<URI>addAll(_deletedFiles, deletedUris);
                List<IResourceDescription.Delta> _externalDeltas = it.getExternalDeltas();
                Iterables.<IResourceDescription.Delta>addAll(_externalDeltas, deltas);
                VirtualFile _head = IterableExtensions.<VirtualFile>head(((Iterable<VirtualFile>)Conversions.doWrapArray(contentRoots)));
                URI _uRI = VirtualFileURIUtil.getURI(_head);
                it.setBaseDir(_uRI);
                Source2GeneratedMapping _copy = fileMappings.copy();
                IndexState _indexState = new IndexState(newIndex, _copy);
                it.setState(_indexState);
                it.setAfterValidate(buildProgressReporter);
                final Procedure1<URI> _function = new Procedure1<URI>() {
                  @Override
                  public void apply(final URI it) {
                    buildProgressReporter.markAsAffected(it);
                  }
                };
                it.setAfterDeleteFile(_function);
                it.setCancelIndicator(cancelIndicator);
              }
            };
            final BuildRequest request = ObjectExtensions.<BuildRequest>operator_doubleArrow(_buildRequest, _function_2);
            IncrementalBuilder _get_1 = this.builderProvider.get();
            Function1<URI, IResourceServiceProvider> _serviceProviderProvider = this.getServiceProviderProvider(module);
            final IncrementalBuilder.Result result = _get_1.build(request, _serviceProviderProvider);
            final Runnable _function_3 = new Runnable() {
              @Override
              public void run() {
                try {
                  XtextAutoBuilderComponent.this.ignoreIncomingEvents = true;
                  XtextResourceSet _resourceSet = request.getResourceSet();
                  final IdeaResourceSetProvider.VirtualFileBasedUriHandler handler = IdeaResourceSetProvider.VirtualFileBasedUriHandler.find(_resourceSet);
                  handler.flushToDisk();
                } finally {
                  XtextAutoBuilderComponent.this.ignoreIncomingEvents = false;
                }
              }
            };
            ModalityState _any = ModalityState.any();
            app.invokeAndWait(_function_3, _any);
            String _name_2 = module.getName();
            IndexState _indexState = result.getIndexState();
            ResourceDescriptionsData _resourceDescriptions = _indexState.getResourceDescriptions();
            this.chunkedResourceDescriptions.setContainer(_name_2, _resourceDescriptions);
            IndexState _indexState_1 = result.getIndexState();
            Source2GeneratedMapping _fileMappings = _indexState_1.getFileMappings();
            this.module2GeneratedMapping.put(module, _fileMappings);
            List<IResourceDescription.Delta> _affectedResources = result.getAffectedResources();
            deltas.addAll(_affectedResources);
            Iterables.removeAll(unProcessedEvents, events);
          }
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable exc = (Throwable)_t;
        boolean _isOperationCanceledException = this.operationCanceledManager.isOperationCanceledException(exc);
        if (_isOperationCanceledException) {
          boolean _isInfoEnabled = XtextAutoBuilderComponent.LOG.isInfoEnabled();
          if (_isInfoEnabled) {
            XtextAutoBuilderComponent.LOG.info("Build canceled.");
          }
          this.queue.addAll(unProcessedEvents);
        } else {
          XtextAutoBuilderComponent.LOG.error("Error during auto build.", exc);
        }
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      buildProgressReporter.clearProgress();
      this.cancelIndicators.remove(cancelIndicator);
    }
  }
  
  public Function1<URI, IResourceServiceProvider> getServiceProviderProvider(final Module module) {
    final Function1<URI, IResourceServiceProvider> _function = new Function1<URI, IResourceServiceProvider>() {
      @Override
      public IResourceServiceProvider apply(final URI it) {
        final IResourceServiceProvider serviceProvider = XtextAutoBuilderComponent.this.resourceServiceProviderRegistry.getResourceServiceProvider(it);
        boolean _notEquals = (!Objects.equal(serviceProvider, null));
        if (_notEquals) {
          final FacetProvider facetProvider = serviceProvider.<FacetProvider>get(FacetProvider.class);
          boolean _notEquals_1 = (!Objects.equal(facetProvider, null));
          if (_notEquals_1) {
            final Facet<? extends AbstractFacetConfiguration> facet = facetProvider.getFacet(module);
            boolean _notEquals_2 = (!Objects.equal(facet, null));
            if (_notEquals_2) {
              return serviceProvider;
            }
          }
        }
        return null;
      }
    };
    return _function;
  }
  
  public XtextResourceSet createResourceSet(final Module module, final ResourceDescriptionsData newData) {
    final XtextResourceSet result = this.resourceSetProvider.get(module);
    final ChunkedResourceDescriptions fullIndex = ChunkedResourceDescriptions.findInEmfObject(result);
    String _name = module.getName();
    fullIndex.setContainer(_name, newData);
    return result;
  }
  
  public String getContainerHandle(final Module module) {
    return module.getName();
  }
  
  protected void collectChanges(final Set<BuildEvent> events, final Module module, final HashSet<URI> changedUris, final HashSet<URI> deletedUris, final ArrayList<IResourceDescription.Delta> deltas) {
    final Application app = ApplicationManager.getApplication();
    final Source2GeneratedMapping fileMappings = this.module2GeneratedMapping.get(module);
    for (final BuildEvent event : events) {
      BuildEvent.Type _type = event.getType();
      if (_type != null) {
        switch (_type) {
          case MODIFIED:
          case ADDED:
            VirtualFile _file = event.getFile();
            final URI uri = VirtualFileURIUtil.getURI(_file);
            List<URI> _source = null;
            if (fileMappings!=null) {
              _source=fileMappings.getSource(uri);
            }
            final List<URI> sourceUris = _source;
            boolean _and = false;
            boolean _notEquals = (!Objects.equal(sourceUris, null));
            if (!_notEquals) {
              _and = false;
            } else {
              boolean _isEmpty = sourceUris.isEmpty();
              boolean _not = (!_isEmpty);
              _and = _not;
            }
            if (_and) {
              for (final URI sourceUri : sourceUris) {
                changedUris.add(sourceUri);
              }
            } else {
              VirtualFile _file_1 = event.getFile();
              boolean _isJavaFile = this.isJavaFile(_file_1);
              if (_isJavaFile) {
                final Computable<Set<IResourceDescription.Delta>> _function = new Computable<Set<IResourceDescription.Delta>>() {
                  @Override
                  public Set<IResourceDescription.Delta> compute() {
                    VirtualFile _file = event.getFile();
                    return XtextAutoBuilderComponent.this.getJavaDeltas(_file, module);
                  }
                };
                Set<IResourceDescription.Delta> _runReadAction = app.<Set<IResourceDescription.Delta>>runReadAction(_function);
                Iterables.<IResourceDescription.Delta>addAll(deltas, _runReadAction);
              } else {
                changedUris.add(uri);
              }
            }
            break;
          case DELETED:
            VirtualFile _file_2 = event.getFile();
            final URI uri_1 = VirtualFileURIUtil.getURI(_file_2);
            List<URI> _source_1 = null;
            if (fileMappings!=null) {
              _source_1=fileMappings.getSource(uri_1);
            }
            final List<URI> sourceUris_1 = _source_1;
            boolean _and_1 = false;
            boolean _notEquals_1 = (!Objects.equal(sourceUris_1, null));
            if (!_notEquals_1) {
              _and_1 = false;
            } else {
              boolean _isEmpty_1 = sourceUris_1.isEmpty();
              boolean _not_1 = (!_isEmpty_1);
              _and_1 = _not_1;
            }
            if (_and_1) {
              for (final URI sourceUri_1 : sourceUris_1) {
                changedUris.add(sourceUri_1);
              }
            } else {
              VirtualFile _file_3 = event.getFile();
              boolean _isJavaFile_1 = this.isJavaFile(_file_3);
              if (_isJavaFile_1) {
                final Computable<Set<IResourceDescription.Delta>> _function_1 = new Computable<Set<IResourceDescription.Delta>>() {
                  @Override
                  public Set<IResourceDescription.Delta> compute() {
                    VirtualFile _file = event.getFile();
                    return XtextAutoBuilderComponent.this.getJavaDeltas(_file, module);
                  }
                };
                Set<IResourceDescription.Delta> _runReadAction_1 = app.<Set<IResourceDescription.Delta>>runReadAction(_function_1);
                Iterables.<IResourceDescription.Delta>addAll(deltas, _runReadAction_1);
              } else {
                deletedUris.add(uri_1);
              }
            }
            break;
          default:
            break;
        }
      }
    }
  }
  
  public boolean isJavaFile(final VirtualFile file) {
    String _extension = file.getExtension();
    return Objects.equal(_extension, "java");
  }
  
  public Set<IResourceDescription.Delta> getJavaDeltas(final VirtualFile file, final Module module) {
    boolean _isValid = file.isValid();
    boolean _not = (!_isValid);
    if (_not) {
      return CollectionLiterals.<IResourceDescription.Delta>emptySet();
    }
    Project _project = module.getProject();
    PsiManager _instance = PsiManager.getInstance(_project);
    final PsiFile psiFile = _instance.findFile(file);
    final LinkedHashSet<IResourceDescription.Delta> result = CollectionLiterals.<IResourceDescription.Delta>newLinkedHashSet();
    if ((psiFile instanceof PsiJavaFile)) {
      PsiClass[] _classes = ((PsiJavaFile)psiFile).getClasses();
      for (final PsiClass clazz : _classes) {
        String _qualifiedName = clazz.getQualifiedName();
        QualifiedName _qualifiedName_1 = this.qualifiedNameConverter.toQualifiedName(_qualifiedName);
        TypeResourceDescription.ChangedDelta _changedDelta = new TypeResourceDescription.ChangedDelta(_qualifiedName_1);
        result.add(_changedDelta);
      }
    }
    return result;
  }
  
  public ChunkedResourceDescriptions installCopyOfResourceDescriptions(final ResourceSet resourceSet) {
    return this.chunkedResourceDescriptions.createShallowCopyWith(resourceSet);
  }
  
  protected Module findModule(final BuildEvent it, final ProjectFileIndex fileIndex) {
    Module _xifexpression = null;
    BuildEvent.Type _type = it.getType();
    boolean _equals = Objects.equal(_type, BuildEvent.Type.DELETED);
    if (_equals) {
      VirtualFile _file = it.getFile();
      _xifexpression = this.findModule(_file, fileIndex);
    } else {
      VirtualFile _file_1 = it.getFile();
      _xifexpression = fileIndex.getModuleForFile(_file_1, true);
    }
    return _xifexpression;
  }
  
  protected Module findModule(final VirtualFile file, final ProjectFileIndex fileIndex) {
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
    return this.findModule(_parent, fileIndex);
  }
  
  @Override
  public String getComponentName() {
    return "Xtext Compiler Component";
  }
  
  public ChunkedResourceDescriptions getIndexState() {
    return this.chunkedResourceDescriptions;
  }
  
  private final static Logger LOG = Logger.getLogger(XtextAutoBuilderComponent.class);
}
