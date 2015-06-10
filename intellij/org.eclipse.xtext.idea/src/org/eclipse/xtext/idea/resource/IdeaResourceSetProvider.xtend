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
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.module.Module
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.Map
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.URIHandler
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.internal.Log

import static org.eclipse.xtext.idea.resource.IdeaResourceSetProvider.*
import static org.eclipse.xtext.idea.resource.VirtualFileURIUtil.*
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.xtext.EcoreUtil2

@Singleton @Log
class IdeaResourceSetProvider {
	
	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	def get(Module context) {
		val resourceSet = resourceSetProvider.get
		resourceSet.classpathURIContext = context
		resourceSet.URIConverter.URIHandlers.clear 
		resourceSet.URIConverter.URIHandlers.add(new VirtualFileBasedUriHandler()) 
		return resourceSet
	}
	
	public static class VirtualFileBasedUriHandler implements URIHandler {
		
		public static def VirtualFileBasedUriHandler find(Notifier notifier) {
			EcoreUtil2.getResourceSet(notifier).URIConverter.URIHandlers.filter(VirtualFileBasedUriHandler).head
		} 
		
		@Accessors Map<URI, byte[]> writtenContents = newHashMap()
		@Accessors Set<URI> deleted = newHashSet()
		
		override canHandle(URI uri) {
			return true
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
				var file = getOrCreateVirtualFile(uri)
				file.setBinaryContent(localWritten.get(uri), -1, timeStamp, requestor)
			}
			for (uri : localDeleted) {
				val file = getVirtualFile(uri)
				if (file != null && file.exists)
					file.delete(requestor)
			}
		}
		
		override contentDescription(URI uri, Map<?,?> options) throws IOException {
			emptyMap
		}
		
		override createInputStream(URI uri, Map<?, ?> options) throws IOException {
			if (deleted.contains(uri)) {
				throw new IllegalStateException("resource "+uri+" is deleted.")
			}
			if (writtenContents.containsKey(uri)) {
				return new ByteArrayInputStream(writtenContents.get(uri))
			}
			val virtualFile = getVirtualFile(uri)
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
			null
		}
		
		override exists(URI uri, Map<?, ?> options) {
			if (deleted.contains(uri)) {
				return false
			}
			if (writtenContents.containsKey(uri)) {
				return true
			}
			return getVirtualFile(uri)?.exists
		}
		
		override getAttributes(URI uri, Map<?, ?> options) {
			emptyMap
		}
		
		override setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
		}
		
	}
}