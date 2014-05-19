package org.eclipse.xtext.purexbase.jvmmodel

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.purexbase.pureXbase.Model
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. 
 * Other Xtend models link against the JVM model rather than the source model. The JVM
 * model elements should be associated with their source element by means of the
 * {@link org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator}.</p>     
 */
class PureXbaseJvmModelInferrer extends AbstractModelInferrer {

	@Inject extension JvmTypesBuilder

   	def dispatch void infer(Model m, /* @NonNull */ IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
   		val e  = m.block
   		acceptor.accept(e.toClass(e.eResource.name)).initializeLater [
   			members += e.toMethod("myMethod", inferredType) [
   				exceptions += e.newTypeRef(Throwable)
   				body = e
   			]
   		]
   	}
   	
   	def name(Resource res) {
		val s = res.URI.lastSegment
		return s.substring(0, s.length - '.xbase'.length)
	}
	
}
