package org.eclipse.xtend.lib.macro.declaration;

/**
 * {@link ResolvedExecutable Resolved} representation of a
 * {@link ConstructorDeclaration}.
 * 
 * @since 2.7
 */
public interface ResolvedConstructor extends ResolvedExecutable {
	ConstructorDeclaration getDeclaration();
}
