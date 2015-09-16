package org.eclipse.xtend.core.idea

import org.eclipse.xtend.core.XtendStandaloneSetupGenerated
import org.eclipse.xtext.util.Modules2
import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Module

class XtendStandaloneSetupIdea extends XtendStandaloneSetupGenerated {

	override Injector createInjector() {
		var Module runtimeModule = new org.eclipse.xtend.core.XtendRuntimeModule()
		var Module ideaModule = new org.eclipse.xtend.core.idea.XtendIdeaModule()
		var Module mergedModule = Modules2.mixin(runtimeModule, ideaModule)
		return Guice.createInjector(mergedModule)
	}
}
