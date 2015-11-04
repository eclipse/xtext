package org.eclipse.xtend.web.server.java2xtend

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.web.server.IServiceResult

@Data
class Java2XtendResult implements IServiceResult {
	Integer stateID //id = 1 no errors; id= 0 errors
	String generateText
	
}