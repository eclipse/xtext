/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.compare;

import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.resourceFactory.ResourceFactoryFragment;

/**
 * @author Michael Clay - Initial contribution and API
 */
@Deprecated
public class CompareFragment extends ResourceFactoryFragment {
	private static final Logger log = Logger.getLogger(CompareFragment.class);

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		if (log.isInfoEnabled()) {
			log.info("generating Compare Framework infrastructure");
		}
		super.generate(grammar, ctx);
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		String simpleName = GrammarUtil.getSimpleName(grammar);
		String statement =
				"binder.bind(String.class).annotatedWith("
				+ "com.google.inject.name.Names.named(org.eclipse.xtext.ui.UIBindings.COMPARE_VIEWER_TITLE))"
				+ ".toInstance(\""+simpleName+" Compare\");";
		return new BindFactory().addTypeToType("org.eclipse.compare.IViewerCreator",
				"org.eclipse.xtext.ui.compare.DefaultViewerCreator").addConfiguredBinding("CompareViewerTitle", statement).getBindings();
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] { "org.eclipse.compare" };
	}
	
	@Override
	@Mandatory
	public void setFileExtensions(String fileExtensions) {
		super.setFileExtensions(fileExtensions);
	}
}
