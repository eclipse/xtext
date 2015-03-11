/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build;

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
