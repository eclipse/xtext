/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionAcceptor;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.FoldedPosition;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionAcceptor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
public class XtendFoldingRegionProvider extends DefaultFoldingRegionProvider {

	@Override
	protected boolean isHandled(EObject object) {
		EClass clazz = object.eClass();
		return clazz == XtendPackage.Literals.XTEND_CLASS
				|| clazz == XtendPackage.Literals.XTEND_INTERFACE
				|| clazz == XtendPackage.Literals.XTEND_ENUM
				|| clazz == XtendPackage.Literals.XTEND_ANNOTATION_TYPE
				|| clazz == XtendPackage.Literals.ANONYMOUS_CLASS
				|| clazz == XtendPackage.Literals.XTEND_FUNCTION 
				|| clazz == XtendPackage.Literals.XTEND_CONSTRUCTOR;
	}
	
	@Override
	protected boolean shouldProcessContent(EObject object) {
		return true;
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
		if(parseResult != null && parseResult.getRootASTElement() instanceof XtendFile) {
			XtendFile xtendFile = (XtendFile) parseResult.getRootASTElement();
			// Only if we have at least 2 imports
			if(xtendFile.getImportSection() != null 
				&& xtendFile.getImportSection().getImportDeclarations().size() >1) {
					ICompositeNode node = NodeModelUtils.findActualNodeFor(xtendFile.getImportSection());
					if(node != null) {
						ITextRegion textRegion = node.getTextRegion();
						foldingRegionAcceptor.accept(textRegion.getOffset(), textRegion.getLength());
					}
			}
		}
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
