/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.services;

import java.util.List;

import org.eclipse.xtend.lib.macro.declaration.Element;

import com.google.common.annotations.Beta;

@Beta
public interface ProblemSupport {
	List<Problem> getProblems(Element element);
	void addError(Element element, String message);
	void addWarning(Element element, String message);
	void addInfo(Element element, String message);
}
