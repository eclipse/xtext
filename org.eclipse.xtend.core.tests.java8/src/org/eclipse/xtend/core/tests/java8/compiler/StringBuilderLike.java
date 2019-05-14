/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler;

import java.io.Serializable;

/**
 * @author dietrich - Initial contribution and API
 */
public class StringBuilderLike implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public int length() {
		return 42;
	}

}
