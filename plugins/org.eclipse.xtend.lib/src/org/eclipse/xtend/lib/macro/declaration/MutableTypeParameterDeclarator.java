package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

import org.eclipse.xtend.lib.macro.type.TypeReference;

public interface MutableTypeParameterDeclarator extends MutableMemberDeclaration, TypeParameterDeclarator {
	public List<MutableTypeParameterDeclaration> getTypeParameters();

	MutableTypeParameterDeclaration addTypeParameter(String name, TypeReference... upperBounds);
}
