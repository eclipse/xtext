package org.eclipse.xtext.purexbase.jvmmodel
 
import org.eclipse.xtext.xbase.jvmmodel.*
import java.util.List
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import com.google.inject.Inject

/**
 * Infers a JVM model from the source model. 
 *
 * The JVM model should contain all elements in the Java code generated from your source model. 
 * Other Xtend models link against the JVM model rather than against the source model. The JVM
 * model elemens should be associated wiht their source element using the IJvmModelAssociator.     
 */
class PureXbaseJvmModelInferrer implements IJvmModelInferrer {

	@Inject IJvmModelAssociator jvmModelAssociator

   	override List<? extends JvmDeclaredType> inferJvmModel(EObject sourceObject) {
   		return newArrayList();
   	}
}
