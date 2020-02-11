/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.labeling

import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment
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
class LabelProviderFragment2 extends AbstractStubGeneratingFragment {

	static val XBASE_LABEL_PROVIDER = 
		"org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider"

	static val XBASE_DESCRIPTION_LABEL_PROVIDER = 
		"org.eclipse.xtext.xbase.ui.labeling.XbaseDescriptionLabelProvider"

	@Inject
	extension XtextGeneratorNaming

	@Inject
	extension XbaseUsageDetector

	@Inject
	FileAccessFactory fileAccessFactory

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
		if (isGenerateStub || grammar.inheritsXbase) {

			if (projectConfig.eclipsePlugin.manifest !== null) {
				projectConfig.eclipsePlugin.manifest.requiredBundles += "org.eclipse.xtext.ui"
			}
	
			val labelProviderClass =
				if (isGenerateStub) grammar.EObjectLabelProviderClass
				else new TypeReference(XBASE_LABEL_PROVIDER)
	
			val descriptionLabelProviderClass =
				if (isGenerateStub) grammar.descriptionLabelProviderClass
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
		}

		if (isGenerateStub && projectConfig.eclipsePlugin.src !== null) {
			if (generateXtendStub) {
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
			 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
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
		''').writeTo(projectConfig.eclipsePlugin.src)
	}

	def protected generateXtendDescriptionLabelProvider() {
		fileAccessFactory.createXtendFile(grammar.descriptionLabelProviderClass, '''
			/**
			 * Provides labels for IEObjectDescriptions and IResourceDescriptions.
			 * 
			 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
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
		''').writeTo(projectConfig.eclipsePlugin.src)
	}

	def protected generateJavaEObjectLabelProvider() {
		fileAccessFactory.createJavaFile(grammar.EObjectLabelProviderClass, '''
			/**
			 * Provides labels for EObjects.
			 * 
			 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
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
		''').writeTo(projectConfig.eclipsePlugin.src)
	}

	def protected generateJavaDescriptionLabelProvider() {
		fileAccessFactory.createJavaFile(grammar.descriptionLabelProviderClass, '''
			/**
			 * Provides labels for IEObjectDescriptions and IResourceDescriptions.
			 * 
			 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
			 */
			public class «grammar.descriptionLabelProviderClass.simpleName» extends «grammar.descriptionLabelProviderSuperClass» {
			
				// Labels and icons can be computed like this:
			//	@Override
			//	public String text(IEObjectDescription ele) {
			//		return ele.getName().toString();
			//	}
			//	
			//	@Override
			//	public String image(IEObjectDescription ele) {
			//		return ele.getEClass().getName() + ".gif";
			//	}
			}
		''').writeTo(projectConfig.eclipsePlugin.src)
	}
}
