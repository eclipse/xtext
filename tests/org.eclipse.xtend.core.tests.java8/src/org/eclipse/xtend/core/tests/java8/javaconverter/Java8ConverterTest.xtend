/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.javaconverter

import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtend.core.tests.javaconverter.JavaConverterTest
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test

/**
 * @author dhuebner - Initial contribution and API
 */
@InjectWith(Java8RuntimeInjectorProvider)
class Java8ConverterTest extends JavaConverterTest {

	@Test def void testDiamondOperator() throws Exception {
		assertEquals('''
		def List<?> foo() {
			var List<String> x=new ArrayList() 
			return new ArrayList() 
		}'''.toString, '''
		public List<?> foo() {
			List<String> x = new ArrayList<>();
			return new ArrayList<>();
		}'''.toXtendClassBodyDeclr)
	}

	@Test def void testJava7() throws Exception {
		assertEquals('''
		package int thousand=1_000
		package int million=1_000_000
		package double d1=1000_000.0d
		// long a1 = 0b1000_1010_0010_1101_1010_0001_0100_0101L;
		package Map<String, List<String>> trades=new TreeMap()
		def void processTrade(String t) {
			
			switch (t) {
				case "NEW",
				case "EXECUTE",
				case "PENDING",
				default :{
					
				}
			}try (var FileInputStream in=new FileInputStream("java7.txt") ){
				System.out.println(in.read()) throw new IllegalAccessException()
			} catch (IOException ) {
				e.printStackTrace() 
			} catch (IllegalAccessException ) {
				e.printStackTrace() 
			}
			
		}'''.toString, '''
			int thousand = 1_000;
			int million = 1_000_000;
			double d1 = 1000_000.0d;
			// long a1 = 0b1000_1010_0010_1101_1010_0001_0100_0101L;
			Map<String, List<String>> trades = new TreeMap<>();
			
			public void processTrade(String t) {
				switch (t) {
				case "NEW":
				case "EXECUTE":
				case "PENDING":
				default:
				}
				try (FileInputStream in = new FileInputStream("java7.txt")) {
					System.out.println(in.read());
					throw new IllegalAccessException();
				} catch (IOException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		'''.toXtendClassBodyDeclr)
	}

	@Test def void testDefaultMethod() throws Exception {
		DUMP = true
		val clazz = toValidXtendInterface('''
		public interface XtendInterfaze {
		  public default String foo() {
		    return "- Hi, I\'m a default impl";
		  }
		  
		  public abstract String baar();
		}''')

		assertNotNull(clazz)
	}

	@Test def void testSimpleLambda() throws Exception {
		val clazz = toValidXtendClass('''
			import java.awt.EventQueue;
			import java.util.concurrent.Callable;
			class Test {
			public void javaLambda(){
				 EventQueue.invokeLater(() -> System.out.println("invoked later"));
				 Callable<Runnable> callable = () -> () -> 
				          System.out.println("callable says hello");
			}
			static Runnable getRunnable(String s)
			   {
			      return () -> System.out.println(s);
			   }
			}
		''')
		assertNotNull(clazz)
	}

	@Test def void testSimpleLambda_2() throws Exception {
		assertEquals(
		'''
		def void javaLambda() {
			EventQueue.invokeLater([System.out.println("invoked later")]) var Callable<Runnable> callable=[[System.out.println("callable says hello")]] 
			
		}
		def static package Runnable getRunnable(String s) {
			return [System.out.println(s)] 
		}'''.toString, '''
			public void javaLambda(){
				 EventQueue.invokeLater(() -> System.out.println("invoked later"));
				 Callable<Runnable> callable = () -> () -> 
				          System.out.println("callable says hello");
			}
			static Runnable getRunnable(String s)
			   {
			      return () -> System.out.println(s);
			   }
		'''.toXtendClassBodyDeclr)
	}
}