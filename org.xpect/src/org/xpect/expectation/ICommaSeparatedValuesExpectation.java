/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.expectation;

import org.xpect.XpectImport;
import org.xpect.expectation.impl.CommaSeparatedValuesExpectationImpl;

import com.google.common.base.Predicate;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@XpectImport(CommaSeparatedValuesExpectationImpl.class)
public interface ICommaSeparatedValuesExpectation {
	void assertEquals(Iterable<?> string);

	void assertEquals(Iterable<?> string, Predicate<String> predicate);

	void assertEquals(Predicate<String> predicate);
}
