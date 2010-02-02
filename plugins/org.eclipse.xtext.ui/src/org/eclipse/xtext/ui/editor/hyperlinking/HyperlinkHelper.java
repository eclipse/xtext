/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hyperlinking;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.TextLocation;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class HyperlinkHelper implements IHyperlinkHelper {

	protected static class HyperlinkAcceptor implements IHyperlinkAcceptor {

		private final List<IHyperlink> links;

		HyperlinkAcceptor(List<IHyperlink> links) {
			this.links = links;
		}
		
		public void accept(IHyperlink hyperlink) {
			if (hyperlink != null)
				links.add(hyperlink);
		}
		
	}
	
	@Inject
	private ILabelProvider labelProvider;

	@Inject
	private Provider<XtextHyperlink> hyperlinkProvider;

	// TODO: consider removing the parameter createMultipleHyperlinks 
	public IHyperlink[] createHyperlinksByOffset(XtextResource resource, int offset, boolean createMultipleHyperlinks) {
		TextLocation textLocation = new TextLocation();
		EObject crossLinkedEObject = EObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, offset,
				textLocation);
		if (crossLinkedEObject != null) {
			List<IHyperlink> links = Lists.newArrayList();
			IHyperlinkAcceptor acceptor = new HyperlinkAcceptor(links);
			Region region = new Region(textLocation.getOffset(), textLocation.getLength());
			createHyperlinksTo(resource, region, crossLinkedEObject, acceptor);
			return Iterables.newArray(links, IHyperlink.class);				
		}
		return null;
	}
	
	public void createHyperlinksTo(XtextResource from, Region region, EObject to, IHyperlinkAcceptor acceptor) {
		final URIConverter uriConverter = from.getResourceSet().getURIConverter();
		final String hyperlinkText = labelProvider.getText(to);
		final URI uri = EcoreUtil.getURI(to);
		final URI normalized = uriConverter.normalize(uri);

		XtextHyperlink result = hyperlinkProvider.get();
		result.setHyperlinkRegion(region);
		result.setURI(normalized);
		result.setHyperlinkText(hyperlinkText);
		acceptor.accept(result);
	}

}
