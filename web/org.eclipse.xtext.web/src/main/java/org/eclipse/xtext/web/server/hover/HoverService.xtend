package org.eclipse.xtext.web.server.hover

import com.google.inject.Singleton
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess

@Singleton
class HoverService {

	def HoverResult getHover(XtextWebDocumentAccess document, int offset) {
		document.readOnly[ it, cancelIndicator |
			new HoverResult('Title', 'Hi from server')
		]
	}	
}