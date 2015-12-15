package org.eclipse.xtext.java.resource

import com.google.inject.Inject
import java.util.Arrays
import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.jdt.internal.compiler.CompilationResult
import org.eclipse.jdt.internal.compiler.Compiler
import org.eclipse.jdt.internal.compiler.DefaultErrorHandlingPolicies
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants
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
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader
import org.eclipse.xtext.resource.IResourceDescriptionsProvider
import org.eclipse.xtext.resource.XtextResourceSet

class JavaDerivedStateComputer {
	
	@Inject IReferableElementsUnloader unloader;
	@Inject EObjectDescriptionBasedStubGenerator stubGenerator
	@Inject IResourceDescriptionsProvider resourceDescriptionsProvider
	
	def discardDerivedState(Resource resource) {
		var EList<EObject> resourcesContentsList=resource.getContents() 
		for (var int i=1 ; i < resourcesContentsList.size(); i++) {
			var EObject eObject = resourcesContentsList.get(i) 
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
				compilerOptions,
				new DefaultProblemFactory()), true)
		val compilationResult = new CompilationResult(compilationUnit, 0, 1, -1)
		val result = parser.dietParse(compilationUnit, compilationResult)
		for (type : result.types) {
			val packageName = result.currentPackage?.importName?.map[String.valueOf(it)]?.join('.')
			val jvmType = createType(type, packageName)
			resource.contents.add(jvmType)
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
			if (type.typeParameters != null) {
				for (typeParam : type.typeParameters) {
					val jvmTypeParam = TypesFactory.eINSTANCE.createJvmTypeParameter
					jvmTypeParam.name = String.valueOf(typeParam.name)
					jvmType.typeParameters += jvmTypeParam
				}
			}
		}
		if (type.memberTypes != null) {
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
	
	def void installFull(Resource resource) {
		if (resource.isInfoFile)
			return;
		val compilationUnit = getCompilationUnit(resource)
		val classLoader = getClassLoader(resource)
		
		val data = resourceDescriptionsProvider.getResourceDescriptions(resource.resourceSet)
		if (data == null)
			throw new IllegalStateException("no index installed")
		// TODO use container manager
		val nameEnv = new IndexAwareNameEnvironment(classLoader, data, stubGenerator)
		val compiler = new Compiler(nameEnv, DefaultErrorHandlingPolicies.proceedWithAllProblems(), getCompilerOptions(), [
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
					val builder = new JvmDeclaredTypeBuilder(new BinaryClass(topLevel, inMemClassLoader), new ClassFileBytesAccess(), inMemClassLoader)
					resource.contents += builder.buildType
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
		val jdkVersion = ClassFileConstants.JDK1_7;
		return new CompilerOptions => [ compilerOptions |
			compilerOptions.targetJDK = jdkVersion
			compilerOptions.inlineJsrBytecode = true
			compilerOptions.sourceLevel = jdkVersion
			// these fields have been introduces in JDT 3.7
			try {
				CompilerOptions.getField("originalSourceLevel").setLong(compilerOptions, jdkVersion)
			} catch (NoSuchFieldException e) {
				// ignore
			}
			compilerOptions.complianceLevel = jdkVersion
			// these fields have been introduces in JDT 3.7
			try {
				CompilerOptions.getField("originalComplianceLevel").setLong(compilerOptions, jdkVersion)
			} catch (NoSuchFieldException e) {
				// ignore
			}
		]
	}
	
	protected def ClassLoader getClassLoader(Resource it) {
		(resourceSet as XtextResourceSet).classpathURIContext as ClassLoader 
	}
	
}