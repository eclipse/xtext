/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard.cli;

import java.io.File;
import java.util.List;

import org.eclipse.xtext.tests.TemporaryFolder;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Karsten Thoms (karsten.thoms@itemis.de) - Initial contribution and API
 * @since 2.15
 */
public class CliProjectsCreatorMainTest {
	@Rule
	public TemporaryFolder temp = new TemporaryFolder();

	@Test
	public void testCreateGreetingsGradleProject() throws Exception {
		File targetDir = temp.newFolder();
		// @formatter:off
		String[] args = new String[] {
			"-targetDir=" + targetDir.getAbsolutePath(),
			"-languageName=org.xtext.example.mydsl.MyDsl",
			"-baseName=org.xtext.example.mydsl",
			"-extension=mydsl",
			"-enabledProjects=GenericIDE,RuntimeTest",
			"-buildSystem=GRADLE",
			"-sourceLayout=MAVEN",
			"-languageServer=FATJAR",
			"-xtextVersion=undefined",
			"-projectLayout=FLAT",
			"-javaVersion=JAVA10"
		};
		// @formatter:on
		CliProjectsCreatorMain.main(args);
		// @formatter:off
		List<String> files = Lists.newArrayList(
				"org.xtext.example.mydsl/src/main/java/org/xtext/example/mydsl/GenerateMyDsl.mwe2",
				"org.xtext.example.mydsl/src/main/java/org/xtext/example/mydsl/MyDsl.xtext",
				"org.xtext.example.mydsl/build.gradle",
				"org.xtext.example.mydsl.ide/build.gradle",
				"org.xtext.example.mydsl.parent/build.gradle",
				"org.xtext.example.mydsl.parent/gradlew",
				"org.xtext.example.mydsl.parent/gradlew.bat",
				"org.xtext.example.mydsl.parent/settings.gradle",
				"org.xtext.example.mydsl.parent/gradle/source-layout.gradle",
				"org.xtext.example.mydsl.parent/gradle/wrapper/gradle-wrapper.jar",
				"org.xtext.example.mydsl.parent/gradle/wrapper/gradle-wrapper.properties");
		// @formatter:on
		for (String file : files) {
			Assert.assertTrue(new File(targetDir, file).exists());
		}
	}
}
