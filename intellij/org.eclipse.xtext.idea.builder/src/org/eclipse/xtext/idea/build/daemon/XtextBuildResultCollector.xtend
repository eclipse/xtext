/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.daemon

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.build.net.ObjectChannel
import org.eclipse.xtext.idea.build.net.Protocol.BuildIssueMessage
import org.eclipse.xtext.idea.build.net.Protocol.BuildResultMessage

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtextBuildResultCollector {
	
	@Accessors(PUBLIC_GETTER)
	BuildResultMessage buildResult = new BuildResultMessage
	
	@Accessors
	ObjectChannel output
	
	def addIssue(BuildIssueMessage issue) {
		output.writeObject(issue)
	}
	
	def addChangedFile(String path) {
		buildResult.dirtyFiles += path
	} 
	
	def addOutputDir(String outputDir) {
		if(!buildResult.outputDirs.contains(outputDir)) {
			buildResult.outputDirs.add(outputDir)
		} 
	}

	def addDeletedFile(String path) {
		buildResult.deletedFiles += path
	}
}