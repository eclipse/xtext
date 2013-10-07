package org.xpect.state;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.xpect.setup.IXpectSetup;
import org.xpect.setup.XpectSetup;

import com.google.common.base.Joiner;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

public class ResolvedConfiguration {

	public static class DerivedValue extends Value {
		private Factory factory;
		private Method invalidator;
		private final Method method;
		private final Class<?> owner;

		public DerivedValue(Class<?> owner, Method method) {
			super();
			this.owner = owner;
			this.method = method;
		}

		public Class<? extends Annotation> getAnnotatedWith() {
			return method.getAnnotation(Creates.class).value();
		}

		public Factory getFactory() {
			return factory;
		}

		public Method getInvalidator() {
			return invalidator;
		}

		public Method getMethod() {
			return method;
		}

		public Class<?> getOwner() {
			return owner;
		}

		public Class<?> getType() {
			Class<?> returnType = method.getReturnType();
			if (returnType == Managed.class) {
				ParameterizedType type = (ParameterizedType) method.getGenericReturnType();
				return (Class<?>) type.getActualTypeArguments()[0];
			}
			return returnType;
		}

		@Override
		public String toString() {
			Class<? extends Annotation> annotatedWith = getAnnotatedWith();
			String an = annotatedWith != Default.class ? "@" + annotatedWith.getSimpleName() + " " : "";
			String m = owner.getSimpleName() + "." + method.getName() + "()";
			return getClass().getSimpleName() + "[" + an + getType().getSimpleName() + " " + m + "]";
		}
	}

	public static class Factory {
		private final Constructor<?> constructor;
		private final List<Value> in;
		private final Collection<DerivedValue> out;

		public Factory(Constructor<?> constructor, List<Value> in, Collection<DerivedValue> out) {
			super();
			this.constructor = constructor;
			this.in = in == null ? null : Collections.unmodifiableList(in);
			this.out = Collections.unmodifiableCollection(out);
		}

		public Constructor<?> getConstructor() {
			return constructor;
		}

		public List<Value> getIn() {
			return in;
		}

		public Collection<DerivedValue> getOut() {
			return out;
		}

		public Class<?> getOwner() {
			return constructor.getDeclaringClass();
		}

		public boolean isResolved() {
			return in != null;
		}

		@Override
		public String toString() {
			List<String> f = Lists.newArrayList();
			if (isResolved())
				for (Value in : getIn())
					f.add("  in " + in);
			else
				f.add("unresolved!");
			for (Value out : getOut())
				f.add("  out " + out);
			Collections.sort(f);
			return getConstructor() + "{\n  " + Joiner.on('\n').join(f) + "\n}";
		}
	}

	public static class PrimaryValue extends Value {
		private final Class<? extends Annotation> annotatedWith;
		private final Class<?> type;
		private final Managed<?> value;

		public PrimaryValue(Class<? extends Annotation> annotatedWith, Class<?> type, Managed<?> value) {
			super();
			this.annotatedWith = annotatedWith;
			this.type = type;
			this.value = value;
		}

		@Override
		public Class<? extends Annotation> getAnnotatedWith() {
			return annotatedWith;
		}

		@Override
		public Class<?> getType() {
			return type;
		}

		public Managed<?> getValue() {
			return value;
		}

		@Override
		public String toString() {
			String an = annotatedWith != Default.class ? "@" + annotatedWith.getSimpleName() + " " : "";
			return getClass().getSimpleName() + "[" + an + type.getSimpleName() + " " + value + "]";
		}
	}

	public static abstract class Value {

		public abstract Class<? extends Annotation> getAnnotatedWith();

		public abstract Class<?> getType();
	}

	private final Map<Class<?>, List<Throwable>> deactivatedFactories;
	private final List<Throwable> errors;
	private final List<Class<?>> overwrittenFactories;
	private final ResolvedConfiguration parent;
	private final List<Factory> resolvedFactories;
	private final List<Factory> unresolvedFactories;
	private final Multimap<Class<? extends Annotation>, Value> values;

	public ResolvedConfiguration(ResolvedConfiguration parent, Configuration configuration) {
		this.parent = parent;
		this.errors = Lists.newArrayList();
		Set<Class<?>> allFactoryClasses = collectAllFactoryClasses(parent, configuration);
		Set<Class<?>> overwrittenFactoryClasses = collectOverwrittenClasses(allFactoryClasses);
		Set<Class<?>> unoverwrittenFactoryClasses = Sets.difference(allFactoryClasses, overwrittenFactoryClasses);
		Map<Class<?>, List<Throwable>> deactivatedFactoryClasses = collectDeactivatedClasses(unoverwrittenFactoryClasses);
		Set<Class<?>> activeFactoryClasses = Sets.difference(unoverwrittenFactoryClasses, deactivatedFactoryClasses.keySet());
		Multimap<Class<? extends Annotation>, Value> allValues = collectAllValues(activeFactoryClasses, configuration);
		Multimap<Class<?>, DerivedValue> annotatio2value = collectDerivedValuesByFactory(allValues.values());
		Set<Factory> allFactories = collectAllFactories(allValues, annotatio2value);
		Set<Factory> resolvedFactories = collectResolvedFactories(allFactories);
		Multimap<Class<? extends Annotation>, Value> resolvedValues = collectValues(allValues, resolvedFactories);
		this.deactivatedFactories = ImmutableMap.copyOf(deactivatedFactoryClasses);
		this.overwrittenFactories = ImmutableList.copyOf(overwrittenFactoryClasses);
		this.resolvedFactories = ImmutableList.copyOf(resolvedFactories);
		this.unresolvedFactories = ImmutableList.copyOf(Sets.difference(allFactories, resolvedFactories));
		this.values = ImmutableMultimap.copyOf(resolvedValues);
	}

	public ResolvedConfiguration(Configuration configuration) {
		this(null, configuration);
	}

	protected void checkRetention(Class<? extends Annotation> annotation) {
		Retention retention = annotation.getAnnotation(Retention.class);
		if (retention == null)
			throw new IllegalStateException("@Retention annotation missing on @" + annotation.getName());
		if (retention.value() != RetentionPolicy.RUNTIME)
			throw new IllegalStateException("RetentionPolicy on @" + annotation.getName() + " must be RUNTIME");
	}

	protected Set<Factory> collectAllFactories(Multimap<Class<? extends Annotation>, Value> all, Multimap<Class<?>, DerivedValue> derived) {
		Set<Factory> result = Sets.newLinkedHashSet();
		NEXT: for (Class<?> factory : derived.keySet())
			for (Constructor<?> constructor : factory.getConstructors()) {
				List<Value> in = findParams(all, constructor);
				Collection<DerivedValue> out = derived.get(factory);
				Factory fact = new Factory(constructor, in, out);
				result.add(fact);
				if (in != null) {
					for (DerivedValue m : out)
						m.factory = fact;
					continue NEXT;
				}
			}
		return result;
	}

	protected Set<Class<?>> collectAllFactoryClasses(ResolvedConfiguration parent, Configuration cfg) {
		Set<Class<?>> result = Sets.newLinkedHashSet();
		if (parent != null)
			for (Factory fact : parent.getUnresolvedFactories())
				result.add(fact.getOwner());
		for (Class<?> factory : cfg.getFactories())
			collectAllFactoryClasses(factory, result);
		return result;
	}

	protected void collectAllFactoryClasses(Class<?> clazz, Set<Class<?>> result) {
		if (IXpectSetup.class.isAssignableFrom(clazz))
			return;
		if (!result.add(clazz))
			return;
		collectAllFactoryClasses(clazz.getAnnotation(XpectSetup.class), result);
		for (Constructor<?> constructor : clazz.getConstructors()) {
			for (Class<?> parameter : constructor.getParameterTypes())
				collectAllFactoryClasses(parameter.getAnnotation(XpectSetup.class), result);
			for (Annotation[] annotations : constructor.getParameterAnnotations())
				for (Annotation annotation : annotations)
					collectAllFactoryClasses(annotation.annotationType().getAnnotation(XpectSetup.class), result);
		}
		for (Method method : clazz.getMethods()) {
			for (Class<?> parameter : method.getParameterTypes())
				collectAllFactoryClasses(parameter.getAnnotation(XpectSetup.class), result);
			for (Annotation[] annotations : method.getParameterAnnotations())
				for (Annotation annotation : annotations)
					collectAllFactoryClasses(annotation.annotationType().getAnnotation(XpectSetup.class), result);
		}
	}

	protected void collectAllFactoryClasses(XpectSetup annotation, Set<Class<?>> result) {
		if (annotation != null)
			for (Class<?> clazz : annotation.value())
				collectAllFactoryClasses(clazz, result);
	}

	protected Multimap<Class<? extends Annotation>, Value> collectAllValues(Collection<Class<?>> factories2, Configuration config) {
		Multimap<Class<? extends Annotation>, Value> annotatio2value = LinkedHashMultimap.create();
		annotatio2value.put(Default.class, new PrimaryValue(Default.class, StateContainer.class, new ManagedImpl<Object>(null)));
		for (Map.Entry<Class<? extends Annotation>, Collection<Pair<Class<?>, Managed<?>>>> e : config.getValues().asMap().entrySet())
			for (Pair<Class<?>, Managed<?>> value : e.getValue()) {
				checkRetention(e.getKey());
				annotatio2value.put(e.getKey(), new PrimaryValue(e.getKey(), value.getFirst(), value.getSecond()));
			}
		for (Class<?> factory : factories2) {
			boolean found = false;
			Map<Pair<Class<? extends Annotation>, Class<?>>, DerivedValue> values = Maps.newHashMap();
			Method[] methods = factory.getMethods();
			for (Method m : methods) {
				Creates annotation = m.getAnnotation(Creates.class);
				if (annotation != null) {
					found = true;
					DerivedValue value = new DerivedValue(factory, m);
					checkRetention(annotation.value());
					annotatio2value.put(annotation.value(), value);
					values.put(Tuples.<Class<? extends Annotation>, Class<?>> create(annotation.value(), value.getType()), value);
				}
			}
			if (!found)
				errors.add(new IllegalStateException("No CreateMethods found in " + factory));
			for (Method m : methods) {
				Invalidates annotation = m.getAnnotation(Invalidates.class);
				if (annotation != null) {
					Class<?>[] parameterTypes = m.getParameterTypes();
					if (parameterTypes.length != 1) {
						errors.add(new IllegalStateException("Invalidate-methods must have exactly one parameter. method: " + m));
						continue;
					}
					DerivedValue value = values.get(Tuples.create(annotation.annotatedWith(), parameterTypes[0]));
					if (value == null) {
						errors.add(new IllegalStateException("No @Creates-method found for invalidate-method. method: " + m));
						continue;
					}
					if (value.invalidator != null) {
						errors.add(new IllegalStateException("Can not have two invalidate-methods for the same annotation/type. method: "
								+ m));
						continue;
					}
					value.invalidator = m;
				}
			}
		}
		return annotatio2value;
	}

	protected Map<Class<?>, List<Throwable>> collectDeactivatedClasses(Set<Class<?>> classes) {
		Map<Class<?>, List<Throwable>> deactivated = Maps.newLinkedHashMap();
		for (Class<?> c : classes) {
			List<Throwable> reasons = getFactoryDeactivationReasons(c);
			if (!reasons.isEmpty())
				deactivated.put(c, ImmutableList.copyOf(reasons));
		}
		return deactivated;
	}

	protected Multimap<Class<?>, DerivedValue> collectDerivedValuesByFactory(Collection<Value> values) {
		Multimap<Class<?>, DerivedValue> annotatio2value = LinkedHashMultimap.create();
		for (Value val : values)
			if (val instanceof DerivedValue) {
				DerivedValue cm = (DerivedValue) val;
				annotatio2value.put(cm.getOwner(), cm);
			}
		return annotatio2value;
	}

	protected Set<Class<?>> collectOverwrittenClasses(Set<Class<?>> classes) {
		Set<Class<?>> superClasses = Sets.newLinkedHashSet();
		for (Class<?> c : classes) {
			Class<?> current = c.getSuperclass();
			while (current != Object.class && superClasses.add(current))
				current = current.getSuperclass();
		}
		return Sets.intersection(classes, superClasses);
	}

	protected Set<Factory> collectResolvedFactories(Collection<Factory> factory) {
		Set<Factory> result = Sets.newLinkedHashSet();
		Map<Factory, Boolean> cache = Maps.newHashMap();
		for (Factory fact : factory)
			if (isResolved(fact, cache))
				result.add(fact);
		return result;
	}

	protected Multimap<Class<? extends Annotation>, Value> collectValues(Multimap<Class<? extends Annotation>, Value> all,
			Set<Factory> factories) {
		Multimap<Class<? extends Annotation>, Value> result = HashMultimap.create();
		for (Value v : all.values())
			if (v instanceof PrimaryValue)
				result.put(v.getAnnotatedWith(), v);
			else if (v instanceof DerivedValue && factories.contains(((DerivedValue) v).getFactory()))
				result.put(v.getAnnotatedWith(), v);
		return result;
	}

	protected List<Value> findParams(Multimap<Class<? extends Annotation>, Value> annotation2values, Constructor<?> constructor) {
		List<Value> result = Lists.newArrayList();
		Class<?>[] parameterTypes = constructor.getParameterTypes();
		Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
		for (int i = 0; i < parameterTypes.length; i++) {
			Collection<Value> vals = findValues(annotation2values, parameterAnnotations[i]);
			if (vals == null)
				return null;
			Value value = findValue(vals, parameterTypes[i]);
			if (value == null && parent != null) // FIXME: cleanup
				value = parent.getValue(parameterAnnotations[i].length > 0 ? parameterAnnotations[i][0].annotationType() : Default.class,
						parameterTypes[i]);
			if (value == null)
				return null;
			result.add(value);
		}
		return result;
	}

	protected Value findValue(Collection<Value> values, Class<?> expectedType) {
		for (Value val : values)
			if (expectedType.isAssignableFrom(val.getType()))
				return val;
		return null;
	}

	protected Collection<Value> findValues(Multimap<Class<? extends Annotation>, Value> annotation2values, Annotation[] annotations) {
		if (annotations.length == 0)
			return annotation2values.get(Default.class);
		for (Annotation a : annotations) {
			Collection<Value> result = annotation2values.get(a.annotationType());
			if (result != null)
				return result;
		}
		return null;
	}

	public Map<Class<?>, List<Throwable>> getDeactivatedFactories() {
		return deactivatedFactories;
	}

	public List<Throwable> getErrors() {
		return errors;
	}

	protected List<Throwable> getFactoryDeactivationReasons(Class<?> clazz) {
		List<Throwable> result = Lists.newArrayList();
		for (Method method : clazz.getMethods()) {
			if (method.getAnnotation(Precondition.class) != null) {
				if (!Modifier.isStatic(method.getModifiers())) {
					this.errors.add(new IllegalStateException("Method " + method + " needs to be static"));
					continue;
				}
				if (method.getParameterTypes().length != 0) {
					this.errors.add(new IllegalStateException("Method " + method + " can not (yet) have parameters."));
					continue;
				}
				try {
					method.invoke(null);
				} catch (IllegalAccessException e) {
					result.add(e);
				} catch (IllegalArgumentException e) {
					result.add(e);
				} catch (InvocationTargetException e) {
					result.add(e.getCause());
				}
			}
		}
		return result;
	}

	public List<Class<?>> getOverwrittenFactories() {
		return overwrittenFactories;
	}

	public ResolvedConfiguration getParent() {
		return parent;
	}

	public List<PrimaryValue> getPrimaryValues() {
		List<PrimaryValue> result = Lists.newArrayList();
		for (Value val : values.values())
			if (val instanceof PrimaryValue)
				result.add((PrimaryValue) val);
		return result;
	}

	public List<Factory> getResolvedFactories() {
		return resolvedFactories;
	}

	public List<Factory> getUnresolvedFactories() {
		return unresolvedFactories;
	}

	public Value getValue(Class<? extends Annotation> annotatedWith, Class<?> expectedType) {
		for (Value val : values.get(annotatedWith))
			if (expectedType.isAssignableFrom(val.getType()))
				return val;
		if (parent != null)
			return parent.getValue(annotatedWith, expectedType);
		return null;
	}

	public Multimap<Class<? extends Annotation>, Value> getValues() {
		return values;
	}

	protected boolean isResolved(Factory fact, Map<Factory, Boolean> cache) {
		if (fact == null || !fact.isResolved())
			return false;
		Boolean result = cache.get(fact);
		if (result != null)
			return result;
		for (Value in : fact.getIn())
			if (in instanceof DerivedValue && !isResolved(((DerivedValue) in).getFactory(), cache)) {
				cache.put(fact, false);
				return false;
			}
		cache.put(fact, true);
		return true;
	}

	@Override
	public String toString() {
		List<String> result = Lists.newArrayList();
		if (!errors.isEmpty()) {
			result.add("Errors {");
			List<String> err = Lists.newArrayList();
			for (Throwable error : errors)
				err.add("    " + error.getMessage());
			Collections.sort(err);
			result.addAll(err);
			result.add("}");
		}
		result.add("Primary Values {");
		List<String> vals = Lists.newArrayList();
		for (Value val : values.values())
			if (val instanceof PrimaryValue)
				vals.add("    " + val.toString());
		Collections.sort(vals);
		result.addAll(vals);
		result.add("}");
		result.add("Derived Values {");
		for (Factory fact : resolvedFactories) {
			result.add("    " + fact.getConstructor().getName() + "{");
			List<String> f = Lists.newArrayList();
			for (Value in : fact.getIn())
				f.add("        in " + in);
			for (Value out : fact.getOut())
				f.add("        out " + out);
			Collections.sort(f);
			result.addAll(f);
			result.add("    }");
		}
		result.add("}");
		if (parent != null) {
			result.add("--- Parent --");
			result.add(parent.toString());
		}
		return Joiner.on("\n").join(result);
	}
}
