/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.ex.common;

import java.util.List;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.parser.antlr.AbstractAntlrGeneratorFragment;

import com.google.common.collect.ImmutableList;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractAntlrGeneratorFragmentEx extends AbstractAntlrGeneratorFragment {

	private AntlrFragmentHelper fragmentHelper;
	
	public void setFragmentHelper(AntlrFragmentHelper fragmentHelper) {
		this.fragmentHelper = fragmentHelper;
	}

	public AntlrFragmentHelper getFragmentHelper() {
		if (fragmentHelper == null)
			fragmentHelper = new AntlrFragmentHelper(getNaming());
		return fragmentHelper;
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return ImmutableList.of(getOptions(), getFragmentHelper());
	}
}
