/*******************************************************************************
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.releng.simrel.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.cbi.p2repo.analyzers.BuildRepoTests;
import org.eclipse.cbi.p2repo.analyzers.RepoTestsConfiguration;
import org.eclipse.cbi.p2repo.analyzers.jars.BREETest;
import org.eclipse.cbi.p2repo.analyzers.jars.ESTest;
import org.eclipse.cbi.p2repo.analyzers.jars.SignerTest;
import org.eclipse.cbi.p2repo.analyzers.jars.TestLayoutTest;
import org.eclipse.cbi.p2repo.analyzers.jars.VersionTest;
import org.eclipse.cbi.p2repo.analyzers.repos.FeatureDisplayableDataChecker;
import org.eclipse.cbi.p2repo.analyzers.repos.FeatureNameLengths;
import org.eclipse.cbi.p2repo.analyzers.repos.IUNameChecker;
import org.eclipse.cbi.p2repo.analyzers.repos.IUVersionCheckToReference;
import org.eclipse.cbi.p2repo.analyzers.repos.ProviderNameChecker;
import org.eclipse.cbi.p2repo.analyzers.repos.TestRepo;
import org.eclipse.cbi.p2repo.analyzers.repos.VersionChecking;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit TestCase which runs all the available checks as Junit Plugin Tests
 * <p>
 * Copied from org.eclipse.cbi.p2repo.analyzers.RepositoryTest. Could not use
 * original class since it is not exported and causes NCDFE.
 * </p>
 * 
 * @author Dennis Huebner
 *
 */
public class RepositoryTest {
	private static final RepoTestsConfiguration CONF_FROM_SYSTEM_PROPERTIES = RepoTestsConfiguration
			.createFromSystemProperties();
	private static final String SKIP_CHECKER_PROP_NAME = "skipChecker";
	private static final Set<String> SKIPPED_CHECKER = new HashSet<String>();
	private static String dirToTest;
	private static String repoToTest;
	private static String refRepoDir;

	@BeforeClass
	public static final void beforeClass() {
		BuildRepoTests tests = new BuildRepoTests(CONF_FROM_SYSTEM_PROPERTIES);
		String directoryToCheck = tests.getDirectoryToCheck();
		if (directoryToCheck == null) {
			System.err.println("Repository directory was not specified. Use -"
					+ RepoTestsConfiguration.REPORT_REPO_DIR_PARAM + "=/dir/location to pass the repository location");
		}
		if (System.getProperty("DUMP_ENV_PROPS", null) != null) {
			for (Entry<Object, Object> entry : System.getProperties().entrySet())
				System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		dirToTest = directoryToCheck;
		repoToTest = "file://" + directoryToCheck;
		refRepoDir = tests.getDirectoryToCheckForReference();

		String skipCheckerProp = System.getProperty(SKIP_CHECKER_PROP_NAME);
		if (skipCheckerProp != null) {
			String[] split = skipCheckerProp.split(";");
			for (String checkerName : split) {
				SKIPPED_CHECKER.add(checkerName);
				System.out.println("Checker " + checkerName + " will be skipped.");
			}
		}
	}

	@AfterClass
	public static final void afterClass() {
		String output = new BuildRepoTests(CONF_FROM_SYSTEM_PROPERTIES).getReportOutputDirectory();
		System.out.println("See reports in:" + output);
	}

	@Test
	public void testVersionUniqness()
			throws ProvisionException, OperationCanceledException, URISyntaxException, IOException {
		VersionChecking checker = new VersionChecking(CONF_FROM_SYSTEM_PROPERTIES);
		if (configureChecker(checker)) {
			assertTrue("Unique Versions used in repository", !checker.testVersionUniqness());
		}
	}

	@Test
	public void testIUNames() throws ProvisionException, OperationCanceledException, URISyntaxException, IOException {
		IUNameChecker checker = new IUNameChecker(CONF_FROM_SYSTEM_PROPERTIES);
		if (configureChecker(checker)) {
			assertTrue("Correct feature names", !checker.testFeatureNames());
			assertTrue("Correct bundle names", !checker.testBundleNames());
		}
	}

	@Test
	public void testProviderName()
			throws ProvisionException, OperationCanceledException, URISyntaxException, IOException {
		ProviderNameChecker checker = new ProviderNameChecker(CONF_FROM_SYSTEM_PROPERTIES);
		if (configureChecker(checker)) {
			assertTrue("Correct provider names", !checker.testProviderNames());
		}
	}

	@Test
	public void testFeatureDisplayableData()
			throws ProvisionException, OperationCanceledException, URISyntaxException, IOException {
		FeatureDisplayableDataChecker checker = new FeatureDisplayableDataChecker(CONF_FROM_SYSTEM_PROPERTIES);
		if (configureChecker(checker)) {
			assertTrue("Correct displayable data (checkLicenseConsistency,checkCopyrights,checkDescriptions)",
					!checker.testDisplayableData());
		}
	}

	@Test
	public void testFeatureNameLengths()
			throws ProvisionException, OperationCanceledException, URISyntaxException, IOException {
		FeatureNameLengths checker = new FeatureNameLengths(CONF_FROM_SYSTEM_PROPERTIES);
		if (configureChecker(checker)) {
			assertFalse("FeatureDirectoryLengths is  <=" + FeatureNameLengths.MAX_CRITERIA,
					checker.testFeatureDirectoryLength() > FeatureNameLengths.MAX_CRITERIA);
		}
	}

	@Test
	public void testIUVersionCheckToReference()
			throws ProvisionException, OperationCanceledException, URISyntaxException, IOException {
		IUVersionCheckToReference checker = new IUVersionCheckToReference(CONF_FROM_SYSTEM_PROPERTIES);
		if (configureChecker(checker)) {
			if (refRepoDir != null) {
				assertTrue("Correct version changes", !checker.checkIUVersionsToReference());
				assertTrue("Correct version changes for features", !checker.checkIUVersionsToReferenceForFeatures());
			}
		}
	}

	@Test
	public void testEclipseSourceReferences() throws OperationCanceledException, IOException {
		ESTest checker = new ESTest(CONF_FROM_SYSTEM_PROPERTIES);
		if (configureChecker(checker)) {
			assertTrue("Correct eclipse source reference", !checker.testESSettingRule());
		}
	}

	@Test
	public void testBREE() throws OperationCanceledException, IOException {
		BREETest checker = new BREETest(CONF_FROM_SYSTEM_PROPERTIES);
		if (configureChecker(checker)) {
			assertTrue("Correct BREE", !checker.testBREESettingRule());
		}
	}

	@Test
	public void testSigning() throws OperationCanceledException, IOException {
		SignerTest checker = new SignerTest(CONF_FROM_SYSTEM_PROPERTIES);
		if (configureChecker(checker)) {
			assertTrue("Correct signature", !checker.verifySignatures());
		}
	}

	@Test
	public void testVersionTest() throws OperationCanceledException, IOException {
		VersionTest checker = new VersionTest(CONF_FROM_SYSTEM_PROPERTIES);
		if (configureChecker(checker)) {
			assertTrue("Correct version pattern", !checker.testVersionsPatterns());
		}
	}

	@Test
	public void testLayout() throws OperationCanceledException, IOException {
		TestLayoutTest checker = new TestLayoutTest(CONF_FROM_SYSTEM_PROPERTIES);
		if (configureChecker(checker)) {
			assertTrue("Correct files and layout in bundles and features.", !checker.testLayout());
		}
	}

	private boolean configureChecker(BuildRepoTests checker) {
		checker.setDirectoryToCheck(dirToTest);
		if (checker instanceof TestRepo) {
			((TestRepo) checker).setRepoURLToTest(repoToTest);
		}
		return !skipChecker(checker);
	}

	private boolean skipChecker(BuildRepoTests checker) {
		if (SKIPPED_CHECKER.size() > 0) {
			return SKIPPED_CHECKER.contains(checker.getClass().getSimpleName());
		}
		return false;
	}

}
