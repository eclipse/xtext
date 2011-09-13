package org.eclipse.xtext.xbase.compiler

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.xbase.jvmmodel.IExpressionContextProvider

class JvmModelGenerator implements IGenerator {
	
	@Inject extension IExpressionContextProvider
	@Inject XbaseCompiler compiler
	
	override void doGenerate(Resource input, IFileSystemAccess fsa) {
		for (obj : input.contents) {
			obj.internalDoGenerate(fsa)
		}
	} 
	
	def dispatch void internalDoGenerate(EObject obj, IFileSystemAccess fsa) {}
	
	def dispatch void internalDoGenerate(JvmGenericType type, IFileSystemAccess fsa) {
		val importManager = new ImportManager(true, type.qualifiedName)
		val typeBody = generateBody(type, importManager)
		fsa.generateFile(type.qualifiedName.replace('.','/')+".java", 
			'''
			«IF type.packageName != null»package «type.packageName»;
			
			«ENDIF»
			«importManager.imports.map(i | "import "+i+";").join»
			
			«typeBody»
			'''
		)
	}
	
	def generateBody(JvmGenericType type, ImportManager importManager) '''
		«type.generateModifier»«IF type.interface»interface«ELSE»class«ENDIF» «type.simpleName» «type.generateExtendsClause(importManager)» {
			«FOR m : type.members»
				«m.generateMember(importManager)»
			«ENDFOR»
		}
	'''
	
	def dispatch generateModifier(JvmGenericType it) '''
		«visibility.javaName»«IF abstract»abstract «ENDIF»«IF final»final «ENDIF»«IF ^static»static «ENDIF»'''
	
	def dispatch generateModifier(JvmField it) '''
		«visibility.javaName»«IF final»final «ENDIF»«IF ^static»static «ENDIF»'''
		
	def dispatch generateModifier(JvmOperation it) '''
		«visibility.javaName»«IF abstract»abstract «ENDIF»«IF final»final «ENDIF»«IF ^static»static «ENDIF»'''
	
	def javaName(JvmVisibility visibility) {
		if (visibility != null)
			return switch visibility {
					case JvmVisibility::PRIVATE : 'private '
					case JvmVisibility::PUBLIC : 'public '
					case JvmVisibility::PROTECTED : 'protected '
					case JvmVisibility::DEFAULT : ''
				}
		else 
			return ''
	}
		
	def generateExtendsClause(JvmGenericType it, ImportManager importManager) {
		if (superTypes.empty)
			return null
		if (it.interface) {
			"extends "+superTypes.map( t | importManager.serialize(t)).join(", ")+" "
		} else {
			val withoutObject = superTypes.filter( typeRef | typeRef.identifier != "java.lang.Object")
			val superClazz = withoutObject.filter(typeRef | typeRef.type instanceof JvmGenericType && !(typeRef.type as JvmGenericType).interface).head
			val superInterfaces = withoutObject.filter(typeRef | typeRef != superClazz)
			var result = ""
			if (superClazz != null) {
				result = "extends " + importManager.serialize(superClazz)+" "
			} 
			if (!superInterfaces.empty) {
				result = result + "implements " + superInterfaces.map( t | importManager.serialize(t)).join(", ") + " "
			}
			return result
		}
	}
	
	def dispatch CharSequence generateMember(JvmMember it, ImportManager importManager) {
		throw new UnsupportedOperationException("generateMember not implemented for elements of type "+it)
	}
	
	def dispatch generateMember(JvmField it, ImportManager importManager) '''
		«it.generateModifier»«importManager.serialize(type)» «simpleName»;
	'''
	def dispatch generateMember(JvmOperation it, ImportManager importManager) '''
		«it.generateModifier»«if (returnType == null) 'void' else importManager.serialize(returnType)» «simpleName»(«it.parameters.map( p | p.generateParameter(importManager)).join(", ")»)«IF abstract»;«ELSE» {
			«it.generateBody(importManager).toString.trim»
		}«ENDIF»
	'''
	
	def generateParameter(JvmFormalParameter it, ImportManager importManager) {
		importManager.serialize(parameterType).toString + " " + simpleName
	}
		
	def CharSequence generateBody(JvmOperation op, ImportManager importManager) {
		val adapter = op.eAdapters.filter(typeof(CompilationStrategyAdapter)).head
		if (adapter != null) {
			return adapter.compilationStrategy.apply(importManager)			
		} else {
			val expression = op.associatedExpression
			if (expression != null) {
				val appendable = new StringBuilderBasedAppendable(importManager)
				appendable.declareVariable(op.declaringType, "this");
				compiler.compile(expression, appendable, op.returnType)
				return appendable.toString
			} else {
				return '''throw new UnsupportedOperationException("«op.simpleName» is not implemented");'''
			}
		}
	}
}