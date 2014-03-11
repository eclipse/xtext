/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.navigation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
public class TypeLiteralAwareHyperlinkHelper extends StaticallyImportedMemberAwareHyperlinkHelper {

	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Override
	protected void createHyperlinksTo(XtextResource resource, INode node, EObject target, IHyperlinkAcceptor acceptor) {
		if (target instanceof JvmType) {
			EObject object = NodeModelUtils.findActualSemanticObjectFor(node);
			if (object instanceof XAbstractFeatureCall) {
				XAbstractFeatureCall casted = (XAbstractFeatureCall) object;
				while(casted.isPackageFragment()) {
					casted = (XAbstractFeatureCall) casted.eContainer();
				}
				if (casted.isTypeLiteral()) {
					ITextRegion textRegion = locationInFileProvider.getSignificantTextRegion(casted);
					Region jfaceRegion = new Region(textRegion.getOffset(), textRegion.getLength());
					createHyperlinksTo(resource, jfaceRegion, target, acceptor);
					return;
				}
			}
		}
		super.createHyperlinksTo(resource, node, target, acceptor);
	}
	
}
