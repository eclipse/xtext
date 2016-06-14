/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.debug;

import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(IStratumBreakpointSupport.DefaultImpl.class)
public interface IStratumBreakpointSupport {

	public boolean isValidLineForBreakPoint(XtextResource resource, int line);
	
	public static class DefaultImpl implements IStratumBreakpointSupport {

		@Override
		public boolean isValidLineForBreakPoint(XtextResource resource, int line) {
			return false;
		}
		
	}
}
