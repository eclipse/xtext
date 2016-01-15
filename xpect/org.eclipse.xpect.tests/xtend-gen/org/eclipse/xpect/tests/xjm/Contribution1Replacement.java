package org.eclipse.xpect.tests.xjm;

import org.eclipse.xpect.XpectReplace;
import org.eclipse.xpect.setup.XpectSetupFactory;
import org.eclipse.xpect.tests.xjm.Contribution1;

@XpectSetupFactory
@XpectReplace(Contribution1.class)
@SuppressWarnings("all")
public class Contribution1Replacement extends Contribution1 {
}
