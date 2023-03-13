/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.maven;

import java.io.File;
import java.io.IOException;

import org.apache.maven.it.VerificationException;
import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;
import org.apache.maven.shared.utils.cli.CommandLineUtils;
import org.junit.Assert;

/**
 * @author dhuebner
 *
 */
public class MavenVerifierUtil {

	public static Verifier newVerifier(String pathToTestProject) throws IOException, VerificationException {
		File testDir = ResourceExtractor.simpleExtractResources(MavenVerifierUtil.class, pathToTestProject);
		Verifier verifier = new Verifier(testDir.getAbsolutePath());

		String testMavenRepo = System.getProperty("testMavenRepo");
		Assert.assertNotNull(
			"Required property 'testMavenRepo' is null!\n"
			+ "If you run these tests from Eclipse, first run the Maven launch\n"
			+ "'pre-integration-test.launch'\n"
			+ "then use the JUnit launch\n"
			+ "'Run ITs from Eclipse.launch'.",
			testMavenRepo);
		verifier.setLocalRepo(testMavenRepo);

		verifier.setDebug(true);
		String testSettingsXML = System.getProperty("testSettingsXML");
		if (testSettingsXML != null) {
			verifier.addCliOption("-s");
			verifier.addCliOption(testSettingsXML);
		}
		verifier.addCliOption("-U");
		verifier.setMavenDebug(true);
		// verifier.setDebugJvm(true);
		// verifier.setForkJvm(false);
		return verifier;
	}

	static public void checkMavenExecutable(String verifierRoot) throws IOException, VerificationException {
		File mvnExecutable = new File(new Verifier(verifierRoot).getExecutable());
		if (!mvnExecutable.exists()) {
			String mavenHome = findMaven();
			if (mavenHome != null) {
				System.setProperty("maven.home", mavenHome);
			} else {
				Assert.fail("Maven home not found. Tried to call '" + mvnExecutable
						+ "'.\nConsider to set the envVar 'M2_HOME' or System property 'maven.home'.\n"
						+ "Current settings are: maven.home=" + System.getProperty("maven.home") + " M2_HOME="
						+ CommandLineUtils.getSystemEnvVars().getProperty("M2_HOME"));
			}
		}
	}

	private static String findMaven() {
		// TODO add more mavens here
		String[] mavens = new String[] { System.getProperty("maven.home"),
				"/opt/local/share/java/maven3/",
				"/usr/local/", "/usr/",
				"/opt/homebrew/"};
		for (String maven : mavens) {
			if (new File(maven + "/bin/mvn").exists()) {
				return maven;
			}
		}
		return null;
	}
}
