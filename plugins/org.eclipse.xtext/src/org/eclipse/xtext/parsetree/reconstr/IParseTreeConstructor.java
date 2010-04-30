/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Moritz Eysholt
 */
public interface IParseTreeConstructor {

	interface TreeConstructionDiagnostic {
		// TODO: Javadoc
		EObject getEObject();

		String getLikelyErrorReasons();
	}

	interface TreeConstructionReport {
		List<TreeConstructionDiagnostic> getDiagnostics();

		boolean isSuccess();
	}

	// TODO: rename to serializeSubtree()
	TreeConstructionReport serializeRecursive(EObject object, ITokenStream out) throws IOException;
}
