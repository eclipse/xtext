/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.web.server.InvalidRequestException

/**
 * Service class for document updates. This service only makes sense with a stateful server,
 * where the server-side document representation is updated after each modification. This
 * can greatly improve response times compared to the stateless alternative, where the full
 * text content is sent with each service request.
 */
@Singleton
class UpdateDocumentService {
	
	@Inject IResourceValidator resourceValidator
	
	/**
	 * Update the state identifier and return it. A background process is started where the given text
	 * is assigned to the document and {@link #processUpdatedDocument(IXtextWebDocument, CancelIndicator)}
	 * is executed.
	 */
	def DocumentStateResult updateFullText(XtextWebDocumentAccess document, String fullText)
			throws InvalidRequestException {
		document.modify([ it, cancelIndicator |
			dirty = true
			processingCompleted = false
			createNewStateId()
			return new DocumentStateResult(stateId)
		], [ it, cancelIndicator |
			text = fullText
			processUpdatedDocument(cancelIndicator)
			return null
		])
	}
	
	/**
	 * Update the state identifier and return it. A background process is started where the given text change
	 * is applied to the document and {@link #processUpdatedDocument(IXtextWebDocument, CancelIndicator)}
	 * is executed.
	 */
	def DocumentStateResult updateDeltaText(XtextWebDocumentAccess document, String deltaText, int offset, int replaceLength)
			throws InvalidRequestException {
		document.modify([ it, cancelIndicator |
			dirty = true
			processingCompleted = false
			createNewStateId()
			return new DocumentStateResult(stateId)
		], [ it, cancelIndicator |
			updateText(deltaText, offset, replaceLength)
			processUpdatedDocument(cancelIndicator)
			return null
		])
	}
	
	/**
	 * Schedule {@link #processUpdatedDocument(IXtextWebDocument, CancelIndicator)} as background
	 * work and return the current state identifier.
	 */
	def DocumentStateResult getStateId(XtextWebDocumentAccess document)
			throws InvalidRequestException {
		document.modify([ it, cancelIndicator |
			return new DocumentStateResult(stateId)
		], [ it, cancelIndicator |
			processUpdatedDocument(cancelIndicator)
			return null
		])
	}
	
	/**
	 * Perform additional document processing if it has not already been done for the current document state.
	 */
	def void processUpdatedDocument(IXtextWebDocument it, CancelIndicator cancelIndicator) {
		if (!processingCompleted) {
			issues.addAll(resourceValidator.validate(resource, CheckMode.ALL, cancelIndicator))
			processingCompleted = true
		}
	}
	
}