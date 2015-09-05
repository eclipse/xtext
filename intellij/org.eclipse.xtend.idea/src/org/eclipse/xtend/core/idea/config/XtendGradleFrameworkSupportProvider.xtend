/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.config

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.framework.FrameworkTypeEx
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModifiableModelsProvider
import com.intellij.openapi.roots.ModifiableRootModel
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.jetbrains.plugins.gradle.frameworkSupport.BuildScriptDataBuilder
import org.jetbrains.plugins.gradle.frameworkSupport.GradleFrameworkSupportProvider

/**
 * @author Dennis Huebner (dhuebner) - Initial contribution and API
 */
class XtendGradleFrameworkSupportProvider extends GradleFrameworkSupportProvider {

	@Inject GradleBuildFileUtility gradleUtility
	@Inject Provider<XtendSupportConfigurable> xtendSupportConfigurableProvider

	new() {
		XtendLanguage.INSTANCE.injectMembers(this)
	}
	
	override getFrameworkType() {
		FrameworkTypeEx.EP_NAME.findExtension(XtendFrameworkType)
	}

	override addSupport(Module module, ModifiableRootModel rootModel, ModifiableModelsProvider modifiableModelsProvider,
		BuildScriptDataBuilder script) {
		// TODO extract this to use in XtendSupportConfigurable
		val snapshot = XtendLibraryManager.xtendLibMavenId.version?.endsWith("-SNAPSHOT")
		script.addOther('''
			buildscript {
				repositories {
					«IF snapshot»
						maven {
							url 'http://oss.sonatype.org/content/repositories/snapshots'
						}
				    «ENDIF»
				    jcenter()
				}
			    dependencies {
			        classpath 'org.xtend:xtend-gradle-plugin:«gradleUtility.xtendGradlePluginVersion»'
			    }
			}
		''')
		script.addPluginDefinition("apply plugin: 'java'").addPluginDefinition("apply plugin: 'org.xtend.xtend'").
			addPropertyDefinition("sourceCompatibility = 1.5").addRepositoriesDefinition("jcenter()").
			addDependencyNotation('''compile '«XtendLibraryManager.xtendLibMavenId.key»' ''')

		if (snapshot) {
			script.addRepositoriesDefinition('''
			maven {
				url 'http://oss.sonatype.org/content/repositories/snapshots'
			}''')
		}
		val xtendSupport = xtendSupportConfigurableProvider.get
		val conf = xtendSupport.createOrGetXtendFacetConf(module)
		xtendSupport.presetGradleOutputDirectories(conf.state,module)
		xtendSupport.createOutputFolders(conf.state,rootModel)
	}

}