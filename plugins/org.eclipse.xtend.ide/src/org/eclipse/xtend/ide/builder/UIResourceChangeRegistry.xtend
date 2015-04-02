/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.builder

import com.google.common.collect.HashMultimap
import com.google.inject.Inject
import com.google.inject.Singleton
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.Set
import org.apache.log4j.Logger
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IResourceChangeEvent
import org.eclipse.core.resources.IResourceChangeListener
import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.resources.IResourceDeltaVisitor
import org.eclipse.core.resources.ISaveContext
import org.eclipse.core.resources.ISaveParticipant
import org.eclipse.core.resources.IWorkspace
import org.eclipse.core.runtime.CoreException
import org.eclipse.emf.common.util.URI
import org.eclipse.jdt.core.JavaCore
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.eclipse.xtend.core.macro.declaration.IResourceChangeRegistry
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.builder.impl.BuildScheduler
import org.eclipse.xtext.builder.impl.IBuildFlag
import org.eclipse.xtext.builder.impl.QueuedBuildData
import org.eclipse.xtext.ui.XtextProjectHelper

import static org.eclipse.core.resources.IResourceDelta.*
import java.io.InputStream
import java.io.BufferedOutputStream
import java.io.BufferedInputStream
import java.util.Collections

@Singleton
class UIResourceChangeRegistry implements IResourceChangeListener, IResourceChangeRegistry, IResourceDeltaVisitor {
	static val logger = Logger.getLogger(UIResourceChangeRegistry) 
	
	@Inject QueuedBuildData queue
	@Inject BuildScheduler scheduler
	@Inject AbstractUIPlugin uiPlugin
	
	IWorkspace workspace

	// accessible for testing only
	@Accessors val existsListeners = HashMultimap.<String, URI>create
	@Accessors val charsetListeners = HashMultimap.<String, URI>create
	@Accessors val childrenListeners = HashMultimap.<String, URI>create
	@Accessors val contentsListeners = HashMultimap.<String, URI>create
	// not persisted since it is only a filter for the currently processed CU
	@Accessors val changesNotRelevantListeners = HashMultimap.<String, URI>create
	
	override synchronized registerExists(String path, URI uri) {
		if (!changesNotRelevantListeners.containsEntry(path, uri))
			existsListeners.put(path, uri)
	}
	
	override synchronized registerGetCharset(String path, URI uri) {
		if (!changesNotRelevantListeners.containsEntry(path, uri))
			charsetListeners.put(path, uri)
	}
	
	override synchronized registerGetChildren(String path, URI uri) {
		if (!changesNotRelevantListeners.containsEntry(path, uri))
			childrenListeners.put(path, uri)
	}
	
	override synchronized registerGetContents(String path, URI uri) {
		if (!changesNotRelevantListeners.containsEntry(path, uri))
			contentsListeners.put(path, uri)
	}
	
	override synchronized registerCreateOrModify(String string, URI uri) {
		existsListeners.remove(string, uri)
		charsetListeners.remove(string, uri)
		childrenListeners.remove(string, uri)
		contentsListeners.remove(string, uri)
		changesNotRelevantListeners.put(string, uri)
	}
	
	override synchronized discardCreateOrModifyInformation(URI uri) {
		changesNotRelevantListeners.values.removeAll(Collections.singleton(uri))
	}
	
	override synchronized resourceChanged(IResourceChangeEvent event) {
		event.delta.accept(this)
	}

	// Only called from synchronized context
	override visit(IResourceDelta delta) throws CoreException {
		if (!existsListeners.isEmpty && delta.hasExistsChanged) {
			val interestedFiles = existsListeners.removeAll(delta.resource.fullPath.toString)
			if (!interestedFiles.isEmpty)
				queueURIs(interestedFiles)
		}
		if (!childrenListeners.isEmpty && (delta.hasExistsChanged || delta.hasChildrenChanged)) {
			val interestedFiles = childrenListeners.removeAll(delta.resource.fullPath.toString)
			if (!interestedFiles.isEmpty)
				queueURIs(interestedFiles)
		}
		if (!charsetListeners.empty && (delta.hasExistsChanged || delta.hasCharsetChanged)) {
			val interestedFiles = charsetListeners.removeAll(delta.resource.fullPath.toString)
			if (!interestedFiles.isEmpty)
				queueURIs(interestedFiles)
		}
		if (!contentsListeners.empty && (delta.hasExistsChanged || delta.hasContentsChanged)) {
			val interestedFiles = contentsListeners.removeAll(delta.resource.fullPath.toString)
			if (!interestedFiles.isEmpty)
				queueURIs(interestedFiles)
		}
		return true
	}
	
	protected def queueURIs(Set<URI> interestedFiles) {
		queue.queueURIs(interestedFiles)
	}
	
	
	private def hasExistsChanged(IResourceDelta delta) {
		return delta.kind == ADDED || delta.kind == REMOVED
	}
	
	private def hasChildrenChanged(IResourceDelta delta) {
		if (delta.resource instanceof IFolder) {
			for (c : delta.affectedChildren) {
				if (c.hasExistsChanged)
					return true;
			}
		}
		return false
	}
	
	private def hasCharsetChanged(IResourceDelta delta) {
		return delta.kind == CHANGED && delta.flags.bitwiseAnd(IResourceDelta.ENCODING) != 0
	}
	
	static int HAS_CONTENTS_CHANGED_FLAGS = CONTENT
								.bitwiseOr(ENCODING)
								.bitwiseOr(REPLACED)
								.bitwiseOr(LOCAL_CHANGED)
	
	private def hasContentsChanged(IResourceDelta delta) {
		if (delta.kind == CHANGED) {
			return delta.flags.bitwiseAnd(HAS_CONTENTS_CHANGED_FLAGS) != 0
		} else {
			return false
		}
	}

	@Inject
	def init(IWorkspace workspace) {
		this.workspace = workspace
		load
		workspace.addSaveParticipant(uiPlugin, new ISaveParticipant() {
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
				forgetBuildState
				return
			}
			val in = new BufferedInputStream(new FileInputStream(location))
			try {
				readState(in)
			} finally {
				in.close
			}
		} catch (Exception e) {
			logger.warn("Could not load resource listener registry, scheduling a full build", e)
			forgetBuildState
		}
	}
	
	def readState(InputStream in) {
		val reader = new DataInputStream(in)
		for (map : #[existsListeners, charsetListeners, childrenListeners, contentsListeners]) {
			val urisForExists = reader.readInt
			for(var i = 0; i < urisForExists; i++) {
				val path = reader.readUTF
				val uri = reader.readUTF
				map.put(path, URI.createURI(uri))
			}
		}
	}
	
	private def synchronized save() {
		try {
			val location = registryStateLocation
			val out = new BufferedOutputStream(new FileOutputStream(location))
			try {
				writeState(out)
			} finally {
				out.close
			}
		} catch (Exception e) {
			logger.warn("Could not save resource listener registry", e)
		}
	}
	
	def writeState(OutputStream out) {
		val writer = new DataOutputStream(out)
		for (map : #[existsListeners, charsetListeners, childrenListeners, contentsListeners]) {
			val entries = map.entries
			writer.writeInt(entries.size)
			for (entry : entries) {
				writer.writeUTF(entry.key)
				writer.writeUTF(entry.value.toString)
			}
		}
	}
	
	private def getRegistryStateLocation() {
		uiPlugin.getStateLocation().append("resource.change.registry").toFile
	}
	
	private def forgetBuildState() {
		val projects = workspace.root.projects.filter[
			accessible && hasNature(XtextProjectHelper.NATURE_ID) && hasNature(JavaCore.NATURE_ID)
		]
		scheduler.scheduleBuildIfNecessary(projects, IBuildFlag.FORGET_BUILD_STATE_ONLY)
	}
	
}
