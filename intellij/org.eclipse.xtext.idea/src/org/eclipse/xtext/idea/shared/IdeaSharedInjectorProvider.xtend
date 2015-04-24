package org.eclipse.xtext.idea.shared

import com.google.inject.Guice
import com.google.inject.Injector

class IdeaSharedInjectorProvider {

	static val INSTANCE = new IdeaSharedInjectorProvider

	val Injector injector

	static def getInjector() {
		INSTANCE.injector
	}

	new() {
		injector = Guice.createInjector(new IdeaSharedModule())
	}

}