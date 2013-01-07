package org.eclipse.xtend.lib.macro.declaration;

import org.eclipse.xtend.lib.macro.type.TypeReference;

public interface MutableMethodDeclaration extends MutableExecutableDeclaration, MethodDeclaration {
	void setReturnType(TypeReference type);
}
