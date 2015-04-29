/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import org.eclipse.emf.common.util.URI
import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import com.google.inject.Singleton

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
class Source2GeneratedMapping {
	
	val Multimap<URI, URI> source2generated = HashMultimap.create  
	val Multimap<URI, URI> generated2source = HashMultimap.create  
	
	def void addSource2Generated(URI source, URI generated) {
		source2generated.put(source, generated)
		generated2source.put(generated, source)
	}
	
	def void removeSource2Generated(URI source, URI generated) {
		source2generated.remove(source, generated)
		generated2source.remove(generated, source)
	}
	
	def void deleteSource(URI source) {
		source2generated.removeAll(source).forEach[
			generated2source.remove(source, it)
		]
	}

	def void deleteGenerated(URI generated) {
		generated2source.removeAll(generated).forEach[
			source2generated.remove(it, generated)
		]
	}
	
	def Iterable<URI> getGenerated(URI source) {
		source2generated.get(source)
	}

	def Iterable<URI> getSource(URI generated) {
		generated2source.get(generated)
	}
}