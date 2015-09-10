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
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.module.Module
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.util.Arrays
import java.util.Map
import java.util.Set
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.URIHandler
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent
import org.eclipse.xtext.idea.common.types.StubTypeProviderFactory
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.LazyStringInputStream
import org.eclipse.xtext.util.internal.Log

import static org.eclipse.emf.ecore.resource.URIConverter.*

import static extension org.eclipse.xtext.idea.resource.VirtualFileURIUtil.*

@Singleton @Log
class IdeaResourceSetProvider {

	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	@Inject StubTypeProviderFactory stubTypeProviderFactory

	@Inject ProjectDescriptionProvider projectDescriptionProvider

	def get(Module module) {
		val resourceSet = resourceSetProvider.get
		resourceSet.classpathURIContext = module
		resourceSet.URIConverter.URIHandlers.clear
		resourceSet.URIConverter.URIHandlers.add(new VirtualFileBasedUriHandler)

		val desc = projectDescriptionProvider.getProjectDescription(module)
		desc.attachToEmfObject(resourceSet)

		val builder = module.project.getComponent(XtextAutoBuilderComponent)
		builder.installCopyOfResourceDescriptions(resourceSet)

		stubTypeProviderFactory.createTypeProvider(resourceSet)
		return resourceSet
	}

	public static class VirtualFileBasedUriHandler implements URIHandler {

		@Accessors
		public static class ContentDescriptor {
			byte[] content
			long timeStamp
		}

		public static def VirtualFileBasedUriHandler find(Notifier notifier) {
			EcoreUtil2.getResourceSet(notifier).URIConverter.URIHandlers.filter(VirtualFileBasedUriHandler).head
		}

		@Accessors Map<URI, ContentDescriptor> writtenContents = newHashMap
		@Accessors Set<URI> deleted = newHashSet

		override canHandle(URI uri) {
			return true
		}

		def flushToDisk() {
			if (LOG.isDebugEnabled) {
				LOG.debug("writing : " + writtenContents.keySet.join(', '))
				LOG.debug("deleting: " + deleted.join(', '))
			}
			val localWritten = writtenContents
			writtenContents = newHashMap
			val localDeleted = deleted
			deleted = newHashSet
			if (localDeleted.empty && localWritten.empty) {
				return;
			}
			ApplicationManager.application.runWriteAction [
				FileDocumentManager.instance.saveAllDocuments

				for (uri : localWritten.keySet) {
					var file = getOrCreateVirtualFile(uri)
					val contentDescriptor = localWritten.get(uri)
					val newContent = contentDescriptor.content
					val oldContent = file.contentsToByteArray
					if (!Arrays.equals(newContent, oldContent))
						file.setBinaryContent(newContent, -1, contentDescriptor.timeStamp, requestor)
				}
				for (uri : localDeleted) {
					val file = getVirtualFile(uri)
					if (file != null && file.exists)
						file.delete(requestor)
				}
			]
		}

		override contentDescription(URI uri, Map<?, ?> options) throws IOException {
			emptyMap
		}

		override createInputStream(URI uri, Map<?, ?> options) throws IOException {
			if (deleted.contains(uri)) {
				throw new IOException("resource " + uri + " is deleted.")
			}
			if (writtenContents.containsKey(uri)) {
				return new ByteArrayInputStream(writtenContents.get(uri).content)
			}
			val virtualFile = getVirtualFile(uri)
			if (virtualFile == null) {
				throw new FileNotFoundException("Couldn't find virtual file for " + uri)
			}

			val cachedDocument = FileDocumentManager.instance.getCachedDocument(virtualFile)
			if (cachedDocument != null) {
				return new LazyStringInputStream(cachedDocument.text, virtualFile.charset)
			}

			return ApplicationManager.application.<InputStream>runReadAction [
				return new ByteArrayInputStream(virtualFile.contentsToByteArray)
			]
		}

		override createOutputStream(URI uri, Map<?, ?> options) throws IOException {
			return new ByteArrayOutputStream() {
				override close() throws IOException {
					super.close()
					val bytes = toByteArray
					deleted.remove(uri)

					val contentDescriptor = new ContentDescriptor
					contentDescriptor.content = bytes
					contentDescriptor.timeStamp = System.currentTimeMillis
					writtenContents.put(uri, contentDescriptor)
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
			if (uri.folderDescriptor != null) {
				return true
			}
			return getVirtualFile(uri)?.exists
		}

		override getAttributes(URI uri, Map<?, ?> options) {
			if (deleted.contains(uri))
				return emptyMap

			val requestedAttributes = options.get(OPTION_REQUESTED_ATTRIBUTES) as Set<String>
			if (requestedAttributes == null || requestedAttributes.empty)
				return emptyMap

			val fileDescriptor = writtenContents.get(uri)
			if (fileDescriptor != null) {
				val attributes = newHashMap
				if (requestedAttributes.contains(ATTRIBUTE_DIRECTORY))
					attributes.put(ATTRIBUTE_DIRECTORY, false)
				if (requestedAttributes.contains(ATTRIBUTE_TIME_STAMP))
					attributes.put(ATTRIBUTE_TIME_STAMP, fileDescriptor.timeStamp)
				return attributes
			}

			val folderDescriptor = uri.folderDescriptor
			if (folderDescriptor != null) {
				val attributes = newHashMap
				if (requestedAttributes.contains(ATTRIBUTE_DIRECTORY))
					attributes.put(ATTRIBUTE_DIRECTORY, true)
				if (requestedAttributes.contains(ATTRIBUTE_TIME_STAMP))
					attributes.put(ATTRIBUTE_TIME_STAMP, folderDescriptor.timeStamp)
				return attributes
			}

			val file = uri.virtualFile
			if (file != null) {
				val attributes = newHashMap
				if (requestedAttributes.contains(ATTRIBUTE_DIRECTORY))
					attributes.put(ATTRIBUTE_DIRECTORY, file.directory)
				if (requestedAttributes.contains(ATTRIBUTE_TIME_STAMP))
					attributes.put(ATTRIBUTE_TIME_STAMP, file.timeStamp)
				return attributes
			}

			return emptyMap
		}

		protected def getFolderDescriptor(URI uri) {
			writtenContents.entrySet.filter[ fileDescriptor |
				val relativeURI = fileDescriptor.key.deresolve(uri)
				relativeURI != fileDescriptor.key
			].head?.value
		}

		override setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
		}

		def getChildren(URI uri) {
			val file = uri.virtualFile
			val children = if (file != null)
					file.children.map[URI].toSet
				else
					newLinkedHashSet
					
			children += writtenContents.keySet.map[ uriToWrite |
				val relativeURI = uriToWrite.deresolve(uri)
				if (!relativeURI.empty && relativeURI != uriToWrite) {
					relativeURI.trimSegments(relativeURI.segmentCount - 1).resolve(uri)	
				}
			].filterNull
			
			children -= deleted
					
			children
		}

	}
}