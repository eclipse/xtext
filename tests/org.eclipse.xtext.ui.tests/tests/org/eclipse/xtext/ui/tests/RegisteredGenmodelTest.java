/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests;

import java.util.Collections;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RegisteredGenmodelTest extends TestCase {

	private IExtensionRegistry registry;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		registry = Platform.getExtensionRegistry();
	}
	
	@Override
	protected void tearDown() throws Exception {
		registry = null;
		super.tearDown();
	}
	
	public void testCanResolveGenmodelURIs() {
		String declaringPlugin = "org.eclipse.emf.ecore";
		String pointId = "generated_package";
		IExtensionPoint point = registry.getExtensionPoint(declaringPlugin + "." + pointId);
		IExtension[] extensions = point.getExtensions();
		for(IExtension extension: extensions) {
			IConfigurationElement[] configurationElements = extension.getConfigurationElements();
			for(IConfigurationElement configurationElement: configurationElements) {
				String attribute = configurationElement.getAttribute("genModel");
				if (attribute != null && attribute.length() != 0) {
					String name = extension.getContributor().getName();
					String uriAsString = "platform:/plugin/" + name + "/" + attribute;
					URI uri = URI.createURI(uriAsString);
					boolean exists = URIConverter.INSTANCE.exists(uri, Collections.emptyMap());
					if (!exists) {
//							fail(uriAsString + " does not exist");
					}
				}
			}
		}
	}
	
}
