/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.daemon

import java.io.File
import java.util.List
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.idea.build.daemon.Protocol.BuildRequest

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Data
class XtextBuildParameters {

	List<File> classpath
	List<File> sourceRoots
	File baseDir
	String encoding

	new(BuildRequest request) {
		classpath =  request.classpath.map[toFile]
		sourceRoots = request.sourceRoots.map[toFile]
		baseDir = request.baseDir.toFile
		encoding = request.encoding
	}
	
	protected def toFile(String it) {
		new File(it)
	}
}