package org.eclipse.xtend.maven;

import java.io.File;
import java.io.IOException;

import org.apache.maven.it.VerificationException;
import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;
import org.junit.Assert;
import org.junit.Test;

public class XtendInstallDebugInfoMojoIT {

	private static String ROOT = "/it/install_debug_info";

	@Test
	public void simpleSMAP() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/simple_smap");
		String xtendGenDir = verifier.getBasedir() + "/target/classes/test";
		String debugInfo = new ClassFileDebugInfoExtractor().getDebugInfo(xtendGenDir);

		// please note that here we have source information for both Java and Xtend
		String xpt = 
				"// test {\n" + 
				"  package test; // XtendA$1.class\n" + 
				"  class XtendA$1 {\n" + 
				"    void <init>() { // XtendA.java:16\n" + 
				"      // XtendA.java:16 -> XtendA.xtend:6\n" + 
				"      void this;\n" + 
				"    }\n" + 
				"    void apply() { // XtendA.java:18\n" + 
				"      // XtendA.java:18 -> XtendA.xtend:6\n" + 
				"      void this;\n" + 
				"      void it;\n" + 
				"    }\n" + 
				"  }\n" + 
				"  \n" + 
				"  package test; // XtendA.class\n" + 
				"  class XtendA {\n" + 
				"    void <init>() { // XtendA.java:13\n" + 
				"      // XtendA.java:14 -> XtendA.xtend:5\n" + 
				"      // XtendA.java:15:23 -> XtendA.xtend:6\n" + 
				"      void this;\n" + 
				"      void _newArrayList;\n" + 
				"      void _function;\n" + 
				"      void _map;\n" + 
				"      void _join;\n" + 
				"    }\n" + 
				"  }\n" + 
				"  \n" + 
				"  package test; // XtendA2.class\n" + 
				"  class XtendA2 {\n" + 
				"    void <init>() { // XtendA2.java:7\n" + 
				"      // XtendA2.java:8 -> XtendA.xtend:12\n" + 
				"      void this;\n" + 
				"    }\n" + 
				"  }\n" + 
				"}";
		Assert.assertEquals(debugInfo, xpt.toString(), debugInfo);
	}

	@Test
	public void simpleXtendAsPrimary() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/xtend_as_primary");
		String xtendGenDir = verifier.getBasedir() + "/target/classes/test";
		String debugInfo = new ClassFileDebugInfoExtractor().getDebugInfo(xtendGenDir);

		// please note that here we have source information only for Xtend
		String xpt = 
				"// test {\n" + 
				"  package test; // XtendA$1.class\n" + 
				"  class XtendA$1 {\n" + 
				"    void <init>() { // XtendA.xtend:6\n" + 
				"      void this;\n" + 
				"    }\n" + 
				"    void apply() { // XtendA.xtend:6\n" + 
				"      void this;\n" + 
				"      void it;\n" + 
				"    }\n" + 
				"  }\n" + 
				"  \n" + 
				"  package test; // XtendA.class\n" + 
				"  class XtendA {\n" + 
				"    void <init>() { // XtendA.xtend:5\n" + 
				"      void this;\n" + 
				"      void myvar;\n" + 
				"    }\n" + 
				"  }\n" + 
				"  \n" + 
				"  package test; // XtendA2.class\n" + 
				"  class XtendA2 {\n" + 
				"    void <init>() { // XtendA.xtend:13\n" + 
				"      void this;\n" + 
				"    }\n" + 
				"  }\n" + 
				"}";
		Assert.assertEquals(debugInfo, xpt.toString(), debugInfo);
	}

	@Test
	public void simpleXtendAsPrimaryWithSyntheticVars() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/xtend_as_primary_with_synthetic_vars");
		String xtendGenDir = verifier.getBasedir() + "/target/classes/test";
		String debugInfo = new ClassFileDebugInfoExtractor().getDebugInfo(xtendGenDir);

		// please note that here we have source information only for Xtend
		String xpt = 
				"// test {\n" + 
				"  package test; // XtendA$1.class\n" + 
				"  class XtendA$1 {\n" + 
				"    void <init>() { // XtendA.xtend:6\n" + 
				"      void this;\n" + 
				"    }\n" + 
				"    void apply() { // XtendA.xtend:6\n" + 
				"      void this;\n" + 
				"      void it;\n" + 
				"    }\n" + 
				"  }\n" + 
				"  \n" + 
				"  package test; // XtendA.class\n" + 
				"  class XtendA {\n" + 
				"    void <init>() { // XtendA.xtend:5\n" + 
				"      void this;\n" + 
				"      void _newArrayList;\n" + 
				"      void _function;\n" + 
				"      void _map;\n" + 
				"      void myvar;\n" + 
				"    }\n" + 
				"  }\n" + 
				"  \n" + 
				"  package test; // XtendA2.class\n" + 
				"  class XtendA2 {\n" + 
				"    void <init>() { // XtendA.xtend:13\n" + 
				"      void this;\n" + 
				"    }\n" + 
				"  }\n" + 
				"}";
		Assert.assertEquals(debugInfo, xpt.toString(), debugInfo);
	}

	@Test
	public void simpleSmapMultisource() throws Exception {
		Verifier verifier = verifyErrorFreeLog(ROOT + "/smap_multisource");
		String info1 = new ClassFileDebugInfoExtractor().getDebugInfo(verifier.getBasedir() + "/target/classes");

		String xpt1 = 
				"// classes {\n" + 
				"  // test {\n" + 
				"    package test; // JavaB.class\n" + 
				"    class JavaB {\n" + 
				"      void <init>() { // JavaB.java:13\n" + 
				"        void this;\n" + 
				"      }\n" + 
				"      void foo() { // JavaB.java:15\n" + 
				"        void this;\n" + 
				"        void test;\n" + 
				"      }\n" + 
				"    }\n" + 
				"    \n" + 
				"    package test; // XtendA.class\n" + 
				"    class XtendA {\n" + 
				"      void <init>() { // XtendA.java:7\n" + 
				"        void this;\n" + 
				"      }\n" + 
				"      void test2() { // XtendA.java:9\n" + 
				"        // XtendA.java:9:10 -> XtendA.xtend:6\n" + 
				"        void this;\n" + 
				"        void s;\n" + 
				"        void _foo;\n" + 
				"      }\n" + 
				"      void newJavaB() { // XtendA.java:14\n" + 
				"        // XtendA.java:14 -> XtendA.xtend:10\n" + 
				"        void this;\n" + 
				"      }\n" + 
				"    }\n" + 
				"    \n" + 
				"    package test; // XtendC.class\n" + 
				"    class XtendC {\n" + 
				"      void <init>() { // XtendC.java:7\n" + 
				"        void this;\n" + 
				"      }\n" + 
				"      void test() { // XtendC.java:9\n" + 
				"        // XtendC.java:9 -> XtendC.xtend:5\n" + 
				"        void this;\n" + 
				"        void s;\n" + 
				"      }\n" + 
				"    }\n" + 
				"  }\n" + 
				"}";
		Assert.assertEquals(xpt1.toString(), info1);

		String info2 = new ClassFileDebugInfoExtractor().getDebugInfo(verifier.getBasedir() + "/target/test-classes");

		String xpt2 = 
				"// test-classes {\n" + 
				"  // foo {\n" + 
				"    package foo; // FooClass.class\n" + 
				"    class FooClass {\n" + 
				"      void <init>() { // FooClass.java:6\n" + 
				"        void this;\n" + 
				"      }\n" + 
				"      void count() { // FooClass.java:8\n" + 
				"        // FooClass.java:8 -> FooClass.xtend:8\n" + 
				"        void this;\n" + 
				"      }\n" + 
				"      void newJavaB() { // FooClass.java:12\n" + 
				"        // FooClass.java:12 -> FooClass.xtend:12\n" + 
				"        void this;\n" + 
				"      }\n" + 
				"    }\n" + 
				"    \n" + 
				"    package foo; // FooTest.class\n" + 
				"    class FooTest {\n" + 
				"      void <init>() { // FooTest.java:8\n" + 
				"        void this;\n" + 
				"      }\n" + 
				"      void assertTrue() { // FooTest.java:11\n" + 
				"        // FooTest.java:11:13 -> FooTest.xtend:11\n" + 
				"        void this;\n" + 
				"        void _fooClass;\n" + 
				"        void _count;\n" + 
				"      }\n" + 
				"    }\n" + 
				"  }\n" + 
				"}";
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
