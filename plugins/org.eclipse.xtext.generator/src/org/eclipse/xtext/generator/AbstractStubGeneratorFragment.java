/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.xtext.Grammar;

/**
 * @since 2.4
 * @author Jan Koehnlein - Initial contribution and API
 */
public class AbstractStubGeneratorFragment extends AbstractGeneratorFragment implements IStubGenerating, IStubGenerating.XtendOption {

	private boolean isGenerateStub = true;
	
	private boolean isGenerateXtendStub;

	public boolean isGenerateXtendStub() {
		return isGenerateXtendStub;
	}

	public void setGenerateXtendStub(boolean isGenerateXtendStub) {
		this.isGenerateXtendStub = isGenerateXtendStub;
	}

	public boolean isGenerateStub() {
		return isGenerateStub;
	}

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
