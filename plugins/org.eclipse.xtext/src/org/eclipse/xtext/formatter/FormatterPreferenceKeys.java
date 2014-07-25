/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatter;

import static java.lang.System.*;

import org.eclipse.xtext.preferences.IntegerKey;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.preferences.TypedPreferenceValues;

/**
 * These are keys for preferences that are used by every formatter implemented with this framework.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.7
 * @see TypedPreferenceValues
 */
public class FormatterPreferenceKeys {
	public static PreferenceKey lineSeparator = new PreferenceKey("line.separator", getProperty("line.separator"));
	public static PreferenceKey indentation = new PreferenceKey("indentation", "\t");
	public static IntegerKey indentationLength = new IntegerKey("indentation.length", 4);
	public static IntegerKey maxLineWidth = new IntegerKey("line.width.max", 120);
}
