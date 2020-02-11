/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * A hover which determines the EObject at the hover region. Subclasses have to implement getHoverInfo2 (final EObject
 * eObject, final ITextViewer textViewer, final IRegion hoverRegion).
 * 
 * @author Christoph Kulla - Initial contribution and API
 */
public abstract class AbstractEObjectHover extends AbstractHover implements IEObjectHover {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	/**
	 * @since 2.19
	 */
	@Inject
	private XtextDocumentUtil xtextDocumentUtil;

	@Override
	public IRegion getHoverRegion(final ITextViewer textViewer, final int offset) {
		IXtextDocument xtextDocument = xtextDocumentUtil.getXtextDocument(textViewer);
		if(xtextDocument == null) 
			return null;
		//TODO this is being called on change in the UI-thread. Not a good idea to do such expensive stuff.
		// returning the region on a per token basis would be better.
		try {
			return xtextDocument.tryReadOnly(new IUnitOfWork<IRegion, XtextResource>() {
				@Override
				public IRegion exec(XtextResource state) throws Exception {
					Pair<EObject, IRegion> element = getXtextElementAt(state, offset);
					if (element != null) {
						return element.getSecond();
					} else {
						return null;
					}
				}
			});
		} catch (OperationCanceledException e) {
			return null;
		} catch (OperationCanceledError e) {
			return null;
		}
	}

	@Override
	public Object getHoverInfo2(final ITextViewer textViewer, final IRegion hoverRegion) {
		if (hoverRegion == null)
			return null;
		IXtextDocument xtextDocument = xtextDocumentUtil.getXtextDocument(textViewer);
		if(xtextDocument == null) 
			return null;
		try {
			return xtextDocument.tryReadOnly(new IUnitOfWork<Object, XtextResource>() {
				@Override
				public Object exec(XtextResource state) throws Exception {
					Pair<EObject, IRegion> element = getXtextElementAt(state, hoverRegion.getOffset());
					if (element != null && element.getFirst() != null) {
						return getHoverInfo(element.getFirst(), textViewer, hoverRegion);
					}
					return null;
				}
			});
		} catch (OperationCanceledException e) {
			return null;
		} catch (OperationCanceledError e) {
			return null;
		}
	}

	@Override
	public abstract Object getHoverInfo(final EObject eObject, final ITextViewer textViewer,
			final IRegion hoverRegion);

	/**
	 * Call this method only from within an IUnitOfWork
	 */
	protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, final IRegion hoverRegion) {
		return getXtextElementAt(resource, hoverRegion.getOffset());
	}

	/**
	 * Call this method only from within an IUnitOfWork
	 */
	protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, final int offset) {
		// check for cross reference
		EObject crossLinkedEObject = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, offset);
		if (crossLinkedEObject != null) {
			if (!crossLinkedEObject.eIsProxy()) {
				IParseResult parseResult = resource.getParseResult();
				if (parseResult != null) {
					ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
					if(leafNode != null && leafNode.isHidden() && leafNode.getOffset() == offset) {
						leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset - 1);
					}
					if (leafNode != null) {
						ITextRegion leafRegion = leafNode.getTextRegion();
						return Tuples.create(crossLinkedEObject, (IRegion) new Region(leafRegion.getOffset(), leafRegion.getLength()));
					}
				}
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

}
