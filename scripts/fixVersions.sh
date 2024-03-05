#!/bin/bash 

usage ()
{
  echo "----------------------------------------------------------"
  echo "Usage   : fixVersions.sh -f <from_version> [-t <to_version>] "
  echo "Note: '-t' is optional, if not given it will be derived from '-f'"
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
  MVNVersion=$(./mvnw -f ./releng/pom.xml -q -Dexec.executable=echo -Dexec.args='${project.version}' --non-recursive exec:exec)
  echo "# MVN version from pom $MVNVersion"
  from_version=`echo $MVNVersion | sed -e 's/[^0-9][^0-9]*$//'`
  echo "# Derived from_version from MVN version $from_version"
}

xargs_sed_inplace() {
	if [[ "$OSTYPE" == "darwin"* ]]; then
		xargs sed -i '' -e "$@"
	else
		xargs sed -i'' -e "$@"
	fi	
}

SnapshotToSnapshot() {
	find . -type f -name "MANIFEST.MF" | xargs_sed_inplace "s/${from}.qualifier/${to}.qualifier/g" 
	find . -type f -name "MANIFEST.MF" | xargs_sed_inplace "s/;version=\"${from}\"/;version=\"${to}\"/g"
	find . -type f -name "MANIFEST.MF" | xargs_sed_inplace "s/org.eclipse.xte\([^;]*\);bundle-version=\"${from}\"/org.eclipse.xte\1;bundle-version=\"${to}\"/g"
	find . -type f -name "MANIFEST.MF_gen" | xargs_sed_inplace "s/${from}.qualifier/${to}.qualifier/g"
	find . -type f -name "pom.xml" | xargs_sed_inplace "s/${from}-SNAPSHOT/${to}-SNAPSHOT/g"
	find . -type f -name "feature.xml" | xargs_sed_inplace "s/version=\"${from}.qualifier\"/version=\"${to}.qualifier\"/g"
	find . -type f -name "feature.xml" | xargs_sed_inplace "s/version=\"${from}\" match=\"equivalent\"/version=\"${to}\" match=\"equivalent\"/g"
	find . -type f -name "category.xml" | xargs_sed_inplace "s/version=\"${from}.qualifier\"/version=\"${to}.qualifier\"/g"
	find . -type f -name "plugin.xml" | xargs_sed_inplace "s/<version>${from}-SNAPSHOT<\/version>/<version>${to}-SNAPSHOT<\/version>/g"
	find . -type f -name "RuntimeProjectConfig.java" | xargs_sed_inplace "s/${from}/${to}/g" 
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
         *)  echo "unknown: option $1" 
             usage
  esac
shift
done

echo "# from_version: $from"
echo "# to_version: $to" 

checkVersionFormat "$from"

if [ -z "$to" ] ; then
  echo "# 'to_version' is unset or set to the empty string"
  echo "# deriving 'to_version' from 'from_verison'"
  deriveToVersion
fi

checkVersionFormat "$to"

echo "# bumping version from Snapshot to Snapshot $(pwd)"
echo "Processing $(pwd)"
SnapshotToSnapshot

