/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.linking;

import java.util.Set;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DispatchUtil {
	
	@Inject
	private IXtend2JvmAssociations associations;

	public boolean isDispatcherFunction(JvmOperation inferredOperation) {
		Set<XtendFunction> xtendFunctions = associations.getAssociatedElements(inferredOperation, XtendFunction.class);
		return xtendFunctions.size() > 1;
	}

}
