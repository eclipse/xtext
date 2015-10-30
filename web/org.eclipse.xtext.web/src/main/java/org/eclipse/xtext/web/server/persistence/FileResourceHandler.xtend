/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.persistence

import com.google.inject.Provider
import java.io.IOException
import java.io.OutputStreamWriter
import java.util.List
import javax.inject.Inject
import org.eclipse.emf.common.util.WrappedException
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider
import org.eclipse.xtext.web.server.model.IXtextWebDocument
import org.eclipse.xtext.web.server.model.XtextWebDocument

/**
 * Resource handler that reads and writes files. The file paths are given by an implementation
 * of {@link IResourceBaseProvider}.
 */
class FileResourceHandler implements IServerResourceHandler {
	
	@Inject IResourceBaseProvider resourceBaseProvider
	
	@Inject IWebResourceSetProvider resourceSetProvider
	
	@Inject Provider<XtextWebDocument> documentProvider
	
	@Inject IEncodingProvider encodingProvider
	
	override get(String resourceId) throws IOException {
		try {
			val uri = resourceBaseProvider.getFileURI(resourceId)
			if (uri === null)
				throw new IOException('The requested resource does not exist.')
			val resourceSet = resourceSetProvider.get(resourceId)
			val resource = resourceSet.getResource(uri, true) as XtextResource
			
			return documentProvider.get() => [
				setInput(resource, resourceId)
			]
		} catch (WrappedException exception) {
			throw exception.cause
		}
	}
	
	override put(IXtextWebDocument document) throws IOException {
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