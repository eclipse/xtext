/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import java.util.List;

import org.eclipse.jface.text.ITextHover;
import org.eclipse.xtext.ui.editor.hover.DefaultCompositeHover;

import com.google.inject.Inject;

/**
 * @author Christoph Kulla - Initial contribution and API
 */
public class JdtCompositeHover extends DefaultCompositeHover {

	@Inject
	JdtHover jdtHover;
	
	@Override
	protected List<ITextHover> createHovers() {
		List<ITextHover> list = super.createHovers();
		list.add (1,jdtHover);
		return list;
	}

}
