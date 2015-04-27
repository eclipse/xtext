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
import java.util.Map
import java.util.StringTokenizer
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.IResourceFactory
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.util.TextRegion
import org.eclipse.xtext.web.server.contentassist.ContentAssistService
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
	}
	
	static val LOG = Logger.getLogger(XtextServiceDispatcher)
	
	@Inject ResourcePersistenceService resourcePersistenceService
	@Inject UpdateDocumentService updateDocumentService
	@Inject ContentAssistService contentAssistService
	@Inject ValidationService validationService
	@Inject IServerResourceHandler resourceHandler
	@Inject Provider<XtextResourceSet> resourceSetProvider
	@Inject Provider<XtextWebDocument> documentProvider
	@Inject FileExtensionProvider fileExtensionProvider
	@Inject IResourceFactory resourceFactory
	
	def getService(String path, Map<String, String> parameters, ISessionStore sessionStore) throws InvalidRequestException {
		val requestType = getRequestType(path, parameters)
		if (LOG.traceEnabled) {
			val stringParams = parameters.entrySet.sortBy[key].join(': ', ', ', '', [
				if (value.length > 18)
					key + '=\'' + value.substring(0, 16) + '...\''
				else if (value.matches('.*\\s+.*'))
					key + '=\'' + value + '\''
				else
					key + '=' + value
			]).replaceAll('(\\n|\\f|\\r)+', ' ')
			LOG.trace('xtext-service/' + requestType + stringParams)
		}
		
		switch requestType {
			case 'load':
				getLoadResourceService(false, parameters, sessionStore)
			case 'revert':
				getLoadResourceService(true, parameters, sessionStore)
			case 'save':
				getSaveResourceService(parameters, sessionStore)
			case 'update':
				getUpdateDocumentService(parameters, sessionStore)
			case 'validation':
				getValidationService(parameters, sessionStore)
			case 'content-assist':
				getContentAssistService(parameters, sessionStore)
			default:
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The request type \'' + requestType + '\' is not supported.')
		} => [
			type = requestType
		]
	}
	
	protected def getRequestType(String contextPath, Map<String, String> parameters) {
		if (contextPath !== null) {
			val tokenizer = new StringTokenizer(contextPath, '/')
			if (tokenizer.hasMoreTokens)
				return tokenizer.nextToken
		}
		return parameters.get('requestType') ?: ''
	}
	
	protected def getLoadResourceService(boolean revert, Map<String, String> parameters,
			ISessionStore sessionStore) throws InvalidRequestException {
		val resourceId = parameters.get('resource')
		if (resourceId === null)
			throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'resource\' is required.')
		new ServiceDescriptor => [
			service = [
				if (revert)
					resourcePersistenceService.revert(resourceId, resourceHandler, sessionStore)
				else
					resourcePersistenceService.load(resourceId, resourceHandler, sessionStore)
			]
			hasSideEffects = revert
		]
	}
	
	protected def getSaveResourceService(Map<String, String> parameters, ISessionStore sessionStore)
			throws InvalidRequestException {
		val document = getDocumentAccess(parameters, sessionStore)
		new ServiceDescriptor => [
			service = [
				resourcePersistenceService.save(document, resourceHandler)
			]
			hasSideEffects = true
			hasTextInput = parameters.containsKey('fullText')
		]
	}
	
	protected def getUpdateDocumentService(Map<String, String> parameters, ISessionStore sessionStore)
			throws InvalidRequestException {
		val resourceId = parameters.get('resource')
		if (resourceId === null)
			throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'resource\' is required.')
		val fullText = parameters.get('fullText')
		val initializedFromFullText = ArrayLiterals.newBooleanArrayOfSize(1)
		val document = new XtextWebDocumentAccess(getResourceDocument(resourceId, sessionStore, [
			// If the resource does not exist, create a dummy resource for the given full text
			if (fullText !== null) {
				initializedFromFullText.set(0, true)
				getFullTextDocument(fullText, resourceId, sessionStore)
			} else
				throw new InvalidRequestException(RESOURCE_NOT_FOUND, 'The requested resource was not found.')
		]), parameters.get('requiredStateId'))
		val result = new ServiceDescriptor => [
			hasSideEffects = true
			hasTextInput = true
		]
		if (fullText === null) {
			val deltaText = parameters.get('deltaText')
			if (deltaText === null)
				throw new InvalidRequestException(INVALID_PARAMETERS, 'One of the parameters \'deltaText\' and \'fullText\' must be specified.')
			val deltaOffset = parameters.getInt('deltaOffset', Optional.absent)
			if (deltaOffset < 0)
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'deltaOffset\' must not be negative.')
			val deltaReplaceLength = parameters.getInt('deltaReplaceLength', Optional.absent)
			if (deltaReplaceLength < 0)
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'deltaReplaceLength\' must not be negative.')
			result.service = [
				updateDocumentService.updateDeltaText(document, deltaText, deltaOffset, deltaReplaceLength)
			]
		} else {
			if (parameters.containsKey('deltaText'))
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameters \'deltaText\' and \'fullText\' cannot be set in the same request.')
			result.service = [
				// If the document has already been initialized with the given text, we don't need to reparse
				updateDocumentService.updateFullText(document, fullText, !initializedFromFullText.get(0))
			]
		}
		return result
	}
	
	protected def getContentAssistService(Map<String, String> parameters, ISessionStore sessionStore)
			throws InvalidRequestException {
		val offset = parameters.getInt('caretOffset', Optional.of(0))
		val document = getDocumentAccess(parameters, sessionStore)
		val selectionStart = parameters.getInt('selectionStart', Optional.of(offset))
		val selectionEnd = parameters.getInt('selectionEnd', Optional.of(selectionStart))
		val selection = new TextRegion(selectionStart, Math.max(selectionEnd - selectionStart, 0))
		val deltaText = parameters.get('deltaText')
		if (deltaText === null) {
			new ServiceDescriptor => [
				service = [
					contentAssistService.createProposals(document, selection, offset)
				]
				hasTextInput = parameters.containsKey('fullText')
			]
		} else {
			if (parameters.containsKey('fullText'))
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameters \'deltaText\' and \'fullText\' cannot be set in the same request.')
			val deltaOffset = parameters.getInt('deltaOffset', Optional.absent)
			if (deltaOffset < 0)
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'deltaOffset\' must not be negative.')
			val deltaReplaceLength = parameters.getInt('deltaReplaceLength', Optional.absent)
			if (deltaReplaceLength < 0)
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'deltaReplaceLength\' must not be negative.')
			new ServiceDescriptor => [
				service = [
					contentAssistService.createProposalsWithUpdate(document, deltaText, deltaOffset, deltaReplaceLength, selection, offset)
				]
				hasSideEffects = true
				hasTextInput = true
			]
		}
	}
	
	protected def getValidationService(Map<String, String> parameters, ISessionStore sessionStore)
			throws InvalidRequestException {
		val document = getDocumentAccess(parameters, sessionStore)
		new ServiceDescriptor => [
			service = [
				validationService.validate(document)
			]
			hasTextInput = parameters.containsKey('fullText')
		]
	}
	
	protected def getDocumentAccess(Map<String, String> parameters, ISessionStore sessionStore)
			throws InvalidRequestException {
		var XtextWebDocument document
		if (parameters.containsKey('fullText')) {
			document = getFullTextDocument(parameters.get('fullText'), null, sessionStore)
		} else if (parameters.containsKey('resource')) {
			document = getResourceDocument(parameters.get('resource'), sessionStore, [
				throw new InvalidRequestException(RESOURCE_NOT_FOUND, 'The requested resource was not found.')
			])
		} else {
			throw new InvalidRequestException(INVALID_PARAMETERS, 'At least one of the parameters \'resource\' and \'fullText\' must be specified.')
		}
		return new XtextWebDocumentAccess(document, parameters.get('requiredStateId'))
	}
	
	protected def getFullTextDocument(String fullText, String resourceId, ISessionStore sessionStore) {
		val resourceSet = resourceSetProvider.get()
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
	
	protected def getInt(Map<String, String> parameters, String key, Optional<Integer> defaultValue)
			throws InvalidRequestException {
		val stringValue = parameters.get(key)
		if (stringValue === null) {
			if (!defaultValue.present) {
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'' + key + '\' must be specified.')
			}
			return defaultValue.get
		}
		try {
			return Integer.parseInt(stringValue)
		} catch (NumberFormatException nfe) {
			throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'' + key + '\' must contain an integer value.')
		}
	}
	
	protected def getBoolean(Map<String, String> parameters, String key, Optional<Boolean> defaultValue)
			throws InvalidRequestException {
		val stringValue = parameters.get(key)
		if (stringValue === null) {
			if (!defaultValue.present) {
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'' + key + '\' must be specified.')
			}
			return defaultValue.get
		}
		switch stringValue.toLowerCase {
			case 'true': return true
			case 'false': return false
			default:
				throw new InvalidRequestException(INVALID_PARAMETERS, 'The parameter \'' + key + '\' must contain a Boolean value.')
		}
	}
	
}