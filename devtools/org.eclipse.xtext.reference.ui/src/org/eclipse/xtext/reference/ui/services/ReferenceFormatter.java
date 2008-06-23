/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.reference.ui.services;

import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.service.IFormatterService;
import org.eclipse.xtext.ui.service.impl.BuildInFormatterService;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class ReferenceFormatter extends BuildInFormatterService implements IFormatterService {
	@Override
	public String befor(LeafNode leafNode) {
		ReferenceTokenTypeDef rttd = new ReferenceTokenTypeDef();
		if (rttd.gelb().match(leafNode) || rttd.grün().match(leafNode) || rttd.rot().match(leafNode))
			return " ";
		if ("}".equals(leafNode.getText()))
			return "\n";
		return super.befor(leafNode);
	}
}
