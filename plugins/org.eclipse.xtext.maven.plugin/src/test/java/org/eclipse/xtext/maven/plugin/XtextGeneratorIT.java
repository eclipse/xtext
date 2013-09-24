package org.eclipse.xtext.maven.plugin;

import java.io.File;
import java.io.IOException;

import org.apache.maven.it.VerificationException;
import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;
import org.junit.Test;

public class XtextGeneratorIT {

	private static String ROOT = "/it/generate";

	@Test
	public void simpleLang() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/simple-lang");
		verifier.assertFileMatches(verifier.getBasedir() + "/src-gen/greetings.txt", "People to greet\\: Test");
	}

	private Verifier verifyErrorFreeLog(String pathToTestProject) throws IOException, VerificationException {
		return verifyErrorFreeLog(pathToTestProject, "verify");
	}

	private Verifier verifyErrorFreeLog(String pathToTestProject, String goal) throws IOException,
			VerificationException {
		Verifier verifier = newVerifier(pathToTestProject);
		verifier.executeGoal(goal);
		verifier.verifyErrorFreeLog();
		verifier.resetStreams();
		return verifier;
	}

	private Verifier newVerifier(String pathToTestProject) throws IOException, VerificationException {
		File testDir = ResourceExtractor.simpleExtractResources(getClass(), pathToTestProject);
		return new Verifier(testDir.getAbsolutePath());
	}
}
