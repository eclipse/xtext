/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
