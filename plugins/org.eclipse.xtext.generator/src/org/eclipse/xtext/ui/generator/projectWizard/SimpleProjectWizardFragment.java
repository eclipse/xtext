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
import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IGeneratorFragment;

/**
 * An {@link IGeneratorFragment} to generate a simple project wizard.
 *  
 * @author Sven Efftinge - Initial contribution and API
 */
public class SimpleProjectWizardFragment extends AbstractGeneratorFragment {

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] {
				"org.eclipse.ui",
				"org.eclipse.core.runtime",
				"org.eclipse.core.resources",
				"org.eclipse.ui.ide"
			};
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType("org.eclipse.xtext.ui.core.wizard.IProjectCreator",
						GrammarUtil.getNamespace(grammar)+".ui.wizard." + GrammarUtil.getName(grammar) + "ProjectCreator")
			.getBindings();
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Collections.singletonList((Object) getGeneratorProjectName(grammar));
	}

	private String getGeneratorProjectName(Grammar g) {
		if (generatorProjectName != null) {
			return generatorProjectName;
		}
		throw new IllegalStateException(getClass().getName()
				+ " : The property 'generatorProjectName' is mandatory but has not been configured.");
	}

	private String generatorProjectName;

	/**
	 * Sets the name of the generator project. 
	 * 
	 * @param generatorProjectName
	 */
	public void setGeneratorProjectName(String generatorProjectName) {
		if (generatorProjectName == null || "".equals(generatorProjectName.trim())) {
			return;
		}
		this.generatorProjectName = generatorProjectName.trim();
	}
}
