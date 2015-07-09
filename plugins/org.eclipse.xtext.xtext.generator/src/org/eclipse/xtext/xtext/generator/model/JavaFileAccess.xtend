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
import java.util.List
import java.util.Map
import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.xtext.generator.CodeConfig

class JavaFileAccess extends TextFileAccess {
	
	val Map<String, String> imports = newHashMap
	
	val TypeReference javaType
	
	val CodeConfig codeConfig
	
	@Accessors
	CharSequence typeComment
	
	@Accessors
	boolean markedAsGenerated
	
	@Accessors
	val List<IClassAnnotation> annotations = newArrayList
	
	new(String qualifiedName, CodeConfig codeConfig) {
		this(new TypeReference(qualifiedName), codeConfig)
	}
	
	new(TypeReference typeRef, CodeConfig codeConfig) {
		if (typeRef.simpleNames.length > 1)
			throw new IllegalArgumentException('Nested type cannot be serialized: ' + typeRef)
		this.javaType = typeRef
		this.codeConfig = codeConfig
		setPath(typeRef.path)
	}

	def String importType(TypeReference typeRef) {
		val simpleNames = typeRef.simpleNames
		var String usableName
		if (typeRef.packageName == 'java.lang' || typeRef.packageName == javaType.packageName) {
			usableName = simpleNames.join('.')
		} else {
			var found = false
			for (var i = simpleNames.length - 1; i >= 0 && !found; i--) {
				val simpleName = simpleNames.get(i)
				if (usableName === null)
					usableName = simpleName
				else
					usableName = simpleName + '.' + usableName
				if (!CodeGenUtil.isJavaDefaultType(simpleName)
						&& !(i == simpleNames.length - 1 && i > 0 && simpleName.length <= 8)) {
					val importable = typeRef.packageName + '.' + simpleNames.subList(0, i + 1).join('.')
					val imported = imports.get(usableName)
					if (imported === null) {
						imports.put(usableName, importable)
						found = true
					} else if (imported == importable) {
						found = true
					}
				}
			}
			if (!found)
				usableName = typeRef.name
		}
		return usableName + typeRef.typeArguments.join('<', ', ', '>', [importType])
	}
	
	def void setJavaContent(StringConcatenationClient javaContent) {
		val javaStringConcat = new JavaStringConcatenation(this)
		javaStringConcat.append(javaContent)
		setContent(javaStringConcat)
	}
	
	override generate() {
		val classAnnotations = annotations + codeConfig.classAnnotations.filter[appliesTo(this)]
		classAnnotations.forEach[importType(annotationImport)]
		val sortedImports = Lists.newArrayList(imports.values)
		Collections.sort(sortedImports)
		return '''
			«codeConfig.fileHeader»
			package «javaType.packageName»;
			
			«FOR importName : sortedImports»
				import «importName»;
			«ENDFOR»
			
			«typeComment»
			«FOR annot : classAnnotations»
				«annot.generate()»
			«ENDFOR»
			«content»
		'''
	}
	
	private static class JavaStringConcatenation extends StringConcatenation {
		
		val JavaFileAccess access
		
		new(JavaFileAccess access) {
			super(access.codeConfig.lineDelimiter)
			this.access = access
		}
		
		override getStringRepresentation(Object object) {
			if (object instanceof TypeReference)
				access.importType(object)
			else if (object instanceof Class<?>)
				access.importType(new TypeReference(object))
			else
				object.toString
		}
		
	}
	
}