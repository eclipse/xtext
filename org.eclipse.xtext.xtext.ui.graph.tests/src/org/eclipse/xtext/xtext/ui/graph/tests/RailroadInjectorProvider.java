package org.eclipse.xtext.xtext.ui.graph.tests;

import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.xtext.ui.graph.bundle.Activator;

import com.google.inject.Injector;

public class RailroadInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return Activator.getDefault().getInjector();
	}

}
