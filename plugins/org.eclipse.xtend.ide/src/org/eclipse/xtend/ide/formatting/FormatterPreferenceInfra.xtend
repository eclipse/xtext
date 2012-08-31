/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting

import java.util.List
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants
import static org.eclipse.xtend.ide.formatting.SettingsData$Category.*
import static org.eclipse.xtend.ide.formatting.SettingsData$WidgetType.*
import java.util.Map
import org.eclipse.xtend.core.formatting.RendererConfiguration

class FormatterPreferenceInfra {
	public static String PREFIX = "org.eclipse.xtend.formatter";
	public static String MAX_LINE_WIDTH = PREFIX + ".max_line_width";
	public static String TAB_POLICY = PREFIX + ".tab_policy";
	public static String INDENTATION_SIZE = PREFIX + ".indentation_size";
	static List<FormatterSetting> settings = newArrayList(
		createNumberSetting(LINE_WRAPPING, MAX_LINE_WIDTH, "Maximum line width"),
		createSetting(INDENTATION, COMBO_BOX, TAB_POLICY, "Tab policy", newArrayList(JavaCore::SPACE, JavaCore::TAB, DefaultCodeFormatterConstants::MIXED)),
		createNumberSetting(INDENTATION, INDENTATION_SIZE, "Tab size")
	)

	def static createNumberSetting(SettingsData$Category category,String name,String label) {
		return new FormatterSetting(category, name, label, NUMBER_FIELD, null)
	}

	def static createSetting(SettingsData$Category category,SettingsData$WidgetType type, String name,String label,List<String> values) {
		return new FormatterSetting(category, name, label, type, values)
	}

	def static createRendererConfiguration(Map<String,String> map){
		val rendererConfiguration = new RendererConfiguration();
		try {
			rendererConfiguration.setIndentationLength(Integer::parseInt(map
								.get(INDENTATION_SIZE)));
			//rendererConfiguration.setIndentation(map
			//					.get(MAX_LINE_WIDTH));
			rendererConfiguration.setMaxLineWidth(Integer::parseInt(map
								.get(MAX_LINE_WIDTH)));
		} catch (NumberFormatException nfe) {}
		return rendererConfiguration;
	}

	def  Iterable<FormatterSetting> settingsByCategory(SettingsData$Category category) {
		return settings.filter([ it.category == category ])
	}

	def  previewText(SettingsData$Category category) {
		switch (category) {
			case SettingsData$Category::INDENTATION: '''
		class BugTester {
		def myDef(){
		println("Works fine")
		}
		}'''
			case SettingsData$Category::LINE_WRAPPING: '''
		class Movies {
		  val movies = new FileReader('data.csv').readLines.map [ line |  val segments = line.split('  ').iterator
		  return new Movie(segments.next, Integer::parseInt(segments.next), Double::parseDouble(segments.next), Long::parseLong(segments.next),  segments.toSet)]
		}'''
		}
	}
}
