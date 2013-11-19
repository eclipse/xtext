package org.eclipse.xtext.xtext.ui.wizard.releng;

import java.io.File;
import java.util.ArrayList;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class P2DirectorLaunch {
  public final static String REPOSITORY = "http://download.eclipse.org/tools/buckminster/headless-4.3/";
  
  private final static String PROFILE = "Buckminster";
  
  private final static ArrayList<String> IUS = new Function0<ArrayList<String>>() {
    public ArrayList<String> apply() {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(
        "org.eclipse.buckminster.cmdline.product", 
        "org.eclipse.buckminster.pde.headless.feature.feature.group", 
        "org.eclipse.buckminster.core.headless.feature.feature.group", 
        "org.eclipse.buckminster.cvs.headless.feature.feature.group", 
        "org.eclipse.buckminster.git.headless.feature.feature.group", 
        "org.eclipse.buckminster.maven.headless.feature.feature.group");
      return _newArrayList;
    }
  }.apply();
  
  public final static String DESTINATION_JAVA = new Function0<String>() {
    public String apply() {
      String _property = System.getProperty("user.home");
      String _plus = (_property + Character.valueOf(File.separatorChar));
      String _plus_1 = (_plus + "buckminster");
      return _plus_1;
    }
  }.apply();
  
  public final static String LOCATION = "${workspace_loc}/../runtime-InstallHeadlessBuckminster";
  
  public final static String PRODUCT = "org.eclipse.equinox.p2.director.product";
  
  /**
   * Returns all the information as program args
   */
  public static String args() {
    String _args = P2DirectorLaunch.args(P2DirectorLaunch.DESTINATION_JAVA);
    return _args;
  }
  
  private static String args(final String destination) {
    String _join = IterableExtensions.join(P2DirectorLaunch.IUS, " -i ");
    String _plus = ((((((("-repository  " + P2DirectorLaunch.REPOSITORY) + " -destination \"") + destination) + "\" -profile ") + P2DirectorLaunch.PROFILE) + " -i ") + _join);
    return _plus;
  }
  
  public static void setupLaunchConfiguration(final ILaunchConfigurationWorkingCopy launchConfiguration, final String destinationPath) {
    launchConfiguration.setAttribute("location", P2DirectorLaunch.LOCATION);
    launchConfiguration.setAttribute("product", P2DirectorLaunch.PRODUCT);
    launchConfiguration.setAttribute("useProduct", true);
    launchConfiguration.setAttribute("org.eclipse.debug.core.capture_output", false);
    launchConfiguration.setAttribute("org.eclipse.debug.ui.ATTR_CONSOLE_OUTPUT_ON", false);
    String _args = P2DirectorLaunch.args(destinationPath);
    launchConfiguration.setAttribute("org.eclipse.jdt.launching.PROGRAM_ARGUMENTS", _args);
  }
}
