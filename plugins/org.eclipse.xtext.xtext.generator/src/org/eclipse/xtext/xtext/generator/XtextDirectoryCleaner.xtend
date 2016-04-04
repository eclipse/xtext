/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Inject
import com.google.inject.Injector
import java.io.File
import java.util.List
import org.eclipse.emf.mwe.utils.DirectoryCleaner
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig

/**
 * @noextend
 */
class XtextDirectoryCleaner implements IGuiceAwareGeneratorComponent {
	@Inject IXtextProjectConfig config

	@Accessors(PUBLIC_SETTER)
	boolean enabled = true
	@Accessors(PUBLIC_SETTER)
	boolean useDefaultExcludes = true
	
	List<String> excludes = newArrayList
	List<String> extraDirectories = newArrayList

	def void addExtraDirectory(String directory) {
		extraDirectories += directory
	}

	def void addExclude(String exclude) {
		excludes += exclude
	}

	def void clean() {
		if (!enabled)
			return;
			
		val directories = newArrayList
		directories += (config.enabledProjects.map[srcGen] + #[config.runtime.ecoreModel]).filterNull.map[path].filter[new File(it).isDirectory]
		directories += extraDirectories
		
		val delegate = new DirectoryCleaner
		delegate.useDefaultExcludes = useDefaultExcludes
		for (it : excludes)
			delegate.addExclude(it)

		for (it : directories)
			delegate.cleanFolder(it)
	}
	
	override initialize(Injector injector) {
		injector.injectMembers(this)
	}
	
}