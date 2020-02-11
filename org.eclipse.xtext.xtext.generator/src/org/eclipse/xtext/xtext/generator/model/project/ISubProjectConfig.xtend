/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model.project

import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess

/**
 * Configuration of subprojects.
 * 
 * @noimplement This interface should not be implemented by clients.
 */
interface ISubProjectConfig extends IGuiceAwareGeneratorComponent {
	
	def boolean isEnabled()
	
	def String getName()
	
	def IXtextGeneratorFileSystemAccess getRoot()
	
	def IXtextGeneratorFileSystemAccess getMetaInf()
	
	def IXtextGeneratorFileSystemAccess getSrc()
	
	def IXtextGeneratorFileSystemAccess getSrcGen()
	
	def IXtextGeneratorFileSystemAccess getIcons()
	
}
