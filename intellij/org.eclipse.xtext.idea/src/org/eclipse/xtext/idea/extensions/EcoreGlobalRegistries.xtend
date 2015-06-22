/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.extensions

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.extensions.Extensions
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.IResourceServiceProvider

/**
 * @author kosyakov - Initial contribution and API
 */
class EcoreGlobalRegistries {

	new() {
		val packageRegistry = EPackage.Registry.INSTANCE
		Extensions.getExtensions(EPackageEP.EP_NAME).forEach [
			packageRegistry.put(nsURI, createDescriptor)
		]

		val extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.extensionToFactoryMap
		Extensions.getExtensions(ResourceFactoryEP.EP_NAME).forEach [
			extensionToFactoryMap.put(type, createDescriptor)
		]

		val registry = IResourceServiceProvider.Registry.INSTANCE
		Extensions.getExtensions(ResourceServiceProviderEP.EP_NAME).forEach [
			if (uriExtension != null)
				registry.extensionToFactoryMap.put(uriExtension, createDescriptor)
			if (protocolName != null)
				registry.protocolToFactoryMap.put(protocolName, createDescriptor)
			if (contentTypeIdentifier != null)
				registry.contentTypeToFactoryMap.put(contentTypeIdentifier, createDescriptor)
		]
	}

	static def ensureInitialized() {
		ApplicationManager.application.getComponent(EcoreGlobalRegistries)
	}

}