/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.daemon

import java.io.File
import org.apache.log4j.Logger
import org.eclipse.xtext.builder.standalone.LanguageAccess
import org.eclipse.xtext.builder.standalone.StandaloneBuilder
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class IdeaStandaloneBuilder extends StandaloneBuilder {

	// TODO find the right way to log
	static val LOG = Logger.getLogger(IdeaStandaloneBuilder)

	XtextBuildParameters buildParameters
	XtextBuildResultCollector buildResultCollector

	def setBuildData(XtextBuildParameters buildParameters) {
		this.buildParameters = buildParameters
		this.baseDir = buildParameters.baseDir.path
		this.classPathEntries = buildParameters.classpath.map[path]
		this.encoding = buildParameters.encoding
		this.tempDir = getOrCreateTmpDir.path
		this.sourceDirs = buildParameters.sourceRoots.map[path]
	}
	
	def setBuildResultCollector(XtextBuildResultCollector buildResultCollector) {
		this.buildResultCollector = buildResultCollector;
		(issueHandler as IdeaIssueHandler).buildResultCollector = buildResultCollector
	}
	
	override protected configureFileSystemAccess(JavaIoFileSystemAccess fsa, LanguageAccess language) {
		if(fsa instanceof BuildDaemonFileSystemAccess) {
			fsa.buildResultCollector = buildResultCollector
		}
		fsa
	}
	
	private def getOrCreateTmpDir() {
		val contentRoot = baseDir
		val tmpDir = new File(contentRoot, 'xtend-stubs')
		if(!tmpDir.exists) 
			tmpDir.mkdir
		else if(!tmpDir.isDirectory)
			LOG.error('Compilation tmpDir ' + tmpDir + ' exists and is a file')
		return tmpDir
	}
}