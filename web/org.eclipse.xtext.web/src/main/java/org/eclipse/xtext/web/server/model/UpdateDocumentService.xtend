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
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.util.CancelIndicator

@Singleton
class UpdateDocumentService {
	
	def updateFullText(XtextWebDocumentAccess document, String fullText) throws InvalidRequestException {
		document.modify[ it, cancelIndicator |
			text = fullText
			postParse(cancelIndicator)
			return new DocumentStateResult(stateId)
		]
	}
	
	def updateDeltaText(XtextWebDocumentAccess document, String deltaText, int offset, int replaceLength)
			throws InvalidRequestException {
		document.modify[ it, cancelIndicator |
			updateText(deltaText, offset, replaceLength)
			postParse(cancelIndicator)
			return new DocumentStateResult(stateId)
		]
	}
	
	protected def postParse(IXtextWebDocument document, CancelIndicator cancelIndicator) {
		EcoreUtil2.resolveLazyCrossReferences(document.resource, cancelIndicator)
	}
	
}