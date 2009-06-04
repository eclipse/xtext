/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(ISemanticHighlightingConfiguration.NullSemanticHighlightingConfiguration.class)
public interface ISemanticHighlightingConfiguration {

	void configure(IHighlightingConfigurationAcceptor acceptor);
	
	public class NullSemanticHighlightingConfiguration implements ISemanticHighlightingConfiguration {

		public void configure(IHighlightingConfigurationAcceptor acceptor) {
		}
		
	}
}
