package org.eclipse.xtext.core.parsetree;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

public class NodeAdapter implements Adapter {

	private Notifier target;
	
	private AbstractNode parserNode; 
	
	public Notifier getTarget() {
		return target;
	}

	public boolean isAdapterForType(Object type) {
		return type==AbstractNode.class;
	}

	public void notifyChanged(Notification notification) {
		// TODO Auto-generated method stub
	}

	public void setTarget(Notifier newTarget) {
		target = newTarget;
	}

	public AbstractNode getParserNode() {
		return parserNode;
	}

	public void setParserNode(AbstractNode parserNode) {
		this.parserNode = parserNode;
	}

	
}
