/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import static java.lang.System.*;

import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.IntegerKey;
import org.eclipse.xtext.preferences.StringKey;
import org.eclipse.xtext.preferences.TypedPreferenceKey;
import org.eclipse.xtext.preferences.TypedPreferenceValues;

/**
 * General preference keys used by this formatting infrastructure. Formatters based on this infrastructure should honor
 * these keys as well.
 * 
 * To set a values for one of these keys, use {@link FormatterRequest#setPreferences(ITypedPreferenceValues)}.
 * 
 * To access a value for one of these keys, use {@link AbstractFormatter2#getPreference(TypedPreferenceKey)}.
 * 
 * To introduce new keys, subclass this class.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 * @see TypedPreferenceValues
 */
public class FormatterPreferenceKeys {

	/**
	 * The characters used to wrap lines. Usually "\n" or "\r\n".
	 */
	public static StringKey lineSeparator = new StringKey("line.separator", getProperty("line.separator"));

	/**
	 * The characters used for one level of indentation. Usually "\t" or four spaces.
	 */
	public static StringKey indentation = new StringKey("indentation", "\t");

	/**
	 * The width of one level of indentation counted in characters. If {@link #indentation} is "\t" and the
	 * display-width of one tab is fours, then this values should be four. The formatter uses this value to compute when
	 * {@link #maxLineWidth} has been exceeded.
	 */
	public static IntegerKey indentationLength = new IntegerKey("indentation.length", 4);

	/**
	 * The maximum of characters that may fit into one line.
	 * 
	 * @see IFormattableSubDocument#requireFitsInLine()
	 * @see IHiddenRegionFormatter#autowrap()
	 */
	public static IntegerKey maxLineWidth = new IntegerKey("line.width.max", 120);
}
