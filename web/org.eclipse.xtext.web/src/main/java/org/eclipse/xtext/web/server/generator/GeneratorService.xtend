/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.generator

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import org.eclipse.xtext.generator.GeneratorDelegate
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.web.server.model.AbstractCachedService
import org.eclipse.xtext.web.server.model.IXtextWebDocument

/**
 * Service class for code generation. The resulting documents are sent back to the client;
 * if exactly one document is generated, the result should be unwrapped, i.e. the response body
 * is the generated document.
 * 
 * <p>Results of this service are cached in the session state. However, the service is <em>not</em>
 * invoked automatically after a document change (in contrast to e.g. validation), but only after
 * an explicit request.</p>
 */
@Singleton
class GeneratorService extends AbstractCachedService<GeneratorResult> {
	
	@Inject GeneratorDelegate generator
	
	@Inject IContentTypeProvider contentTypeProvider
	
	@Inject Provider<InMemoryFileSystemAccess> fileSystemAccessProvider
	
	/**
	 * Generate artifacts for the given document.
	 */
	override compute(IXtextWebDocument it, CancelIndicator cancelIndicator) {
		val fileSystemAccess = fileSystemAccessProvider.get
		generator.generate(resource, fileSystemAccess, [cancelIndicator])
		val result = new GeneratorResult
		result.documents.addAll(fileSystemAccess.textFiles.entrySet.map[
			val contentType = contentTypeProvider.getContentType(key)
			new GeneratorResult.GeneratedDocument(key, contentType, value.toString)
		])
		return result
	}
	
}