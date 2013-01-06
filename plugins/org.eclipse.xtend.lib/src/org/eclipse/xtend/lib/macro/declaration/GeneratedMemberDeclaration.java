package org.eclipse.xtend.lib.macro.declaration;

public interface GeneratedMemberDeclaration extends GeneratedDeclaration, MemberDeclaration {
	public void setDocComment(String docComment);
	public void setVisibility(Visibility visibility);
	public GeneratedTypeDeclaration getDeclaringType();
}
