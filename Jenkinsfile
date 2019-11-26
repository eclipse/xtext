pipeline {
  agent {
    kubernetes {
      label 'xtext-umbrella-' + env.BRANCH_NAME + '-' + env.BUILD_NUMBER
      defaultContainer 'xtext-buildenv'
      yaml '''
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: jnlp
    image: 'eclipsecbi/jenkins-jnlp-agent'
    args: ['\$(JENKINS_SECRET)', '\$(JENKINS_NAME)']
    resources:
      limits:
        memory: "0.4Gi"
        cpu: "0.2"
      requests:
        memory: "0.4Gi"
        cpu: "0.2"
    volumeMounts:
    - mountPath: /home/jenkins/.ssh
      name: volume-known-hosts
  - name: xtext-buildenv
    image: docker.io/smoht/xtext-buildenv:0.7
    tty: true
    resources:
      limits:
        memory: "3.6Gi"
        cpu: "1.0"
      requests:
        memory: "3.6Gi"
        cpu: "1.0"
    volumeMounts:
    - name: settings-xml
      mountPath: /home/jenkins/.m2/settings.xml
      subPath: settings.xml
      readOnly: true
    - name: m2-repo
      mountPath: /home/jenkins/.m2/repository
    - name: volume-known-hosts
      mountPath: /home/jenkins/.ssh
  volumes:
  - name: volume-known-hosts
    configMap:
      name: known-hosts
  - name: settings-xml
    secret:
      secretName: m2-secret-dir
      items:
      - key: settings.xml
        path: settings.xml
  - name: m2-repo
    emptyDir: {}
    '''
    }
  }

  options {
    buildDiscarder(logRotator(numToKeepStr:'15'))
    disableConcurrentBuilds()
    timeout(time: 60, unit: 'MINUTES')
  }

  triggers {
    // only on master branch / 30 minutes before nightly sign-and-deploy
    cron(env.BRANCH_NAME == 'master' ? '20 21 * * *' : '')
    githubPush()
  }
  
  stages {
    stage('Checkout') {
      steps {
        script {
          properties([
            [$class: 'GithubProjectProperty', displayName: '', projectUrlStr: 'https://github.com/eclipse/xtext-core/'],
            [$class: 'RebuildSettings', autoRebuild: false, rebuildDisabled: false]
          ])
        }

        sh '''
          if [ -d ".git" ]; then
            git reset --hard
          fi
        '''
        
        dir('build') { deleteDir() }
        dir('.m2/repository/org/eclipse/xtext') { deleteDir() }
        dir('.m2/repository/org/eclipse/xtend') { deleteDir() }

        sh '''
          sed_inplace() {
              if [[ "$OSTYPE" == "darwin"* ]]; then
                  sed -i '' "$@"
              else
                  sed -i "$@" 
              fi    
          }
          
          targetfiles="$(find releng -type f -iname '*.target')"
          for targetfile in $targetfiles
          do
              echo "Redirecting target platforms in $targetfile to $JENKINS_URL"
              sed_inplace "s?<repository location=\\".*/job/\\([^/]*\\)/job/\\([^/]*\\)/?<repository location=\\"$JENKINS_URL/job/\\1/job/\\2/?" $targetfile
          done
        '''
      }
    }

    stage('Maven Build') {
      steps {
        sh '''
          mvn \
            -f releng \
            --batch-mode \
            --update-snapshots \
            -fae \
            -Dmaven.repo.local=$WORKSPACE/.m2/repository \
            -Dtycho.disableP2Mirrors=true \
            clean install
        '''
      }
    }
  }

  post {
    success {
      archiveArtifacts artifacts: 'build/**'
      script {
        // For release builds trigger releng/sign-and-deploy
        def RELEASE_TYPE = getReleaseType ()
        if (RELEASE_TYPE != "Integration" ) {
          build job: 'releng/sign-and-deploy',
            parameters: [
              string(name: 'RELEASE_TYPE', value: "${RELEASE_TYPE}"),
              string(name: 'BRANCH_TO_DEPLOY', value: "${env.BRANCH_NAME}")
            ],
          wait: false
        }
      }
    }
    failure {
      archiveArtifacts artifacts: '**/target/work/data/.metadata/.log, **/hs_err_pid*.log'
    }
    cleanup {
      script {
        def curResult = currentBuild.currentResult
        def lastResult = 'NEW'
        if (currentBuild.previousBuild != null) {
          lastResult = currentBuild.previousBuild.result
        }

        if (curResult != 'SUCCESS' || lastResult != 'SUCCESS') {
          def color = ''
          switch (curResult) {
            case 'SUCCESS':
              color = '#00FF00'
              break
            case 'UNSTABLE':
              color = '#FFFF00'
              break
            case 'FAILURE':
              color = '#FF0000'
              break
            default: // e.g. ABORTED
              color = '#666666'
          }

          slackSend (
            message: "${lastResult} => ${curResult}: <${env.BUILD_URL}|${env.JOB_NAME}#${env.BUILD_NUMBER}>",
            botUser: true,
            channel: 'xtext-builds',
            color: "${color}"
          )
        }
      }
    }
  }
}

/**
 * Determine the RELEASE_TYPE argument for downstream job releng/sign-and-deploy depending on current branch.
 */
def getReleaseType () {
  if (env.BRANCH_NAME.startsWith("release_")) {
    return "GA"
  } else if (env.BRANCH_NAME.startsWith("milestone_")) {
    return env.BRANCH_NAME.substring(env.BRANCH_NAME.lastIndexOf('.')+1)
  } else {
    return "Integration"
  }
}
