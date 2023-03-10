/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.projectedEditing;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TemporaryResourceProvider {

	@Inject
	private LanguageRegistry languageRegistry;
	
	public <Result> Result useTemporaryResource(
			ResourceSet resourceSet, Grammar language, 
			AbstractRule rootRule, String content, IUnitOfWork<Result, XtextResource> runnable) {
		XtextResource resource = languageRegistry.createTemporaryResourceIn(language, resourceSet);
		if (rootRule != null)
			PartialParser.assignRootRule(resource, (ParserRule) rootRule);
		try {
			resource.load(new StringInputStream(content, resource.getEncoding()), null);
			return runnable.exec(resource);
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (resource != null) {
				if (resource.isLoaded())
					resource.unload();
				resourceSet.getResources().remove(resource);
			}
		}
	}
	
}
