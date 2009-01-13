/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.debug;

import org.eclipse.xtext.parser.packrat.IMarkerFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DebugMarkerFactory implements IMarkerFactory {

	private final IMarkerFactory delegate;
	
	public DebugMarkerFactory(IMarkerFactory delegate) {
		this.delegate = delegate;
	}
	
	public IMarker mark() {
		return new DebuggingMarker(delegate.mark());
	}
	
	private static class DebuggingMarker implements IMarker {
		
		private final IMarker delegate;
		
		public DebuggingMarker(IMarker delegate) {
			this.delegate = delegate;
		}

		public void rollback() {
			delegate.rollback();
		}
		
	}

}
