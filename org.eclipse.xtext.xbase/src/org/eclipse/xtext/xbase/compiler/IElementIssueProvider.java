/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.ImplementedBy;

/**
 * Allows to obtain all issues for a given element including its children.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IElementIssueProvider {
	
	Iterable<Issue> getIssues(EObject element);
	
	@ImplementedBy(ElementIssueProvider.Factory.class)
	interface Factory {
		IElementIssueProvider get(Resource reosurce);
	}
	
}
