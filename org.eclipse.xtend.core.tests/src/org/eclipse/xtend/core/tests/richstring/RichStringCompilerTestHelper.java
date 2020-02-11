/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;

import org.eclipse.xtend.core.tests.compiler.CompilerTestHelper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringCompilerTestHelper extends CompilerTestHelper {

	@Override
	protected Object apply(Class<?> compile) throws Exception {
		return super.apply(compile).toString();
	}
	
}
