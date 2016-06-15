/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.debug;

import org.apache.log4j.Logger;
import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.debug.core.IJavaStratumLineBreakpoint;
import org.eclipse.xtext.builder.smap.StratumBreakpointAdapterFactory;

public class XbaseBreakpointPropertyTester extends PropertyTester {
	private static final Logger logger = Logger.getLogger(XbaseBreakpointPropertyTester.class);

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
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
