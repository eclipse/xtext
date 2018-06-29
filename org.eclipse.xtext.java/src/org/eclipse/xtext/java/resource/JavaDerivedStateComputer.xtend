package org.eclipse.xtext.java.resource

import com.google.inject.Inject
import java.util.Arrays
import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
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
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader
import org.eclipse.xtext.resource.IResourceDescriptionsProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.JavaVersion
import org.eclipse.xtext.util.internal.Log

@Log
class JavaDerivedStateComputer {
	
	@Inject IReferableElementsUnloader unloader;
	@Inject EObjectDescriptionBasedStubGenerator stubGenerator
	@Inject IResourceDescriptionsProvider resourceDescriptionsProvider
	@Inject IQualifiedNameConverter qualifiedNameConverter
	
	def discardDerivedState(Resource resource) {
		var EList<EObject> resourcesContentsList=resource.getContents() 
		for (eObject : resourcesContentsList) {
			unloader.unloadRoot(eObject) 
		}
		resource.getContents().clear 
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
		// TODO use container manager
		val nameEnv = new IndexAwareNameEnvironment(resource, classLoader, data, stubGenerator, classFileCache)
		val compiler = new Compiler(nameEnv, DefaultErrorHandlingPolicies.proceedWithAllProblems(), resource.compilerOptions, [
			for (cls : it.classFiles) {
				// TODO What is with inner classes (they contain $)
				// TODO is there a better way to obtain the class name
				val key = qualifiedNameConverter.toQualifiedName(new String(cls.fileName).replace("/","."))
				if (!classFileCache.containsKey(key)) {
					classFileCache.put(key, new ClassFileReader(cls.bytes,cls.fileName))
				}
			}
			if (Arrays.equals(it.fileName, compilationUnit.fileName)) {
				val map = newHashMap
				var List<String> topLevelTypes = newArrayList
				for (cf : it.getClassFiles()) {
					val className = cf.compoundName.map[String.valueOf(it)].join('.')
					map.put(className, cf.bytes)
					if (!cf.isNestedType) {
						topLevelTypes += className
					}
				}
				val inMemClassLoader = new InMemoryClassLoader(map, classLoader)
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
			}
		], new DefaultProblemFactory())
		compiler.compile(#[compilationUnit])
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
            LOG.warn("The java source language has been configured with Java 7. JDT will not produce signature information for generic @Override methods in this version, which might lead to follow up issues.")
        }
        val sourceLevel = sourceVersion.toJdtVersion
        val targetLevel = targetVersion.toJdtVersion
        val compilerOptions = new CompilerOptions
        compilerOptions.targetJDK = targetLevel
        compilerOptions.inlineJsrBytecode = true
        compilerOptions.sourceLevel = sourceLevel
        compilerOptions.produceMethodParameters = true
        compilerOptions.produceReferenceInfo = true
        // these fields have been introduces in JDT 3.7
        try {
            CompilerOptions.getField("originalSourceLevel").setLong(compilerOptions, targetLevel)
        } catch (NoSuchFieldException e) {
            // ignore
        }
        compilerOptions.complianceLevel = sourceLevel
        // these fields have been introduces in JDT 3.7
        try {
            CompilerOptions.getField("originalComplianceLevel").setLong(compilerOptions, targetLevel)
        } catch (NoSuchFieldException e) {
            // ignore
        }
        return compilerOptions
    }

    protected def long toJdtVersion(JavaVersion version) {
        version.toJdtClassFileConstant
    }
	
	protected def ClassLoader getClassLoader(Resource it) {
		(resourceSet as XtextResourceSet).classpathURIContext as ClassLoader 
	}
	
}