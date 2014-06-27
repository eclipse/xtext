package org.eclipse.xtend.lib.macro.declaration;

/**
 * The resolved representation of a type parameter in the context of a type
 * reference. Consider for instance this method:
 * 
 * <pre>
 * interface Foo&lt;T&gt; {
 *  def &lt;U extends T&gt; void foo(U arg)
 * }
 * </pre>
 * 
 * For a <code>Foo&lt;CharSequence&gt;</code>, the type parameter <code>U</code>
 * would have the upper bound <code>CharSequence</code>
 */
public interface ResolvedTypeParameter {
	/**
	 * @return the declaration that is {@link ResolvedTypeParameter resolved}
	 */
	TypeParameterDeclaration getDeclaration();

	/**
	 * @return the {@link ResolvedTypeParameter resolved} upper bounds
	 */
	Iterable<? extends TypeReference> getResolvedUpperBounds();
}