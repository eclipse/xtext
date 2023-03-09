/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard;

import java.util.LinkedHashSet;
import java.util.Set;

public class RuntimeTestProjectDescriptor extends TestProjectDescriptor {

	public RuntimeTestProjectDescriptor(TestedProjectDescriptor testedProject) {
		super(testedProject);
	}

	@Override
	public Set<ExternalDependency> getExternalDependencies() {
		Set<ExternalDependency> deps = new LinkedHashSet<>();
		deps.addAll(super.getExternalDependencies());
		ExternalDependency xtextTesting = ExternalDependency.createXtextDependency("org.eclipse.xtext.testing");
		xtextTesting.getMaven().setScope(Scope.TESTCOMPILE);
		deps.add(xtextTesting);
		ExternalDependency xbaseTesting = ExternalDependency.createXtextDependency("org.eclipse.xtext.xbase.testing");
		xbaseTesting.getMaven().setScope(Scope.TESTCOMPILE);
		deps.add(xbaseTesting);
		return deps;
	}

	@Override
	public boolean isPartOfGradleBuild() {
		return getConfig().getPreferredBuildSystem() == BuildSystem.GRADLE;
	}

	@Override
	public boolean isPartOfMavenBuild() {
		return getConfig().getPreferredBuildSystem() == BuildSystem.MAVEN;
	}
}
