/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeAwareHyperlinkHelper extends HyperlinkHelper {

	@Inject
	private JdtHyperlinkFactory jdtHyperlinkFactory;
	
	@Override
	public void createHyperlinksTo(XtextResource from, Region region, EObject to, IHyperlinkAcceptor acceptor) {
		if (jdtHyperlinkFactory.canHandle(to))
			jdtHyperlinkFactory.createHyperlink(region, to, acceptor);
		else 
			super.createHyperlinksTo(from, region, to, acceptor);
	}

	public void setJdtHyperlinkFactory(JdtHyperlinkFactory jdtHyperlinkFactory) {
		this.jdtHyperlinkFactory = jdtHyperlinkFactory;
	}

	public JdtHyperlinkFactory getJdtHyperlinkFactory() {
		return jdtHyperlinkFactory;
	}
	
}
