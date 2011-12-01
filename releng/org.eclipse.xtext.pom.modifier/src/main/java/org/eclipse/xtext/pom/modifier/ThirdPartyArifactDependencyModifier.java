/**
 * 
 */
package org.eclipse.xtext.pom.modifier;

import java.util.HashMap;
import java.util.Map;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;

/**
 * @author huebner
 * 
 */
public class ThirdPartyArifactDependencyModifier extends
		AbstractDependenyModifier {

	static final private Map<String, String[]> R_MAP = new HashMap<String, String[]>();

	static {
		R_MAP.put("com.google.guava", new String[] { "guava" });
		R_MAP.put("com.google.inject", new String[] { "guice" });
		R_MAP.put("org.antlr.runtime", new String[] { "antlr-runtime", "org.antlr" });
		R_MAP.put("org.apache.log4j", new String[] { "log4j", "log4j", "1.2.15" });
		R_MAP.put("org.apache.commons.cli", new String[] { "commons-cli", "commons-cli", "1.2" });
		R_MAP.put("org.apache.commons.lang", new String[] { "commons-lang", "commons-lang", "2.4" });
	}

	@Override
	protected boolean doModify(Model model, Dependency dependency) {
		String depArtifId = dependency.getArtifactId();
		if (R_MAP.containsKey(depArtifId)) {
			String[] replacement = R_MAP.get(depArtifId);
			dependency.setArtifactId(replacement[0]);
			if (replacement.length > 1)
				dependency.setGroupId(replacement[1]);
			if (replacement.length > 2)
				dependency.setVersion(replacement[2]);
			return true;
		}
		return false;
	}

}
