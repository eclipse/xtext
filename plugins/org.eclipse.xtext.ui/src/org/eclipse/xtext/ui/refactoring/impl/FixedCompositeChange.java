/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Lists.*;

import java.util.Arrays;
import java.util.List;

import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;

/**
 * A fixed version of {@link CompositeChange}, retruning affectedObjects even if one of the children returns
 * <code>null</code> for them.
 * See <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=410438">bug 410438</a>.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
public class FixedCompositeChange extends CompositeChange {

	public FixedCompositeChange(String name) {
		super(name);
	}

	@Override
	public Object[] getAffectedObjects() {
		if (getChildren().length == 0)
			return new Object[0];
		List<Object> result = newArrayList();
		for (Change change : getChildren()) {
			Object[] affectedObjects = change.getAffectedObjects();
			if (affectedObjects != null)
				result.addAll(Arrays.asList(affectedObjects));
		}
		return result.toArray();
	}
}
