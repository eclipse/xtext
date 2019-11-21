/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.ui.wizard

import java.util.List
import org.eclipse.core.runtime.Status
import org.eclipse.jdt.core.JavaCore
import org.eclipse.swt.graphics.Image
import org.eclipse.xtext.example.fowlerdsl.ui.internal.FowlerdslActivator
import org.eclipse.xtext.ui.PluginImageHelper
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.util.PluginProjectFactory
import org.eclipse.xtext.ui.wizard.template.IProjectGenerator
import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider
import org.eclipse.xtext.ui.wizard.template.ProjectTemplate

import static org.eclipse.core.runtime.IStatus.*

/**
 * Create a list with all project templates to be shown in the template new project wizard.
 * 
 * Each template is able to generate one or more projects. Each project can be configured such that any number of files are included.
 * 
 * @author miklossy - Initial contribution and API
 */
class StatemachineProjectTemplateProvider implements IProjectTemplateProvider {

	override getProjectTemplates() {
		#[new MrsGrantsSecretCompartmentsProject]
	}
}

@ProjectTemplate(label="Mrs Grant's Secret Compartments", icon="project_template.png", description="<p><b>Mrs Grant's Secret Compartments</b></p>" +
"<p>A Fowler Statemachine representing Mrs Grant's Secret Compartments.</p><p><img href=\"mrsgrantssecretcompartment.png\"/></p>")
final class MrsGrantsSecretCompartmentsProject {

	val advanced = check("Advanced:", false)
	val advancedGroup = group("Properties")
	val path = text("Package:", "mydsl", "The package path to place the files in", advancedGroup)

	override protected updateVariables() {
		path.enabled = advanced.value
		if (!advanced.value) {
			path.value = "statemachine"
		}
	}

	override protected validate() {
		if (path.value.matches('[a-z][a-z0-9_]*(/[a-z][a-z0-9_]*)*'))
			null
		else
			new Status(ERROR, "Wizard", "'" + path + "' is not a valid package name")
	}

	override generateProjects(IProjectGenerator generator) {
		generator.generate(new PluginProjectFactory => [
			projectName = projectInfo.projectName
			location = projectInfo.locationPath
			projectNatures += #[JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature", XtextProjectHelper.NATURE_ID]
			builderIds += #[JavaCore.BUILDER_ID, XtextProjectHelper.BUILDER_ID]
			folders += "src"
			folders += "src-gen"
			addFile('''src/«path»/MrsGrantsSecretCompartments.statemachine''', TemplateContent.MrsGrantsSecretCompartments)
		])
	}

	protected override List<Pair<String, Image>> getImages() {
		#["mrsgrantssecretcompartment.png".image]
	}

	private def image(String id) {
		id -> new PluginImageHelper().getImage('''platform:/plugin/«FowlerdslActivator.PLUGIN_ID»/«id»''')
	}

}