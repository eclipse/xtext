/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.xpand2.XpandExecutionContext;

/**
 * Gives the fragments more context information than {@link IGeneratorFragment}. If a fragment implements this
 * interface, the methods of this interface will be called instead of the ones defined in {@link IGeneratorFragment}
 * 
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@SuppressWarnings("deprecation")
public interface IGeneratorFragmentExtension2 {

	void generate(LanguageConfig config, XpandExecutionContext ctx);

	void addToStandaloneSetup(LanguageConfig config, XpandExecutionContext ctx);

	void addToPluginXmlRt(LanguageConfig config, XpandExecutionContext ctx);

	void addToPluginXmlUi(LanguageConfig config, XpandExecutionContext ctx);

}
