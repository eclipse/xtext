/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.jvmmodel

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.naming.IQualifiedNameProvider

import static org.eclipse.xtext.util.Strings.*

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class JvmPsiClassStubGenerator {

	@Inject
	extension IQualifiedNameProvider

	def generateStub(JvmDeclaredType it, IFileSystemAccess fileSystemAccess) {
		fileSystemAccess.generateFile(javaFileName, javaStubSource)
	}

	protected def getJavaFileName(JvmDeclaredType it) {
		concat('/', fullyQualifiedName.segments) + '.java'
	}

	protected def getJavaStubSource(JvmDeclaredType it) '''
		«IF packageName != null»package «packageName»;«ENDIF»
		«compileVisibility» «compileType» «simpleName»«compileTypeParameters» {}
	'''

	protected def compileType(JvmDeclaredType it) {
		switch it {
			JvmEnumerationType: 'enum'
			JvmAnnotationType: '@interface'
			JvmGenericType case interface: 'interface'
			default: 'class'
		}
	}

	protected def compileVisibility(JvmDeclaredType it) {
		switch visibility {
			case PUBLIC: 'public'
			case PROTECTED: 'protected'
			case PRIVATE: 'private'
			default: ''
		}
	}

	protected def compileTypeParameters(JvmDeclaredType it) {
		if (it instanceof JvmGenericType) {
			'''«FOR typeParameter : typeParameters BEFORE '<' SEPARATOR ', ' AFTER '>'»«typeParameter.simpleName»«ENDFOR»'''
		} else
			''
	}

}