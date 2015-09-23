package org.eclipse.xtext.xtext.idea.tests.wizard;

import static org.junit.Assert.*;

import org.eclipse.xtext.idea.wizard.XtextModuleBuilder;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;
import org.junit.Before;
import org.junit.Test;

public class WizardConfigurationTest {
	private WizardConfiguration wizardConfiguration;

	@Before
	public void setUp() throws Exception {
		wizardConfiguration = new WizardConfiguration();
	}

	@Test
	public void testParentProject() {
		new XtextModuleBuilder().setupWizardConfiguration(wizardConfiguration);
		wizardConfiguration.setBaseName("mydsl");
		wizardConfiguration.setRootLocation("/some/absolute/path");

		assertEquals("/some/absolute/path/mydsl", wizardConfiguration.getParentProject().getLocation());
		assertEquals("/some/absolute/path/mydsl.core", wizardConfiguration.getRuntimeProject().getLocation());
	}

}
