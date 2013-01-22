package org.eclipse.xtend.lib.macro;

import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;

public interface ModifyContext extends Tracability, ProblemSupport {
	
	MutableClassDeclaration findGeneratedClass(String name);
	
	TypeReferenceProvider getTypeReferenceProvider();
}
