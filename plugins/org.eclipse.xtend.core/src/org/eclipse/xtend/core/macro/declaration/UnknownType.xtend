package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.lib.macro.declaration.Type
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit

@Data
class UnknownType implements Type {
	
	CompilationUnit compilationUnit
	String name
	
	override isAssignableFrom(Type otherType) {
		return false;
	}
	
}