/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import static com.google.common.collect.Iterables.*;

import java.util.Collections;

import org.eclipse.ltk.core.refactoring.participants.RenameArguments;

/**
 * Stores information on an element to be renamed and elements whose names change as a consequence.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class ElementRenameArguments extends RenameArguments {

	private final ElementRenameInfo baseElementRenameInfo;
	private final Iterable<ElementRenameInfo> dependentElementRenameInfos;

	public ElementRenameArguments(String newName, ElementRenameInfo baseElementRenameInfo,
			Iterable<ElementRenameInfo> dependentElementRenameInfos, boolean updateReferences) {
		super(newName, updateReferences);
		this.baseElementRenameInfo = baseElementRenameInfo;
		this.dependentElementRenameInfos = dependentElementRenameInfos;
	}

	public ElementRenameInfo getBaseElementRenameInfo() {
		return baseElementRenameInfo;
	}

	public Iterable<ElementRenameInfo> getDependentElementRenameInfos() {
		return dependentElementRenameInfos;
	}

	public Iterable<ElementRenameInfo> getAllElementRenameInfos() {
		return concat(Collections.singletonList(baseElementRenameInfo), dependentElementRenameInfos);
	}

}
