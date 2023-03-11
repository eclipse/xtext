/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class FormatterResourceProvider implements IEditedResourceProvider {
	
	@Inject
	private IResourceSetProvider resourceSetProvider;
	
	@Override
	public XtextResource createResource() {
		ResourceSet resourceSet = resourceSetProvider.get(null);
		@SuppressWarnings("restriction")
		XtextResource result = (XtextResource) resourceSet.createResource(URI
				.createURI(org.eclipse.xtext.ui.codetemplates.ui.preferences.TemplateResourceProvider.SYNTHETIC_SCHEME + ":/" + "FormatterPreview.xtend"));
		result.setValidationDisabled(true);
		return result;
	}
	
}
