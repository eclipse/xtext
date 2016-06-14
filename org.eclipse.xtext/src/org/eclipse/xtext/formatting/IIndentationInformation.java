/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(IIndentationInformation.Default.class)
public interface IIndentationInformation {
	/**
	 * returns the string used to indent a line one level
	 */
	String getIndentString();
	
	/**
	 * @since 2.2
	 */
	class Default implements IIndentationInformation{
		@Override
		public String getIndentString() {
			return "\t";
		}
	}
}
