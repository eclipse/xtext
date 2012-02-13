package org.eclipse.xtext.xbase.compiler

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.common.types.JvmAnnotationValue
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue
import org.eclipse.xtext.common.types.JvmByteAnnotationValue
import org.eclipse.xtext.common.types.JvmCharAnnotationValue
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmIntAnnotationValue
import org.eclipse.xtext.common.types.JvmLongAnnotationValue
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmShortAnnotationValue
import org.eclipse.xtext.common.types.JvmStringAnnotationValue
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmUpperBound
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.util.Wrapper
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.common.types.JvmVoid

/**
 * A generator implementation that processes the 
 * derived {@link org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer JVM model}
 * and produces the respective java code.
 */
class JvmModelGenerator implements IGenerator {
	
	@Inject extension ILogicalContainerProvider
	@Inject extension TypeReferences 
	@Inject XbaseCompiler compiler
	@Inject TypeReferenceSerializer typeRefSerializer
	@Inject ILocationInFileProvider locationProvider
	
	override void doGenerate(Resource input, IFileSystemAccess fsa) {
		for (obj : input.contents) {
			obj.internalDoGenerate(fsa)
		}
	}
	
	def dispatch void internalDoGenerate(EObject obj, IFileSystemAccess fsa) {}
	
	def dispatch void internalDoGenerate(JvmGenericType type, IFileSystemAccess fsa) {
		fsa.generateFile(type.qualifiedName.replace('.','/')+".java", type.generateType)
	}
	
	def CharSequence generateType(JvmGenericType type) {
		val importManager = new ImportManager(true, type)
		val bodyAppendable = createAppendable(type, importManager)
		generateBody(type, bodyAppendable)
		val importAppendable = createAppendable(type, importManager)
		if (type.packageName != null) {
			importAppendable.append("package ").append(type.packageName).append(";");
			importAppendable.newLine.newLine
		}
		for(i: importManager.imports) {
			importAppendable.append("import ").append(i).append(";").newLine
		}
		if (!importManager.imports.empty)
			importAppendable.newLine
		importAppendable.append(bodyAppendable)
		return importAppendable
	}
	
	def generateBody(JvmGenericType it, TracingAppendable appendable) {
		generateJavaDoc(appendable)
		generateAnnotations(appendable, true)
		generateModifier(appendable)
		if (interface) {
			appendable.append("interface ")
		} else {
			appendable.append("class ")
		}
		appendable.append(simpleName)
		generateTypeParameterDeclaration(appendable)
		appendable.append(" ")
		generateExtendsClause(appendable)
		appendable.append("{")
		val b = Wrapper::wrap(true)
		members.forEach [ b.set(generateMember(appendable.trace(it), b.get())) ]
		appendable.newLine.append("}").newLine
	}
	
	def dispatch generateModifier(JvmGenericType it, TracingAppendable appendable) {
		appendable.append(visibility.javaName)
		if (isAbstract)
			appendable.append("abstract ")
		if (isStatic)
			appendable.append("static ")
		if (isFinal)
			appendable.append("final ")
	}
	
	def dispatch generateModifier(JvmField it, TracingAppendable appendable) {
		appendable.append(visibility.javaName)
		if (isFinal)
			appendable.append("final ")
		if (isStatic)
			appendable.append("static ")
	}
		
	def dispatch generateModifier(JvmOperation it, TracingAppendable appendable) {
		appendable.append(visibility.javaName)
		if (isAbstract)
			appendable.append("abstract ")
		if (isStatic)
			appendable.append("static ")
		if (isFinal)
			appendable.append("final ")
	}
	
	def dispatch generateModifier(JvmConstructor it, TracingAppendable appendable) {
		appendable.append(visibility.javaName)
	}
	
	/**
	 * Returns the visibility modifier and a space as suffix if not empty
	 */
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
		
	def void generateExtendsClause(JvmGenericType it, TracingAppendable appendable) {
		if (superTypes.empty)
			return;
		val (Iterable<JvmTypeReference>, String)=>void commaDelimited = [ it, prefix | {
			if (empty)
				return;
			appendable.append(prefix).append(" ")
			head.serialize(appendable)
			tail.forEach[
				appendable.append(", ")
				serialize(appendable)
			]
			appendable.append(" ")
		}]
		if (it.interface) {
			commaDelimited.apply(superTypes, "extends")
		} else {
			val withoutObject = superTypes.filter( typeRef | typeRef.identifier != "java.lang.Object")
			val superClazz = withoutObject.filter(typeRef | typeRef.type instanceof JvmGenericType && !(typeRef.type as JvmGenericType).interface).head
			val superInterfaces = withoutObject.filter(typeRef | typeRef != superClazz)
			if (superClazz != null) {
				appendable.append("extends ")
				superClazz.serialize(appendable)
				appendable.append(" ")
			} 
			if (!superInterfaces.empty) {
				commaDelimited.apply(superInterfaces, "implements")
			}
		}
	}
	
	def dispatch boolean generateMember(JvmMember it, TracingAppendable appendable, boolean first) {
		throw new UnsupportedOperationException("generateMember not implemented for elements of type "+it)
	}
	
	def dispatch boolean generateMember(JvmField it, TracingAppendable appendable, boolean first) {
		appendable.increaseIndentation.newLine
		if (!first)
			appendable.newLine
		generateJavaDoc(appendable)
		generateAnnotations(appendable, true)
		generateModifier(appendable)
		type.serialize(appendable)
		appendable.append(" ")
		appendable.append(simpleName)
		generateInitialization(appendable)
		appendable.append(";")
		appendable.decreaseIndentation
		return false
	}
	
	def dispatch boolean generateMember(JvmOperation it, TracingAppendable appendable, boolean first) {
		appendable.increaseIndentation.newLine
		if (!first)
			appendable.newLine
		generateJavaDoc(appendable)
		generateAnnotations(appendable, true)
		generateModifier(appendable)
		generateTypeParameterDeclaration(appendable)
		if (returnType == null) {
			appendable.append("void")
		} else {
			returnType.serialize(appendable)
		}
		appendable.append(" ")
		appendable.append(simpleName)
		appendable.append("(")
		generateParameters(appendable)
		appendable.append(")")
		generateThrowsClause(appendable)
		if (isAbstract) {
			appendable.append(";")
		} else {
			appendable.append(" ")
			generateBody(appendable)
		}
		appendable.decreaseIndentation
		return false
	}
	
	def dispatch boolean generateMember(JvmConstructor it, TracingAppendable appendable, boolean first) {
		if(!parameters.empty || associatedExpression != null || compilationStrategy != null || declaringType.members.filter(typeof(JvmConstructor)).size != 1) {
			appendable.increaseIndentation.newLine
			if (!first)
				appendable.newLine
			generateJavaDoc(appendable)
			generateAnnotations(appendable, true)
			generateModifier(appendable)
			generateTypeParameterDeclaration(appendable)
			appendable.append(simpleName)
			appendable.append("(")
			generateParameters(appendable)
			appendable.append(")")
			generateThrowsClause(appendable)
			appendable.append(" ")
			generateBody(appendable)
			appendable.decreaseIndentation
			return false
		}
		return first
	}
	
	def void generateInitialization(JvmField it, TracingAppendable appendable) {
		if (compilationStrategy != null) {
			appendable.append(" = ")
			appendable.increaseIndentation
			compilationStrategy.apply(appendable)
			appendable.decreaseIndentation
		} else {
			val expression = associatedExpression
			if (expression != null) {
				appendable.append(" = ")
				compiler.compileAsJavaExpression(expression, appendable, type)
			} else {
				""
			}
		}
	}
	
	def void generateTypeParameterDeclaration(JvmTypeParameterDeclarator it, TracingAppendable appendable) {
		if (!typeParameters.isEmpty) {
			appendable.append("<")
			typeParameters.head.generateTypeParameterDeclaration(appendable)
			typeParameters.tail.forEach[
				appendable.append(", ")
				generateTypeParameterDeclaration(appendable)
			]
			appendable.append(">")
		}
	}
	
	def void generateTypeParameterDeclaration(JvmTypeParameter it, TracingAppendable appendable) {
		appendable.append(name)
		generateTypeParameterConstraints(appendable)
	}
	
	def void generateTypeParameterConstraints(JvmTypeParameter it, TracingAppendable appendable) {
		val upperBounds = constraints.filter(typeof(JvmUpperBound))
		if (!upperBounds.empty) {
			appendable.append(" extends ")
			upperBounds.head.typeReference.serialize(appendable)
			upperBounds.tail.forEach[
				appendable.append(" & ")
				typeReference.serialize(appendable)
			]
		}
	}
	
	def void generateThrowsClause(JvmExecutable it, TracingAppendable appendable) {
		val allExceptions = exceptions.map([type]).toSet
		if (!allExceptions.empty) {
			appendable.append(" throws ")
			appendable.append(allExceptions.head)
			allExceptions.tail.forEach[ exception | {
				appendable.append(", ")
				appendable.append(exception)
			}]
		}
	}
	
	def void generateParameters(JvmExecutable it, TracingAppendable appendable) {
		if (!parameters.isEmpty) {
			parameters.head.generateParameter(appendable)
			parameters.tail.forEach[
				appendable.append(", ")
				generateParameter(appendable)
			]
		}
	}
	
	def void generateParameter(JvmFormalParameter it, TracingAppendable appendable) {
		generateAnnotations(appendable, false)
		appendable.append("final ")
		parameterType.serialize(appendable)
		appendable.append(" ")
		appendable.append(simpleName)
	}
		
	def void generateBody(JvmExecutable op, TracingAppendable appendable) {
		if (op.compilationStrategy != null) {
			appendable.openScope
			appendable.increaseIndentation.append("{").newLine
			op.compilationStrategy.apply(appendable)
			appendable.decreaseIndentation.newLine.append("}")
			appendable.closeScope			
		} else {
			val expression = op.getAssociatedExpression
			if (expression != null) {
				appendable.openScope
				for(p: op.parameters) 
					appendable.declareVariable(p, p.simpleName)
				val returnType = switch(op) { 
					JvmOperation: op.returnType
					JvmConstructor: Void::TYPE.getTypeForName(op) 
					default: null
				}
				if (expression instanceof XBlockExpression && (expression as XBlockExpression).expressions.size != 1 && returnType instanceof JvmVoid) {
					val block = expression as XBlockExpression
					if (block.expressions.isEmpty()) {
						appendable.append("{}")		
					} else {
						compiler.compile(expression, appendable, returnType, op.exceptions.toSet)
					}
				} else {
					appendable.append("{").increaseIndentation
					compiler.compile(expression, appendable, returnType, op.exceptions.toSet)
					appendable.decreaseIndentation.newLine.append("}")
				}
				appendable.closeScope
			} else if(op instanceof JvmOperation) {
				appendable.increaseIndentation.append("{").newLine
				appendable.append('throw new UnsupportedOperationException("')
				appendable.append(op.simpleName)
				appendable.append('is not implemented");')
				appendable.decreaseIndentation.newLine.append("}")
			}
		}
	}
	
	def void generateJavaDoc(EObject it, TracingAppendable appendable) {
		val adapter = it.eAdapters.filter(typeof(DocumentationAdapter)).head
		if(!adapter?.documentation.nullOrEmpty) {
			val doc = '''/**''' as StringConcatenation;
			doc.newLine
			doc.append(" * ")
			doc.append(adapter.documentation, " * ")
			doc.newLine
			doc.append(" */")
			appendable.append(doc.toString).newLine
		}
	} 
	
	def void generateAnnotations(JvmAnnotationTarget it, TracingAppendable appendable, boolean withLineBreak) {
		if (!annotations.empty) {
			annotations.head.generateAnnotation(appendable)
			annotations.tail.forEach[
				if (withLineBreak) {
					appendable.newLine
				} else {
					appendable.append(" ")
				}
				generateAnnotation(appendable)
			]
			if (withLineBreak) {
				appendable.newLine
			} else {
				appendable.append(" ")
			}
		}
	}
	
	def void generateAnnotation(JvmAnnotationReference it, TracingAppendable appendable) {
		appendable.append("@")
		appendable.append(annotation)
		if (!values.empty) {
			appendable.append("(")
			values.head.toJava(appendable)
			values.tail.forEach[
				appendable.append(", ")
				toJava(appendable)
			]
			appendable.append(")")
		}
	}
	 
	def void toJava(JvmAnnotationValue it, TracingAppendable appendable) {
		if (operation != null) {
			appendable.append(operation.simpleName)
			appendable.append(" = ")
		} 
		toJavaLiteral(appendable)
	}
		
	def dispatch void toJavaLiteral(JvmAnnotationAnnotationValue it, TracingAppendable appendable) {
		if (values.size != 1) {
			appendable.append("{ ")
			generateAnnotations(appendable, false)
			appendable.append("} ")
		} else {
			generateAnnotations(appendable, false)
		}
	}
		
	def dispatch void toJavaLiteral(JvmShortAnnotationValue it, TracingAppendable appendable) {
		if (values.size == 1) {
			appendable.append(values.head.toString)			
		} else {
			appendable.append(values.join("{ ", ", ", " }", [toString]))
		}
	}
	
	def dispatch void toJavaLiteral(JvmIntAnnotationValue it, TracingAppendable appendable) {
		if (values.size == 1) {
			appendable.append(values.head.toString)			
		} else {
			appendable.append(values.join("{ ", ", ", " }", [toString]))
		}
	}
	
	def dispatch void toJavaLiteral(JvmLongAnnotationValue it, TracingAppendable appendable) {
		if (values.size == 1) {
			appendable.append(values.head.toString)			
		} else {
			appendable.append(values.join("{ ", ", ", " }", [toString]))
		}
	}
	
	def dispatch void toJavaLiteral(JvmByteAnnotationValue it, TracingAppendable appendable) {
		if (values.size == 1) {
			appendable.append(values.head.toString)			
		} else {
			appendable.append(values.join("{ ", ", ", " }", [toString]))
		}
	}
	
	def dispatch void toJavaLiteral(JvmDoubleAnnotationValue it, TracingAppendable appendable) {
		if (values.size == 1) {
			appendable.append(values.head.toString)			
		} else {
			appendable.append(values.join("{ ", ", ", " }", [
				switch(it) {
					case Double::isNaN(it) : "Double.NaN"
					case Double::POSITIVE_INFINITY : "Double.POSITIVE_INFINITY" 
					case Double::NEGATIVE_INFINITY : "Double.NEGATIVE_INFINITY"
					default: toString + "d" 
				}
			]))
		}
	}
	
	def dispatch void toJavaLiteral(JvmFloatAnnotationValue it, TracingAppendable appendable) {
		if (values.size == 1) {
			appendable.append(values.head.toString)			
		} else {
			appendable.append(values.join("{ ", ", ", " }", [
				switch(it) {
					case Float::isNaN(it) : "Float.NaN"
					case Float::POSITIVE_INFINITY : "Float.POSITIVE_INFINITY" 
					case Float::NEGATIVE_INFINITY : "Float.NEGATIVE_INFINITY"
					default: toString + "f" 
				}
			]))
		}
	}
	
	def dispatch void toJavaLiteral(JvmCharAnnotationValue it, TracingAppendable appendable) {
		if (values.size == 1) {
			appendable.append("'" + Strings::convertToJavaString(values.head.toString, true) + "'")			
		} else {
			appendable.append(values.join("{ ", ", ", " }", ["'" + Strings::convertToJavaString(it.toString, true) + "'"]))
		}
	}
		
	def dispatch void toJavaLiteral(JvmStringAnnotationValue it, TracingAppendable appendable) {
		if (values.size == 1) {
			appendable.append('"' + Strings::convertToJavaString(values.head, true) + '"')			
		} else {
			appendable.append(values.join("{ ", ", ", " }", ['"' + Strings::convertToJavaString(it, true) + '"']))
		}
	}
		
	def dispatch void toJavaLiteral(JvmTypeAnnotationValue it, TracingAppendable appendable) {
		if (values.size != 1) {
			appendable.append("{ ")
			if (!values.isEmpty()) {
				appendable.append(values.head.type)
				appendable.append(".class")
				values.tail.forEach[
					appendable.append(", ")
					appendable.append(type)
					appendable.append(".class")
				]
			}
			appendable.append(" }")
		} else {
			appendable.append(values.head.type)
			appendable.append(".class")
		}
	} 
	
	def dispatch void toJavaLiteral(JvmEnumAnnotationValue it, TracingAppendable appendable) {
		if (values.size != 1) {
			appendable.append("{ ")
			if (!values.isEmpty()) {
				appendable.append(values.head.declaringType)
				appendable.append(".")
				appendable.append(values.head.simpleName)
				values.tail.forEach[
					appendable.append(", ")
					appendable.append(declaringType)
					appendable.append(".")
					appendable.append(simpleName)
				]
			}
			appendable.append(" }")
		} else {
			appendable.append(values.head.declaringType)
			appendable.append(".")
			appendable.append(values.head.simpleName)
		}
	} 
		
	def dispatch void toJavaLiteral(JvmBooleanAnnotationValue it, TracingAppendable appendable) {
		if (values.size == 1) {
			appendable.append(values.head.toString)			
		} else {
			appendable.append(values.join("{ ", ", ", " }", [toString]))
		}
	} 
	
	def dispatch void toJavaLiteral(JvmCustomAnnotationValue it, TracingAppendable appendable) {
		switch (values.size) {
			case 0: appendable.append("{}")
			case 1: compiler.toJavaExpression(values.head as XExpression, appendable)
			default: {
				appendable.append('{ ')
				compiler.toJavaExpression(values.head as XExpression, appendable)
				values.tail.filter(typeof(XExpression)).forEach [ appendable.append(", ") compiler.toJavaExpression(it, appendable) ]
				appendable.append(' }')
			}
		}			
	}
	
	def compilationStrategy(JvmIdentifiableElement it) {
		val adapter = eAdapters.filter(typeof(CompilationStrategyAdapter)).head
		if (adapter != null) 
			adapter.compilationStrategy
		else 
			null
	}
	
	def String serialize(JvmTypeReference it, TracingAppendable appendable) {
		typeRefSerializer.serialize(it, it.eContainer, appendable)
		appendable.toString
	}
	
	def TracingAppendable createAppendable(EObject context, ImportManager importManager) {
		val appendable = new StringBuilderBasedAppendable(importManager)
		val type = context.containerType
		if(type != null) {
			appendable.declareVariable(context.containerType, "this")
			val superType = context.containerType.extendedClass
			if (superType != null)
				appendable.declareVariable(superType.type, "super")
		}
		return new TracingAppendable(appendable, locationProvider, context)
	}
	
	def JvmGenericType containerType(EObject context) {
		if(context == null) 
			null
		else if(context instanceof JvmGenericType)
			context as JvmGenericType
		else containerType(context.eContainer)
	}
	
}