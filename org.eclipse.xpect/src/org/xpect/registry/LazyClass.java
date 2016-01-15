package org.xpect.registry;

import org.xpect.util.ExtensionFactoryUtil;
import org.xpect.util.ExtensionFactoryUtil.NameAndClass;

import com.google.common.base.Function;
import com.google.common.base.Objects;

public class LazyClass<T> {
	public static <T> LazyClass<T> create(Class<T> expectedType, IExtensionInfo trace, String attributeName) {
		String className = trace.getAttributeValue(attributeName);
		if (className != null)
			return new LazyClass<T>(expectedType, className, trace.getClassLoader(), trace);
		return null;
	}

	public static <T> LazyClass<T> create(Class<T> expectedType, String name, Function<String, Class<?>> loader) {
		if (name != null)
			return new LazyClass<T>(expectedType, name, loader, null);
		return null;
	}

	public static <T> LazyClass<T> create(Class<T> expectedType, String name, IExtensionInfo trace) {
		if (name != null)
			return new LazyClass<T>(expectedType, name, trace.getClassLoader(), trace);
		return null;
	}

	private final Class<T> expectedType;
	private final String factory;
	private final Function<String, Class<?>> loader;
	private final String name;
	private final IExtensionInfo trace;

	protected LazyClass(Class<T> expectedType, String name, Function<String, Class<?>> loader, IExtensionInfo trace) {
		super();
		NameAndClass nameAndClass = ExtensionFactoryUtil.parseExtensionFactory(name);
		this.expectedType = expectedType;
		this.name = nameAndClass.getClazz();
		this.factory = nameAndClass.getUiLangName();
		this.loader = loader;
		this.trace = trace;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass())
			return false;
		LazyClass<?> other = (LazyClass<?>) obj;
		return Objects.equal(name, other.name);
	}

	public Class<T> getExpectedType() {
		return expectedType;
	}

	public String getFactory() {
		return factory;
	}

	public Function<String, Class<?>> getLoader() {
		return loader;
	}

	public String getName() {
		return name;
	}

	public IExtensionInfo getTrace() {
		return trace;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@SuppressWarnings("unchecked")
	public Class<T> load() {
		Class<?> clazz = loader.apply(name);
		if (expectedType.isAssignableFrom(clazz))
			return (Class<T>) clazz;
		throw new ClassCastException("Class " + clazz.getName() + " is not a subtype of " + expectedType.getName());
	}

	public boolean needsInjection() {
		return this.factory != null;
	}

	@Override
	public String toString() {
		return name;
	}

}
