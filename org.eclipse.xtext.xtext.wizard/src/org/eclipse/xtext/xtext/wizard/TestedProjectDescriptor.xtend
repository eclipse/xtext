/*******************************************************************************
 * Copyright (c) 2015, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

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