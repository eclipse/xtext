/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.javaconverter

import java.net.URLClassLoader
import org.eclipse.jdt.core.dom.ASTParser
import org.eclipse.xtend.core.javaconverter.JavaConverter

/**
 * @author dhuebner - Initial contribution and API
 */
class IdeaJavaConverter extends JavaConverter {

	override protected provideCustomEnvironment(ASTParser parser) {
		val sysClassLoader = ClassLoader.getSystemClassLoader();
		val cpEntries = (sysClassLoader as URLClassLoader).getURLs().map[file]
		println(cpEntries.join('''|
		'''))
		parser.setEnvironment(null, null, null, false)
	}

}