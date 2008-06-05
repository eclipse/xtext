/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.services;

import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;
import org.eclipse.xtext.ui.core.service.ISyntaxColorer;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BISyntaxColorerTest extends AbstractServiceTest {
	public void testTextDefaultStyle() throws Exception {
		ISyntaxColorer colorer = getServiceForDefaultLanguage(ISyntaxColorer.class);
		LeafNode unknownNode = getModelForDefaultLanguage("nothing").getRootNode().getLeafNodes().get(0);
		assertNotNull(unknownNode);
		TextStyle textStyle = colorer.color(unknownNode);
		assertNotNull(textStyle);
	}
}
