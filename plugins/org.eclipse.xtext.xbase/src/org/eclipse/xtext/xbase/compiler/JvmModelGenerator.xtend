/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler

import com.google.inject.Inject
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
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions
import static org.eclipse.xtext.util.Strings.*
import org.eclipse.xtext.validation.Issue
import org.apache.log4j.Logger

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
	@Inject extension LoopExtensions
	@Inject extension ErrorSafeExtensions
	
	@Inject XbaseCompiler compiler
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
		if(type.qualifiedName != null)
			fsa.generateFile(type.qualifiedName.replace('.', '/') + '.java', type.generateType)
	}
	
	def CharSequence generateType(JvmDeclaredType type) {
		val importManager = new ImportManager(true, type)
		val bodyAppendable = createAppendable(type, importManager)
		generateBody(type, bodyAppendable)
		val importAppendable = createAppendable(type, importManager)
		if (type.packageName != null) {
            generateFileHeader(type, importAppendable)
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
		childAppendable.append('{').increaseIndentation
		childAppendable.forEach(membersToBeCompiled, [
				separator = [ITreeAppendable it | newLine]
			], [
				val memberAppendable = childAppendable.traceWithComments(it)
				memberAppendable.openScope
				generateMember(memberAppendable)
				memberAppendable.closeScope
			])
		childAppendable.decreaseIndentation.newLine.append('}')
		appendable.newLine
	}
	
	def dispatch generateBody(JvmEnumerationType it, ITreeAppendable appendable) {
		generateJavaDoc(appendable)
		val childAppendable = appendable.trace(it)
		generateAnnotations(childAppendable, true)
		generateModifier(childAppendable)
		childAppendable.append("enum ")
		childAppendable.traceSignificant(it).append(simpleName)
		childAppendable.append(" ")
		generateExtendsClause(childAppendable)
		childAppendable.append("{").increaseIndentation
		childAppendable.forEach(literals, [
				separator = [ITreeAppendable it | append(',').newLine]  suffix = ';'
			], [
				generateEnumLiteral(childAppendable.trace(it))
			])
		childAppendable.forEach(membersToBeCompiled.filter[!(it instanceof JvmEnumerationLiteral)], [
				separator = [ITreeAppendable it | newLine]
			], [ 
				generateMember(childAppendable.trace(it)) 
			])
		childAppendable.decreaseIndentation.newLine.append("}")
		appendable.newLine
	}
	
	def void generateEnumLiteral(JvmEnumerationLiteral it, ITreeAppendable appendable) {
		appendable.increaseIndentation.newLine
		generateJavaDoc(appendable)
		generateAnnotations(appendable, true)
		appendable.append(simpleName)
		// TODO: constructor args
		appendable.decreaseIndentation
	}
	
	def dispatch generateBody(JvmAnnotationType it, ITreeAppendable appendable) {
		generateJavaDoc(appendable)
		val childAppendable = appendable.trace(it)
		generateAnnotations(childAppendable, true)
		generateModifier(childAppendable)
		childAppendable.append("@interface ")
		childAppendable.traceSignificant(it).append(simpleName)
		childAppendable.append(" {")
		for (operation : members.filter(typeof(JvmOperation))) {
			generateAnnotationMethod(operation, childAppendable)
		}
		childAppendable.newLine.append("}")
		appendable.newLine
	}
	
	def generateAnnotationMethod(JvmOperation it, ITreeAppendable appendable) {
		appendable.increaseIndentation.newLine
		appendable.openScope
		generateJavaDoc(appendable)
		val tracedAppendable = appendable.trace(it)
		generateAnnotations(tracedAppendable, true)
		generateModifier(tracedAppendable)
		returnType.serializeSafely("Object", tracedAppendable)
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
				if(expression.hasErrors(true)) {
					appendable.append("/* skipped default expression with errors */")
				} else {
					appendable.append(" default ")
					compiler.compileAsJavaExpression(expression, appendable, returnType)
				}
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
		if (it instanceof JvmGenericType && (it as JvmGenericType).isInterface) {
			appendable.forEachSafely(superTypes, [
					prefix = 'extends '	separator =  ', ' suffix =  ' '
				], [
					it, app | serializeSafely(app)
				])
		} else {
			val withoutObject = superTypes.filter( typeRef | typeRef.identifier != "java.lang.Object")
			val superClazz = withoutObject.filter(typeRef | typeRef.type instanceof JvmGenericType && !(typeRef.type as JvmGenericType).isInterface).head
			val superInterfaces = withoutObject.filter(typeRef | typeRef != superClazz)
			if (superClazz != null) {
				val hasErrors = superClazz.hasErrors(true)
				if(hasErrors) 
					appendable.append('/* ')
				try {
					appendable.append('extends ')
					superClazz.serializeSafely(appendable)
					appendable.append(' ')
				} catch (Exception ignoreMe) {}
				if(hasErrors) 
					appendable.append(' */')
			} 
			appendable.forEachSafely(superInterfaces, [
					prefix = 'implements ' separator = ', ' suffix = ' '
				], [
					it, app | serializeSafely(app)
				])
		}
	}
	
	def dispatch ITreeAppendable generateMember(JvmMember it, ITreeAppendable appendable) {
		throw new UnsupportedOperationException("generateMember not implemented for elements of type "
			+ it?.^class?.name
		)
	}
	
	def dispatch generateMember(JvmGenericType it, ITreeAppendable appendable) {
		appendable.newLine
		generateBody(it, appendable)
	}
	
	def dispatch generateMember(JvmField it, ITreeAppendable appendable) {
		appendable.newLine
		generateJavaDoc(appendable)
		val tracedAppendable = appendable.trace(it)
		generateAnnotations(tracedAppendable, true)
		generateModifier(tracedAppendable)
		type.serializeSafely("Object", tracedAppendable)
		tracedAppendable.append(" ")
		tracedAppendable.traceSignificant(it).append(simpleName)
		generateInitialization(tracedAppendable)
		tracedAppendable.append(";")
	}
	
	def dispatch generateMember(JvmOperation it, ITreeAppendable appendable) {
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
			returnType.serializeSafely("Object", tracedAppendable)
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
		appendable.closeScope
		appendable
	}
	
	def dispatch generateMember(JvmConstructor it, ITreeAppendable appendable) {
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
		appendable.closeScope
		appendable
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
				if(expression.hasErrors(true)) {
					appendable.append(" /* Skipped initializer because of errors */")
				} else {
					appendable.append(" = ")
					compiler.compileAsJavaExpression(expression, appendable, type)
				}
			}
		}
	}
		
	def void generateTypeParameterDeclaration(JvmTypeParameterDeclarator it, ITreeAppendable appendable) {
		appendable.forEach(typeParameters, [
				prefix = '<' separator = ', ' suffix = '> '
			], [
				it| generateTypeParameterDeclaration(appendable)
			])
	}
	
	def void generateTypeParameterDeclaration(JvmTypeParameter it, ITreeAppendable appendable) {
		val tracedAppendable = appendable.trace(it)
		tracedAppendable.traceSignificant(it).append(name)
		generateTypeParameterConstraints(tracedAppendable)
	}
	
	def void generateTypeParameterConstraints(JvmTypeParameter it, ITreeAppendable appendable) {
		val upperBounds = constraints.filter(typeof(JvmUpperBound))
		appendable.forEachSafely(upperBounds, [
				prefix = ' extends ' separator = ' & '
			], [
				it, app | typeReference.serializeSafely(app)
			])
	}
	
	def void generateThrowsClause(JvmExecutable it, ITreeAppendable appendable) {
		val toBeGenerated = <JvmType, JvmTypeReference> newLinkedHashMap
		exceptions.forEach[if(!toBeGenerated.containsKey(type)) toBeGenerated.put(type, it)]
		appendable.forEachSafely(toBeGenerated.values, [
				prefix = ' throws ' separator = ', '
			], [
				it, app |  app.trace(it).append(it.type)
			])
	}
	
	def void generateParameters(JvmExecutable it, ITreeAppendable appendable) {
		if (!parameters.isEmpty) {
			for (i : 0 .. parameters.size - 1) {
				val last = i + 1 == parameters.size
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
			if (! (parameterType instanceof JvmGenericArrayTypeReference)) {
				tracedAppendable.append("/* Internal Error: Parameter was vararg but not an array type. */");
			} else {
				(parameterType as JvmGenericArrayTypeReference).componentType.serializeSafely("Object", tracedAppendable)
			}
			tracedAppendable.append("...")
		} else {
			parameterType.serializeSafely("Object", tracedAppendable)
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
			val errors = op.getErrors(true)
			if(errors.empty) {
				appendable.increaseIndentation.append("{").newLine
				op.compilationStrategy.apply(appendable)
				appendable.decreaseIndentation.newLine.append("}")
			} else {
				generateBodyWithIssues(appendable, errors)
			}
		} else {
			val expression = op.getAssociatedExpression
			if (expression != null) {
				val errors = expression.getErrors(true)
				if(errors.empty) {
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
				} else {
					generateBodyWithIssues(appendable, errors)	
				}
			} else if(op instanceof JvmOperation) {
				appendable.increaseIndentation.append("{").newLine
				appendable.append('throw new UnsupportedOperationException("')
				appendable.append(op.simpleName)
				appendable.append(' is not implemented");')
				appendable.decreaseIndentation.newLine.append("}")
			} else if (op instanceof JvmConstructor) {
				appendable.append("{").newLine.append("}")
			}
		}
	}

	def generateBodyWithIssues(ITreeAppendable appendable, Iterable<Issue> errors) {
		appendable.append('{').increaseIndentation.newLine
			.append('throw new Error("Unresolved compilation problems"')
		appendable.increaseIndentation
		errors.forEach[appendable.newLine.append('+ "').append(convertToJavaString(message)).append('"')]
		appendable.append(');').decreaseIndentation.decreaseIndentation.newLine
		    .append('}')
	}
	
	
	def void generateFileHeader(JvmDeclaredType it, ITreeAppendable appendable) {
        val fileHeaderAdapter = it.eAdapters.filter(typeof(FileHeaderAdapter)).head
        if(!fileHeaderAdapter?.headerText.nullOrEmpty) {
            val text = '''/**''' as StringConcatenation;
            text.newLine
            text.append(" * ")
            text.append(fileHeaderAdapter.headerText, " * ")
            text.newLine
            text.append(" */")
            appendable.append(text.toString).newLine
        }
    }

	def void generateJavaDoc(EObject it, ITreeAppendable appendable) {
		val adapter = it.eAdapters.filter(typeof(DocumentationAdapter)).head
		if(!adapter?.documentation.nullOrEmpty) {
			// TODO we should track the source of the documentation in the documentation adapter
			val doc = '''/**''' as StringConcatenation
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
		val sep = [ITreeAppendable it |  if(withLineBreak) newLine else append(' ') ]
		appendable.forEachSafely(annotations, [
				separator = sep suffix = sep
			], [
				it, app | it.generateAnnotation(app)
			])
	}
	
	def void generateAnnotations(JvmAnnotationAnnotationValue it, ITreeAppendable appendable, boolean withLineBreak) {
		appendable.forEachSafely(annotations, [
				separator = [ITreeAppendable it |  if(withLineBreak) append(',').newLine else append(', ') ]
				suffix = [ITreeAppendable it |  if(withLineBreak) newLine ]
			], [
				it, app | it.generateAnnotation(app)
			])
	}
	
	def void generateAnnotation(JvmAnnotationReference it, ITreeAppendable appendable) {
		appendable.append("@")
		appendable.append(annotation)
		appendable.forEach(values, [
				prefix = '(' separator = ', ' suffix = ')'		
			], [
				toJava(appendable)
			])
	}
	 
	def void toJava(JvmAnnotationValue it, ITreeAppendable appendable) {
		if (operation != null) {
			appendable.append(operation.simpleName)
			appendable.append(" = ")
		} 
		toJavaLiteral(appendable)
	}
		
	def dispatch void toJavaLiteral(JvmAnnotationAnnotationValue value, ITreeAppendable appendable) {
		appendable.forEachWithShortcut(value.values, [value.generateAnnotations(appendable, false)])
	}
		
	def dispatch void toJavaLiteral(JvmShortAnnotationValue it, ITreeAppendable appendable) {
		appendable.forEachWithShortcut(values, [toString])
	}
	
	def dispatch void toJavaLiteral(JvmIntAnnotationValue it, ITreeAppendable appendable) {
		appendable.forEachWithShortcut(values, [toString])
	}
	
	def dispatch void toJavaLiteral(JvmLongAnnotationValue it, ITreeAppendable appendable) {
		appendable.forEachWithShortcut(values, [toString])
	}
	
	def dispatch void toJavaLiteral(JvmByteAnnotationValue it, ITreeAppendable appendable) {
		appendable.forEachWithShortcut(values, [toString])
	}
	
	def dispatch void toJavaLiteral(JvmDoubleAnnotationValue it, ITreeAppendable appendable) {
		appendable.forEachWithShortcut(values, [
			appendable.append(
				switch(it) {
					case Double::isNaN(it) : "Double.NaN"
					case Double::POSITIVE_INFINITY : "Double.POSITIVE_INFINITY" 
					case Double::NEGATIVE_INFINITY : "Double.NEGATIVE_INFINITY"
					default: toString + "d" 
				})
		])
	}
	
	def dispatch void toJavaLiteral(JvmFloatAnnotationValue it, ITreeAppendable appendable) {
		appendable.forEachWithShortcut(values, [
			appendable.append(
				switch(it) {
					case Float::isNaN(it) : "Float.NaN"
					case Float::POSITIVE_INFINITY : "Float.POSITIVE_INFINITY" 
					case Float::NEGATIVE_INFINITY : "Float.NEGATIVE_INFINITY"
					default: toString + "f" 
				})
		])
	}
	
	def dispatch void toJavaLiteral(JvmCharAnnotationValue it, ITreeAppendable appendable) {
		appendable.forEachWithShortcut(values, [
			appendable.append("'" + Strings::convertToJavaString(toString, true) + "'")			
		])
	}
		
	def dispatch void toJavaLiteral(JvmStringAnnotationValue it, ITreeAppendable appendable) {
		appendable.forEachWithShortcut(values, [
			appendable.append('"' + Strings::convertToJavaString(toString, true) + '"')			
		])
	}
		
	def dispatch void toJavaLiteral(JvmTypeAnnotationValue it, ITreeAppendable appendable) {
		appendable.forEachWithShortcut(values, [
			appendable.append(type).append(".class")
		])
	} 
	
	def dispatch void toJavaLiteral(JvmEnumAnnotationValue it, ITreeAppendable appendable) {
		appendable.forEachWithShortcut(values, [
			appendable.append(declaringType)
			appendable.append(".")
			appendable.append(simpleName)
		])
	} 
		
	def dispatch void toJavaLiteral(JvmBooleanAnnotationValue it, ITreeAppendable appendable) {
		appendable.forEachWithShortcut(values, [
			appendable.append(toString)			
		])
	} 
	
	def dispatch void toJavaLiteral(JvmCustomAnnotationValue it, ITreeAppendable appendable) {
		appendable.forEachWithShortcut(values.filter(typeof(XExpression)), [
			compiler.toJavaExpression(it, appendable)
		])
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
	
	def Iterable<JvmMember> getMembersToBeCompiled(JvmDeclaredType it) {
		members.filter[!(it instanceof JvmConstructor && (it as JvmConstructor).singleSyntheticDefaultConstructor)]
	}
}
