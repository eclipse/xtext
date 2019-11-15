/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.ui.wizard

import org.eclipse.xtext.ui.wizard.template.FileTemplate
import org.eclipse.xtext.ui.wizard.template.IFileGenerator
import org.eclipse.xtext.ui.wizard.template.IFileTemplateProvider

/**
 * Create a list with all file templates to be shown in the template new file wizard.
 * 
 * Each template is able to generate one or more files.
 * 
 * @author miklossy - Initial contribution and API
 */
class StatemachineFileTemplateProvider implements IFileTemplateProvider {
	override getFileTemplates() {
		#[new EmptyFile, new MrsGrantsSecretCompartmentsFile]
	}
}

@FileTemplate(label="Empty Statemachine", icon="file_template.png", description="Empty Statemachine")
final class EmptyFile {
	
	override generateFiles(IFileGenerator generator) {
		generator.generate('''«folder»/«name».statemachine''', '''''')
	}
}

@FileTemplate(label="Mrs Grant's Secret Compartments", icon="file_template.png", description="Mrs Grant's Secret Compartments")
final class MrsGrantsSecretCompartmentsFile {
	
	override generateFiles(IFileGenerator generator) {
		generator.generate('''«folder»/«name».statemachine''', TemplateContent.MrsGrantsSecretCompartments)
	}
}
