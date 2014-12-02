/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.ng

import java.util.List
import org.eclipse.xtext.builder.ng.debug.XtextCompilerConsole
import org.eclipse.xtext.resource.IResourceDescription

/**
 * @author koehnlein - Initial contribution and API
 */
class XtextCompiler {
	
	def List<IResourceDescription.Delta> compile(CompilationRequest compilationRequest) {
		XtextCompilerConsole.log(compilationRequest)		
		emptyList
	}	
	
}