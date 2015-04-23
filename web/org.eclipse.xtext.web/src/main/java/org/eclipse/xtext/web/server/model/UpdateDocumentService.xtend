/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import com.google.inject.Singleton
import org.eclipse.xtext.web.server.InvalidRequestException

@Singleton
class UpdateDocumentService {
	
	def updateFullText(XtextWebDocument document, String fullText, String requiredStateId, String newStateId)
			throws InvalidRequestException {
		document.modify[ access |
			access.checkStateId(requiredStateId)
			access.text = fullText
			if (newStateId !== null) {
				access.stateId = newStateId
			}
			return new DocumentStateResult(access.stateId)
		]
	}
	
	def updateDeltaText(XtextWebDocument document, String deltaText, int offset, int replaceLength,
			String requiredStateId, String newStateId) throws InvalidRequestException {
		document.modify[ access |
			access.checkStateId(requiredStateId)
			access.updateText(deltaText, offset, replaceLength)
			if (newStateId !== null) {
				access.stateId = newStateId
			}
			return new DocumentStateResult(access.stateId)
		]
	}
	
}