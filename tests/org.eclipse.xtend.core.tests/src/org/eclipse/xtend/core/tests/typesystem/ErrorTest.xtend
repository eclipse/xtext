/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.xbase.XAssignment
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XCastedExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.junit.typesystem.NoJRESmokeTester
import org.eclipse.xtext.xbase.junit.typesystem.Oven
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ErrorTest extends AbstractXtendTestCase {
	
	@Inject
	IResourceValidator resourceValidator
	
	@Inject
	IBatchTypeResolver typeResolver
	
	@Inject
	IJvmModelAssociations associations
	
	@Inject
	ResolveBatchedWithoutJRE noJRETester
	
	@Inject extension Oven
	
	@Test
	def void testErrorModel_001() throws Exception {
		'''
			import static extension Throwables.*
			import java.net.URI
			
			class Client {
				val uri = [| new URI('')].propagate [ new IllegalArgumentException(it) ]
			}
			class Throwables {
				def static <T> T propagate((
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_002() throws Exception {
		val file = '''
			class TestXtend {
				val static int a = 4
				
				@
		'''.processWithoutException
		val clazz = file.xtendTypes.head as XtendClass
		val lastMember = clazz.members.last
		val annotations = lastMember.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_003() throws Exception {
		val file = '''
			class TestXtend {
				val static int a = 4
				
				@Click(#[ a, a ])
				d
		'''.processWithoutException
		val clazz = file.xtendTypes.head as XtendClass
		val lastMember = clazz.members.last
		val annotations = lastMember.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_004() throws Exception {
		val file = '''
			class TestXtend {
				val static int a = 4
				
				@Click(#[ a, a ])
				def m
		'''.processWithoutException
		val clazz = file.xtendTypes.head as XtendClass
		val lastMember = clazz.members.last
		val annotations = lastMember.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_005() throws Exception {
		val file = '''
			@
		'''.processWithoutException
		val typeDeclaration = file.xtendTypes.head
		val annotations = typeDeclaration.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_006() throws Exception {
		val file = '''
			@Data class A {}
			@
		'''.processWithoutException
		val typeDeclaration = file.xtendTypes.last
		val annotations = typeDeclaration.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_007() throws Exception {
		val file = '''
			@Data class A {}
			@Data class
		'''.processWithoutException
		val typeDeclaration = file.xtendTypes.last
		val annotations = typeDeclaration.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_008() throws Exception {
		val file = '''
			annotation Bar { @
		'''.processWithoutException
		val typeDeclaration = file.xtendTypes.last
		val annotations = typeDeclaration.members.last.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_009() throws Exception {
		val file = '''
			class X {
				@Property val S
		'''.processWithoutException
		val typeDeclaration = file.xtendTypes.last
		val annotations = typeDeclaration.members.last.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_010() throws Exception {
		val file = '''
			@SuppressWarnings("unused"
		'''.processWithoutException
		val typeDeclaration = file.xtendTypes.last
		val annotations = typeDeclaration.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_011() throws Exception {
		val file = '''
			annotation { 
				val inferred = 'bar'
			}
		'''.processWithoutException
		val annotation = file.xtendTypes.last
		val field = annotation.members.head as XtendField
		val initializer = field.initialValue
		val resolvedTypes = typeResolver.resolveTypes(initializer)
		assertNotNull(resolvedTypes.getActualType(initializer))
	}
	
	@Test
	def void testErrorModel_012() throws Exception {
		val file = '''
			class Y {
			 static def <T> IExpectationSetters<T> expect(T value) {
			 }
			 HeaderAccess<?> unboundedMockHeaderAccess
			 def test() {
			   val Object header = unboundedMockHeaderAccess.header
			   val IExpectationSettersObject> exp1 = expect(header)
			   val IExpectationSetters<Object> exp2 = expect(unboundedMockHeaderAccess.getHeader())
			 }
			}
			interface HeaderAccess<T> {
			   def T getHeader();
			}
			interface IExpectationSetters<T> {}
		'''.processWithoutException
		val y = file.xtendTypes.head
		val exp1 = y.members.get(3) as XtendField // error recovery parses two fields after the function #test
		val initializer = exp1.initialValue
		val resolvedTypes = typeResolver.resolveTypes(initializer)
		assertNotNull(resolvedTypes.getActualType(initializer))
	}
	
	@Test
	def void testErrorModel_013() throws Exception {
		val file = '''
			class Y {
			 static def <T> IExpectationSetters<T> expect(T value) {
			 }
			 HeaderAccess<?> unboundedMockHeaderAccess
			 def test() {
			   val Object header = unboundedMockHeaderAccess.header
			   val IExpectationSetters<Object> exp1 = expect(header)
			   val IExpectationSetters<Object> exp2 = expect(unboundedMockHeaderAccess.getHeader())
			 }
			}
			interface IExpectationSetters<T> {}
			interface HeaderAccess<T> {
			   def  getHeader();
			}
		'''.processWithoutException
		val headerAccess = file.xtendTypes.last
		val function = headerAccess.members.head as XtendFunction // error recovery parses two fields after the function #test
		val operation = associations.getJvmElements(function).head as JvmOperation
		val resolvedTypes = typeResolver.resolveTypes(operation)
		assertNotNull(resolvedTypes.getActualType(operation))
	}
	
	@Test
	def void testErrorModel_014() throws Exception {
		val file = '''
			class B extends  {
				override foo(String x, String...args) {
					return x
				}
			}
			abstract class A {
				def String foo(String x, String...args)
			}
		'''.processWithoutException
		val headerAccess = file.xtendTypes.last
		val function = headerAccess.members.head as XtendFunction // error recovery parses two fields after the function #test
		val operation = associations.getJvmElements(function).head as JvmOperation
		val resolvedTypes = typeResolver.resolveTypes(operation)
		assertNotNull(resolvedTypes.getActualType(operation))
	}
	
	@Test
	def void testErrorModel_015() throws Exception {
		val file = '''
			@ class Node {
			}
		'''.processWithoutException
		val node = file.xtendTypes.head
		val annotation = node.annotations.head
		val resolvedTypes = typeResolver.resolveTypes(annotation)
		assertNotNull(resolvedTypes.getActualType(annotation))
	}
	
	@Test
	def void testErrorModel_016() throws Exception {
		val file = '''
			class <T> {
				val String s
			    new(String ^new) {
			        s = ^new
			    }
			}
		'''.processWithoutException
		val unnamed = file.xtendTypes.head
		val constructor = unnamed.members.last as XtendConstructor
		val body = constructor.expression as XBlockExpression
		val assignment = body.expressions.head as XAssignment
		val resolvedTypes = typeResolver.resolveTypes(assignment)
		assertNotNull(resolvedTypes.getActualType(assignment))
	}
	
	@Test
	def void testErrorModel_017() throws Exception {
		val file = '''
			import static extension Throwables.*
			import java.net.URI
			
			class Throwables {
				def static <T> T propagate(()=>T proc, (Exception)=>Exception handler) {
					try {
						proc.apply
					} catch(Exception e) {
						throw handler.apply(e)
					}
				}
			}
			class Client {
				valuri = [| new URI('')].propagate [ new IllegalArgumentException(it) ]
			}
		'''.processWithoutException
		val client = file.xtendTypes.last
		val field = client.members.head as XtendField
		val initializer = field.initialValue as XMemberFeatureCall
		val closure = initializer.memberCallArguments.head as XClosure
		val implicit = closure.implicitFormalParameters.head
		assertNotNull(implicit)
		val resolvedTypes = typeResolver.resolveTypes(implicit)
		assertNotNull(resolvedTypes.getActualType(implicit))
	}
	
	@Test
	def void testErrorModel_018() throws Exception {
		val file = '''
			class C {
				def m(@
		'''.processWithoutException
		val c = file.xtendTypes.head
		val function = c.members.head as XtendFunction
		val param = function.parameters.head
		val annotation = param.annotations.head
		val resolvedTypes = typeResolver.resolveTypes(annotation)
		assertNotNull(resolvedTypes.getActualType(annotation))
	}
	
	@Test
	def void testErrorModel_019() throws Exception {
		val file = '''
			package x
			import bug396879.*
			class Z {
			  	def addListeners(BooleanProperty prop) {
					val ChangeListenerBoolean> listener = [ p, oldValue, newValue | ]		prop.addListener(listener)
				}
			}
		'''.processWithoutException
		val z = file.xtendTypes.head
		val field = z.members.get(1) as XtendField
		val closure = field.initialValue as XClosure
		val param = closure.declaredFormalParameters.head
		val resolvedTypes = typeResolver.resolveTypes(param)
		assertNotNull(resolvedTypes.getActualType(param))
	}
	
	@Test
	def void testErrorModel_020() throws Exception {
		val file = '''
			package x
			class Y {
				@com.google.inject.Inject extension test.GenericExtensionMethods<String,Integer> x
				def foo(String arg) {
					arg.method
				}
			}
		'''.processWithoutException
		val y = file.xtendTypes.head
		val function = y.members.last as XtendFunction
		val body = function.expression as XBlockExpression
		val featureCall = body.expressions.head as XMemberFeatureCall
		val implicitReceiver = featureCall.implicitReceiver as XMemberFeatureCall
		val this_ = implicitReceiver.memberCallTarget
		val resolvedTypes = typeResolver.resolveTypes(this_)
		assertNotNull(resolvedTypes.getActualType(this_))
	}

	@Test
	def void testErrorModel_021() throws Exception {
		'''
			package x class Z {
				def generate(java.util.List<String> d, String fsa) {
					d.iter(e | e.generate(fsa))
				}
				def void generate(String e, String fsa) {}
				def <T,R> iter(java.util.List<T> list, (T)=>void proc) {
					for(element  list) { proc.apply(element); }
				}
			}
		'''.processWithoutException
	}

	@Test
	def void testErrorModel_022() throws Exception {
		'''
			package generics class Bar {
				def <T extends (Object)=>T> T bar( t) {
					bar(t).apply(bar(t))
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_023() throws Exception {
		'''
			package generics class Bar {
				def <T extends (Object)=>T> T bar() {
					bar(t).apply(bar(t))
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_024() throws Exception {
		'''
			class Bug<A> {
				A a
				new(A a) {
					this.a = a
				}
				def static of (A a) {
					new Bug<A>(a)
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_025() throws Exception {
		'''
			package x class Y {
				def bug343090(Integer a, Integer b) {
			    	<Integer>addFunction.apply(a, b)
				}
				def <T extends> addFunction() {
			    	[T a,T b|a+b] as (T,T)=>T
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_026() throws Exception {
		'''
			package x class Y {
				def bug343090(Integer a, Integer b) {
			    	addFunction.apply(a, b)
				}
				def <T extends> addFunction() {
			    	[T a,T b|a+b] as (T,T)=>T
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_027() throws Exception {
		'''
			package x class Y {
				def bug343090(Integer a, Integer b) {
				    <Integer>addFunction.apply(a, b)
				}
				def <T extends> addFunction() {
				    [T a,T b|(a+b) as Integer] as (T,T)=>T
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_028() throws Exception {
		'''
			package x class Y {
				def bug343090(Integer a, Integer b) {
			    	<Integer>addFunction.apply(a, b)
				}
				def <T extends> addFunction() {
			    	[T a,T b|(a+b) as T] as (T,T)=>T
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_029() throws Exception {
		'''
			package x
			class Y {
				def String test() {
					newArrayList('fo','bar').minBy[]
				}
				def <A,B extends Comparable<? super B>> A minBy(Iterable<A> iterable, (A)=>B maxOn) {
					iterable.sortBy(maxOn).last
				}
				def <A,B extends Comparable<? super B>> A minBy(java.util.Collection<A> iterable, (A)=>B maxOn) {
					iterable.sortBy(maxOn).last
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_030() throws Exception {
		'''
			package x class Y {
				def bug343088(Integer a, Integer b) {
				    addFunction.apply(a, b)
				}
				def <T extends> (T,T)=>T addFunction() {
				    [T a,T b|(a+(b as Integer)) as T]
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_031() throws Exception {
		'''
			package x class Y {
				def bug343088(Integer a, Integer b) {
			    	addFunction.apply(a, b)
				}
				def <T extends> (T,T)=>T addFunction() {
				    [T a,T b|(a+b) as T]
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_032() throws Exception {
		'''
			package x class Y {
				def bug343090(Integer a, Integer b) {
				    <Integer>addFunction.apply(a, b)
				}
				def <T extends > addFunction() {
				    [T a,T b|a+b] as (T,T)=>T
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_033() throws Exception {
		'''
			package x
			import java.util.Collection
			import java.util.List
			class Z {
				def generate() {
					val List<CharSequence> seq = null
					val List<String> strings = null
					val result = seq.addAll2(strings)
					val Collection<String> test = result
					val result2 = strings.addAll3(seq)
					val Collection<String> test2 = result2
				}
				def <N extends N> Collection<K> addAll2(Collection<N> collection, Iterable<K> elements){
				    collection.addAll(elements)
				    null
				}
				def <N, K extends N> Collection<K> addAll3(Iterable<K> elements, Collection<N> collection){
				    collection.addAll(elements)
				    null
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_034() throws Exception {
		'''
			package x
			import java.util.Collection
			import java.util.List
			class Z {
				def generate() {
					val List<CharSequence> seq = null
					val List<String> strings = null
					val result = seq.addAll2(strings)
					val Collection<CharSequence> test = result
					val result2 = strings.addAll3(seq)
					val Collection<CharSequence> test2 = result2
				}
				def <T extends T> Collection<T> addAll2(Collection<T> collection, Iterable<U> elements){
				    collection.addAll(elements)
				    collection.<T>addAll(elements)
				    null
				}
				def <T, U extends T> Collection<T> addAll3(Iterable<U> elements, Collection<T> collection){
				    collection.addAll(elements)
				    collection.<T>addAll(elements)
				    null
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_035() throws Exception {
		'''
			package x
			import java.util.Collection
			import java.util.List
			class Z {
				def generate() {
					val List<CharSequence> seq = null
					val List<String> strings = null
					val result = seq.addAll2(strings)
					val Collection<CharSequence> test = result
					val result2 = strings.addAll3(seq)
					val Collection<CharSequence> test2 = result2
				}
				def <T1 extends T2, T2 extends T1> Collection<T1> addAll2(Collection<T1> collection, Iterable<T2> elements){
				    collection.addAll(elements)
				    collection.<T2>addAll(elements)
				    null
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_036() throws Exception {
		'''
			class Bar<T extends T> {
				new Bar(T t) {
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_037() throws Exception {
		'''
			class Bar<T1 extends T2, T2 extends T1> {
				new Bar(T1 t1, T2 t2) {
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_038() throws Exception {
		'''
			import bug380058.Amount
			
			import static bug380058.SI.*
			
			class JScienceTest {
			    def void test() { 
			        val w = Amount::valueOf(100, MILLIMETER)
			        val h = Amount::valueOf(50, MILLIMETER)
			        val perim = w.plus(h).times(2)
			        println("perim = " + perim)
			    }
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_039() throws Exception {
		'''
			abstract class Option<T> {
			  def <X> Option<X> map((T)=>X f) { switch this {
			    Some<T> : new Some<X>(f.apply(get))
			    None<T> : new None<X>
			  }}
			}
			class Some<T> extends Option<T> {}
			class None<T> extends Option<T> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_040() throws Exception {
		'''
			abstract class Option<T> {
			  def <X> Option<X> map((T)=>X f) { switch this {
			    Some<T> : new Some<X>(f.apply(get))
			    None<T> : new None<X>
			  }}
			}
			class Intermediate1<T> extends Option<T> {}
			class Intermediate2<T> extends Intermediate1<T> {}
			class Some<T> extends Intermediate2<T> {}
			class None<T> extends Intermediate2<T> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_041() throws Exception {
		'''
			class E<T> extends E<T> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_042() throws Exception {
		'''
			class C<T> extends E<T> {}
			class D<T> extends C<T> {}
			class E<T> extends D<T> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_043() throws Exception {
		'''
			@Data class Weight<T extends Comparable> implements Comparable<Weight<T>> {
				T weight
				
				override int compareTo(Weight w) {
					this.weight.compareTo(w.weight)
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_044() throws Exception {
		'''
			@Data class Weight<T extends Comparable<T>> implements Comparable<Weight<T>> {
				T weight
				
				override int compareTo(Weight<T> w) {
					this.weight.compareTo(w.weight)
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_045() throws Exception {
		'''
			@Data class Weight<T extends Comparable<T>> implements Comparable<Weight<T>> {
				T weight
				
				override int compareTo(Weight<T> w) {
					this..compareTo(w.weight)
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_046() throws Exception {
		'''
			annotation DependsOn {
				Class<?>[] value = #[ typeof(), typeof(CharSequence) ]
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_047() throws Exception {
		'''
			@Data class Weight<T extends Comparable<T>> implements Comparable<Weight<T>> {
				T weight
				
				override int compareTo(Weight<T> w) {
					this.weight.compareTo
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_048() throws Exception {
		'''
			@Data class Weight<T extends Comparable<Iterable<T>>> implements Comparable<Iterable<Weight<T>>> {
				T weight
				
				override int compareTo(Iterable<Weight<T>> w) {
					this.weight.compareTo(w.head.weight)
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_049() throws Exception {
		'''
			class C {
				def m(Class<?> type) {
					type.enumConstants.findFirst[ it != null]
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_050() throws Exception {
		'''
			class C {
				@Test def void m() {
					#[ '' ].flatMap[].sortBy [length]
				}
				def <A,B> Iterable<? extends B> flatMap(Iterable<? extends A> iterable, (A)=>B map) {
					return null
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_051() throws Exception {
		'''
			class C {
				
				val list = #[ '' ]
				
				@Test def void m() {
					#[ '' ].flatMap[].sortBy [length]
				}
				
				def <A,B> Iterable<B> flatMap(Iterable<? extends A> iterable, (A)=>B map) {
					return null
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_052() throws Exception {
		'''
			import com.google.inject.Injector
			class C {
				def <T extends Comparable<T>, X extends void m(T t, X x) {
					m('', '')
				}
				def void m(Injector i, Class<? extends CharSequence> c) {
					''.m('')
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_053() throws Exception {
		'''
			class C extends D {
				def m(int it) {
					substring
					it.substring
				
			class D {
				protected extension String
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_054() throws Exception {
		'''
			import org.eclipse.xtext.xbase.lib.Extension
			class C extends D {
				def m(int it) {
					substring
					it.substring
				
			class D {
				@Extension protected String string
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_055() throws Exception {
		'''
			class C extends D {
				protected extension String local
				def m(int it) {
					substring
				
			class D {
				protected extension String inherited
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_056() throws Exception {
		'''
			class C extends D {
				protected extension CharSequence local
				def m(int it) {
					charAt
				
			class D {
				protected extension String inherited
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_057() throws Exception {
		'''
			package x class Y {
				static int j
				int i
				new() {
					this(j)
				}
				new(int i) {
					this.i = i
				}
				def static invokeMe() {
					j = 47 new .i
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_058() throws Exception {
		'''
			class C {
				def m() {
					{ 
						var Object x = ('' a<b>).toString() 
						x 
					}
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_059() throws Exception {
		'''
			class C {
				def m() {
					{ 
						var Object x = null
						x 
					} + ''
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_060() throws Exception {
		'''
			class C {
				def m() {
					newArrayList.fold(newHashMap) [a,b | a.put]
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_061() throws Exception {
		'''
			class C<T> implements C1<T> {
				def void m(C1<?> p) {
					m(this)
				}
			}
			interface C1<A1> extends C2<A1> {}
			interface C2<A2> extends C3<A2, C2<A2>> {}
			interface C3<A3, B3> extends C4<A3, C1<A3>> {}
			interface C4<A4, B4> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_062() throws Exception {
		'''
			class C {
				def void m(C1<?> p) {
					m(a)
				}
			}
			interface C1<A1> extends C2<A1> {}
			interface C2<A2> extends C3<A2, C2<A2>> {}
			interface C3<A3, B3> extends C4<A3, C1<A3>> {}
			interface C4<A4, B4> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_063() throws Exception {
		'''
			class C {
				def void m(C1<?> p) {
					m(null as C1<String>)
				}
			}
			interface C1<A1> extends C2<A1> {}
			interface C2<A2> extends C3<A2, C2<A2>> {}
			interface C3<A3, B3> extends C4<A3, C1<A3>> {}
			interface C4<A4, B4> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_064() throws Exception {
		'''
			class C<T> implements C1<T> {
				def void m(C1<T> p) {
					m(this)
				}
			}
			interface C1<A1> extends C2<A1> {}
			interface C2<A2> extends C3<A2, C2<A2>> {}
			interface C3<A3, B3> extends C4<A3, C1<A3>> {}
			interface C4<A4, B4> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_065() throws Exception {
		'''
			class C {
				def void m(C1<String> p) {
					m(a)
				}
			}
			interface C1<A1> extends C2<A1> {}
			interface C2<A2> extends C3<A2, C2<A2>> {}
			interface C3<A3, B3> extends C4<A3, C1<A3>> {}
			interface C4<A4, B4> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_066() throws Exception {
		'''
			class C {
				def void m(C1<String> p) {
					m(null as C1<String>)
				}
			}
			interface C1<A1> extends C2<A1> {}
			interface C2<A2> extends C3<A2, C2<A2>> {}
			interface C3<A3, B3> extends C4<A3, C1<A3>> {}
			interface C4<A4, B4> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_067() throws Exception {
		'''
			class C<T> implements C1<T> {
				def void m(C2<?> p) {
					m(this)
				}
			}
			interface C1<A1> extends C2<A1> {}
			interface C2<A2> extends C3<A2, C2<A2>> {}
			interface C3<A3, B3> extends C4<A3, C1<A3>> {}
			interface C4<A4, B4> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_068() throws Exception {
		'''
			class C<T> implements C1<T> {
				def void m(C3<?, ?> p) {
					m(this)
				}
			}
			interface C1<A1> extends C2<A1> {}
			interface C2<A2> extends C3<A2, C2<A2>> {}
			interface C3<A3, B3> extends C4<A3, C1<A3>> {}
			interface C4<A4, B4> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_069() throws Exception {
		'''
			class C<T> implements C1<T> {
				def void m(C4<?, ?> p) {
					m(this)
				}
			}
			interface C1<A1> extends C2<A1> {}
			interface C2<A2> extends C3<A2, C2<A2>> {}
			interface C3<A3, B3> extends C4<A3, C1<A3>> {}
			interface C4<A4, B4> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_070() throws Exception {
		'''
			class C {
				def void m(C1<?> p) {
					m(a)
				}
			}
			interface C1<A1> extends C2<C1<C1<A1>>> {}
			interface C2<A2> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_071() throws Exception {
		'''
			import java.util.Map
			class C {
				def <A> Map<A, Expression<A>> then(Expression<A> expr) {}
				def <A extends Number & Comparable<?>> Map<A, NumberExpression<A>> then(NumberExpression<A> expr) {}
				
				def void m() {
					val NumberPath<Long> = null
					val y = then(count)
					println(y)
				}
			}
			
			class NumberPath<T extends Number & Comparable<?>> extends NumberExpression<T> {}
			class NumberExpression<T extends Number & Comparable<?>> extends ComparableExpressionBase<T> {}
			class ComparableExpressionBase<T extends Comparable<?>> extends SimpleExpression<T> {}
			class SimpleExpression<T> extends ExpressionBase<T> {}
			class ExpressionBase<T> implements Expression<T> {}
			interface Expression<T> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_072() throws Exception {
		'''
			class TestTypes {
				def foo() {
					var A tmp = null
					switch (tmp) {
						B: {
							tmp = tmp.bar ?: tmp.baz
						}
					}
				}
				def B bar(Object x) {
					return x as B
				}
				def C baz(Object x) {
					return x as C
				}
			}
			class A {}
			class B extends }
			class C extends A {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_073() throws Exception {
		'''
			class C {
				def static dispatch m(DoesNotExist d) {
					m(d)
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_074() throws Exception {
		'''
			class C {
				def m(int it) {
					for(ension s: <String>newArrayList) {
						substring
					}
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_075() throws Exception {
		'''
			class C {
				def m(int it) {
					for(xtension s: <String>newArrayList) {
						substring
					}
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_076() throws Exception {
		val file = '''
			class C {
				def String m(boolean b) {
					switch 'a' {
						case 'b': 'a'
						case 'c': {
							if 
								return 'b'
							else
								return 'c'
						}
					}
			    }
			}
		'''.processWithoutException
		val resolvedTypes = typeResolver.resolveTypes(file)
		val ifExpression = file.eAllContents.filter(XIfExpression).head
		assertNull(ifExpression.then)
		assertNull(ifExpression.^else)
		assertNotNull(resolvedTypes.getActualType(ifExpression))
	}
	
	@Test
	def void testErrorModel_077() throws Exception {
		val file = '''
			class C {
				def m() {
					try return 'literal' as as Boolean
					  catch(NullPointerException e) return 'second thing is thrown'		  
					  catch(ClassCastException e) throw new NullPointerException()
			    }
			}
		'''.processWithoutException
		val resolvedTypes = typeResolver.resolveTypes(file)
		val casted = file.eAllContents.filter(XCastedExpression).last
		assertNull(casted.type)
		assertNotNull(resolvedTypes.getActualType(casted))
	}
	
	@Test
	def void testErrorModel_078() throws Exception {
		'''
			package org.eclipse.xtend.core.tests.smoke
			
			class Case_4 {
				def richStrings_01() {
					''«»'foobar'«»'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_079() throws Exception {
		'''
			package org.eclipse.xtend.core.tests.smoke
			
			class Case_4 {
				def richStrings_01() {
					''«»'foobar''«»'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_080() throws Exception {
		'''
			package org.eclipse.xtend.core.tests.smoke
			
			class Case_4 {
				def richStrings_01() {
					''«»'foobar'«» '''.processWithoutException
	}
	
	@Test
	def void testErrorModel_081() throws Exception {
		'''
			package org.eclipse.xtend.core.tests.smoke
			
			class Case_4 {
				def richStrings_01() {
					''«»'foobar''«» '''.processWithoutException
	}
	
	@Test
	def void testErrorModel_082() throws Exception {
		'''
			package x
			class Y {
				static int j
				int i
				new() {
					this(j)
				}
				new(int i) {
					this.i = i
				}
				def static invokeMe() {
					j = 4ew Y().i
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_083() throws Exception {
		'''
			package x
			class Y {
				@com.google.inject.Inject extension test.GenericExtensionMethods<String,Integer> x
				def foo(String arg) {
					arg.method
					4ethod
					return x.result
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_084() throws Exception {
		'''
			package foo
			class Bar {
				def foo(int bar) {
					switch(bar) {
						case 1bar'
					}
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_085() throws Exception {
		'''
			package foo
			/**/
			/***/
			/** valid */
			/** valid **/
			/**
			 * invalid/
			class Bar {
				def foo(){
					1 + 1
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_086() throws Exception {
		'''
			/*
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_087() throws Exception {
		'''
			/
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_088() throws Exception {
		'''
			/**
			 * header
			 *//**
			 * javadoc
			 */
			class bar { 
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_089() throws Exception {
		'''/*'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_090() throws Exception {
		'''/'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_091() throws Exception {
		'''/**'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_092() throws Exception {
		'''
			/*
			 *'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_093() throws Exception {
		'''
			class C {
				def m(java.util.List<String[]> arg) {}
				def n() {
				  m(#[['a', 'a']])
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_094() throws Exception {
		'''
			class C {
				def enumValue(Class<?> clazz, String value) {
					if(clazz.enum)
						Enum.valueOf(clazz as Class<Enum>, value)
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_095() throws Exception {
		'''
			class C {
				def add(T item) {
					new() {
					}
				}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_096() throws Exception {
		'''
			class C {
				def add(T item) {
					class D {
						new(A<B> gen) {
							this.gen = gen
						}
					}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_097() throws Exception {
		'''
			class A {
				def void m(Class<?>... c) {
				class B extends A {
			 		override m(Class<? extends Object>... c) {}
				}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_098() throws Exception {
		fireproof('''
			import java.util.LinkedList
			
			class XList<T extends XType> {
				val items = new LinkedList<XItem<T>>
				
				def add(T item) {
					val result = new XItem<T>(this, item)
					items.add(result)
				
			
			interface XType {}
			
			class XItem<T extends XType> {
				XList<T> gen
				T item
				
				new(XList<T> gen, T item) {
					this.gen = gen
					this.item = item
				}
			}
		''')
	}
	
	@Test
	def void testErrorModel_099() throws Exception {
		fireproof('''
			package x 
			class Y {  
				static int j   
				int i   
				new() { 
					this(j   
					new(int i) {
						this.i = i
					}   
					def static invokeMe() {
						j = 47 new Y().i
					}
				}
		''')
	}
	
	@Test
	def void testErrorModel_100() throws Exception {
		'''
			package x class Y {def dispatch void recursiveMethod(CharSequence r, java.util.Set<Object> shapes) {}
			def dispatch vorecursiveMethod(Appendable c, java.util.Set<Object> shapes) {
				// If method2 is called directly, no NPE is thrown
				val Object o = method1()
			}
			def Object method1() {
				return method2()
			}
			// Inferred return type that causes the NPE
			def method2() {
				val java.util.Set<Object> objects = newHashSet()
				// If the recursive method is not called, no NPE is thrown
				recursiveMethod(new String(), objects)
				return objects.findFirst([ Object o | o instanceof CharSequence])
			}}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_101() throws Exception {
		fireproof('''
			package bug411973 class Bug {val ()=>String init new() { this([|"Hello World!"]new(()=>String init) { this.init = init } @Override override toString() { init.apply } }
		''')
	}
	
	@Test
	def void testErrorModel_102() throws Exception {
		fireproof('''
			package x class Y {def String rawListGet(java.util.List elements) {
			  if (elements.(0) instanceof String) {
			    'string'
			  } else {    'no string'  }}}
		''')
	}
	
	@Test
	def void testErrorModel_103() throws Exception {
		fireproof('''
			class C {
				def static dispatch apply(String element) {
				    throw new UnsupportedOperationException("missing implementation for " + element.class)
				}
			}
		''')
	}
	
	@Test
	def void testErrorModel_104() throws Exception {
		fireproof('''
			import com.google.common.base.Optional
			import static java.lang.Enum.*
			import java.util.List
			import java.util.Set
			class C {
				def Optional<Object> m2(Object o, List<Object> list, Object context, Set<Object> set) {
					if (o instanceof String) {
						val idx = valueOf(null, null)
						idx.present
					}
					return null
				}
			}
		''')
	}
	
	@Test
	def void testErrorModel_105() throws Exception {
		fireproof('''
			class C extends Override {
			}
		''')
	}
	
	@Test
	def void testErrorModel_106() throws Exception {
		fireproof('''
			class C extends java.lang.annotation.RetentionPolicy {
			}
		''')
	}
	
	@Test
	def void testErrorModel_107() throws Exception {
		fireproof('''
			class C {
				Override x
			}
		''')
	}
	
	@Test
	def void testErrorModel_108() throws Exception {
		fireproof('''
			class C {
				Override<String> x
			}
		''')
	}
	
	@Test
	def void testErrorModel_109() throws Exception {
		fireproof('''
			class C {
				def Override<String> x() {}
			}
		''')
	}
	
	@Test
	def void testErrorModel_110() throws Exception {
		fireproof('''
			class C {
				def x(Override<String> o) {}
			}
		''')
	}
	
	@Test
	def void testErrorModel_111() throws Exception {
		fireproof('''
			class C {
				java.lang.annotation.RetentionPolicy<String> x
			}
		''')
	}
	
	@Test
	def void testErrorModel_112() throws Exception {
		fireproof('''
			package x
			class Y {
				def String test() {
					newArrayList('fo','bar').maxBy[]
				}
				def <A,B extends Comparable<? super B>> A maxBy(Iterable<A> iterable, (A)=>B maxOn) {
					iterable.sortBy(maxOn).last
				}
			}
		''')
	}
	
	@Test
	def void testErrorModel_113() throws Exception {
		processWithoutException('''
			package org.eclipse.xtend.core.tests.smoke
			
			class Case_2 {
			
				def aOrB(String a, String b) {
					if (a.isNullOrEmpty()) 
						b
					else
						a 
				}
				
				def returnInIf() {
					if ('x'!=) return 'xx' else return 'yy'
				}
			
			}
		''')
	}
	
	@Test
	def void testErrorModel_114() throws Exception {
		'''
			class {
				def m() {
					new Runnable() { override run() {} }
				}
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_115() throws Exception {
		'''
			class Bar {
				valr = new Runnable() { override run() { println(x) } }
				public val x = 1
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_116() throws Exception {
		'''
			class Foo {
				valbar = new Runnable() { override run() {} }
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_117() throws Exception {
		'''
			class {
				val r = new Runnable() { override run() { println(x) } }
				public val x = 1
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_118() throws Exception {
		'''
			class C {
				def m(Iterable<String> iterable) {
					iterable.flatMap[].sortBy [ length ]
				}
				def <A,B extends Iterable<? extends B> flatMap(Iterable<? extends A> iterable, (A)=>B map) {
					return null
				}
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_119() throws Exception {
		'''
			class C {
				def m(Iterable<String> iterable) {
					iterable.flatMap[].sortBy [ length ]
				}
				def <A,B extends Iterable<? extends B>> flatMap(Iterable<? extends A> iterable, (A)=>B map) {
					return null
				}
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_120() throws Exception {
		'''
			class C {
				StringRepository repository
				def m()	{
					var string = repository.findByStringId(1L)
					repository.save(string)
				}
			}
			public interface StringRepository extends GraphRepository<String> {
				def String findByStringId(Long id);
			}
			interface GraphRepository<T> {
				def <U extends U save(U entity);
				def <U extends T> Iterable<U> save(Iterable<U> entities);
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_121() throws Exception {
		'''
			class C { StringRepository repository def m()	{ repository.save(#[]) }
			}
			public interface StringRepository extends GraphRepository<String> { def String findByStringId(Long id);
			}
			interface GraphRepository<T> { def <U extends U save(U entity); def <U extends T> Iterable<U> save(Iterable<U> entities);
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_122() throws Exception {
		'''
			class C { CharSeqRepository repository def m()	{ repository.<String>save(newArrayList) }
			}
			public interface CharSeqRepository extends GraphRepository<CharSequence> {
			}
			interface GraphRepository<T> { def <U extends U save(U entity); def <U extends T> Iterable<U> save(Iterable<U> entities);
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_123() throws Exception {
		'''
			class C { CharSeqRepository repository def m()	{ repository.save(#['a']) }
			}
			public interface CharSeqRepository extends GraphRepository<CharSequence> {
			}
			interface GraphRepository<T> { def <U extends U save(U entity); def <U extends T> Iterable<U> save(Iterable<U> entities);
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_124() throws Exception {
		'''
			import static com.google.common.base.Preconditions.*
			class Test<JAVA_TYPE> {
				val Functions.Function0<JAVA_TYPE> constructor
				val list = new(Functions.Function0<JAVA_TYPE> theConstructor, Class<JAVA_TYPE> theType) {
					constructor = if (theConstructor == null) new NoConstructor<JAVA_TYPE>(theType) else theConstructor
				}
				def static test(){
					new Test(null, String)
				}
			}
			class NoConstructor<JAVA_TYPE> implements Functions.Function0<JAVA_TYPE> {
				val String type
				new(String theTypeName) {
					type = checkNotNull(theTypeName, "theTypeName")
				}
				new(Class<JAVA_TYPE> theType) {
					type = checkNotNull(theType, "theType").name
				}
				override apply() {
					throw new UnsupportedOperationException("Instances of type "+type +" cannot be created (without parameters?)")
				}
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_125() throws Exception {
		'''
			class A {
				static interface B {
					class C {
						A a
						B b
						C c
						D d
						static class D {
							A a
							B b =  A.B {}
							C c = new C
							D d = new B.C.D {}
						}
					}
				}
				A a
				B b = new B {}
				B.C c
				B.C.D d
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_126() throws Exception {
		'''
			package foo
			class Test {
				def Object foo() throws Exception {
					{
						val (java.util.List<String>,String)=>java.util.List<String> functionReturningList = [$
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_127() throws Exception {
		'''
			package foo class Test {
				def Object foo() throws Exception {
					{
						val (java.util.List<String>,String)=>java.util.List<String> functionReturningList = [$ += $1 return $0 ]
						#['foo'].fold(newArrayList, functionReturningList)
					}
				}
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_128() throws Exception {
		'''
			class Test {
				extension Util
				def getRunnable() {
					new Runnable {
						override ru {
							sayHello
						}
					}
				} 
				static class Util {
					def sayHello() {
						'Hello'
					}
				}
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_129() throws Exception {
		'''
			class Test {
				def getRunnable() {
					val extension Util u = null
					new Runnable {
						override ru {
							sayHello
						}
					}
				}
				static class Util {
					def sayHello() {
						'Hello'
					}
				}
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_130() throws Exception {
		'''
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			class C {
				val int a
				val String b
				@FinalFieldsConstructor new()
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_131() throws Exception {
		'''
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			class C {
				val int a
				val String b
				@FinalFieldsConstructor new() {}
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_132() throws Exception {
		'''
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			@FinalFieldsConstructor
			class C {
				val int a
				@FinalFieldsConstructor new
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_133() throws Exception {
		'''
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			class C {
				val int a
				@FinalFieldsConstructor new() {
				FinalFieldsConstructor new() {}
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_134() throws Exception {
		'''
			class A {
				static interface B {
					class C {
						static class D {
						}
					}
				} 
				B b = B.C 
				c B.C
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_135() throws Exception {
		'''
			import .eclipse.xtend.lib.annotations.ToString
			import org.eclipse.xtend.lib.annotations.Data
			@ToString(hideFieldNames=true) @Data class Foo { String b = "Bar"
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_136() throws Exception {
		'''
			@Deprecated
			final class C {
				static extension D = D.instance
			}
			@Deprecated
			package abstract class D {
				def static instance() {
				}
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_137() throws Exception {
		'''
			class C {
				def m0() {
					return new D().m2
				}
				override protected m1() {
					new Object() {
						override m3() ''«»''«»''
					}
				}
			}
			class D {
				def m2() {
				}
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_138() throws Exception {
		val file = '''
			package test
			class Bar<T> extends test.Bar.Foo<T> {}
		'''.processWithoutException
		file.eResource.errors => [
			assertFalse(toString, exists [ message.startsWith("Cyclic ")])
		]
	}
	
	@Test
	def void testErrorModel_139() throws Exception {
		'''
			class C {
				def m() {
					MyComparator.comparingInt [String s| s.length].thenComparing[]
				}
			}
			static abstract class MyComparator<T> {
				def static <T> MyComparator<T> comparingInt(ToIntFunction<? super T> fun) {}
				def <U extends Comparable<? super U>> MyComparator<T> thenComparing(
					Function<? super T, ? extends U> keyExtractor,
					MyComparator<? super U> keyComparator)
				def MyComparator<T> thenComparing(MyComparator<? super T> other)
				def <U extends Comparable<? super U>> MyComparator<T> thenComparing(
					Function<? super T, ? extends U> keyExtractor)
			}
			interface ToIntFunction<T> {
				def int apply(T t)
			}
			interface Function<T, R> {
				def R apply(T)
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_140() throws Exception {
		'''
			class C {
				def m() {
					MyComparator.comparingInt [String s| s.length].thenComparing[]
				}
			}
			static abstract class MyComparator<T> {
				def static <T> MyComparator<T> comparingInt(ToIntFunction<? super T> fun) {}
				def <U extends Comparable<? super Iterable<? extends U>>> MyComparator<T> thenComparing(
					Function<? super T, ? extends U> keyExtractor,
					MyComparator<? super U> keyComparator)
				def MyComparator<T> thenComparing(MyComparator<? super T> other)
				def <U extends Comparable<? super U>> MyComparator<T> thenComparing(
					Function<? super T, ? extends U> keyExtractor)
			}
			interface ToIntFunction<T> {
				def int apply(T t)
			}
			interface Function<T, R> {
				def R apply(T)
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_141() throws Exception {
		'''
			import org.eclipse.xtend.lib.annotations.Data
			@D class A {}
			@Data class C extends A { val int c }
			@Data class B { val int b }
			@Data class D extends B { val double d }
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_142() throws Exception {
		'''
			class TestXtend {
				val static int a = Click(#[ a, a.bitwiseAnd(3) << 1 ])
				def meth() {}
			}
			annotation Click {
				int[] value
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_143() throws Exception {
		'''
			class {
				def void test()
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_144() throws Exception {
		noJRETester.processFile('''
			class C {
				def create "" test() {
					_createCache_test.clear
				}
			}
		''')
	}
	
	@Test
	def void testErrorModel_145() throws Exception {
		'''
			import com.google.common.base.Function
			abstract class C<A> {
				def A get();
				def <B> C<B> map(Function<A, B> f) {
					val thiz = this
					return [
						val A a = thiz.get
						val B b = f.applya)
						return b
					]
				}
			}
		'''.processWithoutException
	}
	
	def processWithoutException(CharSequence input) throws Exception {
		val resource = resourceSet.createResource(URI::createURI("abcdefg.xtend"))
		resource.load(new StringInputStream(input.toString), null)
		resourceValidator.validate(resource, CheckMode::ALL, CancelIndicator::NullImpl)
		return resource.contents.head as XtendFile
	}
	
	static class ResolveBatchedWithoutJRE extends NoJRESmokeTester {
		
		@Inject IBatchTypeResolver resolver
		
		override protected checkNoErrorsInValidator(String model, XtextResource resource) {
			resolver.resolveTypes(resource)
			super.checkNoErrorsInValidator(model, resource)
		}
		
	}
	
}