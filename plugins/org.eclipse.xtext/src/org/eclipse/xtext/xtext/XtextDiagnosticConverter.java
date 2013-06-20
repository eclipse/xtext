/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.validation.DiagnosticConverterImpl;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextDiagnosticConverter extends DiagnosticConverterImpl{

	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Override
	protected IssueLocation getLocationData(EObject obj, EStructuralFeature structuralFeature, int index) {
		if (NodeModelUtils.getNode(obj) == null) {
			ITextRegion location = locationInFileProvider.getSignificantTextRegion(obj);
			if (location != null) {
				ICompositeNode rootNode = NodeModelUtils.getNode(EcoreUtil.getRootContainer(obj));
				if (rootNode != null) {
					ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(rootNode, location.getOffset());
					return getLocationForNode(leafNode);
				}
			} else {
				return super.getLocationData(obj.eContainer(), null, index);
			}
		}
		return super.getLocationData(obj, structuralFeature, index);
	}
	
}
