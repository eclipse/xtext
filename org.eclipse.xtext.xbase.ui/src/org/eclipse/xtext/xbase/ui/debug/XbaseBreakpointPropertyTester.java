/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.debug;

import org.apache.log4j.Logger;
import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.debug.core.IJavaStratumLineBreakpoint;
import org.eclipse.xtext.builder.smap.StratumBreakpointAdapterFactory;

public class XbaseBreakpointPropertyTester extends PropertyTester {
	private static final Logger logger = Logger.getLogger(XbaseBreakpointPropertyTester.class);

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (Platform.getBundle("org.eclipse.jdt.debug") == null) {
			return false;
		}
		if (receiver instanceof IJavaStratumLineBreakpoint) {
			IJavaStratumLineBreakpoint breakpoint = (IJavaStratumLineBreakpoint) receiver;
			try {
				Object sourceUri = breakpoint.getMarker().getAttribute(StratumBreakpointAdapterFactory.ORG_ECLIPSE_XTEXT_XBASE_SOURCE_URI);
				return sourceUri != null;
			} catch (CoreException e) {
				logger.debug("Could not read breakpoint attributes", e);
			}
		}
		return false;
	}

}
