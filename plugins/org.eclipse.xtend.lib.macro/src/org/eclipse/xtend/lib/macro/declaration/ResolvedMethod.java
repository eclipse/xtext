package org.eclipse.xtend.lib.macro.declaration;

/**
 * {@link ResolvedExecutable Resolved} representation of a
 * {@link MethodDeclaration}.
 * 
 * @since 2.7
 */
public interface ResolvedMethod extends ResolvedExecutable {

	MethodDeclaration getDeclaration();

	/**
	 * @return the {@link ResolvedExecutable resolved} return type
	 */
	TypeReference getResolvedReturnType();

	/**
	 * @return the {@link ResolvedExecutable resolved} type parameters.
	 */
	Iterable<? extends ResolvedTypeParameter> getResolvedTypeParameters();
}
