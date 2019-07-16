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
    configMap: 
      name: m2-dir
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
    timestamps()
  }

  // https://jenkins.io/doc/book/pipeline/syntax/#triggers
  triggers {
    cron('H 2 * * *')
  }
  
  stages {
    stage('Checkout') {
      steps {
        script {
          properties([
            [$class: 'GithubProjectProperty', displayName: '', projectUrlStr: 'https://github.com/eclipse/xtext-core/'],
            [$class: 'RebuildSettings', autoRebuild: false, rebuildDisabled: false],
            parameters([
              choice(choices: ['oxygen', 'photon', 'r201809', 'latest'], 
              description: 'Which Target Platform should be used?', 
              name: 'target_platform')
            ]),
            pipelineTriggers([githubPush()])
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
    }
    failure {
      archiveArtifacts artifacts: '**/target/work/data/.metadata/.log, **/hs_err_pid*.log'
    }
    cleanup {
      script {
        def envName = ''
        if (env.JENKINS_URL.contains('ci.eclipse.org/xtext')) {
          envName = ' (JIRO)'
        } else if (env.JENKINS_URL.contains('ci-staging.eclipse.org/xtext')) {
          envName = ' (JIRO)'
        }
        
        def sendNotification = true
        def color = '#00FF00'
        def curResult = currentBuild.currentResult
        def lastResult = 'NONE'
        if (currentBuild.previousBuild != null) {
          lastResult = currentBuild.previousBuild.result
        }
        if (lastResult == 'NONE') {
          curResult = "NEW: ${curResult}"
        } else if (curResult == 'SUCCESS' && lastResult == 'SUCCESS') {
          sendNotification = false
        } else if (curResult == 'SUCCESS' && lastResult != 'SUCCESS') {
          curResult = 'FIXED'
        } else if (curResult == 'UNSTABLE') {
          curResult = 'STILL FAILING (UNSTABLE)'
          color = '#FFFF00'
        } else { // FAILURE, ABORTED, NOT_BUILD
          curResult = 'STILL FAILING'
          color = '#FF0000'
        }
        if (sendNotification) {
          slackSend message: "${curResult}: <${env.BUILD_URL}|${env.JOB_NAME}#${env.BUILD_NUMBER}${envName}>", botUser: true, channel: 'xtext-builds', color: "${color}"
        }
      }
    }
  }
}