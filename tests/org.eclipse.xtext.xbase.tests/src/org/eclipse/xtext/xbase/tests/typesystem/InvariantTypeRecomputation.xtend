/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

/**
 * @author Sebastian Zarnekow
 */
class RecomputingBatchTypeResolver extends DefaultBatchTypeResolver {

	@Inject
	private Provider<RecomputingReentrantTypeResolver> resolverProvider;

	override createResolver() {
		resolverProvider.get
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class RecomputingReentrantTypeResolver extends DefaultReentrantTypeResolver {

	@Inject
	extension ReflectExtensions	
	
	val mapJoiner = Joiner::on('\n').withKeyValueSeparator('=')
	
	override createResolvedTypes() {
		return new RecordingRootResolvedTypes(this)
	}
	
	override resolve() {
		val firstRun = (super.resolve as RecordingRootResolvedTypes).resolvedProxies
		val result = super.resolve as RecordingRootResolvedTypes
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
		''', firstRun.keySet as Object /* TODO workaround for bug in linking */, secondRun.keySet)
		firstRun.forEach[ expression, firstLinkingData |
			val secondLinkingData = secondRun.get(expression)
			assertEqualLinkingData(firstLinkingData, secondLinkingData)
		]
		return result
	}
	
	def dispatch void assertEqualLinkingData(IConstructorLinkingCandidate left, IConstructorLinkingCandidate right) {
		Assert::assertEquals('constructor', left.constructor, right.constructor)
		Assert::assertEquals('constructorCall', left.constructorCall, right.constructorCall)
		doAssertEqualLinkingData(left, right)
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
		Assert::assertEquals('typeArguments', left.typeArguments.map[ simpleName ] as Object /* TODO workaround for bug in linking */, right.typeArguments.map[ simpleName ])
	}
	
	def dispatch void assertEqualLinkingData(IFeatureLinkingCandidate left, IFeatureLinkingCandidate right) {
		Assert::assertEquals('feature', left.feature, right.feature)
		Assert::assertEquals('featureCall', left.featureCall, right.featureCall)
		doAssertEqualLinkingData(left, right)
		Assert::assertEquals('isStatic', left.isStatic, right.isStatic)
		Assert::assertEquals('isExtension', left.isExtension, right.isExtension)
	}
	
	def void doAssertEqualLinkingData(ILinkingCandidate left, ILinkingCandidate right) {
		Assert::assertEquals('typeArguments', left.typeArguments.map[ simpleName ] as Object /* TODO workaround for bug in linking */, right.typeArguments.map[ simpleName ])
		Assert::assertEquals('arguments', left.invoke('getArguments'), right.invoke('getArguments'))
		Assert::assertEquals('explicitTypeArguments', 
			left.<List<LightweightTypeReference>>invokeAndCast('getExplicitTypeArguments').map[toString] as Object, 
			right.<List<LightweightTypeReference>>invokeAndCast('getExplicitTypeArguments').map[toString]
		)
		Assert::assertEquals('syntacticArguments', left.invoke('getSyntacticArguments'), right.invoke('getSyntacticArguments'))
		Assert::assertEquals('receiver', left.invoke('getReceiver'), right.invoke('getReceiver'))
		Assert::assertEquals('declaredTypeParameters', left.invoke('getDeclaredTypeParameters'), right.invoke('getDeclaredTypeParameters'))
		
		assertEqualMapping('getTypeParameterMapping', 
			left.invokeAndCast('getTypeParameterMapping'), 
			right.invokeAndCast('getTypeParameterMapping')
		)
		
		assertEqualMapping('getDeclaratorParameterMapping', 
			left.invokeAndCast('getDeclaratorParameterMapping'), 
			right.invokeAndCast('getDeclaratorParameterMapping')
		)
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
	
	@Property
	Map<XExpression, ILinkingCandidate> resolvedProxies
	
	new(DefaultReentrantTypeResolver resolver) {
		super(resolver)
	}
	
	override resolveProxies() {
		resolvedProxies = basicGetLinkingCandidates
		super.resolveProxies()
	}
	
}

