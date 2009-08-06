/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import org.eclipse.xtext.formatting.INodeModelFormatter;
import org.eclipse.xtext.parsetree.CompositeNode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractNodeModelFormatter implements INodeModelFormatter {

	public static class FormattedRegion implements IFormattedRegion {

		protected String formattedText;

		protected int lengt;

		protected int offset;

		public FormattedRegion(int offset, int lengt, String formattedText) {
			super();
			this.formattedText = formattedText;
			this.lengt = lengt;
			this.offset = offset;
		}

		public String getFormattedText() {
			return formattedText;
		}

		public int getLenght() {
			return lengt;
		}

		public int getOffset() {
			return offset;
		}

	}

	public IFormattedRegion format(CompositeNode root, int offset, int length) {
		return null;
	}

}
