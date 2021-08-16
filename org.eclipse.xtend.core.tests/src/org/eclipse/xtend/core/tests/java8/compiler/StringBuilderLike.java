/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
