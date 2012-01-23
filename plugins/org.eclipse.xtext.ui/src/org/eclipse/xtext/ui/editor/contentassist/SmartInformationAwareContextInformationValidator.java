/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationPresenter;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;


/**
 * An implementation of the <code>IContextInfomationValidator</code> interface.
 * This implementation tries to use {@link ISmartContextInformation} to determine
 * the validity of the information. If this interface is not fulfilled,
 * it determines whether the information is valid by asking the content
 * assist processor for all context information objects for the current position. If the
 * currently displayed information is in the result set, the context information is
 * considered valid.
 * @see ContextInformationValidator
 * @since 2.3
 */
public class SmartInformationAwareContextInformationValidator implements IContextInformationValidator, IContextInformationPresenter {

	/** The content assist processor. */
	private IContentAssistProcessor fProcessor;
	/** The context information to be validated. */
	private IContextInformation fContextInformation;
	/** The associated text viewer. */
	private ITextViewer fViewer;

	/**
	 * Creates a new context information validator which is ready to be installed on
	 * a particular context information.
	 *
	 * @param processor the processor to be used for validation
	 */
	public SmartInformationAwareContextInformationValidator(IContentAssistProcessor processor) {
		fProcessor= processor;
	}

	public void install(IContextInformation contextInformation, ITextViewer viewer, int offset) {
		fContextInformation= contextInformation;
		fViewer= viewer;
	}

	public boolean isContextInformationValid(int offset) {
		if (fContextInformation instanceof ISmartContextInformation) {
			return ((ISmartContextInformation) fContextInformation).isContextInformationValid(fViewer, offset);
		} else {
			IContextInformation[] infos= fProcessor.computeContextInformation(fViewer, offset);
			if (infos != null && infos.length > 0) {
				for (int i= 0; i < infos.length; i++)
					if (fContextInformation.equals(infos[i]))
						return true;
			}
			return false;
		}
	}

	public boolean updatePresentation(int offset, TextPresentation presentation) {
		if (fContextInformation instanceof ISmartContextInformation) {
			return ((ISmartContextInformation) fContextInformation).updatePresentation(fViewer, offset, presentation);
		}
		return false;
	}
}
