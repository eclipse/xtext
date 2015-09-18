/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.util

import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupManager

/**
 * @author Dennis Huebner - Initial contribution and API
 */
class ProjectLifecycleUtil {

	/**
	 * Executes Runnable when project is fully initialized and the Index is ready (SmartMode).<br>
	 * Runnable will be executed immediately when project in in initialized smart mode.
	 */
	def void executeWhenProjectReady(Project project, Runnable fun) {
		if (project.initialized) {
			if (DumbService.getInstance(project).isDumb) {
				DumbService.getInstance(project).runWhenSmart(fun)
			} else {
				fun.run
			}
		} else {
			StartupManager.getInstance(project).registerPostStartupActivity(fun)
		}
	}
}