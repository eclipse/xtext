/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel;

import static com.google.common.collect.Iterables.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DispatchUtil {
	
	@Inject
	private IJvmModelAssociations associations;

	public boolean isDispatcherFunction(JvmOperation inferredOperation) {
		final Iterator<XtendFunction> filter = filter(associations.getSourceElements(inferredOperation), XtendFunction.class).iterator();
		if (!filter.hasNext())
			return false;
		XtendFunction xtendFunction = filter.next();
		return !inferredOperation.getSimpleName().startsWith("_") && xtendFunction.isDispatch();
	}
	
	/**
	 * Return the local cases that are associated with the given dispatch operation.
	 */
	public List<JvmOperation> getDispatchCases(JvmOperation dispatchOperation) {
		Set<EObject> sourceElements = associations.getSourceElements(dispatchOperation);
		List<JvmOperation> result = Lists.newArrayList();
		for(EObject sourceElement: sourceElements) {
			if (sourceElement instanceof XtendFunction) {
				XtendFunction function = (XtendFunction) sourceElement;
				if (Strings.equal(function.getName(), dispatchOperation.getSimpleName())) {
					Set<EObject> jvmElements = associations.getJvmElements(function);
					for(EObject jvmElement: jvmElements) {
						if (jvmElement != dispatchOperation && jvmElement instanceof JvmOperation) {
							JvmOperation candidate = (JvmOperation) jvmElement;
							if (Strings.equal(candidate.getSimpleName(), '_' + function.getName())) {
								result.add(candidate);
							}
						}
					}
				}
			}
		}
		return result;
	}

}
