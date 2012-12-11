package org.eclipse.xtend.core.tests.imports

import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.imports.VisibleTypesFromHierarchy
import com.google.inject.Inject
import org.junit.Test
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmMember

/** 
 * TODO: Write more of these tests as soon as Xtend provides inner classes 
 */
class VisibleTypesFromHierarchyTest extends AbstractXtendTestCase {
	
	@Inject
	private VisibleTypesFromHierarchy typesFromHierarchy

	@Inject
	private IXtendJvmAssociations associations
			
	@Test def testInheritOuter() {
		val xtendClass = clazz('''
			package foo
			
			import types.OuterClass
			
			class Foo extends OuterClass {
				def foo() 
			}
		''')
		val inferredType = associations.getInferredType(xtendClass)
		assertTypeInScope("Foo", inferredType)
		assertTypeInScope("MiddleClass", inferredType)
		assertTypeInScope("MiddleClass.InnerMostClass", inferredType)
		assertNotInScope("OuterClass", inferredType)
		val method = xtendClass.members.get(0)
		val operation = associations.getDirectlyInferredOperation(method as XtendFunction)
		assertTypeInScope("Foo", operation)
		assertTypeInScope("MiddleClass", operation)
		assertTypeInScope("MiddleClass.InnerMostClass", operation)
		assertNotInScope("OuterClass", inferredType)
	}
	
	@Test def testInheritMiddle() {
		val xtendClass = clazz('''
			package foo
			
			import types.OuterClass
			
			class Foo extends OuterClass$MiddleClass {
				def foo() 
			}
		''')
		val inferredType = associations.getInferredType(xtendClass)
		assertTypeInScope("Foo", inferredType)
		assertTypeInScope("InnerMostClass", inferredType)
		assertNotInScope("OuterClass.MiddleClass", inferredType)
		assertNotInScope("MiddleClass", inferredType)
		assertNotInScope("OuterClass", inferredType)

		val method = xtendClass.members.get(0)
		val operation = associations.getDirectlyInferredOperation(method as XtendFunction)
		assertTypeInScope("Foo", operation)
		assertTypeInScope("InnerMostClass", operation)
		assertNotInScope("OuterClass.MiddleClass", operation)
		assertNotInScope("MiddleClass", operation)
		assertNotInScope("OuterClass", operation)
	}
	
	@Test def testInheritOuterTypeParam() {
		val xtendClass = clazz('''
			package foo
			
			import types.OuterClass
			
			class Foo<MiddleClass, T> extends OuterClass<String> {
				def <MiddleClass> foo() 
				def bar()
			}
		''')
		val inferredType = associations.getInferredType(xtendClass)
		assertTypeInScope("Foo", inferredType)
		assertTypeInScope("MiddleClass", inferredType)
		assertTypeInScope("MiddleClass.InnerMostClass", inferredType)
		assertTypeParameterInScope("T", inferredType)
		assertNotInScope("OuterClass", inferredType)
		
		val method = xtendClass.members.get(0)
		val operation = associations.getDirectlyInferredOperation(method as XtendFunction)
		assertTypeInScope("Foo", operation)
		assertTypeParameterInScope("MiddleClass", operation)
		assertTypeParameterInScope("T", operation)
		assertTypeInScope("MiddleClass.InnerMostClass", operation)
		assertNotInScope("OuterClass", operation)

		val method2 = xtendClass.members.get(0)
		val operation2 = associations.getDirectlyInferredOperation(method2 as XtendFunction)
		assertTypeInScope("Foo", operation2)
		assertTypeParameterInScope("MiddleClass", operation2)
		assertTypeParameterInScope("T", operation2)
		assertTypeInScope("MiddleClass.InnerMostClass", operation2)
		assertNotInScope("OuterClass", operation2)
	}
	
	@Test def testInheritMiddleParam() {
		val xtendClass = clazz('''
			package foo
			
			import types.OuterClass
			
			class Foo<InnerMostClass, T> extends OuterClass$MiddleClass<String> {
				def <InnerMostClass> foo() 
				def bar() 
			}
		''')
		val inferredType = associations.getInferredType(xtendClass)
		assertTypeInScope("Foo", inferredType)
		assertTypeInScope("InnerMostClass", inferredType)
		assertTypeParameterInScope("T", inferredType)
		assertNotInScope("OuterClass.MiddleClass", inferredType)
		assertNotInScope("MiddleClass", inferredType)
		assertNotInScope("OuterClass", inferredType)
		
		val method = xtendClass.members.get(0)
		val operation = associations.getDirectlyInferredOperation(method as XtendFunction)
		assertTypeInScope("Foo", operation)
		assertTypeParameterInScope("InnerMostClass", operation)
		assertTypeParameterInScope("T", operation)
		assertNotInScope("OuterClass.MiddleClass", operation)
		assertNotInScope("MiddleClass", operation)
		assertNotInScope("OuterClass", operation)

		val method2 = xtendClass.members.get(0)
		val operation2 = associations.getDirectlyInferredOperation(method2 as XtendFunction)
		assertTypeInScope("Foo", operation2)
		assertTypeInScope("InnerMostClass", operation2)
		assertTypeParameterInScope("T", operation2)
		assertNotInScope("OuterClass.MiddleClass", operation2)
		assertNotInScope("MiddleClass", operation2)
		assertNotInScope("OuterClass", operation2)
	}
	
	def protected assertTypeInScope(String typeName, JvmMember context) {
		val visibleType = typesFromHierarchy.getVisibleType(context, typeName)
		assertNotNull(visibleType)
		assertTrue(visibleType instanceof JvmType)		
	}

	def protected assertTypeParameterInScope(String typeName, JvmMember context) {
		val visibleType = typesFromHierarchy.getVisibleType(context, typeName)
		assertNotNull(visibleType)
		assertTrue(visibleType instanceof JvmTypeParameter)		
	}
	
	def protected assertNotInScope(String typeName, JvmMember context) {
		val visibleType = typesFromHierarchy.getVisibleType(context, typeName)
		assertNull(visibleType)
	}
}