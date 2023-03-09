/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.resourceFactory

import com.google.inject.Inject
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.resource.IResourceFactory
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment

/**
 * Contributes the registration <code>org.eclipse.emf.ecore.extension_parser</code>
 * to the Eclipse (UI) plugin's plugin.xml. See
 * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=264578">
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=264578</a> for details.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
class ResourceFactoryFragment2 extends AbstractXtextGeneratorFragment {
	
	@Inject
	extension XtextGeneratorNaming
	
	override generate() {
		
		language.runtimeGenSetup.registrations.add('''
			«IResourceFactory» resourceFactory = injector.getInstance(«IResourceFactory».class);
			«IResourceServiceProvider» serviceProvider = injector.getInstance(«IResourceServiceProvider».class);
			
			«FOR fileExtension : language.fileExtensions»
			«Resource».Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("«fileExtension»", resourceFactory);
			«IResourceServiceProvider».Registry.INSTANCE.getExtensionToFactoryMap().put("«fileExtension»", serviceProvider);
			«ENDFOR»
		''')

		if (projectConfig.eclipsePlugin?.pluginXml !== null) {
			projectConfig.eclipsePlugin.pluginXml.entries += '''
				<!-- adding resource factories -->
				«FOR fileExtension : language.fileExtensions»
					<extension
						point="org.eclipse.emf.ecore.extension_parser">
						<parser
							class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.resource.IResourceFactory"
							type="«fileExtension»">
						</parser>
					</extension>
					<extension point="org.eclipse.xtext.extension_resourceServiceProvider">
						<resourceServiceProvider
							class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.resource.IResourceUIServiceProvider"
							uriExtension="«fileExtension»">
						</resourceServiceProvider>
					</extension>
				«ENDFOR»
			'''
		}
	}
	
}
