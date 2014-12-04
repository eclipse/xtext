package org.eclipse.xtend.lib.macro.services;

import org.eclipse.xtend.lib.macro.declaration.Type;

/**
 * @since 2.8
 */
public interface GlobalTypeLookup {

	/**
	 * @param clazz
	 *            the clazz representing the type to look up
	 * @return the type with the same qualified name as the given
	 *         <code>Class</code> object, or <code>null</code> if that type
	 *         couldn't be found on the compilation units classpath.
	 */
	Type findTypeGlobally(Class<?> clazz);

	/**
	 * @param typeName
	 *            the qualified name of the type to look up. Nested class delimiter is expected to be the '.' (dot).
	 * @return the type with the given qualified name, or <code>null</code> if such a type
	 *         couldn't be found on the compilation units classpath.
	 */
	Type findTypeGlobally(String typeName);

}