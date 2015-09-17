package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@FinalFieldsConstructor
abstract class TextFile {
	@Accessors val Outlet outlet
	@Accessors val String relativePath
	@Accessors val ProjectDescriptor project

	abstract def String getContent()
}