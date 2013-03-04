/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package test;

/**
 * @author efftinge - Initial contribution and API
 */
public class JavaB extends XtendC {
	public XtendA foo(XtendC test) {
		XtendA result = new XtendA();
		result.test2(new XtendB());
		test.test( result);
		return result;
	}
}
