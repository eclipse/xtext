/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.xtext.ui.refactoring.ui.DefaultLinkedPositionGroupCalculator;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.ImplementedBy;

/**
 * Calculates the positions that should be synchronously edited by the linked editing mode. 
 * 
 * @author Holger Schill - Initial contribution and API
 * @author Jan Koehnlein
 */
@ImplementedBy(DefaultLinkedPositionGroupCalculator.class)
public interface ILinkedPositionGroupCalculator {

	public LinkedPositionGroup getLinkedPositionGroup(IRenameElementContext renameElementContext,
			IProgressMonitor monitor);

}
