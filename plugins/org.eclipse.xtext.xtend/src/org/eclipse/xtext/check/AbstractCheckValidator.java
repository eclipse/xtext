/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.check;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.xtend.check.CheckFacade;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtext.util.MultiMap;
import org.eclipse.xtext.validator.AbstractInjectableValidator;
import org.eclipse.xtext.validator.CheckMode;
import org.eclipse.xtext.validator.CheckType;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractCheckValidator extends AbstractInjectableValidator {

	private ExecutionContext ctx = null;

	@Inject
	public void setExecutionContext(ExecutionContext ctx) {
		this.ctx = ctx;
	}

	private final MultiMap<CheckType, String> checkFiles = new MultiMap<CheckType, String>();

	public void addCheckFile(String checkFile, CheckType checkType) {
		checkFiles.put(checkType, checkFile);
	}

	public void addCheckFile(String checkFile) {
		checkFiles.put(CheckType.FAST, checkFile);
	}

	public boolean validate(EClass eClass, EObject eObject, final DiagnosticChain diagnostics, Map<Object, Object> context) {
		CheckMode mode = CheckMode.getCheckMode(context);
		Issues issues = new IssuesImpl();
		for (CheckType type: checkFiles.keySet()) {
			if (mode.shouldCheck(type)) {
				List<String> list = checkFiles.get(type);
				for (String string : list) {
					CheckFacade.checkAll(string, Collections.singleton(eObject), ctx, issues);
				}
			}
		}

		for (MWEDiagnostic diag : issues.getIssues()) {
			diagnostics.add(diag);
		}
		return !issues.hasErrors();
	}

}
