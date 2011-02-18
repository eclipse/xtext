/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.labeling;

import static com.google.common.collect.Iterables.*;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xtend2.linking.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DispatchUtil {
	
	@Inject
	private IXtend2JvmAssociations associations;

	public boolean isDispatcherFunction(JvmOperation inferredOperation) {
		Iterable<XtendFunction> xtendFunctions = associations.getAssociatedElements(inferredOperation, XtendFunction.class);
		return size(xtendFunctions) > 1 || (!isEmpty(xtendFunctions) && !inferredOperation.getSimpleName().equals(xtendFunctions.iterator().next().getSimpleName()));
	}

	public boolean isDispatcherFunction(XtendFunction xtendFunction) {
		return isDispatcherFunction(associations.getDirectlyInferredOperation(xtendFunction));
	}

	public boolean isDispatchFunction(XtendFunction xtendFunction) {
		return xtendFunction.getName() != null && xtendFunction.getName().startsWith("_");
	}
}
