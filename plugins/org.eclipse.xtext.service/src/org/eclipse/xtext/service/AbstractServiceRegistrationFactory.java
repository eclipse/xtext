package org.eclipse.xtext.service;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.WrappedException;

public abstract class AbstractServiceRegistrationFactory implements IServiceRegistrationFactory {
	
	public ScopedServiceRegistration scope(IServiceScope id) {
		ScopedServiceRegistration ssreg = new ScopedServiceRegistration(id);
		return ssreg;
	}

	public class ScopedServiceRegistration implements IServiceRegistrationFactory {

		private final IServiceScope scope;
		private Set<IServiceRegistration> regs = new HashSet<IServiceRegistration>();

		public ScopedServiceRegistration(IServiceScope scope) {
			this.scope = scope;
		}

		public Set<IServiceRegistration> registrations() {
			return regs;
		}
		public ScopedServiceRegistration with(Class<?> clazz) {
			return with(clazz,clazz);
		}
		public ScopedServiceRegistration with(Class<?> clazz, int prio) {
			return with(clazz,clazz, prio);
		}
		public ScopedServiceRegistration with(Class<?> interf, Class<?> clazz) {
			return with(interf,clazz,ServiceRegistry.PRIORITY_NORMAL);
		}
			public ScopedServiceRegistration with(Class<?> interf, Class<?> clazz, int prio) {
			regs.add(new ServiceReg(scope,new GenericServiceFactory(interf,clazz), prio));
			return this;
		}

	}
	
	class DefaultConstructorFactory implements IServiceFactory {
		private final Class<?> clazz;
		public DefaultConstructorFactory(Class<?> clazz) {
			this.clazz = clazz;
		}

		public Object createService() {
			try {
				return clazz.newInstance();
			} catch (Exception e) {
				throw new WrappedException(e);
			}
		}

		public Class<?> getServiceInterface() {
			return clazz;
		}
		
	}

	class ServiceReg implements IServiceRegistration {

		public ServiceReg(IServiceScope scope, IServiceFactory factory, int prio) {
			this.prio = prio;
			this.scope = scope;
			this.factory = factory;
		}

		private final int prio;
		private final IServiceScope scope;
		private final IServiceFactory factory;

		public int priority() {
			return prio;
		}

		public IServiceScope scope() {
			return scope;
		}

		public IServiceFactory serviceFactory() {
			return factory;
		}

	}

}
