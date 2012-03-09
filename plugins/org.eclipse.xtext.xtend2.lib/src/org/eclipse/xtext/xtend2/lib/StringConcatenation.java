/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.lib;

/**
 * <p>
 * A {@link StringConcatenation} allows for efficient, indentation aware concatenation of character sequences.
 * </p>
 * <p>
 * In addition to the methods that are specified by the implemented interface {@link CharSequence}, there are some other
 * public operations that allow to modify the contents of this sequence. The string representation of arbitrary objects
 * can be appended to an instance of {@link StringConcatenation}. There are overloaded variants of
 * {@link #append(Object, String)} that allow to pass an indentation that should be applied to each line of the appended
 * content. Each line break that is part of the new content will be replaced by the line delimiter that was configured
 * for this {@link StringConcatenation}.
 * </p>
 * <p>
 * The {@link #append(Object) append}-operation ignores <code>null</code> arguments. This is different to what
 * {@link StringBuffer} or {@link StringBuilder} do and that's the reason why the {@link Appendable} interface is not
 * fulfilled by a {@link StringConcatenation}.
 * <p>
 * <p>
 * The object uses an internal {@link List} of {@link String Strings} that is concatenated on demand to a complete
 * sequence. Use {@link #toString()} to get the joined version of a {@link StringConcatenation}.
 * </p>
 * <p>
 * {@link #equals(Object)} and {@link #hashCode()} are not specialized for a {@link StringConcatenation}, that is, the
 * semantics are based on identity similar to what {@link StringBuffer} and {@link StringBuilder} do.
 * </p>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @deprecated use org.eclipse.xtend2.lib.StringConcatenation from bundle org.eclipse.xtend2.lib
 */
@Deprecated
public class StringConcatenation extends org.eclipse.xtend2.lib.StringConcatenation {

	/**
	 * The default line delimiter that is used by instances of {@link StringConcatenation}. It uses
	 * <code>System.getProperty("line.separator")</code>.
	 * @since 2.2
	 */
	public static final String DEFAULT_LINE_DELIMITER = System.getProperty("line.separator");

	/**
	 * Create a new concatenation that uses the system line delimiter.
	 * 
	 * @see System#getProperties()
	 * @see System#getProperty(String)
	 */
	public StringConcatenation() {
		super();
	}

	/**
	 * Create a new concatenation with the specified delimiter.
	 * 
	 * @param lineDelimiter
	 *            the used delimiter.
	 * @throws IllegalArgumentException
	 *             if the lineDelimiter is <code>null</code> or the empty String.
	 * @since 2.2
	 */
	public StringConcatenation(String lineDelimiter) {
		super(lineDelimiter);
	}

}