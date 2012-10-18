package org.eclipse.xpect.ui.editor;

import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IFileEditorMapping;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.registry.EditorDescriptor;
import org.eclipse.ui.internal.registry.EditorRegistry;
import org.eclipse.ui.internal.registry.IWorkbenchRegistryConstants;
import org.eclipse.xpect.util.ExtensionFactoryUtil;
import org.eclipse.xpect.util.ExtensionFactoryUtil.NameAndClass;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

@SuppressWarnings("restriction")
public class XtextWithXpectEditorInstaller {

	protected EditorDescriptor createAssimilatingEditor(String lanugage, String editorClass, IEditorDescriptor descriptor) {
		EditorDescriptor editorDescriptor = (EditorDescriptor) descriptor;
		String newID = descriptor.getId() + ".withXpect";
		XpectEditorConfigurationElement cfg = new XpectEditorConfigurationElement(editorDescriptor.getConfigurationElement());
		cfg.setId(newID);
		cfg.setLanguage(lanugage);
		cfg.setName(descriptor.getLabel() + " with Xpect");
		cfg.setClazz(editorClass);
		cfg.setPluginID(editorDescriptor.getPluginID());
		return createEditorDescriptor(newID, cfg);
	}

	protected EditorDescriptor createEditorDescriptor(String id2, IConfigurationElement element) {
		try {
			Constructor<EditorDescriptor> c = EditorDescriptor.class.getDeclaredConstructor(String.class, IConfigurationElement.class);
			c.setAccessible(true);
			return c.newInstance(id2, element);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void earlyStartup() {
		EditorRegistry registry = (EditorRegistry) PlatformUI.getWorkbench().getEditorRegistry();
		Map<String, Triple<String, String, IEditorDescriptor>> xtextEditors = Maps.newLinkedHashMap();
		Multimap<String, String> editor2extension = LinkedHashMultimap.create();
		for (IFileEditorMapping mapping : registry.getFileEditorMappings())
			for (IEditorDescriptor descriptor : mapping.getEditors()) {
				if (mapping.getExtension() != null)
					editor2extension.put(descriptor.getId(), mapping.getExtension());
				if (xtextEditors.containsKey(descriptor.getId()))
					continue;
				IConfigurationElement configurationElement = ((EditorDescriptor) descriptor).getConfigurationElement();
				String factAndClass = configurationElement.getAttribute(IWorkbenchRegistryConstants.ATT_CLASS);
				NameAndClass nameAndClass = ExtensionFactoryUtil.parseExtensionFactory(factAndClass);
				if (!nameAndClass.hasNameAndClass())
					continue;
				xtextEditors.put(descriptor.getId(), Tuples.create(descriptor.getId(), nameAndClass.getClazz(), descriptor));
			}
		// System.out.println(Joiner.on("\n").join(xtextEditors.entrySet()));
		for (Triple<String, String, IEditorDescriptor> e : xtextEditors.values()) {
			EditorDescriptor withXpectEditor = createAssimilatingEditor(e.getFirst(), e.getSecond(), e.getThird());
			if (registry.findEditor(withXpectEditor.getId()) != null)
				continue;
			List<String> extensions = Lists.newArrayList(editor2extension.get(e.getThird().getId()));
			registry.addEditorFromPlugin(withXpectEditor, extensions, Collections.emptyList(), Collections.emptyList(), false);
		}

	}

}
