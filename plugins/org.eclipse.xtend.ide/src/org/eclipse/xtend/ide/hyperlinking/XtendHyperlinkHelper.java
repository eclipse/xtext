/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.hyperlinking;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.ui.navigation.TypeLiteralAwareHyperlinkHelper;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendHyperlinkHelper extends TypeLiteralAwareHyperlinkHelper {

	@Inject
	private IJvmModelAssociations associations;
	
	@Override
	public void createHyperlinksTo(XtextResource from, Region region, EObject to, IHyperlinkAcceptor acceptor) {
		Set<EObject> sourceElements = associations.getSourceElements(to);
		if(sourceElements.isEmpty()) 
			super.createHyperlinksTo(from, region, to, acceptor);
		else 
			for(EObject sourceElement: sourceElements) {
				super.createHyperlinksTo(from, region, sourceElement, acceptor);
			}
	}
}
