#!/bin/bash 

usage ()
{
  echo "----------------------------------------------------------"
  echo "Usage   : fixVersions.sh -f <from_version> [-t <to_version>] -b <StoS|StoR|MtoR|RCtoR|BST> "
  echo "Example : fixVersions.sh -f '2.15.0' -t '2.16.0' -b StoS"
  echo "Example : fixVersions.sh -f '2.16.0.M1' -t '2.16.0' -b BST"
  echo "Example : fixVersions.sh -f '2.15.0' -b StoS"
  echo "Note: '-t' is optional, if not given it will be derived from '-f'"
  echo "Note: StoS - Snapshot version to another Snapshot version
      StoR - Snapshot version to another Release version
      MtoR - Milestone version to another Release version
      RCtoR - RC version to another Release version
      BST - BootStrap version to another version"
  echo "----------------------------------------------------------"
  exit
}

checkVersionFormat()
{
 re='^[0-9]\.[0-9]+\.[0-9].*$'
  if ! [[ $1 =~ $re ]] ; then
     echo "Error: Version is not in proper format" 
     usage
  fi
}

deriveToVersion()
{
  re='^([0-9])\.([0-9]+)\.([0-9])$'
  if [[ $from =~ $re ]]; then
    majorVersion="${BASH_REMATCH[1]}"
    minorVersion="${BASH_REMATCH[2]}"
    bugFixVersion="${BASH_REMATCH[3]}"
    to=$majorVersion.$(($minorVersion + 1)).$bugFixVersion
    echo "# to_version: $to"
  fi
}

#ToDo: not used right now
deriveFromVersion()
{
  MVNVersion=$(mvn -f ./releng/pom.xml -q -Dexec.executable=echo -Dexec.args='${project.version}' --non-recursive exec:exec)
  echo "# MVN version from pom $MVNVersion"
  from_version=`echo $MVNVersion | sed -e 's/[^0-9][^0-9]*$//'`
  echo "# Derived from_version from MVN version $from_version"
}

xargs_sed_inplace() {
	if [[ "$OSTYPE" == "darwin"* ]]; then
		xargs  sed -i '' "$@"
	else
		xargs  sed -i "$@"
	fi	
}

SnapshotToSnapshot() {
	find . -type f -name "MANIFEST.MF" | xargs_sed_inplace -e "s/${from}.qualifier/${to}.qualifier/g" 
	find . -type f -name "MANIFEST.MF" | xargs_sed_inplace -e "s/;version=\"${from}\"/;version=\"${to}\"/g"
	find . -type f -name "MANIFEST.MF" | xargs_sed_inplace -e "s/org.eclipse.xtext.xbase.lib;bundle-version=\"${from}\"/org.eclipse.xtext.xbase.lib;bundle-version=\"${to}\"/g"
	find . -type f -name "MANIFEST.MF" | xargs_sed_inplace -e "s/org.eclipse.xtend.lib;bundle-version=\"${from}\"/org.eclipse.xtend.lib;bundle-version=\"${to}\"/g"
	find . -type f -name "MANIFEST.MF_gen" | xargs_sed_inplace -e "s/${from}.qualifier/${to}.qualifier/g"
	find . -type f -name "pom.xml" | xargs_sed_inplace -e "s/${from}-SNAPSHOT/${to}-SNAPSHOT/g"
	find . -type f -name "maven-pom.xml" | xargs_sed_inplace -e "s/${from}-SNAPSHOT/${to}-SNAPSHOT/g"
	find . -type f -name "tycho-pom.xml" | xargs_sed_inplace -e "s/${from}-SNAPSHOT/${to}-SNAPSHOT/g"
	find . -type f -name "feature.xml" | xargs_sed_inplace -e "s/version=\"${from}.qualifier\"/version=\"${to}.qualifier\"/g"
	find . -type f -name "feature.xml" | xargs_sed_inplace -e "s/version=\"${from}\" match=\"equivalent\"/version=\"${to}\" match=\"equivalent\"/g"
	find . -type f -name "category.xml" | xargs_sed_inplace -e "s/version=\"${from}.qualifier\"/version=\"${to}.qualifier\"/g"
	find . -type f -name "plugin.xml" | xargs_sed_inplace -e "s/<version>${from}-SNAPSHOT<\/version>/<version>${to}-SNAPSHOT<\/version>/g"
}

SnapshotToRelease() {
	echo "# not usable now"
}

SnapshotToMilestone() {
 	echo "# not usable now"
}

MilestoneToRelease() {
	echo "# not usable now"
}

RCToRelease() {
	echo "# not usable now"
}


VersionBootstrap() {
      find . -type f -name "pom.xml" | xargs_sed_inplace -e "s/<xtend-maven-plugin-version>${from}<\/xtend-maven-plugin-version>/<xtend-maven-plugin-version>${to}<\/xtend-maven-plugin-version>/g"
      find . -type f -name "versions.gradle" | xargs_sed_inplace -e "s/'xtext_bootstrap': '${from}'/'xtext_bootstrap': '${to}'/g"
}

if [ $# -lt 2 ] || [ $# -gt 6 ] ; then
    usage
fi

while [ "$1" != "" ]; do
  case $1 in
        -f ) shift 
             from=$1 ;;
        -t ) shift 
             to=$1 ;;
        -b ) shift 
             bump=$1 ;;
         *)  echo "unknown: option $1" 
             usage
  esac
shift
done

echo "# from_version: $from"
echo "# to_version: $to" 
echo "# bump/bootstrap: $bump" 

checkVersionFormat "$from"

if [ -z "$to" ] ; then
   if [ "$bump" != "BST" ]; then
      echo "# 'to_version' is unset or set to the empty string"
      echo "# deriving 'to_version' from 'from_verison'"
      deriveToVersion
   else
      echo "ERROR# 'to_version' is mandatory for bootstrapping"
      exit 1
   fi
fi

checkVersionFormat "$to"

if [ "$bump" == "StoS" ]; then
   echo "# bumping version from Snapshot to Snapshot"
   
   SnapshotToSnapshot
fi

if [ "$bump" == "BST" ]; then
   echo "# bootstrapping version from $from to $to"
  
   VersionBootstrap
fi
