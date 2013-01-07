package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

public interface MutableTypeParameterDeclarator extends MutableMemberDeclaration, TypeParameterDeclarator {
	public List<MutableTypeParameterDeclaration> getTypeParameters();

	void addTypeParameter(MutableTypeParameterDeclaration typeParameter);
	void addTypeParameter(int index, MutableTypeParameterDeclaration typeParameter);
	void removeTypeParameter(MutableTypeParameterDeclaration typeParameter);
}
