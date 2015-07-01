package org.eclipse.xtext.idea.sdomain.idea.tests.containers;

import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType;
import org.eclipse.xtext.idea.tests.LightToolingTest;

@SuppressWarnings("all")
public abstract class LightSdomainTestCase extends LightToolingTest {
  public LightSdomainTestCase() {
    super(SDomainFileType.INSTANCE);
  }
}
