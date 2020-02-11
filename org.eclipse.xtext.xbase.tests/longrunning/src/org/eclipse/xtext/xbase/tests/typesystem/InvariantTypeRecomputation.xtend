/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.common.base.Joiner
import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import java.util.Map
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate
import org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver
import org.eclipse.xtext.xbase.typesystem.internal.ImplicitReceiver
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.junit.Assert
import org.eclipse.xtext.xbase.typesystem.internal.ImplicitFirstArgument
import org.eclipse.xtext.xbase.typesystem.internal.TypeInsteadOfConstructorLinkingCandidate
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver
import org.eclipse.xtext.xbase.typesystem.internal.ITypeLiteralLinkingCandidate
import org.eclipse.xtext.xbase.typesystem.computation.IApplicableCandidate
import org.eclipse.xtext.xbase.typesystem.computation.IClosureCandidate
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author Sebastian Zarnekow
 */
class RecomputingBatchTypeResolver extends DefaultBatchTypeResolver {

	@Inject
	Provider<RecomputingReentrantTypeResolver> resolverProvider;

	override createResolver() {
		resolverProvider.get
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class RecomputingReentrantTypeResolver extends PublicReentrantTypeResolver {

	@Inject
	extension ReflectExtensions	
	
	val mapJoiner = Joiner::on('\n').withKeyValueSeparator('=')
	
	override createResolvedTypes(CancelIndicator monitor) {
		return new RecordingRootResolvedTypes(this, CancelIndicator.NullImpl)
	}
	
	override resolve(CancelIndicator monitor) {
		val firstResult = super.resolve(monitor) as RecordingRootResolvedTypes
		val firstRun = firstResult.resolvedProxies
		val result = super.resolve(monitor) as RecordingRootResolvedTypes
		val secondRun = result.resolvedProxies
		Assert::assertEquals('''
			«mapJoiner.join(firstRun)»
			 	
			 	vs
			 	
			«mapJoiner.join(secondRun)»
		''', firstRun.size, secondRun.size)
		val setJoiner = Joiner::on('\n')
		Assert::assertEquals('''
			«setJoiner.join(firstRun.keySet)»
			 	
			 	vs
			 	
			«setJoiner.join(secondRun.keySet)»
		''', firstRun.keySet, secondRun.keySet)
		firstRun.forEach[ expression, firstLinkingData |
			val secondLinkingData = secondRun.get(expression)
			assertEqualLinkingData(firstLinkingData, secondLinkingData)
			Assert::assertEquals(firstResult.isRefinedType(expression), result.isRefinedType(expression))
		]
		return result
	}
	
	def dispatch void assertEqualLinkingData(IApplicableCandidate left, IApplicableCandidate right) {
		Assert::fail('''«left» vs «right»''')
	}
	
	def dispatch void assertEqualLinkingData(IClosureCandidate left, IClosureCandidate right) {
		Assert::assertEquals('type', left.parameters.size, right.parameters.size)
		left.parameters.forEach [ leftParam, idx |
			val rightParam = right.parameters.get(idx)
			Assert::assertEquals(leftParam.name, rightParam.name)
			if (leftParam.eContainingFeature != XbasePackage.Literals.XCLOSURE__DECLARED_FORMAL_PARAMETERS)
				Assert::assertEquals(leftParam.parameterType.identifier, rightParam.parameterType.identifier)
		]
	}
	
	def dispatch void assertEqualLinkingData(ITypeLiteralLinkingCandidate left, ITypeLiteralLinkingCandidate right) {
		Assert::assertEquals('type', left.type, right.type)
		Assert::assertEquals('featureCall', left.featureCall, right.featureCall)
		doAssertEqualLinkingData(left, right)
		
		Assert::assertEquals('isStatic', left.isStatic, right.isStatic)
		Assert::assertEquals('isTypeLiteral', left.isTypeLiteral, right.isTypeLiteral)
		Assert::assertEquals('isExtension', left.isExtension, right.isExtension)
	}
	
	def dispatch void assertEqualLinkingData(ITypeLiteralLinkingCandidate left, ILinkingCandidate right) {
		Assert::fail('''«left» vs «right»''')
	}
	
	def dispatch void assertEqualLinkingData(ILinkingCandidate left, ITypeLiteralLinkingCandidate right) {
		Assert::fail('''«left» vs «right»''')
	}
	
	def dispatch void assertEqualLinkingData(IConstructorLinkingCandidate left, IConstructorLinkingCandidate right) {
		Assert::assertEquals('constructor', left.constructor, right.constructor)
		Assert::assertEquals('constructorCall', left.constructorCall, right.constructorCall)
		doAssertEqualLinkingData(left, right)
	}
	
	def dispatch void assertEqualLinkingData(TypeInsteadOfConstructorLinkingCandidate left, IConstructorLinkingCandidate right) {
		Assert::fail('''«left» vs «right»''')
	}
	
	def dispatch void assertEqualLinkingData(IConstructorLinkingCandidate left, TypeInsteadOfConstructorLinkingCandidate right) {
		Assert::fail('''«left» vs «right»''')
	}
	
	def dispatch void assertEqualLinkingData(TypeInsteadOfConstructorLinkingCandidate left, TypeInsteadOfConstructorLinkingCandidate right) {
		Assert::assertEquals('feature', left.feature, right.feature)
		Assert::assertEquals('constructorCall', left.constructorCall, right.constructorCall)
		
		assertEqualReferences('typeArguments', left.typeArguments, right.typeArguments)
		assertEqualReferences('syntacticTypeArguments', left.invokeAndCast('getSyntacticTypeArguments'), right.invokeAndCast('getSyntacticTypeArguments'))
		
		Assert::assertEquals('arguments', left.invoke('getArguments'), right.invoke('getArguments'))
	}
	
	def dispatch void assertEqualLinkingData(ImplicitReceiver left, IFeatureLinkingCandidate right) {
		Assert::fail('''«left» vs «right»''')
	}
	
	def dispatch void assertEqualLinkingData(IFeatureLinkingCandidate left, ImplicitReceiver right) {
		Assert::fail('''«left» vs «right»''')
	}
	
	def dispatch void assertEqualLinkingData(ImplicitReceiver left, ImplicitReceiver right) {
		Assert::assertEquals('feature', left.feature, right.feature)
		Assert::assertEquals('featureCall', left.featureCall, right.featureCall)
		assertEqualReferences('typeArguments', left.typeArguments, right.typeArguments)
	}
	
	def dispatch void assertEqualLinkingData(ImplicitFirstArgument left, ImplicitFirstArgument right) {
		Assert::assertEquals('feature', left.feature, right.feature)
		Assert::assertEquals('featureCall', left.featureCall, right.featureCall)
		assertEqualReferences('typeArguments', left.typeArguments, right.typeArguments)
	}
	
	def dispatch void assertEqualLinkingData(IFeatureLinkingCandidate left, IFeatureLinkingCandidate right) {
		Assert::assertEquals('feature', left.feature, right.feature)
		Assert::assertEquals('featureCall', left.featureCall, right.featureCall)
		doAssertEqualLinkingData(left, right)
		
		Assert::assertEquals('receiver', left.invoke('getReceiver'), right.invoke('getReceiver'))
		assertEqualTypes('receiverType', left.invokeAndCast("getReceiverType"),	left.invokeAndCast("getReceiverType"))
		
		Assert::assertEquals('implicitReceiver', left.invoke('getImplicitReceiver'), right.invoke('getImplicitReceiver'))
		assertEqualTypes('implicitReceiverType', left.invokeAndCast("getImplicitReceiverType"),	left.invokeAndCast("getImplicitReceiverType"))
		
		Assert::assertEquals('implicitFirstArgument', left.invoke('getImplicitFirstArgument'), right.invoke('getImplicitFirstArgument'))
		assertEqualTypes('implicitFirstArgumentType', left.invokeAndCast("getImplicitFirstArgumentType"),	left.invokeAndCast("getImplicitFirstArgumentType"))
		
		Assert::assertEquals('syntacticReceiver', left.invoke('getSyntacticReceiver'), right.invoke('getSyntacticReceiver'))
		assertEqualTypes('syntacticReceiverType', left.invokeAndCast("getSyntacticReceiverType"), left.invokeAndCast("getSyntacticReceiverType"))
		
		Assert::assertEquals('isStatic', left.isStatic, right.isStatic)
		Assert::assertEquals('isTypeLiteral', left.isTypeLiteral, right.isTypeLiteral)
		Assert::assertEquals('syntacticReceiver', left.invoke('getSyntacticReceiver'), right.invoke('getSyntacticReceiver'))
		Assert::assertEquals('isExtension', left.isExtension, right.isExtension)
		
		Assert::assertEquals('syntacticArguments', left.invoke('getSyntacticArguments'), right.invoke('getSyntacticArguments'))
	}
	
	def void doAssertEqualLinkingData(ILinkingCandidate left, ILinkingCandidate right) {
		assertEqualReferences('typeArguments', left.typeArguments, right.typeArguments)
		assertEqualReferences('syntacticTypeArguments', left.invokeAndCast('getSyntacticTypeArguments'), right.invokeAndCast('getSyntacticTypeArguments'))
		
		Assert::assertEquals('arguments', left.invoke('getArguments'), right.invoke('getArguments'))
		
		Assert::assertEquals('declaredTypeParameters', left.invoke('getDeclaredTypeParameters'), right.invoke('getDeclaredTypeParameters'))
		
		assertEqualMapping('typeParameterMapping', left.invokeAndCast('getTypeParameterMapping'), right.invokeAndCast('getTypeParameterMapping'))
		assertEqualMapping('declaratorParameterMapping', left.invokeAndCast('getDeclaratorParameterMapping'), right.invokeAndCast('getDeclaratorParameterMapping'))
	}
	
	def void assertEqualTypes(String message, LightweightTypeReference left, LightweightTypeReference right) {
		Assert::assertEquals(message, left?.toString, right?.toString)
	}
	
	def void assertEqualReferences(String message, List<LightweightTypeReference> left, List<LightweightTypeReference> right) {
		Assert::assertEquals(message, left.map[ toString ], right.map[ toString ])
	}
	
	def void assertEqualMapping(String message, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> left, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> right) {
		Assert::assertEquals('''
			«message»:
			«mapJoiner.join(left)»
			 	
			 	vs
			 	
			«mapJoiner.join(right)»
		''', left.size, right.size)
		Assert::assertEquals('''
			«message»:
			«mapJoiner.join(left)»
			 	
			 	vs
			 	
			«mapJoiner.join(right)»
		''', left.keySet as Object, right.keySet)
		
		left.forEach[ typeParam, leftData |
			val rightData = right.get(typeParam)
			Assert::assertEquals(leftData.variance, rightData.variance)
			Assert::assertEquals(leftData.typeReference.simpleName, rightData.typeReference.simpleName)
		]
	}
	
	def <T> T invokeAndCast(ILinkingCandidate receiver, String getter) {
		receiver.invoke(getter) as T
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class RecordingRootResolvedTypes extends RootResolvedTypes {
	
	@Accessors
	Map<XExpression, IApplicableCandidate> resolvedProxies
	
	new(DefaultReentrantTypeResolver resolver, CancelIndicator monitor) {
		super(resolver, monitor)
	}
	
	override resolveProxies() {
		resolvedProxies = basicGetLinkingMap
		super.resolveProxies()
	}
	
}

