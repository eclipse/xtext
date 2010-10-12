/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr;

import org.eclipse.emf.mwe.core.issues.Issues;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DebugAntlrGeneratorFragment extends AbstractAntlrGeneratorFragment {

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		issues.addInfo("Generate debugging grammar file");
	}
	
}
