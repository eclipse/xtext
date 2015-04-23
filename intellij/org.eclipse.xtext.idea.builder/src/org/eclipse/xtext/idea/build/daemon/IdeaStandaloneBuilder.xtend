/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.daemon

//import java.io.File
//import org.apache.log4j.Logger

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.builder.standalone.LanguageAccess
import org.eclipse.xtext.builder.standalone.incremental.IncrementalStandaloneBuilder
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class IdeaStandaloneBuilder extends IncrementalStandaloneBuilder {

	XtextBuildResultCollector buildResultCollector

	def setBuildResultCollector(XtextBuildResultCollector buildResultCollector) {
		this.buildResultCollector = buildResultCollector;
		(issueHandler as IdeaIssueHandler).buildResultCollector = buildResultCollector
	}
	
	override protected configureFileSystemAccess(JavaIoFileSystemAccess fsa, LanguageAccess language) {
		if(fsa instanceof BuildDaemonFileSystemAccess) 
			fsa.buildResultCollector = buildResultCollector
		fsa
	}
	
	override protected beforeGenerate(Resource resource, IFileSystemAccess fileSystemAccess) {
		buildResultCollector.currentResource = resource
	}
}