package org.xtext.idea.build;

import java.util.Arrays;
import java.util.List;

import org.jetbrains.jps.incremental.BuilderService;
import org.jetbrains.jps.incremental.ModuleLevelBuilder;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

public class XtextBuildService extends BuilderService {
	
	private final static Injector INJECTOR;
	
	static {
		Module builderServiceModule = new BuilderServiceModule();
		INJECTOR = Guice.createInjector(builderServiceModule);
	}
	
	public static Injector getInjector() {
		return INJECTOR;
	}
	
	@Inject
	private ModuleLevelBuilder moduleLevelBuilder;

	public XtextBuildService() {
		INJECTOR.injectMembers(this);
	}
	
	@Override
	public List<? extends ModuleLevelBuilder> createModuleLevelBuilders() {
		return Arrays.asList(moduleLevelBuilder);
	}

}
