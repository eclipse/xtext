package org.eclipse.xtext.pom.modifier;

import java.util.List;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;

public abstract class AbstractDependenyModifier implements ModelModifier {

	public AbstractDependenyModifier() {
		super();
	}

	public final boolean modifiy(Model model) {
		List<Dependency> dependencies = model.getDependencies();
		boolean somethingModified = false;
		if (dependencies != null && !dependencies.isEmpty()) {
			for (Dependency dependency : dependencies) {
				somethingModified |= doModify(model, dependency);
			}
		}
		return somethingModified;
	}

	protected abstract boolean doModify(Model model, Dependency dependency);
}