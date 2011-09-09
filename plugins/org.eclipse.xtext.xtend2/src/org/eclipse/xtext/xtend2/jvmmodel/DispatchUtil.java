/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.jvmmodel;

import static com.google.common.collect.Iterables.*;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DispatchUtil {
	
	@Inject
	private IJvmModelAssociations associations;

	public boolean isDispatcherFunction(JvmOperation inferredOperation) {
		XtendFunction xtendFunction = filter(associations.getSourceElements(inferredOperation), XtendFunction.class).iterator().next();
		return !inferredOperation.getSimpleName().startsWith("_") && xtendFunction.isDispatch();
	}

}
