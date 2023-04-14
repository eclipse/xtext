/*******************************************************************************
 * Copyright (c) 2013, 2016, 2023 itemis AG (http://www.itemis.eu) and others.
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
import org.apache.maven.shared.utils.io.FileUtils;
import org.junit.Assert;

/**
 * @author dhuebner
 * @author Lorenzo Bettini - refactoring
 *
 */
public class MavenVerifierUtil {

	private final static boolean debug = Boolean.getBoolean("xtend.it.tests.debug");

	public static final String IT_ROOT = "/it";

	/**
	 * This is the local Maven repository (typically ~/.m2/repository) that we
	 * will pass to the parent POM of IT projects through the property "local-central".
	 * The idea is to use our local Maven repository cache that we filled up to now as a
	 * "remote" Maven repository when building our IT projects, to speed-up the tests.
	 * Inspired by https://maven.apache.org/plugins/maven-invoker-plugin/examples/fast-use.html
	 */
	private static File localRepoDir;

	public static Verifier newVerifier(String pathToTestProject) throws IOException, VerificationException {
		File testDir = copyProjectToTempDir(pathToTestProject);
		return createVerifier(testDir);
	}

	private static Verifier createVerifier(File baseDir) throws VerificationException {
		Verifier verifier = new Verifier(baseDir.getAbsolutePath(), true);

		String testMavenRepo = System.getProperty("testMavenRepo");
		Assert.assertNotNull(
			"Required property 'testMavenRepo' is null!\n"
			+ "If you run these tests from Eclipse, first run the Maven launch\n"
			+ "'pre-integration-test.launch'\n"
			+ "then use the JUnit launch\n"
			+ "'Run ITs from Eclipse.launch'.",
			testMavenRepo);
		verifier.setLocalRepo(testMavenRepo);

		String localCentralRepository = System.getProperty("maven.repo.local",
				System.getProperty("user.home") + "/.m2/repository");
		localRepoDir = new File(localCentralRepository);

		verifier.setSystemProperty("local-central", localRepoDir.toString());

		if (debug) {
			verifier.setMavenDebug(debug);
		}

		String testSettingsXML = System.getProperty("testSettingsXML");
		if (testSettingsXML != null) {
			verifier.addCliOption("-s");
			verifier.addCliOption(testSettingsXML);
		}
		verifier.addCliOption("-U");
		// verifier.setDebugJvm(true);
		// verifier.setForkJvm(false);

		return verifier;
	}

	public static File copyProjectToTempDir(String pathToTestProject) throws IOException {
		File tempDir = getTempDir();
		File testDir = new File(tempDir, pathToTestProject);
		FileUtils.deleteDirectory(testDir);

		testDir = ResourceExtractor.extractResourcePath(MavenVerifierUtil.class, pathToTestProject, tempDir, true);
		return testDir;
	}

	public static File getTempDir() {
		// it's best to pass a subdirectory of the target folder for "maven.test.tmpdir":
		// that will be the directory where our IT projects will be copied and where
		// the Maven build will be executed.
		// This will make their inspection afterward (the log.txt file) easier.
		// For this reason, we delete that directory here, but NOT after the tests.
		String tempDirPath = System.getProperty("maven.test.tmpdir", System.getProperty("java.io.tmpdir"));
		File tempDir = new File(tempDirPath);
		return tempDir;
	}

	public static void checkMavenExecutable(String verifierRoot) throws IOException, VerificationException {
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
		// copy the parent POM
		File tempDir = getTempDir();
		File pom = ResourceExtractor.extractResourcePath(MavenVerifierUtil.class,
				IT_ROOT + "/pom.xml", tempDir, true);
		// and install it
		Verifier verifier = createVerifier(pom.getParentFile());
		verifier.setDebug(true);
		verifier.executeGoal("install");
		verifier.verifyErrorFreeLog();
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
