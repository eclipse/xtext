/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IInformationControlExtension5;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.information.IInformationProvider;
import org.eclipse.jface.text.information.IInformationProviderExtension;
import org.eclipse.jface.text.information.IInformationProviderExtension2;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider.IInformationControlCreatorProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.6
 */
public class XtextInformationProvider  implements IInformationProvider, IInformationProviderExtension, IInformationProviderExtension2{

	@Inject
	protected IEObjectHover hover;
	@Inject
	protected IEObjectHoverProvider hoverProvider;
	@Inject 
	protected IGlobalServiceProvider serviceProvider;
	@Inject
	protected EObjectAtOffsetHelper eObjectAtOffsetHelper;
	protected EObject contextObject = null;
	protected ITextViewer textViewer;
	protected IRegion region;
	
	public IInformationControlCreator getInformationPresenterControlCreator() {
		IEObjectHoverProvider hoverProvider = serviceProvider.findService(contextObject , IEObjectHoverProvider.class);
		if (hoverProvider==null)
			return null;
		IInformationControlCreatorProvider hoverInfo = hoverProvider.getHoverInfo(contextObject, textViewer, region);
		return hoverInfo.getInformationPresenterControlCreator();
	}

	public Object getInformation2(ITextViewer textViewer, IRegion subject) {
		if(hover != null){
			return hover.getHoverInfo(contextObject, textViewer, region);
		}
		return null;
	}

	public IRegion getSubject(ITextViewer textViewer, final int offset) {
		if(textViewer instanceof XtextSourceViewer){
			IDocument document = ((XtextSourceViewer) textViewer).getDocument();
			if(document instanceof IXtextDocument){
				Object resolvedObject = ((IXtextDocument) document).readOnly(new IUnitOfWork<Object, XtextResource>() {
					public Object exec(XtextResource state) throws Exception {
						return eObjectAtOffsetHelper.resolveElementAt(state, offset);
					}
				});	
				if(resolvedObject != null && resolvedObject instanceof EObject){
					contextObject = (EObject) resolvedObject;
				}
			}
		}
		IRegion computedRegion = computeRegion(textViewer, offset);
		this.region = computedRegion;
		return computedRegion;
	}

	protected IRegion computeRegion(ITextViewer textViewer, final int offset) {
		if(hover instanceof ITextHover)
			return ((ITextHover) hover).getHoverRegion(textViewer, offset);
		return new Region(offset, 0);
	}

	@Deprecated
	public String getInformation(ITextViewer textViewer, IRegion subject) {
		if(hover instanceof ITextHoverExtension2){
			Object hoverInfo2 = ((ITextHoverExtension2) hover).getHoverInfo2(textViewer, subject);
			return hoverInfo2!= null ? hoverInfo2.toString():null;
		}
		return null;
	}
}
