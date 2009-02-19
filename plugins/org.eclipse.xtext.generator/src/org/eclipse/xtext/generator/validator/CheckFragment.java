/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.validator;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;

public class CheckFragment extends AbstractGeneratorFragment {

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[]{
			"org.eclipse.xtend","org.eclipse.xtend.typesystem.emf"
		};
	}

}
