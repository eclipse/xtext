/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.ProjectTopics
import com.intellij.compiler.ModuleCompilerUtil
import com.intellij.facet.Facet
import com.intellij.facet.ProjectWideFacetAdapter
import com.intellij.facet.ProjectWideFacetListenersRegistry
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.AbstractProjectComponent
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.StoragePathMacros
import com.intellij.openapi.components.StorageScheme
import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.editor.event.DocumentAdapter
import com.intellij.openapi.editor.event.DocumentEvent
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.ModuleAdapter
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModuleRootAdapter
import com.intellij.openapi.roots.ModuleRootEvent
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileAdapter
import com.intellij.openapi.vfs.VirtualFileEvent
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.openapi.vfs.VirtualFileMoveEvent
import com.intellij.openapi.vfs.VirtualFilePropertyEvent
import com.intellij.psi.PsiJavaFile
import com.intellij.psi.PsiManager
import com.intellij.psi.impl.PsiModificationTrackerImpl
import com.intellij.util.Alarm
import com.intellij.util.Function
import com.intellij.util.graph.Graph
import java.util.ArrayList
import java.util.HashSet
import java.util.LinkedHashSet
import java.util.List
import java.util.Map
import java.util.Set
import java.util.concurrent.LinkedBlockingQueue
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.build.BuildRequest
import org.eclipse.xtext.build.IncrementalBuilder
import org.eclipse.xtext.build.IndexState
import org.eclipse.xtext.build.Source2GeneratedMapping
import org.eclipse.xtext.common.types.descriptions.TypeResourceDescription.ChangedDelta
import org.eclipse.xtext.idea.facet.AbstractFacetType
import org.eclipse.xtext.idea.facet.FacetProvider
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider.VirtualFileBasedUriHandler
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.internal.Log

import static org.eclipse.xtext.idea.build.BuildEvent.Type.*

import static extension com.intellij.openapi.vfs.VfsUtilCore.*
import static extension org.eclipse.xtext.idea.resource.VirtualFileURIUtil.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@State(
	name='XtextAutoBuilderState', 
	storages = #[
		@Storage(
			id="other", 
			file = StoragePathMacros.WORKSPACE_FILE
		),
		@Storage(
			id = "dir", 
			file = StoragePathMacros.PROJECT_CONFIG_DIR + "/xtextAutoBuilderState.xml", 
			scheme = StorageScheme.DIRECTORY_BASED
		)])
@Log class XtextAutoBuilderComponent extends AbstractProjectComponent implements Disposable, PersistentStateComponent<XtextAutoBuilderComponentState> {
	
	volatile boolean disposed
	
	val queue = new LinkedBlockingQueue<BuildEvent>()
	val cancelIndicators = new LinkedBlockingQueue<MutableCancelIndicator>()

	Alarm alarm 

	Project project
	
	@Inject Provider<IncrementalBuilder> builderProvider	
	
	@Inject Provider<BuildProgressReporter> buildProgressReporterProvider
	 
	@Inject IdeaResourceSetProvider resourceSetProvider
	
	@Inject IResourceServiceProvider.Registry resourceServiceProviderRegistry
	
	@Inject IQualifiedNameConverter qualifiedNameConverter
	
	@Inject Provider<ChunkedResourceDescriptions> chunkedResourceDescriptionsProvider
	
	@Inject OperationCanceledManager operationCanceledManager
	
	ChunkedResourceDescriptions chunkedResourceDescriptions
	
	Map<String, Source2GeneratedMapping> moduleName2GeneratedMapping = newHashMap()
	
	def Iterable<URI> getGeneratedSources(URI source) {
		return moduleName2GeneratedMapping.values.map[getGenerated(source)].flatten.toList
	}
	
	def Iterable<URI> getSource4GeneratedSource(URI generated) {
		return moduleName2GeneratedMapping.values.map[getSource(generated)].flatten.toList
	}
	
	new(Project project) {
		super(project)
		TEST_MODE = ApplicationManager.application.isUnitTestMode
		IdeaSharedInjectorProvider.injector.injectMembers(this)
		this.chunkedResourceDescriptions = chunkedResourceDescriptionsProvider.get
		this.project = project
		// We need the swing thread here to access the ProgressManager.
		// No worries: The actual work is performed in a background thread.
		alarm = new Alarm(Alarm.ThreadToUse.SWING_THREAD, this)
		disposed = false
		Disposer.register(project, this)
	
		EditorFactory.getInstance().getEventMulticaster().addDocumentListener(new DocumentAdapter() {
			override void documentChanged(DocumentEvent event) {
				var file = FileDocumentManager.getInstance().getFile(event.getDocument())
				if (file != null) {
					fileModified(file)
				} else {
					LOG.info("No virtual file for document. Contents was "+event.document)
				}
			}
		}, project)
		
		VirtualFileManager.getInstance().addVirtualFileListener(new VirtualFileAdapter() {
			override beforePropertyChange(VirtualFilePropertyEvent event) {
				if (event.propertyName == VirtualFile.PROP_NAME) {
					fileDeleted(event.file)
				}
			}
			
			override propertyChanged(VirtualFilePropertyEvent event) {
				if (event.propertyName == VirtualFile.PROP_NAME) {
					fileAdded(event.file)
				}
			}
			
			override void contentsChanged(VirtualFileEvent event) {
				fileModified(event.getFile())
			}

			override void fileCreated(VirtualFileEvent event) {
				fileAdded(event.getFile())
			}
			
			override fileDeleted(VirtualFileEvent event) {
				fileDeleted(event.file)
			}
			
			override beforeFileMovement(VirtualFileMoveEvent event) {
				fileDeleted(event.file)
			}
			
			override void fileMoved(VirtualFileMoveEvent event) {
				fileAdded(event.file)
			}
		}, project)
		
		
		val connection = project.getMessageBus().connect(project);
         connection.subscribe(ProjectTopics.PROJECT_ROOTS, new ModuleRootAdapter() {
										
			override rootsChanged(ModuleRootEvent event) {
				doCleanBuild
			}
         	
         });
         
         connection.subscribe(ProjectTopics.MODULES, new ModuleAdapter() {
			
			override moduleAdded(Project project, Module module) {
				if(project.initialized)
					doCleanBuild(module)
			}
			
			override moduleRemoved(Project project, Module module) {
				chunkedResourceDescriptions.removeContainer(module.name)
				moduleName2GeneratedMapping.remove(module.name)
			}
			
			override modulesRenamed(Project project, List<Module> modules, Function<Module, String> oldNameProvider) {
				for (module : modules) {
					chunkedResourceDescriptions.removeContainer(oldNameProvider.fun(module))
					moduleName2GeneratedMapping.remove(module.name)
					doCleanBuild(module)
				}
			}
			
		})
		
		ProjectWideFacetListenersRegistry.getInstance(project).registerListener(new ProjectWideFacetAdapter<Facet>() {
			
			override facetAdded(Facet facet) {
				if (!isXtextFacet(facet) || !project.initialized) 
					return;
				doCleanBuild(facet.module)
			}
			
			override facetRemoved(Facet facet) {
				if (!isXtextFacet(facet)) 
					return;
				doCleanBuild(facet.module)
			}
			
			override facetConfigurationChanged(Facet facet) {
				if (!isXtextFacet(facet)) 
					return;
				doCleanBuild(facet.module)
			}
			
		}, this)
	}
	
	protected def boolean isXtextFacet(Facet<?> facet) {
		val facetType = facet.type
		return facetType instanceof AbstractFacetType<?>
	}
	
	override dispose() {
		disposed = true
		alarm.cancelAllRequests
		queue.clear
		chunkedResourceDescriptions = chunkedResourceDescriptionsProvider.get
	}
	
	protected def getProject() {
		return myProject
	}
	
	def void fileModified(VirtualFile file) {
		enqueue(MODIFIED, file)
	}

	def void fileDeleted(VirtualFile root) {
		if (root.findModule(ProjectFileIndex.SERVICE.getInstance(project)) === null) {
			return
		}
		val files = newArrayList
		root.processFilesRecursively [ file |
			if(!file.directory) files += file
			true
		]
		enqueue(DELETED, files)
	}

	def void fileAdded(VirtualFile file) {
		if (!file.isDirectory && file.length > 0) {
			enqueue(ADDED, file)
		} else {
			if (LOG.infoEnabled)
				LOG.info("Ignoring new empty file "+file.path+". Waiting for content.")
		}
	}
	
	/**
	 * For testing purposes! When set to <code>true</code>, the builds are not running asynchronously and delayed, but directly when the event comes in
	 */
	public static boolean TEST_MODE = false

	protected def void enqueue(BuildEvent.Type type, VirtualFile ... files) {
		val filteredFiles = files.filter[!excluded]
		if (filteredFiles.empty)
			return;

		enqueue(new BuildEvent(type, filteredFiles))
	}

	protected def void enqueue(BuildEvent buildEvent) {
		if (!disposed && !isLoaded) {
			queueAllResources
		}
		if (LOG.isInfoEnabled) {
			for (uri : buildEvent.filesByURI.keySet)
				LOG.info("Queuing " + buildEvent.type + " - " + uri + ".")
		}
		if (!disposed) {
			queue.put(buildEvent)
			doRunBuild()
		}
	}
	
	protected def doCleanBuild() {
		if (ignoreIncomingEvents) {
			return
		}
		alarm.cancelAllRequests
		chunkedResourceDescriptions = chunkedResourceDescriptionsProvider.get
		safeDeleteUris(moduleName2GeneratedMapping.values.map[allGenerated].flatten.toList)
		moduleName2GeneratedMapping.clear
		queueAllResources
		doRunBuild
	}
	
	protected def doCleanBuild(Module module) {
		if (ignoreIncomingEvents) {
			return
		}
		alarm.cancelAllRequests
		chunkedResourceDescriptions.removeContainer(module.name)
		val before = moduleName2GeneratedMapping.remove(module.name)
		if (before != null) {
			safeDeleteUris(before.allGenerated)
		}
		queueAllResources(module)
		doRunBuild
	}
	
	protected def void safeDeleteUris(List<URI> uris) {
		if (!uris.isEmpty) {
			val app = ApplicationManager.application
			val Runnable runnable = [
					try {
						ignoreIncomingEvents = true
						for (uri : uris) {
							val file = uri.virtualFile
							if (file !== null && file.exists) {
								file.delete(XtextAutoBuilderComponent.this)	
							}
						}
					} finally {
						ignoreIncomingEvents = false
					}
			]
			if (app.dispatchThread)
				app.runWriteAction(runnable)
			else
				app.invokeLater([app.runWriteAction(runnable)], app.defaultModalityState)
		}
	}
	
	boolean avoidBuildInTestMode = false
	
	/**
	 * <p>
	 * Should be used in the test mode only.
	 * </p>
	 * <p>
	 * Collects all events produced by the operation and builds them at once.
	 * </p>
	 */
	def void runOperation(()=>void operation) {
		if (!TEST_MODE)
			throw new IllegalStateException('Should be used only for testing')

		avoidBuildInTestMode = true
		try {
			operation.apply
		} finally {
			avoidBuildInTestMode = false
			doRunBuild
		}
	}
	
	protected def doRunBuild() {
		if (TEST_MODE) {
			if (!avoidBuildInTestMode) {
				(PsiManager.getInstance(getProject()).getModificationTracker() as PsiModificationTrackerImpl).incCounter();
				build
			}
		} else {
			alarm.cancelAllRequests
			cancelIndicators.forEach[canceled = true]
			alarm.addRequest([build], 200, ApplicationManager.application.defaultModalityState)
		}
	}
	
	protected def boolean isExcluded(VirtualFile file) {
		if (ignoreIncomingEvents) {
			if (LOG.isDebugEnabled) 
				LOG.debug("Ignoring transitive file change "+file.path)
			return true;
		}
		return file == null 
			|| file.isDirectory 
	}
	
	protected def boolean isLoaded() {
		return !chunkedResourceDescriptions.isEmpty || !queue.isEmpty
	}
	
	protected def queueAllResources(Module module) {
		val entries = ModuleRootManager.getInstance(module).contentEntries
		for (root :  entries.map[sourceFolderFiles.toSet].flatten) {
			root.visitFileTree[ file |
				if (!file.isDirectory && file.exists) {
					queue.put(new BuildEvent(BuildEvent.Type.ADDED, file))
				}
			]
		}
	}
	
	protected def queueAllResources() {
		val moduleManager = ModuleManager.getInstance(project)
		for (module : ApplicationManager.application.<Module[]>runReadAction[moduleManager.modules]) {
			module.queueAllResources
		}
	}
	
	def void visitFileTree(VirtualFile file, (VirtualFile)=>void handler) {
		if (file.isDirectory) {
			for (child : file.children) {
				visitFileTree(child, handler)
			}
		}
		handler.apply(file)
	}
	
	volatile boolean ignoreIncomingEvents = false
	
	private static val BUILD_MONITOR = new Object()
	
	protected def void build() {
		if (disposed) {
			return
		}
		if (!isReadyToBeBuilt) {
			LOG.info("Project not yet initialized, wait some more")
			alarm.addRequest([build], 500)
		} else {
			if(TEST_MODE) {
				internalBuild(null)
			} else {
				ProgressManager.instance.run(new Task.Backgroundable(project, 'Code Generation...') {
					override run(ProgressIndicator indicator) {
						// we want only one thread to enter this code at any time
						indicator.indeterminate = true
						synchronized (BUILD_MONITOR) {
							internalBuild(indicator)
						}
					}
				})
			}
		}
	}
	
	private def boolean isReadyToBeBuilt() {
		return TEST_MODE || (project.isInitialized && !DumbService.getInstance(project).isDumb)
	}
	
	private List<BuildEvent> unProcessedEvents = newArrayList
	
	protected def void internalBuild(ProgressIndicator indicator) {
		queue.drainTo(unProcessedEvents)
		if (unProcessedEvents.isEmpty) {
			return;
		}
		val app = ApplicationManager.application
		val cancelIndicator = new MutableCancelIndicator(indicator)
		cancelIndicators.add(cancelIndicator)
		val moduleManager = ModuleManager.getInstance(getProject)
		val buildProgressReporter = buildProgressReporterProvider.get
		buildProgressReporter.project = project
		buildProgressReporter.events = new ArrayList(unProcessedEvents)
		try {
			val moduleGraph = app.<Graph<Module>>runReadAction[moduleManager.moduleGraph]
			// deltas are added over the whole build
			val deltas = <IResourceDescription.Delta>newArrayList
			val sortedModules = new ArrayList(moduleGraph.nodes)
			ModuleCompilerUtil.sortModules(project, sortedModules)
			for (module: sortedModules) {
				val fileMappings = moduleName2GeneratedMapping.get(module.name) ?: new Source2GeneratedMapping
				val moduleDescriptions = chunkedResourceDescriptions.getContainer(module.name) ?: new ResourceDescriptionsData(emptyList)
				val changedUris = newHashSet
				val deletedUris = newHashSet
				val contentRoots = ModuleRootManager.getInstance(module).contentRoots
				val events = unProcessedEvents.getEventsForModule(module)
				if (contentRoots.empty
					|| events.isEmpty && deltas.isEmpty) {
					LOG.info("Skipping module '"+module.name+"'. Nothing to do here.")		
				} else {
					collectChanges(events, module, changedUris, deletedUris, deltas)
					
					val newIndex = moduleDescriptions.copy
					val request = new BuildRequest => [
						resourceSet = createResourceSet(module, newIndex)
						dirtyFiles += changedUris
						deletedFiles += deletedUris
						externalDeltas += deltas
						baseDir = contentRoots.head.URI
						// outputs = ??
						state = new IndexState(newIndex, fileMappings.copy)	
						afterValidate = buildProgressReporter
						afterDeleteFile = [
							buildProgressReporter.markAsAffected(it)
						]
						it.cancelIndicator = cancelIndicator
					]
					val result = builderProvider.get().build(request, getServiceProviderProvider(module))
					app.invokeAndWait([
						try {
							ignoreIncomingEvents = true
							val handler = VirtualFileBasedUriHandler.find(request.resourceSet)
							handler.flushToDisk
						} finally {
							ignoreIncomingEvents = false
							buildProgressReporter.rehighlight
						}
					], app.defaultModalityState)
					chunkedResourceDescriptions.setContainer(module.name, result.indexState.resourceDescriptions)
					moduleName2GeneratedMapping.put(module.name, result.indexState.fileMappings)
					deltas.addAll(result.affectedResources)
					unProcessedEvents -= events
				}
			}
			// when everything got processed successfully, we clear this to get rid of any events related to excluded files
			unProcessedEvents.clear
		} catch(Throwable exc) {
			if (operationCanceledManager.isOperationCanceledException(exc)) {
				if (LOG.isInfoEnabled)
					LOG.info("Build canceled.")
			} else {
				LOG.error("Error during auto build.", exc)
			}
		} finally {
			buildProgressReporter.clearProgress
			cancelIndicators.remove(cancelIndicator)
		}
	}
	
	protected def getEventsForModule(List<BuildEvent> events, Module module) {
		val moduleRootManager = ModuleRootManager.getInstance(module)
		val excludeRootUrls = moduleRootManager.excludeRootUrls
		val sourceRootUrls = moduleRootManager.sourceRootUrls
		val result = new LinkedHashSet
		for (event : events) {
			val url = event.filesByURI.keySet.head.toString
			if (excludeRootUrls.forall[!url.isUrlUnderRoot(it)] 
				&& sourceRootUrls.exists[url.isUrlUnderRoot(it)]) {
				result += event
			}
		} 
		return result
	}
	
	static val char SEGMENT_SEPARATOR = '/'

	protected def isUrlUnderRoot(String url, String rootUrl) {
		url.length > rootUrl.length && url.charAt(rootUrl.length) == SEGMENT_SEPARATOR &&
			FileUtil.startsWith(url, rootUrl)
	}
	
	def getServiceProviderProvider(Module module) {
		return [
			val serviceProvider = resourceServiceProviderRegistry.getResourceServiceProvider(it)
			if (serviceProvider != null) {
				val facetProvider = serviceProvider.get(FacetProvider)
				if (facetProvider != null) {
					val facet = facetProvider.getFacet(module)
					if (facet != null) {
						return serviceProvider
					}
				}
			}
			return null
		]
	}
	
	def createResourceSet(Module module, ResourceDescriptionsData newData) {
		val result = resourceSetProvider.get(module)
		val fullIndex = ChunkedResourceDescriptions.findInEmfObject(result)
		fullIndex.setContainer(module.name, newData)
		return result
	}
	
	def String getContainerHandle(Module module) {
		return module.name
	}
	
	protected def collectChanges(Set<BuildEvent> events, Module module, HashSet<URI> changedUris, HashSet<URI> deletedUris, ArrayList<Delta> deltas) {
		val app = ApplicationManager.application
		val fileMappings = moduleName2GeneratedMapping.get(module.name)
		for (event : events) {
			switch event.type {
				case MODIFIED,
				case ADDED: {
					for (uri : event.URIs) {
						val sourceUris = fileMappings?.getSource(uri)
						if (sourceUris != null && !sourceUris.isEmpty) {
							for (sourceUri : sourceUris) {
								consistentAdd(sourceUri, changedUris, deletedUris)
							}									
						} else if (isJavaFile(event.getFile(uri))) {
							deltas += app.<Set<IResourceDescription.Delta>>runReadAction [
								return getJavaDeltas(event.getFile(uri), module)
							]
						} else {
							consistentAdd(uri, changedUris, deletedUris)
						}
					}
				}
				case DELETED : {
					for (uri : event.URIs) {
						val sourceUris = fileMappings?.getSource(uri)
						if (sourceUris != null && !sourceUris.isEmpty) {
							for (sourceUri : sourceUris) {
								consistentAdd(sourceUri, changedUris, deletedUris)
							}									
						} else if (isJavaFile(event.getFile(uri))) {
							deltas += app.<Set<IResourceDescription.Delta>>runReadAction [
								getJavaDeltas(event.getFile(uri), module)
							]
						} else {
							consistentAdd(uri, deletedUris, changedUris)
						}
					}
				}
			}
		}
	}
	
	protected def void consistentAdd(URI uri, Set<URI> toBeAdded, Set<URI> toBeRemoved) {
		toBeAdded += uri
		toBeRemoved -= uri
	}
	
	def boolean isJavaFile(VirtualFile file) {
		file.extension == 'java'
	}
	
	def Set<IResourceDescription.Delta> getJavaDeltas(VirtualFile file, Module module) {
		if (!file.isValid) {
			return emptySet
		}
		val psiFile = PsiManager.getInstance(module.project).findFile(file)
		val result = <IResourceDescription.Delta>newLinkedHashSet
		if (psiFile instanceof PsiJavaFile) {
			for (clazz : psiFile.classes) {
				result += new ChangedDelta(qualifiedNameConverter.toQualifiedName(clazz.qualifiedName)) 
			}
		}
		return result
	}
	
	public def ChunkedResourceDescriptions installCopyOfResourceDescriptions(ResourceSet resourceSet) {
		return chunkedResourceDescriptions.createShallowCopyWith(resourceSet)
	}

	protected def findModule(BuildEvent it, ProjectFileIndex fileIndex) {
		val file = filesByURI.values.head
		if (type == DELETED)
			file.findModule(fileIndex)
		else
			fileIndex.getModuleForFile(file, true)
	}
	
	protected def Module findModule(VirtualFile file, ProjectFileIndex fileIndex) {
		if (file == null) {
			return null
		}
		val module = fileIndex.getModuleForFile(file, true)
		if (module != null)
			return module
		return file.parent.findModule(fileIndex)
	}
	
	override String getComponentName() {
		return "Xtext Compiler Component"
	}
	
	def ChunkedResourceDescriptions getIndexState() {
		return chunkedResourceDescriptions
	}
	
	@FinalFieldsConstructor
	static class MutableCancelIndicator implements CancelIndicator {
		
		val ProgressIndicator indicator

		volatile boolean canceled
		
		override isCanceled() {
			canceled || indicator?.canceled
		}
		
		def setCanceled(boolean canceled) {
			this.canceled = canceled
		}
	}
	
	@Inject XtextAutoBuilderComponentState.Codec codec
	
	override getState() {
		codec.encode(resourceServiceProviderRegistry, chunkedResourceDescriptions, moduleName2GeneratedMapping)
	}
	
	override loadState(XtextAutoBuilderComponentState state) {
		try {
			val installedNow = resourceServiceProviderRegistry.extensionToFactoryMap.keySet
			val installedLastTime = codec.decodeInstalledLanguages(state)
			if (!installedNow.equals(installedLastTime)) {
				LOG.info('Different Xtext plugins than last time. Reindexing project.')
				chunkedResourceDescriptions = chunkedResourceDescriptionsProvider.get
				moduleName2GeneratedMapping.clear
				doCleanBuild
			} else {
				if (LOG.debugEnabled)
					LOG.debug("Loading persisted index state.")
				chunkedResourceDescriptions = codec.decodeIndex(state)
				moduleName2GeneratedMapping = codec.decodeModuleToGenerated(state) 
			}
		} catch (Exception exc) {
			LOG.error('Error loading XtextAutoBuildComponentState ', exc)
			chunkedResourceDescriptions = chunkedResourceDescriptionsProvider.get
			moduleName2GeneratedMapping.clear
			doCleanBuild
		}
	}
	
}
