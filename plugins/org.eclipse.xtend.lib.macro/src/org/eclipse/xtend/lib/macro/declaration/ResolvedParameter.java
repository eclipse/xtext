package org.eclipse.xtend.lib.macro.declaration;

/**
 * @since 2.7
 */
public interface ResolvedParameter {
	ParameterDeclaration getDeclaration();
	TypeReference getResolvedType();
}
