/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.types

import com.google.inject.Inject
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMethod
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.PsiShortNamesCache
import com.intellij.util.ArrayUtil
import com.intellij.util.Processor
import com.intellij.util.containers.ContainerUtil
import com.intellij.util.containers.HashSet
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClasses
import org.eclipse.xtext.xbase.idea.types.stubs.JvmDeclaredTypeShortNameIndex
import com.intellij.util.CommonProcessors
import com.intellij.psi.PsiClass

// TODO should this be a shared service?
class JvmTypesShortNamesCache extends PsiShortNamesCache {
	
    @Inject
    extension JvmPsiClasses
    
    @Inject
    JvmDeclaredTypeShortNameIndex jvmDeclaredTypeShortNameIndex
	
	val Project project
	
	val IXtextLanguage language
	
	new(IXtextLanguage language, Project project) {
		language.injectMembers(this)
		this.project = project
		this.language = language
	}
	
	override getAllClassNames() {
		jvmDeclaredTypeShortNameIndex.getAllKeys(project)
	}
	
	override getAllClassNames(HashSet<String> dest) {
		processAllClassNames(new CommonProcessors.CollectProcessor<String>(dest));
	}
	
	override processAllClassNames(Processor<String> processor) {
		jvmDeclaredTypeShortNameIndex.processAllKeys(project, processor)
	}
	
	override getAllFieldNames() {
		ArrayUtil.EMPTY_STRING_ARRAY
	}
	
	override getAllFieldNames(HashSet<String> set) {
	}
	
	override getAllMethodNames() {
		ArrayUtil.EMPTY_STRING_ARRAY
	}
	
	override getAllMethodNames(HashSet<String> set) {
	}
	
	override getClassesByName(String name, GlobalSearchScope scope) {
		val xtextFiles = jvmDeclaredTypeShortNameIndex.get(name, project, scope)
		if (xtextFiles.isEmpty)
			return PsiClass.EMPTY_ARRAY;
		val result = newArrayList
		for (xtextFile : xtextFiles) {
			if (xtextFile.language == language) {
				result += xtextFile.getPsiClassesByName(name)
			}
		}
		result
	}
	
	override getFieldsByName(String name, GlobalSearchScope scope) {
		PsiField.EMPTY_ARRAY
	}
	
	override getFieldsByNameIfNotMoreThan(String name, GlobalSearchScope scope, int maxCount) {
		PsiField.EMPTY_ARRAY
	}
	
	override getMethodsByName(String name, GlobalSearchScope scope) {
		PsiMethod.EMPTY_ARRAY
	}
	
	override getMethodsByNameIfNotMoreThan(String name, GlobalSearchScope scope, int maxCount) {
		PsiMethod.EMPTY_ARRAY
	}
	
	override processMethodsWithName(String name, GlobalSearchScope scope, Processor<PsiMethod> processor) {
		ContainerUtil.process(getMethodsByName(name, scope), processor)
	}
	
}
