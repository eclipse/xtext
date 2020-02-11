/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.preferences;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TemplateResourceProvider implements IEditedResourceProvider {

	public static final String SYNTHETIC_SCHEME = "synthetic";
	
	@Inject 
	private IResourceSetProvider resourceSetProvider;
	
	@Inject
	private IGrammarAccess grammarAccess;
	
	@Override
	public XtextResource createResource() {
		ResourceSet resourceSet = resourceSetProvider.get(null);
		Resource grammarResource = resourceSet.createResource(
				URI.createURI(SYNTHETIC_SCHEME + ":/" + grammarAccess.getGrammar().getName() + ".xtext"));
		grammarResource.getContents().add(EcoreUtil.copy(grammarAccess.getGrammar()));
		XtextResource result = (XtextResource) resourceSet.createResource(
				URI.createURI(SYNTHETIC_SCHEME + ":/" + grammarAccess.getGrammar().getName() + ".___singlecodetemplate"));
		resourceSet.getResources().add(result);
		return result;
	}
}
