package org.eclipse.xtend.web

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.xtend.web.server.java2xtend.Java2XtendService
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.XtextServiceDispatcher
import org.eclipse.xtext.web.server.IServiceContext

@Log
@Singleton
class XtendServiceDispatcher extends XtextServiceDispatcher {
	
	@Inject Java2XtendService java2xtendService
	
	override protected createServiceDescriptor(String serviceType, IServiceContext context) {
		switch serviceType {
			case 'java2xtend':
				getJava2XtendService(context)
			default:
				super.createServiceDescriptor(serviceType, context)	
		}
		
	}
	
	def getJava2XtendService(IServiceContext context) throws InvalidRequestException {
		val document = getDocumentAccess(context)
		val srcJava = context.getParameter("srcJava")
		new ServiceDescriptor => [
			service = [
				try {
					java2xtendService.generate(srcJava,document)
				} catch (Throwable throwable) {
					handleError(throwable)
				}
			]
			// hasTextInput = context.parameterKeys.contains('fullText')
		]
	}
	
}