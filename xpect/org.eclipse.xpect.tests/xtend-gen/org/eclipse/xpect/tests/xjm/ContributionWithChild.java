package org.eclipse.xpect.tests.xjm;

import org.eclipse.xpect.XpectImport;
import org.eclipse.xpect.setup.XpectSetupFactory;
import org.eclipse.xpect.tests.xjm.Contribution1;

@XpectSetupFactory
@XpectImport(Contribution1.class)
@SuppressWarnings("all")
public class ContributionWithChild {
}
