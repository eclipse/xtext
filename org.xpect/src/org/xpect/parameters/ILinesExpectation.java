/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.parameters;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ILinesExpectation {
	void assertEquals(Iterable<?> string);

	void assertEquals(String message, Iterable<?> string);

	void fail(String message, Iterable<?> string);
}
