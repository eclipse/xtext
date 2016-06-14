package org.eclipse.xtend.lib.macro.declaration;

import java.util.ArrayList;
import java.util.List;

/**
 * Resolved representation of an {@link ExecutableDeclaration}.
 * 
 * Parameter types and declared exceptions are put into the context of a
 * specific declaring reference, e.g. {@link List#add(Object) List#add(Object)}
 * becomes <code>List#add(String)</code> in the context of an {@link ArrayList
 * ArrayList&lt;String&gt;}
 * 
 * @since 2.7
 */
public interface ResolvedExecutable {

	/**
	 * @return the executable that is {@link ResolvedExecutable resolved}
	 */
	ExecutableDeclaration getDeclaration();

	/**
	 * @return the {@link ResolvedExecutable resolved} parameters
	 */
	Iterable<? extends ResolvedParameter> getResolvedParameters();

	/**
	 * @return the {@link ResolvedExecutable resolved} exceptions
	 */
	Iterable<? extends TypeReference> getResolvedExceptionTypes();
	
	/**
	 * Returns the simple signature of this executable. The simple signature of
	 * <code>List&lt;String&gt;.addAll(int, Collection&lt;E&gt)</code> is
	 * <code>addAll(int, Collection&lt;String&gt;)</code>.
	 * @return the simple, human-readable signature
	 */
	String getSimpleSignature();
}
