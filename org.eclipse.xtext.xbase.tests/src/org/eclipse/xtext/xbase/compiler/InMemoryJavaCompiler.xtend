/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler

import java.io.ByteArrayInputStream
import java.io.InputStream
import java.net.URL
import java.net.URLConnection
import java.util.HashMap
import java.util.Map
import java.util.Set
import org.eclipse.jdt.core.compiler.CategorizedProblem
import org.eclipse.jdt.internal.compiler.Compiler
import org.eclipse.jdt.internal.compiler.DefaultErrorHandlingPolicies
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit
import org.eclipse.jdt.internal.compiler.env.INameEnvironment
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions
import org.eclipse.jdt.internal.compiler.problem.DefaultProblemFactory
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.JavaVersion
import org.eclipse.xtext.xbase.compiler.InMemoryJavaCompiler.Result

/**
 * 
 * @since 2.9
 */
class InMemoryJavaCompiler {
	
	@FinalFieldsConstructor private static class ClassLoaderBasedNameEnvironment implements INameEnvironment {
		
		val ClassLoader classLoader
		
		Map<String, NameEnvironmentAnswer> cache = newHashMap()
		
		override cleanup() {
			cache.clear
		}
		
		override findType(char[][] compoundTypeName) {
			val fileName = compoundTypeName.map[String.valueOf(it)].join("/")+".class"
			if (cache.containsKey(fileName)) {
				return cache.get(fileName)
			}
			val url = classLoader.getResource(fileName)
			if (url == null) {
				cache.put(fileName, null)
				return null;
			}
			val reader = ClassFileReader.read(url.openStream, fileName)
			val result = new NameEnvironmentAnswer(reader, null)
			cache.put(fileName, result)
			return result
		}
		
		override findType(char[] typeName, char[][] packageName) {
			val fileName = packageName.map[String.valueOf(it)].join("/")+"/"+String.valueOf(typeName)+".class"
			if (cache.containsKey(fileName)) {
				return cache.get(fileName)
			}
			val url = classLoader.getResource(fileName)
			if (url == null) {
				cache.put(fileName, null)
				return null;
			}
			val reader = ClassFileReader.read(url.openStream, fileName)
			val result = new NameEnvironmentAnswer(reader, null)
			cache.put(fileName, result)
			return result
		}
		
		override isPackage(char[][] parentPackageName, char[] packageName) {
			//Working hack
			return Character.isLowerCase(packageName.head)
		}
	}
	
	static package class ByteClassLoader extends ClassLoader {
		Map<String, byte[]> classMap

		new(Map<String, byte[]> classMap, ClassLoader parent) {
			super(parent)
			this.classMap = classMap
		}

		override protected Class<?> findClass(String name) throws ClassNotFoundException {
			var byte[] bytes = classMap.get(name)
			if (bytes === null) {
				return super.findClass(name)
			} else {
				return defineClass(name, bytes, 0, bytes.length)
			}
		}
		
		override protected findResource(String path) {
			if (path.endsWith(".class")) {
				val className = path.substring(0, path.length-6).replace("/", ".")
				val bytes = classMap.get(className)
				if (bytes != null) {
					return new URL("in-memory", null, -1, path, [ 
						new URLConnection(it) {
							override void connect() {}
				
							override InputStream getInputStream() {
								return new ByteArrayInputStream(bytes) 
							}
						}
					])
				}
			}
			return null
		}
	}
	
	val INameEnvironment nameEnv
	val ClassLoader parentClassLoader
	val CompilerOptions compilerOptions

	new(ClassLoader parent, JavaVersion javaVersion) {
		nameEnv = new ClassLoaderBasedNameEnvironment(parent)
		parentClassLoader = parent
		compilerOptions = new CompilerOptions
		val classFmt = javaVersion.toClassFmt
		sourceLevel = classFmt
		complianceLevel = classFmt
		compilerOptions.targetJDK = classFmt
		compilerOptions.inlineJsrBytecode = true
		compilerOptions.preserveAllLocalVariables = true
	}
	
	new(ClassLoader parent, CompilerOptions compilerOptions) {
		nameEnv = new ClassLoaderBasedNameEnvironment(parent)
		parentClassLoader = parent
		this.compilerOptions = new CompilerOptions(compilerOptions.map)
	}
	
	private def long toClassFmt(JavaVersion version) {
		switch(version) {
			case JAVA5: return ClassFileConstants.JDK1_5
			case JAVA6: return ClassFileConstants.JDK1_6
			case JAVA7: return ClassFileConstants.JDK1_7
			case JAVA8: return ((ClassFileConstants.MAJOR_VERSION_1_7 + 1) << 16) + ClassFileConstants.MINOR_VERSION_0 // ClassFileConstants.JDK1_8
		}
	}
	
	/**
	 * sets the source level (see @link(org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants))
	 */
	private def void setSourceLevel(long jdkVersion){
		compilerOptions.sourceLevel = jdkVersion
		// these fields have been introduces in JDT 3.7
		try {
			CompilerOptions.getField("originalSourceLevel").setLong(compilerOptions, jdkVersion)
		} catch (NoSuchFieldException e) {
			// ignore
		}
	}
	
	/**
	 * sets the compliance level (see @link(org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants))
	 */
	private def void setComplianceLevel(long jdkVersion){
		compilerOptions.complianceLevel = jdkVersion
		// these fields have been introduces in JDT 3.7
		try {
			CompilerOptions.getField("originalComplianceLevel").setLong(compilerOptions, jdkVersion)
		} catch (NoSuchFieldException e) {
			// ignore
		}
	}
	
	def Result compile(JavaSource... sources) {
		val Result result = new Result(parentClassLoader)
		var compiler = new Compiler(nameEnv, DefaultErrorHandlingPolicies.proceedWithAllProblems(),
			compilerOptions, [
				for (cf : it.getClassFiles()) {
					result.classMap.put(cf.compoundName.map[String.valueOf(it)].join('.'), cf.bytes)
				}
			], new DefaultProblemFactory(){
				
				override createProblem(char[] originatingFileName, int problemId, String[] problemArguments, int elaborationId, String[] messageArguments, int severity, int startPosition, int endPosition, int lineNumber, int columnNumber) {
					val problem = super.createProblem(originatingFileName, problemId, problemArguments, elaborationId, messageArguments, severity, startPosition, endPosition, lineNumber, columnNumber)
					result.compilationProblems.add(problem)
					return problem
				}
				
				override createProblem(char[] originatingFileName, int problemId, String[] problemArguments, String[] messageArguments, int severity, int startPosition, int endPosition, int lineNumber, int columnNumber) {
					val problem = super.createProblem(originatingFileName, problemId, problemArguments, messageArguments, severity, startPosition, endPosition, lineNumber, columnNumber)
					result.compilationProblems.add(problem)
					return problem
				}
				
			})
		var ICompilationUnit[] units = sources.map[new CompilationUnit(code.toCharArray(), fileName, null)]
		compiler.compile(units)
		return result
	}
	

	@FinalFieldsConstructor public static class Result {
		@Accessors val Set<CategorizedProblem> compilationProblems = newLinkedHashSet()
		val classMap = new HashMap<String, byte[]>
		val ClassLoader parentClassLoader

		def ClassLoader getClassLoader() {
			new ByteClassLoader(classMap, parentClassLoader)
		}
	}

}

/**
 * @since 2.9
 */
@Data class JavaSource {
	String fileName
	String code
}
