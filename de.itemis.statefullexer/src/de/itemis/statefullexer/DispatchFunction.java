package de.itemis.statefullexer;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class DispatchFunction<F, T> implements Function<F, T> {

	protected T defaultValue;
	protected Map<Class<?>, Function<? super Object, T>> delegates;
	protected T nullValue;

	public DispatchFunction() {
		super();
	}

	public DispatchFunction(T nullValue) {
		super();
		this.nullValue = nullValue;
	}

	@SuppressWarnings("unchecked")
	public <X> DispatchFunction<F, T> add(Class<X> clazz, Function<? super X, T> delegate) {
		if (delegates == null)
			delegates = Maps.newLinkedHashMap();
		delegates.put(clazz, (Function<? super Object, T>) delegate);
		return this;
	}

	public void operator_add(Function<?, T> delegate) {
		add(delegate);
	}

	@SuppressWarnings("unchecked")
	public DispatchFunction<F, T> add(Function<?, T> delegate) {
		Method method = findApplyMethod(delegate);
		add(method.getParameterTypes()[0], (Function<Object, T>) delegate);
		return this;
	}

	@Override
	public T apply(F input) {
		if (delegates == null)
			return nullValue;
		if (input == null)
			return nullValue;
		Function<? super Object, T> delegate = delegates.get(input.getClass());
		if (delegate != null)
			return delegate.apply(input);
		Set<Class<?>> visited = Sets.<Class<?>> newHashSet(input.getClass());
		List<Class<?>> current = getDirectSuperTypes(Lists.<Class<?>> newArrayList(input.getClass()), visited);
		while (!current.isEmpty()) {
			for (Class<?> clazz : current) {
				Function<? super Object, T> func = delegates.get(clazz);
				if (func != null)
					return func.apply(input);
				else
					visited.add(clazz);
			}
			current = getDirectSuperTypes(current, visited);
		}
		return defaultValue;
	}

	protected Method findApplyMethod(Function<?, ?> func) {
		for (Method m : func.getClass().getMethods())
			if (m.getName().equals("apply") && m.getParameterTypes().length == 1)
				return m;
		return null;
	}

	public T getDefaultValue() {
		return defaultValue;
	}

	public Map<Class<?>, Function<? super Object, T>> getDelegates() {
		return delegates;
	}

	protected List<Class<?>> getDirectSuperTypes(List<Class<?>> base, Set<Class<?>> exclude) {
		List<Class<?>> result = Lists.<Class<?>> newArrayList();
		for (Class<?> clazz : base) {
			Class<?> superclass = clazz.getSuperclass();
			if (superclass != null && !exclude.contains(clazz.getSuperclass()))
				result.add(superclass);
			for (Class<?> superc : clazz.getInterfaces())
				if (!exclude.contains(superc))
					result.add(superc);
		}
		return result;
	}

	public T getNullValue() {
		return nullValue;
	}

	public DispatchFunction<F, T> setDefaultValue(T defaultValue) {
		this.defaultValue = defaultValue;
		return this;
	}

	public DispatchFunction<F, T> setNullValue(T nullValue) {
		this.nullValue = nullValue;
		return this;
	}
}
