package org.eclipse.xtend.lib.macro.services;

import java.util.List;

import org.eclipse.xtend.lib.macro.declaration.Element;

public interface ProblemSupport {
	List<Problem> getProblems(Element element);
	void addError(Element element, String message);
	void addWarning(Element element, String message);
	void addInfo(Element element, String message);
}
