package org.eclipse.xtext.core.parsetree;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

public class NodeAdapterFactory extends AdapterFactoryImpl {

	public static final NodeAdapterFactory INSTANCE = new NodeAdapterFactory();
	
	private NodeAdapterFactory() {
	}
	
	@Override
	protected Adapter createAdapter(Notifier target) {
		return new NodeAdapter();
	}
	
	@Override
	public boolean isFactoryForType(Object type) {
		return type == AbstractNode.class;
	}
}
