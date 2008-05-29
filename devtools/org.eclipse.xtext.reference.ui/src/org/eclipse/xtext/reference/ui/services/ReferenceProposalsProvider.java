/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.reference.ui.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.reference.ui.Activator;
import org.eclipse.xtext.ui.core.editor.codecompletion.Proposal;
import org.eclipse.xtext.ui.core.language.AbstractLanguageService;
import org.eclipse.xtext.ui.core.service.IProposalsProvider;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class ReferenceProposalsProvider extends AbstractLanguageService implements IProposalsProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.core.service.IProposalsProvider#getProposals(org
	 * .eclipse.jface.text.ITextViewer, int)
	 */
	public List<Proposal> getProposals(ITextViewer viewer, int offset) {

		Proposal p = new Proposal("Hier ein proposal");
		p.setLabel(new StyledString("Proposal Label", StyledString.COUNTER_STYLER));
		p.setDescription("Proposal Beschreibung");
		p.setImage(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/test.gif").createImage());
		Proposal p1 = new Proposal("Hier noch ein proposal");
		p1.setDescription("Noch ein Proposal Beschreibung");
		Proposal p2 = new Proposal("Proposal in bund");
		p2.setLabel(new StyledString("Proposal ", StyledString.QUALIFIER_STYLER).append("in ",
				StyledString.DECORATIONS_STYLER).append("bund", StyledString.COUNTER_STYLER));
		p2.setDescription("Test AutoWRAP: alkg pkap aposk poasdkg pokd"
				+ "gokspeokrg speorkg aüperogk aüpeorgk üapoekg apüodlg laksd lgk üapwoegk ldkgaäösdlgkoawekg ok");
		List<Proposal> retVal = new ArrayList<Proposal>();
		for (ParserRule pr : getLanguageDescriptor().getLanguageFacade().getGrammar().getParserRules()) {
			Proposal pro = new Proposal(pr.getName());
			pro.setLabel(new StyledString(pr.getName()).append(" - " + pr.toString(), StyledString.QUALIFIER_STYLER));
			retVal.add(pro);
		}
		retVal.add(p);
		retVal.add(p1);
		retVal.add(p2);
		return retVal;
	}
}
