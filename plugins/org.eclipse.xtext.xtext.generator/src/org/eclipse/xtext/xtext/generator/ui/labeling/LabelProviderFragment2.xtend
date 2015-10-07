/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.labeling

import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector

import static extension org.eclipse.xtext.GrammarUtil.*

/**
 * Contributes the Labeling provider stub, either in Xtend or Java language.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
class LabelProviderFragment2 extends AbstractGeneratorFragment2 {

	private static val XBASE_LABEL_PROVIDER = 
		"org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider"

	private static val XBASE_DESCRIPTION_LABEL_PROVIDER = 
		"org.eclipse.xtext.xbase.ui.labeling.XbaseDescriptionLabelProvider"

	@Inject
	extension XtextGeneratorNaming

	@Inject
	extension XbaseUsageDetector

	@Inject
	extension CodeConfig

	@Inject
	FileAccessFactory fileAccessFactory

	@Accessors
	private boolean generateStub = true;

	def protected TypeReference getEObjectLabelProviderClass(Grammar g) {
		return new TypeReference(
			g.eclipsePluginBasePackage + ".labeling." + g.simpleName + "LabelProvider"
		)
	}

	def protected TypeReference getEObjectLabelProviderSuperClass(Grammar g) {
		if (g.inheritsXbase)
			new TypeReference(XBASE_LABEL_PROVIDER) 
		else defaultEObjectLabelProviderSuperClass
	}

	/**
	 * Extra getter facilitates customization by overriding. 
	 */
	def protected TypeReference getDefaultEObjectLabelProviderSuperClass() {
		new TypeReference("org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider")
	}


	def protected TypeReference getDescriptionLabelProviderClass(Grammar g) {
		return new TypeReference(
			g.eclipsePluginBasePackage + ".labeling." + g.simpleName + "DescriptionLabelProvider"
		)
	}

	def protected TypeReference getDescriptionLabelProviderSuperClass(Grammar g) {
		if (g.inheritsXbase)
			new TypeReference(XBASE_DESCRIPTION_LABEL_PROVIDER) 
		else defaultDescriptionLabelProviderSuperClass
	}

	/**
	 * Extra getter facilitates customization by overriding. 
	 */
	def protected TypeReference getDefaultDescriptionLabelProviderSuperClass() {
		new TypeReference("org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider")
	}


	override generate() {
		if (!generateStub && !grammar.inheritsXbase) {
			// the binding of the DefaultEObjectLabelProvider and the 
			//  DefaultDescriptionLabelProvider is done in the DefaultUIModule, so ...
			return;
		}

		if (projectConfig.eclipsePluginManifest != null) {
			projectConfig.eclipsePluginManifest.requiredBundles += "org.eclipse.xtext.ui"
		}

		val labelProviderClass =
			if (generateStub) grammar.EObjectLabelProviderClass
			else new TypeReference(XBASE_LABEL_PROVIDER)

		val descriptionLabelProviderClass =
			if (generateStub) grammar.descriptionLabelProviderClass
			else new TypeReference(XBASE_DESCRIPTION_LABEL_PROVIDER)			 

		val iLabelProviderClass = new TypeReference("org.eclipse.jface.viewers.ILabelProvider")
		val rsdLabelProviderClass = 
				new TypeReference("org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider")

		new GuiceModuleAccess.BindingFactory()
				.addTypeToType(iLabelProviderClass, labelProviderClass)
				.addConfiguredBinding("ResourceUIServiceLabelProvider", '''
					binder.bind(«iLabelProviderClass».class).annotatedWith(«
						rsdLabelProviderClass».class).to(«descriptionLabelProviderClass».class);
				''').contributeTo(language.eclipsePluginGenModule)			

		if (!generateStub) {
			return;
		}

		if (projectConfig.eclipsePluginSrc !== null) {
			if (preferXtendStubs) {
				generateXtendEObjectLabelProvider
				generateXtendDescriptionLabelProvider
			} else {
				generateJavaEObjectLabelProvider
				generateJavaDescriptionLabelProvider
			}
		}
	}

	def protected generateXtendEObjectLabelProvider() {
		fileAccessFactory.createXtendFile(grammar.EObjectLabelProviderClass, '''
			/**
			 * Provides labels for EObjects.
			 * 
			 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
			 */
			class «grammar.EObjectLabelProviderClass.simpleName» extends «grammar.EObjectLabelProviderSuperClass» {
			
				@«Inject»
				new(«new TypeReference("org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider")» delegate) {
					super(delegate);
				}
			
				// Labels and icons can be computed like this:
				
			//	def text(Greeting ele) {
			//		'A greeting to ' + ele.name
			//	}
			//
			//	def image(Greeting ele) {
			//		'Greeting.gif'
			//	}
			}
		''').writeTo(projectConfig.eclipsePluginSrc)
	}

	def protected generateXtendDescriptionLabelProvider() {
		fileAccessFactory.createXtendFile(grammar.descriptionLabelProviderClass, '''
			/**
			 * Provides labels for IEObjectDescriptions and IResourceDescriptions.
			 * 
			 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
			 */
			class «grammar.descriptionLabelProviderClass.simpleName» extends «grammar.descriptionLabelProviderSuperClass» {
			
				// Labels and icons can be computed like this:
				
			//	override text(IEObjectDescription ele) {
			//		ele.name.toString
			//	}
			//	 
			//	override image(IEObjectDescription ele) {
			//		ele.EClass.name + '.gif'
			//	}
			}
		''').writeTo(projectConfig.eclipsePluginSrc)
	}

	def protected generateJavaEObjectLabelProvider() {
		fileAccessFactory.createJavaFile(grammar.EObjectLabelProviderClass, '''
			/**
			 * Provides labels for EObjects.
			 * 
			 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
			 */
			public class «grammar.EObjectLabelProviderClass.simpleName» extends «grammar.EObjectLabelProviderSuperClass» {
			
				@«Inject»
				public «grammar.EObjectLabelProviderClass.simpleName»(«
						new TypeReference("org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider")
					» delegate) {
					super(delegate);
				}
			
				// Labels and icons can be computed like this:
				
			//	String text(Greeting ele) {
			//		return "A greeting to " + ele.getName();
			//	}
			//
			//	String image(Greeting ele) {
			//		return "Greeting.gif";
			//	}
			}
		''').writeTo(projectConfig.eclipsePluginSrc)
	}

	def protected generateJavaDescriptionLabelProvider() {
		fileAccessFactory.createJavaFile(grammar.descriptionLabelProviderClass, '''
			/**
			 * Provides labels for IEObjectDescriptions and IResourceDescriptions.
			 * 
			 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
			 */
			public class «grammar.descriptionLabelProviderClass.simpleName» extends «grammar.descriptionLabelProviderSuperClass» {
			
				// Labels and icons can be computed like this:
				
			//	String text(IEObjectDescription ele) {
			//	   return ele.getName().toString();
			//	}
			//	 
			//  String image(IEObjectDescription ele) {
			//     return ele.getEClass().getName() + ".gif";
			//  }	 
			}
		''').writeTo(projectConfig.eclipsePluginSrc)
	}
}