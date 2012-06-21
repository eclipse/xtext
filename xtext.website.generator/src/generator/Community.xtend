package generator

class Community extends AbstractWebsite {

	override path() {
		'community.html'
	}
	
	override contents() '''
	<div id="header_wrapper" class="container" >
		<div class="inner">
			<div class="container">
				<div class="page-heading"><h1>Resources</h1></div>
			</div>
		</div>
	</div>
		<div id="page">
			<div id="team" class="container clearfix"> 
				<h2>Resources</h2>
		        <hr>
				«entry('''
						icon_forum.png
					''','''
						Got Questions?
					''','''
						http://www.eclipse.org/forums/index.php?t=thread&frm_id=27
					''','''
						<p>The <strong>Xtext forum</strong> is the first source for getting answers in case you got stuck.
						The community is very friendly. 
						<br>Please ask any questions clearly and with sufficient information attached.</p>
					''')»
				«entry('''
						icon_bugzilla.png
					''','''
						Found a Bug?
					''','''
						https://bugs.eclipse.org/bugs/buglist.cgi?query_format=advanced&short_desc_type=allwordssubstr&short_desc=&classification=Modeling&product=TMF&component=Xtext&long_desc_type=allwordssubstr&long_desc=&bug_file_loc_type=allwordssubstr&bug_file_loc=&status_whiteboard_type=allwordssubstr&status_whiteboard=&keywords_type=allwords&keywords=&bug_status=NEW&bug_status=ASSIGNED&bug_status=REOPENED&emailtype1=exact&email1=&emailtype2=substring&email2=&bugidtype=include&bug_id=&votes=&chfieldfrom=&chfieldto=Now&chfieldvalue=&cmdtype=doit&order=Reuse+same+sort+as+last+time&field0-0-0=noop&type0-0-0=noop&value0-0-0=
					''','''
						<p>Bug reports and enhancement request are tracked at <strong>bugs.eclipse.org</strong>. Please 
						explain the problem and provide a reduced but reproducable eample.
						Also please explain the concrete use case when requesting enhancements.</p>
					''')»
				«entry('''
						icon_twitter.png
					''','''
						Xtext on Twitter
					''','''
						http://www.eclipse.org/forums/index.php?t=thread&frm_id=27
					''','''
						<p>If you are on twitter and want to get notified about all things Xtext, you should consider following <strong>@Xtext</strong>.</p>
					''')»
				«entry('''
						icon_prof_support.png
					''','''
						Professional Support
					''','''
						http://xtext.itemis.com
					''','''
						<p>Need training, problem solving, a prototype, or just a top-notch IDE for your language? 
						<br><strong>itemis</strong> offers all kinds of professional consulting around Xtext.</p>
					''')»
			</div>
			<br/><br/>
  	  «zoo»
		</div>
	'''
	
	def entry(String img, String title, String link, String description) '''
		<div class="row">
			<div class="span1">&nbsp;</div>
			<div class="span9 team">
		    <a href="«link.trim»" class="anchor-in-div"></a>
		    <div class="row">
			  <div class="span1 ">
			    <img src="images/«img.trim»" alt="image" class="image_left">
			  </div>
			  <div class="span2 ">
			    <h3>«title.trim»</h3>
			 	</div>
				<div class="span6 ">
					«description»
				</div>
				</div>
			</div>
		  <div class="span1">&nbsp;</div>
		</div>
	'''
	
	def zoo() '''
    <div id="zoo" class="container"> 
        <h2>What others have built with Xtext</h2>
        <hr>
    <div class="row">
      <div class="span1">&nbsp;</div>
      <div class="span9">
    <table class="table table-striped table-condensed">
      <thead>
      <tr>
        <th>Name</th>
        <th>Description</th>
        <th>License</th>
        <th>Category</th>
        <th>Xtext&nbsp;v.</th>
        <th>Author(s)</th>
      </tr></thead>
      <tbody>
      
      <tr>
        <td><a href="http://applause.github.com/">APPlause</a></td>
        <td>Open source tool chain to produce native apps for different
    devices such as Android, iPhone and iPad.</td>
        <td>EPL</td>
        <td>Language, Framework</td>
        <td>1.x</td>
        <td>Heiko Behrens, Peter Friese, et al</td>
      </tr>
      
      <tr>
        <td><a href="http://code.google.com/p/alloy4eclipse/">alloy4eclipse</a></td>
        <td>Specification and analysis of models in the Alloy4 language on
    the Eclipse platform.</td>
        <td>LGPL</td>
        <td>Language</td>
        <td>?</td>
        <td>Mohamed Bouragba, Mohamed Said, Maxime Kapusta and Yoann Vasseur</td>
      </tr>
      <tr>
        <td><a href="http://aranea.origo.ethz.ch">Aranea</a></td>
        <td>Messaging and infrastructure layer that uses Xtext for generating the message
    and support classes.</td>
        <td>MIT</td>
        <td>Framework</td>
        <td>1.x</td>
        <td>Patrick Ruckstuhl</td>
      </tr>
      <tr>
        <td><a href="http://www.artop.org/">ARText (part&nbsp;of&nbsp;Artop)</a></td>
        <td>ARText, a textual language for the specification of AUTOSAR
    systems. See the <a href="http://vimeo.com/16768196">very</a> <a href="http://vimeo.com/13154188">cool</a> <a href="http://vimeo.com/12080038">screencasts</a>.</td>
        <td>closed&nbsp;source</td>
        <td>Language</td>
        <td>1.x</td>
        <td>Sebastian Benz, Dana Wong</td>
      </tr>
        <tr>
        <td><a href="http://new.axdt.org">Axdt</a></td>
        <td>ActionScript3 development tools. It uses Mirror resources to
    integrate declarations parsed from html and xml ActionScript Docs similar to
    the Xtext Java integration.</td>
        <td>EPL</td>
        <td>Language</td>
        <td>1.x</td>
        <td>Martin Schnabel</td>
      </tr>
      <tr>
         <td><a href="http://businessAppTester.com">BusinessAppTester</a></td>
         <td>
           Allows you to reuse JUnit test classes by seperating the data from the
    unit implementation class. Uses Xtext to define test class specific domain
    models.
         </td>
         <td>EPL</td>
         <td>Testing, Framework</td>
         <td>1.x</td>
         <td>Florian Pirchner, Ekkehard Gentz</td>
     </tr>
       <tr>
         <td><a href="http://www.canappi.com">Canappi</a></td>
         <td>
           Canappi is a Development Hub, focusing on Mobile Application Development, that
    integrates tools, mobile platforms, libraries and back-end services. It is
    based on mdsl, a very compact mobile domain specific language. Platform
    specific code generation happens in on the ClougGen.org platform.
         </td>
         <td>Commercial</td>
         <td>Language</td>
         <td>2.x</td>
         <td>Jean-Jacques Dubray</td>
     </tr>
     <tr>
          <td><a href="http://code.google.com/p/dom3editor/">dom3editor</a></td>
          <td>
                This is a tool to help edit Dominions 3 mod files. It includes
    context coloring, code completion, error checking and integrated help. You can
    edit using the text editor or the form based entry view.
          </td>
          <td>GPL</td>
          <td>Language</td>
          <td>2.x</td>
          <td>Larry Moore</td>
     </tr>
     <tr>
        <td><a href="http://marketplace.eclipse.org/content/graphviz-dot-zest-dot4zest">DOT for Zest</a></td>
        <td>A Graphviz-compatible DSL for the Eclipse Visualization Toolkit</td>
        <td>EPL</td>
        <td>Language, Framework</td>
        <td>1.x</td>
        <td>Fabian Steeg, Michael Clay</td>
      </tr>
      <tr>
        <td><a href="https://github.com/dslmeinte/Xtext2-DSLs">dslmeinte's example DSLs</a></td>
        <td>Various DSLs for technical domains (data modeling, dynamic screens, XSDs,
    WSDLs)</td>
        <td>MIT license</td>
        <td>examples</td>
        <td>2.0.x</td>
        <td><a href="http://www.dslconsultancy.com/">Meinte Boersma</a></td>
        <td>
      </td></tr>
        <tr>
        <td><a href="http://code.google.com/p/emf-customizer/">EMF&nbsp;Customizer</a></td>
        <td>EMF Customizer is a model (Ecore based)
    customization/styling/refining CSS like textual DSL (Domain Specific Language)
    targeting MDSD tool chains end users. </td>
        <td>EPL</td>
        <td>Language</td>
        <td>1.x</td>
        <td>Cedric Vidal</td>
      </tr>
        <tr>
        <td><a href="http://code.google.com/a/eclipselabs.org/p/emf-scaffolding/">EMF&nbsp;Scaffolding</a></td>
        <td>Implementation of the principle of dynamic inplace scaffolding
    with EMF presented in July 2009 <a href="http://www.slideshare.net/cedric.vidal/rmll-eclipse-acceleo-day-mdsd-scaffolding-and-acceleo-cdric-vidal-11">at Eclipse Acceleo Day</a>.
    </td>
        <td>EPL</td>
        <td>Language, Framework</td>
        <td>1.x</td>
        <td>Cedric Vidal and Jerome Benois</td>
      </tr>
        <tr>
        <td><a href="http://www.eclipse.org/modeling/emft/b3/">Eclipse b3</a></td>
        <td>new generation of Eclipse technology to simplify software build
    and assembly.</td>
        <td>EPL</td>
        <td>Language</td>
        <td>1.x</td>
        <td>Henrik Lindberg</td>
      </tr>
      <tr>
          <td><a href="http://elysium.thsoft.hu">Elysium</a></td>
          <td>LilyPond IDE for Eclipse</td>
          <td>EPL</td>
          <td>Language</td>
          <td>2.x</td>
          <td>Denes Harmath</td>
      </tr>
      <tr>
        <td><a href="http://www.eclipse.org/etrice/">eTrice</a></td>
        <td>eTrice is a Modeling Tool for distributed eventdriven realtime systems based on
    Realtime Object Oriented Modeling (ROOM), not UML. Textual and graphical ROOM
    editors editors and codegenerators and runtime libraries for Java, C++ and C
    will be provided.</td>
        <td>EPL</td>
        <td>Language, Framework</td>
        <td>1.x</td>
        <td>Henrik Rentz-Reichert, Thomas Schuetz</td>
      </tr>
        <tr>
        <td><a href="http://sculptor.fornax-platform.org">Fornax Sculptor</a></td>
        <td>You express your design intent in a textual DSL, from which
    Sculptor generates high quality Java code and configuration.</td>
        <td>Apache 2 License</td>
        <td>Language, Framework</td>
        <td>0.7.x, 1.x</td>
        <td>Patrik Nordwall and others</td>
      </tr>
      <tr>
        <td><a href="http://fj-eclipse.sourceforge.net/">fj-eclipse</a></td>
        <td>an Eclipse-based IDE for Featherweight Java, implemented using Xtext.</td>
        <td>GPL</td>
        <td>Language</td>
        <td>1.x</td>
        <td>Lorenzo Bettini</td>
      </tr>
        <tr>
       <td><a href="https://github.com/cloudsmith/geppetto">Geppetto</a></td>
       <td>Integrated development environment for the Puppet System Admin tools. (The
      PP manifest
                language is Ruby like).</td>
       <td>EPL, Apache</td>
          <td>Language</td>
       <td>2.x</td>
       <td>Henrik Lindberg, Cloudsmith Inc.</td>
      </tr>
      <tr>
          <td><a href="http://www.jolie-lang.org/joliepse.php">Joliepse
    IDE</a></td>
          <td>Joliepse is an Integrated Development Environment (IDE) for the JOLIE
    programming language, the first full-fledged programming language based upon
    the service-oriented programming paradigm
    and support classes.</td>
          <td>GPL</td>
          <td>Language</td>
          <td>1.x</td>
          <td>Diego Castronuovo (castronu at gmail dot com)</td>
      </tr>
      <tr>
        <td><a href="http://rtsys.informatik.uni-kiel.de/~kieler">KIELER</a></td>
        <td>an evaluation platform for new methods in model-based software
    design (automatic layout, graphic/ textual dynamic views, focus and context,
    simulation, codegen,...)</td>
        <td>EPL</td>
        <td>Language</td>
        <td>1.x</td>
        <td>Rtsys group, Dep. of Computer Science, Uni Kiel</td>
      </tr>
        <tr>
        <td><a href="http://code.google.com/p/llvm4e/">LLVM4e</a></td>
        <td>Xtext based Eclipse editor for LLVM (Low Level Virtual Machine)
    Assembly Language *.ll files</td>
        <td>EPL</td>
        <td>Language</td>
        <td>1.x</td>
        <td>Cedric Vidal</td>
      </tr>
      <tr>
          <td><a href="http://mads.sourceforge.net">MADS</a></td>
          <td>
           MADS (Multipurpose Agricultural Data System) is a free open-source tool
    for modelling and analysis of agricultural activities - crops, livestock,
    forestry and others - in developing countries, at sector, regional or project
    level. .
          </td>
          <td>EPL, GPL</td>
          <td>RCP application</td>
          <td>2.0.1</td>
          <td>Michel Simeon</td>
      </tr>
      <tr>
        <td><a href="http://www.mod4j.org/">mod4j</a></td>
        <td>open source DSL-based environment for developing administrative
    enterprise applications</td>
        <td>EPL</td>
        <td>Language, Framework</td>
        <td>1.x</td>
        <td>Jos Warmer</td>
      </tr>
      <tr>
       <td><a href="http://metrikforge.informatik.hu-berlin.de/projects/nanoworkbench/">NanoWorkbench</a>
       </td>
       <td>A Domain-specific Workbench (DSM) for the development of optical
    nanostructures. Especially used for the description of simulations and
    experiments.
       </td>
       <td>GPL</td>
       <td>language, documentation</td>
          <td>1.x</td>
          <td>Siamak Haschemi (haschemi@informatik.hu-berlin.de), Martin Schmidt
     (schmidma@informatik.hu-berlin.de), Arif Wider
    (wider@informatik.hu-berlin.de)</td>
      </tr>
    <tr>
          <td><a href="http://code.google.com/a/eclipselabs.org/p/nusmv-tools/">nusmv-tools</a></td>
          <td>The nusmv-tools project provides a set of tools for the model checker
    <a href="http://nusmv.fbk.eu/">NuSMV</a>. Xtext is used to create an Eclipse
    editor for the NuSMV input language. The editor is further enhanced by static
    analysis checks (shown as Eclipse error markers) performed by an OSGi-fied
    version of NuSMV itself. Watch the <a href="http://vimeo.com/21637768">screencast</a>.
          </td>
          <td>EPL</td>
          <td>Language</td>
          <td>1.x</td>
          <td><a href="mailto://siamak@haschemi.org">Siamak Haschemi</a></td>
      </tr>
      <tr>
          <td><a href="http://wiki.eclipse.org/MDT/OCL">OCL</a></td>
          <td>Editors for OCL expressions, documents, libraries. Standalone or
    embedded in Ecore.</td>
          <td>EPL</td>
          <td>Language</td>
          <td>2.x</td>
          <td>Ed Willink</td>
      </tr>
      <tr>
         <td><a href="http://www.gentleware.com/poseidon-for-dsls.html">Poseidon for DSLs</a></td>
         <td>Framework for creating graphical tools for DSLs, based on internal
    Xtext models. Poseidon for UML 8.0 as a sample DSL platform
         </td>
         <td>commercial</td>
         <td>Framework</td>
         <td>1.x</td>
         <td>Gentleware AG</td>
     </tr>
       <tr>
        <td><a href="http://code.google.com/p/protobuf4e/">protobuf4e</a></td>
        <td>Editor for Google's Protocol Buffers data interchange file
    format. </td>
        <td>EPL</td>
        <td>Language</td>
        <td>1.x</td>
        <td>Cedric Vidal</td>
      </tr>
        <tr>
        <td><a href="http://sourceforge.net/projects/rng-eclipse/">RELAX NG for Eclipse</a></td>
        <td>Provides support for editing RELAX NG documents in the Eclipse
    IDE. Integrates with standard WST XML editor to provide content completion and
    validation of edited XML file based on it's RELAX NG schema.</td>
        <td>EPL</td>
        <td>Language</td>
        <td>0.7.x</td>
        <td>Dave Carver</td>
      </tr>
        <tr>
        <td><a href="http://swrtj.sourceforge.net/">SWRTJ: Sugared Welterweight Record-Trait Java</a></td>
        <td>a Java-like language where units of objects' functionality are modeled by
    traits and by records (a construct that complements traits to model the state
    part of objects).</td>
        <td>GPL</td>
        <td>Language</td>
        <td>1.x</td>
        <td>Fabio Strocco, Lorenzo Bettini</td>
      </tr>
        <tr>
        <td><a href="http://sadl.sourceforge.net/">Semantic Application Design Language (SADL) Version 2</a></td>
        <td>The Semantic Application Design Language (SADL) is a language for building
    semantic models and expressing rules that capture additional domain
    knowledge. The SADL-IDE (integrated development environment) is a set of
    Eclipse plug-ins that support the editing and testing of semantic models
    using the SADL language. </td>
        <td>EPL</td>
        <td>Language</td>
        <td>1.x</td>
        <td>Andrew Crapo, John Interrante, David Bracewell, Saurabh Gupta</td>
      </tr>
      <tr>
          <td><a href="http://code.google.com/a/eclipselabs.org/p/spray/">Spray</a></td>
          <td>This project aims to provide Domain Specific Languages to describe
    Visual DSL Editors against the Graphiti runtime, and provide code generation
    (with Xtend2) to create the boilerplate code for realizing the implementation
    against the Graphiti framework.</td>
          <td>EPL 1.0</td>
          <td>Framework</td>
          <td>2.0.1</td>
          <td>Jos Warmer, Karsten Thoms et. al.</td>
      </tr>
      <tr>
          <td id="name"><a href="http://www.vclipse.org">VClipse</a></td>
          <td>VClipse is an Eclipse-based integrated development environment (IDE)
    for product modeling for the SAP Variant Configurator (VC). VClipse supports the
    specification of objects and dependencies in a textual domain specific language
    calld VCML. This enables the use of standard text comparison tools and version
    control systems in the model development process.</td>
          <td>EPL</td>
          <td>Language</td>
          <td>2.x</td>
          <td>Tim Geisler, Aleksey&nbsp;Shumilin</td>
      </tr>
      <tr>
          <td><a href="https://github.com/team-worthwhile/worthwhile">Worthwhile</a></td>
          <td>Worthwhile is an IDE built around a simple WHILE language that
    integrates editing, running, debugging and verifying programs using
    Microsoft's Z3 prover.
          </td>
          <td>3-Clause BSD</td>
          <td>Language</td>
          <td>2.x</td>
          <td>Leon Handreke, Chris Hiatt, Stefan Orf, Joachim Priesner, Fabian
    Ruch, Matthias Wagner</td>
    </tr>
      <tr>
       <td><a href="http://www.gipsys.ca/xdgl.htm">xDGL Data Generation Language</a></td>
      <td>xDGL is a free plugin on eclipse Helios 3.6 fully compatible with
    eclipse data tools platform DTP. Works with dozens of RDBMS
    databases. xDGL was invented by Abubaker Mahmoud, a Canadian Computer expert.
    xDGL is simple to learn and fast to execute and is designed to solve the problem 
    of most data generators systems works in english. xDGl works in any language that 
    could be written in the UTF-8 encoding. xDGL is the first Java Data Generation Language, 
    the first Eclipse language for Data Genration. xDGL is built in Java, Eclipse and the great Xtext
    Framework.</td>
      <td>Commercial</td>
      <td>Language</td>
      <td>1.x</td>
      <td><a href="mailto://shangab@gmail.com">Abubaker Mahmoud</a></td>
       </tr> 
       <tr>
          <td><a href="http://xsemantics.sourceforge.net/">Xsemantics</a></td>
          <td>XSemantics is a DSL (implemented in Xtext) for writing type systems,
    reduction rules, interpreters (and in general relation rules) for languages
    implemented in Xtext. It then generates Java code that can be used in your
    language implemented in Xtext for scoping and validation (it can also generate
    a validator in Java). It is the successor of XTypeS.
          </td>
          <td>EPL</td>
          <td>Language</td>
          <td>2.x</td>
          <td>Lorenzo Bettini</td>
    </tr>
    <tr>
          <td><a href="https://github.com/msbarry/Xtest">Xtest</a></td>
          <td>Xtest is a unit-testing domain-specific scripting language for Java.
    Tests are run while you type and any time a related file is saved, marking
    exceptions thrown and failed assertions as errors to immediately notify you of
    test failures.
          </td>
          <td>EPL</td>
          <td>Testing, Language</td>
          <td>2.x</td>
          <td>Michael Barry</td>
      </tr>
       <tr>
        <td><a href="http://code.google.com/a/eclipselabs.org/p/xtext-forms-integration/">Xtext Forms Integration</a></td>
        <td>Sample RCP application to demonstrate how Xtext editors can be
    integrated within Eclipse UI forms</td>
        <td>EPL</td>
        <td>Framework</td>
        <td>1.x</td>
        <td>Mikael Barbero</td>
      </tr>
       
      <tr>
        <td><a href="http://code.google.com/a/eclipselabs.org/p/xtext-typesystem/">Xtext Typesystem Framework</a></td>
        <td>A framework that supports the efficient implementation of typesystem
      rules for Xtext languages. Especially useful if your languages has
    expressions, statements, different (combinable) data types.</td>
        <td>EPL</td>
        <td>Framework</td>
        <td>2.x</td>
        <td><a href="mailto:voelter@acm.org">Markus Voelter</a></td>
      </tr>
      
      <tr>
          <td><a href="http://xtypes.sourceforge.net/">XTypeS</a></td>
          <td>a DSL for writing type systems for languages implemented in Xtext. It
    then generates Java code that can be used in your language implemented in Xtext
    for scoping and validation (XTypeS also generates a validator in Java).
          </td>
          <td>GPL</td>
          <td>Language</td>
          <td>1.x</td>
          <td>Lorenzo Bettini</td>
      </tr>
      <tr>
          <td><a href="http://www.yakindu.org">Yakindu Statechart Tools</a></td>
          <td>
            YAKINDU Statechart Tools (SCT) provides an integrated modeling
    environment for the specification and development of reactive, event-driven
    systems based on the concept of statecharts. It is an easy to use tool that
    features sophisticated graphical state chart editing, validation and simulation
    of statecharts as well as code generation.
          </td>
          <td>EPL</td>
          <td>Tool</td>
          <td>2.0.X</td>
          <td>Axel Terfloth, Andreas M&uuml;lder, et al</td>
      </tr>
     <!-- 
      <tr>
        <td>AMP Agent Modeling Platform</td>
        <td>extensible frameworks and exemplary tools for representing,
    editing, generating, executing and visualizing agent-based models (ABMs) and
    any other domain requiring spatial, behavioral and functional features</td>
        <td>http://www.eclipse.org/amp/</td>
        <td>EPL</td>
        <td>Framework</td>
        <td>1.0.0</td>
        <td>Metascape, LLC</td>
      </tr>
      
      <tr>
        <td>EMF Query 2</td>
        <td>search and retrieval of emf model elements in a structured
    format with an additional advantage that resource loading is minimized during
    execution </td>
        <td>http://www.eclipse.org/modeling/emf/?project=query2</td>
        <td>EPL</td>
        <td>Language</td>
        <td>0.7.x</td>
        <td>?</td>
      </tr>
      
      <tr>
        <td>CamelSplit</td>
        <td>Text-based DSL Editor for Camel and Eclipse</td>
        <td>http://code.google.com/p/camel-extra/wiki/CamelSpit</td>
        <td>?</td>
        <td>Language</td>
        <td>?</td>
        <td>Oisin Hurley</td>
      </tr>
    -->
      
    </tbody><tfoot></tfoot></table>
      </div>
      <div class="span1">&nbsp;</div>
    </div>
    </div>
	'''
}