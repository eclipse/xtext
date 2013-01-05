package org.eclipse.xtend.lib.macro.declaration;

public interface SourceMemberDeclaration extends SourceDeclaration, MemberDeclaration {
	public SourceTypeDeclaration getDeclaringType();
}
