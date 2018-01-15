/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import com.google.inject.ImplementedBy
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent

/**
 * File system access for the Xtext generator.
 */
@ImplementedBy(XtextGeneratorFileSystemAccess)
interface IXtextGeneratorFileSystemAccess extends IFileSystemAccess2, IGuiceAwareGeneratorComponent {
	
	def String getPath()
	
	def boolean isOverwrite()
	
}
