/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting;

import org.eclipse.xtext.parsetree.CompositeNode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface INodeModelFormatter {

	public interface IFormattedRegion {
		public String getFormattedText();

		public int getLenght();

		public int getOffset();
	}

	public IFormattedRegion format(CompositeNode root, int offset, int length);

}
