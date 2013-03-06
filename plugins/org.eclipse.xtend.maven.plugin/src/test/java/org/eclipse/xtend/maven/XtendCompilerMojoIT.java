package org.eclipse.xtend.maven;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.apache.maven.it.VerificationException;
import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;
import org.junit.Test;

public class XtendCompilerMojoIT {

	private static String ROOT = "/it/compile";

	@Test
	public void projectWithMultipleSourceDirectories() throws Exception {
		verifyErrorFreeLog(ROOT + "/multisources");
	}

	@Test
	public void simpleProject() throws Exception {
		verifyErrorFreeLog(ROOT + "/simple");
	}

	@Test
	public void pluginPrefix() throws Exception {
		verifyErrorFreeLog(ROOT + "/simple", "xtend:compile");
	}

	@Test
	public void simpleProjectXtend2Tests() throws Exception {
		verifyErrorFreeLog(ROOT + "/withtestsrc");
	}

	@Test
	public void aggregation() throws Exception {
		verifyErrorFreeLog(ROOT + "/aggregation");
	}

	@Test
	public void macro() throws Exception {
		verifyErrorFreeLog(ROOT + "/macros");
	}

	@Test
	public void haltOnXtendValidationErrors() throws Exception {
		Verifier verifier = newVerifier(ROOT + "/xtenderrors");
		try {
			verifier.executeGoal("verify");
			Assert.fail("expected org.apache.maven.plugin.MojoExecutionException");
		} catch (Exception e) {
			verifier.verifyTextInLog("3: Superclass must be a class");
			verifier.verifyTextInLog("BUILD FAILURE");
		}
	}

	@Test
	public void continueOnXtendWarnings() throws Exception {
		Verifier verifier = newVerifier(ROOT + "/xtendwarnings");
		verifier.executeGoal("verify");
		verifier.verifyTextInLog("3: The import 'java.util.Collections' is never used.");
		verifier.verifyTextInLog("[INFO] BUILD SUCCESS");
	}

	@Test
	public void readXtendPrefs() throws Exception {
		Verifier verifier = newVerifier(ROOT + "/xtend-prefs");
		verifier.setDebug(true);
		verifier.executeGoal("test");
		verifier.verifyErrorFreeLog();
		String xtendOutputDirFromPrefs = "generated-sources/xtend-from-pref";

		String xtendGenDir = verifier.getBasedir() + "/src/main/" + xtendOutputDirFromPrefs;
		verifier.assertFilePresent(xtendGenDir + "/test/XtendA.java");
		verifier.assertFilePresent(xtendGenDir + "/test/XtendC.java");

		String xtendTestGenDir = verifier.getBasedir() + "/src/test/" + xtendOutputDirFromPrefs;
		verifier.assertFilePresent(xtendTestGenDir + "/tests/XtendA.java");
		verifier.assertFilePresent(xtendTestGenDir + "/tests/XtendC.java");
	}

	@Test
	public void readXtendPrefsUnused() throws Exception {
		Verifier verifier = newVerifier(ROOT + "/xtend-prefs-unused");
		verifier.setDebug(true);
		verifier.executeGoal("test");
		verifier.verifyErrorFreeLog();
		String pomsOutputDir = "xtend-dir-from-pom";

		String xtendGenDir = verifier.getBasedir() + "/src/main/" + pomsOutputDir;
		verifier.assertFilePresent(xtendGenDir + "/test/XtendA.java");
		verifier.assertFilePresent(xtendGenDir + "/test/XtendC.java");

		String xtendTestGenDir = verifier.getBasedir() + "/src/test/" + pomsOutputDir;
		verifier.assertFilePresent(xtendTestGenDir + "/tests/XtendA.java");
		verifier.assertFilePresent(xtendTestGenDir + "/tests/XtendC.java");
	}

	private void verifyErrorFreeLog(String pathToTestProject) throws IOException, VerificationException {
		verifyErrorFreeLog(pathToTestProject, "verify");
	}

	private void verifyErrorFreeLog(String pathToTestProject, String goal) throws IOException, VerificationException {
		Verifier verifier = newVerifier(pathToTestProject);
		verifier.executeGoal(goal);
		verifier.verifyErrorFreeLog();
		verifier.setDebug(true);
		verifier.resetStreams();
	}

	private Verifier newVerifier(String pathToTestProject) throws IOException, VerificationException {
		File testDir = ResourceExtractor.simpleExtractResources(getClass(), pathToTestProject);
		Verifier verifier = new Verifier(testDir.getAbsolutePath());
		//		verifier.setDebugJvm(true);
		//		verifier.setForkJvm(false);
		return verifier;
	}
}
