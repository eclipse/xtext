/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.richstring;

import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractRichStringTest extends AbstractXtend2TestCase {

	protected RichString richString(String string) throws Exception {
		XtendClass clazz = clazz("class Foo { foo() "+string+"}");
		XtendFunction function = (XtendFunction) clazz.getMembers().get(0);
		return (RichString) function.getExpression();
	}
	
}
