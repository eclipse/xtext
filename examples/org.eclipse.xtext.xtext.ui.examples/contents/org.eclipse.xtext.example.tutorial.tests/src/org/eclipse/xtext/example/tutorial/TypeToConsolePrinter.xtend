package org.eclipse.xtext.example.tutorial

import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.common.types.JvmDeclaredType
import com.google.inject.Inject
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import com.google.inject.Provider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.xbase.XbaseStandaloneSetup
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.EcorePackage

class TypeToConsolePrinter implements IJvmDeclaredTypeAcceptor {

	@Inject extension JvmModelGenerator
	@Inject TypesBuilderExercise exercise
	@Inject Provider<XtextResourceSet> resourceSetProvider
	
	Resource workingResource

	def private createEObjectInNewResource() {
		val resourceSet = resourceSetProvider.get
		resourceSet.classpathURIContext = getClass()
		workingResource = resourceSet.createResource(URI::createURI('dummy.xmi'))
		val result = EcoreUtil::create(EcorePackage$Literals::EOBJECT);
		workingResource.contents += result
		return result
	}
	
	def private printToConsole() {
		workingResource.contents.forEach [ object |
			switch(object) {
				JvmDeclaredType : println(object.generateType)
			}
		]
	}
	
	def static void main(String[] args) {
		val injector = new XbaseStandaloneSetup().createInjectorAndDoEMFRegistration
		val it = injector.getInstance(typeof(TypeToConsolePrinter))
		val object = createEObjectInNewResource
		exercise.infer(object, it, false)
		printToConsole
	}

	override <T extends JvmDeclaredType> accept(T type) {
		if (type != null) {
			workingResource.contents += type
		}
		return [ if (type != null) it?.apply(type) ] 
	}
	
}