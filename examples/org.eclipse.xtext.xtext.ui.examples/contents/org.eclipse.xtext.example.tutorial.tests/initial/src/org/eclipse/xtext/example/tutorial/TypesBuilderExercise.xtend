package org.eclipse.xtext.example.tutorial

import com.google.inject.Inject
import java.io.Serializable
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.common.types.JvmDeclaredType

class TypesBuilderExercise implements IJvmModelInferrer {
	
	@Inject extension JvmTypesBuilder
	
	override infer(EObject sourceObject, IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		val initializable = acceptor.accept(toClass(sourceObject, "EmptyClass"))
		initializable.initializeLater [ 
			JvmDeclaredType emptyClass | emptyClass.superTypes += newTypeRef(sourceObject, typeof(Serializable))
		]
	}
	
}