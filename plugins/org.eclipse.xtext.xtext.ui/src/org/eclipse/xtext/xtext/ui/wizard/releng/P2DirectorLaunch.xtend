package org.eclipse.xtext.xtext.ui.wizard.releng

import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy
import java.io.File

class P2DirectorLaunch {
	
	public static val String REPOSITORY = "http://download.eclipse.org/tools/buckminster/headless-4.2/"
	static val String PROFILE = "Buckminster"
	static val IUS = newArrayList(
		"org.eclipse.buckminster.cmdline.product",
		"org.eclipse.buckminster.pde.headless.feature.feature.group",
		"org.eclipse.buckminster.core.headless.feature.feature.group",
		"org.eclipse.buckminster.cvs.headless.feature.feature.group",
		"org.eclipse.buckminster.git.headless.feature.feature.group",
		"org.eclipse.buckminster.maven.headless.feature.feature.group",
		"org.eclipse.buckminster.emma.headless.feature.feature.group")
	
	public static val String DESTINATION_JAVA = System::getProperty("user.home")+File::separatorChar+"buckminster"
	public static val String LOCATION = "${workspace_loc}/../runtime-InstallHeadlessBuckminster"
	public static val String PRODUCT = "org.eclipse.equinox.p2.director.product"
	
	/*
	* Returns all the information as program args
	*/
	def static String args() {
		args(DESTINATION_JAVA)
	}
	
	def private static String args(String destination) {
		"-repository  "+REPOSITORY+" -destination \""+destination+"\" -profile "+ PROFILE + " -i " + IUS.join(" -i ")
	}
	
	def static setupLaunchConfiguration(ILaunchConfigurationWorkingCopy launchConfiguration, String destinationPath) {
		launchConfiguration.setAttribute("location", LOCATION)
		launchConfiguration.setAttribute("product", PRODUCT)
		launchConfiguration.setAttribute("useProduct", true)
		launchConfiguration.setAttribute("org.eclipse.debug.core.capture_output", false)
		launchConfiguration.setAttribute("org.eclipse.debug.ui.ATTR_CONSOLE_OUTPUT_ON", false)
		launchConfiguration.setAttribute("org.eclipse.jdt.launching.PROGRAM_ARGUMENTS", args(destinationPath))
	}
}