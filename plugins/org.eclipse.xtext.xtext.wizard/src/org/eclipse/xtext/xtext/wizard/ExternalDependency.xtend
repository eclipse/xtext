/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class ExternalDependency {
	static def createXtextDependency(String xtextBundle) {
		new ExternalDependency => [
			p2.bundleId = xtextBundle
			maven [
				groupId = "org.eclipse.xtext"
				artifactId = xtextBundle
				version = "${xtextVersion}"
			]
		]
	}
	
	static def createMavenDependency(String shortNotation) {
		new ExternalDependency => [
			maven.shortNotation = shortNotation
		]
	}
	
	static def createBundleDependency(String bundleId) {
		new ExternalDependency => [
			p2.bundleId = bundleId
		]
	}
	
	val maven = new MavenCoordinates
	val p2 = new P2Coordinates

	def maven((MavenCoordinates)=>void config) {
		config.apply(maven)
	}

	def p2((P2Coordinates)=>void config) {
		config.apply(p2)
	}
	
	@Accessors
	static class MavenCoordinates {
		String groupId
		String artifactId
		String version
		def setShortNotation(String shortNotation) {
			val parts = shortNotation.split(":")
			groupId = parts.get(0)
			artifactId = parts.get(1)
			version = parts.get(2)
		}
		Scope scope = Scope.COMPILE
	}

	@Accessors
	static class P2Coordinates {
		String bundleId
		String version
		Set<String> packages = newHashSet
	}
}