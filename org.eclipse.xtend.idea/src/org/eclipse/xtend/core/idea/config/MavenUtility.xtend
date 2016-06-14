/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.config

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.module.Module
import com.intellij.util.xml.DomUtil
import org.eclipse.xtext.idea.util.PlatformUtil
import org.jetbrains.idea.maven.dom.MavenDomUtil
import org.jetbrains.idea.maven.model.MavenId
import org.jetbrains.idea.maven.project.MavenProject
import org.jetbrains.idea.maven.project.MavenProjectsManager

/**
 * @author dhuebner - Initial contribution and API
 */
class MavenUtility {

	def void addXtendLibMavenDependency(Module module, boolean isTestScope) {
		if (!module.isMavenizedModule) {
			throw new IllegalArgumentException(
				'''Can't add maven dependency to a non maven module «module.name»'''
			)
		}
		val project = module.getProject()
		val mavenProjectsManager = MavenProjectsManager.getInstance(project)
		val MavenProject mavenProject = mavenProjectsManager.findProject(module)
		if(mavenProject === null) return;

		val model = MavenDomUtil.getMavenDomProjectModel(project, mavenProject.getFile())
		if(model === null) return;

		new WriteCommandAction.Simple(project, "Add Xtend lib Maven Dependency",
			newImmutableList(DomUtil.getFile(model))) {

			override protected run() throws Throwable {
				var dependency = MavenDomUtil.createDomDependency(model, null,
					new MavenId(XtendLibraryConfigurator.xtendLibMavenId.groupId,
						XtendLibraryConfigurator.xtendLibMavenId.artifactId,
						XtendLibraryConfigurator.xtendLibMavenId.version))
					if (isTestScope) {
						dependency.getScope().setStringValue("test")
					}
				}

			}.execute()
		}

		def boolean isMavenizedModule(Module module) {
			if (new PlatformUtil().isMavenInstalled) {
				var mavenProjectsManager = MavenProjectsManager.getInstance(module.getProject())
				return if(mavenProjectsManager !== null) mavenProjectsManager.isMavenizedModule(module) else false
			}
			return false
		}

	}
	