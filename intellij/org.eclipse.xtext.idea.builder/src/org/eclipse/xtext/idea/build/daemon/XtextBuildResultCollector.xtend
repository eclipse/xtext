/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.daemon

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.builder.standalone.incremental.IncrementalStandaloneBuilder.FileListener
import org.eclipse.xtext.idea.build.net.Protocol.BuildResultMessage
import org.eclipse.xtext.idea.build.net.Protocol.GeneratedFile

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtextBuildResultCollector implements FileListener {
	
	Multimap<URI, URI> generatedFile2sourceURI = HashMultimap.create 

	Set<URI> outputDirs = newHashSet
	
	Set<URI> deletedFiles = newHashSet
	
	def getBuildResult() {
		new BuildResultMessage => [
			it.deletedFiles += deletedFiles.toString
			it.outputDirs += outputDirs.toString
			it.generatedFiles += generatedFile2sourceURI.keySet.map[ generated |
				new GeneratedFile => [
					file = generated.toString
					sourceFiles += generatedFile2sourceURI.get(generated).map[toString]
				]
			]						
		]
	}
	
	override outputFolderUsed(URI outputFolder) {
		outputDirs += outputFolder
	}
	
	override fileGenerated(URI source, URI target) {
		generatedFile2sourceURI.put(target, source)
	}
	
	override fileDeleted(URI file) {
		deletedFiles.add(file)
	}
}