/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover.html;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.internal.text.html.BrowserInformationControlInput;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextHoverExtension;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider.IInformationControlCreatorProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class DeclarationHoverDispatcher implements ITextHover, ITextHoverExtension, ITextHoverExtension2 {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Inject 
	private IGlobalServiceProvider serviceProvider;

	private IInformationControlCreatorProvider lastCreatorProvider;

	public IRegion getHoverRegion(final ITextViewer textViewer, final int offset) {
		IXtextDocument xtextDocument = XtextDocumentUtil.get(textViewer);
		return xtextDocument.readOnly(new IUnitOfWork<IRegion, XtextResource>() {
			public IRegion exec(XtextResource state) throws Exception {
				Pair<EObject, IRegion> element = getXtextElementAt(state, offset);
				if (element != null) {
					return element.getSecond();
				} else {
					return null;
				}
			}
		});
	}

	public Object getHoverInfo2(final ITextViewer textViewer, final IRegion hoverRegion) {
		if (hoverRegion == null)
			return null;
		IXtextDocument xtextDocument = XtextDocumentUtil.get(textViewer);
		return xtextDocument.readOnly(new IUnitOfWork<Object, XtextResource>() {
			public Object exec(XtextResource state) throws Exception {
				Pair<EObject, IRegion> element = getXtextElementAt(state, hoverRegion.getOffset());
				if (element != null && element.getFirst() != null) {
					return internalgetHoverInfo(element.getFirst(), textViewer, hoverRegion);
				}
				return null;
			}
		});
	}

	protected Object internalgetHoverInfo(EObject first, ITextViewer textViewer, IRegion hoverRegion) {
		IEObjectHoverProvider hoverProvider = serviceProvider.findService(first, IEObjectHoverProvider.class);
		if (hoverProvider==null)
			return null;
		IInformationControlCreatorProvider creatorProvider = hoverProvider.getHoverInfo(first, textViewer, hoverRegion);
		if (creatorProvider==null)
			return null;
		this.lastCreatorProvider = creatorProvider;
		return lastCreatorProvider.getInfo();
	}

	protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, final int offset) {
		// check for cross reference
		EObject crossLinkedEObject = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, offset);
		if (crossLinkedEObject != null) {
			if (!crossLinkedEObject.eIsProxy()) {
				ILeafNode an = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
				return Tuples.create(crossLinkedEObject, (IRegion) new Region(an.getOffset(), an.getLength()));
			}
		} else {
			EObject o = eObjectAtOffsetHelper.resolveElementAt(resource, offset);
			if (o != null) {
				ITextRegion region = locationInFileProvider.getSignificantTextRegion(o);
				final IRegion region2 = new Region(region.getOffset(), region.getLength());
				if (TextUtilities.overlaps(region2, new Region(offset, 0)))
					return Tuples.create(o, region2);
			}
		}
		return null;
	}

	public IInformationControlCreator getHoverControlCreator() {
		return this.lastCreatorProvider==null?null:lastCreatorProvider.getHoverControlCreator();
	}

	@Deprecated
	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		return ((BrowserInformationControlInput)getHoverInfo2(textViewer, hoverRegion)).getHtml();
	}
}
