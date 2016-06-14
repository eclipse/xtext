/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Injector
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess
import org.eclipse.emf.mwe2.runtime.Mandatory

/**
 * Generator fragment that allows to write files to arbitrary, user configurable
 * locations.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractExternalFolderAwareFragment extends AbstractXtextGeneratorFragment {
	
	String absolutePath
	
	@Accessors(PROTECTED_GETTER, PUBLIC_SETTER)
	boolean ^override = false
	
	IXtextGeneratorFileSystemAccess outputLocation
	
	protected def getOutputLocation() {
		return outputLocation
	}
	
	override initialize(Injector injector) {
		super.initialize(injector)
		this.outputLocation = new XtextGeneratorFileSystemAccess(absolutePath, override)
		injector.injectMembers(outputLocation)
	}
	
	protected def getAbsolutePath() {
		return absolutePath
	}
	
	@Mandatory
	def void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath
	}
	
}