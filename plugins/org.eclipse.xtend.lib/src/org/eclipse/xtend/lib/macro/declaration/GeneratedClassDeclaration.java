package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

import org.eclipse.xtend.lib.macro.type.TypeReference;

public interface GeneratedClassDeclaration extends GeneratedTypeDeclaration, ClassDeclaration {
	public void setSuperclass(TypeReference superclass);
	public void setImplementedInterfaces(List<? extends TypeReference> superclass);
	void setAbstract(boolean isAbstract);
	void setFinal(boolean isFinal);
	void setStatic(boolean isStatic);
}
