/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting;

import org.eclipse.emf.common.util.URI;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
@ImplementedBy(IWhitespaceInformationProvider.Default.class)
public interface IWhitespaceInformationProvider {

	IIndentationInformation getIndentationInformation(URI uri);
	
	ILineSeparatorInformation getLineSeparatorInformation(URI uri);
	
	class Default implements IWhitespaceInformationProvider {
		@Inject
		private IIndentationInformation indentationInformation;

		@Inject
		private ILineSeparatorInformation lineSeparatorInformation;

		@Override
		public IIndentationInformation getIndentationInformation(URI uri) {
			return indentationInformation;
		}

		@Override
		public ILineSeparatorInformation getLineSeparatorInformation(URI uri) {
			return lineSeparatorInformation;
		}
	}
}
