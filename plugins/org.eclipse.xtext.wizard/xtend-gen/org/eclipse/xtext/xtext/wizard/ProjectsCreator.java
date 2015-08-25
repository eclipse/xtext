package org.eclipse.xtext.xtext.wizard;

import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@SuppressWarnings("all")
public interface ProjectsCreator {
  public abstract void createProjects(final WizardConfiguration config);
}
