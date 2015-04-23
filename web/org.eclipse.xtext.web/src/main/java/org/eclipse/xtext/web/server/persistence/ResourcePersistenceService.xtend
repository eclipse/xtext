/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.persistence

import com.google.inject.Singleton
import java.io.IOException
import org.eclipse.xtext.web.server.ISessionStore
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.model.DocumentStateResult
import org.eclipse.xtext.web.server.model.XtextWebDocument

import static org.eclipse.xtext.web.server.InvalidRequestException.Type.*

import static extension org.eclipse.xtext.web.server.ISessionStore.Extensions.*

@Singleton
class ResourcePersistenceService {
	
	def load(String resourceId, IServerResourceHandler resourceHandler, ISessionStore sessionStore)
			throws InvalidRequestException {
		val document = sessionStore.get(XtextWebDocument -> resourceId, [
			try {
				resourceHandler.get(resourceId)
			} catch (IOException ioe) {
				throw new InvalidRequestException(RESOURCE_NOT_FOUND, 'The requested resource was not found.')
			}
		])
		document.readOnly[ access |
			val result = new ResourceContentResult(access.text)
			result.dirty = access.dirty
			result.stateId = access.stateId
			return result
		]
	}
	
	def revert(String resourceId, String newStateId, IServerResourceHandler resourceHandler, ISessionStore sessionStore)
			throws InvalidRequestException {
		try {
			val document = resourceHandler.get(resourceId)
			document.modify[ access |
				sessionStore.put(XtextWebDocument -> resourceId, document)
				access.stateId = newStateId
				access.dirty = false
				val result = new ResourceContentResult(access.text)
				result.stateId = newStateId
				return result
			]
		} catch (IOException ioe) {
			throw new InvalidRequestException(RESOURCE_NOT_FOUND, 'The requested resource was not found.')
		}
	}
	
	def save(XtextWebDocument document, IServerResourceHandler resourceHandler, String requiredStateId)
			throws InvalidRequestException {
		document.modify[ access |
			access.checkStateId(requiredStateId)
			try {
				resourceHandler.put(access)
				access.dirty = false
			} catch (IOException ioe) {
				throw new InvalidRequestException(RESOURCE_NOT_FOUND, ioe.message)
			}
			return new DocumentStateResult(access.stateId)
		]
	}
	
}