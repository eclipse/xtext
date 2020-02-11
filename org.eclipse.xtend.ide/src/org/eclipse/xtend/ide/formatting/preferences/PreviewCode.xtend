/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences

class PreviewCode {

	def static String lineWrappingPreviewText() {
		'''
			package test

			import java.io.FileReader
			import java.util.List
			
			class XtendClass {
				def readMovies() {
					val movies = new FileReader('data.csv').readLines.map[
						line |line.toFirstUpper.toFirstLower.toFirstLower.toFirstUpper]
					return movies
				}
			
				def List<String> readLines(FileReader fr) {
					return newArrayList("")
				}
			}
		'''.toString
	}

	def static String defaultPreviewText() {
		'''
			class Movies {
			def settings(XtendFormatterConfig config) {
			val List<FormatterSetting> settings = newArrayList()
			for (entry : config.namedProperties.entrySet) {
			val key = entry.key
			val category = key.split(".").head
			var catEnum = Category::byName(category)
			if (catEnum == null)
			catEnum = Category::OTHER
			settings.add(
			createSetting(catEnum, SettingsData$WidgetType::NUMBER_FIELD, key, key.toFirstUpper,
			newArrayList(entry.value.name)))
			}
			return settings
			}
			}
		'''.toString
	}
	
	def static String newLinePreviewText() {
	'''
		package test
		import java.io.FileReader
		import java.util.List
		@Data class PersonClass {
			@Property String name
			@Property String vorname
		}
	'''
	}
	
	def static String bracesPreviewText() {
		defaultPreviewText
	}
}
