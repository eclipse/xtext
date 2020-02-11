/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.xtext.Grammar;

/**
 * @since 2.4
 * @author Jan Koehnlein - Initial contribution and API
 */
@Deprecated
public class AbstractStubGeneratorFragment extends AbstractGeneratorFragment implements IStubGenerating, IStubGenerating.XtendOption {

	private boolean isGenerateStub = true;
	
	private boolean isGenerateXtendStub;

	@Override
	public boolean isGenerateXtendStub() {
		return isGenerateXtendStub;
	}

	@Override
	public void setGenerateXtendStub(boolean isGenerateXtendStub) {
		this.isGenerateXtendStub = isGenerateXtendStub;
	}

	@Override
	public boolean isGenerateStub() {
		return isGenerateStub;
	}

	@Override
	public void setGenerateStub(boolean isGenerateStub) {
		this.isGenerateStub = isGenerateStub;
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return newArrayList((Object)isGenerateStub(), (Object) isGenerateXtendStub());
	}
	
	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		if(isGenerateXtendStub)
			return new String[] { "org.eclipse.xtext.xbase.lib" };
		else 
			return null;
	}
	
	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		if(isGenerateXtendStub)
			return new String[] { "org.eclipse.xtext.xbase.lib" };
		else 
			return null;
	}
	
}
