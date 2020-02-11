/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import static java.lang.System.*;

import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.IntegerKey;
import org.eclipse.xtext.preferences.PreferenceKeysProvider;
import org.eclipse.xtext.preferences.StringKey;
import org.eclipse.xtext.preferences.TypedPreferenceKey;
import org.eclipse.xtext.preferences.TypedPreferenceValues;

/**
 * <p>
 * General preference keys used by this formatting infrastructure. Formatters based on this infrastructure should honor these keys as well.
 * </p>
 * 
 * <p>
 * To set a values for one of these keys, use {@link FormatterRequest#setPreferences(ITypedPreferenceValues)}.
 * </p>
 * 
 * <p>
 * To access a value for one of these keys, use {@link AbstractFormatter2#getPreference(TypedPreferenceKey)}.
 * </p>
 * 
 * <p>
 * To introduce new keys, subclass this class (see also {@link PreferenceKeysProvider#allConstantKeys(Class...)}.
 * </p>
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 * @see TypedPreferenceValues
 */
public class FormatterPreferenceKeys {

	/**
	 * The characters used to wrap lines. Usually {@code \n} or {@code \r\n}.
	 */
	public static StringKey lineSeparator = new StringKey("line.separator", getProperty("line.separator"));

	/**
	 * The characters used for one level of indentation. Usually "\t" or four spaces.
	 */
	public static StringKey indentation = new StringKey("indentation", "\t");

	/**
	 * @deprecated use {@link #tabWidth}
	 */
	@Deprecated
	public static IntegerKey indentationLength = new IntegerKey("indentation.length", -1);

	/**
	 * The display-width of one tab character.
	 * 
	 * If {@link #indentation} is {@code \t} and the display-width of one tab is fours, then this values should be four. The formatter uses
	 * this value to compute when {@link #maxLineWidth} has been exceeded.
	 */
	public static IntegerKey tabWidth = new IntegerKey("tab.width", 4);

	/**
	 * The maximum of characters that may fit into one line.
	 * 
	 * @see IFormattableSubDocument#requireFitsInLine()
	 * @see IHiddenRegionFormatter#autowrap()
	 */
	public static IntegerKey maxLineWidth = new IntegerKey("line.width.max", 120);
}
