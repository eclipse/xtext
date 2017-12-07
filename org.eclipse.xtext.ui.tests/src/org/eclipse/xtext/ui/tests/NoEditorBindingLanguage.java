/*******************************************************************************
 * Copyright (c) 2017 itemis GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests;

import java.util.List;

import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NoEditorBindingLanguage extends XtextGeneratorLanguage {

	@Override
	protected List<? extends IXtextGeneratorFragment> getImplicitFragments() {
		List<? extends IXtextGeneratorFragment> result = super.getImplicitFragments();
		AbstractStubGeneratingFragment implicit = (AbstractStubGeneratingFragment) result.get(0);
		implicit.setGenerateStub(false);
		return result;
	}
	
}
