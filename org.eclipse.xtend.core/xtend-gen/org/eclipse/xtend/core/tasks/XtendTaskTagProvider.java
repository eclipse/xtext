/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tasks;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.tasks.ITaskTagProvider;
import org.eclipse.xtext.tasks.PreferenceTaskTagProvider;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.tasks.TaskTags;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendTaskTagProvider implements ITaskTagProvider {
  @Inject
  private IPreferenceValuesProvider preferenceValuesProvider;

  @Override
  public TaskTags getTaskTags(final Resource resource) {
    TaskTags _xblockexpression = null;
    {
      final IPreferenceValues prefs = this.preferenceValuesProvider.getPreferenceValues(resource);
      PreferenceKey _preferenceKey = new PreferenceKey(JavaCore.COMPILER_TASK_TAGS, "TODO,FIXME,XXX");
      final String namePref = prefs.getPreference(_preferenceKey);
      PreferenceKey _preferenceKey_1 = new PreferenceKey(JavaCore.COMPILER_TASK_PRIORITIES, "NORMAL,HIGH,NORMAL");
      final String prioritiesPref = prefs.getPreference(_preferenceKey_1);
      PreferenceKey _preferenceKey_2 = new PreferenceKey(JavaCore.COMPILER_TASK_CASE_SENSITIVE, JavaCore.ENABLED);
      final String caseSensitivePref = prefs.getPreference(_preferenceKey_2);
      final List<TaskTag> tags = PreferenceTaskTagProvider.parseTags(namePref, prioritiesPref);
      TaskTags _taskTags = new TaskTags();
      final Procedure1<TaskTags> _function = (TaskTags it) -> {
        List<TaskTag> _taskTags_1 = it.getTaskTags();
        Iterables.<TaskTag>addAll(_taskTags_1, tags);
        it.setCaseSensitive(caseSensitivePref.equals(JavaCore.ENABLED));
      };
      _xblockexpression = ObjectExtensions.<TaskTags>operator_doubleArrow(_taskTags, _function);
    }
    return _xblockexpression;
  }
}
