package org.eclipse.xtext.idea.extensions

import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.LanguageLevelProjectExtension
import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.search.GlobalSearchScope
import org.eclipse.xtext.util.Wrapper

class IdeaProjectExtensions {

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

	/**
	 * The given function is executed with a fallback to the slow indexing mode, which
	 * is demand indexing rather than using a populated index.
	 */
	static def <T> T withAlternativeResolvedEnabled(Project project, ()=>T function) {
		project.dumbService.withAlternativeResolvedEnabled(function)
	}

	/**
	 * The given function is executed with a fallback to the slow indexing mode, which
	 * is demand indexing rather than using a populated index.
	 */
	static def <T> T withAlternativeResolvedEnabled(DumbService dumbService, ()=>T function) {
		val Wrapper<T> result = Wrapper.wrap(null)
		dumbService.withAlternativeResolveEnabled [
			result.set(function.apply)
		]
		return result.get
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
	
	static def getLanguageLevelProjectExtension(Project project) {
		LanguageLevelProjectExtension.getInstance(project)
	}
	
	static def getPsiFileFactory(Project project) {
		PsiFileFactory.getInstance(project)
	}
	
	static def getPsiDocumentManager(Project project) {
		PsiDocumentManager.getInstance(project)
	}

}