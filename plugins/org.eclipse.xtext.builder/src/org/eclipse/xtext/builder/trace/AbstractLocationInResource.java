/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.io.InputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 */
public abstract class AbstractLocationInResource implements ILocationInResource {
	private final AbstractTrace trace;
	private URI eObjectURI;
	private boolean triedToComputeURI;
	private URI absoluteURI;

	protected AbstractLocationInResource(AbstractTrace trace) {
		this.trace = trace;
	}

	public abstract URI getSrcRelativeResourceURI();
	protected abstract int getOffset();
	protected abstract int getLength();
	protected abstract int getLineNumber();
	protected abstract int getEndLineNumber();
	
	/* @NonNull */
	public IStorage getStorage() {
		IStorage result = trace.findStorage(getSrcRelativeResourceURI(), getProject());
		return result;
	}

	public ITextRegionWithLineInformation getTextRegion() {
		ITextRegionWithLineInformation result = new TextRegionWithLineInformation(getOffset(), getLength(), getLineNumber(), getEndLineNumber());
		return result;
	}
	
	public URI getAbsoluteResourceURI() {
		if (absoluteURI == null) {
			absoluteURI = trace.resolvePath(getSrcRelativeResourceURI());
		}
		return absoluteURI;
	}
	
	/* @NonNull */
	public InputStream getContents() throws CoreException {
		return trace.getContents(getSrcRelativeResourceURI(), getProject());
	}
	
	public /* @NonNull */ IProject getProject() {
		return trace.getLocalProject();
	}
	
	public LanguageInfo getLanguage() {
		LanguageInfo result = trace.findLanguage(getAbsoluteResourceURI());
		return result;
	}

	public URI getEObjectURI() {
		if (eObjectURI == null && !triedToComputeURI) {
			Resource resource = trace.getResource(getAbsoluteResourceURI(), getProject());
			if (resource instanceof XtextResource) {
				IParseResult parseResult = ((XtextResource) resource).getParseResult();
				if (parseResult != null) {
					ICompositeNode rootNode = parseResult.getRootNode();
					int end = getOffset() + getLength();
					INode node = NodeModelUtils.findLeafNodeAtOffset(rootNode, getOffset());
					while (node != null) {
						if (node.getTotalEndOffset() >= end) {
							EObject object = NodeModelUtils.findActualSemanticObjectFor(node);
							if (object != null) {
								URI result = EcoreUtil.getURI(object);
								eObjectURI = result;
								triedToComputeURI = true;
								return result;
							}
						}
						node = node.getParent();
					}
				}
			}
			triedToComputeURI = true;
		}
		return eObjectURI;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " @ " + getTextRegion();
	}
	
}
