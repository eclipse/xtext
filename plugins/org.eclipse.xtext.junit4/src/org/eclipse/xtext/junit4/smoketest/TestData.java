/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest;

/**
 * An error that is thrown by the {@link TestDataProvider} to bail out
 * with the text to parse. Caught by the {@link ScenarioRunner} to
 * extract the string that should be smoke tested.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class TestData extends AssertionError {
	private static final long serialVersionUID = 1L;
	private String data;

	TestData(String data) {
		this.data = data;
	}
	
	String getData() {
		return data;
	}
}