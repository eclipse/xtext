package org.eclipse.xtext.parsetree;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

public class ParserNodeAdapter implements Adapter {

	private Notifier target;
	
	private AbstractParserNode parserNode; 
	
	public Notifier getTarget() {
		return target;
	}

	public boolean isAdapterForType(Object type) {
		return type==AbstractParserNode.class;
	}

	public void notifyChanged(Notification notification) {
		// TODO Auto-generated method stub
	}

	public void setTarget(Notifier newTarget) {
		target = newTarget;
	}

	public AbstractParserNode getParserNode() {
		return parserNode;
	}

	public void setParserNode(AbstractParserNode parserNode) {
		this.parserNode = parserNode;
	}

	
}
