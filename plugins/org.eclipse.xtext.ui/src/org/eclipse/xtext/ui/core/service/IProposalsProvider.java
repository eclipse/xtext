/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.service;

import java.util.List;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.ui.core.editor.codecompletion.Proposal;
import org.eclipse.xtext.ui.core.language.ILanguageService;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public interface IProposalsProvider extends ILanguageService {
	List<Proposal> getProposals(ITextViewer viewer, int offset);
}
