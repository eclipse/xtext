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
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.internal.AbstractResourceServiceProviderDescriptor

/**
 * @author kosyakov - Initial contribution and API
 */
class ResourceServiceProviderEP extends AbstractExecutableExtensionPoint {

	public static val EP_NAME = ExtensionPointName.<ResourceServiceProviderEP>create(
		'org.eclipse.xtext.idea.resourceServiceProvider'
	)

	@Attribute("uriExtension")
	@Accessors(PUBLIC_GETTER)
	String uriExtension

	@Attribute("protocolName")
	@Accessors(PUBLIC_GETTER)
	String protocolName

	@Attribute("contentTypeIdentifier")
	@Accessors(PUBLIC_GETTER)
	String contentTypeIdentifier

	def createDescriptor() {
		new ResourceServiceProviderDescriptor(this)
	}

}

@FinalFieldsConstructor
class ResourceServiceProviderDescriptor extends AbstractResourceServiceProviderDescriptor {

	val AbstractExecutableExtensionPoint extensionPoint

	Object myExtension

	override protected getContributor() {
		extensionPoint.contributor
	}

	override protected getExtension() {
		if (myExtension == null)
			myExtension = extensionPoint.createInstance
		return myExtension
	}

}

