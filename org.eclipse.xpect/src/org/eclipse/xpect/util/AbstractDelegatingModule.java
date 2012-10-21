package org.eclipse.xpect.util;

import com.google.inject.Binding;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.spi.LinkedKeyBinding;

public abstract class AbstractDelegatingModule implements Module {

	@Inject
	private Injector original;

	public Injector getOriginal() {
		return original;
	}

	@SuppressWarnings("unchecked")
	public <T> Class<? extends T> getOriginalType(Class<T> type) {
		Binding<T> binding = original.getBinding(type);
		if (binding instanceof LinkedKeyBinding<?>)
			return (Class<? extends T>) ((LinkedKeyBinding<T>) binding).getLinkedKey().getTypeLiteral().getRawType();
		throw new RuntimeException("no binding found for " + type);
	}
}
