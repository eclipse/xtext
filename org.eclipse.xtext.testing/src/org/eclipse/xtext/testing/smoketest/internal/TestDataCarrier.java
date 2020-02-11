/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.smoketest.internal;

import com.google.common.annotations.Beta;

/**
 * An error that is thrown by the {@link TestDataProvider} to bail out
 * with the text to parse. Caught by the {@link ScenarioRunner} to
 * extract the string that should be smoke tested.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
class TestDataCarrier extends AssertionError {
	private static final long serialVersionUID = 1L;
	private String data;

	TestDataCarrier(String data) {
		this.data = data;
	}
	
	String getData() {
		return data;
	}
}