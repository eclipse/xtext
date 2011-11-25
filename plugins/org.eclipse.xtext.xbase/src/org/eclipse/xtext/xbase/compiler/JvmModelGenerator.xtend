package org.eclipse.xtext.xbase.compiler

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationValue
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmShortAnnotationValue
import org.eclipse.xtext.common.types.JvmStringAnnotationValue
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmUpperBound
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.eclipse.xtext.xbase.typing.ITypeProvider
import org.eclipse.xtend2.lib.StringConcatenation

/**
 * A generator implementation that processes the 
 * derived {@link org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer JVM model}
 * and produces the respective java code.
 */
class JvmModelGenerator implements IGenerator {
	
	@Inject extension ILogicalContainerProvider
	@Inject XbaseCompiler compiler
	@Inject extension ITypeProvider
	@Inject extension TypeReferences 
	@Inject TypeReferenceSerializer typeRefSerializer
	
	override void doGenerate(Resource input, IFileSystemAccess fsa) {
		for (obj : input.contents) {
			obj.internalDoGenerate(fsa)
		}
	} 
	
	def dispatch void internalDoGenerate(EObject obj, IFileSystemAccess fsa) {}
	
	def dispatch void internalDoGenerate(JvmGenericType type, IFileSystemAccess fsa) {
		fsa.generateFile(type.qualifiedName.replace('.','/')+".java", type.generateType)
	}
	
	def generateType(JvmGenericType type) {
		val importManager = new ImportManager(true, type)
		val typeBody = generateBody(type, importManager)
		'''
			«IF type.packageName != null»package «type.packageName»;
			
			«ENDIF»
			«FOR i: importManager.imports AFTER "\n"»
				import «i»;
			«ENDFOR»
			«typeBody»
		'''
	}
	
	def generateBody(JvmGenericType it, ImportManager importManager) '''
		«it.generateJavaDoc»
		«it.annotations.generateAnnotations(importManager)»
		«it.generateModifier»«IF it.interface»interface«ELSE»class«ENDIF» «it.simpleName»«generateTypeParameterDeclaration(it.typeParameters, importManager)» «it.generateExtendsClause(importManager)»{
		  «FOR memberCode : it.members.map(m|m.generateMember(importManager)).filter(c|c!=null) SEPARATOR '\n'»
		    «memberCode»
		  «ENDFOR»
		}
	'''
	
	def dispatch generateModifier(JvmGenericType it) '''
		«visibility.javaName»«IF abstract»abstract «ENDIF»«IF final»final «ENDIF»«IF ^static»static «ENDIF»'''
	
	def dispatch generateModifier(JvmField it) '''
		«visibility.javaName»«IF final»final «ENDIF»«IF ^static»static «ENDIF»'''
		
	def dispatch generateModifier(JvmOperation it) '''
		«visibility.javaName»«IF abstract»abstract «ENDIF»«IF final»final «ENDIF»«IF ^static»static «ENDIF»'''
	
	def dispatch generateModifier(JvmConstructor it) '''
		«visibility.javaName»'''
	
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
			"extends "+superTypes.map( t | t.serialize(importManager)).join(", ")+" "
		} else {
			val withoutObject = superTypes.filter( typeRef | typeRef.identifier != "java.lang.Object")
			val superClazz = withoutObject.filter(typeRef | typeRef.type instanceof JvmGenericType && !(typeRef.type as JvmGenericType).interface).head
			val superInterfaces = withoutObject.filter(typeRef | typeRef != superClazz)
			var result = ""
			if (superClazz != null) {
				result = "extends " + superClazz.serialize(importManager)+" "
			} 
			if (!superInterfaces.empty) {
				result = result + "implements " + superInterfaces.map( t | t.serialize(importManager)).join(", ") + " "
			}
			return result
		}
	}
	
	def dispatch CharSequence generateMember(JvmMember it, ImportManager importManager) {
		throw new UnsupportedOperationException("generateMember not implemented for elements of type "+it)
	}
	
	def dispatch generateMember(JvmField it, ImportManager importManager) '''
		«it.generateJavaDoc»
		«IF !annotations.empty»«it.annotations.generateAnnotations(importManager)»«ENDIF»
		«it.generateModifier»«type.serialize(importManager)» «simpleName»«it.generateInitialization(importManager)»;
	'''
	
	def dispatch generateMember(JvmOperation it, ImportManager importManager) '''
		«it.generateJavaDoc»
		«IF !annotations.empty»«it.annotations.generateAnnotations(importManager)»«ENDIF»
		«it.generateModifier»«generateTypeParameterDeclaration(it.typeParameters, importManager)»«if (returnType == null) 'void' else returnType.serialize(importManager)» «simpleName»(«it.parameters.map( p | p.generateParameter(importManager)).join(", ")»)«generateThrowsClause(it, importManager)»«IF abstract»;«ELSE» {
		  «it.generateBody(importManager)»
		}
		«ENDIF»
	'''
	
	def dispatch generateMember(JvmConstructor it, ImportManager importManager) {
		if(!parameters.empty || associatedExpression != null) '''
			«it.generateJavaDoc»
			«IF !annotations.empty»«it.annotations.generateAnnotations(importManager)»«ENDIF»
			«it.generateModifier»«simpleName»(«it.parameters.map( p | p.generateParameter(importManager)).join(", ")»)«generateThrowsClause(it, importManager)» {
			  «it.generateBody(importManager)»
			}
		''' else null
	}
	
	def CharSequence generateInitialization(JvmField it, ImportManager importManager) {
		val adapter = it.eAdapters.filter(typeof(CompilationStrategyAdapter)).head
		if (adapter != null) 
			" = " + adapter.compilationStrategy.apply(importManager)			
		else {
			val expression = associatedExpression
			if (expression != null) {
				val appendable = createAppendable(importManager)
				compiler.compileAsJavaExpression(expression, appendable, type)
				return " = " + appendable.toString
			} else {
				""
			}
		}
	}
	
	def generateTypeParameterDeclaration(List<JvmTypeParameter> typeParameters, ImportManager importManager) {
		'''«FOR it: typeParameters BEFORE '<' SEPARATOR ', ' AFTER '> '»«it.generateTypeParameterDeclaration(importManager)»«ENDFOR»'''
	}
	
	def generateTypeParameterDeclaration(JvmTypeParameter it, ImportManager importManager) {
		'''«importManager.serialize(it)»«it.generateTypeParameterConstraints(importManager)»'''
	}
	
	def generateTypeParameterConstraints(JvmTypeParameter it, ImportManager importManager) {
		'''«FOR it: constraints.filter(typeof(JvmUpperBound)) BEFORE " extends " SEPARATOR " & "»«typeReference.serialize(importManager)»«ENDFOR»'''
	}
	
	def generateThrowsClause(JvmExecutable it, ImportManager importManager) '''«
		FOR exc: it.exceptions BEFORE ' throws ' SEPARATOR ', '»«exc.serialize(importManager)»«ENDFOR
	»'''

	def generateParameter(JvmFormalParameter it, ImportManager importManager) {
		"final " + parameterType.serialize(importManager) + " " + simpleName
	}
		
	def CharSequence generateBody(JvmExecutable op, ImportManager importManager) {
		val adapter = op.eAdapters.filter(typeof(CompilationStrategyAdapter)).head
		if (adapter != null) {
			return adapter.compilationStrategy.apply(importManager)			
		} else {
			val expression = op.getAssociatedExpression
			if (expression != null) {
				val appendable = createAppendable(op, importManager)
				for(p: op.parameters) 
					appendable.declareVariable(p, p.simpleName)
				val returnType = switch(op) { 
					JvmOperation: op.returnType
					JvmConstructor: Void::TYPE.getTypeForName(op) 
					default: null
				};
				compiler.compile(expression, appendable, returnType, op.exceptions.toSet)
				return removeSurroundingCurlies(appendable.toString)
			} else {
				return '''throw new UnsupportedOperationException("«op.simpleName» is not implemented");'''
			}
		}
	}
	
	def String removeSurroundingCurlies(String code) {
		val result = code.trim
		if (result.startsWith("{\n") && result.endsWith("}"))
			return result.substring(2, result.length -1)
		if (result.startsWith("{") && result.endsWith("}"))
			return result.substring(1, result.length -1)
		return result
	}
	
	def generateJavaDoc(EObject it) {
		val adapter = it.eAdapters.filter(typeof(DocumentationAdapter)).head
		if(!adapter?.documentation.nullOrEmpty) {
			val doc = '''/**''' as StringConcatenation;
			doc.newLine
			doc.append(" * ")
			doc.append(adapter.documentation, " * ")
			doc.newLine
			doc.append(" */")
			doc.newLine
			return doc
		}
		else null
	} 
	
	def generateAnnotations(List<JvmAnnotationReference> annotations, ImportManager importManager) {
		if (annotations.empty)
			return null
		'''
		«FOR a : annotations»
			@«importManager.serialize(a.annotation)»«FOR value : a.values BEFORE '(' SEPARATOR ', ' AFTER ')'»«value.toJava(importManager)»«ENDFOR»
		«ENDFOR»
		'''
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
		'''«IF values.size==1»«values.head.serialize(importManager)».class«ELSE»{«values.map(t | t.serialize(importManager) + ".class").join(',')»}«ENDIF»'''
		
	def dispatch toJavaLiteral(JvmBooleanAnnotationValue it, ImportManager importManager) 
		'''«IF values.size==1»«values.head»«ELSE»{«values.join(',')»}«ENDIF»'''
	
	def dispatch toJavaLiteral(JvmCustomAnnotationValue it, ImportManager importManager) {
		val appendable = createAppendable(it, importManager)
		switch (values.size) {
			case 0: appendable.append("{}")
			case 1: compiler.toJavaExpression(values.head as XExpression, appendable)
			default: {
				appendable.append('{')
				compiler.toJavaExpression(values.head as XExpression, appendable)
				values.tail.filter(typeof(XExpression)).forEach [ appendable.append(",") compiler.toJavaExpression(it, appendable) ]
				appendable.append('}')
			}
		}			
		appendable.toString
	}
	
	def String serialize(JvmTypeReference it, ImportManager importManager) {
		val appendable = createAppendable(it, importManager)
		typeRefSerializer.serialize(it, it.eContainer, appendable)
		appendable.toString
	}
	
	def createAppendable(EObject context, ImportManager importManager) {
		val appendable = new StringBuilderBasedAppendable(importManager)
		val type = context.containerType
		if(type != null) {
			appendable.declareVariable(context.containerType, "this")
			val superType = context.containerType.extendedClass
			if (superType != null)
				appendable.declareVariable(superType.type, "super")
		}
		appendable
	}
	
	def JvmGenericType containerType(EObject context) {
		if(context == null) 
			null
		else if(context instanceof JvmGenericType)
			context as JvmGenericType
		else containerType(context.eContainer)
	}
}