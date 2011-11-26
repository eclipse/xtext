package org.eclipse.xtext.xtend2.maven;

import java.io.File;
import java.io.IOException;

import org.apache.maven.it.VerificationException;
import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;
import org.junit.Test;

import com.google.common.collect.Lists;

public class Xtend2BatchCompilerPluginIT {
	@Test
	public void simpleProject() throws Exception {
		verifyErrorFreeLog("/it/simple");
	}

	@Test
	public void pluginPrefix() throws Exception {
		verifyErrorFreeLog("/it/simple", "xtend2:compile");
	}

	@Test
	public void simpleProjectXtend2Tests() throws Exception {
		verifyErrorFreeLog("/it/withtestsrc");
	}

	@Test
	public void aggregation() throws Exception {
		verifyErrorFreeLog("/it/aggregation");
	}

	private void verifyErrorFreeLog(String pathToTestProject) throws IOException, VerificationException {
		verifyErrorFreeLog(pathToTestProject, "verify");
	}

	private void verifyErrorFreeLog(String pathToTestProject, String goal) throws IOException, VerificationException {
		File testDir = ResourceExtractor.simpleExtractResources(getClass(), pathToTestProject);
		Verifier verifier = new Verifier(testDir.getAbsolutePath());
		verifier.executeGoal(goal);
		verifier.verifyErrorFreeLog();
		verifier.resetStreams();
	}
}
