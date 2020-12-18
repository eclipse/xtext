package org.eclipse.xtext.junit5;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.UseTechnicalNames;
import org.junit.runner.RunWith;

/**
 * Test suite that will pick up all Junit5 tests from the listed package and run them
 * when the suite is executed with Junit4.
 */
@RunWith(JUnitPlatform.class)
@UseTechnicalNames
@SelectPackages("org.eclipse.xtext.validation.junit5")
public class RunSuiteJUnit5 {

}
