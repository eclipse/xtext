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
import com.google.inject.Singleton
import java.io.IOException
import java.util.Random
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys
import org.eclipse.xtext.formatting2.FormatterPreferences
import org.eclipse.xtext.preferences.IPreferenceValuesProvider
import org.eclipse.xtext.preferences.MapBasedPreferenceValues
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
import org.eclipse.xtext.web.server.model.IWebDocumentProvider
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider
import org.eclipse.xtext.web.server.model.PrecomputedServiceRegistry
import org.eclipse.xtext.web.server.model.UpdateDocumentService
import org.eclipse.xtext.web.server.model.XtextWebDocument
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess
import org.eclipse.xtext.web.server.occurrences.OccurrencesService
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler
import org.eclipse.xtext.web.server.persistence.ResourcePersistenceService
import org.eclipse.xtext.web.server.syntaxcoloring.HighlightingService
import org.eclipse.xtext.web.server.validation.ValidationService

/**
 * The entry class for Xtext service invocations. Use {@link #getService(IServiceContext)}
 * to obtain a {@link XtextServiceDispatcher.ServiceDescriptor} for a client request. The service
 * descriptor has some metadata that may influence the message format expected for the request, and
 * may lead to a rejection of the request.
 * 
 * <p> A typical usage can look like this:</p>
 * <pre>
 * val serviceDispatcher = injector.getInstance(XtextServiceDispatcher)
 * val serviceDescriptor = serviceDispatcher.getService(serviceContext)
 * // Check whether the service metadata fits to the request format
 * ...
 * val result = serviceDescriptor.service.apply()
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
		 * Context information such as request parameters and session data.
		 */
		IServiceContext context
		
		/**
		 * The function for invoking the service.
		 */
		private ()=>IServiceResult service
		
		/**
		 * Whether the service has any side effects apart from initializing data in the session.
		 */
		boolean hasSideEffects
		
		/**
		 * Whether one of the preconditions of the service does not match, e.g. because it is in
		 * conflict with another request.
		 */
		boolean hasConflict
	}
	
	
	@Inject
	@FormatterPreferences
	IPreferenceValuesProvider formatterPreferencesProvider
	
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
	@Inject IWebDocumentProvider documentProvider
	@Inject FileExtensionProvider fileExtensionProvider
	@Inject IResourceFactory resourceFactory
	@Inject OperationCanceledManager operationCanceledManager
	@Inject XtextWebDocumentAccess.Factory documentAccessFactory
	val randomGenerator = new Random
	
	@Inject
	protected def void registerPreComputedServices(PrecomputedServiceRegistry registry) {
		registry.addPrecomputedService(highlightingService)
		registry.addPrecomputedService(validationService)
	}
	
	/**
	 * Create a service descriptor according to the parameters given in the service context.
	 */
	def ServiceDescriptor getService(IServiceContext context)
			throws InvalidRequestException {
		val serviceType = context.getParameter(IServiceContext.SERVICE_TYPE)
		if (serviceType === null)
			throw new InvalidParametersException('The parameter \'serviceType\' is required.')
		
		if (LOG.traceEnabled) {
			val stringParams = context.parameterKeys.sort.join(': ', ', ', '', [ key |
				val value = context.getParameter(key)
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
			return createServiceDescriptor(serviceType, context) => [
				it.context = context
			]
		} catch (InvalidDocumentStateException ire) {
			LOG.trace('Invalid document state (' + serviceType + ')')
			return new ServiceDescriptor => [
				it.context = context
				service = [new ServiceConflictResult('invalidStateId')]
				hasConflict = true
			]
		}
	}
	
	/**
	 * Do the actual dispatching by delegating to a service descriptor creation method depending on the service type.
	 * Override this method if you want to add more services to the dispatcher.
	 */
	protected def ServiceDescriptor createServiceDescriptor(String serviceType, IServiceContext context) {
		switch serviceType {
			case 'load':
				getLoadResourceService(false, context)
			case 'revert':
				getLoadResourceService(true, context)
			case 'save':
				getSaveResourceService(context)
			case 'update':
				getUpdateDocumentService(context)
			case 'assist':
				getContentAssistService(context)
			case 'validate':
				getValidationService(context)
			case 'hover':
				getHoverService(context)
			case 'highlight':
				getHighlightingService(context)
			case 'occurrences':
				getOccurrencesService(context)
			case 'format':
				getFormattingService(context)
			case 'generate':
				getGeneratorService(context)
			default:
				throw new InvalidParametersException('The service type \'' + serviceType + '\' is not supported.')
		}
	}
	
	protected def getLoadResourceService(boolean revert, IServiceContext context) throws InvalidRequestException {
		val resourceId = context.resourceID
		if (resourceId === null)
			throw new InvalidParametersException('The parameter \'resource\' is required.')
		new ServiceDescriptor => [
			service = [
				try {
					if (revert)
						resourcePersistenceService.revert(resourceId, resourceHandler, context)
					else
						resourcePersistenceService.load(resourceId, resourceHandler, context)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
			hasSideEffects = revert
		]
	}
	
	protected def getSaveResourceService(IServiceContext context)
			throws InvalidRequestException {
		val document = getDocumentAccess(context)
		new ServiceDescriptor => [
			service = [
				try {
					resourcePersistenceService.save(document, resourceHandler, context)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
			hasSideEffects = true
		]
	}
	
	protected def getUpdateDocumentService(IServiceContext context)
			throws InvalidRequestException {
		val resourceId = context.resourceID
		if (resourceId === null)
			throw new InvalidParametersException('The parameter \'resource\' is required.')
		val fullText = context.getParameter('fullText')
		var document = getResourceDocument(resourceId, context)
		val initializedFromFullText = document === null
		if (initializedFromFullText) {
			if (fullText === null)
				throw new ResourceNotFoundException('The requested resource was not found.')
			// If the resource does not exist, create a dummy resource for the given full text
			document = getFullTextDocument(fullText, resourceId, context)
		}
		val documentAccess = documentAccessFactory.create(document, context.getParameter('requiredStateId'), false)
		val result = new ServiceDescriptor => [
			hasSideEffects = true
		]
		if (fullText === null) {
			val deltaText = context.getParameter('deltaText')
			if (deltaText === null)
				throw new InvalidParametersException('One of the parameters \'deltaText\' and \'fullText\' must be specified.')
			val deltaOffset = context.getInt('deltaOffset', Optional.absent)
			if (deltaOffset < 0)
				throw new InvalidParametersException('The parameter \'deltaOffset\' must not be negative.')
			val deltaReplaceLength = context.getInt('deltaReplaceLength', Optional.absent)
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
			if (context.parameterKeys.contains('deltaText'))
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
	
	protected def getContentAssistService(IServiceContext context)
			throws InvalidRequestException {
		val offset = context.getInt('caretOffset', Optional.of(0))
		if (offset < 0)
			throw new InvalidParametersException('The parameter \'offset\' must not be negative.')
		val document = getDocumentAccess(context)
		val proposalsLimit = context.getInt('proposalsLimit', Optional.of(ContentAssistService.DEFAULT_PROPOSALS_LIMIT))
		if (proposalsLimit <= 0)
			throw new InvalidParametersException('The parameter \'proposalsLimit\' must contain a positive integer.')
		val selectionStart = context.getInt('selectionStart', Optional.of(offset))
		val selectionEnd = context.getInt('selectionEnd', Optional.of(selectionStart))
		val selection = new TextRegion(selectionStart, Math.max(selectionEnd - selectionStart, 0))
		val deltaText = context.getParameter('deltaText')
		if (deltaText === null) {
			new ServiceDescriptor => [
				service = [
					try {
						contentAssistService.createProposals(document, selection, offset, proposalsLimit)
					} catch (Throwable throwable) {
						handleError(throwable)
					}
				]
			]
		} else {
			if (context.parameterKeys.contains('fullText'))
				throw new InvalidParametersException('The parameters \'deltaText\' and \'fullText\' cannot be set in the same request.')
			val deltaOffset = context.getInt('deltaOffset', Optional.absent)
			if (deltaOffset < 0)
				throw new InvalidParametersException('The parameter \'deltaOffset\' must not be negative.')
			val deltaReplaceLength = context.getInt('deltaReplaceLength', Optional.absent)
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
			]
		}
	}
	
	protected def getValidationService(IServiceContext context)
			throws InvalidRequestException {
		val document = getDocumentAccess(context)
		new ServiceDescriptor => [
			service = [
				try {
					validationService.getResult(document)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
		]
	}
	
	protected def getHoverService(IServiceContext context)
			throws InvalidRequestException {
		val document = getDocumentAccess(context)
		val offset = context.getInt('caretOffset', Optional.of(0))
		if (offset < 0)
			throw new InvalidParametersException('The parameter \'offset\' must not be negative.')
		val selectionStart = context.getInt('selectionStart', Optional.of(offset))
		val selectionEnd = context.getInt('selectionEnd', Optional.of(selectionStart))
		val selection = new TextRegion(selectionStart, Math.max(selectionEnd - selectionStart, 0))
		val proposal = context.getParameter('proposal')
		new ServiceDescriptor => [
			service = [
				try {
					if (proposal.nullOrEmpty)
						hoverService.getHover(document, offset)
					else
						hoverService.getHover(document, proposal, selection, offset)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
		]
	}
	
	protected def getHighlightingService(IServiceContext context)
			throws InvalidRequestException {
		val document = getDocumentAccess(context)
		new ServiceDescriptor => [
			service = [
				try {
					highlightingService.getResult(document)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
		]
	}
	
	protected def getOccurrencesService(IServiceContext context)
			throws InvalidRequestException {
		val document = getDocumentAccess(context)
		val offset = context.getInt('caretOffset', Optional.of(0))
		if (offset < 0)
			throw new InvalidParametersException('The parameter \'offset\' must not be negative.')
		new ServiceDescriptor => [
			service = [
				try {
					occurrencesService.findOccurrences(document, offset)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
		]
	}

	/**
	 * @see FormatterPreferenceKeys
	 */
	protected def getFormattingService(IServiceContext context)
			throws InvalidRequestException {
		val document = getDocumentAccess(context)
		val selectionStart = context.getInt('selectionStart', Optional.of(0))
		val selectionEnd = context.getInt('selectionEnd', Optional.of(selectionStart))
		val lineSeparator = context.getParameter('lineSeparator')
		val indentation = context.getParameter('indentation')
		val indentationLength = context.getInt('indentationLength', Optional.of(4))
		val maxLineWidth = context.getInt('maxLineWidth', Optional.of(120))
		
		val formatterPreferences = document.readOnly [ formatterPreferencesProvider.getPreferenceValues($0.resource) ]
		val preferences = new MapBasedPreferenceValues(formatterPreferences, newLinkedHashMap)
		preferences.put(FormatterPreferenceKeys.lineSeparator, lineSeparator)
		preferences.put(FormatterPreferenceKeys.indentation, indentation)
		preferences.put(FormatterPreferenceKeys.indentationLength, indentationLength)
		preferences.put(FormatterPreferenceKeys.maxLineWidth, maxLineWidth)

		val selection =
			if (selectionEnd > selectionStart)
				new TextRegion(selectionStart, selectionEnd - selectionStart)
			else null
		new ServiceDescriptor => [
			service = [
				try {
					formattingService.format(document, selection, preferences)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
			hasSideEffects = true
		]
	}
	
	protected def getGeneratorService(IServiceContext context)
			throws InvalidRequestException {
		val document = getDocumentAccess(context)
		val allArtifacts = getBoolean(context, 'allArtifacts', Optional.of(false))
		val includeContent = getBoolean(context, 'includeContent', Optional.of(true))
		new ServiceDescriptor => [
			if (allArtifacts) {
				service = [
					try {
						generatorService.getResult(document, includeContent)
					} catch (Throwable throwable) {
						handleError(throwable)
					}
				]
			} else {
				val artifactId = context.getParameter('artifact')
				service = [
					try {
						generatorService.getArtifact(document, artifactId, includeContent)
					} catch (Throwable throwable) {
						handleError(throwable)
					}
				]
			}
		]
	}
	
	/**
	 * Retrieve the document access for the given service context. If the 'fullText' parameter is given,
	 * a new document containing that text is created. Otherwise the 'resource' parameter is used
	 * to load a resource and put it into the session store.
	 */
	protected def getDocumentAccess(IServiceContext context)
			throws InvalidRequestException {
		var XtextWebDocument document
		var initializedFromFullText = false
		if (context.parameterKeys.contains('fullText')) {
			document = getFullTextDocument(context.getParameter('fullText'), context.resourceID, context)
			initializedFromFullText = true
		} else if (context.parameterKeys.contains('resource')) {
			document = getResourceDocument(context.resourceID, context)
			if (document === null)
				throw new ResourceNotFoundException('The requested resource was not found.')
		} else {
			throw new InvalidParametersException('At least one of the parameters \'resource\' and \'fullText\' must be specified.')
		}
		return documentAccessFactory.create(document, context.getParameter('requiredStateId'), initializedFromFullText)
	}
	
	/**
	 * Returns the resource ID from the service context. Potentially null. 
	 */
	protected def getResourceID(IServiceContext context) {
		return context.getParameter('resource')
	}
	
	/**
	 * Create a new document containing the given text.
	 */
	protected def getFullTextDocument(String fullText, String resourceId, IServiceContext context) {
		val resourceSet = resourceSetProvider.get(resourceId, context)
		val uri = URI.createURI(resourceId
			?: Integer.toHexString(randomGenerator.nextInt) + '.' + fileExtensionProvider.primaryFileExtension)
		val resource = resourceFactory.createResource(uri) as XtextResource
		val existingResource = resourceSet.getResource(uri, false)
		if (existingResource !== null)
			resourceSet.resources.remove(existingResource)
		resourceSet.resources.add(resource)
		resource.load(new StringInputStream(fullText), emptyMap)
		val document = documentProvider.get(resourceId, context)
		document.setInput(resource)
		if (resourceId !== null)
			context.session.put(XtextWebDocument -> resourceId, document)
		return document
	}
	
	/**
	 * Obtain a document from the session store, and if it is not present there, ask the
	 * {@link IServerResourceHandler} to provide it. In case that resource handler fails
	 * to provide the document, {@code null} is returned instead.
	 */
	protected def getResourceDocument(String resourceId, IServiceContext context) {
		try {
			val document = context.session.get(XtextWebDocument -> resourceId, [
				resourceHandler.get(resourceId, context)
			])
			return document
		} catch (IOException ioe) {
			return null
		}
	}
	
	/**
	 * Read an string-valued parameter. If the parameter is not available, the
	 * {@code defaultValue} is returned.
	 * 
	 * @throws InvalidRequestException.InvalidParametersException if the parameter
	 * 		is not available and {@code defaultValue} is absent
	 */
	protected def getString(IServiceContext context, String key, Optional<String> defaultValue)
			throws InvalidParametersException {
		val stringValue = context.getParameter(key)
		if (stringValue === null) {
			if (!defaultValue.present) {
				throw new InvalidParametersException('The parameter \'' + key + '\' must be specified.')
			}
			return defaultValue.get
		}
		return stringValue
	}
	
	/**
	 * Read an integer-valued parameter. If the parameter is not available, the
	 * {@code defaultValue} is returned.
	 * 
	 * @throws InvalidRequestException.InvalidParametersException if the parameter
	 * 		is not available and {@code defaultValue} is absent
	 */
	protected def getInt(IServiceContext context, String key, Optional<Integer> defaultValue)
			throws InvalidParametersException {
		val stringValue = context.getParameter(key)
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
	protected def getBoolean(IServiceContext context, String key, Optional<Boolean> defaultValue)
			throws InvalidParametersException {
		val stringValue = context.getParameter(key)
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
			LOG.trace('Service canceled (' + service.context.getParameter(IServiceContext.SERVICE_TYPE) + ')')
			return new ServiceConflictResult('canceled')
		}
		throw throwable
	}
	
	protected def dispatch handleError(ServiceDescriptor service, InvalidDocumentStateException exception) {
		LOG.trace('Invalid document state (' + service.context.getParameter(IServiceContext.SERVICE_TYPE) + ')')
		return new ServiceConflictResult('invalidStateId')
	}
	
}