/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.generator

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess

/**
 * Service class for code generation. The resulting documents are sent back to the client;
 * if exactly one document is generated, the result is unwrapped, i.e. the response body
 * is the generated document.
 */
@Singleton
class GeneratorService {
	
	@Inject IGenerator generator
	
	@Inject IContentTypeProvider contentTypeProvider
	
	/**
	 * 
	 */
	def GeneratorResult generate(XtextWebDocumentAccess document) throws InvalidRequestException {
		val fileSystemAccess = document.readOnly[ it, cancelIndicator |
			val fileSystemAccess = new ResponseFileSystemAccess
			generator.doGenerate(resource, fileSystemAccess)
			return fileSystemAccess
		]
		val result = new GeneratorResult
		result.entries.addAll(fileSystemAccess.files.map[
			val contentType = contentTypeProvider.getContentType(name)
			new GeneratorResult.GeneratedDocument(name, contentType, content.toString)
		])
		return result
	}
	
}