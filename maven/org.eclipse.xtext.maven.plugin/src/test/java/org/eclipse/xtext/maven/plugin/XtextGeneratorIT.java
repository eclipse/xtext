package org.eclipse.xtext.maven.plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.maven.it.VerificationException;
import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.base.Joiner;

public class XtextGeneratorIT {

	private static String ROOT = "/it/generate";

	@BeforeClass
	static public void setUpOnce() throws IOException, VerificationException {
		new XtextGeneratorIT().verifyErrorFreeLog(ROOT, "clean", "install");
	}

	private final static boolean debug = false;

	@Test
	public void simpleLang() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/simple-lang");
		verifier.assertFileMatches(verifier.getBasedir() + "/src-gen/greetings.txt", "People to greet\\: Test");
	}

	@Test
	public void mavenConfiguration() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/maven-config");
		verifier.assertFileMatches(verifier.getBasedir() + "/model2-output/greetings.txt", "People to greet\\: maven2");
		verifier.assertFilePresent(verifier.getBasedir() + "/model-output/IntegrationTestXbase.java");
	}

	@Test
	public void purexbase() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/purexbase");
		verifier.assertFilePresent(verifier.getBasedir() + "/src-gen/IntegrationTestXbase.java");
		verifier.assertFilePresent(verifier.getBasedir() + "/target/xtext-temp/classes/IntegrationTestXbase.class");
	}
	
	@Test
	public void outputPerSource() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/output-per-source");
		verifier.assertFilePresent(verifier.getBasedir() + "/src-gen/IntegrationTestXbase.java");
		verifier.assertFilePresent(verifier.getBasedir() + "/target/xtext-temp/classes/IntegrationTestXbase.class");
		verifier.assertFilePresent(verifier.getBasedir() + "/other-gen/OtherIntegrationTestXbase.java");
		verifier.assertFilePresent(verifier.getBasedir() + "/target/xtext-temp/classes/OtherIntegrationTestXbase.class");
	}

	@Test
	public void javaLangBiRef() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/java-lang-bi-ref");
		verifier.assertFilePresent(verifier.getBasedir() + "/src-gen/XbaseReferToJava.java");
		verifier.assertFilePresent(verifier.getBasedir() + "/target/xtext-temp/classes/XbaseReferToJava.class");
		verifier.assertFilePresent(verifier.getBasedir() + "/target/xtext-temp/classes/JavaClazz.class");
	}
	
	@Test
	public void aggregation() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/aggregate");
		verifier.assertFilePresent(verifier.getBasedir() + "/purexbase/src-gen/IntegrationTestXbase.java");
		verifier.assertFilePresent(verifier.getBasedir() + "/purexbase/target/xtext-temp/classes/IntegrationTestXbase.class");
	}

	private Verifier verifyErrorFreeLog(String pathToTestProject) throws IOException, VerificationException {
		return verifyErrorFreeLog(pathToTestProject, "clean", "verify");
	}

	private Verifier verifyErrorFreeLog(String pathToTestProject, String... goals) throws IOException,
			VerificationException {
		Verifier verifier = newVerifier(pathToTestProject);
		for (String goal : goals) {
			verifier.executeGoal(goal);
		}
		verifier.verifyErrorFreeLog();
		if (debug) {
			List<String> lines = verifier.loadFile(verifier.getBasedir(), verifier.getLogFileName(), false);
			System.out.println(Joiner.on('\n').join(lines));
		}
		verifier.resetStreams();
		return verifier;
	}

	private Verifier newVerifier(String pathToTestProject) throws IOException, VerificationException {
		File testDir = ResourceExtractor.simpleExtractResources(getClass(), pathToTestProject);
		Verifier verifier = new Verifier(testDir.getAbsolutePath(), debug );
		verifier.setMavenDebug(debug);
		verifier.setForkJvm(!debug);
		return verifier;
	}

	@AfterClass
	static public void tearDownOnce() throws IOException, VerificationException {
		if (!debug)
			new XtextGeneratorIT().verifyErrorFreeLog(ROOT, "clean");
	}

}
