/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.macro.CodeGenerationContext
import org.eclipse.xtend.lib.macro.file.FileLocations
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.macro.services.GlobalTypeLookup
import org.eclipse.xtend.lib.macro.services.Tracability

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class CodeGenerationContextImpl implements CodeGenerationContext {
	
	@Accessors CompilationUnitImpl unit
	
	@Delegate def FileLocations getFileLocations() {
		unit.fileLocations
	}
	
	@Delegate def MutableFileSystemSupport getFileSystemSupport() {
		unit.fileSystemSupport
	}
	
	@Delegate def GlobalTypeLookup getGlobalTypeLookup() {
		unit.typeLookup
	}
	
	@Delegate def Tracability getTracability() {
		unit.tracability
	}
}