/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.extensions

import com.intellij.openapi.extensions.AbstractExtensionPointBean
import com.intellij.openapi.extensions.ExtensionPointName
import com.intellij.util.xmlb.annotations.Attribute
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author kosyakov - Initial contribution and API
 */
class EPackageEP extends AbstractExtensionPointBean implements EPackage.Descriptor {

	public static val EP_NAME = ExtensionPointName.<EPackageEP>create(
		'org.eclipse.xtext.idea.package'
	)

	@Attribute("uri")
	@Accessors(PUBLIC_GETTER)
	String nsURI

	@Attribute("class")
	String packageClass

	def createDescriptor() {
		this
	}

	override getEFactory() {
		null
	}

	override getEPackage() {
		packageClass.findClass.getField('eINSTANCE').get(null) as EPackage
	}

}