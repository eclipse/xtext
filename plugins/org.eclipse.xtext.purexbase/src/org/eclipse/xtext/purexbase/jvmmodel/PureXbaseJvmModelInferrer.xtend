package org.eclipse.xtext.purexbase.jvmmodel
 
import org.eclipse.xtext.xbase.jvmmodel.*
import org.eclipse.emf.ecore.EObject
import java.util.List

/**
 * Infers a JVM model from the source model. 
 *
 * The JVM model should contain all elements in the Java code generated from your source model. 
 * Other Xtend models link against the JVM model rather than against the source model. The JVM
 * model elemens should be associated wiht their source element using the IJvmModelAssociator.     
 */
class PureXbaseJvmModelInferrer implements IJvmModelInferrer {

	@Inject IJvmModelAssociator 

   	override List<? extends EObject> inferJvmModel(EObject sourceObject) {
   		return newArrayList();
   	}
}
