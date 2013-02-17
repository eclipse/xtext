package org.xpect.model;

import static org.xpect.util.JvmAnnotationUtil.getAnnotationValue;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.junit.Test;
import org.xpect.Environment;
import org.xpect.XjmFactory;
import org.xpect.XjmMethod;
import org.xpect.XjmModule;
import org.xpect.XjmSetup;
import org.xpect.XjmTest;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectSuiteClasses;
import org.xpect.setup.XpectModule;
import org.xpect.setup.XpectModules;
import org.xpect.setup.XpectSetup;
import org.xpect.setup.XpectSetups;
import org.xpect.util.JvmAnnotationUtil;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

public class XpectJavaModelImplCustom extends XpectJavaModelImpl {

	private boolean methodsInitialized = false;
	private boolean modulesInitialized = false;
	private boolean setupsInitialized = false;
	private boolean testsInitalized = false;

	private void collectTestClasses(JvmDeclaredType classOrSuite, Map<String, XjmTest> result) {
		if (classOrSuite != null && !classOrSuite.eIsProxy()) {
			XjmTest cls = result.get(classOrSuite.getQualifiedName());
			if (cls == null) {
				cls = XjmFactory.eINSTANCE.createXjmTest();
				cls.setJvmClass(classOrSuite);
				result.put(classOrSuite.getQualifiedName(), cls);
				JvmTypeAnnotationValue typeValue = getAnnotationValue(classOrSuite, XpectSuiteClasses.class, JvmTypeAnnotationValue.class);
				if (typeValue != null)
					for (JvmTypeReference ref : typeValue.getValues())
						if (ref != null && !ref.eIsProxy() && ref.getType() instanceof JvmDeclaredType && !ref.getType().eIsProxy())
							collectTestClasses((JvmDeclaredType) ref.getType(), result);
			}
		}
	}

	private List<Pair<Environment, JvmDeclaredType>> getAnnotated(JvmDeclaredType type, Class<? extends Annotation> singular,
			Class<? extends Annotation> plural) {
		List<JvmAnnotationReference> refs = Lists.newArrayList();
		JvmAnnotationAnnotationValue val = JvmAnnotationUtil.getAnnotationValue(type, plural, JvmAnnotationAnnotationValue.class);
		if (val != null && !val.eIsProxy())
			for (JvmAnnotationReference ref : val.getValues())
				if (ref != null && !ref.eIsProxy())
					refs.add(ref);

		JvmAnnotationReference reference = JvmAnnotationUtil.getAnnotation(type, singular);
		if (reference != null)
			refs.add(reference);

		List<Pair<Environment, JvmDeclaredType>> result = Lists.newArrayList();
		for (JvmAnnotationReference ref : refs) {
			Environment key = getEnvironment(JvmAnnotationUtil.getAnnotationValue(ref, JvmEnumAnnotationValue.class));
			JvmDeclaredType value = getDeclaredType(JvmAnnotationUtil.getAnnotationValue(ref, JvmTypeAnnotationValue.class));
			result.add(Tuples.create(key, value));
		}
		return result;
	}

	@Override
	public EList<XjmSetup> getSetups(Environment environment) {
		EList<XjmSetup> result = new BasicEList<XjmSetup>();
		for (XjmTest test : getTests()) {
			XjmSetup setup = test.getSetups().get(environment);
			if (setup != null)
				result.add(setup);
		}
		return result;
	}

	@Override
	public EList<XjmModule> getModules(Environment environment) {
		EList<XjmModule> result = new BasicEList<XjmModule>();
		for (XjmTest test : getTests()) {
			XjmModule module = test.getModules().get(environment);
			if (module != null)
				result.add(module);
		}
		return result;
	}

	private JvmDeclaredType getDeclaredType(JvmTypeAnnotationValue value) {
		for (JvmTypeReference ref : value.getValues())
			if (ref != null && !ref.eIsProxy() && ref.getType() instanceof JvmDeclaredType && !ref.getType().eIsProxy())
				return (JvmDeclaredType) ref.getType();
		return null;
	}

	private Environment getEnvironment(JvmEnumAnnotationValue key) {
		for (JvmEnumerationLiteral lit : key.getValues())
			if (lit != null && !lit.eIsProxy())
				return Environment.get(lit.getSimpleName());
		return null;
	}

	@Override
	public EMap<String, XjmMethod> getMethods() {
		initTestClassMethods();
		return super.getMethods();
	}

	@Override
	public EList<XjmModule> getModules() {
		initModules();
		return super.getModules();
	}

	@Override
	public EList<XjmSetup> getSetups() {
		initSetups();
		return super.getSetups();
	}

	@Override
	public EList<XjmTest> getTests() {
		initTestClasses();
		return super.getTests();
	}

	public void initModules() {
		if (modulesInitialized)
			return;

		Map<String, XjmModule> cache = Maps.newLinkedHashMap();
		for (XjmTest test : getTests())
			for (Pair<Environment, JvmDeclaredType> p : getAnnotated(test.getJvmClass(), XpectModule.class, XpectModules.class)) {
				XjmModule module = cache.get(p.getSecond().getQualifiedName());
				if (module == null) {
					module = XjmFactory.eINSTANCE.createXjmModule();
					module.setJvmClass(p.getSecond());
					cache.put(p.getSecond().getQualifiedName(), module);
				}
				((XjmTestImplCustom) test).putModule(p.getFirst(), module);
			}
		super.getModules().addAll(cache.values());
		modulesInitialized = true;
	}

	public void initSetups() {
		if (setupsInitialized)
			return;

		Map<String, XjmSetup> cache = Maps.newLinkedHashMap();
		for (XjmTest test : getTests())
			for (Pair<Environment, JvmDeclaredType> p : getAnnotated(test.getJvmClass(), XpectSetup.class, XpectSetups.class)) {
				XjmSetup setup = cache.get(p.getSecond().getQualifiedName());
				if (setup == null) {
					setup = XjmFactory.eINSTANCE.createXjmSetup();
					setup.setJvmClass(p.getSecond());
					cache.put(p.getSecond().getQualifiedName(), setup);
				}
				((XjmTestImplCustom) test).putSetup(p.getFirst(), setup);
			}
		super.getSetups().addAll(cache.values());
		setupsInitialized = true;
	}

	public void initTestClasses() {
		if (testsInitalized)
			return;
		Map<String, XjmTest> name2test = Maps.newLinkedHashMap();
		collectTestClasses(getTestOrSuite().getJvmClass(), name2test);
		super.getTests().addAll(name2test.values());

		testsInitalized = true;
	}

	public void initTestClassMethods() {
		if (methodsInitialized)
			return;

		// collect all methods
		Multimap<Pair<Boolean, String>, Pair<XjmTest, JvmOperation>> xpectMethods = LinkedHashMultimap.create();
		for (XjmTest type : getTests())
			for (JvmFeature feature : type.getJvmClass().getAllFeatures())
				if (feature instanceof JvmOperation && feature.getVisibility() == JvmVisibility.PUBLIC) {
					if (JvmAnnotationUtil.isAnnotatedWith(feature, Xpect.class))
						xpectMethods.put(Tuples.create(true, feature.getSimpleName()), Tuples.create(type, (JvmOperation) feature));
					if (JvmAnnotationUtil.isAnnotatedWith(feature, Test.class))
						xpectMethods.put(Tuples.create(false, feature.getSimpleName()), Tuples.create(type, (JvmOperation) feature));
				}

		// only add the methods for which only one exists.
		XjmFactory factory = XjmFactory.eINSTANCE;
		EMap<String, XjmMethod> name2method = super.getMethods();
		for (Map.Entry<Pair<Boolean, String>, Collection<Pair<XjmTest, JvmOperation>>> e : xpectMethods.asMap().entrySet())
			if (e.getValue().size() == 1) {
				Pair<XjmTest, JvmOperation> pair = e.getValue().iterator().next();
				XjmMethod method = e.getKey().getFirst() ? factory.createXjmXpectMethod() : factory.createXjmTestMethod();
				method.setJvmMethod(pair.getSecond());
				((XjmTestImplCustom) pair.getFirst()).addMethod(method);
				name2method.put(method.getName(), method);
			}

		methodsInitialized = true;
	}

	@Override
	public String toString() {
		Iterable<Object> iterable = Iterables.<Object> concat(getModules(), getSetups(), getTests());
		String body = " {\n  " + Joiner.on("\n").join(iterable).replace("\n", "\n  ") + "\n}";
		return "suite " + getTestOrSuite().getJvmClass().getQualifiedName() + body;
	}
}
