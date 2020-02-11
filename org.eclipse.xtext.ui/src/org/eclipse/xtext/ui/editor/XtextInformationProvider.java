/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.information.IInformationProvider;
import org.eclipse.jface.text.information.IInformationProviderExtension;
import org.eclipse.jface.text.information.IInformationProviderExtension2;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider.IInformationControlCreatorProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider.IInformationControlCreatorProvider2;
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
	protected IGlobalServiceProvider serviceProvider;
	@Inject
	protected EObjectAtOffsetHelper eObjectAtOffsetHelper;
	protected EObject contextObject = null;
	protected ITextViewer textViewer = null;
	protected IRegion contextRegion = null;

	@Override
	public IInformationControlCreator getInformationPresenterControlCreator() {
		if(contextObject != null && textViewer != null && contextRegion != null){
			IEObjectHoverProvider hoverProvider = serviceProvider.findService(contextObject , IEObjectHoverProvider.class);
			if (hoverProvider!=null){
				IInformationControlCreatorProvider hoverInfo = hoverProvider.getHoverInfo(contextObject, textViewer, contextRegion);
				if(hoverInfo instanceof IInformationControlCreatorProvider2){
					return ((IInformationControlCreatorProvider2)hoverInfo).getInformationPresenterControlCreator();
				}
			}
		}
		return null;
	}

	@Override
	public Object getInformation2(ITextViewer textViewer, IRegion subject) {
		if(hover != null && hover instanceof ITextHoverExtension2){
			return ((ITextHoverExtension2) hover).getHoverInfo2(textViewer, subject);
		}
		return null;
	}

	@Override
	public IRegion getSubject(ITextViewer textViewer, final int offset) {
		if(textViewer instanceof XtextSourceViewer){
			IXtextDocument document = ((XtextSourceViewer) textViewer).getXtextDocument();
			if (document != null) {
				Object resolvedObject = document.priorityReadOnly(new IUnitOfWork<Object, XtextResource>() {
					@Override
					public Object exec(XtextResource state) throws Exception {
						return eObjectAtOffsetHelper.resolveElementAt(state, offset);
					}
				});
				if(resolvedObject != null && resolvedObject instanceof EObject){
					this.contextObject = (EObject) resolvedObject;
				}
			}
		}
		this.contextRegion = computeRegion(textViewer, offset);
		this.textViewer = textViewer;
		return contextRegion;
	}

	protected IRegion computeRegion(ITextViewer textViewer, final int offset) {
		if(hover instanceof ITextHover)
			return ((ITextHover) hover).getHoverRegion(textViewer, offset);
		return new Region(offset, 0);
	}

	/**
	 * Just for compatibility reasons
	 * {@link org.eclipse.jface.text.information.IInformationProvider#getInformation(ITextViewer, IRegion)}
	 */
	@Override
	@Deprecated
	public String getInformation(ITextViewer textViewer, IRegion subject) {
		if(hover instanceof ITextHoverExtension2){
			Object hoverInfo2 = ((ITextHoverExtension2) hover).getHoverInfo2(textViewer, subject);
			return hoverInfo2!= null ? hoverInfo2.toString():null;
		}
		return null;
	}
}
