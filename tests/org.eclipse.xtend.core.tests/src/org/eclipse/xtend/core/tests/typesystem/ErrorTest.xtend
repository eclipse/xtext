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
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.xbase.XAssignment
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.junit.Test
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XCastedExpression

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
	
	@Test
	def void testErrorModel_01() throws Exception {
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
	def void testErrorModel_02() throws Exception {
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
	def void testErrorModel_03() throws Exception {
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
	def void testErrorModel_04() throws Exception {
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
	def void testErrorModel_05() throws Exception {
		val file = '''
			@
		'''.processWithoutException
		val typeDeclaration = file.xtendTypes.head
		val annotations = typeDeclaration.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_06() throws Exception {
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
	def void testErrorModel_07() throws Exception {
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
	def void testErrorModel_08() throws Exception {
		val file = '''
			annotation Bar { @
		'''.processWithoutException
		val typeDeclaration = file.xtendTypes.last
		val annotations = typeDeclaration.members.last.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_09() throws Exception {
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
	def void testErrorModel_10() throws Exception {
		val file = '''
			@SuppressWarnings("unused"
		'''.processWithoutException
		val typeDeclaration = file.xtendTypes.last
		val annotations = typeDeclaration.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_11() throws Exception {
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
	def void testErrorModel_12() throws Exception {
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
	def void testErrorModel_13() throws Exception {
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
	def void testErrorModel_14() throws Exception {
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
	def void testErrorModel_15() throws Exception {
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
	def void testErrorModel_16() throws Exception {
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
	def void testErrorModel_17() throws Exception {
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
		val implicit = closure.implicitParameter
		assertNotNull(implicit)
		val resolvedTypes = typeResolver.resolveTypes(implicit)
		assertNotNull(resolvedTypes.getActualType(implicit))
	}
	
	@Test
	def void testErrorModel_18() throws Exception {
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
	def void testErrorModel_19() throws Exception {
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
	def void testErrorModel_20() throws Exception {
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
	def void testErrorModel_21() throws Exception {
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
	def void testErrorModel_22() throws Exception {
		'''
			package generics class Bar {
				def <T extends (Object)=>T> T bar( t) {
					bar(t).apply(bar(t))
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_23() throws Exception {
		'''
			package generics class Bar {
				def <T extends (Object)=>T> T bar() {
					bar(t).apply(bar(t))
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_24() throws Exception {
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
	def void testErrorModel_25() throws Exception {
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
	def void testErrorModel_26() throws Exception {
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
	def void testErrorModel_27() throws Exception {
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
	def void testErrorModel_28() throws Exception {
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
	def void testErrorModel_30() throws Exception {
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
	def void testErrorModel_31() throws Exception {
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
	def void testErrorModel_32() throws Exception {
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
	def void testErrorModel_33() throws Exception {
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
	def void testErrorModel_34() throws Exception {
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
	def void testErrorModel_35() throws Exception {
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
	def void testErrorModel_36() throws Exception {
		'''
			class Bar<T extends T> {
				new Bar(T t) {
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_37() throws Exception {
		'''
			class Bar<T1 extends T2, T2 extends T1> {
				new Bar(T1 t1, T2 t2) {
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_38() throws Exception {
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
	def void testErrorModel_39() throws Exception {
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
	def void testErrorModel_40() throws Exception {
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
	def void testErrorModel_41() throws Exception {
		'''
			class E<T> extends E<T> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_42() throws Exception {
		'''
			class C<T> extends E<T> {}
			class D<T> extends C<T> {}
			class E<T> extends D<T> {}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_43() throws Exception {
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
	def void testErrorModel_44() throws Exception {
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
	def void testErrorModel_45() throws Exception {
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
	def void testErrorModel_46() throws Exception {
		'''
			annotation DependsOn {
				Class<?>[] value = #[ typeof(), typeof(CharSequence) ]
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_47() throws Exception {
		'''
			@Data class Weight<T extends Comparable<T>> implements Comparable<Weight<T>> {
				T weight
				
				override int compareTo(Weight<T> w) {
					this.weight.compareTo
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_48() throws Exception {
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
	def void testErrorModel_49() throws Exception {
		'''
			class C {
				def m(Class<?> type) {
					type.enumConstants.findFirst[ it != null]
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_50() throws Exception {
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
	def void testErrorModel_51() throws Exception {
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
	def void testErrorModel_52() throws Exception {
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
	def void testErrorModel_53() throws Exception {
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
	def void testErrorModel_54() throws Exception {
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
	def void testErrorModel_55() throws Exception {
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
	def void testErrorModel_56() throws Exception {
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
	def void testErrorModel_57() throws Exception {
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
	def void testErrorModel_58() throws Exception {
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
	def void testErrorModel_59() throws Exception {
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
	def void testErrorModel_60() throws Exception {
		'''
			class C {
				def m() {
					newArrayList.fold(newHashMap) [a,b | a.put]
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_61() throws Exception {
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
	def void testErrorModel_62() throws Exception {
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
	def void testErrorModel_63() throws Exception {
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
	def void testErrorModel_64() throws Exception {
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
	def void testErrorModel_65() throws Exception {
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
	def void testErrorModel_66() throws Exception {
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
	def void testErrorModel_67() throws Exception {
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
	def void testErrorModel_68() throws Exception {
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
	def void testErrorModel_69() throws Exception {
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
	def void testErrorModel_70() throws Exception {
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
	def void testErrorModel_71() throws Exception {
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
	def void testErrorModel_72() throws Exception {
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
	def void testErrorModel_73() throws Exception {
		'''
			class C {
				def static dispatch m(DoesNotExist d) {
					m(d)
				}
			}
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_74() throws Exception {
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
	def void testErrorModel_75() throws Exception {
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
	def void testErrorModel_76() throws Exception {
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
	def void testErrorModel_77() throws Exception {
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
	def void testErrorModel_78() throws Exception {
		'''
			package org.eclipse.xtend.core.tests.smoke
			
			class Case_4 {
				def richStrings_01() {
					''«»'foobar'«»'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_79() throws Exception {
		'''
			package org.eclipse.xtend.core.tests.smoke
			
			class Case_4 {
				def richStrings_01() {
					''«»'foobar''«»'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_80() throws Exception {
		'''
			package org.eclipse.xtend.core.tests.smoke
			
			class Case_4 {
				def richStrings_01() {
					''«»'foobar'«» '''.processWithoutException
	}
	
	@Test
	def void testErrorModel_81() throws Exception {
		'''
			package org.eclipse.xtend.core.tests.smoke
			
			class Case_4 {
				def richStrings_01() {
					''«»'foobar''«» '''.processWithoutException
	}
	
	@Test
	def void testErrorModel_82() throws Exception {
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
	def void testErrorModel_83() throws Exception {
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
	def void testErrorModel_84() throws Exception {
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
	def void testErrorModel_85() throws Exception {
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
	def void testErrorModel_86() throws Exception {
		'''
			/*
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_87() throws Exception {
		'''
			/
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_88() throws Exception {
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
	def void testErrorModel_89() throws Exception {
		'''/*'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_90() throws Exception {
		'''/'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_91() throws Exception {
		'''/**'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_92() throws Exception {
		'''
			/*
			 *'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_93() throws Exception {
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
	def void testErrorModel_94() throws Exception {
		'''
			class C {
				def enumValue(Class<?> clazz, String value) {
					if(clazz.enum)
						Enum.valueOf(clazz as Class<Enum>, value)
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
	
}