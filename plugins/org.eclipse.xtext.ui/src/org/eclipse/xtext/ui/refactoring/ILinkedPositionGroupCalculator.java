/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring.ui.LinkedPositionGroupCalculator;

import com.google.inject.ImplementedBy;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Jan Koehnlein
 */
@ImplementedBy(LinkedPositionGroupCalculator.class)
public interface ILinkedPositionGroupCalculator {

	public LinkedPositionGroup getLinkedPositionGroup(IRenameElementContext renameElementContext);
	
}
