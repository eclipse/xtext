package org.eclipse.xtext.builder.internal;

import org.apache.log4j.Logger;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.builder.builderState.impl.IStorageUtil;
import org.eclipse.xtext.builder.impl.javasupport.JdtBuilderModule;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Activator extends AbstractUIPlugin {
	
	private final static Logger log = Logger.getLogger(Activator.class);

	private static Activator INSTANCE;
	
	public static Activator getDefault() {
		return INSTANCE;
	}

	private Injector injector;
	
	public Injector getInjector() {
		return injector;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		//TODO check whether JDT is available, if not use BuilderModule instead
		try {
			injector = Guice.createInjector(new JdtBuilderModule());
			IStorageUtil.Access.setStorageUtil(injector.getInstance(IStorageUtil.class));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		INSTANCE = null;
	}
}
