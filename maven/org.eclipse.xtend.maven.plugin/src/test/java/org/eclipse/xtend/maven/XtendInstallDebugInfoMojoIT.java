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

	@Test
	public void simpleSmapMultisource() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/smap_multisource");
		String info1 = new ClassFileDebugInfoExtractor().getDebugInfo(verifier.getBasedir() + "/target/classes");

		StringBuilder xpt1 = new StringBuilder();
		xpt1.append("// classes {\n");
		xpt1.append("  // test {\n");
		xpt1.append("    package test; // JavaB.class\n");
		xpt1.append("    class JavaB {\n");
		xpt1.append("      void <init>() { // JavaB.java:13\n");
		xpt1.append("        void this;\n");
		xpt1.append("      }\n");
		xpt1.append("      \n");
		xpt1.append("      void foo() { // JavaB.java:15\n");
		xpt1.append("        void this;\n");
		xpt1.append("        void test;\n");
		xpt1.append("      }\n");
		xpt1.append("      \n");
		xpt1.append("    }\n");
		xpt1.append("    \n");
		xpt1.append("    package test; // XtendA.class\n");
		xpt1.append("    class XtendA {\n");
		xpt1.append("      void <init>() { // XtendA.java:7, XtendA.xtend:3\n");
		xpt1.append("        void this;\n");
		xpt1.append("      }\n");
		xpt1.append("      \n");
		xpt1.append("      void test2() { // XtendA.java:9, XtendA.xtend:6\n");
		xpt1.append("        void this;\n");
		xpt1.append("        void s;\n");
		xpt1.append("        void _foo;\n");
		xpt1.append("      }\n");
		xpt1.append("      \n");
		xpt1.append("      void newJavaB() { // XtendA.java:14, XtendA.xtend:10\n");
		xpt1.append("        void this;\n");
		xpt1.append("      }\n");
		xpt1.append("      \n");
		xpt1.append("    }\n");
		xpt1.append("    \n");
		xpt1.append("    package test; // XtendC.class\n");
		xpt1.append("    class XtendC {\n");
		xpt1.append("      void <init>() { // XtendC.java:7, XtendC.xtend:3\n");
		xpt1.append("        void this;\n");
		xpt1.append("      }\n");
		xpt1.append("      \n");
		xpt1.append("      void test() { // XtendC.java:9, XtendC.xtend:5\n");
		xpt1.append("        void this;\n");
		xpt1.append("        void s;\n");
		xpt1.append("      }\n");
		xpt1.append("      \n");
		xpt1.append("    }\n");
		xpt1.append("  }\n");
		xpt1.append("}");
		Assert.assertEquals(xpt1.toString(), info1);

		String info2 = new ClassFileDebugInfoExtractor().getDebugInfo(verifier.getBasedir() + "/target/test-classes");

		StringBuilder xpt2 = new StringBuilder();
		xpt2.append("// test-classes {\n");
		xpt2.append("  // foo {\n");
		xpt2.append("    package foo; // FooClass.class\n");
		xpt2.append("    class FooClass {\n");
		xpt2.append("      void <init>() { // FooClass.java:6, FooClass.xtend:5\n");
		xpt2.append("        void this;\n");
		xpt2.append("      }\n");
		xpt2.append("      \n");
		xpt2.append("      void count() { // FooClass.java:8, FooClass.xtend:8\n");
		xpt2.append("        void this;\n");
		xpt2.append("      }\n");
		xpt2.append("      \n");
		xpt2.append("      void newJavaB() { // FooClass.java:12, FooClass.xtend:12\n");
		xpt2.append("        void this;\n");
		xpt2.append("      }\n");
		xpt2.append("      \n");
		xpt2.append("    }\n");
		xpt2.append("    \n");
		xpt2.append("    package foo; // FooTest.class\n");
		xpt2.append("    class FooTest {\n");
		xpt2.append("      void <init>() { // FooTest.java:8, FooTest.xtend:7\n");
		xpt2.append("        void this;\n");
		xpt2.append("      }\n");
		xpt2.append("      \n");
		xpt2.append("      void assertTrue() { // FooTest.java:11, FooTest.xtend:11\n");
		xpt2.append("        void this;\n");
		xpt2.append("        void _fooClass;\n");
		xpt2.append("        void _count;\n");
		xpt2.append("      }\n");
		xpt2.append("      \n");
		xpt2.append("    }\n");
		xpt2.append("  }\n");
		xpt2.append("}");
		Assert.assertEquals(xpt2.toString(), info2);
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
