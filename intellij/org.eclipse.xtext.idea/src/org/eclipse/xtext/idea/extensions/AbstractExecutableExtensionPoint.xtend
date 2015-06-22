/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.extensions

import com.intellij.openapi.extensions.AbstractExtensionPointBean
import com.intellij.openapi.extensions.ExtensionFactory
import com.intellij.util.xmlb.annotations.Attribute

/**
 * @author kosyakov - Initial contribution and API
 */
abstract class AbstractExecutableExtensionPoint extends AbstractExtensionPointBean {

	@Attribute("factoryClass")
	String factoryClass

	@Attribute("class")
	String implementationClass

	def String getContributor() {
		pluginDescriptor?.pluginId?.toString
	}

	def createInstance() {
		if (implementationClass == null)
			throw 'Class is not specified'.asRuntimeException
		if (factoryClass == null)
			implementationClass.findClass.newInstance
		else
			factoryClass.<ExtensionFactory>findClass.newInstance.createInstance(null, implementationClass)
	}

	protected def asRuntimeException(CharSequence message) {
		new RuntimeException('''«message», plugin id: «contributor».''')
	}

} 