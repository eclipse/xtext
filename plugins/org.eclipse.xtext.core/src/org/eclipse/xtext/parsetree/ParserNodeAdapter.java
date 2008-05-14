package org.eclipse.xtext.parsetree;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

public class ParserNodeAdapter implements Adapter {

	private Notifier target;
	
	private ParserNode parserNode; 
	
	public Notifier getTarget() {
		return target;
	}

	public boolean isAdapterForType(Object type) {
		return type==ParserNode.class;
	}

	public void notifyChanged(Notification notification) {
		// TODO Auto-generated method stub
	}

	public void setTarget(Notifier newTarget) {
		target = newTarget;
	}

	public ParserNode getParserNode() {
		return parserNode;
	}

	public void setParserNode(ParserNode parserNode) {
		this.parserNode = parserNode;
	}

	
}
