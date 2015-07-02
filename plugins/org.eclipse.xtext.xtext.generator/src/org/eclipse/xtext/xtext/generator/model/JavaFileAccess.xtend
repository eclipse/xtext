/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import com.google.common.collect.Lists
import java.util.Collections
import java.util.Map
import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.xtend.lib.annotations.Accessors

class JavaFileAccess extends TextFileAccess {
	
	val Map<String, String> imports = newHashMap
	
	val String packageName
	
	val CodeConfig codeConfig
	
	@Accessors
	CharSequence typeComment
	
	@Accessors
	boolean markedAsGenerated
	
	new(String qualifiedName, CodeConfig codeConfig) {
		val simpleNameIndex = qualifiedName.lastIndexOf('.')
		this.packageName = qualifiedName.substring(0, simpleNameIndex)
		val simpleName = qualifiedName.substring(simpleNameIndex + 1)
		this.path = packageName.replace('.', '/') + '/' + simpleName + '.java'
		this.codeConfig = codeConfig
	}
	
	def String imported(Class<?> clazz) {
		return imported(clazz.name.replace('$', '.'))
	}

	def String imported(String clazz) {
		val simpleNameIndex = clazz.lastIndexOf('.')
		val simpleName = clazz.substring(simpleNameIndex + 1)
		val packageName = clazz.substring(0, simpleNameIndex)
		if (CodeGenUtil.isJavaDefaultType(simpleName) || this.packageName == packageName)
			return simpleName
		val imported = imports.get(simpleName)
		if (imported != null) {
			if (imported.equals(clazz))
				return simpleName
			else
				return clazz
		}
		imports.put(simpleName, clazz)
		return simpleName
	}
	
	override generate() {
		val classAnnotations = codeConfig.classAnnotations.filter[appliesTo(this)]
		classAnnotations.forEach[imported(annotationImport)]
		val sortedImports = Lists.newArrayList(imports.values())
		Collections.sort(sortedImports)
		return '''
			«codeConfig.fileHeader»
			package «packageName»;
			
			«FOR importName : sortedImports»
				import «importName»;
			«ENDFOR»
			
			«typeComment»
			«FOR annot : classAnnotations»
				«annot.generate()»
			«ENDFOR»
			«FOR fragment : codeFragments»
				«fragment»
			«ENDFOR»
		'''
	}
	
}