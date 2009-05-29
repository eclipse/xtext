/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.check;

import java.util.Collections;
import java.util.EnumMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.xtend.check.CheckFacade;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtext.validation.AbstractInjectableValidator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.CheckType;

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

	private final EnumMap<CheckType, Set<String>> checkFiles = new EnumMap<CheckType, Set<String>>(CheckType.class);

	public void addCheckFile(String checkFile, CheckType checkType) {
		Set<String> checks = checkFiles.get(checkType);
		if(checks == null) {
			checks = new LinkedHashSet<String>();
			checkFiles.put(checkType, checks);
		}
		checks.add(checkFile);
	}

	public void addCheckFile(String checkFile) {
		addCheckFile(checkFile, CheckType.FAST);
	}

	public boolean validate(EClass eClass, EObject eObject, final DiagnosticChain diagnostics, Map<Object, Object> context) {
		CheckMode mode = CheckMode.getCheckMode(context);
		Issues issues = new IssuesImpl();
		for (CheckType type: checkFiles.keySet()) {
			if (mode.shouldCheck(type)) {
				Set<String> list = checkFiles.get(type);
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
