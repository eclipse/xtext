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
import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.components.AbstractProjectComponent
import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.editor.event.DocumentAdapter
import com.intellij.openapi.editor.event.DocumentEvent
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.ModuleAdapter
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModuleRootAdapter
import com.intellij.openapi.roots.ModuleRootEvent
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileAdapter
import com.intellij.openapi.vfs.VirtualFileEvent
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.openapi.vfs.VirtualFileMoveEvent
import com.intellij.psi.PsiJavaFile
import com.intellij.psi.PsiManager
import com.intellij.psi.impl.PsiModificationTrackerImpl
import com.intellij.util.Alarm
import com.intellij.util.Function
import com.intellij.util.graph.Graph
import java.util.ArrayList
import java.util.HashSet
import java.util.List
import java.util.Map
import java.util.Set
import java.util.concurrent.LinkedBlockingQueue
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
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
import static org.eclipse.xtext.idea.build.XtextAutoBuilderComponent.*

import static extension org.eclipse.xtext.idea.resource.VirtualFileURIUtil.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Log class XtextAutoBuilderComponent extends AbstractProjectComponent implements Disposable {
	
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
	
	Map<Module, Source2GeneratedMapping> module2GeneratedMapping = newHashMap()
	
	def Iterable<URI> getGeneratedSources(URI source) {
		return module2GeneratedMapping.values.map[getGenerated(source)].flatten.toList
	}
	
	def Iterable<URI> getSource4GeneratedSource(URI generated) {
		return module2GeneratedMapping.values.map[getSource(generated)].flatten.toList
	}
	
	new(Project project) {
		super(project)
		TEST_MODE = ApplicationManager.application.isUnitTestMode
		IdeaSharedInjectorProvider.injector.injectMembers(this)
		this.chunkedResourceDescriptions = chunkedResourceDescriptionsProvider.get
		this.project = project
		alarm = new Alarm(Alarm.ThreadToUse.OWN_THREAD, this)
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
			override void contentsChanged(VirtualFileEvent event) {
				fileModified(event.getFile())
			}

			override void fileCreated(VirtualFileEvent event) {
				fileAdded(event.getFile())
			}

			override void fileDeleted(VirtualFileEvent event) {
				fileDeleted(event.getFile())
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
				doCleanBuild(module)
			}
			
			override moduleRemoved(Project project, Module module) {
				chunkedResourceDescriptions.removeContainer(module.name)
				module2GeneratedMapping.remove(module)
			}
			
			override modulesRenamed(Project project, List<Module> modules, Function<Module, String> oldNameProvider) {
				for (module : modules) {
					chunkedResourceDescriptions.removeContainer(oldNameProvider.fun(module))
					module2GeneratedMapping.remove(module)
					doCleanBuild(module)
				}
			}
			
		})
		
		ProjectWideFacetListenersRegistry.getInstance(project).registerListener(new ProjectWideFacetAdapter<Facet>() {
			
			override facetAdded(Facet facet) {
				if (!isXtextFacet(facet)) 
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
		enqueue(file, MODIFIED)
	}

	def void fileDeleted(VirtualFile file) {
		enqueue(file, DELETED)
	}

	def void fileAdded(VirtualFile file) {
		if (!file.isDirectory && file.length > 0) {
			enqueue(file, ADDED)
		} else {
			if (LOG.infoEnabled)
				LOG.info("Ignoring new empty file "+file.path+". Waiting for content.")
		}
	}
	
	/**
	 * For testing purposes! When set to <code>true</code>, the builds are not running asynchronously and delayed, but directly when the event comes in
	 */
	public static boolean TEST_MODE = false

	protected def enqueue(VirtualFile file, BuildEvent.Type type) {
		if (isExcluded(file)) {
			return;
		}
		if (!disposed && !isLoaded) {
			queueAllResources
		}
		if (LOG.isInfoEnabled) {
			LOG.info("Queuing "+type+" - "+file.URI+".")
		}
		if (file != null && !disposed) {
			queue.put(new BuildEvent(file, type))
			doRunBuild()
		}
	}
	
	protected def doCleanBuild() {
		if (ignoreIncomingEvents) {
			return
		}
		alarm.cancelAllRequests
		chunkedResourceDescriptions = chunkedResourceDescriptionsProvider.get
		safeDeleteUris(module2GeneratedMapping.values.map[allGenerated].flatten.toList)
		module2GeneratedMapping.clear
		queueAllResources
		doRunBuild
	}
	
	protected def doCleanBuild(Module module) {
		if (ignoreIncomingEvents) {
			return
		}
		alarm.cancelAllRequests
		chunkedResourceDescriptions.removeContainer(module.name)
		val before = module2GeneratedMapping.remove(module)
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
							if (file!== null && file.exists) {
									file.delete(XtextAutoBuilderComponent.this)	
							}
						}
					} finally {
						ignoreIncomingEvents = false
					}
			]
			if (app.isDispatchThread) {
				app.runWriteAction(runnable)
			} else {
				app.invokeLater[app.runWriteAction(runnable)]
			}
		}
	}
	
	protected def doRunBuild() {
		if (TEST_MODE) {
			(PsiManager.getInstance(getProject()).getModificationTracker() as PsiModificationTrackerImpl).incCounter();
			build
		} else {
			alarm.cancelAllRequests
			cancelIndicators.forEach[canceled = true]
			alarm.addRequest([build], 200)
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
					queue.put(new BuildEvent(file, BuildEvent.Type.ADDED))
				}
			]
		}
	}
	
	protected def queueAllResources() {
		val baseFile = project.baseDir
		baseFile.visitFileTree[ file |
			if (!file.isDirectory && file.exists) {
				queue.put(new BuildEvent(file, BuildEvent.Type.ADDED))
			}
		]
	}
	
	def void visitFileTree(VirtualFile file, (VirtualFile)=>void handler) {
		if (file.isDirectory) {
			for (child : file.children) {
				visitFileTree(child, handler)
			}
		}
		handler.apply(file)
	}
	
	private volatile boolean ignoreIncomingEvents = false
	
	protected def void build() {
		if (disposed) {
			return
		}
		if (isReadyToBeBuilt) {
			LOG.info("Project not yet initialized, wait some more")
			alarm.addRequest([build], 500)
		} else {
			val allEvents = newArrayList
			queue.drainTo(allEvents)
			internalBuild(allEvents)
		}
	}
	
	private def boolean isReadyToBeBuilt() {
		return !TEST_MODE && !project.isInitialized && !DumbService.getInstance(project).isDumb
	}
	
	protected def void internalBuild(List<BuildEvent> allEvents) {
		val unProcessedEvents = newArrayList
		unProcessedEvents += allEvents
		val app = ApplicationManager.application
		val cancelIndicator = new MutableCancelIndicator
		cancelIndicators.add(cancelIndicator)
		val moduleManager = ModuleManager.getInstance(getProject)
		val buildProgressReporter = buildProgressReporterProvider.get 
		buildProgressReporter.project = project
		try {
			val fileIndex = ProjectFileIndex.SERVICE.getInstance(project)
			val moduleGraph = app.<Graph<Module>>runReadAction[moduleManager.moduleGraph]
			// deltas are added over the whole build
			val deltas = <IResourceDescription.Delta>newArrayList
			val sortedModules = new ArrayList(moduleGraph.nodes)
			ModuleCompilerUtil.sortModules(project, sortedModules)
			for (module: sortedModules) {
				val fileMappings = module2GeneratedMapping.get(module) ?: new Source2GeneratedMapping
				val moduleDescriptions = chunkedResourceDescriptions.getContainer(module.name) ?: new ResourceDescriptionsData(emptyList)
				val changedUris = newHashSet
				val deletedUris = newHashSet
				val contentRoots = ModuleRootManager.getInstance(module).contentRoots
				val events = allEvents.filter[event| event.findModule(fileIndex) == module].toSet
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
						}
					], ModalityState.any)
					chunkedResourceDescriptions.setContainer(module.name, result.indexState.resourceDescriptions)
					module2GeneratedMapping.put(module, result.indexState.fileMappings)
					deltas.addAll(result.affectedResources)
					unProcessedEvents -= events
				}
			}
		} catch(Throwable exc) {
			if (operationCanceledManager.isOperationCanceledException(exc)) {
				if (LOG.isInfoEnabled)
					LOG.info("Build canceled.")
				queue.addAll(unProcessedEvents)
			} else {
				LOG.error("Error during auto build.", exc)
			}
		} finally {
			buildProgressReporter.clearProgress
			cancelIndicators.remove(cancelIndicator)
		}
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
		val fileMappings = module2GeneratedMapping.get(module)
		for (event : events) {
			switch event.type {
				case MODIFIED,
				case ADDED: {
					val uri = event.file.URI
					val sourceUris = fileMappings?.getSource(uri)
					if (sourceUris != null && !sourceUris.isEmpty) {
						for (sourceUri : sourceUris) {
							changedUris += sourceUri
						}									
					} else if (isJavaFile(event.file)) {
						deltas += app.<Set<IResourceDescription.Delta>>runReadAction [
							return getJavaDeltas(event.file, module)
						]
					} else {
						changedUris += uri
					}
				}
				case DELETED : {
					val uri = event.file.URI
					val sourceUris = fileMappings?.getSource(uri)
					if (sourceUris != null && !sourceUris.isEmpty) {
						for (sourceUri : sourceUris) {
							changedUris += sourceUri
						}									
					} else if (isJavaFile(event.file)) {
						deltas += app.<Set<IResourceDescription.Delta>>runReadAction [
							getJavaDeltas(event.file, module)
						]
					} else {
						deletedUris += uri
					}
				}
			}
		}
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
	
	static class MutableCancelIndicator implements CancelIndicator {
		volatile boolean canceled
		override isCanceled() {
			canceled
		}
		
		def setCanceled(boolean canceled) {
			this.canceled = canceled
		}
		
	}
}
