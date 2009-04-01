/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtext.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;

import com.google.common.base.Function;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 * simple composite generator fragment implementation.
 * delegating all callbacks to its contained fragments
 */
public class CompositeGeneratorFragment implements IGeneratorFragment {

	private static Logger LOG = Logger.getLogger(CompositeGeneratorFragment.class);

	private final List<IGeneratorFragment> fragments = new ArrayList<IGeneratorFragment>();

	public void addFragment(IGeneratorFragment fragment) {
		this.fragments.add(fragment);
	}

	public void addFragments(CompositeGeneratorFragment fragment) {
		this.fragments.add(fragment);
	}

	public void addLog(LoggingGeneratorFragment message) {
		message.setLevel(Level.INFO);
		addFragment(message);
	}

	public void addWarn(LoggingGeneratorFragment message) {
		message.setLevel(Level.WARN);
		addFragment(message);
	}

	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		for (IGeneratorFragment fragment : fragments) {
			fragment.addToPluginXmlRt(grammar, ctx);
		}
	}

	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
		for (IGeneratorFragment fragment : fragments) {
			fragment.addToPluginXmlUi(grammar, ctx);
		}
	}

	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
		for (IGeneratorFragment fragment : fragments) {
			fragment.addToStandaloneSetup(grammar, ctx);
		}
	}

	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		for (IGeneratorFragment fragment : fragments) {
			try {
				fragment.generate(grammar, ctx);
			} catch(Exception e) {
				LOG.error(e.getMessage(), e);
			}
		}
	}

	public String[] getExportedPackagesRt(final Grammar grammar) {
		return internalGetExportedPackages(grammar, new Function<IGeneratorFragment, String[]>(){

			public String[] apply(IGeneratorFragment param) {
				return param.getExportedPackagesRt(grammar);
			}});
	}
	
	public String[] getExportedPackagesUi(final Grammar grammar) {
		return internalGetExportedPackages(grammar, new Function<IGeneratorFragment, String[]>(){
			public String[] apply(IGeneratorFragment param) {
				return param.getExportedPackagesUi(grammar);
			}});
	}
	
	public Map<BindKey, BindValue> getGuiceBindingsRt(final Grammar grammar) {
		return internalGetGuiceBindings(grammar, new Function<IGeneratorFragment, Map<BindKey,BindValue>>(){
			public Map<BindKey, BindValue> apply(IGeneratorFragment param) {
				return param.getGuiceBindingsRt(grammar);
			}});
	}
	
	public Map<BindKey, BindValue> getGuiceBindingsUi(final Grammar grammar) {
		return internalGetGuiceBindings(grammar, new Function<IGeneratorFragment, Map<BindKey,BindValue>>(){
			public Map<BindKey, BindValue> apply(IGeneratorFragment param) {
				return param.getGuiceBindingsUi(grammar);
			}});
	}
	
	
	private String[] internalGetExportedPackages(Grammar grammar, Function<IGeneratorFragment, String[]> func) {
		Set<String> all = new LinkedHashSet<String>();
		for (IGeneratorFragment f : this.fragments) {
			String[] exportedPackagesRt = func.apply(f);
			if (exportedPackagesRt != null)
				all.addAll(Arrays.asList(exportedPackagesRt));
		}
		return all.toArray(new String[all.size()]);
	}
	
	private Map<BindKey, BindValue> internalGetGuiceBindings(Grammar grammar, Function<IGeneratorFragment,Map<BindKey, BindValue>> func) {
		Map<BindKey, BindValue> bindings = new LinkedHashMap<BindKey, BindValue>();
		Map<BindKey, Class<? extends IGeneratorFragment>> contributedBy = new HashMap<BindKey, Class<? extends IGeneratorFragment>>();
		for (IGeneratorFragment module : fragments) {
			Map<BindKey, BindValue> temp =func.apply(module);
			if (temp != null) {
				for (Map.Entry<BindKey, BindValue> entry : temp.entrySet()) {
					if (!contributedBy.containsKey(entry.getKey())) {
						contributedBy.put(entry.getKey(), module.getClass());
					} else {
						throw new IllegalStateException("Duplicate binding for " + entry.getKey()
								+ ". Contributed by '" + contributedBy.get(entry.getKey()).getName() + "' and '"
								+ module.getClass().getName() + "'");
					}
					bindings.put(entry.getKey(), entry.getValue());
				}
			}
		}
		return bindings;
	}

	public String[] getRequiredBundlesRt(Grammar grammar) {
		Set<String> all = new LinkedHashSet<String>();
		for (IGeneratorFragment f : this.fragments) {
			String[] requiredBundlesRt = f.getRequiredBundlesRt(grammar);
			if (requiredBundlesRt != null)
				all.addAll(Arrays.asList(requiredBundlesRt));
		}
		return all.toArray(new String[all.size()]);
	}

	public String[] getRequiredBundlesUi(Grammar grammar) {
		Set<String> all = new LinkedHashSet<String>();
		for (IGeneratorFragment f : this.fragments) {
			String[] requiredBundlesUi = f.getRequiredBundlesUi(grammar);
			if (requiredBundlesUi != null)
				all.addAll(Arrays.asList(requiredBundlesUi));
		}
		return all.toArray(new String[all.size()]);
	}

}
