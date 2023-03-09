/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
