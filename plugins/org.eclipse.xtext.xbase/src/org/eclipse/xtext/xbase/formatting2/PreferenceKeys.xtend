package org.eclipse.xtext.xbase.formatting2

import org.eclipse.xtext.preferences.BooleanKey
import org.eclipse.xtext.preferences.IntegerKey

import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting

class BlankLineKey extends IntegerKey implements Procedures.Procedure1<IHiddenRegionFormatting> {
	new(String name, Integer defaultValue) {
		super(name, defaultValue)
	}

	override apply(IHiddenRegionFormatting it) {
		val preferences = request.preferences
		val blankline = preferences.getPreference(this)
		val preserve = preferences.getPreference(preserveBlankLines)
		val min = blankline + 1
		val max = Math.max(preserve + 1, min)
		setNewLines(min, min, max)
	}

}

class NewLineOrPreserveKey extends BooleanKey implements Procedures.Procedure1<IHiddenRegionFormatting> {
	new(String name, Boolean defaultValue) {
		super(name, defaultValue)
	}

	override apply(IHiddenRegionFormatting it) {
		val preferences = request.preferences
		val newLine = preferences.getPreference(this)
		val preserve = preferences.getPreference(preserveNewLines)
		val min = if(newLine) 1 else 0
		val max = if(preserve || newLine) 1 else 0
		setNewLines(min, min, max)
	}

}

class NewLineKey extends BooleanKey implements Procedures.Procedure1<IHiddenRegionFormatting> {
	new(String name, Boolean defaultValue) {
		super(name, defaultValue)
	}

	override apply(IHiddenRegionFormatting it) {
		val newLine = request.preferences.getPreference(this)
		if (newLine)
			setNewLines(1)
		else
			oneSpace
	}

}

class WhitespaceKey extends BooleanKey implements Procedures.Procedure1<IHiddenRegionFormatting> {
	new(String name, Boolean defaultValue) {
		super(name, defaultValue)
	}

	override apply(IHiddenRegionFormatting it) {
		val space = request.preferences.getPreference(this)
		setSpace(if(space) " " else "")
	}

}
