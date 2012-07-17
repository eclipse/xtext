package org.eclipse.xpect.model;

import org.eclipse.xpect.Instance;

public class AssignmentImplCustom extends AssignmentImpl {
	@Override
	public Instance getInstance() {
		return (Instance) eContainer();
	}
}
