/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.builder

import com.google.common.collect.HashMultimap
import com.google.common.io.Files
import com.google.inject.Inject
import com.google.inject.Singleton
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.EOFException
import java.io.FileInputStream
import java.io.FileOutputStream
import org.apache.log4j.Logger
import org.eclipse.core.resources.IResourceChangeEvent
import org.eclipse.core.resources.IResourceChangeListener
import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.resources.IResourceDeltaVisitor
import org.eclipse.core.resources.ISaveContext
import org.eclipse.core.resources.ISaveParticipant
import org.eclipse.core.resources.IWorkspace
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.macro.declaration.ResourceChangeRegistry
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.ide.internal.XtendActivator
import org.eclipse.xtext.builder.impl.BuildScheduler
import org.eclipse.xtext.builder.impl.IBuildFlag
import org.eclipse.xtext.builder.impl.QueuedBuildData
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.jdt.core.JavaCore
import java.io.File

@Singleton
class UIResourceChangeRegistry implements IResourceChangeListener, ResourceChangeRegistry, IResourceDeltaVisitor {
	static val logger = Logger.getLogger(UIResourceChangeRegistry) 
	
	@Inject
	QueuedBuildData queue
	@Inject
	BuildScheduler scheduler
	IWorkspace workspace

	val listeners = HashMultimap.<IPath, URI>create

	override synchronized resourceChanged(IResourceChangeEvent event) {
		event.delta.accept(this)
	}

	override synchronized void register(IPath resourcePath, XtendFile interestedFile) {
		listeners.put(resourcePath, interestedFile.eResource.URI)
	}

	override visit(IResourceDelta delta) throws CoreException {
		val interestedFiles = listeners.removeAll(delta.resource.fullPath)
		queue.queueURIs(interestedFiles)
		true
	}

	@Inject
	def init(IWorkspace workspace) {
		this.workspace = workspace
		load
		workspace.addSaveParticipant(XtendActivator.getInstance, new ISaveParticipant() {
			override saving(ISaveContext context) throws CoreException {
				save
			}
			override doneSaving(ISaveContext context) {}
			
			override prepareToSave(ISaveContext context) throws CoreException {}
			
			override rollback(ISaveContext context) {}
		})
		workspace.addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE)
	}
	
	private def synchronized load() {
		try {
			val location = registryStateLocation
			if (!location.exists) {
				scheduleFullBuild
				return
			}
			val in = new FileInputStream(location)
			try {
				val reader = new DataInputStream(in)
				try {
					while(true) {
						val path = reader.readUTF
						val numberOfUris = reader.readInt
						for(var i = 0; i < numberOfUris; i++) {
							val uri = reader.readUTF
							listeners.put(new Path(path), URI.createURI(uri))
						}
					}
				} catch (EOFException eof) {}
			} finally {
				in.close
			}
		} catch (Exception e) {
			logger.warn("Could not load resource listener registry, scheduling a full build", e)
			scheduleFullBuild
		}
	}
	
	private def synchronized save() {
		try {
			val location = registryStateLocation
			Files.touch(location)
			val out = new FileOutputStream(location)
			try {
				val writer = new DataOutputStream(out)
				listeners.asMap.entrySet.forEach[entry|
					writer.writeUTF(entry.key.toString)
					writer.writeInt(entry.value.size)
					entry.value.forEach[uri|
						writer.writeUTF(uri.toString)
					]
				]
			} finally {
				out.close
			}
		} catch (Exception e) {
			logger.warn("Could not save resource listener registry", e)
		}
	}
	
	var File cachedStateLocation
	
	private def getRegistryStateLocation() {
		if (cachedStateLocation === null) {
			cachedStateLocation = XtendActivator.getInstance.getStateLocation().append("resource.change.registry").toFile
		}
		cachedStateLocation
	}
	
	private def scheduleFullBuild() {
		val projects = workspace.root.projects.filter[
			hasNature(XtextProjectHelper.NATURE_ID) && hasNature(JavaCore.NATURE_ID)
		]
		scheduler.scheduleBuildIfNecessary(projects, IBuildFlag.FORGET_BUILD_STATE_ONLY)
	}
}
