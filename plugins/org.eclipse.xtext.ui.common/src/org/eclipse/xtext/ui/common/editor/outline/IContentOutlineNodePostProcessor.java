/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.ImplementedBy;

/**
 * @author Michael Clay - Initial contribution and API
 */
@ImplementedBy(IContentOutlineNodePostProcessor.NullProcessor.class)
public interface IContentOutlineNodePostProcessor {

	void postProcess(EObject semanticModelObject, ContentOutlineNode contentOutlineNode);

	public class NullProcessor implements IContentOutlineNodePostProcessor {

		public void postProcess(EObject semanticModelObject, ContentOutlineNode contentOutlineNode) {
		}

	}

}
