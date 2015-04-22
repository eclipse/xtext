/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.data.UpdateDocumentResult

class UpdateDocumentService {
	
	def updateFullText(XtextDocument document, String fullText, String requiredStateId, String newStateId)
			throws InvalidRequestException {
		document.modify[ access |
			access.checkStateId(requiredStateId)
			access.text = fullText
			if (newStateId !== null) {
				access.stateId = newStateId
			}
			val result = new UpdateDocumentResult
			result.stateId = access.stateId
			return result
		]
	}
	
	def updateDeltaText(XtextDocument document, String deltaText, int offset, int replaceLength,
			String requiredStateId, String newStateId) throws InvalidRequestException {
		document.modify[ access |
			access.checkStateId(requiredStateId)
			applyDelta(access, deltaText, offset, replaceLength)
			if (newStateId !== null) {
				access.stateId = newStateId
			}
			val result = new UpdateDocumentResult
			result.stateId = access.stateId
			return result
		]
	}
	
	protected def applyDelta(XtextDocument.ModifyAccess access, String deltaText, int deltaOffset, int deltaReplaceLength) {
		val currentText = access.text
		var String newText
		if (deltaOffset == 0 && deltaReplaceLength >= currentText.length)
			newText = deltaText
		else if (deltaOffset == 0)
			newText = deltaText + currentText.substring(deltaReplaceLength)
		else if (deltaOffset + deltaReplaceLength >= currentText.length)
			newText = currentText.substring(0, deltaOffset) + deltaText
		else
			newText = currentText.substring(0, deltaOffset) + deltaText + currentText.substring(deltaOffset + deltaReplaceLength)
		access.text = newText
	}
	
}