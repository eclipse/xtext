/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service.impl;

import java.util.List;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.service.IProposalsProvider;

/**
 * @author Peter Friese - Initial contribution and API
 *
 */
public class BuiltInProposalsProvider implements IProposalsProvider {
    
    public List<ICompletionProposal> getProposals(IEditorModel model, ITextViewer viewer, int offset) {
        return null;
    }

}
