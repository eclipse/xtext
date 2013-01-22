package org.eclipse.xtend.lib.macro;

public interface Problem {
	
	enum Severity {
		ERROR, WARNING, INFO, IGNORE
	}
	
	String getId();
	String getMessage();
	Severity getSeverity();
}
