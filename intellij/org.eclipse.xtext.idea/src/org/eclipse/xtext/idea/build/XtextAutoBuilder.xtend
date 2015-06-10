/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build

import com.google.common.collect.HashMultimap
import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.module.Module
import com.intellij.openapi.progress.ProcessCanceledException
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.OrderEnumerator
import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.Alarm
import java.util.List
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest
import org.eclipse.xtext.builder.standalone.incremental.IncrementalBuilder
import org.eclipse.xtext.builder.standalone.incremental.IndexState
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider.VirtualFileBasedUriHandler
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider
import org.eclipse.xtext.idea.shared.XtextLanguages
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.util.internal.Log

import static org.eclipse.xtext.idea.build.BuildEvent.Type.*

import static extension org.eclipse.xtext.idea.resource.VirtualFileURIUtil.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Log class XtextAutoBuilder implements Disposable {
	
	boolean disposed
	
	BlockingQueue<BuildEvent> queue = new LinkedBlockingQueue<BuildEvent>()

	Alarm alarm 

	Project project
	
	@Inject Provider<IncrementalBuilder> builderProvider	
	
	@Inject Provider<BuildProgressReporter> buildProgressReporterProvider	
	 
	@Inject XtextLanguages xtextLanguages
	
	@Inject IdeaResourceSetProvider resourceSetProvider
	
	IndexState indexState
	
	new(Project project) {
		IdeaSharedInjectorProvider.injector.injectMembers(this)
		this.project = project
		alarm = new Alarm(Alarm.ThreadToUse.OWN_THREAD, this)
		disposed = false
		Disposer.register(project, this)
	}
	
	override dispose() {
		alarm.cancelAllRequests
		queue.clear
		disposed = true
	}

	def void fileModified(VirtualFile file) {
		enqueue(file, MODIFIED)
	}

	def void fileDeleted(VirtualFile file) {
		enqueue(file, DELETED)
	}

	def void fileAdded(VirtualFile file) {
		enqueue(file, ADDED)
	}

	protected def enqueue(VirtualFile file, BuildEvent.Type type) {
		if (!disposed && !isLoaded()) {
			queueAllResources()
		}
		if (LOG.isDebugEnabled) {
			LOG.debug("queuing "+file.URI)
		}
		if (file != null && !disposed) {
			queue.put(new BuildEvent(file, type))
			alarm.cancelAllRequests
			alarm.addRequest([build], 200)
		}
	}
	
	protected def boolean isLoaded() {
		if (indexState != null || !queue.isEmpty)
			return true;
		return false;
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
	
	protected def void build() {
		if (disposed) {
			return
		}
		val allEvents = newArrayList
		queue.drainTo(allEvents)
		build(allEvents)
	}

	public def void build(List<BuildEvent> allEvents) {
		val buildProgressReporter = buildProgressReporterProvider.get 
		buildProgressReporter.project = project
		try {
			val module2event = HashMultimap.create
			val fileIndex = ProjectFileIndex.SERVICE.getInstance(project)
			allEvents.forEach [
				val module = findModule(fileIndex)
				if(module != null)
					module2event.put(module, it)
			]
			for(module: module2event.keySet) {
				val events = module2event.get(module)
				val entries = OrderEnumerator.orderEntries(module)
				val request = new BuildRequest => [
					resourceSet = resourceSetProvider.get(module)
					dirtyFiles += events.filter[type==MODIFIED || type == ADDED].map[file.URI]
					deletedFiles += events.filter[type == DELETED].map[file.URI]
					classPath += entries.withoutSdk.classes.pathsList.virtualFiles.filter[/* HACK! we need to properly exclude the out put dir */!isDirectory].map[URI]
					baseDir = ModuleRootManager.getInstance(module).contentRoots.head.URI
					sourceRoots += entries.withoutSdk.withoutLibraries.withoutDepModules.sources.pathsList.virtualFiles.map[URI]
					// outputs = ??
					failOnValidationError = false
					previousState = indexState ?: new IndexState()

					afterValidate = buildProgressReporter
					afterDeleteFile = [
						buildProgressReporter.markAsAffected(it)
					]
				]
				val app = ApplicationManager.application
				indexState = app.<IndexState>runReadAction [
					builderProvider.get().build(request, xtextLanguages.languageAccesses)
				]
				app.invokeAndWait([
					app.runWriteAction [
						val handler = VirtualFileBasedUriHandler.find(request.resourceSet)
						handler.flushToDisk
					]
				], ModalityState.any)
				
			}
		} catch(ProcessCanceledException exc) {
			queue.addAll(allEvents)
		} finally {
			buildProgressReporter.clearProgress
		}
	}
	
	protected def getIndexState() {
		if (indexState == null) {
			if (!isLoaded()) {
				queueAllResources
				alarm.cancelAllRequests
				alarm.addRequest([build], 200)
			}
			return new IndexState()
		}
		return indexState		
	}
	
	public def IResourceDescriptions getResourceDescriptions() {
		getIndexState.resourceDescriptions
	}

	protected def findModule(BuildEvent it, ProjectFileIndex fileIndex) {
		if (xtextLanguages.languageAccesses.get(file.extension) == null) {
			return null
		}
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
		file.parent.findModule(fileIndex)
	}
	
}