/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.persistence

import com.google.inject.Inject
import com.google.inject.Singleton
import java.io.IOException
import org.eclipse.xtext.web.server.IServiceContext
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.InvalidRequestException.ResourceNotFoundException
import org.eclipse.xtext.web.server.model.DocumentStateResult
import org.eclipse.xtext.web.server.model.XtextWebDocument
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess

/**
 * Service class for loading, saving, and reverting documents. The actual work is done by
 * an implementation of {@link IServerResourceHandler}, so if you want to use this service
 * you must provide such an implementation in the Guice bindings.
 */
@Singleton
class ResourcePersistenceService {
	
	@Inject XtextWebDocumentAccess.Factory documentAccessFactory
	
	/**
	 * Load the content of a document.
	 */
	def ResourceContentResult load(String resourceId, IServerResourceHandler resourceHandler, IServiceContext serviceContext)
			throws InvalidRequestException {
		val document = serviceContext.session.get(XtextWebDocument -> resourceId, [
			try {
				resourceHandler.get(resourceId, serviceContext)
			} catch (IOException ioe) {
				throw new ResourceNotFoundException('The requested resource was not found.', ioe)
			}
		])
		documentAccessFactory.create(document, false).readOnly[ it, cancelIndicator |
			new ResourceContentResult(text, stateId, dirty)
		]
	}
	
	/**
	 * Revert the content of a document to the last saved state.
	 */
	def ResourceContentResult revert(String resourceId, IServerResourceHandler resourceHandler, IServiceContext serviceContext)
			throws InvalidRequestException {
		try {
			val document = resourceHandler.get(resourceId, serviceContext)
			serviceContext.session.put(XtextWebDocument -> resourceId, document)
			return new ResourceContentResult(document.text, document.stateId, false)
		} catch (IOException ioe) {
			throw new ResourceNotFoundException('The requested resource was not found.', ioe)
		}
	}
	
	/**
	 * Save the content of a document.
	 */
	def DocumentStateResult save(XtextWebDocumentAccess document, IServerResourceHandler resourceHandler, IServiceContext serviceContext)
			throws InvalidRequestException {
		document.readOnly[ it, cancelIndicator |
			try {
				resourceHandler.put(it, serviceContext)
				dirty = false
			} catch (IOException ioe) {
				throw new ResourceNotFoundException(ioe.message, ioe)
			}
			return new DocumentStateResult(stateId)
		]
	}
	
}