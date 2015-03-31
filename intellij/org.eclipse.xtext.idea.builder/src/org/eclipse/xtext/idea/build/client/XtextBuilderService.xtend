/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.client

import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Injector
import org.jetbrains.jps.incremental.BuilderService
import org.jetbrains.jps.incremental.ModuleLevelBuilder

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtextBuilderService extends BuilderService {
	
	static Injector INJECTOR = Guice.createInjector(new XtextIdeaBuilderModule)
	
	@Inject ModuleLevelBuilder moduleLevelBuilder

	new() {
		INJECTOR.injectMembers(this) 
	}

	override createModuleLevelBuilders() {
		return #[moduleLevelBuilder] 
	}
}