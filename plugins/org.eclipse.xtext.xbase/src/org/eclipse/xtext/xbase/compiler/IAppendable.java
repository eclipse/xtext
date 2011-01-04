/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IAppendable {
	IAppendable append(Object obj);
	
	public static class StringBuilderBasedAppendable implements IAppendable {
		
		private StringBuilder builder = new StringBuilder(8*1024);

		public IAppendable append(Object obj) {
			builder.append(obj);
			return this;
		}
		
		@Override
		public String toString() {
			return builder.toString();
		}

	}
}
