/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.XtextGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.XtextGrammarTestLanguageUiModule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.XtextUiModule;
import org.eclipse.xtext.enumrules.EnumRulesTestLanguageStandaloneSetup;
import org.eclipse.xtext.enumrules.EnumRulesTestLanguageUiModule;
import org.eclipse.xtext.parser.keywords.KeywordsTestLanguageStandaloneSetup;
import org.eclipse.xtext.parser.keywords.KeywordsTestLanguageUiModule;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguageUiModule;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageUiModule;
import org.eclipse.xtext.ui.common.service.UIPluginModule;
import org.eclipse.xtext.ui.common.tests.Activator;
import org.eclipse.xtext.ui.core.SimpleLabelProvider;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext.Factory;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaContentAssistProcessorTestSetup implements IContentAssistProcessorTestSetup {

	public ISetup getRefGrammarSetup() {
		return new ReferenceGrammarTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ReferenceGrammarTestLanguageUiModule() {
					@Override
					public Class<? extends ContentAssistContext.Factory> bindContentAssistContext$Factory() {
						return DefaultContentAssistContextFactory.class;
					}
				}, new UIPluginModule(Activator.getInstance()));
			}
		};
	}

	public ISetup getXtextGrammarTestSetup() {
		return new XtextGrammarTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtextGrammarTestLanguageUiModule() {
					@Override
					public Class<? extends ContentAssistContext.Factory> bindContentAssistContext$Factory() {
						return DefaultContentAssistContextFactory.class;
					}
				}, new UIPluginModule(Activator.getInstance()));
			}
		};
	}

	public ISetup getXtextSetup() {
		return new XtextStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtextUiModule() {
					@Override
					public Class<? extends ILabelProvider> bindILabelProvider() {
						return SimpleLabelProvider.class;
					}

					@Override
					public Class<? extends ContentAssistContext.Factory> bindContentAssistContext$Factory() {
						return DefaultContentAssistContextFactory.class;
					}
				}, new UIPluginModule(Activator.getInstance()));
			}
		};
	}

	public ISetup getContentAssistGrammarSetup() {
		return new ContentAssistTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ContentAssistTestLanguageUiModule() {
					@Override
					public Class<? extends ContentAssistContext.Factory> bindContentAssistContext$Factory() {
						return DefaultContentAssistContextFactory.class;
					}
				},
				new UIPluginModule(Activator.getInstance()));
			}
		};
	}

	public ISetup getKeywordsLangSetup() {
		return new KeywordsTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new KeywordsTestLanguageUiModule() {
					@Override
					public Class<? extends ContentAssistContext.Factory> bindContentAssistContext$Factory() {
						return DefaultContentAssistContextFactory.class;
					}
				},
				new UIPluginModule(Activator.getInstance()));
			}
		};
	}

	public ISetup getEnumsLangSetup() {
		return new EnumRulesTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new EnumRulesTestLanguageUiModule() {
					@Override
					public Class<? extends ContentAssistContext.Factory> bindContentAssistContext$Factory() {
						return DefaultContentAssistContextFactory.class;
					}
				},
				new UIPluginModule(Activator.getInstance()));
			}
		};
	}

	public ISetup getContentAssistContextTestLanguageSetup() {
		return new ContentAssistContextTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ContentAssistContextTestLanguageUiModule() {
					@Override
					public Class<? extends ContentAssistContext.Factory> bindContentAssistContext$Factory() {
						return DefaultContentAssistContextFactory.class;
					}
				},
				new UIPluginModule(Activator.getInstance()));
			}
		};
	}
	
	public ISetup getCrossReferenceProposalTestLanguageSetup() {
		return new CrossReferenceProposalTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new CrossReferenceProposalTestLanguageUiModule() {
					@Override
					public Class<? extends ContentAssistContext.Factory> bindContentAssistContext$Factory() {
						return DefaultContentAssistContextFactory.class;
					}
				}, new UIPluginModule(Activator.getInstance()));
			}
		};
	}

	public ISetup getDatatypeRuleTestLanguageSetup() {
		return new DatatypeRuleTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new DatatypeRuleTestLanguageUiModule() {
					@Override
					public Class<? extends ContentAssistContext.Factory> bindContentAssistContext$Factory() {
						return DefaultContentAssistContextFactory.class;
					}
				}, new UIPluginModule(Activator.getInstance()));
			}
		};
	}

	public ISetup getLookAheadContentAssistTestLanguageSetup() {
		return new LookAheadContentAssistTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new LookAheadContentAssistTestLanguageUiModule() {
					@Override
					public Class<? extends Factory> bindContentAssistContext$Factory() {
						return DefaultContentAssistContextFactory.class;
					}
				}, new UIPluginModule(Activator.getInstance()));
			}
		};
	}
	
	public ISetup getBug286935TestLanguageSetup() {
		return new Bug286935TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new Bug286935TestLanguageUiModule() {
					@Override
					public Class<? extends Factory> bindContentAssistContext$Factory() {
						return DefaultContentAssistContextFactory.class;
					}
				}, new UIPluginModule(Activator.getInstance()));
			}
		};
	}
	
	public ISetup getBug287941TestLanguageSetup() {
		return new Bug287941TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new Bug287941TestLanguageUiModule() {
					@Override
					public Class<? extends Factory> bindContentAssistContext$Factory() {
						return DefaultContentAssistContextFactory.class;
					}
				}, new UIPluginModule(Activator.getInstance()));
			}
		};
	}
	
	public ISetup getBug288734TestLanguageSetup() {
		return new Bug288734TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new Bug288734TestLanguageUiModule() {
					@Override
					public Class<? extends Factory> bindContentAssistContext$Factory() {
						return DefaultContentAssistContextFactory.class;
					}
				}, new UIPluginModule(Activator.getInstance()));
			}
		};
	}

}