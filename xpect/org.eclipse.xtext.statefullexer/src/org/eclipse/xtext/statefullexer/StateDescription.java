package org.eclipse.xtext.statefullexer;

public abstract class StateDescription {

	public int getPdaState() {
		return 0;
	}

	public int getFsmState() {
		return 0;
	}

	public Object getGroup() {
		return null;
	}

	public void getCloneSource() {
	}

	public Object getToken() {
		return null;
	}
}
