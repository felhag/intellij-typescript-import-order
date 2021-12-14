package com.github.felhag.intellijtypescriptimportorder

import org.apache.commons.lang.StringUtils

class OpenBitbucket : OpenAction() {
    override fun buildUrl(project: String, repo: String): String {
        val url = StringUtils.removeEnd(Settings.get().bitbucketUrl, "/")
        return "${url}/projects/$project/repos/$repo/pull-requests"
    }
}
