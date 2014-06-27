package org.eclipse.xtend.lib.macro.declaration;

/**
 * The resolved representation of a parameter in the context of a type
 * reference. Consider for instance this method
 * 
 * <pre>
 * interface Foo&lt;T&gt; {
 *  def void foo(T arg)
 * }
 * </pre>
 * 
 * In the context of the type reference <code>Foo&lt;String&gt;</code>, the
 * parameter <code>arg</code> has the type <code>String</code>
 * 
 * @since 2.7
 */
public interface ResolvedParameter {
	/**
	 * @return the declaration being {@link ResolvedParameter resolved}
	 */
	ParameterDeclaration getDeclaration();

	/**
	 * @return the {@link ResolvedParameter resolved} type of the parameter
	 */
	TypeReference getResolvedType();
}
