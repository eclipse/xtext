package org.eclipse.xtext.xbase.lib

import com.google.inject.Inject
import java.io.File
import java.io.FileWriter
import java.util.List
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping

import static org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping.*
import org.eclipse.xtext.xbase.XbaseStandaloneSetup
import org.eclipse.xtext.util.Files

class ArithmeticExtensionGenerator {
	def static void main(String[] args) {
		new XbaseStandaloneSetup()
			.createInjectorAndDoEMFRegistration()
			.getInstance(ArithmeticExtensionGenerator)
			.generate()
	}
	
	String since = "2.3"
	
	List<String> types = newArrayList("double", "float", "long", "int", "char", "short", "byte")
	
	List<QualifiedName> comparators = newArrayList(LESS_THAN, LESS_EQUALS_THAN, 
			GREATER_THAN, GREATER_EQUALS_THAN, EQUALS, NOT_EQUALS
	)
	
	List<QualifiedName> operators = newArrayList(PLUS, MINUS, MULTIPLY, DIVIDE, MODULO, LESS_THAN,
			LESS_EQUALS_THAN, GREATER_THAN, GREATER_EQUALS_THAN, EQUALS, NOT_EQUALS
	)
	
	@Inject extension OperatorMapping
	
	
	def generate() {
		val path = "../org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/"
		new File(path).mkdirs()
		for(type: types) {
			val file = new File(path + type.className + ".java")
			val newContent = if(file.exists) {
				val content = Files.readFileIntoString(file.absolutePath)
				'''
					«content.substring(0, content.indexOf(startMarker))»
						«generateAllOperations(type)»
					«content.substring(content.indexOf(endMarker) + endMarker.length)»
				'''		
			} else {
				generate(type)
			}
			val writer = new FileWriter(file)
			writer.append(newContent)
			writer.close()
		}
	}
		
	def generate(String type) '''
		/*******************************************************************************
		 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
		 * All rights reserved. This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v1.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v10.html
		 *******************************************************************************/
		package org.eclipse.xtext.xbase.lib;
		
		/**
		 * This is an extension library for {@link «type.wrapperType»} numbers.
		 * 
		 * @author Jan Koehnlein - Code generator
		 * @since «since»
		 */
		public class «type.className» {
			«type.generateAllOperations»
		}
	''' 
	
	def generateAllOperations(String type) '''
		«startMarker»
		/**
		 * The unary <code>minus</code> operator. This is the equivalent to the Java's <code>-</code> function.
		 * 
		 * @param a  «type.article» «type.wrapperType.toFirstLower».
		 * @return   <code>-a</code>
		 * @since «since»
		 */
		@Pure
		@Inline(value="(-$1)", constantExpression=true)
		public static «returnType(type, MINUS, type)» «MINUS.methodName»(«type» a) {
			return -a;
		}
		
		«FOR other: types»
			«generateOperations(type, other)»
		«ENDFOR» 
		«endMarker»
	'''

	def generateOperations(String op1, String op2) '''
		«FOR operator: operators»
			/**
			 * The binary <code>«operator.methodName.toString.replace('operator_', '')»</code> operator. This is the equivalent to the Java <code>«operator.toHtml»</code> operator.
			 * 
			 * @param a  «op1.article» «op1.wrapperType.toFirstLower».
			 * @param b  «op2.article» «op2.wrapperType.toFirstLower».
			 * @return   <code>a«operator.toHtml»b</code>
			 * @since «since»
			 */
			@Pure
			@Inline(value="($1 «operator» $2)", constantExpression=true)
			public static «returnType(op1, operator, op2)» «operator.methodName»(«op1» a, «op2» b) {
				return a «operator» b;
			}
			
		«ENDFOR»
		/**
		 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
		 * 
		 * @param a  «op1.article» «op1.wrapperType.toFirstLower».
		 * @param b  «op2.article» «op2.wrapperType.toFirstLower».
		 * @return   <code>Math.pow(a, b)</code>
		 * @since «since»
		 */
		@Pure
		@Inline(value="$3.pow($1, $2)", imported=Math.class)
		public static double «POWER.methodName»(«op1» a, «op2» b) {
			return Math.pow(a, b);
		}
		
		/**
		 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
		 * operator.
		 * 
		 * @param a  «op1.article» «op1.wrapperType.toFirstLower».
		 * @param b  «op2.article» «op2.wrapperType.toFirstLower».
		 * @return   <code>a == b</code>
		 * @since 2.4
		 */
		@Pure
		@Inline(value="($1 == $2)", constantExpression=true)
		public static boolean «TRIPLE_EQUALS.methodName»(«op1» a, «op2» b) {
			return a == b;
		}
		
		/**
		 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
		 * operator.
		 * 
		 * @param a  «op1.article» «op1.wrapperType.toFirstLower».
		 * @param b  «op2.article» «op2.wrapperType.toFirstLower».
		 * @return   <code>a != b</code>
		 * @since 2.4
		 */
		@Pure
		@Inline(value="($1 != $2)", constantExpression=true)
		public static boolean «TRIPLE_NOT_EQUALS.methodName»(«op1» a, «op2» b) {
			return a != b;
		}
		
	'''
	
	/**
	 * Binary numeric promotion, see http://java.sun.com/docs/books/jls/second_edition/html/conversions.doc.html#170983
	 */
	def returnType(String o1, QualifiedName operator, String o2) {
		if(comparators.contains(operator)) {
			'boolean'
		} else {
			val operands = newHashSet(o1, o2);
			if(operands.contains('double'))
				'double'
			else if(operands.contains('float'))
				'float'
			else if(operands.contains('long'))
				'long'
			else 
				'int'
		}
	}
	
	def article(String it) {
		switch(it.toLowerCase.substring(0, 1)) {
			case 'a':
				'an'
			case 'e':
				'an'
			case 'i':
				'an'
			case 'o':
				'an'
			case 'u':
				'an'
			default:
				'a'
			
		}
	}
	def wrapperType(String it) {
		switch(it) {
			case "int": "Integer"
			case "char": "Character"
			default: toFirstUpper
		}
	}
	
	def className(String it) {
		wrapperType + "Extensions"
	}
	
	def toHtml(QualifiedName it) {
		toString.replace("<", "&lt;").replace(">", "&gt;")
	}

	def startMarker() {
		"// BEGIN generated code"
	}		
	
	def endMarker() {
		"// END generated code"
	}		
	
}