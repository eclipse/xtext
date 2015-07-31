package org.eclipse.xtend.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.maven.it.VerificationException;
import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.junit.Assert;
import org.junit.Test;

public class XtendCompilerMojoTraceIT {

	private static String ROOT = "/it/compile";
	private boolean debug = false;

	private String loadTraceSourcePath(String file) {
		try {
			FileInputStream in = new FileInputStream(file);
			try {
				AbstractTraceRegion region = new TraceRegionSerializer().readTraceRegionFrom(in);
				return region.getAssociatedSrcRelativePath().toString();
			} finally {
				in.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void traceEnabled() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/trace_enabled");
		String xtendGenDir = verifier.getBasedir() + "/src/main/generated-sources/xtend/";
		verifier.assertFilePresent(xtendGenDir + "test/.XtendA.java._trace");
		verifier.assertFilePresent(xtendGenDir + "test/.XtendA2.java._trace");
		Assert.assertEquals("test/XtendA.xtend", loadTraceSourcePath(xtendGenDir + "test/.XtendA.java._trace"));
		Assert.assertEquals("test/XtendA.xtend", loadTraceSourcePath(xtendGenDir + "test/.XtendA2.java._trace"));
	}

	@Test
	public void traceDisabled() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/trace_disabled");
		String xtendGenDir = verifier.getBasedir() + "/src/main/generated-sources/xtend/";
		verifier.assertFileNotPresent(xtendGenDir + "test/.XtendA.java._trace");
		verifier.assertFileNotPresent(xtendGenDir + "test/.XtendA2.java._trace");
	}

	@Test
	public void traceWithTestSrc() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/trace_withtestsrc");
		String xtendGenDir = verifier.getBasedir() + "/src/";
		verifier.assertFileNotPresent(xtendGenDir + "main/generated-sources/xtend/test/.FooTest.java._trace");
		verifier.assertFileNotPresent(xtendGenDir + "test/generated-sources/xtend/test/.FooTest.java._trace");
	}

	private Verifier verifyErrorFreeLog(String pathToTestProject) throws IOException, VerificationException {
		return verifyErrorFreeLog(pathToTestProject, "verify");
	}

	private Verifier verifyErrorFreeLog(String pathToTestProject, String goal) throws IOException,
			VerificationException {
		Verifier verifier = newVerifier(pathToTestProject, debug);
		verifier.setMavenDebug(debug);
		verifier.executeGoal(goal);
		verifier.verifyErrorFreeLog();
		verifier.setDebug(true);
		verifier.resetStreams();
		return verifier;
	}

	private Verifier newVerifier(String pathToTestProject, boolean debugMode) throws IOException, VerificationException {
		File testDir = ResourceExtractor.simpleExtractResources(getClass(), pathToTestProject);
		return new Verifier(testDir.getAbsolutePath(), debugMode);
	}
}
