/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.generator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated use {@link org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment} instead.
 */
@Deprecated
public class CodetemplatesGeneratorFragment extends org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment {
	
	@Override
	protected String getTemplate() {
		return org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment.class.getName().replaceAll("\\.", "::");
	}
	
}
