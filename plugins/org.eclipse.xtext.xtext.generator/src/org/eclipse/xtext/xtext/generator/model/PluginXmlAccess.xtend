/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtend2.lib.StringConcatenationClient

@Log
@Accessors
class PluginXmlAccess extends TextFileAccess {
	
	new() {
		this.path = 'plugin.xml'
	}
	
	val List<CharSequence> entries = newArrayList
	
	override setContent(StringConcatenationClient content) {
		throw new UnsupportedOperationException("cannot directly set contents on a plugin.xml. Use entries property instead");
	}
	
	override getContent() '''
		<?xml version="1.0" encoding="UTF-8"?>
		<?eclipse version="3.0"?>
		
		<plugin>
			«FOR entry : entries»
				«entry»
			«ENDFOR»
		</plugin>
	'''
	
	/**
	 * Merge the contents of the given plugin.xml into this one.
	 */
	def merge(PluginXmlAccess other) {
		if (this.path != other.path) {
			LOG.warn('Merging plugin.xml files with different paths: ' + this.path + ', ' + other.path)
		}
		this.entries.addAll(other.entries)
	}
	
}