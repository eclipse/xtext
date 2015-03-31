package org.eclipse.xtext.idea.extensions

import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.IndexNotReadyException
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.search.GlobalSearchScope
import org.apache.log4j.Logger

class IdeaProjectExtensions {

	static val LOG = Logger.getLogger(IdeaProjectExtensions)

	static def findClassWithAlternativeResolvedEnabled(
		JavaPsiFacade javaPsiFacade,
		String name,
		GlobalSearchScope searchScope
	) {
		javaPsiFacade.project.withAlternativeResolvedEnabled [
			javaPsiFacade.findClass(name, searchScope)
		]
	}

	static def findClassesWithAlternativeResolvedEnabled(
		JavaPsiFacade javaPsiFacade,
		String name,
		GlobalSearchScope searchScope
	) {
		javaPsiFacade.project.withAlternativeResolvedEnabled [
			javaPsiFacade.findClasses(name, searchScope)
		]
	}

	static def <T> T withAlternativeResolvedEnabled(Project project, ()=>T function) {
		project.dumbService.withAlternativeResolvedEnabled(function)
	}

	static def <T> T withAlternativeResolvedEnabled(DumbService dumbService, ()=>T function) {
		val wasEnabled = dumbService.alternativeResolveEnabled
		if (!wasEnabled) {
			dumbService.alternativeResolveEnabled = true
		}
		try {
			function.apply
		} catch (IndexNotReadyException e) {
			// Should never happen
			LOG.warn(e.message, e)
			null
		} finally {
			if (!wasEnabled) {
				dumbService.alternativeResolveEnabled = false
			}
		}
	}

	static def getJavaPsiFacade(Project project) {
		JavaPsiFacade.getInstance(project)
	}

	static def getDumbService(Project project) {
		DumbService.getInstance(project)
	}
	
	static def getProjectFileIndex(Project project) {
		ProjectFileIndex.SERVICE.getInstance(project)
	}

}