/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.xtext.formatting.INodeModelFormatter.IFormattedRegion;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;


/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class FormatterWindowsLinebreakTest extends FormatterTest {

	@Override
	protected String getLineSeparator() {
		return "\r\n";
	}
	
	@Override
	protected void assertFormattedNM(String expected, final String modelP, int offset, int length) throws Exception {
		if(length != modelP.length() && offset != 0)
			return;
		String model = convertLineBreaks(modelP);
		ICompositeNode node = NodeModelUtils.getNode(getModel(model)).getRootNode();
		// System.out.println(EmfFormatter.objToStr(node));
		IFormattedRegion r = getNodeModelFormatter().format(node, 0, model.length());
		String actual = model.substring(0, r.getOffset()) + r.getFormattedText()
				+ model.substring(r.getLength() + r.getOffset());
		assertEquals(revealLineBreaks(convertLineBreaks(expected)), revealLineBreaks(actual));
	}
}
