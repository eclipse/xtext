package org.eclipse.xtend.lib.macro.declaration;


/**
 * @since 2.7
 */
public interface ResolvedMethod extends ResolvedExecutable {
	
	MethodDeclaration getDeclaration();

	TypeReference getResolvedReturnType();
	
	Iterable<? extends TypeParameterDeclaration> getResolvedTypeParameters();
}
