/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.xtext.serializer.sequencer.GenericSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GenericSemanticSequencerTest extends AbstractSemanticSequencerTest {

	@Override
	protected ISemanticSequencer getGenericSemanticSequencer() {
		return get(GenericSemanticSequencer.class);
	}

	@Override
	public void testUnorderedAlternative1() throws Exception {
		// unsupported
	}

	@Override
	public void testUnorderedAlternative2() throws Exception {
		// unsupported
	}

	@Override
	public void testUnorderedAlternative3() throws Exception {
		// unsupported
	}

	@Override
	public void testUnorderedAlternative4() throws Exception {
		// unsupported
	}

	@Override
	public void testUnorderedAlternative5() throws Exception {
		// unsupported
	}

	@Override
	public void testUnorderedAlternative6() throws Exception {
		// unsupported
	}

	@Override
	public void testUnorderedAlternative7() throws Exception {
		// unsupported
	}

}
