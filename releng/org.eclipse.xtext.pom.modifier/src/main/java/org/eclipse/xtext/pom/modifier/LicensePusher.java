/**
 * 
 */
package org.eclipse.xtext.pom.modifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.maven.model.License;
import org.apache.maven.model.Model;

/**
 * @author huebner
 * 
 */
public class LicensePusher implements ModelModifier {
	private final static String[] GROP_IDs = new String[] { "org.eclipse.emf",
			"org.eclipse.xpand", "org.eclipse.xtend2", "org.eclipse.xtext" };

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.pom.modifier.ModelModifier#modifiy(org.apache.maven
	 * .model.Model)
	 */
	public boolean modifiy(Model pomModel) {
		if (isEclipseGroup(pomModel.getGroupId())) {
			List<License> licenses = pomModel.getLicenses();
			if (licenses == null || licenses.isEmpty()) {
				List<License> eplLicense = new ArrayList<License>();
				eplLicense.add(createEplLicense());
				pomModel.setLicenses(eplLicense);
				return true;
			}
		}
		return false;
	}

	/*
	 * <licenses> <license> <name>Eclipse Public License - v 1.0</name>
	 * <url>http://www.eclipse.org/org/documents/epl-v10.html</url> </license>
	 * </licenses>
	 */
	private License createEplLicense() {
		License eplLicense = new License();
		eplLicense.setName("Eclipse Public License - v 1.0");
		eplLicense.setUrl("http://www.eclipse.org/org/documents/epl-v10.html");
		return eplLicense;
	}

	private boolean isEclipseGroup(String groupId) {
		return Arrays.binarySearch(GROP_IDs, groupId) >= 0;
	}

}
