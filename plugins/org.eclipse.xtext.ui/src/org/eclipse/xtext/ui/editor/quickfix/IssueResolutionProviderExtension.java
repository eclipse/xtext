/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.xtext.validation.Issue;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public interface IssueResolutionProviderExtension {

	/**
	 * @return whether this resolution provider is able to provide resolutions for the given issue.
	 */
	boolean hasResolutionFor(Issue issue);
}
