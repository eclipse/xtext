/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.internal;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelInferrerRegistry;
import org.osgi.framework.BundleContext;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Activator extends Plugin {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		initializeJavaTranslationParticipantRegistry(context);
	}

	protected void initializeJavaTranslationParticipantRegistry(BundleContext context) {
		IExtensionRegistry eReg = Platform.getExtensionRegistry();
		String symbolicName = context.getBundle().getSymbolicName();
		
		new RegistryReader(eReg, symbolicName, "java_translation_participant") {
			
			@Override
			protected boolean readElement(IConfigurationElement element, boolean add) {
				if (element.getName().equals("resourceServiceProvider")) {
					String fileExtension = element.getAttribute("fileExtension");
					if (fileExtension == null) {
						logMissingAttribute(element, "fileExtension");
					} else if (element.getAttribute("class") == null) {
						logMissingAttribute(element, "class");
					} else if (add) {
						JvmModelInferrerRegistry.INSTANCE.register(fileExtension, new JvmModelInferrerDescriptor(element));
						return true;
					} else {
						return true;
					}
				}
				return false;
			}
		}.readRegistry();
	}

}
