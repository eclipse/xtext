/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import java.util.Map
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.util.internal.CodeGenUtil2
import org.eclipse.xtext.xtext.generator.CodeConfig

/**
 * A utility class for generating Java files.
 */
class JavaFileAccess extends TextFileAccess {
	
	/**
	 * A list of keywords in the Java language. Use this to avoid illegal variable names.
	 */
	public static val JAVA_KEYWORDS = #{
		'abstract', 'continue', 'for', 'new', 'switch', 'assert', 'default', 'goto', 'package',
		'synchronized', 'boolean', 'do', 'if', 'private', 'this', 'break', 'double', 'implements',
		'protected', 'throw', 'byte', 'else', 'import', 'public', 'throws', 'case', 'enum',
		'instanceof', 'return', 'transient', 'catch', 'extends', 'int', 'short', 'try', 'char',
		'final', 'interface', 'static', 'void', 'class', 'finally', 'long', 'strictfp', 'volatile',
		'const', 'float', 'native', 'super', 'while'
	}
	
	/**
	 * Set this value for the 'importNestedTypeThreshold' property to disable importing of nested types
	 */
	public static val DONT_IMPORT_NESTED_TYPES = Integer.MAX_VALUE
	
	protected val Map<String, String> imports = newHashMap
	
	protected val TypeReference javaType
	
	protected val CodeConfig codeConfig
	
	@Accessors
	int importNestedTypeThreshold = 8
	
	@Accessors
	boolean markedAsGenerated
	
	@Accessors(PUBLIC_SETTER)
	ResourceSet resourceSet
	
	protected new(TypeReference typeRef, CodeConfig codeConfig) {
		if (typeRef.simpleNames.length > 1)
			throw new IllegalArgumentException('Nested type cannot be serialized: ' + typeRef)
		this.javaType = typeRef
		this.codeConfig = codeConfig
		setPath(typeRef.path + '.' + fileExtension)
	}
	
	protected def String getFileExtension() {
		'java'
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
				if (!CodeGenUtil2.isJavaDefaultType(simpleName)
						&& !(i > 0 && simpleName.length <= importNestedTypeThreshold)) {
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
	
	override setContent(StringConcatenationClient javaContent) {
		val javaStringConcat = new JavaTypeAwareStringConcatenation(this)
		javaStringConcat.append(javaContent)
		this.internalContents = javaStringConcat
	}
	
	protected def boolean appendSemicolons() {
		true
	}
	
	override getContent() '''
		«codeConfig.fileHeader»
		package «javaType.packageName»«IF appendSemicolons»;«ENDIF»

		«FOR importName : imports.values.toSet.sort»
			import «importName»«IF appendSemicolons»;«ENDIF»
		«ENDFOR»
		
		«getInternalContent»
	'''
	
	protected def getInternalContent() {
		internalContents
	}
	
	protected static class JavaTypeAwareStringConcatenation extends StringConcatenation {
		
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
			else if (object instanceof EClass && access.resourceSet !== null)
				access.importType(new TypeReference(object as EClass, access.resourceSet))
			else if (object instanceof EPackage && access.resourceSet !== null)
				access.importType(new TypeReference(object as EPackage, access.resourceSet))
			else
				object.toString
		}
		
	}
	
}
