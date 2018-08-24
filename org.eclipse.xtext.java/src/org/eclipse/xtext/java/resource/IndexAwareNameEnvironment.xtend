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

	Map<QualifiedName, NameEnvironmentAnswer> cache = newHashMap()
    
	override cleanup() {
		cache.clear
	}

	override findType(char[][] compoundTypeName) {
		val className = QualifiedName.create(compoundTypeName.map[String.valueOf(it)])
		return findType(className)
	}
	
	def NameEnvironmentAnswer findType(QualifiedName className) {
		if (classFileCache.containsKey(className)) {
			val t = classFileCache.get(className)
			// TODO is this ok?
			if (t===null) {
				return null
			}
			return new NameEnvironmentAnswer(t, null)
		}
		if (cache.containsKey(className)) {
			return cache.get(className)
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
				cache.put(className, null)
				//TODO is that ok
				classFileCache.put(className, null)
				return null;
			}
			// todo: try with resources/ close Stream
			var InputStream stream = null
			val IBinaryType reader = try {
				stream = url.openStream
				ClassFileReader.read(url.openStream, fileName)
				//TODO what if read fails
			} finally {
				if (stream !== null) {
					stream.close
				}
			}
			// TODO is this ok?
			// TODO what if reader is null
			if (reader === null) {
				return null;
			}
			classFileCache.put(className, reader)
			result = new NameEnvironmentAnswer(reader, null)
		}
		cache.put(className, result)
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
 