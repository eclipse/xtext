/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.daemon

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.builder.standalone.incremental.IJavaDependencyFinder
import org.eclipse.xtext.idea.build.net.Protocol.JavaDependencyRequest
import org.eclipse.xtext.idea.build.net.Protocol.JavaDependencyResult

import static extension org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class BuildDaemonJavaDependencyFinder implements IJavaDependencyFinder {
	
	@Inject extension IBuildSessionSingletons
	
	override getDependentJavaFiles(Iterable<URI> javaFiles) {
		val request = new JavaDependencyRequest => [
			it.javaFiles += javaFiles.map[toString]
		]
		objectChannel.writeObject(request)
		val response = objectChannel.readObject()
		if(response instanceof JavaDependencyResult) {
			return response.dependentJavaFiles.map[asURI]
		} else {
			throw new RuntimeException("Invalid answer from builder process. Expected JavaDependencyResult but got " + response?.class?.toString)
		}
	}
}