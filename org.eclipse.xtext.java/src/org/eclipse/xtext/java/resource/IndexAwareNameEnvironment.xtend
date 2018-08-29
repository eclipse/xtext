package org.eclipse.xtext.java.resource

import java.util.ArrayList
import java.util.Map
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader
import org.eclipse.jdt.internal.compiler.env.INameEnvironment
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.common.types.descriptions.EObjectDescriptionBasedStubGenerator
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.emf.ecore.resource.Resource
import java.io.InputStream
import org.eclipse.jdt.internal.compiler.env.IBinaryType

@FinalFieldsConstructor class IndexAwareNameEnvironment implements INameEnvironment {

    val Resource resource
	val ClassLoader classLoader
	val IResourceDescriptions resourceDescriptions
	val EObjectDescriptionBasedStubGenerator stubGenerator
	val ClassFileCache classFileCache
	
	Map<QualifiedName, NameEnvironmentAnswer> nameToAnswerCache = newHashMap()

	override cleanup() {
		nameToAnswerCache.clear
		classFileCache.clear
	}

	override findType(char[][] compoundTypeName) {
		val className = QualifiedName.create(compoundTypeName.map[String.valueOf(it)])
		return findType(className)
	}
	
	def NameEnvironmentAnswer findType(QualifiedName className) {
		if (classFileCache.containsKey(className)) {
			val t = classFileCache.get(className)
			if (t===null) {
				return null
			}
			return new NameEnvironmentAnswer(t, null)
		}
		if (nameToAnswerCache.containsKey(className)) {
			return nameToAnswerCache.get(className)
		}
		val candidate = resourceDescriptions.getExportedObjects(TypesPackage.Literals.JVM_DECLARED_TYPE, className, false).head
		var NameEnvironmentAnswer result = null 
		if (candidate !== null) {
			val resourceDescription = resourceDescriptions.getResourceDescription(candidate.EObjectURI.trimFragment)
			val res = resource.resourceSet.getResource(resourceDescription.URI, false)
			val source = if (res instanceof JavaResource) {
			    (res as JavaResource).originalSource
			} else {
			    stubGenerator.getJavaStubSource(candidate, resourceDescription)
			}
			result = new NameEnvironmentAnswer(new CompilationUnit(source.toCharArray, className.toString('/')+'.java', null), null)
		} else {
			val fileName = className.toString('/') + ".class"
			val url = classLoader.getResource(fileName)
			if (url === null) {
				nameToAnswerCache.put(className, null)
				classFileCache.put(className, null)
				return null;
			}
			var InputStream stream = null
			val IBinaryType reader = try {
				stream = url.openStream
				ClassFileReader.read(stream, fileName)
			} finally {
				if (stream !== null) {
					stream.close
				}
			}
			if (reader === null) {
				return null;
			}
			classFileCache.put(className, reader)
			result = new NameEnvironmentAnswer(reader, null)
		}
		nameToAnswerCache.put(className, result)
		return result
	}

	override findType(char[] typeName, char[][] packageName) {
		val list = new ArrayList(packageName.map[String.valueOf(it)])
		list += String.valueOf(typeName)
		val className = QualifiedName.create(list)
		return findType(className)
	}

	override isPackage(char[][] parentPackageName, char[] packageName) {
		if (packageName === null || packageName.length == 0) {
			return false;
		}
		// Mostly working hack
		return Character.isLowerCase(packageName.head)
	}
}	
 