package org.eclipse.xtend.lib.macro.declaration;

public interface MutableMemberDeclaration extends MutableDeclaration, MemberDeclaration {
	public void setDocComment(String docComment);
	public void setVisibility(Visibility visibility);
	public MutableTypeDeclaration getDeclaringType();
}
