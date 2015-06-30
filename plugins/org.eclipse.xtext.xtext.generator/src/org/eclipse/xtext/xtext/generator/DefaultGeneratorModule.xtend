/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Binder
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.parser.EclipseProjectPropertiesEncodingProvider
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.service.AbstractGenericModule

class DefaultGeneratorModule extends AbstractGenericModule {
	
	def configureResourceSet(Binder binder) {
		binder.bind(ResourceSet).toInstance(new XtextResourceSet)
	}
	
	def Class<? extends IEncodingProvider> bindIEncodingProvider() {
		EclipseProjectPropertiesEncodingProvider
	}
	
}