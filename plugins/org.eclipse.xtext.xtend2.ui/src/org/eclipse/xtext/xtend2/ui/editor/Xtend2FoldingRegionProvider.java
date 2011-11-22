/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.editor;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionAcceptor;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.FoldedPosition;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionAcceptor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
public class Xtend2FoldingRegionProvider extends DefaultFoldingRegionProvider {

	@Override
	protected boolean isHandled(EObject object) {
		EClass clazz = object.eClass();
		return clazz == Xtend2Package.Literals.XTEND_CLASS || clazz == Xtend2Package.Literals.XTEND_FUNCTION || clazz == Xtend2Package.Literals.XTEND_CONSTRUCTOR;
	}
	
	@Override
	protected boolean shouldProcessContent(EObject object) {
		EClass clazz = object.eClass();
		return clazz == Xtend2Package.Literals.XTEND_CLASS || clazz == Xtend2Package.Literals.XTEND_FILE;
	}
	
	@Override
	protected Collection<FoldedPosition> doGetFoldingRegions(IXtextDocument xtextDocument, XtextResource xtextResource) {
		Collection<FoldedPosition> result = super.doGetFoldingRegions(xtextDocument, xtextResource);
		IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor = createAcceptor(xtextDocument, result, true);
		computeImportFolding(xtextResource, foldingRegionAcceptor);
		return result;
	}
	
	protected void computeImportFolding(XtextResource xtextResource, IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		IParseResult parseResult = xtextResource.getParseResult();
		if(parseResult != null){
			EObject rootASTElement = parseResult.getRootASTElement();
			if(rootASTElement != null){
				ITextRegion textRegion =getFullTextRegionForFeature(rootASTElement, Xtend2Package.Literals.XTEND_FILE__IMPORTS);
				if(textRegion != null)
					foldingRegionAcceptor.accept(textRegion.getOffset(), textRegion.getLength());
			}
		}
	}
	
	protected ITextRegion getFullTextRegionForFeature(EObject owner, EStructuralFeature feature){
		List<INode> childs = NodeModelUtils.findNodesForFeature(owner, feature);
		//Only if we have at least 2 childs
		if(childs.size() > 1){
			INode firstChild = childs.get(0);
			INode lastChild = childs.get(childs.size() -1);
				int offset = firstChild.getOffset();
				int length = lastChild.getOffset() + lastChild.getLength() - offset;
				return new TextRegion(offset,length);
		}
		return null;
	}

	protected IFoldingRegionAcceptor<ITextRegion> createAcceptor(IXtextDocument xtextDocument, Collection<FoldedPosition> foldedPositions, final boolean initiallyCollapsed) {
		return new DefaultFoldingRegionAcceptor(xtextDocument, foldedPositions){
			@Override
			protected FoldedPosition newFoldedPosition(IRegion region, ITextRegion significantRegion) {
				if (region == null)
					return null;
				if (significantRegion != null)
					return new InitiallyCollapsableFoldedPosition(region.getOffset(), region.getLength(), significantRegion.getOffset() - region.getOffset(), significantRegion.getLength(), initiallyCollapsed);
				return new InitiallyCollapsableFoldedPosition(region.getOffset(), region.getLength(), -1, -1, initiallyCollapsed);
			}
		};
	}
}
