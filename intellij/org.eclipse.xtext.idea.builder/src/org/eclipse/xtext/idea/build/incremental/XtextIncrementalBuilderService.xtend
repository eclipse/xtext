package org.eclipse.xtext.idea.build.incremental

import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Injector
import org.jetbrains.jps.incremental.BuilderService
import org.jetbrains.jps.incremental.ModuleLevelBuilder

class XtextIncrementalBuilderService extends BuilderService {
	
	static Injector INJECTOR = Guice.createInjector(new IncrementalBuilderServiceModule)
	
	@Inject ModuleLevelBuilder moduleLevelBuilder

	new() {
		INJECTOR.injectMembers(this) 
	}

	override createModuleLevelBuilders() {
		return #[moduleLevelBuilder] 
	}
}