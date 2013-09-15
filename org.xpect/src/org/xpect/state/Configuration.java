package org.xpect.state;

import java.lang.annotation.Annotation;
import java.util.List;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

public class Configuration {
	private final List<Class<?>> factories = Lists.newArrayList();
	private final Multimap<Class<? extends Annotation>, Pair<Class<?>, Managed<?>>> values = LinkedHashMultimap.create();

	public void addFactory(Class<?> factory) {
		factories.add(factory);
	}

	public <T> void addValue(Class<? extends Annotation> annotation, Class<? super T> type, Managed<T> value) {
		values.put(annotation, Tuples.<Class<?>, Managed<?>> create(type, value));
	}

	@SuppressWarnings("unchecked")
	public <T> void addValue(Class<? extends Annotation> annotation, T value) {
		if (value instanceof Managed<?>)
			throw new IllegalStateException(
					"please use addValue(Class<? extends Annotation> annotation, Class<? super T> type, Managed<T> value)");
		addValue(annotation, (Class<T>) value.getClass(), value);
	}

	public <T> void addValue(Class<? extends Annotation> annotation, Class<? super T> type, T value) {
		addValue(annotation, type, new ManagedImpl<T>(value));
	}

	public <T> void addDefaultValue(Class<? super T> type, Managed<T> value) {
		addValue(Default.class, type, value);
	}

	public <T> void addDefaultValue(Class<? super T> type, T value) {
		addValue(Default.class, type, value);
	}

	@SuppressWarnings("unchecked")
	public <T> void addDefaultValue(T value) {
		if (value instanceof Managed<?>)
			throw new IllegalStateException("please use addDefaultValue(Class<? super T> type, Managed<T> value)");
		addValue(Default.class, (Class<T>) value.getClass(), value);
	}

	public List<Class<?>> getFactories() {
		return factories;
	}

	public Multimap<Class<? extends Annotation>, Pair<Class<?>, Managed<?>>> getValues() {
		return values;
	}

}
