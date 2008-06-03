/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.service;

import java.util.Set;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.ui.core.tokentype.ITokenTypeDef;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public interface ITokenTypeDefService extends ILanguageService {
	// TODO discuss whether we bind this service with syntaxcolorer
	Set<ITokenTypeDef> allTokenTypes();

}
