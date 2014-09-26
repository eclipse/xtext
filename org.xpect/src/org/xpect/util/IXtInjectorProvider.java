package org.xpect.util;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.xpect.XjmContribution;
import org.xpect.XpectJavaModel;
import org.xpect.registry.ILanguageInfo;
import org.xpect.setup.XpectGuiceModule;

import com.google.common.collect.Lists;
import com.google.inject.Injector;
import com.google.inject.Module;

public interface IXtInjectorProvider {
	public class Delegate implements IXtInjectorProvider {
		private IXtInjectorProvider delegate;

		public Injector getInjector(XpectJavaModel javaModel, URI uri) {
			return delegate.getInjector(javaModel, uri);
		}

		public void setDelegate(IXtInjectorProvider delegate) {
			this.delegate = delegate;
		}
	}

	public class RuntimeXtInjectorProvider implements IXtInjectorProvider {
		protected void collectBuiltinModules(List<Class<? extends Module>> moduleClasses) {
		}

		@SuppressWarnings("unchecked")
		protected void collectSetupModules(List<Class<? extends Module>> moduleClasses, XpectJavaModel javaModel) {
			if (javaModel != null) {
				Iterable<XjmContribution> contributions = javaModel.getContributions(XpectGuiceModule.class, EnvironmentUtil.ENVIRONMENT);
				for (XjmContribution contribution : contributions)
					if (contribution.isActive()) {
						Class<?> javaClass = contribution.getJavaClass();
						if (Module.class.isAssignableFrom(javaClass))
							moduleClasses.add((Class<? extends Module>) javaClass);
					}
			}
		}

		public Injector getInjector(XpectJavaModel javaModel, URI uri) {
			String ext = new URIDelegationHandler().getOriginalFileExtension(uri.lastSegment());
			ILanguageInfo info = ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(ext);
			if (info == null)
				return null;
			List<Class<? extends Module>> moduleClasses = Lists.newArrayList();
			collectBuiltinModules(moduleClasses);
			collectSetupModules(moduleClasses, javaModel);
			Injector injector = info.getInjector(moduleClasses);
			return injector;
		}
	}

	public static final IXtInjectorProvider INSTANCE = EcorePlugin.IS_ECLIPSE_RUNNING ? new Delegate() : new RuntimeXtInjectorProvider();

	Injector getInjector(XpectJavaModel javaModel, URI uri);
}
