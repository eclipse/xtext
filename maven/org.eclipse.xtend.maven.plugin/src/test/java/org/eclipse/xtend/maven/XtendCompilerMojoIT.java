package org.eclipse.xtend.maven;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import junit.framework.Assert;

import org.apache.maven.it.VerificationException;
import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;
import org.apache.maven.shared.utils.io.FileUtils;
import org.junit.Test;

public class XtendCompilerMojoIT {

	private static String ROOT = "/it/compile";

	@Test
	public void fileSystemAccess() throws Exception {
		deleteFileIfExist("myusercode/UserCode.css");
		deleteFileIfExist("com/itemis/myusercode/UserCode2.css");

		Verifier annotationVerifier = newVerifier(ROOT + "/filesystemaccess");
		annotationVerifier.setDebug(true);
		annotationVerifier.executeGoal("install");
		annotationVerifier.verifyErrorFreeLog();

		Verifier clientVerifier = newVerifier(ROOT + "/filesystemaccess-client");
		clientVerifier.setDebug(true);
		clientVerifier.executeGoal("compile");
		clientVerifier.verifyErrorFreeLog();
	}

	private void deleteFileIfExist(String path) throws URISyntaxException {
		URL userCodeURL = getClass().getResource(ROOT + "/filesystemaccess-client/src/main/java/" + path);
		if (userCodeURL != null) {
			new File(userCodeURL.toURI()).delete();
		}
	}

	@Test
	public void projectWithMultipleSourceDirectories() throws Exception {
		verifyErrorFreeLog(ROOT + "/multisources");
	}

	@Test
	public void simpleProject() throws Exception {
		verifyErrorFreeLog(ROOT + "/simple");
	}

	@Test
	public void encoding() throws Exception {
		Verifier verifier = newVerifier(ROOT + "/encoding");

		String xtendDir = verifier.getBasedir() + "/src/main/java";
		assertFileContainsUTF16(verifier, xtendDir + "/test/XtendA.xtend", "Mühlheim-Kärlicher Bürger");

		verifier.setDebug(true);
		verifier.executeGoal("test");
		verifier.verifyErrorFreeLog();

		String gen = verifier.getBasedir() + "/src/main/generated-sources/xtend/test/XtendA.java";
		assertFileContainsUTF16(verifier, gen, "Mühlheim-Kärlicher Bürger");
		assertFileContainsUTF16(verifier, gen, "_builder.append(\"möchte meine \");");
		assertFileContainsUTF16(verifier, gen, "_builder.append(\"tür ölen\", \"\");");
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
		Verifier verifier = newVerifier(ROOT + "/aggregation");
		verifier.setDebug(true);
		verifier.executeGoal("test");
		verifier.verifyErrorFreeLog();
		//https://bugs.eclipse.org/bugs/show_bug.cgi?id=409759
		String outputdir = verifier.getBasedir() + "/relativeoutput-module/";

		verifier.assertFilePresent(outputdir + "src/main/generated-sources/xtend/test/XtendA.java");
		verifier.assertFilePresent(outputdir + "src/main/generated-sources/xtend/test/XtendC.java");

		verifier.assertFilePresent(outputdir + "src/test/generated-sources/xtend/tests/XtendA.java");
		verifier.assertFilePresent(outputdir + "src/test/generated-sources/xtend/tests/XtendC.java");
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
		verifier.setDebug(true);
		verifier.executeGoal(goal);
		verifier.verifyErrorFreeLog();
		verifier.resetStreams();
	}

	private Verifier newVerifier(String pathToTestProject) throws IOException, VerificationException {
		File testDir = ResourceExtractor.simpleExtractResources(getClass(), pathToTestProject);
		Verifier verifier = new Verifier(testDir.getAbsolutePath());
		// verifier.setDebugJvm(true);
		// verifier.setForkJvm(false);
		return verifier;
	}

	public void assertFileContainsUTF16(Verifier verifier, String file, String contained) {
		verifier.assertFilePresent(file);
		try {
			String content = FileUtils.fileRead(new File(file), "UTF-16");
			if (!content.contains(contained)) {
				Assert.fail("Content of " + file + " does not contain " + contained + " but: " + content);
			}
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
	}
}
