package org.xpect.model;

import static org.xpect.util.JvmAnnotationUtil.getAnnotationTypeValue;
import static org.xpect.util.JvmAnnotationUtil.getAnnotationValue;
import static org.xpect.util.JvmAnnotationUtil.getJavaAnnotationsViaMetaAnnotation;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.junit.Test;
import org.xpect.Environment;
import org.xpect.XjmClass;
import org.xpect.XjmContribution;
import org.xpect.XjmElement;
import org.xpect.XjmMethod;
import org.xpect.XjmTest;
import org.xpect.XpectContributionRole;
import org.xpect.XpectImport;
import org.xpect.XpectJavaModelFactory;
import org.xpect.XpectReplace;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectSuiteClasses;
import org.xpect.setup.XpectSetup;
import org.xpect.util.JvmAnnotationUtil;
import org.xpect.util.JvmTypesUtil;

import com.google.common.base.Joiner;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

@SuppressWarnings({ "deprecation" })
public class XpectJavaModelImplCustom extends XpectJavaModelImpl {

	private boolean contributionsInitialized = false;
	private boolean methodsInitialized = false;
	private boolean testsInitalized = false;

	private void collectContributions(JvmAnnotationTarget ctx, XjmElement owner, Map<String, XjmContribution> contributions, Set<Object> visited) {
		if (ctx == null || ctx.eIsProxy() || !visited.add(Tuples.create(ctx, owner)))
			return;
		XjmContribution contribution = null;
		if (ctx instanceof JvmDeclaredType) {
			String qualifiedName = ctx.getQualifiedName();
			contribution = contributions.get(qualifiedName);
			if (contribution == null) {
				List<? extends Annotation> roles = getJavaAnnotationsViaMetaAnnotation(ctx, XpectContributionRole.class);
				if (!roles.isEmpty()) {
					contribution = XpectJavaModelFactory.eINSTANCE.createXjmContribution();
					((XjmContributionImplCustom) contribution).initialize((JvmDeclaredType) ctx, roles);
					contributions.put(qualifiedName, contribution);
				}
			}
			if (contribution != null)
				owner.getImports().add(contribution);
		}
		Set<JvmAnnotationTarget> targets = Sets.newLinkedHashSet();
		targets.add(ctx);
		if (ctx instanceof JvmDeclaredType)
			for (JvmType superType : JvmTypesUtil.getAllSuperTypes((JvmDeclaredType) ctx))
				if (superType instanceof JvmAnnotationTarget)
					targets.add((JvmAnnotationTarget) superType);
		Set<JvmDeclaredType> imports = Sets.newLinkedHashSet();
		for (JvmAnnotationTarget target : targets) {
			imports.addAll(getAnnotationTypeValue(target, XpectImport.class));
			imports.addAll(getAnnotationTypeValue(target, XpectSetup.class));
		}
		XjmElement newOwner = contribution == null ? owner : contribution;
		for (JvmDeclaredType imp : imports)
			collectContributions(imp, newOwner, contributions, visited);
	}

	private void collectContributions(XjmClass owner, Map<String, XjmContribution> contribution, Set<Object> visited) {
		collectContributions(owner.getJvmClass(), owner, contribution, visited);
	}

	private void collectTestClasses(JvmDeclaredType classOrSuite, Map<String, XjmTest> result) {
		JvmTypeAnnotationValue typeValue = getAnnotationValue(classOrSuite, XpectSuiteClasses.class, JvmTypeAnnotationValue.class);
		if (typeValue != null)
			for (JvmTypeReference ref : typeValue.getValues())
				if (ref != null && !ref.eIsProxy()) {
					JvmType jvmType = ref.getType();
					if (jvmType instanceof JvmDeclaredType && !jvmType.eIsProxy()) {
						String name = jvmType.getQualifiedName();
						XjmTest cls = result.get(name);
						if (cls == null) {
							JvmDeclaredType jvmDeclaredType = (JvmDeclaredType) jvmType;
							cls = XpectJavaModelFactory.eINSTANCE.createXjmTest();
							cls.setJvmClass(jvmDeclaredType);
							result.put(name, cls);
							collectTestClasses(jvmDeclaredType, result);
						}
					}
				}
	}

	private Multimap<XjmClass, String> computeReverseImports() {
		Multimap<XjmClass, String> result = LinkedHashMultimap.create();
		List<XjmElement> elements = Lists.<XjmElement> newArrayList(getTests());
		elements.addAll(getTests());
		elements.addAll(getMethods().values());
		elements.addAll(getContributions());
		for (XjmElement cnt : elements)
			for (XjmClass imported : cnt.getImports())
				result.put(imported, toSimpleName(cnt));
		return result;
	}

	@Override
	public EList<XjmContribution> getContributions() {
		initContributions();
		return super.getContributions();
	}

	@Override
	public EMap<String, XjmMethod> getMethods() {
		initTestClassMethods();
		return super.getMethods();
	}

	@Override
	public EList<XjmTest> getTests() {
		initTestClasses();
		return super.getTests();
	}

	public void initContributions() {
		if (contributionsInitialized)
			return;

		Set<Object> visited = Sets.newHashSet();
		Map<String, XjmContribution> contributions = Maps.newLinkedHashMap();
		for (XjmTest test : getTests()) {
			collectContributions(test, contributions, visited);
			for (XjmMethod method : test.getMethods()) {
				JvmOperation jvmMethod = method.getJvmMethod();
				if (jvmMethod == null || jvmMethod.eIsProxy())
					continue;
				for (JvmFormalParameter param : jvmMethod.getParameters()) {
					for (JvmAnnotationReference ref : param.getAnnotations())
						collectContributions(ref.getAnnotation(), method, contributions, visited);
					JvmTypeReference typeRef = param.getParameterType();
					if (typeRef != null && !typeRef.eIsProxy()) {
						JvmType type = typeRef.getType();
						if (type instanceof JvmAnnotationTarget && !type.eIsProxy())
							collectContributions((JvmAnnotationTarget) type, method, contributions, visited);
					}
				}
			}
		}
		Collection<XjmContribution> values = contributions.values();
		initSubstitutions(values);
		super.getContributions().addAll(values);
		contributionsInitialized = true;
	}

	private void initSubstitutions(Collection<XjmContribution> contributions) {
		Map<JvmDeclaredType, XjmContribution> contributionsByType = Maps.newHashMap();
		for (XjmContribution cont : contributions) {
			if (cont.isActive()) {
				JvmDeclaredType jvmClass = cont.getJvmClass();
				if (jvmClass != null && !jvmClass.eIsProxy())
					contributionsByType.put(jvmClass, cont);
			}
		}
		for (XjmContribution cont : contributionsByType.values()) {
			List<JvmDeclaredType> replaces = JvmAnnotationUtil.getAnnotationTypeValue(cont.getJvmClass(), XpectReplace.class);
			for (JvmDeclaredType replace : replaces) {
				XjmContribution replaced = contributionsByType.get(replace);
				if (replaced != null)
					replaced.setReplacedBy(cont);
			}
		}
	}

	public void initTestClasses() {
		if (testsInitalized)
			return;
		Map<String, XjmTest> name2test = Maps.newLinkedHashMap();
		XjmTest test = getTestOrSuite();
		EList<XjmTest> newTests = super.getTests();
		newTests.clear();
		if (test != null && !test.eIsProxy()) {
			JvmDeclaredType jvmClass = test.getJvmClass();
			if (jvmClass != null && !jvmClass.eIsProxy()) {
				name2test.put(jvmClass.getQualifiedName(), test);
				collectTestClasses(test.getJvmClass(), name2test);
				newTests.addAll(name2test.values());
			}
		}
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
		XpectJavaModelFactory factory = XpectJavaModelFactory.eINSTANCE;
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

	private String toQualifiedName(JvmIdentifiableElement element) {
		if (element == null)
			return "null";
		if (element.eIsProxy())
			return "Proxy: " + ((InternalEObject) element).eProxyURI();
		String name = element.getQualifiedName();
		return name == null ? "null" : name;
	}

	private String toSimpleName(XjmElement element) {
		if (element instanceof XjmMethod) {
			JvmOperation method = ((XjmMethod) element).getJvmMethod();
			if (method == null)
				return null;
			if (method.eIsProxy())
				return "Proxy: " + ((InternalEObject) method).eProxyURI();
			JvmDeclaredType type = method.getDeclaringType();
			return type.getSimpleName() + "." + method.getSimpleName() + "()";
		} else if (element instanceof XjmClass) {
			JvmDeclaredType jvmClass = ((XjmClass) element).getJvmClass();
			if (jvmClass == null)
				return null;
			if (jvmClass.eIsProxy())
				return "Proxy: " + ((InternalEObject) jvmClass).eProxyURI();
			return jvmClass.getSimpleName();
		}
		return element == null ? "null" : element.toString();
	}

	@Override
	public String toString() {
		Multimap<XjmClass, String> reverseImports = computeReverseImports();
		Multimap<String, XjmContribution> contributionByRole = HashMultimap.create();
		for (XjmContribution cnt : getContributions())
			for (Annotation role : cnt.getRoles())
				contributionByRole.put(role.annotationType().getSimpleName(), cnt);
		List<Object> items = Lists.newArrayList();
		items.addAll(getTests());
		for (Map.Entry<String, Collection<XjmContribution>> e : contributionByRole.asMap().entrySet())
			items.add(toString(e.getKey(), e.getValue(), reverseImports));
		String body = " {\n  " + Joiner.on("\n").join(items).replace("\n", "\n  ") + "\n}";
		return "suite " + toQualifiedName(getTestOrSuite().getJvmClass()) + body;
	}

	private String toString(String role, Collection<XjmContribution> contributions, Multimap<XjmClass, String> reverseImports) {
		List<String> items = Lists.newArrayList();
		for (XjmContribution cnt : contributions)
			items.add(toString(cnt, reverseImports.get(cnt)));
		Collections.sort(items);
		String body = " {\n  " + Joiner.on("\n").join(items).replace("\n", "\n  ") + "\n}";
		return "contributionsFor @" + role + body;
	}

	private String toString(XjmContribution contribution, Collection<String> importedBy) {
		StringBuilder result = new StringBuilder();
		if (!contribution.isActive())
			result.append("[INACTIVE] ");
		result.append(toQualifiedName(contribution.getJvmClass()));
		String reason = contribution.getDeactivationReason();
		if (reason != null) {
			result.append(" InactiveBecause: ");
			result.append(reason);
		}
		if (!importedBy.isEmpty()) {
			result.append(" ImportedBy:");
			result.append(Joiner.on(" ").join(importedBy));
		}
		return result.toString();
	}

	@Override
	public Iterable<XjmContribution> getContributions(Class<? extends Annotation> role) {
		List<XjmContribution> list = Lists.newArrayList();
		N: for (XjmContribution cont : getContributions())
			for (Annotation cand : cont.getRoles())
				if (cand.annotationType() == role) {
					list.add(cont);
					continue N;
				}
		return list;
	}

	@Override
	public Iterable<XjmContribution> getContributions(Class<? extends Annotation> role, Environment environment) {
		List<XjmContribution> list = Lists.newArrayList();
		N: for (XjmContribution cont : getContributions())
			if (cont.getEnvironments().contains(environment))
				for (Annotation cand : cont.getRoles())
					if (cand.annotationType() == role) {
						list.add(cont);
						continue N;
					}
		return list;
	}
}
