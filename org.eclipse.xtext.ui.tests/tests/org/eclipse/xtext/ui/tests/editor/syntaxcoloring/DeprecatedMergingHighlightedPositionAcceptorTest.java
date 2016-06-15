/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.syntaxcoloring;

import java.util.List;

import org.eclipse.xtext.ide.editor.syntaxcoloring.LightweightPosition;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.syntaxcoloring.MergingHighlightedPositionAcceptor;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class DeprecatedMergingHighlightedPositionAcceptorTest extends MergingHighlightedPositionAcceptorTest implements ISemanticHighlightingCalculator {

	@Override
	protected MergingHighlightedPositionAcceptor createAcceptor() {
		return new MergingHighlightedPositionAcceptor(this);
	}

	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		acceptor.addPosition(2, 4, "1", "2");
	}
	
	@Override
	public MergingHighlightedPositionAcceptor getAcceptor() {
		return (MergingHighlightedPositionAcceptor) super.getAcceptor();
	}
	
	@Test public void testAddPositionViaCalculate() {
		provideHighlightingFor(null, getAcceptor());
		List<LightweightPosition> positions = acceptor.getPositions();
		assertEquals(1, positions.size());
		checkPosition(positions.get(0), 2, 4, 0, "1", "2");
	}
}
