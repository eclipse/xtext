package org.eclipse.xpect.model;

import org.eclipse.xpect.Assignment;

public class ComponentImplCustom extends ComponentImpl {
	@Override
	public Assignment getAssignment() {
		return (Assignment) eContainer();
	}
}
