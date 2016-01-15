package org.eclipse.xpect.xtext.lib.setup;

import org.xpect.XpectFile;
import org.xpect.XpectJavaModel;
import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;
import org.xpect.util.IXtInjectorProvider;

import com.google.inject.Injector;

@XpectSetupFactory
public class InjectorSetup {
	private final XpectFile file;
	private final XpectJavaModel xjm;

	public InjectorSetup(XpectJavaModel xjm, XpectFile file) {
		super();
		this.xjm = xjm;
		this.file = file;
	}

	@Creates
	public Injector createInjector() {
		return IXtInjectorProvider.INSTANCE.getInjector(xjm, file.eResource().getURI());
	}

}
