/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.projectWizard;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class SimpleProjectWizardFragment extends AbstractGeneratorFragment {
	
	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] { 
				"org.eclipse.ui", 
				"org.eclipse.core.runtime", 
				"org.eclipse.core.resources",
				"org.eclipse.ui.ide" };
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Collections.singletonList((Object) getGeneratorProjectName(grammar));
	}

	/**
	 * @return
	 */
	private String getGeneratorProjectName(Grammar g) {
		if (generatorProjectName!=null)
			return generatorProjectName;
		throw new IllegalStateException(getClass().getName()+" : The property 'generatorProjectName' is mandatory but has not been configured.");
	}
	
	private String generatorProjectName;
	
	public void setGeneratorProjetName(String generatorProjetName) {
		if ("".equals(generatorProjetName.trim()))
			return;
		this.generatorProjectName = generatorProjetName;
	}
}
