package org.eclipse.xtext.java.resource

import com.google.inject.Inject
import java.util.Arrays
import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.jdt.core.compiler.CharOperation
import org.eclipse.jdt.internal.compiler.CompilationResult
import org.eclipse.jdt.internal.compiler.Compiler
import org.eclipse.jdt.internal.compiler.DefaultErrorHandlingPolicies
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions
import org.eclipse.jdt.internal.compiler.parser.Parser
import org.eclipse.jdt.internal.compiler.problem.DefaultProblemFactory
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.access.binary.BinaryClass
import org.eclipse.xtext.common.types.access.binary.asm.ClassFileBytesAccess
import org.eclipse.xtext.common.types.access.binary.asm.JvmDeclaredTypeBuilder
import org.eclipse.xtext.common.types.descriptions.EObjectDescriptionBasedStubGenerator
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader
import org.eclipse.xtext.resource.IResourceDescriptionsProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.JavaVersion
import org.eclipse.xtext.util.internal.Log
import java.util.Map
import java.util.HashSet

@Log
class JavaDerivedStateComputer {
	
	@Inject IReferableElementsUnloader unloader;
	@Inject EObjectDescriptionBasedStubGenerator stubGenerator
	@Inject IResourceDescriptionsProvider resourceDescriptionsProvider
	
	def discardDerivedState(Resource resource) {
		var EList<EObject> resourcesContentsList=resource.getContents() 
		for (eObject : resourcesContentsList) {
			unloader.unloadRoot(eObject) 
		}
		resource.getContents().clear
		
		if (resource.compilationUnit !== null) {
			val classFileCache = resource.resourceSet.findOrCreateClassFileCache
			classFileCache.addResourceToCompile(resource)
		}
	}
	
	def void installStubs(Resource resource) {
		if (resource.isInfoFile)
			return;
		val compilationUnit = getCompilationUnit(resource)
		val parser = new Parser(new ProblemReporter(
				DefaultErrorHandlingPolicies.proceedWithAllProblems(),
				resource.compilerOptions,
				new DefaultProblemFactory()), true)
		val compilationResult = new CompilationResult(compilationUnit, 0, 1, -1)
		val result = parser.dietParse(compilationUnit, compilationResult)
		
		if (result.types !== null) {
			for (type : result.types) {
				val packageName = result.currentPackage?.importName?.map[String.valueOf(it)]?.join('.')
				val jvmType = createType(type, packageName)
				resource.contents.add(jvmType)
			}
		}
	}
	
	def JvmDeclaredType createType(TypeDeclaration type, String packageName) {
		val jvmType = switch (TypeDeclaration.kind(type.modifiers)) {
			case TypeDeclaration.CLASS_DECL :
				TypesFactory.eINSTANCE.createJvmGenericType
			case TypeDeclaration.INTERFACE_DECL :
				TypesFactory.eINSTANCE.createJvmGenericType => [
					interface = true
				]
			case TypeDeclaration.ENUM_DECL :
				TypesFactory.eINSTANCE.createJvmEnumerationType
			case TypeDeclaration.ANNOTATION_TYPE_DECL :
				TypesFactory.eINSTANCE.createJvmAnnotationType
			default :
				throw new IllegalArgumentException("Cannot handle type "+type.toString)
		}
		jvmType.packageName = packageName
		jvmType.simpleName = String.valueOf(type.name)
		if (jvmType instanceof JvmGenericType) {
			if (type.typeParameters !== null) {
				for (typeParam : type.typeParameters) {
					val jvmTypeParam = TypesFactory.eINSTANCE.createJvmTypeParameter
					jvmTypeParam.name = String.valueOf(typeParam.name)
					jvmType.typeParameters += jvmTypeParam
				}
			}
		}
		if (type.memberTypes !== null) {
			for (nestedType : type.memberTypes) {
				val nested = createType(nestedType, null)
				jvmType.members += nested
			}
		}
		return jvmType
	}
	
	def getCompilationUnit(Resource resource) {
		(resource as JavaResource).getCompilationUnit()
	}
	
	protected def ClassFileCache findOrCreateClassFileCache(ResourceSet rs) {
		var cache = ClassFileCache.findInEmfObject(rs)
		if (cache === null) {
			cache = new ClassFileCache
			cache.attachToEmfObject(rs)
		}
		cache
	}
	
	def void installFull(Resource resource) {
		if (resource.isInfoFile)
			return;
		val classFileCache = resource.resourceSet.findOrCreateClassFileCache
		val compilationUnit = getCompilationUnit(resource)
		val classLoader = getClassLoader(resource)
		
		val data = resourceDescriptionsProvider.getResourceDescriptions(resource.resourceSet)
		if (data === null)
			throw new IllegalStateException("no index installed")
		
		val (List<String>, Map<String, byte[]>)=>void initializer = [ topLevelTypes, classMap |
			val inMemClassLoader = new InMemoryClassLoader(classMap, classLoader)
			for (topLevel : topLevelTypes) {
				try {
					val builder = new JvmDeclaredTypeBuilder(new BinaryClass(topLevel, inMemClassLoader),
						new ClassFileBytesAccess(), inMemClassLoader)
					val type = builder.buildType
					resource.contents += type
				} catch (Throwable t) {
					throw new IllegalStateException("could not load type '" + topLevel + "'", t)
				}
			}
		] 	
		val wasCached = classFileCache.popCompileResult(compilationUnit.fileName, initializer)
		
		if (!wasCached) {
			/*
			 * TODO use container manager to respect the exact class visibility semantics
			 * 
			 * E.g. we could create a proper classloader hierarchy according to the results of the container manager
			 * rather than flattening everything into a single classloader / name env.
			 */
			
			val unitsToCompile = new HashSet(classFileCache.drainResourcesToCompile.map[ it.compilationUnit ].toList)
			unitsToCompile.add(compilationUnit)
			
			val nameEnv = new IndexAwareNameEnvironment(resource, classLoader, data, stubGenerator, classFileCache)
			val compiler = new Compiler(nameEnv, DefaultErrorHandlingPolicies.proceedWithAllProblems(), resource.compilerOptions, [
				for (cls : it.classFiles) {
					val key = QualifiedName.create(CharOperation.toStrings(cls.compoundName))
					classFileCache.computeIfAbsent(key, [name|new ClassFileReader(cls.bytes, cls.fileName)])
				}
				val map = newHashMap
				var List<String> topLevelTypes = newArrayList
				for (cf : it.getClassFiles()) {
					val className = CharOperation.toString(cf.compoundName)
					map.put(className, cf.bytes)
					if (!cf.isNestedType) {
						topLevelTypes += className
					}
				}
				if (Arrays.equals(it.fileName, compilationUnit.fileName)) {
					initializer.apply(topLevelTypes, map)
				} else {
					classFileCache.addCompileResult(it.fileName, topLevelTypes, map)
				}
			], new DefaultProblemFactory())
			compiler.compile(unitsToCompile)
		}
	}
	
	protected def isInfoFile(Resource resource) {
		val name = resource.URI.trimFileExtension.lastSegment
		name == "package-info" || name == "module-info"
	}
	
	protected def CompilerOptions getCompilerOptions() {
		getCompilerOptions(null as JavaConfig)
	}

	protected def CompilerOptions getCompilerOptions(Resource resource) {
		resource?.resourceSet.compilerOptions
	}

	protected def CompilerOptions getCompilerOptions(ResourceSet resourceSet) {
		JavaConfig?.findInEmfObject(resourceSet).compilerOptions
	}

	protected def CompilerOptions getCompilerOptions(JavaConfig javaConfig) {
		val sourceVersion = javaConfig?.javaSourceLevel ?: JavaVersion.JAVA8
		val targetVersion = javaConfig?.javaTargetLevel ?: JavaVersion.JAVA8
		if (sourceVersion == JavaVersion.JAVA7) {
			LOG.warn(
				"The java source language has been configured with Java 7. JDT will not produce signature information for generic @Override methods in this version, which might lead to follow up issues.")
		}
		val sourceLevel = sourceVersion.toJdtVersion
		val targetLevel = targetVersion.toJdtVersion
		val compilerOptions = new CompilerOptions
		compilerOptions.targetJDK = targetLevel
		compilerOptions.inlineJsrBytecode = true
		compilerOptions.sourceLevel = sourceLevel
		compilerOptions.produceMethodParameters = true
		compilerOptions.produceReferenceInfo = true
		compilerOptions.originalSourceLevel = targetLevel
		compilerOptions.complianceLevel = sourceLevel
		compilerOptions.originalComplianceLevel = targetLevel
		return compilerOptions
	}

	protected def long toJdtVersion(JavaVersion version) {
		version.toJdtClassFileConstant
	}
	
	protected def ClassLoader getClassLoader(Resource it) {
		(resourceSet as XtextResourceSet).classpathURIContext as ClassLoader 
	}
	
}