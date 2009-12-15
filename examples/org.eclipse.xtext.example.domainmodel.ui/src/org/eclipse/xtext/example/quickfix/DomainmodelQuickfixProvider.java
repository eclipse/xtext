/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example.quickfix;

import org.eclipse.xtext.example.domainmodel.Type;
import org.eclipse.xtext.example.validation.DomainmodelJavaValidator;
import org.eclipse.xtext.ui.core.editor.quickfix.AbstractDeclarativeQuickfixProvider;
import org.eclipse.xtext.ui.core.editor.quickfix.Fix;
import org.eclipse.xtext.validation.IssueContext;

public class DomainmodelQuickfixProvider extends AbstractDeclarativeQuickfixProvider {

	@Fix(code = DomainmodelJavaValidator.INVALID_TYPE_NAME, label = "Capitalize name", description = "Capitalize name of type")
	public void fixName(Type type, IssueContext issue) {
		type.setName(type.getName().toUpperCase());
	}

}
