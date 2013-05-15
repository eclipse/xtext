/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import java.util.List;

import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider2;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineMode;

import com.google.inject.ImplementedBy;

/**
 * Creates outline nodes. Only called from within {@link org.eclipse.xtext.util.concurrent.IUnitOfWork}s where the
 * {@link IXtextDocument} can be read safely.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(DefaultOutlineTreeProvider2.class)
public interface IOutlineTreeProvider {

	IOutlineNode createRoot(IXtextDocument document);

	/**
	 * For outline tree providers that support multimple modes, e.g. show elements from superclasses or not.
	 * 
	 * @author Jan Koehnlein - Initial contribution and API
	 * @since 2.4
	 */
	interface ModeAware {
		List<OutlineMode> getOutlineModes();
		
		OutlineMode getCurrentMode();

		OutlineMode getNextMode();

		void setCurrentMode(OutlineMode outlineMode);
	}

	/**
	 * If true, the outline nodes can be calculated in a background job, i.e. without blocking the display thread. 
	 * 
	 * @author Jan Koehnlein - Initial contribution and API
	 * @since 2.4
	 */
	interface Extension {

		boolean needsDisplayThread();
	}
}
