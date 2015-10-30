package org.eclipse.xtend.web

import com.google.inject.Inject
import com.google.inject.Provider
import java.io.IOException
import java.io.OutputStreamWriter
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.common.util.WrappedException
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider
import org.eclipse.xtext.web.server.model.IXtextWebDocument
import org.eclipse.xtext.web.server.model.XtextWebDocument
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler

class ExampleResourceHandler implements IServerResourceHandler {

	@Inject IWebResourceSetProvider resourceSetProvider
	
	@Inject Provider<XtextWebDocument> documentProvider
	
	@Inject IEncodingProvider encodingProvider
	
	
	val examples = #{
		'example.xtend' -> '''
			class Example {
				var greeting = "hello world!"
				def sayHello() {
					println(greeting)
				}
			}
		''',
		'java.xtend' -> '''
			class Example {
				
			}
		'''
	}

	override get(String resourceId) throws IOException {
		val result = documentProvider.get
		val resourceSet = resourceSetProvider.get(resourceId)
		val resource = resourceSet.createResource(URI.createURI(resourceId)) as XtextResource
		result.setInput(resource,resourceId)
		result.text = examples.get(resourceId) ?: ''
		return result
	}
	
	override put(IXtextWebDocument document) throws IOException {
		try {
			val uri = document.resource.URI//URI.getFileURI(document.resourceId)
			if (uri.fileExtension.equals("xtend")){
				return
			}
			val outputStream = document.resource.resourceSet.URIConverter.createOutputStream(uri)
			val writer = new OutputStreamWriter(outputStream, encodingProvider.getEncoding(uri))
			writer.write(document.text)
			writer.close
		} catch (WrappedException exception) {
			throw exception.cause
		}
	}

	

}