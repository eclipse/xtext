package org.eclipse.xtend.lib.macro.declaration;

public interface MutableParameterDeclaration extends MutableDeclaration, ParameterDeclaration {
	public MutableExecutableDeclaration getDeclaringExecutable();
}
