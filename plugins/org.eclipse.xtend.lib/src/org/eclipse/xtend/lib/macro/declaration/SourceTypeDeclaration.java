package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

public interface SourceTypeDeclaration extends SourceMemberDeclaration, TypeDeclaration {
	public List<SourceMemberDeclaration> getMembers();
}
