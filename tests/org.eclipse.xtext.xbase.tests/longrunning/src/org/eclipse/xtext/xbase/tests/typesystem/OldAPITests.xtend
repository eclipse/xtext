/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.impl.FeatureCallToJavaMapping
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.eclipse.xtext.xbase.typing.ITypeProvider
import org.eclipse.xtext.xtype.XFunctionTypeRef
import org.eclipse.xtext.xbase.typing.XbaseTypeArgumentContextProvider

/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractOldAPITypeResolverTest extends AbstractTypeResolverTest<JvmTypeReference> {
	
	override JvmTypeReference resolvesTo(String expression, String type, boolean expectWarning) {
		val xExpression = expression(expression, false /* true */);
		assertTrue(xExpression.eResource.errors.isEmpty)
		assertTrue(xExpression.eResource.warnings.isEmpty)
		val resolvedType = typeProvider.getType(xExpression)
		assertEquals(type, resolvedType?.simpleName);
		for(content: xExpression.eAllContents.toIterable) {
			switch(content) {
				XSwitchExpression: {
					assertExpressionTypeIsResolved(content)
					if (content.localVarName != null) {
						assertIdentifiableTypeIsResolved(content)
					}
				}
				XExpression: {
					assertExpressionTypeIsResolved(content)
				}
				JvmIdentifiableElement: {
					assertIdentifiableTypeIsResolved(content)
				}
			}
		}
		assertTrue(xExpression.eResource.linkingAndSyntaxErrors.toString, xExpression.eResource.linkingAndSyntaxErrors.isEmpty)
		assertTrue(xExpression.eResource.warnings.isEmpty)
		return resolvedType
	}
	
	override void isFunctionAndEquivalentTo(JvmTypeReference reference, String type) {
		assertTrue(reference instanceof XFunctionTypeRef)
		assertEquals(type, (reference as XFunctionTypeRef).equivalent.simpleName)
	}
	
	def void assertExpressionTypeIsResolved(XExpression expression) {
		val type = typeProvider.getType(expression)
		assertNotNull(expression.toString, type)
		assertNotNull(expression.toString + " / " + type, type.identifier)
		val expectedType = typeProvider.getExpectedType(expression)
		assertNotNull(expression.toString, String::valueOf(expectedType))	
	}
	
	def void assertIdentifiableTypeIsResolved(JvmIdentifiableElement identifiable) {
		val type = typeProvider.getTypeForIdentifiable(identifiable)
		assertNotNull(identifiable.toString, type)
		assertNotNull(identifiable.toString + " / " + type, type.identifier)	
	}
	
	protected def ITypeProvider getTypeProvider()
}


/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractOldAPITypeArgumentTest extends AbstractTypeArgumentTest {
	
	@Inject
	ILogicalContainerProvider logicalContainerProvider
	
	@Inject
	FeatureCallToJavaMapping featureCallToJavaMapping
	
	override protected resolveTypes(XExpression expression) {
		// done on demand
	}
	
	override protected hasTypeArguments(XExpression expression, String... typeArguments) {
		switch(expression) {
			XAbstractFeatureCall:
				hasTypeArguments(expression, typeArguments)
			XConstructorCall:
				hasTypeArguments(expression, typeArguments)
			default:
				fail('Unexpected expression: ' + expression)
		}
	}
	
	def void hasTypeArguments(XAbstractFeatureCall call, String... typeArguments) {
		val executable = call.feature as JvmExecutable
		val typeParameters = (executable as JvmTypeParameterDeclarator).typeParameters
		assertEquals(typeArguments.size, typeParameters.size)
		
		val receiver = featureCallToJavaMapping.getActualReceiver(call);
		val receiverType = if (receiver != null) typeProvider.getType(receiver)
		val expectedType = typeProvider.getExpectedType(call);
		val List<JvmTypeReference> argumentTypes = newArrayList
		for (XExpression argument : featureCallToJavaMapping.getActualArguments(call)) {
			argumentTypes.add(typeProvider.getType(argument));
		}
		val typeArgumentContext = typeArgumentContextProvider.getTypeArgumentContext(new FeatureCallRequest(
			call, executable, receiverType, expectedType, argumentTypes, logicalContainerProvider
		))
		val actualTypeArguments = <JvmTypeReference>newArrayList
		typeParameters.forEach [
			actualTypeArguments += typeArgumentContext.getBoundArgument(it)
		]
		assertTypeArguments(typeArguments, actualTypeArguments)
	}
	
	def assertTypeArguments(String[] typeArguments, List<JvmTypeReference> actualTypeArguments) {
		typeArguments.forEach [ typeArgument, i |
			val actualTypeArgument = actualTypeArguments.get(i)
			assertNotNull(typeArgument, actualTypeArgument)
			assertEquals(typeArgument, actualTypeArgument.simpleName)
		]
	}
	
	def void hasTypeArguments(XConstructorCall call, String... typeArguments) {
		val producedType = typeProvider.getType(call) as JvmParameterizedTypeReference
		val actualTypeArguments = producedType.arguments
		assertTypeArguments(typeArguments, actualTypeArguments)
	}
	
	protected def ITypeProvider getTypeProvider()
	protected def TypeArgumentContextProvider getTypeArgumentContextProvider()
}



/**
 * @author Sebastian Zarnekow
 */
@Data
class FeatureCallRequest extends XbaseTypeArgumentContextProvider$AbstractFeatureCallRequest {
	
	XAbstractFeatureCall call
	JvmExecutable feature
	JvmTypeReference receiverType
	JvmTypeReference expectedType
	List<JvmTypeReference> argumentTypes
	ILogicalContainerProvider contextProvider
	
	override getNearestDeclarator() {
		var EObject context = call
		var JvmTypeParameterDeclarator result = null;
		while (context != null && result == null) {
			if (context instanceof JvmTypeParameterDeclarator) {
				result = context
			} else {
				val JvmIdentifiableElement logicalContainer = contextProvider.getLogicalContainer(context);
				if (logicalContainer != null) {
					context = logicalContainer;
				} else {
					context = context.eContainer();
				}
			}
		}
		return result;
	}

	override getExplicitTypeArgument() {
		return call.typeArguments;
	}
	
	override getDeclaredType() {
		switch f : feature {
			JvmOperation : f.returnType
			default: null
		}
	}
	
	override getFeatureCall() {
		call
	}
	
}
				

/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractOldAPIClosureTypeTest extends AbstractClosureTypeTest {
	
	override List<Object> resolvesClosuresTo(String expression, String... types) {
		val closures = expression.findClosures
		val result = <Object>newArrayList
		closures.forEach[ closure, index |
			val closureType = typeProvider.getType(closure)
			assertTrue('''failed for closure at «index»: «closureType»''', closureType instanceof XFunctionTypeRef)
			assertEquals('''failed for closure at «index»''', types.get(index), closureType.simpleName); 
			result += closureType
		]		
		return result
	}
	
	override void withEquivalents(List<Object> references, String... types) {
		references.forEach [ reference, index |
			assertTrue(reference instanceof XFunctionTypeRef)
			assertEquals(types.get(index), (reference as XFunctionTypeRef).equivalent.simpleName)
		]
	}
	
	protected def ITypeProvider getTypeProvider()
}

/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractOldAPIConstructorCallTypeTest extends AbstractConstructorCallTypeTest {
	
	override resolvesConstructorCallsTo(String expression, String... types) {
		val expressionWithQualifiedNames = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val featureCalls = expressionWithQualifiedNames.findConstructorCalls
		featureCalls.forEach[ featureCall, index |
			val type = typeProvider.getType(featureCall)
			assertEquals('''failed for constructor call at «index»''', types.get(index), type.simpleName); 
		]		
	}
	
	protected def ITypeProvider getTypeProvider()
}

/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractOldAPIFeatureCallTypeTest extends AbstractFeatureCallTypeTest {
	
	override resolvesFeatureCallsTo(String expression, String... types) {
		val expressionWithQualifiedNames = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val featureCalls = expressionWithQualifiedNames.findFeatureCalls
		featureCalls.forEach[ featureCall, index |
			val type = typeProvider.getType(featureCall)
			assertEquals('''failed for feature call at «index»''', types.get(index), type.simpleName); 
		]		
	}
	
	protected def ITypeProvider getTypeProvider()
	
}



/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractOldAPIIdentifiableTypeTest extends AbstractIdentifiableTypeTest {
	
	override resolvesIdentifiablesTo(String expression, String... types) {
		val expressionWithQualifiedNames = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val identifiables = expressionWithQualifiedNames.findIdentifiables
		identifiables.forEach[ identifiable, index |
			val type = typeProvider.getTypeForIdentifiable(identifiable)
			assertEquals('''failed for identifiable at «index»''', types.get(index), type.simpleName); 
		]		
	}
	
	protected def ITypeProvider getTypeProvider()
	
}

