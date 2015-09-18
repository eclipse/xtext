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
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.IResourceFactory
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.util.TextRegion
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.web.server.InvalidRequestException.InvalidDocumentStateException
import org.eclipse.xtext.web.server.InvalidRequestException.InvalidParametersException
import org.eclipse.xtext.web.server.InvalidRequestException.ResourceNotFoundException
import org.eclipse.xtext.web.server.contentassist.ContentAssistService
import org.eclipse.xtext.web.server.formatting.FormattingService
import org.eclipse.xtext.web.server.generator.GeneratorService
import org.eclipse.xtext.web.server.hover.HoverService
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider
import org.eclipse.xtext.web.server.model.UpdateDocumentService
import org.eclipse.xtext.web.server.model.XtextWebDocument
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess
import org.eclipse.xtext.web.server.occurrences.OccurrencesService
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler
import org.eclipse.xtext.web.server.persistence.ResourcePersistenceService
import org.eclipse.xtext.web.server.syntaxcoloring.HighlightingService
import org.eclipse.xtext.web.server.validation.ValidationService
import org.eclipse.xtext.web.server.model.PrecomputedServiceRegistry

/**
 * The entry class for Xtext service invocations. Use {@link #getService(IRequestData, ISessionStore)}
 * to obtain a {@link XtextServiceDispatcher.ServiceDescriptor} for a client request. The service
 * descriptor has some metadata that may influence the message format expected for the request, and
 * may lead to a rejection of the request.
 * 
 * <p> A typical usage can look like this:</p>
 * <pre>
 * val serviceDispatcher = injector.getInstance(XtextServiceDispatcher)
 * val service = serviceDispatcher.getService(requestData, sessionStore)
 * // Check the service metadata and permissions to invoke the service
 * ...
 * val result = service.service.apply()
 * // Serialize and send the result back to the client
 * ...
 * </pre>
 */
@Singleton
@Log
class XtextServiceDispatcher {
	
	/**
	 * Service metadata, including a function for actually invoking the service.
	 */
	@Accessors
	@ToString
	static class ServiceDescriptor {
		
		/**
		 * The request for which the service was built.
		 */
		IRequestData request
		
		/**
		 * The function for invoking the service.
		 */
		private ()=>IServiceResult service
		
		/**
		 * Whether the service has any side effects apart from initializing data in the session store.
		 */
		boolean hasSideEffects
		
		/**
		 * Whether any text parts of the document have been sent with the request. Requests that
		 * contain text parts may be required to be transmitted with a different format.
		 */
		boolean hasTextInput
		
		/**
		 * Whether one of the preconditions of the service does not match, e.g. because it is in
		 * conflict with another request.
		 */
		boolean hasConflict
	}
	
	@Inject ResourcePersistenceService resourcePersistenceService
	@Inject UpdateDocumentService updateDocumentService
	@Inject ContentAssistService contentAssistService
	@Inject ValidationService validationService
	@Inject HighlightingService highlightingService
	@Inject HoverService hoverService
	@Inject OccurrencesService occurrencesService
	@Inject FormattingService formattingService
	@Inject GeneratorService generatorService
	@Inject IServerResourceHandler resourceHandler
	@Inject IWebResourceSetProvider resourceSetProvider
	@Inject Provider<XtextWebDocument> documentProvider
	@Inject FileExtensionProvider fileExtensionProvider
	@Inject IResourceFactory resourceFactory
	@Inject OperationCanceledManager operationCanceledManager
	@Inject XtextWebDocumentAccess.Factory documentAccessFactory
	
	@Inject
	protected def void registerPreComputedServices(PrecomputedServiceRegistry registry) {
		registry.addPrecomputedService(highlightingService)
		registry.addPrecomputedService(validationService)
	}
	
	/**
	 * Get the service descriptor for the given request.
	 */
	def ServiceDescriptor getService(IRequestData request, ISessionStore sessionStore)
			throws InvalidRequestException {
		val serviceType = request.getParameter(IRequestData.SERVICE_TYPE)
		if (serviceType === null)
			throw new InvalidParametersException('The parameter \'serviceType\' is required.')
		
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
			LOG.trace('xtext-service/' + serviceType + stringParams)
		}
		
		try {
			return createServiceDescriptor(serviceType, request, sessionStore) => [
				it.request = request
			]
		} catch (InvalidDocumentStateException ire) {
			LOG.trace('Invalid document state (' + serviceType + ')')
			return new ServiceDescriptor => [
				it.request = request
				service = [new ServiceConflictResult('invalidStateId')]
				hasConflict = true
			]
		}
	}
	
	/**
	 * Do the actual dispatching by delegating to a service descriptor creation method depending on the service type.
	 * Override this method if you want to add more services to the dispatcher.
	 */
	protected def ServiceDescriptor createServiceDescriptor(String serviceType, IRequestData request, ISessionStore sessionStore) {
		switch serviceType {
			case 'load':
				getLoadResourceService(false, request, sessionStore)
			case 'revert':
				getLoadResourceService(true, request, sessionStore)
			case 'save':
				getSaveResourceService(request, sessionStore)
			case 'update':
				getUpdateDocumentService(request, sessionStore)
			case 'assist':
				getContentAssistService(request, sessionStore)
			case 'validate':
				getValidationService(request, sessionStore)
			case 'hover':
				getHoverService(request, sessionStore)
			case 'highlight':
				getHighlightingService(request, sessionStore)
			case 'occurrences':
				getOccurrencesService(request, sessionStore)
			case 'format':
				getFormattingService(request, sessionStore)
			case 'generate':
				getGeneratorService(request, sessionStore)
			default:
				throw new InvalidParametersException('The service type \'' + serviceType + '\' is not supported.')
		}
	}
	
	protected def getLoadResourceService(boolean revert, IRequestData request,
			ISessionStore sessionStore) throws InvalidRequestException {
		val resourceId = request.getParameter('resource')
		if (resourceId === null)
			throw new InvalidParametersException('The parameter \'resource\' is required.')
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
			throw new InvalidParametersException('The parameter \'resource\' is required.')
		val fullText = request.getParameter('fullText')
		var document = getResourceDocument(resourceId, sessionStore)
		val initializedFromFullText = document === null
		if (initializedFromFullText) {
			if (fullText === null)
				throw new ResourceNotFoundException('The requested resource was not found.')
			// If the resource does not exist, create a dummy resource for the given full text
			document = getFullTextDocument(fullText, resourceId, sessionStore)
		}
		val documentAccess = documentAccessFactory.create(document, request.getParameter('requiredStateId'), false)
		val result = new ServiceDescriptor => [
			hasSideEffects = true
			hasTextInput = true
		]
		if (fullText === null) {
			val deltaText = request.getParameter('deltaText')
			if (deltaText === null)
				throw new InvalidParametersException('One of the parameters \'deltaText\' and \'fullText\' must be specified.')
			val deltaOffset = request.getInt('deltaOffset', Optional.absent)
			if (deltaOffset < 0)
				throw new InvalidParametersException('The parameter \'deltaOffset\' must not be negative.')
			val deltaReplaceLength = request.getInt('deltaReplaceLength', Optional.absent)
			if (deltaReplaceLength < 0)
				throw new InvalidParametersException('The parameter \'deltaReplaceLength\' must not be negative.')
			result.service = [
				try {
					updateDocumentService.updateDeltaText(documentAccess, deltaText, deltaOffset, deltaReplaceLength)
				} catch (Throwable throwable) {
					handleError(result, throwable)
				}
			]
		} else {
			if (request.parameterKeys.contains('deltaText'))
				throw new InvalidParametersException('The parameters \'deltaText\' and \'fullText\' cannot be set in the same request.')
			result.service = [
				try {
					// If the document has already been initialized with the given text, we don't need to reparse
					if (initializedFromFullText)
						updateDocumentService.getStateId(documentAccess)
					else
						updateDocumentService.updateFullText(documentAccess, fullText)
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
		val proposalsLimit = request.getInt('proposalsLimit', Optional.of(ContentAssistService.DEFAULT_PROPOSALS_LIMIT))
		if (proposalsLimit <= 0)
			throw new InvalidParametersException('The parameter \'proposalsLimit\' must contain a positive integer.')
		val selectionStart = request.getInt('selectionStart', Optional.of(offset))
		val selectionEnd = request.getInt('selectionEnd', Optional.of(selectionStart))
		val selection = new TextRegion(selectionStart, Math.max(selectionEnd - selectionStart, 0))
		val deltaText = request.getParameter('deltaText')
		if (deltaText === null) {
			new ServiceDescriptor => [
				service = [
					try {
						contentAssistService.createProposals(document, selection, offset, proposalsLimit)
					} catch (Throwable throwable) {
						handleError(throwable)
					}
				]
				hasTextInput = request.parameterKeys.contains('fullText')
			]
		} else {
			if (request.parameterKeys.contains('fullText'))
				throw new InvalidParametersException('The parameters \'deltaText\' and \'fullText\' cannot be set in the same request.')
			val deltaOffset = request.getInt('deltaOffset', Optional.absent)
			if (deltaOffset < 0)
				throw new InvalidParametersException('The parameter \'deltaOffset\' must not be negative.')
			val deltaReplaceLength = request.getInt('deltaReplaceLength', Optional.absent)
			if (deltaReplaceLength < 0)
				throw new InvalidParametersException('The parameter \'deltaReplaceLength\' must not be negative.')
			new ServiceDescriptor => [
				service = [
					try {
						contentAssistService.createProposalsWithUpdate(document, deltaText, deltaOffset,
								deltaReplaceLength, selection, offset, proposalsLimit)
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
					validationService.getResult(document)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
			hasTextInput = request.parameterKeys.contains('fullText')
		]
	}
	
	protected def getHoverService(IRequestData request, ISessionStore sessionStore)
			throws InvalidRequestException {
		val document = getDocumentAccess(request, sessionStore)
		val offset = request.getInt('caretOffset', Optional.of(0))
		new ServiceDescriptor => [
			service = [
				try {
					hoverService.getHover(document, offset)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
			hasTextInput = request.parameterKeys.contains('fullText')
		]
	}
	
	protected def getHighlightingService(IRequestData request, ISessionStore sessionStore)
			throws InvalidRequestException {
		val document = getDocumentAccess(request, sessionStore)
		new ServiceDescriptor => [
			service = [
				try {
					highlightingService.getResult(document)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
			hasTextInput = request.parameterKeys.contains('fullText')
		]
	}
	
	protected def getOccurrencesService(IRequestData request, ISessionStore sessionStore)
			throws InvalidRequestException {
		val document = getDocumentAccess(request, sessionStore)
		val offset = request.getInt('caretOffset', Optional.of(0))
		new ServiceDescriptor => [
			service = [
				try {
					occurrencesService.findOccurrences(document, offset)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
			hasTextInput = request.parameterKeys.contains('fullText')
		]
	}
	
	protected def getFormattingService(IRequestData request, ISessionStore sessionStore)
			throws InvalidRequestException {
		val document = getDocumentAccess(request, sessionStore)
		val selectionStart = request.getInt('selectionStart', Optional.of(0))
		val selectionEnd = request.getInt('selectionEnd', Optional.of(selectionStart))
		val selection =
			if (selectionEnd > selectionStart)
				new TextRegion(selectionStart, selectionEnd - selectionStart)
			else null
		new ServiceDescriptor => [
			service = [
				try {
					formattingService.format(document, selection)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
			hasTextInput = request.parameterKeys.contains('fullText')
			hasSideEffects = true
		]
	}
	
	protected def getGeneratorService(IRequestData request, ISessionStore sessionStore)
			throws InvalidRequestException {
		val document = getDocumentAccess(request, sessionStore)
		new ServiceDescriptor => [
			service = [
				try {
					generatorService.getResult(document)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
			hasTextInput = request.parameterKeys.contains('fullText')
		]
	}
	
	/**
	 * Retrieve the document access for the given request. If the 'fullText' parameter is given,
	 * a new document containing that text is created. Otherwise the 'resource' parameter is used
	 * to load a resource and put it into the session store.
	 */
	protected def getDocumentAccess(IRequestData request, ISessionStore sessionStore)
			throws InvalidRequestException {
		var XtextWebDocument document
		var initializedFromFullText = false
		if (request.parameterKeys.contains('fullText')) {
			document = getFullTextDocument(request.getParameter('fullText'), null, sessionStore)
			initializedFromFullText = true
		} else if (request.parameterKeys.contains('resource')) {
			document = getResourceDocument(request.getParameter('resource'), sessionStore)
			if (document === null)
				throw new ResourceNotFoundException('The requested resource was not found.')
		} else {
			throw new InvalidParametersException('At least one of the parameters \'resource\' and \'fullText\' must be specified.')
		}
		return documentAccessFactory.create(document, request.getParameter('requiredStateId'), initializedFromFullText)
	}
	
	/**
	 * Create a new document containing the given text.
	 */
	protected def getFullTextDocument(String fullText, String resourceId, ISessionStore sessionStore) {
		val resourceSet = resourceSetProvider.get(resourceId)
		val uri = URI.createURI(resourceId ?: 'fulltext.' + fileExtensionProvider.primaryFileExtension)
		val resource = resourceFactory.createResource(uri) as XtextResource
		resourceSet.resources.add(resource)
		resource.load(new StringInputStream(fullText), null)
		val document = documentProvider.get()
		document.setInput(resource, resourceId)
		if (resourceId !== null)
			sessionStore.put(XtextWebDocument -> resourceId, document)
		return document
	}
	
	/**
	 * Obtain a document from the session store, and if it is not present there, ask the
	 * {@link IServerResourceHandler} to provide it. In case that resource handler fails
	 * to provide the document, {@code null} is returned instead.
	 */
	protected def getResourceDocument(String resourceId, ISessionStore sessionStore) {
		try {
			return sessionStore.get(XtextWebDocument -> resourceId, [
				resourceHandler.get(resourceId)
			])
		} catch (IOException ioe) {
			return null
		}
	}
	
	/**
	 * Read an integer-valued parameter. If the parameter is not available, the
	 * {@code defaultValue} is returned.
	 * 
	 * @throws InvalidRequestException.InvalidParametersException if the parameter
	 * 		is not available and {@code defaultValue} is absent
	 */
	protected def getInt(IRequestData request, String key, Optional<Integer> defaultValue)
			throws InvalidParametersException {
		val stringValue = request.getParameter(key)
		if (stringValue === null) {
			if (!defaultValue.present) {
				throw new InvalidParametersException('The parameter \'' + key + '\' must be specified.')
			}
			return defaultValue.get.intValue
		}
		try {
			return Integer.parseInt(stringValue)
		} catch (NumberFormatException nfe) {
			throw new InvalidParametersException('The parameter \'' + key + '\' must contain an integer value.')
		}
	}
	
	/**
	 * Read a Boolean-valued parameter. If the parameter is not available, the
	 * {@code defaultValue} is returned.
	 * 
	 * @throws InvalidRequestException.InvalidParametersException if the parameter
	 * 		is not available and {@code defaultValue} is absent
	 */
	protected def getBoolean(IRequestData request, String key, Optional<Boolean> defaultValue)
			throws InvalidParametersException {
		val stringValue = request.getParameter(key)
		if (stringValue === null) {
			if (!defaultValue.present) {
				throw new InvalidParametersException('The parameter \'' + key + '\' must be specified.')
			}
			return defaultValue.get.booleanValue
		}
		switch stringValue.toLowerCase {
			case 'true': return true
			case 'false': return false
			default:
				throw new InvalidParametersException('The parameter \'' + key + '\' must contain a Boolean value.')
		}
	}
	
	protected def dispatch handleError(ServiceDescriptor service, Throwable throwable) {
		// The caller is responsible for sending an 'Internal Server Error' message to the client
		if (operationCanceledManager.isOperationCanceledException(throwable)) {
			LOG.trace('Service canceled (' + service.request.getParameter(IRequestData.SERVICE_TYPE) + ')')
			return new ServiceConflictResult('canceled')
		}
		throw throwable
	}
	
	protected def dispatch handleError(ServiceDescriptor service, InvalidDocumentStateException exception) {
		LOG.trace('Invalid document state (' + service.request.getParameter(IRequestData.SERVICE_TYPE) + ')')
		return new ServiceConflictResult('invalidStateId')
	}
	
}