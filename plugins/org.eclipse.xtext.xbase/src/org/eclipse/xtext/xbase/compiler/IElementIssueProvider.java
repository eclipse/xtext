/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Issue;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IElementIssueProvider {
	
	List<Issue> getIssues(EObject element, boolean includeContents);
}
