/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtext.xtext.wizard.ProjectDescriptor
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@FinalFieldsConstructor
abstract class TestedProjectDescriptor extends ProjectDescriptor {
	def TestProjectDescriptor getTestProject()
	
	override getExternalDependencies() {
		val deps = newLinkedHashSet
		deps += super.externalDependencies
		if (testProject.isInlined)
			deps += testProject.externalDependencies
		deps
	}
	
	override getSourceFolders() {
		val sourceFolders = newLinkedHashSet
		sourceFolders += super.sourceFolders
		if (testProject.isInlined)
			sourceFolders += testProject.sourceFolders
		sourceFolders
	}
	
	override getFiles() {
		val files = newArrayList
		files += super.files
		if (testProject.isInlined)
			files += testProject.files.filter[fileFromTestProject| !files.exists[relativePath == fileFromTestProject.relativePath]]
		files
	}
}