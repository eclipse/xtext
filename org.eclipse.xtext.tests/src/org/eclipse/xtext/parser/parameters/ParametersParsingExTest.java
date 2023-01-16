/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.parameters;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParametersParsingExTest extends AbstractParametersParsingTest {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.with(new ParametersTestLanguageExStandaloneSetup());
	}
}
