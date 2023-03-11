/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.macro

import com.google.inject.Inject
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester
import org.eclipse.xtend.core.tests.AbstractXtendTestCase

abstract class AbstractActiveAnnotationTest extends AbstractXtendTestCase {
	
	protected extension XtendCompilerTester
	
	@Inject def doInject(XtendCompilerTester compilerTester) {
		_xtendCompilerTester = compilerTester
		_xtendCompilerTester.javaCompilerClassPath = class.classLoader
	}
}