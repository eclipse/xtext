/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.contentAssist;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractInheritingGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IGeneratorFragment;

/**
 * A {@link IGeneratorFragment} to generate a java-based content assist for an Xtext language.
 *
 * @author Jan Koehnlein
 */
@Deprecated
public class JavaBasedContentAssistFragment extends AbstractInheritingGeneratorFragment {

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider",
					getProposalProviderClassName(grammar))
			.getBindings();
	}

	private String getProposalProviderClassName(Grammar grammar) {
		return getNaming().basePackageUi(grammar)+ ".contentassist." + GrammarUtil.getSimpleName(grammar) + "ProposalProvider";
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[]{
				"org.eclipse.xtext.ui"
		};
	}

	@Override
	public String[] getImportedPackagesUi(Grammar grammar) {
		return new String[] { "org.apache.log4j" };
	}

	@Override
	public String[] getExportedPackagesUi(Grammar grammar) {
		return new String[] { getNaming().packageName(getProposalProviderClassName(grammar)) };
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Collections.<Object>singletonList(getSuperClassName(grammar));
	}

	/**
	 * @since 2.4
	 */
	protected String getSuperClassName(Grammar grammar) {
		Grammar superGrammar = getSuperGrammar(grammar);
		if(isInheritImplementation() && superGrammar != null)
			return getProposalProviderClassName(superGrammar);
		else 
			return "org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider";
			
	}

	/**
	 * Decide whether to inherit content assist from the super language.
	 *
	 * @param inherit
	 * @deprecated use {@link #setInheritImplementation(boolean)} instead
	 */
	@Deprecated
	public void setInherit(boolean inherit) {
		this.setInheritImplementation(inherit);
	}

	/**
	 * @deprecated use {@link #isInheritImplementation()} instead
	 */
	@Deprecated
	public boolean isInherit() {
		return isInheritImplementation();
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		super.generate(grammar, ctx);
	}
	
	/**
	 * @since 2.3
	 */
	public static String getClassName(EObject eObject) {
		return eObject.eClass().getName();
	}
}
