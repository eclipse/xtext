/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource.impl

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.impl.AbstractResourceDescription

@FinalFieldsConstructor
class PsiFileBasedResourceDescription extends AbstractResourceDescription implements IResourceDescription {

	@Accessors
	val BaseXtextFile xtextFile
	
	override protected computeExportedObjects() {
		xtextFile.exportedObjects
	}
	
	override getImportedNames() {
		emptyList
	}
	
	override getReferenceDescriptions() {
		emptyList
	}
	
	override getURI() {
		xtextFile.URI
	}
	
	override toString() {
		class.name + ':' + xtextFile.toString
	}

}
