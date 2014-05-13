/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.internal.debug.ui.JavaDebugHover;
import org.eclipse.jdt.internal.ui.text.JavaWordFinder;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class XbaseDispatchingEObjectTextHover extends DispatchingEObjectTextHover {
	
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	
	@Inject 
	private JavaDebugHover javaDebugHover;
	
	@Override
	public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
		final Object hoverInfo = javaDebugHover.getHoverInfo2(textViewer, hoverRegion);
		if (hoverInfo != null) {
			lastCreatorProvider = new IEObjectHoverProvider.IInformationControlCreatorProvider2() {
				public IInformationControlCreator getHoverControlCreator() {
					return javaDebugHover.getHoverControlCreator();
				}
				public Object getInfo() {
					return hoverInfo;
				}
				public IInformationControlCreator getInformationPresenterControlCreator() {
					return javaDebugHover.getInformationPresenterControlCreator();
				}
			};
			return hoverInfo;
		}
		return super.getHoverInfo2(textViewer, hoverRegion);
	}
	
	@Override
	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		IXtextDocument xtextDocument = XtextDocumentUtil.get(textViewer);
		if(xtextDocument == null || offset<0 || xtextDocument.getLength() < offset) 
			return null;
		IRegion word = JavaWordFinder.findWord(xtextDocument, offset);
		if (word!= null)
			return word;
		//TODO return null for non-operators.
		return new Region(offset, 0);
	}

	@Override
	protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, int offset) {
		Pair<EObject, IRegion> original = super.getXtextElementAt(resource, offset);
		EObject object = eObjectAtOffsetHelper.resolveContainedElementAt(resource, offset);
		if (object != null && object instanceof XAbstractFeatureCall){
			JvmIdentifiableElement feature = ((XAbstractFeatureCall) object).getFeature();
			if(feature instanceof JvmExecutable 
					|| feature instanceof JvmField 
					|| feature instanceof JvmConstructor 
					|| feature instanceof XVariableDeclaration 
					|| feature instanceof JvmFormalParameter)
				if (original != null)
					return Tuples.create(object, original.getSecond());
		}
		return original;
	}
}
