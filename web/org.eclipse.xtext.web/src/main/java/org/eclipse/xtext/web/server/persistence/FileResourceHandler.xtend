/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.persistence

import com.google.inject.Inject
import java.io.IOException
import java.io.OutputStreamWriter
import org.eclipse.emf.common.util.WrappedException
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.web.server.IServiceContext
import org.eclipse.xtext.web.server.model.IWebDocumentProvider
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider
import org.eclipse.xtext.web.server.model.IXtextWebDocument

/**
 * Resource handler that reads and writes files. The file paths are given by an implementation
 * of {@link IResourceBaseProvider}.
 */
class FileResourceHandler implements IServerResourceHandler {
	
	@Inject IResourceBaseProvider resourceBaseProvider
	
	@Inject IWebResourceSetProvider resourceSetProvider
	
	@Inject IWebDocumentProvider documentProvider
	
	@Inject IEncodingProvider encodingProvider
	
	override get(String resourceId, IServiceContext serviceContext) throws IOException {
		try {
			val uri = resourceBaseProvider.getFileURI(resourceId)
			if (uri === null)
				throw new IOException('The requested resource does not exist.')
			val resourceSet = resourceSetProvider.get(resourceId, serviceContext)
			val resource = resourceSet.getResource(uri, true) as XtextResource
			return documentProvider.get(resourceId, serviceContext) => [
				setInput(resource)
			]
		} catch (WrappedException exception) {
			throw exception.cause
		}
	}
	
	override put(IXtextWebDocument document, IServiceContext serviceContext) throws IOException {
		try {
			val uri = resourceBaseProvider.getFileURI(document.resourceId)
			val outputStream = document.resource.resourceSet.URIConverter.createOutputStream(uri)
			val writer = new OutputStreamWriter(outputStream, encodingProvider.getEncoding(uri))
			writer.write(document.text)
			writer.close
		} catch (WrappedException exception) {
			throw exception.cause
		}
	}
	
}