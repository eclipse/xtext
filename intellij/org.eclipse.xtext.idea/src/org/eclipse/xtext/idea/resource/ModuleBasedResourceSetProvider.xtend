/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import com.intellij.openapi.module.Module
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VfsUtilCore
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.URL
import java.util.Map
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.URIHandler
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.XtextResourceSet
import com.intellij.openapi.fileEditor.FileDocumentManager
import org.eclipse.xtext.util.internal.Log

@Singleton @Log
class ModuleBasedResourceSetProvider {
	
	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	def get(Module context) {
		val resourceSet = resourceSetProvider.get
		resourceSet.classpathURIContext = context
		resourceSet.URIConverter.URIHandlers.add(0, new VirtualFileBasedUriHandler()) 
		return resourceSet
	}
	
	public static class VirtualFileBasedUriHandler implements URIHandler {
		
		@Accessors Map<URI, byte[]> writtenContents = newHashMap()
		@Accessors Set<URI> deleted = newHashSet()
		
		override canHandle(URI uri) {
			return findFile(uri) != null
		}
		
		def flushToDisk() {
			if (LOG.isDebugEnabled) {
				LOG.debug("writing : "+writtenContents.keySet.join(', '))
				LOG.debug("deleting: "+deleted.join(', '))
			}
			val localWritten = writtenContents
			writtenContents = newHashMap()
			val localDeleted = deleted
			deleted = newHashSet()
			if (localDeleted.empty && localWritten.empty) {
				return;
			}
			val timeStamp = System.currentTimeMillis
			for (uri : localWritten.keySet) {
				val file = findFile(uri)
				file.setBinaryContent(localWritten.get(uri), -1, timeStamp, requestor)
			}
			for (uri : localDeleted) {
				val file = findFile(uri)
				file.delete(requestor)
			}
		}
		
		def findFile(URI uri) {
			val url = uri.toURL
			if (url == null) {
				return null;
			}
			VfsUtil.findFileByURL(url)
		}
		
		protected def URL toURL(URI uri) {
			if (uri == null) {
				return null
			}
			return VfsUtilCore.convertToURL(uri.toString)
		}
		
		override contentDescription(URI uri, Map<?, ?> options) throws IOException {
			emptyMap
		}
		
		override createInputStream(URI uri, Map<?, ?> options) throws IOException {
			if (deleted.contains(uri)) {
				throw new IllegalStateException("resource "+uri+" is deleted.")
			}
			if (writtenContents.containsKey(uri)) {
				return new ByteArrayInputStream(writtenContents.get(uri))
			}
			val virtualFile = findFile(uri)
			val doc = FileDocumentManager.getInstance().getCachedDocument(virtualFile)
			if (doc != null) {
				return new ByteArrayInputStream(doc.text.getBytes(virtualFile.charset))
			}
			return virtualFile.inputStream
		}
		
		override createOutputStream(URI uri, Map<?, ?> options) throws IOException {
			return new ByteArrayOutputStream() {
				override close() throws IOException {
					super.close()
					val bytes = toByteArray
					deleted.remove(uri)
					writtenContents.put(uri, bytes)
				}
			}
		}
		
		override delete(URI uri, Map<?, ?> options) throws IOException {
			writtenContents.remove(uri)
			deleted.add(uri)
		}
	
		def getRequestor() {
			//TODO
			null
		}
		
		override exists(URI uri, Map<?, ?> options) {
			if (deleted.contains(uri)) {
				return false
			}
			if (writtenContents.containsKey(uri)) {
				return true
			}
			return findFile(uri).exists
		}
		
		override getAttributes(URI uri, Map<?, ?> options) {
			emptyMap
		}
		
		override setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
		}
		
	}
}