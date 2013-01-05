package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

public interface GeneratedTypeDeclaration extends GeneratedMemberDeclaration, TypeDeclaration {
	public List<GeneratedMemberDeclaration> getMembers();
}
