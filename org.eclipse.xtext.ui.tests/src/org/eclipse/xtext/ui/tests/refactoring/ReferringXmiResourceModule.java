/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReferringXmiResourceModule extends AbstractGenericResourceRuntimeModule {

	@Override
	protected String getLanguageName() {
		return "org.eclipse.xtext.ui.tests.refactoring.ReferringTestLanguage";
	}

	@Override
	protected String getFileExtensions() {
		return "referring_xmi";
	}

}
