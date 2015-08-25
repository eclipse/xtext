package org.eclipse.xtext.xtext.generator.model

import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent

interface IXtextGeneratorFileSystemAccess extends IFileSystemAccess2, IGuiceAwareGeneratorComponent {
	
	def String getPath()
	
	def boolean isOverwrite()
}