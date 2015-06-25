/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.ImplementedBy;

/**
 * @deprecated use {@link org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator} instead.
 */
@Deprecated
@ImplementedBy(DefaultSemanticHighlightingCalculator.class)
public interface ISemanticHighlightingCalculator {

	void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor);
	
}
