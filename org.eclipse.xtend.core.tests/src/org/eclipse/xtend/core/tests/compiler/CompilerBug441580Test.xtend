/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug441580Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			import java.io.InputStream
			import java.io.ByteArrayOutputStream
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			class C {
				def loadSample(String fileName) {
					var InputStream in = null
					var ByteArrayOutputStream out = null
					try {
						in = class.classLoader.getResourceAsStream(fileName)
						out = new ByteArrayOutputStream
						var byte[] buffer = newByteArrayOfSize(2048)
						var int size  
						while((size = in.read(buffer)) != -1) {
							out.write(buffer, 0, size)
						}
						out.flush
						return  out.toByteArray
					} finally {
						in?.close
						out?.close
					}
				}
			}
		''', '''
			import java.io.ByteArrayOutputStream;
			import java.io.InputStream;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class C {
			  public byte[] loadSample(final String fileName) {
			    try {
			      InputStream in = null;
			      ByteArrayOutputStream out = null;
			      try {
			        Class<? extends C> _class = this.getClass();
			        ClassLoader _classLoader = _class.getClassLoader();
			        InputStream _resourceAsStream = _classLoader.getResourceAsStream(fileName);
			        in = _resourceAsStream;
			        ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
			        out = _byteArrayOutputStream;
			        byte[] buffer = new byte[2048];
			        int size = 0;
			        while (((size = in.read(buffer)) != (-1))) {
			          out.write(buffer, 0, size);
			        }
			        out.flush();
			        return out.toByteArray();
			      } finally {
			        if (in!=null) {
			          in.close();
			        }
			        if (out!=null) {
			          out.close();
			        }
			      }
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class C {
				def m() {
					var int i = 0
					if ((i = i+1) < 10) {}
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public Object m() {
			    Object _xblockexpression = null;
			    {
			      int i = 0;
			      Object _xifexpression = null;
			      if (((i = (i + 1)) < 10)) {
			        _xifexpression = null;
			      }
			      _xblockexpression = _xifexpression;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class C {
				def m() {
					var int i = 0
					if ((i = (i=i+1)) < (i=(i+1))) {}
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public Object m() {
			    Object _xblockexpression = null;
			    {
			      int i = 0;
			      Object _xifexpression = null;
			      if (((i = (i = (i + 1))) < (i = (i + 1)))) {
			        _xifexpression = null;
			      }
			      _xblockexpression = _xifexpression;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
}