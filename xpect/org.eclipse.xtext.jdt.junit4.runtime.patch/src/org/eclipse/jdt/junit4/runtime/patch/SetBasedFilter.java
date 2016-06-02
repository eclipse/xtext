package org.eclipse.jdt.junit4.runtime.patch;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

public class SetBasedFilter extends Filter {
	private Set<Description> shouldRun;

	public SetBasedFilter(Description rootDescription) {
		this.shouldRun = new LinkedHashSet<Description>();
		collectDescriptions(rootDescription);
	}

	private void collectDescriptions(Description desc) {
		this.shouldRun.add(desc);
		for (Description child : desc.getChildren())
			collectDescriptions(child);
	}

	public SetBasedFilter(Set<Description> shouldRun) {
		this.shouldRun = shouldRun;
	}

	@Override
	public String describe() {
		return shouldRun.toString();
	}

	@Override
	public boolean shouldRun(Description description) {
		if (shouldRun.contains(description))
			return true;
		for (Description each : description.getChildren())
			if (shouldRun(each))
				return true;
		return false;
	}
}
