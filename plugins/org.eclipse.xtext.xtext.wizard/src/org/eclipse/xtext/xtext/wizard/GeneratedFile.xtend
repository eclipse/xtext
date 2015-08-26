package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@FinalFieldsConstructor
abstract class GeneratedFile {
	@Accessors val Outlet outlet
	@Accessors val String relativePath
	abstract def byte[] getBytes()
}