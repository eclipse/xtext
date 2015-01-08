package bootstrap

import org.eclipse.xtext.xdoc.XdocStandaloneSetup
import com.google.inject.Module
import org.eclipse.xtext.xdoc.XdocRuntimeModule
import com.google.inject.Binder
import com.google.inject.Guice

class Config extends XdocStandaloneSetup implements Module {
	
	def static void main(String[] args) {
		val injector = new XdocStandaloneSetup().createInjectorAndDoEMFRegistration
		injector.getInstance(typeof(GenerateBootstrapDoc)).generate
	}
	
	override createInjector() {
		Guice::createInjector(new XdocRuntimeModule, this)
	}
	
	override configure(Binder binder) {
		
	}
	
}