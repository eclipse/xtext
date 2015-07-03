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
import java.util.regex.Pattern
import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtend2.lib.StringConcatenationClient

class JavaFileAccess extends TextFileAccess {
	
	val Map<String, TypeReference> imports = newHashMap
	
	val String packageName
	
	val CodeConfig codeConfig
	
	@Accessors
	CharSequence typeComment
	
	@Accessors
	boolean markedAsGenerated
	
	new(String qualifiedName, CodeConfig codeConfig) {
		this(new TypeReference(qualifiedName), codeConfig)
	}
	
	new(TypeReference typeRef, CodeConfig codeConfig) {
		this.packageName = typeRef.package
		if (typeRef.name != packageName + '.' + typeRef.simpleName)
			throw new IllegalArgumentException('Nested types cannot be serialized.')
		this.path = packageName.replace('.', '/') + '/' + typeRef.simpleName + '.java'
		this.codeConfig = codeConfig
	}

	def String importType(TypeReference typeRef) {
		val simpleName = typeRef.simpleName
		if (CodeGenUtil.isJavaDefaultType(simpleName) || this.packageName == typeRef.package)
			return simpleName
		val imported = imports.get(simpleName)
		if (imported != null) {
			if (imported == typeRef)
				return simpleName
			else
				return typeRef.name
		}
		imports.put(simpleName, typeRef)
		return simpleName
	}
	
	def void setJavaContent(StringConcatenationClient javaContent) {
		val javaStringConcat = new JavaStringConcatenation(this)
		javaStringConcat.append(javaContent)
		content = javaStringConcat
	}
	
	override generate() {
		val classAnnotations = codeConfig.classAnnotations.filter[appliesTo(this)]
		classAnnotations.forEach[importType(annotationImport)]
		val sortedImports = Lists.newArrayList(imports.values.map[name])
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
			«content»
		'''
	}
	
	private static class JavaStringConcatenation extends StringConcatenation {
		
		val JavaFileAccess access
		
		val typeNamePattern = Pattern.compile('[a-z]+(\\.[a-z]+)*(\\.[A-Z][a-zA-Z]*)+')
		
		new(JavaFileAccess access) {
			super(access.codeConfig.lineDelimiter)
			this.access = access
		}
		
		override getStringRepresentation(Object object) {
			if (object instanceof TypeReference)
				access.importType(object)
			else if (object instanceof Class<?>)
				access.importType(new TypeReference(object as Class<?>))
			else if (object instanceof String && typeNamePattern.matcher(object as String).matches)
				access.importType(new TypeReference(object as String))
			else
				object.toString
		}
		
	}
	
}