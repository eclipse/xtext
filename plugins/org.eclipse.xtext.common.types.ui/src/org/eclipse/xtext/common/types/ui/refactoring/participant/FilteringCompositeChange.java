/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring.participant;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;

/**
 * A composite change that filters undo changes for derived Java resources.
 * 
 * Xtext's rename refactoring will create changes for generated Java files in order to update references from other Java
 * resources to the derived code. As the Xtext source changes, the builder will additionally touch these generated Java
 * files after the refactoring. Consequently the derived Java resource change cannot be undone and with it the entire
 * composite change. Filtering these changes reenables undo.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class FilteringCompositeChange extends CompositeChange {

	private static final Logger LOG = Logger.getLogger(FilteringCompositeChange.class);

	public FilteringCompositeChange(String name) {
		super(name);
	}

	@Override
	protected Change createUndoChange(Change[] childUndos) {
		List<Change> filteredUndos = newArrayList();
		for (Change childUndo : childUndos) {
			try {
				Object modifiedElement = childUndo.getModifiedElement();
				if (modifiedElement instanceof ICompilationUnit) {
					ICompilationUnit cu = (ICompilationUnit) modifiedElement;
					if (cu.exists()) {
						IResource resource = cu.getUnderlyingResource();
						if (!resource.isDerived()) {
							filteredUndos.add(childUndo);
						}
					}
				} else {
					filteredUndos.add(childUndo);
				}
			} catch (JavaModelException e) {
				LOG.error("Error filtering refactoring undo changes", e);
			}
		}
		return super.createUndoChange(toArray(filteredUndos, Change.class));
	}
}
