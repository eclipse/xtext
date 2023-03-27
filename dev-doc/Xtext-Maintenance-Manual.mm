<map version="freeplane 1.8.0">
<!--To view this file, download free mind mapping software Freeplane from http://freeplane.sourceforge.net -->
<node TEXT="Xtext Maintenance Manual" FOLDED="false" ID="ID_1857109782" CREATED="1611832872116" MODIFIED="1611832899670" STYLE="oval">
<font SIZE="18"/>
<hook NAME="MapStyle">
    <properties edgeColorConfiguration="#808080ff,#ff0000ff,#0000ffff,#00ff00ff,#ff00ffff,#00ffffff,#7c0000ff,#00007cff,#007c00ff,#7c007cff,#007c7cff,#7c7c00ff" fit_to_viewport="false"/>

<map_styles>
<stylenode LOCALIZED_TEXT="styles.root_node" STYLE="oval" UNIFORM_SHAPE="true" VGAP_QUANTITY="24.0 pt">
<font SIZE="24"/>
<stylenode LOCALIZED_TEXT="styles.predefined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="default" ICON_SIZE="12.0 pt" COLOR="#000000" STYLE="fork">
<font NAME="SansSerif" SIZE="10" BOLD="false" ITALIC="false"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.details"/>
<stylenode LOCALIZED_TEXT="defaultstyle.attributes">
<font SIZE="9"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.note" COLOR="#000000" BACKGROUND_COLOR="#ffffff" TEXT_ALIGN="LEFT"/>
<stylenode LOCALIZED_TEXT="defaultstyle.floating">
<edge STYLE="hide_edge"/>
<cloud COLOR="#f0f0f0" SHAPE="ROUND_RECT"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.user-defined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="styles.topic" COLOR="#18898b" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subtopic" COLOR="#cc3300" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subsubtopic" COLOR="#669900">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.important">
<icon BUILTIN="yes"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.AutomaticLayout" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="AutomaticLayout.level.root" COLOR="#000000" STYLE="oval" SHAPE_HORIZONTAL_MARGIN="10.0 pt" SHAPE_VERTICAL_MARGIN="10.0 pt">
<font SIZE="18"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,1" COLOR="#0033ff">
<font SIZE="16"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,2" COLOR="#00b439">
<font SIZE="14"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,3" COLOR="#990000">
<font SIZE="12"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,4" COLOR="#111111">
<font SIZE="10"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,5"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,6"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,7"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,8"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,9"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,10"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,11"/>
</stylenode>
</stylenode>
</map_styles>
</hook>
<hook NAME="AutomaticEdgeColor" COUNTER="11" RULE="ON_BRANCH_CREATION"/>
<node TEXT="Tasks per Release" POSITION="right" ID="ID_763576794" CREATED="1611837840795" MODIFIED="1611837890362">
<edge COLOR="#ff0000"/>
<node TEXT="Create Simrel Tasks Github Issue&#xa;https://github.com/eclipse/xtext/issues/1889" ID="ID_101290917" CREATED="1611838221627" MODIFIED="1611840117064">
<node TEXT="Version Bump for next relase" ID="ID_77611227" CREATED="1611838244554" MODIFIED="1611838379806"/>
<node TEXT="Bootstrap against Last release" ID="ID_178312350" CREATED="1611838383046" MODIFIED="1611838395781"/>
<node TEXT="Update Oomph" ID="ID_1287907680" CREATED="1611838399456" MODIFIED="1611838404451"/>
<node TEXT="Update Orbit" ID="ID_1888149457" CREATED="1611838406924" MODIFIED="1611838410287"/>
<node TEXT="Update API Diff Job" ID="ID_266680691" CREATED="1611838413367" MODIFIED="1611838420141"/>
<node TEXT="Update Reference Projects" ID="ID_254952600" CREATED="1611838424016" MODIFIED="1611838433641">
<node TEXT="use final in old release" ID="ID_1670552193" CREATED="1611845952569" MODIFIED="1611845962484"/>
<node TEXT="create new release" ID="ID_27520640" CREATED="1611845963749" MODIFIED="1611845969205"/>
</node>
<node TEXT="use platform i-build /xxxx-xx repos in latest" ID="ID_562700332" CREATED="1611838438715" MODIFIED="1611838454913"/>
<node TEXT="create target for the last release e.g. 2020-12" ID="ID_611638730" CREATED="1611838458826" MODIFIED="1611845985689"/>
<node TEXT="create release notes" ID="ID_115257899" CREATED="1611838470902" MODIFIED="1611838476258"/>
<node TEXT="Adapt version numbers in docs" ID="ID_1902508582" CREATED="1611838479467" MODIFIED="1611838485604"/>
<node TEXT="(Release review)" ID="ID_1740105005" CREATED="1611838610434" MODIFIED="1611838621459"/>
</node>
<node TEXT="Aggrcon" ID="ID_904220871" CREATED="1611838644216" MODIFIED="1611838648837">
<node TEXT="Enter new Release" ID="ID_1206249120" CREATED="1611838650785" MODIFIED="1611838655541"/>
<node TEXT="Touch MWE and Xpand" ID="ID_1556001334" CREATED="1611838656696" MODIFIED="1611838662217"/>
</node>
<node TEXT="Marketplace" ID="ID_188066588" CREATED="1611839280696" MODIFIED="1611839284734"/>
<node TEXT="Release Record" ID="ID_1757610781" CREATED="1611839407388" MODIFIED="1611839434601">
<node TEXT="https://projects.eclipse.org/projects/modeling.tmf.xtext/governance" ID="ID_1570275255" CREATED="1611839435935" MODIFIED="1611839437151"/>
<node TEXT="https://projects.eclipse.org/projects/modeling.emf.mwe/governance" ID="ID_1034855226" CREATED="1611839450124" MODIFIED="1611839451116"/>
</node>
<node TEXT="how to Build milestones &amp; releases" ID="ID_364871681" CREATED="1611839702627" MODIFIED="1611839712645">
<node TEXT="https://github.com/eclipse/xtext/blob/master/Builds.md" ID="ID_1595910260" CREATED="1611839728394" MODIFIED="1611839729447"/>
</node>
<node TEXT="https://github.com/eclipse/xtext/blob/master/dev-doc/MaintenanceTasks.md" ID="ID_1801950597" CREATED="1611839781977" MODIFIED="1611839784467"/>
<node TEXT="Version handling in issues" ID="ID_993084427" CREATED="1611839872324" MODIFIED="1611839884400">
<node TEXT="Close old milestones" ID="ID_1470744382" CREATED="1611839886050" MODIFIED="1611839893776"/>
<node TEXT="create new milestones" ID="ID_526818668" CREATED="1611839895183" MODIFIED="1611839901381"/>
<node TEXT="Adapt queries in Readme.md in xtext repo" ID="ID_1307222284" CREATED="1611839902746" MODIFIED="1611839914581"/>
</node>
</node>
<node TEXT="Tasks per Jahr" POSITION="left" ID="ID_1799593358" CREATED="1611837860256" MODIFIED="1611837867007">
<edge COLOR="#0000ff"/>
<node TEXT="Release Review" ID="ID_1658997896" CREATED="1611838623544" MODIFIED="1611838634209">
<node TEXT="Xtext" ID="ID_595090452" CREATED="1611838637104" MODIFIED="1611838638696"/>
<node TEXT="MWE" ID="ID_722460346" CREATED="1611838639805" MODIFIED="1611838641200"/>
<node TEXT="Steps https://github.com/eclipse/xtext/issues/1890" ID="ID_509845310" CREATED="1611839401120" MODIFIED="1611839530153">
<node TEXT="Schedule Review from Governance page" ID="ID_1484835343" CREATED="1611839404538" MODIFIED="1611839465515"/>
<node TEXT="Mail to PMC" ID="ID_1662030238" CREATED="1611839467330" MODIFIED="1611839472296"/>
<node TEXT="IP Log" ID="ID_1428795778" CREATED="1611839473481" MODIFIED="1611839476123"/>
<node TEXT="Actual Review" ID="ID_1127189669" CREATED="1611839498846" MODIFIED="1611839502056"/>
</node>
</node>
</node>
<node TEXT="Tasks per Milestone" POSITION="right" ID="ID_308962131" CREATED="1611837868360" MODIFIED="1611837884767">
<edge COLOR="#00ff00"/>
<node TEXT="Bootstrap against Milestone on master" ID="ID_1250772327" CREATED="1611838666954" MODIFIED="1611838676330"/>
<node TEXT="Adjust aggrcon" ID="ID_124810291" CREATED="1611838678145" MODIFIED="1611838688617"/>
</node>
<node TEXT="Wo findet sich welcher Code" POSITION="left" ID="ID_681259619" CREATED="1611837897862" MODIFIED="1611837905997">
<edge COLOR="#ff00ff"/>
<node TEXT="Sourcecode" ID="ID_53623953" CREATED="1611838708041" MODIFIED="1611839315301">
<node TEXT="Xtext" ID="ID_956015393" CREATED="1611838722321" MODIFIED="1611838799858">
<node TEXT="lib https://github.com/eclipse/xtext-lib/" ID="ID_990472333" CREATED="1611838879406" MODIFIED="1611838885753"/>
<node TEXT="core https://github.com/eclipse/xtext-core/" ID="ID_644516524" CREATED="1611838889846" MODIFIED="1611838894798"/>
<node TEXT="extras https://github.com/eclipse/xtext-extras/" ID="ID_1161616066" CREATED="1611838896074" MODIFIED="1611838901924"/>
<node TEXT="eclipse https://github.com/eclipse/xtext-eclipse/" ID="ID_1857671188" CREATED="1611838903331" MODIFIED="1611838919337"/>
<node TEXT="web https://github.com/eclipse/xtext-web/" ID="ID_540698892" CREATED="1611838920748" MODIFIED="1611838925412"/>
<node TEXT="maven https://github.com/eclipse/xtext-maven/" ID="ID_71412826" CREATED="1611838926551" MODIFIED="1611838932104"/>
<node TEXT="P2 Repo &amp; Jenkins files https://github.com/eclipse/xtext-umbrella/" ID="ID_1569289353" CREATED="1611838940113" MODIFIED="1611838957933"/>
<node TEXT="xtend https://github.com/eclipse/xtext-xtend/" ID="ID_673015587" CREATED="1611838971809" MODIFIED="1611838976173"/>
</node>
<node TEXT="Tests" ID="ID_1622118516" CREATED="1611838725771" MODIFIED="1611838728052">
<node TEXT="Reference Projects https://github.com/itemis/xtext-reference-projects" ID="ID_1804431080" CREATED="1611839065320" MODIFIED="1611839070195">
<node TEXT="travis" ID="ID_1173696742" CREATED="1611841863503" MODIFIED="1611841865695"/>
<node TEXT="github actions" ID="ID_613128606" CREATED="1611841867298" MODIFIED="1611841875820"/>
</node>
<node TEXT="LSP Example https://github.com/itemis/xtext-languageserver-example" ID="ID_286011453" CREATED="1611839072027" MODIFIED="1611839085526"/>
<node TEXT="More Examples" ID="ID_159015541" CREATED="1611839153268" MODIFIED="1611839157273">
<node TEXT="https://github.com/xtext/seven-languages-xtext" ID="ID_1101867913" CREATED="1611839158669" MODIFIED="1611839159703"/>
<node TEXT="https://github.com/xtext/maven-xtext-example" ID="ID_211751669" CREATED="1611839169167" MODIFIED="1611839170403"/>
</node>
</node>
<node TEXT="(Build) Tools" ID="ID_1968704047" CREATED="1611838729491" MODIFIED="1611839097976">
<node TEXT="https://github.com/xtext/publishing" ID="ID_871247358" CREATED="1611839142903" MODIFIED="1611839144484"/>
<node TEXT="api diff https://github.com/xtext/xtext-apidiff" ID="ID_189928204" CREATED="1611839179474" MODIFIED="1611839183674"/>
<node TEXT="gradle cq helper https://github.com/xtext/gradle-wrapper-cq-helper" ID="ID_549373582" CREATED="1611839191309" MODIFIED="1611839196049">
<node TEXT="https://github.com/eclipse/xtext/blob/master/dev-doc/GradleWrapperVersionBump.md" ID="ID_870470741" CREATED="1611839748347" MODIFIED="1611839749503"/>
</node>
<node TEXT="composite for marketplace https://github.com/xtext/xtext-p2-orbit" ID="ID_1155217364" CREATED="1611839243285" MODIFIED="1611839275507"/>
<node TEXT="Simrel: ssh://&lt;user&gt;@git.eclipse.org:29418/simrel/org.eclipse.simrel.build" ID="ID_893606494" CREATED="1611840332950" MODIFIED="1611840342146"/>
</node>
<node TEXT="" ID="ID_591086714" CREATED="1611838862247" MODIFIED="1611839315301"/>
</node>
<node TEXT="Documentation" ID="ID_1775105458" CREATED="1611838713246" MODIFIED="1611838716112">
<node TEXT="docs https://github.com/eclipse/xtext" ID="ID_516745645" CREATED="1611838933948" MODIFIED="1611838938373"/>
</node>
<node TEXT="Tools" ID="ID_1551928349" CREATED="1611838717596" MODIFIED="1611838720611">
<node TEXT="MWE https://github.com/eclipse/mwe/" ID="ID_1921748167" CREATED="1611838792942" MODIFIED="1611838862069"/>
<node TEXT="Others" ID="ID_951325756" CREATED="1611838842704" MODIFIED="1611838845271">
<node TEXT="Xpect https://github.com/eclipse/xpect" ID="ID_271826130" CREATED="1611839304336" MODIFIED="1611839306918"/>
<node TEXT="LSP4J https://github.com/eclipse/lsp4j" ID="ID_817414156" CREATED="1611839322726" MODIFIED="1611839335011"/>
</node>
<node TEXT="xtext gradle plugin https://github.com/xtext/xtext-gradle-plugin" ID="ID_1345833409" CREATED="1611839220498" MODIFIED="1611839228524"/>
</node>
</node>
<node TEXT="Regular Tasks" POSITION="right" ID="ID_1377139840" CREATED="1611838487193" MODIFIED="1611838497723">
<edge COLOR="#00ffff"/>
<node TEXT="Merge Website-Published -&gt; Website-master" ID="ID_403921595" CREATED="1611838531308" MODIFIED="1611838551604"/>
<node TEXT="Regenerate docs for eclipse" ID="ID_1702854551" CREATED="1611838552729" MODIFIED="1611838574689"/>
<node TEXT="Regenerate docs for xtend" ID="ID_1110461079" CREATED="1611838575949" MODIFIED="1611838581545"/>
<node TEXT="Check for new Issues" ID="ID_1820011853" CREATED="1611839577762" MODIFIED="1611839585293">
<node TEXT="Issues in all Github Repos" ID="ID_1399032931" CREATED="1611839586853" MODIFIED="1611839592884">
<node TEXT="See queries in xtext repo" ID="ID_892155493" CREATED="1611841906703" MODIFIED="1611841915675"/>
</node>
<node TEXT="Bugzilla" ID="ID_522313396" CREATED="1611839594143" MODIFIED="1611839597097"/>
</node>
<node TEXT="Community Support" ID="ID_1238129010" CREATED="1611839600863" MODIFIED="1611839606085">
<node TEXT="Twitter" ID="ID_1123653197" CREATED="1611839607478" MODIFIED="1611839609835"/>
<node TEXT="Forum" ID="ID_1546228482" CREATED="1611839611002" MODIFIED="1611839612820"/>
<node TEXT="Stackoverflow" ID="ID_669398111" CREATED="1611839614033" MODIFIED="1611839616766"/>
</node>
<node TEXT="Regenerate Languages    https://github.com/eclipse/xtext/blob/master/dev-doc/RegenerateLanguages.md" ID="ID_398455892" CREATED="1611839793977" MODIFIED="1611839801976"/>
<node TEXT="Check for PRs" ID="ID_22509344" CREATED="1611840864248" MODIFIED="1611840869734">
<node TEXT="See queries in xtext repo" ID="ID_1690079741" CREATED="1611841921749" MODIFIED="1611841923251"/>
</node>
<node TEXT="Investiage Jenkins fails" ID="ID_1049087759" CREATED="1611840912755" MODIFIED="1611840919191"/>
<node TEXT="Run build/test on windows manually" ID="ID_2785135" CREATED="1611841710445" MODIFIED="1611841720268"/>
<node TEXT="Check examples" ID="ID_1645106992" CREATED="1611841723657" MODIFIED="1611841737467">
<node TEXT="is also part of reference-projects integ test" ID="ID_244062991" CREATED="1611845899440" MODIFIED="1611845910391"/>
</node>
<node TEXT="(update to new gradle versions)" ID="ID_831636510" CREATED="1611842256055" MODIFIED="1611842265357">
<node TEXT="this is currently our biggest technical debt" ID="ID_1617344051" CREATED="1612447572789" MODIFIED="1612447585312"/>
<node TEXT="Might be needed for Java 17" ID="ID_1674111036" CREATED="1612447622994" MODIFIED="1612447632086"/>
</node>
<node TEXT="Check &quot;check-versions&quot; jenkins job and update deps" ID="ID_1621573005" CREATED="1611842267981" MODIFIED="1611842282983">
<node TEXT="Also Check manually" ID="ID_537344514" CREATED="1612445731085" MODIFIED="1612445738680"/>
<node TEXT="Also check Wizard stuff manually" ID="ID_481392915" CREATED="1612445740430" MODIFIED="1612445747543"/>
</node>
</node>
<node TEXT="Paying Attention" POSITION="left" ID="ID_80250469" CREATED="1611838807791" MODIFIED="1611838812696">
<edge COLOR="#7c0000"/>
<node TEXT="Orbit" ID="ID_1585653342" CREATED="1611838814167" MODIFIED="1611838816472">
<node TEXT="https://accounts.eclipse.org/mailing-list/orbit-dev" ID="ID_1672848185" CREATED="1611839349456" MODIFIED="1611839350329">
<node TEXT="Guava" ID="ID_1943401128" CREATED="1611841330586" MODIFIED="1611841332822"/>
<node TEXT="Guice" ID="ID_1784652356" CREATED="1611841334591" MODIFIED="1611841338432"/>
<node TEXT="...." ID="ID_1667681243" CREATED="1611841339961" MODIFIED="1611841342047"/>
</node>
</node>
<node TEXT="Cross Project Dev Issue" ID="ID_109591865" CREATED="1611838819168" MODIFIED="1611838825416">
<node TEXT="https://accounts.eclipse.org/mailing-list/cross-project-issues-dev" ID="ID_339078804" CREATED="1611839383043" MODIFIED="1611839384258"/>
</node>
<node TEXT="LSP4J" ID="ID_1178977730" CREATED="1611838829303" MODIFIED="1611838832252">
<node TEXT="https://accounts.eclipse.org/mailing-list/lsp4j-dev" ID="ID_1945782006" CREATED="1611839361234" MODIFIED="1611839362044"/>
<node TEXT="https://github.com/eclipse/lsp4j/issues/" ID="ID_1515287944" CREATED="1611839371537" MODIFIED="1611839372304"/>
</node>
<node TEXT="Platform + JDT" ID="ID_1908888078" CREATED="1611841312841" MODIFIED="1611841321091"/>
</node>
<node TEXT="Jenkins" POSITION="right" ID="ID_228825949" CREATED="1611840138949" MODIFIED="1611840141320">
<edge COLOR="#00007c"/>
<node TEXT="https://ci.eclipse.org/xtext/" ID="ID_636230838" CREATED="1611840148670" MODIFIED="1611840149452"/>
<node TEXT="https://ci.eclipse.org/mwe/" ID="ID_180267491" CREATED="1611840160699" MODIFIED="1611840161584"/>
<node TEXT="https://ci.eclipse.org/lsp4j/" ID="ID_180687227" CREATED="1611840169150" MODIFIED="1611840169792"/>
<node TEXT="https://ci.eclipse.org/xpect/" ID="ID_1175124941" CREATED="1611840178251" MODIFIED="1611840178985"/>
</node>
<node TEXT="Builds" POSITION="left" ID="ID_719489142" CREATED="1611840259327" MODIFIED="1611840261719">
<edge COLOR="#007c00"/>
<node TEXT="Gradle" ID="ID_461899682" CREATED="1611840263362" MODIFIED="1611840265357">
<node TEXT="Lib + Core + Extras + Xtend + Web" ID="ID_192906174" CREATED="1611841353824" MODIFIED="1611841373520"/>
<node TEXT="Umbrella (Gradle Composite)" ID="ID_806271161" CREATED="1611841410374" MODIFIED="1611841420846"/>
</node>
<node TEXT="Maven" ID="ID_60478980" CREATED="1611840266858" MODIFIED="1611840269407">
<node TEXT="Maven + Xtend Maven Plugin" ID="ID_446372460" CREATED="1611841374718" MODIFIED="1611841385504"/>
</node>
<node TEXT="Maven Tycho" ID="ID_109816379" CREATED="1611840271026" MODIFIED="1611840398144">
<node TEXT="Lib + Core + Extras (P2)" ID="ID_13990761" CREATED="1611841386943" MODIFIED="1611841400580"/>
<node TEXT="Eclipse, Xtend" ID="ID_1678126711" CREATED="1611841402185" MODIFIED="1611841405366"/>
<node TEXT="Umbrella" ID="ID_546925841" CREATED="1611841406835" MODIFIED="1611841409074"/>
</node>
</node>
<node TEXT="OOmph&#xa;(Setting up dev env)" POSITION="right" ID="ID_491312962" CREATED="1611840409510" MODIFIED="1611840436856">
<edge COLOR="#7c007c"/>
<node TEXT="https://github.com/eclipse/xtext/blob/master/CONTRIBUTING.md" ID="ID_1609892282" CREATED="1611840425843" MODIFIED="1611840426717"/>
</node>
<node TEXT="Tips&amp;Tricks" POSITION="left" ID="ID_839761309" CREATED="1611840584563" MODIFIED="1611840590024">
<edge COLOR="#007c7c"/>
<node TEXT="gitAll" ID="ID_1467879089" CREATED="1611840592017" MODIFIED="1611840595767"/>
<node TEXT="adjustPipelines" ID="ID_715064790" CREATED="1611840597057" MODIFIED="1611840608985"/>
<node TEXT="locations.properties" ID="ID_20683514" CREATED="1611841430204" MODIFIED="1611841434479"/>
<node TEXT="WSL für windows" ID="ID_1286826463" CREATED="1611841438950" MODIFIED="1611841445686"/>
</node>
</node>
</map>
