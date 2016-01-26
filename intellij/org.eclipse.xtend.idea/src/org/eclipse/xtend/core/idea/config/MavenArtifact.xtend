/** 
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.config

import org.eclipse.xtend.lib.annotations.Data

/** 
 * @author dhuebner - Initial contribution and API
 */
 @Data
class MavenArtifact {
	String groupId
	String artifactId
	String version
	
	def getKey() {
		return '''«groupId»:«artifactId»:«version»'''
	}
	override toString() {
		return key
	}
}
