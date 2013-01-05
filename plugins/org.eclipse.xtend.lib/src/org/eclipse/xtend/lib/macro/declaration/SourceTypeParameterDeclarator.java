package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

public interface SourceTypeParameterDeclarator extends TypeParameterDeclarator, SourceMemberDeclaration {
	public List<SourceTypeParameterDeclaration> getTypeParameters();
}
