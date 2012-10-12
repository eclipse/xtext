/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting

import java.util.List
import org.eclipse.xtend.core.formatting.XtendFormatterConfig
import static org.eclipse.xtend.ide.formatting.SettingsData$WidgetType.*
import org.eclipse.xtend.core.formatting.NewLineConfig
import org.eclipse.xtend.ide.formatting.preferences.Messages

class FormatterPreferenceInfra {
	public static String PREFIX = "org.eclipse.xtend.formatter";

	def static createNumberSetting(SettingsData$Category category, String name, String label) {
		return new FormatterSetting(category, name, label, NUMBER_FIELD, null)
	}

	def static createSetting(SettingsData$Category category, SettingsData$WidgetType type, String name,
		List<String> values) {
		val label = Messages::bind(name, null)
		return new FormatterSetting(category, name, label, type, values)
	}

	def static Iterable<FormatterSetting> settingsByCategory(SettingsData$Category category, XtendFormatterConfig config) {
		return settings(config).filter([ it.category == category ])
	}

	def static settings(XtendFormatterConfig config) {
		val List<FormatterSetting> settings = newArrayList()
		for (entry : config.namedProperties.entrySet) {
			val key = entry.key
			val category = key.split("\\.").head
			var catEnum = SettingsData$Category::byName(category)
			switch (entry.value.type) {
				case typeof(int):
					settings.add(
						createSetting(catEnum, SettingsData$WidgetType::NUMBER_FIELD, key,
							newArrayList(entry.value.name)))
				case typeof(NewLineConfig):
					settings.add(
						createSetting(catEnum, SettingsData$WidgetType::MIN_MAX_FIELDS, key,
							newArrayList(entry.value.name)))
			}
		}
		return settings
	}

	def static previewText(SettingsData$Category category) {
		switch (category) {
			case SettingsData$Category::INDENTATION: '''
			class BugTester {
			def myDef(){
			println("Works fine")
			}
			}'''
			case SettingsData$Category::LINE_WRAPPING: '''
			package test

			import java.io.FileReader
			import java.util.List
			
			class XtendClass {
			
				def testy() {
				}
			
				def readMovies() {
					val movies = new FileReader('data.csv').readLines.map[
						line |line.toFirstUpper.toFirstLower.toFirstLower.toFirstUpper]
					return movies
				}
			
				def List<String> readLines(FileReader fr) {
					return newArrayList("")
				}
			}
'''
		default: '''
			class Movies {
			def settings(XtendFormatterConfig config) {
			val List<FormatterSetting> settings = newArrayList()
			for (entry : config.namedProperties.entrySet) {
			val key = entry.key
			val category = key.split(".").head
			var catEnum = SettingsData$Category::byName(category)
			if (catEnum == null)
			catEnum = SettingsData$Category::OTHER
			settings.add(
			createSetting(catEnum, SettingsData$WidgetType::NUMBER_FIELD, key, key.toFirstUpper,
			newArrayList(entry.value.name)))
			}
			return settings
			}
			}
			'''
		}
	}
}
