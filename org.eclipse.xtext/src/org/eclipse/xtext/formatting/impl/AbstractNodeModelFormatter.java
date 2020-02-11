/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import org.eclipse.xtext.formatting.INodeModelFormatter;
import org.eclipse.xtext.nodemodel.ICompositeNode;

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

		@Override
		public String getFormattedText() {
			return formattedText;
		}

		@Override
		public int getLength() {
			return lengt;
		}

		@Override
		public int getOffset() {
			return offset;
		}

	}

	@Override
	public IFormattedRegion format(ICompositeNode root, int offset, int length) {
		return null;
	}

}
