/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
		'''.buildXtendInput(true, false, false).parse.assertNoIssues
	}

	@Test
	def void test_Error_nullResource() {
		'''
			try (val a = new StringReader(s); 
				val b = ""
			) 
				a.read
		'''.buildXtendInput(true, false, false).parse.assertError(XbasePackage.Literals.XVARIABLE_DECLARATION,
			IssueCodes.INVALID_TRY_RESOURCE_TYPE, "implement java.lang.AutoCloseable")
	}

	@Test
	def void test_Error_NotAutoClosable() {
		'''
			try (val a = #[1,2,3]) {}
		'''.buildXtendInput(true, false, false).parse.assertError(XbasePackage.Literals.XVARIABLE_DECLARATION,
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
		'''.buildXtendInput(true, true, false).assertCompilesTo('''
			StringReader _stringReader = new StringReader(this.s);
			final BufferedReader br = new BufferedReader(_stringReader);
			try {
			  br.readLine();
			} finally {
			  if ((br != null)) {
			    br.close();
			  }
			}
		'''.buildJavaOutput(true, true, false, false))
	}

	@Test
	def void test_easyResource() {
		'''
			package sample
			
			import java.io.StringReader
			import java.io.IOException
			
			class FooClass {
				val s = "line1\nline2\nline3"
				def void fooMethod() {
					try (val a = new StringReader(s))
					  a.read
					catch(IOException e)
					  e.fillInStackTrace
				}
			}
		'''.assertCompilesTo('''
			package sample;
			
			import java.io.IOException;
			import java.io.StringReader;
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class FooClass {
			  private final String s = "line1\nline2\nline3";
			
			  public void fooMethod() {
			    List<Throwable> _ts = new ArrayList<Throwable>();
			    StringReader a = null;
			    try {
			      a = new StringReader(this.s);
			      a.read();
			    } catch (final Throwable _t) {
			      if (_t instanceof IOException) {
			        final IOException e = (IOException)_t;
			        e.fillInStackTrace();
			      } else {
			        _ts.add(_t);
			        throw Exceptions.sneakyThrow(_t);
			      }
			    } finally {
			      if (a != null) {
			        try {
			          a.close();
			        } catch (Throwable _t_1) {
			          _ts.add(_t_1);
			        }
			      }
			      if(!_ts.isEmpty()) throw Exceptions.sneakyThrow(_ts.get(0));
			    }
			  }
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
		'''.buildXtendInput(false, false, false).assertCompilesTo('''
			final AutoCloseable[] array = new AutoCloseable[2];
			List<Throwable> _ts = new ArrayList<Throwable>();
			AutoCloseable someCloseable = null;
			try {
			  someCloseable = array[0];
			  someCloseable.close();
			} finally {
			  if (someCloseable != null) {
			    try {
			      someCloseable.close();
			    } catch (Throwable _t) {
			      _ts.add(_t);
			    }
			  }
			  if(!_ts.isEmpty()) throw Exceptions.sneakyThrow(_ts.get(0));
			}
		'''.buildJavaOutput(false, false, false, true))
	}

		@Test
	def void test_automaticCloseButStillExceptionCatched() {
		'''
			val reader1 = new StringReader(s)
			val reader2 = new StringReader(s)
			val array = #[reader1,reader2]
			
			try (val AutoCloseable closable = array.get(0)){}
		'''.buildXtendInput(true, false, false).assertCompilesTo('''
			package sample;
			
			import java.io.StringReader;
			import java.util.ArrayList;
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
			      List<Throwable> _ts = new ArrayList<Throwable>();
			      AutoCloseable closable = null;
			      try {
			        closable = array.get(0);
			      } finally {
			        if (closable != null) {
			          try {
			            closable.close();
			          } catch (Throwable _t) {
			            _ts.add(_t);
			          }
			        }
			        if(!_ts.isEmpty()) throw Exceptions.sneakyThrow(_ts.get(0));
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
		'''.buildXtendInput(true, false, false).assertCompilesTo('''
			package sample;
			
			import java.io.StringReader;
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class FooClass {
			  private final String s = "line1\nline2\nline3";
			
			  public void fooMethod() {
			    try {
			      List<Throwable> _ts = new ArrayList<Throwable>();
			      StringReader a = null;
			      try {
			        a = new StringReader(this.s);
			        final int x = (1 + 1);
			        a.read();
			      } finally {
			        if (a != null) {
			          try {
			            a.close();
			          } catch (Throwable _t) {
			            _ts.add(_t);
			          }
			        }
			        if(!_ts.isEmpty()) throw Exceptions.sneakyThrow(_ts.get(0));
			      }
			      List<Throwable> _ts_1 = new ArrayList<Throwable>();
			      StringReader x = null;
			      try {
			        x = new StringReader(this.s);
			        x.close();
			      } finally {
			        if (x != null) {
			          try {
			            x.close();
			          } catch (Throwable _t) {
			            _ts_1.add(_t);
			          }
			        }
			        if(!_ts_1.isEmpty()) throw Exceptions.sneakyThrow(_ts_1.get(0));
			      }
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}

	@Test
	def void test_twoResources() {
		'''
			try (val sr = new StringReader(s); val buffy = new BufferedReader(sr)) {
				buffy.read
			}
		'''.buildXtendInput(true, true, false).assertCompilesTo('''
			package sample;
			
			import java.io.BufferedReader;
			import java.io.StringReader;
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class FooClass {
			  private final String s = "line1\nline2\nline3";
			
			  public void fooMethod() {
			    try {
			      List<Throwable> _ts = new ArrayList<Throwable>();
			      StringReader sr = null;
			      BufferedReader buffy = null;
			      try {
			        sr = new StringReader(this.s);
			        buffy = new BufferedReader(sr);
			        buffy.read();
			      } finally {
			        if (buffy != null) {
			          try {
			            buffy.close();
			          } catch (Throwable _t) {
			            _ts.add(_t);
			          }
			        }
			        if (sr != null) {
			          try {
			            sr.close();
			          } catch (Throwable _t) {
			            _ts.add(_t);
			          }
			        }
			        if(!_ts.isEmpty()) throw Exceptions.sneakyThrow(_ts.get(0));
			      }
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}

	@Test
	def void test_twoNestedResources() {
		'''
			try (val br = new BufferedReader(new StringReader(s));) 
				br.readLine()
		'''.buildXtendInput(true, true, false).assertCompilesTo('''
			package sample;
			
			import java.io.BufferedReader;
			import java.io.StringReader;
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class FooClass {
			  private final String s = "line1\nline2\nline3";
			
			  public void fooMethod() {
			    try {
			      List<Throwable> _ts = new ArrayList<Throwable>();
			      BufferedReader br = null;
			      try {
			        br = new BufferedReader(new StringReader(this.s));
			        br.readLine();
			      } finally {
			        if (br != null) {
			          try {
			            br.close();
			          } catch (Throwable _t) {
			            _ts.add(_t);
			          }
			        }
			        if(!_ts.isEmpty()) throw Exceptions.sneakyThrow(_ts.get(0));
			      }
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}

	@Test
	def void test_twoResourcesOneDefinedOutside() {
		'''
			val sr = new StringReader(s)
			try (val br = new BufferedReader(sr);) 
				br.readLine()
		'''.buildXtendInput(true, true, true).assertCompilesTo('''
			package sample;
			
			import java.io.BufferedReader;
			import java.io.StringReader;
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class FooClass {
			  private final String s = "line1\nline2\nline3";
			
			  public void fooMethod() {
			    try {
			      final StringReader sr = new StringReader(this.s);
			      List<Throwable> _ts = new ArrayList<Throwable>();
			      BufferedReader br = null;
			      try {
			        br = new BufferedReader(sr);
			        br.readLine();
			      } finally {
			        if (br != null) {
			          try {
			            br.close();
			          } catch (Throwable _t) {
			            _ts.add(_t);
			          }
			        }
			        if(!_ts.isEmpty()) throw Exceptions.sneakyThrow(_ts.get(0));
			      }
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}

	@Test
	def void test_nestedIf1() {
		'''
			try (val fr = new StringReader(if (true) s+"1" else s+"2"); val br = new BufferedReader(fr)) {
				br.read
			}
		'''.buildXtendInput(true, true, false).assertCompilesTo('''
			package sample;
			
			import java.io.BufferedReader;
			import java.io.StringReader;
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class FooClass {
			  private final String s = "line1\nline2\nline3";
			
			  public void fooMethod() {
			    try {
			      List<Throwable> _ts = new ArrayList<Throwable>();
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
			        if (br != null) {
			          try {
			            br.close();
			          } catch (Throwable _t) {
			            _ts.add(_t);
			          }
			        }
			        if (fr != null) {
			          try {
			            fr.close();
			          } catch (Throwable _t) {
			            _ts.add(_t);
			          }
			        }
			        if(!_ts.isEmpty()) throw Exceptions.sneakyThrow(_ts.get(0));
			      }
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
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
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class FooClass {
			  public void fooMethod() {
			    List<Throwable> _ts = new ArrayList<Throwable>();
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
			        _ts.add(_t);
			        throw Exceptions.sneakyThrow(_t);
			      }
			    } finally {
			      if (a != null) {
			        try {
			          a.close();
			        } catch (Throwable _t_1) {
			          _ts.add(_t_1);
			        }
			      }
			      if(!_ts.isEmpty()) throw Exceptions.sneakyThrow(_ts.get(0));
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
		'''.buildXtendInput(false, false, false).assertCompilesTo('''
			List<Throwable> _ts = new ArrayList<Throwable>();
			AutoCloseable r = null;
			try {
			  r = new AutoCloseable() {
			    public void close() throws Exception {
			      System.out.println("Closing");
			    }
			  };
			} finally {
			  if (r != null) {
			    try {
			      r.close();
			    } catch (Throwable _t) {
			      _ts.add(_t);
			    }
			  }
			  if(!_ts.isEmpty()) throw Exceptions.sneakyThrow(_ts.get(0));
			}
		'''.buildJavaOutput(false, false, false, true))
	}
	
	@Test
	def void test_tryWithLambda02 () {
		'''
		val myList = newArrayList;
		try (val someCloseable = [ myList.add('close') ]) {
		  myList.add('body')
		}
		'''.buildXtendInput(false, false, false).assertCompilesTo(
		'''
		package sample;
		
		import java.util.ArrayList;
		import java.util.List;
		import org.eclipse.xtext.xbase.lib.CollectionLiterals;
		import org.eclipse.xtext.xbase.lib.Exceptions;
		
		@SuppressWarnings("all")
		public class FooClass {
		  private final String s = "line1\nline2\nline3";
		
		  public void fooMethod() {
		    try {
		      final ArrayList<String> myList = CollectionLiterals.<String>newArrayList();
		      List<Throwable> _ts = new ArrayList<Throwable>();
		      AutoCloseable someCloseable = null;
		      try {
		        someCloseable = new AutoCloseable() {
		          public void close() throws Exception {
		            myList.add("close");
		          }
		        };
		        myList.add("body");
		      } finally {
		        if (someCloseable != null) {
		          try {
		            someCloseable.close();
		          } catch (Throwable _t) {
		            _ts.add(_t);
		          }
		        }
		        if(!_ts.isEmpty()) throw Exceptions.sneakyThrow(_ts.get(0));
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
	def private CharSequence buildXtendInput(CharSequence input, boolean needsStringReader,
		boolean needsBufferedReader, boolean needsLists) {
		return '''
			package sample
			
			«IF needsLists»
			import java.util.ArrayList;
			import java.util.List;
			«ENDIF»
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
		boolean needsBufferedReader, boolean needsFunc0, boolean needsLists) {
		return '''
			package sample;
			
			«IF needsLists»
			import java.util.ArrayList;
			import java.util.List;
			«ENDIF»
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
