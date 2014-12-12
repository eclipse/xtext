/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting;

import com.google.inject.ImplementedBy;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
@ImplementedBy(ILineSeparatorInformation.Default.class)
public interface ILineSeparatorInformation {

	String getLineSeparator();
	
	class Default implements ILineSeparatorInformation {

		@Override
		public String getLineSeparator() {
			return System.getProperty("line.separator");
		}
	}
}
