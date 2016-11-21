/*******************************************************************************
 * Copyright (c) 2016 TypeFox.io (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
class CompilerBug406762Test extends AbstractXtendCompilerTest {
	
	@Test def testMyExceptionReturnsThisAsThrowable() {
		'''
			class Bug {
				private static final class MyException extends Exception {
					override synchronized Throwable fillInStackTrace() {
						return this;
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Bug {
			  private static final class MyException extends Exception {
			    public synchronized Throwable fillInStackTrace() {
			      return this;
			    }
			  }
			}
		''')
	}

	@Test def testMyExceptionImpicitlyReturnsThisAsThrowable() {
		'''
			class Bug {
				private static final class MyException extends Exception {
					override synchronized Throwable fillInStackTrace() {
						this
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Bug {
			  private static final class MyException extends Exception {
			    public synchronized Throwable fillInStackTrace() {
			      return this;
			    }
			  }
			}
		''')
	}
	
}