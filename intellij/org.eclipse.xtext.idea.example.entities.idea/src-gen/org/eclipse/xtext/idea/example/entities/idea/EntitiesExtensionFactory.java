/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.example.entities.idea;

import com.intellij.openapi.extensions.ExtensionFactory;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;

public class EntitiesExtensionFactory implements ExtensionFactory {
	@Override
	public Object createInstance(String factoryArgument, String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return EntitiesLanguage.INSTANCE.<Object> getInstance(clazz);
	}
}
