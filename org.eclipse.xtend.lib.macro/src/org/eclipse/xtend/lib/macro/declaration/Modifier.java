package org.eclipse.xtend.lib.macro.declaration;

/**
 * A list of all modifiers that are allowed on {@link MemberDeclaration}s in
 * Xtend source code
 */
public enum Modifier {
	/**
	 * The public visibility modifier, can be present on
	 * {@link FieldDeclaration fields}, {@link TypeDeclaration types} and
	 * {@link ExecutableDeclaration executables}
	 */
	PUBLIC,
	/**
	 * The private visibility modifier, can be present on
	 * {@link FieldDeclaration fields}, {@link TypeDeclaration types} and
	 * {@link ExecutableDeclaration executables}
	 */
	PRIVATE,
	/**
	 * The protected visibility modifier, can be present on
	 * {@link FieldDeclaration fields}, {@link TypeDeclaration types} and
	 * {@link ExecutableDeclaration executables}
	 */
	PROTECTED,
	/**
	 * The package private visibility modifier, can be present on
	 * {@link FieldDeclaration fields}, {@link TypeDeclaration types} and
	 * {@link ExecutableDeclaration executables}
	 */
	PACKAGE,
	/**
	 * The abstract modifier, can be present on {@link ClassDeclaration classes}
	 * and {@link MethodDeclaration methods}
	 */
	ABSTRACT,
	/**
	 * The static modifier, can be present on {@link TypeDeclaration types},
	 * {@link FieldDeclaration fields} and {@link MethodDeclaration methods}
	 */
	STATIC,
	/**
	 * The dispatch modifier, can be present on {@link MethodDeclaration
	 * methods}
	 */
	DISPATCH,
	/**
	 * The final modifier, can be present on {@link ClassDeclaration classes},
	 * {@link FieldDeclaration fields} and {@link MethodDeclaration methods}
	 */
	FINAL,
	/**
	 * The strict floating point modifier, can be present on
	 * {@link ClassDeclaration classes} and {@link MethodDeclaration methods}
	 */
	STRICTFP,
	/**
	 * The native modifier, can be present on {@link MethodDeclaration methods}
	 */
	NATIVE,
	/**
	 * The volatile modifier, can be present on {@link FieldDeclaration fields}
	 */
	VOLATILE,
	/**
	 * The synchronied modifier, can be present on {@link MethodDeclaration
	 * methods}
	 */
	SYNCHRONIZED,
	/**
	 * The transient modifier, can be present on {@link FieldDeclaration fields}
	 */
	TRANSIENT,
	/**
	 * The val modifier, can be present on {@link FieldDeclaration fields}
	 */
	VAL,
	/**
	 * The var modifier, can be present on {@link FieldDeclaration fields}
	 */
	VAR,
	/**
	 * The def modifier, can be present on {@link MethodDeclaration methods}
	 */
	DEF,
	/**
	 * The override modifier, can be present on {@link MethodDeclaration
	 * methods}
	 */
	OVERRIDE,
	
	/**
	 * The extension modifier, can be present on {@link FieldDeclaration fields}
	 * @since 2.8
	 */
	EXTENSION,
}
