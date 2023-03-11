/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import com.google.inject.Inject
import java.util.HashMap
import java.util.Map
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmArrayType
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.common.types.access.TypeResource
import org.eclipse.xtext.common.types.access.impl.ClassFinder
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.util.IResourceScopeCache
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XListLiteral
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair
import org.eclipse.xtext.xbase.imports.IImportsConfiguration
import org.eclipse.xtext.xbase.interpreter.AbstractConstantExpressionsInterpreter
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException
import org.eclipse.xtext.xbase.interpreter.Context
import org.eclipse.xtext.xbase.interpreter.StackedConstantExpressionEvaluationException
import org.eclipse.xtext.xbase.interpreter.UnresolvableFeatureException
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals
import org.eclipse.xtext.xbase.typesystem.util.PendingLinkingCandidateResolver
import org.eclipse.xtext.xbase.typesystem.util.TypeLiteralLinkingCandidateResolver
import org.eclipse.xtext.xtype.XComputedTypeReference
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom

/**
 * An interpreter for evaluating constant expressions in annotation values.
 * 
 * @author Sven Efftinge
 */
class ConstantExpressionsInterpreter extends AbstractConstantExpressionsInterpreter {

	@Inject ILogicalContainerProvider containerProvider

	@Inject ProcessorInstanceForJvmTypeProvider classLoaderProvider

	@Inject extension NumberLiterals numberLiterals

	@Inject IScopeProvider scopeProvider

	@Inject IImportsConfiguration importSectionLocator

	@Inject IQualifiedNameConverter qualifiedNameConverter
	
	@Inject IResourceScopeCache cache
	
	def Object evaluate(XExpression expression, JvmTypeReference expectedType) {
		val classLoader = classLoaderProvider.getClassLoader(expression)
		val visibleFeatures = findVisibleFeatures(expression)
		val result = evaluate(expression, 
			new Context(
				(if (expectedType instanceof XComputedTypeReference) null else expectedType), 
				new ClassFinder(classLoader), visibleFeatures,
				newLinkedHashSet()
			)
		)
		return result
	}
	
	/**
	 * looks up the static final fields which are accessible in unqualified form for the given expression.
	 * That essentially includes static imports and the fields declared in the containing types
	 */
	protected def Map<String, JvmIdentifiableElement> findVisibleFeatures(XExpression expression) {
		// don't build a scope for a storage loaded resource, since everything is computed and we will resolve the proxies
		switch res : expression.eResource {
			StorageAwareResource case res.isLoadedFromStorage : return newHashMap
		}
		val container = switch cont : containerProvider.getNearestLogicalContainer(expression) {
			JvmGenericType: {
				cont
			}
			JvmMember: {
				cont.declaringType
			}
		}
		cache.get('visibleFeaturesForAnnotationValues'->container, expression.eResource) [
			val result = newHashMap
			val section = importSectionLocator.getImportSection(expression.eResource as XtextResource)
			if(section !== null) {
				for (imp : section.importDeclarations) {
					if(imp.static) {
						val importedTypeName = imp.importedTypeName
						if (importedTypeName !== null) {
							val type = imp.findTypeByName(importedTypeName)
							switch type {
								JvmGenericType: {
									// add constant fields
									type.collectAllVisibleFields(result)
								}
								JvmEnumerationType: {
									// add enum values
									for (feature : type.literals) {
										result.put(feature.simpleName, feature)
									}
								}
							}
						}
					}
				}
			}
			container.collectAllVisibleFields(result)
			return result
		]
	}
	
	protected def void collectAllVisibleFields(JvmDeclaredType type, Map<String, JvmIdentifiableElement> result) {
		if (type === null) {
			return;
		}
		collectAllVisibleFields(type.declaringType, result)
		result.putAll(type.allVisibleFields)
	}
	
	/**
	 * The visible fields collector does not interfere with the local caches of JvmDeclaredTypes
	 * but only looks at the fields of those types.
	 */
	static class VisibleFieldsCollector {
		def void collect(JvmDeclaredType type, Map<String, JvmIdentifiableElement> result) {
			type.collect(newHashSet, result)
		}
		private def void collect(JvmDeclaredType type, Set<JvmType> seen, Map<String, JvmIdentifiableElement> result) {
			if (seen.add(type)) {
				for(member: type.members) {
					if (member instanceof JvmField) {
						if (member.final && member.static) {
							val existing = result.put(member.simpleName, member)
							if (existing !== null) {
								result.put(existing.simpleName, existing)
							}
						}
					}
				}
				for(superType: type.superTypes) {
					val rawSuperType = superType?.type
					if (rawSuperType instanceof JvmDeclaredType && !rawSuperType.eIsProxy) {
						collect(rawSuperType as JvmDeclaredType, seen, result)
					}
				}
			}
		}
	}
	
	protected def getAllVisibleFields(JvmDeclaredType type) {
		val result = newHashMap
		new ConstantExpressionsInterpreter.VisibleFieldsCollector().collect(type, result)
		return result
	}
	
	protected def JvmType findTypeByName(EObject context, String qualifiedName) {
		val scope = scopeProvider.getScope(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)
		val qn = qualifiedNameConverter.toQualifiedName(qualifiedName)
		return scope.getSingleElement(qn)?.getEObjectOrProxy as JvmType
	}

	def dispatch Object internalEvaluate(XNumberLiteral it, Context ctx) {
		val type = if (ctx.expectedType === null)
			javaType
		else 
			getJavaType(ctx.expectedType.type,ctx.classFinder) as Class<? extends Number>
		
		numberValue(type)
	}

	def dispatch Object internalEvaluate(XListLiteral it, Context ctx) {
		val expectedComponentType = switch exp : ctx.expectedType {
			JvmGenericArrayTypeReference : {
				exp.componentType
			}
		}
		val elements = it.elements.map[
			evaluate(ctx.cloneWithExpectation(expectedComponentType))
		]
		val Class<?> componentType = if (expectedComponentType !== null) {
				expectedComponentType.type.getJavaType(ctx.classFinder)
			} else if(!elements.empty) {
				switch cl : elements.head.class {
					case Integer : Integer.TYPE 
					case Long : Long.TYPE 
					case Short : Short.TYPE 
					case Boolean : Boolean.TYPE 
					case Double : Double.TYPE 
					case Byte : Byte.TYPE 
					case Float: Float.TYPE
					default : cl
				}
			} else {
				Object
			}
		return Conversions.unwrapArray(elements, componentType)
	}
	
	protected def isResolveProxies(EObject ctx) {
		return switch res: ctx.eResource {
			StorageAwareResource: res.isLoadedFromStorage 
			default : false
		}
	}
	
	def dispatch Object internalEvaluate(XFeatureCall it, Context ctx) {
		val feature = eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, resolveProxies) as EObject
		if (!feature.eIsProxy) {
			return switch feature {
				JvmEnumerationLiteral: feature
				JvmField: evaluateField(it, feature, ctx)
				JvmType: toTypeReference(feature, 0)
			}
		}
		val featureName = concreteSyntaxFeatureName
		val expectedRawType = {
			switch it: ctx.expectedType {
				XComputedTypeReferenceImplCustom case equivalentComputed: type
				XComputedTypeReference,
				case it === null: null
				default: type
			}
		}
		val visibleFeatures = if (isEnumExpectationInAnnotationValue(expectedRawType)) {
			val enumType = switch(expectedRawType) {
				JvmEnumerationType: expectedRawType
				JvmArrayType: expectedRawType.componentType as JvmEnumerationType
			}
			val copy = new HashMap(ctx.visibleFeatures)
			enumType.literals.forEach [
				copy.put(simpleName, it)
			]
			copy
		} else {
			ctx.visibleFeatures
		}
		if (visibleFeatures.containsKey(featureName)) {
			return switch visibleFeature : visibleFeatures.get(featureName) {
				JvmEnumerationLiteral : {
					resolveFeature(visibleFeature)
					visibleFeature
				}
				JvmField : {
					resolveFeature(visibleFeature)
					evaluateField(it, visibleFeature, ctx)
				}
			}
		}
		val type = findTypeByName(featureName)
		if (type !== null) {
			resolveType(type)
			return toTypeReference(type, 0)
		}
		throw new UnresolvableFeatureException("Couldn't resolve feature "+featureName, it)
	}
	
	private def isEnumExpectationInAnnotationValue(XFeatureCall it, JvmType expectedRawType) {
		if (expectedRawType instanceof JvmEnumerationType || expectedRawType instanceof JvmArrayType && (expectedRawType as JvmArrayType).componentType instanceof JvmEnumerationType) {
			// TODO annotation values don't know something about their logical container?
			var container = it.eContainer 
			if (container instanceof XAnnotationElementValuePair) {
				return true
			}
			if (container instanceof XAnnotation) {
				return true
			}
			if (container instanceof XListLiteral) {
				container = container.eContainer
				if (container instanceof XAnnotationElementValuePair) {
					return true
				}
				if (container instanceof XAnnotation) {
					return true
				}
			}
		}
		return false;
	}

	def dispatch Object internalEvaluate(XMemberFeatureCall it, Context ctx) {
		val feature = eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, isResolveProxies) as EObject
		if (!feature.eIsProxy) {
			return switch feature {
				JvmEnumerationLiteral: feature
				JvmField: evaluateField(it, feature, ctx)
				JvmType: toTypeReference(feature, 0)
			}
		}
		val featureName = concreteSyntaxFeatureName
		try {
			val receiver = evaluate(memberCallTarget, ctx)
			switch receiver {
				JvmTypeReference : {
					switch type : receiver.type {
						JvmEnumerationType : {
							val enumValue = type.literals.findFirst[simpleName==featureName]
							if (enumValue === null) {
								throw new ConstantExpressionEvaluationException("Couldn't find enum value "+featureName+" on enum "+receiver.simpleName, it)
							}
							resolveFeature(enumValue)
							return enumValue
						}
						JvmGenericType : {
							val field = type.allFeatures.filter(JvmField).findFirst[simpleName==featureName]
							if (field === null) {
								throw new ConstantExpressionEvaluationException("Couldn't find field "+featureName+" on type "+receiver.simpleName, it)
							}
							resolveFeature(field)
							return evaluateField(it,field, ctx)
						}
					}
				}
			}
			throw new UnresolvableFeatureException("Unresolvable feature "+featureName+" on "+receiver, it) 
		} catch (UnresolvableFeatureException e) {
			val typeName = fullName
			val type = findTypeByName(typeName)
			if (type !== null) {
				resolveType(type)
				return toTypeReference(type, 0)
			} else {
				throw new UnresolvableFeatureException("Unresolvable type "+typeName, it)
			}
		}
	}
	
	def dispatch String getFullName(XExpression call) {
		throw new ConstantExpressionEvaluationException("The expression '"+call.toText+"' cannot be used as a receiver within a constant expression.")
	}
	
	def dispatch String getFullName(XMemberFeatureCall call) {
		val prefix = call.memberCallTarget.fullName
		return prefix+'.'+call.concreteSyntaxFeatureName
	}
	
	def dispatch String getFullName(XFeatureCall call) {
		call.concreteSyntaxFeatureName
	}
	
	protected def evaluateField(XAbstractFeatureCall call, JvmField field, Context context) {
		if (field.isSetConstant || field.eResource instanceof TypeResource) {
			if (field.isConstant) {
				return field.constantValue
			} else {
				throw new ConstantExpressionEvaluationException("Field "+field.declaringType.simpleName+"."+field.simpleName+" is not a constant")
			}
		}
		val expression = containerProvider.getAssociatedExpression(field)
		if (context.alreadyEvaluating.contains(expression)) {
			throw new ConstantExpressionEvaluationException("Endless recursive evaluation detected.")
		}
		try {
			val visibleFeatures = findVisibleFeatures(expression)
			val ctx = new Context(field.type, context.classFinder, visibleFeatures, context.alreadyEvaluating)
			return evaluate(expression, ctx)
		} catch (ConstantExpressionEvaluationException e) {
			throw new StackedConstantExpressionEvaluationException(call, field, e)
		}
	}

	protected def Class<?> getJavaType(JvmType type, ClassFinder classFinder) throws ClassNotFoundException {
		if (type instanceof JvmArrayType) {
			var JvmType t = type
			var String dimensions = '' 
			while (t instanceof JvmArrayType) {
				dimensions = dimensions + '[]'
				t = t.componentType
			}
			val componentClass = getJavaType(t, classFinder)
			return classFinder.forName(componentClass.name+dimensions)
		}
		if(type.identifier == 'java.lang.Class') {
			return JvmTypeReference
		}
		if(type instanceof JvmEnumerationType) {
			return JvmEnumerationLiteral
		}
		if(type instanceof JvmAnnotationType) {
			return XAnnotation
		}
		return classFinder.forName(type.identifier)
	}
	
	protected def resolveType(XAbstractFeatureCall featureCall, JvmIdentifiableElement feature) {
		new TypeLiteralLinkingCandidateResolver(featureCall).resolveLinkingProxy(featureCall as InternalEObject, feature, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE)
	}
	
	protected def resolveFeature(XAbstractFeatureCall featureCall, JvmIdentifiableElement feature) {
		new PendingLinkingCandidateResolver(featureCall).resolveLinkingProxy(featureCall as InternalEObject, feature, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE)
	}

}
