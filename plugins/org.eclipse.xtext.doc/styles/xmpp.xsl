<?xml version='1.0'?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:l="http://docbook.sourceforge.net/xmlns/l10n/1.0"
    version="1.0">

  <!-- Include other stylesheets -->
  <xsl:import href="docbook.xsl"/>
  <xsl:include href="inline.xsl" />
  <xsl:include href="component.xsl" />
  <xsl:include href="inline.xsl" />
  <xsl:include href="titlepage.xsl"/>

  <xsl:param name="section.autolabel" select="'0'"/>

  <!-- Images -->
  <xsl:param name="draft.watermark.image" select="''"/>

  <!-- Enable bookmarks -->
  <xsl:param name="fop1.extensions" select="1"/>

  <!-- Do not print out URLs -->
  <xsl:param name="ulink.show" select="0"/>
  <!--<xsl:param name="show.comments" select="0"/>-->

  <!-- Page setup -->
  <xsl:param name="paper.type" select="'A4'"/>
  <!--<xsl:param name="double.sided"/>-->

  <!--<xsl:param name="header.column.widths">0 1 0</xsl:param>-->
  <!--<xsl:attribute-set name="header.content.properties">
    <xsl:attribute name="font-family">Helvetica</xsl:attribute>
    <xsl:attribute name="font-size">12pt</xsl:attribute>
    <xsl:attribute name="font-weight">bold</xsl:attribute>
  </xsl:attribute-set>-->

  <!--<xsl:attribute-set name="footer.content.properties">
    <xsl:attribute name="font-family">Helvetica</xsl:attribute>
    <xsl:attribute name="font-size">8pt</xsl:attribute>
  </xsl:attribute-set>
  <xsl:param name="footer.rule" select="0"/>-->

  <!--
  <xsl:param name="page.margin.top" select="'3.9cm'"/>
  <xsl:param name="page.margin.bottom" select="'3.9cm'"/>
  <xsl:param name="page.margin.inner" select="'4cm'"/>
  <xsl:param name="page.margin.outer" select="'4cm'"/>
  -->
  <xsl:param name="body.start.indent" select="'0'"/>
  <xsl:param name="body.margin.bottom" select="'1.2cm'"/>
  <xsl:attribute-set name="normal.para.spacing">
    <xsl:attribute name="space-before.optimum">0.4em</xsl:attribute>  
    <xsl:attribute name="space-before.minimum">0.3em</xsl:attribute>
    <xsl:attribute name="space-before.maximum">0.5em</xsl:attribute>
  </xsl:attribute-set>
  <xsl:attribute-set name="list.block.spacing">
    <xsl:attribute name="space-before.optimum">0.4em</xsl:attribute>
    <xsl:attribute name="space-before.minimum">0.3em</xsl:attribute>
    <xsl:attribute name="space-before.maximum">0.5em</xsl:attribute>
    <xsl:attribute name="space-after.optimum">0.4em</xsl:attribute>
    <xsl:attribute name="space-after.minimum">0.3em</xsl:attribute>
    <xsl:attribute name="space-after.maximum">0.5em</xsl:attribute>
  </xsl:attribute-set>
  <xsl:attribute-set name="list.item.spacing">
    <xsl:attribute name="space-before.optimum">0.4em</xsl:attribute>
    <xsl:attribute name="space-before.minimum">0.3em</xsl:attribute>
    <xsl:attribute name="space-before.maximum">0.5em</xsl:attribute>
  </xsl:attribute-set>
  <xsl:attribute-set name="verbatim.properties">
    <xsl:attribute name="space-before.minimum">0.3em</xsl:attribute>
    <xsl:attribute name="space-before.optimum">0.4em</xsl:attribute>
    <xsl:attribute name="space-before.maximum">0.5em</xsl:attribute>
    <xsl:attribute name="space-after.minimum">0.3em</xsl:attribute>
    <xsl:attribute name="space-after.optimum">0.4em</xsl:attribute>
    <xsl:attribute name="space-after.maximum">0.5em</xsl:attribute>
    <xsl:attribute name="hyphenate">false</xsl:attribute>
    <xsl:attribute name="wrap-option">no-wrap</xsl:attribute>
    <xsl:attribute name="white-space-collapse">false</xsl:attribute>
    <xsl:attribute name="white-space-treatment">preserve</xsl:attribute>
    <xsl:attribute name="linefeed-treatment">preserve</xsl:attribute>
    <xsl:attribute name="text-align">start</xsl:attribute>
    <xsl:attribute name="start-indent">10pt</xsl:attribute>
  </xsl:attribute-set>
  
  <!-- PETER -->
  <xsl:param name="title.margin.left">-3pc</xsl:param>
  <xsl:param name="section.autolabel" select="1"/>
  <xsl:attribute-set name="section.title.level1.properties"
                   use-attribute-sets="section.properties">
    <xsl:attribute name="border-bottom-style">solid</xsl:attribute>
    <xsl:attribute name="border-bottom-width">1pt</xsl:attribute>
    <xsl:attribute name="font-size">
      <xsl:value-of select="$body.font.master * 1.728"/>
      <xsl:text>pt</xsl:text>
    </xsl:attribute>
  </xsl:attribute-set>
  <xsl:attribute-set name="section.title.level2.properties">
  <xsl:attribute name="font-size">
    <xsl:value-of select="$body.font.master * 1.44"/>
    <xsl:text>pt</xsl:text>
  </xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="section.title.level3.properties">
  <xsl:attribute name="font-size">
    <xsl:value-of select="$body.font.master * 1.2"/>
    <xsl:text>pt</xsl:text>
  </xsl:attribute>
</xsl:attribute-set>

  <xsl:param name="variablelist.as.blocks" select="0"/>

  <!-- Fonts & colors -->
  <xsl:param name="body.font.master" select="10"/>
  <xsl:param name="body.font.family" select="'Birka,Gentium Basic,Times'"/>
  <xsl:param name="title.font.family" select="'Myriad Pro,Delicious,Helvetica'"/>
  <xsl:param name="monospace.font.family" select="'Inconsolata,Courier'"/>

  <xsl:attribute-set name="monospace.verbatim.properties">
    <xsl:attribute name="font-size">.8em</xsl:attribute>
    <xsl:attribute name="padding">5pt</xsl:attribute>
  </xsl:attribute-set>

  <xsl:attribute-set name="nongraphical.admonition.properties">
    <xsl:attribute name="background-color">#F0F0F0</xsl:attribute>
    <xsl:attribute name="padding">5pt</xsl:attribute>
  </xsl:attribute-set>

  <!--<xsl:param name="shade.verbatim" select="1"/>
  <xsl:attribute-set name="shade.verbatim.style">
    <xsl:attribute name="border">0</xsl:attribute>
    <xsl:attribute name="background-color">#F0F0F0</xsl:attribute>
  </xsl:attribute-set> -->

  <xsl:attribute-set name="section.title.chapter.properties">
    <xsl:attribute name="font-size">
      <xsl:value-of select="$body.font.master * 1.8"/>
      <xsl:text>pt</xsl:text>
    </xsl:attribute>
  </xsl:attribute-set>

  <xsl:attribute-set name="section.title.level1.properties">
    <xsl:attribute name="font-size">
      <xsl:value-of select="$body.font.master * 1.7"/>
      <xsl:text>pt</xsl:text>
    </xsl:attribute>
    <!--<xsl:attribute name="border-bottom">1pt solid #505050</xsl:attribute>-->
  </xsl:attribute-set>

  <xsl:attribute-set name="section.title.level2.properties">
    <xsl:attribute name="font-size">
      <xsl:value-of select="$body.font.master * 1.4"/>
      <xsl:text>pt</xsl:text>
    </xsl:attribute>
  </xsl:attribute-set>

  <!-- FIXME: Doesn't work 
  <xsl:attribute-set name="bibliography.title.properties">
    <xsl:attribute name="break-before">page</xsl:attribute>
  </xsl:attribute-set>
  -->

  <xsl:attribute-set name="toc.line.properties">
    <xsl:attribute name="font-size">10pt</xsl:attribute>
    <xsl:attribute name="font-weight">
      <xsl:choose>
        <xsl:when test="self::chapter | self::preface | self::appendix">bold</xsl:when>
        <xsl:otherwise>normal</xsl:otherwise>
      </xsl:choose>
    </xsl:attribute>
  </xsl:attribute-set>

  <xsl:param name="generate.toc">
    book      toc,title
  </xsl:param>

</xsl:stylesheet> 