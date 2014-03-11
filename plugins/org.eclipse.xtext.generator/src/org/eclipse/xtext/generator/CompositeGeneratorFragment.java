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
 * A simple composite generator fragment implementation. It delegates all callbacks to its contained fragments.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompositeGeneratorFragment implements IGeneratorFragment, IGeneratorFragmentExtension, NamingAware {

	private static Logger LOG = Logger.getLogger(CompositeGeneratorFragment.class);

	protected final List<IGeneratorFragment> fragments = new ArrayList<IGeneratorFragment>();

	public void addFragment(IGeneratorFragment fragment) {
		if (naming != null && fragment instanceof NamingAware)
			((NamingAware) fragment).registerNaming(naming);
		this.fragments.add(fragment);
	}

	public void addFragments(CompositeGeneratorFragment fragment) {
		if (naming != null)
			fragment.registerNaming(naming);
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

	/**
	 * @since 2.3
	 */
	public void addToPluginXmlTests(Grammar grammar, XpandExecutionContext ctx) {
		for (IGeneratorFragment fragment : fragments) {
			if (fragment instanceof IGeneratorFragmentExtension) {
				((IGeneratorFragmentExtension) fragment).addToPluginXmlTests(grammar, ctx);
			}
		}
	}

	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
		for (IGeneratorFragment fragment : fragments) {
			fragment.addToStandaloneSetup(grammar, ctx);
		}
	}

	public void generate(Grammar grammar, XpandExecutionContext ctx) throws CompositeGeneratorException {
		CompositeGeneratorException cgEx = new CompositeGeneratorException();
		for (IGeneratorFragment fragment : fragments) {
			try {
				fragment.generate(grammar, ctx);
			} catch (WorkflowInterruptedException e) {
				throw e;
			} catch (Exception e) {
				cgEx.addException(e);
			}
		}
		if(cgEx.hasExceptions()) {
			throw cgEx;
		}
	}

	public String[] getExportedPackagesRt(final Grammar grammar) {
		return collectAllStrings(grammar, new Function<IGeneratorFragment, String[]>() {
			public String[] apply(IGeneratorFragment param) {
				return param.getExportedPackagesRt(grammar);
			}
		});
	}

	public String[] getImportedPackagesRt(final Grammar grammar) {
		return collectAllStrings(grammar, new Function<IGeneratorFragment, String[]>() {
			public String[] apply(IGeneratorFragment param) {
				return param.getImportedPackagesRt(grammar);
			}
		});
	}

	public String[] getExportedPackagesUi(final Grammar grammar) {
		return collectAllStrings(grammar, new Function<IGeneratorFragment, String[]>() {
			public String[] apply(IGeneratorFragment param) {
				return param.getExportedPackagesUi(grammar);
			}
		});
	}

	public String[] getImportedPackagesUi(final Grammar grammar) {
		return collectAllStrings(grammar, new Function<IGeneratorFragment, String[]>() {
			public String[] apply(IGeneratorFragment param) {
				return param.getImportedPackagesUi(grammar);
			}
		});
	}

	/**
	 * @since 2.3
	 */
	public String[] getImportedPackagesTests(final Grammar grammar) {
		return collectAllStrings(grammar, new Function<IGeneratorFragment, String[]>() {
			public String[] apply(IGeneratorFragment param) {
				return param instanceof IGeneratorFragmentExtension 
						? ((IGeneratorFragmentExtension) param).getImportedPackagesTests(grammar)
						: null;
			}
		});
	}

	/**
	 * @since 2.3
	 */
	public String[] getExportedPackagesTests(final Grammar grammar) {
		return collectAllStrings(grammar, new Function<IGeneratorFragment, String[]>() {
			public String[] apply(IGeneratorFragment param) {
				return param instanceof IGeneratorFragmentExtension 
						? ((IGeneratorFragmentExtension) param).getExportedPackagesTests(grammar)
						: null;
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

	private String[] collectAllStrings(Grammar grammar, Function<IGeneratorFragment, String[]> func) {
		Set<String> all = new LinkedHashSet<String>();
		for (IGeneratorFragment f : this.fragments) {
			String[] strings = func.apply(f);
			if (strings != null)
				all.addAll(Arrays.asList(strings));
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
									if (entry.isFinal()) {
										throw new IllegalStateException("Conflicting final bindings for '" + binding.getKey() + "' from fragments " +
												""+binding.getContributedBy()+" and "+entry.getContributedBy());
									} else {
										LOG.warn("Cannot override final binding '" + binding + "'. " +
												"Ignoring binding from fragment '"+module.getClass().getSimpleName() +"'");
									}
								} else {
									if (LOG.isDebugEnabled()) {
										LOG.debug("replacing binding : " + binding);
										LOG.debug(" with new binding : " + entry);
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
	
	public String[] getRequiredBundlesRt(final Grammar grammar) {
		return collectAllStrings(grammar, new Function<IGeneratorFragment, String[]> () {
			public String[] apply(IGeneratorFragment f) {
				return f.getRequiredBundlesRt(grammar);
			}
		});
	}

	public String[] getRequiredBundlesUi(final Grammar grammar) {
		return collectAllStrings(grammar, new Function<IGeneratorFragment, String[]> () {
			public String[] apply(IGeneratorFragment f) {
				return f.getRequiredBundlesUi(grammar);
			}
		});
	}

	/**
	 * @since 2.3
	 */
	public String[] getRequiredBundlesTests(final Grammar grammar) {
		return collectAllStrings(grammar, new Function<IGeneratorFragment, String[]> () {
			public String[] apply(IGeneratorFragment f) {
				return (f instanceof IGeneratorFragmentExtension)
						? ((IGeneratorFragmentExtension)f).getRequiredBundlesTests(grammar)
						: null;
			}
		});
	}
	
	public void checkConfiguration(Issues issues) {
		for (IGeneratorFragment fragment : fragments) {
			fragment.checkConfiguration(issues);
		}
	}

	private Naming naming;

	public void registerNaming(Naming n) {
		this.naming = n;
		for (IGeneratorFragment f : fragments) {
			if (f instanceof NamingAware)
				((NamingAware) f).registerNaming(n);
		}

	}

}
