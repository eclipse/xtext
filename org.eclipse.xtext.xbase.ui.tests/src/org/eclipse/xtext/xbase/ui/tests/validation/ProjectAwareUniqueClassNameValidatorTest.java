/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.validation;

import org.eclipse.core.runtime.Path;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class ProjectAwareUniqueClassNameValidatorTest {
	private MockedProjectAwareUniqueClassNameValidator classNameValidator = new MockedProjectAwareUniqueClassNameValidator();

	@Test
	public void testIfDerived_MavenPath() {
		OutputConfiguration output = new OutputConfiguration("TEST");
		output.setOutputDirectory("xtend_gen");
		OutputConfiguration.SourceMapping sourceMapping = new OutputConfiguration.SourceMapping("src/main/xtend_gen");
		output.getSourceMappings().add(sourceMapping);
		classNameValidator.getContext().put("ProjectAwareUniqueClassNameValidator.outputConfigs", Lists.newArrayList(output));
		MockedFile file = new MockedFile(new Path("foo/src/main/xtend_gen/org/eclipse/test/foo.bar"), null);
		Assert.assertTrue(classNameValidator.isDerived(file));
	}

	@Test
	public void testIfDerived_MavenPath_2() {
		OutputConfiguration output = new OutputConfiguration("TEST");
		output.setOutputDirectory("xtend_gen");
		classNameValidator.getContext().put("ProjectAwareUniqueClassNameValidator.outputConfigs", Lists.newArrayList(output));
		MockedFile file = new MockedFile(new Path("foo/src/main/xtend_gen/org/eclipse/test/foo.bar"), null);
		Assert.assertFalse(classNameValidator.isDerived(file));
	}

	@Test
	public void testIfDerived_MavenPath_3() {
		OutputConfiguration output = new OutputConfiguration("TEST");
		output.setOutputDirectory("xtend_gen");
		OutputConfiguration.SourceMapping sourceMapping = new OutputConfiguration.SourceMapping("src/main/xtend_gen");
		output.getSourceMappings().add(sourceMapping);
		classNameValidator.getContext().put("ProjectAwareUniqueClassNameValidator.outputConfigs", Lists.newArrayList(output));
		MockedFile file = new MockedFile(new Path("foo/src/main/src/org/eclipse/test/foo.bar"), null);
		Assert.assertFalse(classNameValidator.isDerived(file));
	}

	@Test
	public void testIfDerived_MavenPath_4() {
		OutputConfiguration output = new OutputConfiguration("TEST");
		output.setOutputDirectory("xtend_gen");
		OutputConfiguration.SourceMapping sourceMapping = new OutputConfiguration.SourceMapping("src/main/xtend_gen");
		output.getSourceMappings().add(sourceMapping);
		OutputConfiguration.SourceMapping sourceMapping2 = new OutputConfiguration.SourceMapping("src/test/xtend_gen");
		output.getSourceMappings().add(sourceMapping2);
		classNameValidator.getContext().put("ProjectAwareUniqueClassNameValidator.outputConfigs", Lists.newArrayList(output));
		MockedFile file = new MockedFile(new Path("foo/src/test/xtend_gen/org/eclipse/test/foo.bar"), null);
		Assert.assertTrue(classNameValidator.isDerived(file));
	}

	@Test
	public void testIfDerived_Plain() {
		OutputConfiguration output = new OutputConfiguration("TEST");
		output.setOutputDirectory("xtend_gen");
		OutputConfiguration.SourceMapping sourceMapping = new OutputConfiguration.SourceMapping("xtend_gen");
		output.getSourceMappings().add(sourceMapping);
		classNameValidator.getContext().put("ProjectAwareUniqueClassNameValidator.outputConfigs", Lists.newArrayList(output));
		MockedFile file = new MockedFile(new Path("foo/xtend_gen/org/eclipse/test/foo.bar"), null);
		Assert.assertTrue(classNameValidator.isDerived(file));
	}

	@Test
	public void testIfDerived_Plain_1() {
		OutputConfiguration output = new OutputConfiguration("TEST");
		output.setOutputDirectory("xtend_gen");
		classNameValidator.getContext().put("ProjectAwareUniqueClassNameValidator.outputConfigs", Lists.newArrayList(output));
		MockedFile file = new MockedFile(new Path("foo/xtend_gen/org/eclipse/test/foo.bar"), null);
		Assert.assertTrue(classNameValidator.isDerived(file));
	}
}
