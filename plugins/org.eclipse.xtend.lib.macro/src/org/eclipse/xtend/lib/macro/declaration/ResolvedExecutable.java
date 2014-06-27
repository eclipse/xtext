package org.eclipse.xtend.lib.macro.declaration;

/**
 * @since 2.7
 */
public interface ResolvedExecutable {
	
	ExecutableDeclaration getDeclaration();
	
	Iterable<? extends ResolvedParameter> getResolvedParameters();
	
	Iterable<? extends TypeReference> getResolvedExceptions();
}
