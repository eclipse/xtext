/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.util.CancelIndicator

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class ArithmeticsGenerator implements IGenerator2 {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, CancelIndicator cancelIndicator) {
	}
	
	override void beforeGenerate(Resource resource, IFileSystemAccess2 fsa, CancelIndicator cancelIndicator) {}
	
	override void afterGenerate(Resource resource, IFileSystemAccess2 fsa, CancelIndicator cancelIndicator) {}
}
