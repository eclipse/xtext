/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ide.types

import com.google.common.base.Splitter
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream
import java.util.Collection
import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.naming.QualifiedName
import org.objectweb.asm.ClassReader

@Data
class ClasspathTypeDescriptor implements ITypeDescriptor {
	
	static val NESTED_CLASS_SPLITTER = Splitter.on('$')
	static val PACKAGE_AND_NESTED_CLASS_SPLITTER = Splitter.onPattern('\\.|\\$')
	static val ANONYMOUS_CLASS_PATTERN = Pattern.compile('\\d+')
	
	String name
	
	// TODO may also need access flags of enclosing classes to determine visibility
	int accessFlags
	
	override getSimpleName() {
		qualifiedName.lastSegment
	}
	
	override getQualifiedName() {
		QualifiedName.create(PACKAGE_AND_NESTED_CLASS_SPLITTER.split(name))
	}
	
	static def forFile(File file, String packageName, Collection<String> packagePrefixes) {
		if (!packagePrefixes.empty && !packagePrefixes.exists[packageName.startsWith(it)])
			return null
		val fileName = file.name
		var InputStream inputStream
		try {
			if (fileName.endsWith('.class')) {
				val simpleNames = fileName.substring(0, fileName.length - 6)
				for (s : NESTED_CLASS_SPLITTER.split(simpleNames)) {
					if (ANONYMOUS_CLASS_PATTERN.matcher(s).matches)
						return null
				}
				val name = if (packageName.empty) simpleNames else packageName + '.' + simpleNames
				
				inputStream = new FileInputStream(file)
				val classReader = new ClassReader(inputStream)
				val accessFlags = classReader.access
				new ClasspathTypeDescriptor(name, accessFlags)
			}
		} catch (IOException exception) {
		} finally {
			if (inputStream !== null)
				inputStream.close()			
		}
	}
	
	static def forJarEntry(JarEntry jarEntry, JarFile jarFile, Collection<String> packagePrefixes) {
		val filePath = jarEntry.name
		var InputStream inputStream
		try {
			if (filePath.endsWith('.class')) {
				val name = filePath.substring(0, filePath.length - 6).replace('/', '.')
				if (!packagePrefixes.empty && !packagePrefixes.exists[name.startsWith(it)])
					return null
				val simpleNames = name.substring(name.lastIndexOf('.') + 1)
				for (s : NESTED_CLASS_SPLITTER.split(simpleNames)) {
					if (ANONYMOUS_CLASS_PATTERN.matcher(s).matches)
						return null
				}
				
				inputStream = jarFile.getInputStream(jarEntry)
				val classReader = new ClassReader(inputStream)
				val accessFlags = classReader.access
				new ClasspathTypeDescriptor(name, accessFlags)
			}
		} catch (IOException exception) {
		} finally {
			if (inputStream !== null)
				inputStream.close()			
		}
	}
	
}
