/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.bracketmatching

import org.eclipse.xtend.lib.annotations.Data

/**
 * Defines a single pair of braces which need to be matched when editing code.
 * 
 * @author kosyakov - Initial contribution and API
 */
@Data
class BracePair {
	/**
	 * The length of a left brace should be one character for Eclipse.
	 */
	val String leftBrace
	/**
	 * The length of a right brace should be one character for Eclipse.
	 */
	val String rightBrace
	/**
	 * True if the brace is structural. Structural braces have higher priority than regular braces:
	 * they are matched with each other even if there are unmatched braces of other types between them,
	 * and an opening non-structural brace is not matched with a closing one if one of them is outside a pair
	 * of matched structural braces and another is outside. In Java code, the curly braces are structural.
	 * 
	 * It is ignored by Eclipse.
	 */
	val boolean structural
}