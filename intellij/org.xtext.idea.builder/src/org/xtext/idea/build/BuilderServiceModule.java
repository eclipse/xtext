package org.xtext.idea.build;

import org.jetbrains.jps.incremental.ModuleLevelBuilder;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class BuilderServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ModuleLevelBuilder.class).to(XtextModuleLevelBuilder.class).in(Scopes.SINGLETON);
		bind(XtextIdeaRefreshComponent.class).in(Scopes.SINGLETON);
	}

}
