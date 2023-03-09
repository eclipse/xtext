/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.outline

import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.typeRef

/**
 * @author Christian Schneider - Initial contribution and API
 */
class OutlineTreeProviderFragment2 extends AbstractStubGeneratingFragment {

	@Inject FileAccessFactory fileAccessFactory
	@Inject extension XtextGeneratorNaming
	
	protected def TypeReference getOutlineTreeProviderClass(Grammar grammar) {
		new TypeReference(grammar.eclipsePluginBasePackage
			+ ".outline." + GrammarUtil.getSimpleName(grammar) + "OutlineTreeProvider"
		)
	}

	override generate() {
		if (projectConfig.eclipsePlugin.manifest !== null) {
			projectConfig.eclipsePlugin.manifest.requiredBundles += "org.eclipse.xtext.ui"
		}
		
		if (!isGenerateStub) {
			return;
		}

		if (projectConfig.eclipsePlugin.src !== null) {
			if (generateXtendStub) {
				generateXtendOutlineTreeProvider
			} else {
				generateJavaOutlineTreeProvider
			}
		}

		new GuiceModuleAccess.BindingFactory()
				.addTypeToType(new TypeReference("org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider"),
						grammar.outlineTreeProviderClass)
				.addTypeToType(new TypeReference("org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider"),
						grammar.outlineTreeProviderClass)
				.contributeTo(language.eclipsePluginGenModule);
	}
	
	def protected generateJavaOutlineTreeProvider() {
		fileAccessFactory.createJavaFile(grammar.outlineTreeProviderClass, '''
			/**
			 * Customization of the default outline structure.
			 *
			 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
			 */
			public class «grammar.outlineTreeProviderClass.simpleName» extends «
				"org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider".typeRef» {
			
			}
		''').writeTo(projectConfig.eclipsePlugin.src)
	}
	
	def protected generateXtendOutlineTreeProvider() {
		fileAccessFactory.createXtendFile(grammar.outlineTreeProviderClass, '''
			/**
			 * Customization of the default outline structure.
			 *
			 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
			 */
			class «grammar.outlineTreeProviderClass.simpleName» extends «
				"org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider".typeRef» {
			
			}
		''').writeTo(projectConfig.eclipsePlugin.src)
	}}
