/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xtextgen.GenModel;
import org.eclipse.xtext.xtextgen.Outlet;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class GenExtensions {

	public static String outletPath(GenModel genModel, String outletName) {
		Outlet outlet = getOuletForName(genModel, outletName);
		if (outlet == null) {
			throw new NullPointerException("No such outlet : " + outletName);
		}
		return outlet.getTargetFolder();
	}

	public static Outlet getOuletForName(GenModel genModel, String outletName) {
		EList<Outlet> outlets = genModel.getOutlets();
		for (Outlet outlet : outlets) {
			if (outlet.getName() == outletName || outlet.getName() != null && outlet.getName().equals(outletName))
				return outlet;
		}
		return null;
	}

	/**
	 * @param genModel
	 *            containing the grammar to generate the template for
	 * @return the derived,minimum default template pattern of the given grammar
	 */
	public static String getDefaultGrammarTemplate(GenModel genModel) {
		return new DefaultGrammarTemplateSwitch().doSwitch(GrammarUtil.getDefaultEntryRule(genModel.getGrammar())
				.getAlternatives());
	}
}
