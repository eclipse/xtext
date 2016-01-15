package org.eclipse.xpect.tests.state;

import org.eclipse.xpect.state.Configuration;
import org.eclipse.xpect.state.ResolvedConfiguration;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class StateTestUtil {
  public static ResolvedConfiguration newAnalyzedConfiguration(final Procedure1<? super Configuration> init) {
    Configuration _configuration = new Configuration(null);
    Configuration _doubleArrow = ObjectExtensions.<Configuration>operator_doubleArrow(_configuration, init);
    return new ResolvedConfiguration(_doubleArrow);
  }
  
  public static ResolvedConfiguration newAnalyzedConfiguration(final ResolvedConfiguration parent, final Procedure1<? super Configuration> init) {
    Configuration _configuration = new Configuration(null);
    Configuration _doubleArrow = ObjectExtensions.<Configuration>operator_doubleArrow(_configuration, init);
    return new ResolvedConfiguration(parent, _doubleArrow);
  }
}
