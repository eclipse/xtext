/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.ex.common;

import java.util.List;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.parser.antlr.AbstractAntlrGeneratorFragment;
import org.eclipse.xtext.generator.parser.antlr.ex.wsAware.SyntheticTerminalAwareFragmentHelper;
import org.eclipse.xtext.parser.antlr.AbstractIndentationTokenSource;
import org.eclipse.xtext.parser.antlr.AbstractSplittingTokenSource;

import com.google.common.collect.ImmutableList;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public abstract class AbstractAntlrGeneratorFragmentEx extends AbstractAntlrGeneratorFragment {

	private AntlrFragmentHelper fragmentHelper;
	
	/**
	 * @since 2.8
	 */
	private boolean detectSyntheticTerminals = true;

	/**
	 * Allows to customize the detection of synthetic terminal symbols in the grammar.
	 * @see SyntheticTerminalAwareFragmentHelper
	 */
	public void setFragmentHelper(AntlrFragmentHelper fragmentHelper) {
		this.fragmentHelper = fragmentHelper;
	}

	public AntlrFragmentHelper getFragmentHelper() {
		if (fragmentHelper == null) {
			if (detectSyntheticTerminals) {
				fragmentHelper = new SyntheticTerminalAwareFragmentHelper(getNaming());
			} else {
				fragmentHelper = new AntlrFragmentHelper(getNaming());
			}
		}
		return fragmentHelper;
	}
	
	@Override
	public void registerNaming(Naming naming) {
		if (fragmentHelper != null) {
			fragmentHelper.registerNaming(naming);
		}
		super.registerNaming(naming);
	}

	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return ImmutableList.of(getOptions(), getFragmentHelper());
	}

	@Override
	protected String getParserFileNameSuffix() {
		return ".java";
	}

	@Override
	protected String getLexerFileNameSuffix() {
		return ".java";
	}
	
	/**
	 * @since 2.8
	 */
	public boolean isDetectSyntheticTerminals() {
		return detectSyntheticTerminals;
	}
	
	/**
	 * Set to false if synthetic terminal should be ignored. Synthetic terminals
	 * have the form {@code terminal ABC: 'synthetic:ABC';} in the grammar
	 * and require a customized {@link AbstractSplittingTokenSource token source}.
	 * 
	 * @see SyntheticTerminalAwareFragmentHelper
	 * @see AbstractIndentationTokenSource
	 * @see AbstractSplittingTokenSource
	 * @since 2.8
	 */
	public void setDetectSyntheticTerminals(boolean detectSyntheticTerminals) {
		this.detectSyntheticTerminals = detectSyntheticTerminals;
	}
}
