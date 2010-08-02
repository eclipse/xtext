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
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.TextLocation;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.validation.DiagnosticConverterImpl;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextDiagnosticConverter extends DiagnosticConverterImpl{

	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Override
	protected Triple<Integer, Integer, Integer> getLocationData(EObject obj, EStructuralFeature structuralFeature) {
		if (NodeUtil.getNodeAdapter(obj) == null) {
			TextLocation location = locationInFileProvider.getLocation(obj);
			if (location != null) {
				AbstractNode node = NodeUtil.getNode(EcoreUtil.getRootContainer(obj));
				AbstractNode foundNode = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(node, location.getOffset());
				Integer lineNumber = Integer.valueOf(foundNode.getLine());
				int offset = foundNode.getOffset();
				Integer charStart = Integer.valueOf(Integer.valueOf(offset));
				Integer charEnd = Integer.valueOf(offset + location.getLength());
				return Tuples.create(lineNumber, charStart, charEnd);
			} else {
				return super.getLocationData(obj.eContainer(), null);
			}
		}
		return super.getLocationData(obj, structuralFeature);
	}
	
}
