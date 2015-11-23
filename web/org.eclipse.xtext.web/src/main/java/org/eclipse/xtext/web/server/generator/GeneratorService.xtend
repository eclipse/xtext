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
import java.util.List
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.generator.GeneratorDelegate
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.web.server.IServiceResult
import org.eclipse.xtext.web.server.InvalidRequestException.ResourceNotFoundException
import org.eclipse.xtext.web.server.model.AbstractCachedService
import org.eclipse.xtext.web.server.model.IXtextWebDocument
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess

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
class GeneratorService extends AbstractCachedService<GeneratorService.GeneratedArtifacts> {
	
	/** The default artifact name that is accessed when no specific artifact is requested. */
	public static val DEFAULT_ARTIFACT = IFileSystemAccess.DEFAULT_OUTPUT + '/DEFAULT_ARTIFACT'
	
	/**
	 * This service result class is just a wrapper to store all generated documents.
	 */
	@Data
	static class GeneratedArtifacts implements IServiceResult {
		List<GeneratorResult> artifacts = newArrayList
	}
	
	@Inject GeneratorDelegate generator
	
	@Inject IContentTypeProvider contentTypeProvider
	
	@Inject Provider<InMemoryFileSystemAccess> fileSystemAccessProvider
	
	/**
	 * Generate artifacts for the given document.
	 */
	override compute(IXtextWebDocument it, CancelIndicator cancelIndicator) {
		val fileSystemAccess = fileSystemAccessProvider.get
		generator.generate(resource, fileSystemAccess, [cancelIndicator])
		val result = new GeneratedArtifacts
		result.artifacts.addAll(fileSystemAccess.textFiles.entrySet.map[
			val contentType = contentTypeProvider.getContentType(key)
			new GeneratorResult(key, contentType, value.toString)
		])
		return result
	}
	
	def getArtifact(XtextWebDocumentAccess document, String artifactId) {
		val artifacts = getResult(document).artifacts
		val searchString = artifactId ?: DEFAULT_ARTIFACT
		val result = artifacts.findFirst[name == searchString]
		if (result === null)
			throw new ResourceNotFoundException('The requested generator artifact was not found.')
		return result
	}
	
}