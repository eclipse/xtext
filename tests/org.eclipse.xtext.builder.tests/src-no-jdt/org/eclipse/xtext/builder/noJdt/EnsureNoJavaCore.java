/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.noJdt;

import org.eclipse.jdt.core.JavaCore;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
public class EnsureNoJavaCore {

	@Test(expected = NoClassDefFoundError.class)
	public void testJavaCoreNotAvailable() {
		JavaCore.class.getName();
	}
	
}
