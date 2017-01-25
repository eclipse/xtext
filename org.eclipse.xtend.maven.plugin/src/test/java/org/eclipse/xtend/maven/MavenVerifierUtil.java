/**
 * 
 */
package org.eclipse.xtend.maven;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.maven.it.VerificationException;
import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;
import org.apache.maven.shared.utils.cli.CommandLineUtils;
import org.junit.Assert;

/**
 * @author dhuebner
 *
 */
public class MavenVerifierUtil {

	public static Verifier newVerifier(String pathToTestProject) throws IOException, VerificationException {
		File testDir = ResourceExtractor.simpleExtractResources(MavenVerifierUtil.class, pathToTestProject);
		Verifier verifier = new Verifier(testDir.getAbsolutePath());
		String localRepo = Paths.get("../.m2/repository/").toAbsolutePath().normalize().toString();
		
		verifier.setSystemProperty("gradleMavenRepo", System.getProperty("gradleMavenRepo"));
		verifier.setLocalRepo(localRepo);
		verifier.setDebug(true);
		// verifier.setMavenDebug(true);
		// verifier.setDebugJvm(true);
		// verifier.setForkJvm(false);
		return verifier;
	}

	static public void checkMavenExecutable(String verifierRoot) throws IOException, VerificationException {
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
	}

	private static String findMaven() {
		// TODO add more mavens here
		String[] mavens = new String[] { System.getProperty("maven.home"), "/opt/local/share/java/maven3/" };
		for (String maven : mavens) {
			if (new File(maven + "/bin/mvn").exists()) {
				return maven;
			}
		}
		return null;
	}
}
