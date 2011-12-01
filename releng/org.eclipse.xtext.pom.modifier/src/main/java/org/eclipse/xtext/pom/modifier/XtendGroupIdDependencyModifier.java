/**
 * 
 */
package org.eclipse.xtext.pom.modifier;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;

/**
 * @author huebner
 * 
 */
public class XtendGroupIdDependencyModifier extends AbstractDependenyModifier {

	protected boolean doModify(Model model, Dependency dependency) {
		if ("org.eclipse.xtend".equals(dependency.getGroupId())) {
			dependency.setGroupId("org.eclipse.xpand");
			return true;
		}
		return false;
	}

}
