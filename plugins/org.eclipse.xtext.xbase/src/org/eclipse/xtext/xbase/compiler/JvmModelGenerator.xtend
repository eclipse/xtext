package org.eclipse.xtext.xbase.compiler

import com.google.inject.Inject
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmAnnotationValue
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue
import org.eclipse.xtext.common.types.JvmByteAnnotationValue
import org.eclipse.xtext.common.types.JvmCharAnnotationValue
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIntAnnotationValue
import org.eclipse.xtext.common.types.JvmLongAnnotationValue
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmShortAnnotationValue
import org.eclipse.xtext.common.types.JvmStringAnnotationValue
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmUpperBound
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.JvmVoid
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.trace.LocationData
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.util.ITextRegionWithLineInformation
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.util.TextRegionWithLineInformation
import org.eclipse.xtext.util.Wrapper
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions

/**
 * A generator implementation that processes the 
 * derived {@link org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer JVM model}
 * and produces the respective java code.
 */
class JvmModelGenerator implements IGenerator {
	
	static val LOG = Logger::getLogger(typeof(JvmModelGenerator))
	
	@Inject extension ILogicalContainerProvider
	@Inject extension TypeReferences 
	@Inject extension TreeAppendableUtil
	@Inject extension JvmTypeExtensions
	@Inject XbaseCompiler compiler
	@Inject TypeReferenceSerializer typeRefSerializer
	@Inject ILocationInFileProvider locationProvider
	@Inject IEObjectDocumentationProvider documentationProvider
	@Inject IJvmModelAssociations jvmModelAssociations
	@Inject JavaKeywords keywords
	
	override void doGenerate(Resource input, IFileSystemAccess fsa) {
		for (obj : input.contents) {
			obj.internalDoGenerate(fsa)
		}
	}
	
	
	def dispatch void internalDoGenerate(EObject obj, IFileSystemAccess fsa) {}
	
	def dispatch void internalDoGenerate(JvmDeclaredType type, IFileSystemAccess fsa) {
		if (DisableCodeGenerationAdapter::isDisabled(type))
			return;
		fsa.generateFile(type.qualifiedName.replace('.','/')+".java", type.generateType)
	}
	
	def CharSequence generateType(JvmDeclaredType type) {
		
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
	
	
	def dispatch generateBody(JvmGenericType it, ITreeAppendable appendable) {
		generateJavaDoc(appendable)
		val childAppendable = appendable.trace(it)
		generateAnnotations(childAppendable, true)
		generateModifier(childAppendable)
		if (isInterface) {
			childAppendable.append("interface ")
		} else {
			childAppendable.append("class ")
		}
		childAppendable.traceSignificant(it).append(simpleName)
		generateTypeParameterDeclaration(childAppendable)
		if (typeParameters.empty)
			childAppendable.append(" ")
		generateExtendsClause(childAppendable)
		childAppendable.append("{")
		val b = Wrapper::wrap(true)
		members.forEach [ 
			val memberAppendable = childAppendable.traceWithComments(it)
			memberAppendable.openScope
			b.set(generateMember(memberAppendable, b.get()))
			memberAppendable.closeScope
		]
		childAppendable.newLine.append("}")
		appendable.newLine
	}
	
	def dispatch generateBody(JvmEnumerationType it, ITreeAppendable appendable) {
		generateJavaDoc(appendable)
		generateAnnotations(appendable, true)
		generateModifier(appendable)
		appendable.append("enum ")
		appendable.traceSignificant(it).append(simpleName)
		appendable.append(" ")
		generateExtendsClause(appendable)
		appendable.append("{")
		val b = Wrapper::wrap(true)
		literals.forEach[b.set(generateEnumLiteral(appendable.trace(it), b.get()))]
		members.filter[!(it instanceof JvmEnumerationLiteral)].forEach [ b.set(generateMember(appendable.trace(it), b.get())) ]
		appendable.newLine.append("}").newLine
	}
	
	def dispatch generateBody(JvmAnnotationType it, ITreeAppendable appendable) {
		generateJavaDoc(appendable)
		generateAnnotations(appendable, true)
		generateModifier(appendable)
		appendable.append("@interface ")
		appendable.traceSignificant(it).append(simpleName)
		appendable.append(" {")
		for (operation : members.filter(typeof(JvmOperation))) {
			generateAnnotationMethod(operation, appendable)
		}
		appendable.newLine.append("}").newLine
	}
	
	def generateAnnotationMethod(JvmOperation it, ITreeAppendable appendable) {
		appendable.increaseIndentation.newLine
		appendable.openScope
		generateJavaDoc(appendable)
		val tracedAppendable = appendable.trace(it)
		generateAnnotations(tracedAppendable, true)
		generateModifier(tracedAppendable)
		returnType.serialize(tracedAppendable)
		tracedAppendable.append(" ")
		tracedAppendable.traceSignificant(it).append(simpleName)
		tracedAppendable.append("()")
		generateDefaultExpression(tracedAppendable)
		tracedAppendable.append(";")
		appendable.decreaseIndentation
		appendable.closeScope
	}
	
	def void generateDefaultExpression(JvmOperation it, ITreeAppendable appendable) {
		if (compilationStrategy != null) {
			appendable.append(" default ")
			appendable.increaseIndentation
			compilationStrategy.apply(appendable)
			appendable.decreaseIndentation
		} else {
			val expression = associatedExpression
			if (expression != null) {
				appendable.append(" default ")
				compiler.compileAsJavaExpression(expression, appendable, returnType)
			}
		}
	}
	
	def dispatch generateModifier(JvmDeclaredType it, ITreeAppendable appendable) {
		appendable.append(visibility.javaName)
		if (isAbstract)
			appendable.append("abstract ")
		if (isStatic)
			appendable.append("static ")
		if (isFinal)
			appendable.append("final ")
	}
	
	def dispatch generateModifier(JvmField it, ITreeAppendable appendable) {
		appendable.append(visibility.javaName)
		if (isFinal)
			appendable.append("final ")
		if (isStatic)
			appendable.append("static ")
	}
		
	def dispatch generateModifier(JvmOperation it, ITreeAppendable appendable) {
		appendable.append(visibility.javaName)
		if (isAbstract)
			appendable.append("abstract ")
		if (isStatic)
			appendable.append("static ")
		if (isFinal)
			appendable.append("final ")
	}
	
	def dispatch generateModifier(JvmConstructor it, ITreeAppendable appendable) {
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
		
	def void generateExtendsClause(JvmDeclaredType it, ITreeAppendable appendable) {
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
		if (it instanceof JvmGenericType && (it as JvmGenericType).isInterface) {
			commaDelimited.apply(superTypes, "extends")
		} else {
			val withoutObject = superTypes.filter( typeRef | typeRef.identifier != "java.lang.Object")
			val superClazz = withoutObject.filter(typeRef | typeRef.type instanceof JvmGenericType && !(typeRef.type as JvmGenericType).isInterface).head
			
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
	
	def boolean generateEnumLiteral(JvmEnumerationLiteral it, ITreeAppendable appendable, boolean first) {
		if (!first)
			appendable.append(",").newLine
		appendable.increaseIndentation.newLine
		generateJavaDoc(appendable)
		generateAnnotations(appendable, true)
		appendable.append(simpleName)
		// TODO: constructor args
		appendable.decreaseIndentation
		return false
	}
	
	def dispatch boolean generateMember(JvmMember it, ITreeAppendable appendable, boolean first) {
		throw new UnsupportedOperationException("generateMember not implemented for elements of type "+it)
	}
	
	def dispatch boolean generateMember(JvmGenericType it, ITreeAppendable appendable, boolean first) {
		appendable.increaseIndentation.newLine
		generateBody(it, appendable)
		appendable.decreaseIndentation
		return false
	}
	
	def dispatch boolean generateMember(JvmField it, ITreeAppendable appendable, boolean first) {
		appendable.increaseIndentation.newLine
		if (!first)
			appendable.newLine
		generateJavaDoc(appendable)
		val tracedAppendable = appendable.trace(it)
		generateAnnotations(tracedAppendable, true)
		generateModifier(tracedAppendable)
		type.serialize(tracedAppendable)
		tracedAppendable.append(" ")
		tracedAppendable.traceSignificant(it).append(simpleName)
		generateInitialization(tracedAppendable)
		tracedAppendable.append(";")
		appendable.decreaseIndentation
		return false
	}
	
	def dispatch boolean generateMember(JvmOperation it, ITreeAppendable appendable, boolean first) {
		appendable.increaseIndentation.newLine
		if (!first)
			appendable.newLine
		appendable.openScope
		generateJavaDoc(appendable)
		val tracedAppendable = appendable.trace(it)
		generateAnnotations(tracedAppendable, true)
		generateModifier(tracedAppendable)
		generateTypeParameterDeclaration(tracedAppendable)
		if (returnType == null) {
			tracedAppendable.append("void")
		} else {
			returnType.serialize(tracedAppendable)
		}
		tracedAppendable.append(" ")
		tracedAppendable.traceSignificant(it).append(simpleName)
		tracedAppendable.append("(")
		generateParameters(tracedAppendable)
		tracedAppendable.append(")")
		generateThrowsClause(tracedAppendable)
		if (isAbstract || !hasBody) {
			tracedAppendable.append(";")
		} else {
			tracedAppendable.append(" ")
			generateExecutableBody(tracedAppendable)
		}
		appendable.decreaseIndentation
		appendable.closeScope
		return false
	}
	
	def dispatch boolean generateMember(JvmConstructor it, ITreeAppendable appendable, boolean first) {
		if(!isSingleSyntheticDefaultConstructor) {
			appendable.increaseIndentation.newLine
			if (!first)
				appendable.newLine
			appendable.openScope
			generateJavaDoc(appendable)
			val tracedAppendable = appendable.trace(it)
			generateAnnotations(tracedAppendable, true)
			generateModifier(tracedAppendable)
			generateTypeParameterDeclaration(tracedAppendable)
			tracedAppendable.traceSignificant(it).append(simpleName)
			tracedAppendable.append("(")
			generateParameters(tracedAppendable)
			tracedAppendable.append(")")
			generateThrowsClause(tracedAppendable)
			tracedAppendable.append(" ")
			generateExecutableBody(tracedAppendable)
			appendable.decreaseIndentation
			appendable.closeScope
			return false
		}
		return first
	}
	
	def void generateInitialization(JvmField it, ITreeAppendable appendable) {
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
			}
		}
	}
		
	def void generateTypeParameterDeclaration(JvmTypeParameterDeclarator it, ITreeAppendable appendable) {
		if (!typeParameters.isEmpty) {
			appendable.append("<")
			typeParameters.head.generateTypeParameterDeclaration(appendable)
			typeParameters.tail.forEach[
				appendable.append(", ")
				generateTypeParameterDeclaration(appendable)
			]
			appendable.append("> ")
		}
	}
	
	def void generateTypeParameterDeclaration(JvmTypeParameter it, ITreeAppendable appendable) {
		val tracedAppendable = appendable.trace(it)
		tracedAppendable.traceSignificant(it).append(name)
		generateTypeParameterConstraints(tracedAppendable)
	}
	
	def void generateTypeParameterConstraints(JvmTypeParameter it, ITreeAppendable appendable) {
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
	
	def void generateThrowsClause(JvmExecutable it, ITreeAppendable appendable) {
		val seenExceptions = <JvmType>newHashSet
		if (!exceptions.empty) {
			appendable.append(" throws ")
			seenExceptions.add(exceptions.head.type)
			appendable.trace(exceptions.head).append(exceptions.head.type)
			exceptions.tail.forEach[ exception |
				if (seenExceptions.add(exception.type)) { 
					appendable.append(", ")
					appendable.trace(exception).append(exception.type)
				}
			]
		}
	}
	
	def void generateParameters(JvmExecutable it, ITreeAppendable appendable) {
		if (!parameters.isEmpty) {
			for (i : 0..parameters.size-1) {
				val last = i+1 == parameters.size
				val p = parameters.get(i)
				p.generateParameter(appendable, last && it.varArgs)
				if (!last)
					appendable.append(", ")
			}
		}
	}
	
	def void generateParameter(JvmFormalParameter it, ITreeAppendable appendable, boolean vararg) {
		val tracedAppendable = appendable.trace(it)
		generateAnnotations(tracedAppendable, false)
		tracedAppendable.append("final ")
		if (vararg) {
			(parameterType as JvmGenericArrayTypeReference).componentType.serialize(tracedAppendable)
			tracedAppendable.append("...");
		} else {
			parameterType.serialize(tracedAppendable)
		}
		tracedAppendable.append(" ")
		val name = tracedAppendable.declareVariable(it, makeJavaIdentifier(simpleName))
		tracedAppendable.traceSignificant(it).append(name)
	}
	
	def hasBody(JvmExecutable op) {
		op.compilationStrategy != null || op.associatedExpression != null
	}
		
	def void generateExecutableBody(JvmExecutable op, ITreeAppendable appendable) {
		if (op.compilationStrategy != null) {
			appendable.increaseIndentation.append("{").newLine
			op.compilationStrategy.apply(appendable)
			appendable.decreaseIndentation.newLine.append("}")
		} else {
			val expression = op.getAssociatedExpression
			if (expression != null) {
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
			} else if(op instanceof JvmOperation) {
				appendable.increaseIndentation.append("{").newLine
				appendable.append('throw new UnsupportedOperationException("')
				appendable.append(op.simpleName)
				appendable.append('is not implemented");')
				appendable.decreaseIndentation.newLine.append("}")
			} else if (op instanceof JvmConstructor) {
				appendable.append("{").newLine.append("}")
			}
		}
	}
	
	def void generateJavaDoc(EObject it, ITreeAppendable appendable) {
		val adapter = it.eAdapters.filter(typeof(DocumentationAdapter)).head
		if(!adapter?.documentation.nullOrEmpty) {
			// TODO we should track the source of the documentation in the documentation adapter
			val doc = '''/**''' as StringConcatenation;
			doc.newLine
			doc.append(" * ")
			doc.append(adapter.documentation, " * ")
			doc.newLine
			doc.append(" */")
			val sourceElements = jvmModelAssociations.getSourceElements(it)
			if (sourceElements.size == 1 && documentationProvider instanceof IEObjectDocumentationProviderExtension) {
				val documentationNodes = (documentationProvider as IEObjectDocumentationProviderExtension).getDocumentationNodes(sourceElements.head)
				if (!documentationNodes.empty) {
					var documentationTrace = ITextRegionWithLineInformation::EMPTY_REGION
					for(node: documentationNodes) {
						documentationTrace = documentationTrace.merge(new TextRegionWithLineInformation(node.offset, node.length, node.startLine, node.endLine)) 
					}
					appendable.trace(new LocationData(documentationTrace, null, null)).append(doc.toString)
					appendable.newLine
					return
				}
			} 
			appendable.append(doc.toString).newLine
		}
	} 
	
	def void generateAnnotations(JvmAnnotationTarget it, ITreeAppendable appendable, boolean withLineBreak) {
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
	
	def void generateAnnotations(JvmAnnotationAnnotationValue it, ITreeAppendable appendable, boolean withLineBreak) {
		if (!annotations.empty) {
			annotations.head.generateAnnotation(appendable)
			annotations.tail.forEach[
				if (withLineBreak) {
					appendable.newLine
				} else {
					appendable.append(", ")
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
	
	def void generateAnnotation(JvmAnnotationReference it, ITreeAppendable appendable) {
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
	 
	def void toJava(JvmAnnotationValue it, ITreeAppendable appendable) {
		if (operation != null) {
			appendable.append(operation.simpleName)
			appendable.append(" = ")
		} 
		toJavaLiteral(appendable)
	}
		
	def dispatch void toJavaLiteral(JvmAnnotationAnnotationValue it, ITreeAppendable appendable) {
		if (values.size != 1) {
			appendable.append("{ ")
			generateAnnotations(appendable, false)
			appendable.append("} ")
		} else {
			generateAnnotations(appendable, false)
		}
	}
		
	def dispatch void toJavaLiteral(JvmShortAnnotationValue it, ITreeAppendable appendable) {
		if (values.size == 1) {
			appendable.append(values.head.toString)			
		} else {
			appendable.append(values.join("{ ", ", ", " }", [toString]))
		}
	}
	
	def dispatch void toJavaLiteral(JvmIntAnnotationValue it, ITreeAppendable appendable) {
		if (values.size == 1) {
			appendable.append(values.head.toString)			
		} else {
			appendable.append(values.join("{ ", ", ", " }", [toString]))
		}
	}
	
	def dispatch void toJavaLiteral(JvmLongAnnotationValue it, ITreeAppendable appendable) {
		if (values.size == 1) {
			appendable.append(values.head.toString)			
		} else {
			appendable.append(values.join("{ ", ", ", " }", [toString]))
		}
	}
	
	def dispatch void toJavaLiteral(JvmByteAnnotationValue it, ITreeAppendable appendable) {
		if (values.size == 1) {
			appendable.append(values.head.toString)			
		} else {
			appendable.append(values.join("{ ", ", ", " }", [toString]))
		}
	}
	
	def dispatch void toJavaLiteral(JvmDoubleAnnotationValue it, ITreeAppendable appendable) {
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
	
	def dispatch void toJavaLiteral(JvmFloatAnnotationValue it, ITreeAppendable appendable) {
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
	
	def dispatch void toJavaLiteral(JvmCharAnnotationValue it, ITreeAppendable appendable) {
		if (values.size == 1) {
			appendable.append("'" + Strings::convertToJavaString(values.head.toString, true) + "'")			
		} else {
			appendable.append(values.join("{ ", ", ", " }", ["'" + Strings::convertToJavaString(it.toString, true) + "'"]))
		}
	}
		
	def dispatch void toJavaLiteral(JvmStringAnnotationValue it, ITreeAppendable appendable) {
		if (values.size == 1) {
			appendable.append('"' + Strings::convertToJavaString(values.head, true) + '"')			
		} else {
			appendable.append(values.join("{ ", ", ", " }", ['"' + Strings::convertToJavaString(it, true) + '"']))
		}
	}
		
	def dispatch void toJavaLiteral(JvmTypeAnnotationValue it, ITreeAppendable appendable) {
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
	
	def dispatch void toJavaLiteral(JvmEnumAnnotationValue it, ITreeAppendable appendable) {
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
		
	def dispatch void toJavaLiteral(JvmBooleanAnnotationValue it, ITreeAppendable appendable) {
		if (values.size == 1) {
			appendable.append(values.head.toString)			
		} else {
			appendable.append(values.join("{ ", ", ", " }", [toString]))
		}
	} 
	
	def dispatch void toJavaLiteral(JvmCustomAnnotationValue it, ITreeAppendable appendable) {
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
	
	def void serialize(JvmTypeReference it, ITreeAppendable appendable) {
		if (it == null) {
			LOG.warn("type was null", new NullPointerException)
			appendable.append("Object /* problem during compilation, see error log*/")			
		} else {
			typeRefSerializer.serialize(it, it.eContainer, appendable)
		}
	}
	
	def TreeAppendable createAppendable(EObject context, ImportManager importManager) {
		val appendable = new TreeAppendable(importManager, locationProvider, jvmModelAssociations, context, "  ", "\n")
		val type = context.containerType
		if( type != null) {
			appendable.declareVariable(context.containerType, "this")
			val superType = context.containerType.extendedClass
			if (superType != null)
				appendable.declareVariable(superType.type, "super")
		}
		return appendable
	}
	
	def JvmGenericType containerType(EObject context) {
		if(context == null) 
			null
		else if(context instanceof JvmGenericType)
			context as JvmGenericType
		else containerType(context.eContainer)
	}
	
	def protected String makeJavaIdentifier(String name) {
		if (keywords.isJavaKeyword(name)) {
			name+"_"
		} else {
			name
		}
	}
	
}