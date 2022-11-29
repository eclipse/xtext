/**
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard;

import java.util.LinkedHashSet;
import java.util.Set;

public class UiTestProjectDescriptor extends TestProjectDescriptor {

	public UiTestProjectDescriptor(TestedProjectDescriptor testedProject) {
		super(testedProject);
	}

	@Override
	public Set<ExternalDependency> getExternalDependencies() {
		Set<ExternalDependency> deps = new LinkedHashSet<>();
		deps.addAll(super.getExternalDependencies());
		ExternalDependency xtextTesting = ExternalDependency.createXtextDependency("org.eclipse.xtext.testing");
		xtextTesting.getMaven().setScope(Scope.TESTCOMPILE);
		deps.add(xtextTesting);
		ExternalDependency xtextUiTesting = ExternalDependency.createXtextDependency("org.eclipse.xtext.ui.testing");
		xtextUiTesting.getMaven().setScope(Scope.TESTCOMPILE);
		deps.add(xtextUiTesting);
		ExternalDependency xbaseTesting = ExternalDependency.createXtextDependency("org.eclipse.xtext.xbase.testing");
		xbaseTesting.getMaven().setScope(Scope.TESTCOMPILE);
		deps.add(xbaseTesting);
		ExternalDependency xbaseUiTesting = ExternalDependency.createXtextDependency("org.eclipse.xtext.xbase.ui.testing");
		xbaseUiTesting.getMaven().setScope(Scope.TESTCOMPILE);
		deps.add(xbaseUiTesting);
		return deps;
	}

	@Override
	public boolean isPartOfGradleBuild() {
		return false;
	}

	@Override
	public boolean isPartOfMavenBuild() {
		return true;
	}

	@Override
	public boolean needsUiHarness() {
		return true;
	}
}
