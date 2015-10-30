package org.eclipse.xtend.web

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.xtend.web.server.java2xtend.Java2XtendService
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.web.server.IRequestData
import org.eclipse.xtext.web.server.ISessionStore
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.XtextServiceDispatcher

@Singleton
@Log
class XtendServiceDispatcher extends XtextServiceDispatcher {
	
	
	@Inject Java2XtendService java2xtendService
	
	
	override protected createServiceDescriptor(String serviceType, IRequestData request, ISessionStore sessionStore) {
		switch serviceType {
			case 'java2xtend':
				getJava2XtendService(request, sessionStore)
			default :
				super.createServiceDescriptor(serviceType, request, sessionStore)	
		}
		
	}
	
	def getJava2XtendService(IRequestData request, ISessionStore sessionStore) throws InvalidRequestException {
		
		val document = getDocumentAccess(request, sessionStore)
		val srcJava = request.getParameter("srcJava")
		new ServiceDescriptor => [
			service = [
				try {
					java2xtendService.generate(srcJava,document)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
			hasTextInput = request.parameterKeys.contains('fullText')
		]
	}
	
}