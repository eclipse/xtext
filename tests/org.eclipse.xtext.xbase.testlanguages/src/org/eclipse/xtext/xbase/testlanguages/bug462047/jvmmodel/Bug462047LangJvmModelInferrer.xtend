package org.eclipse.xtext.xbase.testlanguages.bug462047.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.testlanguages.bug462047.bug462047.Bug462047Element

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class Bug462047LangJvmModelInferrer extends AbstractModelInferrer {

    @Inject extension JvmTypesBuilder
   	def dispatch void infer(Bug462047Element element, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
   		acceptor.accept(element.toClass("CORE."+element.name)) [
   			documentation = '''«element.ref?.qualifiedName»'''
   		]
   	}
}

