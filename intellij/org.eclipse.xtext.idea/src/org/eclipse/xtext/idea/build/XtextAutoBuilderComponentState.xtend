/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build

import com.intellij.util.Base64
import com.intellij.util.xmlb.annotations.Tag
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.Map
import org.eclipse.xtext.build.Source2GeneratedMapping
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.jdom.Element
import org.jdom.Text
import org.eclipse.xtext.resource.IResourceServiceProvider

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtextAutoBuilderComponentState {

	@Tag Element installedLanguages

	@Tag Element index
	
	@Tag Element module2generated

	protected new() {}

	protected new(Element installedLanguages, Element index, Element module2generated) {
		this.installedLanguages = installedLanguages
		this.index = index
		this.module2generated = module2generated			
	}

	static class Codec {
		
		val SEP = ';'
		
		def encode(IResourceServiceProvider.Registry registry, ChunkedResourceDescriptions index, Map<String, Source2GeneratedMapping> module2GeneratedMapping) {
			val installedLanguages = new Element('installedLanguages').addContent(registry.extensionToFactoryMap.keySet.toList.sort.join(SEP))
			val indexData = index.toXml('xtextIndex')
			val module2generatedData = module2GeneratedMapping.toXml('module2generated')
			return new XtextAutoBuilderComponentState(installedLanguages, indexData, module2generatedData)
		}
		 
		protected def toXml(Object object, String name) {
			val baos = new ByteArrayOutputStream
			val oos = new ObjectOutputStream(baos)
			try {
				oos.writeObject(object)
				oos.flush
				val bytes = baos.toByteArray
				val encoded = Base64.encode(bytes)
				return new Element(name) => [
					addContent(new Text(encoded))
				]
			} finally {
				oos.close
			}
		} 

		def decodeInstalledLanguages(XtextAutoBuilderComponentState state) {
			if (state.installedLanguages===null)
				return null;
			return state.installedLanguages.text.split(SEP).toSet
		}
		
		def decodeIndex(XtextAutoBuilderComponentState state) {
			state.index.toObject as ChunkedResourceDescriptions
		}

		def Map<String, Source2GeneratedMapping> decodeModuleToGenerated(XtextAutoBuilderComponentState state) {
			state.module2generated.toObject as Map<String, Source2GeneratedMapping>
		}
		
		protected def toObject(Element element) {
			val content = element.content.filter(Text).head?.text
			val bytes = Base64.decode(content)
			val bais = new ByteArrayInputStream(bytes)
			val ois = new ObjectInputStream(bais)
			try {
				return ois.readObject
			} finally {
				ois.close
			}	
		} 
	}
}