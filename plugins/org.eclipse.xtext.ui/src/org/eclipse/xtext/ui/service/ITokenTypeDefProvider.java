/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service;

import java.util.List;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.ui.tokentype.ITokenTypeDef;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public interface ITokenTypeDefProvider extends ILanguageService {
	List<ITokenTypeDef> allTokenTypes();
}
