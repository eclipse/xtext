package org.eclipse.xtend.maven;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.apache.maven.it.VerificationException;
import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;
import org.junit.Test;

public class XtendInstallDebugInfoMojoIT {

	private static String ROOT = "/it/install_debug_info";

	@Test
	public void simpleSMAP() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/simple_smap");
		String xtendGenDir = verifier.getBasedir() + "/target/classes/test";
		String debugInfo = new ClassFileDebugInfoExtractor().getDebugInfo(xtendGenDir);

		// please note that here we have source information for both Java and Xtend
		StringBuilder xpt = new StringBuilder();
		xpt.append("// test {\n");
		xpt.append("  package test; // XtendA$1.class\n");
		xpt.append("  class XtendA$1 {\n");
		xpt.append("    void <init>() { // XtendA.java:16, XtendA.xtend:6\n");
		xpt.append("      void this;\n");
		xpt.append("    }\n");
		xpt.append("    \n");
		xpt.append("    void apply() { // XtendA.java:18, XtendA.xtend:6\n");
		xpt.append("      void this;\n");
		xpt.append("      void it;\n");
		xpt.append("      void _lessThan;\n");
		xpt.append("    }\n");
		xpt.append("    \n");
		xpt.append("  }\n");
		xpt.append("  \n");
		xpt.append("  package test; // XtendA.class\n");
		xpt.append("  class XtendA {\n");
		xpt.append("    void <init>() { // XtendA.java:13, XtendA.xtend:4\n");
		xpt.append("      void this;\n");
		xpt.append("      void _newArrayList;\n");
		xpt.append("      void _function;\n");
		xpt.append("      void _map;\n");
		xpt.append("      void _join;\n");
		xpt.append("    }\n");
		xpt.append("    \n");
		xpt.append("  }\n");
		xpt.append("  \n");
		xpt.append("  package test; // XtendA2.class\n");
		xpt.append("  class XtendA2 {\n");
		xpt.append("    void <init>() { // XtendA2.java:7, XtendA.xtend:11\n");
		xpt.append("      void this;\n");
		xpt.append("    }\n");
		xpt.append("    \n");
		xpt.append("  }\n");
		xpt.append("}");
		Assert.assertEquals(xpt.toString(), debugInfo);
	}

	@Test
	public void simpleXtendAsPrimary() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/xtend_as_primary");
		String xtendGenDir = verifier.getBasedir() + "/target/classes/test";
		String debugInfo = new ClassFileDebugInfoExtractor().getDebugInfo(xtendGenDir);

		// please note that here we have source information only for Xtend
		StringBuilder xpt = new StringBuilder();
		xpt.append("// test {\n");
		xpt.append("  package test; // XtendA$1.class\n");
		xpt.append("  class XtendA$1 {\n");
		xpt.append("    void <init>() { // XtendA.xtend:6\n");
		xpt.append("      void this;\n");
		xpt.append("    }\n");
		xpt.append("    \n");
		xpt.append("    void apply() { // XtendA.xtend:6\n");
		xpt.append("      void this;\n");
		xpt.append("      void it;\n");
		xpt.append("    }\n");
		xpt.append("    \n");
		xpt.append("  }\n");
		xpt.append("  \n");
		xpt.append("  package test; // XtendA.class\n");
		xpt.append("  class XtendA {\n");
		xpt.append("    void <init>() { // XtendA.xtend:4\n");
		xpt.append("      void this;\n");
		xpt.append("      void myvar;\n");
		xpt.append("    }\n");
		xpt.append("    \n");
		xpt.append("  }\n");
		xpt.append("  \n");
		xpt.append("  package test; // XtendA2.class\n");
		xpt.append("  class XtendA2 {\n");
		xpt.append("    void <init>() { // XtendA.xtend:12\n");
		xpt.append("      void this;\n");
		xpt.append("    }\n");
		xpt.append("    \n");
		xpt.append("  }\n");
		xpt.append("}");
		Assert.assertEquals(xpt.toString(), debugInfo);
	}

	@Test
	public void simpleXtendAsPrimaryWithSyntheticVars() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/xtend_as_primary_with_synthetic_vars");
		String xtendGenDir = verifier.getBasedir() + "/target/classes/test";
		String debugInfo = new ClassFileDebugInfoExtractor().getDebugInfo(xtendGenDir);

		// please note that here we have source information only for Xtend
		StringBuilder xpt = new StringBuilder();
		xpt.append("// test {\n");
		xpt.append("  package test; // XtendA$1.class\n");
		xpt.append("  class XtendA$1 {\n");
		xpt.append("    void <init>() { // XtendA.xtend:6\n");
		xpt.append("      void this;\n");
		xpt.append("    }\n");
		xpt.append("    \n");
		xpt.append("    void apply() { // XtendA.xtend:6\n");
		xpt.append("      void this;\n");
		xpt.append("      void it;\n");
		xpt.append("      void _lessThan;\n");
		xpt.append("    }\n");
		xpt.append("    \n");
		xpt.append("  }\n");
		xpt.append("  \n");
		xpt.append("  package test; // XtendA.class\n");
		xpt.append("  class XtendA {\n");
		xpt.append("    void <init>() { // XtendA.xtend:4\n");
		xpt.append("      void this;\n");
		xpt.append("      void _newArrayList;\n");
		xpt.append("      void _function;\n");
		xpt.append("      void _map;\n");
		xpt.append("      void myvar;\n");
		xpt.append("    }\n");
		xpt.append("    \n");
		xpt.append("  }\n");
		xpt.append("  \n");
		xpt.append("  package test; // XtendA2.class\n");
		xpt.append("  class XtendA2 {\n");
		xpt.append("    void <init>() { // XtendA.xtend:12\n");
		xpt.append("      void this;\n");
		xpt.append("    }\n");
		xpt.append("    \n");
		xpt.append("  }\n");
		xpt.append("}");
		Assert.assertEquals(xpt.toString(), debugInfo);
	}

	private Verifier verifyErrorFreeLog(String pathToTestProject) throws IOException, VerificationException {
		return verifyErrorFreeLog(pathToTestProject, "verify");
	}

	private Verifier verifyErrorFreeLog(String pathToTestProject, String goal) throws IOException,
			VerificationException {
		Verifier verifier = newVerifier(pathToTestProject);
		//		verifier.setForkJvm(false);
		verifier.setDebug(true);
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
