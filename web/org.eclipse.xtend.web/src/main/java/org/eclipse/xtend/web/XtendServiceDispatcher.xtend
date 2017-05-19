package org.eclipse.xtend.web

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.xtend.web.server.java2xtend.Java2XtendService
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.web.server.IServiceContext
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.XtextServiceDispatcher
import org.eclipse.xtext.web.server.generator.GeneratorService

@Log
@Singleton
class XtendServiceDispatcher extends XtextServiceDispatcher {
	
	// TODO propose Gerrit to Xtext to make XtextServiceDispatcher's @Inject protected
	@Inject GeneratorService generatorService
	
	@Inject Java2XtendService java2xtendService
	
	override protected createServiceDescriptor(String serviceType, IServiceContext context) {
		switch serviceType {
			case 'java2xtend':
				getJava2XtendService(context)
			default:
				super.createServiceDescriptor(serviceType, context)	
		}
	}
	
	/** 
	 * Xtend may generate several *.java from one *.xtend,
	 * so we don't have an 'artifact' request parameter and
	 * instead of generatorService.getArtifact() need to compute().
	 */
	override protected getGeneratorService(IServiceContext context) throws InvalidRequestException {
        new ServiceDescriptor => [
            service = [
                try {
                    getDocumentAccess(context).readOnly([state, cancelIndicator | generatorService.compute(state, cancelIndicator) ])
                } catch (Throwable throwable) {
                    handleError(throwable)
                }
            ]
        ]
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