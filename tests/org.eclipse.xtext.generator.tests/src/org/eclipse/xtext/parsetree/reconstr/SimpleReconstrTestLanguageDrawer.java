/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import java.io.IOException;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarToDot;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parsetree.reconstr.impl.FollowerToDot;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SimpleReconstrTestLanguageDrawer {
	public static void main(String[] args) {
		try {
			final String path = "tmp/";
			SimpleReconstrTestLanguageStandaloneSetup.doSetup();
			XtextStandaloneSetup.doSetup();
			Grammar epg = new SimpleReconstrTestLanguageStandaloneSetup()
					.createInjector().getInstance(IGrammarAccess.class)
					.getGrammar();
			Grammar xg = new XtextStandaloneSetup().createInjector()
					.getInstance(IGrammarAccess.class).getGrammar();
			GrammarToDot gtd = new FollowerToDot();
			// GrammarToDot gtd = new GrammarToDot();
			try {
				gtd.draw(epg, path + epg.getName() + ".pdf", "-v -T pdf");
				gtd.draw(xg, path + xg.getName() + ".pdf", "-v -T pdf");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
