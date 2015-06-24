/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.extensions

import com.intellij.openapi.extensions.ExtensionPointName
import com.intellij.util.xmlb.annotations.Attribute
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * @author kosyakov - Initial contribution and API
 */
class ResourceFactoryEP extends AbstractExecutableExtensionPoint {

	public static val EP_NAME = ExtensionPointName.<ResourceFactoryEP>create(
		'org.eclipse.xtext.idea.resourceFactory'
	)

	@Attribute("type")
	@Accessors(PUBLIC_GETTER)
	String type

	def createDescriptor() {
		new ResourceFactoryDescriptor(this)
	}

}

@FinalFieldsConstructor
class ResourceFactoryDescriptor implements Resource.Factory.Descriptor {

	val AbstractExecutableExtensionPoint extensionPoint

	Resource.Factory factory

	override createFactory() {
		if (factory == null)
			factory = extensionPoint.createInstance as Resource.Factory
		return factory
	}

}