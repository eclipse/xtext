/*******************************************************************************
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.documentation.EObjectInComment;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider.IInformationControlCreatorProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Stephane Galland - Adding support for XConstructorCall
 * @author Tamas Miklossy - Adding support for elements referenced in Javadoc comments
 * @since 2.3
 */
public class XbaseDispatchingEObjectTextHover extends DispatchingEObjectTextHover {
	
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	
	@Inject 
	private JavaDebugHoverProvider javaDebugHoverProvider;
	
	@Inject
	private IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider;
	
	/**
	 * @since 2.19
	 */
	@Inject
	private XtextDocumentUtil xtextDocumentUtil;
	
	@Override
	public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
		IInformationControlCreatorProvider creatorProvider = javaDebugHoverProvider
				.getInformationControlCreatorProvider(textViewer, hoverRegion);
		if (creatorProvider != null) {
			lastCreatorProvider = creatorProvider;
			return creatorProvider.getInfo();
		}
		return super.getHoverInfo2(textViewer, hoverRegion);
	}
	
	@Override
	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		IXtextDocument xtextDocument = xtextDocumentUtil.getXtextDocument(textViewer);
		if(xtextDocument == null || offset<0 || xtextDocument.getLength() < offset) 
			return null;
		@SuppressWarnings("restriction")
		IRegion word = org.eclipse.jdt.internal.ui.text.JavaWordFinder.findWord(xtextDocument, offset);
		if (word!= null)
			return word;
		//TODO return null for non-operators.
		return new Region(offset, 0);
	}

	@Override
	protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, int offset) {
		Pair<EObject, IRegion> original = super.getXtextElementAt(resource, offset);
		if (original != null) {
			EObject object = eObjectAtOffsetHelper.resolveContainedElementAt(resource, offset);
			if (object instanceof XAbstractFeatureCall){
				JvmIdentifiableElement feature = ((XAbstractFeatureCall) object).getFeature();
				if(feature instanceof JvmExecutable 
						|| feature instanceof JvmField 
						|| feature instanceof JvmConstructor 
						|| feature instanceof XVariableDeclaration 
						|| feature instanceof JvmFormalParameter)
					return Tuples.create(object, original.getSecond());
			} else if (object instanceof XConstructorCall){
					return Tuples.create(object, original.getSecond());
			}
		}
		
		EObjectInComment eObjectReferencedInComment = javaDocTypeReferenceProvider.computeEObjectReferencedInComment(resource, offset);
		if(eObjectReferencedInComment != null) {
			EObject eObject = eObjectReferencedInComment.getEObject();
			ITextRegion region = eObjectReferencedInComment.getRegion();
			return Tuples.create(eObject, new Region(region.getOffset(), region.getLength()));
		}
		
		return original;
	}
}
