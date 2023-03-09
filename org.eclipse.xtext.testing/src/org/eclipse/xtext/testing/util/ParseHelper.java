/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.util;

import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.LookAheadInfo;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Inject;

/**
 * Some convenience methods for parsing (i.e. testing, etc.)
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class ParseHelper<T extends EObject> {

	@Inject
	private ResourceHelper resourceHelper;
	
	@Inject
	private InvariantChecker invariantChecker;

	public String fileExtension;
	
	@Inject
	public void setFileExtensionProvider(FileExtensionProvider extensionProvider) {
		fileExtension = extensionProvider.getPrimaryFileExtension();
	}

	@SuppressWarnings("unchecked")
	public T parse(InputStream in, URI uriToUse, Map<?, ?> options, ResourceSet resourceSet) {
		resourceHelper.setFileExtension(fileExtension);
		Resource resource = resourceHelper.resource(in, uriToUse, options, resourceSet);
		if (resource instanceof XtextResource) {
			IParseResult parseResult = ((XtextResource) resource).getParseResult();
			if (parseResult != null) {
				ICompositeNode rootNode = parseResult.getRootNode();
				if (rootNode != null) {
					checkNodeModel(rootNode);
				}
			}
		}
		T root = (T) (resource.getContents().isEmpty() ? null : resource.getContents().get(0));
		return root;
	}

	public T parse(CharSequence text) throws Exception {
		return parse(text, resourceHelper.createResourceSet());
	}

	public T parse(CharSequence text, ResourceSet resourceSetToUse) throws Exception {
		return parse(getAsStream(text), computeUnusedUri(resourceSetToUse), null, resourceSetToUse);
	}

	public T parse(CharSequence text, URI uriToUse, ResourceSet resourceSetToUse) throws Exception {
		return parse(getAsStream(text), uriToUse, null, resourceSetToUse);
	}
	
	protected URI computeUnusedUri(ResourceSet resourceSet) {
		return resourceHelper.computeUnusedUri(resourceSet);
	}

	protected InputStream getAsStream(CharSequence text) {
		return resourceHelper.getAsStream(text);
	}

	/**
	 * @since 2.22
	 */
	protected InvariantChecker getInvariantChecker() {
		return invariantChecker;
	}
	
	/**
	 * @since 2.22
	 */
	protected void checkNodeModel(ICompositeNode rootNode) {
		getInvariantChecker().checkInvariant(rootNode);
		new LookAheadInfo(rootNode).checkConsistency();
	}
}
