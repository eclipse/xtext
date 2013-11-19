/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib

import java.io.File
import java.io.FileWriter
import org.eclipse.xtext.util.Files

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ArrayExtensionsGenerator {
	def startMarker() {
		"// BEGIN generated code"
	}

	def endMarker() {
		"// END generated code"
	}

	val primitiveTypes = newArrayList("boolean", "double", "float", "long", "int", "char", "short", "byte")

	def static void main(String[] args) {
		new ArrayExtensionsGenerator().generateFile();
	}

	def generateFile() {
		val file = new File("../org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/ArrayExtensions.java")
		if (!file.exists)
			throw new IllegalStateException("file "+file+" doesn't exist.");
		
		val content = Files.readFileIntoString(file.absolutePath)
		if (content.indexOf(startMarker)==-1) {
			throw new IllegalStateException("File "+file+" doesn't contain '// BEGIN generated code' marker.");
		}
		val newContent = '''
			«content.substring(0, content.indexOf(startMarker)+startMarker.length)»
				
				«generateAllOperations()»
			«content.substring(content.indexOf(endMarker))»
		'''		
		val writer = new FileWriter(file)
		writer.append(newContent)
		writer.close()
		println("generation finished")
	}

	def generateAllOperations() '''
		«generateLength('Object')»
		
		«generateHashCode('Object')»
		
		«generateEquals('Object')»
		«FOR t : primitiveTypes»
			
			«generateGet(t)»
			
			«generateSet(t)»
			
			«generateLength(t)»
			
			«generateHashCode(t)»
			
			«generateEquals(t)»
			
			«generateClone(t)»
		«ENDFOR»
	'''
	
	def generateClone(String string) '''
		/**
		 * Clones the array. @see {@link Object#clone}
		 * 
		 * @param array
		 *            the array
		 * @return the cloned array
		 * @since 2.5
		 */
		@Pure
		@Inline("$1.clone()")
		public static «string»[] clone(«string»[] array) {
			return array.clone();
		}
	'''
	
	def generateEquals(String string) '''
		/**
		 * Returns whether the array and the given other object are equal.
		 * 
		 * Delegates to {@link Arrays#equals(«string»[], «string»[])}
		 * 
		 * @param array
		 *            the array
		 * @param other
		 *            the other element to compare to
		 * @return the hash code
		 * @since 2.5
		 */
		@Pure
		public static boolean equals(«string»[] array, Object other) {
			if (other instanceof «string»[]) {
				return Arrays.equals(array, («string»[]) other);
			}
			return false;
		}
	'''
	
	def generateHashCode(String string) '''
		/**
		 * Returns a hash code value for the given array.
		 * 
		 * @param array
		 *            the array
		 * @return the hash code
		 * @since 2.5
		 */
		@Pure
		@Inline("$1.hashCode()")
		public static int hashCode(«string»[] array) {
			return array.hashCode();
		}
	'''
	
	def generateLength(String string) '''
		/**
		 * @param array
		 *            the array
		 * @return the length of the given array
		 */
		@Pure
		@Inline("$1.length")
		public static int length(«string»[] array) {
			return array.length;
		}
	'''
	
	def generateSet(String string) '''
		/**
		 * @param array
		 *            the array
		 * @param index
		 *            the index the value should be set at
		 * @param value
		 *            the value to set at the given index
		 */
		@Inline("$1[$2] = $3")
		public static void set(«string»[] array, int index, «string» value) {
			array[index] = value;
		}
	'''
	
	def generateGet(String string) '''
		/**
		 * @param array
		 *            the array
		 * @param index
		 *            the index
		 * @return the value at the given index
		 */
		@Pure
		@Inline("$1[$2]")
		public static «string» get(«string»[] array, int index) {
			return array[index];
		}
	'''
	
}
