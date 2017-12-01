/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.editor

import com.google.inject.Inject
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector

/**
 * @author fstolte - Initial contribution and API
 * @since 2.14
 */
class EditorFragment2 extends AbstractStubGeneratingFragment {
	
	@Inject FileAccessFactory fileAccessFactory
	
	@Inject extension XbaseUsageDetector
	
	@Inject extension XtextGeneratorNaming
	
	override generate() {
		if (isGenerateStub) {
			if (projectConfig.eclipsePlugin?.srcGen !== null) {
				generateEditor
			}
			

			if (projectConfig.eclipsePlugin.manifest !== null) {
				projectConfig.eclipsePlugin.manifest.exportedPackages += grammar.eclipsePluginEditor.packageName
			}
		}
	}
	
	
	protected def generateEditor() {
		val file = fileAccessFactory.createGeneratedJavaFile(grammar.eclipsePluginEditor)
		
		val superClass = if (grammar.inheritsXbase) grammar.eclipsePluginXbaseEditor else grammar.eclipsePluginDefaultEditor
		
		file.content = '''
			/**
			 * This class was generated. Customizations should only happen in a newly
			 * introduced subclass.
			 */
			public class «grammar.eclipsePluginEditor.simpleName» extends «superClass» {
			}
		'''
		file.writeTo(projectConfig.eclipsePlugin.srcGen)
	}
	
}