/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GenericFormatterTester {
	@Inject
	private FormatterTesterWithImpl tester;

	@Inject
	private Provider<GenericFormatterTestRequest> requestProvider;

	public void assertFormatted(Procedure1<? super GenericFormatterTestRequest> test) {
		GenericFormatterTestRequest request = requestProvider.get();
		test.apply(request);
		tester.assertFormatted(request);
	}
}
