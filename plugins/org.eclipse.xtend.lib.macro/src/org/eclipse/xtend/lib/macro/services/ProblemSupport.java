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
import org.eclipse.xtend.lib.macro.services.Problem.Severity;
import org.eclipse.xtext.xbase.lib.Procedures;

import com.google.common.annotations.Beta;

/**
 * Support for looking up and creating new {@link Problem} markers on {@link Element}s
 * 
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface ProblemSupport {
	/**
	 * @param element the element to look up problems
	 * @return the problems associated with the given {@link Element}
	 */
	List<? extends Problem> getProblems(Element element);
	
	/**
	 * Adds a problem marker with severity {@link Severity}#ERROR to the given element
	 * 
	 * @param element the element to which associate the new problem marker
	 * @param message the message for the problem marker
	 */
	void addError(Element element, String message);
	
	/**
	 * Adds a problem marker with severity {@link Severity}#WARNING to the given element
	 * 
	 * @param element the element to which associate the new problem marker
	 * @param message the message for the problem marker
	 */
	void addWarning(Element element, String message);

	/**
	 * @param validationCallback
	 *            a callback that will be executed in the validation phase, when
	 *            all transformations have been done and types are inferred.
	 * @since 2.7
	 */
	void validateLater(Procedures.Procedure0 validationCallback);
}

