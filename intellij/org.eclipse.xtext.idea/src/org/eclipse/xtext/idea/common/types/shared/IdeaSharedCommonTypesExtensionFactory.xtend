/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.common.types.shared

import com.intellij.openapi.extensions.ExtensionFactory

/**
 * @author kosyakov - Initial contribution and API
 */
class IdeaSharedCommonTypesExtensionFactory implements ExtensionFactory {

	override createInstance(String factoryArgument, String implementationClass) {
		val clazz = Class.forName(implementationClass)
		IdeaSharedCommonTypesLanguage.INSTANCE.getInstance(clazz)
	}

}