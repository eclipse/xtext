/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.net

import java.io.Serializable
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.jetbrains.jps.incremental.messages.BuildMessage
import org.eclipse.xtend.lib.annotations.EqualsHashCode

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class Protocol {
	
	@Accessors
	@EqualsHashCode
	static class BuildRequestMessage implements Serializable {
		List<String> dirtyFiles	= newArrayList
		List<String> deletedFiles = newArrayList
		List<String> classpath = newArrayList
		List<String> sourceRoots = newArrayList
		String baseDir
		String encoding
	}
	
	@Accessors
	@EqualsHashCode
	static class BuildResultMessage implements Serializable {
		List<String> dirtyFiles = newArrayList		
		List<String> deletedFiles = newArrayList
		List<String> outputDirs = newArrayList
	}
	
	@Accessors
	@EqualsHashCode
	static class BuildIssueMessage implements Serializable {
		BuildMessage.Kind kind
		String message
		String path
		int startOffset
		int endOffset
		int locationOffset
		int line
		int column
	}
}