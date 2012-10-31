package org.xpect.model;

import org.xpect.Assignment;


public class ComponentImplCustom extends ComponentImpl {
	@Override
	public Assignment getAssignment() {
		return (Assignment) eContainer();
	}
}
