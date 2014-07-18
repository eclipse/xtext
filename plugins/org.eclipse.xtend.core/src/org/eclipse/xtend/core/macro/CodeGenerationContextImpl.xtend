/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.macro.CodeGenerationContext
import org.eclipse.xtend.lib.macro.file.FileLocations
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class CodeGenerationContextImpl implements CodeGenerationContext {
	
	@Accessors @Delegate MutableFileSystemSupport fileSystemSupport
	@Accessors @Delegate FileLocations fileLocations
	
}