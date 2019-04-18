/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.eclipse.xtext.xbase.XbasePackage

/**
 * @author Eva Poell - Initial contribution and API
 */
class TryWithResourcesTest extends AbstractXtendCompilerTest {

	@Inject extension ValidationTestHelper
	@Inject extension ParseHelper<XtendFile>

	// Validation Tests
	// ------------------
	@Test
	def void test_noIssues() {
		'''
			try (val a = new StringReader(s); 
			) 
				a.read
		'''.buildXtendInput(true, false).parse.assertNoIssues
	}

	@Test
	def void test_Error_nullResource() {
		'''
			try (val a = new StringReader(s); 
				val b = ""
			) 
				a.read
		'''.buildXtendInput(true, false).parse.assertError(XbasePackage.Literals.XVARIABLE_DECLARATION,
			IssueCodes.INVALID_TRY_RESOURCE_TYPE, "implement java.lang.AutoCloseable")
	}

	@Test
	def void test_Error_NotAutoClosable() {
		'''
			try (val a = #[1,2,3]) {}
		'''.buildXtendInput(true, false).parse.assertError(XbasePackage.Literals.XVARIABLE_DECLARATION,
			IssueCodes.INVALID_TRY_RESOURCE_TYPE, "implement java.lang.AutoCloseable")
	}


	// Compilation Tests
	// -------------------
	@Test
	def void test_normalTryWithoutResource() {
		'''
			val br = new BufferedReader(new StringReader(s));
			try 
				br.readLine()
			finally
				if(br !== null)
					br.close()
		'''.test2('''
			StringReader _stringReader = new StringReader(this.s);
			final BufferedReader br = new BufferedReader(_stringReader);
			try {
			  br.readLine();
			} finally {
			  if ((br != null)) {
			    br.close();
			  }
			}
		''')
	}

	@Test
	def void test_easyResource() {
		'''
			try (val a = new StringReader(s))
			a.read
		'''.test1('''
			StringReader a = null;
			try {
			  a = new StringReader(this.s);
			  a.read();
			} finally {
			  if (a != null) a.close();
			}
		''')
	}

	@Test
	def test_assumeTypeAutoClosable() {
		'''
			val array = newArrayOfSize(2)
			try(val someCloseable = array.get(0)) {
				someCloseable.close
			}
		'''.test0('''
			final AutoCloseable[] array = new AutoCloseable[2];
			AutoCloseable someCloseable = null;
			try {
			  someCloseable = array[0];
			  someCloseable.close();
			} finally {
			  if (someCloseable != null) someCloseable.close();
			}
		''')
	}

		@Test
	def void test_automaticCloseButStillExceptionCatched() {
		'''
			val reader1 = new StringReader(s)
			val reader2 = new StringReader(s)
			val array = #[reader1,reader2]
			
			try (val AutoCloseable closable = array.get(0)){}
		'''.buildXtendInput(true, false).assertCompilesTo('''
			package sample;
			
			import java.io.StringReader;
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class FooClass {
			  private final String s = "line1\nline2\nline3";
			  
			  public void fooMethod() {
			    try {
			      final StringReader reader1 = new StringReader(this.s);
			      final StringReader reader2 = new StringReader(this.s);
			      final List<StringReader> array = Collections.<StringReader>unmodifiableList(CollectionLiterals.<StringReader>newArrayList(reader1, reader2));
			      AutoCloseable closable = null;
			      try {
			        closable = array.get(0);
			      } finally {
			        if (closable != null) closable.close();
			      }
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}

	@Test
	def test_noteSecretVariableNames() {
		'''
			try (val a = new StringReader(s)){
				val x = 1+1
				a.read
			}
			
			try(val x = new StringReader(s)) {
				x.close
			}
		'''.test1('''
			StringReader a = null;
			try {
			  a = new StringReader(this.s);
			  final int x = (1 + 1);
			  a.read();
			} finally {
			  if (a != null) a.close();
			}
			StringReader x = null;
			try {
			  x = new StringReader(this.s);
			  x.close();
			} finally {
			  if (x != null) x.close();
			}
		''')
	}

	@Test
	def void test_twoResources() {
		'''
			try (val sr = new StringReader(s); val buffy = new BufferedReader(sr)) {
				buffy.read
			}
		'''.test2('''
			StringReader sr = null;
			BufferedReader buffy = null;
			try {
			  sr = new StringReader(this.s);
			  buffy = new BufferedReader(sr);
			  buffy.read();
			} finally {
			  if (buffy != null) buffy.close();
			  if (sr != null) sr.close();
			}
		''')
	}

	@Test
	def void test_twoNestedResources() {
		'''
			try (val br = new BufferedReader(new StringReader(s));) 
				br.readLine()
		'''.test2('''
			BufferedReader br = null;
			try {
			  br = new BufferedReader(new StringReader(this.s));
			  br.readLine();
			} finally {
			  if (br != null) br.close();
			}
		''')
	}

	@Test
	def void test_twoResourcesOneDefinedOutside() {
		'''
			val sr = new StringReader(s)
			try (val br = new BufferedReader(sr);) 
				br.readLine()
		'''.test2('''
			final StringReader sr = new StringReader(this.s);
			BufferedReader br = null;
			try {
			  br = new BufferedReader(sr);
			  br.readLine();
			} finally {
			  if (br != null) br.close();
			}
		''')
	}

	@Test
	def void test_nestedIf1() {
		'''
			try (val fr = new StringReader(if (true) s+"1" else s+"2"); val br = new BufferedReader(fr)) {
				br.read
			}
		'''.test3('''
			StringReader fr = null;
			BufferedReader br = null;
			try {
			  fr = new Function0<StringReader>() {
			    public StringReader apply() {
			      String _xifexpression = null;
			      if (true) {
			        _xifexpression = (FooClass.this.s + "1");
			      } else {
			        _xifexpression = (FooClass.this.s + "2");
			      }
			      return new StringReader(_xifexpression);
			    }
			  }.apply();
			  br = new BufferedReader(fr);
			  br.read();
			} finally {
			  if (br != null) br.close();
			  if (fr != null) fr.close();
			}
		''')
	}

	@Test
	def void test_ResourceIOException() {
		'''
			package sample
			
			import java.io.File
			import java.io.FileReader
			import java.io.IOException
			
			class FooClass {
			
				def void fooMethod() {
					try (val a = new FileReader(new File("\\home/docs/text.txt")))
						a.read
					catch(IOException e)
						e.fillInStackTrace
				}
			}
		'''.assertCompilesTo(
		'''
			package sample;
			
			import java.io.File;
			import java.io.FileReader;
			import java.io.IOException;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class FooClass {
			  public void fooMethod() {
			    FileReader a = null;
			    try {
			      a = new Function0<FileReader>() {
			        public FileReader apply() {
			          try {
			            File _file = new File("\\home/docs/text.txt");
			            return new FileReader(_file);
			          } catch (Throwable _e) {
			            throw Exceptions.sneakyThrow(_e);
			          }
			        }
			      }.apply();
			      a.read();
			    } catch (final Throwable _t) {
			      if (_t instanceof IOException) {
			        final IOException e = (IOException)_t;
			        e.fillInStackTrace();
			      } else {
			        throw Exceptions.sneakyThrow(_t);
			      }
			    } finally {
			      if (a != null) a.close();
			    }
			  }
			}
		''')
	}

	@Test
	def void test_tryWithLambda01 () {
		'''
			try (var r = [System.out.println("Closing")]) {
			}
		'''.test0('''
			AutoCloseable r = null;
			try {
			  r = new AutoCloseable() {
			    public void close() throws Exception {
			      System.out.println("Closing");
			    }
			  };
			} finally {
			  if (r != null) r.close();
			}
		''')
	}
	
	@Test
	def void test_tryWithLambda02 () {
		'''
		val myList = newArrayList;
		try (val someCloseable = [ myList.add('close') ]) {
			myList.add('body')
		}
		'''.buildXtendInput(false, false).assertCompilesTo(
		'''
		package sample;
		
		import java.util.ArrayList;
		import org.eclipse.xtext.xbase.lib.CollectionLiterals;
		import org.eclipse.xtext.xbase.lib.Exceptions;
		
		@SuppressWarnings("all")
		public class FooClass {
		  private final String s = "line1\nline2\nline3";
		  
		  public void fooMethod() {
		    try {
		      final ArrayList<String> myList = CollectionLiterals.<String>newArrayList();
		      AutoCloseable someCloseable = null;
		      try {
		        someCloseable = new AutoCloseable() {
		          public void close() throws Exception {
		            myList.add("close");
		          }
		        };
		        myList.add("body");
		      } finally {
		        if (someCloseable != null) someCloseable.close();
		      }
		    } catch (Throwable _e) {
		      throw Exceptions.sneakyThrow(_e);
		    }
		  }
		}
		'''
		)
	}


	// Helpers
	// ---------
	/** Test does not need any imports besides 'Exceptions'*/
	def private void test0(CharSequence input, CharSequence expected) {
		(input.buildXtendInput(false, false)).assertCompilesTo(expected.buildJavaOutput(false, false, false))
	}
	
	/** Test needs 'StringReader'*/
	def private void test1(CharSequence input, CharSequence expected) {
		(input.buildXtendInput(true, false)).assertCompilesTo(expected.buildJavaOutput(true, false, false))
	}

	/** Test needs 'StringReader' and 'BufferedReader'*/
	def private void test2(CharSequence input, CharSequence expected) {
		(input.buildXtendInput(true, true)).assertCompilesTo(expected.buildJavaOutput(true, true, false))
	}

	/** Test needs 'StringReader', 'BufferedReader' and 'Functions.Function0' */
	def private void test3(CharSequence input, CharSequence expected) {
		(input.buildXtendInput(true, true)).assertCompilesTo(expected.buildJavaOutput(true, true, true))
	}

	def private CharSequence buildXtendInput(CharSequence input, boolean needsStringReader,
		boolean needsBufferedReader) {
		return '''
			package sample
							
			«IF needsBufferedReader»import java.io.BufferedReader«ENDIF»
			«IF needsStringReader»import java.io.StringReader«ENDIF»
			
			class FooClass {
				val s = "line1\nline2\nline3"
				def void fooMethod() {
					«input»
				}
			}
		'''
	}

	def private CharSequence buildJavaOutput(CharSequence expected, boolean needsStringReader,
		boolean needsBufferedReader, boolean needsFunc0) {
		return '''
			package sample;
			
			«IF needsBufferedReader»import java.io.BufferedReader;«ENDIF»
			«IF needsStringReader»import java.io.StringReader;«ENDIF»
			import org.eclipse.xtext.xbase.lib.Exceptions;
			«IF needsFunc0»import org.eclipse.xtext.xbase.lib.Functions.Function0;«ENDIF»
			
			@SuppressWarnings("all")
			public class FooClass {
			  private final String s = "line1\nline2\nline3";
			  
			  public void fooMethod() {
			    try {
			      «expected»
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		'''
	}
}
