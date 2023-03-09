/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtext.xbase.lib.Inline;

/**
 * @author Stephane Galland - Initial contribution and API
 */
public class ConstantInlineExpansionData {

	@Inline(value = "1", constantExpression = true)
	public int getValue() {
		return 1;
	}

	@Inline(value = "1", constantExpression = false)
	public int getValue2() {
		return 1;
	}

}
