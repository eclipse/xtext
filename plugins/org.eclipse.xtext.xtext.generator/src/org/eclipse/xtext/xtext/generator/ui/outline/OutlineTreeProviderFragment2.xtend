/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.outline

import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.typeRef
import org.eclipse.xtext.xtext.generator.CodeConfig

/**
 * @author Christian Schneider - Initial contribution and API
 */
class OutlineTreeProviderFragment2 extends AbstractGeneratorFragment2 {

	@Inject CodeConfig codeConfig
	@Inject FileAccessFactory fileAccessFactory
	@Inject extension XtextGeneratorNaming
	
	@Accessors
	boolean generateStub = true;

	protected def TypeReference getOutlineTreeProviderClass(Grammar grammar) {
		new TypeReference(grammar.eclipsePluginBasePackage
			+ ".outline." + GrammarUtil.getSimpleName(grammar) + "OutlineTreeProvider"
		)
	}

	override generate() {
		if (projectConfig.eclipsePlugin.manifest != null) {
			projectConfig.eclipsePlugin.manifest.requiredBundles += "org.eclipse.xtext.ui"
		}
		
		if (!generateStub) {
			return;
		}

		if (projectConfig.eclipsePlugin.src !== null) {
			if (codeConfig.preferXtendStubs) {
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
			 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline
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
			 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline
			 */
			class «grammar.outlineTreeProviderClass.simpleName» extends «
				"org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider".typeRef» {
			
			}
		''').writeTo(projectConfig.eclipsePlugin.src)
	}}