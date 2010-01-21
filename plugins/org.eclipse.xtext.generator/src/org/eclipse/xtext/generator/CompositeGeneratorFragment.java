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
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;

import com.google.common.base.Function;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 *         simple composite generator fragment implementation. delegating all
 *         callbacks to its contained fragments
 */
public class CompositeGeneratorFragment implements IGeneratorFragment {

	private static Logger LOG = Logger.getLogger(CompositeGeneratorFragment.class);

	protected final List<IGeneratorFragment> fragments = new ArrayList<IGeneratorFragment>();

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
			} catch (WorkflowInterruptedException e) {
				throw e;
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
			}
		}
	}

	public String[] getExportedPackagesRt(final Grammar grammar) {
		return internalGetExportedPackages(grammar, new Function<IGeneratorFragment, String[]>() {

			public String[] apply(IGeneratorFragment param) {
				return param.getExportedPackagesRt(grammar);
			}
		});
	}
	
	public String[] getImportedPackagesRt(final Grammar grammar) {
		return internalGetImportedPackages(grammar, new Function<IGeneratorFragment, String[]>() {
			public String[] apply(IGeneratorFragment param) {
				return param.getImportedPackagesRt(grammar);
			}
		});
	}

	public String[] getExportedPackagesUi(final Grammar grammar) {
		return internalGetExportedPackages(grammar, new Function<IGeneratorFragment, String[]>() {
			public String[] apply(IGeneratorFragment param) {
				return param.getExportedPackagesUi(grammar);
			}
		});
	}
	
	public String[] getImportedPackagesUi(final Grammar grammar) {
		return internalGetImportedPackages(grammar, new Function<IGeneratorFragment, String[]>() {
			public String[] apply(IGeneratorFragment param) {
				return param.getImportedPackagesUi(grammar);
			}
		});
	}
	
	public Set<Binding> getGuiceBindingsRt(final Grammar grammar) {
		return internalGetGuiceBindings(grammar, new Function<IGeneratorFragment, Set<Binding>>() {
			public Set<Binding> apply(IGeneratorFragment param) {
				return param.getGuiceBindingsRt(grammar);
			}
		});
	}

	public Set<Binding> getGuiceBindingsUi(final Grammar grammar) {
		return internalGetGuiceBindings(grammar, new Function<IGeneratorFragment, Set<Binding>>() {
			public Set<Binding> apply(IGeneratorFragment param) {
				return param.getGuiceBindingsUi(grammar);
			}
		});
	}

	private String[] internalGetExportedPackages(Grammar grammar, Function<IGeneratorFragment, String[]> func) {
		Set<String> all = new LinkedHashSet<String>();
		for (IGeneratorFragment f : this.fragments) {
			String[] exportedPackages = func.apply(f);
			if (exportedPackages != null)
				all.addAll(Arrays.asList(exportedPackages));
		}
		return all.toArray(new String[all.size()]);
	}
	
	private String[] internalGetImportedPackages(Grammar grammar, Function<IGeneratorFragment, String[]> func) {
		Set<String> all = new LinkedHashSet<String>();
		for (IGeneratorFragment f : this.fragments) {
			String[] importedPackages = func.apply(f);
			if (importedPackages != null)
				all.addAll(Arrays.asList(importedPackages));
		}
		return all.toArray(new String[all.size()]);
	}

	private Set<Binding> internalGetGuiceBindings(Grammar grammar, Function<IGeneratorFragment, Set<Binding>> func) {
		LinkedHashSet<Binding> bindings = new LinkedHashSet<Binding>();
		for (IGeneratorFragment module : fragments) {
			Set<Binding> temp = func.apply(module);
			if (temp != null) {
				for (Binding entry : temp) {
					if (bindings.contains(entry)) {
						for (Iterator<Binding> iterator = bindings.iterator(); iterator.hasNext();) {
							Binding binding = iterator.next();
							if (binding.equals(entry)) {
								if (binding.isFinal()) {
									throw new IllegalStateException("Cannot override final binding '" + binding + "'");
								} else {
									if (LOG.isDebugEnabled()) {
										LOG.debug("replacing binding : "+binding);
										LOG.debug(" with new binding : "+entry);
									}
									iterator.remove();
								}
								break;
							}
						}
					}
					bindings.add(entry);
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

	public void checkConfiguration(Issues issues) {
		for (IGeneratorFragment fragment : fragments) {
			fragment.checkConfiguration(issues);
		}
	}

}
