/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFunction;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractRichStringTest extends AbstractXtendTestCase {

	protected String getPrefix() {
		return "class Foo { def foo() ";
	}
	
	protected int getPrefixLength() {
		return getPrefix().length();
	}
	
	protected RichString richString(String string) throws Exception {
		XtendClass clazz = clazz(getPrefix()+string+"}");
		XtendFunction function = (XtendFunction) clazz.getMembers().get(0);
		return (RichString) function.getExpression();
	}
	
}
