/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.asm;

/**
 * Initially copied from org.eclipse.jdt.internal.compiler.util.Util
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SignatureUtil {

	/**
	 * Character constant indicating the primitive type boolean in a signature.
	 * Value is <code>'Z'</code>.
	 */
	private static final char C_BOOLEAN 		= 'Z';

	/**
	 * Character constant indicating the primitive type byte in a signature.
	 * Value is <code>'B'</code>.
	 */
	private static final char C_BYTE 		= 'B';

	/**
	 * Character constant indicating the primitive type char in a signature.
	 * Value is <code>'C'</code>.
	 */
	private static final char C_CHAR 		= 'C';

	/**
	 * Character constant indicating the primitive type double in a signature.
	 * Value is <code>'D'</code>.
	 */
	private static final char C_DOUBLE 		= 'D';

	/**
	 * Character constant indicating the primitive type float in a signature.
	 * Value is <code>'F'</code>.
	 */
	private static final char C_FLOAT 		= 'F';

	/**
	 * Character constant indicating the primitive type int in a signature.
	 * Value is <code>'I'</code>.
	 */
	private static final char C_INT 			= 'I';

	/**
	 * Character constant indicating the semicolon in a signature.
	 * Value is <code>';'</code>.
	 */
	private static final char C_SEMICOLON 			= ';';

	/**
	 * Character constant indicating the primitive type long in a signature.
	 * Value is <code>'J'</code>.
	 */
	private static final char C_LONG			= 'J';

	/**
	 * Character constant indicating the primitive type short in a signature.
	 * Value is <code>'S'</code>.
	 */
	private static final char C_SHORT		= 'S';

	/**
	 * Character constant indicating result type void in a signature.
	 * Value is <code>'V'</code>.
	 */
	private static final char C_VOID			= 'V';

	/**
	 * Character constant indicating the start of a resolved type variable in a
	 * signature. Value is <code>'T'</code>.
	 * @since 3.0
	 */
	private static final char C_TYPE_VARIABLE	= 'T';

	/**
	 * Character constant indicating an unbound wildcard type argument
	 * in a signature.
	 * Value is <code>'*'</code>.
	 * @since 3.0
	 */
	private static final char C_STAR	= '*';

	/**
	 * Character constant indicating a bound wildcard type argument
	 * in a signature with extends clause.
	 * Value is <code>'+'</code>.
	 * @since 3.1
	 */
	private static final char C_EXTENDS	= '+';

	/**
	 * Character constant indicating a bound wildcard type argument
	 * in a signature with super clause.
	 * Value is <code>'-'</code>.
	 * @since 3.1
	 */
	private static final char C_SUPER	= '-';

	/**
	 * Character constant indicating the dot in a signature.
	 * Value is <code>'.'</code>.
	 */
	private static final char C_DOT			= '.';

	/**
	 * Character constant indicating an array type in a signature.
	 * Value is <code>'['</code>.
	 */
	private static final char C_ARRAY		= '[';

	/**
	 * Character constant indicating the start of a resolved, named type in a
	 * signature. Value is <code>'L'</code>.
	 */
	private static final char C_RESOLVED		= 'L';

	/**
	 * Character constant indicating the start of an unresolved, named type in a
	 * signature. Value is <code>'Q'</code>.
	 */
	private static final char C_UNRESOLVED	= 'Q';

	/**
	 * Character constant indicating the start of a formal type parameter
	 * (or type argument) list in a signature. Value is <code>'&lt;'</code>.
	 * @since 3.0
	 */
	private static final char C_GENERIC_START	= '<';

	/**
	 * Character constant indicating the end of a generic type list in a
	 * signature. Value is <code>'&gt;'</code>.
	 * @since 3.0
	 */
	private static final char C_GENERIC_END	= '>';

	/**
	 * Character constant indicating a capture of a wildcard type in a
	 * signature. Value is <code>'!'</code>.
	 * @since 3.1
	 */
	private static final char C_CAPTURE	= '!';

	/**
	 * Scans the given string for a type signature starting at the given index
	 * and returns the index of the last character.
	 * <pre>
	 * TypeSignature:
	 *  |  BaseTypeSignature
	 *  |  ArrayTypeSignature
	 *  |  ClassTypeSignature
	 *  |  TypeVariableSignature
	 * </pre>
	 *
	 * @param string the signature string
	 * @param start the 0-based character index of the first character
	 * @return the 0-based character index of the last character
	 * @exception IllegalArgumentException if this is not a type signature
	 */
	static int scanTypeSignature(String string, int start) {
		// need a minimum 1 char
		if (start >= string.length()) {
			throw new IllegalArgumentException();
		}
		char c = string.charAt(start);
		switch (c) {
			case C_ARRAY :
				return scanArrayTypeSignature(string, start);
			case C_RESOLVED :
			case C_UNRESOLVED :
				return scanClassTypeSignature(string, start);
			case C_TYPE_VARIABLE :
				return scanTypeVariableSignature(string, start);
			case C_BOOLEAN :
			case C_BYTE :
			case C_CHAR :
			case C_DOUBLE :
			case C_FLOAT :
			case C_INT :
			case C_LONG :
			case C_SHORT :
			case C_VOID :
				return scanBaseTypeSignature(string, start);
			case C_CAPTURE :
				return scanCaptureTypeSignature(string, start);
			case C_EXTENDS:
			case C_SUPER:
			case C_STAR:
				return scanTypeBoundSignature(string, start);
			default :
				throw new IllegalArgumentException();
		}
	}

	/**
	 * Scans the given string for a base type signature starting at the given index
	 * and returns the index of the last character.
	 * <pre>
	 * BaseTypeSignature:
	 *     <b>B</b> | <b>C</b> | <b>D</b> | <b>F</b> | <b>I</b>
	 *   | <b>J</b> | <b>S</b> | <b>V</b> | <b>Z</b>
	 * </pre>
	 * Note that although the base type "V" is only allowed in method return types,
	 * there is no syntactic ambiguity. This method will accept them anywhere
	 * without complaint.
	 *
	 * @param string the signature string
	 * @param start the 0-based character index of the first character
	 * @return the 0-based character index of the last character
	 * @exception IllegalArgumentException if this is not a base type signature
	 */
	private static int scanBaseTypeSignature(String string, int start) {
		// need a minimum 1 char
		if (start >= string.length()) {
			throw new IllegalArgumentException();
		}
		char c = string.charAt(start);
		if ("BCDFIJSVZ".indexOf(c) >= 0) { //$NON-NLS-1$
			return start;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Scans the given string for an array type signature starting at the given
	 * index and returns the index of the last character.
	 * <pre>
	 * ArrayTypeSignature:
	 *     <b>[</b> TypeSignature
	 * </pre>
	 *
	 * @param string the signature string
	 * @param start the 0-based character index of the first character
	 * @return the 0-based character index of the last character
	 * @exception IllegalArgumentException if this is not an array type signature
	 */
	private static int scanArrayTypeSignature(String string, int start) {
		int length = string.length();
		// need a minimum 2 char
		if (start >= length - 1) {
			throw new IllegalArgumentException();
		}
		char c = string.charAt(start);
		if (c != C_ARRAY) {
			throw new IllegalArgumentException();
		}
	
		c = string.charAt(++start);
		while(c == C_ARRAY) {
			// need a minimum 2 char
			if (start >= length - 1) {
				throw new IllegalArgumentException();
			}
			c = string.charAt(++start);
		}
		return scanTypeSignature(string, start);
	}

	/**
	 * Scans the given string for a capture of a wildcard type signature starting at the given
	 * index and returns the index of the last character.
	 * <pre>
	 * CaptureTypeSignature:
	 *     <b>!</b> TypeBoundSignature
	 * </pre>
	 *
	 * @param string the signature string
	 * @param start the 0-based character index of the first character
	 * @return the 0-based character index of the last character
	 * @exception IllegalArgumentException if this is not a capture type signature
	 */
	private static int scanCaptureTypeSignature(String string, int start) {
		// need a minimum 2 char
		if (start >= string.length() - 1) {
			throw new IllegalArgumentException();
		}
		char c = string.charAt(start);
		if (c != C_CAPTURE) {
			throw new IllegalArgumentException();
		}
		return scanTypeBoundSignature(string, start + 1);
	}

	/**
	 * Scans the given string for a type variable signature starting at the given
	 * index and returns the index of the last character.
	 * <pre>
	 * TypeVariableSignature:
	 *     <b>T</b> Identifier <b>;</b>
	 * </pre>
	 *
	 * @param string the signature string
	 * @param start the 0-based character index of the first character
	 * @return the 0-based character index of the last character
	 * @exception IllegalArgumentException if this is not a type variable signature
	 */
	private static int scanTypeVariableSignature(String string, int start) {
		// need a minimum 3 chars "Tx;"
		if (start >= string.length() - 2) {
			throw new IllegalArgumentException();
		}
		// must start in "T"
		char c = string.charAt(start);
		if (c != C_TYPE_VARIABLE) {
			throw new IllegalArgumentException();
		}
		int id = scanIdentifier(string, start + 1);
		c = string.charAt(id + 1);
		if (c == C_SEMICOLON) {
			return id + 1;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Scans the given string for an identifier starting at the given
	 * index and returns the index of the last character.
	 * Stop characters are: ";", ":", "&lt;", "&gt;", "/", ".".
	 *
	 * @param string the signature string
	 * @param start the 0-based character index of the first character
	 * @return the 0-based character index of the last character
	 * @exception IllegalArgumentException if this is not an identifier
	 */
	private static int scanIdentifier(String string, int start) {
		// need a minimum 1 char
		if (start >= string.length()) {
			throw new IllegalArgumentException();
		}
		int p = start;
		while (true) {
			char c = string.charAt(p);
			if (c == '<' || c == '>' || c == ':' || c == ';' || c == '.' || c == '/') {
				return p - 1;
			}
			p++;
			if (p == string.length()) {
				return p - 1;
			}
		}
	}

	/**
	 * Scans the given string for a class type signature starting at the given
	 * index and returns the index of the last character.
	 * <pre>
	 * ClassTypeSignature:
	 *     { <b>L</b> | <b>Q</b> } Identifier
	 *           { { <b>/</b> | <b>.</b> Identifier [ <b>&lt;</b> TypeArgumentSignature* <b>&gt;</b> ] }
	 *           <b>;</b>
	 * </pre>
	 * Note that although all "/"-identifiers most come before "."-identifiers,
	 * there is no syntactic ambiguity. This method will accept them without
	 * complaint.
	 *
	 * @param string the signature string
	 * @param start the 0-based character index of the first character
	 * @return the 0-based character index of the last character
	 * @exception IllegalArgumentException if this is not a class type signature
	 */
	private static int scanClassTypeSignature(String string, int start) {
		// need a minimum 3 chars "Lx;"
		if (start >= string.length() - 2) {
			throw new IllegalArgumentException();
		}
		// must start in "L" or "Q"
		char c = string.charAt(start);
		if (c != C_RESOLVED && c != C_UNRESOLVED) {
			return -1;
		}
		int p = start + 1;
		while (true) {
			if (p >= string.length()) {
				throw new IllegalArgumentException();
			}
			c = string.charAt(p);
			if (c == C_SEMICOLON) {
				// all done
				return p;
			} else if (c == C_GENERIC_START) {
				int e = scanTypeArgumentSignatures(string, p);
				p = e;
			} else if (c == C_DOT || c == '/') {
				int id = scanIdentifier(string, p + 1);
				p = id;
			}
			p++;
		}
	}

	/**
	 * Scans the given string for a type bound signature starting at the given
	 * index and returns the index of the last character.
	 * <pre>
	 * TypeBoundSignature:
	 *     <b>[-+]</b> TypeSignature <b>;</b>
	 *     <b>*</b></b>
	 * </pre>
	 *
	 * @param string the signature string
	 * @param start the 0-based character index of the first character
	 * @return the 0-based character index of the last character
	 * @exception IllegalArgumentException if this is not a type variable signature
	 */
	private static int scanTypeBoundSignature(String string, int start) {
		// need a minimum 1 char for wildcard
		if (start >= string.length()) {
			throw new IllegalArgumentException();
		}
		char c = string.charAt(start);
		switch (c) {
			case C_STAR :
				return start;
			case C_SUPER :
			case C_EXTENDS :
				// need a minimum 3 chars "+[I"
				if (start >= string.length() - 2) {
					throw new IllegalArgumentException();
				}
				break;
			default :
				// must start in "+/-"
					throw new IllegalArgumentException();
	
		}
		c = string.charAt(++start);
		switch (c) {
			case C_CAPTURE :
				return scanCaptureTypeSignature(string, start);
			case C_SUPER :
			case C_EXTENDS :
				return scanTypeBoundSignature(string, start);
			case C_RESOLVED :
			case C_UNRESOLVED :
				return scanClassTypeSignature(string, start);
			case C_TYPE_VARIABLE :
				return scanTypeVariableSignature(string, start);
			case C_ARRAY :
				return scanArrayTypeSignature(string, start);
			case C_STAR:
				return start;
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * Scans the given string for a list of type argument signatures starting at
	 * the given index and returns the index of the last character.
	 * <pre>
	 * TypeArgumentSignatures:
	 *     <b>&lt;</b> TypeArgumentSignature* <b>&gt;</b>
	 * </pre>
	 * Note that although there is supposed to be at least one type argument, there
	 * is no syntactic ambiguity if there are none. This method will accept zero
	 * type argument signatures without complaint.
	 *
	 * @param string the signature string
	 * @param start the 0-based character index of the first character
	 * @return the 0-based character index of the last character
	 * @exception IllegalArgumentException if this is not a list of type arguments
	 * signatures
	 */
	private static int scanTypeArgumentSignatures(String string, int start) {
		// need a minimum 2 char "<>"
		if (start >= string.length() - 1) {
			throw new IllegalArgumentException();
		}
		char c = string.charAt(start);
		if (c != C_GENERIC_START) {
			throw new IllegalArgumentException();
		}
		int p = start + 1;
		while (true) {
			if (p >= string.length()) {
				throw new IllegalArgumentException();
			}
			c = string.charAt(p);
			if (c == C_GENERIC_END) {
				return p;
			}
			int e = scanTypeArgumentSignature(string, p);
			p = e + 1;
		}
	}

	/**
	 * Scans the given string for a type argument signature starting at the given
	 * index and returns the index of the last character.
	 * <pre>
	 * TypeArgumentSignature:
	 *     <b>&#42;</b>
	 *  |  <b>+</b> TypeSignature
	 *  |  <b>-</b> TypeSignature
	 *  |  TypeSignature
	 * </pre>
	 * Note that although base types are not allowed in type arguments, there is
	 * no syntactic ambiguity. This method will accept them without complaint.
	 *
	 * @param string the signature string
	 * @param start the 0-based character index of the first character
	 * @return the 0-based character index of the last character
	 * @exception IllegalArgumentException if this is not a type argument signature
	 */
	static int scanTypeArgumentSignature(String string, int start) {
		// need a minimum 1 char
		if (start >= string.length()) {
			throw new IllegalArgumentException();
		}
		char c = string.charAt(start);
		switch (c) {
			case C_STAR :
				return start;
			case C_EXTENDS :
			case C_SUPER :
				return scanTypeBoundSignature(string, start);
			default :
				return scanTypeSignature(string, start);
		}
	}
}