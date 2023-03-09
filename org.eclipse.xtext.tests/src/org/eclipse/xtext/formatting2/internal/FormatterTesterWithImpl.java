/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormatterTesterWithImpl extends FormatterTestHelper {
	@Override
	protected IFormatter2 createFormatter(FormatterTestRequest req) {
		return ((GenericFormatterTestRequest) req).getFormatter();
	}
}
