/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server

import com.google.common.base.Optional
import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import java.io.IOException
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.IResourceFactory
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.util.TextRegion
import org.eclipse.xtext.web.server.contentassist.ContentAssistService
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider
import org.eclipse.xtext.web.server.model.UpdateDocumentService
import org.eclipse.xtext.web.server.model.XtextWebDocument
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler
import org.eclipse.xtext.web.server.persistence.ResourcePersistenceService
import org.eclipse.xtext.web.server.validation.ValidationService

import static org.eclipse.xtext.web.server.InvalidRequestException.Type.*

@Singleton
class XtextServiceDispatcher {
	
	@Accessors
	@ToString
	static class ServiceDescriptor {
		String type
		private ()=>IServiceResult service
		boolean hasSideEffects
		boolean hasTextInput
		boolean hasConflict
	}
	
	static val LOG = Logger.getLogger(XtextServiceDispatcher)
	
	@Inject ResourcePersistenceService resourcePersistenceService
	@Inject UpdateDocumentService updateDocumentService
	@Inject ContentAssistService contentAssistService
	@Inject ValidationService validationService
	@Inject IServerResourceHandler resourceHandler
	@Inject IWebResourceSetProvider resourceSetProvider
	@Inject Provider<XtextWebDocument> documentProvider
	@Inject FileExtensionProvider fileExtensionProvider
	@Inject IResourceFactory resourceFactory
	@Inject OperationCanceledManager operationCanceledManager
	
	def ServiceDescriptor getService(IRequestData request, ISessionStore sessionStore)
			throws InvalidRequestException {
		val requestType = request.getMetadata(IRequestData.METADATA_REQUEST_TYPE) ?: ''
		if (LOG.traceEnabled) {
			val stringParams = request.parameterKeys.sort.join(': ', ', ', '', [ key |
				val value = request.getParameter(key)
				if (value.length > 18)
					key + '=\'' + value.substring(0, 16) + '...\''
				else if (value.matches('.*\\s+.*'))
					key + '=\'' + value + '\''
				else
					key + '=' + value
			]).replaceAll('(\\n|\\f|\\r)+', ' ')
			LOG.trace('xtext-service/' + requestType + stringParams)
		}
		
		try {
			createServiceDescriptor(requestType, request, sessionStore) => [
				type = requestType
			]
		} catch (InvalidRequestException ire) {
			if (ire.type == INVALID_DOCUMENT_STATE) {
				LOG.trace('Invalid document state (' + requestType + ')')
				return new ServiceDescriptor => [
					type = requestType
					service = [new ServiceConflictResult('invalidStateId')]
					hasConflict = true
				]
			}
			// The caller is responsible for translating this exception into a proper error message
			throw ire
		}
	}
	
	def ServiceDescriptor createServiceDescriptor(String requestType, IRequestData request, ISessionStore sessionStore) {
		switch requestType {
			case 'load':
				getLoadResourceService(false, request, sessionStore)
			case 'revert':
				getLoadResourceService(true, request, sessionStore)
			case 'save':
				getSaveResourceService(request, sessionStore)
			case 'update':
				getUpdateDocumentService(request, sessionStore)
			case 'validation':
				getValidationService(request, sessionStore)
			case 'content-assist':
				getContentAssistService(request, sessionStore)
			default:
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The request type \'' + requestType + '\' is not supported.')
		}
	}
	
	protected def getLoadResourceService(boolean revert, IRequestData request,
			ISessionStore sessionStore) throws InvalidRequestException {
		val resourceId = request.getParameter('resource')
		if (resourceId === null)
			throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'resource\' is required.')
		new ServiceDescriptor => [
			service = [
				try {
					if (revert)
						resourcePersistenceService.revert(resourceId, resourceHandler, sessionStore)
					else
						resourcePersistenceService.load(resourceId, resourceHandler, sessionStore)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
			hasSideEffects = revert
		]
	}
	
	protected def getSaveResourceService(IRequestData request, ISessionStore sessionStore)
			throws InvalidRequestException {
		val document = getDocumentAccess(request, sessionStore)
		new ServiceDescriptor => [
			service = [
				try {
					resourcePersistenceService.save(document, resourceHandler)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
			hasSideEffects = true
			hasTextInput = request.parameterKeys.contains('fullText')
		]
	}
	
	protected def getUpdateDocumentService(IRequestData request, ISessionStore sessionStore)
			throws InvalidRequestException {
		val resourceId = request.getParameter('resource')
		if (resourceId === null)
			throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'resource\' is required.')
		val fullText = request.getParameter('fullText')
		val initializedFromFullText = ArrayLiterals.newBooleanArrayOfSize(1)
		val document = new XtextWebDocumentAccess(getResourceDocument(resourceId, sessionStore, [
			// If the resource does not exist, create a dummy resource for the given full text
			if (fullText !== null) {
				initializedFromFullText.set(0, true)
				getFullTextDocument(fullText, resourceId, sessionStore)
			} else
				throw new InvalidRequestException(RESOURCE_NOT_FOUND, 'The requested resource was not found.')
		]), request.getParameter('requiredStateId'))
		val result = new ServiceDescriptor => [
			hasSideEffects = true
			hasTextInput = true
		]
		if (fullText === null) {
			val deltaText = request.getParameter('deltaText')
			if (deltaText === null)
				throw new InvalidRequestException(INVALID_PARAMETERS, 'One of the parameters \'deltaText\' and \'fullText\' must be specified.')
			val deltaOffset = request.getInt('deltaOffset', Optional.absent)
			if (deltaOffset < 0)
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'deltaOffset\' must not be negative.')
			val deltaReplaceLength = request.getInt('deltaReplaceLength', Optional.absent)
			if (deltaReplaceLength < 0)
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'deltaReplaceLength\' must not be negative.')
			result.service = [
				try {
					updateDocumentService.updateDeltaText(document, deltaText, deltaOffset, deltaReplaceLength)
				} catch (Throwable throwable) {
					handleError(result, throwable)
				}
			]
		} else {
			if (request.parameterKeys.contains('deltaText'))
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameters \'deltaText\' and \'fullText\' cannot be set in the same request.')
			result.service = [
				try {
					// If the document has already been initialized with the given text, we don't need to reparse
					updateDocumentService.updateFullText(document, fullText, !initializedFromFullText.get(0))
				} catch (Throwable throwable) {
					handleError(result, throwable)
				}
			]
		}
		return result
	}
	
	protected def getContentAssistService(IRequestData request, ISessionStore sessionStore)
			throws InvalidRequestException {
		val offset = request.getInt('caretOffset', Optional.of(0))
		val document = getDocumentAccess(request, sessionStore)
		val selectionStart = request.getInt('selectionStart', Optional.of(offset))
		val selectionEnd = request.getInt('selectionEnd', Optional.of(selectionStart))
		val selection = new TextRegion(selectionStart, Math.max(selectionEnd - selectionStart, 0))
		val deltaText = request.getParameter('deltaText')
		if (deltaText === null) {
			new ServiceDescriptor => [
				service = [
					try {
						contentAssistService.createProposals(document, selection, offset)
					} catch (Throwable throwable) {
						handleError(throwable)
					}
				]
				hasTextInput = request.parameterKeys.contains('fullText')
			]
		} else {
			if (request.parameterKeys.contains('fullText'))
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameters \'deltaText\' and \'fullText\' cannot be set in the same request.')
			val deltaOffset = request.getInt('deltaOffset', Optional.absent)
			if (deltaOffset < 0)
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'deltaOffset\' must not be negative.')
			val deltaReplaceLength = request.getInt('deltaReplaceLength', Optional.absent)
			if (deltaReplaceLength < 0)
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'deltaReplaceLength\' must not be negative.')
			new ServiceDescriptor => [
				service = [
					try {
						contentAssistService.createProposalsWithUpdate(document, deltaText, deltaOffset,
								deltaReplaceLength, selection, offset)
					} catch (Throwable throwable) {
						handleError(throwable)
					}
				]
				hasSideEffects = true
				hasTextInput = true
			]
		}
	}
	
	protected def getValidationService(IRequestData request, ISessionStore sessionStore)
			throws InvalidRequestException {
		val document = getDocumentAccess(request, sessionStore)
		new ServiceDescriptor => [
			service = [
				try {
					validationService.validate(document)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
			hasTextInput = request.parameterKeys.contains('fullText')
		]
	}
	
	protected def getDocumentAccess(IRequestData request, ISessionStore sessionStore)
			throws InvalidRequestException {
		var XtextWebDocument document
		if (request.parameterKeys.contains('fullText')) {
			document = getFullTextDocument(request.getParameter('fullText'), null, sessionStore)
		} else if (request.parameterKeys.contains('resource')) {
			document = getResourceDocument(request.getParameter('resource'), sessionStore, [
				throw new InvalidRequestException(RESOURCE_NOT_FOUND, 'The requested resource was not found.')
			])
		} else {
			throw new InvalidRequestException(INVALID_PARAMETERS, 'At least one of the parameters \'resource\' and \'fullText\' must be specified.')
		}
		return new XtextWebDocumentAccess(document, request.getParameter('requiredStateId'))
	}
	
	protected def getFullTextDocument(String fullText, String resourceId, ISessionStore sessionStore) {
		val resourceSet = resourceSetProvider.get(resourceId)
		val uri = URI.createURI(resourceId ?: 'fullText.' + fileExtensionProvider.primaryFileExtension)
		val resource = resourceFactory.createResource(uri) as XtextResource
		resourceSet.resources.add(resource)
		resource.load(new StringInputStream(fullText), null)
		val document = documentProvider.get()
		document.setInput(resource, resourceId)
		if (resourceId !== null)
			sessionStore.put(XtextWebDocument -> resourceId, document)
		return document
	}
	
	protected def getResourceDocument(String resourceId, ISessionStore sessionStore,
			Provider<XtextWebDocument> alternativeDocumentProvider) {
		return sessionStore.get(XtextWebDocument -> resourceId, [
			try {
				return resourceHandler.get(resourceId)
			} catch (IOException ioe) {
				return alternativeDocumentProvider.get()
			}
		])
	}
	
	protected def getInt(IRequestData request, String key, Optional<Integer> defaultValue)
			throws InvalidRequestException {
		val stringValue = request.getParameter(key)
		if (stringValue === null) {
			if (!defaultValue.present) {
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'' + key + '\' must be specified.')
			}
			return defaultValue.get.intValue
		}
		try {
			return Integer.parseInt(stringValue)
		} catch (NumberFormatException nfe) {
			throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'' + key + '\' must contain an integer value.')
		}
	}
	
	protected def getBoolean(IRequestData request, String key, Optional<Boolean> defaultValue)
			throws InvalidRequestException {
		val stringValue = request.getParameter(key)
		if (stringValue === null) {
			if (!defaultValue.present) {
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'' + key + '\' must be specified.')
			}
			return defaultValue.get.booleanValue
		}
		switch stringValue.toLowerCase {
			case 'true': return true
			case 'false': return false
			default:
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'' + key + '\' must contain a Boolean value.')
		}
	}
	
	protected def dispatch handleError(ServiceDescriptor service, Throwable throwable) {
		// The caller is responsible for sending an 'Internal Server Error' message to the client
		if (operationCanceledManager.isOperationCanceledException(throwable)) {
			LOG.trace('Service canceled (' + service.type + ')')
			return new ServiceConflictResult('canceled')
		}
		throw throwable
	}
	
	protected def dispatch handleError(ServiceDescriptor service, InvalidRequestException exception) {
		if (exception.type == INVALID_DOCUMENT_STATE) {
			LOG.trace('Invalid document state (' + service.type + ')')
			return new ServiceConflictResult('invalidStateId')
		}
		// The caller is responsible for translating this exception into a proper error message
		throw exception
	}
	
}