package org.eclipse.xtext.parsetree;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

public class ParserNodeAdapterFactory extends AdapterFactoryImpl {

	public static final ParserNodeAdapterFactory INSTANCE = new ParserNodeAdapterFactory();
	
	private ParserNodeAdapterFactory() {
	}
	
	@Override
	protected Adapter createAdapter(Notifier target) {
		return new ParserNodeAdapter();
	}
	
	@Override
	public boolean isFactoryForType(Object type) {
		return type == AbstractParserNode.class;
	}
}
