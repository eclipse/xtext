/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.xtext.ui.refactoring.impl.LinkedModelCalculator;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.ImplementedBy;

/**
 * @author Holger Schill - Initial contribution and API
 */
@ImplementedBy(LinkedModelCalculator.class)
public interface ILinkedModelCalculator {

	public void init(IRenameElementContext renameElementContext);
	
	public LinkedPositionGroup getLinkedPositionGroup();
	
	public IRenameStrategy getRenameStrategy();
	
}
