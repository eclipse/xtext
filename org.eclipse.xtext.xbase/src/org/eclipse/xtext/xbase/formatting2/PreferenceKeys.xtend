/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting2

import org.eclipse.xtext.formatting2.IHiddenRegionFormatter
import org.eclipse.xtext.preferences.BooleanKey
import org.eclipse.xtext.preferences.IntegerKey

import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class BlankLineKey extends IntegerKey implements Procedures.Procedure1<IHiddenRegionFormatter> {
	new(String name, Integer defaultValue) {
		super(name, defaultValue)
	}

	override apply(IHiddenRegionFormatter it) {
		val preferences = request.preferences
		val blankline = preferences.getPreference(this)
		val preserve = preferences.getPreference(preserveBlankLines)
		val min = blankline + 1
		val max = Math.max(preserve + 1, min)
		setNewLines(min, min, max)
	}

}

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class NewLineOrPreserveKey extends BooleanKey implements Procedures.Procedure1<IHiddenRegionFormatter> {
	new(String name, Boolean defaultValue) {
		super(name, defaultValue)
	}

	override apply(IHiddenRegionFormatter it) {
		val preferences = request.preferences
		val newLine = preferences.getPreference(this)
		val preserve = preferences.getPreference(preserveNewLines)
		val min = if(newLine) 1 else 0
		val max = if(preserve || newLine) 1 else 0
		setNewLines(min, min, max)
		setSpace(" ")
	}

}

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class NewLineKey extends BooleanKey implements Procedures.Procedure1<IHiddenRegionFormatter> {
	new(String name, Boolean defaultValue) {
		super(name, defaultValue)
	}

	override apply(IHiddenRegionFormatter it) {
		val newLine = request.preferences.getPreference(this)
		if (newLine)
			setNewLines(1)
		else
			oneSpace
	}

}

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class WhitespaceKey extends BooleanKey implements Procedures.Procedure1<IHiddenRegionFormatter> {
	new(String name, Boolean defaultValue) {
		super(name, defaultValue)
	}

	override apply(IHiddenRegionFormatter it) {
		val space = request.preferences.getPreference(this)
		setSpace(if(space) " " else "")
	}

}
