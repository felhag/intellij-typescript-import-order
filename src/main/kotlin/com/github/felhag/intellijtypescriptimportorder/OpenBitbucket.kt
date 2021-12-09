package com.github.felhag.intellijtypescriptimportorder

class OpenBitbucket : OpenAction() {
    override fun buildUrl(project: String, repo: String): String {
        return "${Settings.get().bitbucketUrl}/$project/repos/$repo/pull-requests"
    }
}
