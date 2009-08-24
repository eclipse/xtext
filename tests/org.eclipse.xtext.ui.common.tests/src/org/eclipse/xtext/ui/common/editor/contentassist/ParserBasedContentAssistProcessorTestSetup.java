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
import org.eclipse.xtext.contentassist.antlr.XtextGrammarTestLanguageParser;
import org.eclipse.xtext.enumrules.EnumRulesTestLanguageStandaloneSetup;
import org.eclipse.xtext.enumrules.EnumRulesTestLanguageUiModule;
import org.eclipse.xtext.enumrules.contentassist.antlr.EnumRulesTestLanguageParser;
import org.eclipse.xtext.parser.keywords.KeywordsTestLanguageStandaloneSetup;
import org.eclipse.xtext.parser.keywords.KeywordsTestLanguageUiModule;
import org.eclipse.xtext.parser.keywords.contentassist.antlr.KeywordsTestLanguageParser;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguageUiModule;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageUiModule;
import org.eclipse.xtext.testlanguages.contentassist.antlr.ContentAssistTestLanguageParser;
import org.eclipse.xtext.testlanguages.contentassist.antlr.ReferenceGrammarTestLanguageParser;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.ParserBasedContentAssistContextFactory;
import org.eclipse.xtext.ui.common.editor.contentassist.contentassist.antlr.Bug286935TestLanguageParser;
import org.eclipse.xtext.ui.common.editor.contentassist.contentassist.antlr.ContentAssistContextTestLanguageParser;
import org.eclipse.xtext.ui.common.editor.contentassist.contentassist.antlr.CrossReferenceProposalTestLanguageParser;
import org.eclipse.xtext.ui.common.editor.contentassist.contentassist.antlr.DatatypeRuleTestLanguageParser;
import org.eclipse.xtext.ui.common.editor.contentassist.contentassist.antlr.LookAheadContentAssistTestLanguageParser;
import org.eclipse.xtext.ui.common.service.UIPluginModule;
import org.eclipse.xtext.ui.common.tests.Activator;
import org.eclipse.xtext.ui.core.SimpleLabelProvider;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext.Factory;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserBasedContentAssistProcessorTestSetup implements IContentAssistProcessorTestSetup {

	public ISetup getRefGrammarSetup() {
		return new ReferenceGrammarTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ReferenceGrammarTestLanguageUiModule() {
					@Override
					public Class<? extends Factory> bindContentAssistContext$Factory() {
						return ParserBasedContentAssistContextFactory.class;
					}

					@Override
					public Class<? extends IContentAssistParser> bindIContentAssistParser() {
						return ReferenceGrammarTestLanguageParser.class;
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
					public Class<? extends Factory> bindContentAssistContext$Factory() {
						return ParserBasedContentAssistContextFactory.class;
					}

					@Override
					public Class<? extends IContentAssistParser> bindIContentAssistParser() {
						return XtextGrammarTestLanguageParser.class;
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
					public Class<? extends Factory> bindContentAssistContext$Factory() {
						return ParserBasedContentAssistContextFactory.class;
					}

					@Override
					public Class<? extends IContentAssistParser> bindIContentAssistParser() {
						return org.eclipse.xtext.contentassist.antlr.XtextParser.class;
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
					public Class<? extends Factory> bindContentAssistContext$Factory() {
						return ParserBasedContentAssistContextFactory.class;
					}

					@Override
					public Class<? extends IContentAssistParser> bindIContentAssistParser() {
						return ContentAssistTestLanguageParser.class;
					}
				}, new UIPluginModule(Activator.getInstance()));
			}
		};
	}

	public ISetup getKeywordsLangSetup() {
		return new KeywordsTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new KeywordsTestLanguageUiModule() {
					@Override
					public Class<? extends Factory> bindContentAssistContext$Factory() {
						return ParserBasedContentAssistContextFactory.class;
					}

					@Override
					public Class<? extends IContentAssistParser> bindIContentAssistParser() {
						return KeywordsTestLanguageParser.class;
					}
				}, new UIPluginModule(Activator.getInstance()));
			}
		};
	}

	public ISetup getEnumsLangSetup() {
		return new EnumRulesTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new EnumRulesTestLanguageUiModule() {
					@Override
					public Class<? extends Factory> bindContentAssistContext$Factory() {
						return ParserBasedContentAssistContextFactory.class;
					}

					@Override
					public Class<? extends IContentAssistParser> bindIContentAssistParser() {
						return EnumRulesTestLanguageParser.class;
					}
				}, new UIPluginModule(Activator.getInstance()));
			}
		};
	}

	public ISetup getContentAssistContextTestLanguageSetup() {
		return new ContentAssistContextTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ContentAssistContextTestLanguageUiModule() {
					@Override
					public Class<? extends Factory> bindContentAssistContext$Factory() {
						return ParserBasedContentAssistContextFactory.class;
					}

					@Override
					public Class<? extends IContentAssistParser> bindIContentAssistParser() {
						return ContentAssistContextTestLanguageParser.class;
					}
				}, new UIPluginModule(Activator.getInstance()));
			}
		};
	}
	
	public ISetup getCrossReferenceProposalTestLanguageSetup() {
		return new CrossReferenceProposalTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new CrossReferenceProposalTestLanguageUiModule() {
					@Override
					public Class<? extends Factory> bindContentAssistContext$Factory() {
						return ParserBasedContentAssistContextFactory.class;
					}

					@Override
					public Class<? extends IContentAssistParser> bindIContentAssistParser() {
						return CrossReferenceProposalTestLanguageParser.class;
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
					public Class<? extends Factory> bindContentAssistContext$Factory() {
						return ParserBasedContentAssistContextFactory.class;
					}

					@Override
					public Class<? extends IContentAssistParser> bindIContentAssistParser() {
						return DatatypeRuleTestLanguageParser.class;
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
						return ParserBasedContentAssistContextFactory.class;
					}

					@Override
					public Class<? extends IContentAssistParser> bindIContentAssistParser() {
						return LookAheadContentAssistTestLanguageParser.class;
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
						return ParserBasedContentAssistContextFactory.class;
					}
					@Override
					public Class<? extends IContentAssistParser> bindIContentAssistParser() {
						return Bug286935TestLanguageParser.class;
					}
				}, new UIPluginModule(Activator.getInstance()));
			}
		};
	}

}