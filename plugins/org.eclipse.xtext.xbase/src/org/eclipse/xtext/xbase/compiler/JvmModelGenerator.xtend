package org.eclipse.xtext.xbase.compiler

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationValue
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmShortAnnotationValue
import org.eclipse.xtext.common.types.JvmStringAnnotationValue
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.xbase.jvmmodel.IExpressionContextProvider

class JvmModelGenerator implements IGenerator {
	
	@Inject extension org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
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
			«importManager.imports.map(i | "import "+i+";").join("\n")»
			
			«typeBody»
			'''
		)
	}
	
	def generateBody(JvmGenericType type, ImportManager importManager) '''
		«type.annotations.generateAnnotations(importManager)»
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
			val expression = op.getAssociatedExpression
			if (expression != null) {
				val appendable = new StringBuilderBasedAppendable(importManager)
				appendable.declareVariable(op.declaringType, "this");
				compiler.compile(expression, appendable, op.returnType)
				return removeSurroundingCurlies(appendable.toString)
			} else {
				return '''throw new UnsupportedOperationException("«op.simpleName» is not implemented");'''
			}
		}
	}
	
	def String removeSurroundingCurlies(String code) {
		val result = code.trim
		if (result.startsWith("{") && result.endsWith("}"))
			return result.substring(1, result.length -1)
		return result
	}
	
	def generateAnnotations(List<JvmAnnotationReference> annotations, ImportManager importManager) {
		if (annotations.empty)
			return null
		'''«FOR a : annotations»
			@«importManager.serialize(a.annotation)»(«FOR value : a.values SEPARATOR ','»«value.toJava(importManager)»«ENDFOR»)
		«ENDFOR»'''
	}
	
	def toJava(JvmAnnotationValue it, ImportManager importManager) 
		'''«IF operation != null»«operation.simpleName» = «ENDIF»«it.toJavaLiteral(importManager)»'''
		
	def dispatch toJavaLiteral(JvmAnnotationAnnotationValue it, ImportManager importManager) 
		'''«it.annotations.generateAnnotations(importManager)»'''
		
	def dispatch toJavaLiteral(JvmShortAnnotationValue it, ImportManager importManager) 
		'''«IF values.size==1»«values.head»«ELSE»{«values.join(',')»}«ENDIF»'''
		
	def dispatch toJavaLiteral(JvmStringAnnotationValue it, ImportManager importManager) 
		'''«IF values.size==1»"«values.head»"«ELSE»{«values.map(s | '"'+s+'"').join(',')»}«ENDIF»'''
		
	def dispatch toJavaLiteral(JvmTypeAnnotationValue it, ImportManager importManager) 
		'''«IF values.size==1»«importManager.serialize(values.head)»«ELSE»{«values.map(t | importManager.serialize(t)).join(',')»}«ENDIF»'''
		
	def dispatch toJavaLiteral(JvmBooleanAnnotationValue it, ImportManager importManager) 
		'''«IF values.size==1»«values.head»«ELSE»{«values.join(',')»}«ENDIF»'''
		
}