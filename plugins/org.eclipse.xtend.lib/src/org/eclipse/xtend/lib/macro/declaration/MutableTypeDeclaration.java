package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

public interface MutableTypeDeclaration extends MutableMemberDeclaration, TypeDeclaration {
	public List<? extends MutableMemberDeclaration> getMembers();
	void setSimpleName(String simpleName);
	void setPackageName(String packageName);
	
	void addMember(MutableMemberDeclaration member);
	void addMember(int index, MutableMemberDeclaration member);
	void removeMember(MutableMemberDeclaration member);
}
