package org.eclipse.xtend.lib.macro.declaration;

public interface SourceMemberDeclaration extends MemberDeclaration, SourceNamedElement {
	public SourceTypeDeclaration getDeclaringType();
}
