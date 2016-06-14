package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.lib.macro.declaration.Type
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit
import org.eclipse.xtend.lib.annotations.Data

@Data
class UnknownType implements Type {
	
	CompilationUnit compilationUnit
	String qualifiedName
	
	override isAssignableFrom(Type otherType) {
		return false;
	}
	
	override getSimpleName() {
		val idx = qualifiedName.lastIndexOf('.')
		if (idx >0 ) {
			qualifiedName.substring(idx)
		} else {
			qualifiedName
		}
	}
	
}