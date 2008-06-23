/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service;

import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.ILanguageService;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public interface IFormatterService extends ILanguageService {

	public abstract boolean shouldIndent(AbstractNode node);

	public abstract String bevor(LeafNode leafNode);

}