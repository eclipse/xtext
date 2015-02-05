package org.eclipse.xtext.idea.build.incremental

import com.google.inject.AbstractModule
import com.google.inject.Scopes
import org.eclipse.xtext.idea.build.XtextIdeaRefreshComponent
import org.jetbrains.jps.incremental.ModuleLevelBuilder

class IncrementalBuilderServiceModule extends AbstractModule {
	
	override protected configure() {
		bind(ModuleLevelBuilder).to(XtextIncrementalBuilder).in(Scopes.SINGLETON);
		bind(XtextIdeaRefreshComponent).in(Scopes.SINGLETON);
	}	
}