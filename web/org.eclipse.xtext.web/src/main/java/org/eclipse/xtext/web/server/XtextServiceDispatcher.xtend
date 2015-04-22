/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server

import com.google.common.base.Optional
import com.google.inject.Injector
import com.google.inject.Provider
import java.io.IOException
import java.util.Map
import java.util.StringTokenizer
import javax.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.IResourceFactory
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.util.TextRegion
import org.eclipse.xtext.web.server.contentassist.ContentAssistService
import org.eclipse.xtext.web.server.data.JsonObject
import org.eclipse.xtext.web.server.model.UpdateDocumentService
import org.eclipse.xtext.web.server.model.XtextDocument
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler
import org.eclipse.xtext.web.server.persistence.ResourcePersistenceService
import org.eclipse.xtext.web.server.validation.ValidationService

import static extension org.eclipse.xtext.web.server.ISessionStore.Extensions.*

class XtextServiceDispatcher {
	
	@Accessors
	static class ServiceDescriptor {
		String type
		private ()=>JsonObject service
		boolean hasSideEffects
		boolean hasTextInput
	}
	
	val serviceProviderRegistry = IResourceServiceProvider.Registry.INSTANCE
	
	@Inject IServerResourceHandler resourceHandler
	// TODO constructor injection
	
	def getService(String path, Map<String, String> parameters, ISessionStore sessionStore) throws InvalidRequestException {
		val requestType = getRequestType(path, parameters)
		val injector = getInjector(parameters)
		
		switch requestType {
			case 'load':
				getLoadResourceService(false, parameters, injector, sessionStore)
			case 'revert':
				getLoadResourceService(true, parameters, injector, sessionStore)
			case 'save':
				getSaveResourceService(parameters, injector, sessionStore)
			case 'update':
				getUpdateDocumentService(parameters, injector, sessionStore)
			case 'validation':
				getValidationService(parameters, injector, sessionStore)
			case 'content-assist':
				getContentAssistService(parameters, injector, sessionStore)
			default:
				throw new InvalidRequestException(400, 'The request type \'' + requestType + '\' is not supported.')
		} => [
			type = requestType
		]
	}
	
	// TODO move to servlet
	protected def getInjector(Map<String, String> parameters) throws InvalidRequestException {
		var IResourceServiceProvider resourceServiceProvider
		
		val emfURI = URI.createURI(parameters.get('resource') ?: '')
		val contentType = parameters.get('contentType')
		if (contentType === null)
			resourceServiceProvider = serviceProviderRegistry.getResourceServiceProvider(emfURI)
		else
			resourceServiceProvider = serviceProviderRegistry.getResourceServiceProvider(emfURI, contentType)
		
		if (resourceServiceProvider == null)
			throw new InvalidRequestException(400, 'Unable to identify the resource type.')
		
		return resourceServiceProvider.get(Injector)
	}
	
	protected def getRequestType(String contextPath, Map<String, String> parameters) {
		if (contextPath !== null) {
			val tokenizer = new StringTokenizer(contextPath, '/')
			if (tokenizer.hasMoreTokens)
				return tokenizer.nextToken
		}
		return parameters.get('requestType') ?: ''
	}
	
	protected def getLoadResourceService(boolean revert, Map<String, String> parameters, Injector injector,
			ISessionStore sessionStore) throws InvalidRequestException {
		val service = injector.getInstance(ResourcePersistenceService)
		val resourceId = parameters.get('resource')
		if (resourceId === null)
			throw new InvalidRequestException(400, 'The parameter \'resource\' is required.')
		new ServiceDescriptor => [
			service = [
				if (revert)
					service.revert(resourceId, parameters.get('newState'), resourceHandler, sessionStore).forRequestId(parameters)
				else
					service.load(resourceId, resourceHandler, sessionStore).forRequestId(parameters)
			]
			hasSideEffects = revert
		]
	}
	
	protected def getSaveResourceService(Map<String, String> parameters, Injector injector, ISessionStore sessionStore)
			throws InvalidRequestException {
		val service = injector.getInstance(ResourcePersistenceService)
		val document = getDocument(parameters, injector, sessionStore)
		val requiredStateId = parameters.get('requiredState')
		new ServiceDescriptor => [
			service = [
				service.save(document, resourceHandler, requiredStateId).forRequestId(parameters)
			]
			hasSideEffects = true
			hasTextInput = parameters.containsKey('fullText')
		]
	}
	
	protected def getUpdateDocumentService(Map<String, String> parameters, Injector injector, ISessionStore sessionStore)
			throws InvalidRequestException {
		val service = injector.getInstance(UpdateDocumentService)
		val resourceId = parameters.get('resource')
		if (resourceId === null)
			throw new InvalidRequestException(400, 'The parameter \'resource\' is required.')
		val fullText = parameters.get('fullText')
		val document = getResourceDocument(resourceId, injector, sessionStore, [
			// If the resource does not exist, create a dummy resource for the given full text
			if (fullText !== null)
				getFullTextDocument(fullText, resourceId, injector, sessionStore)
			else
				throw new InvalidRequestException(404, 'The requested resource was not found.')
		])
		val requiredStateId = parameters.get('requiredState')
		val newStateId = parameters.get('newState')
		val result = new ServiceDescriptor => [
			hasSideEffects = true
			hasTextInput = true
		]
		if (fullText === null) {
			val deltaText = parameters.get('deltaText')
			if (deltaText === null)
				throw new InvalidRequestException(400, 'At least one of the parameters \'deltaText\' and \'fullText\' must be specified.')
			val deltaOffset = parameters.getInt('deltaOffset', Optional.absent)
			if (deltaOffset < 0)
				throw new InvalidRequestException(400, 'The parameter \'deltaOffset\' must not be negative.')
			val deltaReplaceLength = parameters.getInt('deltaReplaceLength', Optional.absent)
			if (deltaReplaceLength < 0)
				throw new InvalidRequestException(400, 'The parameter \'deltaReplaceLength\' must not be negative.')
			result.service = [
				service.updateDeltaText(document, deltaText, deltaOffset, deltaReplaceLength,
					requiredStateId, newStateId).forRequestId(parameters)
			]
		} else {
			result.service = [
				service.updateFullText(document, fullText, requiredStateId, newStateId)
			]
		}
		return result
	}
	
	protected def getValidationService(Map<String, String> parameters, Injector injector, ISessionStore sessionStore)
			throws InvalidRequestException {
		val service = injector.getInstance(ValidationService)
		val document = getDocument(parameters, injector, sessionStore)
		val requiredStateId = parameters.get('requiredState')
		new ServiceDescriptor => [
			service = [
				service.validate(document, requiredStateId).forRequestId(parameters)
			]
			hasTextInput = parameters.containsKey('fullText')
		]
	}
	
	protected def getContentAssistService(Map<String, String> parameters, Injector injector, ISessionStore sessionStore)
			throws InvalidRequestException {
		val service = injector.getInstance(ContentAssistService)
		val offset = parameters.getInt('caretOffset', Optional.of(0))
		val document = getDocument(parameters, injector, sessionStore)
		val selectionStart = parameters.getInt('selectionStart', Optional.of(0))
		val selectionEnd = parameters.getInt('selectionEnd', Optional.of(0))
		val selection = new TextRegion(selectionStart, Math.max(selectionEnd - selectionStart, 0))
		val requiredStateId = parameters.get('requiredState')
		new ServiceDescriptor => [
			service = [
				service.createProposals(document, selection, offset, requiredStateId).forRequestId(parameters)
			]
			hasTextInput = parameters.containsKey('fullText')
		]
	}
	
	protected def getDocument(Map<String, String> parameters, Injector injector, ISessionStore sessionStore)
			throws InvalidRequestException {
		if (parameters.containsKey('fullText')) {
			return getFullTextDocument(parameters.get('fullText'), parameters.get('resource'), injector, sessionStore)
		} else if (parameters.containsKey('resource')) {
			return getResourceDocument(parameters.get('resource'), injector, sessionStore, [
				throw new InvalidRequestException(404, 'The requested resource was not found.')
			])
		} else {
			throw new InvalidRequestException(400, 'At least one of the parameters \'resource\' and \'fullText\' must be specified.')
		}
	}
	
	protected def getFullTextDocument(String fullText, String resourceId, Injector injector, ISessionStore sessionStore) {
		val resourceSet = injector.getInstance(XtextResourceSet)
		val uri = URI.createURI(resourceId ?: 'fullText.' + injector.getInstance(FileExtensionProvider).primaryFileExtension)
		val resource = injector.getInstance(IResourceFactory).createResource(uri) as XtextResource
		resourceSet.resources.add(resource)
		resource.load(new StringInputStream(fullText), null)
		val document = new XtextDocument(resource, resourceId)
		if (resourceId !== null)
			sessionStore.put(XtextDocument -> resourceId, document)
		return document
	}
	
	protected def getResourceDocument(String resourceId, Injector injector, ISessionStore sessionStore,
			Provider<XtextDocument> alternativeDocumentProvider) {
		// TODO bind lock to session
		synchronized (injector.getInstance(XtextDocument.CreationLock)) {
			return sessionStore.get(XtextDocument -> resourceId, [
				try {
					val resourceSet = injector.getInstance(XtextResourceSet)
					return resourceHandler.get(resourceId, resourceSet)
				} catch (IOException ioe) {
					return alternativeDocumentProvider.get()
				}
			])
		}
	}
	
	protected def getInt(Map<String, String> parameters, String key, Optional<Integer> defaultValue)
			throws InvalidRequestException {
		val stringValue = parameters.get(key)
		if (stringValue === null) {
			if (!defaultValue.present) {
				throw new InvalidRequestException(400, 'The parameter \'' + key + '\' must be specified.')
			}
			return defaultValue.get
		}
		try {
			return Integer.parseInt(stringValue)
		} catch (NumberFormatException nfe) {
			throw new InvalidRequestException(400, 'The parameter \'' + key + '\' must contain an integer value.')
		}
	}
	
	protected def getBoolean(Map<String, String> parameters, String key, Optional<Boolean> defaultValue)
			throws InvalidRequestException {
		val stringValue = parameters.get(key)
		if (stringValue === null) {
			if (!defaultValue.present) {
				throw new InvalidRequestException(400, 'The parameter \'' + key + '\' must be specified.')
			}
			return defaultValue.get
		}
		switch stringValue.toLowerCase {
			case 'true': return true
			case 'false': return false
			default:
				throw new InvalidRequestException(400, 'The parameter \'' + key + '\' must contain a Boolean value.')
		}
	}
	
	// TODO brauch ich das wirklich?
	protected def forRequestId(JsonObject jsonObject, Map<String, String> parameters) {
		val requestId = parameters.get('requestId')
		if (requestId !== null)
			jsonObject.requestId = requestId
		return jsonObject
	}
	
}