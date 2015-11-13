package org.eclipse.xtend.web.server.java2xtend

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.web.server.IServiceResult

@Data
class Java2XtendResult implements IServiceResult {
	Integer stateID //id = 1 not null; id= 0 the generated code is null
	String generateText
	
}