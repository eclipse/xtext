/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.namespaces;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(IQualifiedNameSupport.DefaultImpl.class)
public interface IQualifiedNameSupport {
	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	public class DefaultImpl implements IQualifiedNameSupport {
		public String getDelimiter() {
			return ".";
		}

		public String getWildCard() {
			return "*";
		}
	}
	String getDelimiter();
	String getWildCard();
}
